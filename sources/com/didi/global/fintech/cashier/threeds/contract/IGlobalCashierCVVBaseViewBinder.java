package com.didi.global.fintech.cashier.threeds.contract;

import com.didi.global.fintech.cashier.model.net.response.CVVInfoResponse;
import com.didi.global.fintech.cashier.p117ui.IGlobalCashierBaseViewHolder;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&J\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\u0010\u000b\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0002\u0010\f¨\u0006\r"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/threeds/contract/IGlobalCashierCVVBaseViewBinder;", "T", "Lcom/didi/global/fintech/cashier/ui/IGlobalCashierBaseViewHolder;", "", "setupView", "", "data", "Lcom/didi/global/fintech/cashier/model/net/response/CVVInfoResponse;", "validate", "", "viewBind", "viewHolder", "(Lcom/didi/global/fintech/cashier/ui/IGlobalCashierBaseViewHolder;)Lcom/didi/global/fintech/cashier/threeds/contract/IGlobalCashierCVVBaseViewBinder;", "cashier_threeds_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: IGlobalCashierThreeDSViewBinders.kt */
public interface IGlobalCashierCVVBaseViewBinder<T extends IGlobalCashierBaseViewHolder> {
    void setupView(CVVInfoResponse cVVInfoResponse);

    boolean validate();

    IGlobalCashierCVVBaseViewBinder<T> viewBind(T t);
}
