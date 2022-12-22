package com.didi.unifylogin.view;

import com.didi.unifylogin.presenter.VerifyEmailRegisterCodePresenter;
import com.didi.unifylogin.presenter.ability.IVerifyCodePresenter;
import com.taxis99.R;

public class VerifyEmailRegisterCodeFragment extends VerifyEmailCodeFragment {
    /* access modifiers changed from: protected */
    public IVerifyCodePresenter bindPresenter() {
        return new VerifyEmailRegisterCodePresenter(this, this.context);
    }

    /* access modifiers changed from: protected */
    public void updateView() {
        super.updateView();
        this.titleTv.setText(getString(R.string.FoodOpB_account_Enter_verification_rODE));
        this.subTitleTv.setText(getString(R.string.FoodOpB_account_The_verification_OXfa));
        this.codeLenTv.setText(getString(R.string.FoodOpB_account_6_digit_vGOk));
        this.retryCodeBtn.setText(getString(R.string.FoodOpB_account_Resend_CJNc));
    }
}
