package com.google.android.gms.internal.ads;

import java.util.Map;
import java.util.concurrent.Executor;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcmb {
    /* access modifiers changed from: private */
    public final Executor executor;
    /* access modifiers changed from: private */
    public final zzcmg zzgob;
    /* access modifiers changed from: private */
    public final Map<String, String> zzgof;

    public zzcmb(zzcmg zzcmg, Executor executor2) {
        this.zzgob = zzcmg;
        this.zzgof = zzcmg.zzarq();
        this.executor = executor2;
    }

    public final zzcma zzarp() {
        return new zzcma(this).zzarl();
    }
}
