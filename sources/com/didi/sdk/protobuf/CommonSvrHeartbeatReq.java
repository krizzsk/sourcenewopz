package com.didi.sdk.protobuf;

import com.squareup.wire.Message;

public final class CommonSvrHeartbeatReq extends Message {
    public int hashCode() {
        return 0;
    }

    public CommonSvrHeartbeatReq() {
    }

    private CommonSvrHeartbeatReq(Builder builder) {
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        return obj instanceof CommonSvrHeartbeatReq;
    }

    public static final class Builder extends Message.Builder<CommonSvrHeartbeatReq> {
        public Builder() {
        }

        public Builder(CommonSvrHeartbeatReq commonSvrHeartbeatReq) {
            super(commonSvrHeartbeatReq);
        }

        public CommonSvrHeartbeatReq build() {
            return new CommonSvrHeartbeatReq(this);
        }
    }
}
