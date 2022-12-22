package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class NaviTrafficSegment extends Message {
    public static final Integer DEFAULT_IDX = 0;
    public static final Integer DEFAULT_SEGIDX = 0;
    public static final Integer DEFAULT_TIME_S = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.INT32)
    public final Integer idx;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer segidx;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.INT32)
    public final Integer time_s;

    public NaviTrafficSegment(Integer num, Integer num2, Integer num3) {
        this.idx = num;
        this.segidx = num2;
        this.time_s = num3;
    }

    private NaviTrafficSegment(Builder builder) {
        this(builder.idx, builder.segidx, builder.time_s);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof NaviTrafficSegment)) {
            return false;
        }
        NaviTrafficSegment naviTrafficSegment = (NaviTrafficSegment) obj;
        if (!equals((Object) this.idx, (Object) naviTrafficSegment.idx) || !equals((Object) this.segidx, (Object) naviTrafficSegment.segidx) || !equals((Object) this.time_s, (Object) naviTrafficSegment.time_s)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.idx;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.segidx;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.time_s;
        if (num3 != null) {
            i2 = num3.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<NaviTrafficSegment> {
        public Integer idx;
        public Integer segidx;
        public Integer time_s;

        public Builder() {
        }

        public Builder(NaviTrafficSegment naviTrafficSegment) {
            super(naviTrafficSegment);
            if (naviTrafficSegment != null) {
                this.idx = naviTrafficSegment.idx;
                this.segidx = naviTrafficSegment.segidx;
                this.time_s = naviTrafficSegment.time_s;
            }
        }

        public Builder idx(Integer num) {
            this.idx = num;
            return this;
        }

        public Builder segidx(Integer num) {
            this.segidx = num;
            return this;
        }

        public Builder time_s(Integer num) {
            this.time_s = num;
            return this;
        }

        public NaviTrafficSegment build() {
            checkRequiredFields();
            return new NaviTrafficSegment(this);
        }
    }
}
