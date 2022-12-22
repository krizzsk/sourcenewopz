package atd.p052y;

import atd.p046s0.C1172a;
import atd.p053z.C1229d;
import com.adyen.threeds2.RuntimeErrorEvent;

/* renamed from: atd.y.b */
public enum C1224b {
    UNKNOWN(C1172a.m764a(-693706391112366L), C1172a.m764a(-693740750850734L)),
    MESSAGE_VERSIONS_MISMATCH(C1172a.m764a(-693951204248238L), C1172a.m764a(-694062873397934L)),
    MESSAGE_INDICES_MISMATCH(C1172a.m764a(-694432240585390L), C1172a.m764a(-694539614767790L)),
    ACTIVITY_WEAK_REFERENCE_MISSING(C1172a.m764a(-694900392020654L), C1172a.m764a(-695037830974126L)),
    ACTIVITY_REFERENCE_MISSING(C1172a.m764a(-695329888750254L), C1172a.m764a(-695445852867246L));
    
    private final String mErrorCode;
    private final String mErrorMessage;

    private C1224b(String str, String str2) {
        this.mErrorCode = str;
        this.mErrorMessage = str2;
    }

    /* renamed from: a */
    public RuntimeErrorEvent mo13980a() {
        return new C1229d(this.mErrorCode, this.mErrorMessage);
    }

    /* renamed from: a */
    public RuntimeErrorEvent mo13981a(String str) {
        return new C1229d(this.mErrorCode, this.mErrorMessage);
    }
}
