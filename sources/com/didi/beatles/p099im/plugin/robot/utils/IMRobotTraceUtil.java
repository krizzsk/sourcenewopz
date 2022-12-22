package com.didi.beatles.p099im.plugin.robot.utils;

import com.didi.beatles.p099im.omega.IMTraceUtil;
import com.didi.beatles.p099im.plugin.robot.IMRobotConstant;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.Map;

/* renamed from: com.didi.beatles.im.plugin.robot.utils.IMRobotTraceUtil */
public class IMRobotTraceUtil {
    public static void tracePanelShow(String str) {
        IMTraceUtil.addBusinessEvent("wyc_ddim_ddcard_sw").add(IMRobotConstant.getExtraTraceMap()).add("sw_type", Integer.valueOf(IMRobotConstant.getActionSource() == 5 ? 1 : 2)).add("tracking_data", str).report();
    }

    public static void tracePanelShowFail() {
        IMTraceUtil.addBusinessEvent("wyc_ddim_robotfail_sw").add(IMRobotConstant.getExtraTraceMap()).report();
    }

    public static void tracePanelShowRetry() {
        IMTraceUtil.addBusinessEvent("wyc_ddim_robotfail_retry_ck").add(IMRobotConstant.getExtraTraceMap()).report();
    }

    public static void traceRobotPraiseShow(String str, String str2) {
        IMTraceUtil.addBusinessEvent("wyc_ddim_robot_context_sw").add(IMRobotConstant.getExtraTraceMap()).add(SDKConstants.PARAM_CONTEXT_CONTEXT_ID, str2).add("robot_id", str).report();
    }

    public static void traceChangeRobotPraiseClick(String str, String str2) {
        IMTraceUtil.addBusinessEvent("wyc_ddim_robot_changecontext_ck").add(IMRobotConstant.getExtraTraceMap()).add(SDKConstants.PARAM_CONTEXT_CONTEXT_ID, str2).add("robot_id", str).report();
    }

    public static void tracePlayingRobotPraiseClick(String str, String str2, int i) {
        IMTraceUtil.addBusinessEvent("wyc_ddim_robot_voice_ck").add(IMRobotConstant.getExtraTraceMap()).add(SDKConstants.PARAM_CONTEXT_CONTEXT_ID, str2).add("robot_id", str).add("ck_type", Integer.valueOf(i)).report();
    }

    public static void traceSendRobotPraiseClick(String str, String str2) {
        IMTraceUtil.addBusinessEvent("wyc_ddim_robot_send_ck").add(IMRobotConstant.getExtraTraceMap()).add(SDKConstants.PARAM_CONTEXT_CONTEXT_ID, str2).add("robot_id", str).report();
    }

    public static void traceRobotChangeClick(String str, String str2) {
        IMTraceUtil.addBusinessEvent("wyc_ddim_robot_changerobot_ck").add("fr_robot_id", str).add("robot_id", str2).add(IMRobotConstant.getExtraTraceMap()).report();
    }

    public static void traceRobotShow(String str, boolean z) {
        IMTraceUtil.addBusinessEvent("wyc_ddim_robot_sw").add("robot_id", str).add(IMRobotConstant.getExtraTraceMap()).add("page_type", Integer.valueOf(z ? 1 : 2)).report();
    }

    public static void traceCardSw(String str, int i, String str2, Map<String, String> map) {
        IMTraceUtil.addBusinessEvent("ddim_service_kkcard_sw").add("order_id", str2).add("tips_id", str).add("is_anonymous", Integer.valueOf(i)).add(map).report();
    }

    public static void traceCardShareCk(String str, int i, String str2, Map<String, String> map) {
        IMTraceUtil.addBusinessEvent("ddim_service_kkcard_top_ck").add("order_id", str2).add("tips_id", str).add("is_anonymous", Integer.valueOf(i)).add(map).report();
    }

    public static void traceCardVoiceCk(String str, int i, String str2, Map<String, String> map) {
        IMTraceUtil.addBusinessEvent("ddim_service_kkcard_voice_ck").add("order_id", str2).add("tips_id", str).add("is_anonymous", Integer.valueOf(i)).add(map).report();
    }
}
