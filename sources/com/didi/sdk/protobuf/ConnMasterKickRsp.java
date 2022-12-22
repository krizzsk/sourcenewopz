package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ConnMasterKickRsp extends Message {
    public static final Integer DEFAULT_RC = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.INT32)

    /* renamed from: rc */
    public final Integer f36942rc;

    public ConnMasterKickRsp(Integer num) {
        this.f36942rc = num;
    }

    private ConnMasterKickRsp(Builder builder) {
        this(builder.f36943rc);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConnMasterKickRsp)) {
            return false;
        }
        return equals((Object) this.f36942rc, (Object) ((ConnMasterKickRsp) obj).f36942rc);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            Integer num = this.f36942rc;
            i = num != null ? num.hashCode() : 0;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<ConnMasterKickRsp> {

        /* renamed from: rc */
        public Integer f36943rc;

        public Builder() {
        }

        public Builder(ConnMasterKickRsp connMasterKickRsp) {
            super(connMasterKickRsp);
            if (connMasterKickRsp != null) {
                this.f36943rc = connMasterKickRsp.f36942rc;
            }
        }

        /* renamed from: rc */
        public Builder mo94295rc(Integer num) {
            this.f36943rc = num;
            return this;
        }

        public ConnMasterKickRsp build() {
            checkRequiredFields();
            return new ConnMasterKickRsp(this);
        }
    }
}
