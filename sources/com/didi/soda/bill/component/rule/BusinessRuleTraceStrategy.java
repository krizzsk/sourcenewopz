package com.didi.soda.bill.component.rule;

import android.os.Bundle;
import com.didi.soda.bill.BillOmegaHelper;
import com.didi.soda.customer.app.constant.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0006H\u0016J\b\u0010\u0014\u001a\u00020\u0012H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0015"}, mo175978d2 = {"Lcom/didi/soda/bill/component/rule/BusinessRuleTraceStrategy;", "Lcom/didi/soda/bill/component/rule/RuleTraceStrategy;", "bundle", "Landroid/os/Bundle;", "(Landroid/os/Bundle;)V", "btnType", "", "getBtnType", "()I", "setBtnType", "(I)V", "shopId", "", "getShopId", "()Ljava/lang/String;", "setShopId", "(Ljava/lang/String;)V", "traceBtnClick", "", "type", "traceClosed", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BusinessRuleTraceStrategy.kt */
public final class BusinessRuleTraceStrategy extends RuleTraceStrategy {

    /* renamed from: a */
    private String f38953a = "";

    /* renamed from: b */
    private int f38954b = 1;

    public BusinessRuleTraceStrategy(Bundle bundle) {
        super(bundle);
        if (bundle != null) {
            String string = bundle.getString(Const.PageParams.SHOP_ID, "");
            Intrinsics.checkNotNullExpressionValue(string, "it.getString(Const.PageP…OP_ID, StringConst.EMPTY)");
            setShopId(string);
        }
    }

    public final String getShopId() {
        return this.f38953a;
    }

    public final void setShopId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f38953a = str;
    }

    public final int getBtnType() {
        return this.f38954b;
    }

    public final void setBtnType(int i) {
        this.f38954b = i;
    }

    public void traceClosed() {
        BillOmegaHelper.Companion.onCouponReduceClose(this.f38954b, this.f38953a);
    }

    public void traceBtnClick(int i) {
        this.f38954b = 0;
    }
}
