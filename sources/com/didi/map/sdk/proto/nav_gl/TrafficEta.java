package com.didi.map.sdk.proto.nav_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class TrafficEta extends Message {
    public static final Integer DEFAULT_TIME = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1)
    public final MapRoutePoint beginPos;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2)
    public final MapRoutePoint endPos;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.UINT32)
    public final Integer time;

    public TrafficEta(MapRoutePoint mapRoutePoint, MapRoutePoint mapRoutePoint2, Integer num) {
        this.beginPos = mapRoutePoint;
        this.endPos = mapRoutePoint2;
        this.time = num;
    }

    private TrafficEta(Builder builder) {
        this(builder.beginPos, builder.endPos, builder.time);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TrafficEta)) {
            return false;
        }
        TrafficEta trafficEta = (TrafficEta) obj;
        if (!equals((Object) this.beginPos, (Object) trafficEta.beginPos) || !equals((Object) this.endPos, (Object) trafficEta.endPos) || !equals((Object) this.time, (Object) trafficEta.time)) {
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
        Integer num = this.time;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<TrafficEta> {
        public MapRoutePoint beginPos;
        public MapRoutePoint endPos;
        public Integer time;

        public Builder() {
        }

        public Builder(TrafficEta trafficEta) {
            super(trafficEta);
            if (trafficEta != null) {
                this.beginPos = trafficEta.beginPos;
                this.endPos = trafficEta.endPos;
                this.time = trafficEta.time;
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

        public Builder time(Integer num) {
            this.time = num;
            return this;
        }

        public TrafficEta build() {
            checkRequiredFields();
            return new TrafficEta(this);
        }
    }
}
