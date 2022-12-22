package com.didi.sdk.protobuf;

import com.squareup.wire.Message;

public final class ConnSvrDisconnectReq extends Message {
    public int hashCode() {
        return 0;
    }

    public ConnSvrDisconnectReq() {
    }

    private ConnSvrDisconnectReq(Builder builder) {
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        return obj instanceof ConnSvrDisconnectReq;
    }

    public static final class Builder extends Message.Builder<ConnSvrDisconnectReq> {
        public Builder() {
        }

        public Builder(ConnSvrDisconnectReq connSvrDisconnectReq) {
            super(connSvrDisconnectReq);
        }

        public ConnSvrDisconnectReq build() {
            return new ConnSvrDisconnectReq(this);
        }
    }
}
