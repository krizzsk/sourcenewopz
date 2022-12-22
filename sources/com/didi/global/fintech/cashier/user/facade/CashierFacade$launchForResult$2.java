package com.didi.global.fintech.cashier.user.facade;

import android.content.Intent;
import androidx.fragment.app.Fragment;
import com.didi.global.fintech.cashier.user.model.CashierParam;
import com.didi.global.fintech.cashier.user.spi.IGlobalCashierProcessor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, mo175978d2 = {"<anonymous>", "", "result", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CashierFacade.kt */
final class CashierFacade$launchForResult$2 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ Fragment $fragment;
    final /* synthetic */ CashierLaunchListener $listener;
    final /* synthetic */ CashierParam $param;
    final /* synthetic */ int $requestCode;
    final /* synthetic */ CashierFacade this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CashierFacade$launchForResult$2(CashierLaunchListener cashierLaunchListener, CashierFacade cashierFacade, Fragment fragment, int i, CashierParam cashierParam) {
        super(1);
        this.$listener = cashierLaunchListener;
        this.this$0 = cashierFacade;
        this.$fragment = fragment;
        this.$requestCode = i;
        this.$param = cashierParam;
    }

    public /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z) {
        CashierLaunchListener cashierLaunchListener = this.$listener;
        if (cashierLaunchListener != null) {
            cashierLaunchListener.onCashierLaunch(z);
        }
        CashierFacade cashierFacade = this.this$0;
        if (!z) {
            cashierFacade = null;
        }
        if (cashierFacade != null) {
            CashierFacade cashierFacade2 = this.this$0;
            Fragment fragment = this.$fragment;
            int i = this.$requestCode;
            CashierParam cashierParam = this.$param;
            IGlobalCashierProcessor access$getCashierProcessor$p = cashierFacade2.f22022b;
            if (access$getCashierProcessor$p != null) {
                access$getCashierProcessor$p.launch(fragment, (Intent) null, Integer.valueOf(i), cashierParam);
            }
        }
    }
}
