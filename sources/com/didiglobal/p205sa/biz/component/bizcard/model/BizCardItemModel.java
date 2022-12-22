package com.didiglobal.p205sa.biz.component.bizcard.model;

import com.didi.global.globaluikit.richinfo.LEGORichInfo;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001e\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001e\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001e\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR \u0010\u0018\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR \u0010\u001e\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001d¨\u0006!"}, mo175978d2 = {"Lcom/didiglobal/sa/biz/component/bizcard/model/BizCardItemModel;", "Ljava/io/Serializable;", "()V", "buttonTitle", "", "getButtonTitle", "()Ljava/lang/String;", "setButtonTitle", "(Ljava/lang/String;)V", "cardID", "getCardID", "setCardID", "endColor", "getEndColor", "setEndColor", "icon", "getIcon", "setIcon", "link", "getLink", "setLink", "startColor", "getStartColor", "setStartColor", "subTitle", "Lcom/didi/global/globaluikit/richinfo/LEGORichInfo;", "getSubTitle", "()Lcom/didi/global/globaluikit/richinfo/LEGORichInfo;", "setSubTitle", "(Lcom/didi/global/globaluikit/richinfo/LEGORichInfo;)V", "title", "getTitle", "setTitle", "biz-library_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didiglobal.sa.biz.component.bizcard.model.BizCardItemModel */
/* compiled from: BizCardItemModel.kt */
public final class BizCardItemModel implements Serializable {
    @SerializedName("buttonTitle")
    private String buttonTitle = "";
    @SerializedName("cardID")
    private String cardID = "";
    @SerializedName("endColor")
    private String endColor = "";
    @SerializedName("icon")
    private String icon = "";
    @SerializedName("link")
    private String link = "";
    @SerializedName("startColor")
    private String startColor = "";
    @SerializedName("subTitle")
    private LEGORichInfo subTitle;
    @SerializedName("title")
    private LEGORichInfo title;

    public final String getCardID() {
        return this.cardID;
    }

    public final void setCardID(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.cardID = str;
    }

    public final String getStartColor() {
        return this.startColor;
    }

    public final void setStartColor(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.startColor = str;
    }

    public final String getEndColor() {
        return this.endColor;
    }

    public final void setEndColor(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.endColor = str;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final void setIcon(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.icon = str;
    }

    public final String getLink() {
        return this.link;
    }

    public final void setLink(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.link = str;
    }

    public final LEGORichInfo getTitle() {
        return this.title;
    }

    public final void setTitle(LEGORichInfo lEGORichInfo) {
        this.title = lEGORichInfo;
    }

    public final LEGORichInfo getSubTitle() {
        return this.subTitle;
    }

    public final void setSubTitle(LEGORichInfo lEGORichInfo) {
        this.subTitle = lEGORichInfo;
    }

    public final String getButtonTitle() {
        return this.buttonTitle;
    }

    public final void setButtonTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.buttonTitle = str;
    }
}
