package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdei implements zzesa<zzddz<zzdhh>> {
    private final zzesn<zzdhk> zzfak;
    private final zzesn<Clock> zzfvh;

    public zzdei(zzesn<zzdhk> zzesn, zzesn<Clock> zzesn2) {
        this.zzfak = zzesn;
        this.zzfvh = zzesn2;
    }

    public final /* synthetic */ Object get() {
        return (zzddz) zzesg.zzbd(new zzddz(this.zzfak.get(), zzadf.zzdea.get().longValue(), this.zzfvh.get()));
    }
}
