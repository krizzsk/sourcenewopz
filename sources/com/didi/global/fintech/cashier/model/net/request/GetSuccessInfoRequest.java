package com.didi.global.fintech.cashier.model.net.request;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0011"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/model/net/request/GetSuccessInfoRequest;", "Lcom/didi/global/fintech/cashier/model/net/request/CashierRequestCommonParams;", "out_trade_id", "", "(Ljava/lang/String;)V", "getOut_trade_id", "()Ljava/lang/String;", "setOut_trade_id", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "cashier_model_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GetSuccessInfoRequest.kt */
public final class GetSuccessInfoRequest extends CashierRequestCommonParams {
    @SerializedName("out_trade_id")
    private String out_trade_id;

    public GetSuccessInfoRequest() {
        this((String) null, 1, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ GetSuccessInfoRequest copy$default(GetSuccessInfoRequest getSuccessInfoRequest, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = getSuccessInfoRequest.out_trade_id;
        }
        return getSuccessInfoRequest.copy(str);
    }

    public final String component1() {
        return this.out_trade_id;
    }

    public final GetSuccessInfoRequest copy(String str) {
        Intrinsics.checkNotNullParameter(str, "out_trade_id");
        return new GetSuccessInfoRequest(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof GetSuccessInfoRequest) && Intrinsics.areEqual((Object) this.out_trade_id, (Object) ((GetSuccessInfoRequest) obj).out_trade_id);
    }

    public int hashCode() {
        return this.out_trade_id.hashCode();
    }

    public String toString() {
        return "GetSuccessInfoRequest(out_trade_id=" + this.out_trade_id + VersionRange.RIGHT_OPEN;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GetSuccessInfoRequest(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str);
    }

    public final String getOut_trade_id() {
        return this.out_trade_id;
    }

    public final void setOut_trade_id(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.out_trade_id = str;
    }

    public GetSuccessInfoRequest(String str) {
        Intrinsics.checkNotNullParameter(str, "out_trade_id");
        this.out_trade_id = str;
    }
}
