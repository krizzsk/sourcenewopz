package com.didi.payment.kycservice.net.response;

import com.didi.payment.commonsdk.net.WBaseResp;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\n"}, mo175978d2 = {"Lcom/didi/payment/kycservice/net/response/FaceSessionResp;", "Lcom/didi/payment/commonsdk/net/WBaseResp;", "()V", "data", "Lcom/didi/payment/kycservice/net/response/FaceSessionResp$Data;", "getData", "()Lcom/didi/payment/kycservice/net/response/FaceSessionResp$Data;", "setData", "(Lcom/didi/payment/kycservice/net/response/FaceSessionResp$Data;)V", "Data", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FaceSessionResp.kt */
public final class FaceSessionResp extends WBaseResp {
    @SerializedName("data")
    public Data data;

    public final Data getData() {
        Data data2 = this.data;
        if (data2 != null) {
            return data2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("data");
        return null;
    }

    public final void setData(Data data2) {
        Intrinsics.checkNotNullParameter(data2, "<set-?>");
        this.data = data2;
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, mo175978d2 = {"Lcom/didi/payment/kycservice/net/response/FaceSessionResp$Data;", "", "()V", "bizCode", "", "getBizCode", "()Ljava/lang/String;", "setBizCode", "(Ljava/lang/String;)V", "sessionId", "getSessionId", "setSessionId", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: FaceSessionResp.kt */
    public static final class Data {
        private String bizCode;
        private String sessionId;

        public final String getSessionId() {
            return this.sessionId;
        }

        public final void setSessionId(String str) {
            this.sessionId = str;
        }

        public final String getBizCode() {
            return this.bizCode;
        }

        public final void setBizCode(String str) {
            this.bizCode = str;
        }
    }
}
