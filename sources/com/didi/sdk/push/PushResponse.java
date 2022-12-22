package com.didi.sdk.push;

public abstract class PushResponse {
    protected int msgType;
    protected byte[] seqId;

    public int getMsgType() {
        return this.msgType;
    }

    public byte[] getSeqId() {
        return this.seqId;
    }

    public static abstract class Builder<T extends PushResponse> {
        protected int msgType;
        protected byte[] seqId;

        public abstract T build();

        public Builder<T> msgType(int i) {
            this.msgType = i;
            return this;
        }

        public Builder<T> seqId(byte[] bArr) {
            this.seqId = bArr;
            return this;
        }
    }
}
