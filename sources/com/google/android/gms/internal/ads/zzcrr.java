package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcrr {
    private int responseCode = 0;
    private long zzgth = 0;
    private long zzgti = 0;
    private long zzgtj = 0;
    private final Object zzgtk = new Object();
    private final Object zzgtl = new Object();
    private final Object zzgtm = new Object();
    private final Object zzgtn = new Object();

    public final void zzei(int i) {
        synchronized (this.zzgtk) {
            this.responseCode = i;
        }
    }

    public final int getResponseCode() {
        int i;
        synchronized (this.zzgtk) {
            i = this.responseCode;
        }
        return i;
    }

    public final void zzeo(long j) {
        synchronized (this.zzgtl) {
            this.zzgth = j;
        }
    }

    public final long zzpa() {
        long j;
        synchronized (this.zzgtl) {
            j = this.zzgth;
        }
        return j;
    }

    public final synchronized void zzff(long j) {
        synchronized (this.zzgtm) {
            this.zzgti = j;
        }
    }

    public final synchronized long zzass() {
        long j;
        synchronized (this.zzgtm) {
            j = this.zzgti;
        }
        return j;
    }

    public final synchronized void zzep(long j) {
        synchronized (this.zzgtn) {
            this.zzgtj = j;
        }
    }

    public final synchronized long zzpb() {
        long j;
        synchronized (this.zzgtn) {
            j = this.zzgtj;
        }
        return j;
    }
}
