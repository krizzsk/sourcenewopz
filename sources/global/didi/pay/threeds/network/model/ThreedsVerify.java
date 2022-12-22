package global.didi.pay.threeds.network.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\f"}, mo175978d2 = {"Lglobal/didi/pay/threeds/network/model/ThreedsVerify;", "Lglobal/didi/pay/threeds/network/model/ThreedsBaseRequest;", "sessionId", "", "authId", "(Ljava/lang/String;Ljava/lang/String;)V", "getAuthId", "()Ljava/lang/String;", "setAuthId", "(Ljava/lang/String;)V", "getSessionId", "setSessionId", "payThreeds_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ThreedsVerify.kt */
public final class ThreedsVerify extends ThreedsBaseRequest {
    private String authId;
    private String sessionId;

    public ThreedsVerify() {
        this((String) null, (String) null, 3, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ThreedsVerify(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final void setSessionId(String str) {
        this.sessionId = str;
    }

    public final String getAuthId() {
        return this.authId;
    }

    public final void setAuthId(String str) {
        this.authId = str;
    }

    public ThreedsVerify(String str, String str2) {
        this.sessionId = str;
        this.authId = str2;
    }
}
