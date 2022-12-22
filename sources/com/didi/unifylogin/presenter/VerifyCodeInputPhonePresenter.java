package com.didi.unifylogin.presenter;

import android.content.Context;
import android.text.TextUtils;
import com.didi.sdk.util.ToastHelper;
import com.didi.unifylogin.api.LoginPreferredConfig;
import com.didi.unifylogin.base.model.FragmentMessenger;
import com.didi.unifylogin.base.presenter.LoginBasePresenter;
import com.didi.unifylogin.presenter.ability.IInputNewPhonePresenter;
import com.didi.unifylogin.utils.LoginState;
import com.didi.unifylogin.utils.phone.PhoneUtils;
import com.didi.unifylogin.view.ability.IInputNewPhoneView;
import com.taxis99.R;

public class VerifyCodeInputPhonePresenter extends LoginBasePresenter<IInputNewPhoneView> implements IInputNewPhonePresenter {
    public VerifyCodeInputPhonePresenter(IInputNewPhoneView iInputNewPhoneView, Context context) {
        super(iInputNewPhoneView, context);
    }

    public void updateView() {
        super.updateView();
        String inputNewPhoneTitle = LoginPreferredConfig.getTextAdapter(this.messenger).getInputNewPhoneTitle(this.context);
        if (!TextUtils.isEmpty(inputNewPhoneTitle)) {
            ((IInputNewPhoneView) this.view).setTitle(inputNewPhoneTitle);
        }
        String inputNewPhoneSubTitle = LoginPreferredConfig.getTextAdapter(this.messenger).getInputNewPhoneSubTitle(this.context);
        if (!TextUtils.isEmpty(inputNewPhoneSubTitle)) {
            ((IInputNewPhoneView) this.view).setSubTitle(inputNewPhoneSubTitle);
        }
    }

    public void verifyPhone() {
        String normalPhone = PhoneUtils.toNormalPhone(((IInputNewPhoneView) this.view).getPhone());
        String inputNewPhoneTel = LoginPreferredConfig.getTextAdapter(this.messenger).getInputNewPhoneTel(this.context);
        if (inputNewPhoneTel == null || !inputNewPhoneTel.equals(normalPhone)) {
            getMessenger().setNewCell(normalPhone);
            updateOmegaScene(FragmentMessenger.getNowScene());
            transform(LoginState.STATE_NEW_CODE);
            return;
        }
        ToastHelper.showShortInfo(this.context, this.context.getString(R.string.login_unify_str_input_new_phone));
    }
}
