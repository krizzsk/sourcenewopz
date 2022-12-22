package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ConnMasterGetOnlineCountReq extends Message {
    public static final Integer DEFAULT_ROLE = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer role;

    public ConnMasterGetOnlineCountReq(Integer num) {
        this.role = num;
    }

    private ConnMasterGetOnlineCountReq(Builder builder) {
        this(builder.role);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConnMasterGetOnlineCountReq)) {
            return false;
        }
        return equals((Object) this.role, (Object) ((ConnMasterGetOnlineCountReq) obj).role);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            Integer num = this.role;
            i = num != null ? num.hashCode() : 0;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<ConnMasterGetOnlineCountReq> {
        public Integer role;

        public Builder() {
        }

        public Builder(ConnMasterGetOnlineCountReq connMasterGetOnlineCountReq) {
            super(connMasterGetOnlineCountReq);
            if (connMasterGetOnlineCountReq != null) {
                this.role = connMasterGetOnlineCountReq.role;
            }
        }

        public Builder role(Integer num) {
            this.role = num;
            return this;
        }

        public ConnMasterGetOnlineCountReq build() {
            return new ConnMasterGetOnlineCountReq(this);
        }
    }
}
