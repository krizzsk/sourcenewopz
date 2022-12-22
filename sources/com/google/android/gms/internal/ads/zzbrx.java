package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbrx implements zzbsy, zzbtm, zzbxb, zzbza {
    private final Executor executor;
    /* access modifiers changed from: private */
    public final zzbtl zzgah;
    private final zzdot zzgai;
    private final ScheduledExecutorService zzgaj;
    private zzecb<Boolean> zzgak = zzecb.zzbbf();
    private ScheduledFuture<?> zzgal;

    public zzbrx(zzbtl zzbtl, zzdot zzdot, ScheduledExecutorService scheduledExecutorService, Executor executor2) {
        this.zzgah = zzbtl;
        this.zzgai = zzdot;
        this.zzgaj = scheduledExecutorService;
        this.executor = executor2;
    }

    public final void onAdClosed() {
    }

    public final void onAdLeftApplication() {
    }

    public final void onRewardedVideoCompleted() {
    }

    public final void onRewardedVideoStarted() {
    }

    public final void zzalz() {
    }

    public final void zzama() {
    }

    public final void zzb(zzavd zzavd, String str, String str2) {
    }

    public final void onAdOpened() {
        if (this.zzgai.zzhmt == 0 || this.zzgai.zzhmt == 1) {
            this.zzgah.onAdImpression();
        }
    }

    public final void zzalx() {
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcrt)).booleanValue() && this.zzgai.zzhmt == 2) {
            if (this.zzgai.zzhmf == 0) {
                this.zzgah.onAdImpression();
                return;
            }
            zzebh.zza(this.zzgak, new zzbrz(this), this.executor);
            this.zzgal = this.zzgaj.schedule(new zzbrw(this), (long) this.zzgai.zzhmf, TimeUnit.MILLISECONDS);
        }
    }

    public final synchronized void zzk(zzvh zzvh) {
        if (!this.zzgak.isDone()) {
            if (this.zzgal != null) {
                this.zzgal.cancel(true);
            }
            this.zzgak.setException(new Exception());
        }
    }

    public final synchronized void zzaly() {
        if (!this.zzgak.isDone()) {
            if (this.zzgal != null) {
                this.zzgal.cancel(true);
            }
            this.zzgak.set(true);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzamb() {
        synchronized (this) {
            if (!this.zzgak.isDone()) {
                this.zzgak.set(true);
            }
        }
    }
}
