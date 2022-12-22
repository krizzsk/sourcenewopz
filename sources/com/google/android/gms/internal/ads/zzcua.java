package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.internal.util.zzbh;
import com.google.android.gms.ads.internal.util.zzbm;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.zza;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcua implements zzcth<zzbne, zzdqd, zzcuv> {
    private final Context context;
    private final Executor zzfur;
    private final zzboa zzgwe;

    public zzcua(Context context2, zzboa zzboa, Executor executor) {
        this.context = context2;
        this.zzgwe = zzboa;
        this.zzfur = executor;
    }

    public final void zza(zzdpi zzdpi, zzdot zzdot, zzctb<zzdqd, zzcuv> zzctb) throws zzdpq {
        zzvt zzb;
        zzvt zzvt = zzdpi.zzhns.zzfzg.zzbpy;
        if (zzvt.zzciy) {
            zzb = new zzvt(this.context, zza.zzb(zzvt.width, zzvt.height));
        } else {
            if (!((Boolean) zzww.zzra().zzd(zzabq.zzdaf)).booleanValue() || !zzdot.zzadh) {
                zzb = zzdpr.zzb(this.context, zzdot.zzhmj);
            } else {
                zzb = new zzvt(this.context, zza.zzc(zzvt.width, zzvt.height));
            }
        }
        zzvt zzvt2 = zzb;
        if (!((Boolean) zzww.zzra().zzd(zzabq.zzdaf)).booleanValue() || !zzdot.zzadh) {
            ((zzdqd) zzctb.zzdoy).zzb(this.context, zzvt2, zzdpi.zzhns.zzfzg.zzhnx, zzdot.zzhmk.toString(), zzbh.zza((zzbm) zzdot.zzhmh), (zzant) zzctb.zzgvk);
        } else {
            ((zzdqd) zzctb.zzdoy).zza(this.context, zzvt2, zzdpi.zzhns.zzfzg.zzhnx, zzdot.zzhmk.toString(), zzbh.zza((zzbm) zzdot.zzhmh), (zzant) zzctb.zzgvk);
        }
    }

    private final View zza(zzctb<zzdqd, zzcuv> zzctb, zzdot zzdot) throws zzdpq {
        zzanu zzvo = ((zzdqd) zzctb.zzdoy).zzvo();
        if (zzvo != null) {
            try {
                View view = (View) ObjectWrapper.unwrap(zzvo.zzve());
                boolean shouldDelegateInterscrollerEffect = zzvo.shouldDelegateInterscrollerEffect();
                if (view == null) {
                    throw new zzdpq(new Exception("BannerAdapterWrapper interscrollerView should not be null"));
                } else if (!shouldDelegateInterscrollerEffect) {
                    return view;
                } else {
                    try {
                        return (View) zzebh.zzb(zzebh.zzag(null), new zzcuc(this, view, zzdot), (Executor) zzbat.zzeki).get();
                    } catch (InterruptedException | ExecutionException e) {
                        throw new zzdpq(e);
                    }
                }
            } catch (RemoteException e2) {
                throw new zzdpq(e2);
            }
        } else {
            zzd.zzex("getInterscrollerAd should not be null after loadInterscrollerAd loaded ad.");
            throw new zzdpq(new Exception("getInterscrollerAd should not be null after loadInterscrollerAd loaded ad."));
        }
    }

    public final /* synthetic */ Object zzb(zzdpi zzdpi, zzdot zzdot, zzctb zzctb) throws zzdpq, zzcwo {
        View view;
        if (!((Boolean) zzww.zzra().zzd(zzabq.zzdaf)).booleanValue() || !zzdot.zzadh) {
            view = ((zzdqd) zzctb.zzdoy).getView();
        } else {
            view = zza(zzctb, zzdot);
        }
        zzboa zzboa = this.zzgwe;
        zzbps zzbps = new zzbps(zzdpi, zzdot, zzctb.zzcja);
        zzdqd zzdqd = (zzdqd) zzctb.zzdoy;
        zzdqd.getClass();
        zzbnh zza = zzboa.zza(zzbps, new zzbnl(view, (zzbfi) null, zzcud.zza(zzdqd), zzdot.zzhmj.get(0)));
        zza.zzaij().zzv(view);
        zza.zzahh().zza(new zzbkx((zzdqd) zzctb.zzdoy), this.zzfur);
        ((zzcuv) zzctb.zzgvk).zzb((zzant) zza.zzahm());
        return zza.zzaii();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzebt zza(View view, zzdot zzdot, Object obj) throws Exception {
        return zzebh.zzag(zzbos.zza(this.context, view, zzdot));
    }
}
