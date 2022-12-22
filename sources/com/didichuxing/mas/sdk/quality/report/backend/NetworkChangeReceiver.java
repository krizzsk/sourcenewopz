package com.didichuxing.mas.sdk.quality.report.backend;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.util.Log;
import com.didi.dimina.container.bridge.network.NetWorkStateReceiver;

public class NetworkChangeReceiver extends BroadcastReceiver {
    private static NetworkChangeReceiver mReceiver;

    public static void init(Context context) {
        mReceiver = new NetworkChangeReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(NetWorkStateReceiver.ANDROID_NET_CHANGE_ACTION);
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        try {
            context.registerReceiver(mReceiver, intentFilter);
        } catch (Exception e) {
            Log.d("Context", "registerReceiver", e);
        }
    }

    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.net.wifi.STATE_CHANGE")) {
            if (((NetworkInfo) intent.getParcelableExtra("networkInfo")).isConnected()) {
                BackendThread.getInstance().wakeup();
            }
        } else if (intent.getAction().equals(NetWorkStateReceiver.ANDROID_NET_CHANGE_ACTION)) {
            NetworkInfo networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
            if (networkInfo.getType() == 1) {
                networkInfo.isConnected();
            }
        }
    }
}
