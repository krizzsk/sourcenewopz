package com.didi.payment.wallet.global.proxy;

import android.app.Activity;

public class PayPalProxy {

    /* renamed from: a */
    private static IPayPalProxy f31776a;

    public interface IPayPalProxy {
        void startPayPalActivity(Activity activity, int i);

        void startPayPalDetailActivity(Activity activity, int i);
    }

    public static IPayPalProxy getProxy() {
        return f31776a;
    }

    public static void setProxy(IPayPalProxy iPayPalProxy) {
        f31776a = iPayPalProxy;
    }
}
