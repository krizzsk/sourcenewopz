package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcwx implements zzcth<zzcip, zzaqa, zzcuv> {
    private final Context context;
    private final zzcis zzgyj;

    public zzcwx(Context context2, zzcis zzcis) {
        this.context = context2;
        this.zzgyj = zzcis;
    }

    public final void zza(zzdpi zzdpi, zzdot zzdot, zzctb<zzaqa, zzcuv> zzctb) throws zzdpq {
        try {
            ((zzaqa) zzctb.zzdoy).zzdn(zzdot.zzdpg);
            if (zzdpi.zzhns.zzfzg.zzhof.zzhnj == zzdpe.zzhnn) {
                ((zzaqa) zzctb.zzdoy).zzb(zzdot.zzewu, zzdot.zzhmk.toString(), zzdpi.zzhns.zzfzg.zzhnx, ObjectWrapper.wrap(this.context), new zzcwz(this, zzctb), (zzant) zzctb.zzgvk);
            } else {
                ((zzaqa) zzctb.zzdoy).zza(zzdot.zzewu, zzdot.zzhmk.toString(), zzdpi.zzhns.zzfzg.zzhnx, ObjectWrapper.wrap(this.context), (zzapz) new zzcwz(this, zzctb), (zzant) zzctb.zzgvk);
            }
        } catch (RemoteException e) {
            zzd.zza("Remote exception loading a rewarded RTB ad", e);
        }
    }

    public final /* synthetic */ Object zzb(zzdpi zzdpi, zzdot zzdot, zzctb zzctb) throws zzdpq, zzcwo {
        zzcvf zzcvf = new zzcvf(zzdot, (zzaqa) zzctb.zzdoy, true);
        zzcir zza = this.zzgyj.zza(new zzbps(zzdpi, zzdot, zzctb.zzcja), new zzciq(zzcvf));
        zzcvf.zza(zza.zzahk());
        ((zzcuv) zzctb.zzgvk).zzb((zzant) zza.zzajd());
        return zza.zzaja();
    }
}
