package atd.p017e;

import atd.p010a0.C0956a;
import atd.p046s0.C1172a;
import java.util.Locale;

/* renamed from: atd.e.d */
public enum C1015d {
    CHALLENGE_REQUEST(C1172a.m764a(-18391503293102L)),
    CHALLENGE_RESPONSE(C1172a.m764a(-18494582508206L)),
    ERROR(C1172a.m764a(-18541827148462L));
    
    private final String mValue;

    private C1015d(String str) {
        this.mValue = str;
    }

    /* renamed from: a */
    public static C1015d m333a(String str) throws C0956a {
        for (C1015d dVar : (C1015d[]) C1015d.class.getEnumConstants()) {
            if (dVar.mo13744a().equals(str)) {
                return dVar;
            }
        }
        throw new C0956a(String.format(Locale.ENGLISH, C1172a.m764a(-18168164993710L), new Object[]{str}), C1014c.MESSAGE_RECEIVED_INVALID);
    }

    /* renamed from: a */
    public String mo13744a() {
        return this.mValue;
    }
}
