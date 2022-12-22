package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcmg extends zzcmj {
    private final zzdue zzgom;

    public zzcmg(Executor executor, zzbas zzbas, zzdue zzdue, zzdug zzdug) {
        super(executor, zzbas, zzdug);
        this.zzgom = zzdue;
        zzarr();
    }

    public final Map<String, String> zzarq() {
        return new HashMap(this.zzgof);
    }

    /* access modifiers changed from: protected */
    public final void zzarr() {
        this.zzgom.zzq(this.zzgof);
    }
}
