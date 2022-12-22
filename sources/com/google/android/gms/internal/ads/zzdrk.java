package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdrk implements zzdri {
    private final String zzcm;

    public zzdrk(String str) {
        this.zzcm = str;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzdrk)) {
            return false;
        }
        return this.zzcm.equals(((zzdrk) obj).zzcm);
    }

    public final int hashCode() {
        return this.zzcm.hashCode();
    }

    public final String toString() {
        return this.zzcm;
    }
}
