package com.didi.global.fintech.cashier.core.interceptor;

import com.didi.global.fintech.cashier.p117ui.dialog.GlobalCashierDialogCallback;
import com.didi.sdk.util.UiThreadHandler;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, mo175978d2 = {"com/didi/global/fintech/cashier/core/interceptor/ExitConfirmInterceptor$intercept$3", "Lcom/didi/global/fintech/cashier/ui/dialog/GlobalCashierDialogCallback;", "onBtnClick", "", "cashier_core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ExitConfirmInterceptor.kt */
public final class ExitConfirmInterceptor$intercept$3 implements GlobalCashierDialogCallback {
    final /* synthetic */ Function0<Unit>[] $interceptCallback;

    ExitConfirmInterceptor$intercept$3(Function0<Unit>[] function0Arr) {
        this.$interceptCallback = function0Arr;
    }

    public void onBtnClick() {
        Function0 function0 = (Function0) ArraysKt.getOrNull((T[]) this.$interceptCallback, 3);
        if (function0 != null) {
            UiThreadHandler.postDelayed(new Runnable() {
                public final void run() {
                    ExitConfirmInterceptor$intercept$3.m46441onBtnClick$lambda1$lambda0(Function0.this);
                }
            }, 300);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onBtnClick$lambda-1$lambda-0  reason: not valid java name */
    public static final void m46441onBtnClick$lambda1$lambda0(Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "$tmp0");
        function0.invoke();
    }
}
