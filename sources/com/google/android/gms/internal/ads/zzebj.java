package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzebj<V> implements Runnable {
    private final Future<V> zzido;
    private final zzebi<? super V> zzidp;

    zzebj(Future<V> future, zzebi<? super V> zzebi) {
        this.zzido = future;
        this.zzidp = zzebi;
    }

    public final void run() {
        Throwable zza;
        Future<V> future = this.zzido;
        if (!(future instanceof zzecl) || (zza = zzeck.zza((zzecl) future)) == null) {
            try {
                this.zzidp.onSuccess(zzebh.zza(this.zzido));
            } catch (ExecutionException e) {
                this.zzidp.zzb(e.getCause());
            } catch (Error | RuntimeException e2) {
                this.zzidp.zzb(e2);
            }
        } else {
            this.zzidp.zzb(zza);
        }
    }

    public final String toString() {
        return zzdxy.zzw(this).zzy(this.zzidp).toString();
    }
}
