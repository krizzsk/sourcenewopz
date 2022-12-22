package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.ViewGroup;
import com.google.android.gms.internal.ads.zzbsj;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcwd extends zzcwf<zzbpi> {
    private final zzccb zzfbj;
    private final zzbxr zzfbo;
    private final zzbhh zzgxu;
    private final zzbsj.zza zzgxv;

    public zzcwd(zzbhh zzbhh, zzccb zzccb, zzbsj.zza zza, zzbxr zzbxr) {
        this.zzgxu = zzbhh;
        this.zzfbj = zzccb;
        this.zzgxv = zza;
        this.zzfbo = zzbxr;
    }

    /* access modifiers changed from: protected */
    public final zzebt<zzbpi> zza(zzdpm zzdpm, Bundle bundle) {
        return this.zzgxu.zzagj().zza(this.zzgxv.zza(zzdpm).zze(bundle).zzami()).zza(this.zzfbo).zza(this.zzfbj).zza(new zzbnd((ViewGroup) null)).zzahf().zzahd().zzalv();
    }
}
