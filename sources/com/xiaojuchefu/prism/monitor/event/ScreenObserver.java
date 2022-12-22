package com.xiaojuchefu.prism.monitor.event;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.xiaojuchefu.prism.monitor.PrismMonitor;

public class ScreenObserver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.SCREEN_ON")) {
            PrismMonitor.getInstance().post(7);
        } else if (intent.getAction().equals("android.intent.action.SCREEN_OFF")) {
            PrismMonitor.getInstance().post(8);
        }
    }
}
