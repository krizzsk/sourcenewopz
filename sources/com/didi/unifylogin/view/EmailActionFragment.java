package com.didi.unifylogin.view;

import com.didi.unifylogin.utils.LoginState;

public class EmailActionFragment extends InfoActionFragment {
    /* access modifiers changed from: protected */
    public void updateView() {
        super.updateView();
        setNameVisibility(false);
        setLastNameVisibility(false);
    }

    public LoginState getNowState() {
        return LoginState.STATE_EMAIL_ACTION;
    }
}
