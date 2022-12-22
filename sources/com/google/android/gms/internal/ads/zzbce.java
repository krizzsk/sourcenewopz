package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzbce implements Runnable {
    private final zzbbz zzemq;

    private zzbce(zzbbz zzbbz) {
        this.zzemq = zzbbz;
    }

    static Runnable zza(zzbbz zzbbz) {
        return new zzbce(zzbbz);
    }

    public final void run() {
        this.zzemq.stop();
    }
}
