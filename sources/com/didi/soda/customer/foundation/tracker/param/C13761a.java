package com.didi.soda.customer.foundation.tracker.param;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.didi.soda.customer.foundation.tracker.param.a */
/* compiled from: BaseCommonParam */
abstract class C13761a {
    private Map<String, String> mParamsMap = new HashMap();

    C13761a() {
    }

    /* access modifiers changed from: package-private */
    public void putParam(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            removeParam(str);
        } else {
            this.mParamsMap.put(str, str2);
        }
    }

    /* access modifiers changed from: package-private */
    public void removeParam(String str) {
        this.mParamsMap.remove(str);
    }

    /* access modifiers changed from: package-private */
    public String getParam(String str) {
        return this.mParamsMap.get(str);
    }

    /* access modifiers changed from: package-private */
    public void copyParams(C13761a aVar) {
        this.mParamsMap.putAll(aVar.mParamsMap);
    }

    /* access modifiers changed from: package-private */
    public Map<String, String> getParams() {
        return this.mParamsMap;
    }
}
