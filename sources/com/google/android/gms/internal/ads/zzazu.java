package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zza;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzr;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzazu extends zza {
    private final /* synthetic */ zzazs zzeev;

    zzazu(zzazs zzazs) {
        this.zzeev = zzazs;
    }

    public final void zzwp() {
        zzabu zzabu = new zzabu(this.zzeev.context, this.zzeev.zzbpx.zzbrz);
        synchronized (this.zzeev.lock) {
            try {
                zzr.zzle();
                zzabz.zza(this.zzeev.zzeei, zzabu);
            } catch (IllegalArgumentException e) {
                zzd.zzd("Cannot config CSI reporter.", e);
            }
        }
    }
}
