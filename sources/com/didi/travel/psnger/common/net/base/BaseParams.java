package com.didi.travel.psnger.common.net.base;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public abstract class BaseParams {

    /* renamed from: a */
    private int f44047a;

    /* renamed from: b */
    private Map<String, Object> f44048b = new HashMap();

    /* access modifiers changed from: protected */
    public abstract Map<String, Object> convertBean2Map();

    public void addParam(String str, Object obj) {
        this.f44048b.put(str, obj);
    }

    public final Map<String, Object> getParams() {
        this.f44048b.put("business_id", Integer.valueOf(this.f44047a));
        this.f44048b.putAll(convertBean2Map());
        return this.f44048b;
    }

    /* access modifiers changed from: protected */
    public void put(Map<String, Object> map, String str, Object obj) {
        String valueOf = String.valueOf(obj);
        if (TextUtils.isEmpty(valueOf)) {
            map.put(str, "");
        } else {
            map.put(str, valueOf.trim());
        }
    }

    public void setBusinessId(int i) {
        this.f44047a = i;
    }

    public int getBusinessId() {
        return this.f44047a;
    }
}
