package com.didi.sdk.tpush;

public interface ILogCallbackListener {
    void onLog(int i, String str);

    void onRequested(int i, int i2, byte[] bArr);
}
