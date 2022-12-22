package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.ads.internal.zzg;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcyg implements zzg {
    private final zzbzp zzfwy;
    private final zzbtl zzgep;
    private final zzbst zzgeq;
    private final zzbli zzger;
    private final zzbzk zzget;
    private AtomicBoolean zzgzp = new AtomicBoolean(false);

    zzcyg(zzbst zzbst, zzbtl zzbtl, zzbzp zzbzp, zzbzk zzbzk, zzbli zzbli) {
        this.zzgeq = zzbst;
        this.zzgep = zzbtl;
        this.zzfwy = zzbzp;
        this.zzget = zzbzk;
        this.zzger = zzbli;
    }

    public final synchronized void zzh(View view) {
        if (this.zzgzp.compareAndSet(false, true)) {
            this.zzger.onAdImpression();
            this.zzget.zzv(view);
        }
    }

    public final void zzkg() {
        if (this.zzgzp.get()) {
            this.zzgeq.onAdClicked();
        }
    }

    public final void zzkh() {
        if (this.zzgzp.get()) {
            this.zzgep.onAdImpression();
            this.zzfwy.zzanl();
        }
    }
}
