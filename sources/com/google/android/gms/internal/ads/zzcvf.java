package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzcvf implements zzcbr {
    private zzbtl zzgah = null;
    private final zzdot zzgai;
    private final zzaqa zzgxf;
    private final boolean zzgxg;

    zzcvf(zzdot zzdot, zzaqa zzaqa, boolean z) {
        this.zzgai = zzdot;
        this.zzgxf = zzaqa;
        this.zzgxg = z;
    }

    public final void zza(boolean z, Context context) throws zzcbq {
        boolean z2;
        try {
            if (this.zzgxg) {
                z2 = this.zzgxf.zzab(ObjectWrapper.wrap(context));
            } else {
                z2 = this.zzgxf.zzaa(ObjectWrapper.wrap(context));
            }
            if (!z2) {
                throw new zzcbq("Adapter failed to show.");
            } else if (this.zzgah != null) {
                if (!((Boolean) zzww.zzra().zzd(zzabq.zzcrt)).booleanValue() && this.zzgai.zzhmt == 2) {
                    this.zzgah.onAdImpression();
                }
            }
        } catch (Throwable th) {
            throw new zzcbq(th);
        }
    }

    public final void zza(zzbtl zzbtl) {
        this.zzgah = zzbtl;
    }
}
