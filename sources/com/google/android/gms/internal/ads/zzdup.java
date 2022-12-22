package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdup {
    private final Executor executor;
    private final zzbas zzhuz;

    public zzdup(Executor executor2, zzbas zzbas) {
        this.executor = executor2;
        this.zzhuz = zzbas;
    }

    public final void zzk(List<String> list) {
        for (String zzen : list) {
            zzen(zzen);
        }
    }

    public final void zzen(String str) {
        this.executor.execute(new zzduo(this, str));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzhd(String str) {
        this.zzhuz.zzen(str);
    }
}
