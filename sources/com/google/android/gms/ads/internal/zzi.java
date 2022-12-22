package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.zzdwd;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzi implements zzdwd {
    private final /* synthetic */ zzf zzbpn;

    zzi(zzf zzf) {
        this.zzbpn = zzf;
    }

    public final void zza(int i, long j) {
        this.zzbpn.zzxh.zzh(i, System.currentTimeMillis() - j);
    }

    public final void zza(int i, long j, String str) {
        this.zzbpn.zzxh.zzb(i, System.currentTimeMillis() - j, str);
    }
}
