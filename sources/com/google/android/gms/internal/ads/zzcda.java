package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcda implements zzesa<zzblv> {
    private final zzesn<Executor> zzeyl;
    private final zzesn<Context> zzeyq;
    private final zzesn<Clock> zzfvh;
    private final zzesn<zzqt> zzgfl;

    public zzcda(zzesn<zzqt> zzesn, zzesn<Executor> zzesn2, zzesn<Context> zzesn3, zzesn<Clock> zzesn4) {
        this.zzgfl = zzesn;
        this.zzeyl = zzesn2;
        this.zzeyq = zzesn3;
        this.zzfvh = zzesn4;
    }

    public final /* synthetic */ Object get() {
        return (zzblv) zzesg.zzbd(new zzblv(this.zzeyl.get(), new zzblg(this.zzeyq.get(), this.zzgfl.get()), this.zzfvh.get()));
    }
}
