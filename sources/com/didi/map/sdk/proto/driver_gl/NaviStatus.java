package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class NaviStatus extends Message {
    public static final Double DEFAULT_ACCURACY;
    public static final Double DEFAULT_ANGLE;
    public static final Integer DEFAULT_COORSTART = 0;
    public static final Double DEFAULT_SPEED;
    @ProtoField(tag = 5, type = Message.Datatype.DOUBLE)
    public final Double accuracy;
    @ProtoField(tag = 4, type = Message.Datatype.DOUBLE)
    public final Double angle;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer coorStart;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1)
    public final DoublePoint position;
    @ProtoField(tag = 3, type = Message.Datatype.DOUBLE)
    public final Double speed;

    static {
        Double valueOf = Double.valueOf(0.0d);
        DEFAULT_SPEED = valueOf;
        DEFAULT_ANGLE = valueOf;
        DEFAULT_ACCURACY = valueOf;
    }

    public NaviStatus(DoublePoint doublePoint, Integer num, Double d, Double d2, Double d3) {
        this.position = doublePoint;
        this.coorStart = num;
        this.speed = d;
        this.angle = d2;
        this.accuracy = d3;
    }

    private NaviStatus(Builder builder) {
        this(builder.position, builder.coorStart, builder.speed, builder.angle, builder.accuracy);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof NaviStatus)) {
            return false;
        }
        NaviStatus naviStatus = (NaviStatus) obj;
        if (!equals((Object) this.position, (Object) naviStatus.position) || !equals((Object) this.coorStart, (Object) naviStatus.coorStart) || !equals((Object) this.speed, (Object) naviStatus.speed) || !equals((Object) this.angle, (Object) naviStatus.angle) || !equals((Object) this.accuracy, (Object) naviStatus.accuracy)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        DoublePoint doublePoint = this.position;
        int i2 = 0;
        int hashCode = (doublePoint != null ? doublePoint.hashCode() : 0) * 37;
        Integer num = this.coorStart;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Double d = this.speed;
        int hashCode3 = (hashCode2 + (d != null ? d.hashCode() : 0)) * 37;
        Double d2 = this.angle;
        int hashCode4 = (hashCode3 + (d2 != null ? d2.hashCode() : 0)) * 37;
        Double d3 = this.accuracy;
        if (d3 != null) {
            i2 = d3.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<NaviStatus> {
        public Double accuracy;
        public Double angle;
        public Integer coorStart;
        public DoublePoint position;
        public Double speed;

        public Builder() {
        }

        public Builder(NaviStatus naviStatus) {
            super(naviStatus);
            if (naviStatus != null) {
                this.position = naviStatus.position;
                this.coorStart = naviStatus.coorStart;
                this.speed = naviStatus.speed;
                this.angle = naviStatus.angle;
                this.accuracy = naviStatus.accuracy;
            }
        }

        public Builder position(DoublePoint doublePoint) {
            this.position = doublePoint;
            return this;
        }

        public Builder coorStart(Integer num) {
            this.coorStart = num;
            return this;
        }

        public Builder speed(Double d) {
            this.speed = d;
            return this;
        }

        public Builder angle(Double d) {
            this.angle = d;
            return this;
        }

        public Builder accuracy(Double d) {
            this.accuracy = d;
            return this;
        }

        public NaviStatus build() {
            checkRequiredFields();
            return new NaviStatus(this);
        }
    }
}
