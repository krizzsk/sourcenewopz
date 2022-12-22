package com.didi.payment.commonsdk.fastpay;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B1\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003J5\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001J\t\u0010 \u001a\u00020\u0007HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000f\"\u0004\b\u0016\u0010\u0011¨\u0006!"}, mo175978d2 = {"Lcom/didi/payment/commonsdk/fastpay/FastPayData;", "Ljava/io/Serializable;", "isSupportFastPay", "", "fastPayAmount", "", "fastPayButtonText", "", "paymentMethodText", "(ZILjava/lang/String;Ljava/lang/String;)V", "getFastPayAmount", "()I", "setFastPayAmount", "(I)V", "getFastPayButtonText", "()Ljava/lang/String;", "setFastPayButtonText", "(Ljava/lang/String;)V", "()Z", "setSupportFastPay", "(Z)V", "getPaymentMethodText", "setPaymentMethodText", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "toString", "wallet-service-commonsdk_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FastPayData.kt */
public final class FastPayData implements Serializable {
    private int fastPayAmount;
    private String fastPayButtonText;
    private boolean isSupportFastPay;
    private String paymentMethodText;

    public FastPayData() {
        this(false, 0, (String) null, (String) null, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ FastPayData copy$default(FastPayData fastPayData, boolean z, int i, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = fastPayData.isSupportFastPay;
        }
        if ((i2 & 2) != 0) {
            i = fastPayData.fastPayAmount;
        }
        if ((i2 & 4) != 0) {
            str = fastPayData.fastPayButtonText;
        }
        if ((i2 & 8) != 0) {
            str2 = fastPayData.paymentMethodText;
        }
        return fastPayData.copy(z, i, str, str2);
    }

    public final boolean component1() {
        return this.isSupportFastPay;
    }

    public final int component2() {
        return this.fastPayAmount;
    }

    public final String component3() {
        return this.fastPayButtonText;
    }

    public final String component4() {
        return this.paymentMethodText;
    }

    public final FastPayData copy(boolean z, int i, String str, String str2) {
        return new FastPayData(z, i, str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FastPayData)) {
            return false;
        }
        FastPayData fastPayData = (FastPayData) obj;
        return this.isSupportFastPay == fastPayData.isSupportFastPay && this.fastPayAmount == fastPayData.fastPayAmount && Intrinsics.areEqual((Object) this.fastPayButtonText, (Object) fastPayData.fastPayButtonText) && Intrinsics.areEqual((Object) this.paymentMethodText, (Object) fastPayData.paymentMethodText);
    }

    public int hashCode() {
        boolean z = this.isSupportFastPay;
        if (z) {
            z = true;
        }
        int i = (((z ? 1 : 0) * true) + this.fastPayAmount) * 31;
        String str = this.fastPayButtonText;
        int i2 = 0;
        int hashCode = (i + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.paymentMethodText;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    public String toString() {
        return "FastPayData(isSupportFastPay=" + this.isSupportFastPay + ", fastPayAmount=" + this.fastPayAmount + ", fastPayButtonText=" + this.fastPayButtonText + ", paymentMethodText=" + this.paymentMethodText + VersionRange.RIGHT_OPEN;
    }

    public FastPayData(boolean z, int i, String str, String str2) {
        this.isSupportFastPay = z;
        this.fastPayAmount = i;
        this.fastPayButtonText = str;
        this.paymentMethodText = str2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FastPayData(boolean z, int i, String str, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? 0 : i, (i2 & 4) != 0 ? null : str, (i2 & 8) != 0 ? null : str2);
    }

    public final boolean isSupportFastPay() {
        return this.isSupportFastPay;
    }

    public final void setSupportFastPay(boolean z) {
        this.isSupportFastPay = z;
    }

    public final int getFastPayAmount() {
        return this.fastPayAmount;
    }

    public final void setFastPayAmount(int i) {
        this.fastPayAmount = i;
    }

    public final String getFastPayButtonText() {
        return this.fastPayButtonText;
    }

    public final void setFastPayButtonText(String str) {
        this.fastPayButtonText = str;
    }

    public final String getPaymentMethodText() {
        return this.paymentMethodText;
    }

    public final void setPaymentMethodText(String str) {
        this.paymentMethodText = str;
    }
}
