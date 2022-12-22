package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzuh;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzuz implements zzeni<Integer, zzuh.zzc.zza> {
    zzuz() {
    }

    public final /* synthetic */ Object convert(Object obj) {
        zzuh.zzc.zza zzce = zzuh.zzc.zza.zzce(((Integer) obj).intValue());
        return zzce == null ? zzuh.zzc.zza.AD_FORMAT_TYPE_UNSPECIFIED : zzce;
    }
}
