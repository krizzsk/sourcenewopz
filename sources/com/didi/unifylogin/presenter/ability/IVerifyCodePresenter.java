package com.didi.unifylogin.presenter.ability;

import com.didi.unifylogin.base.presenter.ILoginBasePresenter;
import com.didi.unifylogin.utils.LoginChoicePopUtil;
import java.util.List;

public interface IVerifyCodePresenter extends ILoginBasePresenter {
    List<LoginChoicePopUtil.ChoiceItem> getChoices();

    int getCodeType();

    String getPhone();

    void handleChoice(int i);

    void nextOperate();

    void notReceiveCode();

    void requestSms(int i);

    void retrieveAcc();

    void setCell(boolean z, boolean z2);

    void setCodeType(int i);

    void startCountDown();
}
