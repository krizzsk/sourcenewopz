package com.didi.sdk.protobuf;

import com.squareup.wire.Message;

public final class CollectSvrHeartbeatReq extends Message {
    public int hashCode() {
        return 0;
    }

    public CollectSvrHeartbeatReq() {
    }

    private CollectSvrHeartbeatReq(Builder builder) {
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        return obj instanceof CollectSvrHeartbeatReq;
    }

    public static final class Builder extends Message.Builder<CollectSvrHeartbeatReq> {
        public Builder() {
        }

        public Builder(CollectSvrHeartbeatReq collectSvrHeartbeatReq) {
            super(collectSvrHeartbeatReq);
        }

        public CollectSvrHeartbeatReq build() {
            return new CollectSvrHeartbeatReq(this);
        }
    }
}
