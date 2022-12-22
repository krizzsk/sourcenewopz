package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzd;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcws implements zzcth<zzcip, zzdqd, zzcuv> {
    private final Context context;
    private final Executor zzfur;
    private final zzcis zzgyj;

    public zzcws(Context context2, Executor executor, zzcis zzcis) {
        this.context = context2;
        this.zzfur = executor;
        this.zzgyj = zzcis;
    }

    public final void zza(zzdpi zzdpi, zzdot zzdot, zzctb<zzdqd, zzcuv> zzctb) throws zzdpq {
        try {
            zzdpm zzdpm = zzdpi.zzhns.zzfzg;
            if (zzdpm.zzhof.zzhnj == zzdpe.zzhnn) {
                ((zzdqd) zzctb.zzdoy).zzb(this.context, zzdpm.zzhnx, zzdot.zzhmk.toString(), (zzant) zzctb.zzgvk);
            } else {
                ((zzdqd) zzctb.zzdoy).zza(this.context, zzdpm.zzhnx, zzdot.zzhmk.toString(), (zzant) zzctb.zzgvk);
            }
        } catch (Exception e) {
            String valueOf = String.valueOf(zzctb.zzcja);
            zzd.zzd(valueOf.length() != 0 ? "Fail to load ad from adapter ".concat(valueOf) : new String("Fail to load ad from adapter "), e);
        }
    }

    public final /* synthetic */ Object zzb(zzdpi zzdpi, zzdot zzdot, zzctb zzctb) throws zzdpq, zzcwo {
        zzcir zza = this.zzgyj.zza(new zzbps(zzdpi, zzdot, zzctb.zzcja), new zzciq(new zzcwv(zzctb)));
        zza.zzahh().zza(new zzbkx((zzdqd) zzctb.zzdoy), this.zzfur);
        ((zzcuv) zzctb.zzgvk).zzb((zzant) zza.zzajc());
        return zza.zzaja();
    }
}
