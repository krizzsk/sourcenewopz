package atd.p017e;

import atd.p010a0.C0956a;
import atd.p046s0.C1172a;

/* renamed from: atd.e.e */
public enum C1016e {
    f272Y(C1172a.m764a(-18812410088110L)),
    f271N(C1172a.m764a(-18829589957294L));
    
    public static final String INVALID_TRANS_STATUS_MSG = null;
    private final String mValue;

    private C1016e(String str) {
        this.mValue = str;
    }

    /* renamed from: a */
    public static C1016e m335a(String str) throws C0956a {
        if (str == null || str.isEmpty()) {
            return null;
        }
        for (C1016e eVar : values()) {
            if (str.equalsIgnoreCase(eVar.mValue)) {
                return eVar;
            }
        }
        throw new C0956a(C1172a.m764a(-18563301984942L) + str, C1014c.DATA_ELEMENT_INVALID_FORMAT);
    }

    /* renamed from: a */
    public String mo13745a() {
        return this.mValue;
    }
}
