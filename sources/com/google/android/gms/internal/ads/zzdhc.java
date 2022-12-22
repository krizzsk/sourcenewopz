package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdhc implements zzesa<zzdgv> {
    private final zzesn<Context> zzece;
    private final zzesn<zzebs> zzeyl;

    private zzdhc(zzesn<zzebs> zzesn, zzesn<Context> zzesn2) {
        this.zzeyl = zzesn;
        this.zzece = zzesn2;
    }

    public static zzdhc zzbb(zzesn<zzebs> zzesn, zzesn<Context> zzesn2) {
        return new zzdhc(zzesn, zzesn2);
    }

    public static zzdgv zza(zzebs zzebs, Context context) {
        return new zzdgv(zzebs, context);
    }

    public final /* synthetic */ Object get() {
        return zza(this.zzeyl.get(), this.zzece.get());
    }
}
