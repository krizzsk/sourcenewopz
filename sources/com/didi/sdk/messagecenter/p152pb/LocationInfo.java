package com.didi.sdk.messagecenter.p152pb;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

/* renamed from: com.didi.sdk.messagecenter.pb.LocationInfo */
public final class LocationInfo extends Message {
    public static final Float DEFAULT_ACCELERATEDSPEEDX;
    public static final Float DEFAULT_ACCELERATEDSPEEDY;
    public static final Float DEFAULT_ACCELERATEDSPEEDZ;
    public static final Double DEFAULT_ACCURACY;
    public static final Double DEFAULT_DIRECTION;
    public static final Float DEFAULT_INCLUDEDANGLEPITCH;
    public static final Float DEFAULT_INCLUDEDANGLEROLL;
    public static final Float DEFAULT_INCLUDEDANGLEYAW;
    public static final LocationType DEFAULT_LOCTYPE = LocationType.LOC_GPS;
    public static final Double DEFAULT_SPEED;
    public static final Integer DEFAULT_TIMESTAMP = 0;
    public static final CoordinateType DEFAULT_TYPE = CoordinateType.BD_09;
    public static final Double DEFAULT_X;
    public static final Double DEFAULT_Y;
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 7, type = Message.Datatype.FLOAT)
    public final Float acceleratedSpeedX;
    @ProtoField(label = Message.Label.REQUIRED, tag = 8, type = Message.Datatype.FLOAT)
    public final Float acceleratedSpeedY;
    @ProtoField(label = Message.Label.REQUIRED, tag = 9, type = Message.Datatype.FLOAT)
    public final Float acceleratedSpeedZ;
    @ProtoField(label = Message.Label.REQUIRED, tag = 4, type = Message.Datatype.DOUBLE)
    public final Double accuracy;
    @ProtoField(label = Message.Label.REQUIRED, tag = 5, type = Message.Datatype.DOUBLE)
    public final Double direction;
    @ProtoField(label = Message.Label.REQUIRED, tag = 12, type = Message.Datatype.FLOAT)
    public final Float includedAnglePitch;
    @ProtoField(label = Message.Label.REQUIRED, tag = 11, type = Message.Datatype.FLOAT)
    public final Float includedAngleRoll;
    @ProtoField(label = Message.Label.REQUIRED, tag = 10, type = Message.Datatype.FLOAT)
    public final Float includedAngleYaw;
    @ProtoField(tag = 14, type = Message.Datatype.ENUM)
    public final LocationType locType;
    @ProtoField(label = Message.Label.REQUIRED, tag = 6, type = Message.Datatype.DOUBLE)
    public final Double speed;
    @ProtoField(label = Message.Label.REQUIRED, tag = 13, type = Message.Datatype.INT32)
    public final Integer timestamp;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.ENUM)
    public final CoordinateType type;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.DOUBLE)

    /* renamed from: x */
    public final Double f36788x;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.DOUBLE)

    /* renamed from: y */
    public final Double f36789y;

    static {
        Double valueOf = Double.valueOf(0.0d);
        DEFAULT_X = valueOf;
        DEFAULT_Y = valueOf;
        DEFAULT_ACCURACY = valueOf;
        DEFAULT_DIRECTION = valueOf;
        DEFAULT_SPEED = valueOf;
        Float valueOf2 = Float.valueOf(0.0f);
        DEFAULT_ACCELERATEDSPEEDX = valueOf2;
        DEFAULT_ACCELERATEDSPEEDY = valueOf2;
        DEFAULT_ACCELERATEDSPEEDZ = valueOf2;
        DEFAULT_INCLUDEDANGLEYAW = valueOf2;
        DEFAULT_INCLUDEDANGLEROLL = valueOf2;
        DEFAULT_INCLUDEDANGLEPITCH = valueOf2;
    }

    public LocationInfo(Double d, Double d2, CoordinateType coordinateType, Double d3, Double d4, Double d5, Float f, Float f2, Float f3, Float f4, Float f5, Float f6, Integer num, LocationType locationType) {
        this.f36788x = d;
        this.f36789y = d2;
        this.type = coordinateType;
        this.accuracy = d3;
        this.direction = d4;
        this.speed = d5;
        this.acceleratedSpeedX = f;
        this.acceleratedSpeedY = f2;
        this.acceleratedSpeedZ = f3;
        this.includedAngleYaw = f4;
        this.includedAngleRoll = f5;
        this.includedAnglePitch = f6;
        this.timestamp = num;
        this.locType = locationType;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private LocationInfo(com.didi.sdk.messagecenter.p152pb.LocationInfo.Builder r17) {
        /*
            r16 = this;
            r0 = r17
            java.lang.Double r2 = r0.f36790x
            java.lang.Double r3 = r0.f36791y
            com.didi.sdk.messagecenter.pb.CoordinateType r4 = r0.type
            java.lang.Double r5 = r0.accuracy
            java.lang.Double r6 = r0.direction
            java.lang.Double r7 = r0.speed
            java.lang.Float r8 = r0.acceleratedSpeedX
            java.lang.Float r9 = r0.acceleratedSpeedY
            java.lang.Float r10 = r0.acceleratedSpeedZ
            java.lang.Float r11 = r0.includedAngleYaw
            java.lang.Float r12 = r0.includedAngleRoll
            java.lang.Float r13 = r0.includedAnglePitch
            java.lang.Integer r14 = r0.timestamp
            com.didi.sdk.messagecenter.pb.LocationType r15 = r0.locType
            r1 = r16
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            r16.setBuilder(r17)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.messagecenter.p152pb.LocationInfo.<init>(com.didi.sdk.messagecenter.pb.LocationInfo$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LocationInfo)) {
            return false;
        }
        LocationInfo locationInfo = (LocationInfo) obj;
        if (!equals((Object) this.f36788x, (Object) locationInfo.f36788x) || !equals((Object) this.f36789y, (Object) locationInfo.f36789y) || !equals((Object) this.type, (Object) locationInfo.type) || !equals((Object) this.accuracy, (Object) locationInfo.accuracy) || !equals((Object) this.direction, (Object) locationInfo.direction) || !equals((Object) this.speed, (Object) locationInfo.speed) || !equals((Object) this.acceleratedSpeedX, (Object) locationInfo.acceleratedSpeedX) || !equals((Object) this.acceleratedSpeedY, (Object) locationInfo.acceleratedSpeedY) || !equals((Object) this.acceleratedSpeedZ, (Object) locationInfo.acceleratedSpeedZ) || !equals((Object) this.includedAngleYaw, (Object) locationInfo.includedAngleYaw) || !equals((Object) this.includedAngleRoll, (Object) locationInfo.includedAngleRoll) || !equals((Object) this.includedAnglePitch, (Object) locationInfo.includedAnglePitch) || !equals((Object) this.timestamp, (Object) locationInfo.timestamp) || !equals((Object) this.locType, (Object) locationInfo.locType)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Double d = this.f36788x;
        int i2 = 0;
        int hashCode = (d != null ? d.hashCode() : 0) * 37;
        Double d2 = this.f36789y;
        int hashCode2 = (hashCode + (d2 != null ? d2.hashCode() : 0)) * 37;
        CoordinateType coordinateType = this.type;
        int hashCode3 = (hashCode2 + (coordinateType != null ? coordinateType.hashCode() : 0)) * 37;
        Double d3 = this.accuracy;
        int hashCode4 = (hashCode3 + (d3 != null ? d3.hashCode() : 0)) * 37;
        Double d4 = this.direction;
        int hashCode5 = (hashCode4 + (d4 != null ? d4.hashCode() : 0)) * 37;
        Double d5 = this.speed;
        int hashCode6 = (hashCode5 + (d5 != null ? d5.hashCode() : 0)) * 37;
        Float f = this.acceleratedSpeedX;
        int hashCode7 = (hashCode6 + (f != null ? f.hashCode() : 0)) * 37;
        Float f2 = this.acceleratedSpeedY;
        int hashCode8 = (hashCode7 + (f2 != null ? f2.hashCode() : 0)) * 37;
        Float f3 = this.acceleratedSpeedZ;
        int hashCode9 = (hashCode8 + (f3 != null ? f3.hashCode() : 0)) * 37;
        Float f4 = this.includedAngleYaw;
        int hashCode10 = (hashCode9 + (f4 != null ? f4.hashCode() : 0)) * 37;
        Float f5 = this.includedAngleRoll;
        int hashCode11 = (hashCode10 + (f5 != null ? f5.hashCode() : 0)) * 37;
        Float f6 = this.includedAnglePitch;
        int hashCode12 = (hashCode11 + (f6 != null ? f6.hashCode() : 0)) * 37;
        Integer num = this.timestamp;
        int hashCode13 = (hashCode12 + (num != null ? num.hashCode() : 0)) * 37;
        LocationType locationType = this.locType;
        if (locationType != null) {
            i2 = locationType.hashCode();
        }
        int i3 = hashCode13 + i2;
        this.hashCode = i3;
        return i3;
    }

    /* renamed from: com.didi.sdk.messagecenter.pb.LocationInfo$Builder */
    public static final class Builder extends Message.Builder<LocationInfo> {
        public Float acceleratedSpeedX;
        public Float acceleratedSpeedY;
        public Float acceleratedSpeedZ;
        public Double accuracy;
        public Double direction;
        public Float includedAnglePitch;
        public Float includedAngleRoll;
        public Float includedAngleYaw;
        public LocationType locType;
        public Double speed;
        public Integer timestamp;
        public CoordinateType type;

        /* renamed from: x */
        public Double f36790x;

        /* renamed from: y */
        public Double f36791y;

        public Builder() {
        }

        public Builder(LocationInfo locationInfo) {
            super(locationInfo);
            if (locationInfo != null) {
                this.f36790x = locationInfo.f36788x;
                this.f36791y = locationInfo.f36789y;
                this.type = locationInfo.type;
                this.accuracy = locationInfo.accuracy;
                this.direction = locationInfo.direction;
                this.speed = locationInfo.speed;
                this.acceleratedSpeedX = locationInfo.acceleratedSpeedX;
                this.acceleratedSpeedY = locationInfo.acceleratedSpeedY;
                this.acceleratedSpeedZ = locationInfo.acceleratedSpeedZ;
                this.includedAngleYaw = locationInfo.includedAngleYaw;
                this.includedAngleRoll = locationInfo.includedAngleRoll;
                this.includedAnglePitch = locationInfo.includedAnglePitch;
                this.timestamp = locationInfo.timestamp;
                this.locType = locationInfo.locType;
            }
        }

        /* renamed from: x */
        public Builder mo93104x(Double d) {
            this.f36790x = d;
            return this;
        }

        /* renamed from: y */
        public Builder mo93105y(Double d) {
            this.f36791y = d;
            return this;
        }

        public Builder type(CoordinateType coordinateType) {
            this.type = coordinateType;
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

        public Builder acceleratedSpeedX(Float f) {
            this.acceleratedSpeedX = f;
            return this;
        }

        public Builder acceleratedSpeedY(Float f) {
            this.acceleratedSpeedY = f;
            return this;
        }

        public Builder acceleratedSpeedZ(Float f) {
            this.acceleratedSpeedZ = f;
            return this;
        }

        public Builder includedAngleYaw(Float f) {
            this.includedAngleYaw = f;
            return this;
        }

        public Builder includedAngleRoll(Float f) {
            this.includedAngleRoll = f;
            return this;
        }

        public Builder includedAnglePitch(Float f) {
            this.includedAnglePitch = f;
            return this;
        }

        public Builder timestamp(Integer num) {
            this.timestamp = num;
            return this;
        }

        public Builder locType(LocationType locationType) {
            this.locType = locationType;
            return this;
        }

        public LocationInfo build() {
            checkRequiredFields();
            return new LocationInfo(this);
        }
    }
}
