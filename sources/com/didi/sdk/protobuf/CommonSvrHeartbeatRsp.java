package com.didi.sdk.protobuf;

import com.squareup.wire.Message;

public final class CommonSvrHeartbeatRsp extends Message {
    public int hashCode() {
        return 0;
    }

    public CommonSvrHeartbeatRsp() {
    }

    private CommonSvrHeartbeatRsp(Builder builder) {
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        return obj instanceof CommonSvrHeartbeatRsp;
    }

    public static final class Builder extends Message.Builder<CommonSvrHeartbeatRsp> {
        public Builder() {
        }

        public Builder(CommonSvrHeartbeatRsp commonSvrHeartbeatRsp) {
            super(commonSvrHeartbeatRsp);
        }

        public CommonSvrHeartbeatRsp build() {
            return new CommonSvrHeartbeatRsp(this);
        }
    }
}
