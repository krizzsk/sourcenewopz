package com.didi.travel.psnger.utils;

import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didi.travel.psnger.store.DDTravelOrderStore;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.Map;
import rui.config.RConfigConstants;

public class OrderStatusOmegaEvent {
    public static void orderStatusOmegaTrace(String str, boolean z) {
        HashMap hashMap = new HashMap();
        CarOrder carOrder = (CarOrder) DDTravelOrderStore.getOrder();
        if (carOrder != null) {
            hashMap.put("oid", carOrder.getOid());
            hashMap.put("status", Integer.valueOf(carOrder.getStatus()));
            hashMap.put(ParamKeys.PARAM_SUB_STATUS, Integer.valueOf(carOrder.getSubStatus()));
        }
        hashMap.put("is_push", Integer.valueOf(z ? 1 : 0));
        StackTraceElement[] stackTrace = new Exception().getStackTrace();
        if (!(stackTrace == null || stackTrace.length <= 2 || stackTrace[2] == null)) {
            StackTraceElement stackTraceElement = stackTrace[2];
            hashMap.put("from", m31440a(stackTraceElement.getFileName()) + RConfigConstants.KEYWORD_COLOR_SIGN + stackTraceElement.getMethodName());
        }
        OmegaSDKAdapter.trackEvent(str, (Map<String, Object>) hashMap);
    }

    /* renamed from: a */
    private static String m31440a(String str) {
        try {
            return str.substring(0, str.indexOf("."));
        } catch (Exception unused) {
            return str;
        }
    }
}
