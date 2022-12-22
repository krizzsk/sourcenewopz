package com.didi.travel.psnger.core.model.request;

import com.didi.travel.psnger.common.net.base.BaseParams;
import java.util.HashMap;
import java.util.Map;

public class BaseOrderDetailParams extends BaseParams {

    /* renamed from: a */
    private String f44078a;

    public String getOid() {
        return this.f44078a;
    }

    public void setOid(String str) {
        this.f44078a = str;
    }

    /* access modifiers changed from: protected */
    public Map<String, Object> convertBean2Map() {
        HashMap hashMap = new HashMap();
        hashMap.put("order_id", this.f44078a);
        return hashMap;
    }
}
