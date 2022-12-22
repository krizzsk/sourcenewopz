package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbts extends zzbxq<zzbtp> {
    public zzbts(Set<zzbzl<zzbtp>> set) {
        super(set);
    }

    public final void zzce(Context context) {
        zza(new zzbtr(context));
    }

    public final void zzcf(Context context) {
        zza(new zzbtu(context));
    }

    public final void zzcg(Context context) {
        zza(new zzbtt(context));
    }

    public final void zza(zzcab zzcab, Executor executor) {
        zza(zzbzl.zzb(new zzbtw(this, zzcab), executor));
    }
}
