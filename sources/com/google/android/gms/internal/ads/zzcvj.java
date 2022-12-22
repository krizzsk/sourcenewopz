package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcvj implements zzcth<zzcaj, zzaqa, zzcuv> {
    private final Context context;
    private final zzcbj zzgwq;

    public zzcvj(Context context2, zzcbj zzcbj) {
        this.context = context2;
        this.zzgwq = zzcbj;
    }

    public final void zza(zzdpi zzdpi, zzdot zzdot, zzctb<zzaqa, zzcuv> zzctb) throws zzdpq {
        try {
            ((zzaqa) zzctb.zzdoy).zzdn(zzdot.zzdpg);
            ((zzaqa) zzctb.zzdoy).zza(zzdot.zzewu, zzdot.zzhmk.toString(), zzdpi.zzhns.zzfzg.zzhnx, ObjectWrapper.wrap(this.context), (zzapt) new zzcvl(this, zzctb), (zzant) zzctb.zzgvk);
        } catch (RemoteException e) {
            throw new zzdpq(e);
        }
    }

    public final /* synthetic */ Object zzb(zzdpi zzdpi, zzdot zzdot, zzctb zzctb) throws zzdpq, zzcwo {
        zzcvf zzcvf = new zzcvf(zzdot, (zzaqa) zzctb.zzdoy, false);
        zzcal zza = this.zzgwq.zza(new zzbps(zzdpi, zzdot, zzctb.zzcja), new zzcak(zzcvf));
        zzcvf.zza(zza.zzahk());
        ((zzcuv) zzctb.zzgvk).zzb((zzant) zza.zzahn());
        return zza.zzait();
    }
}
