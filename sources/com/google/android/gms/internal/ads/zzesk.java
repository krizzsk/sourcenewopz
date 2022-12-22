package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzesk<T> implements zzesn<T> {
    private static final Object zzjfb = new Object();
    private volatile Object zzeix = zzjfb;
    private volatile zzesn<T> zzjfc;

    private zzesk(zzesn<T> zzesn) {
        this.zzjfc = zzesn;
    }

    public final T get() {
        T t = this.zzeix;
        if (t != zzjfb) {
            return t;
        }
        zzesn<T> zzesn = this.zzjfc;
        if (zzesn == null) {
            return this.zzeix;
        }
        T t2 = zzesn.get();
        this.zzeix = t2;
        this.zzjfc = null;
        return t2;
    }

    public static <P extends zzesn<T>, T> zzesn<T> zzas(P p) {
        return ((p instanceof zzesk) || (p instanceof zzesb)) ? p : new zzesk((zzesn) zzesg.checkNotNull(p));
    }
}
