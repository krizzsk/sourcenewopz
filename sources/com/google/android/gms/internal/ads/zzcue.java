package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcue implements zzcth<zzbne, zzaqa, zzcuv> {
    private final Context context;
    /* access modifiers changed from: private */
    public View view;
    private final zzboa zzgwe;
    /* access modifiers changed from: private */
    public zzanu zzgwl;

    public zzcue(Context context2, zzboa zzboa) {
        this.context = context2;
        this.zzgwe = zzboa;
    }

    public final void zza(zzdpi zzdpi, zzdot zzdot, zzctb<zzaqa, zzcuv> zzctb) throws zzdpq {
        try {
            ((zzaqa) zzctb.zzdoy).zzdn(zzdot.zzdpg);
            if (!((Boolean) zzww.zzra().zzd(zzabq.zzdaf)).booleanValue() || !zzdot.zzadh) {
                ((zzaqa) zzctb.zzdoy).zza(zzdot.zzewu, zzdot.zzhmk.toString(), zzdpi.zzhns.zzfzg.zzhnx, ObjectWrapper.wrap(this.context), (zzapo) new zzcui(this, zzctb), (zzant) zzctb.zzgvk, zzdpi.zzhns.zzfzg.zzbpy);
            } else {
                ((zzaqa) zzctb.zzdoy).zzb(zzdot.zzewu, zzdot.zzhmk.toString(), zzdpi.zzhns.zzfzg.zzhnx, ObjectWrapper.wrap(this.context), new zzcui(this, zzctb), (zzant) zzctb.zzgvk, zzdpi.zzhns.zzfzg.zzbpy);
            }
        } catch (RemoteException e) {
            throw new zzdpq(e);
        }
    }

    private final View zze(zzdot zzdot) throws zzdpq {
        try {
            View view2 = (View) ObjectWrapper.unwrap(this.zzgwl.zzve());
            boolean shouldDelegateInterscrollerEffect = this.zzgwl.shouldDelegateInterscrollerEffect();
            if (view2 == null) {
                throw new zzdpq(new Exception("BannerRtbAdapterWrapper interscrollerView should not be null"));
            } else if (!shouldDelegateInterscrollerEffect) {
                return view2;
            } else {
                try {
                    return (View) zzebh.zzb(zzebh.zzag(null), new zzcug(this, view2, zzdot), (Executor) zzbat.zzeki).get();
                } catch (InterruptedException | ExecutionException e) {
                    throw new zzdpq(e);
                }
            }
        } catch (RemoteException e2) {
            throw new zzdpq(e2);
        }
    }

    public final /* synthetic */ Object zzb(zzdpi zzdpi, zzdot zzdot, zzctb zzctb) throws zzdpq, zzcwo {
        View view2;
        if (!((Boolean) zzww.zzra().zzd(zzabq.zzdaf)).booleanValue() || !zzdot.zzadh) {
            view2 = this.view;
        } else {
            view2 = zze(zzdot);
        }
        zzbnh zza = this.zzgwe.zza(new zzbps(zzdpi, zzdot, zzctb.zzcja), new zzbnl(view2, (zzbfi) null, new zzcuh(zzctb), zzdot.zzhmj.get(0)));
        zza.zzaij().zzv(view2);
        ((zzcuv) zzctb.zzgvk).zzb((zzant) zza.zzahn());
        return zza.zzaii();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzebt zzb(View view2, zzdot zzdot, Object obj) throws Exception {
        return zzebh.zzag(zzbos.zza(this.context, view2, zzdot));
    }

    static final /* synthetic */ zzzd zza(zzctb zzctb) throws zzdpq {
        try {
            return ((zzaqa) zzctb.zzdoy).getVideoController();
        } catch (RemoteException e) {
            throw new zzdpq(e);
        }
    }
}
