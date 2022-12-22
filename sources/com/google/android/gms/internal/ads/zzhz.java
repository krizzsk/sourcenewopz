package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzhz {
    public static final zzhz zzaik = new zzhz(1.0f, 1.0f);
    public final float zzail;
    public final float zzaim;
    private final int zzain;

    public zzhz(float f, float f2) {
        this.zzail = f;
        this.zzaim = f2;
        this.zzain = Math.round(f * 1000.0f);
    }

    public final long zzdu(long j) {
        return j * ((long) this.zzain);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzhz zzhz = (zzhz) obj;
            return this.zzail == zzhz.zzail && this.zzaim == zzhz.zzaim;
        }
    }

    public final int hashCode() {
        return ((Float.floatToRawIntBits(this.zzail) + 527) * 31) + Float.floatToRawIntBits(this.zzaim);
    }
}
