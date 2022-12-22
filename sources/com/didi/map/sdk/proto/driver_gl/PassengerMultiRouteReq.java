package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class PassengerMultiRouteReq extends Message {
    public static final String DEFAULT_CALLERID = "";
    public static final String DEFAULT_LANG = "";
    public static final Long DEFAULT_LASTGROUPID = 0L;
    public static final Boolean DEFAULT_NEEDREFRESH = false;
    public static final Boolean DEFAULT_NEEDROUTEINFO = false;
    public static final String DEFAULT_VERSION = "";
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String callerId;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String lang;
    @ProtoField(tag = 6, type = Message.Datatype.INT64)
    public final Long lastGroupId;
    @ProtoField(tag = 4, type = Message.Datatype.BOOL)
    public final Boolean needRefresh;
    @ProtoField(tag = 5, type = Message.Datatype.BOOL)
    public final Boolean needRouteInfo;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1)
    public final OrderInfo orderInfo;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.STRING)
    public final String version;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2)
    public final VisitorInfo visitorInfo;

    public PassengerMultiRouteReq(OrderInfo orderInfo2, VisitorInfo visitorInfo2, String str, Boolean bool, Boolean bool2, Long l, String str2, String str3) {
        this.orderInfo = orderInfo2;
        this.visitorInfo = visitorInfo2;
        this.version = str;
        this.needRefresh = bool;
        this.needRouteInfo = bool2;
        this.lastGroupId = l;
        this.callerId = str2;
        this.lang = str3;
    }

    private PassengerMultiRouteReq(Builder builder) {
        this(builder.orderInfo, builder.visitorInfo, builder.version, builder.needRefresh, builder.needRouteInfo, builder.lastGroupId, builder.callerId, builder.lang);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PassengerMultiRouteReq)) {
            return false;
        }
        PassengerMultiRouteReq passengerMultiRouteReq = (PassengerMultiRouteReq) obj;
        if (!equals((Object) this.orderInfo, (Object) passengerMultiRouteReq.orderInfo) || !equals((Object) this.visitorInfo, (Object) passengerMultiRouteReq.visitorInfo) || !equals((Object) this.version, (Object) passengerMultiRouteReq.version) || !equals((Object) this.needRefresh, (Object) passengerMultiRouteReq.needRefresh) || !equals((Object) this.needRouteInfo, (Object) passengerMultiRouteReq.needRouteInfo) || !equals((Object) this.lastGroupId, (Object) passengerMultiRouteReq.lastGroupId) || !equals((Object) this.callerId, (Object) passengerMultiRouteReq.callerId) || !equals((Object) this.lang, (Object) passengerMultiRouteReq.lang)) {
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
        Boolean bool = this.needRefresh;
        int hashCode4 = (hashCode3 + (bool != null ? bool.hashCode() : 0)) * 37;
        Boolean bool2 = this.needRouteInfo;
        int hashCode5 = (hashCode4 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        Long l = this.lastGroupId;
        int hashCode6 = (hashCode5 + (l != null ? l.hashCode() : 0)) * 37;
        String str2 = this.callerId;
        int hashCode7 = (hashCode6 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.lang;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        int i3 = hashCode7 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<PassengerMultiRouteReq> {
        public String callerId;
        public String lang;
        public Long lastGroupId;
        public Boolean needRefresh;
        public Boolean needRouteInfo;
        public OrderInfo orderInfo;
        public String version;
        public VisitorInfo visitorInfo;

        public Builder() {
        }

        public Builder(PassengerMultiRouteReq passengerMultiRouteReq) {
            super(passengerMultiRouteReq);
            if (passengerMultiRouteReq != null) {
                this.orderInfo = passengerMultiRouteReq.orderInfo;
                this.visitorInfo = passengerMultiRouteReq.visitorInfo;
                this.version = passengerMultiRouteReq.version;
                this.needRefresh = passengerMultiRouteReq.needRefresh;
                this.needRouteInfo = passengerMultiRouteReq.needRouteInfo;
                this.lastGroupId = passengerMultiRouteReq.lastGroupId;
                this.callerId = passengerMultiRouteReq.callerId;
                this.lang = passengerMultiRouteReq.lang;
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

        public Builder needRefresh(Boolean bool) {
            this.needRefresh = bool;
            return this;
        }

        public Builder needRouteInfo(Boolean bool) {
            this.needRouteInfo = bool;
            return this;
        }

        public Builder lastGroupId(Long l) {
            this.lastGroupId = l;
            return this;
        }

        public Builder callerId(String str) {
            this.callerId = str;
            return this;
        }

        public Builder lang(String str) {
            this.lang = str;
            return this;
        }

        public PassengerMultiRouteReq build() {
            checkRequiredFields();
            return new PassengerMultiRouteReq(this);
        }
    }
}
