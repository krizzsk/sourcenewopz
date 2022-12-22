package com.didi.sdk.app;

import android.app.Activity;
import com.didi.unifylogin.listener.LoginListeners;
import com.didichuxing.swarm.toolkit.AuthenticationChangeEvent;

class AuthenticationServiceImpl$1 implements LoginListeners.LoginListener {
    final /* synthetic */ C12009a this$0;

    public void onCancel() {
    }

    AuthenticationServiceImpl$1(C12009a aVar) {
        this.this$0 = aVar;
    }

    public void onSuccess(Activity activity, String str) {
        this.this$0.m24929a(new AuthenticationChangeEvent(this.this$0, true));
    }
}
