package atd.p020f0;

import atd.p046s0.C1172a;
import atd.p052y.C1225c;
import java.util.Locale;

/* renamed from: atd.f0.h */
public final class C1030h {

    /* renamed from: a */
    private final C1028f f280a;

    /* renamed from: b */
    private final C1026d f281b;

    /* renamed from: c */
    private final C1029g f282c;

    /* renamed from: d */
    private final C1027e f283d;

    /* renamed from: e */
    private final C1025c f284e;

    static {
        C1172a.m764a(-699611971144366L);
    }

    C1030h(C1028f fVar, C1026d dVar, C1029g gVar, C1027e eVar, C1025c cVar) {
        this.f280a = fVar;
        this.f281b = dVar;
        this.f282c = gVar;
        this.f283d = eVar;
        this.f284e = cVar;
    }

    /* renamed from: a */
    public static C1030h m357a(String str) {
        String[] split = str.split(C1172a.m764a(-699534661733038L));
        if (split.length == 5) {
            return new C1030h(new C1028f(split[0]), new C1026d(split[1]), new C1029g(split[2]), new C1027e(split[3]), new C1025c(split[4]));
        }
        throw C1225c.CRYPTO_FAILURE.mo13982a();
    }

    /* renamed from: b */
    public C1027e mo13753b() {
        return this.f283d;
    }

    /* renamed from: c */
    public C1028f mo13754c() {
        return this.f280a;
    }

    /* renamed from: d */
    public C1029g mo13755d() {
        return this.f282c;
    }

    /* renamed from: e */
    public String mo13756e() {
        return String.format(Locale.US, C1172a.m764a(-699547546634926L), new Object[]{this.f280a.mo13791c(), this.f281b.mo13791c(), this.f282c.mo13791c(), this.f283d.mo13791c(), this.f284e.mo13791c()});
    }

    /* renamed from: a */
    public C1025c mo13752a() {
        return this.f284e;
    }
}
