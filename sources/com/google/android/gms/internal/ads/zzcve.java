package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzbh;
import com.google.android.gms.ads.internal.util.zzbm;
import com.google.android.gms.ads.internal.util.zzd;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcve implements zzcth<zzcaj, zzdqd, zzcuv> {
    private final Context context;
    private final zzbar zzbpj;
    private final Executor zzfur;
    private final zzcbj zzgwq;

    public zzcve(Context context2, zzbar zzbar, zzcbj zzcbj, Executor executor) {
        this.context = context2;
        this.zzbpj = zzbar;
        this.zzgwq = zzcbj;
        this.zzfur = executor;
    }

    public final void zza(zzdpi zzdpi, zzdot zzdot, zzctb<zzdqd, zzcuv> zzctb) throws zzdpq {
        ((zzdqd) zzctb.zzdoy).zza(this.context, zzdpi.zzhns.zzfzg.zzhnx, zzdot.zzhmk.toString(), zzbh.zza((zzbm) zzdot.zzhmh), (zzant) zzctb.zzgvk);
    }

    public final /* synthetic */ Object zzb(zzdpi zzdpi, zzdot zzdot, zzctb zzctb) throws zzdpq, zzcwo {
        zzcal zza = this.zzgwq.zza(new zzbps(zzdpi, zzdot, zzctb.zzcja), new zzcak(new zzcvh(this, zzctb)));
        zza.zzahh().zza(new zzbkx((zzdqd) zzctb.zzdoy), this.zzfur);
        ((zzcuv) zzctb.zzgvk).zzb((zzant) zza.zzahm());
        return zza.zzait();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzctb zzctb, boolean z, Context context2) throws zzcbq {
        try {
            ((zzdqd) zzctb.zzdoy).setImmersiveMode(z);
            if (this.zzbpj.zzekb < ((Integer) zzww.zzra().zzd(zzabq.zzcpm)).intValue()) {
                ((zzdqd) zzctb.zzdoy).showInterstitial();
            } else {
                ((zzdqd) zzctb.zzdoy).zzcl(context2);
            }
        } catch (zzdpq e) {
            zzd.zzey("Cannot show interstitial.");
            throw new zzcbq(e.getCause());
        }
    }
}
