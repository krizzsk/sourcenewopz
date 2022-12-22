package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzddh implements zzdhe<zzdhb<Bundle>> {
    private final Executor executor;
    private final zzazs zzbqn;

    zzddh(Executor executor2, zzazs zzazs) {
        this.executor = executor2;
        this.zzbqn = zzazs;
    }

    public final zzebt<zzdhb<Bundle>> zzatu() {
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcsx)).booleanValue()) {
            return zzebh.zzag(null);
        }
        return zzebh.zzb(this.zzbqn.zzym(), zzddk.zzebv, this.executor);
    }
}
