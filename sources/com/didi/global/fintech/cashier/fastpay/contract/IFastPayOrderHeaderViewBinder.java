package com.didi.global.fintech.cashier.fastpay.contract;

import com.didi.global.fintech.cashier.p117ui.IFastPayHeaderViewHolder;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00030\u0002J\b\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&¨\u0006\t"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/fastpay/contract/IFastPayOrderHeaderViewBinder;", "D", "Lcom/didi/global/fintech/cashier/fastpay/contract/IFastPayBaseViewBinder;", "Lcom/didi/global/fintech/cashier/ui/IFastPayHeaderViewHolder;", "onBackClick", "", "updateHeader", "content", "", "cashier_fastpay_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: IFastPayViewBinders.kt */
public interface IFastPayOrderHeaderViewBinder<D> extends IFastPayBaseViewBinder<D, IFastPayHeaderViewHolder> {
    void onBackClick();

    void updateHeader(String str);
}
