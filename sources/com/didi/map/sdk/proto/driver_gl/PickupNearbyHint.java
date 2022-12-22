package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class PickupNearbyHint extends Message {
    public static final String DEFAULT_HINTMESSAGE = "";
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String hintMessage;

    public PickupNearbyHint(String str) {
        this.hintMessage = str;
    }

    private PickupNearbyHint(Builder builder) {
        this(builder.hintMessage);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PickupNearbyHint)) {
            return false;
        }
        return equals((Object) this.hintMessage, (Object) ((PickupNearbyHint) obj).hintMessage);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            String str = this.hintMessage;
            i = str != null ? str.hashCode() : 0;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<PickupNearbyHint> {
        public String hintMessage;

        public Builder() {
        }

        public Builder(PickupNearbyHint pickupNearbyHint) {
            super(pickupNearbyHint);
            if (pickupNearbyHint != null) {
                this.hintMessage = pickupNearbyHint.hintMessage;
            }
        }

        public Builder hintMessage(String str) {
            this.hintMessage = str;
            return this;
        }

        public PickupNearbyHint build() {
            return new PickupNearbyHint(this);
        }
    }
}
