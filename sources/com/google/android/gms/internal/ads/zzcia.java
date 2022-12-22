package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzcia implements zzebi<zzbfi> {
    private final /* synthetic */ String zzgln;
    private final /* synthetic */ Map zzglo;

    zzcia(zzchu zzchu, String str, Map map) {
        this.zzgln = str;
        this.zzglo = map;
    }

    public final void zzb(Throwable th) {
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        ((zzbfi) obj).zza(this.zzgln, (Map<String, ?>) this.zzglo);
    }
}
