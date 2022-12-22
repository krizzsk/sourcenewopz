package com.didi.unifiedPay.sdk.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0019"}, mo175978d2 = {"Lcom/didi/unifiedPay/sdk/model/InstallmentRecommendModel;", "Ljava/io/Serializable;", "generalMarketingText", "", "changePay", "addCard", "installmentFaqLink", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAddCard", "()Ljava/lang/String;", "getChangePay", "getGeneralMarketingText", "getInstallmentFaqLink", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "pay_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: Installment.kt */
public final class InstallmentRecommendModel implements Serializable {
    @SerializedName("add_card")
    private final String addCard;
    @SerializedName("change_pay")
    private final String changePay;
    @SerializedName("general_marketing_text")
    private final String generalMarketingText;
    @SerializedName("installment_faq_link")
    private final String installmentFaqLink;

    public static /* synthetic */ InstallmentRecommendModel copy$default(InstallmentRecommendModel installmentRecommendModel, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = installmentRecommendModel.generalMarketingText;
        }
        if ((i & 2) != 0) {
            str2 = installmentRecommendModel.changePay;
        }
        if ((i & 4) != 0) {
            str3 = installmentRecommendModel.addCard;
        }
        if ((i & 8) != 0) {
            str4 = installmentRecommendModel.installmentFaqLink;
        }
        return installmentRecommendModel.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.generalMarketingText;
    }

    public final String component2() {
        return this.changePay;
    }

    public final String component3() {
        return this.addCard;
    }

    public final String component4() {
        return this.installmentFaqLink;
    }

    public final InstallmentRecommendModel copy(String str, String str2, String str3, String str4) {
        return new InstallmentRecommendModel(str, str2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InstallmentRecommendModel)) {
            return false;
        }
        InstallmentRecommendModel installmentRecommendModel = (InstallmentRecommendModel) obj;
        return Intrinsics.areEqual((Object) this.generalMarketingText, (Object) installmentRecommendModel.generalMarketingText) && Intrinsics.areEqual((Object) this.changePay, (Object) installmentRecommendModel.changePay) && Intrinsics.areEqual((Object) this.addCard, (Object) installmentRecommendModel.addCard) && Intrinsics.areEqual((Object) this.installmentFaqLink, (Object) installmentRecommendModel.installmentFaqLink);
    }

    public int hashCode() {
        String str = this.generalMarketingText;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.changePay;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.addCard;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.installmentFaqLink;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "InstallmentRecommendModel(generalMarketingText=" + this.generalMarketingText + ", changePay=" + this.changePay + ", addCard=" + this.addCard + ", installmentFaqLink=" + this.installmentFaqLink + VersionRange.RIGHT_OPEN;
    }

    public InstallmentRecommendModel(String str, String str2, String str3, String str4) {
        this.generalMarketingText = str;
        this.changePay = str2;
        this.addCard = str3;
        this.installmentFaqLink = str4;
    }

    public final String getGeneralMarketingText() {
        return this.generalMarketingText;
    }

    public final String getChangePay() {
        return this.changePay;
    }

    public final String getAddCard() {
        return this.addCard;
    }

    public final String getInstallmentFaqLink() {
        return this.installmentFaqLink;
    }
}
