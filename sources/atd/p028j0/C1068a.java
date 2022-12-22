package atd.p028j0;

import atd.p044r0.C1159f;
import atd.p052y.C1223a;
import com.adyen.threeds2.AuthenticationRequestParameters;
import com.adyen.threeds2.exception.InvalidInputException;

/* renamed from: atd.j0.a */
public final class C1068a implements AuthenticationRequestParameters {

    /* renamed from: a */
    private final String f311a;

    /* renamed from: b */
    private final String f312b;

    /* renamed from: c */
    private final String f313c;

    /* renamed from: d */
    private final String f314d;

    /* renamed from: e */
    private final String f315e;

    /* renamed from: f */
    private final String f316f;

    public C1068a(String str, String str2, String str3, String str4, String str5, String str6) throws InvalidInputException {
        C1159f.m731a((Object) str, C1223a.SDK_TRANSACTION_ID);
        C1159f.m731a((Object) str2, C1223a.DEVICE_DATA);
        C1159f.m731a((Object) str3, C1223a.SDK_EPHEMERAL_PUBLIC_KEY);
        C1159f.m731a((Object) str4, C1223a.SDK_APP_ID);
        C1159f.m731a((Object) str5, C1223a.SDK_REFERENCE_NUMBER);
        C1159f.m731a((Object) str6, C1223a.MESSAGE_VERSION);
        this.f311a = str;
        this.f312b = str2;
        this.f313c = str3;
        this.f314d = str4;
        this.f315e = str5;
        this.f316f = str6;
    }

    public String getDeviceData() {
        return this.f312b;
    }

    public String getMessageVersion() {
        return this.f316f;
    }

    public String getSDKAppID() {
        return this.f314d;
    }

    public String getSDKEphemeralPublicKey() {
        return this.f313c;
    }

    public String getSDKReferenceNumber() {
        return this.f315e;
    }

    public String getSDKTransactionID() {
        return this.f311a;
    }
}
