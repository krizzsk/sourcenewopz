package com.didi.global.fintech.cashier.core.interceptor;

import android.content.Context;
import com.didi.global.fintech.cashier.core.action.GlobalCashierActionsHandler;
import com.didi.global.fintech.cashier.model.net.request.CashierAction;
import com.didi.global.fintech.cashier.user.model.CashierParam;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005JC\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00022\"\u0010\u0013\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00150\u0014\"\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0015H\u0016¢\u0006\u0002\u0010\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/core/interceptor/CashierActionInterceptor;", "Lcom/didi/global/fintech/cashier/core/interceptor/BaseInterceptor;", "Lcom/didi/global/fintech/cashier/model/net/request/CashierAction;", "uniqueId", "", "(Ljava/lang/String;)V", "cashierParam", "Lcom/didi/global/fintech/cashier/user/model/CashierParam;", "getCashierParam", "()Lcom/didi/global/fintech/cashier/user/model/CashierParam;", "setCashierParam", "(Lcom/didi/global/fintech/cashier/user/model/CashierParam;)V", "getUniqueId", "()Ljava/lang/String;", "intercept", "", "context", "Landroid/content/Context;", "data", "interceptCallback", "", "Lkotlin/Function0;", "(Landroid/content/Context;Lcom/didi/global/fintech/cashier/model/net/request/CashierAction;[Lkotlin/jvm/functions/Function0;)V", "cashier_core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CashierActionInterceptor.kt */
public final class CashierActionInterceptor implements BaseInterceptor<CashierAction> {

    /* renamed from: a */
    private final String f21429a;

    /* renamed from: b */
    private CashierParam f21430b;

    public CashierActionInterceptor() {
        this((String) null, 1, (DefaultConstructorMarker) null);
    }

    public CashierActionInterceptor(String str) {
        this.f21429a = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CashierActionInterceptor(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str);
    }

    public final String getUniqueId() {
        return this.f21429a;
    }

    public final CashierParam getCashierParam() {
        return this.f21430b;
    }

    public final void setCashierParam(CashierParam cashierParam) {
        this.f21430b = cashierParam;
    }

    public void intercept(Context context, CashierAction cashierAction, Function0<Unit>... function0Arr) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(function0Arr, "interceptCallback");
        if (GlobalCashierActionsHandler.INSTANCE.handleAction(context, cashierAction, this.f21430b, this.f21429a)) {
            Function0 function0 = (Function0) ArraysKt.getOrNull((T[]) function0Arr, 0);
            if (function0 != null) {
                function0.invoke();
                return;
            }
            return;
        }
        Function0 function02 = (Function0) ArraysKt.getOrNull((T[]) function0Arr, 1);
        if (function02 != null) {
            function02.invoke();
        }
    }
}
