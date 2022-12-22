package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzcnk implements Runnable {
    private final String zzdkl;
    private final zzcnl zzgpt;

    zzcnk(zzcnl zzcnl, String str) {
        this.zzgpt = zzcnl;
        this.zzdkl = str;
    }

    public final void run() {
        zzcnl zzcnl = this.zzgpt;
        zzcnl.zzgpu.zzgi(this.zzdkl);
    }
}
