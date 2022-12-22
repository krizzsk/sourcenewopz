package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class PickupPointHint extends Message {
    public static final String DEFAULT_HINTMESSAGE = "";
    public static final String DEFAULT_PICURL = "";
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String hintMessage;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String picUrl;

    public PickupPointHint(String str, String str2) {
        this.hintMessage = str;
        this.picUrl = str2;
    }

    private PickupPointHint(Builder builder) {
        this(builder.hintMessage, builder.picUrl);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PickupPointHint)) {
            return false;
        }
        PickupPointHint pickupPointHint = (PickupPointHint) obj;
        if (!equals((Object) this.hintMessage, (Object) pickupPointHint.hintMessage) || !equals((Object) this.picUrl, (Object) pickupPointHint.picUrl)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.hintMessage;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        String str2 = this.picUrl;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<PickupPointHint> {
        public String hintMessage;
        public String picUrl;

        public Builder() {
        }

        public Builder(PickupPointHint pickupPointHint) {
            super(pickupPointHint);
            if (pickupPointHint != null) {
                this.hintMessage = pickupPointHint.hintMessage;
                this.picUrl = pickupPointHint.picUrl;
            }
        }

        public Builder hintMessage(String str) {
            this.hintMessage = str;
            return this;
        }

        public Builder picUrl(String str) {
            this.picUrl = str;
            return this;
        }

        public PickupPointHint build() {
            return new PickupPointHint(this);
        }
    }
}
