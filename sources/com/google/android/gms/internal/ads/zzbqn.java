package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbqn implements zzesa<zzbzl<zzbtq>> {
    private final zzbqi zzfzt;
    private final zzesn<zzbqr> zzfzu;

    private zzbqn(zzbqi zzbqi, zzesn<zzbqr> zzesn) {
        this.zzfzt = zzbqi;
        this.zzfzu = zzesn;
    }

    public static zzbqn zzd(zzbqi zzbqi, zzesn<zzbqr> zzesn) {
        return new zzbqn(zzbqi, zzesn);
    }

    public final /* synthetic */ Object get() {
        return (zzbzl) zzesg.zzbd(new zzbzl(this.zzfzu.get(), zzbat.zzekj));
    }
}
