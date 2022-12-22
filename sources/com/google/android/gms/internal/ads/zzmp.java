package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzmp implements zznq {
    private final zznq[] zzbdu;

    public zzmp(zznq[] zznqArr) {
        this.zzbdu = zznqArr;
    }

    public final long zzhr() {
        long j = Long.MAX_VALUE;
        for (zznq zzhr : this.zzbdu) {
            long zzhr2 = zzhr.zzhr();
            if (zzhr2 != Long.MIN_VALUE) {
                j = Math.min(j, zzhr2);
            }
        }
        if (j == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j;
    }

    public final boolean zzee(long j) {
        boolean z;
        boolean z2 = false;
        do {
            long zzhr = zzhr();
            if (zzhr == Long.MIN_VALUE) {
                break;
            }
            z = false;
            for (zznq zznq : this.zzbdu) {
                if (zznq.zzhr() == zzhr) {
                    z |= zznq.zzee(j);
                }
            }
            z2 |= z;
        } while (z);
        return z2;
    }
}
