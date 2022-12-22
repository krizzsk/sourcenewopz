package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzbbk implements zzebi<T> {
    private final /* synthetic */ zzbbh zzeku;

    zzbbk(zzbbh zzbbh) {
        this.zzeku = zzbbh;
    }

    public final void onSuccess(T t) {
        this.zzeku.zzekr.set(1);
    }

    public final void zzb(Throwable th) {
        this.zzeku.zzekr.set(-1);
    }
}
