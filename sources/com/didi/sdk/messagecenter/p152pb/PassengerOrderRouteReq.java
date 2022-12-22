package com.didi.sdk.messagecenter.p152pb;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

/* renamed from: com.didi.sdk.messagecenter.pb.PassengerOrderRouteReq */
public final class PassengerOrderRouteReq extends Message {
    public static final Integer DEFAULT_BIZTYPE = 0;
    public static final Long DEFAULT_CURROUTEID = 0L;
    public static final String DEFAULT_DIDIVERSION = "";
    public static final Long DEFAULT_DRIVERID = 0L;
    public static final String DEFAULT_IMEI = "";
    public static final Boolean DEFAULT_ISNEEDTRAJ = false;
    public static final String DEFAULT_ORDERID = "";
    public static final Integer DEFAULT_ORDERSTAGE = 0;
    public static final Long DEFAULT_PASSENGERID = 0L;
    public static final String DEFAULT_PHONENUM = "";
    public static final Integer DEFAULT_PSGBIZTYPE = 0;
    public static final String DEFAULT_ROUTEENGINETYPE = "";
    public static final String DEFAULT_SDKMAPTYPE = "";
    public static final Long DEFAULT_TIMESTAMP = 0L;
    public static final String DEFAULT_TOKEN = "";
    public static final String DEFAULT_VERSION = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 6, type = Message.Datatype.INT32)
    public final Integer bizType;
    @ProtoField(label = Message.Label.REQUIRED, tag = 5, type = Message.Datatype.INT64)
    public final Long curRouteId;
    @ProtoField(tag = 16, type = Message.Datatype.STRING)
    public final String didiVersion;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.UINT64)
    public final Long driverId;
    @ProtoField(label = Message.Label.REQUIRED, tag = 8, type = Message.Datatype.STRING)
    public final String imei;
    @ProtoField(label = Message.Label.REQUIRED, tag = 4, type = Message.Datatype.BOOL)
    public final Boolean isNeedTraj;
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
    @ProtoField(tag = 18, type = Message.Datatype.INT32)
    public final Integer psgBizType;
    @ProtoField(tag = 17, type = Message.Datatype.STRING)
    public final String routeEngineType;
    @ProtoField(tag = 15, type = Message.Datatype.STRING)
    public final String sdkmaptype;
    @ProtoField(label = Message.Label.REQUIRED, tag = 10, type = Message.Datatype.UINT64)
    public final Long timestamp;
    @ProtoField(label = Message.Label.REQUIRED, tag = 13, type = Message.Datatype.STRING)
    public final String token;
    @ProtoField(label = Message.Label.REQUIRED, tag = 9, type = Message.Datatype.STRING)
    public final String version;

    public PassengerOrderRouteReq(String str, String str2, Long l, Boolean bool, Long l2, Integer num, Integer num2, String str3, String str4, Long l3, DoublePoint doublePoint, DoublePoint doublePoint2, String str5, Long l4, String str6, String str7, String str8, Integer num3) {
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
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private PassengerOrderRouteReq(com.didi.sdk.messagecenter.p152pb.PassengerOrderRouteReq.Builder r22) {
        /*
            r21 = this;
            r0 = r22
            r1 = r21
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
            com.didi.sdk.messagecenter.pb.DoublePoint r12 = r0.pickupEndPoint
            com.didi.sdk.messagecenter.pb.DoublePoint r13 = r0.orderEndPoint
            java.lang.String r14 = r0.token
            java.lang.Long r15 = r0.passengerId
            r20 = r1
            java.lang.String r1 = r0.sdkmaptype
            r16 = r1
            java.lang.String r1 = r0.didiVersion
            r17 = r1
            java.lang.String r1 = r0.routeEngineType
            r18 = r1
            java.lang.Integer r1 = r0.psgBizType
            r19 = r1
            r1 = r20
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            r21.setBuilder(r22)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.messagecenter.p152pb.PassengerOrderRouteReq.<init>(com.didi.sdk.messagecenter.pb.PassengerOrderRouteReq$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PassengerOrderRouteReq)) {
            return false;
        }
        PassengerOrderRouteReq passengerOrderRouteReq = (PassengerOrderRouteReq) obj;
        if (!equals((Object) this.orderId, (Object) passengerOrderRouteReq.orderId) || !equals((Object) this.phoneNum, (Object) passengerOrderRouteReq.phoneNum) || !equals((Object) this.driverId, (Object) passengerOrderRouteReq.driverId) || !equals((Object) this.isNeedTraj, (Object) passengerOrderRouteReq.isNeedTraj) || !equals((Object) this.curRouteId, (Object) passengerOrderRouteReq.curRouteId) || !equals((Object) this.bizType, (Object) passengerOrderRouteReq.bizType) || !equals((Object) this.orderStage, (Object) passengerOrderRouteReq.orderStage) || !equals((Object) this.imei, (Object) passengerOrderRouteReq.imei) || !equals((Object) this.version, (Object) passengerOrderRouteReq.version) || !equals((Object) this.timestamp, (Object) passengerOrderRouteReq.timestamp) || !equals((Object) this.pickupEndPoint, (Object) passengerOrderRouteReq.pickupEndPoint) || !equals((Object) this.orderEndPoint, (Object) passengerOrderRouteReq.orderEndPoint) || !equals((Object) this.token, (Object) passengerOrderRouteReq.token) || !equals((Object) this.passengerId, (Object) passengerOrderRouteReq.passengerId) || !equals((Object) this.sdkmaptype, (Object) passengerOrderRouteReq.sdkmaptype) || !equals((Object) this.didiVersion, (Object) passengerOrderRouteReq.didiVersion) || !equals((Object) this.routeEngineType, (Object) passengerOrderRouteReq.routeEngineType) || !equals((Object) this.psgBizType, (Object) passengerOrderRouteReq.psgBizType)) {
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
        if (num3 != null) {
            i2 = num3.hashCode();
        }
        int i3 = hashCode17 + i2;
        this.hashCode = i3;
        return i3;
    }

    /* renamed from: com.didi.sdk.messagecenter.pb.PassengerOrderRouteReq$Builder */
    public static final class Builder extends Message.Builder<PassengerOrderRouteReq> {
        public Integer bizType;
        public Long curRouteId;
        public String didiVersion;
        public Long driverId;
        public String imei;
        public Boolean isNeedTraj;
        public DoublePoint orderEndPoint;
        public String orderId;
        public Integer orderStage;
        public Long passengerId;
        public String phoneNum;
        public DoublePoint pickupEndPoint;
        public Integer psgBizType;
        public String routeEngineType;
        public String sdkmaptype;
        public Long timestamp;
        public String token;
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

        public PassengerOrderRouteReq build() {
            checkRequiredFields();
            return new PassengerOrderRouteReq(this);
        }
    }
}
