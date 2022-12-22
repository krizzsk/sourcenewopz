package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzcuq implements Runnable {
    private final zzdot zzfxi;
    private final zzdpi zzgjy;
    private final zzcuo zzgwx;

    zzcuq(zzcuo zzcuo, zzdpi zzdpi, zzdot zzdot) {
        this.zzgwx = zzcuo;
        this.zzgjy = zzdpi;
        this.zzfxi = zzdot;
    }

    public final void run() {
        this.zzgwx.zzd(this.zzgjy, this.zzfxi);
    }
}
