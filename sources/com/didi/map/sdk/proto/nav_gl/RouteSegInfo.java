package com.didi.map.sdk.proto.nav_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class RouteSegInfo extends Message {
    public static final Integer DEFAULT_ETASEC = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.UINT32)
    public final Integer etaSec;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1)
    public final MapRoutePoint pos;

    public RouteSegInfo(MapRoutePoint mapRoutePoint, Integer num) {
        this.pos = mapRoutePoint;
        this.etaSec = num;
    }

    private RouteSegInfo(Builder builder) {
        this(builder.pos, builder.etaSec);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RouteSegInfo)) {
            return false;
        }
        RouteSegInfo routeSegInfo = (RouteSegInfo) obj;
        if (!equals((Object) this.pos, (Object) routeSegInfo.pos) || !equals((Object) this.etaSec, (Object) routeSegInfo.etaSec)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        MapRoutePoint mapRoutePoint = this.pos;
        int i2 = 0;
        int hashCode = (mapRoutePoint != null ? mapRoutePoint.hashCode() : 0) * 37;
        Integer num = this.etaSec;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<RouteSegInfo> {
        public Integer etaSec;
        public MapRoutePoint pos;

        public Builder() {
        }

        public Builder(RouteSegInfo routeSegInfo) {
            super(routeSegInfo);
            if (routeSegInfo != null) {
                this.pos = routeSegInfo.pos;
                this.etaSec = routeSegInfo.etaSec;
            }
        }

        public Builder pos(MapRoutePoint mapRoutePoint) {
            this.pos = mapRoutePoint;
            return this;
        }

        public Builder etaSec(Integer num) {
            this.etaSec = num;
            return this;
        }

        public RouteSegInfo build() {
            checkRequiredFields();
            return new RouteSegInfo(this);
        }
    }
}
