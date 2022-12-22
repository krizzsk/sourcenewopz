package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzdbp implements Runnable {
    private final zzdbf zzhch;
    private final zzchu[] zzhcq;

    zzdbp(zzdbf zzdbf, zzchu[] zzchuArr) {
        this.zzhch = zzdbf;
        this.zzhcq = zzchuArr;
    }

    public final void run() {
        this.zzhch.zza(this.zzhcq);
    }
}
