package com.didi.global.fintech.cashier.model.net.response.fastpay;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B7\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003JE\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR \u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\f¨\u0006!"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/model/net/response/fastpay/ShowInfo;", "", "button", "", "adjust_desc", "non_auto_deduction_desc", "adjust_bubble", "last_one_toast", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAdjust_bubble", "()Ljava/lang/String;", "setAdjust_bubble", "(Ljava/lang/String;)V", "getAdjust_desc", "setAdjust_desc", "getButton", "setButton", "getLast_one_toast", "setLast_one_toast", "getNon_auto_deduction_desc", "setNon_auto_deduction_desc", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "cashier_model_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FastPayOrderResponse.kt */
public final class ShowInfo {
    @SerializedName("adjust_bubble")
    private String adjust_bubble;
    @SerializedName("adjust_desc")
    private String adjust_desc;
    @SerializedName("button")
    private String button;
    @SerializedName("last_one_toast")
    private String last_one_toast;
    @SerializedName("non_auto_deduction_desc")
    private String non_auto_deduction_desc;

    public static /* synthetic */ ShowInfo copy$default(ShowInfo showInfo, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = showInfo.button;
        }
        if ((i & 2) != 0) {
            str2 = showInfo.adjust_desc;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = showInfo.non_auto_deduction_desc;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = showInfo.adjust_bubble;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            str5 = showInfo.last_one_toast;
        }
        return showInfo.copy(str, str6, str7, str8, str5);
    }

    public final String component1() {
        return this.button;
    }

    public final String component2() {
        return this.adjust_desc;
    }

    public final String component3() {
        return this.non_auto_deduction_desc;
    }

    public final String component4() {
        return this.adjust_bubble;
    }

    public final String component5() {
        return this.last_one_toast;
    }

    public final ShowInfo copy(String str, String str2, String str3, String str4, String str5) {
        return new ShowInfo(str, str2, str3, str4, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShowInfo)) {
            return false;
        }
        ShowInfo showInfo = (ShowInfo) obj;
        return Intrinsics.areEqual((Object) this.button, (Object) showInfo.button) && Intrinsics.areEqual((Object) this.adjust_desc, (Object) showInfo.adjust_desc) && Intrinsics.areEqual((Object) this.non_auto_deduction_desc, (Object) showInfo.non_auto_deduction_desc) && Intrinsics.areEqual((Object) this.adjust_bubble, (Object) showInfo.adjust_bubble) && Intrinsics.areEqual((Object) this.last_one_toast, (Object) showInfo.last_one_toast);
    }

    public int hashCode() {
        String str = this.button;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.adjust_desc;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.non_auto_deduction_desc;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.adjust_bubble;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.last_one_toast;
        if (str5 != null) {
            i = str5.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        return "ShowInfo(button=" + this.button + ", adjust_desc=" + this.adjust_desc + ", non_auto_deduction_desc=" + this.non_auto_deduction_desc + ", adjust_bubble=" + this.adjust_bubble + ", last_one_toast=" + this.last_one_toast + VersionRange.RIGHT_OPEN;
    }

    public ShowInfo(String str, String str2, String str3, String str4, String str5) {
        this.button = str;
        this.adjust_desc = str2;
        this.non_auto_deduction_desc = str3;
        this.adjust_bubble = str4;
        this.last_one_toast = str5;
    }

    public final String getButton() {
        return this.button;
    }

    public final void setButton(String str) {
        this.button = str;
    }

    public final String getAdjust_desc() {
        return this.adjust_desc;
    }

    public final void setAdjust_desc(String str) {
        this.adjust_desc = str;
    }

    public final String getNon_auto_deduction_desc() {
        return this.non_auto_deduction_desc;
    }

    public final void setNon_auto_deduction_desc(String str) {
        this.non_auto_deduction_desc = str;
    }

    public final String getAdjust_bubble() {
        return this.adjust_bubble;
    }

    public final void setAdjust_bubble(String str) {
        this.adjust_bubble = str;
    }

    public final String getLast_one_toast() {
        return this.last_one_toast;
    }

    public final void setLast_one_toast(String str) {
        this.last_one_toast = str;
    }
}
