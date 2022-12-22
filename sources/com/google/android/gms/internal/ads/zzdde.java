package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdde implements zzesa<zzdcx> {
    private final zzesn<zzckb> zzeyj;
    private final zzesn<zzcna> zzezu;
    private final zzesn<zzdcz> zzfam;
    private final zzesn<zzebs> zzhdg;

    private zzdde(zzesn<zzebs> zzesn, zzesn<zzckb> zzesn2, zzesn<zzcna> zzesn3, zzesn<zzdcz> zzesn4) {
        this.zzhdg = zzesn;
        this.zzeyj = zzesn2;
        this.zzezu = zzesn3;
        this.zzfam = zzesn4;
    }

    public static zzdde zzh(zzesn<zzebs> zzesn, zzesn<zzckb> zzesn2, zzesn<zzcna> zzesn3, zzesn<zzdcz> zzesn4) {
        return new zzdde(zzesn, zzesn2, zzesn3, zzesn4);
    }

    public final /* synthetic */ Object get() {
        return new zzdcx(this.zzhdg.get(), this.zzeyj.get(), this.zzezu.get(), this.zzfam.get());
    }
}
