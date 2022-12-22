package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzp implements Runnable {
    private final /* synthetic */ zzab zzy;
    private final /* synthetic */ zzm zzz;

    zzp(zzm zzm, zzab zzab) {
        this.zzz = zzm;
        this.zzy = zzab;
    }

    public final void run() {
        try {
            this.zzz.zzm.put(this.zzy);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }
}
