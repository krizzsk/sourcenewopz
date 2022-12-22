package com.didi.payment.base.net;

public interface DownCallback {
    void onFailure();

    void onProgress(int i);

    void onSuccess();
}
