package com.didi.sdk.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.didi.sdk.app.BaseBusinessContext;
import java.util.HashMap;
import java.util.Map;

public class BroadcastReceiverManagerImpl<T extends BaseBusinessContext> implements BroadcastReceiverManager {

    /* renamed from: a */
    private LocalBroadcastManager f35128a;

    /* renamed from: b */
    private T f35129b;

    /* renamed from: c */
    private Context f35130c;

    /* renamed from: d */
    private Map<AbsDidiBroadcastReceiver, BroadcastReceiver> f35131d = new HashMap();

    BroadcastReceiverManagerImpl(T t) {
        this.f35128a = LocalBroadcastManager.getInstance(t.getContext());
        this.f35129b = t;
        this.f35130c = t.getContext();
    }

    public void unregisterReceiver(AbsDidiBroadcastReceiver absDidiBroadcastReceiver) {
        BroadcastReceiver remove;
        if (absDidiBroadcastReceiver != null && (remove = this.f35131d.remove(absDidiBroadcastReceiver)) != null) {
            this.f35128a.unregisterReceiver(remove);
        }
    }

    public void registerReceiver(AbsDidiBroadcastReceiver absDidiBroadcastReceiver, IntentFilter intentFilter) {
        InternalReceiver internalReceiver = new InternalReceiver(this.f35129b, absDidiBroadcastReceiver);
        this.f35128a.registerReceiver(internalReceiver, intentFilter);
        this.f35131d.put(absDidiBroadcastReceiver, internalReceiver);
    }

    public void sendBroadcast(Intent intent) {
        BroadcastSender.getInstance(this.f35130c).sendBroadcast(intent);
    }

    private static class InternalReceiver<T extends BaseBusinessContext> extends BroadcastReceiver {
        private AbsDidiBroadcastReceiver absDidiBroadcastReceiver;
        private T context;

        public InternalReceiver(T t, AbsDidiBroadcastReceiver absDidiBroadcastReceiver2) {
            this.context = t;
            this.absDidiBroadcastReceiver = absDidiBroadcastReceiver2;
        }

        public void onReceive(Context context2, Intent intent) {
            this.absDidiBroadcastReceiver.onReceive(this.context, intent);
        }
    }
}
