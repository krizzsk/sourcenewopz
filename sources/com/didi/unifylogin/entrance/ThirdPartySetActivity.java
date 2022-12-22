package com.didi.unifylogin.entrance;

import android.content.Intent;
import com.didi.thirdpartylogin.base.AbsThirdPartyLoginBase;
import com.didi.thirdpartylogin.base.ThirdPartyLoginManager;
import com.didi.unifylogin.base.model.FragmentMessenger;
import com.didi.unifylogin.base.net.LoginScene;
import com.didi.unifylogin.base.view.AbsLoginBaseActivity;
import com.didi.unifylogin.utils.LoginLog;
import com.didi.unifylogin.utils.LoginState;

public class ThirdPartySetActivity extends AbsLoginBaseActivity {
    public void onFlowFinish(int i, FragmentMessenger fragmentMessenger) {
        LoginLog.write(this.TAG + " onFlowFinish result: " + i);
    }

    public void onCancel() {
        LoginLog.write(this.TAG + " onCancel");
    }

    public LoginScene getInitScene() {
        return LoginScene.SCENE_UNDEFINED;
    }

    public LoginState getInitState() {
        return LoginState.STATE_THIRD_PARTY_SET;
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (ThirdPartyLoginManager.getThirdPartyLogins() != null) {
            for (AbsThirdPartyLoginBase handleLoginResult : ThirdPartyLoginManager.getThirdPartyLogins()) {
                handleLoginResult.handleLoginResult(i, i2, intent);
            }
        }
    }
}
