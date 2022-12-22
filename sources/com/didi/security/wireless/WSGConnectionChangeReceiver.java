package com.didi.security.wireless;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public abstract class WSGConnectionChangeReceiver extends BroadcastReceiver {
    public abstract void changeNetStatus(boolean z);

    public void onReceive(Context context, Intent intent) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            boolean z = false;
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(0);
            boolean isConnected = networkInfo != null ? networkInfo.isConnected() : false;
            NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(1);
            boolean isConnected2 = networkInfo2 != null ? networkInfo2.isConnected() : false;
            if (isConnected || isConnected2) {
                z = true;
            }
            changeNetStatus(z);
        } catch (Throwable unused) {
        }
    }
}
