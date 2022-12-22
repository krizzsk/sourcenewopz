package com.didi.unifylogin.presenter.ability;

import com.didi.unifylogin.base.presenter.ILoginBasePresenter;

public interface IDeleteAccountManualPresenter extends ILoginBasePresenter {
    void deleteAcc();

    void goDeleteAccountReasons();

    void goVerifyCode();
}
