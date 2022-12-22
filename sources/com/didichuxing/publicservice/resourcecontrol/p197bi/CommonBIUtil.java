package com.didichuxing.publicservice.resourcecontrol.p197bi;

import com.didichuxing.omega.sdk.common.record.Event;
import com.didichuxing.publicservice.general.ConstantUtils;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.Map;

/* renamed from: com.didichuxing.publicservice.resourcecontrol.bi.CommonBIUtil */
public class CommonBIUtil {
    public static String KEY_ACDID = "act_id";
    public static String KEY_RESOURCEID = "tabty";
    public static final String NOTICECARD_SW = "noticeCard_sw";
    public static final String TONE_P_X_BUB_ACT_CK = "tone_p_x_bub_act_ck";
    public static final String TONE_P_X_BUB_ACT_SUS_REQ = "tone_p_x_bub_act_sus_req";
    public static final String TONE_P_X_BUB_ACT_SW = "tone_p_x_bub_act_sw";
    public static final String TONE_P_X_BUB_SKIP_CK = "tone_p_x_bub_skip_ck";
    public static final String TONE_P_X_HOME_NTPPQ_CK = "tone_p_x_home_ntppq_ck";
    public static final String TONE_P_X_HOME_NTPP_CK = "tone_p_x_home_ntpp_ck";
    public static final String TONE_P_X_HOME_NTPP_SUS_REQ = "tone_p_x_home_ntpp_sus_req";
    public static final String TONE_P_X_HOME_NTPP_SW = "tone_p_x_home_ntpp_sw";

    public static void traceOpEvent(String str, Map<String, Object> map) {
        if (str != null && !str.isEmpty()) {
            Event event = new Event(str);
            if (map != null && map.size() > 0) {
                event.putAllAttrs(map);
            }
            OmegaSDKAdapter.trackEvent(event);
        }
    }

    public static String convertBiz(ConstantUtils.ResourceId resourceId) {
        String str = "unkown" + resourceId.getId();
        if (resourceId == ConstantUtils.ResourceId.NOTICE_ZHUANCHE) {
            return "zhuanche";
        }
        if (resourceId == ConstantUtils.ResourceId.NOTICE_SHUNFENGCHE) {
            return "shunfengche";
        }
        if (resourceId == ConstantUtils.ResourceId.NOTICE_BUS) {
            return "bus";
        }
        if (resourceId == ConstantUtils.ResourceId.NOTICE_KUAICHE) {
            return "kuaiche";
        }
        if (resourceId == ConstantUtils.ResourceId.NOTICE_TAXI) {
            return "taxi";
        }
        if (resourceId == ConstantUtils.ResourceId.NOTICE_DAIJIA) {
            return "daijia";
        }
        if (resourceId == ConstantUtils.ResourceId.SHICHENG_SHIJIA) {
            return "shijia";
        }
        if (resourceId == ConstantUtils.ResourceId.NOTICE_GONGJIAO) {
            return "gongjiao";
        }
        if (resourceId == ConstantUtils.ResourceId.NOTICE_UNTAXI) {
            return "untaxi";
        }
        return resourceId == ConstantUtils.ResourceId.NOTICE_PUBLIC ? "notice_public" : str;
    }
}
