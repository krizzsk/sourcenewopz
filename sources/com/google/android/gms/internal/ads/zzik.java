package com.google.android.gms.internal.ads;

import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzik {
    private final Handler handler;
    /* access modifiers changed from: private */
    public final zzil zzajn;

    public zzik(Handler handler2, zzil zzil) {
        this.handler = zzil != null ? (Handler) zzpg.checkNotNull(handler2) : null;
        this.zzajn = zzil;
    }

    public final void zza(zzjm zzjm) {
        if (this.zzajn != null) {
            this.handler.post(new zzin(this, zzjm));
        }
    }

    public final void zza(String str, long j, long j2) {
        if (this.zzajn != null) {
            this.handler.post(new zzim(this, str, j, j2));
        }
    }

    public final void zzb(zzht zzht) {
        if (this.zzajn != null) {
            this.handler.post(new zzip(this, zzht));
        }
    }

    public final void zza(int i, long j, long j2) {
        if (this.zzajn != null) {
            this.handler.post(new zzio(this, i, j, j2));
        }
    }

    public final void zzb(zzjm zzjm) {
        if (this.zzajn != null) {
            this.handler.post(new zzir(this, zzjm));
        }
    }

    public final void zzz(int i) {
        if (this.zzajn != null) {
            this.handler.post(new zziq(this, i));
        }
    }
}
