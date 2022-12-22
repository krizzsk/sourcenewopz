package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbpj<AdT> implements zzesa<zzbpg<AdT>> {
    private final zzesn<Map<String, zzcsz<AdT>>> zzfyt;

    private zzbpj(zzesn<Map<String, zzcsz<AdT>>> zzesn) {
        this.zzfyt = zzesn;
    }

    public static <AdT> zzbpj<AdT> zzd(zzesn<Map<String, zzcsz<AdT>>> zzesn) {
        return new zzbpj<>(zzesn);
    }

    public final /* synthetic */ Object get() {
        return new zzbpg(this.zzfyt.get());
    }
}
