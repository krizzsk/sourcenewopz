package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdvq;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
final class zzdvt implements zzeni<Integer, zzdvq.zza> {
    zzdvt() {
    }

    public final /* synthetic */ Object convert(Object obj) {
        zzdvq.zza zzep = zzdvq.zza.zzep(((Integer) obj).intValue());
        return zzep == null ? zzdvq.zza.BLOCKED_REASON_UNKNOWN : zzep;
    }
}
