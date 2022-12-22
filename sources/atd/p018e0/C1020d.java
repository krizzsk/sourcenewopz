package atd.p018e0;

import atd.p052y.C1225c;

/* renamed from: atd.e0.d */
public final class C1020d {

    /* renamed from: a */
    public static final C1019c f273a = new C1018b();

    /* renamed from: b */
    public static final C1019c f274b = new C1017a();

    /* renamed from: a */
    public static C1019c m345a(String str) {
        if (f273a.mo13603a().equals(str)) {
            return f273a;
        }
        if (f274b.mo13603a().equals(str)) {
            return f274b;
        }
        throw C1225c.CRYPTO_FAILURE.mo13982a();
    }
}
