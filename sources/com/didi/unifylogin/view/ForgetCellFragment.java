package com.didi.unifylogin.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.unifylogin.base.presenter.ILoginBasePresenter;
import com.didi.unifylogin.base.presenter.LoginBasePresenter;
import com.didi.unifylogin.base.view.AbsLoginBaseFragment;
import com.didi.unifylogin.utils.LoginState;
import com.taxis99.R;

public class ForgetCellFragment extends AbsLoginBaseFragment {
    public void initListener() {
    }

    /* access modifiers changed from: protected */
    public ILoginBasePresenter bindPresenter() {
        return new LoginBasePresenter(this, this.context);
    }

    public View initView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return layoutInflater.inflate(R.layout.login_unify_fragment_forget_cell, viewGroup, false);
    }

    public LoginState getNowState() {
        return LoginState.STATE_FORGET_CELL;
    }
}
