package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public class zzbxq<ListenerT> {
    private final Map<ListenerT, Executor> zzgcm = new HashMap();

    protected zzbxq(Set<zzbzl<ListenerT>> set) {
        zzb(set);
    }

    public final synchronized void zza(zzbzl<ListenerT> zzbzl) {
        zza(zzbzl.zzgdh, zzbzl.executor);
    }

    public final synchronized void zza(ListenerT listenert, Executor executor) {
        this.zzgcm.put(listenert, executor);
    }

    private final synchronized void zzb(Set<zzbzl<ListenerT>> set) {
        for (zzbzl<ListenerT> zza : set) {
            zza(zza);
        }
    }

    /* access modifiers changed from: protected */
    public final synchronized void zza(zzbxs<ListenerT> zzbxs) {
        for (Map.Entry next : this.zzgcm.entrySet()) {
            ((Executor) next.getValue()).execute(new zzbxp(zzbxs, next.getKey()));
        }
    }
}
