package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzay;
import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcfy implements zzesa<zzcfw> {
    private final zzesn<Executor> zzeyl;
    private final zzesn<zzay> zzffr;
    private final zzesn<Clock> zzfvh;

    public zzcfy(zzesn<zzay> zzesn, zzesn<Clock> zzesn2, zzesn<Executor> zzesn3) {
        this.zzffr = zzesn;
        this.zzfvh = zzesn2;
        this.zzeyl = zzesn3;
    }

    public final /* synthetic */ Object get() {
        return new zzcfw(this.zzffr.get(), this.zzfvh.get(), this.zzeyl.get());
    }
}
