package com.didi.travel.psnger.model.response;

import com.didichuxing.bigdata.p173dp.locsdk.Const;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* compiled from: DriverPosition */
class DriverPositionRaw implements Serializable {
    @SerializedName("arrivedTime")
    public int arrivedTime;
    @SerializedName("distance")
    public String distance;
    @SerializedName("distanceEnabled")
    public int distanceEnabled = 0;
    @SerializedName("lat")
    public String lat = "";
    @SerializedName("lng")
    public String lng = "";

    DriverPositionRaw() {
    }

    public String toString() {
        return "DriverPosition [lat=" + this.lat + ", lng=" + this.lng + ", arrivedTime=" + this.arrivedTime + ", distance=" + this.distance + ", distanceEnabled=" + this.distanceEnabled + Const.jaRight;
    }
}
