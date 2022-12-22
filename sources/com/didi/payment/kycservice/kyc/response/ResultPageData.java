package com.didi.payment.kycservice.kyc.response;

import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0003:;<B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R.\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016j\n\u0012\u0004\u0012\u00020\u0017\u0018\u0001`\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0012\"\u0004\b%\u0010\u0014R\u001e\u0010&\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u0010\n\u0002\u0010+\u001a\u0004\b&\u0010(\"\u0004\b)\u0010*R\u001a\u0010,\u001a\u00020'X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001a\u00101\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0012\"\u0004\b3\u0010\u0014R\u001c\u00104\u001a\u0004\u0018\u000105X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109¨\u0006="}, mo175978d2 = {"Lcom/didi/payment/kycservice/kyc/response/ResultPageData;", "Ljava/io/Serializable;", "()V", "btnText", "", "getBtnText", "()Ljava/lang/String;", "setBtnText", "(Ljava/lang/String;)V", "centerSubTitle", "getCenterSubTitle", "setCenterSubTitle", "centerTitle", "getCenterTitle", "setCenterTitle", "clickAction", "", "getClickAction", "()I", "setClickAction", "(I)V", "entryList", "Ljava/util/ArrayList;", "Lcom/didi/payment/kycservice/kyc/response/ResultPageData$ItemInfo;", "Lkotlin/collections/ArrayList;", "getEntryList", "()Ljava/util/ArrayList;", "setEntryList", "(Ljava/util/ArrayList;)V", "extraButton", "Lcom/didi/payment/kycservice/kyc/response/ResultPageData$ExtraButton;", "getExtraButton", "()Lcom/didi/payment/kycservice/kyc/response/ResultPageData$ExtraButton;", "setExtraButton", "(Lcom/didi/payment/kycservice/kyc/response/ResultPageData$ExtraButton;)V", "faceStatus", "getFaceStatus", "setFaceStatus", "isPix", "", "()Ljava/lang/Boolean;", "setPix", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "keyStatus", "getKeyStatus", "()Z", "setKeyStatus", "(Z)V", "kycStatus", "getKycStatus", "setKycStatus", "richIcon", "Lcom/didi/payment/kycservice/kyc/response/ResultPageData$IconInfo;", "getRichIcon", "()Lcom/didi/payment/kycservice/kyc/response/ResultPageData$IconInfo;", "setRichIcon", "(Lcom/didi/payment/kycservice/kyc/response/ResultPageData$IconInfo;)V", "ExtraButton", "IconInfo", "ItemInfo", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ResultPageData.kt */
public final class ResultPageData implements Serializable {
    private String btnText = "";
    private String centerSubTitle;
    private String centerTitle;
    private int clickAction;
    private ArrayList<ItemInfo> entryList;
    private ExtraButton extraButton;
    private int faceStatus;
    private Boolean isPix = false;
    private boolean keyStatus;
    private int kycStatus;
    private IconInfo richIcon;

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

    public final boolean getKeyStatus() {
        return this.keyStatus;
    }

    public final void setKeyStatus(boolean z) {
        this.keyStatus = z;
    }

    public final String getCenterTitle() {
        return this.centerTitle;
    }

    public final void setCenterTitle(String str) {
        this.centerTitle = str;
    }

    public final String getCenterSubTitle() {
        return this.centerSubTitle;
    }

    public final void setCenterSubTitle(String str) {
        this.centerSubTitle = str;
    }

    public final IconInfo getRichIcon() {
        return this.richIcon;
    }

    public final void setRichIcon(IconInfo iconInfo) {
        this.richIcon = iconInfo;
    }

    public final int getClickAction() {
        return this.clickAction;
    }

    public final void setClickAction(int i) {
        this.clickAction = i;
    }

    public final String getBtnText() {
        return this.btnText;
    }

    public final void setBtnText(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.btnText = str;
    }

    public final ArrayList<ItemInfo> getEntryList() {
        return this.entryList;
    }

    public final void setEntryList(ArrayList<ItemInfo> arrayList) {
        this.entryList = arrayList;
    }

    public final ExtraButton getExtraButton() {
        return this.extraButton;
    }

    public final void setExtraButton(ExtraButton extraButton2) {
        this.extraButton = extraButton2;
    }

    public final Boolean isPix() {
        return this.isPix;
    }

    public final void setPix(Boolean bool) {
        this.isPix = bool;
    }

    @Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/payment/kycservice/kyc/response/ResultPageData$IconInfo;", "Ljava/io/Serializable;", "iconUrl", "", "size", "", "(Ljava/lang/String;I)V", "getIconUrl", "()Ljava/lang/String;", "getSize", "()I", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: ResultPageData.kt */
    public static final class IconInfo implements Serializable {
        private final String iconUrl;
        private final int size;

        public IconInfo(String str, int i) {
            Intrinsics.checkNotNullParameter(str, "iconUrl");
            this.iconUrl = str;
            this.size = i;
        }

        public final String getIconUrl() {
            return this.iconUrl;
        }

        public final int getSize() {
            return this.size;
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, mo175978d2 = {"Lcom/didi/payment/kycservice/kyc/response/ResultPageData$ItemInfo;", "Ljava/io/Serializable;", "title", "", "desc", "reference", "type", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getDesc", "()Ljava/lang/String;", "getReference", "getTitle", "getType", "()I", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: ResultPageData.kt */
    public static final class ItemInfo implements Serializable {
        private final String desc;
        private final String reference;
        private final String title;
        private final int type;

        public ItemInfo(String str, String str2, String str3, int i) {
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(str2, "desc");
            Intrinsics.checkNotNullParameter(str3, "reference");
            this.title = str;
            this.desc = str2;
            this.reference = str3;
            this.type = i;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getDesc() {
            return this.desc;
        }

        public final String getReference() {
            return this.reference;
        }

        public final int getType() {
            return this.type;
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\f"}, mo175978d2 = {"Lcom/didi/payment/kycservice/kyc/response/ResultPageData$ExtraButton;", "Ljava/io/Serializable;", "extraBtnText", "", "link", "(Ljava/lang/String;Ljava/lang/String;)V", "getExtraBtnText", "()Ljava/lang/String;", "setExtraBtnText", "(Ljava/lang/String;)V", "getLink", "setLink", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: ResultPageData.kt */
    public static final class ExtraButton implements Serializable {
        private String extraBtnText;
        private String link;

        public ExtraButton(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "extraBtnText");
            Intrinsics.checkNotNullParameter(str2, "link");
            this.extraBtnText = str;
            this.link = str2;
        }

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
