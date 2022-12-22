package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class PassengerMultiRouteSelectReq extends Message {
    public static final Long DEFAULT_SELECTROUTEID = 0L;
    public static final String DEFAULT_TRACEID = "";
    public static final String DEFAULT_VERSION = "";
    @ProtoField(label = Message.Label.REQUIRED, tag = 1)
    public final OrderInfo orderInfo;
    @ProtoField(label = Message.Label.REQUIRED, tag = 4, type = Message.Datatype.INT64)
    public final Long selectRouteId;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String traceId;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.STRING)
    public final String version;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2)
    public final VisitorInfo visitorInfo;

    public PassengerMultiRouteSelectReq(OrderInfo orderInfo2, VisitorInfo visitorInfo2, String str, Long l, String str2) {
        this.orderInfo = orderInfo2;
        this.visitorInfo = visitorInfo2;
        this.version = str;
        this.selectRouteId = l;
        this.traceId = str2;
    }

    private PassengerMultiRouteSelectReq(Builder builder) {
        this(builder.orderInfo, builder.visitorInfo, builder.version, builder.selectRouteId, builder.traceId);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PassengerMultiRouteSelectReq)) {
            return false;
        }
        PassengerMultiRouteSelectReq passengerMultiRouteSelectReq = (PassengerMultiRouteSelectReq) obj;
        if (!equals((Object) this.orderInfo, (Object) passengerMultiRouteSelectReq.orderInfo) || !equals((Object) this.visitorInfo, (Object) passengerMultiRouteSelectReq.visitorInfo) || !equals((Object) this.version, (Object) passengerMultiRouteSelectReq.version) || !equals((Object) this.selectRouteId, (Object) passengerMultiRouteSelectReq.selectRouteId) || !equals((Object) this.traceId, (Object) passengerMultiRouteSelectReq.traceId)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        OrderInfo orderInfo2 = this.orderInfo;
        int i2 = 0;
        int hashCode = (orderInfo2 != null ? orderInfo2.hashCode() : 0) * 37;
        VisitorInfo visitorInfo2 = this.visitorInfo;
        int hashCode2 = (hashCode + (visitorInfo2 != null ? visitorInfo2.hashCode() : 0)) * 37;
        String str = this.version;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        Long l = this.selectRouteId;
        int hashCode4 = (hashCode3 + (l != null ? l.hashCode() : 0)) * 37;
        String str2 = this.traceId;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<PassengerMultiRouteSelectReq> {
        public OrderInfo orderInfo;
        public Long selectRouteId;
        public String traceId;
        public String version;
        public VisitorInfo visitorInfo;

        public Builder() {
        }

        public Builder(PassengerMultiRouteSelectReq passengerMultiRouteSelectReq) {
            super(passengerMultiRouteSelectReq);
            if (passengerMultiRouteSelectReq != null) {
                this.orderInfo = passengerMultiRouteSelectReq.orderInfo;
                this.visitorInfo = passengerMultiRouteSelectReq.visitorInfo;
                this.version = passengerMultiRouteSelectReq.version;
                this.selectRouteId = passengerMultiRouteSelectReq.selectRouteId;
                this.traceId = passengerMultiRouteSelectReq.traceId;
            }
        }

        public Builder orderInfo(OrderInfo orderInfo2) {
            this.orderInfo = orderInfo2;
            return this;
        }

        public Builder visitorInfo(VisitorInfo visitorInfo2) {
            this.visitorInfo = visitorInfo2;
            return this;
        }

        public Builder version(String str) {
            this.version = str;
            return this;
        }

        public Builder selectRouteId(Long l) {
            this.selectRouteId = l;
            return this;
        }

        public Builder traceId(String str) {
            this.traceId = str;
            return this;
        }

        public PassengerMultiRouteSelectReq build() {
            checkRequiredFields();
            return new PassengerMultiRouteSelectReq(this);
        }
    }
}
