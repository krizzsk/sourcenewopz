package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzr;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcqb extends zzatz {
    private final Context context;
    private final Executor zzfur;
    private final zzauw zzgrz;
    private final zzaux zzgsa;
    private final zzbki zzgsb;
    private final HashMap<String, zzcqm> zzgsc;

    public zzcqb(Context context2, Executor executor, zzauw zzauw, zzbki zzbki, zzaux zzaux, HashMap<String, zzcqm> hashMap) {
        zzabq.initialize(context2);
        this.context = context2;
        this.zzfur = executor;
        this.zzgrz = zzauw;
        this.zzgsa = zzaux;
        this.zzgsb = zzbki;
        this.zzgsc = hashMap;
    }

    public final zzats zza(zzatq zzatq) throws RemoteException {
        return null;
    }

    public final void zza(zzatq zzatq, zzaub zzaub) throws RemoteException {
    }

    public final zzebt<InputStream> zzb(zzauj zzauj, int i) {
        zzamo zza = zzr.zzli().zza(this.context, zzbar.zzaau());
        zzdhw zza2 = this.zzgsb.zza(zzauj, i);
        zzamg<I, O> zza3 = zza.zza("google.afma.response.normalize", zzcqp.zzgsk, zzamn.zzdmb);
        zzcqq zzcqq = new zzcqq(this.context, zzauj.zzdvi.zzbrz, this.zzgrz, zzauj.zzdwh, i);
        zzdtg zzahw = zza2.zzahw();
        zzcqm zzcqm = null;
        if (!zzadr.zzdfo.get().booleanValue()) {
            if (zzauj.zzdyv != null && !zzauj.zzdyv.isEmpty()) {
                zzd.zzed("Request contained a PoolKey but split request is disabled.");
            }
        } else if (zzauj.zzdyv != null && !zzauj.zzdyv.isEmpty() && (zzcqm = this.zzgsc.remove(zzauj.zzdyv)) == null) {
            zzd.zzed("Request contained a PoolKey but no matching parameters were found.");
        }
        if (zzcqm == null) {
            zzebt<JSONObject> zza4 = zza(zzauj, zzahw, zza2);
            zzebt<zzaup> zza5 = zza(zza4, zzahw, zza);
            zzdst zzayi = zzahw.zza(zzdth.HTTP, (zzebt<?>[]) new zzebt[]{zza5, zza4}).zzb(new zzcqa(zza4, zza5)).zzb(zzcqq).zzayi();
            return zzahw.zza(zzdth.PRE_PROCESS, (zzebt<?>[]) new zzebt[]{zza4, zza5, zzayi}).zzb(new zzcqd(zzayi, zza4, zza5)).zza(zza3).zzayi();
        }
        zzdst zzayi2 = zzahw.zza(zzdth.HTTP, zzebh.zzag(new zzcqt(zzcqm.zzgsh, zzcqm.zzgsg))).zzb(zzcqq).zzayi();
        zzebt zzag = zzebh.zzag(zzcqm);
        return zzahw.zza(zzdth.PRE_PROCESS, (zzebt<?>[]) new zzebt[]{zzayi2, zzag}).zzb(new zzcqc(zzayi2, zzag)).zza(zza3).zzayi();
    }

    private static zzebt<JSONObject> zza(zzauj zzauj, zzdtg zzdtg, zzdhw zzdhw) {
        zzcqf zzcqf = new zzcqf(zzdhw);
        return zzdtg.zza(zzdth.GMS_SIGNALS, zzebh.zzag(zzauj.zzdys)).zza(zzcqf).zzb(zzcqe.zzgqm).zzayi();
    }

    private static zzebt<zzaup> zza(zzebt<JSONObject> zzebt, zzdtg zzdtg, zzamo zzamo) {
        return zzdtg.zza(zzdth.BUILD_URL, zzebt).zza(zzamo.zza("AFMA_getAdDictionary", zzamn.zzdma, zzcqh.zzdlz)).zzayi();
    }

    public final void zza(zzauj zzauj, zzaud zzaud) {
        zzebt<InputStream> zzb = zzb(zzauj, Binder.getCallingUid());
        zza(zzb, zzaud);
        zzb.addListener(new zzcqg(this), this.zzfur);
    }

    public final zzebt<InputStream> zzc(zzauj zzauj, int i) {
        if (!zzadr.zzdfo.get().booleanValue()) {
            return zzebh.immediateFailedFuture(new Exception("Split request is disabled."));
        }
        if (zzauj.zzdyu == null) {
            return zzebh.immediateFailedFuture(new Exception("Pool configuration missing from request."));
        }
        if (zzauj.zzdyu.zzhqp == 0 || zzauj.zzdyu.zzhqq == 0) {
            return zzebh.immediateFailedFuture(new Exception("Caching is disabled."));
        }
        zzamo zza = zzr.zzli().zza(this.context, zzbar.zzaau());
        zzdhw zza2 = this.zzgsb.zza(zzauj, i);
        zzdtg zzahw = zza2.zzahw();
        zzebt<JSONObject> zza3 = zza(zzauj, zzahw, zza2);
        zzebt<zzaup> zza4 = zza(zza3, zzahw, zza);
        return zzahw.zza(zzdth.GET_URL_AND_CACHE_KEY, (zzebt<?>[]) new zzebt[]{zza3, zza4}).zzb(new zzcqj(this, zza4, zza3)).zzayi();
    }

    public final zzebt<InputStream> zzgk(String str) {
        if (!zzadr.zzdfo.get().booleanValue()) {
            return zzebh.immediateFailedFuture(new Exception("Split request is disabled."));
        }
        zzcqk zzcqk = new zzcqk(this);
        if (this.zzgsc.remove(str) != null) {
            return zzebh.zzag(zzcqk);
        }
        String valueOf = String.valueOf(str);
        return zzebh.immediateFailedFuture(new Exception(valueOf.length() != 0 ? "URL to be removed not found for cache key: ".concat(valueOf) : new String("URL to be removed not found for cache key: ")));
    }

    public final void zzc(zzauj zzauj, zzaud zzaud) {
        zza(zzc(zzauj, Binder.getCallingUid()), zzaud);
    }

    public final void zza(String str, zzaud zzaud) {
        zza(zzgk(str), zzaud);
    }

    public final zzebt<InputStream> zzd(zzauj zzauj, int i) {
        zzamo zza = zzr.zzli().zza(this.context, zzbar.zzaau());
        if (!zzadx.zzdgf.get().booleanValue()) {
            return zzebh.immediateFailedFuture(new Exception("Signal collection disabled."));
        }
        zzdhw zza2 = this.zzgsb.zza(zzauj, i);
        zzdhd<JSONObject> zzahv = zza2.zzahv();
        return zza2.zzahw().zza(zzdth.GET_SIGNALS, zzebh.zzag(zzauj.zzdys)).zza(new zzcqi(zzahv)).zzv(zzdth.JS_SIGNALS).zza(zza.zza("google.afma.request.getSignals", zzamn.zzdma, zzamn.zzdmb)).zzayi();
    }

    public final void zzb(zzauj zzauj, zzaud zzaud) {
        zza(zzd(zzauj, Binder.getCallingUid()), zzaud);
    }

    private final void zza(zzebt<InputStream> zzebt, zzaud zzaud) {
        zzebh.zza(zzebh.zzb(zzebt, new zzcql(this), (Executor) zzbat.zzeke), new zzcqn(this, zzaud), zzbat.zzekj);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ InputStream zza(zzebt zzebt, zzebt zzebt2) throws Exception {
        String zzxc = ((zzaup) zzebt.get()).zzxc();
        this.zzgsc.put(zzxc, new zzcqm((zzaup) zzebt.get(), (JSONObject) zzebt2.get()));
        return new ByteArrayInputStream(zzxc.getBytes(zzdxu.UTF_8));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzasn() {
        zzbba.zza(this.zzgsa.zzxe(), "persistFlags");
    }
}
