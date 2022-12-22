package com.didi.sdk.protobuf;

import com.squareup.wire.Message;

public final class ConnSvrGetOnlineCountReq extends Message {
    public int hashCode() {
        return 0;
    }

    public ConnSvrGetOnlineCountReq() {
    }

    private ConnSvrGetOnlineCountReq(Builder builder) {
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        return obj instanceof ConnSvrGetOnlineCountReq;
    }

    public static final class Builder extends Message.Builder<ConnSvrGetOnlineCountReq> {
        public Builder() {
        }

        public Builder(ConnSvrGetOnlineCountReq connSvrGetOnlineCountReq) {
            super(connSvrGetOnlineCountReq);
        }

        public ConnSvrGetOnlineCountReq build() {
            return new ConnSvrGetOnlineCountReq(this);
        }
    }
}
