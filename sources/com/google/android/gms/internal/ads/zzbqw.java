package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbqw implements zzesa<zzbzl<zzbuj>> {
    private final zzesn<Executor> zzeyl;
    private final zzesn<zzbkz> zzfvz;

    private zzbqw(zzesn<zzbkz> zzesn, zzesn<Executor> zzesn2) {
        this.zzfvz = zzesn;
        this.zzeyl = zzesn2;
    }

    public static zzbqw zzi(zzesn<zzbkz> zzesn, zzesn<Executor> zzesn2) {
        return new zzbqw(zzesn, zzesn2);
    }

    public static zzbzl<zzbuj> zza(zzbkz zzbkz, Executor executor) {
        return (zzbzl) zzesg.zzbd(new zzbzl(zzbkz, executor));
    }

    public final /* synthetic */ Object get() {
        return zza(this.zzfvz.get(), this.zzeyl.get());
    }
}
