package com.didi.entrega.customer.foundation.tracker;

import com.didi.entrega.customer.foundation.tracker.param.GlobalParam;
import java.util.Map;

public final class OmegaCommonParamHelper {

    /* renamed from: a */
    private static GlobalParam f20039a = new GlobalParam();

    private OmegaCommonParamHelper() {
    }

    public static void setExternalGlobalParam(GlobalParam.ExternalGlobalParam externalGlobalParam) {
        f20039a.setExternalGlobalParam(externalGlobalParam);
    }

    public static String getActivityId() {
        return f20039a.getActivityId();
    }

    public static String getChannelId() {
        return f20039a.getChannelId();
    }

    public static String getFirstActivityId() {
        return f20039a.getFirstActivityId();
    }

    public static String getFirstChannelId() {
        return f20039a.getFirstChannelId();
    }

    /* renamed from: a */
    static Map<String, Object> m14799a(String str) {
        return f20039a.getParams(str);
    }

    public static Map<String, Object> getCommonParam() {
        return f20039a.getParams((String) null);
    }
}
