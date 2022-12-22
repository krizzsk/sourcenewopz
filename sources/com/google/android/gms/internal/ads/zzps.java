package com.google.android.gms.internal.ads;

import android.os.SystemClock;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzps implements zzpk {
    private boolean started;
    private zzhz zzafp = zzhz.zzaik;
    private long zzbkv;
    private long zzbkw;

    public final void start() {
        if (!this.started) {
            this.zzbkw = SystemClock.elapsedRealtime();
            this.started = true;
        }
    }

    public final void stop() {
        if (this.started) {
            zzel(zzgg());
            this.started = false;
        }
    }

    public final void zzel(long j) {
        this.zzbkv = j;
        if (this.started) {
            this.zzbkw = SystemClock.elapsedRealtime();
        }
    }

    public final void zza(zzpk zzpk) {
        zzel(zzpk.zzgg());
        this.zzafp = zzpk.zzfw();
    }

    public final long zzgg() {
        long j;
        long j2 = this.zzbkv;
        if (!this.started) {
            return j2;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.zzbkw;
        if (this.zzafp.zzail == 1.0f) {
            j = zzhf.zzdp(elapsedRealtime);
        } else {
            j = this.zzafp.zzdu(elapsedRealtime);
        }
        return j2 + j;
    }

    public final zzhz zzb(zzhz zzhz) {
        if (this.started) {
            zzel(zzgg());
        }
        this.zzafp = zzhz;
        return zzhz;
    }

    public final zzhz zzfw() {
        return this.zzafp;
    }
}
