package com.didi.global.fintech.cashier.fastpay.contract;

import com.didi.global.fintech.cashier.p117ui.IGlobalCashierBaseViewHolder;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006H&J\u0012\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\rH&¨\u0006\u000e"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/fastpay/contract/IFastPayBasePresenter;", "D", "Lcom/didi/global/fintech/cashier/fastpay/contract/IFastPayCorePresenter;", "addViewBinder", "", "binder", "Lcom/didi/global/fintech/cashier/fastpay/contract/IFastPayBaseViewBinder;", "Lcom/didi/global/fintech/cashier/ui/IGlobalCashierBaseViewHolder;", "getString", "", "id", "", "onBackPressed", "", "cashier_fastpay_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: IFastPayPresenters.kt */
public interface IFastPayBasePresenter<D> extends IFastPayCorePresenter {
    boolean addViewBinder(IFastPayBaseViewBinder<D, ? extends IGlobalCashierBaseViewHolder> iFastPayBaseViewBinder);

    String getString(int i);

    void onBackPressed();
}
