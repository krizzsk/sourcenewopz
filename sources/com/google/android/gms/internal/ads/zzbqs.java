package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbqs implements zzesa<zzbzl<zzve>> {
    private final zzesn<Executor> zzeyl;
    private final zzesn<zzbkz> zzfvz;

    private zzbqs(zzesn<zzbkz> zzesn, zzesn<Executor> zzesn2) {
        this.zzfvz = zzesn;
        this.zzeyl = zzesn2;
    }

    public static zzbqs zze(zzesn<zzbkz> zzesn, zzesn<Executor> zzesn2) {
        return new zzbqs(zzesn, zzesn2);
    }

    public final /* synthetic */ Object get() {
        return (zzbzl) zzesg.zzbd(new zzbzl(this.zzfvz.get(), this.zzeyl.get()));
    }
}
