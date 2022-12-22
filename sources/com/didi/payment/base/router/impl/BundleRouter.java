package com.didi.payment.base.router.impl;

import android.content.Context;
import java.util.Map;

public class BundleRouter implements IPayRouter {

    /* renamed from: a */
    private String f29934a;

    public void destroy() {
    }

    public void route(Context context, String str, Map<String, Object> map, RouteCallback routeCallback) {
        this.f29934a = str;
    }

    public String getUrl() {
        return this.f29934a;
    }
}
