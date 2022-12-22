package com.didi.unifylogin.view;

import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.didi.unifylogin.utils.LoginState;

public class SetCellErrorFragment extends AbsPromptFragment {
    public void initListener() {
        this.f45011e.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                new LoginOmegaUtil(LoginOmegaUtil.CONFM_CK).send();
                SetCellErrorFragment.this.goBack();
            }
        });
    }

    public LoginState getNowState() {
        return LoginState.STATE_SETCELL_ERROR;
    }
}
