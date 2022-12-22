package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class PassengerWalkRouteReq extends Message {
    public static final Integer DEFAULT_BIZTYPE = 0;
    public static final String DEFAULT_CALLER = "";
    public static final Double DEFAULT_ENDLAT;
    public static final Double DEFAULT_ENDLNG;
    public static final Double DEFAULT_STARTLAT;
    public static final Double DEFAULT_STARTLNG;
    public static final Long DEFAULT_TIMESTAMP = 0L;
    public static final Long DEFAULT_USERID = 0L;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer bizType;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String caller;
    @ProtoField(label = Message.Label.REQUIRED, tag = 4, type = Message.Datatype.DOUBLE)
    public final Double endLat;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.DOUBLE)
    public final Double endLng;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.DOUBLE)
    public final Double startLat;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.DOUBLE)
    public final Double startLng;
    @ProtoField(label = Message.Label.REQUIRED, tag = 5, type = Message.Datatype.UINT64)
    public final Long timestamp;
    @ProtoField(tag = 7, type = Message.Datatype.UINT64)
    public final Long userId;

    static {
        Double valueOf = Double.valueOf(0.0d);
        DEFAULT_STARTLNG = valueOf;
        DEFAULT_STARTLAT = valueOf;
        DEFAULT_ENDLNG = valueOf;
        DEFAULT_ENDLAT = valueOf;
    }

    public PassengerWalkRouteReq(Double d, Double d2, Double d3, Double d4, Long l, Integer num, Long l2, String str) {
        this.startLng = d;
        this.startLat = d2;
        this.endLng = d3;
        this.endLat = d4;
        this.timestamp = l;
        this.bizType = num;
        this.userId = l2;
        this.caller = str;
    }

    private PassengerWalkRouteReq(Builder builder) {
        this(builder.startLng, builder.startLat, builder.endLng, builder.endLat, builder.timestamp, builder.bizType, builder.userId, builder.caller);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PassengerWalkRouteReq)) {
            return false;
        }
        PassengerWalkRouteReq passengerWalkRouteReq = (PassengerWalkRouteReq) obj;
        if (!equals((Object) this.startLng, (Object) passengerWalkRouteReq.startLng) || !equals((Object) this.startLat, (Object) passengerWalkRouteReq.startLat) || !equals((Object) this.endLng, (Object) passengerWalkRouteReq.endLng) || !equals((Object) this.endLat, (Object) passengerWalkRouteReq.endLat) || !equals((Object) this.timestamp, (Object) passengerWalkRouteReq.timestamp) || !equals((Object) this.bizType, (Object) passengerWalkRouteReq.bizType) || !equals((Object) this.userId, (Object) passengerWalkRouteReq.userId) || !equals((Object) this.caller, (Object) passengerWalkRouteReq.caller)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Double d = this.startLng;
        int i2 = 0;
        int hashCode = (d != null ? d.hashCode() : 0) * 37;
        Double d2 = this.startLat;
        int hashCode2 = (hashCode + (d2 != null ? d2.hashCode() : 0)) * 37;
        Double d3 = this.endLng;
        int hashCode3 = (hashCode2 + (d3 != null ? d3.hashCode() : 0)) * 37;
        Double d4 = this.endLat;
        int hashCode4 = (hashCode3 + (d4 != null ? d4.hashCode() : 0)) * 37;
        Long l = this.timestamp;
        int hashCode5 = (hashCode4 + (l != null ? l.hashCode() : 0)) * 37;
        Integer num = this.bizType;
        int hashCode6 = (hashCode5 + (num != null ? num.hashCode() : 0)) * 37;
        Long l2 = this.userId;
        int hashCode7 = (hashCode6 + (l2 != null ? l2.hashCode() : 0)) * 37;
        String str = this.caller;
        if (str != null) {
            i2 = str.hashCode();
        }
        int i3 = hashCode7 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<PassengerWalkRouteReq> {
        public Integer bizType;
        public String caller;
        public Double endLat;
        public Double endLng;
        public Double startLat;
        public Double startLng;
        public Long timestamp;
        public Long userId;

        public Builder() {
        }

        public Builder(PassengerWalkRouteReq passengerWalkRouteReq) {
            super(passengerWalkRouteReq);
            if (passengerWalkRouteReq != null) {
                this.startLng = passengerWalkRouteReq.startLng;
                this.startLat = passengerWalkRouteReq.startLat;
                this.endLng = passengerWalkRouteReq.endLng;
                this.endLat = passengerWalkRouteReq.endLat;
                this.timestamp = passengerWalkRouteReq.timestamp;
                this.bizType = passengerWalkRouteReq.bizType;
                this.userId = passengerWalkRouteReq.userId;
                this.caller = passengerWalkRouteReq.caller;
            }
        }

        public Builder startLng(Double d) {
            this.startLng = d;
            return this;
        }

        public Builder startLat(Double d) {
            this.startLat = d;
            return this;
        }

        public Builder endLng(Double d) {
            this.endLng = d;
            return this;
        }

        public Builder endLat(Double d) {
            this.endLat = d;
            return this;
        }

        public Builder timestamp(Long l) {
            this.timestamp = l;
            return this;
        }

        public Builder bizType(Integer num) {
            this.bizType = num;
            return this;
        }

        public Builder userId(Long l) {
            this.userId = l;
            return this;
        }

        public Builder caller(String str) {
            this.caller = str;
            return this;
        }

        public PassengerWalkRouteReq build() {
            checkRequiredFields();
            return new PassengerWalkRouteReq(this);
        }
    }
}
