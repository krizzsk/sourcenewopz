package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzr;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzbxp implements Runnable {
    private final Object zzdms;
    private final zzbxs zzgcl;

    zzbxp(zzbxs zzbxs, Object obj) {
        this.zzgcl = zzbxs;
        this.zzdms = obj;
    }

    public final void run() {
        try {
            this.zzgcl.zzo(this.zzdms);
        } catch (Throwable th) {
            zzr.zzkz().zzb(th, "EventEmitter.notify");
            zzd.zza("Event emitter exception.", th);
        }
    }
}
