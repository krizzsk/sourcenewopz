package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbyp implements zzesa<zzcwk> {
    private final zzesn<zzcwm> zzfcp;
    private final zzesn<zzctc> zzfcq;
    private final zzesn<Clock> zzfvh;
    private final zzbxr zzgdc;

    private zzbyp(zzbxr zzbxr, zzesn<Clock> zzesn, zzesn<zzcwm> zzesn2, zzesn<zzctc> zzesn3) {
        this.zzgdc = zzbxr;
        this.zzfvh = zzesn;
        this.zzfcp = zzesn2;
        this.zzfcq = zzesn3;
    }

    public static zzbyp zza(zzbxr zzbxr, zzesn<Clock> zzesn, zzesn<zzcwm> zzesn2, zzesn<zzctc> zzesn3) {
        return new zzbyp(zzbxr, zzesn, zzesn2, zzesn3);
    }

    public final /* synthetic */ Object get() {
        return (zzcwk) zzesg.zzbd(this.zzgdc.zza(this.zzfvh.get(), this.zzfcp.get(), this.zzfcq.get()));
    }
}
