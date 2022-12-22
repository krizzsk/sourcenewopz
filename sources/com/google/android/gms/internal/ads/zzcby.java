package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcby implements zzesa<zzcbz> {
    private final zzesn<zzcdy> zzfxe;
    private final zzesn<Map<String, zzcsz<zzbpi>>> zzfyt;
    private final zzesn<Map<String, zzcsz<zzcdf>>> zzgdz;
    private final zzesn<Map<String, zzcvm<zzcdf>>> zzgea;
    private final zzesn<zzbph<zzbne>> zzgeb;

    public zzcby(zzesn<Map<String, zzcsz<zzbpi>>> zzesn, zzesn<Map<String, zzcsz<zzcdf>>> zzesn2, zzesn<Map<String, zzcvm<zzcdf>>> zzesn3, zzesn<zzbph<zzbne>> zzesn4, zzesn<zzcdy> zzesn5) {
        this.zzfyt = zzesn;
        this.zzgdz = zzesn2;
        this.zzgea = zzesn3;
        this.zzgeb = zzesn4;
        this.zzfxe = zzesn5;
    }

    public final /* synthetic */ Object get() {
        return new zzcbz(this.zzfyt.get(), this.zzgdz.get(), this.zzgea.get(), this.zzgeb, this.zzfxe.get());
    }
}
