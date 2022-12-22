package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzbbj implements zzebi<T> {
    private final /* synthetic */ zzbbi zzeks;
    private final /* synthetic */ zzbbg zzekt;

    zzbbj(zzbbh zzbbh, zzbbi zzbbi, zzbbg zzbbg) {
        this.zzeks = zzbbi;
        this.zzekt = zzbbg;
    }

    public final void onSuccess(T t) {
        this.zzeks.zzg(t);
    }

    public final void zzb(Throwable th) {
        this.zzekt.run();
    }
}
