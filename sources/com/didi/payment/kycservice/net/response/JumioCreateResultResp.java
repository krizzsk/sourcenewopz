package com.didi.payment.kycservice.net.response;

import com.didi.payment.commonsdk.net.WBaseResp;
import com.didi.payment.kycservice.kyc.response.GuidesInfoResp;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\n"}, mo175978d2 = {"Lcom/didi/payment/kycservice/net/response/JumioCreateResultResp;", "Lcom/didi/payment/commonsdk/net/WBaseResp;", "()V", "data", "Lcom/didi/payment/kycservice/net/response/JumioCreateResultResp$Data;", "getData", "()Lcom/didi/payment/kycservice/net/response/JumioCreateResultResp$Data;", "setData", "(Lcom/didi/payment/kycservice/net/response/JumioCreateResultResp$Data;)V", "Data", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: JumioCreateResultResp.kt */
public final class JumioCreateResultResp extends WBaseResp {
    @SerializedName("data")
    private Data data;

    public final Data getData() {
        return this.data;
    }

    public final void setData(Data data2) {
        this.data = data2;
    }

    @Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\"\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\b¨\u0006!"}, mo175978d2 = {"Lcom/didi/payment/kycservice/net/response/JumioCreateResultResp$Data;", "Ljava/io/Serializable;", "()V", "country", "", "getCountry", "()Ljava/lang/String;", "setCountry", "(Ljava/lang/String;)V", "dateCenter", "getDateCenter", "setDateCenter", "exitDetail", "Lcom/didi/payment/kycservice/kyc/response/GuidesInfoResp$ExitDetail;", "getExitDetail", "()Lcom/didi/payment/kycservice/kyc/response/GuidesInfoResp$ExitDetail;", "setExitDetail", "(Lcom/didi/payment/kycservice/kyc/response/GuidesInfoResp$ExitDetail;)V", "sdkToken", "getSdkToken", "setSdkToken", "tipsList", "", "getTipsList", "()Ljava/util/List;", "setTipsList", "(Ljava/util/List;)V", "tipsTitle", "getTipsTitle", "setTipsTitle", "workflowId", "getWorkflowId", "setWorkflowId", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: JumioCreateResultResp.kt */
    public static final class Data implements Serializable {
        private String country;
        private String dateCenter;
        private GuidesInfoResp.ExitDetail exitDetail;
        private String sdkToken;
        private List<String> tipsList;
        private String tipsTitle;
        private String workflowId;

        public final String getSdkToken() {
            return this.sdkToken;
        }

        public final void setSdkToken(String str) {
            this.sdkToken = str;
        }

        public final String getWorkflowId() {
            return this.workflowId;
        }

        public final void setWorkflowId(String str) {
            this.workflowId = str;
        }

        public final String getDateCenter() {
            return this.dateCenter;
        }

        public final void setDateCenter(String str) {
            this.dateCenter = str;
        }

        public final String getCountry() {
            return this.country;
        }

        public final void setCountry(String str) {
            this.country = str;
        }

        public final String getTipsTitle() {
            return this.tipsTitle;
        }

        public final void setTipsTitle(String str) {
            this.tipsTitle = str;
        }

        public final List<String> getTipsList() {
            return this.tipsList;
        }

        public final void setTipsList(List<String> list) {
            this.tipsList = list;
        }

        public final GuidesInfoResp.ExitDetail getExitDetail() {
            return this.exitDetail;
        }

        public final void setExitDetail(GuidesInfoResp.ExitDetail exitDetail2) {
            this.exitDetail = exitDetail2;
        }
    }
}
