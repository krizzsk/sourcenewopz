package com.didi.global.fintech.cashier.model.net.response.fastpay;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003J-\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR \u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006 "}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/model/net/response/fastpay/FastPayInfoResponse;", "Ljava/io/Serializable;", "switchStatus", "", "paymentLimit", "Lcom/didi/global/fintech/cashier/model/net/response/fastpay/FastPayLimit;", "showInfo", "Lcom/didi/global/fintech/cashier/model/net/response/fastpay/FastPayShowInfo;", "(Ljava/lang/String;Lcom/didi/global/fintech/cashier/model/net/response/fastpay/FastPayLimit;Lcom/didi/global/fintech/cashier/model/net/response/fastpay/FastPayShowInfo;)V", "getPaymentLimit", "()Lcom/didi/global/fintech/cashier/model/net/response/fastpay/FastPayLimit;", "setPaymentLimit", "(Lcom/didi/global/fintech/cashier/model/net/response/fastpay/FastPayLimit;)V", "getShowInfo", "()Lcom/didi/global/fintech/cashier/model/net/response/fastpay/FastPayShowInfo;", "setShowInfo", "(Lcom/didi/global/fintech/cashier/model/net/response/fastpay/FastPayShowInfo;)V", "getSwitchStatus", "()Ljava/lang/String;", "setSwitchStatus", "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "cashier_model_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FastPayInfoResponse.kt */
public final class FastPayInfoResponse implements Serializable {
    @SerializedName("payment_limit")
    private FastPayLimit paymentLimit;
    @SerializedName("show_info")
    private FastPayShowInfo showInfo;
    @SerializedName("switch_status")
    private String switchStatus;

    public static /* synthetic */ FastPayInfoResponse copy$default(FastPayInfoResponse fastPayInfoResponse, String str, FastPayLimit fastPayLimit, FastPayShowInfo fastPayShowInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            str = fastPayInfoResponse.switchStatus;
        }
        if ((i & 2) != 0) {
            fastPayLimit = fastPayInfoResponse.paymentLimit;
        }
        if ((i & 4) != 0) {
            fastPayShowInfo = fastPayInfoResponse.showInfo;
        }
        return fastPayInfoResponse.copy(str, fastPayLimit, fastPayShowInfo);
    }

    public final String component1() {
        return this.switchStatus;
    }

    public final FastPayLimit component2() {
        return this.paymentLimit;
    }

    public final FastPayShowInfo component3() {
        return this.showInfo;
    }

    public final FastPayInfoResponse copy(String str, FastPayLimit fastPayLimit, FastPayShowInfo fastPayShowInfo) {
        return new FastPayInfoResponse(str, fastPayLimit, fastPayShowInfo);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FastPayInfoResponse)) {
            return false;
        }
        FastPayInfoResponse fastPayInfoResponse = (FastPayInfoResponse) obj;
        return Intrinsics.areEqual((Object) this.switchStatus, (Object) fastPayInfoResponse.switchStatus) && Intrinsics.areEqual((Object) this.paymentLimit, (Object) fastPayInfoResponse.paymentLimit) && Intrinsics.areEqual((Object) this.showInfo, (Object) fastPayInfoResponse.showInfo);
    }

    public int hashCode() {
        String str = this.switchStatus;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        FastPayLimit fastPayLimit = this.paymentLimit;
        int hashCode2 = (hashCode + (fastPayLimit == null ? 0 : fastPayLimit.hashCode())) * 31;
        FastPayShowInfo fastPayShowInfo = this.showInfo;
        if (fastPayShowInfo != null) {
            i = fastPayShowInfo.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "FastPayInfoResponse(switchStatus=" + this.switchStatus + ", paymentLimit=" + this.paymentLimit + ", showInfo=" + this.showInfo + VersionRange.RIGHT_OPEN;
    }

    public FastPayInfoResponse(String str, FastPayLimit fastPayLimit, FastPayShowInfo fastPayShowInfo) {
        this.switchStatus = str;
        this.paymentLimit = fastPayLimit;
        this.showInfo = fastPayShowInfo;
    }

    public final String getSwitchStatus() {
        return this.switchStatus;
    }

    public final void setSwitchStatus(String str) {
        this.switchStatus = str;
    }

    public final FastPayLimit getPaymentLimit() {
        return this.paymentLimit;
    }

    public final void setPaymentLimit(FastPayLimit fastPayLimit) {
        this.paymentLimit = fastPayLimit;
    }

    public final FastPayShowInfo getShowInfo() {
        return this.showInfo;
    }

    public final void setShowInfo(FastPayShowInfo fastPayShowInfo) {
        this.showInfo = fastPayShowInfo;
    }
}
