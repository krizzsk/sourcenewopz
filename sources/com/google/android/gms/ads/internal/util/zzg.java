package com.google.android.gms.ads.internal.util;

import android.os.Looper;
import android.os.Message;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.internal.ads.zzdxi;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzg extends zzdxi {
    public zzg(Looper looper) {
        super(looper);
    }

    public final void handleMessage(Message message) {
        try {
            super.handleMessage(message);
        } catch (Exception e) {
            zzr.zzkz().zza(e, "AdMobHandler.handleMessage");
        }
    }

    /* access modifiers changed from: protected */
    public final void zzb(Message message) {
        try {
            super.zzb(message);
        } catch (Throwable th) {
            zzr.zzkv();
            zzj.zza(zzr.zzkz().getApplicationContext(), th);
            throw th;
        }
    }
}
