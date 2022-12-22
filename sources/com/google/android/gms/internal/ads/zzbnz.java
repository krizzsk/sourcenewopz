package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbnz implements zzesa<zzbzl<zzqw>> {
    private final zzesn<Executor> zzeyl;
    private final zzesn<zzbpb> zzfvz;
    private final zzbnl zzfxk;

    public zzbnz(zzbnl zzbnl, zzesn<zzbpb> zzesn, zzesn<Executor> zzesn2) {
        this.zzfxk = zzbnl;
        this.zzfvz = zzesn;
        this.zzeyl = zzesn2;
    }

    public final /* synthetic */ Object get() {
        return (zzbzl) zzesg.zzbd(new zzbzl(this.zzfvz.get(), this.zzeyl.get()));
    }
}
