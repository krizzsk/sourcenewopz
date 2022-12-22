package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class OptionalRouteReq extends Message {
    public static final Long DEFAULT_ROUTEID = 0L;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.INT64)
    public final Long routeId;
    @ProtoField(tag = 2)
    public final NaviStatus status;

    public OptionalRouteReq(Long l, NaviStatus naviStatus) {
        this.routeId = l;
        this.status = naviStatus;
    }

    private OptionalRouteReq(Builder builder) {
        this(builder.routeId, builder.status);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OptionalRouteReq)) {
            return false;
        }
        OptionalRouteReq optionalRouteReq = (OptionalRouteReq) obj;
        if (!equals((Object) this.routeId, (Object) optionalRouteReq.routeId) || !equals((Object) this.status, (Object) optionalRouteReq.status)) {
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
        NaviStatus naviStatus = this.status;
        if (naviStatus != null) {
            i2 = naviStatus.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<OptionalRouteReq> {
        public Long routeId;
        public NaviStatus status;

        public Builder() {
        }

        public Builder(OptionalRouteReq optionalRouteReq) {
            super(optionalRouteReq);
            if (optionalRouteReq != null) {
                this.routeId = optionalRouteReq.routeId;
                this.status = optionalRouteReq.status;
            }
        }

        public Builder routeId(Long l) {
            this.routeId = l;
            return this;
        }

        public Builder status(NaviStatus naviStatus) {
            this.status = naviStatus;
            return this;
        }

        public OptionalRouteReq build() {
            checkRequiredFields();
            return new OptionalRouteReq(this);
        }
    }
}
