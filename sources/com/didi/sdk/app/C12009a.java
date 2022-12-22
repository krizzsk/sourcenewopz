package com.didi.sdk.app;

import android.app.Application;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.unifylogin.api.OneLoginFacade;
import com.didichuxing.swarm.toolkit.AuthenticationChangeEvent;
import com.didichuxing.swarm.toolkit.AuthenticationService;
import com.didichuxing.swarm.toolkit.OnAuthenticationStateChangeListener;
import java.util.Vector;

/* renamed from: com.didi.sdk.app.a */
/* compiled from: AuthenticationServiceImpl */
class C12009a implements AuthenticationService {

    /* renamed from: a */
    private final Vector<OnAuthenticationStateChangeListener> f35223a = new Vector<>();

    public C12009a(Application application) {
        OneLoginFacade.getFunction().addLoginListener(new AuthenticationServiceImpl$1(this));
        OneLoginFacade.getFunction().addLoginOutListener(new AuthenticationServiceImpl$2(this));
    }

    public boolean isAuthenticated() {
        return NationTypeUtil.getNationComponentData().getLoginInfo().isLoginNow();
    }

    public String getToken() {
        return NationTypeUtil.getNationComponentData().getLoginInfo().getToken();
    }

    public void addAuthenticationChangeListener(OnAuthenticationStateChangeListener onAuthenticationStateChangeListener) {
        this.f35223a.add(onAuthenticationStateChangeListener);
    }

    public void removeAuthenticationChangeListener(OnAuthenticationStateChangeListener onAuthenticationStateChangeListener) {
        this.f35223a.remove(onAuthenticationStateChangeListener);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m24929a(AuthenticationChangeEvent authenticationChangeEvent) {
        if (!this.f35223a.isEmpty()) {
            Vector<OnAuthenticationStateChangeListener> vector = this.f35223a;
            for (OnAuthenticationStateChangeListener onAuthenticationStateChanged : (OnAuthenticationStateChangeListener[]) vector.toArray(new OnAuthenticationStateChangeListener[vector.size()])) {
                onAuthenticationStateChanged.onAuthenticationStateChanged(authenticationChangeEvent);
            }
        }
    }
}
