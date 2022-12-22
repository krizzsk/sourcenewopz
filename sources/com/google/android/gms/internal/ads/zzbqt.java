package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbqt implements zzesa<zzbzl<zzbzq>> {
    private final zzesn<Executor> zzeyl;
    private final zzesn<zzbzt> zzfvz;

    private zzbqt(zzesn<zzbzt> zzesn, zzesn<Executor> zzesn2) {
        this.zzfvz = zzesn;
        this.zzeyl = zzesn2;
    }

    public static zzbqt zzf(zzesn<zzbzt> zzesn, zzesn<Executor> zzesn2) {
        return new zzbqt(zzesn, zzesn2);
    }

    public final /* synthetic */ Object get() {
        return (zzbzl) zzesg.zzbd(new zzbzl(this.zzfvz.get(), this.zzeyl.get()));
    }
}
