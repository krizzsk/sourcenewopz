package com.didi.map.sdk.proto.nav_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class EventCheckTiming extends Message {
    @ProtoField(label = Message.Label.REQUIRED, tag = 1)
    public final MapRoutePoint beginPosOfRoute;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2)
    public final MapRoutePoint endPosOfRoute;

    public EventCheckTiming(MapRoutePoint mapRoutePoint, MapRoutePoint mapRoutePoint2) {
        this.beginPosOfRoute = mapRoutePoint;
        this.endPosOfRoute = mapRoutePoint2;
    }

    private EventCheckTiming(Builder builder) {
        this(builder.beginPosOfRoute, builder.endPosOfRoute);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EventCheckTiming)) {
            return false;
        }
        EventCheckTiming eventCheckTiming = (EventCheckTiming) obj;
        if (!equals((Object) this.beginPosOfRoute, (Object) eventCheckTiming.beginPosOfRoute) || !equals((Object) this.endPosOfRoute, (Object) eventCheckTiming.endPosOfRoute)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        MapRoutePoint mapRoutePoint = this.beginPosOfRoute;
        int i2 = 0;
        int hashCode = (mapRoutePoint != null ? mapRoutePoint.hashCode() : 0) * 37;
        MapRoutePoint mapRoutePoint2 = this.endPosOfRoute;
        if (mapRoutePoint2 != null) {
            i2 = mapRoutePoint2.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<EventCheckTiming> {
        public MapRoutePoint beginPosOfRoute;
        public MapRoutePoint endPosOfRoute;

        public Builder() {
        }

        public Builder(EventCheckTiming eventCheckTiming) {
            super(eventCheckTiming);
            if (eventCheckTiming != null) {
                this.beginPosOfRoute = eventCheckTiming.beginPosOfRoute;
                this.endPosOfRoute = eventCheckTiming.endPosOfRoute;
            }
        }

        public Builder beginPosOfRoute(MapRoutePoint mapRoutePoint) {
            this.beginPosOfRoute = mapRoutePoint;
            return this;
        }

        public Builder endPosOfRoute(MapRoutePoint mapRoutePoint) {
            this.endPosOfRoute = mapRoutePoint;
            return this;
        }

        public EventCheckTiming build() {
            checkRequiredFields();
            return new EventCheckTiming(this);
        }
    }
}
