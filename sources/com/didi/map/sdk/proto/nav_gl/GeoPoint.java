package com.didi.map.sdk.proto.nav_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class GeoPoint extends Message {
    public static final Integer DEFAULT_LAT = 0;
    public static final Integer DEFAULT_LNG = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer lat;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.INT32)
    public final Integer lng;

    public GeoPoint(Integer num, Integer num2) {
        this.lng = num;
        this.lat = num2;
    }

    private GeoPoint(Builder builder) {
        this(builder.lng, builder.lat);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GeoPoint)) {
            return false;
        }
        GeoPoint geoPoint = (GeoPoint) obj;
        if (!equals((Object) this.lng, (Object) geoPoint.lng) || !equals((Object) this.lat, (Object) geoPoint.lat)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.lng;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.lat;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GeoPoint> {
        public Integer lat;
        public Integer lng;

        public Builder() {
        }

        public Builder(GeoPoint geoPoint) {
            super(geoPoint);
            if (geoPoint != null) {
                this.lng = geoPoint.lng;
                this.lat = geoPoint.lat;
            }
        }

        public Builder lng(Integer num) {
            this.lng = num;
            return this;
        }

        public Builder lat(Integer num) {
            this.lat = num;
            return this;
        }

        public GeoPoint build() {
            checkRequiredFields();
            return new GeoPoint(this);
        }
    }
}
