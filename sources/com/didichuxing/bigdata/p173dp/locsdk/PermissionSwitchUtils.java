package com.didichuxing.bigdata.p173dp.locsdk;

import android.content.Context;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.PermissionSwitchUtils */
public class PermissionSwitchUtils {

    /* renamed from: com.didichuxing.bigdata.dp.locsdk.PermissionSwitchUtils$PermissionSwitchState */
    public enum PermissionSwitchState {
        LOCATION_SWITCH_CLOSE("location switch is closed"),
        LOCATION_SWITCH_GPS_ONLY("only switch on gps to locate"),
        LOCATION_SWITCH_NETWORK_ONLY("only switch on network to locate"),
        WIFI_SCAN_DISABLED("wifi closed or not allowed scan"),
        NORMAL_LOC_SWITCH("location related switches are open"),
        UNKNOWN("unkonwn state");
        
        private String message;

        private PermissionSwitchState(String str) {
            this.message = str;
        }

        public String getMessage() {
            return this.message;
        }
    }

    public static PermissionSwitchState getPermissionSwitchState(Context context) {
        int locationSwitchLevel = Utils.getLocationSwitchLevel(context);
        if (locationSwitchLevel == 0) {
            return PermissionSwitchState.LOCATION_SWITCH_CLOSE;
        }
        if (locationSwitchLevel == 1) {
            return PermissionSwitchState.LOCATION_SWITCH_GPS_ONLY;
        }
        if (locationSwitchLevel == 2) {
            return PermissionSwitchState.LOCATION_SWITCH_NETWORK_ONLY;
        }
        if (locationSwitchLevel != 3) {
            return PermissionSwitchState.UNKNOWN;
        }
        SensorMonitor instance = SensorMonitor.getInstance(context);
        if (instance.isWifiEnabled() || instance.isWifiAllowScan()) {
            return PermissionSwitchState.NORMAL_LOC_SWITCH;
        }
        return PermissionSwitchState.WIFI_SCAN_DISABLED;
    }
}
