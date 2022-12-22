package com.didi.global.fintech.cashier.core.viewbinder.policy;

import com.didi.global.fintech.cashier.core.contract.IGlobalCashierPolicyPresenter;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierPolicyViewBinder;
import com.didi.global.fintech.cashier.core.viewbinder.GlobalCashierBaseViewBinder;
import com.didi.global.fintech.cashier.model.net.response.PayInfoResponse;
import com.didi.global.fintech.cashier.p117ui.IGlobalCashierPolicyViewHolder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\f\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00012\u00020\u0005B\r\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u0016\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\tH\u0002J\u0012\u0010\u0017\u001a\u00020\u00112\b\u0010\u0018\u001a\u0004\u0018\u00010\u0010H\u0002J\u001e\u0010\u0019\u001a\u00020\u00112\u0014\u0010\u001a\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0004\u0012\u00020\u00110\u000fH\u0016J\u0012\u0010\u001b\u001a\u00020\u00112\b\u0010\u001c\u001a\u0004\u0018\u00010\u0004H\u0016R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR*\u0010\u000e\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u001d"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/core/viewbinder/policy/GlobalCashierPolicyViewBinder;", "Lcom/didi/global/fintech/cashier/core/viewbinder/GlobalCashierBaseViewBinder;", "Lcom/didi/global/fintech/cashier/ui/IGlobalCashierPolicyViewHolder;", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierPolicyPresenter;", "Lcom/didi/global/fintech/cashier/model/net/response/PayInfoResponse;", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierPolicyViewBinder;", "presenter", "(Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierPolicyPresenter;)V", "checked", "", "getChecked", "()Z", "setChecked", "(Z)V", "linkListener", "Lkotlin/Function1;", "", "", "getLinkListener", "()Lkotlin/jvm/functions/Function1;", "setLinkListener", "(Lkotlin/jvm/functions/Function1;)V", "onCheckBoxChanged", "onLinkClicked", "url", "registerLinkListener", "listener", "setupView", "data", "cashier_core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCashierPolicyViewBinder.kt */
public final class GlobalCashierPolicyViewBinder extends GlobalCashierBaseViewBinder<IGlobalCashierPolicyViewHolder, IGlobalCashierPolicyPresenter, PayInfoResponse> implements IGlobalCashierPolicyViewBinder {

    /* renamed from: a */
    private boolean f21533a;

    /* renamed from: b */
    private Function1<? super String, Unit> f21534b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlobalCashierPolicyViewBinder(IGlobalCashierPolicyPresenter iGlobalCashierPolicyPresenter) {
        super(iGlobalCashierPolicyPresenter);
        Intrinsics.checkNotNullParameter(iGlobalCashierPolicyPresenter, "presenter");
    }

    public final boolean getChecked() {
        return this.f21533a;
    }

    public final void setChecked(boolean z) {
        this.f21533a = z;
    }

    public final Function1<String, Unit> getLinkListener() {
        return this.f21534b;
    }

