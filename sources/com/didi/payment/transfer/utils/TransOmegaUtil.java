package com.didi.payment.transfer.utils;

import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.transfer.DebugUtil;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TransOmegaUtil {

    /* renamed from: a */
    private static Map<String, Object> f31493a = new HashMap();

    /* renamed from: b */
    private static Set<String> f31494b;

    static {
        HashSet hashSet = new HashSet();
        f31494b = hashSet;
        hashSet.add(TransGlobalOmegaKey.KEY_ACCOUNT_STATUS);
        f31494b.add(TransGlobalOmegaKey.KEY_WALLET_PAGEID);
        f31494b.add(TransGlobalOmegaKey.KEY_PAYEE_99ACCOUNT_STATUS);
        f31494b.add(TransGlobalOmegaKey.KEY_PAYEE_99PAY_ACCOUNT_STATUS);
    }

    public static void trackEvent(String str) {
        m22265a(str, (Map<String, Object>) null);
    }

    public static void trackEvent(String str, String str2, Object obj) {
        HashMap hashMap = new HashMap();
        hashMap.put(str2, obj);
        m22265a(str, hashMap);
    }

    public static void trackEventWithGlobal(String str, String... strArr) {
        trackEventWithGlobal(str, (Map<String, Object>) null, strArr);
    }

    public static void trackEventWithGlobal(String str, Map<String, Object> map, String... strArr) {
        HashMap hashMap = new HashMap();
        if (!CollectionUtil.isEmpty((Map<?, ?>) map)) {
            for (String next : map.keySet()) {
                hashMap.put(next, map.get(next));
            }
        }
        for (String str2 : strArr) {
            if (!f31494b.contains(str2) || !f31493a.containsKey(str2)) {
                hashMap.put(str2, "");
            } else {
                hashMap.put(str2, f31493a.get(str2));
            }
        }
        if (DebugUtil.isAppInDebugMode()) {
            DebugUtil.justLog("Trans_Omega eventId: %s, params: %s", str, m22264a(hashMap));
        }
        FinOmegaSDK.trackEvent(str, hashMap);
    }

    /* renamed from: a */
    private static String m22264a(Map<String, Object> map) {
        if (CollectionUtil.isEmpty((Map<?, ?>) map)) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(Const.joLeft);
        for (String next : map.keySet()) {
            sb.append(next);
            sb.append(":");
            sb.append(map.get(next));
            sb.append(", ");
        }
        sb.append("}");
        return sb.toString();
    }

    public static void trackEvent(String str, String str2, Object obj, String str3, Object obj2) {
        HashMap hashMap = new HashMap();
        hashMap.put(str2, obj);
        hashMap.put(str3, obj2);
        m22265a(str, hashMap);
    }

    /* renamed from: a */
    private static void m22265a(String str, Map<String, Object> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        if (!CollectionUtil.isEmpty((Map<?, ?>) f31493a)) {
            for (String next : f31493a.keySet()) {
                map.put(next, f31493a.get(next));
            }
        }
        if (DebugUtil.isAppInDebugMode()) {
            DebugUtil.justLog("Trans_Omega eventId: %s, params: %s", str, m22264a(map));
        }
        FinOmegaSDK.trackEvent(str, map);
    }

    public static void addGlobalParam(String str, Object obj) {
        f31493a.put(str, obj);
    }

    public static void removeGlobalParam(String str) {
        f31493a.remove(str);
    }

    public static void clearGlobalParams() {
        f31493a.clear();
    }

    public static void trackEvent(String str, String str2, Object obj, String str3, Object obj2, String str4, Object obj3, String str5, Object obj4) {
        HashMap hashMap = new HashMap();
        hashMap.put(str2, obj);
        hashMap.put(str3, obj2);
        hashMap.put(str4, obj3);
        hashMap.put(str5, obj4);
        m22265a(str, hashMap);
    }

    public static void addOmegaGlobalParam(String str, Object obj) {
        FinOmegaSDK.putGlobalKV(str, obj);
    }
}
