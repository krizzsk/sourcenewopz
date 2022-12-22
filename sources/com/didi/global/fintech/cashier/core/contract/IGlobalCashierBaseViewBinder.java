package com.didi.global.fintech.cashier.core.contract;

import com.didi.global.fintech.cashier.p117ui.IGlobalCashierBaseViewHolder;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u0004\b\u0001\u0010\u00032\u00020\u0004J\b\u0010\u0005\u001a\u00020\u0006H&J\u0017\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00018\u0001H&¢\u0006\u0002\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00018\u0001H&¢\u0006\u0002\u0010\fJ#\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\b\u0010\u000e\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierBaseViewBinder;", "T", "Lcom/didi/global/fintech/cashier/ui/IGlobalCashierBaseViewHolder;", "D", "", "defaultVisible", "", "setupView", "", "data", "(Ljava/lang/Object;)V", "validate", "(Ljava/lang/Object;)Z", "viewBind", "viewHolder", "(Lcom/didi/global/fintech/cashier/ui/IGlobalCashierBaseViewHolder;)Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierBaseViewBinder;", "cashier_core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: IGlobalCashierViewBinders.kt */
public interface IGlobalCashierBaseViewBinder<T extends IGlobalCashierBaseViewHolder, D> {
    boolean defaultVisible();

    void setupView(D d);

    boolean validate(D d);

    IGlobalCashierBaseViewBinder<T, D> viewBind(T t);
}
