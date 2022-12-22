package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbdo implements zzhx {
    private int zzbir;
    private final zzor zzeqx;
    private long zzeqy;
    private long zzeqz;
    private long zzera;
    private long zzerb;
    private boolean zzerc;

    zzbdo() {
        this(15000, 30000, 2500, 5000);
    }

    private zzbdo(int i, int i2, long j, long j2) {
        this.zzeqx = new zzor(true, 65536);
        this.zzeqy = 15000000;
        this.zzeqz = 30000000;
        this.zzera = 2500000;
        this.zzerb = 5000000;
    }

    public final void zzff() {
        zzl(false);
    }

    public final void zza(zzhy[] zzhyArr, zznu zznu, zzoi zzoi) {
        this.zzbir = 0;
        for (int i = 0; i < zzhyArr.length; i++) {
            if (zzoi.zzbh(i) != null) {
                this.zzbir += zzpt.zzbs(zzhyArr[i].getTrackType());
            }
        }
        this.zzeqx.zzbi(this.zzbir);
    }

    public final void onStopped() {
        zzl(true);
    }

    public final void zzfg() {
        zzl(true);
    }

    public final zzol zzfh() {
        return this.zzeqx;
    }

    public final synchronized boolean zzc(long j, boolean z) {
        boolean z2;
        long j2 = z ? this.zzerb : this.zzera;
        if (j2 <= 0 || j >= j2) {
            z2 = true;
        } else {
            z2 = false;
        }
        return z2;
    }

    public final synchronized boolean zzdt(long j) {
        boolean z;
        char c;
        z = false;
        if (j > this.zzeqz) {
            c = 0;
        } else {
            c = j < this.zzeqy ? (char) 2 : 1;
        }
        boolean z2 = this.zzeqx.zziu() >= this.zzbir;
        if (c == 2 || (c == 1 && this.zzerc && !z2)) {
            z = true;
        }
        this.zzerc = z;
        return z;
    }

    public final synchronized void zzea(int i) {
        this.zzeqy = ((long) i) * 1000;
    }

    public final synchronized void zzeb(int i) {
        this.zzeqz = ((long) i) * 1000;
    }

    public final synchronized void zzds(int i) {
        this.zzera = ((long) i) * 1000;
    }

    public final synchronized void zzdt(int i) {
        this.zzerb = ((long) i) * 1000;
    }

    private final void zzl(boolean z) {
        this.zzbir = 0;
        this.zzerc = false;
        if (z) {
            this.zzeqx.reset();
        }
    }
}
