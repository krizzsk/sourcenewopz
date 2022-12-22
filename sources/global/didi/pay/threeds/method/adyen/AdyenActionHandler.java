package global.didi.pay.threeds.method.adyen;

import android.content.Intent;
import android.net.Uri;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import com.adyen.checkout.adyen3ds2.Adyen3DS2Component;
import com.adyen.checkout.adyen3ds2.Adyen3DS2Configuration;
import com.adyen.checkout.components.ActionComponentData;
import com.adyen.checkout.components.ComponentError;
import com.adyen.checkout.components.model.payments.response.Action;
import com.adyen.checkout.redirect.RedirectComponent;
import com.adyen.checkout.redirect.RedirectConfiguration;
import global.didi.pay.threeds.utils.ThreeDSUtils;

public class AdyenActionHandler implements IAdyenActionHandler {
    private Adyen3DS2Component adyen3DS2Component;
    private FragmentActivity mActivity;
    private IAdyen3DSListener mListener;
    private RedirectComponent redirectComponent;

    public AdyenActionHandler(FragmentActivity fragmentActivity) {
        this.adyen3DS2Component = Adyen3DS2Component.PROVIDER.get(fragmentActivity, fragmentActivity.getApplication(), (Adyen3DS2Configuration) ThreeDSUtils.getConfiguration(fragmentActivity, "threeDS2"));
        this.redirectComponent = RedirectComponent.PROVIDER.get(fragmentActivity, fragmentActivity.getApplication(), (RedirectConfiguration) ThreeDSUtils.getConfiguration(fragmentActivity, "redirect"));
        this.adyen3DS2Component.observe(fragmentActivity, new Observer() {
            public final void onChanged(Object obj) {
                AdyenActionHandler.this.lambda$new$0$AdyenActionHandler((ActionComponentData) obj);
            }
        });
        this.redirectComponent.observe(fragmentActivity, new Observer() {
            public final void onChanged(Object obj) {
                AdyenActionHandler.this.lambda$new$1$AdyenActionHandler((ActionComponentData) obj);
            }
        });
        this.adyen3DS2Component.observeErrors(fragmentActivity, new Observer() {
            public final void onChanged(Object obj) {
                AdyenActionHandler.this.lambda$new$2$AdyenActionHandler((ComponentError) obj);
            }
        });
        this.redirectComponent.observeErrors(fragmentActivity, new Observer() {
            public final void onChanged(Object obj) {
                AdyenActionHandler.this.lambda$new$3$AdyenActionHandler((ComponentError) obj);
            }
        });
        this.mActivity = fragmentActivity;
    }

    public /* synthetic */ void lambda$new$0$AdyenActionHandler(ActionComponentData actionComponentData) {
        IAdyen3DSListener iAdyen3DSListener = this.mListener;
        if (iAdyen3DSListener != null) {
            iAdyen3DSListener.onSuccess(actionComponentData);
        }
    }

    public /* synthetic */ void lambda$new$1$AdyenActionHandler(ActionComponentData actionComponentData) {
        IAdyen3DSListener iAdyen3DSListener = this.mListener;
        if (iAdyen3DSListener != null) {
            iAdyen3DSListener.onSuccess(actionComponentData);
        }
    }

    public /* synthetic */ void lambda$new$2$AdyenActionHandler(ComponentError componentError) {
        IAdyen3DSListener iAdyen3DSListener = this.mListener;
        if (iAdyen3DSListener != null) {
            iAdyen3DSListener.onFailure(componentError);
        }
    }

    public /* synthetic */ void lambda$new$3$AdyenActionHandler(ComponentError componentError) {
        IAdyen3DSListener iAdyen3DSListener = this.mListener;
        if (iAdyen3DSListener != null) {
            iAdyen3DSListener.onFailure(componentError);
        }
    }

    public void handleAction(Action action) {
        if (action != null) {
            if (this.adyen3DS2Component.canHandleAction(action)) {
                this.adyen3DS2Component.handleAction(this.mActivity, action);
            }
            if (this.redirectComponent.canHandleAction(action)) {
                this.redirectComponent.handleAction(this.mActivity, action);
            }
        }
    }

    public boolean openActivityHandle(Action action) {
        if (action == null) {
            return false;
        }
        return this.redirectComponent.canHandleAction(action);
    }

    public void handleRedirectResponse(Uri uri) {
        if (this.redirectComponent != null) {
            Intent intent = new Intent();
            intent.setData(uri);
            this.redirectComponent.handleIntent(intent);
        }
    }

    public void setListener(IAdyen3DSListener iAdyen3DSListener) {
        this.mListener = iAdyen3DSListener;
    }
}
