package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.internal.ads.zzbsj;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcwi extends zzcwf<zzcip> {
    private final zzbxr zzfbo;
    private final zzbhh zzgxu;
    private final zzbsj.zza zzgxv;

    public zzcwi(zzbhh zzbhh, zzbsj.zza zza, zzbxr zzbxr) {
        this.zzgxu = zzbhh;
        this.zzgxv = zza;
        this.zzfbo = zzbxr;
    }

    /* access modifiers changed from: protected */
    public final zzebt<zzcip> zza(zzdpm zzdpm, Bundle bundle) {
        return this.zzgxu.zzagk().zzf(this.zzgxv.zza(zzdpm).zze(bundle).zzami()).zzf(this.zzfbo).zzaix().zzahd().zzalv();
    }
}
