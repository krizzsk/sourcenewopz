package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbqz implements zzesa<zzbpf> {
    private final zzesn<zzbts> zzfie;
    private final zzesn<zzbvl> zzfif;
    private final zzesn<zzbui> zzfjn;
    private final zzesn<zzdpi> zzftz;
    private final zzesn<zzdot> zzfxz;
    private final zzesn<zzdmi> zzfzx;
    private final zzesn<zzbsp> zzfzy;

    private zzbqz(zzesn<zzdpi> zzesn, zzesn<zzdot> zzesn2, zzesn<zzbts> zzesn3, zzesn<zzbui> zzesn4, zzesn<zzdmi> zzesn5, zzesn<zzbsp> zzesn6, zzesn<zzbvl> zzesn7) {
        this.zzftz = zzesn;
        this.zzfxz = zzesn2;
        this.zzfie = zzesn3;
        this.zzfjn = zzesn4;
        this.zzfzx = zzesn5;
        this.zzfzy = zzesn6;
        this.zzfif = zzesn7;
    }

    public static zzbqz zza(zzesn<zzdpi> zzesn, zzesn<zzdot> zzesn2, zzesn<zzbts> zzesn3, zzesn<zzbui> zzesn4, zzesn<zzdmi> zzesn5, zzesn<zzbsp> zzesn6, zzesn<zzbvl> zzesn7) {
        return new zzbqz(zzesn, zzesn2, zzesn3, zzesn4, zzesn5, zzesn6, zzesn7);
    }

    public final /* synthetic */ Object get() {
        return new zzbpf(this.zzftz.get(), this.zzfxz.get(), this.zzfie.get(), this.zzfjn.get(), this.zzfzx.get(), this.zzfzy.get(), this.zzfif.get());
    }
}
