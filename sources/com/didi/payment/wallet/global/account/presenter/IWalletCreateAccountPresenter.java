package com.didi.payment.wallet.global.account.presenter;

import com.didi.payment.base.mvp.IBasePresenter;
import com.didi.payment.base.mvp.IBaseView;

public interface IWalletCreateAccountPresenter<T extends IBaseView> extends IBasePresenter<T> {
    void createAccount(String str, String str2, String str3, String str4);

    void requestLocationOnce();
}
