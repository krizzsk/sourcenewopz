package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;
import okio.ByteString;

public final class MapPassengeOrderRouteRes extends Message {
    public static final String DEFAULT_CHOOSESRCPOIMSG = "";
    public static final Integer DEFAULT_CURDSTROUTEGEOINDEX = 0;
    public static final String DEFAULT_DEBUGMSG = "";
    public static final Integer DEFAULT_DIRECTION = 0;
    public static final Integer DEFAULT_DISTANCE = -1;
    public static final Boolean DEFAULT_DRIVERBLUETOOTHOPEN = false;
    public static final Integer DEFAULT_DRVGEODISTANCEM = 0;
    public static final Integer DEFAULT_DRVGEOINDEX = -1;
    public static final Long DEFAULT_DRVLOCTIMESTAMP = 0L;
    public static final Integer DEFAULT_ETA = -1;
    public static final String DEFAULT_ETASTR = "";
    public static final Integer DEFAULT_GPBUBBLEFROMTYPE = 0;
    public static final ByteString DEFAULT_GUIDEPOINTCOPYWRITING = ByteString.EMPTY;
    public static final String DEFAULT_INHERITFAILEDTIPS = "";
    public static final Long DEFAULT_LOGID = 0L;
    public static final String DEFAULT_MSG = "";
    public static final List<RouteMsg> DEFAULT_NAVIMSGS = Collections.emptyList();
    public static final List<OdPoint> DEFAULT_ODPOINTS = Collections.emptyList();
    public static final Integer DEFAULT_REACHTERMINAL = 0;
    public static final Integer DEFAULT_RET = 0;
    public static final List<RoadNameItem> DEFAULT_ROADNAME = Collections.emptyList();
    public static final Long DEFAULT_ROUTEDBID = 0L;
    public static final ByteString DEFAULT_ROUTEENGINERESPACK = ByteString.EMPTY;
    public static final String DEFAULT_ROUTEENGINETYPE = "";
    public static final Long DEFAULT_ROUTEID = 0L;
    public static final String DEFAULT_ROUTESTRING = "";
    public static final Integer DEFAULT_SCTXVERSION = 0;
    public static final List<TrafficItem> DEFAULT_TRAFFIC = Collections.emptyList();
    public static final ByteString DEFAULT_TRAFFICEVENT = ByteString.EMPTY;
    public static final Long DEFAULT_TRAFFICVERSION = 0L;
    @ProtoField(tag = 100, type = Message.Datatype.STRING)
    public final String RouteString;
    @ProtoField(tag = 30, type = Message.Datatype.STRING)
    public final String chooseSrcPoiMsg;
    @ProtoField(tag = 32, type = Message.Datatype.INT32)
    public final Integer curDstRouteGeoIndex;
    @ProtoField(tag = 17, type = Message.Datatype.STRING)
    public final String debugMsg;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer direction;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer distance;
    @ProtoField(tag = 34, type = Message.Datatype.BOOL)
    public final Boolean driverBluetoothOpen;
    @ProtoField(tag = 4)
    public final DoublePoint driverPoint;
    @ProtoField(tag = 27, type = Message.Datatype.INT32)
    public final Integer drvGeoDistanceM;
    @ProtoField(tag = 26, type = Message.Datatype.INT32)
    public final Integer drvGeoIndex;
    @ProtoField(tag = 23, type = Message.Datatype.INT64)
    public final Long drvLocTimestamp;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer eta;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String etaStr;
    @ProtoField(tag = 31, type = Message.Datatype.INT32)
    public final Integer gpBubbleFromType;
    @ProtoField(tag = 21, type = Message.Datatype.BYTES)
    public final ByteString guidePointCopywriting;
    @ProtoField(tag = 29, type = Message.Datatype.STRING)
    public final String inheritFailedTips;
    @ProtoField(tag = 11, type = Message.Datatype.UINT64)
    public final Long logId;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.STRING)
    public final String msg;
    @ProtoField(label = Message.Label.REPEATED, messageType = RouteMsg.class, tag = 15)
    public final List<RouteMsg> naviMsgs;
    @ProtoField(label = Message.Label.REPEATED, messageType = OdPoint.class, tag = 18)
    public final List<OdPoint> odPoints;
    @ProtoField(tag = 14, type = Message.Datatype.INT32)
    public final Integer reachTerminal;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.INT32)
    public final Integer ret;
    @ProtoField(tag = 22)

    /* renamed from: rf */
    public final RouteFeature f28604rf;
    @ProtoField(label = Message.Label.REPEATED, messageType = RoadNameItem.class, tag = 25)
    public final List<RoadNameItem> roadName;
    @ProtoField(tag = 19, type = Message.Datatype.UINT64)
    public final Long routeDbId;
    @ProtoField(tag = 9, type = Message.Datatype.BYTES)
    public final ByteString routeEngineResPack;
    @ProtoField(tag = 16, type = Message.Datatype.STRING)
    public final String routeEngineType;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long routeId;
    @ProtoField(tag = 12)
    public final DiffGeoPoints routePoints;
    @ProtoField(tag = 20, type = Message.Datatype.INT32)
    public final Integer sctxVersion;
    @ProtoField(tag = 33)
    public final SecRouteInfo secRouteInfo;
    @ProtoField(label = Message.Label.REPEATED, messageType = TrafficItem.class, tag = 13)
    public final List<TrafficItem> traffic;
    @ProtoField(tag = 24, type = Message.Datatype.BYTES)
    public final ByteString trafficEvent;
    @ProtoField(tag = 28, type = Message.Datatype.INT64)
    public final Long trafficVersion;
    @ProtoField(tag = 10)
    public final DiffGeoPoints trajPoints;

    public MapPassengeOrderRouteRes(Integer num, String str, Long l, DoublePoint doublePoint, Integer num2, String str2, Integer num3, Integer num4, ByteString byteString, DiffGeoPoints diffGeoPoints, Long l2, DiffGeoPoints diffGeoPoints2, List<TrafficItem> list, Integer num5, List<RouteMsg> list2, String str3, String str4, List<OdPoint> list3, Long l3, Integer num6, ByteString byteString2, RouteFeature routeFeature, Long l4, ByteString byteString3, List<RoadNameItem> list4, Integer num7, Integer num8, Long l5, String str5, String str6, Integer num9, Integer num10, SecRouteInfo secRouteInfo2, Boolean bool, String str7) {
        this.ret = num;
        this.msg = str;
        this.routeId = l;
        this.driverPoint = doublePoint;
        this.eta = num2;
        this.etaStr = str2;
        this.distance = num3;
        this.direction = num4;
        this.routeEngineResPack = byteString;
        this.trajPoints = diffGeoPoints;
        this.logId = l2;
        this.routePoints = diffGeoPoints2;
        this.traffic = immutableCopyOf(list);
        this.reachTerminal = num5;
        this.naviMsgs = immutableCopyOf(list2);
        this.routeEngineType = str3;
        this.debugMsg = str4;
        this.odPoints = immutableCopyOf(list3);
        this.routeDbId = l3;
        this.sctxVersion = num6;
        this.guidePointCopywriting = byteString2;
        this.f28604rf = routeFeature;
        this.drvLocTimestamp = l4;
        this.trafficEvent = byteString3;
        this.roadName = immutableCopyOf(list4);
        this.drvGeoIndex = num7;
        this.drvGeoDistanceM = num8;
        this.trafficVersion = l5;
        this.inheritFailedTips = str5;
        this.chooseSrcPoiMsg = str6;
        this.gpBubbleFromType = num9;
        this.curDstRouteGeoIndex = num10;
        this.secRouteInfo = secRouteInfo2;
        this.driverBluetoothOpen = bool;
        this.RouteString = str7;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private MapPassengeOrderRouteRes(com.didi.map.sdk.proto.driver_gl.MapPassengeOrderRouteRes.Builder r39) {
        /*
            r38 = this;
            r0 = r39
            r1 = r38
            java.lang.Integer r2 = r0.ret
            java.lang.String r3 = r0.msg
            java.lang.Long r4 = r0.routeId
            com.didi.map.sdk.proto.driver_gl.DoublePoint r5 = r0.driverPoint
            java.lang.Integer r6 = r0.eta
            java.lang.String r7 = r0.etaStr
            java.lang.Integer r8 = r0.distance
            java.lang.Integer r9 = r0.direction
            okio.ByteString r10 = r0.routeEngineResPack
            com.didi.map.sdk.proto.driver_gl.DiffGeoPoints r11 = r0.trajPoints
            java.lang.Long r12 = r0.logId
            com.didi.map.sdk.proto.driver_gl.DiffGeoPoints r13 = r0.routePoints
            java.util.List<com.didi.map.sdk.proto.driver_gl.TrafficItem> r14 = r0.traffic
            java.lang.Integer r15 = r0.reachTerminal
            r37 = r1
            java.util.List<com.didi.map.sdk.proto.driver_gl.RouteMsg> r1 = r0.naviMsgs
            r16 = r1
            java.lang.String r1 = r0.routeEngineType
            r17 = r1
            java.lang.String r1 = r0.debugMsg
            r18 = r1
            java.util.List<com.didi.map.sdk.proto.driver_gl.OdPoint> r1 = r0.odPoints
            r19 = r1
            java.lang.Long r1 = r0.routeDbId
            r20 = r1
            java.lang.Integer r1 = r0.sctxVersion
            r21 = r1
            okio.ByteString r1 = r0.guidePointCopywriting
            r22 = r1
            com.didi.map.sdk.proto.driver_gl.RouteFeature r1 = r0.f28605rf
            r23 = r1
            java.lang.Long r1 = r0.drvLocTimestamp
            r24 = r1
            okio.ByteString r1 = r0.trafficEvent
            r25 = r1
            java.util.List<com.didi.map.sdk.proto.driver_gl.RoadNameItem> r1 = r0.roadName
            r26 = r1
            java.lang.Integer r1 = r0.drvGeoIndex
            r27 = r1
            java.lang.Integer r1 = r0.drvGeoDistanceM
            r28 = r1
            java.lang.Long r1 = r0.trafficVersion
            r29 = r1
            java.lang.String r1 = r0.inheritFailedTips
            r30 = r1
            java.lang.String r1 = r0.chooseSrcPoiMsg
            r31 = r1
            java.lang.Integer r1 = r0.gpBubbleFromType
            r32 = r1
            java.lang.Integer r1 = r0.curDstRouteGeoIndex
            r33 = r1
            com.didi.map.sdk.proto.driver_gl.SecRouteInfo r1 = r0.secRouteInfo
            r34 = r1
            java.lang.Boolean r1 = r0.driverBluetoothOpen
            r35 = r1
            java.lang.String r1 = r0.RouteString
            r36 = r1
            r1 = r37
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36)
            r38.setBuilder(r39)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.sdk.proto.driver_gl.MapPassengeOrderRouteRes.<init>(com.didi.map.sdk.proto.driver_gl.MapPassengeOrderRouteRes$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MapPassengeOrderRouteRes)) {
            return false;
        }
        MapPassengeOrderRouteRes mapPassengeOrderRouteRes = (MapPassengeOrderRouteRes) obj;
        if (!equals((Object) this.ret, (Object) mapPassengeOrderRouteRes.ret) || !equals((Object) this.msg, (Object) mapPassengeOrderRouteRes.msg) || !equals((Object) this.routeId, (Object) mapPassengeOrderRouteRes.routeId) || !equals((Object) this.driverPoint, (Object) mapPassengeOrderRouteRes.driverPoint) || !equals((Object) this.eta, (Object) mapPassengeOrderRouteRes.eta) || !equals((Object) this.etaStr, (Object) mapPassengeOrderRouteRes.etaStr) || !equals((Object) this.distance, (Object) mapPassengeOrderRouteRes.distance) || !equals((Object) this.direction, (Object) mapPassengeOrderRouteRes.direction) || !equals((Object) this.routeEngineResPack, (Object) mapPassengeOrderRouteRes.routeEngineResPack) || !equals((Object) this.trajPoints, (Object) mapPassengeOrderRouteRes.trajPoints) || !equals((Object) this.logId, (Object) mapPassengeOrderRouteRes.logId) || !equals((Object) this.routePoints, (Object) mapPassengeOrderRouteRes.routePoints) || !equals((List<?>) this.traffic, (List<?>) mapPassengeOrderRouteRes.traffic) || !equals((Object) this.reachTerminal, (Object) mapPassengeOrderRouteRes.reachTerminal) || !equals((List<?>) this.naviMsgs, (List<?>) mapPassengeOrderRouteRes.naviMsgs) || !equals((Object) this.routeEngineType, (Object) mapPassengeOrderRouteRes.routeEngineType) || !equals((Object) this.debugMsg, (Object) mapPassengeOrderRouteRes.debugMsg) || !equals((List<?>) this.odPoints, (List<?>) mapPassengeOrderRouteRes.odPoints) || !equals((Object) this.routeDbId, (Object) mapPassengeOrderRouteRes.routeDbId) || !equals((Object) this.sctxVersion, (Object) mapPassengeOrderRouteRes.sctxVersion) || !equals((Object) this.guidePointCopywriting, (Object) mapPassengeOrderRouteRes.guidePointCopywriting) || !equals((Object) this.f28604rf, (Object) mapPassengeOrderRouteRes.f28604rf) || !equals((Object) this.drvLocTimestamp, (Object) mapPassengeOrderRouteRes.drvLocTimestamp) || !equals((Object) this.trafficEvent, (Object) mapPassengeOrderRouteRes.trafficEvent) || !equals((List<?>) this.roadName, (List<?>) mapPassengeOrderRouteRes.roadName) || !equals((Object) this.drvGeoIndex, (Object) mapPassengeOrderRouteRes.drvGeoIndex) || !equals((Object) this.drvGeoDistanceM, (Object) mapPassengeOrderRouteRes.drvGeoDistanceM) || !equals((Object) this.trafficVersion, (Object) mapPassengeOrderRouteRes.trafficVersion) || !equals((Object) this.inheritFailedTips, (Object) mapPassengeOrderRouteRes.inheritFailedTips) || !equals((Object) this.chooseSrcPoiMsg, (Object) mapPassengeOrderRouteRes.chooseSrcPoiMsg) || !equals((Object) this.gpBubbleFromType, (Object) mapPassengeOrderRouteRes.gpBubbleFromType) || !equals((Object) this.curDstRouteGeoIndex, (Object) mapPassengeOrderRouteRes.curDstRouteGeoIndex) || !equals((Object) this.secRouteInfo, (Object) mapPassengeOrderRouteRes.secRouteInfo) || !equals((Object) this.driverBluetoothOpen, (Object) mapPassengeOrderRouteRes.driverBluetoothOpen) || !equals((Object) this.RouteString, (Object) mapPassengeOrderRouteRes.RouteString)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.ret;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        String str = this.msg;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        Long l = this.routeId;
        int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 37;
        DoublePoint doublePoint = this.driverPoint;
        int hashCode4 = (hashCode3 + (doublePoint != null ? doublePoint.hashCode() : 0)) * 37;
        Integer num2 = this.eta;
        int hashCode5 = (hashCode4 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str2 = this.etaStr;
        int hashCode6 = (hashCode5 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num3 = this.distance;
        int hashCode7 = (hashCode6 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.direction;
        int hashCode8 = (hashCode7 + (num4 != null ? num4.hashCode() : 0)) * 37;
        ByteString byteString = this.routeEngineResPack;
        int hashCode9 = (hashCode8 + (byteString != null ? byteString.hashCode() : 0)) * 37;
        DiffGeoPoints diffGeoPoints = this.trajPoints;
        int hashCode10 = (hashCode9 + (diffGeoPoints != null ? diffGeoPoints.hashCode() : 0)) * 37;
        Long l2 = this.logId;
        int hashCode11 = (hashCode10 + (l2 != null ? l2.hashCode() : 0)) * 37;
        DiffGeoPoints diffGeoPoints2 = this.routePoints;
        int hashCode12 = (hashCode11 + (diffGeoPoints2 != null ? diffGeoPoints2.hashCode() : 0)) * 37;
        List<TrafficItem> list = this.traffic;
        int i3 = 1;
        int hashCode13 = (hashCode12 + (list != null ? list.hashCode() : 1)) * 37;
        Integer num5 = this.reachTerminal;
        int hashCode14 = (hashCode13 + (num5 != null ? num5.hashCode() : 0)) * 37;
        List<RouteMsg> list2 = this.naviMsgs;
        int hashCode15 = (hashCode14 + (list2 != null ? list2.hashCode() : 1)) * 37;
        String str3 = this.routeEngineType;
        int hashCode16 = (hashCode15 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.debugMsg;
        int hashCode17 = (hashCode16 + (str4 != null ? str4.hashCode() : 0)) * 37;
        List<OdPoint> list3 = this.odPoints;
        int hashCode18 = (hashCode17 + (list3 != null ? list3.hashCode() : 1)) * 37;
        Long l3 = this.routeDbId;
        int hashCode19 = (hashCode18 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Integer num6 = this.sctxVersion;
        int hashCode20 = (hashCode19 + (num6 != null ? num6.hashCode() : 0)) * 37;
        ByteString byteString2 = this.guidePointCopywriting;
        int hashCode21 = (hashCode20 + (byteString2 != null ? byteString2.hashCode() : 0)) * 37;
        RouteFeature routeFeature = this.f28604rf;
        int hashCode22 = (hashCode21 + (routeFeature != null ? routeFeature.hashCode() : 0)) * 37;
        Long l4 = this.drvLocTimestamp;
        int hashCode23 = (hashCode22 + (l4 != null ? l4.hashCode() : 0)) * 37;
        ByteString byteString3 = this.trafficEvent;
        int hashCode24 = (hashCode23 + (byteString3 != null ? byteString3.hashCode() : 0)) * 37;
        List<RoadNameItem> list4 = this.roadName;
        if (list4 != null) {
            i3 = list4.hashCode();
        }
        int i4 = (hashCode24 + i3) * 37;
        Integer num7 = this.drvGeoIndex;
        int hashCode25 = (i4 + (num7 != null ? num7.hashCode() : 0)) * 37;
        Integer num8 = this.drvGeoDistanceM;
        int hashCode26 = (hashCode25 + (num8 != null ? num8.hashCode() : 0)) * 37;
        Long l5 = this.trafficVersion;
        int hashCode27 = (hashCode26 + (l5 != null ? l5.hashCode() : 0)) * 37;
        String str5 = this.inheritFailedTips;
        int hashCode28 = (hashCode27 + (str5 != null ? str5.hashCode() : 0)) * 37;
        String str6 = this.chooseSrcPoiMsg;
        int hashCode29 = (hashCode28 + (str6 != null ? str6.hashCode() : 0)) * 37;
        Integer num9 = this.gpBubbleFromType;
        int hashCode30 = (hashCode29 + (num9 != null ? num9.hashCode() : 0)) * 37;
        Integer num10 = this.curDstRouteGeoIndex;
        int hashCode31 = (hashCode30 + (num10 != null ? num10.hashCode() : 0)) * 37;
        SecRouteInfo secRouteInfo2 = this.secRouteInfo;
        int hashCode32 = (hashCode31 + (secRouteInfo2 != null ? secRouteInfo2.hashCode() : 0)) * 37;
        Boolean bool = this.driverBluetoothOpen;
        int hashCode33 = (hashCode32 + (bool != null ? bool.hashCode() : 0)) * 37;
        String str7 = this.RouteString;
        if (str7 != null) {
            i2 = str7.hashCode();
        }
        int i5 = hashCode33 + i2;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<MapPassengeOrderRouteRes> {
        public String RouteString;
        public String chooseSrcPoiMsg;
        public Integer curDstRouteGeoIndex;
        public String debugMsg;
        public Integer direction;
        public Integer distance;
        public Boolean driverBluetoothOpen;
        public DoublePoint driverPoint;
        public Integer drvGeoDistanceM;
        public Integer drvGeoIndex;
        public Long drvLocTimestamp;
        public Integer eta;
        public String etaStr;
        public Integer gpBubbleFromType;
        public ByteString guidePointCopywriting;
        public String inheritFailedTips;
        public Long logId;
        public String msg;
        public List<RouteMsg> naviMsgs;
        public List<OdPoint> odPoints;
        public Integer reachTerminal;
        public Integer ret;

        /* renamed from: rf */
        public RouteFeature f28605rf;
        public List<RoadNameItem> roadName;
        public Long routeDbId;
        public ByteString routeEngineResPack;
        public String routeEngineType;
        public Long routeId;
        public DiffGeoPoints routePoints;
        public Integer sctxVersion;
        public SecRouteInfo secRouteInfo;
        public List<TrafficItem> traffic;
        public ByteString trafficEvent;
        public Long trafficVersion;
        public DiffGeoPoints trajPoints;

        public Builder() {
        }

        public Builder(MapPassengeOrderRouteRes mapPassengeOrderRouteRes) {
            super(mapPassengeOrderRouteRes);
            if (mapPassengeOrderRouteRes != null) {
                this.ret = mapPassengeOrderRouteRes.ret;
                this.msg = mapPassengeOrderRouteRes.msg;
                this.routeId = mapPassengeOrderRouteRes.routeId;
                this.driverPoint = mapPassengeOrderRouteRes.driverPoint;
                this.eta = mapPassengeOrderRouteRes.eta;
                this.etaStr = mapPassengeOrderRouteRes.etaStr;
                this.distance = mapPassengeOrderRouteRes.distance;
                this.direction = mapPassengeOrderRouteRes.direction;
                this.routeEngineResPack = mapPassengeOrderRouteRes.routeEngineResPack;
                this.trajPoints = mapPassengeOrderRouteRes.trajPoints;
                this.logId = mapPassengeOrderRouteRes.logId;
                this.routePoints = mapPassengeOrderRouteRes.routePoints;
                this.traffic = MapPassengeOrderRouteRes.copyOf(mapPassengeOrderRouteRes.traffic);
                this.reachTerminal = mapPassengeOrderRouteRes.reachTerminal;
                this.naviMsgs = MapPassengeOrderRouteRes.copyOf(mapPassengeOrderRouteRes.naviMsgs);
                this.routeEngineType = mapPassengeOrderRouteRes.routeEngineType;
                this.debugMsg = mapPassengeOrderRouteRes.debugMsg;
                this.odPoints = MapPassengeOrderRouteRes.copyOf(mapPassengeOrderRouteRes.odPoints);
                this.routeDbId = mapPassengeOrderRouteRes.routeDbId;
                this.sctxVersion = mapPassengeOrderRouteRes.sctxVersion;
                this.guidePointCopywriting = mapPassengeOrderRouteRes.guidePointCopywriting;
                this.f28605rf = mapPassengeOrderRouteRes.f28604rf;
                this.drvLocTimestamp = mapPassengeOrderRouteRes.drvLocTimestamp;
                this.trafficEvent = mapPassengeOrderRouteRes.trafficEvent;
                this.roadName = MapPassengeOrderRouteRes.copyOf(mapPassengeOrderRouteRes.roadName);
                this.drvGeoIndex = mapPassengeOrderRouteRes.drvGeoIndex;
                this.drvGeoDistanceM = mapPassengeOrderRouteRes.drvGeoDistanceM;
                this.trafficVersion = mapPassengeOrderRouteRes.trafficVersion;
                this.inheritFailedTips = mapPassengeOrderRouteRes.inheritFailedTips;
                this.chooseSrcPoiMsg = mapPassengeOrderRouteRes.chooseSrcPoiMsg;
                this.gpBubbleFromType = mapPassengeOrderRouteRes.gpBubbleFromType;
                this.curDstRouteGeoIndex = mapPassengeOrderRouteRes.curDstRouteGeoIndex;
                this.secRouteInfo = mapPassengeOrderRouteRes.secRouteInfo;
                this.driverBluetoothOpen = mapPassengeOrderRouteRes.driverBluetoothOpen;
                this.RouteString = mapPassengeOrderRouteRes.RouteString;
            }
        }

        public Builder ret(Integer num) {
            this.ret = num;
            return this;
        }

        public Builder msg(String str) {
            this.msg = str;
            return this;
        }

        public Builder routeId(Long l) {
            this.routeId = l;
            return this;
        }

        public Builder driverPoint(DoublePoint doublePoint) {
            this.driverPoint = doublePoint;
            return this;
        }

        public Builder eta(Integer num) {
            this.eta = num;
            return this;
        }

        public Builder etaStr(String str) {
            this.etaStr = str;
            return this;
        }

        public Builder distance(Integer num) {
            this.distance = num;
            return this;
        }

        public Builder direction(Integer num) {
            this.direction = num;
            return this;
        }

        public Builder routeEngineResPack(ByteString byteString) {
            this.routeEngineResPack = byteString;
            return this;
        }

        public Builder trajPoints(DiffGeoPoints diffGeoPoints) {
            this.trajPoints = diffGeoPoints;
            return this;
        }

        public Builder logId(Long l) {
            this.logId = l;
            return this;
        }

        public Builder routePoints(DiffGeoPoints diffGeoPoints) {
            this.routePoints = diffGeoPoints;
            return this;
        }

        public Builder traffic(List<TrafficItem> list) {
            this.traffic = checkForNulls(list);
            return this;
        }

        public Builder reachTerminal(Integer num) {
            this.reachTerminal = num;
            return this;
        }

        public Builder naviMsgs(List<RouteMsg> list) {
            this.naviMsgs = checkForNulls(list);
            return this;
        }

        public Builder routeEngineType(String str) {
            this.routeEngineType = str;
            return this;
        }

        public Builder debugMsg(String str) {
            this.debugMsg = str;
            return this;
        }

        public Builder odPoints(List<OdPoint> list) {
            this.odPoints = checkForNulls(list);
            return this;
        }

        public Builder routeDbId(Long l) {
            this.routeDbId = l;
            return this;
        }

        public Builder sctxVersion(Integer num) {
            this.sctxVersion = num;
            return this;
        }

        public Builder guidePointCopywriting(ByteString byteString) {
            this.guidePointCopywriting = byteString;
            return this;
        }

        /* renamed from: rf */
        public Builder mo78353rf(RouteFeature routeFeature) {
            this.f28605rf = routeFeature;
            return this;
        }

        public Builder drvLocTimestamp(Long l) {
            this.drvLocTimestamp = l;
            return this;
        }

        public Builder trafficEvent(ByteString byteString) {
            this.trafficEvent = byteString;
            return this;
        }

        public Builder roadName(List<RoadNameItem> list) {
            this.roadName = checkForNulls(list);
            return this;
        }

        public Builder drvGeoIndex(Integer num) {
            this.drvGeoIndex = num;
            return this;
        }

        public Builder drvGeoDistanceM(Integer num) {
            this.drvGeoDistanceM = num;
            return this;
        }

        public Builder trafficVersion(Long l) {
            this.trafficVersion = l;
            return this;
        }

        public Builder inheritFailedTips(String str) {
            this.inheritFailedTips = str;
            return this;
        }

        public Builder chooseSrcPoiMsg(String str) {
            this.chooseSrcPoiMsg = str;
            return this;
        }

        public Builder gpBubbleFromType(Integer num) {
            this.gpBubbleFromType = num;
            return this;
        }

        public Builder curDstRouteGeoIndex(Integer num) {
            this.curDstRouteGeoIndex = num;
            return this;
        }

        public Builder secRouteInfo(SecRouteInfo secRouteInfo2) {
            this.secRouteInfo = secRouteInfo2;
            return this;
        }

        public Builder driverBluetoothOpen(Boolean bool) {
            this.driverBluetoothOpen = bool;
            return this;
        }

        public Builder RouteString(String str) {
            this.RouteString = str;
            return this;
        }

        public MapPassengeOrderRouteRes build() {
            checkRequiredFields();
            return new MapPassengeOrderRouteRes(this);
        }
    }
}
