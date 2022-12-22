package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbnu implements zzesa<zzbzl<zzbuj>> {
    private final zzesn<zzbov> zzfvz;
    private final zzbnl zzfxk;

    public zzbnu(zzbnl zzbnl, zzesn<zzbov> zzesn) {
        this.zzfxk = zzbnl;
        this.zzfvz = zzesn;
    }

    public static zzbzl<zzbuj> zza(zzbnl zzbnl, zzbov zzbov) {
        return (zzbzl) zzesg.zzbd(new zzbzl(zzbov, zzbat.zzeki));
    }

    public final /* synthetic */ Object get() {
        return zza(this.zzfxk, this.zzfvz.get());
    }
}
