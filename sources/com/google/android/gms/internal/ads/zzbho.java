package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbho implements zzesa<Set<zzbzl<zzbyw>>> {
    private final zzesn<zzcqz> zzeyk;
    private final zzesn<Executor> zzeyl;

    public zzbho(zzesn<zzcqz> zzesn, zzesn<Executor> zzesn2) {
        this.zzeyk = zzesn;
        this.zzeyl = zzesn2;
    }

    public final /* synthetic */ Object get() {
        Set set;
        zzcqz zzcqz = this.zzeyk.get();
        Executor executor = this.zzeyl.get();
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcsg)).booleanValue()) {
            if (((Boolean) zzww.zzra().zzd(zzabq.zzdbl)).booleanValue()) {
                set = Collections.singleton(new zzbzl(zzcqz, executor));
                return (Set) zzesg.zzbd(set);
            }
        }
        set = Collections.emptySet();
        return (Set) zzesg.zzbd(set);
    }
}
