package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzalh implements Runnable {
    private final zzale zzdkv;
    private final zzei zzdkw;
    private final zzalz zzdkx;

    zzalh(zzale zzale, zzei zzei, zzalz zzalz) {
        this.zzdkv = zzale;
        this.zzdkw = zzei;
        this.zzdkx = zzalz;
    }

    public final void run() {
        this.zzdkv.zza(this.zzdkw, this.zzdkx);
    }
}
