package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzdtc implements Runnable {
    private final zzdsy zzhtf;
    private final zzdst zzhtg;

    zzdtc(zzdsy zzdsy, zzdst zzdst) {
        this.zzhtf = zzdsy;
        this.zzhtg = zzdst;
    }

    public final void run() {
        zzdsy zzdsy = this.zzhtf;
        zzdsy.zzhta.zzhsv.zzb(this.zzhtg);
    }
}
