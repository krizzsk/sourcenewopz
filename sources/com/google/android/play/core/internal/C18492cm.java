package com.google.android.play.core.internal;

/* renamed from: com.google.android.play.core.internal.cm */
public final class C18492cm<T> implements C18490ck, C18494co {

    /* renamed from: a */
    private static final Object f53177a = new Object();

    /* renamed from: b */
    private volatile C18494co<T> f53178b;

    /* renamed from: c */
    private volatile Object f53179c = f53177a;

    private C18492cm(C18494co<T> coVar) {
        this.f53178b = coVar;
    }

    /* renamed from: a */
    public static <P extends C18494co<T>, T> C18494co<T> m37910a(P p) {
        C18470br.m37854a(p);
        return p instanceof C18492cm ? p : new C18492cm(p);
    }

    /* renamed from: b */
    public static <P extends C18494co<T>, T> C18490ck<T> m37911b(P p) {
        if (p instanceof C18490ck) {
            return (C18490ck) p;
        }
        C18470br.m37854a(p);
        return new C18492cm(p);
    }

    /* renamed from: a */
    public final T mo149139a() {
        T t = this.f53179c;
        if (t == f53177a) {
            synchronized (this) {
                t = this.f53179c;
                if (t == f53177a) {
                    t = this.f53178b.mo148801a();
                    T t2 = this.f53179c;
                    if (t2 != f53177a && !(t2 instanceof C18493cn)) {
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
                    this.f53179c = t;
                    this.f53178b = null;
                }
            }
        }
        return t;
    }
}
