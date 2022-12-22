package com.didi.global.fintech.cashier.model.net.request;

import com.didi.global.fintech.cashier.model.net.response.BasicPayment;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J3\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\f¨\u0006\u001e"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/model/net/request/ChangePayInfoRequest;", "Lcom/didi/global/fintech/cashier/model/net/request/CashierRequestCommonParams;", "out_trade_id", "", "from_select", "", "Lcom/didi/global/fintech/cashier/model/net/response/BasicPayment;", "to_select", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getFrom_select", "()Ljava/util/List;", "setFrom_select", "(Ljava/util/List;)V", "getOut_trade_id", "()Ljava/lang/String;", "setOut_trade_id", "(Ljava/lang/String;)V", "getTo_select", "setTo_select", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "cashier_model_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ChangePayInfoRequest.kt */
public final class ChangePayInfoRequest extends CashierRequestCommonParams {
    private List<BasicPayment> from_select;
    private String out_trade_id;
    private List<BasicPayment> to_select;

    public ChangePayInfoRequest() {
        this((String) null, (List) null, (List) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ChangePayInfoRequest copy$default(ChangePayInfoRequest changePayInfoRequest, String str, List<BasicPayment> list, List<BasicPayment> list2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = changePayInfoRequest.out_trade_id;
        }
        if ((i & 2) != 0) {
            list = changePayInfoRequest.from_select;
        }
        if ((i & 4) != 0) {
            list2 = changePayInfoRequest.to_select;
        }
        return changePayInfoRequest.copy(str, list, list2);
    }

    public final String component1() {
        return this.out_trade_id;
    }

    public final List<BasicPayment> component2() {
        return this.from_select;
    }

    public final List<BasicPayment> component3() {
        return this.to_select;
    }

    public final ChangePayInfoRequest copy(String str, List<BasicPayment> list, List<BasicPayment> list2) {
        Intrinsics.checkNotNullParameter(str, "out_trade_id");
        Intrinsics.checkNotNullParameter(list, "from_select");
        Intrinsics.checkNotNullParameter(list2, "to_select");
        return new ChangePayInfoRequest(str, list, list2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChangePayInfoRequest)) {
            return false;
        }
        ChangePayInfoRequest changePayInfoRequest = (ChangePayInfoRequest) obj;
        return Intrinsics.areEqual((Object) this.out_trade_id, (Object) changePayInfoRequest.out_trade_id) && Intrinsics.areEqual((Object) this.from_select, (Object) changePayInfoRequest.from_select) && Intrinsics.areEqual((Object) this.to_select, (Object) changePayInfoRequest.to_select);
    }

    public int hashCode() {
        return (((this.out_trade_id.hashCode() * 31) + this.from_select.hashCode()) * 31) + this.to_select.hashCode();
    }

    public String toString() {
        return "ChangePayInfoRequest(out_trade_id=" + this.out_trade_id + ", from_select=" + this.from_select + ", to_select=" + this.to_select + VersionRange.RIGHT_OPEN;
    }

    public final String getOut_trade_id() {
        return this.out_trade_id;
    }

    public final void setOut_trade_id(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.out_trade_id = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ChangePayInfoRequest(String str, List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? new ArrayList() : list, (i & 4) != 0 ? new ArrayList() : list2);
    }

    public final List<BasicPayment> getFrom_select() {
        return this.from_select;
    }

    public final void setFrom_select(List<BasicPayment> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.from_select = list;
    }

    public final List<BasicPayment> getTo_select() {
        return this.to_select;
    }

    public final void setTo_select(List<BasicPayment> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.to_select = list;
    }

    public ChangePayInfoRequest(String str, List<BasicPayment> list, List<BasicPayment> list2) {
        Intrinsics.checkNotNullParameter(str, "out_trade_id");
        Intrinsics.checkNotNullParameter(list, "from_select");
        Intrinsics.checkNotNullParameter(list2, "to_select");
        this.out_trade_id = str;
        this.from_select = list;
        this.to_select = list2;
    }
}
