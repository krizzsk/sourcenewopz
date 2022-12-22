package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class PickupGuideFunc extends Message {
    public static final Integer DEFAULT_POSTOROUTE = 0;
    public static final Boolean DEFAULT_SHOWSTREETSCAPE = false;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer PosToRoute;
    @ProtoField(tag = 1, type = Message.Datatype.BOOL)
    public final Boolean ShowStreetScape;

    public PickupGuideFunc(Boolean bool, Integer num) {
        this.ShowStreetScape = bool;
        this.PosToRoute = num;
    }

    private PickupGuideFunc(Builder builder) {
        this(builder.ShowStreetScape, builder.PosToRoute);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PickupGuideFunc)) {
            return false;
        }
        PickupGuideFunc pickupGuideFunc = (PickupGuideFunc) obj;
        if (!equals((Object) this.ShowStreetScape, (Object) pickupGuideFunc.ShowStreetScape) || !equals((Object) this.PosToRoute, (Object) pickupGuideFunc.PosToRoute)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Boolean bool = this.ShowStreetScape;
        int i2 = 0;
        int hashCode = (bool != null ? bool.hashCode() : 0) * 37;
        Integer num = this.PosToRoute;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<PickupGuideFunc> {
        public Integer PosToRoute;
        public Boolean ShowStreetScape;

        public Builder() {
        }

        public Builder(PickupGuideFunc pickupGuideFunc) {
            super(pickupGuideFunc);
            if (pickupGuideFunc != null) {
                this.ShowStreetScape = pickupGuideFunc.ShowStreetScape;
                this.PosToRoute = pickupGuideFunc.PosToRoute;
            }
        }

        public Builder ShowStreetScape(Boolean bool) {
            this.ShowStreetScape = bool;
            return this;
        }

        public Builder PosToRoute(Integer num) {
            this.PosToRoute = num;
            return this;
        }

        public PickupGuideFunc build() {
            return new PickupGuideFunc(this);
        }
    }
}
