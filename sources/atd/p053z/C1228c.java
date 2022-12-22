package atd.p053z;

import atd.p046s0.C1172a;
import com.adyen.threeds2.ErrorMessage;
import com.adyen.threeds2.ProtocolErrorEvent;

/* renamed from: atd.z.c */
public final class C1228c implements ProtocolErrorEvent {

    /* renamed from: a */
    private final String f388a;

    /* renamed from: b */
    private final ErrorMessage f389b;

    public C1228c(String str, ErrorMessage errorMessage) {
        this.f388a = str;
        this.f389b = errorMessage;
    }

    public ErrorMessage getErrorMessage() {
        return this.f389b;
    }

    public String getSDKTransactionID() {
        return this.f388a;
    }

    public String toString() {
        return C1172a.m764a(-697142364949166L) + getSDKTransactionID() + C1172a.m764a(-697228264295086L) + getErrorMessage();
    }
}
