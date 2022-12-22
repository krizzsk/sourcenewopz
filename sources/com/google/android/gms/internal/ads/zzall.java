package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzall implements Runnable {
    private final zzale zzdkv;
    private final zzalz zzdky;
    private final zzakv zzdkz;

    zzall(zzale zzale, zzalz zzalz, zzakv zzakv) {
        this.zzdkv = zzale;
        this.zzdky = zzalz;
        this.zzdkz = zzakv;
    }

    public final void run() {
        this.zzdkv.zza(this.zzdky, this.zzdkz);
    }
}
