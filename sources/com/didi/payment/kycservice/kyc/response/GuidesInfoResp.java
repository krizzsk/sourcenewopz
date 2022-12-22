package com.didi.payment.kycservice.kyc.response;

import com.didi.payment.commonsdk.net.WBaseResp;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u0006\t\n\u000b\f\r\u000eB\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000f"}, mo175978d2 = {"Lcom/didi/payment/kycservice/kyc/response/GuidesInfoResp;", "Lcom/didi/payment/commonsdk/net/WBaseResp;", "()V", "data", "Lcom/didi/payment/kycservice/kyc/response/GuidesInfoResp$Data;", "getData", "()Lcom/didi/payment/kycservice/kyc/response/GuidesInfoResp$Data;", "setData", "(Lcom/didi/payment/kycservice/kyc/response/GuidesInfoResp$Data;)V", "Data", "ExitDetail", "GuideData", "Income", "StepInfo", "TipsInfo", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GuidesInfoResp.kt */
public final class GuidesInfoResp extends WBaseResp {
    @SerializedName("data")
    private Data data;

    public final Data getData() {
        return this.data;
    }

    public final void setData(Data data2) {
        this.data = data2;
    }

    @Metadata(mo175977d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR \u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010\u001f\u001a\u00020\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\f\"\u0004\b!\u0010\u000eR\u001a\u0010\"\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\f\"\u0004\b$\u0010\u000eR\u001a\u0010%\u001a\u00020&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010(\"\u0004\b-\u0010*R\u001e\u0010.\u001a\u0004\u0018\u00010&X\u000e¢\u0006\u0010\n\u0002\u00103\u001a\u0004\b/\u00100\"\u0004\b1\u00102R \u00104\u001a\u0004\u0018\u0001058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R2\u0010:\u001a\u0016\u0012\u0004\u0012\u00020<\u0018\u00010;j\n\u0012\u0004\u0012\u00020<\u0018\u0001`=8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u001a\u0010B\u001a\u00020&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010(\"\u0004\bD\u0010*¨\u0006E"}, mo175978d2 = {"Lcom/didi/payment/kycservice/kyc/response/GuidesInfoResp$Data;", "Ljava/io/Serializable;", "()V", "exitDetail", "Lcom/didi/payment/kycservice/kyc/response/GuidesInfoResp$ExitDetail;", "getExitDetail", "()Lcom/didi/payment/kycservice/kyc/response/GuidesInfoResp$ExitDetail;", "setExitDetail", "(Lcom/didi/payment/kycservice/kyc/response/GuidesInfoResp$ExitDetail;)V", "faceStatus", "", "getFaceStatus", "()I", "setFaceStatus", "(I)V", "fullKycStatus", "getFullKycStatus", "setFullKycStatus", "guideData", "Lcom/didi/payment/kycservice/kyc/response/GuidesInfoResp$GuideData;", "getGuideData", "()Lcom/didi/payment/kycservice/kyc/response/GuidesInfoResp$GuideData;", "setGuideData", "(Lcom/didi/payment/kycservice/kyc/response/GuidesInfoResp$GuideData;)V", "incomeDetailList", "Ljava/util/LinkedList;", "Lcom/didi/payment/kycservice/kyc/response/GuidesInfoResp$Income;", "getIncomeDetailList", "()Ljava/util/LinkedList;", "setIncomeDetailList", "(Ljava/util/LinkedList;)V", "kycStatus", "getKycStatus", "setKycStatus", "latourKycStatus", "getLatourKycStatus", "setLatourKycStatus", "needDoorGod", "", "getNeedDoorGod", "()Z", "setNeedDoorGod", "(Z)V", "needSkipPage", "getNeedSkipPage", "setNeedSkipPage", "pixStatus", "getPixStatus", "()Ljava/lang/Boolean;", "setPixStatus", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "resultData", "Lcom/didi/payment/kycservice/kyc/response/ResultPageData;", "getResultData", "()Lcom/didi/payment/kycservice/kyc/response/ResultPageData;", "setResultData", "(Lcom/didi/payment/kycservice/kyc/response/ResultPageData;)V", "stepList", "Ljava/util/ArrayList;", "Lcom/didi/payment/kycservice/kyc/response/GuidesInfoResp$StepInfo;", "Lkotlin/collections/ArrayList;", "getStepList", "()Ljava/util/ArrayList;", "setStepList", "(Ljava/util/ArrayList;)V", "supportFullKyc", "getSupportFullKyc", "setSupportFullKyc", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: GuidesInfoResp.kt */
    public static final class Data implements Serializable {
        private ExitDetail exitDetail;
        @SerializedName("authenticationStatus")
        private int faceStatus;
        private int fullKycStatus;
        @SerializedName("noviceGuide")
        private GuideData guideData;
        private LinkedList<Income> incomeDetailList;
        @SerializedName("status")
        private int kycStatus;
        private int latourKycStatus;
        private boolean needDoorGod = true;
        private boolean needSkipPage;
        private Boolean pixStatus;
        @SerializedName("resultEntryFormat")
        private ResultPageData resultData;
        @SerializedName("stepList")
        private ArrayList<StepInfo> stepList;
        private boolean supportFullKyc;

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

        public final int getFullKycStatus() {
            return this.fullKycStatus;
        }

        public final void setFullKycStatus(int i) {
            this.fullKycStatus = i;
        }

        public final int getLatourKycStatus() {
            return this.latourKycStatus;
        }

        public final void setLatourKycStatus(int i) {
            this.latourKycStatus = i;
        }

        public final GuideData getGuideData() {
            return this.guideData;
        }

        public final void setGuideData(GuideData guideData2) {
            this.guideData = guideData2;
        }

        public final ArrayList<StepInfo> getStepList() {
            return this.stepList;
        }

        public final void setStepList(ArrayList<StepInfo> arrayList) {
            this.stepList = arrayList;
        }

        public final ResultPageData getResultData() {
            return this.resultData;
        }

        public final void setResultData(ResultPageData resultPageData) {
            this.resultData = resultPageData;
        }

        public final boolean getSupportFullKyc() {
            return this.supportFullKyc;
        }

        public final void setSupportFullKyc(boolean z) {
            this.supportFullKyc = z;
        }

        public final Boolean getPixStatus() {
            return this.pixStatus;
        }

        public final void setPixStatus(Boolean bool) {
            this.pixStatus = bool;
        }

        public final boolean getNeedDoorGod() {
            return this.needDoorGod;
        }

        public final void setNeedDoorGod(boolean z) {
            this.needDoorGod = z;
        }

        public final boolean getNeedSkipPage() {
            return this.needSkipPage;
        }

        public final void setNeedSkipPage(boolean z) {
            this.needSkipPage = z;
        }

        public final LinkedList<Income> getIncomeDetailList() {
            return this.incomeDetailList;
        }

        public final void setIncomeDetailList(LinkedList<Income> linkedList) {
            this.incomeDetailList = linkedList;
        }

        public final ExitDetail getExitDetail() {
            return this.exitDetail;
        }

        public final void setExitDetail(ExitDetail exitDetail2) {
            this.exitDetail = exitDetail2;
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, mo175978d2 = {"Lcom/didi/payment/kycservice/kyc/response/GuidesInfoResp$Income;", "Ljava/io/Serializable;", "()V", "display", "", "getDisplay", "()Ljava/lang/String;", "setDisplay", "(Ljava/lang/String;)V", "type", "getType", "setType", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: GuidesInfoResp.kt */
    public static final class Income implements Serializable {
        private String display = "";
        private String type = "";

        public final String getDisplay() {
            return this.display;
        }

        public final void setDisplay(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.display = str;
        }

        public final String getType() {
            return this.type;
        }

        public final void setType(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.type = str;
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0012"}, mo175978d2 = {"Lcom/didi/payment/kycservice/kyc/response/GuidesInfoResp$ExitDetail;", "Ljava/io/Serializable;", "()V", "firstBtn", "", "getFirstBtn", "()Ljava/lang/String;", "setFirstBtn", "(Ljava/lang/String;)V", "secondBtn", "getSecondBtn", "setSecondBtn", "subTitle", "getSubTitle", "setSubTitle", "title", "getTitle", "setTitle", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: GuidesInfoResp.kt */
    public static final class ExitDetail implements Serializable {
        private String firstBtn = "";
        private String secondBtn = "";
        private String subTitle = "";
        private String title = "";

        public final String getTitle() {
            return this.title;
        }

        public final void setTitle(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.title = str;
        }

        public final String getSubTitle() {
            return this.subTitle;
        }

        public final void setSubTitle(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.subTitle = str;
        }

        public final String getFirstBtn() {
            return this.firstBtn;
        }

        public final void setFirstBtn(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.firstBtn = str;
        }

        public final String getSecondBtn() {
            return this.secondBtn;
        }

        public final void setSecondBtn(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.secondBtn = str;
        }
    }

    @Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR.\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016j\n\u0012\u0004\u0012\u00020\u0017\u0018\u0001`\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, mo175978d2 = {"Lcom/didi/payment/kycservice/kyc/response/GuidesInfoResp$GuideData;", "Ljava/io/Serializable;", "()V", "desc", "", "getDesc", "()Ljava/lang/String;", "setDesc", "(Ljava/lang/String;)V", "explainText", "getExplainText", "setExplainText", "iconUrl", "getIconUrl", "setIconUrl", "noviceTitle", "getNoviceTitle", "setNoviceTitle", "registerBtn", "getRegisterBtn", "setRegisterBtn", "tipsList", "Ljava/util/ArrayList;", "Lcom/didi/payment/kycservice/kyc/response/GuidesInfoResp$TipsInfo;", "Lkotlin/collections/ArrayList;", "getTipsList", "()Ljava/util/ArrayList;", "setTipsList", "(Ljava/util/ArrayList;)V", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: GuidesInfoResp.kt */
    public static final class GuideData implements Serializable {
        private String desc = "";
        private String explainText = "";
        private String iconUrl = "";
        private String noviceTitle = "";
        private String registerBtn = "";
        private ArrayList<TipsInfo> tipsList;

        public final String getNoviceTitle() {
            return this.noviceTitle;
        }

        public final void setNoviceTitle(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.noviceTitle = str;
        }

        public final String getDesc() {
            return this.desc;
        }

        public final void setDesc(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.desc = str;
        }

        public final String getIconUrl() {
            return this.iconUrl;
        }

        public final void setIconUrl(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.iconUrl = str;
        }

        public final String getExplainText() {
            return this.explainText;
        }

        public final void setExplainText(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.explainText = str;
        }

        public final ArrayList<TipsInfo> getTipsList() {
            return this.tipsList;
        }

        public final void setTipsList(ArrayList<TipsInfo> arrayList) {
            this.tipsList = arrayList;
        }

        public final String getRegisterBtn() {
            return this.registerBtn;
        }

        public final void setRegisterBtn(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.registerBtn = str;
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, mo175978d2 = {"Lcom/didi/payment/kycservice/kyc/response/GuidesInfoResp$StepInfo;", "Ljava/io/Serializable;", "()V", "status", "", "getStatus", "()I", "setStatus", "(I)V", "stepType", "getStepType", "setStepType", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: GuidesInfoResp.kt */
    public static final class StepInfo implements Serializable {
        private int status;
        private int stepType = 1;

        public final int getStepType() {
            return this.stepType;
        }

        public final void setStepType(int i) {
            this.stepType = i;
        }

        public final int getStatus() {
            return this.status;
        }

        public final void setStatus(int i) {
            this.status = i;
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, mo175978d2 = {"Lcom/didi/payment/kycservice/kyc/response/GuidesInfoResp$TipsInfo;", "Ljava/io/Serializable;", "()V", "content", "", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "tipIconUrl", "getTipIconUrl", "setTipIconUrl", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: GuidesInfoResp.kt */
    public static final class TipsInfo implements Serializable {
        private String content = "";
        private String tipIconUrl = "";

        public final String getContent() {
            return this.content;
        }

        public final void setContent(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.content = str;
        }

        public final String getTipIconUrl() {
            return this.tipIconUrl;
        }

        public final void setTipIconUrl(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.tipIconUrl = str;
        }
    }
}
