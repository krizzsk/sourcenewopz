package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzchq implements zzesa<zzcho> {
    private final zzesn<Context> zzece;
    private final zzesn<zzcen> zzfku;
    private final zzesn<zzcdr> zzgff;
    private final zzesn<zzcdf> zzgld;

    private zzchq(zzesn<Context> zzesn, zzesn<zzcdr> zzesn2, zzesn<zzcen> zzesn3, zzesn<zzcdf> zzesn4) {
        this.zzece = zzesn;
        this.zzgff = zzesn2;
        this.zzfku = zzesn3;
        this.zzgld = zzesn4;
    }

    public static zzchq zzc(zzesn<Context> zzesn, zzesn<zzcdr> zzesn2, zzesn<zzcen> zzesn3, zzesn<zzcdf> zzesn4) {
        return new zzchq(zzesn, zzesn2, zzesn3, zzesn4);
    }

    public final /* synthetic */ Object get() {
        return new zzcho(this.zzece.get(), this.zzgff.get(), this.zzfku.get(), this.zzgld.get());
    }
}
