package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;
import okio.ByteString;

public final class DriverOrderRouteRes extends Message {
    public static final Double DEFAULT_CONFIDENCE = Double.valueOf(0.0d);
    public static final Integer DEFAULT_CURDSTROUTEGEOINDEX = 0;
    public static final String DEFAULT_DEBUGMSG = "";
    public static final Integer DEFAULT_DISTANCE = -1;
    public static final Integer DEFAULT_ETA = -1;
    public static final ByteString DEFAULT_EVENT = ByteString.EMPTY;
    public static final ByteString DEFAULT_EXTENDDATA = ByteString.EMPTY;
    public static final Integer DEFAULT_ISMULTIROUTE = 0;
    public static final List<RouteInfo> DEFAULT_LINKINFOS = Collections.emptyList();
    public static final Long DEFAULT_LOGID = 0L;
    public static final Boolean DEFAULT_MANDATORY = false;
    public static final ByteString DEFAULT_MOCKTRAJ = ByteString.EMPTY;
    public static final String DEFAULT_MSG = "";
    public static final Integer DEFAULT_NAVIADDTIONALLINE = 0;
    public static final Integer DEFAULT_NAVIFLAG = 0;
    public static final List<OdPoint> DEFAULT_ODPOINTS = Collections.emptyList();
    public static final Integer DEFAULT_POINTPARKING = 0;
    public static final String DEFAULT_RECOMMENDINFO = "";
    public static final Integer DEFAULT_RET = 0;
    public static final List<RouteFeature> DEFAULT_RF = Collections.emptyList();
    public static final ByteString DEFAULT_RISEPBBIN = ByteString.EMPTY;
    public static final Long DEFAULT_ROUTEDBID = 0L;
    public static final ByteString DEFAULT_ROUTEENGINERESPACK = ByteString.EMPTY;
    public static final List<DiffGeoPoints> DEFAULT_ROUTEGEOS = Collections.emptyList();
    public static final List<Long> DEFAULT_ROUTEIDS = Collections.emptyList();
    public static final Integer DEFAULT_SCTXVERSION = 0;
    public static final List<ToastData> DEFAULT_TOASTLIST = Collections.emptyList();
    public static final String DEFAULT_TRACEID = "";
    @ProtoField(tag = 27, type = Message.Datatype.BYTES)
    public final ByteString RisePbBin;
    @ProtoField(tag = 22, type = Message.Datatype.DOUBLE)
    public final Double confidence;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer curDstRouteGeoIndex;
    @ProtoField(tag = 12, type = Message.Datatype.STRING)
    public final String debugMsg;
    @ProtoField(tag = 19, type = Message.Datatype.INT32)
    public final Integer distance;
    @ProtoField(tag = 10)
    public final DynamicRouteRes dynamicRouteRes;
    @ProtoField(tag = 18, type = Message.Datatype.INT32)
    public final Integer eta;
    @ProtoField(tag = 16, type = Message.Datatype.BYTES)
    public final ByteString event;
    @ProtoField(tag = 23, type = Message.Datatype.BYTES)
    public final ByteString extendData;
    @ProtoField(tag = 30, type = Message.Datatype.INT32)
    public final Integer isMultiRoute;
    @ProtoField(label = Message.Label.REPEATED, messageType = RouteInfo.class, tag = 8)
    public final List<RouteInfo> linkInfos;
    @ProtoField(tag = 7, type = Message.Datatype.UINT64)
    public final Long logId;
    @ProtoField(tag = 21, type = Message.Datatype.BOOL)
    public final Boolean mandatory;
    @ProtoField(tag = 11, type = Message.Datatype.BYTES)
    public final ByteString mocktraj;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.STRING)
    public final String msg;
    @ProtoField(tag = 31)
    public final Msg2PsgRes msg2PsgRes;
    @ProtoField(tag = 26, type = Message.Datatype.INT32)
    public final Integer naviAddtionalLine;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer naviFlag;
    @ProtoField(label = Message.Label.REPEATED, messageType = OdPoint.class, tag = 14)
    public final List<OdPoint> odPoints;
    @ProtoField(tag = 24)
    public final PickupHint pickupHint;
    @ProtoField(tag = 32, type = Message.Datatype.INT32)
    public final Integer pointParking;
    @ProtoField(tag = 25, type = Message.Datatype.STRING)
    public final String recommendInfo;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.INT32)
    public final Integer ret;
    @ProtoField(label = Message.Label.REPEATED, messageType = RouteFeature.class, tag = 29)

    /* renamed from: rf */
    public final List<RouteFeature> f28602rf;
    @ProtoField(tag = 13, type = Message.Datatype.UINT64)
    public final Long routeDbId;
    @ProtoField(tag = 5, type = Message.Datatype.BYTES)
    public final ByteString routeEngineResPack;
    @ProtoField(label = Message.Label.REPEATED, messageType = DiffGeoPoints.class, tag = 4)
    public final List<DiffGeoPoints> routeGeos;
    @ProtoField(label = Message.Label.REPEATED, tag = 3, type = Message.Datatype.INT64)
    public final List<Long> routeIds;
    @ProtoField(tag = 20, type = Message.Datatype.INT32)
    public final Integer sctxVersion;
    @ProtoField(tag = 15)
    public final SessionRes sessionRes;
    @ProtoField(label = Message.Label.REPEATED, messageType = ToastData.class, tag = 28)
    public final List<ToastData> toastList;
    @ProtoField(tag = 17, type = Message.Datatype.STRING)
    public final String traceId;

    public DriverOrderRouteRes(Integer num, String str, List<Long> list, List<DiffGeoPoints> list2, ByteString byteString, Integer num2, Long l, List<RouteInfo> list3, Integer num3, DynamicRouteRes dynamicRouteRes2, ByteString byteString2, String str2, Long l2, List<OdPoint> list4, SessionRes sessionRes2, ByteString byteString3, String str3, Integer num4, Integer num5, Integer num6, Boolean bool, Double d, ByteString byteString4, PickupHint pickupHint2, String str4, Integer num7, ByteString byteString5, List<ToastData> list5, List<RouteFeature> list6, Integer num8, Msg2PsgRes msg2PsgRes2, Integer num9) {
        this.ret = num;
        this.msg = str;
        this.routeIds = immutableCopyOf(list);
        this.routeGeos = immutableCopyOf(list2);
        this.routeEngineResPack = byteString;
        this.curDstRouteGeoIndex = num2;
        this.logId = l;
        this.linkInfos = immutableCopyOf(list3);
        this.naviFlag = num3;
        this.dynamicRouteRes = dynamicRouteRes2;
        this.mocktraj = byteString2;
        this.debugMsg = str2;
        this.routeDbId = l2;
        this.odPoints = immutableCopyOf(list4);
        this.sessionRes = sessionRes2;
        this.event = byteString3;
        this.traceId = str3;
        this.eta = num4;
        this.distance = num5;
        this.sctxVersion = num6;
        this.mandatory = bool;
        this.confidence = d;
        this.extendData = byteString4;
        this.pickupHint = pickupHint2;
        this.recommendInfo = str4;
        this.naviAddtionalLine = num7;
        this.RisePbBin = byteString5;
        this.toastList = immutableCopyOf(list5);
        this.f28602rf = immutableCopyOf(list6);
        this.isMultiRoute = num8;
        this.msg2PsgRes = msg2PsgRes2;
        this.pointParking = num9;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private DriverOrderRouteRes(com.didi.map.sdk.proto.driver_gl.DriverOrderRouteRes.Builder r36) {
        /*
            r35 = this;
            r0 = r36
            r1 = r35
            java.lang.Integer r2 = r0.ret
            java.lang.String r3 = r0.msg
            java.util.List<java.lang.Long> r4 = r0.routeIds
            java.util.List<com.didi.map.sdk.proto.driver_gl.DiffGeoPoints> r5 = r0.routeGeos
            okio.ByteString r6 = r0.routeEngineResPack
            java.lang.Integer r7 = r0.curDstRouteGeoIndex
            java.lang.Long r8 = r0.logId
            java.util.List<com.didi.map.sdk.proto.driver_gl.RouteInfo> r9 = r0.linkInfos
            java.lang.Integer r10 = r0.naviFlag
            com.didi.map.sdk.proto.driver_gl.DynamicRouteRes r11 = r0.dynamicRouteRes
            okio.ByteString r12 = r0.mocktraj
            java.lang.String r13 = r0.debugMsg
            java.lang.Long r14 = r0.routeDbId
            java.util.List<com.didi.map.sdk.proto.driver_gl.OdPoint> r15 = r0.odPoints
            r34 = r1
            com.didi.map.sdk.proto.driver_gl.SessionRes r1 = r0.sessionRes
            r16 = r1
            okio.ByteString r1 = r0.event
            r17 = r1
            java.lang.String r1 = r0.traceId
            r18 = r1
            java.lang.Integer r1 = r0.eta
            r19 = r1
            java.lang.Integer r1 = r0.distance
            r20 = r1
            java.lang.Integer r1 = r0.sctxVersion
            r21 = r1
            java.lang.Boolean r1 = r0.mandatory
            r22 = r1
            java.lang.Double r1 = r0.confidence
            r23 = r1
            okio.ByteString r1 = r0.extendData
            r24 = r1
            com.didi.map.sdk.proto.driver_gl.PickupHint r1 = r0.pickupHint
            r25 = r1
            java.lang.String r1 = r0.recommendInfo
            r26 = r1
            java.lang.Integer r1 = r0.naviAddtionalLine
            r27 = r1
            okio.ByteString r1 = r0.RisePbBin
            r28 = r1
            java.util.List<com.didi.map.sdk.proto.driver_gl.ToastData> r1 = r0.toastList
            r29 = r1
            java.util.List<com.didi.map.sdk.proto.driver_gl.RouteFeature> r1 = r0.f28603rf
            r30 = r1
            java.lang.Integer r1 = r0.isMultiRoute
            r31 = r1
            com.didi.map.sdk.proto.driver_gl.Msg2PsgRes r1 = r0.msg2PsgRes
            r32 = r1
            java.lang.Integer r1 = r0.pointParking
            r33 = r1
            r1 = r34
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33)
            r35.setBuilder(r36)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.sdk.proto.driver_gl.DriverOrderRouteRes.<init>(com.didi.map.sdk.proto.driver_gl.DriverOrderRouteRes$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DriverOrderRouteRes)) {
            return false;
        }
        DriverOrderRouteRes driverOrderRouteRes = (DriverOrderRouteRes) obj;
        if (!equals((Object) this.ret, (Object) driverOrderRouteRes.ret) || !equals((Object) this.msg, (Object) driverOrderRouteRes.msg) || !equals((List<?>) this.routeIds, (List<?>) driverOrderRouteRes.routeIds) || !equals((List<?>) this.routeGeos, (List<?>) driverOrderRouteRes.routeGeos) || !equals((Object) this.routeEngineResPack, (Object) driverOrderRouteRes.routeEngineResPack) || !equals((Object) this.curDstRouteGeoIndex, (Object) driverOrderRouteRes.curDstRouteGeoIndex) || !equals((Object) this.logId, (Object) driverOrderRouteRes.logId) || !equals((List<?>) this.linkInfos, (List<?>) driverOrderRouteRes.linkInfos) || !equals((Object) this.naviFlag, (Object) driverOrderRouteRes.naviFlag) || !equals((Object) this.dynamicRouteRes, (Object) driverOrderRouteRes.dynamicRouteRes) || !equals((Object) this.mocktraj, (Object) driverOrderRouteRes.mocktraj) || !equals((Object) this.debugMsg, (Object) driverOrderRouteRes.debugMsg) || !equals((Object) this.routeDbId, (Object) driverOrderRouteRes.routeDbId) || !equals((List<?>) this.odPoints, (List<?>) driverOrderRouteRes.odPoints) || !equals((Object) this.sessionRes, (Object) driverOrderRouteRes.sessionRes) || !equals((Object) this.event, (Object) driverOrderRouteRes.event) || !equals((Object) this.traceId, (Object) driverOrderRouteRes.traceId) || !equals((Object) this.eta, (Object) driverOrderRouteRes.eta) || !equals((Object) this.distance, (Object) driverOrderRouteRes.distance) || !equals((Object) this.sctxVersion, (Object) driverOrderRouteRes.sctxVersion) || !equals((Object) this.mandatory, (Object) driverOrderRouteRes.mandatory) || !equals((Object) this.confidence, (Object) driverOrderRouteRes.confidence) || !equals((Object) this.extendData, (Object) driverOrderRouteRes.extendData) || !equals((Object) this.pickupHint, (Object) driverOrderRouteRes.pickupHint) || !equals((Object) this.recommendInfo, (Object) driverOrderRouteRes.recommendInfo) || !equals((Object) this.naviAddtionalLine, (Object) driverOrderRouteRes.naviAddtionalLine) || !equals((Object) this.RisePbBin, (Object) driverOrderRouteRes.RisePbBin) || !equals((List<?>) this.toastList, (List<?>) driverOrderRouteRes.toastList) || !equals((List<?>) this.f28602rf, (List<?>) driverOrderRouteRes.f28602rf) || !equals((Object) this.isMultiRoute, (Object) driverOrderRouteRes.isMultiRoute) || !equals((Object) this.msg2PsgRes, (Object) driverOrderRouteRes.msg2PsgRes) || !equals((Object) this.pointParking, (Object) driverOrderRouteRes.pointParking)) {
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
        List<Long> list = this.routeIds;
        int i3 = 1;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 1)) * 37;
        List<DiffGeoPoints> list2 = this.routeGeos;
        int hashCode4 = (hashCode3 + (list2 != null ? list2.hashCode() : 1)) * 37;
        ByteString byteString = this.routeEngineResPack;
        int hashCode5 = (hashCode4 + (byteString != null ? byteString.hashCode() : 0)) * 37;
        Integer num2 = this.curDstRouteGeoIndex;
        int hashCode6 = (hashCode5 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Long l = this.logId;
        int hashCode7 = (hashCode6 + (l != null ? l.hashCode() : 0)) * 37;
        List<RouteInfo> list3 = this.linkInfos;
        int hashCode8 = (hashCode7 + (list3 != null ? list3.hashCode() : 1)) * 37;
        Integer num3 = this.naviFlag;
        int hashCode9 = (hashCode8 + (num3 != null ? num3.hashCode() : 0)) * 37;
        DynamicRouteRes dynamicRouteRes2 = this.dynamicRouteRes;
        int hashCode10 = (hashCode9 + (dynamicRouteRes2 != null ? dynamicRouteRes2.hashCode() : 0)) * 37;
        ByteString byteString2 = this.mocktraj;
        int hashCode11 = (hashCode10 + (byteString2 != null ? byteString2.hashCode() : 0)) * 37;
        String str2 = this.debugMsg;
        int hashCode12 = (hashCode11 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Long l2 = this.routeDbId;
        int hashCode13 = (hashCode12 + (l2 != null ? l2.hashCode() : 0)) * 37;
        List<OdPoint> list4 = this.odPoints;
        int hashCode14 = (hashCode13 + (list4 != null ? list4.hashCode() : 1)) * 37;
        SessionRes sessionRes2 = this.sessionRes;
        int hashCode15 = (hashCode14 + (sessionRes2 != null ? sessionRes2.hashCode() : 0)) * 37;
        ByteString byteString3 = this.event;
        int hashCode16 = (hashCode15 + (byteString3 != null ? byteString3.hashCode() : 0)) * 37;
        String str3 = this.traceId;
        int hashCode17 = (hashCode16 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Integer num4 = this.eta;
        int hashCode18 = (hashCode17 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.distance;
        int hashCode19 = (hashCode18 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.sctxVersion;
        int hashCode20 = (hashCode19 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Boolean bool = this.mandatory;
        int hashCode21 = (hashCode20 + (bool != null ? bool.hashCode() : 0)) * 37;
        Double d = this.confidence;
        int hashCode22 = (hashCode21 + (d != null ? d.hashCode() : 0)) * 37;
        ByteString byteString4 = this.extendData;
        int hashCode23 = (hashCode22 + (byteString4 != null ? byteString4.hashCode() : 0)) * 37;
        PickupHint pickupHint2 = this.pickupHint;
        int hashCode24 = (hashCode23 + (pickupHint2 != null ? pickupHint2.hashCode() : 0)) * 37;
        String str4 = this.recommendInfo;
        int hashCode25 = (hashCode24 + (str4 != null ? str4.hashCode() : 0)) * 37;
        Integer num7 = this.naviAddtionalLine;
        int hashCode26 = (hashCode25 + (num7 != null ? num7.hashCode() : 0)) * 37;
        ByteString byteString5 = this.RisePbBin;
        int hashCode27 = (hashCode26 + (byteString5 != null ? byteString5.hashCode() : 0)) * 37;
        List<ToastData> list5 = this.toastList;
        int hashCode28 = (hashCode27 + (list5 != null ? list5.hashCode() : 1)) * 37;
        List<RouteFeature> list6 = this.f28602rf;
        if (list6 != null) {
            i3 = list6.hashCode();
        }
        int i4 = (hashCode28 + i3) * 37;
        Integer num8 = this.isMultiRoute;
        int hashCode29 = (i4 + (num8 != null ? num8.hashCode() : 0)) * 37;
        Msg2PsgRes msg2PsgRes2 = this.msg2PsgRes;
        int hashCode30 = (hashCode29 + (msg2PsgRes2 != null ? msg2PsgRes2.hashCode() : 0)) * 37;
        Integer num9 = this.pointParking;
        if (num9 != null) {
            i2 = num9.hashCode();
        }
        int i5 = hashCode30 + i2;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<DriverOrderRouteRes> {
        public ByteString RisePbBin;
        public Double confidence;
        public Integer curDstRouteGeoIndex;
        public String debugMsg;
        public Integer distance;
        public DynamicRouteRes dynamicRouteRes;
        public Integer eta;
        public ByteString event;
        public ByteString extendData;
        public Integer isMultiRoute;
        public List<RouteInfo> linkInfos;
        public Long logId;
        public Boolean mandatory;
        public ByteString mocktraj;
        public String msg;
        public Msg2PsgRes msg2PsgRes;
        public Integer naviAddtionalLine;
        public Integer naviFlag;
        public List<OdPoint> odPoints;
        public PickupHint pickupHint;
        public Integer pointParking;
        public String recommendInfo;
        public Integer ret;

        /* renamed from: rf */
        public List<RouteFeature> f28603rf;
        public Long routeDbId;
        public ByteString routeEngineResPack;
        public List<DiffGeoPoints> routeGeos;
        public List<Long> routeIds;
        public Integer sctxVersion;
        public SessionRes sessionRes;
        public List<ToastData> toastList;
        public String traceId;

        public Builder() {
        }

        public Builder(DriverOrderRouteRes driverOrderRouteRes) {
            super(driverOrderRouteRes);
            if (driverOrderRouteRes != null) {
                this.ret = driverOrderRouteRes.ret;
                this.msg = driverOrderRouteRes.msg;
                this.routeIds = DriverOrderRouteRes.copyOf(driverOrderRouteRes.routeIds);
                this.routeGeos = DriverOrderRouteRes.copyOf(driverOrderRouteRes.routeGeos);
                this.routeEngineResPack = driverOrderRouteRes.routeEngineResPack;
                this.curDstRouteGeoIndex = driverOrderRouteRes.curDstRouteGeoIndex;
                this.logId = driverOrderRouteRes.logId;
                this.linkInfos = DriverOrderRouteRes.copyOf(driverOrderRouteRes.linkInfos);
                this.naviFlag = driverOrderRouteRes.naviFlag;
                this.dynamicRouteRes = driverOrderRouteRes.dynamicRouteRes;
                this.mocktraj = driverOrderRouteRes.mocktraj;
                this.debugMsg = driverOrderRouteRes.debugMsg;
                this.routeDbId = driverOrderRouteRes.routeDbId;
                this.odPoints = DriverOrderRouteRes.copyOf(driverOrderRouteRes.odPoints);
                this.sessionRes = driverOrderRouteRes.sessionRes;
                this.event = driverOrderRouteRes.event;
                this.traceId = driverOrderRouteRes.traceId;
                this.eta = driverOrderRouteRes.eta;
                this.distance = driverOrderRouteRes.distance;
                this.sctxVersion = driverOrderRouteRes.sctxVersion;
                this.mandatory = driverOrderRouteRes.mandatory;
                this.confidence = driverOrderRouteRes.confidence;
                this.extendData = driverOrderRouteRes.extendData;
                this.pickupHint = driverOrderRouteRes.pickupHint;
                this.recommendInfo = driverOrderRouteRes.recommendInfo;
                this.naviAddtionalLine = driverOrderRouteRes.naviAddtionalLine;
                this.RisePbBin = driverOrderRouteRes.RisePbBin;
                this.toastList = DriverOrderRouteRes.copyOf(driverOrderRouteRes.toastList);
                this.f28603rf = DriverOrderRouteRes.copyOf(driverOrderRouteRes.f28602rf);
                this.isMultiRoute = driverOrderRouteRes.isMultiRoute;
                this.msg2PsgRes = driverOrderRouteRes.msg2PsgRes;
                this.pointParking = driverOrderRouteRes.pointParking;
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

        public Builder routeIds(List<Long> list) {
            this.routeIds = checkForNulls(list);
            return this;
        }

        public Builder routeGeos(List<DiffGeoPoints> list) {
            this.routeGeos = checkForNulls(list);
            return this;
        }

        public Builder routeEngineResPack(ByteString byteString) {
            this.routeEngineResPack = byteString;
            return this;
        }

        public Builder curDstRouteGeoIndex(Integer num) {
            this.curDstRouteGeoIndex = num;
            return this;
        }

        public Builder logId(Long l) {
            this.logId = l;
            return this;
        }

        public Builder linkInfos(List<RouteInfo> list) {
            this.linkInfos = checkForNulls(list);
            return this;
        }

        public Builder naviFlag(Integer num) {
            this.naviFlag = num;
            return this;
        }

        public Builder dynamicRouteRes(DynamicRouteRes dynamicRouteRes2) {
            this.dynamicRouteRes = dynamicRouteRes2;
            return this;
        }

        public Builder mocktraj(ByteString byteString) {
            this.mocktraj = byteString;
            return this;
        }

        public Builder debugMsg(String str) {
            this.debugMsg = str;
            return this;
        }

        public Builder routeDbId(Long l) {
            this.routeDbId = l;
            return this;
        }

        public Builder odPoints(List<OdPoint> list) {
            this.odPoints = checkForNulls(list);
            return this;
        }

        public Builder sessionRes(SessionRes sessionRes2) {
            this.sessionRes = sessionRes2;
            return this;
        }

        public Builder event(ByteString byteString) {
            this.event = byteString;
            return this;
        }

        public Builder traceId(String str) {
            this.traceId = str;
            return this;
        }

        public Builder eta(Integer num) {
            this.eta = num;
            return this;
        }

        public Builder distance(Integer num) {
            this.distance = num;
            return this;
        }

        public Builder sctxVersion(Integer num) {
            this.sctxVersion = num;
            return this;
        }

        public Builder mandatory(Boolean bool) {
            this.mandatory = bool;
            return this;
        }

        public Builder confidence(Double d) {
            this.confidence = d;
            return this;
        }

        public Builder extendData(ByteString byteString) {
            this.extendData = byteString;
            return this;
        }

        public Builder pickupHint(PickupHint pickupHint2) {
            this.pickupHint = pickupHint2;
            return this;
        }

        public Builder recommendInfo(String str) {
            this.recommendInfo = str;
            return this;
        }

        public Builder naviAddtionalLine(Integer num) {
            this.naviAddtionalLine = num;
            return this;
        }

        public Builder RisePbBin(ByteString byteString) {
            this.RisePbBin = byteString;
            return this;
        }

        public Builder toastList(List<ToastData> list) {
            this.toastList = checkForNulls(list);
            return this;
        }

        /* renamed from: rf */
        public Builder mo78150rf(List<RouteFeature> list) {
            this.f28603rf = checkForNulls(list);
            return this;
        }

        public Builder isMultiRoute(Integer num) {
            this.isMultiRoute = num;
            return this;
        }

        public Builder msg2PsgRes(Msg2PsgRes msg2PsgRes2) {
            this.msg2PsgRes = msg2PsgRes2;
            return this;
        }

        public Builder pointParking(Integer num) {
            this.pointParking = num;
            return this;
        }

        public DriverOrderRouteRes build() {
            checkRequiredFields();
            return new DriverOrderRouteRes(this);
        }
    }
}
