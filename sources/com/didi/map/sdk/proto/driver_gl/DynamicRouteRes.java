package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class DynamicRouteRes extends Message {
    public static final Integer DEFAULT_STRATEGYID = 0;
    public static final Integer DEFAULT_VALIDTIME = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer strategyId;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer validTime;

    public DynamicRouteRes(Integer num, Integer num2) {
        this.strategyId = num;
        this.validTime = num2;
    }

    private DynamicRouteRes(Builder builder) {
        this(builder.strategyId, builder.validTime);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DynamicRouteRes)) {
            return false;
        }
        DynamicRouteRes dynamicRouteRes = (DynamicRouteRes) obj;
        if (!equals((Object) this.strategyId, (Object) dynamicRouteRes.strategyId) || !equals((Object) this.validTime, (Object) dynamicRouteRes.validTime)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.strategyId;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.validTime;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<DynamicRouteRes> {
        public Integer strategyId;
        public Integer validTime;

        public Builder() {
        }

        public Builder(DynamicRouteRes dynamicRouteRes) {
            super(dynamicRouteRes);
            if (dynamicRouteRes != null) {
                this.strategyId = dynamicRouteRes.strategyId;
                this.validTime = dynamicRouteRes.validTime;
            }
        }

        public Builder strategyId(Integer num) {
            this.strategyId = num;
            return this;
        }

        public Builder validTime(Integer num) {
            this.validTime = num;
            return this;
        }

        public DynamicRouteRes build() {
            return new DynamicRouteRes(this);
        }
    }
}
