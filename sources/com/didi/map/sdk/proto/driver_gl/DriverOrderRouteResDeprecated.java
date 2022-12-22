package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;
import okio.ByteString;

public final class DriverOrderRouteResDeprecated extends Message {
    public static final Integer DEFAULT_CURDSTROUTEGEOINDEX = 0;
    public static final Integer DEFAULT_DISTANCE = -1;
    public static final Integer DEFAULT_ETA = -1;
    public static final List<RouteInfo> DEFAULT_LINKINFOS = Collections.emptyList();
    public static final Long DEFAULT_LOGID = 0L;
    public static final ByteString DEFAULT_MOCKTRAJ = ByteString.EMPTY;
    public static final String DEFAULT_MSG = "";
    public static final Integer DEFAULT_NAVIFLAG = 0;
    public static final List<OdPoint> DEFAULT_ODPOINTS = Collections.emptyList();
    public static final Integer DEFAULT_RET = 0;
    public static final ByteString DEFAULT_ROUTEENGINERESPACK = ByteString.EMPTY;
    public static final List<DiffGeoPoints> DEFAULT_ROUTEGEOS = Collections.emptyList();
    public static final List<Long> DEFAULT_ROUTEIDS = Collections.emptyList();
    public static final Integer DEFAULT_SCTXVERSION = 0;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer curDstRouteGeoIndex;
    @ProtoField(tag = 13, type = Message.Datatype.INT32)
    public final Integer distance;
    @ProtoField(tag = 10)
    public final DynamicRouteRes dynamicRouteRes;
    @ProtoField(tag = 12, type = Message.Datatype.INT32)
    public final Integer eta;
    @ProtoField(label = Message.Label.REPEATED, messageType = RouteInfo.class, tag = 8)
    public final List<RouteInfo> linkInfos;
    @ProtoField(tag = 7, type = Message.Datatype.UINT64)
    public final Long logId;
    @ProtoField(tag = 11, type = Message.Datatype.BYTES)
    public final ByteString mocktraj;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.STRING)
    public final String msg;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer naviFlag;
    @ProtoField(label = Message.Label.REPEATED, messageType = OdPoint.class, tag = 14)
    public final List<OdPoint> odPoints;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.INT32)
    public final Integer ret;
    @ProtoField(tag = 5, type = Message.Datatype.BYTES)
    public final ByteString routeEngineResPack;
    @ProtoField(label = Message.Label.REPEATED, messageType = DiffGeoPoints.class, tag = 4)
    public final List<DiffGeoPoints> routeGeos;
    @ProtoField(label = Message.Label.REPEATED, tag = 3, type = Message.Datatype.INT64)
    public final List<Long> routeIds;
    @ProtoField(tag = 19, type = Message.Datatype.INT32)
    public final Integer sctxVersion;

    public DriverOrderRouteResDeprecated(Integer num, String str, List<Long> list, List<DiffGeoPoints> list2, ByteString byteString, Integer num2, Long l, List<RouteInfo> list3, Integer num3, DynamicRouteRes dynamicRouteRes2, ByteString byteString2, Integer num4, Integer num5, List<OdPoint> list4, Integer num6) {
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
        this.eta = num4;
        this.distance = num5;
        this.odPoints = immutableCopyOf(list4);
        this.sctxVersion = num6;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private DriverOrderRouteResDeprecated(com.didi.map.sdk.proto.driver_gl.DriverOrderRouteResDeprecated.Builder r18) {
        /*
            r17 = this;
            r0 = r18
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
            java.lang.Integer r13 = r0.eta
            java.lang.Integer r14 = r0.distance
            java.util.List<com.didi.map.sdk.proto.driver_gl.OdPoint> r15 = r0.odPoints
            java.lang.Integer r1 = r0.sctxVersion
            r16 = r1
            r1 = r17
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            r17.setBuilder(r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.sdk.proto.driver_gl.DriverOrderRouteResDeprecated.<init>(com.didi.map.sdk.proto.driver_gl.DriverOrderRouteResDeprecated$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DriverOrderRouteResDeprecated)) {
            return false;
        }
        DriverOrderRouteResDeprecated driverOrderRouteResDeprecated = (DriverOrderRouteResDeprecated) obj;
        if (!equals((Object) this.ret, (Object) driverOrderRouteResDeprecated.ret) || !equals((Object) this.msg, (Object) driverOrderRouteResDeprecated.msg) || !equals((List<?>) this.routeIds, (List<?>) driverOrderRouteResDeprecated.routeIds) || !equals((List<?>) this.routeGeos, (List<?>) driverOrderRouteResDeprecated.routeGeos) || !equals((Object) this.routeEngineResPack, (Object) driverOrderRouteResDeprecated.routeEngineResPack) || !equals((Object) this.curDstRouteGeoIndex, (Object) driverOrderRouteResDeprecated.curDstRouteGeoIndex) || !equals((Object) this.logId, (Object) driverOrderRouteResDeprecated.logId) || !equals((List<?>) this.linkInfos, (List<?>) driverOrderRouteResDeprecated.linkInfos) || !equals((Object) this.naviFlag, (Object) driverOrderRouteResDeprecated.naviFlag) || !equals((Object) this.dynamicRouteRes, (Object) driverOrderRouteResDeprecated.dynamicRouteRes) || !equals((Object) this.mocktraj, (Object) driverOrderRouteResDeprecated.mocktraj) || !equals((Object) this.eta, (Object) driverOrderRouteResDeprecated.eta) || !equals((Object) this.distance, (Object) driverOrderRouteResDeprecated.distance) || !equals((List<?>) this.odPoints, (List<?>) driverOrderRouteResDeprecated.odPoints) || !equals((Object) this.sctxVersion, (Object) driverOrderRouteResDeprecated.sctxVersion)) {
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
        Integer num4 = this.eta;
        int hashCode12 = (hashCode11 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.distance;
        int hashCode13 = (hashCode12 + (num5 != null ? num5.hashCode() : 0)) * 37;
        List<OdPoint> list4 = this.odPoints;
        if (list4 != null) {
            i3 = list4.hashCode();
        }
        int i4 = (hashCode13 + i3) * 37;
        Integer num6 = this.sctxVersion;
        if (num6 != null) {
            i2 = num6.hashCode();
        }
        int i5 = i4 + i2;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<DriverOrderRouteResDeprecated> {
        public Integer curDstRouteGeoIndex;
        public Integer distance;
        public DynamicRouteRes dynamicRouteRes;
        public Integer eta;
        public List<RouteInfo> linkInfos;
        public Long logId;
        public ByteString mocktraj;
        public String msg;
        public Integer naviFlag;
        public List<OdPoint> odPoints;
        public Integer ret;
        public ByteString routeEngineResPack;
        public List<DiffGeoPoints> routeGeos;
        public List<Long> routeIds;
        public Integer sctxVersion;

        public Builder() {
        }

        public Builder(DriverOrderRouteResDeprecated driverOrderRouteResDeprecated) {
            super(driverOrderRouteResDeprecated);
            if (driverOrderRouteResDeprecated != null) {
                this.ret = driverOrderRouteResDeprecated.ret;
                this.msg = driverOrderRouteResDeprecated.msg;
                this.routeIds = DriverOrderRouteResDeprecated.copyOf(driverOrderRouteResDeprecated.routeIds);
                this.routeGeos = DriverOrderRouteResDeprecated.copyOf(driverOrderRouteResDeprecated.routeGeos);
                this.routeEngineResPack = driverOrderRouteResDeprecated.routeEngineResPack;
                this.curDstRouteGeoIndex = driverOrderRouteResDeprecated.curDstRouteGeoIndex;
                this.logId = driverOrderRouteResDeprecated.logId;
                this.linkInfos = DriverOrderRouteResDeprecated.copyOf(driverOrderRouteResDeprecated.linkInfos);
                this.naviFlag = driverOrderRouteResDeprecated.naviFlag;
                this.dynamicRouteRes = driverOrderRouteResDeprecated.dynamicRouteRes;
                this.mocktraj = driverOrderRouteResDeprecated.mocktraj;
                this.eta = driverOrderRouteResDeprecated.eta;
                this.distance = driverOrderRouteResDeprecated.distance;
                this.odPoints = DriverOrderRouteResDeprecated.copyOf(driverOrderRouteResDeprecated.odPoints);
                this.sctxVersion = driverOrderRouteResDeprecated.sctxVersion;
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

        public Builder eta(Integer num) {
            this.eta = num;
            return this;
        }

        public Builder distance(Integer num) {
            this.distance = num;
            return this;
        }

        public Builder odPoints(List<OdPoint> list) {
            this.odPoints = checkForNulls(list);
            return this;
        }

        public Builder sctxVersion(Integer num) {
            this.sctxVersion = num;
            return this;
        }

        public DriverOrderRouteResDeprecated build() {
            checkRequiredFields();
            return new DriverOrderRouteResDeprecated(this);
        }
    }
}
