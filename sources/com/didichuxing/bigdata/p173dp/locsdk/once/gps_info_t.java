package com.didichuxing.bigdata.p173dp.locsdk.once;

import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.io.Serializable;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.once.gps_info_t */
/* compiled from: LocDataDef */
class gps_info_t implements Serializable {
    double acy;
    double dir;
    double lat;
    double lon;
    double spd;

    /* renamed from: ts */
    long f46142ts;

    gps_info_t() {
    }

    /* access modifiers changed from: package-private */
    public String toJson() {
        return Const.joLeft + "\"lon\"" + ":" + Const.formatDouble(this.lon, 6) + "," + "\"lat\"" + ":" + Const.formatDouble(this.lat, 6) + "," + "\"spd\"" + ":" + Const.formatDouble(this.spd, 6) + "," + "\"dir\"" + ":" + Const.formatDouble(this.dir, 6) + "," + "\"ts\"" + ":" + this.f46142ts + "," + "\"acy\"" + ":" + Const.formatDouble(this.acy, 6) + "}";
    }
}
