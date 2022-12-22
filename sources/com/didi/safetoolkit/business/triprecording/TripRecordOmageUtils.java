package com.didi.safetoolkit.business.triprecording;

import com.didi.safetoolkit.omega.SfOmegaUtil;

public class TripRecordOmageUtils {
    public static final int TYPE_RECORDING = 3;
    public static final int TYPE_RECORD_DISABLE = 1;
    public static final int TYPE_RECORD_ENABLE = 2;

    public static void sendStartBtnClickOmega(String str) {
        SfOmegaUtil.addEventId("pax_safetyRecord_start_btn_ck").addKeyValue("order_id", str).report();
    }

    public static void sendLawBtnClickOmega(boolean z, String str) {
        SfOmegaUtil.addEventId("pax_safetyRecord_pax_btn_ck").addKeyValue("type", Integer.valueOf(TripRecordingManager.Companion.getInstance().isRecording() ? 3 : z ? 2 : 1)).addKeyValue("order_id", str).report();
    }

    public static void sendTripRecordingActShowOmega(boolean z, String str) {
        SfOmegaUtil.addEventId("pax_safetyRecord_view_sw").addKeyValue("type", Integer.valueOf(TripRecordingManager.Companion.getInstance().isRecording() ? 3 : z ? 2 : 1)).addKeyValue("order_id", str).report();
    }

    public static void sendTripRecordEnterClickOmega(String str) {
        SfOmegaUtil.addEventId("gp_safetyToolkit_record_btn_ck").addKeyValue("order_id", str).report();
    }

    public static void ibt_gd_safetyrecord_start_error_bt(String str, String str2) {
        SfOmegaUtil.addEventId("ibt_gp_safetyrecord_start_error_bt").addKeyValue("result", str).addKeyValue("order_id", str2).report();
    }

    public static void ibt_gd_safetyrecord_break_error_bt(String str, String str2) {
        SfOmegaUtil.addEventId("ibt_gp_safetyrecord_break_error_bt").addKeyValue("result", str).addKeyValue("order_id", str2).report();
    }

    public static void ibt_gp_safetymonitoring_autorecord_ck(boolean z) {
        SfOmegaUtil.addEventId("ibt_gp_safetymonitoring_autorecord_ck").addKeyValue("type", z ? "open" : "close").report();
    }

    public static void ibt_gp_autorecord_close_turnon_ck() {
        SfOmegaUtil.addEventId("ibt_gp_autorecord_close_turnon_ck").report();
    }

    public static void ibt_gp_autorecord_close_turnoff_ck() {
        SfOmegaUtil.addEventId("ibt_gp_autorecord_close_turnoff_ck").report();
    }

    public static void ibt_gp_safety_manualrecord_turnon_ck() {
        SfOmegaUtil.addEventId("ibt_gp_safety_manualrecord_turnon_ck").report();
    }

    public static void ibt_gp_safety_manualrecord_cancel_ck() {
        SfOmegaUtil.addEventId("ibt_gp_safety_manualrecord_cancel_ck").report();
    }
}
