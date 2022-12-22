package com.didi.unifylogin.view.ability;

import com.didi.unifylogin.base.view.ability.ILoginBaseFragment;

public interface IRestPwdView extends ILoginBaseFragment {
    String getNewPwd();

    String getOldPwd();
}
