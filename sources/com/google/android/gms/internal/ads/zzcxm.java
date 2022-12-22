package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzd;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcxm implements zzcth<zzcip, zzdqd, zzcuu> {
    private final Context context;
    /* access modifiers changed from: private */
    public final Executor zzfur;
    private final zzcis zzgyj;

    public zzcxm(Context context2, Executor executor, zzcis zzcis) {
        this.context = context2;
        this.zzfur = executor;
        this.zzgyj = zzcis;
    }

    public final void zza(zzdpi zzdpi, zzdot zzdot, zzctb<zzdqd, zzcuu> zzctb) throws zzdpq {
        if (!((zzdqd) zzctb.zzdoy).isInitialized()) {
            ((zzcuu) zzctb.zzgvk).zza((zzbzy) new zzcxo(this, zzdpi, zzdot, zzctb));
            ((zzdqd) zzctb.zzdoy).zza(this.context, zzdpi.zzhns.zzfzg.zzhnx, (String) null, (zzavu) zzctb.zzgvk, zzdot.zzhmk.toString());
            return;
        }
        zzc(zzdpi, zzdot, zzctb);
    }

    /* access modifiers changed from: private */
    public static void zzc(zzdpi zzdpi, zzdot zzdot, zzctb<zzdqd, zzcuu> zzctb) {
        try {
            ((zzdqd) zzctb.zzdoy).zza(zzdpi.zzhns.zzfzg.zzhnx, zzdot.zzhmk.toString());
        } catch (Exception e) {
            String valueOf = String.valueOf(zzctb.zzcja);
            zzd.zzd(valueOf.length() != 0 ? "Fail to load ad from adapter ".concat(valueOf) : new String("Fail to load ad from adapter "), e);
        }
    }

    public final /* synthetic */ Object zzb(zzdpi zzdpi, zzdot zzdot, zzctb zzctb) throws zzdpq, zzcwo {
        zzcir zza = this.zzgyj.zza(new zzbps(zzdpi, zzdot, zzctb.zzcja), new zzciq(new zzcxp(zzctb)));
        zza.zzahh().zza(new zzbkx((zzdqd) zzctb.zzdoy), this.zzfur);
        zzbty zzahi = zza.zzahi();
        zzbst zzahj = zza.zzahj();
        ((zzcuu) zzctb.zzgvk).zza((zzavu) new zzcxq(this, zza.zzaiu(), zzahj, zzahi, zza.zzajb()));
        return zza.zzaja();
    }
}
