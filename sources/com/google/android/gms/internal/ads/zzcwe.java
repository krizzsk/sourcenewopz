package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.ViewGroup;
import com.google.android.gms.internal.ads.zzbsj;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcwe extends zzcwf<zzbne> {
    private final zzccb zzfbj;
    private final zzbxr zzfbo;
    private final zzcyo zzfon;
    private final ViewGroup zzfwu;
    private final zzbve zzfyj;
    private final zzbhh zzgxu;
    private final zzbsj.zza zzgxv;

    public zzcwe(zzbhh zzbhh, zzbsj.zza zza, zzcyo zzcyo, zzbxr zzbxr, zzccb zzccb, zzbve zzbve, ViewGroup viewGroup) {
        this.zzgxu = zzbhh;
        this.zzgxv = zza;
        this.zzfon = zzcyo;
        this.zzfbo = zzbxr;
        this.zzfbj = zzccb;
        this.zzfyj = zzbve;
        this.zzfwu = viewGroup;
    }

    /* access modifiers changed from: protected */
    public final zzebt<zzbne> zza(zzdpm zzdpm, Bundle bundle) {
        return this.zzgxu.zzagc().zzd(this.zzgxv.zza(zzdpm).zze(bundle).zzami()).zzd(this.zzfbo).zza(this.zzfon).zzb(this.zzfbj).zza(new zzboz(this.zzfyj)).zzd(new zzbnd(this.zzfwu)).zzaie().zzahd().zzalv();
    }
}
