package com.didi.unifylogin.presenter.ability;

import com.didi.unifylogin.base.presenter.ILoginBaseFillerPresenter;

public interface IPreCertificationPresenter extends ILoginBaseFillerPresenter {
    void checkResult();

    void openCertification(String str);
}
