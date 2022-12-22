package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import com.didi.hawaii.mapsdk.gesture.NNGestureClassfy;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzddt implements zzdhe<zzddu> {
    private final Context context;
    private final zzebs zzgka;

    public zzddt(zzebs zzebs, Context context2) {
        this.zzgka = zzebs;
        this.context = context2;
    }

    public final zzebt<zzddu> zzatu() {
        return this.zzgka.zze(new zzddw(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzddu zzauc() throws Exception {
        Intent intent = null;
        try {
            intent = this.context.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        } catch (Exception e) {
            Log.d("Context", "registerReceiver", e);
        }
        double d = -1.0d;
        boolean z = false;
        if (intent != null) {
            int intExtra = intent.getIntExtra("status", -1);
            double intExtra2 = ((double) intent.getIntExtra("level", -1)) / ((double) intent.getIntExtra(NNGestureClassfy.SCALE_LABLE, -1));
            if (intExtra == 2 || intExtra == 5) {
                z = true;
            }
            d = intExtra2;
        }
        return new zzddu(d, z);
    }
}