    public final void setLinkListener(Function1<? super String, Unit> function1) {
        this.f21534b = function1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0011, code lost:
        r2 = r7.getCashierInfo();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setupView(com.didi.global.fintech.cashier.model.net.response.PayInfoResponse r7) {
        /*
            r6 = this;
            super.setupView(r7)
            com.didi.global.fintech.cashier.ui.IGlobalCashierBaseViewHolder r0 = r6.getViewHolder()
            com.didi.global.fintech.cashier.ui.IGlobalCashierPolicyViewHolder r0 = (com.didi.global.fintech.cashier.p117ui.IGlobalCashierPolicyViewHolder) r0
            r1 = 0
            if (r0 != 0) goto L_0x000d
            goto L_0x001f
        L_0x000d:
            if (r7 != 0) goto L_0x0011
        L_0x000f:
            r2 = r1
            goto L_0x001c
        L_0x0011:
            com.didi.global.fintech.cashier.model.net.response.CashierInfo r2 = r7.getCashierInfo()
            if (r2 != 0) goto L_0x0018
            goto L_0x000f
        L_0x0018:
            java.lang.String r2 = r2.getBrandLogo()
        L_0x001c:
            r0.updateBrandLogo(r2)
        L_0x001f:
            com.didi.global.fintech.cashier.ui.IGlobalCashierBaseViewHolder r0 = r6.getViewHolder()
            com.didi.global.fintech.cashier.ui.IGlobalCashierPolicyViewHolder r0 = (com.didi.global.fintech.cashier.p117ui.IGlobalCashierPolicyViewHolder) r0
            if (r0 != 0) goto L_0x0028
            goto L_0x003a
        L_0x0028:
            if (r7 != 0) goto L_0x002c
        L_0x002a:
            r2 = r1
            goto L_0x0037
        L_0x002c:
            com.didi.global.fintech.cashier.model.net.response.PolicyInfo r2 = r7.getPolicyInfo()
            if (r2 != 0) goto L_0x0033
            goto L_0x002a
        L_0x0033:
            java.lang.String r2 = r2.getContent()
        L_0x0037:
            r0.updateContent(r2)
        L_0x003a:
            r0 = 0
            if (r7 != 0) goto L_0x003e
            goto L_0x0050
        L_0x003e:
            com.didi.global.fintech.cashier.model.net.response.PolicyInfo r2 = r7.getPolicyInfo()
            if (r2 != 0) goto L_0x0045
            goto L_0x0050
        L_0x0045:
            java.lang.Boolean r2 = r2.getDefaultCheck()
            if (r2 != 0) goto L_0x004c
            goto L_0x0050
        L_0x004c:
            boolean r0 = r2.booleanValue()
        L_0x0050:
            r6.f21533a = r0
            com.didi.global.fintech.cashier.ui.IGlobalCashierBaseViewHolder r0 = r6.getViewHolder()
            com.didi.global.fintech.cashier.ui.IGlobalCashierPolicyViewHolder r0 = (com.didi.global.fintech.cashier.p117ui.IGlobalCashierPolicyViewHolder) r0
            if (r0 != 0) goto L_0x005b
            goto L_0x008b
        L_0x005b:
            boolean r2 = r6.f21533a
            com.didi.global.fintech.cashier.core.viewbinder.policy.GlobalCashierPolicyViewBinder$setupView$1 r3 = new com.didi.global.fintech.cashier.core.viewbinder.policy.GlobalCashierPolicyViewBinder$setupView$1
            r3.<init>(r6)
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            com.didi.global.fintech.cashier.core.datapraser.ViewBinderDataParser$Companion r4 = com.didi.global.fintech.cashier.core.datapraser.ViewBinderDataParser.Companion
            if (r7 != 0) goto L_0x0069
            goto L_0x0074
        L_0x0069:
            com.didi.global.fintech.cashier.model.net.response.PolicyInfo r7 = r7.getPolicyInfo()
            if (r7 != 0) goto L_0x0070
            goto L_0x0074
        L_0x0070:
            java.util.List r1 = r7.getAcceptContent()
        L_0x0074:
            com.didi.global.fintech.cashier.core.viewbinder.policy.GlobalCashierPolicyViewBinder$setupView$2 r7 = new com.didi.global.fintech.cashier.core.viewbinder.policy.GlobalCashierPolicyViewBinder$setupView$2
            com.didi.global.fintech.cashier.core.datapraser.ViewBinderDataParser$Companion r5 = com.didi.global.fintech.cashier.core.datapraser.ViewBinderDataParser.Companion
            r7.<init>(r5)
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            java.util.List r7 = r4.parseDataList(r1, r7)
            com.didi.global.fintech.cashier.core.viewbinder.policy.GlobalCashierPolicyViewBinder$setupView$3 r1 = new com.didi.global.fintech.cashier.core.viewbinder.policy.GlobalCashierPolicyViewBinder$setupView$3
            r1.<init>(r6)
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r0.updatePolicy(r2, r3, r7, r1)
        L_0x008b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.fintech.cashier.core.viewbinder.policy.GlobalCashierPolicyViewBinder.setupView(com.didi.global.fintech.cashier.model.net.response.PayInfoResponse):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m15770a(boolean z) {
        this.f21533a = z;
        ((IGlobalCashierPolicyPresenter) getPresenter()).omegaPolicyCk(1);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m15769a(String str) {
        Function1<? super String, Unit> function1 = this.f21534b;
        if (function1 != null) {
            function1.invoke(str);
        }
    }

    public void registerLinkListener(Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "listener");
        this.f21534b = function1;
    }

    public boolean checked() {
        return this.f21533a;
    }
}
