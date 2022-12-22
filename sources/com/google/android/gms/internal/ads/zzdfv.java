package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdfv implements zzesa<zzdfw> {
    private final zzesn<PackageInfo> zzgay;
    private final zzesn<ApplicationInfo> zzgqp;

    private zzdfv(zzesn<ApplicationInfo> zzesn, zzesn<PackageInfo> zzesn2) {
        this.zzgqp = zzesn;
        this.zzgay = zzesn2;
    }

    public static zzdfv zzay(zzesn<ApplicationInfo> zzesn, zzesn<PackageInfo> zzesn2) {
        return new zzdfv(zzesn, zzesn2);
    }

    public static zzdfw zza(ApplicationInfo applicationInfo, PackageInfo packageInfo) {
        return new zzdfw(applicationInfo, packageInfo);
    }

    public final /* synthetic */ Object get() {
        return zza(this.zzgqp.get(), this.zzgay.get());
    }
}
