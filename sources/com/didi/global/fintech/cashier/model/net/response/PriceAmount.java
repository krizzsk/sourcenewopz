package com.didi.global.fintech.cashier.model.net.response;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\b\b\u0018\u00002\u00020\u0001B/\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007HÆ\u0003J8\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\b\u0010 \u001a\u0004\u0018\u00010\u0005J\b\u0010!\u001a\u0004\u0018\u00010\u0005J\t\u0010\"\u001a\u00020\u0005HÖ\u0001R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R&\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006#"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/model/net/response/PriceAmount;", "Ljava/io/Serializable;", "fee", "", "display", "", "split", "", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;)V", "getDisplay", "()Ljava/lang/String;", "setDisplay", "(Ljava/lang/String;)V", "getFee", "()Ljava/lang/Integer;", "setFee", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getSplit", "()Ljava/util/List;", "setSplit", "(Ljava/util/List;)V", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;)Lcom/didi/global/fintech/cashier/model/net/response/PriceAmount;", "equals", "", "other", "", "hashCode", "price", "symbol", "toString", "cashier_model_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PayInfoResponse.kt */
public final class PriceAmount implements Serializable {
    @SerializedName("display")
    private String display;
    @SerializedName("fee")
    private Integer fee;
    @SerializedName("split")
    private List<String> split;

    public PriceAmount() {
        this((Integer) null, (String) null, (List) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ PriceAmount copy$default(PriceAmount priceAmount, Integer num, String str, List<String> list, int i, Object obj) {
        if ((i & 1) != 0) {
            num = priceAmount.fee;
        }
        if ((i & 2) != 0) {
            str = priceAmount.display;
        }
        if ((i & 4) != 0) {
            list = priceAmount.split;
        }
        return priceAmount.copy(num, str, list);
    }

    public final Integer component1() {
        return this.fee;
    }

    public final String component2() {
        return this.display;
    }

    public final List<String> component3() {
        return this.split;
    }

    public final PriceAmount copy(Integer num, String str, List<String> list) {
        return new PriceAmount(num, str, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PriceAmount)) {
            return false;
        }
        PriceAmount priceAmount = (PriceAmount) obj;
        return Intrinsics.areEqual((Object) this.fee, (Object) priceAmount.fee) && Intrinsics.areEqual((Object) this.display, (Object) priceAmount.display) && Intrinsics.areEqual((Object) this.split, (Object) priceAmount.split);
    }

    public int hashCode() {
        Integer num = this.fee;
        int i = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.display;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        List<String> list = this.split;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "PriceAmount(fee=" + this.fee + ", display=" + this.display + ", split=" + this.split + VersionRange.RIGHT_OPEN;
    }

    public PriceAmount(Integer num, String str, List<String> list) {
        this.fee = num;
        this.display = str;
        this.split = list;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PriceAmount(Integer num, String str, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : list);
    }

    public final Integer getFee() {
        return this.fee;
    }

    public final void setFee(Integer num) {
        this.fee = num;
    }

    public final String getDisplay() {
        return this.display;
    }

    public final void setDisplay(String str) {
        this.display = str;
    }

    public final List<String> getSplit() {
        return this.split;
    }

    public final void setSplit(List<String> list) {
        this.split = list;
    }

    public final String symbol() {
        List<String> list = this.split;
        if (list == null) {
            return null;
        }
        return CollectionsKt.getLastIndex(list) >= 0 ? list.get(0) : "";
    }

    public final String price() {
        List<String> list = this.split;
        if (list == null) {
            return null;
        }
        return 1 <= CollectionsKt.getLastIndex(list) ? list.get(1) : "";
    }
}
