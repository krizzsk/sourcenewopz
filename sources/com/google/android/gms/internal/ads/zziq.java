package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zziq implements Runnable {
    private final /* synthetic */ zzik zzajr;
    private final /* synthetic */ int zzajx;

    zziq(zzik zzik, int i) {
        this.zzajr = zzik;
        this.zzajx = i;
    }

    public final void run() {
        this.zzajr.zzajn.zzaa(this.zzajx);
    }
}
