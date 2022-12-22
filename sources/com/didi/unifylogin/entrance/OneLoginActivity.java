package com.didi.unifylogin.entrance;

import android.content.Intent;
import android.os.Bundle;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.util.ToastHelper;
import com.didi.thirdpartylogin.base.AbsThirdPartyLoginBase;
import com.didi.thirdpartylogin.base.ThirdPartyLoginManager;
import com.didi.unifylogin.base.model.FragmentMessenger;
import com.didi.unifylogin.base.model.LoginModel;
import com.didi.unifylogin.base.net.LoginRpcCallbackV2;
import com.didi.unifylogin.base.net.LoginScene;
import com.didi.unifylogin.base.net.pojo.request.AuthParam;
import com.didi.unifylogin.base.net.pojo.response.BaseResponse;
import com.didi.unifylogin.base.view.AbsLoginBaseActivity;
import com.didi.unifylogin.country.CountryManager;
import com.didi.unifylogin.listener.ListenerManager;
import com.didi.unifylogin.listener.LoginListeners;
import com.didi.unifylogin.store.LoginStore;
import com.didi.unifylogin.utils.LoginConstants;
import com.didi.unifylogin.utils.LoginLog;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.didi.unifylogin.utils.LoginProgressDialog;
import com.didi.unifylogin.utils.LoginState;
import com.didichuxing.foundation.rpc.RpcRequest;
import com.didichuxing.foundation.rpc.RpcResponseProxy;
import com.taxis99.R;
import java.io.IOException;
import java.io.Serializable;
import java.util.Iterator;

public class OneLoginActivity extends AbsLoginBaseActivity {
    public static final String INIT_MESSENGER = "init_messenger";
    public static final String INIT_STATE = "init_state";
    public static final String REG_BY_KEY = "regByKey";

