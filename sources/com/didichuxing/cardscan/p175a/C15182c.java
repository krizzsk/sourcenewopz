package com.didichuxing.cardscan.p175a;

import android.content.Context;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.Map;
import p242io.card.payment.CardScanner;
import p242io.card.payment.DetectionInfo;

/* renamed from: com.didichuxing.cardscan.a.c */
public class C15182c {
    /* renamed from: a */
    public static void m33167a(Context context, DetectionInfo detectionInfo) {
        if (context != null && detectionInfo != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("card_recognize_result", Integer.valueOf(detectionInfo.complete ? 2 : detectionInfo.num_frames_scanned > 0 ? 3 : 1));
            hashMap.put("num_frames_scanned", Integer.valueOf(detectionInfo.num_frames_scanned));
            hashMap.put("card_recognize_interval", Long.valueOf((detectionInfo.system_time_expiry_completion_time == 0 ? CardScanner.endPreviewTime : detectionInfo.system_time_expiry_completion_time) - CardScanner.startPreviewTime));
            hashMap.put("card_num_recognize_interval", Long.valueOf(detectionInfo.system_time_card_number_completion_time - detectionInfo.system_time_scanner_begin_time));
            hashMap.put("card_expiry_recognize_interval", Long.valueOf(detectionInfo.system_time_expiry_completion_time - detectionInfo.system_time_scanner_begin_time));
            hashMap.put("card_expiry_enable", Boolean.valueOf(C15181b.m33165a(context)));
            OmegaSDKAdapter.trackEvent("DDCard_Detector_Analytics", (Map<String, Object>) hashMap);
        }
    }

    /* renamed from: a */
    public static void m33168a(Map<String, Object> map) {
        OmegaSDKAdapter.trackEvent("DDCard_Detector_Support", map);
    }
}
