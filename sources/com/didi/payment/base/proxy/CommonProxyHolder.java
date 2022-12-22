package com.didi.payment.base.proxy;

import android.content.Context;
import java.util.HashMap;

public class CommonProxyHolder {

    /* renamed from: a */
    private static ICommonProxy f29913a;

    public interface ICommonProxy {
        void doLogin(Context context);

        HashMap<String, Object> getBaseParams(Context context);

        Object getTerminalId(Context context);

        boolean isLogin(Context context);
    }

    public static ICommonProxy getProxy() {
        return f29913a;
    }

    public static void setProxy(ICommonProxy iCommonProxy) {
        f29913a = iCommonProxy;
    }
}
