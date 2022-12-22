package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzddi implements zzesa<zzddg> {
    private final zzesn<zzebs> zzeyl;
    private final zzesn<zzdpm> zzfxn;
    private final zzesn<zzbar> zzgbl;

    private zzddi(zzesn<zzebs> zzesn, zzesn<zzdpm> zzesn2, zzesn<zzbar> zzesn3) {
        this.zzeyl = zzesn;
        this.zzfxn = zzesn2;
        this.zzgbl = zzesn3;
    }

    public static zzddi zzz(zzesn<zzebs> zzesn, zzesn<zzdpm> zzesn2, zzesn<zzbar> zzesn3) {
        return new zzddi(zzesn, zzesn2, zzesn3);
    }

    public final /* synthetic */ Object get() {
        return new zzddg(this.zzeyl.get(), this.zzfxn.get(), this.zzgbl.get());
    }
}
