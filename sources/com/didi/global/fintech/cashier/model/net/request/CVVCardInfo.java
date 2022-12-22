package com.didi.global.fintech.cashier.model.net.request;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006\u001e"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/model/net/request/CVVCardInfo;", "Ljava/io/Serializable;", "card_index", "", "card_prefix", "card_suffix", "card_icon", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCard_icon", "()Ljava/lang/String;", "setCard_icon", "(Ljava/lang/String;)V", "getCard_index", "setCard_index", "getCard_prefix", "setCard_prefix", "getCard_suffix", "setCard_suffix", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "cashier_model_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GetCVVInfoRequest.kt */
public final class CVVCardInfo implements Serializable {
    @SerializedName("card_icon")
    private String card_icon;
    @SerializedName("card_index")
    private String card_index;
    @SerializedName("card_prefix")
    private String card_prefix;
    @SerializedName("card_suffix")
    private String card_suffix;

    public CVVCardInfo() {
        this((String) null, (String) null, (String) null, (String) null, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ CVVCardInfo copy$default(CVVCardInfo cVVCardInfo, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = cVVCardInfo.card_index;
        }
        if ((i & 2) != 0) {
            str2 = cVVCardInfo.card_prefix;
        }
        if ((i & 4) != 0) {
            str3 = cVVCardInfo.card_suffix;
        }
        if ((i & 8) != 0) {
            str4 = cVVCardInfo.card_icon;
        }
        return cVVCardInfo.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.card_index;
    }

    public final String component2() {
        return this.card_prefix;
    }

    public final String component3() {
        return this.card_suffix;
    }

    public final String component4() {
        return this.card_icon;
    }

    public final CVVCardInfo copy(String str, String str2, String str3, String str4) {
        return new CVVCardInfo(str, str2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CVVCardInfo)) {
            return false;
        }
        CVVCardInfo cVVCardInfo = (CVVCardInfo) obj;
        return Intrinsics.areEqual((Object) this.card_index, (Object) cVVCardInfo.card_index) && Intrinsics.areEqual((Object) this.card_prefix, (Object) cVVCardInfo.card_prefix) && Intrinsics.areEqual((Object) this.card_suffix, (Object) cVVCardInfo.card_suffix) && Intrinsics.areEqual((Object) this.card_icon, (Object) cVVCardInfo.card_icon);
    }

    public int hashCode() {
        String str = this.card_index;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.card_prefix;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.card_suffix;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.card_icon;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "CVVCardInfo(card_index=" + this.card_index + ", card_prefix=" + this.card_prefix + ", card_suffix=" + this.card_suffix + ", card_icon=" + this.card_icon + VersionRange.RIGHT_OPEN;
    }

    public CVVCardInfo(String str, String str2, String str3, String str4) {
        this.card_index = str;
        this.card_prefix = str2;
        this.card_suffix = str3;
        this.card_icon = str4;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CVVCardInfo(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4);
    }

    public final String getCard_index() {
        return this.card_index;
    }

    public final void setCard_index(String str) {
        this.card_index = str;
    }

    public final String getCard_prefix() {
        return this.card_prefix;
    }

    public final void setCard_prefix(String str) {
        this.card_prefix = str;
    }

    public final String getCard_suffix() {
        return this.card_suffix;
    }

    public final void setCard_suffix(String str) {
        this.card_suffix = str;
    }

    public final String getCard_icon() {
        return this.card_icon;
    }

    public final void setCard_icon(String str) {
        this.card_icon = str;
    }
}
