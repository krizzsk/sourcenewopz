package com.didi.map.setting.global;

import com.didi.component.common.net.CarServerParam;
import com.didi.map.sdk.maprouter.global.PlatInfo;
import com.didi.map.setting.common.MapSettingOmega;
import com.didi.map.setting.common.utils.DLog;
import com.didi.map.setting.common.utils.MapSettingUtils;

public class TraceEvent {
    public static void trackRememberNav(boolean z, String str, boolean z2) {
        String navType = MapSettingUtils.getNavType(str);
        if (z2) {
            navType = "6";
        }
        MapSettingOmega.add("map_global_navi_remember").add(CarServerParam.PARAM_DRIVER_ID, Long.valueOf(PlatInfo.getInstance().getDriverId())).add("is_remember", Integer.valueOf(z ? 1 : 0)).add("type", navType).report();
        DLog.m20371d("TraceEvent, map_global_navi_remember, driver_id = " + PlatInfo.getInstance().getDriverId() + ",is_remember=" + z + ", type = " + navType, new Object[0]);
    }
}
