package com.didi.global.fintech.cashier.model.net.request;

import com.didi.soda.customer.app.constant.Const;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0016"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/model/net/request/CanChangeNewVersionRequest;", "Lcom/didi/global/fintech/cashier/model/net/request/CashierRequestCommonParams;", "out_trade_id", "", "biz_content", "(Ljava/lang/String;Ljava/lang/String;)V", "getBiz_content", "()Ljava/lang/String;", "setBiz_content", "(Ljava/lang/String;)V", "getOut_trade_id", "setOut_trade_id", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "cashier_model_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CanChangeNewVersionRequest.kt */
public final class CanChangeNewVersionRequest extends CashierRequestCommonParams {
    @SerializedName("biz_content")
    private String biz_content;
    @SerializedName("out_trade_id")
    private String out_trade_id;

    public CanChangeNewVersionRequest() {
        this((String) null, (String) null, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ CanChangeNewVersionRequest copy$default(CanChangeNewVersionRequest canChangeNewVersionRequest, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = canChangeNewVersionRequest.out_trade_id;
        }
        if ((i & 2) != 0) {
            str2 = canChangeNewVersionRequest.biz_content;
        }
        return canChangeNewVersionRequest.copy(str, str2);
    }

    public final String component1() {
        return this.out_trade_id;
    }

    public final String component2() {
        return this.biz_content;
    }

    public final CanChangeNewVersionRequest copy(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "out_trade_id");
        Intrinsics.checkNotNullParameter(str2, Const.PayParams.BIZ_CONTENT_UNDERLINE);
        return new CanChangeNewVersionRequest(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CanChangeNewVersionRequest)) {
            return false;
        }
        CanChangeNewVersionRequest canChangeNewVersionRequest = (CanChangeNewVersionRequest) obj;
        return Intrinsics.areEqual((Object) this.out_trade_id, (Object) canChangeNewVersionRequest.out_trade_id) && Intrinsics.areEqual((Object) this.biz_content, (Object) canChangeNewVersionRequest.biz_content);
    }

    public int hashCode() {
        return (this.out_trade_id.hashCode() * 31) + this.biz_content.hashCode();
    }

    public String toString() {
        return "CanChangeNewVersionRequest(out_trade_id=" + this.out_trade_id + ", biz_content=" + this.biz_content + VersionRange.RIGHT_OPEN;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CanChangeNewVersionRequest(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2);
    }

    public final String getOut_trade_id() {
        return this.out_trade_id;
    }

    public final void setOut_trade_id(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.out_trade_id = str;
    }

    public final String getBiz_content() {
        return this.biz_content;
    }

    public final void setBiz_content(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.biz_content = str;
    }

    public CanChangeNewVersionRequest(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "out_trade_id");
        Intrinsics.checkNotNullParameter(str2, Const.PayParams.BIZ_CONTENT_UNDERLINE);
        this.out_trade_id = str;
        this.biz_content = str2;
    }
}
