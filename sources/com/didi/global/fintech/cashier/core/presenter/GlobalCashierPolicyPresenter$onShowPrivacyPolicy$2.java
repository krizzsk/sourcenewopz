package com.didi.global.fintech.cashier.core.presenter;

import com.didi.global.fintech.cashier.core.interceptor.CashierActionInterceptor;
import com.didi.global.fintech.cashier.model.net.request.CashierAction;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, mo175978d2 = {"<anonymous>", "", "it", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCashierPolicyPresenter.kt */
final class GlobalCashierPolicyPresenter$onShowPrivacyPolicy$2 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ GlobalCashierPolicyPresenter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GlobalCashierPolicyPresenter$onShowPrivacyPolicy$2(GlobalCashierPolicyPresenter globalCashierPolicyPresenter) {
        super(1);
        this.this$0 = globalCashierPolicyPresenter;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(String str) {
        this.this$0.omegaPolicyCk(2);
        CashierAction insOpenUrl = CashierAction.Companion.insOpenUrl(str);
        CashierActionInterceptor actionInterceptor = this.this$0.getActionInterceptor();
        if (actionInterceptor != null) {
            actionInterceptor.intercept(this.this$0.getContext(), insOpenUrl, (Function0<Unit>[]) new Function0[0]);
        }
    }
}
