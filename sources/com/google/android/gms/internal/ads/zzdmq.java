package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdmq implements zzesa<zzdmh<zzcis, zzcip>> {
    private final zzesn<Context> zzeyq;
    private final zzesn<zzdqs> zzfba;
    private final zzesn<zzdrn> zzfbb;

    public zzdmq(zzesn<Context> zzesn, zzesn<zzdqs> zzesn2, zzesn<zzdrn> zzesn3) {
        this.zzeyq = zzesn;
        this.zzfba = zzesn2;
        this.zzfbb = zzesn3;
    }

    public final /* synthetic */ Object get() {
        Object obj;
        Context context = this.zzeyq.get();
        zzdqs zzdqs = this.zzfba.get();
        zzdrn zzdrn = this.zzfbb.get();
        if (((Integer) zzww.zzra().zzd(zzabq.zzcyz)).intValue() > 0) {
            zzdrm zza = zzdrn.zza(zzdrf.Rewarded, context, zzdqs, new zzdlp(new zzdlk()));
            obj = new zzdll(new zzdmc(new zzdlz()), new zzdlu(zza.zzhkm, zzbat.zzeke), zza.zzhrn, zzbat.zzeke);
        } else {
            obj = new zzdlz();
        }
        return (zzdmh) zzesg.zzbd(obj);
    }
}
