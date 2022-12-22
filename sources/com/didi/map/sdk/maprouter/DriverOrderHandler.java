package com.didi.map.sdk.maprouter;

import android.text.TextUtils;

public class DriverOrderHandler {

    /* renamed from: a */
    private static DriverOrderHandler f28284a = new DriverOrderHandler();

    /* renamed from: b */
    private String f28285b = "";

    private DriverOrderHandler() {
    }

    public static DriverOrderHandler getInstance() {
        return f28284a;
    }

    public void updateOrderId(String str) {
        if (!TextUtils.equals(this.f28285b, str)) {
            this.f28285b = str;
        }
    }

    public String getCurrentOrderId() {
        return this.f28285b;
    }
}
