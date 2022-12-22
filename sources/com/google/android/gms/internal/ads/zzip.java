package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzip implements Runnable {
    private final /* synthetic */ zzik zzajr;
    private final /* synthetic */ zzht zzajw;

    zzip(zzik zzik, zzht zzht) {
        this.zzajr = zzik;
        this.zzajw = zzht;
    }

    public final void run() {
        this.zzajr.zzajn.zzc(this.zzajw);
    }
}
