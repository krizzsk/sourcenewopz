package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class DriverBeyondPickupFunc extends Message {
    public static final Boolean DEFAULT_BEYONDPICKUP = false;
    public static final Integer DEFAULT_PARKING = 0;
    public static final Integer DEFAULT_PICKUPTYPE = 0;
    @ProtoField(tag = 1, type = Message.Datatype.BOOL)
    public final Boolean BeyondPickup;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer Parking;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer PickupType;

    public DriverBeyondPickupFunc(Boolean bool, Integer num, Integer num2) {
        this.BeyondPickup = bool;
        this.Parking = num;
        this.PickupType = num2;
    }

    private DriverBeyondPickupFunc(Builder builder) {
        this(builder.BeyondPickup, builder.Parking, builder.PickupType);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DriverBeyondPickupFunc)) {
            return false;
        }
        DriverBeyondPickupFunc driverBeyondPickupFunc = (DriverBeyondPickupFunc) obj;
        if (!equals((Object) this.BeyondPickup, (Object) driverBeyondPickupFunc.BeyondPickup) || !equals((Object) this.Parking, (Object) driverBeyondPickupFunc.Parking) || !equals((Object) this.PickupType, (Object) driverBeyondPickupFunc.PickupType)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Boolean bool = this.BeyondPickup;
        int i2 = 0;
        int hashCode = (bool != null ? bool.hashCode() : 0) * 37;
        Integer num = this.Parking;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.PickupType;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<DriverBeyondPickupFunc> {
        public Boolean BeyondPickup;
        public Integer Parking;
        public Integer PickupType;

        public Builder() {
        }

        public Builder(DriverBeyondPickupFunc driverBeyondPickupFunc) {
            super(driverBeyondPickupFunc);
            if (driverBeyondPickupFunc != null) {
                this.BeyondPickup = driverBeyondPickupFunc.BeyondPickup;
                this.Parking = driverBeyondPickupFunc.Parking;
                this.PickupType = driverBeyondPickupFunc.PickupType;
            }
        }

        public Builder BeyondPickup(Boolean bool) {
            this.BeyondPickup = bool;
            return this;
        }

        public Builder Parking(Integer num) {
            this.Parking = num;
            return this;
        }

        public Builder PickupType(Integer num) {
            this.PickupType = num;
            return this;
        }

        public DriverBeyondPickupFunc build() {
            return new DriverBeyondPickupFunc(this);
        }
    }
}
