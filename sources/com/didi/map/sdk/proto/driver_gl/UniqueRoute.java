package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class UniqueRoute extends Message {
    public static final Integer DEFAULT_ENDIDX = 0;
    public static final Integer DEFAULT_STARTIDX = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer endIdx;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer startIdx;

    public UniqueRoute(Integer num, Integer num2) {
        this.startIdx = num;
        this.endIdx = num2;
    }

    private UniqueRoute(Builder builder) {
        this(builder.startIdx, builder.endIdx);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UniqueRoute)) {
            return false;
        }
        UniqueRoute uniqueRoute = (UniqueRoute) obj;
        if (!equals((Object) this.startIdx, (Object) uniqueRoute.startIdx) || !equals((Object) this.endIdx, (Object) uniqueRoute.endIdx)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.startIdx;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.endIdx;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<UniqueRoute> {
        public Integer endIdx;
        public Integer startIdx;

        public Builder() {
        }

        public Builder(UniqueRoute uniqueRoute) {
            super(uniqueRoute);
            if (uniqueRoute != null) {
                this.startIdx = uniqueRoute.startIdx;
                this.endIdx = uniqueRoute.endIdx;
            }
        }

        public Builder startIdx(Integer num) {
            this.startIdx = num;
            return this;
        }

        public Builder endIdx(Integer num) {
            this.endIdx = num;
            return this;
        }

        public UniqueRoute build() {
            return new UniqueRoute(this);
        }
    }
}
