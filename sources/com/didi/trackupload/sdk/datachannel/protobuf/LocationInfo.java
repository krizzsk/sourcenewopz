package com.didi.trackupload.sdk.datachannel.protobuf;

import com.sdu.didi.protobuf.MapTrackExtraPointData;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class LocationInfo extends Message {
    public static final Float DEFAULT_ACCELERATEDSPEEDX;
    public static final Float DEFAULT_ACCELERATEDSPEEDY;
    public static final Float DEFAULT_ACCELERATEDSPEEDZ;
    public static final Double DEFAULT_ACCURACY;
    public static final Float DEFAULT_ALTITUDE;
    public static final Double DEFAULT_DIRECTION;
    public static final Float DEFAULT_INCLUDEDANGLEPITCH;
    public static final Float DEFAULT_INCLUDEDANGLEROLL;
    public static final Float DEFAULT_INCLUDEDANGLEYAW;
    public static final LocationType DEFAULT_LOCTYPE = LocationType.LOC_GPS;
    public static final Double DEFAULT_SPEED;
    public static final Integer DEFAULT_TIMESTAMP = 0;
    public static final Integer DEFAULT_TIMESTAMP_LOCAL = 0;
    public static final CoordinateType DEFAULT_TYPE = CoordinateType.BD_09;
    public static final Double DEFAULT_X;
    public static final Double DEFAULT_Y;
    @ProtoField(label = Message.Label.REQUIRED, tag = 7, type = Message.Datatype.FLOAT)
    public final Float acceleratedSpeedX;
    @ProtoField(label = Message.Label.REQUIRED, tag = 8, type = Message.Datatype.FLOAT)
    public final Float acceleratedSpeedY;
    @ProtoField(label = Message.Label.REQUIRED, tag = 9, type = Message.Datatype.FLOAT)
    public final Float acceleratedSpeedZ;
    @ProtoField(label = Message.Label.REQUIRED, tag = 4, type = Message.Datatype.DOUBLE)
    public final Double accuracy;
    @ProtoField(tag = 17, type = Message.Datatype.FLOAT)
    public final Float altitude;
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
    @ProtoField(tag = 15)
    public final MapTrackExtraPointData map_extra_point_data;
    @ProtoField(label = Message.Label.REQUIRED, tag = 6, type = Message.Datatype.DOUBLE)
    public final Double speed;
    @ProtoField(label = Message.Label.REQUIRED, tag = 13, type = Message.Datatype.INT32)
    public final Integer timestamp;
    @ProtoField(tag = 16, type = Message.Datatype.INT32)
    public final Integer timestamp_local;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.ENUM)
    public final CoordinateType type;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.DOUBLE)

    /* renamed from: x */
    public final Double f43984x;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.DOUBLE)

    /* renamed from: y */
    public final Double f43985y;

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
        DEFAULT_ALTITUDE = valueOf2;
    }

    public LocationInfo(Double d, Double d2, CoordinateType coordinateType, Double d3, Double d4, Double d5, Float f, Float f2, Float f3, Float f4, Float f5, Float f6, Integer num, LocationType locationType, MapTrackExtraPointData mapTrackExtraPointData, Integer num2, Float f7) {
        this.f43984x = d;
        this.f43985y = d2;
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
        this.map_extra_point_data = mapTrackExtraPointData;
        this.timestamp_local = num2;
        this.altitude = f7;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private LocationInfo(com.didi.trackupload.sdk.datachannel.protobuf.LocationInfo.Builder r21) {
        /*
            r20 = this;
            r0 = r21
            r1 = r20
            java.lang.Double r2 = r0.f43986x
            java.lang.Double r3 = r0.f43987y
            com.didi.trackupload.sdk.datachannel.protobuf.CoordinateType r4 = r0.type
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
            com.didi.trackupload.sdk.datachannel.protobuf.LocationType r15 = r0.locType
            r19 = r1
            com.sdu.didi.protobuf.MapTrackExtraPointData r1 = r0.map_extra_point_data
            r16 = r1
            java.lang.Integer r1 = r0.timestamp_local
            r17 = r1
            java.lang.Float r1 = r0.altitude
            r18 = r1
            r1 = r19
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            r20.setBuilder(r21)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.trackupload.sdk.datachannel.protobuf.LocationInfo.<init>(com.didi.trackupload.sdk.datachannel.protobuf.LocationInfo$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LocationInfo)) {
            return false;
        }
        LocationInfo locationInfo = (LocationInfo) obj;
        if (!equals((Object) this.f43984x, (Object) locationInfo.f43984x) || !equals((Object) this.f43985y, (Object) locationInfo.f43985y) || !equals((Object) this.type, (Object) locationInfo.type) || !equals((Object) this.accuracy, (Object) locationInfo.accuracy) || !equals((Object) this.direction, (Object) locationInfo.direction) || !equals((Object) this.speed, (Object) locationInfo.speed) || !equals((Object) this.acceleratedSpeedX, (Object) locationInfo.acceleratedSpeedX) || !equals((Object) this.acceleratedSpeedY, (Object) locationInfo.acceleratedSpeedY) || !equals((Object) this.acceleratedSpeedZ, (Object) locationInfo.acceleratedSpeedZ) || !equals((Object) this.includedAngleYaw, (Object) locationInfo.includedAngleYaw) || !equals((Object) this.includedAngleRoll, (Object) locationInfo.includedAngleRoll) || !equals((Object) this.includedAnglePitch, (Object) locationInfo.includedAnglePitch) || !equals((Object) this.timestamp, (Object) locationInfo.timestamp) || !equals((Object) this.locType, (Object) locationInfo.locType) || !equals((Object) this.map_extra_point_data, (Object) locationInfo.map_extra_point_data) || !equals((Object) this.timestamp_local, (Object) locationInfo.timestamp_local) || !equals((Object) this.altitude, (Object) locationInfo.altitude)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Double d = this.f43984x;
        int i2 = 0;
        int hashCode = (d != null ? d.hashCode() : 0) * 37;
        Double d2 = this.f43985y;
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
        int hashCode14 = (hashCode13 + (locationType != null ? locationType.hashCode() : 0)) * 37;
        MapTrackExtraPointData mapTrackExtraPointData = this.map_extra_point_data;
        int hashCode15 = (hashCode14 + (mapTrackExtraPointData != null ? mapTrackExtraPointData.hashCode() : 0)) * 37;
        Integer num2 = this.timestamp_local;
        int hashCode16 = (hashCode15 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Float f7 = this.altitude;
        if (f7 != null) {
            i2 = f7.hashCode();
        }
        int i3 = hashCode16 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<LocationInfo> {
        public Float acceleratedSpeedX;
        public Float acceleratedSpeedY;
        public Float acceleratedSpeedZ;
        public Double accuracy;
        public Float altitude;
        public Double direction;
        public Float includedAnglePitch;
        public Float includedAngleRoll;
        public Float includedAngleYaw;
        public LocationType locType;
        public MapTrackExtraPointData map_extra_point_data;
        public Double speed;
        public Integer timestamp;
        public Integer timestamp_local;
        public CoordinateType type;

        /* renamed from: x */
        public Double f43986x;

        /* renamed from: y */
        public Double f43987y;

        public Builder() {
        }

        public Builder(LocationInfo locationInfo) {
            super(locationInfo);
            if (locationInfo != null) {
                this.f43986x = locationInfo.f43984x;
                this.f43987y = locationInfo.f43985y;
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
                this.map_extra_point_data = locationInfo.map_extra_point_data;
                this.timestamp_local = locationInfo.timestamp_local;
                this.altitude = locationInfo.altitude;
            }
        }

        /* renamed from: x */
        public Builder mo109498x(Double d) {
            this.f43986x = d;
            return this;
        }

        /* renamed from: y */
        public Builder mo109499y(Double d) {
            this.f43987y = d;
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

        public Builder map_extra_point_data(MapTrackExtraPointData mapTrackExtraPointData) {
            this.map_extra_point_data = mapTrackExtraPointData;
            return this;
        }

        public Builder timestamp_local(Integer num) {
            this.timestamp_local = num;
            return this;
        }

        public Builder altitude(Float f) {
            this.altitude = f;
            return this;
        }

        public LocationInfo build() {
            checkRequiredFields();
            return new LocationInfo(this);
        }
    }
}
