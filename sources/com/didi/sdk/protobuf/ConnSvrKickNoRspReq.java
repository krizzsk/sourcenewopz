package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ConnSvrKickNoRspReq extends Message {
    public static final Long DEFAULT_TIMESTAMP = 0L;
    @ProtoField(tag = 1, type = Message.Datatype.UINT64)
    public final Long timestamp;

    public ConnSvrKickNoRspReq(Long l) {
        this.timestamp = l;
    }

    private ConnSvrKickNoRspReq(Builder builder) {
        this(builder.timestamp);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConnSvrKickNoRspReq)) {
            return false;
        }
        return equals((Object) this.timestamp, (Object) ((ConnSvrKickNoRspReq) obj).timestamp);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            Long l = this.timestamp;
            i = l != null ? l.hashCode() : 0;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<ConnSvrKickNoRspReq> {
        public Long timestamp;

        public Builder() {
        }

        public Builder(ConnSvrKickNoRspReq connSvrKickNoRspReq) {
            super(connSvrKickNoRspReq);
            if (connSvrKickNoRspReq != null) {
                this.timestamp = connSvrKickNoRspReq.timestamp;
            }
        }

        public Builder timestamp(Long l) {
            this.timestamp = l;
            return this;
        }

        public ConnSvrKickNoRspReq build() {
            return new ConnSvrKickNoRspReq(this);
        }
    }
}
