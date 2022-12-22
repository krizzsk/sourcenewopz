package com.didi.map.sdk.proto.nav_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class RouteRoadName extends Message {
    public static final String DEFAULT_NAME = "";
    @ProtoField(label = Message.Label.REQUIRED, tag = 1)
    public final MapRoutePoint beginPos;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2)
    public final MapRoutePoint endPos;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.STRING)
    public final String name;

    public RouteRoadName(MapRoutePoint mapRoutePoint, MapRoutePoint mapRoutePoint2, String str) {
        this.beginPos = mapRoutePoint;
        this.endPos = mapRoutePoint2;
        this.name = str;
    }

    private RouteRoadName(Builder builder) {
        this(builder.beginPos, builder.endPos, builder.name);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RouteRoadName)) {
            return false;
        }
        RouteRoadName routeRoadName = (RouteRoadName) obj;
        if (!equals((Object) this.beginPos, (Object) routeRoadName.beginPos) || !equals((Object) this.endPos, (Object) routeRoadName.endPos) || !equals((Object) this.name, (Object) routeRoadName.name)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        MapRoutePoint mapRoutePoint = this.beginPos;
        int i2 = 0;
        int hashCode = (mapRoutePoint != null ? mapRoutePoint.hashCode() : 0) * 37;
        MapRoutePoint mapRoutePoint2 = this.endPos;
        int hashCode2 = (hashCode + (mapRoutePoint2 != null ? mapRoutePoint2.hashCode() : 0)) * 37;
        String str = this.name;
        if (str != null) {
            i2 = str.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<RouteRoadName> {
        public MapRoutePoint beginPos;
        public MapRoutePoint endPos;
        public String name;

        public Builder() {
        }

        public Builder(RouteRoadName routeRoadName) {
            super(routeRoadName);
            if (routeRoadName != null) {
                this.beginPos = routeRoadName.beginPos;
                this.endPos = routeRoadName.endPos;
                this.name = routeRoadName.name;
            }
        }

        public Builder beginPos(MapRoutePoint mapRoutePoint) {
            this.beginPos = mapRoutePoint;
            return this;
        }

        public Builder endPos(MapRoutePoint mapRoutePoint) {
            this.endPos = mapRoutePoint;
            return this;
        }

        public Builder name(String str) {
            this.name = str;
            return this;
        }

        public RouteRoadName build() {
            checkRequiredFields();
            return new RouteRoadName(this);
        }
    }
}
