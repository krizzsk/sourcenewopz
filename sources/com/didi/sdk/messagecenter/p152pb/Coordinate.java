package com.didi.sdk.messagecenter.p152pb;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

/* renamed from: com.didi.sdk.messagecenter.pb.Coordinate */
public final class Coordinate extends Message {
    public static final Integer DEFAULT_ANGLE = 0;
    public static final Double DEFAULT_DX;
    public static final Double DEFAULT_DY;
    public static final Integer DEFAULT_TIMESTAMP = 0;
    public static final CoordinateType DEFAULT_TYPE = CoordinateType.BD_09;
    public static final Double DEFAULT_X;
    public static final Double DEFAULT_Y;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer angle;
    @ProtoField(tag = 5, type = Message.Datatype.DOUBLE)

    /* renamed from: dx */
    public final Double f36778dx;
    @ProtoField(tag = 6, type = Message.Datatype.DOUBLE)

    /* renamed from: dy */
    public final Double f36779dy;
    @ProtoField(tag = 4, type = Message.Datatype.UINT32)
    public final Integer timestamp;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.ENUM)
    public final CoordinateType type;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.DOUBLE)

    /* renamed from: x */
    public final Double f36780x;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.DOUBLE)

    /* renamed from: y */
    public final Double f36781y;

    static {
        Double valueOf = Double.valueOf(0.0d);
        DEFAULT_X = valueOf;
        DEFAULT_Y = valueOf;
        DEFAULT_DX = valueOf;
        DEFAULT_DY = valueOf;
    }

    public Coordinate(Double d, Double d2, CoordinateType coordinateType, Integer num, Double d3, Double d4, Integer num2) {
        this.f36780x = d;
        this.f36781y = d2;
        this.type = coordinateType;
        this.timestamp = num;
        this.f36778dx = d3;
        this.f36779dy = d4;
        this.angle = num2;
    }

    private Coordinate(Builder builder) {
        this(builder.f36784x, builder.f36785y, builder.type, builder.timestamp, builder.f36782dx, builder.f36783dy, builder.angle);
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
        if (!equals((Object) this.f36780x, (Object) coordinate.f36780x) || !equals((Object) this.f36781y, (Object) coordinate.f36781y) || !equals((Object) this.type, (Object) coordinate.type) || !equals((Object) this.timestamp, (Object) coordinate.timestamp) || !equals((Object) this.f36778dx, (Object) coordinate.f36778dx) || !equals((Object) this.f36779dy, (Object) coordinate.f36779dy) || !equals((Object) this.angle, (Object) coordinate.angle)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Double d = this.f36780x;
        int i2 = 0;
        int hashCode = (d != null ? d.hashCode() : 0) * 37;
        Double d2 = this.f36781y;
        int hashCode2 = (hashCode + (d2 != null ? d2.hashCode() : 0)) * 37;
        CoordinateType coordinateType = this.type;
        int hashCode3 = (hashCode2 + (coordinateType != null ? coordinateType.hashCode() : 0)) * 37;
        Integer num = this.timestamp;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 37;
        Double d3 = this.f36778dx;
        int hashCode5 = (hashCode4 + (d3 != null ? d3.hashCode() : 0)) * 37;
        Double d4 = this.f36779dy;
        int hashCode6 = (hashCode5 + (d4 != null ? d4.hashCode() : 0)) * 37;
        Integer num2 = this.angle;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode6 + i2;
        this.hashCode = i3;
        return i3;
    }

    /* renamed from: com.didi.sdk.messagecenter.pb.Coordinate$Builder */
    public static final class Builder extends Message.Builder<Coordinate> {
        public Integer angle;

        /* renamed from: dx */
        public Double f36782dx;

        /* renamed from: dy */
        public Double f36783dy;
        public Integer timestamp;
        public CoordinateType type;

        /* renamed from: x */
        public Double f36784x;

        /* renamed from: y */
        public Double f36785y;

        public Builder() {
        }

        public Builder(Coordinate coordinate) {
            super(coordinate);
            if (coordinate != null) {
                this.f36784x = coordinate.f36780x;
                this.f36785y = coordinate.f36781y;
                this.type = coordinate.type;
                this.timestamp = coordinate.timestamp;
                this.f36782dx = coordinate.f36778dx;
                this.f36783dy = coordinate.f36779dy;
                this.angle = coordinate.angle;
            }
        }

        /* renamed from: x */
        public Builder mo92990x(Double d) {
            this.f36784x = d;
            return this;
        }

        /* renamed from: y */
        public Builder mo92991y(Double d) {
            this.f36785y = d;
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
        public Builder mo92986dx(Double d) {
            this.f36782dx = d;
            return this;
        }

        /* renamed from: dy */
        public Builder mo92987dy(Double d) {
            this.f36783dy = d;
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
