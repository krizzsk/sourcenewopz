package atd.p017e;

import atd.p015d.C0981d;
import atd.p015d.C0988i;
import atd.p046s0.C1172a;
import atd.p053z.C1227b;
import atd.p053z.C1228c;
import atd.p053z.C1229d;
import com.adyen.threeds2.ProtocolErrorEvent;
import com.adyen.threeds2.RuntimeErrorEvent;

/* renamed from: atd.e.c */
public enum C1014c {
    MESSAGE_RECEIVED_INVALID(C1172a.m764a(-14641996843694L), C1172a.m764a(-14659176712878L), C1172a.m764a(-14667766647470L), C1172a.m764a(-14779435797166L)),
    MESSAGE_VERSION_NOT_SUPPORTED(C1172a.m764a(-14929759652526L), C1172a.m764a(-14946939521710L), C1172a.m764a(-14955529456302L), C1172a.m764a(-15118738213550L)),
    DATA_ELEMENT_MISSING(C1172a.m764a(-15230407363246L), C1172a.m764a(-15247587232430L), C1172a.m764a(-15256177167022L), C1172a.m764a(-15389321153198L)),
    MESSAGE_EXTENSION_MISSING(C1172a.m764a(-15522465139374L), C1172a.m764a(-15539645008558L), C1172a.m764a(-15548234943150L), C1172a.m764a(-15732918536878L)),
    DATA_ELEMENT_INVALID_FORMAT(C1172a.m764a(-15874652457646L), C1172a.m764a(-15891832326830L), C1172a.m764a(-15900422261422L), C1172a.m764a(-16106580691630L)),
    DUPLICATE_DATA_ELEMENT(C1172a.m764a(-16226839775918L), C1172a.m764a(-16244019645102L), C1172a.m764a(-16252609579694L), C1172a.m764a(-16355688794798L)),
    TRANSACTION_ID_NOT_RECOGNIZED(C1172a.m764a(-16506012650158L), C1172a.m764a(-16523192519342L), C1172a.m764a(-16531782453934L), C1172a.m764a(-16664926440110L)),
    DATA_DECRYPTION_FAILURE(C1172a.m764a(-16789480491694L), C1172a.m764a(-16806660360878L), C1172a.m764a(-16815250295470L), C1172a.m764a(-16922624477870L)),
    ACCESS_DENIED(C1172a.m764a(-17004228856494L), C1172a.m764a(-17021408725678L), C1172a.m764a(-17029998660270L), C1172a.m764a(-17171732581038L)),
    ISO_CODE_INVALID(C1172a.m764a(-17266221861550L), C1172a.m764a(-17283401730734L), C1172a.m764a(-17291991665326L), C1172a.m764a(-17369301076654L)),
    TRANSACTION_TIMED_OUT(C1172a.m764a(-17485265193646L), C1172a.m764a(-17502445062830L), C1172a.m764a(-17511034997422L), C1172a.m764a(-17609819245230L)),
    TRANSIENT_SYSTEM_FAILURE(C1172a.m764a(-17738668264110L), C1172a.m764a(-17755848133294L), C1172a.m764a(-17764438067886L), C1172a.m764a(-17876107217582L)),
    SYSTEM_CONNECTION_FAILURE(C1172a.m764a(-18009251203758L), C1172a.m764a(-18026431072942L), C1172a.m764a(-18035021007534L), C1172a.m764a(-18146690157230L));
    
    private final String mErrorCode;
    private final String mErrorComponent;
    private final String mErrorDescription;
    private final String mErrorMessageType;

    private C1014c(String str, String str2, String str3, String str4) {
        this.mErrorCode = str;
        this.mErrorComponent = str2;
        this.mErrorDescription = str3;
        this.mErrorMessageType = str4;
    }

    /* renamed from: a */
    public String mo13740a() {
        return this.mErrorCode;
    }

    /* renamed from: b */
    public String mo13741b() {
        return this.mErrorComponent;
    }

    /* renamed from: c */
    public String mo13742c() {
        return this.mErrorDescription;
    }

    /* renamed from: d */
    public String mo13743d() {
        return this.mErrorMessageType;
    }

    /* renamed from: a */
    public C0981d mo13737a(C0988i iVar, String str) {
        return new C0981d(iVar.mo13665d(), iVar.mo13669h(), iVar.mo13663b(), iVar.mo13667f(), iVar.mo13668g(), this, str);
    }

    /* renamed from: a */
    public ProtocolErrorEvent mo13738a(String str, String str2) {
        return new C1228c(str, new C1227b(str, this.mErrorCode, this.mErrorDescription, str2));
    }

    /* renamed from: a */
    public RuntimeErrorEvent mo13739a(String str) {
        return new C1229d(this.mErrorCode, this.mErrorDescription);
    }
}
