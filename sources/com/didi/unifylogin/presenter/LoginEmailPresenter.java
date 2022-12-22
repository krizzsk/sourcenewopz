package com.didi.unifylogin.presenter;

import android.content.Context;
import android.text.TextUtils;
import com.didi.sdk.view.SimplePopupBase;
import com.didi.thirdpartylogin.base.AbsThirdPartyLoginBase;
import com.didi.unifylogin.api.OneLoginFacade;
import com.didi.unifylogin.base.model.LoginModel;
import com.didi.unifylogin.base.net.LoginRpcCallbackV2;
import com.didi.unifylogin.base.net.LoginScene;
import com.didi.unifylogin.base.net.pojo.request.GateKeeperParam;
import com.didi.unifylogin.base.net.pojo.response.GateKeeperResponse;
import com.didi.unifylogin.base.presenter.LoginBasePresenter;
import com.didi.unifylogin.domain.CompassService;
import com.didi.unifylogin.presenter.ability.IInputPhonePresenter;
import com.didi.unifylogin.spi.CompassRequestService;
import com.didi.unifylogin.store.LoginStore;
import com.didi.unifylogin.utils.LoginLog;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.didi.unifylogin.utils.LoginState;
import com.didi.unifylogin.utils.ToastHelper;
import com.didi.unifylogin.view.ability.IInputPhoneView;
import com.didichuxing.foundation.rpc.RpcRequest;
import com.didichuxing.foundation.rpc.RpcResponseProxy;
import com.taxis99.R;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class LoginEmailPresenter extends LoginBasePresenter<IInputPhoneView> implements CompassService.CompassCheckCondition, CompassService.IBizProcessor, CompassService.PopupShowHandler, IInputPhonePresenter {

    /* renamed from: a */
    private static final String f44833a = "LoginEmailPresenter - ";

    public void getThirdPartyToken(AbsThirdPartyLoginBase absThirdPartyLoginBase) {
    }

    public void go2InputCPF(Context context) {
    }

    public void goRegByKey(String str) {
    }

    public LoginEmailPresenter(IInputPhoneView iInputPhoneView, Context context) {
        super(iInputPhoneView, context);
    }

    public void nextOperate() {
        if (!((IInputPhoneView) this.view).isAgreeLaw()) {
            ToastHelper.showAgreeLawHint(this.context, this.view);
            return;
        }
        ((IInputPhoneView) this.view).showLoading((String) null);
        this.messenger.setEmail(((IInputPhoneView) this.view).getEmail());
        this.messenger.setHideEmail(((IInputPhoneView) this.view).getEmail());
        HashMap hashMap = new HashMap();
        hashMap.put("email", this.messenger.getEmail());
        hashMap.put("invoke_scene", "user_login");
        new CompassService().setCompassCheckCond(this).setPopupHandler(this).registeProcessor(this).getCompassJudge(this.context, hashMap);
    }

    /* renamed from: a */
    private void m31990a() {
        ((IInputPhoneView) this.view).showLoading((String) null);
        LoginModel.getNet(this.context).gatekeeper(new GateKeeperParam(this.context, getSceneNum()).setEmail(this.messenger.getEmail()), new LoginRpcCallbackV2<GateKeeperResponse>() {
            public void onSuccess(RpcResponseProxy<GateKeeperResponse> rpcResponseProxy) {
                super.onSuccess(rpcResponseProxy);
                GateKeeperResponse content = rpcResponseProxy.getContent();
                ((IInputPhoneView) LoginEmailPresenter.this.view).hideLoading();
                if (content == null) {
                    ((IInputPhoneView) LoginEmailPresenter.this.view).showError(LoginEmailPresenter.this.context.getResources().getString(R.string.login_unify_net_error));
                } else if (content.errno != 0) {
                    new LoginOmegaUtil(LoginOmegaUtil.TONE_P_X_LOGIN_PHONE_CHECK).add("errno", Integer.valueOf(content.errno)).send();
                    ((IInputPhoneView) LoginEmailPresenter.this.view).showError(!TextUtils.isEmpty(content.error) ? content.error : LoginEmailPresenter.this.context.getResources().getString(R.string.login_unify_net_error));
                } else {
                    new LoginOmegaUtil(LoginOmegaUtil.TONE_P_X_LOGIN_USERENTER).send();
                    new LoginOmegaUtil(LoginOmegaUtil.TONE_P_X_LOGIN_CONFM_USERTYPE_CK).send();
                    if (content.roles == null) {
                        ((IInputPhoneView) LoginEmailPresenter.this.view).showError(!TextUtils.isEmpty(content.error) ? content.error : LoginEmailPresenter.this.context.getResources().getString(R.string.login_unify_net_error));
                        return;
                    }
                    LoginStore.getInstance().setUserType(content.usertype);
                    LoginEmailPresenter.this.messenger.setHideEmail(content.email);
                    LoginEmailPresenter.this.messenger.setCredential(content.credential);
                    LoginEmailPresenter.this.messenger.setFaceDes(content.faceDes);
                    saveActionOfSeven(content.actions);
                    if (OneLoginFacade.getStore().isNewUser()) {
                        new LoginOmegaUtil(LoginOmegaUtil.CONFM_NEWUSER_CK).send();
                    }
                    if (content.roles.size() > 1) {
                        LoginStore.getInstance().setAndSaveDoubleId(true);
                        ((IInputPhoneView) LoginEmailPresenter.this.view).selectDoubleIdentity(content.roles);
                        return;
                    }
                    LoginStore.getInstance().setAndSaveDoubleId(false);
                    LoginStore.getInstance().setAndSaveRole(content.roles.get(0).f44704id);
                    LoginEmailPresenter.this.goLogin(content.roles.get(0).login_type);
                }
            }

            public void onFailure(RpcRequest rpcRequest, IOException iOException) {
                super.onFailure(rpcRequest, iOException);
                ((IInputPhoneView) LoginEmailPresenter.this.view).hideLoading();
                ((IInputPhoneView) LoginEmailPresenter.this.view).showError(LoginEmailPresenter.this.context.getResources().getString(R.string.login_unify_net_error));
            }

            /* access modifiers changed from: package-private */
            public void saveActionOfSeven(List<GateKeeperResponse.Action> list) {
                if (list != null && list.size() > 0) {
                    for (GateKeeperResponse.Action action : list) {
                        if (action.action == 7) {
                            LoginStore.getInstance().setFinishInputInfo(false);
                            LoginLog.write("saveActionOfSeven: need");
                            return;
                        }
                    }
                }
                LoginStore.getInstance().setFinishInputInfo(true);
            }
        });
    }

    public void goLogin(int i) {
        if (i == 1) {
            setScene(LoginScene.SCENE_LOGIN);
            updateOmegaScene(LoginScene.SCENE_LOGIN);
            transform(LoginState.STATE_EMAIL_REGISTER_CODE);
        } else if (i != 2) {
            setScene(LoginScene.SCENE_CODE_LOGIN);
            updateOmegaScene(LoginScene.SCENE_CODE_LOGIN);
            transform(LoginState.STATE_EMAIL_CODE);
        } else {
            setScene(LoginScene.SCENE_PWD_LOGIN);
            updateOmegaScene(LoginScene.SCENE_PWD_LOGIN);
            transform(LoginState.STATE_LOGIN_PWD_BY_EMAIL);
        }
    }

    public void retrieveAccount() {
        setScene(LoginScene.SCENE_RETRIEVE);
        updateOmegaScene(LoginScene.SCENE_RETRIEVE);
        transform(LoginState.STATE_PRE_RETRIEVE);
    }

    public void onShowPopup(SimplePopupBase simplePopupBase) {
        if (((IInputPhoneView) this.view).getFragment() != null && ((IInputPhoneView) this.view).getFragment().getFragmentManager() != null) {
            simplePopupBase.show(((IInputPhoneView) this.view).getFragment().getFragmentManager(), "");
            ((IInputPhoneView) this.view).hideLoading();
        }
    }

    public void onConfirm() {
        m31990a();
    }

    public void onCancel() {
        m31990a();
    }

    public void processBiz() {
        m31990a();
    }

    public boolean haveCpsCKCondition() {
        return CompassRequestService.isSupportDynamicDomain(this.context);
    }
}
