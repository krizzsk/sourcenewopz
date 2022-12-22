package com.didi.trackupload.sdk.datachannel.protobuf;

import com.google.gson.annotations.SerializedName;
import com.sdu.didi.protobuf.MapTrackExtraMessageData;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class CollectSvrCoordinateReq extends Message {
    public static final Float DEFAULT_ACCELERATEDSPEEDX;
    public static final Float DEFAULT_ACCELERATEDSPEEDY;
    public static final Float DEFAULT_ACCELERATEDSPEEDZ;
    public static final Double DEFAULT_ACCURACY;
    public static final Float DEFAULT_AIR_PRESSURE;
    public static final Float DEFAULT_ALTITUDE;
    public static final Integer DEFAULT_ASSIGN_MODEL = 0;
    public static final Integer DEFAULT_BIZSTATUS = 0;
    public static final Integer DEFAULT_BIZTYPE = 0;
    public static final Integer DEFAULT_CARPOOL = 0;
    public static final Integer DEFAULT_CARPOOL_NUM = 0;
    public static final String DEFAULT_CAR_LEVELS = "";
    public static final Long DEFAULT_CAR_LEVEL_BITS = 0L;
    public static final Integer DEFAULT_CHINA_APP_OFFSET = 0;
    public static final Integer DEFAULT_CHINA_RT_OFFSET = 0;
    public static final Double DEFAULT_DIRECTION;
    public static final Integer DEFAULT_FREE_SEAT_NUM = 0;
    public static final Integer DEFAULT_GPS_LOCAL_TIME = 0;
    public static final Integer DEFAULT_GPS_SOURCE = 0;
    public static final String DEFAULT_IDC = "";
    public static final Float DEFAULT_INCLUDEDANGLEPITCH;
    public static final Float DEFAULT_INCLUDEDANGLEROLL;
    public static final Float DEFAULT_INCLUDEDANGLEYAW;
    public static final Boolean DEFAULT_IS_BILLING = false;
    public static final Double DEFAULT_LAT;
    public static final Integer DEFAULT_LISTEN_STATUS = 0;
    public static final Double DEFAULT_LNG;
    public static final Long DEFAULT_LOCAL_TIME64_GPS = 0L;
    public static final Long DEFAULT_LOCAL_TIME64_MOBILE = 0L;
    public static final Integer DEFAULT_LOCATE_TIME = 0;
    public static final Integer DEFAULT_LOCATION_UTC_OFFSET = 0;
    public static final String DEFAULT_LOCATION_VDR = "";
    public static final String DEFAULT_NAVI_TYPE = "";
    public static final Integer DEFAULT_ORDER_BIZTYPE = 0;
    public static final String DEFAULT_ORDER_ID = "";
    public static final Integer DEFAULT_ORDER_STATUS = 0;
    public static final Integer DEFAULT_OS_UTC_OFFSET = 0;
    public static final String DEFAULT_PHONE = "";
    public static final Double DEFAULT_PRE_LAT;
    public static final Double DEFAULT_PRE_LNG;
    public static final Boolean DEFAULT_PULL_PEER = false;
    public static final String DEFAULT_REQUIRE_LEVELS = "";
    public static final Long DEFAULT_REQUIRE_LEVEL_BITS = 0L;
    public static final Integer DEFAULT_ROLE = 0;
    public static final Integer DEFAULT_RT_STATUS = 0;
    public static final Double DEFAULT_SPEED;
    public static final Integer DEFAULT_STATE = 0;
    public static final Integer DEFAULT_STATE_EXT = 0;
    public static final CoordinateType DEFAULT_TYPE = CoordinateType.BD_09;
    public static final Long DEFAULT_USER_ID = 0L;
    public static final Integer DEFAULT_UTC_OFFSET = 0;
    @SerializedName("acceleratedSpeedX")
    @ProtoField(tag = 8, type = Message.Datatype.FLOAT)
    public final Float acceleratedSpeedX;
    @SerializedName("acceleratedSpeedY")
    @ProtoField(tag = 9, type = Message.Datatype.FLOAT)
    public final Float acceleratedSpeedY;
    @SerializedName("acceleratedSpeedZ")
    @ProtoField(tag = 10, type = Message.Datatype.FLOAT)
    public final Float acceleratedSpeedZ;
    @SerializedName("accuracy")
    @ProtoField(tag = 5, type = Message.Datatype.DOUBLE)
    public final Double accuracy;
    @SerializedName("air_pressure")
    @ProtoField(tag = 30, type = Message.Datatype.FLOAT)
    public final Float air_pressure;
    @SerializedName("altitude")
    @ProtoField(tag = 28, type = Message.Datatype.FLOAT)
    public final Float altitude;
    @SerializedName("assign_model")
    @ProtoField(tag = 29, type = Message.Datatype.UINT32)
    public final Integer assign_model;
    @SerializedName("bizstatus")
    @ProtoField(tag = 23, type = Message.Datatype.UINT32)
    public final Integer bizstatus;
    @SerializedName("biztype")
    @ProtoField(tag = 20, type = Message.Datatype.UINT32)
    public final Integer biztype;
    @SerializedName("car_level_bits")
    @ProtoField(tag = 46, type = Message.Datatype.UINT64)
    public final Long car_level_bits;
    @SerializedName("car_levels")
    @ProtoField(tag = 47, type = Message.Datatype.STRING)
    public final String car_levels;
    @SerializedName("carpool")
    @ProtoField(tag = 32, type = Message.Datatype.UINT32)
    public final Integer carpool;
    @SerializedName("carpool_num")
    @ProtoField(tag = 35, type = Message.Datatype.UINT32)
    public final Integer carpool_num;
    @SerializedName("china_app_offset")
    @ProtoField(tag = 40, type = Message.Datatype.INT32)
    public final Integer china_app_offset;
    @SerializedName("china_rt_offset")
    @ProtoField(tag = 41, type = Message.Datatype.INT32)
    public final Integer china_rt_offset;
    @SerializedName("city")
    @ProtoField(tag = 31)
    public final City city;
    @SerializedName("direction")
    @ProtoField(tag = 6, type = Message.Datatype.DOUBLE)
    public final Double direction;
    @SerializedName("free_seat_num")
    @ProtoField(tag = 33, type = Message.Datatype.UINT32)
    public final Integer free_seat_num;
    @SerializedName("gps_local_time")
    @ProtoField(tag = 34, type = Message.Datatype.UINT32)
    public final Integer gps_local_time;
    @SerializedName("gps_source")
    @ProtoField(tag = 18, type = Message.Datatype.UINT32)
    public final Integer gps_source;
    @SerializedName("idc")
    @ProtoField(tag = 51, type = Message.Datatype.STRING)
    public final String idc;
    @SerializedName("includedAnglePitch")
    @ProtoField(tag = 13, type = Message.Datatype.FLOAT)
    public final Float includedAnglePitch;
    @SerializedName("includedAngleRoll")
    @ProtoField(tag = 12, type = Message.Datatype.FLOAT)
    public final Float includedAngleRoll;
    @SerializedName("includedAngleYaw")
    @ProtoField(tag = 11, type = Message.Datatype.FLOAT)
    public final Float includedAngleYaw;
    @SerializedName("is_billing")
    @ProtoField(tag = 42, type = Message.Datatype.BOOL)
    public final Boolean is_billing;
    @SerializedName("lat")
    @ProtoField(tag = 3, type = Message.Datatype.DOUBLE)
    public final Double lat;
    @SerializedName("listen_status")
    @ProtoField(tag = 25, type = Message.Datatype.UINT32)
    public final Integer listen_status;
    @SerializedName("lng")
    @ProtoField(tag = 2, type = Message.Datatype.DOUBLE)
    public final Double lng;
    @SerializedName("local_time64_gps")
    @ProtoField(tag = 38, type = Message.Datatype.UINT64)
    public final Long local_time64_gps;
    @SerializedName("local_time64_mobile")
    @ProtoField(tag = 37, type = Message.Datatype.UINT64)
    public final Long local_time64_mobile;
    @SerializedName("locate_time")
    @ProtoField(tag = 24, type = Message.Datatype.UINT32)
    public final Integer locate_time;
    @SerializedName("location_utc_offset")
    @ProtoField(tag = 44, type = Message.Datatype.INT32)
    public final Integer location_utc_offset;
    @SerializedName("location_vdr")
    @ProtoField(tag = 50, type = Message.Datatype.STRING)
    public final String location_vdr;
    @SerializedName("map_extra_message_data")
    @ProtoField(tag = 55)
    public final MapTrackExtraMessageData map_extra_message_data;
    @SerializedName("navi_type")
    @ProtoField(tag = 26, type = Message.Datatype.STRING)
    public final String navi_type;
    @SerializedName("order_biztype")
    @ProtoField(tag = 36, type = Message.Datatype.UINT32)
    public final Integer order_biztype;
    @SerializedName("order_id")
    @ProtoField(tag = 54, type = Message.Datatype.STRING)
    public final String order_id;
    @SerializedName("order_status")
    @ProtoField(tag = 53, type = Message.Datatype.INT32)
    public final Integer order_status;
    @SerializedName("os_utc_offset")
    @ProtoField(tag = 45, type = Message.Datatype.INT32)
    public final Integer os_utc_offset;
    @SerializedName("phone")
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String phone;
    @SerializedName("plutus_data")
    @ProtoField(tag = 43)
    public final DriverOrderMoneyGetReqV2 plutus_data;
    @SerializedName("pre_lat")
    @ProtoField(tag = 16, type = Message.Datatype.DOUBLE)
    public final Double pre_lat;
    @SerializedName("pre_lng")
    @ProtoField(tag = 15, type = Message.Datatype.DOUBLE)
    public final Double pre_lng;
    @SerializedName("pull_peer")
    @ProtoField(tag = 14, type = Message.Datatype.BOOL)
    public final Boolean pull_peer;
    @SerializedName("require_level_bits")
    @ProtoField(tag = 48, type = Message.Datatype.UINT64)
    public final Long require_level_bits;
    @SerializedName("require_levels")
    @ProtoField(tag = 49, type = Message.Datatype.STRING)
    public final String require_levels;
    @SerializedName("rlab_trip_data")
    @ProtoField(tag = 52)
    public final RlabTripData rlab_trip_data;
    @SerializedName("role")
    @ProtoField(tag = 21, type = Message.Datatype.UINT32)
    public final Integer role;
    @SerializedName("rt_status")
    @ProtoField(tag = 27, type = Message.Datatype.UINT32)
    public final Integer rt_status;
    @SerializedName("speed")
    @ProtoField(tag = 7, type = Message.Datatype.DOUBLE)
    public final Double speed;
    @SerializedName("state")
    @ProtoField(tag = 17, type = Message.Datatype.UINT32)
    public final Integer state;
    @SerializedName("state_ext")
    @ProtoField(tag = 19, type = Message.Datatype.INT32)
    public final Integer state_ext;
    @SerializedName("type")
    @ProtoField(tag = 4, type = Message.Datatype.ENUM)
    public final CoordinateType type;
    @SerializedName("user_id")
    @ProtoField(tag = 22, type = Message.Datatype.UINT64)
    public final Long user_id;
    @SerializedName("utc_offset")
    @ProtoField(tag = 39, type = Message.Datatype.INT32)
    public final Integer utc_offset;

    static {
        Double valueOf = Double.valueOf(0.0d);
        DEFAULT_LNG = valueOf;
        DEFAULT_LAT = valueOf;
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
        DEFAULT_PRE_LNG = valueOf;
        DEFAULT_PRE_LAT = valueOf;
        DEFAULT_ALTITUDE = valueOf2;
        DEFAULT_AIR_PRESSURE = valueOf2;
    }

    public CollectSvrCoordinateReq(String str, Double d, Double d2, CoordinateType coordinateType, Double d3, Double d4, Double d5, Float f, Float f2, Float f3, Float f4, Float f5, Float f6, Boolean bool, Double d6, Double d7, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Long l, Integer num6, Integer num7, Integer num8, String str2, Integer num9, Float f7, Integer num10, Float f8, City city2, Integer num11, Integer num12, Integer num13, Integer num14, Integer num15, Long l2, Long l3, Integer num16, Integer num17, Integer num18, Boolean bool2, DriverOrderMoneyGetReqV2 driverOrderMoneyGetReqV2, Integer num19, Integer num20, Long l4, String str3, Long l5, String str4, String str5, String str6, RlabTripData rlabTripData, Integer num21, String str7, MapTrackExtraMessageData mapTrackExtraMessageData) {
        this.phone = str;
        this.lng = d;
        this.lat = d2;
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
        this.pull_peer = bool;
        this.pre_lng = d6;
        this.pre_lat = d7;
        this.state = num;
        this.gps_source = num2;
        this.state_ext = num3;
        this.biztype = num4;
        this.role = num5;
        this.user_id = l;
        this.bizstatus = num6;
        this.locate_time = num7;
        this.listen_status = num8;
        this.navi_type = str2;
        this.rt_status = num9;
        this.altitude = f7;
        this.assign_model = num10;
        this.air_pressure = f8;
        this.city = city2;
        this.carpool = num11;
        this.free_seat_num = num12;
        this.gps_local_time = num13;
        this.carpool_num = num14;
        this.order_biztype = num15;
        this.local_time64_mobile = l2;
        this.local_time64_gps = l3;
        this.utc_offset = num16;
        this.china_app_offset = num17;
        this.china_rt_offset = num18;
        this.is_billing = bool2;
        this.plutus_data = driverOrderMoneyGetReqV2;
        this.location_utc_offset = num19;
        this.os_utc_offset = num20;
        this.car_level_bits = l4;
        this.car_levels = str3;
        this.require_level_bits = l5;
        this.require_levels = str4;
        this.location_vdr = str5;
        this.idc = str6;
        this.rlab_trip_data = rlabTripData;
        this.order_status = num21;
        this.order_id = str7;
        this.map_extra_message_data = mapTrackExtraMessageData;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private CollectSvrCoordinateReq(com.didi.trackupload.sdk.datachannel.protobuf.CollectSvrCoordinateReq.Builder r59) {
        /*
            r58 = this;
            r0 = r59
            r1 = r58
            java.lang.String r2 = r0.phone
            java.lang.Double r3 = r0.lng
            java.lang.Double r4 = r0.lat
            com.didi.trackupload.sdk.datachannel.protobuf.CoordinateType r5 = r0.type
            java.lang.Double r6 = r0.accuracy
            java.lang.Double r7 = r0.direction
            java.lang.Double r8 = r0.speed
            java.lang.Float r9 = r0.acceleratedSpeedX
            java.lang.Float r10 = r0.acceleratedSpeedY
            java.lang.Float r11 = r0.acceleratedSpeedZ
            java.lang.Float r12 = r0.includedAngleYaw
            java.lang.Float r13 = r0.includedAngleRoll
            java.lang.Float r14 = r0.includedAnglePitch
            java.lang.Boolean r15 = r0.pull_peer
            r57 = r1
            java.lang.Double r1 = r0.pre_lng
            r16 = r1
            java.lang.Double r1 = r0.pre_lat
            r17 = r1
            java.lang.Integer r1 = r0.state
            r18 = r1
            java.lang.Integer r1 = r0.gps_source
            r19 = r1
            java.lang.Integer r1 = r0.state_ext
            r20 = r1
            java.lang.Integer r1 = r0.biztype
            r21 = r1
            java.lang.Integer r1 = r0.role
            r22 = r1
            java.lang.Long r1 = r0.user_id
            r23 = r1
            java.lang.Integer r1 = r0.bizstatus
            r24 = r1
            java.lang.Integer r1 = r0.locate_time
            r25 = r1
            java.lang.Integer r1 = r0.listen_status
            r26 = r1
            java.lang.String r1 = r0.navi_type
            r27 = r1
            java.lang.Integer r1 = r0.rt_status
            r28 = r1
            java.lang.Float r1 = r0.altitude
            r29 = r1
            java.lang.Integer r1 = r0.assign_model
            r30 = r1
            java.lang.Float r1 = r0.air_pressure
            r31 = r1
            com.didi.trackupload.sdk.datachannel.protobuf.City r1 = r0.city
            r32 = r1
            java.lang.Integer r1 = r0.carpool
            r33 = r1
            java.lang.Integer r1 = r0.free_seat_num
            r34 = r1
            java.lang.Integer r1 = r0.gps_local_time
            r35 = r1
            java.lang.Integer r1 = r0.carpool_num
            r36 = r1
            java.lang.Integer r1 = r0.order_biztype
            r37 = r1
            java.lang.Long r1 = r0.local_time64_mobile
            r38 = r1
            java.lang.Long r1 = r0.local_time64_gps
            r39 = r1
            java.lang.Integer r1 = r0.utc_offset
            r40 = r1
            java.lang.Integer r1 = r0.china_app_offset
            r41 = r1
            java.lang.Integer r1 = r0.china_rt_offset
            r42 = r1
            java.lang.Boolean r1 = r0.is_billing
            r43 = r1
            com.didi.trackupload.sdk.datachannel.protobuf.DriverOrderMoneyGetReqV2 r1 = r0.plutus_data
            r44 = r1
            java.lang.Integer r1 = r0.location_utc_offset
            r45 = r1
            java.lang.Integer r1 = r0.os_utc_offset
            r46 = r1
            java.lang.Long r1 = r0.car_level_bits
            r47 = r1
            java.lang.String r1 = r0.car_levels
            r48 = r1
            java.lang.Long r1 = r0.require_level_bits
            r49 = r1
            java.lang.String r1 = r0.require_levels
            r50 = r1
            java.lang.String r1 = r0.location_vdr
            r51 = r1
            java.lang.String r1 = r0.idc
            r52 = r1
            com.didi.trackupload.sdk.datachannel.protobuf.RlabTripData r1 = r0.rlab_trip_data
            r53 = r1
            java.lang.Integer r1 = r0.order_status
            r54 = r1
            java.lang.String r1 = r0.order_id
            r55 = r1
            com.sdu.didi.protobuf.MapTrackExtraMessageData r1 = r0.map_extra_message_data
            r56 = r1
            r1 = r57
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56)
            r58.setBuilder(r59)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.trackupload.sdk.datachannel.protobuf.CollectSvrCoordinateReq.<init>(com.didi.trackupload.sdk.datachannel.protobuf.CollectSvrCoordinateReq$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CollectSvrCoordinateReq)) {
            return false;
        }
        CollectSvrCoordinateReq collectSvrCoordinateReq = (CollectSvrCoordinateReq) obj;
        if (!equals((Object) this.phone, (Object) collectSvrCoordinateReq.phone) || !equals((Object) this.lng, (Object) collectSvrCoordinateReq.lng) || !equals((Object) this.lat, (Object) collectSvrCoordinateReq.lat) || !equals((Object) this.type, (Object) collectSvrCoordinateReq.type) || !equals((Object) this.accuracy, (Object) collectSvrCoordinateReq.accuracy) || !equals((Object) this.direction, (Object) collectSvrCoordinateReq.direction) || !equals((Object) this.speed, (Object) collectSvrCoordinateReq.speed) || !equals((Object) this.acceleratedSpeedX, (Object) collectSvrCoordinateReq.acceleratedSpeedX) || !equals((Object) this.acceleratedSpeedY, (Object) collectSvrCoordinateReq.acceleratedSpeedY) || !equals((Object) this.acceleratedSpeedZ, (Object) collectSvrCoordinateReq.acceleratedSpeedZ) || !equals((Object) this.includedAngleYaw, (Object) collectSvrCoordinateReq.includedAngleYaw) || !equals((Object) this.includedAngleRoll, (Object) collectSvrCoordinateReq.includedAngleRoll) || !equals((Object) this.includedAnglePitch, (Object) collectSvrCoordinateReq.includedAnglePitch) || !equals((Object) this.pull_peer, (Object) collectSvrCoordinateReq.pull_peer) || !equals((Object) this.pre_lng, (Object) collectSvrCoordinateReq.pre_lng) || !equals((Object) this.pre_lat, (Object) collectSvrCoordinateReq.pre_lat) || !equals((Object) this.state, (Object) collectSvrCoordinateReq.state) || !equals((Object) this.gps_source, (Object) collectSvrCoordinateReq.gps_source) || !equals((Object) this.state_ext, (Object) collectSvrCoordinateReq.state_ext) || !equals((Object) this.biztype, (Object) collectSvrCoordinateReq.biztype) || !equals((Object) this.role, (Object) collectSvrCoordinateReq.role) || !equals((Object) this.user_id, (Object) collectSvrCoordinateReq.user_id) || !equals((Object) this.bizstatus, (Object) collectSvrCoordinateReq.bizstatus) || !equals((Object) this.locate_time, (Object) collectSvrCoordinateReq.locate_time) || !equals((Object) this.listen_status, (Object) collectSvrCoordinateReq.listen_status) || !equals((Object) this.navi_type, (Object) collectSvrCoordinateReq.navi_type) || !equals((Object) this.rt_status, (Object) collectSvrCoordinateReq.rt_status) || !equals((Object) this.altitude, (Object) collectSvrCoordinateReq.altitude) || !equals((Object) this.assign_model, (Object) collectSvrCoordinateReq.assign_model) || !equals((Object) this.air_pressure, (Object) collectSvrCoordinateReq.air_pressure) || !equals((Object) this.city, (Object) collectSvrCoordinateReq.city) || !equals((Object) this.carpool, (Object) collectSvrCoordinateReq.carpool) || !equals((Object) this.free_seat_num, (Object) collectSvrCoordinateReq.free_seat_num) || !equals((Object) this.gps_local_time, (Object) collectSvrCoordinateReq.gps_local_time) || !equals((Object) this.carpool_num, (Object) collectSvrCoordinateReq.carpool_num) || !equals((Object) this.order_biztype, (Object) collectSvrCoordinateReq.order_biztype) || !equals((Object) this.local_time64_mobile, (Object) collectSvrCoordinateReq.local_time64_mobile) || !equals((Object) this.local_time64_gps, (Object) collectSvrCoordinateReq.local_time64_gps) || !equals((Object) this.utc_offset, (Object) collectSvrCoordinateReq.utc_offset) || !equals((Object) this.china_app_offset, (Object) collectSvrCoordinateReq.china_app_offset) || !equals((Object) this.china_rt_offset, (Object) collectSvrCoordinateReq.china_rt_offset) || !equals((Object) this.is_billing, (Object) collectSvrCoordinateReq.is_billing) || !equals((Object) this.plutus_data, (Object) collectSvrCoordinateReq.plutus_data) || !equals((Object) this.location_utc_offset, (Object) collectSvrCoordinateReq.location_utc_offset) || !equals((Object) this.os_utc_offset, (Object) collectSvrCoordinateReq.os_utc_offset) || !equals((Object) this.car_level_bits, (Object) collectSvrCoordinateReq.car_level_bits) || !equals((Object) this.car_levels, (Object) collectSvrCoordinateReq.car_levels) || !equals((Object) this.require_level_bits, (Object) collectSvrCoordinateReq.require_level_bits) || !equals((Object) this.require_levels, (Object) collectSvrCoordinateReq.require_levels) || !equals((Object) this.location_vdr, (Object) collectSvrCoordinateReq.location_vdr) || !equals((Object) this.idc, (Object) collectSvrCoordinateReq.idc) || !equals((Object) this.rlab_trip_data, (Object) collectSvrCoordinateReq.rlab_trip_data) || !equals((Object) this.order_status, (Object) collectSvrCoordinateReq.order_status) || !equals((Object) this.order_id, (Object) collectSvrCoordinateReq.order_id) || !equals((Object) this.map_extra_message_data, (Object) collectSvrCoordinateReq.map_extra_message_data)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.phone;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        Double d = this.lng;
        int hashCode2 = (hashCode + (d != null ? d.hashCode() : 0)) * 37;
        Double d2 = this.lat;
        int hashCode3 = (hashCode2 + (d2 != null ? d2.hashCode() : 0)) * 37;
        CoordinateType coordinateType = this.type;
        int hashCode4 = (hashCode3 + (coordinateType != null ? coordinateType.hashCode() : 0)) * 37;
        Double d3 = this.accuracy;
        int hashCode5 = (hashCode4 + (d3 != null ? d3.hashCode() : 0)) * 37;
        Double d4 = this.direction;
        int hashCode6 = (hashCode5 + (d4 != null ? d4.hashCode() : 0)) * 37;
        Double d5 = this.speed;
        int hashCode7 = (hashCode6 + (d5 != null ? d5.hashCode() : 0)) * 37;
        Float f = this.acceleratedSpeedX;
        int hashCode8 = (hashCode7 + (f != null ? f.hashCode() : 0)) * 37;
        Float f2 = this.acceleratedSpeedY;
        int hashCode9 = (hashCode8 + (f2 != null ? f2.hashCode() : 0)) * 37;
        Float f3 = this.acceleratedSpeedZ;
        int hashCode10 = (hashCode9 + (f3 != null ? f3.hashCode() : 0)) * 37;
        Float f4 = this.includedAngleYaw;
        int hashCode11 = (hashCode10 + (f4 != null ? f4.hashCode() : 0)) * 37;
        Float f5 = this.includedAngleRoll;
        int hashCode12 = (hashCode11 + (f5 != null ? f5.hashCode() : 0)) * 37;
        Float f6 = this.includedAnglePitch;
        int hashCode13 = (hashCode12 + (f6 != null ? f6.hashCode() : 0)) * 37;
        Boolean bool = this.pull_peer;
        int hashCode14 = (hashCode13 + (bool != null ? bool.hashCode() : 0)) * 37;
        Double d6 = this.pre_lng;
        int hashCode15 = (hashCode14 + (d6 != null ? d6.hashCode() : 0)) * 37;
        Double d7 = this.pre_lat;
        int hashCode16 = (hashCode15 + (d7 != null ? d7.hashCode() : 0)) * 37;
        Integer num = this.state;
        int hashCode17 = (hashCode16 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.gps_source;
        int hashCode18 = (hashCode17 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.state_ext;
        int hashCode19 = (hashCode18 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.biztype;
        int hashCode20 = (hashCode19 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.role;
        int hashCode21 = (hashCode20 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Long l = this.user_id;
        int hashCode22 = (hashCode21 + (l != null ? l.hashCode() : 0)) * 37;
        Integer num6 = this.bizstatus;
        int hashCode23 = (hashCode22 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Integer num7 = this.locate_time;
        int hashCode24 = (hashCode23 + (num7 != null ? num7.hashCode() : 0)) * 37;
        Integer num8 = this.listen_status;
        int hashCode25 = (hashCode24 + (num8 != null ? num8.hashCode() : 0)) * 37;
        String str2 = this.navi_type;
        int hashCode26 = (hashCode25 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num9 = this.rt_status;
        int hashCode27 = (hashCode26 + (num9 != null ? num9.hashCode() : 0)) * 37;
        Float f7 = this.altitude;
        int hashCode28 = (hashCode27 + (f7 != null ? f7.hashCode() : 0)) * 37;
        Integer num10 = this.assign_model;
        int hashCode29 = (hashCode28 + (num10 != null ? num10.hashCode() : 0)) * 37;
        Float f8 = this.air_pressure;
        int hashCode30 = (hashCode29 + (f8 != null ? f8.hashCode() : 0)) * 37;
        City city2 = this.city;
        int hashCode31 = (hashCode30 + (city2 != null ? city2.hashCode() : 0)) * 37;
        Integer num11 = this.carpool;
        int hashCode32 = (hashCode31 + (num11 != null ? num11.hashCode() : 0)) * 37;
        Integer num12 = this.free_seat_num;
        int hashCode33 = (hashCode32 + (num12 != null ? num12.hashCode() : 0)) * 37;
        Integer num13 = this.gps_local_time;
        int hashCode34 = (hashCode33 + (num13 != null ? num13.hashCode() : 0)) * 37;
        Integer num14 = this.carpool_num;
        int hashCode35 = (hashCode34 + (num14 != null ? num14.hashCode() : 0)) * 37;
        Integer num15 = this.order_biztype;
        int hashCode36 = (hashCode35 + (num15 != null ? num15.hashCode() : 0)) * 37;
        Long l2 = this.local_time64_mobile;
        int hashCode37 = (hashCode36 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.local_time64_gps;
        int hashCode38 = (hashCode37 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Integer num16 = this.utc_offset;
        int hashCode39 = (hashCode38 + (num16 != null ? num16.hashCode() : 0)) * 37;
        Integer num17 = this.china_app_offset;
        int hashCode40 = (hashCode39 + (num17 != null ? num17.hashCode() : 0)) * 37;
        Integer num18 = this.china_rt_offset;
        int hashCode41 = (hashCode40 + (num18 != null ? num18.hashCode() : 0)) * 37;
        Boolean bool2 = this.is_billing;
        int hashCode42 = (hashCode41 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        DriverOrderMoneyGetReqV2 driverOrderMoneyGetReqV2 = this.plutus_data;
        int hashCode43 = (hashCode42 + (driverOrderMoneyGetReqV2 != null ? driverOrderMoneyGetReqV2.hashCode() : 0)) * 37;
        Integer num19 = this.location_utc_offset;
        int hashCode44 = (hashCode43 + (num19 != null ? num19.hashCode() : 0)) * 37;
        Integer num20 = this.os_utc_offset;
        int hashCode45 = (hashCode44 + (num20 != null ? num20.hashCode() : 0)) * 37;
        Long l4 = this.car_level_bits;
        int hashCode46 = (hashCode45 + (l4 != null ? l4.hashCode() : 0)) * 37;
        String str3 = this.car_levels;
        int hashCode47 = (hashCode46 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Long l5 = this.require_level_bits;
        int hashCode48 = (hashCode47 + (l5 != null ? l5.hashCode() : 0)) * 37;
        String str4 = this.require_levels;
        int hashCode49 = (hashCode48 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.location_vdr;
        int hashCode50 = (hashCode49 + (str5 != null ? str5.hashCode() : 0)) * 37;
        String str6 = this.idc;
        int hashCode51 = (hashCode50 + (str6 != null ? str6.hashCode() : 0)) * 37;
        RlabTripData rlabTripData = this.rlab_trip_data;
        int hashCode52 = (hashCode51 + (rlabTripData != null ? rlabTripData.hashCode() : 0)) * 37;
        Integer num21 = this.order_status;
        int hashCode53 = (hashCode52 + (num21 != null ? num21.hashCode() : 0)) * 37;
        String str7 = this.order_id;
        int hashCode54 = (hashCode53 + (str7 != null ? str7.hashCode() : 0)) * 37;
        MapTrackExtraMessageData mapTrackExtraMessageData = this.map_extra_message_data;
        if (mapTrackExtraMessageData != null) {
            i2 = mapTrackExtraMessageData.hashCode();
        }
        int i3 = hashCode54 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<CollectSvrCoordinateReq> {
        public Float acceleratedSpeedX;
        public Float acceleratedSpeedY;
        public Float acceleratedSpeedZ;
        public Double accuracy;
        public Float air_pressure;
        public Float altitude;
        public Integer assign_model;
        public Integer bizstatus;
        public Integer biztype;
        public Long car_level_bits;
        public String car_levels;
        public Integer carpool;
        public Integer carpool_num;
        public Integer china_app_offset;
        public Integer china_rt_offset;
        public City city;
        public Double direction;
        public Integer free_seat_num;
        public Integer gps_local_time;
        public Integer gps_source;
        public String idc;
        public Float includedAnglePitch;
        public Float includedAngleRoll;
        public Float includedAngleYaw;
        public Boolean is_billing;
        public Double lat;
        public Integer listen_status;
        public Double lng;
        public Long local_time64_gps;
        public Long local_time64_mobile;
        public Integer locate_time;
        public Integer location_utc_offset;
        public String location_vdr;
        public MapTrackExtraMessageData map_extra_message_data;
        public String navi_type;
        public Integer order_biztype;
        public String order_id;
        public Integer order_status;
        public Integer os_utc_offset;
        public String phone;
        public DriverOrderMoneyGetReqV2 plutus_data;
        public Double pre_lat;
        public Double pre_lng;
        public Boolean pull_peer;
        public Long require_level_bits;
        public String require_levels;
        public RlabTripData rlab_trip_data;
        public Integer role;
        public Integer rt_status;
        public Double speed;
        public Integer state;
        public Integer state_ext;
        public CoordinateType type;
        public Long user_id;
        public Integer utc_offset;

        public Builder() {
        }

        public Builder(CollectSvrCoordinateReq collectSvrCoordinateReq) {
            super(collectSvrCoordinateReq);
            if (collectSvrCoordinateReq != null) {
                this.phone = collectSvrCoordinateReq.phone;
                this.lng = collectSvrCoordinateReq.lng;
                this.lat = collectSvrCoordinateReq.lat;
                this.type = collectSvrCoordinateReq.type;
                this.accuracy = collectSvrCoordinateReq.accuracy;
                this.direction = collectSvrCoordinateReq.direction;
                this.speed = collectSvrCoordinateReq.speed;
                this.acceleratedSpeedX = collectSvrCoordinateReq.acceleratedSpeedX;
                this.acceleratedSpeedY = collectSvrCoordinateReq.acceleratedSpeedY;
                this.acceleratedSpeedZ = collectSvrCoordinateReq.acceleratedSpeedZ;
                this.includedAngleYaw = collectSvrCoordinateReq.includedAngleYaw;
                this.includedAngleRoll = collectSvrCoordinateReq.includedAngleRoll;
                this.includedAnglePitch = collectSvrCoordinateReq.includedAnglePitch;
                this.pull_peer = collectSvrCoordinateReq.pull_peer;
                this.pre_lng = collectSvrCoordinateReq.pre_lng;
                this.pre_lat = collectSvrCoordinateReq.pre_lat;
                this.state = collectSvrCoordinateReq.state;
                this.gps_source = collectSvrCoordinateReq.gps_source;
                this.state_ext = collectSvrCoordinateReq.state_ext;
                this.biztype = collectSvrCoordinateReq.biztype;
                this.role = collectSvrCoordinateReq.role;
                this.user_id = collectSvrCoordinateReq.user_id;
                this.bizstatus = collectSvrCoordinateReq.bizstatus;
                this.locate_time = collectSvrCoordinateReq.locate_time;
                this.listen_status = collectSvrCoordinateReq.listen_status;
                this.navi_type = collectSvrCoordinateReq.navi_type;
                this.rt_status = collectSvrCoordinateReq.rt_status;
                this.altitude = collectSvrCoordinateReq.altitude;
                this.assign_model = collectSvrCoordinateReq.assign_model;
                this.air_pressure = collectSvrCoordinateReq.air_pressure;
                this.city = collectSvrCoordinateReq.city;
                this.carpool = collectSvrCoordinateReq.carpool;
                this.free_seat_num = collectSvrCoordinateReq.free_seat_num;
                this.gps_local_time = collectSvrCoordinateReq.gps_local_time;
                this.carpool_num = collectSvrCoordinateReq.carpool_num;
                this.order_biztype = collectSvrCoordinateReq.order_biztype;
                this.local_time64_mobile = collectSvrCoordinateReq.local_time64_mobile;
                this.local_time64_gps = collectSvrCoordinateReq.local_time64_gps;
                this.utc_offset = collectSvrCoordinateReq.utc_offset;
                this.china_app_offset = collectSvrCoordinateReq.china_app_offset;
                this.china_rt_offset = collectSvrCoordinateReq.china_rt_offset;
                this.is_billing = collectSvrCoordinateReq.is_billing;
                this.plutus_data = collectSvrCoordinateReq.plutus_data;
                this.location_utc_offset = collectSvrCoordinateReq.location_utc_offset;
                this.os_utc_offset = collectSvrCoordinateReq.os_utc_offset;
                this.car_level_bits = collectSvrCoordinateReq.car_level_bits;
                this.car_levels = collectSvrCoordinateReq.car_levels;
                this.require_level_bits = collectSvrCoordinateReq.require_level_bits;
                this.require_levels = collectSvrCoordinateReq.require_levels;
                this.location_vdr = collectSvrCoordinateReq.location_vdr;
                this.idc = collectSvrCoordinateReq.idc;
                this.rlab_trip_data = collectSvrCoordinateReq.rlab_trip_data;
                this.order_status = collectSvrCoordinateReq.order_status;
                this.order_id = collectSvrCoordinateReq.order_id;
                this.map_extra_message_data = collectSvrCoordinateReq.map_extra_message_data;
            }
        }

        public Builder phone(String str) {
            this.phone = str;
            return this;
        }

        public Builder lng(Double d) {
            this.lng = d;
            return this;
        }

        public Builder lat(Double d) {
            this.lat = d;
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

        public Builder pull_peer(Boolean bool) {
            this.pull_peer = bool;
            return this;
        }

        public Builder pre_lng(Double d) {
            this.pre_lng = d;
            return this;
        }

        public Builder pre_lat(Double d) {
            this.pre_lat = d;
            return this;
        }

        public Builder state(Integer num) {
            this.state = num;
            return this;
        }

        public Builder gps_source(Integer num) {
            this.gps_source = num;
            return this;
        }

        public Builder state_ext(Integer num) {
            this.state_ext = num;
            return this;
        }

        public Builder biztype(Integer num) {
            this.biztype = num;
            return this;
        }

        public Builder role(Integer num) {
            this.role = num;
            return this;
        }

        public Builder user_id(Long l) {
            this.user_id = l;
            return this;
        }

        public Builder bizstatus(Integer num) {
            this.bizstatus = num;
            return this;
        }

        public Builder locate_time(Integer num) {
            this.locate_time = num;
            return this;
        }

        public Builder listen_status(Integer num) {
            this.listen_status = num;
            return this;
        }

        public Builder navi_type(String str) {
            this.navi_type = str;
            return this;
        }

        public Builder rt_status(Integer num) {
            this.rt_status = num;
            return this;
        }

        public Builder altitude(Float f) {
            this.altitude = f;
            return this;
        }

        public Builder assign_model(Integer num) {
            this.assign_model = num;
            return this;
        }

        public Builder air_pressure(Float f) {
            this.air_pressure = f;
            return this;
        }

        public Builder city(City city2) {
            this.city = city2;
            return this;
        }

        public Builder carpool(Integer num) {
            this.carpool = num;
            return this;
        }

        public Builder free_seat_num(Integer num) {
            this.free_seat_num = num;
            return this;
        }

        public Builder gps_local_time(Integer num) {
            this.gps_local_time = num;
            return this;
        }

        public Builder carpool_num(Integer num) {
            this.carpool_num = num;
            return this;
        }

        public Builder order_biztype(Integer num) {
            this.order_biztype = num;
            return this;
        }

        public Builder local_time64_mobile(Long l) {
            this.local_time64_mobile = l;
            return this;
        }

        public Builder local_time64_gps(Long l) {
            this.local_time64_gps = l;
            return this;
        }

        public Builder utc_offset(Integer num) {
            this.utc_offset = num;
            return this;
        }

        public Builder china_app_offset(Integer num) {
            this.china_app_offset = num;
            return this;
        }

        public Builder china_rt_offset(Integer num) {
            this.china_rt_offset = num;
            return this;
        }

        public Builder is_billing(Boolean bool) {
            this.is_billing = bool;
            return this;
        }

        public Builder plutus_data(DriverOrderMoneyGetReqV2 driverOrderMoneyGetReqV2) {
            this.plutus_data = driverOrderMoneyGetReqV2;
            return this;
        }

        public Builder location_utc_offset(Integer num) {
            this.location_utc_offset = num;
            return this;
        }

        public Builder os_utc_offset(Integer num) {
            this.os_utc_offset = num;
            return this;
        }

        public Builder car_level_bits(Long l) {
            this.car_level_bits = l;
            return this;
        }

        public Builder car_levels(String str) {
            this.car_levels = str;
            return this;
        }

        public Builder require_level_bits(Long l) {
            this.require_level_bits = l;
            return this;
        }

        public Builder require_levels(String str) {
            this.require_levels = str;
            return this;
        }

        public Builder location_vdr(String str) {
            this.location_vdr = str;
            return this;
        }

        public Builder idc(String str) {
            this.idc = str;
            return this;
        }

        public Builder rlab_trip_data(RlabTripData rlabTripData) {
            this.rlab_trip_data = rlabTripData;
            return this;
        }

        public Builder order_status(Integer num) {
            this.order_status = num;
            return this;
        }

        public Builder order_id(String str) {
            this.order_id = str;
            return this;
        }

        public Builder map_extra_message_data(MapTrackExtraMessageData mapTrackExtraMessageData) {
            this.map_extra_message_data = mapTrackExtraMessageData;
            return this;
        }

        public CollectSvrCoordinateReq build() {
            return new CollectSvrCoordinateReq(this);
        }
    }
}
