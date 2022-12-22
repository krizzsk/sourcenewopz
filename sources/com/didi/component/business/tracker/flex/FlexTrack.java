package com.didi.component.business.tracker.flex;

import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.HashMap;
import java.util.Map;

public class FlexTrack {
    public static final String sFlexMonitorSceneKey = "scene";

    @Target({ElementType.FIELD, ElementType.LOCAL_VARIABLE, ElementType.PARAMETER})
    @Retention(RetentionPolicy.SOURCE)
    public @interface FlexErrorScene {
        public static final int sFlexMonitorSceneMaxLowPriceInValid = 2;
        public static final int sFlexMonitorSceneNoJumpFlexOfferPricePage = 4;
        public static final int sFlexMonitorSceneNoRemoteData = 1;
        public static final int sFlexMonitorSceneOfferPriceParseError = 3;
        public static final int sFlexMonitorSceneSendOrderFlexOfferPrice = 5;
    }

    @Target({ElementType.FIELD, ElementType.LOCAL_VARIABLE, ElementType.PARAMETER})
    @Retention(RetentionPolicy.SOURCE)
    public @interface FlexEvent {
        public static final String sFlexMonitorEventId = "ibt_monitor_flex_error_ck";
    }

    public static void track(String str, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("scene", Integer.valueOf(i));
        OmegaSDKAdapter.trackEvent(str, (Map<String, Object>) hashMap);
    }

    public static void track(String str, int i, HashMap<String, Object> hashMap) {
        HashMap hashMap2 = new HashMap();
        hashMap2.put("scene", Integer.valueOf(i));
        if (hashMap != null) {
            hashMap2.putAll(hashMap);
        }
        OmegaSDKAdapter.trackEvent(str, (Map<String, Object>) hashMap2);
    }

    public static void trackInValidPrice(String str, String str2) {
        try {
            float parseFloat = Float.parseFloat(str);
            float parseFloat2 = Float.parseFloat(str2);
            if (parseFloat2 < 0.0f || parseFloat < 0.0f || parseFloat2 > parseFloat) {
                HashMap hashMap = new HashMap();
                hashMap.put("scene", 2);
                OmegaSDKAdapter.trackEvent(FlexEvent.sFlexMonitorEventId, (Map<String, Object>) hashMap);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
