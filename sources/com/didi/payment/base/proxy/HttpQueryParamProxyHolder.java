package com.didi.payment.base.proxy;

import android.content.Context;
import java.util.HashMap;

public class HttpQueryParamProxyHolder {

    /* renamed from: a */
    private static IQueryParamProxy f29918a;

    public interface IQueryParamProxy {
        HashMap<String, Object> getQueryParams(Context context);
    }

    public static IQueryParamProxy getProxy() {
        return f29918a;
    }

    public static void setProxy(IQueryParamProxy iQueryParamProxy) {
        f29918a = iQueryParamProxy;
    }
}
