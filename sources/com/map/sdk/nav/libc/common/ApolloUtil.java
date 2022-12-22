package com.map.sdk.nav.libc.common;

import com.didi.common.map.util.DLog;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;
import com.example.compapollovisitor.ApolloVisitHelper;

public class ApolloUtil {
    private static final String TAG = "NBApolloUtil";
    private static boolean enableJumpFilter = false;
    private static boolean mYawConfigAllow = true;
    private static final float map_driver_corner_yaw_distance_ratio = 0.45f;
    private static final int map_driver_corner_yaw_type = 2;
    private static final boolean sIsSctxSimulationTimestampNTP;
    private static final IToggle sSctxSimulationToggle;
    private static boolean sShouldRemoveCarImage;
    private static IToggle toggle = Apollo.getToggle("global_map_match_yaw_config_toggle_new");

    public static float getCornerYawDistanceRadio() {
        return map_driver_corner_yaw_distance_ratio;
    }

    public static int getCornerYawStrategy() {
        return 2;
    }

    static {
        ApolloVisitHelper.getInstance().addApolloKey("global_map_match_yaw_config_toggle_new");
        IToggle iToggle = toggle;
        boolean z = true;
        if (iToggle != null && iToggle.allow()) {
        }
        enableJumpFilter = false;
        IToggle toggle2 = Apollo.getToggle("globalmap_enable_filter_jump_point");
        if (toggle2 != null && toggle2.allow() && 1 == ((Integer) toggle2.getExperiment().getParam("filter_jump_point", 0)).intValue()) {
            enableJumpFilter = true;
        }
        sShouldRemoveCarImage = true;
        IToggle toggle3 = Apollo.getToggle("map_driver_use_car_image_toggle");
        if (toggle3 == null || !toggle3.allow()) {
            sShouldRemoveCarImage = true;
            DLog.m7384d(TAG, "map_driver_use_car_image_toggle not allowed", new Object[0]);
        } else {
            sShouldRemoveCarImage = false;
            DLog.m7384d(TAG, "map_driver_use_car_image_toggle allowed", new Object[0]);
        }
        IToggle toggle4 = Apollo.getToggle("global_map_sctx_simulation_toggle");
        sSctxSimulationToggle = toggle4;
        if (toggle4 == null || !toggle4.allow()) {
            sIsSctxSimulationTimestampNTP = false;
            return;
        }
        if (((Integer) sSctxSimulationToggle.getExperiment().getParam("simulation_time_mode_ntp", 0)).intValue() <= 0) {
            z = false;
        }
        sIsSctxSimulationTimestampNTP = z;
    }

    public static float getFilterAccuracy() {
        IToggle iToggle;
        if (!mYawConfigAllow || (iToggle = toggle) == null) {
            return 1000.0f;
        }
        return ((Float) iToggle.getExperiment().getParam("filterAccuracy", Float.valueOf(1000.0f))).floatValue();
    }

    public static int getMinSnapOffsetRadius() {
        IToggle iToggle;
        if (!mYawConfigAllow || (iToggle = toggle) == null) {
            return 30;
        }
        return ((Integer) iToggle.getExperiment().getParam("m_Min_offsetRadius", 30)).intValue();
    }

    public static int getMaxSnapOffsetRadius() {
        IToggle iToggle;
        if (!mYawConfigAllow || (iToggle = toggle) == null) {
            return 100;
        }
        return ((Integer) iToggle.getExperiment().getParam("m_Max_offsetRadius", 100)).intValue();
    }

    public static float getValidAngleDiff() {
        IToggle iToggle;
        if (!mYawConfigAllow || (iToggle = toggle) == null) {
            return 30.0f;
        }
        return ((Float) iToggle.getExperiment().getParam("m_valid_angleDiff", Float.valueOf(30.0f))).floatValue();
    }

    public static float getYawValidAngleDiff() {
        IToggle iToggle;
        if (!mYawConfigAllow || (iToggle = toggle) == null) {
            return 30.0f;
        }
        return ((Float) iToggle.getExperiment().getParam("yaw_valid_angleDiff", Float.valueOf(30.0f))).floatValue();
    }

    public static int getMinOffsetRadius() {
        IToggle iToggle;
        if (!mYawConfigAllow || (iToggle = toggle) == null) {
            return 30;
        }
        return ((Integer) iToggle.getExperiment().getParam("yaw_Min_offsetRadius", 30)).intValue();
    }

    public static int getMaxOffsetRadius() {
        IToggle iToggle;
        if (!mYawConfigAllow || (iToggle = toggle) == null) {
            return 100;
        }
        return ((Integer) iToggle.getExperiment().getParam("yaw_Max_offsetRadius", 100)).intValue();
    }

    public static float getYawDirectSpeed() {
        IToggle iToggle;
        if (!mYawConfigAllow || (iToggle = toggle) == null) {
            return 1.0f;
        }
        return ((Float) iToggle.getExperiment().getParam("yaw_direct_speed", Float.valueOf(1.0f))).floatValue();
    }

    public static float getYawOutWayCredit() {
        IToggle iToggle;
        if (!mYawConfigAllow || (iToggle = toggle) == null) {
            return 1.0f;
        }
        return ((Float) iToggle.getExperiment().getParam("yaw_outWay_credit", Float.valueOf(1.0f))).floatValue();
    }

    public static int getYawAccuracyOffset() {
        IToggle iToggle;
        if (!mYawConfigAllow || (iToggle = toggle) == null) {
            return 10;
        }
        return ((Integer) iToggle.getExperiment().getParam("yaw_accuracy_offset", 10)).intValue();
    }

    public static double getMaxCarHeadLevel() {
        IToggle toggle2 = Apollo.getToggle("map_light_nav_car_head_level");
        double d = 16.25d;
        if (toggle2 != null && toggle2.allow()) {
            d = ((Double) toggle2.getExperiment().getParam("android_max_level", Double.valueOf(16.25d))).doubleValue();
        }
        if (d < 15.5d) {
            return 15.5d;
        }
        return d;
    }

    public static DMKMapMatchABConfig getDMKMapMatchABConfig() {
        DMKMapMatchABConfig dMKMapMatchABConfig = new DMKMapMatchABConfig();
        dMKMapMatchABConfig.enableJumpFilter = enableJumpFilter;
        return dMKMapMatchABConfig;
    }

    public static boolean shouldRemoveCarImage() {
        return sShouldRemoveCarImage;
    }

    public static boolean isSctxSimulationTimestampNTP() {
        return sIsSctxSimulationTimestampNTP;
    }
}
