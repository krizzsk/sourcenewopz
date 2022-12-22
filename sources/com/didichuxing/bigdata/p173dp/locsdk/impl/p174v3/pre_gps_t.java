package com.didichuxing.bigdata.p173dp.locsdk.impl.p174v3;

import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.io.Serializable;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.impl.v3.pre_gps_t */
/* compiled from: LocDataDef */
class pre_gps_t implements Serializable {
    double acy;
    double dir;

    /* renamed from: dt */
    long f45993dt;
    double lat;
    double lon;
    double spd;

    pre_gps_t() {
    }

    /* access modifiers changed from: package-private */
    public String toJson() {
        return Const.joLeft + "\"lon\"" + ":" + Const.formatDouble(this.lon, 6) + "," + "\"lat\"" + ":" + Const.formatDouble(this.lat, 6) + "," + "\"spd\"" + ":" + Const.formatDouble(this.spd, 2) + "," + "\"dir\"" + ":" + Const.formatDouble(this.dir, 2) + "," + "\"dt\"" + ":" + this.f45993dt + "," + "\"acy\"" + ":" + Const.formatDouble(this.acy, 2) + "}";
    }
}
