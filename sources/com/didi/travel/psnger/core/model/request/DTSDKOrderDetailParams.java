package com.didi.travel.psnger.core.model.request;

import java.util.HashMap;
import java.util.Map;

public class DTSDKOrderDetailParams extends BaseOrderDetailParams {

    /* renamed from: a */
    private String f44091a;

    public String getOid() {
        return this.f44091a;
    }

    public void setOid(String str) {
        this.f44091a = str;
    }

    /* access modifiers changed from: protected */
    public Map<String, Object> convertBean2Map() {
        HashMap hashMap = new HashMap();
        hashMap.put("order_id", this.f44091a);
        return hashMap;
    }
}
