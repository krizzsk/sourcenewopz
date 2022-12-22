package com.didi.unifylogin.entrance;

import android.content.Context;
import android.text.TextUtils;
import com.didi.sdk.util.ToastHelper;
import com.didi.unifylogin.base.model.FragmentMessenger;
import com.didi.unifylogin.base.model.LoginModel;
import com.didi.unifylogin.base.net.LoginRpcCallbackV2;
import com.didi.unifylogin.base.net.LoginScene;
import com.didi.unifylogin.base.net.pojo.request.SimpleParam;
import com.didi.unifylogin.base.net.pojo.response.CheckPwdResponse;
import com.didi.unifylogin.base.view.AbsLoginBaseActivity;
import com.didi.unifylogin.listener.ListenerManager;
import com.didi.unifylogin.listener.LoginListeners;
import com.didi.unifylogin.store.LoginStore;
import com.didi.unifylogin.utils.LoginLog;
import com.didi.unifylogin.utils.LoginState;
import com.didichuxing.foundation.rpc.RpcRequest;
import com.didichuxing.foundation.rpc.RpcResponseProxy;
import com.taxis99.R;
import java.io.IOException;

public class SetPwdActivity extends AbsLoginBaseActivity {
    public void onFlowFinish(int i, FragmentMessenger fragmentMessenger) {
        LoginLog.write(this.TAG + " onFlowFinish result: " + i);
        if (i == -1) {
            if (!TextUtils.isEmpty(LoginStore.getInstance().getTemporaryToken())) {
                LoginStore.getInstance().setAndsaveToken(LoginStore.getInstance().getTemporaryToken());
            }
            ToastHelper.showShortInfo(getApplicationContext(), (int) R.string.login_unify_set_pwd_success);
            if (ListenerManager.getModifyPasswordListener() != null) {
                ListenerManager.getModifyPasswordListener().onSuccess(this);
            }
        } else if (ListenerManager.getModifyPasswordListener() != null) {
            ListenerManager.getModifyPasswordListener().onCancel();
        }
        setResult(i);
        finish();
    }

    public void onCancel() {
        LoginLog.write(this.TAG + " onCancel");
        if (ListenerManager.getModifyPasswordListener() != null) {
            ListenerManager.getModifyPasswordListener().onCancel();
        }
    }

    public LoginScene getInitScene() {
        return LoginScene.SCENE_RESET_PWD;
    }

    /* access modifiers changed from: protected */
    public void startFirstPage() {
        LoginLog.write(this.TAG + " startFirstPage: ");
        showLoading((String) null);
        Context applicationContext = getApplicationContext();
        LoginModel.getNet(applicationContext).checkPassword(new SimpleParam(applicationContext, getInitScene().getSceneNum()).setTicket(LoginStore.getInstance().getToken()), new LoginRpcCallbackV2<CheckPwdResponse>() {
            public void onSuccess(RpcResponseProxy<CheckPwdResponse> rpcResponseProxy) {
                super.onSuccess(rpcResponseProxy);
                CheckPwdResponse content = rpcResponseProxy.getContent();
                SetPwdActivity.this.hideLoading();
                if (content == null || content.errno != 0) {
                    SetPwdActivity setPwdActivity = SetPwdActivity.this;
                    setPwdActivity.transform((LoginState) null, setPwdActivity.getInitState(), SetPwdActivity.this.getInitMessenger());
                    return;
                }
                LoginState loginState = content.status == 1 ? LoginState.STATE_VERIFY_OLD_PWD : LoginState.STATE_SET_PWD;
                SetPwdActivity setPwdActivity2 = SetPwdActivity.this;
                setPwdActivity2.transform((LoginState) null, loginState, setPwdActivity2.getInitMessenger());
            }

            public void onFailure(RpcRequest rpcRequest, IOException iOException) {
                super.onFailure(rpcRequest, iOException);
                SetPwdActivity.this.hideLoading();
                SetPwdActivity setPwdActivity = SetPwdActivity.this;
                setPwdActivity.transform((LoginState) null, setPwdActivity.getInitState(), SetPwdActivity.this.getInitMessenger());
            }
        });
    }

    public LoginState getInitState() {
        return LoginState.STATE_VERIFY_OLD_PWD;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        ListenerManager.setModifyPasswordListener((LoginListeners.ModifyPasswordListener) null);
    }
}
