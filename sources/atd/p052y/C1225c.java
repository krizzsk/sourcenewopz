package atd.p052y;

import atd.p046s0.C1172a;
import com.adyen.threeds2.exception.SDKRuntimeException;

/* renamed from: atd.y.c */
public enum C1225c {
    CHALLENGE_PRESENTATION_FAILURE(C1172a.m764a(-695733615676078L)),
    CRYPTO_FAILURE(C1172a.m764a(-695935479138990L)),
    DEVICE_DATA_FAILURE(C1172a.m764a(-696120162732718L)),
    SECURE_CHANNEL_SETUP_FAILURE(C1172a.m764a(-696334911097518L)),
    UNKNOWN_DIRECTORY_SERVER(C1172a.m764a(-696571134298798L));
    
    private final String mErrorMessage;

    private C1225c(String str) {
        this.mErrorMessage = str;
    }

    /* renamed from: a */
    public SDKRuntimeException mo13982a() {
        return mo13983a((Throwable) null);
    }

    /* renamed from: a */
    public SDKRuntimeException mo13983a(Throwable th) {
        return new SDKRuntimeException(this.mErrorMessage, (String) null, (Throwable) null);
    }
}
