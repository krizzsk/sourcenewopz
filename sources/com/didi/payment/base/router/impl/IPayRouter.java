package com.didi.payment.base.router.impl;

import android.content.Context;
import java.util.Map;

public interface IPayRouter {
    public static final String KEY_INTENT_FLAG = "INTENT_FLAG";
    public static final String KEY_URL_TYPE = "URL_TYPE";
    public static final String TYPE_CMB = "CMB";
    public static final String TYPE_COUPON = "COUPON";

    void destroy();

    String getUrl();

    void route(Context context, String str, Map<String, Object> map, RouteCallback routeCallback);
}
