package atd.p053z;

import atd.p046s0.C1172a;
import com.adyen.threeds2.ErrorMessage;

/* renamed from: atd.z.b */
public final class C1227b implements ErrorMessage {

    /* renamed from: a */
    private final String f384a;

    /* renamed from: b */
    private final String f385b;

    /* renamed from: c */
    private final String f386c;

    /* renamed from: d */
    private final String f387d;

    public C1227b(String str, String str2, String str3, String str4) {
        this.f384a = str;
        this.f385b = str2;
        this.f386c = str3;
        this.f387d = str4;
    }

    public String getErrorCode() {
        return this.f385b;
    }

    public String getErrorDescription() {
        return this.f386c;
    }

    public String getErrorDetails() {
        return this.f387d;
    }

    public String getTransactionID() {
        return this.f384a;
    }

    public String toString() {
        return C1172a.m764a(-696858897107630L) + getTransactionID() + C1172a.m764a(-696931911551662L) + getErrorCode() + C1172a.m764a(-696987746126510L) + getErrorDescription() + C1172a.m764a(-697073645472430L) + getErrorDetails();
    }
}
