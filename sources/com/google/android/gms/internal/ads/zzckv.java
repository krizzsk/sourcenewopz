package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzckv implements zzesa<Set<zzbzl<zzdtm>>> {
    private final zzesn<zzcll> zzeyk;
    private final zzesn<Executor> zzeyl;

    private zzckv(zzesn<Executor> zzesn, zzesn<zzcll> zzesn2) {
        this.zzeyl = zzesn;
        this.zzeyk = zzesn2;
    }

    public static zzckv zzac(zzesn<Executor> zzesn, zzesn<zzcll> zzesn2) {
        return new zzckv(zzesn, zzesn2);
    }

    public final /* synthetic */ Object get() {
        Set set;
        Executor executor = this.zzeyl.get();
        zzcll zzcll = this.zzeyk.get();
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcwb)).booleanValue()) {
            set = Collections.singleton(new zzbzl(zzcll, executor));
        } else {
            set = Collections.emptySet();
        }
        return (Set) zzesg.zzbd(set);
    }
}
