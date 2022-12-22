package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class Int32Point extends Message {
    public static final Integer DEFAULT_LAT = 0;
    public static final Integer DEFAULT_LNG = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.INT32)
    public final Integer lat;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer lng;

    public Int32Point(Integer num, Integer num2) {
        this.lat = num;
        this.lng = num2;
    }

    private Int32Point(Builder builder) {
        this(builder.lat, builder.lng);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Int32Point)) {
            return false;
        }
        Int32Point int32Point = (Int32Point) obj;
        if (!equals((Object) this.lat, (Object) int32Point.lat) || !equals((Object) this.lng, (Object) int32Point.lng)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.lat;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.lng;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<Int32Point> {
        public Integer lat;
        public Integer lng;

        public Builder() {
        }

        public Builder(Int32Point int32Point) {
            super(int32Point);
            if (int32Point != null) {
                this.lat = int32Point.lat;
                this.lng = int32Point.lng;
            }
        }

        public Builder lat(Integer num) {
            this.lat = num;
            return this;
        }

        public Builder lng(Integer num) {
            this.lng = num;
            return this;
        }

        public Int32Point build() {
            checkRequiredFields();
            return new Int32Point(this);
        }
    }
}
