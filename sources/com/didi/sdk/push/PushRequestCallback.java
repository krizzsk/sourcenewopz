package com.didi.sdk.push;

public interface PushRequestCallback {
    void onRequest(CallbackInfo callbackInfo);

    public static class CallbackInfo {
        public int msgType;
        public int retCode;
        public byte[] seqId;

        public CallbackInfo(int i, int i2, byte[] bArr) {
            this.retCode = i;
            this.msgType = i2;
            this.seqId = bArr;
        }
    }
}
