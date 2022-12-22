package com.didichuxing.bigdata.p173dp.locsdk.impl.p174v3;

import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.io.Serializable;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.impl.v3.pre_location_t */
/* compiled from: LocDataDef */
class pre_location_t implements Serializable {
    double acy;
    double lat;
    double lon;
    double spd;
    String src;

    /* renamed from: ts */
    long f45994ts;

    pre_location_t(double d, double d2, double d3, long j, double d4, String str) {
        this.lon = d;
        this.lat = d2;
        this.spd = d3;
        this.f45994ts = j;
        this.acy = d4;
        this.src = str;
    }

    /* access modifiers changed from: package-private */
    public String toJson() {
        return Const.joLeft + "\"lon\"" + ":" + Const.formatDouble(this.lon, 6) + "," + "\"lat\"" + ":" + Const.formatDouble(this.lat, 6) + "," + "\"spd\"" + ":" + Const.formatDouble(this.spd, 2) + "," + "\"ts\"" + ":" + this.f45994ts + "," + "\"acy\"" + ":" + Const.formatDouble(this.acy, 3) + "," + Const.js_req_src + ":" + Const.jsQuote + this.src + Const.jsQuote + "}";
    }
}
