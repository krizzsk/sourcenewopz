package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzbci implements Runnable {
    private final /* synthetic */ zzbcb zzemr;
    private final /* synthetic */ boolean zzemu;

    zzbci(zzbcb zzbcb, boolean z) {
        this.zzemr = zzbcb;
        this.zzemu = z;
    }

    public final void run() {
        this.zzemr.zzd("windowVisibilityChanged", "isVisible", String.valueOf(this.zzemu));
    }
}
