package com.didi.travel.psnger.model.response;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* compiled from: DriverPosition */
class PeerCoordinate implements Serializable {
    @SerializedName("coordinate")
    public Coord coordinate;
    @SerializedName("distance")
    public int distance;
    @SerializedName("local_id")
    String localId;
    @SerializedName("wait_time")
    public int waitTime;

    PeerCoordinate() {
    }
}
