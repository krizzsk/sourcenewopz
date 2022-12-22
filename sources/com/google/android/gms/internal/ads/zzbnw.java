package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbnw implements zzesa<zzaya> {
    private final zzesn<Context> zzeyq;
    private final zzbnl zzfxk;
    private final zzesn<zzdpm> zzfxn;

    public zzbnw(zzbnl zzbnl, zzesn<Context> zzesn, zzesn<zzdpm> zzesn2) {
        this.zzfxk = zzbnl;
        this.zzeyq = zzesn;
        this.zzfxn = zzesn2;
    }

    public final /* synthetic */ Object get() {
        return (zzaya) zzesg.zzbd(new zzaya(this.zzeyq.get(), this.zzfxn.get().zzhny));
    }
}
