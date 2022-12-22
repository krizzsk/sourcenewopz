package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzd;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzcxp implements zzcbr {
    private final zzctb zzgwn;

    zzcxp(zzctb zzctb) {
        this.zzgwn = zzctb;
    }

    public final void zza(boolean z, Context context) {
        zzctb zzctb = this.zzgwn;
        try {
            ((zzdqd) zzctb.zzdoy).setImmersiveMode(z);
            ((zzdqd) zzctb.zzdoy).showVideo();
        } catch (zzdpq e) {
            zzd.zzd("Cannot show rewarded video.", e);
            throw new zzcbq(e.getCause());
        }
    }
}
