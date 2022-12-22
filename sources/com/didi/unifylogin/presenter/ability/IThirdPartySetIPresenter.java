package com.didi.unifylogin.presenter.ability;

import com.didi.thirdpartylogin.base.AbsThirdPartyLoginBase;
import com.didi.unifylogin.base.presenter.ILoginBasePresenter;

public interface IThirdPartySetIPresenter extends ILoginBasePresenter {
    void bind(AbsThirdPartyLoginBase absThirdPartyLoginBase);

    void loadThirdPartys();

    void unBind(AbsThirdPartyLoginBase absThirdPartyLoginBase);
}
