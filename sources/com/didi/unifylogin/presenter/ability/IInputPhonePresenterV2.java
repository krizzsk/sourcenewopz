package com.didi.unifylogin.presenter.ability;

import android.view.View;
import com.didi.unifylogin.utils.customview.AbsLoginTitleBar;

public interface IInputPhonePresenterV2 extends IInputPhonePresenter {
    void clickClearPhone();

    void clickCountry();

    void clickPhone();

    void initViewAnimatorHelper(View view, AbsLoginTitleBar absLoginTitleBar);

    boolean onBackPressed();

    void preLoginRequest();
}
