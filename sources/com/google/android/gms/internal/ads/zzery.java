package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzery<T> implements zzesa<T> {
    private zzesn<T> zzjfa;

    public final T get() {
        zzesn<T> zzesn = this.zzjfa;
        if (zzesn != null) {
            return zzesn.get();
        }
        throw new IllegalStateException();
    }

    public static <T> void zzbf(zzesn<T> zzesn, zzesn<T> zzesn2) {
        zzesg.checkNotNull(zzesn2);
        zzery zzery = (zzery) zzesn;
        if (zzery.zzjfa == null) {
            zzery.zzjfa = zzesn2;
            return;
        }
        throw new IllegalStateException();
    }
}
