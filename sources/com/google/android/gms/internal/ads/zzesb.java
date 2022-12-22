package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzesb<T> implements zzeru<T>, zzesn<T> {
    private static final Object zzjfb = new Object();
    private volatile Object zzeix = zzjfb;
    private volatile zzesn<T> zzjfc;

    private zzesb(zzesn<T> zzesn) {
        this.zzjfc = zzesn;
    }

    public final T get() {
        T t = this.zzeix;
        if (t == zzjfb) {
            synchronized (this) {
                t = this.zzeix;
                if (t == zzjfb) {
                    t = this.zzjfc.get();
                    T t2 = this.zzeix;
                    if (t2 != zzjfb && !(t2 instanceof zzesh)) {
                        if (t2 != t) {
                            String valueOf = String.valueOf(t2);
                            String valueOf2 = String.valueOf(t);
                            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 118 + String.valueOf(valueOf2).length());
                            sb.append("Scoped provider was invoked recursively returning different results: ");
                            sb.append(valueOf);
                            sb.append(" & ");
                            sb.append(valueOf2);
                            sb.append(". This is likely due to a circular dependency.");
                            throw new IllegalStateException(sb.toString());
                        }
                    }
                    this.zzeix = t;
                    this.zzjfc = null;
                }
            }
        }
        return t;
    }

    public static <P extends zzesn<T>, T> zzesn<T> zzas(P p) {
        zzesg.checkNotNull(p);
        if (p instanceof zzesb) {
            return p;
        }
        return new zzesb(p);
    }

    public static <P extends zzesn<T>, T> zzeru<T> zzat(P p) {
        if (p instanceof zzeru) {
            return (zzeru) p;
        }
        return new zzesb((zzesn) zzesg.checkNotNull(p));
    }
}
