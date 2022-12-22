package com.didi.hawaii.p118ar.utils;

import android.text.TextUtils;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;
import java.util.HashSet;

/* renamed from: com.didi.hawaii.ar.utils.ARAPollo */
public class ARAPollo {

    /* renamed from: a */
    private static final String f23285a = "hawaii_android_ar_use_dev";

    /* renamed from: b */
    private static final String f23286b = "hawaii_android_ar_power_lower";

    /* renamed from: c */
    private static final String f23287c = "hawaii_ar__modle";

    /* renamed from: d */
    private static final String f23288d = "ARnav_loc_version";

    /* renamed from: e */
    private static final String f23289e = "ARnav_use_oldBoard";

    /* renamed from: f */
    private static final String f23290f = "ARnav_use_PDRV2";

    /* renamed from: g */
    private static final String f23291g = "arnav_use_image_default_size";

    /* renamed from: h */
    private static final String f23292h = "ARnav_use_PDRLevelDetection";

    /* renamed from: i */
    private static final String f23293i = "ARnav_AR_drift";

    /* renamed from: j */
    private static final String f23294j = "arnav_check_time_out";

    /* renamed from: k */
    private static final String f23295k = "ARnav_zg_use_PDR";

    /* renamed from: l */
    private static final String f23296l = "ARnav_support_Direction_guide";

    public static boolean isUseDEV() {
        return Apollo.getToggle(f23285a).allow();
    }

    public static int getCheckTimeOut() {
        IToggle toggle = Apollo.getToggle(f23294j);
        if (toggle.allow()) {
            return ((Integer) toggle.getExperiment().getParam("timeout", 1200)).intValue();
        }
        return 1200;
    }

    public static boolean isUseDeFaultImageSize() {
        return Apollo.getToggle(f23291g).allow();
    }

    public static boolean isUseOldBoard() {
        return Apollo.getToggle(f23289e).allow();
    }

    public static int getLowerPower() {
        IToggle toggle = Apollo.getToggle(f23286b);
        if (toggle.allow()) {
            return ((Integer) toggle.getExperiment().getParam("power", 20)).intValue();
        }
        return 20;
    }

    public static int getARNavVersion() {
        IToggle toggle = Apollo.getToggle(f23288d);
        if (toggle.allow()) {
            return ((Integer) toggle.getExperiment().getParam("version", 2)).intValue();
        }
        return 2;
    }

    public static String getSupportModle() {
        IToggle toggle = Apollo.getToggle(f23287c);
        if (toggle.allow()) {
            return (String) toggle.getExperiment().getParam("modle", "");
        }
        return "";
    }

    public static HashSet<String> getOtherSupportModle() {
        String supportModle = getSupportModle();
        HashSet<String> hashSet = new HashSet<>(5);
        if (!TextUtils.isEmpty(supportModle)) {
            hashSet.add(supportModle);
        }
        IToggle toggle = Apollo.getToggle(f23287c);
        if (toggle.allow()) {
            String str = (String) toggle.getExperiment().getParam("otherSupModle", "");
            if (!TextUtils.isEmpty(str)) {
                for (String str2 : str.trim().replace("；", ";").split(";")) {
                    if (!TextUtils.isEmpty(str2)) {
                        hashSet.add(str2);
                    }
                }
            }
        }
        return hashSet;
    }

    public static boolean getUsePDR() {
        IToggle toggle = Apollo.getToggle(f23290f);
        if (!toggle.allow() || ((Integer) toggle.getExperiment().getParam("enabled", 0)).intValue() <= 0) {
            return false;
        }
        return true;
    }

    public static boolean getUsePDRShadow() {
        IToggle toggle = Apollo.getToggle(f23290f);
        if (!toggle.allow() || ((Integer) toggle.getExperiment().getParam("shadowEnable", 0)).intValue() <= 0) {
            return false;
        }
        return true;
    }

    public static boolean getUsePDRFusion() {
        IToggle toggle = Apollo.getToggle(f23290f);
        if (!toggle.allow() || ((Integer) toggle.getExperiment().getParam("fusionEnable", 0)).intValue() <= 0) {
            return false;
        }
        return true;
    }

    public static int getUsePDRTotalDuration() {
        IToggle toggle = Apollo.getToggle(f23290f);
        if (toggle.allow()) {
            return ((Integer) toggle.getExperiment().getParam("totalDuration", 30)).intValue();
        }
        return 30;
    }

    public static int getUsePDRCoreDuration() {
        IToggle toggle = Apollo.getToggle(f23290f);
        if (toggle.allow()) {
            return ((Integer) toggle.getExperiment().getParam("pdrDuration", 10)).intValue();
        }
        return 10;
    }

    public static int getUsePDRInterLocInterval() {
        IToggle toggle = Apollo.getToggle(f23290f);
        if (toggle.allow()) {
            return ((Integer) toggle.getExperiment().getParam("interLocInterval", 4)).intValue();
        }
        return 4;
    }

    public static int getUsePDRInterLocDistance() {
        IToggle toggle = Apollo.getToggle(f23290f);
        if (toggle.allow()) {
            return ((Integer) toggle.getExperiment().getParam("interLocDistance", 5)).intValue();
        }
        return 5;
    }

    public static boolean getUsePDRLevelDetection() {
        IToggle toggle = Apollo.getToggle(f23292h);
        if (!toggle.allow() || ((Integer) toggle.getExperiment().getParam("enabled", 0)).intValue() <= 0) {
            return false;
        }
        return true;
    }

    public static boolean getUseARDriftDetectionInInit() {
        IToggle toggle = Apollo.getToggle(f23293i);
        if (!toggle.allow() || ((Integer) toggle.getExperiment().getParam("enableInit", 0)).intValue() <= 0) {
            return false;
        }
        return true;
    }

    public static int getARDriftDetectionSpeedInInit() {
        IToggle toggle = Apollo.getToggle(f23293i);
        if (toggle.allow()) {
            return ((Integer) toggle.getExperiment().getParam("speedInit", 3)).intValue();
        }
        return 3;
    }

    public static boolean getUseARDriftDetectionInNavi() {
        IToggle toggle = Apollo.getToggle(f23293i);
        if (!toggle.allow() || ((Integer) toggle.getExperiment().getParam("enableNavi", 0)).intValue() <= 0) {
            return false;
        }
        return true;
    }

    public static int getARDriftDetectionSpeedInNavi() {
        IToggle toggle = Apollo.getToggle(f23293i);
        if (toggle.allow()) {
            return ((Integer) toggle.getExperiment().getParam("speedNavi", 5)).intValue();
        }
        return 5;
    }

    public static boolean getZGUsePDR() {
        return Apollo.getToggle(f23295k).allow();
    }

    public static boolean getSupportDirectionGuide() {
        return Apollo.getToggle(f23296l).allow();
    }

    public static boolean getDisableClippath() {
        IToggle toggle = Apollo.getToggle(f23296l);
        if (!toggle.allow() || ((Integer) toggle.getExperiment().getParam("disableClippath", 0)).intValue() <= 0) {
            return false;
        }
        return true;
    }

    public static int getDistanceArrived() {
        IToggle toggle = Apollo.getToggle(f23286b);
        if (toggle.allow()) {
            return ((Integer) toggle.getExperiment().getParam("distanceArrived", 10)).intValue();
        }
        return 10;
    }
}
