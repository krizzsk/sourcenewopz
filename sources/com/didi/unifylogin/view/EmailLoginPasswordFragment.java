package com.didi.unifylogin.view;

import com.didi.unifylogin.presenter.EmailLoginPasswordPresenter;
import com.didi.unifylogin.presenter.ability.ILoginPasswordPresenter;
import com.taxis99.R;

public class EmailLoginPasswordFragment extends LoginPasswordFragment {
    /* access modifiers changed from: protected */
    public ILoginPasswordPresenter bindPresenter() {
        return new EmailLoginPasswordPresenter(this, this.context);
    }

    /* access modifiers changed from: protected */
    public void updateView() {
        super.updateView();
        this.tvTitle.setText(getString(R.string.FoodOpB_account_Enter_password_alsZ));
        this.forgetPasswordTv.setText(getString(R.string.FoodOpB_account_Forget_the_oSyJ));
        this.confirmBtn.setText(getString(R.string.FoodOpB_account_Confirmation_LskV));
    }
}
