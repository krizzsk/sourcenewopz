package com.didi.component.servicecontrol.nopay.impl.view;

import com.didi.component.core.IView;
import com.didi.component.servicecontrol.nopay.AbsServiceControlNopayPresenter;
import com.didi.travel.psnger.model.response.CashUnPayInterceptInfo;

public interface IServiceControlNopayView extends IView<AbsServiceControlNopayPresenter> {
    void close();

    void hideLoading();

    void showLoading();

    void showNoPayView(CashUnPayInterceptInfo cashUnPayInterceptInfo);
}
