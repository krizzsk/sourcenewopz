package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzeal;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzeav<V> extends zzeal<Object, V> {
    /* access modifiers changed from: private */
    public zzeax<?> zzidh;

    zzeav(zzdyv<? extends zzebt<?>> zzdyv, boolean z, Executor executor, Callable<V> callable) {
        super(zzdyv, z, false);
        this.zzidh = new zzeay(this, callable, executor);
        zzbav();
    }

    /* access modifiers changed from: package-private */
    public final void zzb(int i, @NullableDecl Object obj) {
    }

    /* access modifiers changed from: package-private */
    public final void zzbaw() {
        zzeax<?> zzeax = this.zzidh;
        if (zzeax != null) {
            zzeax.execute();
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzeal.zza zza) {
        super.zza(zza);
        if (zza == zzeal.zza.OUTPUT_FUTURE_DONE) {
            this.zzidh = null;
        }
    }

    /* access modifiers changed from: protected */
    public final void interruptTask() {
        zzeax<?> zzeax = this.zzidh;
        if (zzeax != null) {
            zzeax.interruptTask();
        }
    }
}
