package com.didi.sdk.messagecenter;

public interface PushCallback {
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
