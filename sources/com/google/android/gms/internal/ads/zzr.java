package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzr implements zzak {
    private int zzab;
    private int zzac;
    private final int zzad;
    private final float zzae;

    public zzr() {
        this(2500, 1, 1.0f);
    }

    private zzr(int i, int i2, float f) {
        this.zzab = 2500;
        this.zzad = 1;
        this.zzae = 1.0f;
    }

    public final int zzb() {
        return this.zzab;
    }

    public final int zzc() {
        return this.zzac;
    }

    public final void zza(zzap zzap) throws zzap {
        boolean z = true;
        int i = this.zzac + 1;
        this.zzac = i;
        int i2 = this.zzab;
        this.zzab = i2 + ((int) (((float) i2) * this.zzae));
        if (i > this.zzad) {
            z = false;
        }
        if (!z) {
            throw zzap;
        }
    }
}
