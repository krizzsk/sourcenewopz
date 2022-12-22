package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class RoutePlanReq extends Message {
    public static final Integer DEFAULT_BIZGROUP = 0;
    public static final String DEFAULT_CALLER = "";
    public static final String DEFAULT_COUNTRYID = "";
    public static final Long DEFAULT_DRIVERID = 0L;
    public static final String DEFAULT_EXTENDDATA = "";
    public static final List<OdPoint> DEFAULT_ODPOINTS = Collections.emptyList();
    public static final String DEFAULT_ORDERID = "";
    public static final Integer DEFAULT_ORDERSTAGE = 0;
    public static final Long DEFAULT_PASSENGERID = 0L;
    public static final List<Long> DEFAULT_PASSENGERS = Collections.emptyList();
    public static final String DEFAULT_PHONENUM = "";
    public static final String DEFAULT_PRODUCTID = "";
    public static final String DEFAULT_TOKEN = "";
    public static final String DEFAULT_TRACEINFO = "";
    public static final String DEFAULT_TRAVELID = "";
    public static final TravelMode DEFAULT_TRAVELMODE = TravelMode.DRIVING;
    @ProtoField(tag = 19, type = Message.Datatype.INT32)
    public final Integer bizGroup;
    @ProtoField(tag = 14, type = Message.Datatype.STRING)
    public final String caller;
    @ProtoField(tag = 9, type = Message.Datatype.STRING)
    public final String countryId;
    @ProtoField(tag = 8, type = Message.Datatype.UINT64)
    public final Long driverId;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2)
    public final DoublePoint endPoint;
    @ProtoField(tag = 16, type = Message.Datatype.STRING)
    public final String extendData;
    @ProtoField(label = Message.Label.REPEATED, messageType = OdPoint.class, tag = 13)
    public final List<OdPoint> odPoints;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String orderId;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer orderStage;
    @ProtoField(tag = 10, type = Message.Datatype.UINT64)
    public final Long passengerId;
    @ProtoField(label = Message.Label.REPEATED, tag = 18, type = Message.Datatype.UINT64)
    public final List<Long> passengers;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String phoneNum;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String productId;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1)
    public final DoublePoint startPoint;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.STRING)
    public final String token;
    @ProtoField(tag = 15, type = Message.Datatype.STRING)
    public final String traceInfo;
    @ProtoField(tag = 17)
    public final HisTraj trajs;
    @ProtoField(tag = 12, type = Message.Datatype.STRING)
    public final String travelId;
    @ProtoField(tag = 11, type = Message.Datatype.ENUM)
    public final TravelMode travelMode;

    public RoutePlanReq(DoublePoint doublePoint, DoublePoint doublePoint2, String str, String str2, String str3, Integer num, String str4, Long l, String str5, Long l2, TravelMode travelMode2, String str6, List<OdPoint> list, String str7, String str8, String str9, HisTraj hisTraj, List<Long> list2, Integer num2) {
        this.startPoint = doublePoint;
        this.endPoint = doublePoint2;
        this.token = str;
        this.orderId = str2;
        this.phoneNum = str3;
        this.orderStage = num;
        this.productId = str4;
        this.driverId = l;
        this.countryId = str5;
        this.passengerId = l2;
        this.travelMode = travelMode2;
        this.travelId = str6;
        this.odPoints = immutableCopyOf(list);
        this.caller = str7;
        this.traceInfo = str8;
        this.extendData = str9;
        this.trajs = hisTraj;
        this.passengers = immutableCopyOf(list2);
        this.bizGroup = num2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private RoutePlanReq(com.didi.map.sdk.proto.driver_gl.RoutePlanReq.Builder r23) {
        /*
            r22 = this;
            r0 = r23
            r1 = r22
            com.didi.map.sdk.proto.driver_gl.DoublePoint r2 = r0.startPoint
            com.didi.map.sdk.proto.driver_gl.DoublePoint r3 = r0.endPoint
            java.lang.String r4 = r0.token
            java.lang.String r5 = r0.orderId
            java.lang.String r6 = r0.phoneNum
            java.lang.Integer r7 = r0.orderStage
            java.lang.String r8 = r0.productId
            java.lang.Long r9 = r0.driverId
            java.lang.String r10 = r0.countryId
            java.lang.Long r11 = r0.passengerId
            com.didi.map.sdk.proto.driver_gl.TravelMode r12 = r0.travelMode
            java.lang.String r13 = r0.travelId
            java.util.List<com.didi.map.sdk.proto.driver_gl.OdPoint> r14 = r0.odPoints
            java.lang.String r15 = r0.caller
            r21 = r1
            java.lang.String r1 = r0.traceInfo
            r16 = r1
            java.lang.String r1 = r0.extendData
            r17 = r1
            com.didi.map.sdk.proto.driver_gl.HisTraj r1 = r0.trajs
            r18 = r1
            java.util.List<java.lang.Long> r1 = r0.passengers
            r19 = r1
            java.lang.Integer r1 = r0.bizGroup
            r20 = r1
            r1 = r21
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            r22.setBuilder(r23)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.sdk.proto.driver_gl.RoutePlanReq.<init>(com.didi.map.sdk.proto.driver_gl.RoutePlanReq$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RoutePlanReq)) {
            return false;
        }
        RoutePlanReq routePlanReq = (RoutePlanReq) obj;
        if (!equals((Object) this.startPoint, (Object) routePlanReq.startPoint) || !equals((Object) this.endPoint, (Object) routePlanReq.endPoint) || !equals((Object) this.token, (Object) routePlanReq.token) || !equals((Object) this.orderId, (Object) routePlanReq.orderId) || !equals((Object) this.phoneNum, (Object) routePlanReq.phoneNum) || !equals((Object) this.orderStage, (Object) routePlanReq.orderStage) || !equals((Object) this.productId, (Object) routePlanReq.productId) || !equals((Object) this.driverId, (Object) routePlanReq.driverId) || !equals((Object) this.countryId, (Object) routePlanReq.countryId) || !equals((Object) this.passengerId, (Object) routePlanReq.passengerId) || !equals((Object) this.travelMode, (Object) routePlanReq.travelMode) || !equals((Object) this.travelId, (Object) routePlanReq.travelId) || !equals((List<?>) this.odPoints, (List<?>) routePlanReq.odPoints) || !equals((Object) this.caller, (Object) routePlanReq.caller) || !equals((Object) this.traceInfo, (Object) routePlanReq.traceInfo) || !equals((Object) this.extendData, (Object) routePlanReq.extendData) || !equals((Object) this.trajs, (Object) routePlanReq.trajs) || !equals((List<?>) this.passengers, (List<?>) routePlanReq.passengers) || !equals((Object) this.bizGroup, (Object) routePlanReq.bizGroup)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        DoublePoint doublePoint = this.startPoint;
        int i2 = 0;
        int hashCode = (doublePoint != null ? doublePoint.hashCode() : 0) * 37;
        DoublePoint doublePoint2 = this.endPoint;
        int hashCode2 = (hashCode + (doublePoint2 != null ? doublePoint2.hashCode() : 0)) * 37;
        String str = this.token;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.orderId;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.phoneNum;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Integer num = this.orderStage;
        int hashCode6 = (hashCode5 + (num != null ? num.hashCode() : 0)) * 37;
        String str4 = this.productId;
        int hashCode7 = (hashCode6 + (str4 != null ? str4.hashCode() : 0)) * 37;
        Long l = this.driverId;
        int hashCode8 = (hashCode7 + (l != null ? l.hashCode() : 0)) * 37;
        String str5 = this.countryId;
        int hashCode9 = (hashCode8 + (str5 != null ? str5.hashCode() : 0)) * 37;
        Long l2 = this.passengerId;
        int hashCode10 = (hashCode9 + (l2 != null ? l2.hashCode() : 0)) * 37;
        TravelMode travelMode2 = this.travelMode;
        int hashCode11 = (hashCode10 + (travelMode2 != null ? travelMode2.hashCode() : 0)) * 37;
        String str6 = this.travelId;
        int hashCode12 = (hashCode11 + (str6 != null ? str6.hashCode() : 0)) * 37;
        List<OdPoint> list = this.odPoints;
        int i3 = 1;
        int hashCode13 = (hashCode12 + (list != null ? list.hashCode() : 1)) * 37;
        String str7 = this.caller;
        int hashCode14 = (hashCode13 + (str7 != null ? str7.hashCode() : 0)) * 37;
        String str8 = this.traceInfo;
        int hashCode15 = (hashCode14 + (str8 != null ? str8.hashCode() : 0)) * 37;
        String str9 = this.extendData;
        int hashCode16 = (hashCode15 + (str9 != null ? str9.hashCode() : 0)) * 37;
        HisTraj hisTraj = this.trajs;
        int hashCode17 = (hashCode16 + (hisTraj != null ? hisTraj.hashCode() : 0)) * 37;
        List<Long> list2 = this.passengers;
        if (list2 != null) {
            i3 = list2.hashCode();
        }
        int i4 = (hashCode17 + i3) * 37;
        Integer num2 = this.bizGroup;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i5 = i4 + i2;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<RoutePlanReq> {
        public Integer bizGroup;
        public String caller;
        public String countryId;
        public Long driverId;
        public DoublePoint endPoint;
        public String extendData;
        public List<OdPoint> odPoints;
        public String orderId;
        public Integer orderStage;
        public Long passengerId;
        public List<Long> passengers;
        public String phoneNum;
        public String productId;
        public DoublePoint startPoint;
        public String token;
        public String traceInfo;
        public HisTraj trajs;
        public String travelId;
        public TravelMode travelMode;

        public Builder() {
        }

        public Builder(RoutePlanReq routePlanReq) {
            super(routePlanReq);
            if (routePlanReq != null) {
                this.startPoint = routePlanReq.startPoint;
                this.endPoint = routePlanReq.endPoint;
                this.token = routePlanReq.token;
                this.orderId = routePlanReq.orderId;
                this.phoneNum = routePlanReq.phoneNum;
                this.orderStage = routePlanReq.orderStage;
                this.productId = routePlanReq.productId;
                this.driverId = routePlanReq.driverId;
                this.countryId = routePlanReq.countryId;
                this.passengerId = routePlanReq.passengerId;
                this.travelMode = routePlanReq.travelMode;
                this.travelId = routePlanReq.travelId;
                this.odPoints = RoutePlanReq.copyOf(routePlanReq.odPoints);
                this.caller = routePlanReq.caller;
                this.traceInfo = routePlanReq.traceInfo;
                this.extendData = routePlanReq.extendData;
                this.trajs = routePlanReq.trajs;
                this.passengers = RoutePlanReq.copyOf(routePlanReq.passengers);
                this.bizGroup = routePlanReq.bizGroup;
            }
        }

        public Builder startPoint(DoublePoint doublePoint) {
            this.startPoint = doublePoint;
            return this;
        }

        public Builder endPoint(DoublePoint doublePoint) {
            this.endPoint = doublePoint;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
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

        public Builder productId(String str) {
            this.productId = str;
            return this;
        }

        public Builder driverId(Long l) {
            this.driverId = l;
            return this;
        }

        public Builder countryId(String str) {
            this.countryId = str;
            return this;
        }

        public Builder passengerId(Long l) {
            this.passengerId = l;
            return this;
        }

        public Builder travelMode(TravelMode travelMode2) {
            this.travelMode = travelMode2;
            return this;
        }

        public Builder travelId(String str) {
            this.travelId = str;
            return this;
        }

        public Builder odPoints(List<OdPoint> list) {
            this.odPoints = checkForNulls(list);
            return this;
        }

        public Builder caller(String str) {
            this.caller = str;
            return this;
        }

        public Builder traceInfo(String str) {
            this.traceInfo = str;
            return this;
        }

        public Builder extendData(String str) {
            this.extendData = str;
            return this;
        }

        public Builder trajs(HisTraj hisTraj) {
            this.trajs = hisTraj;
            return this;
        }

        public Builder passengers(List<Long> list) {
            this.passengers = checkForNulls(list);
            return this;
        }

        public Builder bizGroup(Integer num) {
            this.bizGroup = num;
            return this;
        }

        public RoutePlanReq build() {
            checkRequiredFields();
            return new RoutePlanReq(this);
        }
    }
}
