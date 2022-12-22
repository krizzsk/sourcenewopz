package com.didi.payment.kycservice.net.response;

import com.didi.payment.commonsdk.net.WBaseResp;
import com.didi.payment.kycservice.kyc.response.ResultPageData;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0005\t\n\u000b\f\rB\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000e"}, mo175978d2 = {"Lcom/didi/payment/kycservice/net/response/SubmitKycInfoV1Resp;", "Lcom/didi/payment/commonsdk/net/WBaseResp;", "()V", "data", "Lcom/didi/payment/kycservice/net/response/SubmitKycInfoV1Resp$DataBean;", "getData", "()Lcom/didi/payment/kycservice/net/response/SubmitKycInfoV1Resp$DataBean;", "setData", "(Lcom/didi/payment/kycservice/net/response/SubmitKycInfoV1Resp$DataBean;)V", "DataBean", "EntryInfo", "ExtraButton", "ResultEntryFormat", "RichInfo", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SubmitKycInfoV1Resp.kt */
public final class SubmitKycInfoV1Resp extends WBaseResp {
    @SerializedName("data")
    public DataBean data;

    public final DataBean getData() {
        DataBean dataBean = this.data;
        if (dataBean != null) {
            return dataBean;
        }
        Intrinsics.throwUninitializedPropertyAccessException("data");
        return null;
    }

    public final void setData(DataBean dataBean) {
        Intrinsics.checkNotNullParameter(dataBean, "<set-?>");
        this.data = dataBean;
    }

