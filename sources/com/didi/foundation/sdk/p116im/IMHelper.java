package com.didi.foundation.sdk.p116im;

import android.app.Activity;
import android.app.Application;
import com.didi.beatles.p099im.access.IMAssister;
import com.didi.beatles.p099im.access.IMContext;
import com.didi.beatles.p099im.access.IMEngine;
import com.didi.foundation.sdk.depsdowngrade.DependencyDowngradeToggle;
import com.didi.foundation.sdk.log.LogService;
import com.didi.foundation.sdk.login.LoginCallbacks;
import com.didi.foundation.sdk.login.LoginService;
import com.didi.sdk.logging.Logger;
import com.didichuxing.foundation.spi.ServiceLoader;

/* renamed from: com.didi.foundation.sdk.im.IMHelper */
public final class IMHelper {

    /* renamed from: a */
    static Logger f21171a = LogService.getLogger("IMHelper");

    /* renamed from: b */
    private static Application f21172b;

    /* renamed from: c */
    private static IMContext f21173c;

    /* renamed from: d */
    private static IMAssister f21174d;

    /* renamed from: e */
    private static IMContextProvider f21175e;

    static {
        if (DependencyDowngradeToggle.getInstance().isDowngradeIM()) {
            f21171a.warn("Initialize downgrade!", new Object[0]);
        } else {
            m15589b();
        }
    }

    /* renamed from: b */
    private static void m15589b() {
        f21175e = (IMContextProvider) ServiceLoader.load(IMContextProvider.class).get();
        Logger logger = f21171a;
        logger.debug("sIMContextProvider: " + f21175e, new Object[0]);
        if (f21175e == null) {
            f21171a.warn("static block: IMContextProvider implementation not found!", new Object[0]);
            return;
        }
        LoginService instance = LoginService.getInstance();
        instance.addLoginListener(new LoginCallbacks.LoginListener() {
            public void onCancel() {
            }

            public void onSuccess(Activity activity, String str) {
                IMHelper.f21171a.debug("onLoginSuccess and init IM engine", new Object[0]);
                IMHelper.initIMEngine(activity.getApplication());
            }
        });
        instance.addLogoutListener(new LoginCallbacks.LoginOutListener() {
            public void onSuccess() {
                IMHelper.f21171a.debug("onLogoutSuccess and release IM engine", new Object[0]);
                IMHelper.m15590c();
            }
        });
    }

    private IMHelper() {
    }

    public static void initIMEngine(Application application) {
        if (DependencyDowngradeToggle.getInstance().isDowngradeIM()) {
            f21171a.warn("initIMEngine: Downgrade and return", new Object[0]);
            return;
        }
        IMContextProvider iMContextProvider = f21175e;
        if (iMContextProvider == null) {
            f21171a.warn("initIMEngine: IMContextProvider implementation not found!", new Object[0]);
            return;
        }
        f21172b = application;
        if (f21173c == null) {
            f21173c = new C8358b(application, iMContextProvider);
        }
        if (f21174d == null) {
            f21174d = new C8357a();
        }
        try {
            IMEngine.getInstance(application).initIMEngine(f21173c, f21174d);
            if (f21175e.getIMResource() != null) {
                IMEngine.getInstance(application).registerIMResource(f21175e.getIMResource());
            }
        } catch (Exception e) {
            Logger logger = f21171a;
            logger.error("init IM error: " + e, new Object[0]);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static void m15590c() {
        if (f21175e == null) {
            f21171a.warn("releaseIMEngine: IMContextProvider implementation not found!", new Object[0]);
            return;
        }
        IMEngine.getInstance(f21172b).destroyIMEngine();
        f21173c = null;
        f21174d = null;
        f21172b = null;
    }
}