    public boolean isLoginFlow() {
        return true;
    }

    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        CountryManager.getIns().getCountriesFromNet((CountryManager.CountriesChangeListener) null);
    }

    public void onFlowFinish(int i, FragmentMessenger fragmentMessenger) {
        LoginLog.write(this.TAG + " onFlowFinish result: " + i + ", scene：" + fragmentMessenger.getScene().getSceneNum());
        if (i == 0) {
            LoginProgressDialog.dismissProgressDialogFragmentSafely();
            startFirstPage();
        } else if (fragmentMessenger.getScene() == LoginScene.SCENE_RETRIEVE) {
            LoginProgressDialog.dismissProgressDialogFragmentSafely();
            ToastHelper.showShortInfo(getApplicationContext(), getString(R.string.login_unify_retrieve_success));
            startFirstPage();
        } else {
            m31784a(fragmentMessenger);
            if (ListenerManager.getLoginInterceptor() != null) {
                m31786b(fragmentMessenger);
            } else {
                loginFinish(i, fragmentMessenger);
            }
        }
    }

    /* renamed from: a */
    private void m31784a(final FragmentMessenger fragmentMessenger) {
        if (fragmentMessenger != null && fragmentMessenger.isNeedBind()) {
            LoginLog.write(fragmentMessenger.getChannel() + "请求绑定");
            AuthParam authParam = new AuthParam(getApplicationContext(), fragmentMessenger.getSceneNum());
            authParam.setAuthChannel(fragmentMessenger.getChannel()).setIdToken(fragmentMessenger.getIdtoken()).setTicket(LoginStore.getInstance().getTemporaryToken()).setMethod(LoginConstants.AUTH_BIND_METHOD);
            LoginModel.getNet(getApplicationContext()).ctrolAuth(authParam, new LoginRpcCallbackV2<BaseResponse>() {
                public void onSuccess(RpcResponseProxy<BaseResponse> rpcResponseProxy) {
                    super.onSuccess(rpcResponseProxy);
                    BaseResponse content = rpcResponseProxy.getContent();
                    if (content.errno == 0) {
                        new LoginOmegaUtil(LoginOmegaUtil.TONE_P_X_LOGIN_LINKPHONE_SC).add("social", fragmentMessenger.getChannel()).send();
                        LoginLog.write(fragmentMessenger.getChannel() + "绑定成功");
                        return;
                    }
                    LoginLog.write(fragmentMessenger.getChannel() + content.error);
                }

                public void onFailure(RpcRequest rpcRequest, IOException iOException) {
                    super.onFailure(rpcRequest, iOException);
                    LoginLog.write(fragmentMessenger.getChannel() + "绑定失败" + iOException.toString());
                }
            });
        }
    }

    public void onCancel() {
        Iterator<LoginListeners.LoginListener> it = ListenerManager.getLoginListeners().iterator();
        while (it.hasNext()) {
            it.next().onCancel();
        }
    }

    public void goJump() {
        Iterator<LoginListeners.LoginJumpListener> it = ListenerManager.getLoginJumpListeners().iterator();
        while (it.hasNext()) {
            it.next().jump(this);
        }
        new LoginOmegaUtil(LoginOmegaUtil.TONE_P_X_ACCOUNT_LOGINFINISH).send();
        finish();
    }

    /* renamed from: b */
    private void m31786b(final FragmentMessenger fragmentMessenger) {
        LoginLog.write(this.TAG + " start interceptLogin ");
        LoginProgressDialog.showDialog(this, getString(R.string.login_unify_loading), false);
        LoginStore.getInstance().setToken(LoginStore.getInstance().getTemporaryToken());
        ListenerManager.getLoginInterceptor().onInterceptor(LoginStore.getInstance().getToken(), this, new LoginListeners.InterceptorCallback() {
            public void onSuccess() {
                LoginLog.write(OneLoginActivity.this.TAG + " interceptLogin--Success ");
                OneLoginActivity.this.loginFinish(-1, fragmentMessenger);
            }

            public void onFailed(int i, String str) {
                LoginProgressDialog.dismissProgressDialogFragmentSafely();
                if (str != null) {
                    LoginLog.write(OneLoginActivity.this.TAG + " interceptLogin--onFailed : " + i + ":" + str);
                }
                if (!TextUtil.isEmpty(str)) {
                    ToastHelper.showLongInfo(OneLoginActivity.this.mContext, str);
                }
                new LoginOmegaUtil(LoginOmegaUtil.LOGIN_FAIL_SW).add("errno", Integer.valueOf(i)).add(LoginOmegaUtil.ISAPPERRNO, true).send();
                OneLoginActivity.this.startFirstPage();
                LoginStore.getInstance().loginOutClean();
            }
        });
    }

    public void loginFinish(int i, FragmentMessenger fragmentMessenger) {
        LoginStore.getInstance().setAndsaveToken(LoginStore.getInstance().getTemporaryToken());
        Iterator<LoginListeners.LoginListener> it = ListenerManager.getLoginListeners().iterator();
        while (it.hasNext()) {
            it.next().onSuccess(this, LoginStore.getInstance().getToken());
        }
        Iterator<LoginListeners.TokenListener> it2 = ListenerManager.getTokenListeners().iterator();
        while (it2.hasNext()) {
            it2.next().onSuccess(LoginStore.getInstance().getToken());
        }
        LoginProgressDialog.dismissProgressDialogFragmentSafely();
        setResult(i);
        finish();
        LoginLog.write(this.TAG + " loginFinish : " + i);
        String str = null;
        if (fragmentMessenger != null) {
            str = fragmentMessenger.getLoginMethod();
        }
        if (TextUtil.isEmpty(str)) {
            new LoginOmegaUtil(LoginOmegaUtil.LOGIN_SUCCESS_SW).send();
        } else {
            new LoginOmegaUtil(LoginOmegaUtil.LOGIN_SUCCESS_SW).add("channel", str).send();
        }
        new LoginOmegaUtil(LoginOmegaUtil.TONE_P_X_ACCOUNT_LOGINFINISH).send();
        if (!FragmentMessenger.scenesStack.isEmpty()) {
            FragmentMessenger.scenesStack.clear();
        }
    }

    public LoginScene getInitScene() {
        return LoginScene.SCENE_LOGIN;
    }

    public LoginState getInitState() {
        Serializable serializableExtra = getIntent().getSerializableExtra(INIT_STATE);
        if (serializableExtra instanceof LoginState) {
            return (LoginState) serializableExtra;
        }
        return LoginState.STATE_INPUT_PHONE;
    }

    /* access modifiers changed from: protected */
    public FragmentMessenger getInitMessenger() {
        Serializable serializableExtra = getIntent().getSerializableExtra(INIT_MESSENGER);
        if (serializableExtra instanceof FragmentMessenger) {
            return (FragmentMessenger) serializableExtra;
        }
        return super.getInitMessenger();
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
