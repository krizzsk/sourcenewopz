package com.didi.travel.psnger.core.model.request;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public class CancelOrderParams extends BaseCancelOrderParams {

    /* renamed from: a */
    private String f44079a;

    /* renamed from: b */
    private String f44080b;

    /* renamed from: c */
    private String f44081c;

    /* renamed from: d */
    private String f44082d;

    /* access modifiers changed from: protected */
    public Map<String, Object> convertBean2Map() {
        HashMap hashMap = new HashMap();
        put(hashMap, "token", this.f44080b);
        if (!TextUtils.isEmpty(this.f44082d)) {
            put(hashMap, "lat", this.f44082d);
        }
        if (!TextUtils.isEmpty(this.f44081c)) {
            put(hashMap, "lng", this.f44081c);
        }
        put(hashMap, "oid", this.f44079a);
        return hashMap;
    }

    public void setOrderId(String str) {
        this.f44079a = str;
    }

    public String getOrderId() {
        return this.f44079a;
    }

    public void setToken(String str) {
        this.f44080b = str;
    }

    public String getToken() {
        return this.f44080b;
    }

    public void setLng(String str) {
        this.f44081c = str;
    }

    public String getLng() {
        return this.f44081c;
    }

    public void setLat(String str) {
        this.f44082d = str;
    }

    public String getLat() {
        return this.f44082d;
    }
}
