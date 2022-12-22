package com.didi.unifylogin.view.ability;

import com.didi.unifylogin.base.view.ability.ILoginBaseFragment;

public interface IVerifyCodeView extends ILoginBaseFragment {
    void cleanCode();

    String getCode();

    void resetCodeStatus();

    void setCountDownTime(int i);

    void setNotReceiveVisibility(int i);

    void showChoicePopupMenu();

    void showIdentityAuthPromptInfo();

    void showRetryGetCode();

    void voiceDialog();
}
