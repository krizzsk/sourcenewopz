package com.didi.global.fintech.cashier.core.contract;

import com.didi.global.fintech.cashier.model.net.response.PayInfoResponse;
import com.didi.global.fintech.cashier.p117ui.IGlobalCashierPolicyViewHolder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\b\u0010\u0004\u001a\u00020\u0005H&J\u001e\u0010\u0006\u001a\u00020\u00072\u0014\u0010\b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u00070\tH&¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierPolicyViewBinder;", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierBaseViewBinder;", "Lcom/didi/global/fintech/cashier/ui/IGlobalCashierPolicyViewHolder;", "Lcom/didi/global/fintech/cashier/model/net/response/PayInfoResponse;", "checked", "", "registerLinkListener", "", "listener", "Lkotlin/Function1;", "", "cashier_core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: IGlobalCashierViewBinders.kt */
public interface IGlobalCashierPolicyViewBinder extends IGlobalCashierBaseViewBinder<IGlobalCashierPolicyViewHolder, PayInfoResponse> {
    boolean checked();

    void registerLinkListener(Function1<? super String, Unit> function1);
}
