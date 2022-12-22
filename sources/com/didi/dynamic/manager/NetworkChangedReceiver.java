package com.didi.dynamic.manager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.didi.dynamic.manager.utils.Log;
import com.didi.dynamic.manager.utils.NetworkUtil;

public class NetworkChangedReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        String simpleName = NetworkChangedReceiver.class.getSimpleName();
        Log.m14488i(simpleName, "onReceive:" + NetworkUtil.getSimpleNetworkType(context));
        DownloadManager.getInstance(context).downloadModuleInWifi(true);
    }
}
