package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdts implements zzdtt {
    private final Executor executor;
    private final zzbas zzeiw;

    public zzdts(Executor executor2, zzbas zzbas) {
        this.executor = executor2;
        this.zzeiw = zzbas;
    }

    public final void zzgw(String str) {
        this.executor.execute(new zzdtv(this, str));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzgx(String str) {
        this.zzeiw.zzen(str);
    }
}
