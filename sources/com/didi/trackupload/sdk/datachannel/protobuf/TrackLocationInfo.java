package com.didi.trackupload.sdk.datachannel.protobuf;

import com.sdu.didi.protobuf.MapTrackExtraMessageData;
import com.sdu.didi.protobuf.MapTrackExtraPointData;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class TrackLocationInfo extends Message {
    public static final Float DEFAULT_ACCELERATEDSPEEDX;
    public static final Float DEFAULT_ACCELERATEDSPEEDY;
    public static final Float DEFAULT_ACCELERATEDSPEEDZ;
    public static final Double DEFAULT_ACCURACY;
    public static final Float DEFAULT_ALTITUDE;
    public static final CoordinateType DEFAULT_COORDTYPE = CoordinateType.BD_09;
    public static final Double DEFAULT_DIRECTION;
    public static final Float DEFAULT_INCLUDEDANGLEPITCH;
    public static final Float DEFAULT_INCLUDEDANGLEROLL;
    public static final Float DEFAULT_INCLUDEDANGLEYAW;
    public static final Double DEFAULT_LAT;
    public static final Double DEFAULT_LNG;
    public static final LocationType DEFAULT_LOCTYPE = LocationType.LOC_GPS;
    public static final Double DEFAULT_SPEED;
    public static final Long DEFAULT_TIMESTAMP64_LOC = 0L;
    public static final Integer DEFAULT_TIMESTAMP_LOC = 0;
    public static final Integer DEFAULT_TIMESTAMP_MOBILE = 0;
    @ProtoField(tag = 11, type = Message.Datatype.FLOAT)
    public final Float acceleratedSpeedX;
    @ProtoField(tag = 12, type = Message.Datatype.FLOAT)
    public final Float acceleratedSpeedY;
    @ProtoField(tag = 13, type = Message.Datatype.FLOAT)
    public final Float acceleratedSpeedZ;
    @ProtoField(label = Message.Label.REQUIRED, tag = 5, type = Message.Datatype.DOUBLE)
    public final Double accuracy;
    @ProtoField(tag = 8, type = Message.Datatype.FLOAT)
    public final Float altitude;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.ENUM)
    public final CoordinateType coordType;
    @ProtoField(label = Message.Label.REQUIRED, tag = 6, type = Message.Datatype.DOUBLE)
    public final Double direction;
    @ProtoField(tag = 16, type = Message.Datatype.FLOAT)
    public final Float includedAnglePitch;
    @ProtoField(tag = 15, type = Message.Datatype.FLOAT)
    public final Float includedAngleRoll;
    @ProtoField(tag = 14, type = Message.Datatype.FLOAT)
    public final Float includedAngleYaw;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.DOUBLE)
    public final Double lat;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.DOUBLE)
    public final Double lng;
    @ProtoField(label = Message.Label.REQUIRED, tag = 4, type = Message.Datatype.ENUM)
    public final LocationType locType;
    public final transient MapTrackExtraMessageData map_extra_message_data;
    @ProtoField(tag = 17)
    public final MapTrackExtraPointData map_extra_point_data;
    @ProtoField(label = Message.Label.REQUIRED, tag = 7, type = Message.Datatype.DOUBLE)
    public final Double speed;
    public final transient Long timestamp64_loc;
    @ProtoField(label = Message.Label.REQUIRED, tag = 9, type = Message.Datatype.INT32)
    public final Integer timestamp_loc;
    @ProtoField(tag = 10, type = Message.Datatype.INT32)
    public final Integer timestamp_mobile;

    static {
        Double valueOf = Double.valueOf(0.0d);
        DEFAULT_LNG = valueOf;
        DEFAULT_LAT = valueOf;
        DEFAULT_ACCURACY = valueOf;
        DEFAULT_DIRECTION = valueOf;
        DEFAULT_SPEED = valueOf;
        Float valueOf2 = Float.valueOf(0.0f);
        DEFAULT_ALTITUDE = valueOf2;
        DEFAULT_ACCELERATEDSPEEDX = valueOf2;
        DEFAULT_ACCELERATEDSPEEDY = valueOf2;
        DEFAULT_ACCELERATEDSPEEDZ = valueOf2;
        DEFAULT_INCLUDEDANGLEYAW = valueOf2;
        DEFAULT_INCLUDEDANGLEROLL = valueOf2;
        DEFAULT_INCLUDEDANGLEPITCH = valueOf2;
    }

    public TrackLocationInfo(Double d, Double d2, CoordinateType coordinateType, LocationType locationType, Double d3, Double d4, Double d5, Float f, Integer num, Integer num2, Float f2, Float f3, Float f4, Float f5, Float f6, Float f7, MapTrackExtraPointData mapTrackExtraPointData, MapTrackExtraMessageData mapTrackExtraMessageData, Long l) {
        this.lng = d;
        this.lat = d2;
        this.coordType = coordinateType;
        this.locType = locationType;
        this.accuracy = d3;
        this.direction = d4;
        this.speed = d5;
        this.altitude = f;
        this.timestamp_loc = num;
        this.timestamp_mobile = num2;
        this.acceleratedSpeedX = f2;
        this.acceleratedSpeedY = f3;
        this.acceleratedSpeedZ = f4;
        this.includedAngleYaw = f5;
        this.includedAngleRoll = f6;
        this.includedAnglePitch = f7;
        this.map_extra_point_data = mapTrackExtraPointData;
        this.map_extra_message_data = mapTrackExtraMessageData;
        this.timestamp64_loc = l;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private TrackLocationInfo(com.didi.trackupload.sdk.datachannel.protobuf.TrackLocationInfo.Builder r23) {
        /*
            r22 = this;
            r0 = r23
            r1 = r22
            java.lang.Double r2 = r0.lng
            java.lang.Double r3 = r0.lat
            com.didi.trackupload.sdk.datachannel.protobuf.CoordinateType r4 = r0.coordType
            com.didi.trackupload.sdk.datachannel.protobuf.LocationType r5 = r0.locType
            java.lang.Double r6 = r0.accuracy
            java.lang.Double r7 = r0.direction
            java.lang.Double r8 = r0.speed
            java.lang.Float r9 = r0.altitude
            java.lang.Integer r10 = r0.timestamp_loc
            java.lang.Integer r11 = r0.timestamp_mobile
            java.lang.Float r12 = r0.acceleratedSpeedX
            java.lang.Float r13 = r0.acceleratedSpeedY
            java.lang.Float r14 = r0.acceleratedSpeedZ
            java.lang.Float r15 = r0.includedAngleYaw
            r21 = r1
            java.lang.Float r1 = r0.includedAngleRoll
            r16 = r1
            java.lang.Float r1 = r0.includedAnglePitch
            r17 = r1
            com.sdu.didi.protobuf.MapTrackExtraPointData r1 = r0.map_extra_point_data
            r18 = r1
            com.sdu.didi.protobuf.MapTrackExtraMessageData r1 = r0.map_extra_message_data
            r19 = r1
            java.lang.Long r1 = r0.timestamp64_loc
            r20 = r1
            r1 = r21
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            r22.setBuilder(r23)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.trackupload.sdk.datachannel.protobuf.TrackLocationInfo.<init>(com.didi.trackupload.sdk.datachannel.protobuf.TrackLocationInfo$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TrackLocationInfo)) {
            return false;
        }
        TrackLocationInfo trackLocationInfo = (TrackLocationInfo) obj;
        if (!equals((Object) this.lng, (Object) trackLocationInfo.lng) || !equals((Object) this.lat, (Object) trackLocationInfo.lat) || !equals((Object) this.coordType, (Object) trackLocationInfo.coordType) || !equals((Object) this.locType, (Object) trackLocationInfo.locType) || !equals((Object) this.accuracy, (Object) trackLocationInfo.accuracy) || !equals((Object) this.direction, (Object) trackLocationInfo.direction) || !equals((Object) this.speed, (Object) trackLocationInfo.speed) || !equals((Object) this.altitude, (Object) trackLocationInfo.altitude) || !equals((Object) this.timestamp_loc, (Object) trackLocationInfo.timestamp_loc) || !equals((Object) this.timestamp_mobile, (Object) trackLocationInfo.timestamp_mobile) || !equals((Object) this.acceleratedSpeedX, (Object) trackLocationInfo.acceleratedSpeedX) || !equals((Object) this.acceleratedSpeedY, (Object) trackLocationInfo.acceleratedSpeedY) || !equals((Object) this.acceleratedSpeedZ, (Object) trackLocationInfo.acceleratedSpeedZ) || !equals((Object) this.includedAngleYaw, (Object) trackLocationInfo.includedAngleYaw) || !equals((Object) this.includedAngleRoll, (Object) trackLocationInfo.includedAngleRoll) || !equals((Object) this.includedAnglePitch, (Object) trackLocationInfo.includedAnglePitch) || !equals((Object) this.map_extra_point_data, (Object) trackLocationInfo.map_extra_point_data) || !equals((Object) this.map_extra_message_data, (Object) trackLocationInfo.map_extra_message_data) || !equals((Object) this.timestamp64_loc, (Object) trackLocationInfo.timestamp64_loc)) {
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
        LocationType locationType = this.locType;
        int hashCode4 = (hashCode3 + (locationType != null ? locationType.hashCode() : 0)) * 37;
        Double d3 = this.accuracy;
        int hashCode5 = (hashCode4 + (d3 != null ? d3.hashCode() : 0)) * 37;
        Double d4 = this.direction;
        int hashCode6 = (hashCode5 + (d4 != null ? d4.hashCode() : 0)) * 37;
        Double d5 = this.speed;
        int hashCode7 = (hashCode6 + (d5 != null ? d5.hashCode() : 0)) * 37;
        Float f = this.altitude;
        int hashCode8 = (hashCode7 + (f != null ? f.hashCode() : 0)) * 37;
        Integer num = this.timestamp_loc;
        int hashCode9 = (hashCode8 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.timestamp_mobile;
        int hashCode10 = (hashCode9 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Float f2 = this.acceleratedSpeedX;
        int hashCode11 = (hashCode10 + (f2 != null ? f2.hashCode() : 0)) * 37;
        Float f3 = this.acceleratedSpeedY;
        int hashCode12 = (hashCode11 + (f3 != null ? f3.hashCode() : 0)) * 37;
        Float f4 = this.acceleratedSpeedZ;
        int hashCode13 = (hashCode12 + (f4 != null ? f4.hashCode() : 0)) * 37;
        Float f5 = this.includedAngleYaw;
        int hashCode14 = (hashCode13 + (f5 != null ? f5.hashCode() : 0)) * 37;
        Float f6 = this.includedAngleRoll;
        int hashCode15 = (hashCode14 + (f6 != null ? f6.hashCode() : 0)) * 37;
        Float f7 = this.includedAnglePitch;
        int hashCode16 = (hashCode15 + (f7 != null ? f7.hashCode() : 0)) * 37;
        MapTrackExtraPointData mapTrackExtraPointData = this.map_extra_point_data;
        int hashCode17 = (hashCode16 + (mapTrackExtraPointData != null ? mapTrackExtraPointData.hashCode() : 0)) * 37;
        MapTrackExtraMessageData mapTrackExtraMessageData = this.map_extra_message_data;
        int hashCode18 = (hashCode17 + (mapTrackExtraMessageData != null ? mapTrackExtraMessageData.hashCode() : 0)) * 37;
        Long l = this.timestamp64_loc;
        if (l != null) {
            i2 = l.hashCode();
        }
        int i3 = hashCode18 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<TrackLocationInfo> {
        public Float acceleratedSpeedX;
        public Float acceleratedSpeedY;
        public Float acceleratedSpeedZ;
        public Double accuracy;
        public Float altitude;
        public CoordinateType coordType;
        public Double direction;
        public Float includedAnglePitch;
        public Float includedAngleRoll;
        public Float includedAngleYaw;
        public Double lat;
        public Double lng;
        public LocationType locType;
        public MapTrackExtraMessageData map_extra_message_data;
        public MapTrackExtraPointData map_extra_point_data;
        public Double speed;
        public Long timestamp64_loc;
        public Integer timestamp_loc;
        public Integer timestamp_mobile;

        public Builder() {
        }

        public Builder(TrackLocationInfo trackLocationInfo) {
            super(trackLocationInfo);
            if (trackLocationInfo != null) {
                this.lng = trackLocationInfo.lng;
                this.lat = trackLocationInfo.lat;
                this.coordType = trackLocationInfo.coordType;
                this.locType = trackLocationInfo.locType;
                this.accuracy = trackLocationInfo.accuracy;
                this.direction = trackLocationInfo.direction;
                this.speed = trackLocationInfo.speed;
                this.altitude = trackLocationInfo.altitude;
                this.timestamp_loc = trackLocationInfo.timestamp_loc;
                this.timestamp_mobile = trackLocationInfo.timestamp_mobile;
                this.acceleratedSpeedX = trackLocationInfo.acceleratedSpeedX;
                this.acceleratedSpeedY = trackLocationInfo.acceleratedSpeedY;
                this.acceleratedSpeedZ = trackLocationInfo.acceleratedSpeedZ;
                this.includedAngleYaw = trackLocationInfo.includedAngleYaw;
                this.includedAngleRoll = trackLocationInfo.includedAngleRoll;
                this.includedAnglePitch = trackLocationInfo.includedAnglePitch;
                this.map_extra_point_data = trackLocationInfo.map_extra_point_data;
                this.map_extra_message_data = trackLocationInfo.map_extra_message_data;
                this.timestamp64_loc = trackLocationInfo.timestamp64_loc;
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

        public Builder locType(LocationType locationType) {
            this.locType = locationType;
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

        public Builder timestamp_loc(Integer num) {
            this.timestamp_loc = num;
            return this;
        }

        public Builder timestamp_mobile(Integer num) {
            this.timestamp_mobile = num;
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

        public Builder map_extra_point_data(MapTrackExtraPointData mapTrackExtraPointData) {
            this.map_extra_point_data = mapTrackExtraPointData;
            return this;
        }

        public Builder map_extra_message_data(MapTrackExtraMessageData mapTrackExtraMessageData) {
            this.map_extra_message_data = mapTrackExtraMessageData;
            return this;
        }

        public Builder timestamp64_loc(Long l) {
            this.timestamp64_loc = l;
            return this;
        }

        public TrackLocationInfo build() {
            checkRequiredFields();
            return new TrackLocationInfo(this);
        }
    }
}
