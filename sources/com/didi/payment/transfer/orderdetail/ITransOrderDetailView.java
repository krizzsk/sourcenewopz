package com.didi.payment.transfer.orderdetail;

import com.didi.payment.transfer.common.IPageView;
import com.didi.payment.transfer.orderdetail.presenter.IOrderDetailPresenter;
import com.didi.payment.transfer.orderdetail.presenter.TransPayResultResp;

public interface ITransOrderDetailView extends IPageView<IOrderDetailPresenter> {
    void onGotOrderStatus(TransPayResultResp.PayResultData payResultData);

    void onNetworkError();

    void onPageFinish();

    void onUpdateCountDownLoading(int i, int i2);

    void showShareWindow(String str);

    void stopCountdownLoading();
}
