package com.didi.unifiedPay.component.manager;

import java.util.HashMap;

public class PayCache {

    /* renamed from: b */
    private static PayCache f44364b = null;

    /* renamed from: c */
    private static final String f44365c = "LAST_PAY_FAILED_SHOW";

    /* renamed from: a */
    private HashMap<String, Object> f44366a = new HashMap<>();

    public static synchronized PayCache getInstance() {
        PayCache payCache;
        synchronized (PayCache.class) {
            if (f44364b == null) {
                f44364b = new PayCache();
            }
            payCache = f44364b;
        }
        return payCache;
    }

    public void setLastPayFailShowed(String str) {
        HashMap<String, Object> hashMap = this.f44366a;
        hashMap.put(f44365c + str, 1);
    }

    public boolean isLastPayFailShow(String str) {
        HashMap<String, Object> hashMap = this.f44366a;
        return hashMap.containsKey(f44365c + str);
    }
}
