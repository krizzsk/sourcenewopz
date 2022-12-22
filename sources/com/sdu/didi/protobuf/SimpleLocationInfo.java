package com.sdu.didi.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SimpleLocationInfo extends Message {
    public static final Double DEFAULT_ACCURACY;
    public static final Float DEFAULT_ALTITUDE = Float.valueOf(0.0f);
    public static final CoordinateType DEFAULT_COORDTYPE = CoordinateType.BD_09;
    public static final Double DEFAULT_DIRECTION;
    public static final Double DEFAULT_LAT;
    public static final Double DEFAULT_LNG;
    public static final String DEFAULT_SOURCE = "";
    public static final Double DEFAULT_SPEED;
    public static final Long DEFAULT_TIME64_LOC = 0L;
    public static final Long DEFAULT_TIME64_MOBILE = 0L;
    @ProtoField(tag = 5, type = Message.Datatype.DOUBLE)
    public final Double accuracy;
    @ProtoField(tag = 8, type = Message.Datatype.FLOAT)
    public final Float altitude;
    @ProtoField(tag = 3, type = Message.Datatype.ENUM)
    public final CoordinateType coordType;
    @ProtoField(tag = 6, type = Message.Datatype.DOUBLE)
    public final Double direction;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.DOUBLE)
    public final Double lat;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.DOUBLE)
    public final Double lng;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String source;
    @ProtoField(tag = 7, type = Message.Datatype.DOUBLE)
    public final Double speed;
    @ProtoField(tag = 9, type = Message.Datatype.UINT64)
    public final Long time64_loc;
    @ProtoField(tag = 10, type = Message.Datatype.UINT64)
    public final Long time64_mobile;

    static {
        Double valueOf = Double.valueOf(0.0d);
        DEFAULT_LNG = valueOf;
        DEFAULT_LAT = valueOf;
        DEFAULT_ACCURACY = valueOf;
        DEFAULT_DIRECTION = valueOf;
        DEFAULT_SPEED = valueOf;
    }

    public SimpleLocationInfo(Double d, Double d2, CoordinateType coordinateType, String str, Double d3, Double d4, Double d5, Float f, Long l, Long l2) {
        this.lng = d;
        this.lat = d2;
        this.coordType = coordinateType;
        this.source = str;
        this.accuracy = d3;
        this.direction = d4;
        this.speed = d5;
        this.altitude = f;
        this.time64_loc = l;
        this.time64_mobile = l2;
    }

    private SimpleLocationInfo(Builder builder) {
        this(builder.lng, builder.lat, builder.coordType, builder.source, builder.accuracy, builder.direction, builder.speed, builder.altitude, builder.time64_loc, builder.time64_mobile);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SimpleLocationInfo)) {
            return false;
        }
        SimpleLocationInfo simpleLocationInfo = (SimpleLocationInfo) obj;
        if (!equals((Object) this.lng, (Object) simpleLocationInfo.lng) || !equals((Object) this.lat, (Object) simpleLocationInfo.lat) || !equals((Object) this.coordType, (Object) simpleLocationInfo.coordType) || !equals((Object) this.source, (Object) simpleLocationInfo.source) || !equals((Object) this.accuracy, (Object) simpleLocationInfo.accuracy) || !equals((Object) this.direction, (Object) simpleLocationInfo.direction) || !equals((Object) this.speed, (Object) simpleLocationInfo.speed) || !equals((Object) this.altitude, (Object) simpleLocationInfo.altitude) || !equals((Object) this.time64_loc, (Object) simpleLocationInfo.time64_loc) || !equals((Object) this.time64_mobile, (Object) simpleLocationInfo.time64_mobile)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Double d = this.lng;
        int i2 = 0;
        int hashCode = (d != null ? d.hashCode() : 0) * 37;
        Double d2 = this.lat;
        int hashCode2 = (hashCode + (d2 != null ? d2.hashCode() : 0)) * 37;
        CoordinateType coordinateType = this.coordType;
        int hashCode3 = (hashCode2 + (coordinateType != null ? coordinateType.hashCode() : 0)) * 37;
        String str = this.source;
        int hashCode4 = (hashCode3 + (str != null ? str.hashCode() : 0)) * 37;
        Double d3 = this.accuracy;
        int hashCode5 = (hashCode4 + (d3 != null ? d3.hashCode() : 0)) * 37;
        Double d4 = this.direction;
        int hashCode6 = (hashCode5 + (d4 != null ? d4.hashCode() : 0)) * 37;
        Double d5 = this.speed;
        int hashCode7 = (hashCode6 + (d5 != null ? d5.hashCode() : 0)) * 37;
        Float f = this.altitude;
        int hashCode8 = (hashCode7 + (f != null ? f.hashCode() : 0)) * 37;
        Long l = this.time64_loc;
        int hashCode9 = (hashCode8 + (l != null ? l.hashCode() : 0)) * 37;
        Long l2 = this.time64_mobile;
        if (l2 != null) {
            i2 = l2.hashCode();
        }
        int i3 = hashCode9 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SimpleLocationInfo> {
        public Double accuracy;
        public Float altitude;
        public CoordinateType coordType;
        public Double direction;
        public Double lat;
        public Double lng;
        public String source;
        public Double speed;
        public Long time64_loc;
        public Long time64_mobile;

        public Builder() {
        }

        public Builder(SimpleLocationInfo simpleLocationInfo) {
            super(simpleLocationInfo);
            if (simpleLocationInfo != null) {
                this.lng = simpleLocationInfo.lng;
                this.lat = simpleLocationInfo.lat;
                this.coordType = simpleLocationInfo.coordType;
                this.source = simpleLocationInfo.source;
                this.accuracy = simpleLocationInfo.accuracy;
                this.direction = simpleLocationInfo.direction;
                this.speed = simpleLocationInfo.speed;
                this.altitude = simpleLocationInfo.altitude;
                this.time64_loc = simpleLocationInfo.time64_loc;
                this.time64_mobile = simpleLocationInfo.time64_mobile;
            }
        }

        public Builder lng(Double d) {
            this.lng = d;
            return this;
        }

        public Builder lat(Double d) {
            this.lat = d;
            return this;
        }

        public Builder coordType(CoordinateType coordinateType) {
            this.coordType = coordinateType;
            return this;
        }

        public Builder source(String str) {
            this.source = str;
            return this;
        }

        public Builder accuracy(Double d) {
            this.accuracy = d;
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

        public Builder altitude(Float f) {
            this.altitude = f;
            return this;
        }

        public Builder time64_loc(Long l) {
            this.time64_loc = l;
            return this;
        }

        public Builder time64_mobile(Long l) {
            this.time64_mobile = l;
            return this;
        }

        public SimpleLocationInfo build() {
            checkRequiredFields();
            return new SimpleLocationInfo(this);
        }
    }
}
