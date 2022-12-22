package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzr;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcny implements zzesa<zzebt<String>> {
    private final zzesn<Context> zzeyq;
    private final zzesn<zzdtg> zzfxq;

    private zzcny(zzesn<zzdtg> zzesn, zzesn<Context> zzesn2) {
        this.zzfxq = zzesn;
        this.zzeyq = zzesn2;
    }

    public static zzcny zzai(zzesn<zzdtg> zzesn, zzesn<Context> zzesn2) {
        return new zzcny(zzesn, zzesn2);
    }

    public final /* synthetic */ Object get() {
        return (zzebt) zzesg.zzbd(this.zzfxq.get().zzt(zzdth.WEBVIEW_COOKIE).zzc(new zzcnu(zzr.zzkx().zzbi(this.zzeyq.get()))).zza(1, TimeUnit.SECONDS).zza(Exception.class, zzcnx.zzgqm).zzayi());
    }
}
