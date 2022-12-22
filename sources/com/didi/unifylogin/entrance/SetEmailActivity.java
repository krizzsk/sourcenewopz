package com.didi.unifylogin.entrance;

import com.didi.unifylogin.base.model.FragmentMessenger;
import com.didi.unifylogin.base.net.LoginScene;
import com.didi.unifylogin.base.view.AbsLoginBaseActivity;
import com.didi.unifylogin.listener.ListenerManager;
import com.didi.unifylogin.utils.LoginLog;
import com.didi.unifylogin.utils.LoginState;

public class SetEmailActivity extends AbsLoginBaseActivity {
    public void onFlowFinish(int i, FragmentMessenger fragmentMessenger) {
        LoginLog.write(this.TAG + " onFlowFinish result: " + i);
        if (ListenerManager.getModifyEmailListener() != null) {
            if (i == -1) {
                ListenerManager.getModifyEmailListener().onSuccess(this);
            } else {
                ListenerManager.getModifyEmailListener().onCancel();
            }
        }
        finish();
    }

    public void onCancel() {
        if (ListenerManager.getModifyEmailListener() != null) {
            ListenerManager.getModifyEmailListener().onCancel();
        }
    }

    public LoginScene getInitScene() {
        return LoginScene.SCENE_RESET_EMAIL;
    }

    public LoginState getInitState() {
        return LoginState.STATE_PRE_SET_EMAIL;
    }
}
