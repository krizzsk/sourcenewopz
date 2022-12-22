package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdcr implements zzesa<zzdcp> {
    private final zzesn<Context> zzeyq;
    private final zzesn<zzddz<zzdhh>> zzfak;
    private final zzesn<zzdpm> zzfxn;
    private final zzesn<zzazs> zzhdo;

    private zzdcr(zzesn<zzddz<zzdhh>> zzesn, zzesn<zzdpm> zzesn2, zzesn<Context> zzesn3, zzesn<zzazs> zzesn4) {
        this.zzfak = zzesn;
        this.zzfxn = zzesn2;
        this.zzeyq = zzesn3;
        this.zzhdo = zzesn4;
    }

    public static zzdcr zzg(zzesn<zzddz<zzdhh>> zzesn, zzesn<zzdpm> zzesn2, zzesn<Context> zzesn3, zzesn<zzazs> zzesn4) {
        return new zzdcr(zzesn, zzesn2, zzesn3, zzesn4);
    }

    public final /* synthetic */ Object get() {
        return new zzdcp(this.zzfak.get(), this.zzfxn.get(), this.zzeyq.get(), this.zzhdo.get());
    }
}
