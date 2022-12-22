package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.internal.ads.zzbsj;
import com.google.android.gms.internal.ads.zzbxr;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdmr implements zzdat<zzcaj> {
    /* access modifiers changed from: private */
    public final Executor zzfur;
    private final zzdpo zzhan;
    /* access modifiers changed from: private */
    public final zzczm zzhas;
    private final zzbhh zzhco;
    private final Context zzhik;
    private zzacm zzhjj;
    /* access modifiers changed from: private */
    public zzebt<zzcaj> zzhjl;
    /* access modifiers changed from: private */
    public final zzdnb zzhkv;

    public zzdmr(Context context, Executor executor, zzbhh zzbhh, zzczm zzczm, zzdnb zzdnb, zzdpo zzdpo) {
        this.zzhik = context;
        this.zzfur = executor;
        this.zzhco = zzbhh;
        this.zzhas = zzczm;
        this.zzhan = zzdpo;
        this.zzhkv = zzdnb;
    }

    public final boolean isLoading() {
        zzebt<zzcaj> zzebt = this.zzhjl;
        return zzebt != null && !zzebt.isDone();
    }

    public final boolean zza(zzvq zzvq, String str, zzdas zzdas, zzdav<? super zzcaj> zzdav) {
        zzvt zzvt;
        zzcbj zzcbj;
        if (str == null) {
            zzd.zzex("Ad unit ID should not be null for interstitial ad.");
            this.zzfur.execute(new zzdmu(this));
            return false;
        } else if (isLoading()) {
            return false;
        } else {
            if (zzdas instanceof zzdms) {
                zzvt = ((zzdms) zzdas).zzedt;
            } else {
                zzvt = new zzvt();
            }
            zzdpm zzawg = this.zzhan.zzgt(str).zzg(zzvt).zzh(zzvq).zzawg();
            if (((Boolean) zzww.zzra().zzd(zzabq.zzdau)).booleanValue()) {
                zzcbj = this.zzhco.zzagh().zze(new zzbsj.zza().zzci(this.zzhik).zza(zzawg).zzami()).zze(new zzbxr.zza().zza((zzbvm) this.zzhas, this.zzfur).zza((AppEventListener) this.zzhas, this.zzfur).zzanf()).zzb(new zzcyo(this.zzhjj)).zzair();
            } else {
                zzbxr.zza zza = new zzbxr.zza();
                zzdnb zzdnb = this.zzhkv;
                if (zzdnb != null) {
                    zza.zza((zzbsy) zzdnb, this.zzfur).zza((zzbuj) this.zzhkv, this.zzfur).zza((zzbsz) this.zzhkv, this.zzfur);
                }
                zzcbj = this.zzhco.zzagh().zze(new zzbsj.zza().zzci(this.zzhik).zza(zzawg).zzami()).zze(zza.zza((zzbvm) this.zzhas, this.zzfur).zza((zzbsy) this.zzhas, this.zzfur).zza((zzbuj) this.zzhas, this.zzfur).zza((zzbsz) this.zzhas, this.zzfur).zza((zzve) this.zzhas, this.zzfur).zza((AppEventListener) this.zzhas, this.zzfur).zza((zzbvb) this.zzhas, this.zzfur).zza((zzbtm) this.zzhas, this.zzfur).zzanf()).zzb(new zzcyo(this.zzhjj)).zzair();
            }
            zzebt<zzcaj> zzalv = zzcbj.zzahd().zzalv();
            this.zzhjl = zzalv;
            zzebh.zza(zzalv, new zzdmt(this, zzdav, zzcbj), this.zzfur);
            return true;
        }
    }

    public final void zza(zzacm zzacm) {
        this.zzhjj = zzacm;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzavt() {
        this.zzhas.zzd(zzdqh.zza(zzdqj.INVALID_AD_UNIT_ID, (String) null, (zzvh) null));
    }
}
