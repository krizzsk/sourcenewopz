package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzbcf implements Runnable {
    private final /* synthetic */ zzbcb zzemr;

    zzbcf(zzbcb zzbcb) {
        this.zzemr = zzbcb;
    }

    public final void run() {
        this.zzemr.zzd("surfaceDestroyed", new String[0]);
    }
}
