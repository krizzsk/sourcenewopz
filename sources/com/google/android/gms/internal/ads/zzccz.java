package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.HashSet;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzccz implements zzesa<zzbzk> {
    private final zzesn<Context> zzeyq;
    private final zzesn<zzdot> zzfxz;

    public zzccz(zzesn<Context> zzesn, zzesn<zzdot> zzesn2) {
        this.zzeyq = zzesn;
        this.zzfxz = zzesn2;
    }

    public final /* synthetic */ Object get() {
        return (zzbzk) zzesg.zzbd(new zzbzk(this.zzeyq.get(), new HashSet(), this.zzfxz.get()));
    }
}
