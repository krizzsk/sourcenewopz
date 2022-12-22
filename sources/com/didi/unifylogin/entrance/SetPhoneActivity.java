package com.didi.unifylogin.entrance;

import android.content.Intent;
import androidx.fragment.app.Fragment;
import com.didi.sdk.login.LoginReason;
import com.didi.sdk.util.ToastHelper;
import com.didi.sdk.util.UiThreadHandler;
import com.didi.unifylogin.api.LoginPreferredConfig;
import com.didi.unifylogin.base.model.FragmentMessenger;
import com.didi.unifylogin.base.net.LoginScene;
import com.didi.unifylogin.base.net.pojo.response.CountryListResponse;
import com.didi.unifylogin.base.view.AbsLoginBaseActivity;
import com.didi.unifylogin.country.CountryManager;
import com.didi.unifylogin.externalfunction.LogoutManager;
import com.didi.unifylogin.flutter.LoginLogicManager;
import com.didi.unifylogin.listener.ListenerManager;
import com.didi.unifylogin.listener.LoginListeners;
import com.didi.unifylogin.store.LoginStore;
import com.didi.unifylogin.utils.LoginLog;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.didi.unifylogin.utils.LoginState;
import com.taxis99.R;

public class SetPhoneActivity extends AbsLoginBaseActivity {
    public void onFlowFinish(final int i, FragmentMessenger fragmentMessenger) {
        LoginLog.write(this.TAG + " onFlowFinish result: " + i);
        if (i == -1) {
            new LogoutManager(this, LoginReason.SIGN_IN_OR_SIGN_OFF_CHANGE_PHONE).silenceLogout();
            LoginStore.getInstance().setAndSavePhone(fragmentMessenger.getNewCell());
            if (fragmentMessenger.getNewCellCountry() != null) {
                CountryManager.getIns().setCurrentCountry(fragmentMessenger.getNewCellCountry());
                fragmentMessenger.setNewCellCountry((CountryListResponse.CountryRule) null);
            }
            LoginLogicManager.getMessenger().setCell(fragmentMessenger.getNewCell());
            ToastHelper.showShortInfo(getApplicationContext(), getString(R.string.login_unify_set_cell_success));
            UiThreadHandler.postDelayed(new Runnable() {
                public void run() {
                    if (ListenerManager.getSetCellListener() != null) {
                        ListenerManager.getSetCellListener().onSuccess(SetPhoneActivity.this);
                    }
                    SetPhoneActivity.this.setResult(i);
                    SetPhoneActivity.this.finish();
                }
            }, 2000);
            new LoginOmegaUtil(LoginOmegaUtil.TONE_P_X_PHOECHGE_SC).send();
            return;
        }
        if (ListenerManager.getSetCellListener() != null) {
            ListenerManager.getSetCellListener().onCancel();
        }
        setResult(i);
        finish();
    }

    public void onCancel() {
        LoginLog.write(this.TAG + " onCancel");
        if (ListenerManager.getSetCellListener() != null) {
            ListenerManager.getSetCellListener().onCancel();
        }
    }

    public LoginScene getInitScene() {
        if (this.isChangePhoneByID) {
            return LoginScene.SCENE_CHANGE_PHONE_BY_ID;
        }
        return LoginScene.SCENE_SET_PHONE;
    }

    public LoginState getInitState() {
        if (this.isChangePhoneByID) {
            return LoginState.STATE_NEW_PHONE;
        }
        if (LoginPreferredConfig.isNeedPrePage()) {
            return LoginState.STATE_PRE_SET_CELL;
        }
        return LoginState.STATE_NEW_PHONE;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        ListenerManager.setSetCellListener((LoginListeners.SetCellListener) null);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        Fragment findFragmentById = getSupportFragmentManager().findFragmentById(R.id.fl_fragment);
        if (findFragmentById != null) {
            findFragmentById.onActivityResult(i, i2, intent);
        }
    }
}
