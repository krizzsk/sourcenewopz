package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbtb extends zzbxq<zzbtc> implements zzbtc {
    public zzbtb(zzbtf zzbtf, Set<zzbzl<zzbtc>> set, Executor executor) {
        super(set);
        zza(zzbtf, executor);
    }

    public final void zzl(zzvh zzvh) {
        zza(new zzbte(zzvh));
    }

    public final void zza(zzcbq zzcbq) {
        zza(new zzbtd(zzcbq));
    }

    public final void zzamj() {
        zza(zzbtg.zzgbn);
    }
}
