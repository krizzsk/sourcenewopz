package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcnz implements zzesa<zzebt<String>> {
    private final zzesn<Context> zzeyq;
    private final zzesn<zzei> zzfuc;
    private final zzesn<zzebs> zzgao;

    private zzcnz(zzesn<zzei> zzesn, zzesn<Context> zzesn2, zzesn<zzebs> zzesn3) {
        this.zzfuc = zzesn;
        this.zzeyq = zzesn2;
        this.zzgao = zzesn3;
    }

    public static zzcnz zzx(zzesn<zzei> zzesn, zzesn<Context> zzesn2, zzesn<zzebs> zzesn3) {
        return new zzcnz(zzesn, zzesn2, zzesn3);
    }

    public final /* synthetic */ Object get() {
        return (zzebt) zzesg.zzbd(this.zzgao.get().zze(new zzcnw(this.zzfuc.get(), this.zzeyq.get())));
    }
}
