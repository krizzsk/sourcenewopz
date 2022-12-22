package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzmt implements Runnable {
    private final /* synthetic */ zzms zzbdv;
    private final /* synthetic */ zzmy zzbew;

    zzmt(zzms zzms, zzmy zzmy) {
        this.zzbdv = zzms;
        this.zzbew = zzmy;
    }

    public final void run() {
        this.zzbew.release();
        int size = this.zzbdv.zzbeh.size();
        for (int i = 0; i < size; i++) {
            ((zznm) this.zzbdv.zzbeh.valueAt(i)).disable();
        }
    }
}
