package com.didi.map.sdk.proto.nav_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class TrafficStatusLine extends Message {
    public static final Integer DEFAULT_COLOR = 0;
    public static final TrafficLineStatusEnum DEFAULT_STATUS = TrafficLineStatusEnum.TLS_Unknow;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1)
    public final MapRoutePoint beginPos;
    @ProtoField(label = Message.Label.REQUIRED, tag = 4, type = Message.Datatype.UINT32)
    public final Integer color;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2)
    public final MapRoutePoint endPos;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.ENUM)
    public final TrafficLineStatusEnum status;

    public TrafficStatusLine(MapRoutePoint mapRoutePoint, MapRoutePoint mapRoutePoint2, TrafficLineStatusEnum trafficLineStatusEnum, Integer num) {
        this.beginPos = mapRoutePoint;
        this.endPos = mapRoutePoint2;
        this.status = trafficLineStatusEnum;
        this.color = num;
    }

    private TrafficStatusLine(Builder builder) {
        this(builder.beginPos, builder.endPos, builder.status, builder.color);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TrafficStatusLine)) {
            return false;
        }
        TrafficStatusLine trafficStatusLine = (TrafficStatusLine) obj;
        if (!equals((Object) this.beginPos, (Object) trafficStatusLine.beginPos) || !equals((Object) this.endPos, (Object) trafficStatusLine.endPos) || !equals((Object) this.status, (Object) trafficStatusLine.status) || !equals((Object) this.color, (Object) trafficStatusLine.color)) {
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
        TrafficLineStatusEnum trafficLineStatusEnum = this.status;
        int hashCode3 = (hashCode2 + (trafficLineStatusEnum != null ? trafficLineStatusEnum.hashCode() : 0)) * 37;
        Integer num = this.color;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<TrafficStatusLine> {
        public MapRoutePoint beginPos;
        public Integer color;
        public MapRoutePoint endPos;
        public TrafficLineStatusEnum status;

        public Builder() {
        }

        public Builder(TrafficStatusLine trafficStatusLine) {
            super(trafficStatusLine);
            if (trafficStatusLine != null) {
                this.beginPos = trafficStatusLine.beginPos;
                this.endPos = trafficStatusLine.endPos;
                this.status = trafficStatusLine.status;
                this.color = trafficStatusLine.color;
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

        public Builder status(TrafficLineStatusEnum trafficLineStatusEnum) {
            this.status = trafficLineStatusEnum;
            return this;
        }

        public Builder color(Integer num) {
            this.color = num;
            return this;
        }

        public TrafficStatusLine build() {
            checkRequiredFields();
            return new TrafficStatusLine(this);
        }
    }
}
