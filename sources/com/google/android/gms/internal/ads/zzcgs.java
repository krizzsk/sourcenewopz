package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzr;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcgs {
    private final Executor zzfur;
    private final zzdpm zzfzg;
    private final zzcja zzgix;

    public zzcgs(zzdpm zzdpm, Executor executor, zzcja zzcja) {
        this.zzfzg = zzdpm;
        this.zzfur = executor;
        this.zzgix = zzcja;
    }

    public final zzebt<zzbfi> zzo(JSONObject jSONObject) {
        return zzebh.zzb(zzebh.zzb(zzebh.zzag(null), new zzcgx(this), this.zzfur), new zzcgv(this, jSONObject), this.zzfur);
    }

    public final zzebt<zzbfi> zzp(String str, String str2) {
        return zzebh.zzb(zzebh.zzag(null), new zzcgu(this, str, str2), this.zzfur);
    }

    private final void zzh(zzbfi zzbfi) {
        zzbfi.zza("/video", (zzaig<? super zzbfi>) zzahr.zzdis);
        zzbfi.zza("/videoMeta", (zzaig<? super zzbfi>) zzahr.zzdit);
        zzbfi.zza("/precache", (zzaig<? super zzbfi>) new zzbep());
        zzbfi.zza("/delayPageLoaded", (zzaig<? super zzbfi>) zzahr.zzdiw);
        zzbfi.zza("/instrument", (zzaig<? super zzbfi>) zzahr.zzdiu);
        zzbfi.zza("/log", (zzaig<? super zzbfi>) zzahr.zzdin);
        zzbfi.zza("/videoClicked", (zzaig<? super zzbfi>) zzahr.zzdio);
        zzbfi.zzaef().zzbc(true);
        zzbfi.zza("/click", (zzaig<? super zzbfi>) zzahr.zzdij);
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcts)).booleanValue()) {
            zzbfi.zza("/getNativeAdViewSignals", (zzaig<? super zzbfi>) zzahr.zzdiz);
        }
        if (this.zzfzg.zzdxd != null) {
            zzbfi.zzaef().zzbd(true);
            zzbfi.zza("/open", (zzaig<? super zzbfi>) new zzaio((zza) null, (zzaqz) null, (zzcsh) null, (zzcmb) null, (zzdtw) null));
        } else {
            zzbfi.zzaef().zzbd(false);
        }
        if (zzr.zzlt().zzaa(zzbfi.getContext())) {
            zzbfi.zza("/logScionEvent", (zzaig<? super zzbfi>) new zzaim(zzbfi.getContext()));
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzebt zzq(Object obj) throws Exception {
        zzbfi zza = this.zzgix.zza(zzvt.zzqk(), (zzdot) null, (zzdoy) null);
        zzbbb zzk = zzbbb.zzk(zza);
        zzh(zza);
        zza.zzaef().zza((zzbgw) new zzcgw(zzk));
        zza.loadUrl((String) zzww.zzra().zzd(zzabq.zzctr));
        return zzk;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzebt zza(String str, String str2, Object obj) throws Exception {
        zzbfi zza = this.zzgix.zza(zzvt.zzqk(), (zzdot) null, (zzdoy) null);
        zzbbb zzk = zzbbb.zzk(zza);
        zzh(zza);
        if (this.zzfzg.zzdxd != null) {
            zza.zza(zzbgx.zzafi());
        } else {
            zza.zza(zzbgx.zzafh());
        }
        zza.zzaef().zza((zzbgt) new zzcgz(this, zza, zzk));
        zza.zzb(str, str2, (String) null);
        return zzk;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzbfi zzbfi, zzbbb zzbbb, boolean z) {
        if (z) {
            if (!(this.zzfzg.zzhnw == null || zzbfi.zzabv() == null)) {
                zzbfi.zzabv().zzb(this.zzfzg.zzhnw);
            }
            zzbbb.zzaav();
            return;
        }
        zzbbb.setException(new zzcwo(zzdqj.INTERNAL_ERROR, "Instream video Web View failed to load."));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzebt zza(JSONObject jSONObject, zzbfi zzbfi) throws Exception {
        zzbbb zzk = zzbbb.zzk(zzbfi);
        if (this.zzfzg.zzdxd != null) {
            zzbfi.zza(zzbgx.zzafi());
        } else {
            zzbfi.zza(zzbgx.zzafh());
        }
        zzbfi.zzaef().zza((zzbgt) new zzcgy(this, zzbfi, zzk));
        zzbfi.zzb("google.afma.nativeAds.renderVideo", jSONObject);
        return zzk;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(zzbfi zzbfi, zzbbb zzbbb, boolean z) {
        if (!(this.zzfzg.zzhnw == null || zzbfi.zzabv() == null)) {
            zzbfi.zzabv().zzb(this.zzfzg.zzhnw);
        }
        zzbbb.zzaav();
    }
}
