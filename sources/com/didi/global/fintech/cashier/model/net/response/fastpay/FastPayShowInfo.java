package com.didi.global.fintech.cashier.model.net.response.fastpay;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b \n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BK\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J]\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001R \u0010\t\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR \u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000eR \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\f\"\u0004\b\u0018\u0010\u000eR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000e¨\u0006*"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/model/net/response/fastpay/FastPayShowInfo;", "Ljava/io/Serializable;", "iconUrl", "", "title", "subTitle", "paymentOrderTitle", "explainUrl", "explain", "button", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getButton", "()Ljava/lang/String;", "setButton", "(Ljava/lang/String;)V", "getExplain", "setExplain", "getExplainUrl", "setExplainUrl", "getIconUrl", "setIconUrl", "getPaymentOrderTitle", "setPaymentOrderTitle", "getSubTitle", "setSubTitle", "getTitle", "setTitle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "", "hashCode", "", "toString", "cashier_model_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FastPayInfoResponse.kt */
public final class FastPayShowInfo implements Serializable {
    @SerializedName("button")
    private String button;
    @SerializedName("explain")
    private String explain;
    @SerializedName("explain_url")
    private String explainUrl;
    @SerializedName("icon_url")
    private String iconUrl;
    @SerializedName("payment_order_title")
    private String paymentOrderTitle;
    @SerializedName("sub_title")
    private String subTitle;
    @SerializedName("title")
    private String title;

    public static /* synthetic */ FastPayShowInfo copy$default(FastPayShowInfo fastPayShowInfo, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, Object obj) {
        if ((i & 1) != 0) {
            str = fastPayShowInfo.iconUrl;
        }
        if ((i & 2) != 0) {
            str2 = fastPayShowInfo.title;
        }
        String str8 = str2;
        if ((i & 4) != 0) {
            str3 = fastPayShowInfo.subTitle;
        }
        String str9 = str3;
        if ((i & 8) != 0) {
            str4 = fastPayShowInfo.paymentOrderTitle;
        }
        String str10 = str4;
        if ((i & 16) != 0) {
            str5 = fastPayShowInfo.explainUrl;
        }
        String str11 = str5;
        if ((i & 32) != 0) {
            str6 = fastPayShowInfo.explain;
        }
        String str12 = str6;
        if ((i & 64) != 0) {
            str7 = fastPayShowInfo.button;
        }
        return fastPayShowInfo.copy(str, str8, str9, str10, str11, str12, str7);
    }

    public final String component1() {
        return this.iconUrl;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.subTitle;
    }

    public final String component4() {
        return this.paymentOrderTitle;
    }

    public final String component5() {
        return this.explainUrl;
    }

    public final String component6() {
        return this.explain;
    }

    public final String component7() {
        return this.button;
    }

    public final FastPayShowInfo copy(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        return new FastPayShowInfo(str, str2, str3, str4, str5, str6, str7);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FastPayShowInfo)) {
            return false;
        }
        FastPayShowInfo fastPayShowInfo = (FastPayShowInfo) obj;
        return Intrinsics.areEqual((Object) this.iconUrl, (Object) fastPayShowInfo.iconUrl) && Intrinsics.areEqual((Object) this.title, (Object) fastPayShowInfo.title) && Intrinsics.areEqual((Object) this.subTitle, (Object) fastPayShowInfo.subTitle) && Intrinsics.areEqual((Object) this.paymentOrderTitle, (Object) fastPayShowInfo.paymentOrderTitle) && Intrinsics.areEqual((Object) this.explainUrl, (Object) fastPayShowInfo.explainUrl) && Intrinsics.areEqual((Object) this.explain, (Object) fastPayShowInfo.explain) && Intrinsics.areEqual((Object) this.button, (Object) fastPayShowInfo.button);
    }

    public int hashCode() {
        String str = this.iconUrl;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.title;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.subTitle;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.paymentOrderTitle;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.explainUrl;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.explain;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.button;
        if (str7 != null) {
            i = str7.hashCode();
        }
        return hashCode6 + i;
    }

    public String toString() {
        return "FastPayShowInfo(iconUrl=" + this.iconUrl + ", title=" + this.title + ", subTitle=" + this.subTitle + ", paymentOrderTitle=" + this.paymentOrderTitle + ", explainUrl=" + this.explainUrl + ", explain=" + this.explain + ", button=" + this.button + VersionRange.RIGHT_OPEN;
    }

    public FastPayShowInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.iconUrl = str;
        this.title = str2;
        this.subTitle = str3;
        this.paymentOrderTitle = str4;
        this.explainUrl = str5;
        this.explain = str6;
        this.button = str7;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final String getSubTitle() {
        return this.subTitle;
    }

    public final void setSubTitle(String str) {
        this.subTitle = str;
    }

    public final String getPaymentOrderTitle() {
        return this.paymentOrderTitle;
    }

    public final void setPaymentOrderTitle(String str) {
        this.paymentOrderTitle = str;
    }

    public final String getExplainUrl() {
        return this.explainUrl;
    }

    public final void setExplainUrl(String str) {
        this.explainUrl = str;
    }

    public final String getExplain() {
        return this.explain;
    }

    public final void setExplain(String str) {
        this.explain = str;
    }

    public final String getButton() {
        return this.button;
    }

    public final void setButton(String str) {
        this.button = str;
    }
}
