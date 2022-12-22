package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbrg implements zzesa<zzbzl<zzbus>> {
    private final zzesn<zzbvl> zzeyk;
    private final zzesn<Executor> zzeyl;

    private zzbrg(zzesn<zzbvl> zzesn, zzesn<Executor> zzesn2) {
        this.zzeyk = zzesn;
        this.zzeyl = zzesn2;
    }

    public static zzbrg zzn(zzesn<zzbvl> zzesn, zzesn<Executor> zzesn2) {
        return new zzbrg(zzesn, zzesn2);
    }

    public final /* synthetic */ Object get() {
        return (zzbzl) zzesg.zzbd(new zzbzl(this.zzeyk.get(), this.zzeyl.get()));
    }
}
