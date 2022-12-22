package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.overlay.zzp;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzbmm;
import com.google.android.gms.internal.ads.zzbpc;
import com.google.android.gms.internal.ads.zzbsg;
import com.google.android.gms.internal.ads.zzbsj;
import com.google.android.gms.internal.ads.zzbxr;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public abstract class zzdjx<AppOpenAd extends zzbpc, AppOpenRequestComponent extends zzbmm<AppOpenAd>, AppOpenRequestComponentBuilder extends zzbsg<AppOpenRequestComponent>> implements zzdat<AppOpenAd> {
    /* access modifiers changed from: private */
    public final Executor zzfur;
    private final ViewGroup zzfwu;
    private final zzdpo zzhan;
    protected final zzbhh zzhco;
    private final Context zzhik;
    /* access modifiers changed from: private */
    public final zzdkd zzhil;
    /* access modifiers changed from: private */
    public final zzdmh<AppOpenRequestComponent, AppOpenAd> zzhim;
    /* access modifiers changed from: private */
    @Nullable
    public zzebt<AppOpenAd> zzhin;

    protected zzdjx(Context context, Executor executor, zzbhh zzbhh, zzdmh<AppOpenRequestComponent, AppOpenAd> zzdmh, zzdkd zzdkd, zzdpo zzdpo) {
        this.zzhik = context;
        this.zzfur = executor;
        this.zzhco = zzbhh;
        this.zzhim = zzdmh;
        this.zzhil = zzdkd;
        this.zzhan = zzdpo;
        this.zzfwu = new FrameLayout(context);
    }

    /* access modifiers changed from: protected */
    public abstract AppOpenRequestComponentBuilder zza(zzbnd zzbnd, zzbsj zzbsj, zzbxr zzbxr);

    public final boolean isLoading() {
        zzebt<AppOpenAd> zzebt = this.zzhin;
        return zzebt != null && !zzebt.isDone();
    }

    public final synchronized boolean zza(zzvq zzvq, String str, zzdas zzdas, zzdav<? super AppOpenAd> zzdav) throws RemoteException {
        Preconditions.checkMainThread("loadAd must be called on the main UI thread.");
        if (str == null) {
            zzd.zzex("Ad unit ID should not be null for app open ad.");
            this.zzfur.execute(new zzdka(this));
            return false;
        } else if (this.zzhin != null) {
            return false;
        } else {
            zzdqa.zze(this.zzhik, zzvq.zzcid);
            zzdpm zzawg = this.zzhan.zzgt(str).zzg(zzvt.zzqm()).zzh(zzvq).zzawg();
            zzdke zzdke = new zzdke((zzdkc) null);
            zzdke.zzfzg = zzawg;
            zzebt<AppOpenAd> zza = this.zzhim.zza(new zzdmm(zzdke), new zzdjz(this));
            this.zzhin = zza;
            zzebh.zza(zza, new zzdkc(this, zzdav, zzdke), this.zzfur);
            return true;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: zza */
    public final synchronized AppOpenRequestComponentBuilder zzb(zzdmk zzdmk) {
        zzdke zzdke = (zzdke) zzdmk;
        if (((Boolean) zzww.zzra().zzd(zzabq.zzdat)).booleanValue()) {
            return zza(new zzbnd(this.zzfwu), new zzbsj.zza().zzci(this.zzhik).zza(zzdke.zzfzg).zzami(), new zzbxr.zza().zzanf());
        }
        zzdkd zzb = zzdkd.zzb(this.zzhil);
        zzbxr.zza zza = new zzbxr.zza();
        zza.zza((zzbsz) zzb, this.zzfur);
        zza.zza((zzbus) zzb, this.zzfur);
        zza.zza((zzp) zzb, this.zzfur);
        zza.zza((zzbvb) zzb, this.zzfur);
        zza.zza((zzdmi) zzb);
        return zza(new zzbnd(this.zzfwu), new zzbsj.zza().zzci(this.zzhik).zza(zzdke.zzfzg).zzami(), zza.zzanf());
    }

    public final void zza(zzwc zzwc) {
        this.zzhan.zzb(zzwc);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzave() {
        this.zzhil.zzd(zzdqh.zza(zzdqj.INVALID_AD_UNIT_ID, (String) null, (zzvh) null));
    }
}
