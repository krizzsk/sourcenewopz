package com.didi.unifylogin.presenter.ability;

import com.didi.unifylogin.base.presenter.ILoginBasePresenter;

public interface IDeleteAccountReasonsPresenter extends ILoginBasePresenter {
    void deleteAcc();

    void goDeleteAccountFailed();

    void goVerifyCode();
}
