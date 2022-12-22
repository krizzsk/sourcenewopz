package com.didi.unifylogin.view;

import android.text.TextUtils;
import com.didi.unifylogin.presenter.LoginPhonePresenter;
import com.didi.unifylogin.presenter.ability.IInputPhonePresenter;
import com.didi.unifylogin.utils.LoginLog;
import com.didi.unifylogin.utils.LoginState;
import com.taxis99.R;

public class ThirdPartyPhoneFragment extends InputPhoneFragment {
    /* access modifiers changed from: protected */
    public void updateView() {
        super.updateView();
        setTitleBarLeftVisible(true);
        setTitleBarRightVisible(false);
        setOtherWaVisibility(false);
        setTitle(getString(R.string.login_unify_third_phone_title));
        setSubTitle(getString(R.string.login_unify_input_phone_sub_title));
        hideThirdPartyView();
        this.messenger.setNeedBind(true);
        if (this.messenger.getAuthInfo() != null && !TextUtils.isEmpty(this.messenger.getAuthInfo().getCell())) {
            this.phoneEt.setText(this.messenger.getAuthInfo().getCell());
        }
    }

    public LoginState getNowState() {
        return LoginState.STATE_BIND_THIRD_PHONE;
    }

    /* access modifiers changed from: protected */
    public IInputPhonePresenter bindPresenter() {
        LoginLog.write(this.TAG + " bindPresenter preScene:" + this.preScene.getSceneNum());
        return new LoginPhonePresenter(this, this.context, true, this.messenger.getChannel());
    }
}
