package atd.p053z;

import atd.p046s0.C1172a;
import com.adyen.threeds2.CompletionEvent;

/* renamed from: atd.z.a */
public final class C1226a implements CompletionEvent {

    /* renamed from: a */
    private final String f382a;

    /* renamed from: b */
    private final String f383b;

    public C1226a(String str, String str2) {
        this.f382a = str;
        this.f383b = str2;
    }

    public String getSDKTransactionID() {
        return this.f382a;
    }

    public String getTransactionStatus() {
        return this.f383b;
    }

    public String toString() {
        return C1172a.m764a(-696682803448494L) + getSDKTransactionID() + C1172a.m764a(-696768702794414L) + getTransactionStatus();
    }
}
