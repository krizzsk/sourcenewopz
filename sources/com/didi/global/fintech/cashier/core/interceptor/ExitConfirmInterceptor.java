package com.didi.global.fintech.cashier.core.interceptor;

import android.content.Context;
import com.didi.global.fintech.cashier.model.net.response.ShowInfo;
import com.didi.global.fintech.cashier.p117ui.dialog.GlobalCashierDialogCommonConfig;
import com.didi.global.fintech.cashier.p117ui.dialog.GlobalCashierDialogFactory;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \r2\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0003JC\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00022\"\u0010\t\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000b0\n\"\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000bH\u0016¢\u0006\u0002\u0010\f¨\u0006\u000e"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/core/interceptor/ExitConfirmInterceptor;", "Lcom/didi/global/fintech/cashier/core/interceptor/BaseInterceptor;", "Lcom/didi/global/fintech/cashier/model/net/response/ShowInfo$CancelConfirm;", "()V", "intercept", "", "context", "Landroid/content/Context;", "data", "interceptCallback", "", "Lkotlin/Function0;", "(Landroid/content/Context;Lcom/didi/global/fintech/cashier/model/net/response/ShowInfo$CancelConfirm;[Lkotlin/jvm/functions/Function0;)V", "Companion", "cashier_core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ExitConfirmInterceptor.kt */
public final class ExitConfirmInterceptor implements BaseInterceptor<ShowInfo.CancelConfirm> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final Lazy<ExitConfirmInterceptor> f21431a = LazyKt.lazy(ExitConfirmInterceptor$Companion$INS$2.INSTANCE);

    @JvmStatic
    public static final ExitConfirmInterceptor getInstance() {
        return Companion.getInstance();
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\u0004H\u0007R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/core/interceptor/ExitConfirmInterceptor$Companion;", "", "()V", "INS", "Lcom/didi/global/fintech/cashier/core/interceptor/ExitConfirmInterceptor;", "getINS", "()Lcom/didi/global/fintech/cashier/core/interceptor/ExitConfirmInterceptor;", "INS$delegate", "Lkotlin/Lazy;", "getInstance", "cashier_core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: ExitConfirmInterceptor.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        private final ExitConfirmInterceptor getINS() {
            return (ExitConfirmInterceptor) ExitConfirmInterceptor.f21431a.getValue();
        }

        @JvmStatic
        public final ExitConfirmInterceptor getInstance() {
            return getINS();
        }
    }

    public void intercept(Context context, ShowInfo.CancelConfirm cancelConfirm, Function0<Unit>... function0Arr) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(function0Arr, "interceptCallback");
        if (cancelConfirm == null || !Intrinsics.areEqual((Object) cancelConfirm.getNeedConfirm(), (Object) true)) {
            Function0 function0 = (Function0) ArraysKt.getOrNull((T[]) function0Arr, 1);
            if (function0 != null) {
                function0.invoke();
                return;
            }
            return;
        }
        GlobalCashierDialogFactory globalCashierDialogFactory = GlobalCashierDialogFactory.INSTANCE;
        GlobalCashierDialogFactory.TYPE type = GlobalCashierDialogFactory.TYPE.BOTTOM;
        GlobalCashierDialogCommonConfig globalCashierDialogCommonConfig = GlobalCashierDialogCommonConfig.EXIT_CONFORM;
        String title = cancelConfirm.getTitle();
        if (title != null) {
            globalCashierDialogCommonConfig.setTitle(title);
        }
        String message = cancelConfirm.getMessage();
        if (message != null) {
            globalCashierDialogCommonConfig.setSubTitle(message);
        }
        Unit unit = Unit.INSTANCE;
        globalCashierDialogFactory.showDialog(context, type, globalCashierDialogCommonConfig, new ExitConfirmInterceptor$intercept$2(function0Arr), new ExitConfirmInterceptor$intercept$3(function0Arr));
        Function0 function02 = (Function0) ArraysKt.getOrNull((T[]) function0Arr, 0);
        if (function02 != null) {
            function02.invoke();
        }
    }
}
