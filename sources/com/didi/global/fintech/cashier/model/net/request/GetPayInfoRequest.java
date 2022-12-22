package com.didi.global.fintech.cashier.model.net.request;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006\u001e"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/model/net/request/GetPayInfoRequest;", "Lcom/didi/global/fintech/cashier/model/net/request/CashierRequestCommonParams;", "out_trade_id", "", "biz_content", "sign_type", "sign", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBiz_content", "()Ljava/lang/String;", "setBiz_content", "(Ljava/lang/String;)V", "getOut_trade_id", "setOut_trade_id", "getSign", "setSign", "getSign_type", "setSign_type", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "cashier_model_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GetPayInfoRequest.kt */
public final class GetPayInfoRequest extends CashierRequestCommonParams {
    @SerializedName("biz_content")
    private String biz_content;
    @SerializedName("out_trade_id")
    private String out_trade_id;
    @SerializedName("sign")
    private String sign;
    @SerializedName("sign_type")
    private String sign_type;

    public GetPayInfoRequest() {
        this((String) null, (String) null, (String) null, (String) null, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ GetPayInfoRequest copy$default(GetPayInfoRequest getPayInfoRequest, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = getPayInfoRequest.out_trade_id;
        }
        if ((i & 2) != 0) {
            str2 = getPayInfoRequest.biz_content;
        }
        if ((i & 4) != 0) {
            str3 = getPayInfoRequest.sign_type;
        }
        if ((i & 8) != 0) {
            str4 = getPayInfoRequest.sign;
        }
        return getPayInfoRequest.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.out_trade_id;
    }

    public final String component2() {
        return this.biz_content;
    }

    public final String component3() {
        return this.sign_type;
    }

    public final String component4() {
        return this.sign;
    }

    public final GetPayInfoRequest copy(String str, String str2, String str3, String str4) {
        return new GetPayInfoRequest(str, str2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetPayInfoRequest)) {
            return false;
        }
        GetPayInfoRequest getPayInfoRequest = (GetPayInfoRequest) obj;
        return Intrinsics.areEqual((Object) this.out_trade_id, (Object) getPayInfoRequest.out_trade_id) && Intrinsics.areEqual((Object) this.biz_content, (Object) getPayInfoRequest.biz_content) && Intrinsics.areEqual((Object) this.sign_type, (Object) getPayInfoRequest.sign_type) && Intrinsics.areEqual((Object) this.sign, (Object) getPayInfoRequest.sign);
    }

    public int hashCode() {
        String str = this.out_trade_id;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.biz_content;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.sign_type;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.sign;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "GetPayInfoRequest(out_trade_id=" + this.out_trade_id + ", biz_content=" + this.biz_content + ", sign_type=" + this.sign_type + ", sign=" + this.sign + VersionRange.RIGHT_OPEN;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GetPayInfoRequest(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4);
    }

    public final String getOut_trade_id() {
        return this.out_trade_id;
    }

    public final void setOut_trade_id(String str) {
        this.out_trade_id = str;
    }

    public final String getBiz_content() {
        return this.biz_content;
    }

    public final void setBiz_content(String str) {
        this.biz_content = str;
    }

    public final String getSign_type() {
        return this.sign_type;
    }

    public final void setSign_type(String str) {
        this.sign_type = str;
    }

    public GetPayInfoRequest(String str, String str2, String str3, String str4) {
        this.out_trade_id = str;
        this.biz_content = str2;
        this.sign_type = str3;
        this.sign = str4;
    }

    public final String getSign() {
        return this.sign;
    }

    public final void setSign(String str) {
        this.sign = str;
    }
}
