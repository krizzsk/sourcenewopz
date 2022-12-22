package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzcpi implements zzbvm {
    private final Context context;
    private final zzayd zzbrf;

    zzcpi(Context context2, zzayd zzayd) {
        this.context = context2;
        this.zzbrf = zzayd;
    }

    public final void zzd(zzauj zzauj) {
    }

    public final void zzd(zzdpi zzdpi) {
        if (!TextUtils.isEmpty(zzdpi.zzhnt.zzeuy.zzdyi)) {
            this.zzbrf.zza(this.context, zzdpi.zzhns.zzfzg.zzhnx);
            this.zzbrf.zzi(this.context, zzdpi.zzhnt.zzeuy.zzdyi);
        }
    }
}
