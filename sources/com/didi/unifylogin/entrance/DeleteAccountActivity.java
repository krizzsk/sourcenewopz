package com.didi.unifylogin.entrance;

import android.content.Context;
import com.didi.sdk.login.LoginReason;
import com.didi.sdk.util.ToastHelper;
import com.didi.sdk.util.UiThreadHandler;
import com.didi.unifylogin.base.model.FragmentMessenger;
import com.didi.unifylogin.base.net.LoginScene;
import com.didi.unifylogin.base.view.AbsLoginBaseActivity;
import com.didi.unifylogin.externalfunction.LogoutManager;
import com.didi.unifylogin.listener.ListenerManager;
import com.didi.unifylogin.listener.LoginListeners;
import com.didi.unifylogin.store.LoginStore;
import com.didi.unifylogin.utils.LoginLog;
import com.didi.unifylogin.utils.LoginState;
import com.taxis99.R;

public class DeleteAccountActivity extends AbsLoginBaseActivity {
    public void onFlowFinish(final int i, FragmentMessenger fragmentMessenger) {
        LoginLog.write(this.TAG + " onFlowFinish result: " + i);
        if (ListenerManager.getCAFinishListener() == null) {
            return;
        }
        if (i == -1) {
            ToastHelper.showShortCompleted((Context) this, (int) R.string.Global_Driver_drv_delete_account_confirm_deletion_Account_Delete_brdx);
            new LogoutManager(this, LoginReason.SIGN_IN_OR_SIGN_OFF_DELETE_ACCOUNT).silenceLogout();
            LoginStore.getInstance().cleanPhone();
            UiThreadHandler.postDelayed(new Runnable() {
                public void run() {
                    if (ListenerManager.getCAFinishListener() != null) {
                        ListenerManager.getCAFinishListener().onSuccess(DeleteAccountActivity.this);
                    }
                    DeleteAccountActivity.this.setResult(i);
                    DeleteAccountActivity.this.finish();
                }
            }, 2000);
            return;
        }
        ListenerManager.getCAFinishListener().onCancel();
        setResult(i);
        finish();
    }

    public void onCancel() {
        LoginLog.write(this.TAG + " onCancel");
        if (ListenerManager.getCAFinishListener() != null) {
            ListenerManager.getCAFinishListener().onCancel();
        }
    }

    public LoginScene getInitScene() {
        return LoginScene.SCENE_DELETE_ACCOUNT;
    }

    public LoginState getInitState() {
        return LoginState.STATE_DELETE_ACCOUNT_MANUAL;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        ListenerManager.setCAFinishListener((LoginListeners.CancelAccFinishListener) null);
    }
}
