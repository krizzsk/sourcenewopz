package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcvw implements zzcth<zzcdf, zzaqa, zzcuv> {
    private final Context context;
    private final zzbar zzbpj;
    private final zzccf zzgxk;
    /* access modifiers changed from: private */
    public zzaoh zzgxs;

    public zzcvw(Context context2, zzccf zzccf, zzbar zzbar) {
        this.context = context2;
        this.zzgxk = zzccf;
        this.zzbpj = zzbar;
    }

    public final void zza(zzdpi zzdpi, zzdot zzdot, zzctb<zzaqa, zzcuv> zzctb) throws zzdpq {
        try {
            ((zzaqa) zzctb.zzdoy).zzdn(zzdot.zzdpg);
            if (this.zzbpj.zzekb < ((Integer) zzww.zzra().zzd(zzabq.zzcrw)).intValue()) {
                ((zzaqa) zzctb.zzdoy).zza(zzdot.zzewu, zzdot.zzhmk.toString(), zzdpi.zzhns.zzfzg.zzhnx, ObjectWrapper.wrap(this.context), (zzapu) new zzcvy(this, zzctb), (zzant) zzctb.zzgvk);
            } else {
                ((zzaqa) zzctb.zzdoy).zza(zzdot.zzewu, zzdot.zzhmk.toString(), zzdpi.zzhns.zzfzg.zzhnx, ObjectWrapper.wrap(this.context), (zzapu) new zzcvy(this, zzctb), (zzant) zzctb.zzgvk, zzdpi.zzhns.zzfzg.zzdpr);
            }
        } catch (RemoteException e) {
            throw new zzdpq(e);
        }
    }

    public final /* synthetic */ Object zzb(zzdpi zzdpi, zzdot zzdot, zzctb zzctb) throws zzdpq, zzcwo {
        if (zzdpi.zzhns.zzfzg.zzhnz.contains(Integer.toString(6))) {
            zzcdr zzb = zzcdr.zzb(this.zzgxs);
            if (zzdpi.zzhns.zzfzg.zzhnz.contains(Integer.toString(zzb.zzaoo()))) {
                zzcds zza = this.zzgxk.zza(new zzbps(zzdpi, zzdot, zzctb.zzcja), new zzced(zzb), new zzcfo((zzaoc) null, (zzaob) null, this.zzgxs));
                ((zzcuv) zzctb.zzgvk).zzb((zzant) zza.zzahn());
                return zza.zzaho();
            }
            throw new zzcwo(zzdqj.INTERNAL_ERROR, "No corresponding native ad listener");
        }
        throw new zzcwo(zzdqj.INVALID_REQUEST, "Unified must be used for RTB.");
    }
}
