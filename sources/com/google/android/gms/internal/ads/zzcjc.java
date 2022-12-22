package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.ads.internal.zza;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcjc {
    private final zzaxo zzbos;
    private final zzcmb zzdje;
    private final zzdtw zzdjf;
    private final zzcsh zzdji;
    private final zzei zzeus;
    private final zzdup zzftn;
    private final Executor zzfur;
    /* access modifiers changed from: private */
    public final zzbty zzfzc;
    private final zzbur zzgds;
    private final zzbst zzgeq;
    private final zzbli zzger;
    private final zzbzk zzget;
    private final zzbum zzgls;
    private final zzbxe zzglt;
    private final zza zzgmi;
    private final zzbts zzgmj;
    /* access modifiers changed from: private */
    public final zzbwt zzgmk;

    public zzcjc(zzbst zzbst, zzbty zzbty, zzbum zzbum, zzbur zzbur, zzbxe zzbxe, Executor executor, zzbzk zzbzk, zzbli zzbli, zza zza, zzbts zzbts, zzaxo zzaxo, zzei zzei, zzbwt zzbwt, zzcsh zzcsh, zzdup zzdup, zzcmb zzcmb, zzdtw zzdtw) {
        this.zzgeq = zzbst;
        this.zzfzc = zzbty;
        this.zzgls = zzbum;
        this.zzgds = zzbur;
        this.zzglt = zzbxe;
        this.zzfur = executor;
        this.zzget = zzbzk;
        this.zzger = zzbli;
        this.zzgmi = zza;
        this.zzgmj = zzbts;
        this.zzbos = zzaxo;
        this.zzeus = zzei;
        this.zzgmk = zzbwt;
        this.zzdji = zzcsh;
        this.zzftn = zzdup;
        this.zzdje = zzcmb;
        this.zzdjf = zzdtw;
    }

    public final void zza(zzbfi zzbfi, boolean z, zzaii zzaii) {
        zzdy zzcb;
        zzbfi zzbfi2 = zzbfi;
        zzbfi.zzaef().zza(new zzcjf(this), this.zzgls, this.zzgds, new zzcje(this), new zzcjh(this), z, zzaii, this.zzgmi, new zzcjm(this), this.zzbos, this.zzdji, this.zzftn, this.zzdje, this.zzdjf);
        zzbfi2.setOnTouchListener(new zzcjg(this));
        zzbfi2.setOnClickListener(new zzcjj(this));
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcsu)).booleanValue() && (zzcb = this.zzeus.zzcb()) != null) {
            zzcb.zzb(zzbfi.getView());
        }
        this.zzget.zza(zzbfi2, this.zzfur);
        this.zzget.zza(new zzcji(zzbfi2), this.zzfur);
        this.zzget.zzv(zzbfi.getView());
        zzbfi2.zza("/trackActiveViewUnit", (zzaig<? super zzbfi>) new zzcjl(this, zzbfi2));
        this.zzger.zzn(zzbfi2);
        if (!((Boolean) zzww.zzra().zzd(zzabq.zzcpt)).booleanValue()) {
            zzbts zzbts = this.zzgmj;
            zzbfi.getClass();
            zzbts.zza(zzcjk.zzk(zzbfi), this.zzfur);
        }
    }

    public static zzebt<?> zza(zzbfi zzbfi, String str, String str2) {
        zzbbe zzbbe = new zzbbe();
        zzbfi.zzaef().zza((zzbgt) new zzcjn(zzbbe));
        zzbfi.zzb(str, str2, (String) null);
        return zzbbe;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzbfi zzbfi, zzbfi zzbfi2, Map map) {
        this.zzger.zzc(zzbfi);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzae(View view) {
        this.zzgmi.recordClick();
        zzaxo zzaxo = this.zzbos;
        if (zzaxo != null) {
            zzaxo.zzxi();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ boolean zza(View view, MotionEvent motionEvent) {
        this.zzgmi.recordClick();
        zzaxo zzaxo = this.zzbos;
        if (zzaxo == null) {
            return false;
        }
        zzaxo.zzxi();
        return false;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzaqj() {
        this.zzfzc.onAdLeftApplication();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzq(String str, String str2) {
        this.zzglt.onAppEvent(str, str2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzaqk() {
        this.zzgeq.onAdClicked();
    }
}
