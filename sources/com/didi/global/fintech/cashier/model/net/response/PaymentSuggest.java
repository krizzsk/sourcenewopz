package com.didi.global.fintech.cashier.model.net.response;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B/\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J3\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R&\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010¨\u0006\u001e"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/model/net/response/PaymentSuggest;", "Ljava/io/Serializable;", "message", "", "type", "channels", "", "Lcom/didi/global/fintech/cashier/model/net/response/BasicPayment;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getChannels", "()Ljava/util/List;", "setChannels", "(Ljava/util/List;)V", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "getType", "setType", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "cashier_model_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PayStatusResponse.kt */
public final class PaymentSuggest implements Serializable {
    @SerializedName("channels")
    private List<? extends BasicPayment> channels;
    @SerializedName("message")
    private String message;
    @SerializedName("type")
    private String type;

    public PaymentSuggest() {
        this((String) null, (String) null, (List) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ PaymentSuggest copy$default(PaymentSuggest paymentSuggest, String str, String str2, List<? extends BasicPayment> list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = paymentSuggest.message;
        }
        if ((i & 2) != 0) {
            str2 = paymentSuggest.type;
        }
        if ((i & 4) != 0) {
            list = paymentSuggest.channels;
        }
        return paymentSuggest.copy(str, str2, list);
    }

    public final String component1() {
        return this.message;
    }

    public final String component2() {
        return this.type;
    }

    public final List<BasicPayment> component3() {
        return this.channels;
    }

    public final PaymentSuggest copy(String str, String str2, List<? extends BasicPayment> list) {
        return new PaymentSuggest(str, str2, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaymentSuggest)) {
            return false;
        }
        PaymentSuggest paymentSuggest = (PaymentSuggest) obj;
        return Intrinsics.areEqual((Object) this.message, (Object) paymentSuggest.message) && Intrinsics.areEqual((Object) this.type, (Object) paymentSuggest.type) && Intrinsics.areEqual((Object) this.channels, (Object) paymentSuggest.channels);
    }

    public int hashCode() {
        String str = this.message;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.type;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        List<? extends BasicPayment> list = this.channels;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "PaymentSuggest(message=" + this.message + ", type=" + this.type + ", channels=" + this.channels + VersionRange.RIGHT_OPEN;
    }

    public PaymentSuggest(String str, String str2, List<? extends BasicPayment> list) {
        this.message = str;
        this.type = str2;
        this.channels = list;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PaymentSuggest(String str, String str2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : list);
    }

    public final String getMessage() {
        return this.message;
    }

    public final void setMessage(String str) {
        this.message = str;
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(String str) {
        this.type = str;
    }

    public final List<BasicPayment> getChannels() {
        return this.channels;
    }

    public final void setChannels(List<? extends BasicPayment> list) {
        this.channels = list;
    }
}
