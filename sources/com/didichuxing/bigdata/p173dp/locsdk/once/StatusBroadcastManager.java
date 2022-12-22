package com.didichuxing.bigdata.p173dp.locsdk.once;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.once.StatusBroadcastManager */
public class StatusBroadcastManager {
    public static final String ACTION_LOCATION_STATUS_CHANGED = "com.didichuxing.bigdata.dp.com.didichuxing.bigdata.dp.locsdk.ACTION_LOCATION_STATUS_CHANGED";
    public static final String EXTRA_KEY_STATUS_TYPE = "com.didichuxing.bigdata.dp.com.didichuxing.bigdata.dp.locsdk.EXTRA_KEY_STATUS_TYPE";
    public static final String EXTRA_KEY_STATUS_VALUE = "com.didichuxing.bigdata.dp.com.didichuxing.bigdata.dp.locsdk.EXTRA_KEY_STATUS_VALUE";

    /* renamed from: a */
    private LocalBroadcastManager f46113a;

    /* renamed from: b */
    private Context f46114b;

    public void unRegisterStatusReceiver(BroadcastReceiver broadcastReceiver) {
        LocalBroadcastManager localBroadcastManager = this.f46113a;
        if (localBroadcastManager != null) {
            localBroadcastManager.unregisterReceiver(broadcastReceiver);
        }
    }

    public void broadcastStatus(String str, int i) {
        if (this.f46113a != null) {
            Intent intent = new Intent("com.didichuxing.bigdata.dp.com.didichuxing.bigdata.dp.locsdk.ACTION_LOCATION_STATUS_CHANGED");
            intent.putExtra("com.didichuxing.bigdata.dp.com.didichuxing.bigdata.dp.locsdk.EXTRA_KEY_STATUS_TYPE", str);
            intent.putExtra("com.didichuxing.bigdata.dp.com.didichuxing.bigdata.dp.locsdk.EXTRA_KEY_STATUS_VALUE", i);
            this.f46113a.sendBroadcast(intent);
        }
    }

    /* renamed from: com.didichuxing.bigdata.dp.locsdk.once.StatusBroadcastManager$InstanceHolder */
    private static class InstanceHolder {
        static final StatusBroadcastManager sInstance = new StatusBroadcastManager();

        private InstanceHolder() {
        }
    }

    public static StatusBroadcastManager getInstance() {
        return InstanceHolder.sInstance;
    }

    private StatusBroadcastManager() {
    }

    public void init(Context context) {
        if (this.f46114b == null || this.f46113a == null) {
            this.f46114b = context;
            this.f46113a = LocalBroadcastManager.getInstance(context);
        }
    }

    public void registerStatusReceiver(BroadcastReceiver broadcastReceiver) {
        if (this.f46113a != null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.didichuxing.bigdata.dp.com.didichuxing.bigdata.dp.locsdk.ACTION_LOCATION_STATUS_CHANGED");
            this.f46113a.registerReceiver(broadcastReceiver, intentFilter);
        }
    }
}
