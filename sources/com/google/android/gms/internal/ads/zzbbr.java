package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzbbr implements Runnable {
    private final /* synthetic */ zzbbq zzelq;

    zzbbr(zzbbq zzbbq) {
        this.zzelq = zzbbq;
    }

    public final void run() {
        if (this.zzelq.zzelo != null) {
            this.zzelq.zzelo.zzabf();
        }
    }
}
