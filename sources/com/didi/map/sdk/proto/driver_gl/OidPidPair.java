package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class OidPidPair extends Message {
    public static final String DEFAULT_ORDERID = "";
    public static final String DEFAULT_PASSENGERID = "";
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.STRING)
    public final String orderId;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.STRING)
    public final String passengerId;

    public OidPidPair(String str, String str2) {
        this.orderId = str;
        this.passengerId = str2;
    }

    private OidPidPair(Builder builder) {
        this(builder.orderId, builder.passengerId);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OidPidPair)) {
            return false;
        }
        OidPidPair oidPidPair = (OidPidPair) obj;
        if (!equals((Object) this.orderId, (Object) oidPidPair.orderId) || !equals((Object) this.passengerId, (Object) oidPidPair.passengerId)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.orderId;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        String str2 = this.passengerId;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<OidPidPair> {
        public String orderId;
        public String passengerId;

        public Builder() {
        }

        public Builder(OidPidPair oidPidPair) {
            super(oidPidPair);
            if (oidPidPair != null) {
                this.orderId = oidPidPair.orderId;
                this.passengerId = oidPidPair.passengerId;
            }
        }

        public Builder orderId(String str) {
            this.orderId = str;
            return this;
        }

        public Builder passengerId(String str) {
            this.passengerId = str;
            return this;
        }

        public OidPidPair build() {
            checkRequiredFields();
            return new OidPidPair(this);
        }
    }
}
