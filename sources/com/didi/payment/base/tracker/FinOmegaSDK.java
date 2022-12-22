package com.didi.payment.base.tracker;

import com.didi.dimina.container.secondparty.trace.inner.LogBase;
import com.didi.payment.base.exts.ApplicationContextProvider;
import com.didi.payment.base.utils.PayBaseParamUtil;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didichuxing.omega.sdk.init.OmegaSDK;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.Map;

public class FinOmegaSDK {

    /* renamed from: a */
    private static Map<String, Object> f29971a = new HashMap();

    /* renamed from: b */
    private static Map<String, Object> f29972b = new HashMap();

    public static void putFinGlobalAttrs(String str, Object obj) {
        f29972b.put(str, obj);
    }

    public static void putFinGlobalExtAttrs(String str, Object obj) {
        f29971a.put(str, obj);
    }

    public static void removeFinGlobalExtAttrs() {
        f29971a.clear();
    }

    public static void trackEvent(String str, Map<String, Object> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        m21002a(map);
        OmegaSDKAdapter.trackEvent(str, map);
    }

    public static void trackEvent(String str) {
        HashMap hashMap = new HashMap();
        m21002a(hashMap);
        OmegaSDKAdapter.trackEvent(str, (Map<String, Object>) hashMap);
    }

    public static void trackEvent(String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put(str2, str3);
        m21002a(hashMap);
        OmegaSDKAdapter.trackEvent(str, "", hashMap);
    }

    public static void trackError(String str, Throwable th) {
        OmegaSDK.trackError(str, th);
    }

    public static void putGlobalKV(String str, Object obj) {
        OmegaSDK.putGlobalKV(str, obj);
    }

    public static void removeGlobalKV(String str) {
        OmegaSDK.removeGlobalKV(str);
    }

    public static void trackError(String str, String str2, String str3, String str4, Map<String, Object> map) {
        OmegaSDK.trackError(str, str2, str3, str4, map);
    }

    /* renamed from: a */
    private static void m21002a(Map<String, Object> map) {
        if (!f29972b.isEmpty()) {
            map.putAll(f29972b);
        }
        if (!f29971a.isEmpty()) {
            map.putAll(f29971a);
        }
        map.put(ParamConst.PARAM_PUB_BIZ_LINE, Const.PubBizLine.FIN);
        map.put("pub_subbiz", "payment");
        map.put(LogBase.KEY_UID, PayBaseParamUtil.getStringParam(ApplicationContextProvider.Companion.getContext(), "uid"));
    }
}
