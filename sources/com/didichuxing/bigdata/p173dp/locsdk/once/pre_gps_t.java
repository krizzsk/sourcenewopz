package com.didichuxing.bigdata.p173dp.locsdk.once;

import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.io.Serializable;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.once.pre_gps_t */
/* compiled from: LocDataDef */
class pre_gps_t implements Serializable {
    double acy;
    double dir;

    /* renamed from: dt */
    long f46144dt;
    double lat;
    double lon;
    double spd;

    pre_gps_t() {
    }

    /* access modifiers changed from: package-private */
    public String toJson() {
        return Const.joLeft + "\"lon\"" + ":" + Const.formatDouble(this.lon, 6) + "," + "\"lat\"" + ":" + Const.formatDouble(this.lat, 6) + "," + "\"spd\"" + ":" + Const.formatDouble(this.spd, 2) + "," + "\"dir\"" + ":" + Const.formatDouble(this.dir, 2) + "," + "\"dt\"" + ":" + this.f46144dt + "," + "\"acy\"" + ":" + Const.formatDouble(this.acy, 2) + "}";
    }
}
