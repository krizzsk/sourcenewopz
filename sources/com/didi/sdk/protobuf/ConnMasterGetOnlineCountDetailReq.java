package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ConnMasterGetOnlineCountDetailReq extends Message {
    public static final Integer DEFAULT_ROLE = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer role;

    public ConnMasterGetOnlineCountDetailReq(Integer num) {
        this.role = num;
    }

    private ConnMasterGetOnlineCountDetailReq(Builder builder) {
        this(builder.role);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConnMasterGetOnlineCountDetailReq)) {
            return false;
        }
        return equals((Object) this.role, (Object) ((ConnMasterGetOnlineCountDetailReq) obj).role);
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

    public static final class Builder extends Message.Builder<ConnMasterGetOnlineCountDetailReq> {
        public Integer role;

        public Builder() {
        }

        public Builder(ConnMasterGetOnlineCountDetailReq connMasterGetOnlineCountDetailReq) {
            super(connMasterGetOnlineCountDetailReq);
            if (connMasterGetOnlineCountDetailReq != null) {
                this.role = connMasterGetOnlineCountDetailReq.role;
            }
        }

        public Builder role(Integer num) {
            this.role = num;
            return this;
        }

        public ConnMasterGetOnlineCountDetailReq build() {
            return new ConnMasterGetOnlineCountDetailReq(this);
        }
    }
}
