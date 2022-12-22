package atd.p025i;

import atd.p046s0.C1172a;

/* renamed from: atd.i.c */
public class C1051c extends Exception {

    /* renamed from: a */
    private final C1052a f305a;

    /* renamed from: atd.i.c$a */
    public enum C1052a {
        MARKET_OR_REGIONAL_RESTRICTION(C1172a.m764a(-30361577147054L)),
        UNSUPPORTED_BY_PLATFORM_OR_DEPRECATED(C1172a.m764a(-30546260740782L)),
        MISSING_PERMISSION(C1172a.m764a(-30649339955886L)),
        PARAMETER_NULL_OR_BLANK(C1172a.m764a(-30773894007470L));
        
        private final String mCode;

        private C1052a(String str) {
            this.mCode = str;
        }

        /* renamed from: a */
        public String mo13783a() {
            return this.mCode;
        }
    }

    public C1051c(C1052a aVar, Throwable th) {
        super(th);
        this.f305a = aVar;
    }

    /* renamed from: a */
    public String mo13782a() {
        return this.f305a.mo13783a();
    }
}
