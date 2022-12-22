package com.didi.beatles.p099im.utils;

import com.didi.beatles.p099im.module.entity.IMBusinessParam;
import com.didi.beatles.p099im.module.entity.IMSession;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.didi.beatles.im.utils.IMParamUtil */
public class IMParamUtil {
    public static String getTraceOrderId(IMBusinessParam iMBusinessParam, IMSession iMSession) {
        String str;
        if (iMBusinessParam != null) {
            str = iMBusinessParam.getOrderId() > 0 ? String.valueOf(iMBusinessParam.getOrderId()) : iMBusinessParam.getsOrderId();
        } else {
            str = null;
        }
        return (str != null || iMSession == null || iMSession.getExtendSessionInfo() == null) ? str : iMSession.getExtendSessionInfo().orderId;
    }

    public static Map<String, String> getTraceExtra(IMBusinessParam iMBusinessParam, int i) {
        Map<String, String> extraTraceMap = iMBusinessParam == null ? null : iMBusinessParam.getExtraTraceMap();
        if (extraTraceMap == null) {
            extraTraceMap = new HashMap<>();
        }
        if (!extraTraceMap.containsKey("source")) {
            extraTraceMap.put("source", "top_msg_list_" + i);
        }
        return extraTraceMap;
    }
}
