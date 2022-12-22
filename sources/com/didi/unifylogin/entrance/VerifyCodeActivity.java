package com.didi.unifylogin.entrance;

import android.os.Bundle;
import com.didi.sdk.apm.SystemUtils;
import com.didi.unifylogin.base.model.FragmentMessenger;
import com.didi.unifylogin.base.net.LoginScene;
import com.didi.unifylogin.base.view.AbsLoginBaseActivity;
import com.didi.unifylogin.listener.ListenerManager;
import com.didi.unifylogin.listener.LoginListeners;
import com.didi.unifylogin.utils.LoginLog;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.didi.unifylogin.utils.LoginState;
import java.util.Map;

public class VerifyCodeActivity extends AbsLoginBaseActivity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        LoginListeners.VerifyCodeListener verifyCodeListener = ListenerManager.getVerifyCodeListener();
        if (verifyCodeListener != null) {
            verifyCodeListener.onActivityCreated(this);
        }
    }

    public void onFlowFinish(int i, FragmentMessenger fragmentMessenger) {
        LoginLog.write(this.TAG + " onFlowFinish result: " + i);
        LoginOmegaUtil.setOmegaMap((Map<String, Object>) null);
        if (i == -1) {
            LoginListeners.VerifyCodeListener verifyCodeListener = ListenerManager.getVerifyCodeListener();
            if (verifyCodeListener != null) {
                verifyCodeListener.onSuccess(this, fragmentMessenger.getVerifyCOdeKey(), fragmentMessenger.getNewCell());
            }
        } else {
            LoginListeners.VerifyCodeListener verifyCodeListener2 = ListenerManager.getVerifyCodeListener();
            if (verifyCodeListener2 != null) {
                verifyCodeListener2.onFail();
            }
        }
        finish();
    }

    public void onCancel() {
        LoginLog.write(this.TAG + " onCancel");
    }

    public LoginScene getInitScene() {
        return LoginScene.SCENE_CHANGE_PHONE_WITH_CODE;
    }

    public LoginState getInitState() {
        return LoginState.STATE_NEW_PHONE;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        LoginListeners.VerifyCodeListener verifyCodeListener = ListenerManager.getVerifyCodeListener();
        if (verifyCodeListener != null) {
            verifyCodeListener.onActivityDestroy();
        }
    }
}
