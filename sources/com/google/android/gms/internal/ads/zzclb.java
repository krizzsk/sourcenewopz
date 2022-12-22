package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzclb implements zzesa<zzcku> {
    private final zzesn<zzdmp> zzfcu;
    private final zzesn<zztz> zzgma;

    private zzclb(zzesn<zztz> zzesn, zzesn<zzdmp> zzesn2) {
        this.zzgma = zzesn;
        this.zzfcu = zzesn2;
    }

    public static zzclb zzad(zzesn<zztz> zzesn, zzesn<zzdmp> zzesn2) {
        return new zzclb(zzesn, zzesn2);
    }

    public final /* synthetic */ Object get() {
        return new zzcku(this.zzgma.get(), this.zzfcu.get());
    }
}
