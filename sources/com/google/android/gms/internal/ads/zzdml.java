package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdml {
    public static zzdmh<zzbmg, zzbmp> zza(Context context, zzdqs zzdqs, zzdrn zzdrn) {
        return zzc(context, zzdqs, zzdrn);
    }

    public static zzdmh<zzbmt, zzbmz> zzb(Context context, zzdqs zzdqs, zzdrn zzdrn) {
        return zzc(context, zzdqs, zzdrn);
    }

    private static <AppOpenAdRequestComponent extends zzbsh<AppOpenAd>, AppOpenAd extends zzbpc> zzdmh<AppOpenAdRequestComponent, AppOpenAd> zzc(Context context, zzdqs zzdqs, zzdrn zzdrn) {
        if (((Integer) zzww.zzra().zzd(zzabq.zzczn)).intValue() <= 0) {
            return new zzdlz();
        }
        zzdrm zza = zzdrn.zza(zzdrf.AppOpen, context, zzdqs, new zzdlp(new zzdlk()));
        return new zzdll(new zzdmc(new zzdlz()), new zzdlu(zza.zzhkm, zzbat.zzeke), zza.zzhrn, zzbat.zzeke);
    }
}
