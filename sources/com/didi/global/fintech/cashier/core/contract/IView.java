package com.didi.global.fintech.cashier.core.contract;

import android.view.View;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00072\u000e\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00000\tH&R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\n"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/core/contract/IView;", "", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "bindPresenter", "", "presenter", "Lcom/didi/global/fintech/cashier/core/contract/IPresenter;", "cashier_core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: IGlobalCashierViews.kt */
public interface IView {
    void bindPresenter(IPresenter<? extends IView> iPresenter);

    View getView();
}
