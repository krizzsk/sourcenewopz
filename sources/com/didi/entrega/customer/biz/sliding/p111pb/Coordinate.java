package com.didi.entrega.customer.biz.sliding.p111pb;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

/* renamed from: com.didi.entrega.customer.biz.sliding.pb.Coordinate */
public final class Coordinate extends Message {
    public static final Integer DEFAULT_ANGLE = 0;
    public static final Integer DEFAULT_TIMESTAMP = 0;
    public static final Double DEFAULT_X;
    public static final Double DEFAULT_Y;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer angle;
    @ProtoField(tag = 5, type = Message.Datatype.DOUBLE)

    /* renamed from: dx */
    public final Double f19844dx;
    @ProtoField(tag = 6, type = Message.Datatype.DOUBLE)

    /* renamed from: dy */
    public final Double f19845dy;
    @ProtoField(tag = 4, type = Message.Datatype.UINT32)
    public final Integer timestamp;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.ENUM)
    public final CoordinateType type;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.DOUBLE)

    /* renamed from: x */
    public final Double f19846x;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.DOUBLE)

    /* renamed from: y */
    public final Double f19847y;

    static {
        Double valueOf = Double.valueOf(0.0d);
        DEFAULT_X = valueOf;
        DEFAULT_Y = valueOf;
    }

    public Coordinate(Double d, Double d2, CoordinateType coordinateType, Integer num, Double d3, Double d4, Integer num2) {
        this.f19846x = d;
        this.f19847y = d2;
        this.type = coordinateType;
        this.timestamp = num;
        this.f19844dx = d3;
        this.f19845dy = d4;
        this.angle = num2;
    }

    private Coordinate(Builder builder) {
        this(builder.f19850x, builder.f19851y, builder.type, builder.timestamp, builder.f19848dx, builder.f19849dy, builder.angle);
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
        if (!equals((Object) this.f19846x, (Object) coordinate.f19846x) || !equals((Object) this.f19847y, (Object) coordinate.f19847y) || !equals((Object) this.type, (Object) coordinate.type) || !equals((Object) this.timestamp, (Object) coordinate.timestamp) || !equals((Object) this.f19844dx, (Object) coordinate.f19844dx) || !equals((Object) this.f19845dy, (Object) coordinate.f19845dy) || !equals((Object) this.angle, (Object) coordinate.angle)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Double d = this.f19846x;
        int i2 = 0;
        int hashCode = (d != null ? d.hashCode() : 0) * 37;
        Double d2 = this.f19847y;
        int hashCode2 = (hashCode + (d2 != null ? d2.hashCode() : 0)) * 37;
        CoordinateType coordinateType = this.type;
        int hashCode3 = (hashCode2 + (coordinateType != null ? coordinateType.hashCode() : 0)) * 37;
        Integer num = this.timestamp;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 37;
        Double d3 = this.f19844dx;
        int hashCode5 = (hashCode4 + (d3 != null ? d3.hashCode() : 0)) * 37;
        Double d4 = this.f19845dy;
        int hashCode6 = (hashCode5 + (d4 != null ? d4.hashCode() : 0)) * 37;
        Integer num2 = this.angle;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode6 + i2;
        this.hashCode = i3;
        return i3;
    }

    /* renamed from: com.didi.entrega.customer.biz.sliding.pb.Coordinate$Builder */
    public static final class Builder extends Message.Builder<Coordinate> {
        public Integer angle;

        /* renamed from: dx */
        public Double f19848dx;

        /* renamed from: dy */
        public Double f19849dy;
        public Integer timestamp;
        public CoordinateType type;

        /* renamed from: x */
        public Double f19850x;

        /* renamed from: y */
        public Double f19851y;

        public Builder() {
        }

        public Builder(Coordinate coordinate) {
            super(coordinate);
            if (coordinate != null) {
                this.f19850x = coordinate.f19846x;
                this.f19851y = coordinate.f19847y;
                this.type = coordinate.type;
                this.timestamp = coordinate.timestamp;
                this.f19848dx = coordinate.f19844dx;
                this.f19849dy = coordinate.f19845dy;
                this.angle = coordinate.angle;
            }
        }

        public Builder angle(Integer num) {
            this.angle = num;
            return this;
        }

        public Coordinate build() {
            checkRequiredFields();
            return new Coordinate(this);
        }

        public Builder type(CoordinateType coordinateType) {
            this.type = coordinateType;
            return this;
        }

        /* renamed from: x */
        public Builder mo59766x(Double d) {
            this.f19850x = d;
            return this;
        }

        /* renamed from: y */
        public Builder mo59767y(Double d) {
            this.f19851y = d;
            return this;
        }
    }
}
