package com.didi.sdk.push;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class PushNetReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        try {
            if (Utils.isNetworkConnected(context)) {
                NetworkChangeHandler.getDefault().onAvailable(context);
            } else {
                NetworkChangeHandler.getDefault().onLost(context);
            }
        } catch (Exception unused) {
        }
    }
}
