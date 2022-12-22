package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import com.google.android.gms.ads.internal.util.zzf;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbsc {
    private final String packageName;
    private final zzbar zzbpj;
    private final PackageInfo zzdvo;
    private final List<String> zzdvy;
    private final String zzdyt;
    private final zzdtg zzfzh;
    private final ApplicationInfo zzgar;
    private final zzeru<zzebt<String>> zzgas;
    private final zzdhd<Bundle> zzgat;

    public zzbsc(zzdtg zzdtg, zzbar zzbar, ApplicationInfo applicationInfo, String str, List<String> list, PackageInfo packageInfo, zzeru<zzebt<String>> zzeru, zzf zzf, String str2, zzdhd<Bundle> zzdhd) {
        this.zzfzh = zzdtg;
        this.zzbpj = zzbar;
        this.zzgar = applicationInfo;
        this.packageName = str;
        this.zzdvy = list;
        this.zzdvo = packageInfo;
        this.zzgas = zzeru;
        this.zzdyt = str2;
        this.zzgat = zzdhd;
    }

    public final zzebt<Bundle> zzamc() {
        return this.zzfzh.zzt(zzdth.SIGNALS).zze(this.zzgat.zzs(new Bundle())).zzayi();
    }

    public final zzebt<zzauj> zzamd() {
        zzebt<Bundle> zzamc = zzamc();
        return this.zzfzh.zza(zzdth.REQUEST_PARCEL, (zzebt<?>[]) new zzebt[]{zzamc, this.zzgas.get()}).zzb(new zzbsf(this, zzamc)).zzayi();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzauj zzc(zzebt zzebt) throws Exception {
        return new zzauj((Bundle) zzebt.get(), this.zzbpj, this.zzgar, this.packageName, this.zzdvy, this.zzdvo, (String) this.zzgas.get().get(), this.zzdyt, (zzdrc) null, (String) null);
    }
}
