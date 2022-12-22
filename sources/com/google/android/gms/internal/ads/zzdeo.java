package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdeo implements zzesa<zzdek> {
    private final zzesn<Context> zzece;
    private final zzesn<zzebs> zzeyl;

    private zzdeo(zzesn<Context> zzesn, zzesn<zzebs> zzesn2) {
        this.zzece = zzesn;
        this.zzeyl = zzesn2;
    }

    public static zzdeo zzav(zzesn<Context> zzesn, zzesn<zzebs> zzesn2) {
        return new zzdeo(zzesn, zzesn2);
    }

    public static zzdek zza(Context context, zzebs zzebs) {
        return new zzdek(context, zzebs);
    }

    public final /* synthetic */ Object get() {
        return zza(this.zzece.get(), this.zzeyl.get());
    }
}
