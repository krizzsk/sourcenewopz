package com.didi.soda.bill.component.rule;

import android.os.Bundle;
import com.didi.soda.bill.BillOmegaHelper;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0013H\u0016J\b\u0010\u0017\u001a\u00020\u0013H\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u0018"}, mo175978d2 = {"Lcom/didi/soda/bill/component/rule/RefundRuleTraceStrategy;", "Lcom/didi/soda/bill/component/rule/RuleTraceStrategy;", "bundle", "Landroid/os/Bundle;", "pageAlias", "", "(Landroid/os/Bundle;Ljava/lang/String;)V", "isConfirmClicked", "", "()Z", "setConfirmClicked", "(Z)V", "orderId", "getOrderId", "()Ljava/lang/String;", "setOrderId", "(Ljava/lang/String;)V", "getPageAlias", "traceBtnClick", "", "type", "", "traceClosed", "traceCreate", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: RefundRuleTraceStrategy.kt */
public final class RefundRuleTraceStrategy extends RuleTraceStrategy {

    /* renamed from: a */
    private final String f38955a;

    /* renamed from: b */
    private String f38956b;

    /* renamed from: c */
    private boolean f38957c;

    public RefundRuleTraceStrategy(Bundle bundle, String str) {
        super(bundle);
        String str2;
        this.f38955a = str;
        if (bundle == null) {
            str2 = null;
        } else {
            str2 = bundle.getString("orderid");
        }
        this.f38956b = str2;
    }

    public final String getPageAlias() {
        return this.f38955a;
    }

    public final String getOrderId() {
        return this.f38956b;
    }

    public final void setOrderId(String str) {
        this.f38956b = str;
    }

    public final boolean isConfirmClicked() {
        return this.f38957c;
    }

    public final void setConfirmClicked(boolean z) {
        this.f38957c = z;
    }

    public void traceCreate() {
        BillOmegaHelper.Companion.traceRefundRuleSW(this.f38956b);
    }

    public void traceBtnClick(int i) {
        this.f38957c = true;
        BillOmegaHelper.Companion.traceRefundRuleBtnCk(this.f38956b);
    }

    public void traceClosed() {
        if (!this.f38957c) {
            BillOmegaHelper.Companion.traceRefundRuleBackCk(this.f38955a);
        }
    }
}
