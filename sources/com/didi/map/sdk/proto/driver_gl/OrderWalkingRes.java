package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import okio.ByteString;

public final class OrderWalkingRes extends Message {
    public static final Integer DEFAULT_DISTANCE = -1;
    public static final Integer DEFAULT_ETA = -1;
    public static final Long DEFAULT_LOGID = 0L;
    public static final String DEFAULT_MSG = "";
    public static final Integer DEFAULT_RET = 0;
    public static final ByteString DEFAULT_ROUTEENGINERESPACK = ByteString.EMPTY;
    public static final Long DEFAULT_ROUTEID = 0L;
    public static final WalkState DEFAULT_STATE = WalkState.STATE_STANDING;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer distance;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer eta;
    @ProtoField(tag = 3)
    public final DiffGeoPoints geos;
    @ProtoField(tag = 10, type = Message.Datatype.UINT64)
    public final Long logid;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String msg;
    @ProtoField(tag = 9)
    public final DoublePoint psgPos;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer ret;
    @ProtoField(tag = 6, type = Message.Datatype.BYTES)
    public final ByteString routeEngineResPack;
    @ProtoField(tag = 7, type = Message.Datatype.INT64)
    public final Long routeId;
    @ProtoField(tag = 8, type = Message.Datatype.ENUM)
    public final WalkState state;

    public OrderWalkingRes(Integer num, String str, DiffGeoPoints diffGeoPoints, Integer num2, Integer num3, ByteString byteString, Long l, WalkState walkState, DoublePoint doublePoint, Long l2) {
        this.ret = num;
        this.msg = str;
        this.geos = diffGeoPoints;
        this.eta = num2;
        this.distance = num3;
        this.routeEngineResPack = byteString;
        this.routeId = l;
        this.state = walkState;
        this.psgPos = doublePoint;
        this.logid = l2;
    }

    private OrderWalkingRes(Builder builder) {
        this(builder.ret, builder.msg, builder.geos, builder.eta, builder.distance, builder.routeEngineResPack, builder.routeId, builder.state, builder.psgPos, builder.logid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OrderWalkingRes)) {
            return false;
        }
        OrderWalkingRes orderWalkingRes = (OrderWalkingRes) obj;
        if (!equals((Object) this.ret, (Object) orderWalkingRes.ret) || !equals((Object) this.msg, (Object) orderWalkingRes.msg) || !equals((Object) this.geos, (Object) orderWalkingRes.geos) || !equals((Object) this.eta, (Object) orderWalkingRes.eta) || !equals((Object) this.distance, (Object) orderWalkingRes.distance) || !equals((Object) this.routeEngineResPack, (Object) orderWalkingRes.routeEngineResPack) || !equals((Object) this.routeId, (Object) orderWalkingRes.routeId) || !equals((Object) this.state, (Object) orderWalkingRes.state) || !equals((Object) this.psgPos, (Object) orderWalkingRes.psgPos) || !equals((Object) this.logid, (Object) orderWalkingRes.logid)) {
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
        DiffGeoPoints diffGeoPoints = this.geos;
        int hashCode3 = (hashCode2 + (diffGeoPoints != null ? diffGeoPoints.hashCode() : 0)) * 37;
        Integer num2 = this.eta;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.distance;
        int hashCode5 = (hashCode4 + (num3 != null ? num3.hashCode() : 0)) * 37;
        ByteString byteString = this.routeEngineResPack;
        int hashCode6 = (hashCode5 + (byteString != null ? byteString.hashCode() : 0)) * 37;
        Long l = this.routeId;
        int hashCode7 = (hashCode6 + (l != null ? l.hashCode() : 0)) * 37;
        WalkState walkState = this.state;
        int hashCode8 = (hashCode7 + (walkState != null ? walkState.hashCode() : 0)) * 37;
        DoublePoint doublePoint = this.psgPos;
        int hashCode9 = (hashCode8 + (doublePoint != null ? doublePoint.hashCode() : 0)) * 37;
        Long l2 = this.logid;
        if (l2 != null) {
            i2 = l2.hashCode();
        }
        int i3 = hashCode9 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<OrderWalkingRes> {
        public Integer distance;
        public Integer eta;
        public DiffGeoPoints geos;
        public Long logid;
        public String msg;
        public DoublePoint psgPos;
        public Integer ret;
        public ByteString routeEngineResPack;
        public Long routeId;
        public WalkState state;

        public Builder() {
        }

        public Builder(OrderWalkingRes orderWalkingRes) {
            super(orderWalkingRes);
            if (orderWalkingRes != null) {
                this.ret = orderWalkingRes.ret;
                this.msg = orderWalkingRes.msg;
                this.geos = orderWalkingRes.geos;
                this.eta = orderWalkingRes.eta;
                this.distance = orderWalkingRes.distance;
                this.routeEngineResPack = orderWalkingRes.routeEngineResPack;
                this.routeId = orderWalkingRes.routeId;
                this.state = orderWalkingRes.state;
                this.psgPos = orderWalkingRes.psgPos;
                this.logid = orderWalkingRes.logid;
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

        public Builder geos(DiffGeoPoints diffGeoPoints) {
            this.geos = diffGeoPoints;
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

        public Builder routeEngineResPack(ByteString byteString) {
            this.routeEngineResPack = byteString;
            return this;
        }

        public Builder routeId(Long l) {
            this.routeId = l;
            return this;
        }

        public Builder state(WalkState walkState) {
            this.state = walkState;
            return this;
        }

        public Builder psgPos(DoublePoint doublePoint) {
            this.psgPos = doublePoint;
            return this;
        }

        public Builder logid(Long l) {
            this.logid = l;
            return this;
        }

        public OrderWalkingRes build() {
            return new OrderWalkingRes(this);
        }
    }
}
