package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbsk implements zzesa<Context> {
    private final zzesn<Context> zzece;
    private final zzbsj zzgbg;

    private zzbsk(zzbsj zzbsj, zzesn<Context> zzesn) {
        this.zzgbg = zzbsj;
        this.zzece = zzesn;
    }

    public static zzbsk zza(zzbsj zzbsj, zzesn<Context> zzesn) {
        return new zzbsk(zzbsj, zzesn);
    }

    public final /* synthetic */ Object get() {
        return (Context) zzesg.zzbd(this.zzgbg.zzch(this.zzece.get()));
    }
}
