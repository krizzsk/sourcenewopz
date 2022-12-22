package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import okio.ByteString;

public final class OrderWalkingReq extends Message {
    public static final Integer DEFAULT_BIZTYPE = 0;
    public static final String DEFAULT_CALLER = "";
    public static final Long DEFAULT_CURROUTEID = 0L;
    public static final String DEFAULT_DIDIVERSION = "";
    public static final Long DEFAULT_DRIVERID = 0L;
    public static final Integer DEFAULT_EVENTTYPE = 0;
    public static final String DEFAULT_ORDERID = "";
    public static final Long DEFAULT_PASSENGERID = 0L;
    public static final String DEFAULT_PRODUCTID = "";
    public static final Integer DEFAULT_ROLE = 0;
    public static final ByteString DEFAULT_ROUTEENGINEREQPACK = ByteString.EMPTY;
    public static final WalkScene DEFAULT_SCENE = WalkScene.START;
    public static final String DEFAULT_SDKMAPTYPE = "";
    public static final WalkState DEFAULT_STATE = WalkState.STATE_STANDING;
    public static final Integer DEFAULT_TYPE = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 6, type = Message.Datatype.INT32)
    public final Integer bizType;
    @ProtoField(tag = 18, type = Message.Datatype.STRING)
    public final String caller;
    @ProtoField(label = Message.Label.REQUIRED, tag = 12, type = Message.Datatype.INT64)
    public final Long curRouteId;
    @ProtoField(tag = 19, type = Message.Datatype.STRING)
    public final String didiVersion;
    @ProtoField(tag = 7, type = Message.Datatype.UINT64)
    public final Long driverId;
    @ProtoField(tag = 2)
    public final DoublePoint dstGeo;
    @ProtoField(label = Message.Label.REQUIRED, tag = 11, type = Message.Datatype.INT32)
    public final Integer eventType;
    @ProtoField(tag = 9, type = Message.Datatype.STRING)
    public final String orderId;
    @ProtoField(tag = 8, type = Message.Datatype.UINT64)
    public final Long passengerId;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String productId;
    @ProtoField(tag = 13)
    public final DoublePoint psgPos;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.INT32)
    public final Integer role;
    @ProtoField(tag = 16, type = Message.Datatype.BYTES)
    public final ByteString routeEngineReqPack;
    @ProtoField(tag = 15, type = Message.Datatype.ENUM)
    public final WalkScene scene;
    @ProtoField(tag = 17, type = Message.Datatype.STRING)
    public final String sdkmaptype;
    @ProtoField(tag = 1)
    public final DoublePoint srcGeo;
    @ProtoField(tag = 14, type = Message.Datatype.ENUM)
    public final WalkState state;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer type;
    @ProtoField(tag = 10)
    public final VisitorInfo visitorInfo;

    public OrderWalkingReq(DoublePoint doublePoint, DoublePoint doublePoint2, Integer num, Integer num2, String str, Integer num3, Long l, Long l2, String str2, VisitorInfo visitorInfo2, Integer num4, Long l3, DoublePoint doublePoint3, WalkState walkState, WalkScene walkScene, ByteString byteString, String str3, String str4, String str5) {
        this.srcGeo = doublePoint;
        this.dstGeo = doublePoint2;
        this.role = num;
        this.type = num2;
        this.productId = str;
        this.bizType = num3;
        this.driverId = l;
        this.passengerId = l2;
        this.orderId = str2;
        this.visitorInfo = visitorInfo2;
        this.eventType = num4;
        this.curRouteId = l3;
        this.psgPos = doublePoint3;
        this.state = walkState;
        this.scene = walkScene;
        this.routeEngineReqPack = byteString;
        this.sdkmaptype = str3;
        this.caller = str4;
        this.didiVersion = str5;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private OrderWalkingReq(com.didi.map.sdk.proto.driver_gl.OrderWalkingReq.Builder r23) {
        /*
            r22 = this;
            r0 = r23
            r1 = r22
            com.didi.map.sdk.proto.driver_gl.DoublePoint r2 = r0.srcGeo
            com.didi.map.sdk.proto.driver_gl.DoublePoint r3 = r0.dstGeo
            java.lang.Integer r4 = r0.role
            java.lang.Integer r5 = r0.type
            java.lang.String r6 = r0.productId
            java.lang.Integer r7 = r0.bizType
            java.lang.Long r8 = r0.driverId
            java.lang.Long r9 = r0.passengerId
            java.lang.String r10 = r0.orderId
            com.didi.map.sdk.proto.driver_gl.VisitorInfo r11 = r0.visitorInfo
            java.lang.Integer r12 = r0.eventType
            java.lang.Long r13 = r0.curRouteId
            com.didi.map.sdk.proto.driver_gl.DoublePoint r14 = r0.psgPos
            com.didi.map.sdk.proto.driver_gl.WalkState r15 = r0.state
            r21 = r1
            com.didi.map.sdk.proto.driver_gl.WalkScene r1 = r0.scene
            r16 = r1
            okio.ByteString r1 = r0.routeEngineReqPack
            r17 = r1
            java.lang.String r1 = r0.sdkmaptype
            r18 = r1
            java.lang.String r1 = r0.caller
            r19 = r1
            java.lang.String r1 = r0.didiVersion
            r20 = r1
            r1 = r21
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            r22.setBuilder(r23)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.sdk.proto.driver_gl.OrderWalkingReq.<init>(com.didi.map.sdk.proto.driver_gl.OrderWalkingReq$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OrderWalkingReq)) {
            return false;
        }
        OrderWalkingReq orderWalkingReq = (OrderWalkingReq) obj;
        if (!equals((Object) this.srcGeo, (Object) orderWalkingReq.srcGeo) || !equals((Object) this.dstGeo, (Object) orderWalkingReq.dstGeo) || !equals((Object) this.role, (Object) orderWalkingReq.role) || !equals((Object) this.type, (Object) orderWalkingReq.type) || !equals((Object) this.productId, (Object) orderWalkingReq.productId) || !equals((Object) this.bizType, (Object) orderWalkingReq.bizType) || !equals((Object) this.driverId, (Object) orderWalkingReq.driverId) || !equals((Object) this.passengerId, (Object) orderWalkingReq.passengerId) || !equals((Object) this.orderId, (Object) orderWalkingReq.orderId) || !equals((Object) this.visitorInfo, (Object) orderWalkingReq.visitorInfo) || !equals((Object) this.eventType, (Object) orderWalkingReq.eventType) || !equals((Object) this.curRouteId, (Object) orderWalkingReq.curRouteId) || !equals((Object) this.psgPos, (Object) orderWalkingReq.psgPos) || !equals((Object) this.state, (Object) orderWalkingReq.state) || !equals((Object) this.scene, (Object) orderWalkingReq.scene) || !equals((Object) this.routeEngineReqPack, (Object) orderWalkingReq.routeEngineReqPack) || !equals((Object) this.sdkmaptype, (Object) orderWalkingReq.sdkmaptype) || !equals((Object) this.caller, (Object) orderWalkingReq.caller) || !equals((Object) this.didiVersion, (Object) orderWalkingReq.didiVersion)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        DoublePoint doublePoint = this.srcGeo;
        int i2 = 0;
        int hashCode = (doublePoint != null ? doublePoint.hashCode() : 0) * 37;
        DoublePoint doublePoint2 = this.dstGeo;
        int hashCode2 = (hashCode + (doublePoint2 != null ? doublePoint2.hashCode() : 0)) * 37;
        Integer num = this.role;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.type;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str = this.productId;
        int hashCode5 = (hashCode4 + (str != null ? str.hashCode() : 0)) * 37;
        Integer num3 = this.bizType;
        int hashCode6 = (hashCode5 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Long l = this.driverId;
        int hashCode7 = (hashCode6 + (l != null ? l.hashCode() : 0)) * 37;
        Long l2 = this.passengerId;
        int hashCode8 = (hashCode7 + (l2 != null ? l2.hashCode() : 0)) * 37;
        String str2 = this.orderId;
        int hashCode9 = (hashCode8 + (str2 != null ? str2.hashCode() : 0)) * 37;
        VisitorInfo visitorInfo2 = this.visitorInfo;
        int hashCode10 = (hashCode9 + (visitorInfo2 != null ? visitorInfo2.hashCode() : 0)) * 37;
        Integer num4 = this.eventType;
        int hashCode11 = (hashCode10 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Long l3 = this.curRouteId;
        int hashCode12 = (hashCode11 + (l3 != null ? l3.hashCode() : 0)) * 37;
        DoublePoint doublePoint3 = this.psgPos;
        int hashCode13 = (hashCode12 + (doublePoint3 != null ? doublePoint3.hashCode() : 0)) * 37;
        WalkState walkState = this.state;
        int hashCode14 = (hashCode13 + (walkState != null ? walkState.hashCode() : 0)) * 37;
        WalkScene walkScene = this.scene;
        int hashCode15 = (hashCode14 + (walkScene != null ? walkScene.hashCode() : 0)) * 37;
        ByteString byteString = this.routeEngineReqPack;
        int hashCode16 = (hashCode15 + (byteString != null ? byteString.hashCode() : 0)) * 37;
        String str3 = this.sdkmaptype;
        int hashCode17 = (hashCode16 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.caller;
        int hashCode18 = (hashCode17 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.didiVersion;
        if (str5 != null) {
            i2 = str5.hashCode();
        }
        int i3 = hashCode18 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<OrderWalkingReq> {
        public Integer bizType;
        public String caller;
        public Long curRouteId;
        public String didiVersion;
        public Long driverId;
        public DoublePoint dstGeo;
        public Integer eventType;
        public String orderId;
        public Long passengerId;
        public String productId;
        public DoublePoint psgPos;
        public Integer role;
        public ByteString routeEngineReqPack;
        public WalkScene scene;
        public String sdkmaptype;
        public DoublePoint srcGeo;
        public WalkState state;
        public Integer type;
        public VisitorInfo visitorInfo;

        public Builder() {
        }

        public Builder(OrderWalkingReq orderWalkingReq) {
            super(orderWalkingReq);
            if (orderWalkingReq != null) {
                this.srcGeo = orderWalkingReq.srcGeo;
                this.dstGeo = orderWalkingReq.dstGeo;
                this.role = orderWalkingReq.role;
                this.type = orderWalkingReq.type;
                this.productId = orderWalkingReq.productId;
                this.bizType = orderWalkingReq.bizType;
                this.driverId = orderWalkingReq.driverId;
                this.passengerId = orderWalkingReq.passengerId;
                this.orderId = orderWalkingReq.orderId;
                this.visitorInfo = orderWalkingReq.visitorInfo;
                this.eventType = orderWalkingReq.eventType;
                this.curRouteId = orderWalkingReq.curRouteId;
                this.psgPos = orderWalkingReq.psgPos;
                this.state = orderWalkingReq.state;
                this.scene = orderWalkingReq.scene;
                this.routeEngineReqPack = orderWalkingReq.routeEngineReqPack;
                this.sdkmaptype = orderWalkingReq.sdkmaptype;
                this.caller = orderWalkingReq.caller;
                this.didiVersion = orderWalkingReq.didiVersion;
            }
        }

        public Builder srcGeo(DoublePoint doublePoint) {
            this.srcGeo = doublePoint;
            return this;
        }

        public Builder dstGeo(DoublePoint doublePoint) {
            this.dstGeo = doublePoint;
            return this;
        }

        public Builder role(Integer num) {
            this.role = num;
            return this;
        }

        public Builder type(Integer num) {
            this.type = num;
            return this;
        }

        public Builder productId(String str) {
            this.productId = str;
            return this;
        }

        public Builder bizType(Integer num) {
            this.bizType = num;
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

        public Builder orderId(String str) {
            this.orderId = str;
            return this;
        }

        public Builder visitorInfo(VisitorInfo visitorInfo2) {
            this.visitorInfo = visitorInfo2;
            return this;
        }

        public Builder eventType(Integer num) {
            this.eventType = num;
            return this;
        }

        public Builder curRouteId(Long l) {
            this.curRouteId = l;
            return this;
        }

        public Builder psgPos(DoublePoint doublePoint) {
            this.psgPos = doublePoint;
            return this;
        }

        public Builder state(WalkState walkState) {
            this.state = walkState;
            return this;
        }

        public Builder scene(WalkScene walkScene) {
            this.scene = walkScene;
            return this;
        }

        public Builder routeEngineReqPack(ByteString byteString) {
            this.routeEngineReqPack = byteString;
            return this;
        }

        public Builder sdkmaptype(String str) {
            this.sdkmaptype = str;
            return this;
        }

        public Builder caller(String str) {
            this.caller = str;
            return this;
        }

        public Builder didiVersion(String str) {
            this.didiVersion = str;
            return this;
        }

        public OrderWalkingReq build() {
            checkRequiredFields();
            return new OrderWalkingReq(this);
        }
    }
}
