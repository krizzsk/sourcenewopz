package com.didi.sdk.push;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public class BasePushReConnectionHandler implements PushConnectionListener {
    private static final int MAX_RETRY_COUNT = 50;
    private static final int MAX_RETRY_INTERVAL = 10000;
    private static final int MIDDLE_RETRY_COUNT = 20;
    private static final int MIDDLE_RETRY_INTERVAL = 5000;
    private static final int RETRY_CONNECT_DELAY = 1;
    private static final int RETRY_CONNECT_DELAY_FIXED = 2;
    private static final int RETRY_INTERVAL = 3000;
    private Handler handler = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (i == 1 || i == 2) {
                PushClient.getClient().startPushInternal();
            }
        }
    };
    private int mRetryCount = 0;

    public void onConnection(PushConnResult pushConnResult) {
        int retCode = pushConnResult.getRetCode();
        if (retCode == 0) {
            this.mRetryCount = 0;
            return;
        }
        switch (retCode) {
            case -20:
            case -19:
            case -18:
            case -15:
            case -13:
            case -12:
            case -11:
            case -10:
            case -6:
            case -1:
            case 120:
            case 140:
            case 150:
            case 160:
            case 180:
            case 190:
                reConnectDelayFixed();
                return;
            case -9:
            case 100:
            case 170:
                reConnectDelay();
                return;
            default:
                return;
        }
    }

    private void reConnectDelay() {
        int i = this.mRetryCount + 1;
        this.mRetryCount = i;
        int i2 = i > 50 ? 10000 : i > 20 ? 5000 : 3000;
        this.handler.removeMessages(1);
        this.handler.sendEmptyMessageDelayed(1, (long) i2);
    }

    private void reConnectDelayFixed() {
        this.handler.sendEmptyMessageDelayed(2, 1000);
    }
}
