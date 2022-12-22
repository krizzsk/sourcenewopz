package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class TrafficLighInfo extends Message {
    @ProtoField(tag = 1)
    public final DoublePoint point;

    public TrafficLighInfo(DoublePoint doublePoint) {
        this.point = doublePoint;
    }

    private TrafficLighInfo(Builder builder) {
        this(builder.point);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TrafficLighInfo)) {
            return false;
        }
        return equals((Object) this.point, (Object) ((TrafficLighInfo) obj).point);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            DoublePoint doublePoint = this.point;
            i = doublePoint != null ? doublePoint.hashCode() : 0;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<TrafficLighInfo> {
        public DoublePoint point;

        public Builder() {
        }

        public Builder(TrafficLighInfo trafficLighInfo) {
            super(trafficLighInfo);
            if (trafficLighInfo != null) {
                this.point = trafficLighInfo.point;
            }
        }

        public Builder point(DoublePoint doublePoint) {
            this.point = doublePoint;
            return this;
        }

        public TrafficLighInfo build() {
            return new TrafficLighInfo(this);
        }
    }
}
