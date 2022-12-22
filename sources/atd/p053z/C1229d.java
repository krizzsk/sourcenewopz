package atd.p053z;

import atd.p046s0.C1172a;
import com.adyen.threeds2.RuntimeErrorEvent;

/* renamed from: atd.z.d */
public final class C1229d implements RuntimeErrorEvent {

    /* renamed from: a */
    private final String f390a;

    /* renamed from: b */
    private final String f391b;

    public C1229d(String str, String str2) {
        this.f390a = str;
        this.f391b = str2;
    }

    public String getErrorCode() {
        return this.f390a;
    }

    public String getErrorMessage() {
        return this.f391b;
    }

    public String toString() {
        return C1172a.m764a(-697296983771822L) + getErrorCode() + C1172a.m764a(-697352818346670L) + getErrorMessage();
    }
}
