package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbqk implements zzesa<zzbzl<zzbsy>> {
    private final zzbqi zzfzt;
    private final zzesn<zzbqr> zzfzu;

    private zzbqk(zzbqi zzbqi, zzesn<zzbqr> zzesn) {
        this.zzfzt = zzbqi;
        this.zzfzu = zzesn;
    }

    public static zzbqk zza(zzbqi zzbqi, zzesn<zzbqr> zzesn) {
        return new zzbqk(zzbqi, zzesn);
    }

    public final /* synthetic */ Object get() {
        return (zzbzl) zzesg.zzbd(new zzbzl(this.zzfzu.get(), zzbat.zzekj));
    }
}
