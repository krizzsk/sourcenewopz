package atd.p009a;

import atd.p046s0.C1172a;
import com.adyen.threeds2.internal.C1395b;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

/* renamed from: atd.a.e */
public final class C0943e {

    /* renamed from: atd.a.e$b */
    public static final class C0945b {

        /* renamed from: a */
        private final C0944a f164a;

        /* renamed from: b */
        private final Charset f165b;

        C0945b(C0944a aVar, Charset charset) {
            this.f164a = aVar;
            this.f165b = charset == null ? C1395b.f995a : charset;
        }

        /* renamed from: a */
        public Charset mo13563a() {
            return this.f165b;
        }

        /* renamed from: b */
        public C0944a mo13564b() {
            return this.f164a;
        }

        /* renamed from: c */
        public String mo13565c() {
            return this.f164a.mo13561a() + C1172a.m764a(-2942505929390L) + C1172a.m764a(-2951095863982L) + C1172a.m764a(-2985455602350L) + this.f165b.name();
        }

        public String toString() {
            return mo13565c();
        }
    }

    static {
        C1172a.m764a(-3101419719342L);
        C1172a.m764a(-3131484490414L);
        C1172a.m764a(-3187319065262L);
        C1172a.m764a(-3195908999854L);
        C1172a.m764a(-3230268738222L);
    }

    /* renamed from: a */
    public static C0945b m118a(Map<String, List<String>> map) {
        List<String> list;
        C0945b a;
        if (map == null) {
            return null;
        }
        for (Map.Entry next : map.entrySet()) {
            if (!(next == null || !C1172a.m764a(-2994045536942L).equalsIgnoreCase((String) next.getKey()) || (list = (List) next.getValue()) == null)) {
                for (String str : list) {
                    if (str != null && (a = m119a(str.split(C1172a.m764a(-3049880111790L)))) != null) {
                        return a;
                    }
                }
                continue;
            }
        }
        return null;
    }

    /* renamed from: atd.a.e$a */
    public enum C0944a {
        APPLICATION_JSON(C1172a.m764a(-2723462597294L)),
        APPLICATION_JOSE(C1172a.m764a(-2869491485358L));
        
        private final String mValue;

        private C0944a(String str) {
            this.mValue = str;
        }

        /* renamed from: a */
        static C0944a m121a(String str) {
            for (C0944a aVar : values()) {
                if (aVar.mValue.equalsIgnoreCase(str)) {
                    return aVar;
                }
            }
            return null;
        }

        public String toString() {
            return this.mValue;
        }

        /* renamed from: a */
        public String mo13561a() {
            return this.mValue;
        }

        /* renamed from: a */
        public C0945b mo13560a(Charset charset) {
            return new C0945b(this, charset);
        }
    }

    /* renamed from: a */
    private static C0945b m119a(String... strArr) {
        Charset charset;
        C0944a aVar;
        if (strArr.length > 0) {
            aVar = C0944a.m121a(strArr[0]);
            if (aVar == null) {
                return null;
            }
            charset = strArr.length > 1 ? m120a(strArr[1]) : null;
        } else {
            charset = null;
            aVar = null;
        }
        if (aVar != null) {
            return aVar.mo13560a(charset);
        }
        return null;
    }

    /* renamed from: a */
    private static Charset m120a(String str) {
        String[] split = str.split(C1172a.m764a(-3058470046382L));
        if (split.length > 1 && C1172a.m764a(-3067059980974L).equalsIgnoreCase(split[0])) {
            try {
                return Charset.forName(split[1]);
            } catch (IllegalArgumentException unused) {
            }
        }
        return null;
    }
}
