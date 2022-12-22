package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzbbw implements Runnable {
    private final /* synthetic */ zzbbq zzelq;
    private final /* synthetic */ int zzelu;
    private final /* synthetic */ int zzelv;

    zzbbw(zzbbq zzbbq, int i, int i2) {
        this.zzelq = zzbbq;
        this.zzelu = i;
        this.zzelv = i2;
    }

    public final void run() {
        if (this.zzelq.zzelo != null) {
            this.zzelq.zzelo.zzm(this.zzelu, this.zzelv);
        }
    }
}
