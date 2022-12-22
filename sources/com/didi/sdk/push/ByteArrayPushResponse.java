package com.didi.sdk.push;

import com.didi.sdk.push.PushResponse;

public class ByteArrayPushResponse extends PushResponse {
    private byte[] originData;

    private ByteArrayPushResponse(Builder builder) {
        this.msgType = builder.msgType;
        this.seqId = builder.seqId;
        this.originData = builder.originData;
    }

    public byte[] getOriginData() {
        return this.originData;
    }

    public static final class Builder extends PushResponse.Builder<ByteArrayPushResponse> {
        /* access modifiers changed from: private */
        public byte[] originData;

        public Builder msgType(int i) {
            this.msgType = i;
            return this;
        }

        public Builder seqId(byte[] bArr) {
            this.seqId = bArr;
            return this;
        }

        public Builder originData(byte[] bArr) {
            this.originData = bArr;
            return this;
        }

        public ByteArrayPushResponse build() {
            return new ByteArrayPushResponse(this);
        }
    }
}
