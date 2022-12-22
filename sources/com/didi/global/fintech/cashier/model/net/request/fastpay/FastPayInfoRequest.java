package com.didi.global.fintech.cashier.model.net.request.fastpay;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0011"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/model/net/request/fastpay/FastPayInfoRequest;", "Lcom/didi/global/fintech/cashier/model/net/request/fastpay/FastPayRequestCommonParams;", "product_id", "", "(Ljava/lang/String;)V", "getProduct_id", "()Ljava/lang/String;", "setProduct_id", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "cashier_model_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FastPayInfoRequest.kt */
public final class FastPayInfoRequest extends FastPayRequestCommonParams {
    @SerializedName("product_id")
    private String product_id;

    public FastPayInfoRequest() {
        this((String) null, 1, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ FastPayInfoRequest copy$default(FastPayInfoRequest fastPayInfoRequest, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = fastPayInfoRequest.product_id;
        }
        return fastPayInfoRequest.copy(str);
    }

    public final String component1() {
        return this.product_id;
    }

    public final FastPayInfoRequest copy(String str) {
        return new FastPayInfoRequest(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FastPayInfoRequest) && Intrinsics.areEqual((Object) this.product_id, (Object) ((FastPayInfoRequest) obj).product_id);
    }

    public int hashCode() {
        String str = this.product_id;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public String toString() {
        return "FastPayInfoRequest(product_id=" + this.product_id + VersionRange.RIGHT_OPEN;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FastPayInfoRequest(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str);
    }

    public final String getProduct_id() {
        return this.product_id;
    }

    public final void setProduct_id(String str) {
        this.product_id = str;
    }

    public FastPayInfoRequest(String str) {
        this.product_id = str;
    }
}
