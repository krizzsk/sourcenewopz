package com.didi.beatles.p099im.api.entity;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* renamed from: com.didi.beatles.im.api.entity.IMStreetViewRequest */
public class IMStreetViewRequest extends IMBaseRequest {
    private Body body = new Body();

    /* renamed from: com.didi.beatles.im.api.entity.IMStreetViewRequest$Body */
    public static class Body implements Serializable {
        @SerializedName("driver_uid")
        public long driverUid;
        @SerializedName("passenger_uid")
        public long passengerUid;
        @SerializedName("sid")
        public long sessionId;
    }

    public IMStreetViewRequest(int i, int i2) {
        super(i, i2);
    }

    public IMStreetViewRequest setSessionId(long j) {
        this.body.sessionId = j;
        return this;
    }

    public IMStreetViewRequest setPassengerUid(long j) {
        this.body.passengerUid = j;
        return this;
    }

    public IMStreetViewRequest setDriverUid(long j) {
        this.body.driverUid = j;
        return this;
    }
}
