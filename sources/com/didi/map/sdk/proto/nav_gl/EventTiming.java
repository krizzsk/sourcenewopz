package com.didi.map.sdk.proto.nav_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class EventTiming extends Message {
    public static final EventTimingOrderEnum DEFAULT_ORDER = EventTimingOrderEnum.ETOrder_Null;
    public static final Integer DEFAULT_VALIDENDLENGTH = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1)
    public final MapRoutePoint beginPosOfRoute;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2)
    public final MapRoutePoint endPosOfRoute;
    @ProtoField(label = Message.Label.REQUIRED, tag = 4, type = Message.Datatype.ENUM)
    public final EventTimingOrderEnum order;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.UINT32)
    public final Integer validEndLength;

    public EventTiming(MapRoutePoint mapRoutePoint, MapRoutePoint mapRoutePoint2, Integer num, EventTimingOrderEnum eventTimingOrderEnum) {
        this.beginPosOfRoute = mapRoutePoint;
        this.endPosOfRoute = mapRoutePoint2;
        this.validEndLength = num;
        this.order = eventTimingOrderEnum;
    }

    private EventTiming(Builder builder) {
        this(builder.beginPosOfRoute, builder.endPosOfRoute, builder.validEndLength, builder.order);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EventTiming)) {
            return false;
        }
        EventTiming eventTiming = (EventTiming) obj;
        if (!equals((Object) this.beginPosOfRoute, (Object) eventTiming.beginPosOfRoute) || !equals((Object) this.endPosOfRoute, (Object) eventTiming.endPosOfRoute) || !equals((Object) this.validEndLength, (Object) eventTiming.validEndLength) || !equals((Object) this.order, (Object) eventTiming.order)) {
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
        int hashCode2 = (hashCode + (mapRoutePoint2 != null ? mapRoutePoint2.hashCode() : 0)) * 37;
        Integer num = this.validEndLength;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        EventTimingOrderEnum eventTimingOrderEnum = this.order;
        if (eventTimingOrderEnum != null) {
            i2 = eventTimingOrderEnum.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<EventTiming> {
        public MapRoutePoint beginPosOfRoute;
        public MapRoutePoint endPosOfRoute;
        public EventTimingOrderEnum order;
        public Integer validEndLength;

        public Builder() {
        }

        public Builder(EventTiming eventTiming) {
            super(eventTiming);
            if (eventTiming != null) {
                this.beginPosOfRoute = eventTiming.beginPosOfRoute;
                this.endPosOfRoute = eventTiming.endPosOfRoute;
                this.validEndLength = eventTiming.validEndLength;
                this.order = eventTiming.order;
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

        public Builder validEndLength(Integer num) {
            this.validEndLength = num;
            return this;
        }

        public Builder order(EventTimingOrderEnum eventTimingOrderEnum) {
            this.order = eventTimingOrderEnum;
            return this;
        }

        public EventTiming build() {
            checkRequiredFields();
            return new EventTiming(this);
        }
    }
}
