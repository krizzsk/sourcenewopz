package com.didi.sdk.messagecenter.p152pb;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

/* renamed from: com.didi.sdk.messagecenter.pb.LocationDetail */
public final class LocationDetail extends Message {
    public static final Double DEFAULT_DIRECTION;
    public static final Double DEFAULT_LAT;
    public static final Double DEFAULT_LNG;
    public static final Double DEFAULT_SPEED;
    @ProtoField(tag = 3, type = Message.Datatype.DOUBLE)
    public final Double direction;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.DOUBLE)
    public final Double lat;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.DOUBLE)
    public final Double lng;
    @ProtoField(tag = 4, type = Message.Datatype.DOUBLE)
    public final Double speed;

    static {
        Double valueOf = Double.valueOf(0.0d);
        DEFAULT_LAT = valueOf;
        DEFAULT_LNG = valueOf;
        DEFAULT_DIRECTION = valueOf;
        DEFAULT_SPEED = valueOf;
    }

    public LocationDetail(Double d, Double d2, Double d3, Double d4) {
        this.lat = d;
        this.lng = d2;
        this.direction = d3;
        this.speed = d4;
    }

    private LocationDetail(Builder builder) {
        this(builder.lat, builder.lng, builder.direction, builder.speed);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LocationDetail)) {
            return false;
        }
        LocationDetail locationDetail = (LocationDetail) obj;
        if (!equals((Object) this.lat, (Object) locationDetail.lat) || !equals((Object) this.lng, (Object) locationDetail.lng) || !equals((Object) this.direction, (Object) locationDetail.direction) || !equals((Object) this.speed, (Object) locationDetail.speed)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Double d = this.lat;
        int i2 = 0;
        int hashCode = (d != null ? d.hashCode() : 0) * 37;
        Double d2 = this.lng;
        int hashCode2 = (hashCode + (d2 != null ? d2.hashCode() : 0)) * 37;
        Double d3 = this.direction;
        int hashCode3 = (hashCode2 + (d3 != null ? d3.hashCode() : 0)) * 37;
        Double d4 = this.speed;
        if (d4 != null) {
            i2 = d4.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    /* renamed from: com.didi.sdk.messagecenter.pb.LocationDetail$Builder */
    public static final class Builder extends Message.Builder<LocationDetail> {
        public Double direction;
        public Double lat;
        public Double lng;
        public Double speed;

        public Builder() {
        }

        public Builder(LocationDetail locationDetail) {
            super(locationDetail);
            if (locationDetail != null) {
                this.lat = locationDetail.lat;
                this.lng = locationDetail.lng;
                this.direction = locationDetail.direction;
                this.speed = locationDetail.speed;
            }
        }

        public Builder lat(Double d) {
            this.lat = d;
            return this;
        }

        public Builder lng(Double d) {
            this.lng = d;
            return this;
        }

        public Builder direction(Double d) {
            this.direction = d;
            return this;
        }

        public Builder speed(Double d) {
            this.speed = d;
            return this;
        }

        public LocationDetail build() {
            checkRequiredFields();
            return new LocationDetail(this);
        }
    }
}
