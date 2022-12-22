package com.didi.unifylogin.base.presenter;

import com.didi.unifylogin.base.net.LoginScene;
import com.didi.unifylogin.base.net.pojo.response.BaseLoginSuccessResponse;
import com.didi.unifylogin.utils.LoginState;

public interface ILoginBasePresenter {
    LoginScene getScene();

    int getSceneNum();

    void goFillInfo();

    void goFillNextInfo(LoginState loginState);

    void handToken(BaseLoginSuccessResponse baseLoginSuccessResponse);

    void setScene(LoginScene loginScene);

    void transform(LoginState loginState);

    void updateOmegaScene(LoginScene loginScene);

    void updateView();
}
