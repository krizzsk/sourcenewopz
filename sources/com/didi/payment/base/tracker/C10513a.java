package com.didi.payment.base.tracker;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.didi.payment.base.tracker.a */
/* compiled from: PayOmegaTracker */
class C10513a implements IPayTracker {

    /* renamed from: a */
    private static final String f29980a = "PayOmegaTracker";

    /* renamed from: b */
    private static Map<String, Object> f29981b;

    C10513a() {
    }

    public void trackEvent(String str, Map<String, Object> map) {
        if (!TextUtils.isEmpty(str) && map != null) {
            createEvent(str).attrs(map).track();
        }
    }

    public void trackEvent(String str) {
        createEvent(str).track();
    }

    public ErrorEvent createErrorEvent(String str, String str2, String str3) {
        return new ErrorEvent(str, str2, str3);
    }

    public Event createEvent(String str) {
        return new Event(str);
    }

    public void putGlobal(String str, Object obj) {
        FinOmegaSDK.putGlobalKV(str, obj);
    }

    public void removeGlobal(String str) {
        FinOmegaSDK.removeGlobalKV(str);
    }

    public void putWalletGlobal(String str, Object obj) {
        if (f29981b == null) {
            f29981b = new HashMap();
        }
        f29981b.put(str, obj);
    }

    public void removeWalletGlobal(String str) {
        Map<String, Object> map = f29981b;
        if (map != null) {
            map.remove(str);
        }
    }

    public void trackEventWithWalletGlobal(String str, Map<String, Object> map) {
        if (TextUtils.isEmpty(str) || map == null) {
            createEvent(str).attrs(f29981b).track();
            return;
        }
        map.putAll(f29981b);
        createEvent(str).attrs(map).track();
    }
}
