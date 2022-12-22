package com.didi.global.fintech.cashier.fastpay.contract;

import com.didi.global.fintech.cashier.p117ui.IGlobalCashierBaseViewHolder;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0002*\u00020\u00032\u00020\u0004J\u0015\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00028\u0000H&¢\u0006\u0002\u0010\bJ\u0015\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u000bJ#\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\b\u0010\r\u001a\u0004\u0018\u00018\u0001H&¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/fastpay/contract/IFastPayBaseViewBinder;", "D", "T", "Lcom/didi/global/fintech/cashier/ui/IGlobalCashierBaseViewHolder;", "", "setupView", "", "data", "(Ljava/lang/Object;)V", "validate", "", "(Ljava/lang/Object;)Z", "viewBind", "viewHolder", "(Lcom/didi/global/fintech/cashier/ui/IGlobalCashierBaseViewHolder;)Lcom/didi/global/fintech/cashier/fastpay/contract/IFastPayBaseViewBinder;", "cashier_fastpay_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: IFastPayViewBinders.kt */
public interface IFastPayBaseViewBinder<D, T extends IGlobalCashierBaseViewHolder> {
    void setupView(D d);

    boolean validate(D d);

    IFastPayBaseViewBinder<D, T> viewBind(T t);
}
