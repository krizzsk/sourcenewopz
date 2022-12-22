package atd.p017e;

import atd.p010a0.C0956a;
import atd.p046s0.C1172a;

/* renamed from: atd.e.a */
public enum C1012a {
    f270Y(C1172a.m764a(-14006341683886L)),
    f269N(C1172a.m764a(-14023521553070L));
    
    private final String mValue;

    private C1012a(String str) {
        this.mValue = str;
    }

    /* renamed from: a */
    public static C1012a m320a(String str) throws C0956a {
        if (str == null) {
            return f269N;
        }
        for (C1012a aVar : values()) {
            if (str.equalsIgnoreCase(aVar.mValue)) {
                return aVar;
            }
        }
        throw new C0956a(C1172a.m764a(-13916147370670L), C1014c.DATA_ELEMENT_INVALID_FORMAT);
    }

    /* renamed from: b */
    public boolean mo13735b() {
        return C1172a.m764a(-13980571880110L).equals(this.mValue);
    }

    /* renamed from: a */
    public boolean mo13734a() {
        return C1172a.m764a(-13989161814702L).equals(this.mValue);
    }
}
