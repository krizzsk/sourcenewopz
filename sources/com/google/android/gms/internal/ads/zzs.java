package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzs implements Runnable {
    private final Runnable mRunnable;
    private final zzab zzaf;
    private final zzag zzag;

    public zzs(zzab zzab, zzag zzag2, Runnable runnable) {
        this.zzaf = zzab;
        this.zzag = zzag2;
        this.mRunnable = runnable;
    }

    public final void run() {
        this.zzaf.isCanceled();
        if (this.zzag.isSuccess()) {
            this.zzaf.zza(this.zzag.result);
        } else {
            this.zzaf.zzb(this.zzag.zzbr);
        }
        if (this.zzag.zzbs) {
            this.zzaf.zzc("intermediate-response");
        } else {
            this.zzaf.zzd("done");
        }
        Runnable runnable = this.mRunnable;
        if (runnable != null) {
            runnable.run();
        }
    }
}
