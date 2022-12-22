package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbro implements zzesa<zzbzl<zzbuj>> {
    private final zzesn<zzbsa> zzeyk;
    private final zzbra zzgad;

    private zzbro(zzbra zzbra, zzesn<zzbsa> zzesn) {
        this.zzgad = zzbra;
        this.zzeyk = zzesn;
    }

    public static zzbro zzb(zzbra zzbra, zzesn<zzbsa> zzesn) {
        return new zzbro(zzbra, zzesn);
    }

    public final /* synthetic */ Object get() {
        return (zzbzl) zzesg.zzbd(new zzbzl(this.zzeyk.get(), zzbat.zzekj));
    }
}
