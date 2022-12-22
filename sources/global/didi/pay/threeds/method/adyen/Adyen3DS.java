package global.didi.pay.threeds.method.adyen;

import androidx.fragment.app.FragmentActivity;
import com.adyen.checkout.components.ActionComponentData;
import com.adyen.checkout.components.ComponentError;
import com.adyen.checkout.components.model.payments.response.Action;
import com.adyen.checkout.core.exception.CheckoutException;
import global.didi.pay.threeds.contract.IAdyen3DS;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.json.JSONObject;

public class Adyen3DS implements IAdyen3DS {
    private FragmentActivity mActivity;
    private IAdyen3DSListener mListener;
    private IAdyenActionHandler mPresenter;

    public Adyen3DS(FragmentActivity fragmentActivity) {
        this.mActivity = fragmentActivity;
        this.mPresenter = new AdyenActionHandler(fragmentActivity);
    }

    public boolean checkActionJsonObject(JSONObject jSONObject) {
        try {
            Action.SERIALIZER.deserialize(jSONObject);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public void handleAction(Action action) {
        if (this.mPresenter.openActivityHandle(action)) {
            AdyenActionActivity.startActionActivity(this.mActivity, action);
        } else {
            this.mPresenter.handleAction(action);
        }
    }

    public void handleAction(JSONObject jSONObject) {
        if (!checkActionJsonObject(jSONObject)) {
            onEvent(new ComponentError(new CheckoutException("Check Action failed")));
        } else {
            handleAction(Action.SERIALIZER.deserialize(jSONObject));
        }
    }

    public void registerListener(IAdyen3DSListener iAdyen3DSListener) {
        this.mListener = iAdyen3DSListener;
        this.mPresenter.setListener(iAdyen3DSListener);
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }

    public void unregisterListener() {
        this.mListener = null;
        this.mPresenter.setListener((IAdyen3DSListener) null);
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }

    @Subscribe
    public void onEvent(ActionComponentData actionComponentData) {
        IAdyen3DSListener iAdyen3DSListener = this.mListener;
        if (iAdyen3DSListener != null) {
            iAdyen3DSListener.onSuccess(actionComponentData);
        }
    }

    @Subscribe
    public void onEvent(ComponentError componentError) {
        if (this.mListener != null) {
            if (componentError.getErrorMessage().equals("Cancel")) {
                this.mListener.onCancel();
            } else {
                this.mListener.onFailure(componentError);
            }
        }
    }
}
