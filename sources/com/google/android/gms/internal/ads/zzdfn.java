package com.google.android.gms.internal.ads;

import android.content.pm.PackageInfo;
import com.google.android.gms.ads.internal.util.zzf;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdfn implements zzesa<zzdfk> {
    private final zzesn<zzf> zzeck;
    private final zzesn<zzebs> zzeyl;
    private final zzesn<zzdpm> zzfxn;
    private final zzesn<PackageInfo> zzgay;

    public zzdfn(zzesn<zzebs> zzesn, zzesn<zzdpm> zzesn2, zzesn<PackageInfo> zzesn3, zzesn<zzf> zzesn4) {
        this.zzeyl = zzesn;
        this.zzfxn = zzesn2;
        this.zzgay = zzesn3;
        this.zzeck = zzesn4;
    }

    public final /* synthetic */ Object get() {
        return new zzdfk(this.zzeyl.get(), this.zzfxn.get(), this.zzgay.get(), this.zzeck.get());
    }
}
