package com.didi.payment.kycservice.key.create.response;

import com.didi.payment.commonsdk.net.WBaseResp;
import com.didi.payment.kycservice.kyc.response.MigrateTipData;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\n"}, mo175978d2 = {"Lcom/didi/payment/kycservice/key/create/response/PollStatusResp;", "Lcom/didi/payment/commonsdk/net/WBaseResp;", "()V", "data", "Lcom/didi/payment/kycservice/key/create/response/PollStatusResp$Data;", "getData", "()Lcom/didi/payment/kycservice/key/create/response/PollStatusResp$Data;", "setData", "(Lcom/didi/payment/kycservice/key/create/response/PollStatusResp$Data;)V", "Data", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PollStatusResp.kt */
public final class PollStatusResp extends WBaseResp {
    @SerializedName("data")
    private Data data;

    public final Data getData() {
        return this.data;
    }

    public final void setData(Data data2) {
        this.data = data2;
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, mo175978d2 = {"Lcom/didi/payment/kycservice/key/create/response/PollStatusResp$Data;", "", "()V", "migrateTipData", "Lcom/didi/payment/kycservice/kyc/response/MigrateTipData;", "getMigrateTipData", "()Lcom/didi/payment/kycservice/kyc/response/MigrateTipData;", "setMigrateTipData", "(Lcom/didi/payment/kycservice/kyc/response/MigrateTipData;)V", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PollStatusResp.kt */
    public static final class Data {
        @SerializedName("migrateDetail")
        private MigrateTipData migrateTipData;

        public final MigrateTipData getMigrateTipData() {
            return this.migrateTipData;
        }

        public final void setMigrateTipData(MigrateTipData migrateTipData2) {
            this.migrateTipData = migrateTipData2;
        }
    }
}
