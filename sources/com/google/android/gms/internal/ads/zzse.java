package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzse {
    final long value;
    final int zzbuo;
    final String zzbuv;

    zzse(long j, String str, int i) {
        this.value = j;
        this.zzbuv = str;
        this.zzbuo = i;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof zzse)) {
            zzse zzse = (zzse) obj;
            if (zzse.value == this.value && zzse.zzbuo == this.zzbuo) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        return (int) this.value;
    }
}
