package com.didi.map.setting.common.apollo;

import com.didi.map.setting.common.conf.DefaultConfProvider;
import com.didi.map.setting.common.utils.DLog;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IExperiment;
import com.didichuxing.apollo.sdk.IToggle;

public class MapSettingApolloUtil {

    /* renamed from: a */
    private static boolean f28928a = true;

    /* renamed from: b */
    private static int f28929b = 5;

    /* renamed from: c */
    private static int f28930c = 24;
    public static boolean sTrafficBarEnable;

    public static boolean isDayNightModeApolloEnabled() {
        return true;
    }

    public static boolean isAutoOpenNav() {
        return DefaultConfProvider.getConfig().isDoubleClickRemember();
    }

    public static String getNavFilter() {
        return DefaultConfProvider.getNavShowListApollo().getNavFilter();
    }

    public static boolean isNeedFilterNav() {
        return DefaultConfProvider.getNavShowListApollo().allow();
    }

    public static boolean isShowNaviTime() {
        IToggle toggle = Apollo.getToggle("jp_driver_navitime_controller");
        if (toggle != null && toggle.allow()) {
            return true;
        }
        DLog.m20371d("Show navitime apollo is false", new Object[0]);
        return false;
    }

    public static boolean isShowYahoo() {
        IToggle toggle = Apollo.getToggle("jp_driver_yahoo_controller");
        if (toggle != null && toggle.allow()) {
            return true;
        }
        DLog.m20371d("Show yahoo apollo is false", new Object[0]);
        return false;
    }

    static {
        IToggle toggle = Apollo.getToggle("map_global_driver_yandex_call_times");
        boolean z = true;
        if (toggle != null && toggle.allow()) {
            DLog.m20371d("map_global_driver_yandex_call_times true", new Object[0]);
            IExperiment experiment = toggle.getExperiment();
            f28929b = ((Integer) experiment.getParam("limit_call_times", 5)).intValue();
            f28930c = ((Integer) experiment.getParam("limit_hours", 24)).intValue();
        }
        DLog.m20371d("map_global_driver_yandex_call_times false", new Object[0]);
        sTrafficBarEnable = false;
        IToggle toggle2 = Apollo.getToggle("map_driver_hawaii_road_status_bar_final_AB");
        if (toggle2 == null || !toggle2.allow()) {
            DLog.m20371d("map_driver_hawaii_road_status_bar_final_AB not allow", new Object[0]);
            return;
        }
        IExperiment experiment2 = toggle2.getExperiment();
        if (experiment2 != null) {
            if (((Integer) experiment2.getParam("enable", 0)).intValue() != 1) {
                z = false;
            }
            sTrafficBarEnable = z;
            DLog.m20371d("map_driver_hawaii_road_status_bar_final_AB enabled", new Object[0]);
            return;
        }
        DLog.m20371d("map_driver_hawaii_road_status_bar_final_AB exp null", new Object[0]);
    }

    public static boolean isShowYandexNavTimes() {
        return f28928a;
    }

    public static int getYandexNavLimitCallTimes() {
        return f28929b;
    }

    public static int getYandexNavLimitHours() {
        return f28930c;
    }

    public static boolean getTrafficBarEnable() {
        return sTrafficBarEnable;
    }
}
