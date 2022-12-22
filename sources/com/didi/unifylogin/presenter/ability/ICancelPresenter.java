package com.didi.unifylogin.presenter.ability;

import com.didi.unifylogin.base.presenter.ILoginBasePresenter;

public interface ICancelPresenter extends ILoginBasePresenter {
    void deleteAcc();

    void goVerifyCode();
}
