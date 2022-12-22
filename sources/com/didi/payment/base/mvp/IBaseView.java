package com.didi.payment.base.mvp;

import com.didi.payment.base.mvp.IBasePresenter;

public interface IBaseView<T extends IBasePresenter> {
    void hideLoading();

    void showLoading();

    void showToast(String str);

    void showToastComplete(String str);
}
