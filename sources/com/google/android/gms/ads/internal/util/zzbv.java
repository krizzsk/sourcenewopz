package com.google.android.gms.ads.internal.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import com.google.android.gms.internal.ads.zzabq;
import com.google.android.gms.internal.ads.zzww;
import java.util.ArrayList;
import java.util.Map;
import java.util.WeakHashMap;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbv {
    private Context zzaai;
    private final BroadcastReceiver zzeja = new zzby(this);
    private final Map<BroadcastReceiver, IntentFilter> zzejb = new WeakHashMap();
    private boolean zzejc;
    private boolean zzzq = false;

    public final synchronized void initialize(Context context) {
        if (!this.zzzq) {
            Context applicationContext = context.getApplicationContext();
            this.zzaai = applicationContext;
            if (applicationContext == null) {
                this.zzaai = context;
            }
            zzabq.initialize(this.zzaai);
            this.zzejc = ((Boolean) zzww.zzra().zzd(zzabq.zzcua)).booleanValue();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            try {
                this.zzaai.registerReceiver(this.zzeja, intentFilter);
            } catch (Exception e) {
                Log.d("Context", "registerReceiver", e);
            }
            this.zzzq = true;
        }
    }

    public final synchronized void zza(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (this.zzejc) {
            this.zzejb.put(broadcastReceiver, intentFilter);
            return;
        }
        try {
            context.registerReceiver(broadcastReceiver, intentFilter);
        } catch (Exception e) {
            Log.d("Context", "registerReceiver", e);
        }
        return;
    }

    public final synchronized void zza(Context context, BroadcastReceiver broadcastReceiver) {
        if (this.zzejc) {
            this.zzejb.remove(broadcastReceiver);
            return;
        }
        try {
            context.unregisterReceiver(broadcastReceiver);
        } catch (Exception e) {
            Log.d("Context", "unregisterReceiver", e);
        }
        return;
    }

    /* access modifiers changed from: private */
    public final synchronized void zzc(Context context, Intent intent) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry next : this.zzejb.entrySet()) {
            if (((IntentFilter) next.getValue()).hasAction(intent.getAction())) {
                arrayList.add((BroadcastReceiver) next.getKey());
            }
        }
        ArrayList arrayList2 = arrayList;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            ((BroadcastReceiver) obj).onReceive(context, intent);
        }
    }
}
