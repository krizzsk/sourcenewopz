package com.didi.sdk.push;

public class PushRequest {
    private byte[] data;
    private int msgType;
    private boolean needResponse;
    private int priority;
    private byte[] seqIdOut;

    public int getMsgType() {
        return this.msgType;
    }

    public byte[] getData() {
        return this.data;
    }

    public byte[] getSeqIdOut() {
        return this.seqIdOut;
    }

    public int getPriority() {
        return this.priority;
    }

    public boolean isNeedResponse() {
        return this.needResponse;
    }

    public PushRequest(Builder builder) {
        this.msgType = builder.msgType;
        this.data = builder.data;
        this.seqIdOut = builder.seqIdOut;
        this.priority = builder.priority;
        this.needResponse = builder.needResponse;
    }

    public static final class Builder {
        /* access modifiers changed from: private */
        public byte[] data;
        /* access modifiers changed from: private */
        public int msgType;
        /* access modifiers changed from: private */
        public boolean needResponse;
        /* access modifiers changed from: private */
        public int priority;
        /* access modifiers changed from: private */
        public byte[] seqIdOut;

        public Builder msgType(int i) {
            this.msgType = i;
            return this;
        }

        public Builder data(byte[] bArr) {
            this.data = bArr;
            return this;
        }

        public Builder seqIdOut(byte[] bArr) {
            this.seqIdOut = bArr;
            return this;
        }

        public Builder priority(int i) {
            this.priority = i;
            return this;
        }

        public Builder needResponse(boolean z) {
            this.needResponse = z;
            return this;
        }

        public PushRequest build() {
            return new PushRequest(this);
        }
    }
}
