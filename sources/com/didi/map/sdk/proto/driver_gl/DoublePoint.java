package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class DoublePoint extends Message {
    public static final Double DEFAULT_ACCURACY;
    public static final String DEFAULT_CHOOSEFLAG = "";
    public static final Integer DEFAULT_DIRECTION = 0;
    public static final Double DEFAULT_DLAT;
    public static final Double DEFAULT_DLNG;
    public static final LocationSource DEFAULT_GPSSOURCE = LocationSource.GPS;
    public static final Long DEFAULT_GPSTIMESTAMP = 0L;
    public static final Float DEFAULT_LAT;
    public static final Float DEFAULT_LNG;
    public static final String DEFAULT_NAME = "";
    public static final Integer DEFAULT_POINTSOURCE = 0;
    public static final Integer DEFAULT_SPEED = 0;
    public static final Long DEFAULT_TIMESTAMP = 0L;
    public static final String DEFAULT_UID = "";
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String UID;
    @ProtoField(tag = 9, type = Message.Datatype.DOUBLE)
    public final Double accuracy;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String chooseFlag;
    @ProtoField(tag = 14, type = Message.Datatype.INT32)
    public final Integer direction;
    @ProtoField(tag = 4, type = Message.Datatype.DOUBLE)
    public final Double dlat;
    @ProtoField(tag = 3, type = Message.Datatype.DOUBLE)
    public final Double dlng;
    @ProtoField(tag = 12, type = Message.Datatype.ENUM)
    public final LocationSource gpsSource;
    @ProtoField(tag = 11, type = Message.Datatype.UINT64)
    public final Long gpsTimestamp;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.FLOAT)
    public final Float lat;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.FLOAT)
    public final Float lng;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String name;
    @ProtoField(tag = 13, type = Message.Datatype.INT32)
    public final Integer pointSource;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer speed;
    @ProtoField(tag = 10, type = Message.Datatype.UINT64)
    public final Long timestamp;

    static {
        Float valueOf = Float.valueOf(0.0f);
        DEFAULT_LAT = valueOf;
        DEFAULT_LNG = valueOf;
        Double valueOf2 = Double.valueOf(0.0d);
        DEFAULT_DLNG = valueOf2;
        DEFAULT_DLAT = valueOf2;
        DEFAULT_ACCURACY = valueOf2;
    }

    public DoublePoint(Float f, Float f2, Double d, Double d2, String str, String str2, String str3, Integer num, Double d3, Long l, Long l2, LocationSource locationSource, Integer num2, Integer num3) {
        this.lat = f;
        this.lng = f2;
        this.dlng = d;
        this.dlat = d2;
        this.name = str;
        this.UID = str2;
        this.chooseFlag = str3;
        this.speed = num;
        this.accuracy = d3;
        this.timestamp = l;
        this.gpsTimestamp = l2;
        this.gpsSource = locationSource;
        this.pointSource = num2;
        this.direction = num3;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private DoublePoint(com.didi.map.sdk.proto.driver_gl.DoublePoint.Builder r17) {
        /*
            r16 = this;
            r0 = r17
            java.lang.Float r2 = r0.lat
            java.lang.Float r3 = r0.lng
            java.lang.Double r4 = r0.dlng
            java.lang.Double r5 = r0.dlat
            java.lang.String r6 = r0.name
            java.lang.String r7 = r0.UID
            java.lang.String r8 = r0.chooseFlag
            java.lang.Integer r9 = r0.speed
            java.lang.Double r10 = r0.accuracy
            java.lang.Long r11 = r0.timestamp
            java.lang.Long r12 = r0.gpsTimestamp
            com.didi.map.sdk.proto.driver_gl.LocationSource r13 = r0.gpsSource
            java.lang.Integer r14 = r0.pointSource
            java.lang.Integer r15 = r0.direction
            r1 = r16
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            r16.setBuilder(r17)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.sdk.proto.driver_gl.DoublePoint.<init>(com.didi.map.sdk.proto.driver_gl.DoublePoint$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DoublePoint)) {
            return false;
        }
        DoublePoint doublePoint = (DoublePoint) obj;
        if (!equals((Object) this.lat, (Object) doublePoint.lat) || !equals((Object) this.lng, (Object) doublePoint.lng) || !equals((Object) this.dlng, (Object) doublePoint.dlng) || !equals((Object) this.dlat, (Object) doublePoint.dlat) || !equals((Object) this.name, (Object) doublePoint.name) || !equals((Object) this.UID, (Object) doublePoint.UID) || !equals((Object) this.chooseFlag, (Object) doublePoint.chooseFlag) || !equals((Object) this.speed, (Object) doublePoint.speed) || !equals((Object) this.accuracy, (Object) doublePoint.accuracy) || !equals((Object) this.timestamp, (Object) doublePoint.timestamp) || !equals((Object) this.gpsTimestamp, (Object) doublePoint.gpsTimestamp) || !equals((Object) this.gpsSource, (Object) doublePoint.gpsSource) || !equals((Object) this.pointSource, (Object) doublePoint.pointSource) || !equals((Object) this.direction, (Object) doublePoint.direction)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Float f = this.lat;
        int i2 = 0;
        int hashCode = (f != null ? f.hashCode() : 0) * 37;
        Float f2 = this.lng;
        int hashCode2 = (hashCode + (f2 != null ? f2.hashCode() : 0)) * 37;
        Double d = this.dlng;
        int hashCode3 = (hashCode2 + (d != null ? d.hashCode() : 0)) * 37;
        Double d2 = this.dlat;
        int hashCode4 = (hashCode3 + (d2 != null ? d2.hashCode() : 0)) * 37;
        String str = this.name;
        int hashCode5 = (hashCode4 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.UID;
        int hashCode6 = (hashCode5 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.chooseFlag;
        int hashCode7 = (hashCode6 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Integer num = this.speed;
        int hashCode8 = (hashCode7 + (num != null ? num.hashCode() : 0)) * 37;
        Double d3 = this.accuracy;
        int hashCode9 = (hashCode8 + (d3 != null ? d3.hashCode() : 0)) * 37;
        Long l = this.timestamp;
        int hashCode10 = (hashCode9 + (l != null ? l.hashCode() : 0)) * 37;
        Long l2 = this.gpsTimestamp;
        int hashCode11 = (hashCode10 + (l2 != null ? l2.hashCode() : 0)) * 37;
        LocationSource locationSource = this.gpsSource;
        int hashCode12 = (hashCode11 + (locationSource != null ? locationSource.hashCode() : 0)) * 37;
        Integer num2 = this.pointSource;
        int hashCode13 = (hashCode12 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.direction;
        if (num3 != null) {
            i2 = num3.hashCode();
        }
        int i3 = hashCode13 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<DoublePoint> {
        public String UID;
        public Double accuracy;
        public String chooseFlag;
        public Integer direction;
        public Double dlat;
        public Double dlng;
        public LocationSource gpsSource;
        public Long gpsTimestamp;
        public Float lat;
        public Float lng;
        public String name;
        public Integer pointSource;
        public Integer speed;
        public Long timestamp;

        public Builder() {
        }

        public Builder(DoublePoint doublePoint) {
            super(doublePoint);
            if (doublePoint != null) {
                this.lat = doublePoint.lat;
                this.lng = doublePoint.lng;
                this.dlng = doublePoint.dlng;
                this.dlat = doublePoint.dlat;
                this.name = doublePoint.name;
                this.UID = doublePoint.UID;
                this.chooseFlag = doublePoint.chooseFlag;
                this.speed = doublePoint.speed;
                this.accuracy = doublePoint.accuracy;
                this.timestamp = doublePoint.timestamp;
                this.gpsTimestamp = doublePoint.gpsTimestamp;
                this.gpsSource = doublePoint.gpsSource;
                this.pointSource = doublePoint.pointSource;
                this.direction = doublePoint.direction;
            }
        }

        public Builder lat(Float f) {
            this.lat = f;
            return this;
        }

        public Builder lng(Float f) {
            this.lng = f;
            return this;
        }

        public Builder dlng(Double d) {
            this.dlng = d;
            return this;
        }

        public Builder dlat(Double d) {
            this.dlat = d;
            return this;
        }

        public Builder name(String str) {
            this.name = str;
            return this;
        }

        public Builder UID(String str) {
            this.UID = str;
            return this;
        }

        public Builder chooseFlag(String str) {
            this.chooseFlag = str;
            return this;
        }

        public Builder speed(Integer num) {
            this.speed = num;
            return this;
        }

        public Builder accuracy(Double d) {
            this.accuracy = d;
            return this;
        }

        public Builder timestamp(Long l) {
            this.timestamp = l;
            return this;
        }

        public Builder gpsTimestamp(Long l) {
            this.gpsTimestamp = l;
            return this;
        }

        public Builder gpsSource(LocationSource locationSource) {
            this.gpsSource = locationSource;
            return this;
        }

        public Builder pointSource(Integer num) {
            this.pointSource = num;
            return this;
        }

        public Builder direction(Integer num) {
            this.direction = num;
            return this;
        }

        public DoublePoint build() {
            checkRequiredFields();
            return new DoublePoint(this);
        }
    }
}
