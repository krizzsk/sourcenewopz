package com.didi.sdk.app;

import com.didi.unifylogin.listener.LoginListeners;
import com.didichuxing.swarm.toolkit.AuthenticationChangeEvent;

class AuthenticationServiceImpl$2 implements LoginListeners.LoginOutListener {
    final /* synthetic */ C12009a this$0;

    AuthenticationServiceImpl$2(C12009a aVar) {
        this.this$0 = aVar;
    }

    public void onSuccess() {
        this.this$0.m24929a(new AuthenticationChangeEvent(this.this$0, false));
    }
}
