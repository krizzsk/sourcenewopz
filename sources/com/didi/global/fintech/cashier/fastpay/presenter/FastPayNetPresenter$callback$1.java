package com.didi.global.fintech.cashier.fastpay.presenter;

import com.didi.global.fintech.cashier.fastpay.contract.IFastPayNetPresenter;
import com.didi.global.fintech.cashier.model.CashierError;
import com.didi.global.fintech.cashier.network.callback.CashierNetCallback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0015\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\b¨\u0006\t"}, mo175978d2 = {"com/didi/global/fintech/cashier/fastpay/presenter/FastPayNetPresenter$callback$1", "Lcom/didi/global/fintech/cashier/network/callback/CashierNetCallback;", "onFailure", "", "error", "Lcom/didi/global/fintech/cashier/model/CashierError;", "onSuccess", "response", "(Ljava/lang/Object;)V", "cashier_fastpay_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FastPayNetPresenter.kt */
public final class FastPayNetPresenter$callback$1 implements CashierNetCallback<T> {
    final /* synthetic */ IFastPayNetPresenter.API $API;
    final /* synthetic */ Function1<T, Unit> $success;
    final /* synthetic */ FastPayNetPresenter this$0;

    FastPayNetPresenter$callback$1(Function1<? super T, Unit> function1, FastPayNetPresenter fastPayNetPresenter, IFastPayNetPresenter.API api) {
        this.$success = function1;
        this.this$0 = fastPayNetPresenter;
        this.$API = api;
    }

    public void onSuccess(T t) {
        this.$success.invoke(t);
    }

    public void onFailure(CashierError cashierError) {
        Intrinsics.checkNotNullParameter(cashierError, "error");
        this.this$0.onRequestFailed(this.$API, cashierError);
    }
}
