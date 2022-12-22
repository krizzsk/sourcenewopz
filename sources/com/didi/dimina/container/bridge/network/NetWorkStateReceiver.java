package com.didi.dimina.container.bridge.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

public class NetWorkStateReceiver extends BroadcastReceiver {
    public static final String ANDROID_NET_CHANGE_ACTION = "android.net.conn.CONNECTIVITY_CHANGE";

    /* renamed from: a */
    private boolean f16748a = false;

    /* renamed from: b */
    private final ArrayList<NetWorkStateListener> f16749b = new ArrayList<>();

    public interface NetWorkStateListener {
        void onNetworkChange();
    }

    public static NetWorkStateReceiver getInstance() {
        return Holder.INSTANCE;
    }

    public void init(Context context) {
        if (!this.f16748a) {
            this.f16748a = true;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(ANDROID_NET_CHANGE_ACTION);
            try {
                context.registerReceiver(Holder.INSTANCE, intentFilter);
            } catch (Exception e) {
                Log.d("Context", "registerReceiver", e);
            }
        }
    }

    public void onReceive(Context context, Intent intent) {
        if (intent != null && intent.getAction().equals(ANDROID_NET_CHANGE_ACTION)) {
            notifyNetworkState();
        }
    }

    public synchronized void registerNetworkState(NetWorkStateListener netWorkStateListener) {
        this.f16749b.add(netWorkStateListener);
    }

    public synchronized void unregisterNetworkState(NetWorkStateListener netWorkStateListener) {
        this.f16749b.remove(netWorkStateListener);
    }

    public void notifyNetworkState() {
        synchronized (NetWorkStateReceiver.class) {
            Iterator<NetWorkStateListener> it = this.f16749b.iterator();
            while (it.hasNext()) {
                it.next().onNetworkChange();
            }
        }
    }

    private static class Holder {
        /* access modifiers changed from: private */
        public static final NetWorkStateReceiver INSTANCE = new NetWorkStateReceiver();

        private Holder() {
        }
    }
}
