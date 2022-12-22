package com.didi.global.fintech.cashier.model.net.request;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J'\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000f¨\u0006\u001c"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/model/net/request/GetPayStatusRequest;", "Lcom/didi/global/fintech/cashier/model/net/request/CashierRequestCommonParams;", "first_polling", "", "scene", "", "out_trade_id", "(ZLjava/lang/String;Ljava/lang/String;)V", "getFirst_polling", "()Z", "setFirst_polling", "(Z)V", "getOut_trade_id", "()Ljava/lang/String;", "setOut_trade_id", "(Ljava/lang/String;)V", "getScene", "setScene", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "cashier_model_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GetPayStatusRequest.kt */
public final class GetPayStatusRequest extends CashierRequestCommonParams {
    @SerializedName("first_polling")
    private boolean first_polling;
    @SerializedName("out_trade_id")
    private String out_trade_id;
    @SerializedName("scene")
    private String scene;

    public GetPayStatusRequest() {
        this(false, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ GetPayStatusRequest copy$default(GetPayStatusRequest getPayStatusRequest, boolean z, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = getPayStatusRequest.first_polling;
        }
        if ((i & 2) != 0) {
            str = getPayStatusRequest.scene;
        }
        if ((i & 4) != 0) {
            str2 = getPayStatusRequest.out_trade_id;
        }
        return getPayStatusRequest.copy(z, str, str2);
    }

    public final boolean component1() {
        return this.first_polling;
    }

    public final String component2() {
        return this.scene;
    }

    public final String component3() {
        return this.out_trade_id;
    }

    public final GetPayStatusRequest copy(boolean z, String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "scene");
        Intrinsics.checkNotNullParameter(str2, "out_trade_id");
        return new GetPayStatusRequest(z, str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetPayStatusRequest)) {
            return false;
        }
        GetPayStatusRequest getPayStatusRequest = (GetPayStatusRequest) obj;
        return this.first_polling == getPayStatusRequest.first_polling && Intrinsics.areEqual((Object) this.scene, (Object) getPayStatusRequest.scene) && Intrinsics.areEqual((Object) this.out_trade_id, (Object) getPayStatusRequest.out_trade_id);
    }

    public int hashCode() {
        boolean z = this.first_polling;
        if (z) {
            z = true;
        }
        return ((((z ? 1 : 0) * true) + this.scene.hashCode()) * 31) + this.out_trade_id.hashCode();
    }

    public String toString() {
        return "GetPayStatusRequest(first_polling=" + this.first_polling + ", scene=" + this.scene + ", out_trade_id=" + this.out_trade_id + VersionRange.RIGHT_OPEN;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GetPayStatusRequest(boolean z, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? "PAY" : str, (i & 4) != 0 ? "" : str2);
    }

    public final boolean getFirst_polling() {
        return this.first_polling;
    }

    public final void setFirst_polling(boolean z) {
        this.first_polling = z;
    }

    public final String getScene() {
        return this.scene;
    }

    public final void setScene(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.scene = str;
    }

    public final String getOut_trade_id() {
        return this.out_trade_id;
    }

    public final void setOut_trade_id(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.out_trade_id = str;
    }

    public GetPayStatusRequest(boolean z, String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "scene");
        Intrinsics.checkNotNullParameter(str2, "out_trade_id");
        this.first_polling = z;
        this.scene = str;
        this.out_trade_id = str2;
    }
}
