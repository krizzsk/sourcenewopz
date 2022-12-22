package com.didi.unifylogin.view;

import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.unifylogin.base.model.FragmentMessenger;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.didi.unifylogin.utils.LoginState;

public class ConfirmSnatchCellFragment extends AbsPromptFragment {
    public void initListener() {
        this.f45011e.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                new LoginOmegaUtil(LoginOmegaUtil.TONE_P_X_PHOECHGE_CHANGE_CK).send();
                new LoginOmegaUtil(LoginOmegaUtil.CONFM_CK).send();
                ConfirmSnatchCellFragment.this.presenter.updateOmegaScene(FragmentMessenger.getNowScene());
                ConfirmSnatchCellFragment.this.presenter.transform(LoginState.STATE_NEW_CODE);
            }
        });
    }

    public LoginState getNowState() {
        return LoginState.STATE_CONFIRM_SNATCH;
    }
}
