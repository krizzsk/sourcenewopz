package com.didi.sdk.app;

import android.content.Intent;
import android.content.IntentFilter;

public interface BroadcastReceiverManager extends IBroadcastSender {
    void registerReceiver(AbsDidiBroadcastReceiver absDidiBroadcastReceiver, IntentFilter intentFilter);

    void sendBroadcast(Intent intent);

    void unregisterReceiver(AbsDidiBroadcastReceiver absDidiBroadcastReceiver);
}
