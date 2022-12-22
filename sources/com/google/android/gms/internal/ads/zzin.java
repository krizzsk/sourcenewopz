package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzin implements Runnable {
    private final /* synthetic */ zzik zzajr;
    private final /* synthetic */ zzjm zzajs;

    zzin(zzik zzik, zzjm zzjm) {
        this.zzajr = zzik;
        this.zzajs = zzjm;
    }

    public final void run() {
        this.zzajr.zzajn.zzc(this.zzajs);
    }
}
