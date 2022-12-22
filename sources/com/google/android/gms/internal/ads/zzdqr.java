package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzf;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdqr implements zzesa<zzf> {
    private final zzesn<zzazs> zzhdo;
    private final zzdqo zzhpn;

    private zzdqr(zzdqo zzdqo, zzesn<zzazs> zzesn) {
        this.zzhpn = zzdqo;
        this.zzhdo = zzesn;
    }

    public static zzdqr zzb(zzdqo zzdqo, zzesn<zzazs> zzesn) {
        return new zzdqr(zzdqo, zzesn);
    }

    public static zzf zza(zzdqo zzdqo, zzazs zzazs) {
        return (zzf) zzesg.zzbd(zzazs.zzyl());
    }

    public final /* synthetic */ Object get() {
        return zza(this.zzhpn, this.zzhdo.get());
    }
}
