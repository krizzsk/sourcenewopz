package com.didi.global.fintech.cashier.model.net.response.fastpay;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B3\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003J?\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR \u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R&\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\r¨\u0006$"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/model/net/response/fastpay/FastPayLimit;", "Ljava/io/Serializable;", "title", "", "button", "payLimits", "", "Lcom/didi/global/fintech/cashier/model/net/response/fastpay/FastPayLimitItem;", "curLimit", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/didi/global/fintech/cashier/model/net/response/fastpay/FastPayLimitItem;)V", "getButton", "()Ljava/lang/String;", "setButton", "(Ljava/lang/String;)V", "getCurLimit", "()Lcom/didi/global/fintech/cashier/model/net/response/fastpay/FastPayLimitItem;", "setCurLimit", "(Lcom/didi/global/fintech/cashier/model/net/response/fastpay/FastPayLimitItem;)V", "getPayLimits", "()Ljava/util/List;", "setPayLimits", "(Ljava/util/List;)V", "getTitle", "setTitle", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "cashier_model_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FastPayInfoResponse.kt */
public final class FastPayLimit implements Serializable {
    @SerializedName("button")
    private String button;
    @SerializedName("default_payment_limit")
    private FastPayLimitItem curLimit;
    @SerializedName("payment_limit_config_list")
    private List<FastPayLimitItem> payLimits;
    @SerializedName("title")
    private String title;

    public static /* synthetic */ FastPayLimit copy$default(FastPayLimit fastPayLimit, String str, String str2, List<FastPayLimitItem> list, FastPayLimitItem fastPayLimitItem, int i, Object obj) {
        if ((i & 1) != 0) {
            str = fastPayLimit.title;
        }
        if ((i & 2) != 0) {
            str2 = fastPayLimit.button;
        }
        if ((i & 4) != 0) {
            list = fastPayLimit.payLimits;
        }
        if ((i & 8) != 0) {
            fastPayLimitItem = fastPayLimit.curLimit;
        }
        return fastPayLimit.copy(str, str2, list, fastPayLimitItem);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.button;
    }

    public final List<FastPayLimitItem> component3() {
        return this.payLimits;
    }

    public final FastPayLimitItem component4() {
        return this.curLimit;
    }

    public final FastPayLimit copy(String str, String str2, List<FastPayLimitItem> list, FastPayLimitItem fastPayLimitItem) {
        return new FastPayLimit(str, str2, list, fastPayLimitItem);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FastPayLimit)) {
            return false;
        }
        FastPayLimit fastPayLimit = (FastPayLimit) obj;
        return Intrinsics.areEqual((Object) this.title, (Object) fastPayLimit.title) && Intrinsics.areEqual((Object) this.button, (Object) fastPayLimit.button) && Intrinsics.areEqual((Object) this.payLimits, (Object) fastPayLimit.payLimits) && Intrinsics.areEqual((Object) this.curLimit, (Object) fastPayLimit.curLimit);
    }

    public int hashCode() {
        String str = this.title;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.button;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        List<FastPayLimitItem> list = this.payLimits;
        int hashCode3 = (hashCode2 + (list == null ? 0 : list.hashCode())) * 31;
        FastPayLimitItem fastPayLimitItem = this.curLimit;
        if (fastPayLimitItem != null) {
            i = fastPayLimitItem.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "FastPayLimit(title=" + this.title + ", button=" + this.button + ", payLimits=" + this.payLimits + ", curLimit=" + this.curLimit + VersionRange.RIGHT_OPEN;
    }

    public FastPayLimit(String str, String str2, List<FastPayLimitItem> list, FastPayLimitItem fastPayLimitItem) {
        this.title = str;
        this.button = str2;
        this.payLimits = list;
        this.curLimit = fastPayLimitItem;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final String getButton() {
        return this.button;
    }

    public final void setButton(String str) {
        this.button = str;
    }

    public final List<FastPayLimitItem> getPayLimits() {
        return this.payLimits;
    }

    public final void setPayLimits(List<FastPayLimitItem> list) {
        this.payLimits = list;
    }

    public final FastPayLimitItem getCurLimit() {
        return this.curLimit;
    }

    public final void setCurLimit(FastPayLimitItem fastPayLimitItem) {
        this.curLimit = fastPayLimitItem;
    }
}
