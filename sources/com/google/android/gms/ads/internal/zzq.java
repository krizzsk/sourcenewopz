package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.zzef;
import com.google.android.gms.internal.ads.zzei;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzq implements Callable<zzei> {
    private final /* synthetic */ zzl zzbqf;

    zzq(zzl zzl) {
        this.zzbqf = zzl;
    }

    public final /* synthetic */ Object call() throws Exception {
        return new zzei(zzef.zzb(this.zzbqf.zzbpx.zzbrz, this.zzbqf.context, false));
    }
}
