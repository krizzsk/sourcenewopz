package com.didi.sdk.protobuf;

import com.squareup.wire.Message;

public final class ConnSvrGetOnlineReq extends Message {
    public int hashCode() {
        return 0;
    }

    public ConnSvrGetOnlineReq() {
    }

    private ConnSvrGetOnlineReq(Builder builder) {
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        return obj instanceof ConnSvrGetOnlineReq;
    }

    public static final class Builder extends Message.Builder<ConnSvrGetOnlineReq> {
        public Builder() {
        }

        public Builder(ConnSvrGetOnlineReq connSvrGetOnlineReq) {
            super(connSvrGetOnlineReq);
        }

        public ConnSvrGetOnlineReq build() {
            return new ConnSvrGetOnlineReq(this);
        }
    }
}
