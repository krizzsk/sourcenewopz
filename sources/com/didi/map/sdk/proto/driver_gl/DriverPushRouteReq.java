package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class DriverPushRouteReq extends Message {
    public static final Boolean DEFAULT_BLUETOOTHOPEN = false;
    public static final Long DEFAULT_CITYID = 0L;
    public static final String DEFAULT_COUNTRYID = "";
    public static final Integer DEFAULT_DRIVERDIRECTION = 0;
    public static final Long DEFAULT_DRIVERID = 0L;
    public static final String DEFAULT_DYNAMICPARAMETER = "";
    public static final List<LegInfo> DEFAULT_LEGSINFO = Collections.emptyList();
    public static final String DEFAULT_MAPTYPE = "";
    public static final String DEFAULT_MAPVERSION = "";
    public static final List<OdPoint> DEFAULT_ODPOINTS = Collections.emptyList();
    public static final Long DEFAULT_ODPOINTSTIMESTAMP = 0L;
    public static final String DEFAULT_ORDERID = "";
    public static final Integer DEFAULT_ORDERSTAGE = 0;
    public static final Long DEFAULT_PASSENGERID = 0L;
    public static final String DEFAULT_PHONENUM = "";
    public static final String DEFAULT_PRODUCTID = "";
    public static final String DEFAULT_TICKET = "";
    public static final Long DEFAULT_TIMESTAMP = 0L;
    public static final String DEFAULT_VERSION = "5";
    @ProtoField(tag = 22, type = Message.Datatype.BOOL)
    public final Boolean bluetoothOpen;
    @ProtoField(tag = 11, type = Message.Datatype.UINT64)
    public final Long cityId;
    @ProtoField(tag = 10, type = Message.Datatype.STRING)
    public final String countryId;
    @ProtoField(tag = 19)
    public final OdPoint destPoint;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer driverDirection;
    @ProtoField(tag = 12, type = Message.Datatype.UINT64)
    public final Long driverId;
    @ProtoField(tag = 5)
    public final DoublePoint driverLocation;
    @ProtoField(tag = 21, type = Message.Datatype.STRING)
    public final String dynamicParameter;
    @ProtoField(label = Message.Label.REPEATED, messageType = LegInfo.class, tag = 14)
    public final List<LegInfo> legsInfo;
    @ProtoField(tag = 15, type = Message.Datatype.STRING)
    public final String mapType;
    @ProtoField(tag = 16, type = Message.Datatype.STRING)
    public final String mapVersion;
    @ProtoField(label = Message.Label.REPEATED, messageType = OdPoint.class, tag = 17)
    public final List<OdPoint> odPoints;
    @ProtoField(tag = 18, type = Message.Datatype.UINT64)
    public final Long odPointsTimestamp;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.STRING)
    public final String orderId;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer orderStage;
    @ProtoField(tag = 13, type = Message.Datatype.UINT64)
    public final Long passengerId;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String phoneNum;
    @ProtoField(tag = 9, type = Message.Datatype.STRING)
    public final String productId;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.STRING)
    public final String ticket;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.UINT64)
    public final Long timestamp;
    @ProtoField(tag = 7)
    public final HisTraj trajs;
    @ProtoField(tag = 20, type = Message.Datatype.STRING)
    public final String version;

    public DriverPushRouteReq(Long l, String str, String str2, Integer num, DoublePoint doublePoint, Integer num2, HisTraj hisTraj, String str3, String str4, String str5, Long l2, Long l3, Long l4, List<LegInfo> list, String str6, String str7, List<OdPoint> list2, Long l5, OdPoint odPoint, String str8, String str9, Boolean bool) {
        this.timestamp = l;
        this.ticket = str;
        this.orderId = str2;
        this.orderStage = num;
        this.driverLocation = doublePoint;
        this.driverDirection = num2;
        this.trajs = hisTraj;
        this.phoneNum = str3;
        this.productId = str4;
        this.countryId = str5;
        this.cityId = l2;
        this.driverId = l3;
        this.passengerId = l4;
        this.legsInfo = immutableCopyOf(list);
        this.mapType = str6;
        this.mapVersion = str7;
        this.odPoints = immutableCopyOf(list2);
        this.odPointsTimestamp = l5;
        this.destPoint = odPoint;
        this.version = str8;
        this.dynamicParameter = str9;
        this.bluetoothOpen = bool;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private DriverPushRouteReq(com.didi.map.sdk.proto.driver_gl.DriverPushRouteReq.Builder r26) {
        /*
            r25 = this;
            r0 = r26
            r1 = r25
            java.lang.Long r2 = r0.timestamp
            java.lang.String r3 = r0.ticket
            java.lang.String r4 = r0.orderId
            java.lang.Integer r5 = r0.orderStage
            com.didi.map.sdk.proto.driver_gl.DoublePoint r6 = r0.driverLocation
            java.lang.Integer r7 = r0.driverDirection
            com.didi.map.sdk.proto.driver_gl.HisTraj r8 = r0.trajs
            java.lang.String r9 = r0.phoneNum
            java.lang.String r10 = r0.productId
            java.lang.String r11 = r0.countryId
            java.lang.Long r12 = r0.cityId
            java.lang.Long r13 = r0.driverId
            java.lang.Long r14 = r0.passengerId
            java.util.List<com.didi.map.sdk.proto.driver_gl.LegInfo> r15 = r0.legsInfo
            r24 = r1
            java.lang.String r1 = r0.mapType
            r16 = r1
            java.lang.String r1 = r0.mapVersion
            r17 = r1
            java.util.List<com.didi.map.sdk.proto.driver_gl.OdPoint> r1 = r0.odPoints
            r18 = r1
            java.lang.Long r1 = r0.odPointsTimestamp
            r19 = r1
            com.didi.map.sdk.proto.driver_gl.OdPoint r1 = r0.destPoint
            r20 = r1
            java.lang.String r1 = r0.version
            r21 = r1
            java.lang.String r1 = r0.dynamicParameter
            r22 = r1
            java.lang.Boolean r1 = r0.bluetoothOpen
            r23 = r1
            r1 = r24
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            r25.setBuilder(r26)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.sdk.proto.driver_gl.DriverPushRouteReq.<init>(com.didi.map.sdk.proto.driver_gl.DriverPushRouteReq$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DriverPushRouteReq)) {
            return false;
        }
        DriverPushRouteReq driverPushRouteReq = (DriverPushRouteReq) obj;
        if (!equals((Object) this.timestamp, (Object) driverPushRouteReq.timestamp) || !equals((Object) this.ticket, (Object) driverPushRouteReq.ticket) || !equals((Object) this.orderId, (Object) driverPushRouteReq.orderId) || !equals((Object) this.orderStage, (Object) driverPushRouteReq.orderStage) || !equals((Object) this.driverLocation, (Object) driverPushRouteReq.driverLocation) || !equals((Object) this.driverDirection, (Object) driverPushRouteReq.driverDirection) || !equals((Object) this.trajs, (Object) driverPushRouteReq.trajs) || !equals((Object) this.phoneNum, (Object) driverPushRouteReq.phoneNum) || !equals((Object) this.productId, (Object) driverPushRouteReq.productId) || !equals((Object) this.countryId, (Object) driverPushRouteReq.countryId) || !equals((Object) this.cityId, (Object) driverPushRouteReq.cityId) || !equals((Object) this.driverId, (Object) driverPushRouteReq.driverId) || !equals((Object) this.passengerId, (Object) driverPushRouteReq.passengerId) || !equals((List<?>) this.legsInfo, (List<?>) driverPushRouteReq.legsInfo) || !equals((Object) this.mapType, (Object) driverPushRouteReq.mapType) || !equals((Object) this.mapVersion, (Object) driverPushRouteReq.mapVersion) || !equals((List<?>) this.odPoints, (List<?>) driverPushRouteReq.odPoints) || !equals((Object) this.odPointsTimestamp, (Object) driverPushRouteReq.odPointsTimestamp) || !equals((Object) this.destPoint, (Object) driverPushRouteReq.destPoint) || !equals((Object) this.version, (Object) driverPushRouteReq.version) || !equals((Object) this.dynamicParameter, (Object) driverPushRouteReq.dynamicParameter) || !equals((Object) this.bluetoothOpen, (Object) driverPushRouteReq.bluetoothOpen)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.timestamp;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        String str = this.ticket;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.orderId;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num = this.orderStage;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 37;
        DoublePoint doublePoint = this.driverLocation;
        int hashCode5 = (hashCode4 + (doublePoint != null ? doublePoint.hashCode() : 0)) * 37;
        Integer num2 = this.driverDirection;
        int hashCode6 = (hashCode5 + (num2 != null ? num2.hashCode() : 0)) * 37;
        HisTraj hisTraj = this.trajs;
        int hashCode7 = (hashCode6 + (hisTraj != null ? hisTraj.hashCode() : 0)) * 37;
        String str3 = this.phoneNum;
        int hashCode8 = (hashCode7 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.productId;
        int hashCode9 = (hashCode8 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.countryId;
        int hashCode10 = (hashCode9 + (str5 != null ? str5.hashCode() : 0)) * 37;
        Long l2 = this.cityId;
        int hashCode11 = (hashCode10 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.driverId;
        int hashCode12 = (hashCode11 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Long l4 = this.passengerId;
        int hashCode13 = (hashCode12 + (l4 != null ? l4.hashCode() : 0)) * 37;
        List<LegInfo> list = this.legsInfo;
        int i3 = 1;
        int hashCode14 = (hashCode13 + (list != null ? list.hashCode() : 1)) * 37;
        String str6 = this.mapType;
        int hashCode15 = (hashCode14 + (str6 != null ? str6.hashCode() : 0)) * 37;
        String str7 = this.mapVersion;
        int hashCode16 = (hashCode15 + (str7 != null ? str7.hashCode() : 0)) * 37;
        List<OdPoint> list2 = this.odPoints;
        if (list2 != null) {
            i3 = list2.hashCode();
        }
        int i4 = (hashCode16 + i3) * 37;
        Long l5 = this.odPointsTimestamp;
        int hashCode17 = (i4 + (l5 != null ? l5.hashCode() : 0)) * 37;
        OdPoint odPoint = this.destPoint;
        int hashCode18 = (hashCode17 + (odPoint != null ? odPoint.hashCode() : 0)) * 37;
        String str8 = this.version;
        int hashCode19 = (hashCode18 + (str8 != null ? str8.hashCode() : 0)) * 37;
        String str9 = this.dynamicParameter;
        int hashCode20 = (hashCode19 + (str9 != null ? str9.hashCode() : 0)) * 37;
        Boolean bool = this.bluetoothOpen;
        if (bool != null) {
            i2 = bool.hashCode();
        }
        int i5 = hashCode20 + i2;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<DriverPushRouteReq> {
        public Boolean bluetoothOpen;
        public Long cityId;
        public String countryId;
        public OdPoint destPoint;
        public Integer driverDirection;
        public Long driverId;
        public DoublePoint driverLocation;
        public String dynamicParameter;
        public List<LegInfo> legsInfo;
        public String mapType;
        public String mapVersion;
        public List<OdPoint> odPoints;
        public Long odPointsTimestamp;
        public String orderId;
        public Integer orderStage;
        public Long passengerId;
        public String phoneNum;
        public String productId;
        public String ticket;
        public Long timestamp;
        public HisTraj trajs;
        public String version;

        public Builder() {
        }

        public Builder(DriverPushRouteReq driverPushRouteReq) {
            super(driverPushRouteReq);
            if (driverPushRouteReq != null) {
                this.timestamp = driverPushRouteReq.timestamp;
                this.ticket = driverPushRouteReq.ticket;
                this.orderId = driverPushRouteReq.orderId;
                this.orderStage = driverPushRouteReq.orderStage;
                this.driverLocation = driverPushRouteReq.driverLocation;
                this.driverDirection = driverPushRouteReq.driverDirection;
                this.trajs = driverPushRouteReq.trajs;
                this.phoneNum = driverPushRouteReq.phoneNum;
                this.productId = driverPushRouteReq.productId;
                this.countryId = driverPushRouteReq.countryId;
                this.cityId = driverPushRouteReq.cityId;
                this.driverId = driverPushRouteReq.driverId;
                this.passengerId = driverPushRouteReq.passengerId;
                this.legsInfo = DriverPushRouteReq.copyOf(driverPushRouteReq.legsInfo);
                this.mapType = driverPushRouteReq.mapType;
                this.mapVersion = driverPushRouteReq.mapVersion;
                this.odPoints = DriverPushRouteReq.copyOf(driverPushRouteReq.odPoints);
                this.odPointsTimestamp = driverPushRouteReq.odPointsTimestamp;
                this.destPoint = driverPushRouteReq.destPoint;
                this.version = driverPushRouteReq.version;
                this.dynamicParameter = driverPushRouteReq.dynamicParameter;
                this.bluetoothOpen = driverPushRouteReq.bluetoothOpen;
            }
        }

        public Builder timestamp(Long l) {
            this.timestamp = l;
            return this;
        }

        public Builder ticket(String str) {
            this.ticket = str;
            return this;
        }

        public Builder orderId(String str) {
            this.orderId = str;
            return this;
        }

        public Builder orderStage(Integer num) {
            this.orderStage = num;
            return this;
        }

        public Builder driverLocation(DoublePoint doublePoint) {
            this.driverLocation = doublePoint;
            return this;
        }

        public Builder driverDirection(Integer num) {
            this.driverDirection = num;
            return this;
        }

        public Builder trajs(HisTraj hisTraj) {
            this.trajs = hisTraj;
            return this;
        }

        public Builder phoneNum(String str) {
            this.phoneNum = str;
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

        public Builder cityId(Long l) {
            this.cityId = l;
            return this;
        }

        public Builder driverId(Long l) {
            this.driverId = l;
            return this;
        }

        public Builder passengerId(Long l) {
            this.passengerId = l;
            return this;
        }

        public Builder legsInfo(List<LegInfo> list) {
            this.legsInfo = checkForNulls(list);
            return this;
        }

        public Builder mapType(String str) {
            this.mapType = str;
            return this;
        }

        public Builder mapVersion(String str) {
            this.mapVersion = str;
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

        public Builder destPoint(OdPoint odPoint) {
            this.destPoint = odPoint;
            return this;
        }

        public Builder version(String str) {
            this.version = str;
            return this;
        }

        public Builder dynamicParameter(String str) {
            this.dynamicParameter = str;
            return this;
        }

        public Builder bluetoothOpen(Boolean bool) {
            this.bluetoothOpen = bool;
            return this;
        }

        public DriverPushRouteReq build() {
            checkRequiredFields();
            return new DriverPushRouteReq(this);
        }
    }
}
