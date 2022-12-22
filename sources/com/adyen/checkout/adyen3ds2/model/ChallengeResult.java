package com.adyen.checkout.adyen3ds2.model;

import com.adyen.checkout.components.encoding.Base64Encoder;
import com.adyen.threeds2.CompletionEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000b"}, mo175978d2 = {"Lcom/adyen/checkout/adyen3ds2/model/ChallengeResult;", "", "isAuthenticated", "", "payload", "", "(ZLjava/lang/String;)V", "()Z", "getPayload", "()Ljava/lang/String;", "Companion", "3ds2_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ChallengeResult.kt */
public final class ChallengeResult {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: c */
    private static final String f545c = "transStatus";

    /* renamed from: d */
    private static final String f546d = "authorisationToken";

    /* renamed from: e */
    private static final String f547e = "Y";

    /* renamed from: a */
    private final boolean f548a;

    /* renamed from: b */
    private final String f549b;

    public /* synthetic */ ChallengeResult(boolean z, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, str);
    }

    private ChallengeResult(boolean z, String str) {
        this.f548a = z;
        this.f549b = str;
    }

    public final String getPayload() {
        return this.f549b;
    }

    public final boolean isAuthenticated() {
        return this.f548a;
    }

    @Metadata(mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, mo175978d2 = {"Lcom/adyen/checkout/adyen3ds2/model/ChallengeResult$Companion;", "", "()V", "KEY_AUTHORISATION_TOKEN", "", "KEY_TRANSACTION_STATUS", "VALUE_TRANSACTION_STATUS", "from", "Lcom/adyen/checkout/adyen3ds2/model/ChallengeResult;", "completionEvent", "Lcom/adyen/threeds2/CompletionEvent;", "authorisationToken", "3ds2_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: ChallengeResult.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ ChallengeResult from$default(Companion companion, CompletionEvent completionEvent, String str, int i, Object obj) throws JSONException {
            if ((i & 2) != 0) {
                str = null;
            }
            return companion.from(completionEvent, str);
        }

        public final ChallengeResult from(CompletionEvent completionEvent, String str) throws JSONException {
            Intrinsics.checkNotNullParameter(completionEvent, "completionEvent");
            String transactionStatus = completionEvent.getTransactionStatus();
            boolean areEqual = Intrinsics.areEqual((Object) "Y", (Object) transactionStatus);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(ChallengeResult.f545c, transactionStatus);
            jSONObject.putOpt(ChallengeResult.f546d, str);
            String encode = Base64Encoder.encode(jSONObject.toString());
            Intrinsics.checkNotNullExpressionValue(encode, "encode(jsonObject.toString())");
            return new ChallengeResult(areEqual, encode, (DefaultConstructorMarker) null);
        }
    }
}
