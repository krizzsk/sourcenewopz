package com.didi.global.fintech.cashier.model.net.response.fastpay;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0011"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/model/net/response/fastpay/FastPaySubmitQuizResponse;", "Ljava/io/Serializable;", "toast", "", "(Ljava/lang/String;)V", "getToast", "()Ljava/lang/String;", "setToast", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "cashier_model_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FastPaySubmitQuizResponse.kt */
public final class FastPaySubmitQuizResponse implements Serializable {
    @SerializedName("toast")
    private String toast;

    public FastPaySubmitQuizResponse() {
        this((String) null, 1, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ FastPaySubmitQuizResponse copy$default(FastPaySubmitQuizResponse fastPaySubmitQuizResponse, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = fastPaySubmitQuizResponse.toast;
        }
        return fastPaySubmitQuizResponse.copy(str);
    }

    public final String component1() {
        return this.toast;
    }

    public final FastPaySubmitQuizResponse copy(String str) {
        return new FastPaySubmitQuizResponse(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FastPaySubmitQuizResponse) && Intrinsics.areEqual((Object) this.toast, (Object) ((FastPaySubmitQuizResponse) obj).toast);
    }

    public int hashCode() {
        String str = this.toast;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public String toString() {
        return "FastPaySubmitQuizResponse(toast=" + this.toast + VersionRange.RIGHT_OPEN;
    }

    public FastPaySubmitQuizResponse(String str) {
        this.toast = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FastPaySubmitQuizResponse(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str);
    }

    public final String getToast() {
        return this.toast;
    }

    public final void setToast(String str) {
        this.toast = str;
    }
}
