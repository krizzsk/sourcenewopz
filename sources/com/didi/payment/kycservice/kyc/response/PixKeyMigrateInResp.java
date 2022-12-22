package com.didi.payment.kycservice.kyc.response;

import com.didi.payment.commonsdk.net.WBaseResp;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\n"}, mo175978d2 = {"Lcom/didi/payment/kycservice/kyc/response/PixKeyMigrateInResp;", "Lcom/didi/payment/commonsdk/net/WBaseResp;", "()V", "data", "Lcom/didi/payment/kycservice/kyc/response/PixKeyMigrateInResp$Data;", "getData", "()Lcom/didi/payment/kycservice/kyc/response/PixKeyMigrateInResp$Data;", "setData", "(Lcom/didi/payment/kycservice/kyc/response/PixKeyMigrateInResp$Data;)V", "Data", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PixKeyMigrateInResp.kt */
public final class PixKeyMigrateInResp extends WBaseResp {
    @SerializedName("data")
    private Data data;

    public final Data getData() {
        return this.data;
    }

    public final void setData(Data data2) {
        this.data = data2;
    }

    @Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, mo175978d2 = {"Lcom/didi/payment/kycservice/kyc/response/PixKeyMigrateInResp$Data;", "Ljava/io/Serializable;", "()V", "faceStatus", "", "getFaceStatus", "()I", "setFaceStatus", "(I)V", "kycStatus", "getKycStatus", "setKycStatus", "resultData", "Lcom/didi/payment/kycservice/kyc/response/ResultPageData;", "getResultData", "()Lcom/didi/payment/kycservice/kyc/response/ResultPageData;", "setResultData", "(Lcom/didi/payment/kycservice/kyc/response/ResultPageData;)V", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PixKeyMigrateInResp.kt */
    public static final class Data implements Serializable {
        @SerializedName("authenticationStatus")
        private int faceStatus;
        @SerializedName("status")
        private int kycStatus;
        @SerializedName("resultEntryFormat")
        private ResultPageData resultData;

        public final int getKycStatus() {
            return this.kycStatus;
        }

        public final void setKycStatus(int i) {
            this.kycStatus = i;
        }

        public final int getFaceStatus() {
            return this.faceStatus;
        }

        public final void setFaceStatus(int i) {
            this.faceStatus = i;
        }

        public final ResultPageData getResultData() {
            return this.resultData;
        }

        public final void setResultData(ResultPageData resultPageData) {
            this.resultData = resultPageData;
        }
    }
}
