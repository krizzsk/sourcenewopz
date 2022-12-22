package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzcxr implements Runnable {
    private final zzdot zzfxi;
    private final zzdpi zzgjy;
    private final zzcxo zzgyx;
    private final zzctb zzgyy;

    zzcxr(zzcxo zzcxo, zzdpi zzdpi, zzdot zzdot, zzctb zzctb) {
        this.zzgyx = zzcxo;
        this.zzgjy = zzdpi;
        this.zzfxi = zzdot;
        this.zzgyy = zzctb;
    }

    public final void run() {
        zzcxo zzcxo = this.zzgyx;
        zzcxm.zzc(this.zzgjy, this.zzfxi, this.zzgyy);
    }
}
