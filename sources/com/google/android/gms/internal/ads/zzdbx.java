package com.google.android.gms.internal.ads;

import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdbx implements zzesa<zzebt<zzdcb>> {
    private final zzesn<zzdtg> zzfxq;
    private final zzesn<zzdca> zzhcx;
    private final zzesn<zzbsc> zzhcy;

    public zzdbx(zzesn<zzdtg> zzesn, zzesn<zzdca> zzesn2, zzesn<zzbsc> zzesn3) {
        this.zzfxq = zzesn;
        this.zzhcx = zzesn2;
        this.zzhcy = zzesn3;
    }

    public final /* synthetic */ Object get() {
        return (zzebt) zzesg.zzbd(this.zzfxq.get().zza(zzdth.GENERATE_SIGNALS, this.zzhcy.get().zzamd()).zza(this.zzhcx.get()).zza((long) ((Integer) zzww.zzra().zzd(zzabq.zzcxi)).intValue(), TimeUnit.SECONDS).zzayi());
    }
}
