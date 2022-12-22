package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class TrafficStatusReq extends Message {
    public static final Integer DEFAULT_BIZTYPE = 0;
    public static final Boolean DEFAULT_BLUETOOTHOPEN = false;
    public static final Boolean DEFAULT_DEBUG_MODEL = false;
    public static final String DEFAULT_DIDIVERSION = "";
    public static final String DEFAULT_EXTENDDATA = "";
    public static final String DEFAULT_IMEI = "";
    public static final Integer DEFAULT_IS_NAVI = 0;
    public static final Boolean DEFAULT_NEEDMISSION = false;
    public static final Boolean DEFAULT_NEEDMJO = false;
    public static final Integer DEFAULT_NGVERSION = 0;
    public static final Boolean DEFAULT_NONEEDRAINBOW = false;
    public static final List<OptionalRouteReq> DEFAULT_OPROUTES = Collections.emptyList();
    public static final List<Long> DEFAULT_OPTIONALROUTEIDS = Collections.emptyList();
    public static final Integer DEFAULT_PARKVERSION = 0;
    public static final String DEFAULT_PHONENUM = "";
    public static final String DEFAULT_PROTOCOL = "";
    public static final Integer DEFAULT_ROLE = 0;
    public static final String DEFAULT_ROUTEENGINETYPE = "";
    public static final Long DEFAULT_ROUTEID = 0L;
    public static final String DEFAULT_SDKMAPTYPE = "";
    public static final Boolean DEFAULT_SHOWEVENT = false;
    public static final String DEFAULT_TICKET = "";
    public static final String DEFAULT_TRACEID = "";
    public static final String DEFAULT_TRAVELID = "";
    public static final String DEFAULT_VERSION = "";
    @ProtoField(tag = 20, type = Message.Datatype.INT32)
    public final Integer bizType;
    @ProtoField(tag = 28, type = Message.Datatype.BOOL)
    public final Boolean bluetoothOpen;
    @ProtoField(tag = 13, type = Message.Datatype.BOOL)
    public final Boolean debug_model;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String didiVersion;
    @ProtoField(tag = 27, type = Message.Datatype.STRING)
    public final String extendData;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String imei;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer is_navi;
    @ProtoField(tag = 29)
    public final Msg2PsgReq msg2PsgReq;
    @ProtoField(tag = 18, type = Message.Datatype.BOOL)
    public final Boolean needMission;
    @ProtoField(tag = 22, type = Message.Datatype.BOOL)
    public final Boolean needMjo;
    @ProtoField(tag = 21, type = Message.Datatype.INT32)
    public final Integer ngVersion;
    @ProtoField(tag = 19, type = Message.Datatype.BOOL)
    public final Boolean noNeedRainbow;
    @ProtoField(label = Message.Label.REPEATED, messageType = OptionalRouteReq.class, tag = 26)
    public final List<OptionalRouteReq> opRoutes;
    @ProtoField(tag = 24)
    public final OpenSdkInfo openSdkInfo;
    @ProtoField(label = Message.Label.REPEATED, tag = 23, type = Message.Datatype.INT64)
    public final List<Long> optionalRouteIds;
    @ProtoField(tag = 25, type = Message.Datatype.INT32)
    public final Integer parkVersion;
    @ProtoField(tag = 11)
    public final DoublePoint passengerEndPoint;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String phoneNum;
    @ProtoField(tag = 12, type = Message.Datatype.STRING)
    public final String protocol;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer role;
    @ProtoField(tag = 10, type = Message.Datatype.STRING)
    public final String routeEngineType;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.INT64)
    public final Long routeId;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String sdkmaptype;
    @ProtoField(tag = 16, type = Message.Datatype.BOOL)
    public final Boolean showEvent;
    @ProtoField(tag = 14)
    public final NaviStatus status;
    @ProtoField(label = Message.Label.REQUIRED, tag = 4, type = Message.Datatype.STRING)
    public final String ticket;
    @ProtoField(tag = 17, type = Message.Datatype.STRING)
    public final String traceId;
    @ProtoField(tag = 15, type = Message.Datatype.STRING)
    public final String travelId;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.STRING)
    public final String version;

    public TrafficStatusReq(Long l, String str, String str2, String str3, Integer num, String str4, String str5, String str6, Integer num2, String str7, DoublePoint doublePoint, String str8, Boolean bool, NaviStatus naviStatus, String str9, Boolean bool2, String str10, Boolean bool3, Boolean bool4, Integer num3, Integer num4, Boolean bool5, List<Long> list, OpenSdkInfo openSdkInfo2, Integer num5, List<OptionalRouteReq> list2, String str11, Boolean bool6, Msg2PsgReq msg2PsgReq2) {
        this.routeId = l;
        this.sdkmaptype = str;
        this.version = str2;
        this.ticket = str3;
        this.role = num;
        this.phoneNum = str4;
        this.imei = str5;
        this.didiVersion = str6;
        this.is_navi = num2;
        this.routeEngineType = str7;
        this.passengerEndPoint = doublePoint;
        this.protocol = str8;
        this.debug_model = bool;
        this.status = naviStatus;
        this.travelId = str9;
        this.showEvent = bool2;
        this.traceId = str10;
        this.needMission = bool3;
        this.noNeedRainbow = bool4;
        this.bizType = num3;
        this.ngVersion = num4;
        this.needMjo = bool5;
        this.optionalRouteIds = immutableCopyOf(list);
        this.openSdkInfo = openSdkInfo2;
        this.parkVersion = num5;
        this.opRoutes = immutableCopyOf(list2);
        this.extendData = str11;
        this.bluetoothOpen = bool6;
        this.msg2PsgReq = msg2PsgReq2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private TrafficStatusReq(com.didi.map.sdk.proto.driver_gl.TrafficStatusReq.Builder r33) {
        /*
            r32 = this;
            r0 = r33
            r1 = r32
            java.lang.Long r2 = r0.routeId
            java.lang.String r3 = r0.sdkmaptype
            java.lang.String r4 = r0.version
            java.lang.String r5 = r0.ticket
            java.lang.Integer r6 = r0.role
            java.lang.String r7 = r0.phoneNum
            java.lang.String r8 = r0.imei
            java.lang.String r9 = r0.didiVersion
            java.lang.Integer r10 = r0.is_navi
            java.lang.String r11 = r0.routeEngineType
            com.didi.map.sdk.proto.driver_gl.DoublePoint r12 = r0.passengerEndPoint
            java.lang.String r13 = r0.protocol
            java.lang.Boolean r14 = r0.debug_model
            com.didi.map.sdk.proto.driver_gl.NaviStatus r15 = r0.status
            r31 = r1
            java.lang.String r1 = r0.travelId
            r16 = r1
            java.lang.Boolean r1 = r0.showEvent
            r17 = r1
            java.lang.String r1 = r0.traceId
            r18 = r1
            java.lang.Boolean r1 = r0.needMission
            r19 = r1
            java.lang.Boolean r1 = r0.noNeedRainbow
            r20 = r1
            java.lang.Integer r1 = r0.bizType
            r21 = r1
            java.lang.Integer r1 = r0.ngVersion
            r22 = r1
            java.lang.Boolean r1 = r0.needMjo
            r23 = r1
            java.util.List<java.lang.Long> r1 = r0.optionalRouteIds
            r24 = r1
            com.didi.map.sdk.proto.driver_gl.OpenSdkInfo r1 = r0.openSdkInfo
            r25 = r1
            java.lang.Integer r1 = r0.parkVersion
            r26 = r1
            java.util.List<com.didi.map.sdk.proto.driver_gl.OptionalRouteReq> r1 = r0.opRoutes
            r27 = r1
            java.lang.String r1 = r0.extendData
            r28 = r1
            java.lang.Boolean r1 = r0.bluetoothOpen
            r29 = r1
            com.didi.map.sdk.proto.driver_gl.Msg2PsgReq r1 = r0.msg2PsgReq
            r30 = r1
            r1 = r31
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30)
            r32.setBuilder(r33)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.sdk.proto.driver_gl.TrafficStatusReq.<init>(com.didi.map.sdk.proto.driver_gl.TrafficStatusReq$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TrafficStatusReq)) {
            return false;
        }
        TrafficStatusReq trafficStatusReq = (TrafficStatusReq) obj;
        if (!equals((Object) this.routeId, (Object) trafficStatusReq.routeId) || !equals((Object) this.sdkmaptype, (Object) trafficStatusReq.sdkmaptype) || !equals((Object) this.version, (Object) trafficStatusReq.version) || !equals((Object) this.ticket, (Object) trafficStatusReq.ticket) || !equals((Object) this.role, (Object) trafficStatusReq.role) || !equals((Object) this.phoneNum, (Object) trafficStatusReq.phoneNum) || !equals((Object) this.imei, (Object) trafficStatusReq.imei) || !equals((Object) this.didiVersion, (Object) trafficStatusReq.didiVersion) || !equals((Object) this.is_navi, (Object) trafficStatusReq.is_navi) || !equals((Object) this.routeEngineType, (Object) trafficStatusReq.routeEngineType) || !equals((Object) this.passengerEndPoint, (Object) trafficStatusReq.passengerEndPoint) || !equals((Object) this.protocol, (Object) trafficStatusReq.protocol) || !equals((Object) this.debug_model, (Object) trafficStatusReq.debug_model) || !equals((Object) this.status, (Object) trafficStatusReq.status) || !equals((Object) this.travelId, (Object) trafficStatusReq.travelId) || !equals((Object) this.showEvent, (Object) trafficStatusReq.showEvent) || !equals((Object) this.traceId, (Object) trafficStatusReq.traceId) || !equals((Object) this.needMission, (Object) trafficStatusReq.needMission) || !equals((Object) this.noNeedRainbow, (Object) trafficStatusReq.noNeedRainbow) || !equals((Object) this.bizType, (Object) trafficStatusReq.bizType) || !equals((Object) this.ngVersion, (Object) trafficStatusReq.ngVersion) || !equals((Object) this.needMjo, (Object) trafficStatusReq.needMjo) || !equals((List<?>) this.optionalRouteIds, (List<?>) trafficStatusReq.optionalRouteIds) || !equals((Object) this.openSdkInfo, (Object) trafficStatusReq.openSdkInfo) || !equals((Object) this.parkVersion, (Object) trafficStatusReq.parkVersion) || !equals((List<?>) this.opRoutes, (List<?>) trafficStatusReq.opRoutes) || !equals((Object) this.extendData, (Object) trafficStatusReq.extendData) || !equals((Object) this.bluetoothOpen, (Object) trafficStatusReq.bluetoothOpen) || !equals((Object) this.msg2PsgReq, (Object) trafficStatusReq.msg2PsgReq)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.routeId;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        String str = this.sdkmaptype;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.version;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.ticket;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Integer num = this.role;
        int hashCode5 = (hashCode4 + (num != null ? num.hashCode() : 0)) * 37;
        String str4 = this.phoneNum;
        int hashCode6 = (hashCode5 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.imei;
        int hashCode7 = (hashCode6 + (str5 != null ? str5.hashCode() : 0)) * 37;
        String str6 = this.didiVersion;
        int hashCode8 = (hashCode7 + (str6 != null ? str6.hashCode() : 0)) * 37;
        Integer num2 = this.is_navi;
        int hashCode9 = (hashCode8 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str7 = this.routeEngineType;
        int hashCode10 = (hashCode9 + (str7 != null ? str7.hashCode() : 0)) * 37;
        DoublePoint doublePoint = this.passengerEndPoint;
        int hashCode11 = (hashCode10 + (doublePoint != null ? doublePoint.hashCode() : 0)) * 37;
        String str8 = this.protocol;
        int hashCode12 = (hashCode11 + (str8 != null ? str8.hashCode() : 0)) * 37;
        Boolean bool = this.debug_model;
        int hashCode13 = (hashCode12 + (bool != null ? bool.hashCode() : 0)) * 37;
        NaviStatus naviStatus = this.status;
        int hashCode14 = (hashCode13 + (naviStatus != null ? naviStatus.hashCode() : 0)) * 37;
        String str9 = this.travelId;
        int hashCode15 = (hashCode14 + (str9 != null ? str9.hashCode() : 0)) * 37;
        Boolean bool2 = this.showEvent;
        int hashCode16 = (hashCode15 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        String str10 = this.traceId;
        int hashCode17 = (hashCode16 + (str10 != null ? str10.hashCode() : 0)) * 37;
        Boolean bool3 = this.needMission;
        int hashCode18 = (hashCode17 + (bool3 != null ? bool3.hashCode() : 0)) * 37;
        Boolean bool4 = this.noNeedRainbow;
        int hashCode19 = (hashCode18 + (bool4 != null ? bool4.hashCode() : 0)) * 37;
        Integer num3 = this.bizType;
        int hashCode20 = (hashCode19 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.ngVersion;
        int hashCode21 = (hashCode20 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Boolean bool5 = this.needMjo;
        int hashCode22 = (hashCode21 + (bool5 != null ? bool5.hashCode() : 0)) * 37;
        List<Long> list = this.optionalRouteIds;
        int i3 = 1;
        int hashCode23 = (hashCode22 + (list != null ? list.hashCode() : 1)) * 37;
        OpenSdkInfo openSdkInfo2 = this.openSdkInfo;
        int hashCode24 = (hashCode23 + (openSdkInfo2 != null ? openSdkInfo2.hashCode() : 0)) * 37;
        Integer num5 = this.parkVersion;
        int hashCode25 = (hashCode24 + (num5 != null ? num5.hashCode() : 0)) * 37;
        List<OptionalRouteReq> list2 = this.opRoutes;
        if (list2 != null) {
            i3 = list2.hashCode();
        }
        int i4 = (hashCode25 + i3) * 37;
        String str11 = this.extendData;
        int hashCode26 = (i4 + (str11 != null ? str11.hashCode() : 0)) * 37;
        Boolean bool6 = this.bluetoothOpen;
        int hashCode27 = (hashCode26 + (bool6 != null ? bool6.hashCode() : 0)) * 37;
        Msg2PsgReq msg2PsgReq2 = this.msg2PsgReq;
        if (msg2PsgReq2 != null) {
            i2 = msg2PsgReq2.hashCode();
        }
        int i5 = hashCode27 + i2;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<TrafficStatusReq> {
        public Integer bizType;
        public Boolean bluetoothOpen;
        public Boolean debug_model;
        public String didiVersion;
        public String extendData;
        public String imei;
        public Integer is_navi;
        public Msg2PsgReq msg2PsgReq;
        public Boolean needMission;
        public Boolean needMjo;
        public Integer ngVersion;
        public Boolean noNeedRainbow;
        public List<OptionalRouteReq> opRoutes;
        public OpenSdkInfo openSdkInfo;
        public List<Long> optionalRouteIds;
        public Integer parkVersion;
        public DoublePoint passengerEndPoint;
        public String phoneNum;
        public String protocol;
        public Integer role;
        public String routeEngineType;
        public Long routeId;
        public String sdkmaptype;
        public Boolean showEvent;
        public NaviStatus status;
        public String ticket;
        public String traceId;
        public String travelId;
        public String version;

        public Builder() {
        }

        public Builder(TrafficStatusReq trafficStatusReq) {
            super(trafficStatusReq);
            if (trafficStatusReq != null) {
                this.routeId = trafficStatusReq.routeId;
                this.sdkmaptype = trafficStatusReq.sdkmaptype;
                this.version = trafficStatusReq.version;
                this.ticket = trafficStatusReq.ticket;
                this.role = trafficStatusReq.role;
                this.phoneNum = trafficStatusReq.phoneNum;
                this.imei = trafficStatusReq.imei;
                this.didiVersion = trafficStatusReq.didiVersion;
                this.is_navi = trafficStatusReq.is_navi;
                this.routeEngineType = trafficStatusReq.routeEngineType;
                this.passengerEndPoint = trafficStatusReq.passengerEndPoint;
                this.protocol = trafficStatusReq.protocol;
                this.debug_model = trafficStatusReq.debug_model;
                this.status = trafficStatusReq.status;
                this.travelId = trafficStatusReq.travelId;
                this.showEvent = trafficStatusReq.showEvent;
                this.traceId = trafficStatusReq.traceId;
                this.needMission = trafficStatusReq.needMission;
                this.noNeedRainbow = trafficStatusReq.noNeedRainbow;
                this.bizType = trafficStatusReq.bizType;
                this.ngVersion = trafficStatusReq.ngVersion;
                this.needMjo = trafficStatusReq.needMjo;
                this.optionalRouteIds = TrafficStatusReq.copyOf(trafficStatusReq.optionalRouteIds);
                this.openSdkInfo = trafficStatusReq.openSdkInfo;
                this.parkVersion = trafficStatusReq.parkVersion;
                this.opRoutes = TrafficStatusReq.copyOf(trafficStatusReq.opRoutes);
                this.extendData = trafficStatusReq.extendData;
                this.bluetoothOpen = trafficStatusReq.bluetoothOpen;
                this.msg2PsgReq = trafficStatusReq.msg2PsgReq;
            }
        }

        public Builder routeId(Long l) {
            this.routeId = l;
            return this;
        }

        public Builder sdkmaptype(String str) {
            this.sdkmaptype = str;
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

        public Builder role(Integer num) {
            this.role = num;
            return this;
        }

        public Builder phoneNum(String str) {
            this.phoneNum = str;
            return this;
        }

        public Builder imei(String str) {
            this.imei = str;
            return this;
        }

        public Builder didiVersion(String str) {
            this.didiVersion = str;
            return this;
        }

        public Builder is_navi(Integer num) {
            this.is_navi = num;
            return this;
        }

        public Builder routeEngineType(String str) {
            this.routeEngineType = str;
            return this;
        }

        public Builder passengerEndPoint(DoublePoint doublePoint) {
            this.passengerEndPoint = doublePoint;
            return this;
        }

        public Builder protocol(String str) {
            this.protocol = str;
            return this;
        }

        public Builder debug_model(Boolean bool) {
            this.debug_model = bool;
            return this;
        }

        public Builder status(NaviStatus naviStatus) {
            this.status = naviStatus;
            return this;
        }

        public Builder travelId(String str) {
            this.travelId = str;
            return this;
        }

        public Builder showEvent(Boolean bool) {
            this.showEvent = bool;
            return this;
        }

        public Builder traceId(String str) {
            this.traceId = str;
            return this;
        }

        public Builder needMission(Boolean bool) {
            this.needMission = bool;
            return this;
        }

        public Builder noNeedRainbow(Boolean bool) {
            this.noNeedRainbow = bool;
            return this;
        }

        public Builder bizType(Integer num) {
            this.bizType = num;
            return this;
        }

        public Builder ngVersion(Integer num) {
            this.ngVersion = num;
            return this;
        }

        public Builder needMjo(Boolean bool) {
            this.needMjo = bool;
            return this;
        }

        public Builder optionalRouteIds(List<Long> list) {
            this.optionalRouteIds = checkForNulls(list);
            return this;
        }

        public Builder openSdkInfo(OpenSdkInfo openSdkInfo2) {
            this.openSdkInfo = openSdkInfo2;
            return this;
        }

        public Builder parkVersion(Integer num) {
            this.parkVersion = num;
            return this;
        }

        public Builder opRoutes(List<OptionalRouteReq> list) {
            this.opRoutes = checkForNulls(list);
            return this;
        }

        public Builder extendData(String str) {
            this.extendData = str;
            return this;
        }

        public Builder bluetoothOpen(Boolean bool) {
            this.bluetoothOpen = bool;
            return this;
        }

        public Builder msg2PsgReq(Msg2PsgReq msg2PsgReq2) {
            this.msg2PsgReq = msg2PsgReq2;
            return this;
        }

        public TrafficStatusReq build() {
            checkRequiredFields();
            return new TrafficStatusReq(this);
        }
    }
}
