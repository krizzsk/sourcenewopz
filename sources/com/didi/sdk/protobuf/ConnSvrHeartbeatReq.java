package com.didi.sdk.protobuf;

import com.squareup.wire.Message;

public final class ConnSvrHeartbeatReq extends Message {
    public int hashCode() {
        return 0;
    }

    public ConnSvrHeartbeatReq() {
    }

    private ConnSvrHeartbeatReq(Builder builder) {
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        return obj instanceof ConnSvrHeartbeatReq;
    }

    public static final class Builder extends Message.Builder<ConnSvrHeartbeatReq> {
        public Builder() {
        }

        public Builder(ConnSvrHeartbeatReq connSvrHeartbeatReq) {
            super(connSvrHeartbeatReq);
        }

        public ConnSvrHeartbeatReq build() {
            return new ConnSvrHeartbeatReq(this);
        }
    }
}
