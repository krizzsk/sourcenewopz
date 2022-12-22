package com.didi.unifylogin.view;

import com.didi.unifylogin.utils.LoginState;

public class NameActionFragment extends InfoActionFragment {
    /* access modifiers changed from: protected */
    public void updateView() {
        super.updateView();
        setEmailVisibility(false);
        this.subTitleTv.setVisibility(8);
    }

    public LoginState getNowState() {
        return LoginState.STATE_NAME_ACTION;
    }
}
