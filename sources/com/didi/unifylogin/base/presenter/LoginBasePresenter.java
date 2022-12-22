package com.didi.unifylogin.base.presenter;

import android.content.Context;
import android.text.TextUtils;
import com.didi.unifylogin.base.manager.LoginFillerFragmentManager;
import com.didi.unifylogin.base.manager.LoginFragmentManager;
import com.didi.unifylogin.base.model.FragmentMessenger;
import com.didi.unifylogin.base.model.LoginModel;
import com.didi.unifylogin.base.net.LoginRpcCallbackV2;
import com.didi.unifylogin.base.net.LoginScene;
import com.didi.unifylogin.base.net.pojo.request.LoginActionParam;
import com.didi.unifylogin.base.net.pojo.response.ActionResponse;
import com.didi.unifylogin.base.net.pojo.response.BaseLoginSuccessResponse;
import com.didi.unifylogin.base.net.pojo.response.CountryListResponse;
import com.didi.unifylogin.base.view.ability.ILoginBaseFragment;
import com.didi.unifylogin.country.CountryManager;
import com.didi.unifylogin.store.LoginStore;
import com.didi.unifylogin.utils.LoginState;
import com.didichuxing.foundation.rpc.RpcRequest;
import com.didichuxing.foundation.rpc.RpcResponseProxy;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LoginBasePresenter<V extends ILoginBaseFragment> implements ILoginBasePresenter {
    protected String TAG = getClass().getSimpleName();
    protected Context context;
    protected FragmentMessenger messenger;
    protected V view;

    /* access modifiers changed from: protected */
    public void updateLoginInfo(BaseLoginSuccessResponse baseLoginSuccessResponse) {
    }

    public void updateView() {
    }

    public LoginBasePresenter(V v, Context context2) {
        this.view = v;
        this.context = context2;
        this.messenger = getMessenger();
    }

    public FragmentMessenger getMessenger() {
        V v = this.view;
        if (v != null) {
            return v.getMessenger();
        }
        return null;
    }

    public LoginScene getScene() {
        FragmentMessenger fragmentMessenger = this.messenger;
        if (fragmentMessenger != null) {
            return fragmentMessenger.getScene();
        }
        return LoginScene.SCENE_LOGIN;
    }

    public int getSceneNum() {
        return getScene().getSceneNum();
    }

    public void setScene(LoginScene loginScene) {
        FragmentMessenger fragmentMessenger;
        if (loginScene != null && (fragmentMessenger = this.messenger) != null) {
            fragmentMessenger.setScene(loginScene);
        }
    }

    public void updateOmegaScene(LoginScene loginScene) {
        FragmentMessenger fragmentMessenger;
        if (loginScene != null && (fragmentMessenger = this.messenger) != null) {
            fragmentMessenger.updateOmegaScene(loginScene);
        }
    }

    public void transform(LoginState loginState) {
        LoginFragmentManager.transform(this.view.getNowState(), loginState, this.view);
        this.view.setForbidBack(false);
    }

    public void goFillInfo() {
        goFillNextInfo((LoginState) null);
    }

    public void handToken(BaseLoginSuccessResponse baseLoginSuccessResponse) {
        CountryListResponse.CountryRule countryById = CountryManager.getIns().getCountryById(baseLoginSuccessResponse.countryId);
        if (baseLoginSuccessResponse.countryId == 86) {
            HashMap hashMap = new HashMap();
            hashMap.put("phone", baseLoginSuccessResponse.cell);
            OmegaSDKAdapter.trackEvent("loginResponseIs86", (Map<String, Object>) hashMap);
        }
        if (countryById != null) {
            CountryManager.getIns().setCurrentCountry(countryById);
        }
        LoginStore.getInstance().saveLoginInfo(baseLoginSuccessResponse, this.messenger);
        updateLoginInfo(baseLoginSuccessResponse);
        if (!this.view.isLoginFlow()) {
            this.view.onFlowFinish(-1);
            return;
        }
        this.view.showLoading((String) null);
        LoginActionParam usertype = new LoginActionParam(this.context, getSceneNum()).setUsertype(LoginStore.getInstance().getUserType());
        String channel = this.messenger.getChannel();
        if (!TextUtils.isEmpty(channel)) {
            usertype.setForceCodeLogin(true).setAuthChannel(channel);
        }
        usertype.setTicket(LoginStore.getInstance().getTemporaryToken());
        LoginModel.getNet(this.context).getPostLoginAction(usertype, new LoginRpcCallbackV2<ActionResponse>() {
            public void onSuccess(RpcResponseProxy<ActionResponse> rpcResponseProxy) {
                super.onSuccess(rpcResponseProxy);
                ActionResponse content = rpcResponseProxy.getContent();
                if (content == null || content.errno != 0) {
                    LoginBasePresenter.this.view.onFlowFinish(-1);
                    return;
                }
                LoginFillerFragmentManager.setFillers(content.actions);
                LoginBasePresenter.this.goFillInfo();
            }

            public void onFailure(RpcRequest rpcRequest, IOException iOException) {
                super.onFailure(rpcRequest, iOException);
                LoginBasePresenter.this.view.onFlowFinish(-1);
                iOException.printStackTrace();
            }
        });
    }

    public void goFillNextInfo(LoginState loginState) {
        LoginState nextState = LoginFillerFragmentManager.getNextState(loginState);
        if (nextState != null) {
            if (this.messenger.getScene() == LoginScene.SCENE_PWD_LOGIN && LoginState.STATE_SET_PWD == nextState) {
                updateOmegaScene(FragmentMessenger.getNowScene());
                transform(LoginState.STATE_PRE_SET_PWD);
            } else {
                updateOmegaScene(FragmentMessenger.getNowScene());
                transform(nextState);
            }
            if (loginState != null || this.messenger.getScene() == LoginScene.SCENE_FORGETPWD) {
                this.view.setForbidBack(true);
                return;
            }
            return;
        }
        this.view.onFlowFinish(-1);
    }
}
