package com.didi.unifylogin.view.ability;

import com.didi.unifylogin.base.view.ability.ILoginBaseFragment;

public interface IPreSetEmailView extends ILoginBaseFragment {
    void showActivateDialog();

    void showErrorView();

    void upDateByState(int i, long j);
}
