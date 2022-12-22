package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzag<T> {
    public final T result;
    public final zzn zzbq;
    public final zzap zzbr;
    public boolean zzbs;

    public static <T> zzag<T> zza(T t, zzn zzn) {
        return new zzag<>(t, zzn);
    }

    public static <T> zzag<T> zzc(zzap zzap) {
        return new zzag<>(zzap);
    }

    public final boolean isSuccess() {
        return this.zzbr == null;
    }

    private zzag(T t, zzn zzn) {
        this.zzbs = false;
        this.result = t;
        this.zzbq = zzn;
        this.zzbr = null;
    }

    private zzag(zzap zzap) {
        this.zzbs = false;
        this.result = null;
        this.zzbq = null;
        this.zzbr = zzap;
    }
}
