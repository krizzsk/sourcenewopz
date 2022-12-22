package com.didi.unifylogin.base.view.ability;

import com.didi.unifylogin.base.model.FragmentMessenger;
import com.didi.unifylogin.base.net.LoginScene;
import com.didi.unifylogin.utils.LoginState;

public interface ILoginBaseActivity extends ILoginBaseView {
    LoginScene getInitScene();

    LoginState getInitState();

    boolean isForbidBack();

    boolean isPopBack();

    void onCancel();

    void onFlowFinish(int i, FragmentMessenger fragmentMessenger);

    void setForbidBack(boolean z);

    void setIsPopBack(boolean z);

    void transform(LoginState loginState, LoginState loginState2, FragmentMessenger fragmentMessenger);
}
