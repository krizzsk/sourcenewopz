package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class DriverPos extends Message {
    public static final Integer DEFAULT_ARRIVED_TIME = 0;
    public static final Float DEFAULT_DISTANCE = Float.valueOf(0.0f);
    public static final Integer DEFAULT_DISTANCE_ENABLED = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer arrived_time;
    @ProtoField(tag = 3, type = Message.Datatype.FLOAT)
    public final Float distance;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer distance_enabled;
    @ProtoField(tag = 1)
    public final Coordinate pos;

    public DriverPos(Coordinate coordinate, Integer num, Float f, Integer num2) {
        this.pos = coordinate;
        this.arrived_time = num;
        this.distance = f;
        this.distance_enabled = num2;
    }

    private DriverPos(Builder builder) {
        this(builder.pos, builder.arrived_time, builder.distance, builder.distance_enabled);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DriverPos)) {
            return false;
        }
        DriverPos driverPos = (DriverPos) obj;
        if (!equals((Object) this.pos, (Object) driverPos.pos) || !equals((Object) this.arrived_time, (Object) driverPos.arrived_time) || !equals((Object) this.distance, (Object) driverPos.distance) || !equals((Object) this.distance_enabled, (Object) driverPos.distance_enabled)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Coordinate coordinate = this.pos;
        int i2 = 0;
        int hashCode = (coordinate != null ? coordinate.hashCode() : 0) * 37;
        Integer num = this.arrived_time;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Float f = this.distance;
        int hashCode3 = (hashCode2 + (f != null ? f.hashCode() : 0)) * 37;
        Integer num2 = this.distance_enabled;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<DriverPos> {
        public Integer arrived_time;
        public Float distance;
        public Integer distance_enabled;
        public Coordinate pos;

        public Builder() {
        }

        public Builder(DriverPos driverPos) {
            super(driverPos);
            if (driverPos != null) {
                this.pos = driverPos.pos;
                this.arrived_time = driverPos.arrived_time;
                this.distance = driverPos.distance;
                this.distance_enabled = driverPos.distance_enabled;
            }
        }

        public Builder pos(Coordinate coordinate) {
            this.pos = coordinate;
            return this;
        }

        public Builder arrived_time(Integer num) {
            this.arrived_time = num;
            return this;
        }

        public Builder distance(Float f) {
            this.distance = f;
            return this;
        }

        public Builder distance_enabled(Integer num) {
            this.distance_enabled = num;
            return this;
        }

        public DriverPos build() {
            return new DriverPos(this);
        }
    }
}
