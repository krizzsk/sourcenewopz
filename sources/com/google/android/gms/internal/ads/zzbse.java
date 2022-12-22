package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import com.google.android.gms.ads.internal.util.zzf;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbse implements zzesa<zzbsc> {
    private final zzesn<zzf> zzeck;
    private final zzesn<zzdhd<Bundle>> zzfeu;
    private final zzesn<zzbar> zzfvj;
    private final zzesn<zzdtg> zzfxq;
    private final zzesn<ApplicationInfo> zzgav;
    private final zzesn<String> zzgaw;
    private final zzesn<List<String>> zzgax;
    private final zzesn<PackageInfo> zzgay;
    private final zzesn<zzebt<String>> zzgaz;
    private final zzesn<String> zzgba;

    private zzbse(zzesn<zzdtg> zzesn, zzesn<zzbar> zzesn2, zzesn<ApplicationInfo> zzesn3, zzesn<String> zzesn4, zzesn<List<String>> zzesn5, zzesn<PackageInfo> zzesn6, zzesn<zzebt<String>> zzesn7, zzesn<zzf> zzesn8, zzesn<String> zzesn9, zzesn<zzdhd<Bundle>> zzesn10) {
        this.zzfxq = zzesn;
        this.zzfvj = zzesn2;
        this.zzgav = zzesn3;
        this.zzgaw = zzesn4;
        this.zzgax = zzesn5;
        this.zzgay = zzesn6;
        this.zzgaz = zzesn7;
        this.zzeck = zzesn8;
        this.zzgba = zzesn9;
        this.zzfeu = zzesn10;
    }

    public static zzbse zza(zzesn<zzdtg> zzesn, zzesn<zzbar> zzesn2, zzesn<ApplicationInfo> zzesn3, zzesn<String> zzesn4, zzesn<List<String>> zzesn5, zzesn<PackageInfo> zzesn6, zzesn<zzebt<String>> zzesn7, zzesn<zzf> zzesn8, zzesn<String> zzesn9, zzesn<zzdhd<Bundle>> zzesn10) {
        return new zzbse(zzesn, zzesn2, zzesn3, zzesn4, zzesn5, zzesn6, zzesn7, zzesn8, zzesn9, zzesn10);
    }

    public final /* synthetic */ Object get() {
        return new zzbsc(this.zzfxq.get(), this.zzfvj.get(), this.zzgav.get(), this.zzgaw.get(), this.zzgax.get(), this.zzgay.get(), zzesb.zzat(this.zzgaz), this.zzeck.get(), this.zzgba.get(), this.zzfeu.get());
    }
}
