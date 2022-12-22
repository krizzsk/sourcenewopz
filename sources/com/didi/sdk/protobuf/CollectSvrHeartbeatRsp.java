package com.didi.sdk.protobuf;

import com.squareup.wire.Message;

public final class CollectSvrHeartbeatRsp extends Message {
    public int hashCode() {
        return 0;
    }

    public CollectSvrHeartbeatRsp() {
    }

    private CollectSvrHeartbeatRsp(Builder builder) {
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        return obj instanceof CollectSvrHeartbeatRsp;
    }

    public static final class Builder extends Message.Builder<CollectSvrHeartbeatRsp> {
        public Builder() {
        }

        public Builder(CollectSvrHeartbeatRsp collectSvrHeartbeatRsp) {
            super(collectSvrHeartbeatRsp);
        }

        public CollectSvrHeartbeatRsp build() {
            return new CollectSvrHeartbeatRsp(this);
        }
    }
}
