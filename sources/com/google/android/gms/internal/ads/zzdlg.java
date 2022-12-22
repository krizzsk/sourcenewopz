package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzdlg implements Runnable {
    private final zzvh zzhcg;
    private final zzdle zzhjq;

    zzdlg(zzdle zzdle, zzvh zzvh) {
        this.zzhjq = zzdle;
        this.zzhcg = zzvh;
    }

    public final void run() {
        zzdle zzdle = this.zzhjq;
        zzdle.zzhjn.zzhas.zzd(this.zzhcg);
    }
}
