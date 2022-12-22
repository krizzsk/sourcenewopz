package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzcnd implements Runnable {
    private final zzcna zzgpl;
    private final zzajt zzgpm;

    zzcnd(zzcna zzcna, zzajt zzajt) {
        this.zzgpl = zzcna;
        this.zzgpm = zzajt;
    }

    public final void run() {
        this.zzgpl.zzc(this.zzgpm);
    }
}
