package com.didi.global.fintech.cashier.model.net.response.fastpay;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\b\u0010\u0015\u001a\u00020\u0003H\u0016J\u0006\u0010\u0016\u001a\u00020\u0014R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0017"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/model/net/response/fastpay/FastPayLimitItem;", "Ljava/io/Serializable;", "amount", "", "amount_display", "(Ljava/lang/String;Ljava/lang/String;)V", "getAmount", "()Ljava/lang/String;", "setAmount", "(Ljava/lang/String;)V", "getAmount_display", "setAmount_display", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "uniqueId", "cashier_model_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FastPayInfoResponse.kt */
public final class FastPayLimitItem implements Serializable {
    @SerializedName("amount")
    private String amount;
    @SerializedName("amount_display")
    private String amount_display;

    public static /* synthetic */ FastPayLimitItem copy$default(FastPayLimitItem fastPayLimitItem, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = fastPayLimitItem.amount;
        }
        if ((i & 2) != 0) {
            str2 = fastPayLimitItem.amount_display;
        }
        return fastPayLimitItem.copy(str, str2);
    }

    public final String component1() {
        return this.amount;
    }

    public final String component2() {
        return this.amount_display;
    }

    public final FastPayLimitItem copy(String str, String str2) {
        return new FastPayLimitItem(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FastPayLimitItem)) {
            return false;
        }
        FastPayLimitItem fastPayLimitItem = (FastPayLimitItem) obj;
        return Intrinsics.areEqual((Object) this.amount, (Object) fastPayLimitItem.amount) && Intrinsics.areEqual((Object) this.amount_display, (Object) fastPayLimitItem.amount_display);
    }

    public int hashCode() {
        String str = this.amount;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.amount_display;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public FastPayLimitItem(String str, String str2) {
        this.amount = str;
        this.amount_display = str2;
    }

    public final String getAmount() {
        return this.amount;
    }

    public final void setAmount(String str) {
        this.amount = str;
    }

    public final String getAmount_display() {
        return this.amount_display;
    }

    public final void setAmount_display(String str) {
        this.amount_display = str;
    }

    public String toString() {
        return "{amount=" + this.amount + ",amount_display=" + this.amount_display + '}';
    }

    public final int uniqueId() {
        return toString().hashCode();
    }
}
