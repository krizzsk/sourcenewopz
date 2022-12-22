package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class PositionProperty extends Message {
    public static final Integer DEFAULT_DIRECTION = 0;
    public static final String DEFAULT_SOURCE = "";
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer direction;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1)
    public final DoublePoint position;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.STRING)
    public final String source;

    public PositionProperty(DoublePoint doublePoint, Integer num, String str) {
        this.position = doublePoint;
        this.direction = num;
        this.source = str;
    }

    private PositionProperty(Builder builder) {
        this(builder.position, builder.direction, builder.source);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PositionProperty)) {
            return false;
        }
        PositionProperty positionProperty = (PositionProperty) obj;
        if (!equals((Object) this.position, (Object) positionProperty.position) || !equals((Object) this.direction, (Object) positionProperty.direction) || !equals((Object) this.source, (Object) positionProperty.source)) {
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
        Integer num = this.direction;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        String str = this.source;
        if (str != null) {
            i2 = str.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<PositionProperty> {
        public Integer direction;
        public DoublePoint position;
        public String source;

        public Builder() {
        }

        public Builder(PositionProperty positionProperty) {
            super(positionProperty);
            if (positionProperty != null) {
                this.position = positionProperty.position;
                this.direction = positionProperty.direction;
                this.source = positionProperty.source;
            }
        }

        public Builder position(DoublePoint doublePoint) {
            this.position = doublePoint;
            return this;
        }

        public Builder direction(Integer num) {
            this.direction = num;
            return this;
        }

        public Builder source(String str) {
            this.source = str;
            return this;
        }

        public PositionProperty build() {
            checkRequiredFields();
            return new PositionProperty(this);
        }
    }
}