    @Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, mo175978d2 = {"Lcom/didi/payment/kycservice/net/response/SubmitKycInfoV1Resp$DataBean;", "Ljava/io/Serializable;", "()V", "bizCode", "", "getBizCode", "()Ljava/lang/String;", "setBizCode", "(Ljava/lang/String;)V", "externalId", "getExternalId", "setExternalId", "resultEntryFormat", "Lcom/didi/payment/kycservice/kyc/response/ResultPageData;", "getResultEntryFormat", "()Lcom/didi/payment/kycservice/kyc/response/ResultPageData;", "setResultEntryFormat", "(Lcom/didi/payment/kycservice/kyc/response/ResultPageData;)V", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: SubmitKycInfoV1Resp.kt */
    public static final class DataBean implements Serializable {
        private String bizCode;
        private String externalId;
        @SerializedName("resultEntryFormat")
        private ResultPageData resultEntryFormat;

        public final ResultPageData getResultEntryFormat() {
            return this.resultEntryFormat;
        }

        public final void setResultEntryFormat(ResultPageData resultPageData) {
            this.resultEntryFormat = resultPageData;
        }

        public final String getBizCode() {
            return this.bizCode;
        }

        public final void setBizCode(String str) {
            this.bizCode = str;
        }

        public final String getExternalId() {
            return this.externalId;
        }

        public final void setExternalId(String str) {
            this.externalId = str;
        }
    }

    @Metadata(mo175977d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R.\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016j\n\u0012\u0004\u0012\u00020\u0017\u0018\u0001`\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006)"}, mo175978d2 = {"Lcom/didi/payment/kycservice/net/response/SubmitKycInfoV1Resp$ResultEntryFormat;", "Ljava/io/Serializable;", "()V", "btnText", "", "getBtnText", "()Ljava/lang/String;", "setBtnText", "(Ljava/lang/String;)V", "centerSubTitle", "getCenterSubTitle", "setCenterSubTitle", "centerTitle", "getCenterTitle", "setCenterTitle", "clickAction", "", "getClickAction", "()I", "setClickAction", "(I)V", "entryList", "Ljava/util/ArrayList;", "Lcom/didi/payment/kycservice/net/response/SubmitKycInfoV1Resp$EntryInfo;", "Lkotlin/collections/ArrayList;", "getEntryList", "()Ljava/util/ArrayList;", "setEntryList", "(Ljava/util/ArrayList;)V", "extraButton", "Lcom/didi/payment/kycservice/net/response/SubmitKycInfoV1Resp$ExtraButton;", "getExtraButton", "()Lcom/didi/payment/kycservice/net/response/SubmitKycInfoV1Resp$ExtraButton;", "setExtraButton", "(Lcom/didi/payment/kycservice/net/response/SubmitKycInfoV1Resp$ExtraButton;)V", "richIcon", "Lcom/didi/payment/kycservice/net/response/SubmitKycInfoV1Resp$RichInfo;", "getRichIcon", "()Lcom/didi/payment/kycservice/net/response/SubmitKycInfoV1Resp$RichInfo;", "setRichIcon", "(Lcom/didi/payment/kycservice/net/response/SubmitKycInfoV1Resp$RichInfo;)V", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: SubmitKycInfoV1Resp.kt */
    public static final class ResultEntryFormat implements Serializable {
        private String btnText = "";
        private String centerSubTitle = "";
        private String centerTitle = "";
        private int clickAction;
        private ArrayList<EntryInfo> entryList;
        private ExtraButton extraButton;
        private RichInfo richIcon;

        public final String getBtnText() {
            return this.btnText;
        }

        public final void setBtnText(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.btnText = str;
        }

        public final int getClickAction() {
            return this.clickAction;
        }

        public final void setClickAction(int i) {
            this.clickAction = i;
        }

        public final ArrayList<EntryInfo> getEntryList() {
            return this.entryList;
        }

        public final void setEntryList(ArrayList<EntryInfo> arrayList) {
            this.entryList = arrayList;
        }

        public final RichInfo getRichIcon() {
            return this.richIcon;
        }

        public final void setRichIcon(RichInfo richInfo) {
            this.richIcon = richInfo;
        }

        public final String getCenterTitle() {
            return this.centerTitle;
        }

        public final void setCenterTitle(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.centerTitle = str;
        }

        public final String getCenterSubTitle() {
            return this.centerSubTitle;
        }

        public final void setCenterSubTitle(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.centerSubTitle = str;
        }

        public final ExtraButton getExtraButton() {
            return this.extraButton;
        }

        public final void setExtraButton(ExtraButton extraButton2) {
            this.extraButton = extraButton2;
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, mo175978d2 = {"Lcom/didi/payment/kycservice/net/response/SubmitKycInfoV1Resp$EntryInfo;", "Ljava/io/Serializable;", "()V", "desc", "", "getDesc", "()Ljava/lang/String;", "setDesc", "(Ljava/lang/String;)V", "title", "getTitle", "setTitle", "type", "", "getType", "()I", "setType", "(I)V", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: SubmitKycInfoV1Resp.kt */
    public static final class EntryInfo implements Serializable {
        private String desc = "";
        private String title = "";
        private int type;

        public final String getTitle() {
            return this.title;
        }

        public final void setTitle(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.title = str;
        }

        public final String getDesc() {
            return this.desc;
        }

        public final void setDesc(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.desc = str;
        }

        public final int getType() {
            return this.type;
        }

        public final void setType(int i) {
            this.type = i;
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, mo175978d2 = {"Lcom/didi/payment/kycservice/net/response/SubmitKycInfoV1Resp$RichInfo;", "Ljava/io/Serializable;", "()V", "iconUrl", "", "getIconUrl", "()Ljava/lang/String;", "setIconUrl", "(Ljava/lang/String;)V", "size", "", "getSize", "()I", "setSize", "(I)V", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: SubmitKycInfoV1Resp.kt */
    public static final class RichInfo implements Serializable {
        private String iconUrl = "";
        private int size;

        public final String getIconUrl() {
            return this.iconUrl;
        }

        public final void setIconUrl(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.iconUrl = str;
        }

        public final int getSize() {
            return this.size;
        }

        public final void setSize(int i) {
            this.size = i;
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, mo175978d2 = {"Lcom/didi/payment/kycservice/net/response/SubmitKycInfoV1Resp$ExtraButton;", "Ljava/io/Serializable;", "()V", "extraBtnText", "", "getExtraBtnText", "()Ljava/lang/String;", "setExtraBtnText", "(Ljava/lang/String;)V", "link", "getLink", "setLink", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: SubmitKycInfoV1Resp.kt */
    public static final class ExtraButton implements Serializable {
        private String extraBtnText = "";
        private String link = "";

        public final String getExtraBtnText() {
            return this.extraBtnText;
        }

        public final void setExtraBtnText(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.extraBtnText = str;
        }

        public final String getLink() {
            return this.link;
        }

        public final void setLink(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.link = str;
        }
    }
}
