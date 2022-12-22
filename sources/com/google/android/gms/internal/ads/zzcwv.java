package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzcwv implements zzcbr {
    private final zzctb zzgwn;

    zzcwv(zzctb zzctb) {
        this.zzgwn = zzctb;
    }

    public final void zza(boolean z, Context context) {
        zzctb zzctb = this.zzgwn;
        try {
            ((zzdqd) zzctb.zzdoy).setImmersiveMode(z);
            ((zzdqd) zzctb.zzdoy).zzcm(context);
        } catch (zzdpq e) {
            throw new zzcbq(e.getCause());
        }
    }
}
