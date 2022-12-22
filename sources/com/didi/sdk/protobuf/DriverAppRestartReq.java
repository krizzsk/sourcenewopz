package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class DriverAppRestartReq extends Message {
    public static final Boolean DEFAULT_LOGOUT = false;
    public static final String DEFAULT_TIPMSG = "";
    @ProtoField(tag = 2, type = Message.Datatype.BOOL)
    public final Boolean logout;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String tipMsg;

    public DriverAppRestartReq(String str, Boolean bool) {
        this.tipMsg = str;
        this.logout = bool;
    }

    private DriverAppRestartReq(Builder builder) {
        this(builder.tipMsg, builder.logout);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DriverAppRestartReq)) {
            return false;
        }
        DriverAppRestartReq driverAppRestartReq = (DriverAppRestartReq) obj;
        if (!equals((Object) this.tipMsg, (Object) driverAppRestartReq.tipMsg) || !equals((Object) this.logout, (Object) driverAppRestartReq.logout)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.tipMsg;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        Boolean bool = this.logout;
        if (bool != null) {
            i2 = bool.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<DriverAppRestartReq> {
        public Boolean logout;
        public String tipMsg;

        public Builder() {
        }

        public Builder(DriverAppRestartReq driverAppRestartReq) {
            super(driverAppRestartReq);
            if (driverAppRestartReq != null) {
                this.tipMsg = driverAppRestartReq.tipMsg;
                this.logout = driverAppRestartReq.logout;
            }
        }

        public Builder tipMsg(String str) {
            this.tipMsg = str;
            return this;
        }

        public Builder logout(Boolean bool) {
            this.logout = bool;
            return this;
        }

        public DriverAppRestartReq build() {
            return new DriverAppRestartReq(this);
        }
    }
}
