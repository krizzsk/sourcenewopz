package com.didi.payment.kycservice.kyc.response;

import com.didi.payment.commonsdk.net.WBaseResp;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\n"}, mo175978d2 = {"Lcom/didi/payment/kycservice/kyc/response/JumioCheckResp;", "Lcom/didi/payment/commonsdk/net/WBaseResp;", "()V", "data", "Lcom/didi/payment/kycservice/kyc/response/JumioCheckResp$Data;", "getData", "()Lcom/didi/payment/kycservice/kyc/response/JumioCheckResp$Data;", "setData", "(Lcom/didi/payment/kycservice/kyc/response/JumioCheckResp$Data;)V", "Data", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: JumioCheckResp.kt */
public final class JumioCheckResp extends WBaseResp {
    @SerializedName("data")
    private Data data;

    public final Data getData() {
        return this.data;
    }

    public final void setData(Data data2) {
        this.data = data2;
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, mo175978d2 = {"Lcom/didi/payment/kycservice/kyc/response/JumioCheckResp$Data;", "Ljava/io/Serializable;", "()V", "resultEntryFormat", "Lcom/didi/payment/kycservice/kyc/response/ResultPageData;", "getResultEntryFormat", "()Lcom/didi/payment/kycservice/kyc/response/ResultPageData;", "setResultEntryFormat", "(Lcom/didi/payment/kycservice/kyc/response/ResultPageData;)V", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: JumioCheckResp.kt */
    public static final class Data implements Serializable {
        private ResultPageData resultEntryFormat;

        public final ResultPageData getResultEntryFormat() {
            return this.resultEntryFormat;
        }

        public final void setResultEntryFormat(ResultPageData resultPageData) {
            this.resultEntryFormat = resultPageData;
        }
    }
}
