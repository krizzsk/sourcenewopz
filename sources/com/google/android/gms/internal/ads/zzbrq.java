package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzf;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbrq implements zzesa<zzbrr> {
    private final zzesn<Context> zzece;
    private final zzesn<zzf> zzeck;
    private final zzesn<zzcna> zzezu;
    private final zzesn<zzbar> zzfvj;
    private final zzesn<zzdpm> zzfxn;

    private zzbrq(zzesn<Context> zzesn, zzesn<zzdpm> zzesn2, zzesn<zzbar> zzesn3, zzesn<zzf> zzesn4, zzesn<zzcna> zzesn5) {
        this.zzece = zzesn;
        this.zzfxn = zzesn2;
        this.zzfvj = zzesn3;
        this.zzeck = zzesn4;
        this.zzezu = zzesn5;
    }

    public static zzbrq zzb(zzesn<Context> zzesn, zzesn<zzdpm> zzesn2, zzesn<zzbar> zzesn3, zzesn<zzf> zzesn4, zzesn<zzcna> zzesn5) {
        return new zzbrq(zzesn, zzesn2, zzesn3, zzesn4, zzesn5);
    }

    public final /* synthetic */ Object get() {
        return new zzbrr(this.zzece.get(), this.zzfxn.get(), this.zzfvj.get(), this.zzeck.get(), this.zzezu.get());
    }
}
