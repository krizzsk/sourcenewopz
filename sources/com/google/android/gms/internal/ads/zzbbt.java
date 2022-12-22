package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzbbt implements Runnable {
    private final /* synthetic */ zzbbq zzelq;

    zzbbt(zzbbq zzbbq) {
        this.zzelq = zzbbq;
    }

    public final void run() {
        if (this.zzelq.zzelo != null) {
            this.zzelq.zzelo.zzabd();
        }
    }
}
