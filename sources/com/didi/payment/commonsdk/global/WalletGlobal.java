package com.didi.payment.commonsdk.global;

import android.app.Application;

public class WalletGlobal {

    /* renamed from: a */
    private static Application f30163a;

    public static void init(Application application) {
        f30163a = application;
    }

    @Deprecated
    public static Application getAppContext() {
        return f30163a;
    }
}
