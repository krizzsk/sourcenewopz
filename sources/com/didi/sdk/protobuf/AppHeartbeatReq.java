package com.didi.sdk.protobuf;

import com.squareup.wire.Message;

public final class AppHeartbeatReq extends Message {
    public int hashCode() {
        return 0;
    }

    public AppHeartbeatReq() {
    }

    private AppHeartbeatReq(Builder builder) {
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        return obj instanceof AppHeartbeatReq;
    }

    public static final class Builder extends Message.Builder<AppHeartbeatReq> {
        public Builder() {
        }

        public Builder(AppHeartbeatReq appHeartbeatReq) {
            super(appHeartbeatReq);
        }

        public AppHeartbeatReq build() {
            return new AppHeartbeatReq(this);
        }
    }
}
