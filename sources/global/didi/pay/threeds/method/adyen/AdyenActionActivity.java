package global.didi.pay.threeds.method.adyen;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.adyen.checkout.components.ActionComponentData;
import com.adyen.checkout.components.ComponentError;
import com.adyen.checkout.components.model.payments.response.Action;
import com.adyen.checkout.core.exception.CheckoutException;
import com.adyen.checkout.redirect.RedirectUtil;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import org.greenrobot.eventbus.EventBus;

public class AdyenActionActivity extends FragmentActivity implements IAdyen3DSListener {
    public static final String EXTRA_ACTION = "action";
    private boolean forceClose = false;
    private Action mAction;
    private IAdyenActionHandler mPresenter;

    public static void startActionActivity(Context context, Action action) {
        Intent intent = new Intent(context, AdyenActionActivity.class);
        intent.putExtra("action", action);
        context.startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_adyen_action);
        AdyenActionHandler adyenActionHandler = new AdyenActionHandler(this);
        this.mPresenter = adyenActionHandler;
        adyenActionHandler.setListener(this);
        Action action = (Action) getIntent().getParcelableExtra("action");
        this.mAction = action;
        if (action != null) {
            this.mPresenter.handleAction(action);
        }
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        this.forceClose = false;
        super.onNewIntent(intent);
        if (intent == null || intent.getAction() == null || !intent.getAction().equals("android.intent.action.VIEW") || intent.getData() == null || !intent.getData().toString().startsWith(RedirectUtil.REDIRECT_RESULT_SCHEME)) {
            finish();
        } else {
            this.mPresenter.handleRedirectResponse(intent.getData());
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (this.forceClose) {
            EventBus.getDefault().post(new ComponentError(new CheckoutException("Cancel")));
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.forceClose = true;
    }

    public void onSuccess(ActionComponentData actionComponentData) {
        EventBus.getDefault().post(actionComponentData);
        finish();
    }

    public void onFailure(ComponentError componentError) {
        EventBus.getDefault().post(new ComponentError(new CheckoutException(getString(R.string.threeds_fail_message))));
        finish();
    }

    public void onCancel() {
        EventBus.getDefault().post(new ComponentError(new CheckoutException("Cancel")));
        finish();
    }
}
