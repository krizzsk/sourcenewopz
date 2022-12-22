package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class PassengerOrderRouteReq extends Message {
    public static final Integer DEFAULT_BIZGROUP = 0;
    public static final Integer DEFAULT_BIZTYPE = 0;
    public static final String DEFAULT_CALLER = "sdk";
    public static final String DEFAULT_COUNTRYID = "";
    public static final Long DEFAULT_CURROUTEID = 0L;
    public static final Long DEFAULT_CURTRAFFICVERSION = 0L;
    public static final String DEFAULT_DIDIVERSION = "";
    public static final Long DEFAULT_DRIVERID = 0L;
    public static final String DEFAULT_EXTERNINFO = "";
    public static final String DEFAULT_IMEI = "";
    public static final Boolean DEFAULT_ISCARPOOL = false;
    public static final Boolean DEFAULT_ISNEEDTRAJ = false;
    public static final String DEFAULT_LANG = "";
    public static final String DEFAULT_LASTORDERID = "";
    public static final Boolean DEFAULT_NEEDETDA = true;
    public static final Boolean DEFAULT_NEEDROUTEDETAIL = false;
    public static final Boolean DEFAULT_NEEDTRAFFIC = false;
    public static final Boolean DEFAULT_NONEEDGEO = false;
    public static final List<OdPoint> DEFAULT_ODPOINTS = Collections.emptyList();
    public static final Long DEFAULT_ODPOINTSTIMESTAMP = 0L;
    public static final String DEFAULT_ORDERID = "";
    public static final Integer DEFAULT_ORDERSTAGE = 0;
    public static final Long DEFAULT_PASSENGERID = 0L;
    public static final String DEFAULT_PHONENUM = "";
    public static final String DEFAULT_POLICYINFO = "";
    public static final String DEFAULT_PRODUCTID = "";
    public static final Integer DEFAULT_PSGBIZTYPE = 0;
    public static final Boolean DEFAULT_PUSHBTMSG = false;
    public static final Boolean DEFAULT_READONLY = false;
    public static final Integer DEFAULT_RECPPSTATE = 0;
    public static final Long DEFAULT_ROUTEDBID = 0L;
    public static final String DEFAULT_ROUTEENGINETYPE = "";
    public static final String DEFAULT_SDKMAPTYPE = "";
    public static final Long DEFAULT_TIMESTAMP = 0L;
    public static final String DEFAULT_TOKEN = "";
    public static final String DEFAULT_TRAVELID = "";
    public static final TravelMode DEFAULT_TRAVELMODE = TravelMode.DRIVING;
    public static final String DEFAULT_VERSION = "";
    @ProtoField(tag = 40, type = Message.Datatype.INT32)
    public final Integer bizGroup;
    @ProtoField(label = Message.Label.REQUIRED, tag = 6, type = Message.Datatype.INT32)
    public final Integer bizType;
    @ProtoField(tag = 30, type = Message.Datatype.STRING)
    public final String caller;
    @ProtoField(tag = 24, type = Message.Datatype.STRING)
    public final String countryId;
    @ProtoField(label = Message.Label.REQUIRED, tag = 5, type = Message.Datatype.INT64)
    public final Long curRouteId;
    @ProtoField(tag = 32, type = Message.Datatype.INT64)
    public final Long curTrafficVersion;
    @ProtoField(tag = 26)
    public final DebugInfo debugInfo;
    @ProtoField(tag = 100)
    public final OdPoint destPoint;
    @ProtoField(tag = 16, type = Message.Datatype.STRING)
    public final String didiVersion;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.UINT64)
    public final Long driverId;
    @ProtoField(tag = 34, type = Message.Datatype.STRING)
    public final String externInfo;
    @ProtoField(label = Message.Label.REQUIRED, tag = 8, type = Message.Datatype.STRING)
    public final String imei;
    @ProtoField(tag = 21, type = Message.Datatype.BOOL)
    public final Boolean isCarpool;
    @ProtoField(label = Message.Label.REQUIRED, tag = 4, type = Message.Datatype.BOOL)
    public final Boolean isNeedTraj;
    @ProtoField(tag = 35, type = Message.Datatype.STRING)
    public final String lang;
    @ProtoField(tag = 22, type = Message.Datatype.STRING)
    public final String lastOrderId;
    @ProtoField(tag = 31, type = Message.Datatype.BOOL)
    public final Boolean needETDA;
    @ProtoField(tag = 101, type = Message.Datatype.BOOL)
    public final Boolean needRouteDetail;
    @ProtoField(tag = 41, type = Message.Datatype.BOOL)
    public final Boolean needTraffic;
    @ProtoField(tag = 25, type = Message.Datatype.BOOL)
    public final Boolean noNeedGeo;
    @ProtoField(label = Message.Label.REPEATED, messageType = OdPoint.class, tag = 27)
    public final List<OdPoint> odPoints;
    @ProtoField(tag = 28, type = Message.Datatype.UINT64)
    public final Long odPointsTimestamp;
    @ProtoField(label = Message.Label.REQUIRED, tag = 12)
    public final DoublePoint orderEndPoint;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.STRING)
    public final String orderId;
    @ProtoField(label = Message.Label.REQUIRED, tag = 7, type = Message.Datatype.INT32)
    public final Integer orderStage;
    @ProtoField(tag = 14, type = Message.Datatype.UINT64)
    public final Long passengerId;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.STRING)
    public final String phoneNum;
    @ProtoField(label = Message.Label.REQUIRED, tag = 11)
    public final DoublePoint pickupEndPoint;
    @ProtoField(tag = 33, type = Message.Datatype.STRING)
    public final String policyInfo;
    @ProtoField(tag = 23, type = Message.Datatype.STRING)
    public final String productId;
    @ProtoField(tag = 18, type = Message.Datatype.INT32)
    public final Integer psgBizType;
    @ProtoField(tag = 37)
    public final DoublePoint psgPoint;
    @ProtoField(tag = 39, type = Message.Datatype.BOOL)
    public final Boolean pushBtMsg;
    @ProtoField(tag = 29, type = Message.Datatype.BOOL)
    public final Boolean readOnly;
    @ProtoField(tag = 36, type = Message.Datatype.INT32)
    public final Integer recPPState;
    @ProtoField(tag = 20, type = Message.Datatype.UINT64)
    public final Long routeDbId;
    @ProtoField(tag = 17, type = Message.Datatype.STRING)
    public final String routeEngineType;
    @ProtoField(tag = 15, type = Message.Datatype.STRING)
    public final String sdkmaptype;
    @ProtoField(label = Message.Label.REQUIRED, tag = 10, type = Message.Datatype.UINT64)
    public final Long timestamp;
    @ProtoField(label = Message.Label.REQUIRED, tag = 13, type = Message.Datatype.STRING)
    public final String token;
    @ProtoField(tag = 19, type = Message.Datatype.STRING)
    public final String travelId;
    @ProtoField(tag = 38, type = Message.Datatype.ENUM)
    public final TravelMode travelMode;
    @ProtoField(label = Message.Label.REQUIRED, tag = 9, type = Message.Datatype.STRING)
    public final String version;

    public PassengerOrderRouteReq(String str, String str2, Long l, Boolean bool, Long l2, Integer num, Integer num2, String str3, String str4, Long l3, DoublePoint doublePoint, DoublePoint doublePoint2, String str5, Long l4, String str6, String str7, String str8, Integer num3, String str9, Long l5, Boolean bool2, String str10, String str11, String str12, Boolean bool3, DebugInfo debugInfo2, List<OdPoint> list, Long l6, Boolean bool4, String str13, Boolean bool5, Long l7, String str14, String str15, String str16, Integer num4, DoublePoint doublePoint3, TravelMode travelMode2, Boolean bool6, Integer num5, Boolean bool7, OdPoint odPoint, Boolean bool8) {
        this.orderId = str;
        this.phoneNum = str2;
        this.driverId = l;
        this.isNeedTraj = bool;
        this.curRouteId = l2;
        this.bizType = num;
        this.orderStage = num2;
        this.imei = str3;
        this.version = str4;
        this.timestamp = l3;
        this.pickupEndPoint = doublePoint;
        this.orderEndPoint = doublePoint2;
        this.token = str5;
        this.passengerId = l4;
        this.sdkmaptype = str6;
        this.didiVersion = str7;
        this.routeEngineType = str8;
        this.psgBizType = num3;
        this.travelId = str9;
        this.routeDbId = l5;
        this.isCarpool = bool2;
        this.lastOrderId = str10;
        this.productId = str11;
        this.countryId = str12;
        this.noNeedGeo = bool3;
        this.debugInfo = debugInfo2;
        this.odPoints = immutableCopyOf(list);
        this.odPointsTimestamp = l6;
        this.readOnly = bool4;
        this.caller = str13;
        this.needETDA = bool5;
        this.curTrafficVersion = l7;
        this.policyInfo = str14;
        this.externInfo = str15;
        this.lang = str16;
        this.recPPState = num4;
        this.psgPoint = doublePoint3;
        this.travelMode = travelMode2;
        this.pushBtMsg = bool6;
        this.bizGroup = num5;
        this.needTraffic = bool7;
        this.destPoint = odPoint;
        this.needRouteDetail = bool8;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private PassengerOrderRouteReq(com.didi.map.sdk.proto.driver_gl.PassengerOrderRouteReq.Builder r47) {
        /*
            r46 = this;
            r0 = r47
            r1 = r46
            java.lang.String r2 = r0.orderId
            java.lang.String r3 = r0.phoneNum
            java.lang.Long r4 = r0.driverId
            java.lang.Boolean r5 = r0.isNeedTraj
            java.lang.Long r6 = r0.curRouteId
            java.lang.Integer r7 = r0.bizType
            java.lang.Integer r8 = r0.orderStage
            java.lang.String r9 = r0.imei
            java.lang.String r10 = r0.version
            java.lang.Long r11 = r0.timestamp
            com.didi.map.sdk.proto.driver_gl.DoublePoint r12 = r0.pickupEndPoint
            com.didi.map.sdk.proto.driver_gl.DoublePoint r13 = r0.orderEndPoint
            java.lang.String r14 = r0.token
            java.lang.Long r15 = r0.passengerId
            r45 = r1
            java.lang.String r1 = r0.sdkmaptype
            r16 = r1
            java.lang.String r1 = r0.didiVersion
            r17 = r1
            java.lang.String r1 = r0.routeEngineType
            r18 = r1
            java.lang.Integer r1 = r0.psgBizType
            r19 = r1
            java.lang.String r1 = r0.travelId
            r20 = r1
            java.lang.Long r1 = r0.routeDbId
            r21 = r1
            java.lang.Boolean r1 = r0.isCarpool
            r22 = r1
            java.lang.String r1 = r0.lastOrderId
            r23 = r1
            java.lang.String r1 = r0.productId
            r24 = r1
            java.lang.String r1 = r0.countryId
            r25 = r1
            java.lang.Boolean r1 = r0.noNeedGeo
            r26 = r1
            com.didi.map.sdk.proto.driver_gl.DebugInfo r1 = r0.debugInfo
            r27 = r1
            java.util.List<com.didi.map.sdk.proto.driver_gl.OdPoint> r1 = r0.odPoints
            r28 = r1
            java.lang.Long r1 = r0.odPointsTimestamp
            r29 = r1
            java.lang.Boolean r1 = r0.readOnly
            r30 = r1
            java.lang.String r1 = r0.caller
            r31 = r1
            java.lang.Boolean r1 = r0.needETDA
            r32 = r1
            java.lang.Long r1 = r0.curTrafficVersion
            r33 = r1
            java.lang.String r1 = r0.policyInfo
            r34 = r1
            java.lang.String r1 = r0.externInfo
            r35 = r1
            java.lang.String r1 = r0.lang
            r36 = r1
            java.lang.Integer r1 = r0.recPPState
            r37 = r1
            com.didi.map.sdk.proto.driver_gl.DoublePoint r1 = r0.psgPoint
            r38 = r1
            com.didi.map.sdk.proto.driver_gl.TravelMode r1 = r0.travelMode
            r39 = r1
            java.lang.Boolean r1 = r0.pushBtMsg
            r40 = r1
            java.lang.Integer r1 = r0.bizGroup
            r41 = r1
            java.lang.Boolean r1 = r0.needTraffic
            r42 = r1
            com.didi.map.sdk.proto.driver_gl.OdPoint r1 = r0.destPoint
            r43 = r1
            java.lang.Boolean r1 = r0.needRouteDetail
            r44 = r1
            r1 = r45
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44)
            r46.setBuilder(r47)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.sdk.proto.driver_gl.PassengerOrderRouteReq.<init>(com.didi.map.sdk.proto.driver_gl.PassengerOrderRouteReq$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PassengerOrderRouteReq)) {
            return false;
        }
        PassengerOrderRouteReq passengerOrderRouteReq = (PassengerOrderRouteReq) obj;
        if (!equals((Object) this.orderId, (Object) passengerOrderRouteReq.orderId) || !equals((Object) this.phoneNum, (Object) passengerOrderRouteReq.phoneNum) || !equals((Object) this.driverId, (Object) passengerOrderRouteReq.driverId) || !equals((Object) this.isNeedTraj, (Object) passengerOrderRouteReq.isNeedTraj) || !equals((Object) this.curRouteId, (Object) passengerOrderRouteReq.curRouteId) || !equals((Object) this.bizType, (Object) passengerOrderRouteReq.bizType) || !equals((Object) this.orderStage, (Object) passengerOrderRouteReq.orderStage) || !equals((Object) this.imei, (Object) passengerOrderRouteReq.imei) || !equals((Object) this.version, (Object) passengerOrderRouteReq.version) || !equals((Object) this.timestamp, (Object) passengerOrderRouteReq.timestamp) || !equals((Object) this.pickupEndPoint, (Object) passengerOrderRouteReq.pickupEndPoint) || !equals((Object) this.orderEndPoint, (Object) passengerOrderRouteReq.orderEndPoint) || !equals((Object) this.token, (Object) passengerOrderRouteReq.token) || !equals((Object) this.passengerId, (Object) passengerOrderRouteReq.passengerId) || !equals((Object) this.sdkmaptype, (Object) passengerOrderRouteReq.sdkmaptype) || !equals((Object) this.didiVersion, (Object) passengerOrderRouteReq.didiVersion) || !equals((Object) this.routeEngineType, (Object) passengerOrderRouteReq.routeEngineType) || !equals((Object) this.psgBizType, (Object) passengerOrderRouteReq.psgBizType) || !equals((Object) this.travelId, (Object) passengerOrderRouteReq.travelId) || !equals((Object) this.routeDbId, (Object) passengerOrderRouteReq.routeDbId) || !equals((Object) this.isCarpool, (Object) passengerOrderRouteReq.isCarpool) || !equals((Object) this.lastOrderId, (Object) passengerOrderRouteReq.lastOrderId) || !equals((Object) this.productId, (Object) passengerOrderRouteReq.productId) || !equals((Object) this.countryId, (Object) passengerOrderRouteReq.countryId) || !equals((Object) this.noNeedGeo, (Object) passengerOrderRouteReq.noNeedGeo) || !equals((Object) this.debugInfo, (Object) passengerOrderRouteReq.debugInfo) || !equals((List<?>) this.odPoints, (List<?>) passengerOrderRouteReq.odPoints) || !equals((Object) this.odPointsTimestamp, (Object) passengerOrderRouteReq.odPointsTimestamp) || !equals((Object) this.readOnly, (Object) passengerOrderRouteReq.readOnly) || !equals((Object) this.caller, (Object) passengerOrderRouteReq.caller) || !equals((Object) this.needETDA, (Object) passengerOrderRouteReq.needETDA) || !equals((Object) this.curTrafficVersion, (Object) passengerOrderRouteReq.curTrafficVersion) || !equals((Object) this.policyInfo, (Object) passengerOrderRouteReq.policyInfo) || !equals((Object) this.externInfo, (Object) passengerOrderRouteReq.externInfo) || !equals((Object) this.lang, (Object) passengerOrderRouteReq.lang) || !equals((Object) this.recPPState, (Object) passengerOrderRouteReq.recPPState) || !equals((Object) this.psgPoint, (Object) passengerOrderRouteReq.psgPoint) || !equals((Object) this.travelMode, (Object) passengerOrderRouteReq.travelMode) || !equals((Object) this.pushBtMsg, (Object) passengerOrderRouteReq.pushBtMsg) || !equals((Object) this.bizGroup, (Object) passengerOrderRouteReq.bizGroup) || !equals((Object) this.needTraffic, (Object) passengerOrderRouteReq.needTraffic) || !equals((Object) this.destPoint, (Object) passengerOrderRouteReq.destPoint) || !equals((Object) this.needRouteDetail, (Object) passengerOrderRouteReq.needRouteDetail)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.orderId;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        String str2 = this.phoneNum;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        Long l = this.driverId;
        int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 37;
        Boolean bool = this.isNeedTraj;
        int hashCode4 = (hashCode3 + (bool != null ? bool.hashCode() : 0)) * 37;
        Long l2 = this.curRouteId;
        int hashCode5 = (hashCode4 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Integer num = this.bizType;
        int hashCode6 = (hashCode5 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.orderStage;
        int hashCode7 = (hashCode6 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str3 = this.imei;
        int hashCode8 = (hashCode7 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.version;
        int hashCode9 = (hashCode8 + (str4 != null ? str4.hashCode() : 0)) * 37;
        Long l3 = this.timestamp;
        int hashCode10 = (hashCode9 + (l3 != null ? l3.hashCode() : 0)) * 37;
        DoublePoint doublePoint = this.pickupEndPoint;
        int hashCode11 = (hashCode10 + (doublePoint != null ? doublePoint.hashCode() : 0)) * 37;
        DoublePoint doublePoint2 = this.orderEndPoint;
        int hashCode12 = (hashCode11 + (doublePoint2 != null ? doublePoint2.hashCode() : 0)) * 37;
        String str5 = this.token;
        int hashCode13 = (hashCode12 + (str5 != null ? str5.hashCode() : 0)) * 37;
        Long l4 = this.passengerId;
        int hashCode14 = (hashCode13 + (l4 != null ? l4.hashCode() : 0)) * 37;
        String str6 = this.sdkmaptype;
        int hashCode15 = (hashCode14 + (str6 != null ? str6.hashCode() : 0)) * 37;
        String str7 = this.didiVersion;
        int hashCode16 = (hashCode15 + (str7 != null ? str7.hashCode() : 0)) * 37;
        String str8 = this.routeEngineType;
        int hashCode17 = (hashCode16 + (str8 != null ? str8.hashCode() : 0)) * 37;
        Integer num3 = this.psgBizType;
        int hashCode18 = (hashCode17 + (num3 != null ? num3.hashCode() : 0)) * 37;
        String str9 = this.travelId;
        int hashCode19 = (hashCode18 + (str9 != null ? str9.hashCode() : 0)) * 37;
        Long l5 = this.routeDbId;
        int hashCode20 = (hashCode19 + (l5 != null ? l5.hashCode() : 0)) * 37;
        Boolean bool2 = this.isCarpool;
        int hashCode21 = (hashCode20 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        String str10 = this.lastOrderId;
        int hashCode22 = (hashCode21 + (str10 != null ? str10.hashCode() : 0)) * 37;
        String str11 = this.productId;
        int hashCode23 = (hashCode22 + (str11 != null ? str11.hashCode() : 0)) * 37;
        String str12 = this.countryId;
        int hashCode24 = (hashCode23 + (str12 != null ? str12.hashCode() : 0)) * 37;
        Boolean bool3 = this.noNeedGeo;
        int hashCode25 = (hashCode24 + (bool3 != null ? bool3.hashCode() : 0)) * 37;
        DebugInfo debugInfo2 = this.debugInfo;
        int hashCode26 = (hashCode25 + (debugInfo2 != null ? debugInfo2.hashCode() : 0)) * 37;
        List<OdPoint> list = this.odPoints;
        int hashCode27 = (hashCode26 + (list != null ? list.hashCode() : 1)) * 37;
        Long l6 = this.odPointsTimestamp;
        int hashCode28 = (hashCode27 + (l6 != null ? l6.hashCode() : 0)) * 37;
        Boolean bool4 = this.readOnly;
        int hashCode29 = (hashCode28 + (bool4 != null ? bool4.hashCode() : 0)) * 37;
        String str13 = this.caller;
        int hashCode30 = (hashCode29 + (str13 != null ? str13.hashCode() : 0)) * 37;
        Boolean bool5 = this.needETDA;
        int hashCode31 = (hashCode30 + (bool5 != null ? bool5.hashCode() : 0)) * 37;
        Long l7 = this.curTrafficVersion;
        int hashCode32 = (hashCode31 + (l7 != null ? l7.hashCode() : 0)) * 37;
        String str14 = this.policyInfo;
        int hashCode33 = (hashCode32 + (str14 != null ? str14.hashCode() : 0)) * 37;
        String str15 = this.externInfo;
        int hashCode34 = (hashCode33 + (str15 != null ? str15.hashCode() : 0)) * 37;
        String str16 = this.lang;
        int hashCode35 = (hashCode34 + (str16 != null ? str16.hashCode() : 0)) * 37;
        Integer num4 = this.recPPState;
        int hashCode36 = (hashCode35 + (num4 != null ? num4.hashCode() : 0)) * 37;
        DoublePoint doublePoint3 = this.psgPoint;
        int hashCode37 = (hashCode36 + (doublePoint3 != null ? doublePoint3.hashCode() : 0)) * 37;
        TravelMode travelMode2 = this.travelMode;
        int hashCode38 = (hashCode37 + (travelMode2 != null ? travelMode2.hashCode() : 0)) * 37;
        Boolean bool6 = this.pushBtMsg;
        int hashCode39 = (hashCode38 + (bool6 != null ? bool6.hashCode() : 0)) * 37;
        Integer num5 = this.bizGroup;
        int hashCode40 = (hashCode39 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Boolean bool7 = this.needTraffic;
        int hashCode41 = (hashCode40 + (bool7 != null ? bool7.hashCode() : 0)) * 37;
        OdPoint odPoint = this.destPoint;
        int hashCode42 = (hashCode41 + (odPoint != null ? odPoint.hashCode() : 0)) * 37;
        Boolean bool8 = this.needRouteDetail;
        if (bool8 != null) {
            i2 = bool8.hashCode();
        }
        int i3 = hashCode42 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<PassengerOrderRouteReq> {
        public Integer bizGroup;
        public Integer bizType;
        public String caller;
        public String countryId;
        public Long curRouteId;
        public Long curTrafficVersion;
        public DebugInfo debugInfo;
        public OdPoint destPoint;
        public String didiVersion;
        public Long driverId;
        public String externInfo;
        public String imei;
        public Boolean isCarpool;
        public Boolean isNeedTraj;
        public String lang;
        public String lastOrderId;
        public Boolean needETDA;
        public Boolean needRouteDetail;
        public Boolean needTraffic;
        public Boolean noNeedGeo;
        public List<OdPoint> odPoints;
        public Long odPointsTimestamp;
        public DoublePoint orderEndPoint;
        public String orderId;
        public Integer orderStage;
        public Long passengerId;
        public String phoneNum;
        public DoublePoint pickupEndPoint;
        public String policyInfo;
        public String productId;
        public Integer psgBizType;
        public DoublePoint psgPoint;
        public Boolean pushBtMsg;
        public Boolean readOnly;
        public Integer recPPState;
        public Long routeDbId;
        public String routeEngineType;
        public String sdkmaptype;
        public Long timestamp;
        public String token;
        public String travelId;
        public TravelMode travelMode;
        public String version;

        public Builder() {
        }

        public Builder(PassengerOrderRouteReq passengerOrderRouteReq) {
            super(passengerOrderRouteReq);
            if (passengerOrderRouteReq != null) {
                this.orderId = passengerOrderRouteReq.orderId;
                this.phoneNum = passengerOrderRouteReq.phoneNum;
                this.driverId = passengerOrderRouteReq.driverId;
                this.isNeedTraj = passengerOrderRouteReq.isNeedTraj;
                this.curRouteId = passengerOrderRouteReq.curRouteId;
                this.bizType = passengerOrderRouteReq.bizType;
                this.orderStage = passengerOrderRouteReq.orderStage;
                this.imei = passengerOrderRouteReq.imei;
                this.version = passengerOrderRouteReq.version;
                this.timestamp = passengerOrderRouteReq.timestamp;
                this.pickupEndPoint = passengerOrderRouteReq.pickupEndPoint;
                this.orderEndPoint = passengerOrderRouteReq.orderEndPoint;
                this.token = passengerOrderRouteReq.token;
                this.passengerId = passengerOrderRouteReq.passengerId;
                this.sdkmaptype = passengerOrderRouteReq.sdkmaptype;
                this.didiVersion = passengerOrderRouteReq.didiVersion;
                this.routeEngineType = passengerOrderRouteReq.routeEngineType;
                this.psgBizType = passengerOrderRouteReq.psgBizType;
                this.travelId = passengerOrderRouteReq.travelId;
                this.routeDbId = passengerOrderRouteReq.routeDbId;
                this.isCarpool = passengerOrderRouteReq.isCarpool;
                this.lastOrderId = passengerOrderRouteReq.lastOrderId;
                this.productId = passengerOrderRouteReq.productId;
                this.countryId = passengerOrderRouteReq.countryId;
                this.noNeedGeo = passengerOrderRouteReq.noNeedGeo;
                this.debugInfo = passengerOrderRouteReq.debugInfo;
                this.odPoints = PassengerOrderRouteReq.copyOf(passengerOrderRouteReq.odPoints);
                this.odPointsTimestamp = passengerOrderRouteReq.odPointsTimestamp;
                this.readOnly = passengerOrderRouteReq.readOnly;
                this.caller = passengerOrderRouteReq.caller;
                this.needETDA = passengerOrderRouteReq.needETDA;
                this.curTrafficVersion = passengerOrderRouteReq.curTrafficVersion;
                this.policyInfo = passengerOrderRouteReq.policyInfo;
                this.externInfo = passengerOrderRouteReq.externInfo;
                this.lang = passengerOrderRouteReq.lang;
                this.recPPState = passengerOrderRouteReq.recPPState;
                this.psgPoint = passengerOrderRouteReq.psgPoint;
                this.travelMode = passengerOrderRouteReq.travelMode;
                this.pushBtMsg = passengerOrderRouteReq.pushBtMsg;
                this.bizGroup = passengerOrderRouteReq.bizGroup;
                this.needTraffic = passengerOrderRouteReq.needTraffic;
                this.destPoint = passengerOrderRouteReq.destPoint;
                this.needRouteDetail = passengerOrderRouteReq.needRouteDetail;
            }
        }

        public Builder orderId(String str) {
            this.orderId = str;
            return this;
        }

        public Builder phoneNum(String str) {
            this.phoneNum = str;
            return this;
        }

        public Builder driverId(Long l) {
            this.driverId = l;
            return this;
        }

        public Builder isNeedTraj(Boolean bool) {
            this.isNeedTraj = bool;
            return this;
        }

        public Builder curRouteId(Long l) {
            this.curRouteId = l;
            return this;
        }

        public Builder bizType(Integer num) {
            this.bizType = num;
            return this;
        }

        public Builder orderStage(Integer num) {
            this.orderStage = num;
            return this;
        }

        public Builder imei(String str) {
            this.imei = str;
            return this;
        }

        public Builder version(String str) {
            this.version = str;
            return this;
        }

        public Builder timestamp(Long l) {
            this.timestamp = l;
            return this;
        }

        public Builder pickupEndPoint(DoublePoint doublePoint) {
            this.pickupEndPoint = doublePoint;
            return this;
        }

        public Builder orderEndPoint(DoublePoint doublePoint) {
            this.orderEndPoint = doublePoint;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public Builder passengerId(Long l) {
            this.passengerId = l;
            return this;
        }

        public Builder sdkmaptype(String str) {
            this.sdkmaptype = str;
            return this;
        }

        public Builder didiVersion(String str) {
            this.didiVersion = str;
            return this;
        }

        public Builder routeEngineType(String str) {
            this.routeEngineType = str;
            return this;
        }

        public Builder psgBizType(Integer num) {
            this.psgBizType = num;
            return this;
        }

        public Builder travelId(String str) {
            this.travelId = str;
            return this;
        }

        public Builder routeDbId(Long l) {
            this.routeDbId = l;
            return this;
        }

        public Builder isCarpool(Boolean bool) {
            this.isCarpool = bool;
            return this;
        }

        public Builder lastOrderId(String str) {
            this.lastOrderId = str;
            return this;
        }

        public Builder productId(String str) {
            this.productId = str;
            return this;
        }

        public Builder countryId(String str) {
            this.countryId = str;
            return this;
        }

        public Builder noNeedGeo(Boolean bool) {
            this.noNeedGeo = bool;
            return this;
        }

        public Builder debugInfo(DebugInfo debugInfo2) {
            this.debugInfo = debugInfo2;
            return this;
        }

        public Builder odPoints(List<OdPoint> list) {
            this.odPoints = checkForNulls(list);
            return this;
        }

        public Builder odPointsTimestamp(Long l) {
            this.odPointsTimestamp = l;
            return this;
        }

        public Builder readOnly(Boolean bool) {
            this.readOnly = bool;
            return this;
        }

        public Builder caller(String str) {
            this.caller = str;
            return this;
        }

        public Builder needETDA(Boolean bool) {
            this.needETDA = bool;
            return this;
        }

        public Builder curTrafficVersion(Long l) {
            this.curTrafficVersion = l;
            return this;
        }

        public Builder policyInfo(String str) {
            this.policyInfo = str;
            return this;
        }

        public Builder externInfo(String str) {
            this.externInfo = str;
            return this;
        }

        public Builder lang(String str) {
            this.lang = str;
            return this;
        }

        public Builder recPPState(Integer num) {
            this.recPPState = num;
            return this;
        }

        public Builder psgPoint(DoublePoint doublePoint) {
            this.psgPoint = doublePoint;
            return this;
        }

        public Builder travelMode(TravelMode travelMode2) {
            this.travelMode = travelMode2;
            return this;
        }

        public Builder pushBtMsg(Boolean bool) {
            this.pushBtMsg = bool;
            return this;
        }

        public Builder bizGroup(Integer num) {
            this.bizGroup = num;
            return this;
        }

        public Builder needTraffic(Boolean bool) {
            this.needTraffic = bool;
            return this;
        }

        public Builder destPoint(OdPoint odPoint) {
            this.destPoint = odPoint;
            return this;
        }

        public Builder needRouteDetail(Boolean bool) {
            this.needRouteDetail = bool;
            return this;
        }

        public PassengerOrderRouteReq build() {
            checkRequiredFields();
            return new PassengerOrderRouteReq(this);
        }
    }
}
