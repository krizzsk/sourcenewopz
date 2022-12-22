package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdqt implements zzesa<zzbac> {
    private final zzesn<zzazs> zzhdo;
    private final zzdqo zzhpn;

    private zzdqt(zzdqo zzdqo, zzesn<zzazs> zzesn) {
        this.zzhpn = zzdqo;
        this.zzhdo = zzesn;
    }

    public static zzdqt zzc(zzdqo zzdqo, zzesn<zzazs> zzesn) {
        return new zzdqt(zzdqo, zzesn);
    }

    public final /* synthetic */ Object get() {
        return (zzbac) zzesg.zzbd(this.zzhdo.get().zzyn());
    }
}
