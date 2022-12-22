package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class DriverLoc extends Message {
    public static final Integer DEFAULT_DIRECTION = 0;
    public static final Long DEFAULT_GPSTIMESTAMP = 0L;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer direction;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long gpsTimestamp;
    @ProtoField(tag = 1)
    public final DoublePoint point;

    public DriverLoc(DoublePoint doublePoint, Integer num, Long l) {
        this.point = doublePoint;
        this.direction = num;
        this.gpsTimestamp = l;
    }

    private DriverLoc(Builder builder) {
        this(builder.point, builder.direction, builder.gpsTimestamp);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DriverLoc)) {
            return false;
        }
        DriverLoc driverLoc = (DriverLoc) obj;
        if (!equals((Object) this.point, (Object) driverLoc.point) || !equals((Object) this.direction, (Object) driverLoc.direction) || !equals((Object) this.gpsTimestamp, (Object) driverLoc.gpsTimestamp)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        DoublePoint doublePoint = this.point;
        int i2 = 0;
        int hashCode = (doublePoint != null ? doublePoint.hashCode() : 0) * 37;
        Integer num = this.direction;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Long l = this.gpsTimestamp;
        if (l != null) {
            i2 = l.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<DriverLoc> {
        public Integer direction;
        public Long gpsTimestamp;
        public DoublePoint point;

        public Builder() {
        }

        public Builder(DriverLoc driverLoc) {
            super(driverLoc);
            if (driverLoc != null) {
                this.point = driverLoc.point;
                this.direction = driverLoc.direction;
                this.gpsTimestamp = driverLoc.gpsTimestamp;
            }
        }

        public Builder point(DoublePoint doublePoint) {
            this.point = doublePoint;
            return this;
        }

        public Builder direction(Integer num) {
            this.direction = num;
            return this;
        }

        public Builder gpsTimestamp(Long l) {
            this.gpsTimestamp = l;
            return this;
        }

        public DriverLoc build() {
            return new DriverLoc(this);
        }
    }
}
