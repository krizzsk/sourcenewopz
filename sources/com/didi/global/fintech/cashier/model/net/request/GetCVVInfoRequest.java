package com.didi.global.fintech.cashier.model.net.request;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0019"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/model/net/request/GetCVVInfoRequest;", "Lcom/didi/global/fintech/cashier/model/net/request/CashierRequestCommonParams;", "out_trade_id", "", "extra_info", "Lcom/didi/global/fintech/cashier/model/net/request/CVVCardInfo;", "(Ljava/lang/String;Lcom/didi/global/fintech/cashier/model/net/request/CVVCardInfo;)V", "getExtra_info", "()Lcom/didi/global/fintech/cashier/model/net/request/CVVCardInfo;", "setExtra_info", "(Lcom/didi/global/fintech/cashier/model/net/request/CVVCardInfo;)V", "getOut_trade_id", "()Ljava/lang/String;", "setOut_trade_id", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "cashier_model_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GetCVVInfoRequest.kt */
public final class GetCVVInfoRequest extends CashierRequestCommonParams {
    @SerializedName("extra_info")
    private CVVCardInfo extra_info;
    @SerializedName("out_trade_id")
    private String out_trade_id;

    public GetCVVInfoRequest() {
        this((String) null, (CVVCardInfo) null, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ GetCVVInfoRequest copy$default(GetCVVInfoRequest getCVVInfoRequest, String str, CVVCardInfo cVVCardInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            str = getCVVInfoRequest.out_trade_id;
        }
        if ((i & 2) != 0) {
            cVVCardInfo = getCVVInfoRequest.extra_info;
        }
        return getCVVInfoRequest.copy(str, cVVCardInfo);
    }

    public final String component1() {
        return this.out_trade_id;
    }

    public final CVVCardInfo component2() {
        return this.extra_info;
    }

    public final GetCVVInfoRequest copy(String str, CVVCardInfo cVVCardInfo) {
        return new GetCVVInfoRequest(str, cVVCardInfo);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetCVVInfoRequest)) {
            return false;
        }
        GetCVVInfoRequest getCVVInfoRequest = (GetCVVInfoRequest) obj;
        return Intrinsics.areEqual((Object) this.out_trade_id, (Object) getCVVInfoRequest.out_trade_id) && Intrinsics.areEqual((Object) this.extra_info, (Object) getCVVInfoRequest.extra_info);
    }

    public int hashCode() {
        String str = this.out_trade_id;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        CVVCardInfo cVVCardInfo = this.extra_info;
        if (cVVCardInfo != null) {
            i = cVVCardInfo.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "GetCVVInfoRequest(out_trade_id=" + this.out_trade_id + ", extra_info=" + this.extra_info + VersionRange.RIGHT_OPEN;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GetCVVInfoRequest(String str, CVVCardInfo cVVCardInfo, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : cVVCardInfo);
    }

    public final String getOut_trade_id() {
        return this.out_trade_id;
    }

    public final void setOut_trade_id(String str) {
        this.out_trade_id = str;
    }

    public final CVVCardInfo getExtra_info() {
        return this.extra_info;
    }

    public final void setExtra_info(CVVCardInfo cVVCardInfo) {
        this.extra_info = cVVCardInfo;
    }

    public GetCVVInfoRequest(String str, CVVCardInfo cVVCardInfo) {
        this.out_trade_id = str;
        this.extra_info = cVVCardInfo;
    }
}
