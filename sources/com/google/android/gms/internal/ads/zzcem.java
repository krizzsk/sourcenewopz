package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzcem implements Runnable {
    private final zzcfl zzggf;
    private final zzcen zzgih;

    zzcem(zzcen zzcen, zzcfl zzcfl) {
        this.zzgih = zzcen;
        this.zzggf = zzcfl;
    }

    public final void run() {
        this.zzgih.zzi(this.zzggf);
    }
}
