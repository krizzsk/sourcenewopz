package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdqn implements zzesa<zzbzl<zzbsz>> {
    private final zzesn<zzdqm> zzfzu;
    private final zzdqk zzhpm;

    private zzdqn(zzdqk zzdqk, zzesn<zzdqm> zzesn) {
        this.zzhpm = zzdqk;
        this.zzfzu = zzesn;
    }

    public static zzdqn zza(zzdqk zzdqk, zzesn<zzdqm> zzesn) {
        return new zzdqn(zzdqk, zzesn);
    }

    public final /* synthetic */ Object get() {
        return (zzbzl) zzesg.zzbd(new zzbzl(this.zzfzu.get(), zzbat.zzekj));
    }
}
