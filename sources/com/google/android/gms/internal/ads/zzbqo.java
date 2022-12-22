package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbqo implements zzesa<zzazr> {
    private final zzesn<zzbac> zzfby;
    private final zzesn<Clock> zzfvh;
    private final zzesn<zzdpm> zzfxn;

    private zzbqo(zzesn<Clock> zzesn, zzesn<zzbac> zzesn2, zzesn<zzdpm> zzesn3) {
        this.zzfvh = zzesn;
        this.zzfby = zzesn2;
        this.zzfxn = zzesn3;
    }

    public static zzbqo zzg(zzesn<Clock> zzesn, zzesn<zzbac> zzesn2, zzesn<zzdpm> zzesn3) {
        return new zzbqo(zzesn, zzesn2, zzesn3);
    }

    public final /* synthetic */ Object get() {
        return (zzazr) zzesg.zzbd(this.zzfby.get().zza(this.zzfvh.get(), this.zzfxn.get().zzhny));
    }
}
