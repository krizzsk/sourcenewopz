package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzad;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbru implements zzesa<zzdxw<zzdot, zzad>> {
    private final zzesn<Context> zzeyq;
    private final zzesn<zzbar> zzfsw;
    private final zzesn<zzdpm> zzfxn;

    public zzbru(zzesn<Context> zzesn, zzesn<zzbar> zzesn2, zzesn<zzdpm> zzesn3) {
        this.zzeyq = zzesn;
        this.zzfsw = zzesn2;
        this.zzfxn = zzesn3;
    }

    public final /* synthetic */ Object get() {
        return (zzdxw) zzesg.zzbd(new zzbrv(this.zzeyq.get(), this.zzfsw.get(), this.zzfxn.get()));
    }
}
