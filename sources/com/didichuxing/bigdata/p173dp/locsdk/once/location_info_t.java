package com.didichuxing.bigdata.p173dp.locsdk.once;

import com.didichuxing.bigdata.p173dp.locsdk.Const;
import com.didichuxing.bigdata.p173dp.locsdk.DLog;
import java.io.Serializable;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.once.location_info_t */
/* compiled from: LocDataDef */
class location_info_t implements Serializable {
    long accuracy;
    double confidence;
    double lat_gcj;
    double lon_gcj;

    location_info_t() {
    }

    /* access modifiers changed from: package-private */
    public String toJson() {
        return Const.joLeft + Const.js_rsp_loc_lon_gcj + ":" + Const.formatDouble(this.lon_gcj, 6) + "," + Const.js_rsp_loc_lat_gcj + ":" + Const.formatDouble(this.lat_gcj, 6) + "," + Const.js_rsp_loc_accuracy + ":" + this.accuracy + "," + Const.js_rsp_loc_confidence + ":" + Const.formatDouble(this.confidence, 3) + "}";
    }

    static location_info_t toObject(String str) {
        try {
            location_info_t location_info_t = new location_info_t();
            String jsonObject = Const.getJsonObject(str, Const.js_rsp_loc_lon_gcj);
            String jsonObject2 = Const.getJsonObject(str, Const.js_rsp_loc_lat_gcj);
            String jsonObject3 = Const.getJsonObject(str, Const.js_rsp_loc_accuracy);
            String jsonObject4 = Const.getJsonObject(str, Const.js_rsp_loc_confidence);
            if (!(jsonObject.length() == 0 || jsonObject2.length() == 0 || jsonObject3.length() == 0)) {
                if (jsonObject4.length() != 0) {
                    location_info_t.lon_gcj = Double.parseDouble(jsonObject);
                    location_info_t.lat_gcj = Double.parseDouble(jsonObject2);
                    location_info_t.accuracy = Long.parseLong(jsonObject3);
                    location_info_t.confidence = Double.parseDouble(jsonObject4);
                    return location_info_t;
                }
            }
            return null;
        } catch (Exception e) {
            DLog.m32737d(e.toString());
            return null;
        }
    }
}
