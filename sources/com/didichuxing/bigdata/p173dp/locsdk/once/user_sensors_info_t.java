package com.didichuxing.bigdata.p173dp.locsdk.once;

import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.io.Serializable;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.once.user_sensors_info_t */
/* compiled from: LocDataDef */
class user_sensors_info_t implements Serializable {
    int air_press;
    int connect_type;
    int gps_inter;
    boolean gps_open_not;
    int light_value;
    int location_permission;
    int location_switch_level;
    long timestamp;
    boolean wifi_open_not;
    boolean wifi_scan_available;

    user_sensors_info_t() {
    }

    /* access modifiers changed from: package-private */
    public String toJson() {
        return Const.joLeft + "\"timestamp\"" + ":" + this.timestamp + "," + Const.js_req_sensor_wifi_open_not + ":" + this.wifi_open_not + "," + Const.js_req_sensor_wifi_scan_available + ":" + this.wifi_scan_available + "," + Const.js_req_sensor_gps_open_not + ":" + this.gps_open_not + "," + Const.js_req_sensor_wifi_connect_not + ":" + this.connect_type + "," + Const.js_req_sensor_air_press + ":" + this.air_press + "," + Const.js_req_sensor_light_value + ":" + this.light_value + "," + Const.js_req_sensor_gps_inter + ":" + this.gps_inter + "," + Const.js_req_sensor_location_switch_level + ":" + this.location_switch_level + "," + Const.js_req_sensor_location_permission + ":" + this.location_permission + "}";
    }

    /* access modifiers changed from: package-private */
    public String toBamaiLog() {
        return Const.joLeft + "\"timestamp\"" + ":" + this.timestamp + "," + Const.js_req_sensor_wifi_open_not + ":" + this.wifi_open_not + "," + Const.js_req_sensor_wifi_scan_available + ":" + this.wifi_scan_available + "," + Const.js_req_sensor_gps_open_not + ":" + this.gps_open_not + "," + Const.js_req_sensor_wifi_connect_not + ":" + this.connect_type + "," + Const.js_req_sensor_location_switch_level + ":" + this.location_switch_level + "," + Const.js_req_sensor_location_permission + ":" + this.location_permission + "}";
    }
}
