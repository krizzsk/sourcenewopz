package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.internal.ads.zzbsj;
import com.google.android.gms.internal.ads.zzbxr;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdnz implements zzdat<zzcip> {
    /* access modifiers changed from: private */
    public final Executor zzfur;
    private final zzdph zzgbf;
    private final zzdpo zzhan;
    private final zzbhh zzhco;
    private final Context zzhik;
    /* access modifiers changed from: private */
    public final zzdmh<zzcis, zzcip> zzhim;
    private zzebt<zzcip> zzhjl;
    /* access modifiers changed from: private */
    public final zzdnb zzhlj;

    public zzdnz(Context context, Executor executor, zzbhh zzbhh, zzdmh<zzcis, zzcip> zzdmh, zzdnb zzdnb, zzdpo zzdpo, zzdph zzdph) {
        this.zzhik = context;
        this.zzfur = executor;
        this.zzhco = zzbhh;
        this.zzhim = zzdmh;
        this.zzhlj = zzdnb;
        this.zzhan = zzdpo;
        this.zzgbf = zzdph;
    }

    public final boolean isLoading() {
        zzebt<zzcip> zzebt = this.zzhjl;
        return zzebt != null && !zzebt.isDone();
    }

    public final boolean zza(zzvq zzvq, String str, zzdas zzdas, zzdav<? super zzcip> zzdav) throws RemoteException {
        zzavt zzavt = new zzavt(zzvq, str);
        if (zzdas instanceof zzdoa) {
            zzdoa zzdoa = (zzdoa) zzdas;
        }
        if (zzavt.zzbvf == null) {
            zzd.zzex("Ad unit ID should not be null for rewarded video ad.");
            this.zzfur.execute(new zzdoc(this));
            return false;
        }
        zzebt<zzcip> zzebt = this.zzhjl;
        if (zzebt != null && !zzebt.isDone()) {
            return false;
        }
        zzdqa.zze(this.zzhik, zzavt.zzdvn.zzcid);
        zzdpm zzawg = this.zzhan.zzgt(zzavt.zzbvf).zzg(zzvt.zzql()).zzh(zzavt.zzdvn).zzawg();
        zzdof zzdof = new zzdof((zzdoe) null);
        zzdof.zzfzg = zzawg;
        zzdof.zzhlk = null;
        zzebt<zzcip> zza = this.zzhim.zza(new zzdmm(zzdof), new zzdob(this));
        this.zzhjl = zza;
        zzebh.zza(zza, new zzdoe(this, zzdav, zzdof), this.zzfur);
        return true;
    }

    /* access modifiers changed from: package-private */
    public final void zzek(int i) {
        this.zzhan.zzawf().zzel(i);
    }

    /* access modifiers changed from: private */
    /* renamed from: zzd */
    public final zzciv zze(zzdmk zzdmk) {
        zzdof zzdof = (zzdof) zzdmk;
        return this.zzhco.zzagk().zzf(new zzbsj.zza().zzci(this.zzhik).zza(zzdof.zzfzg).zzft(zzdof.zzhlk).zza(this.zzgbf).zzami()).zzf(new zzbxr.zza().zzanf());
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzavu() {
        this.zzhlj.zzd(zzdqh.zza(zzdqj.INVALID_AD_UNIT_ID, (String) null, (zzvh) null));
    }
}
