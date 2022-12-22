package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;
import okio.ByteString;

public final class DriverOrderRouteReq extends Message {
    public static final String DEFAULT_AMAPTBTVERSION = "";
    public static final Integer DEFAULT_BIZGROUP = 0;
    public static final Integer DEFAULT_BIZTYPE = 0;
    public static final Boolean DEFAULT_BLUETOOTHOPEN = false;
    public static final String DEFAULT_CALLER = "";
    public static final String DEFAULT_COUNTRYID = "";
    public static final Long DEFAULT_CURROUTEID = 0L;
    public static final Boolean DEFAULT_DEBUG_MODEL = false;
    public static final String DEFAULT_DIDIVERSION = "";
    public static final Long DEFAULT_DRIVERID = 0L;
    public static final Integer DEFAULT_EVENTTYPE = 0;
    public static final ByteString DEFAULT_EXTENDDATA = ByteString.EMPTY;
    public static final String DEFAULT_IMEI = "";
    public static final Boolean DEFAULT_ISCHANGEENDPOINT = true;
    public static final Boolean DEFAULT_ISCHANGESTARTPOINT = true;
    public static final Long DEFAULT_LASTDIDIROUTEID = 0L;
    public static final Integer DEFAULT_LIGHTNAVI = 0;
    public static final Long DEFAULT_LOGID = 0L;
    public static final Boolean DEFAULT_NONEEDGEO = false;
    public static final List<OdPoint> DEFAULT_ODPOINTS = Collections.emptyList();
    public static final Long DEFAULT_ODPOINTSTIMESTAMP = 0L;
    public static final Integer DEFAULT_ORARETRYTIME = 0;
    public static final String DEFAULT_ORDERID = "";
    public static final Integer DEFAULT_ORDERSTAGE = 0;
    public static final Long DEFAULT_PASSENGERID = 0L;
    public static final String DEFAULT_PHONENUM = "";
    public static final String DEFAULT_PRODUCTID = "";
    public static final String DEFAULT_PROTOTYPE = "";
    public static final String DEFAULT_PSGMULTIROUTETRACEID = "";
    public static final ByteString DEFAULT_ROUTEENGINEREQPACK = ByteString.EMPTY;
    public static final String DEFAULT_SDKMAPTYPE = "";
    public static final Integer DEFAULT_STARTPOINTACCURACY = 0;
    public static final Integer DEFAULT_STARTPOINTDIRECTION = 0;
    public static final Integer DEFAULT_STARTPOINTSPEED = 0;
    public static final Boolean DEFAULT_SYNC2PSG = true;
    public static final String DEFAULT_TICKET = "";
    public static final Long DEFAULT_TIMESTAMP = 0L;
    public static final TravelMode DEFAULT_TRAVELMODE = TravelMode.DRIVING;
    public static final String DEFAULT_TRAVERID = "";
    public static final String DEFAULT_VERSION = "";
    @ProtoField(tag = 23, type = Message.Datatype.STRING)
    public final String amapTbtVersion;
    @ProtoField(tag = 46, type = Message.Datatype.INT32)
    public final Integer bizGroup;
    @ProtoField(label = Message.Label.REQUIRED, tag = 4, type = Message.Datatype.INT32)
    public final Integer bizType;
    @ProtoField(tag = 48, type = Message.Datatype.BOOL)
    public final Boolean bluetoothOpen;
    @ProtoField(tag = 33, type = Message.Datatype.STRING)
    public final String caller;
    @ProtoField(tag = 27)
    public final DriverConfig config;
    @ProtoField(tag = 36, type = Message.Datatype.STRING)
    public final String countryId;
    @ProtoField(tag = 37, type = Message.Datatype.INT64)
    public final Long curRouteId;
    @ProtoField(tag = 45)
    public final DebugInfo debugInfo;
    @ProtoField(tag = 32, type = Message.Datatype.BOOL)
    public final Boolean debug_model;
    @ProtoField(tag = 26, type = Message.Datatype.STRING)
    public final String didiVersion;
    @ProtoField(tag = 17, type = Message.Datatype.UINT64)
    public final Long driverId;
    @ProtoField(tag = 28)
    public final DynamicRouteReq dynamicRouteReq;
    @ProtoField(label = Message.Label.REQUIRED, tag = 9)
    public final DoublePoint endPoint;
    @ProtoField(label = Message.Label.REQUIRED, tag = 10, type = Message.Datatype.INT32)
    public final Integer eventType;
    @ProtoField(tag = 44, type = Message.Datatype.BYTES)
    public final ByteString extendData;
    @ProtoField(label = Message.Label.REQUIRED, tag = 12, type = Message.Datatype.STRING)
    public final String imei;
    @ProtoField(tag = 30, type = Message.Datatype.BOOL)
    public final Boolean isChangeEndPoint;
    @ProtoField(tag = 29, type = Message.Datatype.BOOL)
    public final Boolean isChangeStartPoint;
    @ProtoField(tag = 19, type = Message.Datatype.UINT64)
    public final Long lastDiDiRouteId;
    @ProtoField(tag = 25, type = Message.Datatype.INT32)
    public final Integer lightNavi;
    @ProtoField(tag = 22, type = Message.Datatype.UINT64)
    public final Long logid;
    @ProtoField(tag = 47)
    public final Msg2PsgReq msg2PsgReq;
    @ProtoField(tag = 38, type = Message.Datatype.BOOL)
    public final Boolean noNeedGeo;
    @ProtoField(label = Message.Label.REPEATED, messageType = OdPoint.class, tag = 34)
    public final List<OdPoint> odPoints;
    @ProtoField(tag = 42, type = Message.Datatype.UINT64)
    public final Long odPointsTimestamp;
    @ProtoField(tag = 43)
    public final OpenSdkInfo openSdkInfo;
    @ProtoField(tag = 24, type = Message.Datatype.INT32)
    public final Integer oraRetryTime;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.STRING)
    public final String orderId;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.INT32)
    public final Integer orderStage;
    @ProtoField(tag = 16, type = Message.Datatype.UINT64)
    public final Long passengerId;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.STRING)
    public final String phoneNum;
    @ProtoField(tag = 35, type = Message.Datatype.STRING)
    public final String productId;
    @ProtoField(tag = 31, type = Message.Datatype.STRING)
    public final String protoType;
    @ProtoField(tag = 40, type = Message.Datatype.STRING)
    public final String psgMultiRouteTraceId;
    @ProtoField(label = Message.Label.REQUIRED, tag = 13, type = Message.Datatype.BYTES)
    public final ByteString routeEngineReqPack;
    @ProtoField(tag = 21, type = Message.Datatype.STRING)
    public final String sdkmaptype;
    @ProtoField(label = Message.Label.REQUIRED, tag = 5)
    public final DoublePoint startPoint;
    @ProtoField(label = Message.Label.REQUIRED, tag = 8, type = Message.Datatype.INT32)
    public final Integer startPointAccuracy;
    @ProtoField(label = Message.Label.REQUIRED, tag = 7, type = Message.Datatype.INT32)
    public final Integer startPointDirection;
    @ProtoField(label = Message.Label.REQUIRED, tag = 6, type = Message.Datatype.INT32)
    public final Integer startPointSpeed;
    @ProtoField(tag = 39, type = Message.Datatype.BOOL)
    public final Boolean sync2Psg;
    @ProtoField(label = Message.Label.REQUIRED, tag = 15, type = Message.Datatype.STRING)
    public final String ticket;
    @ProtoField(label = Message.Label.REQUIRED, tag = 11, type = Message.Datatype.UINT64)
    public final Long timestamp;
    @ProtoField(tag = 20)
    public final HisTraj trajs;
    @ProtoField(tag = 41, type = Message.Datatype.ENUM)
    public final TravelMode travelMode;
    @ProtoField(tag = 18, type = Message.Datatype.STRING)
    public final String traverId;
    @ProtoField(label = Message.Label.REQUIRED, tag = 14, type = Message.Datatype.STRING)
    public final String version;

    public DriverOrderRouteReq(String str, String str2, Integer num, Integer num2, DoublePoint doublePoint, Integer num3, Integer num4, Integer num5, DoublePoint doublePoint2, Integer num6, Long l, String str3, ByteString byteString, String str4, String str5, Long l2, Long l3, String str6, Long l4, HisTraj hisTraj, String str7, Long l5, String str8, Integer num7, Integer num8, String str9, DriverConfig driverConfig, DynamicRouteReq dynamicRouteReq2, Boolean bool, Boolean bool2, String str10, Boolean bool3, String str11, List<OdPoint> list, String str12, String str13, Long l6, Boolean bool4, Boolean bool5, String str14, TravelMode travelMode2, Long l7, OpenSdkInfo openSdkInfo2, ByteString byteString2, DebugInfo debugInfo2, Integer num9, Msg2PsgReq msg2PsgReq2, Boolean bool6) {
        this.orderId = str;
        this.phoneNum = str2;
        this.orderStage = num;
        this.bizType = num2;
        this.startPoint = doublePoint;
        this.startPointSpeed = num3;
        this.startPointDirection = num4;
        this.startPointAccuracy = num5;
        this.endPoint = doublePoint2;
        this.eventType = num6;
        this.timestamp = l;
        this.imei = str3;
        this.routeEngineReqPack = byteString;
        this.version = str4;
        this.ticket = str5;
        this.passengerId = l2;
        this.driverId = l3;
        this.traverId = str6;
        this.lastDiDiRouteId = l4;
        this.trajs = hisTraj;
        this.sdkmaptype = str7;
        this.logid = l5;
        this.amapTbtVersion = str8;
        this.oraRetryTime = num7;
        this.lightNavi = num8;
        this.didiVersion = str9;
        this.config = driverConfig;
        this.dynamicRouteReq = dynamicRouteReq2;
        this.isChangeStartPoint = bool;
        this.isChangeEndPoint = bool2;
        this.protoType = str10;
        this.debug_model = bool3;
        this.caller = str11;
        this.odPoints = immutableCopyOf(list);
        this.productId = str12;
        this.countryId = str13;
        this.curRouteId = l6;
        this.noNeedGeo = bool4;
        this.sync2Psg = bool5;
        this.psgMultiRouteTraceId = str14;
        this.travelMode = travelMode2;
        this.odPointsTimestamp = l7;
        this.openSdkInfo = openSdkInfo2;
        this.extendData = byteString2;
        this.debugInfo = debugInfo2;
        this.bizGroup = num9;
        this.msg2PsgReq = msg2PsgReq2;
        this.bluetoothOpen = bool6;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private DriverOrderRouteReq(com.didi.map.sdk.proto.driver_gl.DriverOrderRouteReq.Builder r52) {
        /*
            r51 = this;
            r0 = r52
            r1 = r51
            java.lang.String r2 = r0.orderId
            java.lang.String r3 = r0.phoneNum
            java.lang.Integer r4 = r0.orderStage
            java.lang.Integer r5 = r0.bizType
            com.didi.map.sdk.proto.driver_gl.DoublePoint r6 = r0.startPoint
            java.lang.Integer r7 = r0.startPointSpeed
            java.lang.Integer r8 = r0.startPointDirection
            java.lang.Integer r9 = r0.startPointAccuracy
            com.didi.map.sdk.proto.driver_gl.DoublePoint r10 = r0.endPoint
            java.lang.Integer r11 = r0.eventType
            java.lang.Long r12 = r0.timestamp
            java.lang.String r13 = r0.imei
            okio.ByteString r14 = r0.routeEngineReqPack
            java.lang.String r15 = r0.version
            r50 = r1
            java.lang.String r1 = r0.ticket
            r16 = r1
            java.lang.Long r1 = r0.passengerId
            r17 = r1
            java.lang.Long r1 = r0.driverId
            r18 = r1
            java.lang.String r1 = r0.traverId
            r19 = r1
            java.lang.Long r1 = r0.lastDiDiRouteId
            r20 = r1
            com.didi.map.sdk.proto.driver_gl.HisTraj r1 = r0.trajs
            r21 = r1
            java.lang.String r1 = r0.sdkmaptype
            r22 = r1
            java.lang.Long r1 = r0.logid
            r23 = r1
            java.lang.String r1 = r0.amapTbtVersion
            r24 = r1
            java.lang.Integer r1 = r0.oraRetryTime
            r25 = r1
            java.lang.Integer r1 = r0.lightNavi
            r26 = r1
            java.lang.String r1 = r0.didiVersion
            r27 = r1
            com.didi.map.sdk.proto.driver_gl.DriverConfig r1 = r0.config
            r28 = r1
            com.didi.map.sdk.proto.driver_gl.DynamicRouteReq r1 = r0.dynamicRouteReq
            r29 = r1
            java.lang.Boolean r1 = r0.isChangeStartPoint
            r30 = r1
            java.lang.Boolean r1 = r0.isChangeEndPoint
            r31 = r1
            java.lang.String r1 = r0.protoType
            r32 = r1
            java.lang.Boolean r1 = r0.debug_model
            r33 = r1
            java.lang.String r1 = r0.caller
            r34 = r1
            java.util.List<com.didi.map.sdk.proto.driver_gl.OdPoint> r1 = r0.odPoints
            r35 = r1
            java.lang.String r1 = r0.productId
            r36 = r1
            java.lang.String r1 = r0.countryId
            r37 = r1
            java.lang.Long r1 = r0.curRouteId
            r38 = r1
            java.lang.Boolean r1 = r0.noNeedGeo
            r39 = r1
            java.lang.Boolean r1 = r0.sync2Psg
            r40 = r1
            java.lang.String r1 = r0.psgMultiRouteTraceId
            r41 = r1
            com.didi.map.sdk.proto.driver_gl.TravelMode r1 = r0.travelMode
            r42 = r1
            java.lang.Long r1 = r0.odPointsTimestamp
            r43 = r1
            com.didi.map.sdk.proto.driver_gl.OpenSdkInfo r1 = r0.openSdkInfo
            r44 = r1
            okio.ByteString r1 = r0.extendData
            r45 = r1
            com.didi.map.sdk.proto.driver_gl.DebugInfo r1 = r0.debugInfo
            r46 = r1
            java.lang.Integer r1 = r0.bizGroup
            r47 = r1
            com.didi.map.sdk.proto.driver_gl.Msg2PsgReq r1 = r0.msg2PsgReq
            r48 = r1
            java.lang.Boolean r1 = r0.bluetoothOpen
            r49 = r1
            r1 = r50
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49)
            r51.setBuilder(r52)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.sdk.proto.driver_gl.DriverOrderRouteReq.<init>(com.didi.map.sdk.proto.driver_gl.DriverOrderRouteReq$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DriverOrderRouteReq)) {
            return false;
        }
        DriverOrderRouteReq driverOrderRouteReq = (DriverOrderRouteReq) obj;
        if (!equals((Object) this.orderId, (Object) driverOrderRouteReq.orderId) || !equals((Object) this.phoneNum, (Object) driverOrderRouteReq.phoneNum) || !equals((Object) this.orderStage, (Object) driverOrderRouteReq.orderStage) || !equals((Object) this.bizType, (Object) driverOrderRouteReq.bizType) || !equals((Object) this.startPoint, (Object) driverOrderRouteReq.startPoint) || !equals((Object) this.startPointSpeed, (Object) driverOrderRouteReq.startPointSpeed) || !equals((Object) this.startPointDirection, (Object) driverOrderRouteReq.startPointDirection) || !equals((Object) this.startPointAccuracy, (Object) driverOrderRouteReq.startPointAccuracy) || !equals((Object) this.endPoint, (Object) driverOrderRouteReq.endPoint) || !equals((Object) this.eventType, (Object) driverOrderRouteReq.eventType) || !equals((Object) this.timestamp, (Object) driverOrderRouteReq.timestamp) || !equals((Object) this.imei, (Object) driverOrderRouteReq.imei) || !equals((Object) this.routeEngineReqPack, (Object) driverOrderRouteReq.routeEngineReqPack) || !equals((Object) this.version, (Object) driverOrderRouteReq.version) || !equals((Object) this.ticket, (Object) driverOrderRouteReq.ticket) || !equals((Object) this.passengerId, (Object) driverOrderRouteReq.passengerId) || !equals((Object) this.driverId, (Object) driverOrderRouteReq.driverId) || !equals((Object) this.traverId, (Object) driverOrderRouteReq.traverId) || !equals((Object) this.lastDiDiRouteId, (Object) driverOrderRouteReq.lastDiDiRouteId) || !equals((Object) this.trajs, (Object) driverOrderRouteReq.trajs) || !equals((Object) this.sdkmaptype, (Object) driverOrderRouteReq.sdkmaptype) || !equals((Object) this.logid, (Object) driverOrderRouteReq.logid) || !equals((Object) this.amapTbtVersion, (Object) driverOrderRouteReq.amapTbtVersion) || !equals((Object) this.oraRetryTime, (Object) driverOrderRouteReq.oraRetryTime) || !equals((Object) this.lightNavi, (Object) driverOrderRouteReq.lightNavi) || !equals((Object) this.didiVersion, (Object) driverOrderRouteReq.didiVersion) || !equals((Object) this.config, (Object) driverOrderRouteReq.config) || !equals((Object) this.dynamicRouteReq, (Object) driverOrderRouteReq.dynamicRouteReq) || !equals((Object) this.isChangeStartPoint, (Object) driverOrderRouteReq.isChangeStartPoint) || !equals((Object) this.isChangeEndPoint, (Object) driverOrderRouteReq.isChangeEndPoint) || !equals((Object) this.protoType, (Object) driverOrderRouteReq.protoType) || !equals((Object) this.debug_model, (Object) driverOrderRouteReq.debug_model) || !equals((Object) this.caller, (Object) driverOrderRouteReq.caller) || !equals((List<?>) this.odPoints, (List<?>) driverOrderRouteReq.odPoints) || !equals((Object) this.productId, (Object) driverOrderRouteReq.productId) || !equals((Object) this.countryId, (Object) driverOrderRouteReq.countryId) || !equals((Object) this.curRouteId, (Object) driverOrderRouteReq.curRouteId) || !equals((Object) this.noNeedGeo, (Object) driverOrderRouteReq.noNeedGeo) || !equals((Object) this.sync2Psg, (Object) driverOrderRouteReq.sync2Psg) || !equals((Object) this.psgMultiRouteTraceId, (Object) driverOrderRouteReq.psgMultiRouteTraceId) || !equals((Object) this.travelMode, (Object) driverOrderRouteReq.travelMode) || !equals((Object) this.odPointsTimestamp, (Object) driverOrderRouteReq.odPointsTimestamp) || !equals((Object) this.openSdkInfo, (Object) driverOrderRouteReq.openSdkInfo) || !equals((Object) this.extendData, (Object) driverOrderRouteReq.extendData) || !equals((Object) this.debugInfo, (Object) driverOrderRouteReq.debugInfo) || !equals((Object) this.bizGroup, (Object) driverOrderRouteReq.bizGroup) || !equals((Object) this.msg2PsgReq, (Object) driverOrderRouteReq.msg2PsgReq) || !equals((Object) this.bluetoothOpen, (Object) driverOrderRouteReq.bluetoothOpen)) {
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
        Integer num = this.orderStage;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.bizType;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        DoublePoint doublePoint = this.startPoint;
        int hashCode5 = (hashCode4 + (doublePoint != null ? doublePoint.hashCode() : 0)) * 37;
        Integer num3 = this.startPointSpeed;
        int hashCode6 = (hashCode5 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.startPointDirection;
        int hashCode7 = (hashCode6 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.startPointAccuracy;
        int hashCode8 = (hashCode7 + (num5 != null ? num5.hashCode() : 0)) * 37;
        DoublePoint doublePoint2 = this.endPoint;
        int hashCode9 = (hashCode8 + (doublePoint2 != null ? doublePoint2.hashCode() : 0)) * 37;
        Integer num6 = this.eventType;
        int hashCode10 = (hashCode9 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Long l = this.timestamp;
        int hashCode11 = (hashCode10 + (l != null ? l.hashCode() : 0)) * 37;
        String str3 = this.imei;
        int hashCode12 = (hashCode11 + (str3 != null ? str3.hashCode() : 0)) * 37;
        ByteString byteString = this.routeEngineReqPack;
        int hashCode13 = (hashCode12 + (byteString != null ? byteString.hashCode() : 0)) * 37;
        String str4 = this.version;
        int hashCode14 = (hashCode13 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.ticket;
        int hashCode15 = (hashCode14 + (str5 != null ? str5.hashCode() : 0)) * 37;
        Long l2 = this.passengerId;
        int hashCode16 = (hashCode15 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.driverId;
        int hashCode17 = (hashCode16 + (l3 != null ? l3.hashCode() : 0)) * 37;
        String str6 = this.traverId;
        int hashCode18 = (hashCode17 + (str6 != null ? str6.hashCode() : 0)) * 37;
        Long l4 = this.lastDiDiRouteId;
        int hashCode19 = (hashCode18 + (l4 != null ? l4.hashCode() : 0)) * 37;
        HisTraj hisTraj = this.trajs;
        int hashCode20 = (hashCode19 + (hisTraj != null ? hisTraj.hashCode() : 0)) * 37;
        String str7 = this.sdkmaptype;
        int hashCode21 = (hashCode20 + (str7 != null ? str7.hashCode() : 0)) * 37;
        Long l5 = this.logid;
        int hashCode22 = (hashCode21 + (l5 != null ? l5.hashCode() : 0)) * 37;
        String str8 = this.amapTbtVersion;
        int hashCode23 = (hashCode22 + (str8 != null ? str8.hashCode() : 0)) * 37;
        Integer num7 = this.oraRetryTime;
        int hashCode24 = (hashCode23 + (num7 != null ? num7.hashCode() : 0)) * 37;
        Integer num8 = this.lightNavi;
        int hashCode25 = (hashCode24 + (num8 != null ? num8.hashCode() : 0)) * 37;
        String str9 = this.didiVersion;
        int hashCode26 = (hashCode25 + (str9 != null ? str9.hashCode() : 0)) * 37;
        DriverConfig driverConfig = this.config;
        int hashCode27 = (hashCode26 + (driverConfig != null ? driverConfig.hashCode() : 0)) * 37;
        DynamicRouteReq dynamicRouteReq2 = this.dynamicRouteReq;
        int hashCode28 = (hashCode27 + (dynamicRouteReq2 != null ? dynamicRouteReq2.hashCode() : 0)) * 37;
        Boolean bool = this.isChangeStartPoint;
        int hashCode29 = (hashCode28 + (bool != null ? bool.hashCode() : 0)) * 37;
        Boolean bool2 = this.isChangeEndPoint;
        int hashCode30 = (hashCode29 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        String str10 = this.protoType;
        int hashCode31 = (hashCode30 + (str10 != null ? str10.hashCode() : 0)) * 37;
        Boolean bool3 = this.debug_model;
        int hashCode32 = (hashCode31 + (bool3 != null ? bool3.hashCode() : 0)) * 37;
        String str11 = this.caller;
        int hashCode33 = (hashCode32 + (str11 != null ? str11.hashCode() : 0)) * 37;
        List<OdPoint> list = this.odPoints;
        int hashCode34 = (hashCode33 + (list != null ? list.hashCode() : 1)) * 37;
        String str12 = this.productId;
        int hashCode35 = (hashCode34 + (str12 != null ? str12.hashCode() : 0)) * 37;
        String str13 = this.countryId;
        int hashCode36 = (hashCode35 + (str13 != null ? str13.hashCode() : 0)) * 37;
        Long l6 = this.curRouteId;
        int hashCode37 = (hashCode36 + (l6 != null ? l6.hashCode() : 0)) * 37;
        Boolean bool4 = this.noNeedGeo;
        int hashCode38 = (hashCode37 + (bool4 != null ? bool4.hashCode() : 0)) * 37;
        Boolean bool5 = this.sync2Psg;
        int hashCode39 = (hashCode38 + (bool5 != null ? bool5.hashCode() : 0)) * 37;
        String str14 = this.psgMultiRouteTraceId;
        int hashCode40 = (hashCode39 + (str14 != null ? str14.hashCode() : 0)) * 37;
        TravelMode travelMode2 = this.travelMode;
        int hashCode41 = (hashCode40 + (travelMode2 != null ? travelMode2.hashCode() : 0)) * 37;
        Long l7 = this.odPointsTimestamp;
        int hashCode42 = (hashCode41 + (l7 != null ? l7.hashCode() : 0)) * 37;
        OpenSdkInfo openSdkInfo2 = this.openSdkInfo;
        int hashCode43 = (hashCode42 + (openSdkInfo2 != null ? openSdkInfo2.hashCode() : 0)) * 37;
        ByteString byteString2 = this.extendData;
        int hashCode44 = (hashCode43 + (byteString2 != null ? byteString2.hashCode() : 0)) * 37;
        DebugInfo debugInfo2 = this.debugInfo;
        int hashCode45 = (hashCode44 + (debugInfo2 != null ? debugInfo2.hashCode() : 0)) * 37;
        Integer num9 = this.bizGroup;
        int hashCode46 = (hashCode45 + (num9 != null ? num9.hashCode() : 0)) * 37;
        Msg2PsgReq msg2PsgReq2 = this.msg2PsgReq;
        int hashCode47 = (hashCode46 + (msg2PsgReq2 != null ? msg2PsgReq2.hashCode() : 0)) * 37;
        Boolean bool6 = this.bluetoothOpen;
        if (bool6 != null) {
            i2 = bool6.hashCode();
        }
        int i3 = hashCode47 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<DriverOrderRouteReq> {
        public String amapTbtVersion;
        public Integer bizGroup;
        public Integer bizType;
        public Boolean bluetoothOpen;
        public String caller;
        public DriverConfig config;
        public String countryId;
        public Long curRouteId;
        public DebugInfo debugInfo;
        public Boolean debug_model;
        public String didiVersion;
        public Long driverId;
        public DynamicRouteReq dynamicRouteReq;
        public DoublePoint endPoint;
        public Integer eventType;
        public ByteString extendData;
        public String imei;
        public Boolean isChangeEndPoint;
        public Boolean isChangeStartPoint;
        public Long lastDiDiRouteId;
        public Integer lightNavi;
        public Long logid;
        public Msg2PsgReq msg2PsgReq;
        public Boolean noNeedGeo;
        public List<OdPoint> odPoints;
        public Long odPointsTimestamp;
        public OpenSdkInfo openSdkInfo;
        public Integer oraRetryTime;
        public String orderId;
        public Integer orderStage;
        public Long passengerId;
        public String phoneNum;
        public String productId;
        public String protoType;
        public String psgMultiRouteTraceId;
        public ByteString routeEngineReqPack;
        public String sdkmaptype;
        public DoublePoint startPoint;
        public Integer startPointAccuracy;
        public Integer startPointDirection;
        public Integer startPointSpeed;
        public Boolean sync2Psg;
        public String ticket;
        public Long timestamp;
        public HisTraj trajs;
        public TravelMode travelMode;
        public String traverId;
        public String version;

        public Builder() {
        }

        public Builder(DriverOrderRouteReq driverOrderRouteReq) {
            super(driverOrderRouteReq);
            if (driverOrderRouteReq != null) {
                this.orderId = driverOrderRouteReq.orderId;
                this.phoneNum = driverOrderRouteReq.phoneNum;
                this.orderStage = driverOrderRouteReq.orderStage;
                this.bizType = driverOrderRouteReq.bizType;
                this.startPoint = driverOrderRouteReq.startPoint;
                this.startPointSpeed = driverOrderRouteReq.startPointSpeed;
                this.startPointDirection = driverOrderRouteReq.startPointDirection;
                this.startPointAccuracy = driverOrderRouteReq.startPointAccuracy;
                this.endPoint = driverOrderRouteReq.endPoint;
                this.eventType = driverOrderRouteReq.eventType;
                this.timestamp = driverOrderRouteReq.timestamp;
                this.imei = driverOrderRouteReq.imei;
                this.routeEngineReqPack = driverOrderRouteReq.routeEngineReqPack;
                this.version = driverOrderRouteReq.version;
                this.ticket = driverOrderRouteReq.ticket;
                this.passengerId = driverOrderRouteReq.passengerId;
                this.driverId = driverOrderRouteReq.driverId;
                this.traverId = driverOrderRouteReq.traverId;
                this.lastDiDiRouteId = driverOrderRouteReq.lastDiDiRouteId;
                this.trajs = driverOrderRouteReq.trajs;
                this.sdkmaptype = driverOrderRouteReq.sdkmaptype;
                this.logid = driverOrderRouteReq.logid;
                this.amapTbtVersion = driverOrderRouteReq.amapTbtVersion;
                this.oraRetryTime = driverOrderRouteReq.oraRetryTime;
                this.lightNavi = driverOrderRouteReq.lightNavi;
                this.didiVersion = driverOrderRouteReq.didiVersion;
                this.config = driverOrderRouteReq.config;
                this.dynamicRouteReq = driverOrderRouteReq.dynamicRouteReq;
                this.isChangeStartPoint = driverOrderRouteReq.isChangeStartPoint;
                this.isChangeEndPoint = driverOrderRouteReq.isChangeEndPoint;
                this.protoType = driverOrderRouteReq.protoType;
                this.debug_model = driverOrderRouteReq.debug_model;
                this.caller = driverOrderRouteReq.caller;
                this.odPoints = DriverOrderRouteReq.copyOf(driverOrderRouteReq.odPoints);
                this.productId = driverOrderRouteReq.productId;
                this.countryId = driverOrderRouteReq.countryId;
                this.curRouteId = driverOrderRouteReq.curRouteId;
                this.noNeedGeo = driverOrderRouteReq.noNeedGeo;
                this.sync2Psg = driverOrderRouteReq.sync2Psg;
                this.psgMultiRouteTraceId = driverOrderRouteReq.psgMultiRouteTraceId;
                this.travelMode = driverOrderRouteReq.travelMode;
                this.odPointsTimestamp = driverOrderRouteReq.odPointsTimestamp;
                this.openSdkInfo = driverOrderRouteReq.openSdkInfo;
                this.extendData = driverOrderRouteReq.extendData;
                this.debugInfo = driverOrderRouteReq.debugInfo;
                this.bizGroup = driverOrderRouteReq.bizGroup;
                this.msg2PsgReq = driverOrderRouteReq.msg2PsgReq;
                this.bluetoothOpen = driverOrderRouteReq.bluetoothOpen;
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

        public Builder orderStage(Integer num) {
            this.orderStage = num;
            return this;
        }

        public Builder bizType(Integer num) {
            this.bizType = num;
            return this;
        }

        public Builder startPoint(DoublePoint doublePoint) {
            this.startPoint = doublePoint;
            return this;
        }

        public Builder startPointSpeed(Integer num) {
            this.startPointSpeed = num;
            return this;
        }

        public Builder startPointDirection(Integer num) {
            this.startPointDirection = num;
            return this;
        }

        public Builder startPointAccuracy(Integer num) {
            this.startPointAccuracy = num;
            return this;
        }

        public Builder endPoint(DoublePoint doublePoint) {
            this.endPoint = doublePoint;
            return this;
        }

        public Builder eventType(Integer num) {
            this.eventType = num;
            return this;
        }

        public Builder timestamp(Long l) {
            this.timestamp = l;
            return this;
        }

        public Builder imei(String str) {
            this.imei = str;
            return this;
        }

        public Builder routeEngineReqPack(ByteString byteString) {
            this.routeEngineReqPack = byteString;
            return this;
        }

        public Builder version(String str) {
            this.version = str;
            return this;
        }

        public Builder ticket(String str) {
            this.ticket = str;
            return this;
        }

        public Builder passengerId(Long l) {
            this.passengerId = l;
            return this;
        }

        public Builder driverId(Long l) {
            this.driverId = l;
            return this;
        }

        public Builder traverId(String str) {
            this.traverId = str;
            return this;
        }

        public Builder lastDiDiRouteId(Long l) {
            this.lastDiDiRouteId = l;
            return this;
        }

        public Builder trajs(HisTraj hisTraj) {
            this.trajs = hisTraj;
            return this;
        }

        public Builder sdkmaptype(String str) {
            this.sdkmaptype = str;
            return this;
        }

        public Builder logid(Long l) {
            this.logid = l;
            return this;
        }

        public Builder amapTbtVersion(String str) {
            this.amapTbtVersion = str;
            return this;
        }

        public Builder oraRetryTime(Integer num) {
            this.oraRetryTime = num;
            return this;
        }

        public Builder lightNavi(Integer num) {
            this.lightNavi = num;
            return this;
        }

        public Builder didiVersion(String str) {
            this.didiVersion = str;
            return this;
        }

        public Builder config(DriverConfig driverConfig) {
            this.config = driverConfig;
            return this;
        }

        public Builder dynamicRouteReq(DynamicRouteReq dynamicRouteReq2) {
            this.dynamicRouteReq = dynamicRouteReq2;
            return this;
        }

        public Builder isChangeStartPoint(Boolean bool) {
            this.isChangeStartPoint = bool;
            return this;
        }

        public Builder isChangeEndPoint(Boolean bool) {
            this.isChangeEndPoint = bool;
            return this;
        }

        public Builder protoType(String str) {
            this.protoType = str;
            return this;
        }

        public Builder debug_model(Boolean bool) {
            this.debug_model = bool;
            return this;
        }

        public Builder caller(String str) {
            this.caller = str;
            return this;
        }

        public Builder odPoints(List<OdPoint> list) {
            this.odPoints = checkForNulls(list);
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

        public Builder curRouteId(Long l) {
            this.curRouteId = l;
            return this;
        }

        public Builder noNeedGeo(Boolean bool) {
            this.noNeedGeo = bool;
            return this;
        }

        public Builder sync2Psg(Boolean bool) {
            this.sync2Psg = bool;
            return this;
        }

        public Builder psgMultiRouteTraceId(String str) {
            this.psgMultiRouteTraceId = str;
            return this;
        }

        public Builder travelMode(TravelMode travelMode2) {
            this.travelMode = travelMode2;
            return this;
        }

        public Builder odPointsTimestamp(Long l) {
            this.odPointsTimestamp = l;
            return this;
        }

        public Builder openSdkInfo(OpenSdkInfo openSdkInfo2) {
            this.openSdkInfo = openSdkInfo2;
            return this;
        }

        public Builder extendData(ByteString byteString) {
            this.extendData = byteString;
            return this;
        }

        public Builder debugInfo(DebugInfo debugInfo2) {
            this.debugInfo = debugInfo2;
            return this;
        }

        public Builder bizGroup(Integer num) {
            this.bizGroup = num;
            return this;
        }

        public Builder msg2PsgReq(Msg2PsgReq msg2PsgReq2) {
            this.msg2PsgReq = msg2PsgReq2;
            return this;
        }

        public Builder bluetoothOpen(Boolean bool) {
            this.bluetoothOpen = bool;
            return this;
        }

        public DriverOrderRouteReq build() {
            checkRequiredFields();
            return new DriverOrderRouteReq(this);
        }
    }
}
