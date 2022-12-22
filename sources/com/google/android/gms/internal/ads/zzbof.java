package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbof implements zzesa<zzcsz<zzbne>> {
    private final zzesn<zzcxw<zzbne, zzdqd, zzcuv>> zzffm;
    private final zzesn<Boolean> zzfpu;
    private final zzesn<zzcwe> zzfpw;

    public zzbof(zzesn<Boolean> zzesn, zzesn<zzcwe> zzesn2, zzesn<zzcxw<zzbne, zzdqd, zzcuv>> zzesn3) {
        this.zzfpu = zzesn;
        this.zzfpw = zzesn2;
        this.zzffm = zzesn3;
    }

    public final /* synthetic */ Object get() {
        boolean booleanValue = this.zzfpu.get().booleanValue();
        zzcsz zzcsz = (zzcwe) this.zzfpw.get();
        zzcsz zzcsz2 = (zzcxw) this.zzffm.get();
        if (!booleanValue) {
            zzcsz = zzcsz2;
        }
        return (zzcsz) zzesg.zzbd(zzcsz);
    }
}
