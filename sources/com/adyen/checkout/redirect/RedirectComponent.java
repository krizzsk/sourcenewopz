package com.adyen.checkout.redirect;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import com.adyen.checkout.components.ActionComponentProvider;
import com.adyen.checkout.components.base.BaseActionComponent;
import com.adyen.checkout.components.base.IntentHandlingComponent;
import com.adyen.checkout.components.model.payments.response.Action;
import com.adyen.checkout.components.model.payments.response.RedirectAction;
import com.adyen.checkout.core.exception.CheckoutException;
import com.adyen.checkout.core.exception.ComponentException;

public final class RedirectComponent extends BaseActionComponent<RedirectConfiguration> implements IntentHandlingComponent {
    public static final ActionComponentProvider<RedirectComponent, RedirectConfiguration> PROVIDER = new RedirectComponentProvider();

    /* renamed from: a */
    private final RedirectDelegate f950a;

    public RedirectComponent(Application application, RedirectConfiguration redirectConfiguration, RedirectDelegate redirectDelegate) {
        super(application, redirectConfiguration);
        this.f950a = redirectDelegate;
    }

    public static String getReturnUrl(Context context) {
        return RedirectUtil.REDIRECT_RESULT_SCHEME + context.getPackageName();
    }

    public boolean canHandleAction(Action action) {
        return PROVIDER.canHandleAction(action);
    }

    /* access modifiers changed from: protected */
    public void handleActionInternal(Activity activity, Action action) throws ComponentException {
        this.f950a.makeRedirect(activity, (RedirectAction) action);
    }

    public void handleIntent(Intent intent) {
        try {
            notifyDetails(this.f950a.handleRedirectResponse(intent.getData()));
        } catch (CheckoutException e) {
            notifyException(e);
        }
    }
}
