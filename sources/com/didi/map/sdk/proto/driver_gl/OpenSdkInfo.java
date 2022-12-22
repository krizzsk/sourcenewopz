package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class OpenSdkInfo extends Message {
    public static final Integer DEFAULT_OPENID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer openId;

    public OpenSdkInfo(Integer num) {
        this.openId = num;
    }

    private OpenSdkInfo(Builder builder) {
        this(builder.openId);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OpenSdkInfo)) {
            return false;
        }
        return equals((Object) this.openId, (Object) ((OpenSdkInfo) obj).openId);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            Integer num = this.openId;
            i = num != null ? num.hashCode() : 0;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<OpenSdkInfo> {
        public Integer openId;

        public Builder() {
        }

        public Builder(OpenSdkInfo openSdkInfo) {
            super(openSdkInfo);
            if (openSdkInfo != null) {
                this.openId = openSdkInfo.openId;
            }
        }

        public Builder openId(Integer num) {
            this.openId = num;
            return this;
        }

        public OpenSdkInfo build() {
            return new OpenSdkInfo(this);
        }
    }
}
