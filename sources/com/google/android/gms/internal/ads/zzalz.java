package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzar;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzalz extends zzbbh<zzakv> {
    private final Object lock = new Object();
    /* access modifiers changed from: private */
    public zzar<zzakv> zzdkt;
    private boolean zzdlo;
    private int zzdlp;

    public zzalz(zzar<zzakv> zzar) {
        this.zzdkt = zzar;
        this.zzdlo = false;
        this.zzdlp = 0;
    }

    public final zzalv zzuw() {
        zzalv zzalv = new zzalv(this);
        synchronized (this.lock) {
            zza(new zzaly(this, zzalv), new zzamb(this, zzalv));
            Preconditions.checkState(this.zzdlp >= 0);
            this.zzdlp++;
        }
        return zzalv;
    }

    /* access modifiers changed from: protected */
    public final void zzux() {
        synchronized (this.lock) {
            Preconditions.checkState(this.zzdlp > 0);
            zzd.zzed("Releasing 1 reference for JS Engine");
            this.zzdlp--;
            zzuz();
        }
    }

    public final void zzuy() {
        synchronized (this.lock) {
            Preconditions.checkState(this.zzdlp >= 0);
            zzd.zzed("Releasing root reference. JS Engine will be destroyed once other references are released.");
            this.zzdlo = true;
            zzuz();
        }
    }

    private final void zzuz() {
        synchronized (this.lock) {
            Preconditions.checkState(this.zzdlp >= 0);
            if (!this.zzdlo || this.zzdlp != 0) {
                zzd.zzed("There are still references to the engine. Not destroying.");
            } else {
                zzd.zzed("No reference is left (including root). Cleaning up engine.");
                zza(new zzama(this), new zzbbf());
            }
        }
    }
}
