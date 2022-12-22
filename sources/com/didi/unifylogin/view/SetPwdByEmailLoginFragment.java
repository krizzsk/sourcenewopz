package com.didi.unifylogin.view;

import com.didi.unifylogin.base.net.LoginScene;
import com.didi.unifylogin.presenter.ForgetEmailSetPwdPresenter;
import com.didi.unifylogin.presenter.SetPwdByEmailLoginPresenter;
import com.didi.unifylogin.presenter.ability.ISetPwdPresenter;
import com.didi.unifylogin.utils.LoginState;
import com.didi.unifylogin.utils.PasswordUtils;
import com.taxis99.R;

public class SetPwdByEmailLoginFragment extends SetPwdFragment {

    /* renamed from: com.didi.unifylogin.view.SetPwdByEmailLoginFragment$1 */
    static /* synthetic */ class C147381 {
        static final /* synthetic */ int[] $SwitchMap$com$didi$unifylogin$base$net$LoginScene;

        static {
            int[] iArr = new int[LoginScene.values().length];
            $SwitchMap$com$didi$unifylogin$base$net$LoginScene = iArr;
            try {
                iArr[LoginScene.SCENE_FORGETPWD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public ISetPwdPresenter bindPresenter() {
        if (C147381.$SwitchMap$com$didi$unifylogin$base$net$LoginScene[this.messenger.getScene().ordinal()] != 1) {
            return new SetPwdByEmailLoginPresenter(this, this.context);
        }
        return new ForgetEmailSetPwdPresenter(this, this.context);
    }

    public LoginState getNowState() {
        return LoginState.STATE_SET_PWD_BY_EMAIL;
    }

    /* access modifiers changed from: protected */
    public void updateView() {
        super.updateView();
        setTitle(getString(R.string.FoodOpB_account_Create_a_VRQh));
        setSubTitle(getString(R.string.login_unify_set_pwd_sub_title, this.messenger.getHideEmail()));
        this.validHint.setText(getString(R.string.login_unify_set_password_tips_2, Integer.valueOf(PasswordUtils.getMinDigit())));
        this.tvMixHint.setText(getString(R.string.login_unify_verify_old_password_err_tips_2));
        this.confirmBtn.setText(getString(R.string.FoodOpB_account_Confirmation_LskV));
    }
}
