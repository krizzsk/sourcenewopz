package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzj;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzbcu implements Runnable {
    private boolean zzbtm = false;
    private zzbcb zzemt;

    zzbcu(zzbcb zzbcb) {
        this.zzemt = zzbcb;
    }

    public final void run() {
        if (!this.zzbtm) {
            this.zzemt.zzabl();
            zzacj();
        }
    }

    public final void pause() {
        this.zzbtm = true;
        this.zzemt.zzabl();
    }

    public final void resume() {
        this.zzbtm = false;
        zzacj();
    }

    private final void zzacj() {
        zzj.zzegq.removeCallbacks(this);
        zzj.zzegq.postDelayed(this, 250);
    }
}
