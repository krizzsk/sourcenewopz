package com.didi.onehybrid.resource.offline;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.CopyOnWriteArrayList;

public class FusionOfflineEventBroadcastReceiver extends BroadcastReceiver {
    private CopyOnWriteArrayList<OfflineBundleInfo> mOfflineBundleInfos;
    MyHandler myHandler = new MyHandler(Looper.myLooper());

    public void onReceive(Context context, Intent intent) {
        Bundle checkParams = checkParams(intent);
        if (checkParams != null) {
            String string = checkParams.getString("fusion_offline_event_type", "0");
            char c = 65535;
            if (string.hashCode() == 49 && string.equals("1")) {
                c = 0;
            }
            if (c == 0) {
                downloadEvent(checkParams, "1");
            }
        }
    }

    private Bundle checkParams(Intent intent) {
        String action;
        if (intent != null && (action = intent.getAction()) != null && !action.isEmpty() && action.equals("fusion_offline_event")) {
            return intent.getExtras();
        }
        return null;
    }

    static class MyHandler extends Handler {
        public MyHandler() {
        }

        public MyHandler(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (!OfflineBundleManager.getInstance().isAllOfflineItemLoaded()) {
                sendMessageDelayed(message, 2000);
            } else if (message.what == 10023) {
                OfflineBundleManager.getInstance().downloadOfflineWhenEvent((String) message.obj);
            }
        }
    }

    private void downloadEvent(Bundle bundle, String str) {
        String string = bundle.getString(str);
        if (string != null && !string.isEmpty() && OfflineBundleManager.isInitialized()) {
            Message obtainMessage = this.myHandler.obtainMessage();
            obtainMessage.what = 10023;
            obtainMessage.obj = string;
            this.myHandler.sendMessage(obtainMessage);
        }
    }
}
