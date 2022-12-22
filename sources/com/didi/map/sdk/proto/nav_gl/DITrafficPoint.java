package com.didi.map.sdk.proto.nav_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class DITrafficPoint extends Message {
    public static final String DEFAULT_MSG = "";
    public static final TrafficPointKindEnum DEFAULT_TYPE = TrafficPointKindEnum.TPK_Slow;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.STRING)
    public final String msg;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1)
    public final MapRoutePoint targetPos;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.ENUM)
    public final TrafficPointKindEnum type;

    public DITrafficPoint(MapRoutePoint mapRoutePoint, TrafficPointKindEnum trafficPointKindEnum, String str) {
        this.targetPos = mapRoutePoint;
        this.type = trafficPointKindEnum;
        this.msg = str;
    }

    private DITrafficPoint(Builder builder) {
        this(builder.targetPos, builder.type, builder.msg);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DITrafficPoint)) {
            return false;
        }
        DITrafficPoint dITrafficPoint = (DITrafficPoint) obj;
        if (!equals((Object) this.targetPos, (Object) dITrafficPoint.targetPos) || !equals((Object) this.type, (Object) dITrafficPoint.type) || !equals((Object) this.msg, (Object) dITrafficPoint.msg)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        MapRoutePoint mapRoutePoint = this.targetPos;
        int i2 = 0;
        int hashCode = (mapRoutePoint != null ? mapRoutePoint.hashCode() : 0) * 37;
        TrafficPointKindEnum trafficPointKindEnum = this.type;
        int hashCode2 = (hashCode + (trafficPointKindEnum != null ? trafficPointKindEnum.hashCode() : 0)) * 37;
        String str = this.msg;
        if (str != null) {
            i2 = str.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<DITrafficPoint> {
        public String msg;
        public MapRoutePoint targetPos;
        public TrafficPointKindEnum type;

        public Builder() {
        }

        public Builder(DITrafficPoint dITrafficPoint) {
            super(dITrafficPoint);
            if (dITrafficPoint != null) {
                this.targetPos = dITrafficPoint.targetPos;
                this.type = dITrafficPoint.type;
                this.msg = dITrafficPoint.msg;
            }
        }

        public Builder targetPos(MapRoutePoint mapRoutePoint) {
            this.targetPos = mapRoutePoint;
            return this;
        }

        public Builder type(TrafficPointKindEnum trafficPointKindEnum) {
            this.type = trafficPointKindEnum;
            return this;
        }

        public Builder msg(String str) {
            this.msg = str;
            return this;
        }

        public DITrafficPoint build() {
            checkRequiredFields();
            return new DITrafficPoint(this);
        }
    }
}
