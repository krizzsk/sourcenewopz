package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class Coordinate extends Message {
    public static final Integer DEFAULT_ANGLE = 0;
    public static final Double DEFAULT_DX;
    public static final Double DEFAULT_DY;
    public static final Integer DEFAULT_TIMESTAMP = 0;
    public static final CoordinateType DEFAULT_TYPE = CoordinateType.BD_09;
    public static final Double DEFAULT_X;
    public static final Double DEFAULT_Y;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer angle;
    @ProtoField(tag = 5, type = Message.Datatype.DOUBLE)

    /* renamed from: dx */
    public final Double f36944dx;
    @ProtoField(tag = 6, type = Message.Datatype.DOUBLE)

    /* renamed from: dy */
    public final Double f36945dy;
    @ProtoField(tag = 4, type = Message.Datatype.UINT32)
    public final Integer timestamp;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.ENUM)
    public final CoordinateType type;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.DOUBLE)

    /* renamed from: x */
    public final Double f36946x;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.DOUBLE)

    /* renamed from: y */
    public final Double f36947y;

    static {
        Double valueOf = Double.valueOf(0.0d);
        DEFAULT_X = valueOf;
        DEFAULT_Y = valueOf;
        DEFAULT_DX = valueOf;
        DEFAULT_DY = valueOf;
    }

    public Coordinate(Double d, Double d2, CoordinateType coordinateType, Integer num, Double d3, Double d4, Integer num2) {
        this.f36946x = d;
        this.f36947y = d2;
        this.type = coordinateType;
        this.timestamp = num;
        this.f36944dx = d3;
        this.f36945dy = d4;
        this.angle = num2;
    }

    private Coordinate(Builder builder) {
        this(builder.f36950x, builder.f36951y, builder.type, builder.timestamp, builder.f36948dx, builder.f36949dy, builder.angle);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Coordinate)) {
            return false;
        }
        Coordinate coordinate = (Coordinate) obj;
        if (!equals((Object) this.f36946x, (Object) coordinate.f36946x) || !equals((Object) this.f36947y, (Object) coordinate.f36947y) || !equals((Object) this.type, (Object) coordinate.type) || !equals((Object) this.timestamp, (Object) coordinate.timestamp) || !equals((Object) this.f36944dx, (Object) coordinate.f36944dx) || !equals((Object) this.f36945dy, (Object) coordinate.f36945dy) || !equals((Object) this.angle, (Object) coordinate.angle)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Double d = this.f36946x;
        int i2 = 0;
        int hashCode = (d != null ? d.hashCode() : 0) * 37;
        Double d2 = this.f36947y;
        int hashCode2 = (hashCode + (d2 != null ? d2.hashCode() : 0)) * 37;
        CoordinateType coordinateType = this.type;
        int hashCode3 = (hashCode2 + (coordinateType != null ? coordinateType.hashCode() : 0)) * 37;
        Integer num = this.timestamp;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 37;
        Double d3 = this.f36944dx;
        int hashCode5 = (hashCode4 + (d3 != null ? d3.hashCode() : 0)) * 37;
        Double d4 = this.f36945dy;
        int hashCode6 = (hashCode5 + (d4 != null ? d4.hashCode() : 0)) * 37;
        Integer num2 = this.angle;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode6 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<Coordinate> {
        public Integer angle;

        /* renamed from: dx */
        public Double f36948dx;

        /* renamed from: dy */
        public Double f36949dy;
        public Integer timestamp;
        public CoordinateType type;

        /* renamed from: x */
        public Double f36950x;

        /* renamed from: y */
        public Double f36951y;

        public Builder() {
        }

        public Builder(Coordinate coordinate) {
            super(coordinate);
            if (coordinate != null) {
                this.f36950x = coordinate.f36946x;
                this.f36951y = coordinate.f36947y;
                this.type = coordinate.type;
                this.timestamp = coordinate.timestamp;
                this.f36948dx = coordinate.f36944dx;
                this.f36949dy = coordinate.f36945dy;
                this.angle = coordinate.angle;
            }
        }

        /* renamed from: x */
        public Builder mo94353x(Double d) {
            this.f36950x = d;
            return this;
        }

        /* renamed from: y */
        public Builder mo94354y(Double d) {
            this.f36951y = d;
            return this;
        }

        public Builder type(CoordinateType coordinateType) {
            this.type = coordinateType;
            return this;
        }

        public Builder timestamp(Integer num) {
            this.timestamp = num;
            return this;
        }

        /* renamed from: dx */
        public Builder mo94349dx(Double d) {
            this.f36948dx = d;
            return this;
        }

        /* renamed from: dy */
        public Builder mo94350dy(Double d) {
            this.f36949dy = d;
            return this;
        }

        public Builder angle(Integer num) {
            this.angle = num;
            return this;
        }

        public Coordinate build() {
            checkRequiredFields();
            return new Coordinate(this);
        }
    }
}
