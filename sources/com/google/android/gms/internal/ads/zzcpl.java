package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcpl implements zzesa<zzcpi> {
    private final zzesn<zzayd> zzecg;
    private final zzesn<Context> zzeyq;

    private zzcpl(zzesn<Context> zzesn, zzesn<zzayd> zzesn2) {
        this.zzeyq = zzesn;
        this.zzecg = zzesn2;
    }

    public static zzcpl zzal(zzesn<Context> zzesn, zzesn<zzayd> zzesn2) {
        return new zzcpl(zzesn, zzesn2);
    }

    public final /* synthetic */ Object get() {
        return new zzcpi(this.zzeyq.get(), this.zzecg.get());
    }
}
