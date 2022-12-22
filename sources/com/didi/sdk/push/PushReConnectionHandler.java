package com.didi.sdk.push;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;

@ServiceProvider({PushConnectionListener.class})
public class PushReConnectionHandler implements PushConnectionListener {
    private static final int ERROR_FORCE_RETRY_CONNECT = 2;
    private static final int ERROR_RETRY_CONNECT = 1;
    private static final int MAX_RETRY_COUNT = 5;
    private static final int MAX_RETRY_INTERVAL = 5000;
    private static final int RETRY_CONNECTION_INTERVAL = 3000;
    private static final String TAG = "push-debug";
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
        } else if (retCode == 100 || retCode == 120 || retCode == 140 || retCode == 150 || retCode == 160 || retCode == 170 || retCode == 180) {
            retryConnection();
        } else if (retCode == 190) {
            forceRetryConnect();
        }
    }

    private void retryConnection() {
        int i = this.mRetryCount + 1;
        this.mRetryCount = i;
        int i2 = i >= 5 ? 5000 : 3000;
        this.handler.removeMessages(1);
        this.handler.sendEmptyMessageDelayed(1, (long) i2);
    }

    private void forceRetryConnect() {
        this.handler.sendEmptyMessage(2);
    }
}
