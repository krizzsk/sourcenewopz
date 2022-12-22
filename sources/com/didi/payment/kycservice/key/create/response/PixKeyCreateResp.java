package com.didi.payment.kycservice.key.create.response;

import com.didi.payment.commonsdk.net.WBaseResp;
import com.didi.payment.kycservice.kyc.response.MigrateTipData;
import com.didi.payment.kycservice.kyc.response.ResultPageData;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0002\t\nB\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/payment/kycservice/key/create/response/PixKeyCreateResp;", "Lcom/didi/payment/commonsdk/net/WBaseResp;", "()V", "data", "Lcom/didi/payment/kycservice/key/create/response/PixKeyCreateResp$Data;", "getData", "()Lcom/didi/payment/kycservice/key/create/response/PixKeyCreateResp$Data;", "setData", "(Lcom/didi/payment/kycservice/key/create/response/PixKeyCreateResp$Data;)V", "Companion", "Data", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PixKeyCreateResp.kt */
public final class PixKeyCreateResp extends WBaseResp {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int NET_ERR_CODE_KYC_FAIL = 60221;
    public static final int NET_ERR_CODE_OVER5 = 60205;
    public static final int PIX_KEY_UNDER_REVIEW_KEY_PENDING_MIGRATE_ERROR = 60208;
    public static final int PIX_KEY_UNDER_REVIEW_KEY_PENDING_REGISTER_ERROR = 60207;
    @SerializedName("data")
    private Data data;

    public final Data getData() {
        return this.data;
    }

    public final void setData(Data data2) {
        this.data = data2;
    }

    @Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR \u0010\u0015\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, mo175978d2 = {"Lcom/didi/payment/kycservice/key/create/response/PixKeyCreateResp$Data;", "", "()V", "faceStatus", "", "getFaceStatus", "()I", "setFaceStatus", "(I)V", "kycStatus", "getKycStatus", "setKycStatus", "migrateTipData", "Lcom/didi/payment/kycservice/kyc/response/MigrateTipData;", "getMigrateTipData", "()Lcom/didi/payment/kycservice/kyc/response/MigrateTipData;", "setMigrateTipData", "(Lcom/didi/payment/kycservice/kyc/response/MigrateTipData;)V", "pixStatus", "getPixStatus", "setPixStatus", "resultData", "Lcom/didi/payment/kycservice/kyc/response/ResultPageData;", "getResultData", "()Lcom/didi/payment/kycservice/kyc/response/ResultPageData;", "setResultData", "(Lcom/didi/payment/kycservice/kyc/response/ResultPageData;)V", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PixKeyCreateResp.kt */
    public static final class Data {
        @SerializedName("authenticationStatus")
        private int faceStatus;
        @SerializedName("status")
        private int kycStatus;
        @SerializedName("migrateDetail")
        private MigrateTipData migrateTipData;
        private int pixStatus;
        @SerializedName("resultEntryFormat")
        private ResultPageData resultData;

        public final int getPixStatus() {
            return this.pixStatus;
        }

        public final void setPixStatus(int i) {
            this.pixStatus = i;
        }

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

        public final MigrateTipData getMigrateTipData() {
            return this.migrateTipData;
        }

        public final void setMigrateTipData(MigrateTipData migrateTipData2) {
            this.migrateTipData = migrateTipData2;
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, mo175978d2 = {"Lcom/didi/payment/kycservice/key/create/response/PixKeyCreateResp$Companion;", "", "()V", "NET_ERR_CODE_KYC_FAIL", "", "NET_ERR_CODE_OVER5", "PIX_KEY_UNDER_REVIEW_KEY_PENDING_MIGRATE_ERROR", "PIX_KEY_UNDER_REVIEW_KEY_PENDING_REGISTER_ERROR", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PixKeyCreateResp.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
