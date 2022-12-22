package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.zzds;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzh implements Runnable {
    private final /* synthetic */ boolean zzbpm;
    private final /* synthetic */ zzf zzbpn;

    zzh(zzf zzf, boolean z) {
        this.zzbpn = zzf;
        this.zzbpm = z;
    }

    public final void run() {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            zzds.zza(this.zzbpn.zzbpk.zzbrz, zzf.zze(this.zzbpn.zzbpi), this.zzbpm).zzbu();
        } catch (NullPointerException e) {
            this.zzbpn.zzxh.zza(2027, System.currentTimeMillis() - currentTimeMillis, (Exception) e);
        }
    }
}
