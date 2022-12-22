package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdeg implements zzesa<zzdee> {
    private final zzesn<zzebs> zzeyl;
    private final zzesn<String> zzfvk;
    private final zzesn<zzdpm> zzfxn;
    private final zzesn<zzckd> zzhet;

    private zzdeg(zzesn<zzebs> zzesn, zzesn<zzckd> zzesn2, zzesn<zzdpm> zzesn3, zzesn<String> zzesn4) {
        this.zzeyl = zzesn;
        this.zzhet = zzesn2;
        this.zzfxn = zzesn3;
        this.zzfvk = zzesn4;
    }

    public static zzdeg zzi(zzesn<zzebs> zzesn, zzesn<zzckd> zzesn2, zzesn<zzdpm> zzesn3, zzesn<String> zzesn4) {
        return new zzdeg(zzesn, zzesn2, zzesn3, zzesn4);
    }

    public final /* synthetic */ Object get() {
        return new zzdee(this.zzeyl.get(), this.zzhet.get(), this.zzfxn.get(), this.zzfvk.get());
    }
}
