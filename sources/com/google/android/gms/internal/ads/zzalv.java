package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzalv extends zzbbh<zzamc> {
    private final Object lock = new Object();
    /* access modifiers changed from: private */
    public final zzalz zzdlk;
    private boolean zzdll;

    public zzalv(zzalz zzalz) {
        this.zzdlk = zzalz;
    }

    public final void release() {
        synchronized (this.lock) {
            if (!this.zzdll) {
                this.zzdll = true;
                zza(new zzalu(this), new zzbbf());
                zza(new zzalx(this), new zzalw(this));
            }
        }
    }
}
