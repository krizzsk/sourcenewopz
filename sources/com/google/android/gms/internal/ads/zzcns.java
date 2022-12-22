package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcns implements zzesa<zzcno> {
    private final zzesn<zzebs> zzeyl;
    private final zzesn<zzebs> zzgqh;
    private final zzesn<zzcoz> zzgqi;
    private final zzesn<zzcqb> zzgqj;

    private zzcns(zzesn<zzebs> zzesn, zzesn<zzebs> zzesn2, zzesn<zzcoz> zzesn3, zzesn<zzcqb> zzesn4) {
        this.zzgqh = zzesn;
        this.zzeyl = zzesn2;
        this.zzgqi = zzesn3;
        this.zzgqj = zzesn4;
    }

    public static zzcns zzd(zzesn<zzebs> zzesn, zzesn<zzebs> zzesn2, zzesn<zzcoz> zzesn3, zzesn<zzcqb> zzesn4) {
        return new zzcns(zzesn, zzesn2, zzesn3, zzesn4);
    }

    public final /* synthetic */ Object get() {
        return new zzcno(this.zzgqh.get(), this.zzeyl.get(), this.zzgqi.get(), zzesb.zzat(this.zzgqj));
    }
}
