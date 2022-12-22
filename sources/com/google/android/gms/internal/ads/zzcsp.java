package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcsp implements zzesa<zzcsh> {
    private final zzesn<Context> zzeyq;
    private final zzesn<zzebs> zzgtb;

    public zzcsp(zzesn<Context> zzesn, zzesn<zzebs> zzesn2) {
        this.zzeyq = zzesn;
        this.zzgtb = zzesn2;
    }

    public final /* synthetic */ Object get() {
        return new zzcsh(this.zzeyq.get(), this.zzgtb.get());
    }
}
