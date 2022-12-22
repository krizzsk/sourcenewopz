package com.didi.travel.psnger.core.model.request;

import com.didi.travel.psnger.common.net.base.ParamKeys;
import java.util.HashMap;
import java.util.Map;

public class CancelTripParams extends BaseCancelTripParams {

    /* renamed from: a */
    private String f44083a;

    /* renamed from: b */
    private String f44084b;

    /* renamed from: c */
    private String f44085c;

    /* renamed from: d */
    private String f44086d;

    /* renamed from: e */
    private int f44087e;

    /* renamed from: f */
    private String f44088f;

    /* renamed from: g */
    private int f44089g = 0;

    /* renamed from: h */
    private int f44090h;

    /* access modifiers changed from: protected */
    public Map<String, Object> convertBean2Map() {
        HashMap hashMap = new HashMap();
        put(hashMap, "token", this.f44084b);
        put(hashMap, "lng", this.f44085c);
        put(hashMap, "lat", this.f44086d);
        put(hashMap, "oid", this.f44083a);
        put(hashMap, "type", Integer.valueOf(this.f44087e));
        put(hashMap, "content", this.f44088f);
        put(hashMap, ParamKeys.PARAM_CONTROL, 1);
        put(hashMap, ParamKeys.PARAM_NATIVE_CANCEL, Integer.valueOf(this.f44089g));
        put(hashMap, ParamKeys.PARAM_SUB_STATUS, Integer.valueOf(this.f44090h));
        return hashMap;
    }

    public void setOrderId(String str) {
        this.f44083a = str;
    }

    public String getOrderId() {
        return this.f44083a;
    }

    public void setToken(String str) {
        this.f44084b = str;
    }

    public String getToken() {
        return this.f44084b;
    }

    public void setLng(String str) {
        this.f44085c = str;
    }

    public String getLng() {
        return this.f44085c;
    }

    public void setLat(String str) {
        this.f44086d = str;
    }

    public String getLat() {
        return this.f44086d;
    }

    public void setType(int i) {
        this.f44087e = i;
    }

    public int getType() {
        return this.f44087e;
    }

    public void setContent(String str) {
        this.f44088f = str;
    }

    public String getContent() {
        return this.f44088f;
    }

    public int getNativeCancel() {
        return this.f44089g;
    }

    public void setNativeCancel(int i) {
        this.f44089g = i;
    }

    public int getSubStatus() {
        return this.f44090h;
    }

    public void setSubStatus(int i) {
        this.f44090h = i;
    }
}
