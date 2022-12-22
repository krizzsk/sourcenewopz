package com.didi.payment.base.router.impl;

import android.content.Context;
import java.util.Map;

public class ActivityRouter implements IPayRouter {

    /* renamed from: a */
    private String f29933a;

    public void destroy() {
    }

    public void route(Context context, String str, Map<String, Object> map, RouteCallback routeCallback) {
        this.f29933a = str;
    }

    public String getUrl() {
        return this.f29933a;
    }
}
