package com.didi.unifylogin.presenter.ability;

import com.didi.unifylogin.base.presenter.ILoginBasePresenter;

public interface IPreSetEmailPresenter extends ILoginBasePresenter {
    void getEmailState();

    void toActivate();
}
