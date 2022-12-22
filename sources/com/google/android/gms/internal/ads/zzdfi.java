package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdfi implements zzesa<zzdfg> {
    private final zzesn<zzebs> zzeyl;
    private final zzesn<zzdor> zzgww;

    private zzdfi(zzesn<zzebs> zzesn, zzesn<zzdor> zzesn2) {
        this.zzeyl = zzesn;
        this.zzgww = zzesn2;
    }

    public static zzdfi zzax(zzesn<zzebs> zzesn, zzesn<zzdor> zzesn2) {
        return new zzdfi(zzesn, zzesn2);
    }

    public final /* synthetic */ Object get() {
        return new zzdfg(this.zzeyl.get(), this.zzgww.get());
    }
}
