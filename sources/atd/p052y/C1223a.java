package atd.p052y;

import atd.p046s0.C1172a;
import com.adyen.threeds2.exception.InvalidInputException;

/* renamed from: atd.y.a */
public enum C1223a {
    APPLICATION_CONTEXT(C1172a.m764a(-691228194982574L)),
    CONFIG_PARAMETERS(C1172a.m764a(-691425763478190L)),
    LOCALE(C1172a.m764a(-691567497398958L)),
    DIRECTORY_SERVER_ID(C1172a.m764a(-691722116221614L)),
    MESSAGE_VERSION(C1172a.m764a(-691906799815342L)),
    CURRENT_ACTIVITY(C1172a.m764a(-692082893474478L)),
    CHALLENGE_PARAMETERS(C1172a.m764a(-692280461970094L)),
    CHALLENGE_STATUS_RECEIVER(C1172a.m764a(-692516685171374L)),
    TIMEOUT(C1172a.m764a(-692692778830510L)),
    SDK_TRANSACTION_ID(C1172a.m764a(-692847397653166L)),
    DEVICE_DATA(C1172a.m764a(-693010606410414L)),
    SDK_EPHEMERAL_PUBLIC_KEY(C1172a.m764a(-693203879938734L)),
    SDK_APP_ID(C1172a.m764a(-693384268565166L)),
    SDK_REFERENCE_NUMBER(C1172a.m764a(-693551772289710L));
    
    private final String mErrorMessage;

    private C1223a(String str) {
        this.mErrorMessage = str;
    }

    /* renamed from: a */
    public InvalidInputException mo13978a() {
        return mo13979a((Throwable) null);
    }

    /* renamed from: a */
    public InvalidInputException mo13979a(Throwable th) {
        return new InvalidInputException(this.mErrorMessage, (Throwable) null);
    }
}
