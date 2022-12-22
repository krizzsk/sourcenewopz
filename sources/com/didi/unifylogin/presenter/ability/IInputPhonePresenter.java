package com.didi.unifylogin.presenter.ability;

import android.content.Context;
import com.didi.thirdpartylogin.base.AbsThirdPartyLoginBase;
import com.didi.unifylogin.base.presenter.ILoginBasePresenter;

public interface IInputPhonePresenter extends ILoginBasePresenter {
    void getThirdPartyToken(AbsThirdPartyLoginBase absThirdPartyLoginBase);

    void go2InputCPF(Context context);

    void goLogin(int i);

    void goRegByKey(String str);

    void nextOperate();

    void retrieveAccount();
}
