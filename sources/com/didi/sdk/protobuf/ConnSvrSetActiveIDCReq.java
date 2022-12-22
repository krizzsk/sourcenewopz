package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ConnSvrSetActiveIDCReq extends Message {
    public static final Boolean DEFAULT_ACTIVE = false;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.BOOL)
    public final Boolean active;

    public ConnSvrSetActiveIDCReq(Boolean bool) {
        this.active = bool;
    }

    private ConnSvrSetActiveIDCReq(Builder builder) {
        this(builder.active);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConnSvrSetActiveIDCReq)) {
            return false;
        }
        return equals((Object) this.active, (Object) ((ConnSvrSetActiveIDCReq) obj).active);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            Boolean bool = this.active;
            i = bool != null ? bool.hashCode() : 0;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<ConnSvrSetActiveIDCReq> {
        public Boolean active;

        public Builder() {
        }

        public Builder(ConnSvrSetActiveIDCReq connSvrSetActiveIDCReq) {
            super(connSvrSetActiveIDCReq);
            if (connSvrSetActiveIDCReq != null) {
                this.active = connSvrSetActiveIDCReq.active;
            }
        }

        public Builder active(Boolean bool) {
            this.active = bool;
            return this;
        }

        public ConnSvrSetActiveIDCReq build() {
            checkRequiredFields();
            return new ConnSvrSetActiveIDCReq(this);
        }
    }
}
