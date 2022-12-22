package com.kwai.koom.javaoom.analysis;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;

class IPCReceiver extends ResultReceiver {

    /* renamed from: a */
    public static final int f55551a = 1001;

    /* renamed from: b */
    public static final int f55552b = 1002;

    /* renamed from: c */
    private ReceiverCallback f55553c;

    public interface ReceiverCallback {
        void onError();

        void onSuccess();
    }

    public IPCReceiver(ReceiverCallback receiverCallback) {
        super((Handler) null);
        this.f55553c = receiverCallback;
    }

    /* access modifiers changed from: protected */
    public void onReceiveResult(int i, Bundle bundle) {
        super.onReceiveResult(i, bundle);
        ReceiverCallback receiverCallback = this.f55553c;
        if (receiverCallback == null) {
            return;
        }
        if (i == 1001) {
            receiverCallback.onSuccess();
        } else {
            receiverCallback.onError();
        }
    }
}
