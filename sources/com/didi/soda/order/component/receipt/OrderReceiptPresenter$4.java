package com.didi.soda.order.component.receipt;

import android.app.Activity;
import com.didi.foundation.sdk.login.LoginCallbacks;

class OrderReceiptPresenter$4 implements LoginCallbacks.ModifyEmailListener {
    final /* synthetic */ C14122a this$0;

    OrderReceiptPresenter$4(C14122a aVar) {
        this.this$0 = aVar;
    }

    public void onSuccess(Activity activity) {
        this.this$0.getScopeContext().getNavigator().finish();
    }

    public void onCancel() {
        this.this$0.getScopeContext().getNavigator().finish();
    }
}
