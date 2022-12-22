package com.didi.sdk.protobuf;

import com.squareup.wire.Message;

public final class AppSynchronizeReq extends Message {
    public int hashCode() {
        return 0;
    }

    public AppSynchronizeReq() {
    }

    private AppSynchronizeReq(Builder builder) {
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        return obj instanceof AppSynchronizeReq;
    }

    public static final class Builder extends Message.Builder<AppSynchronizeReq> {
        public Builder() {
        }

        public Builder(AppSynchronizeReq appSynchronizeReq) {
            super(appSynchronizeReq);
        }

        public AppSynchronizeReq build() {
            return new AppSynchronizeReq(this);
        }
    }
}
