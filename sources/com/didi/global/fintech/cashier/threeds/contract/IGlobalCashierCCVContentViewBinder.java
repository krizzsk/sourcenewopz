package com.didi.global.fintech.cashier.threeds.contract;

import com.didi.global.fintech.cashier.p117ui.IGlobalCashierCVVViewHolder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\u001c\u0010\u0007\u001a\u00020\u00062\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00060\tH&¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/threeds/contract/IGlobalCashierCCVContentViewBinder;", "Lcom/didi/global/fintech/cashier/threeds/contract/IGlobalCashierCVVBaseViewBinder;", "Lcom/didi/global/fintech/cashier/ui/IGlobalCashierCVVViewHolder;", "getCvvContent", "", "onDrawerClick", "", "registerTextChangeListener", "listener", "Lkotlin/Function1;", "", "cashier_threeds_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: IGlobalCashierThreeDSViewBinders.kt */
public interface IGlobalCashierCCVContentViewBinder extends IGlobalCashierCVVBaseViewBinder<IGlobalCashierCVVViewHolder> {
    String getCvvContent();

    void onDrawerClick();

    void registerTextChangeListener(Function1<? super Integer, Unit> function1);
}
