package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzbh;
import com.google.android.gms.ads.internal.util.zzbm;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcvu implements zzcth<zzcdf, zzdqd, zzcuv> {
    private final Context context;
    private final Executor zzfur;
    private final zzccf zzgxk;

    public zzcvu(Context context2, zzccf zzccf, Executor executor) {
        this.context = context2;
        this.zzgxk = zzccf;
        this.zzfur = executor;
    }

    public final void zza(zzdpi zzdpi, zzdot zzdot, zzctb<zzdqd, zzcuv> zzctb) throws zzdpq {
        ((zzdqd) zzctb.zzdoy).zza(this.context, zzdpi.zzhns.zzfzg.zzhnx, zzdot.zzhmk.toString(), zzbh.zza((zzbm) zzdot.zzhmh), (zzant) zzctb.zzgvk, zzdpi.zzhns.zzfzg.zzdpr, zzdpi.zzhns.zzfzg.zzhnz);
    }

    private static boolean zza(zzdpi zzdpi, int i) {
        return zzdpi.zzhns.zzfzg.zzhnz.contains(Integer.toString(i));
    }

    public final /* synthetic */ Object zzb(zzdpi zzdpi, zzdot zzdot, zzctb zzctb) throws zzdpq, zzcwo {
        zzcdr zzcdr;
        zzaob zzvf = ((zzdqd) zzctb.zzdoy).zzvf();
        zzaoc zzvg = ((zzdqd) zzctb.zzdoy).zzvg();
        zzaoh zzvl = ((zzdqd) zzctb.zzdoy).zzvl();
        if (zzvl != null && zza(zzdpi, 6)) {
            zzcdr = zzcdr.zzb(zzvl);
        } else if (zzvf != null && zza(zzdpi, 6)) {
            zzcdr = zzcdr.zzb(zzvf);
        } else if (zzvf != null && zza(zzdpi, 2)) {
            zzcdr = zzcdr.zza(zzvf);
        } else if (zzvg != null && zza(zzdpi, 6)) {
            zzcdr = zzcdr.zzb(zzvg);
        } else if (zzvg == null || !zza(zzdpi, 1)) {
            throw new zzcwo(zzdqj.INTERNAL_ERROR, "No native ad mappers");
        } else {
            zzcdr = zzcdr.zza(zzvg);
        }
        if (zzdpi.zzhns.zzfzg.zzhnz.contains(Integer.toString(zzcdr.zzaoo()))) {
            zzcds zza = this.zzgxk.zza(new zzbps(zzdpi, zzdot, zzctb.zzcja), new zzced(zzcdr), new zzcfo(zzvg, zzvf, zzvl));
            ((zzcuv) zzctb.zzgvk).zzb((zzant) zza.zzahm());
            zza.zzahh().zza(new zzbkx((zzdqd) zzctb.zzdoy), this.zzfur);
            return zza.zzaho();
        }
        throw new zzcwo(zzdqj.INTERNAL_ERROR, "No corresponding native ad listener");
    }
}
