package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcas implements zzesa<zzbzl<zzbuj>> {
    private final zzesn<zzcbt> zzfvz;
    private final zzcak zzgdr;

    private zzcas(zzcak zzcak, zzesn<zzcbt> zzesn) {
        this.zzgdr = zzcak;
        this.zzfvz = zzesn;
    }

    public static zzcas zzc(zzcak zzcak, zzesn<zzcbt> zzesn) {
        return new zzcas(zzcak, zzesn);
    }

    public final /* synthetic */ Object get() {
        return (zzbzl) zzesg.zzbd(new zzbzl(this.zzfvz.get(), zzbat.zzeki));
    }
}
