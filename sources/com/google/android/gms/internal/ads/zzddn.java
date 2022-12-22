package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzddn implements zzesa<zzddl> {
    private final zzesn<zzdqm> zzfcs;
    private final zzesn<zzbqr> zzfdm;
    private final zzesn<zzdpm> zzfxn;
    private final zzesn<String> zzhec;
    private final zzesn<String> zzhed;

    private zzddn(zzesn<String> zzesn, zzesn<String> zzesn2, zzesn<zzbqr> zzesn3, zzesn<zzdqm> zzesn4, zzesn<zzdpm> zzesn5) {
        this.zzhec = zzesn;
        this.zzhed = zzesn2;
        this.zzfdm = zzesn3;
        this.zzfcs = zzesn4;
        this.zzfxn = zzesn5;
    }

    public static zzddn zzh(zzesn<String> zzesn, zzesn<String> zzesn2, zzesn<zzbqr> zzesn3, zzesn<zzdqm> zzesn4, zzesn<zzdpm> zzesn5) {
        return new zzddn(zzesn, zzesn2, zzesn3, zzesn4, zzesn5);
    }

    public final /* synthetic */ Object get() {
        return new zzddl(this.zzhec.get(), this.zzhed.get(), this.zzfdm.get(), this.zzfcs.get(), this.zzfxn.get());
    }
}
