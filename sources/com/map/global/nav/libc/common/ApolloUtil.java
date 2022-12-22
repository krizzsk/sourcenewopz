package com.map.global.nav.libc.common;

import com.didi.common.map.util.DLog;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;
import com.example.compapollovisitor.ApolloVisitHelper;

public class ApolloUtil {

    /* renamed from: a */
    private static final String f55692a = "NBApolloUtil";

    /* renamed from: b */
    private static boolean f55693b = true;

    /* renamed from: c */
    private static IToggle f55694c = Apollo.getToggle("global_map_match_yaw_config_toggle_new");

    /* renamed from: d */
    private static final int f55695d = 2;

    /* renamed from: e */
    private static final float f55696e = 0.45f;

    /* renamed from: f */
    private static boolean f55697f;

    /* renamed from: g */
    private static boolean f55698g;

    /* renamed from: h */
    private static final IToggle f55699h;

    /* renamed from: i */
    private static final boolean f55700i;

    public static float getCornerYawDistanceRadio() {
        return f55696e;
    }

    public static int getCornerYawStrategy() {
        return 2;
    }

    static {
        ApolloVisitHelper.getInstance().addApolloKey("global_map_match_yaw_config_toggle_new");
        IToggle iToggle = f55694c;
        boolean z = true;
        if (iToggle != null && iToggle.allow()) {
        }
        f55697f = false;
        IToggle toggle = Apollo.getToggle("globalmap_enable_filter_jump_point");
        if (toggle != null && toggle.allow() && 1 == ((Integer) toggle.getExperiment().getParam("filter_jump_point", 0)).intValue()) {
            f55697f = true;
        }
        f55698g = true;
        IToggle toggle2 = Apollo.getToggle("map_driver_use_car_image_toggle");
        if (toggle2 == null || !toggle2.allow()) {
            f55698g = true;
            DLog.m7384d(f55692a, "map_driver_use_car_image_toggle not allowed", new Object[0]);
        } else {
            f55698g = false;
            DLog.m7384d(f55692a, "map_driver_use_car_image_toggle allowed", new Object[0]);
        }
        IToggle toggle3 = Apollo.getToggle("global_map_sctx_simulation_toggle");
        f55699h = toggle3;
        if (toggle3 == null || !toggle3.allow()) {
            f55700i = false;
            return;
        }
        if (((Integer) f55699h.getExperiment().getParam("simulation_time_mode_ntp", 0)).intValue() <= 0) {
            z = false;
        }
        f55700i = z;
    }

    public static float getFilterAccuracy() {
        IToggle iToggle;
        if (!f55693b || (iToggle = f55694c) == null) {
            return 1000.0f;
        }
        return ((Float) iToggle.getExperiment().getParam("filterAccuracy", Float.valueOf(1000.0f))).floatValue();
    }

    public static int getMinSnapOffsetRadius() {
        IToggle iToggle;
        if (!f55693b || (iToggle = f55694c) == null) {
            return 30;
        }
        return ((Integer) iToggle.getExperiment().getParam("m_Min_offsetRadius", 30)).intValue();
    }

    public static int getMaxSnapOffsetRadius() {
        IToggle iToggle;
        if (!f55693b || (iToggle = f55694c) == null) {
            return 100;
        }
        return ((Integer) iToggle.getExperiment().getParam("m_Max_offsetRadius", 100)).intValue();
    }

    public static float getValidAngleDiff() {
        IToggle iToggle;
        if (!f55693b || (iToggle = f55694c) == null) {
            return 30.0f;
        }
        return ((Float) iToggle.getExperiment().getParam("m_valid_angleDiff", Float.valueOf(30.0f))).floatValue();
    }

    public static float getYawValidAngleDiff() {
        IToggle iToggle;
        if (!f55693b || (iToggle = f55694c) == null) {
            return 30.0f;
        }
        return ((Float) iToggle.getExperiment().getParam("yaw_valid_angleDiff", Float.valueOf(30.0f))).floatValue();
    }

    public static int getMinOffsetRadius() {
        IToggle iToggle;
        if (!f55693b || (iToggle = f55694c) == null) {
            return 30;
        }
        return ((Integer) iToggle.getExperiment().getParam("yaw_Min_offsetRadius", 30)).intValue();
    }

    public static int getMaxOffsetRadius() {
        IToggle iToggle;
        if (!f55693b || (iToggle = f55694c) == null) {
            return 100;
        }
        return ((Integer) iToggle.getExperiment().getParam("yaw_Max_offsetRadius", 100)).intValue();
    }

    public static float getYawDirectSpeed() {
        IToggle iToggle;
        if (!f55693b || (iToggle = f55694c) == null) {
            return 1.0f;
        }
        return ((Float) iToggle.getExperiment().getParam("yaw_direct_speed", Float.valueOf(1.0f))).floatValue();
    }

    public static float getYawOutWayCredit() {
        IToggle iToggle;
        if (!f55693b || (iToggle = f55694c) == null) {
            return 1.0f;
        }
        return ((Float) iToggle.getExperiment().getParam("yaw_outWay_credit", Float.valueOf(1.0f))).floatValue();
    }

    public static int getYawAccuracyOffset() {
        IToggle iToggle;
        if (!f55693b || (iToggle = f55694c) == null) {
            return 10;
        }
        return ((Integer) iToggle.getExperiment().getParam("yaw_accuracy_offset", 10)).intValue();
    }

    public static double getMaxCarHeadLevel() {
        IToggle toggle = Apollo.getToggle("map_light_nav_car_head_level");
        double d = 16.25d;
        if (toggle != null && toggle.allow()) {
            d = ((Double) toggle.getExperiment().getParam("android_max_level", Double.valueOf(16.25d))).doubleValue();
        }
        if (d < 15.5d) {
            return 15.5d;
        }
        return d;
    }

    public static DMKMapMatchABConfig getDMKMapMatchABConfig() {
        DMKMapMatchABConfig dMKMapMatchABConfig = new DMKMapMatchABConfig();
        dMKMapMatchABConfig.enableJumpFilter = f55697f;
        return dMKMapMatchABConfig;
    }

    public static boolean shouldRemoveCarImage() {
        return f55698g;
    }

    public static boolean isSctxSimulationTimestampNTP() {
        return f55700i;
    }
}
