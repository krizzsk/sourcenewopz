package com.didi.unifylogin.presenter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.didi.global.fintech.cashier.model.net.request.CashierAction;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.view.dialog.AlertDialogFragment;
import com.didi.unifylogin.api.LoginActionApi;
import com.didi.unifylogin.api.LoginPreferredConfig;
import com.didi.unifylogin.base.manager.LoginFillerFragmentManager;
import com.didi.unifylogin.base.model.FragmentMessenger;
import com.didi.unifylogin.base.model.LoginModel;
import com.didi.unifylogin.base.net.LoginScene;
import com.didi.unifylogin.base.net.pojo.request.SignInByPasswordParam;
import com.didi.unifylogin.base.net.pojo.response.SignInByPasswordResponse;
import com.didi.unifylogin.base.presenter.LoginBasePresenter;
import com.didi.unifylogin.base.view.BaseViewUtil;
import com.didi.unifylogin.listener.ListenerManager;
import com.didi.unifylogin.presenter.ability.ILoginPasswordPresenter;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.didi.unifylogin.utils.LoginState;
import com.didi.unifylogin.utils.RsaEncryptUtil;
import com.didi.unifylogin.utils.simplifycode.LoginServiceCallbackV2;
import com.didi.unifylogin.view.CaptchaFragment;
import com.didi.unifylogin.view.ability.ILoginPwdView;
import com.didichuxing.foundation.rpc.RpcRequest;
import com.taxis99.R;

public class LoginPasswordPresenter extends LoginBasePresenter<ILoginPwdView> implements ILoginPasswordPresenter {

    /* renamed from: a */
    private static LoginState f44834a = LoginState.STATE_PASSWORD;

    /* renamed from: b */
    private static final int f44835b = 1;

    /* renamed from: c */
    private static final int f44836c = 2;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f44837d = false;

    /* renamed from: e */
    private int f44838e = 0;

    public LoginPasswordPresenter(ILoginPwdView iLoginPwdView, Context context) {
        super(iLoginPwdView, context);
    }

    public void forgetPwd() {
        setScene(LoginScene.SCENE_FORGETPWD);
        updateOmegaScene(LoginScene.SCENE_FORGETPWD);
        transform(LoginState.STATE_CODE);
    }

    public void captchaCheck() {
        if (this.f44837d && CaptchaFragment.isCaptchaPass && !TextUtil.isEmpty(this.messenger.getPassword())) {
            passwordLogin(this.messenger.getPassword());
        }
        this.f44837d = false;
    }

    public void updateView() {
        String str;
        super.updateView();
        if (this.messenger.getFaceDes() != null && !TextUtil.isEmpty(this.messenger.getFaceDes().text)) {
            str = this.messenger.getFaceDes().text;
            this.f44838e = 2;
        } else if (LoginPreferredConfig.isAllowOptLoginByCode()) {
            str = this.context.getString(R.string.login_unify_login_by_code);
            this.f44838e = 1;
        } else {
            str = null;
        }
        ((ILoginPwdView) this.view).setChangeWay(str);
    }

    public void passwordLogin(String str) {
        String str2 = null;
        ((ILoginPwdView) this.view).showLoading((String) null);
        setScene(LoginScene.SCENE_PWD_LOGIN);
        this.messenger.setPassword(str);
        if (ListenerManager.getFirstInstallListener() != null) {
            str2 = ListenerManager.getFirstInstallListener().reasonOfFirstInstall();
        }
        SignInByPasswordParam cell = new SignInByPasswordParam(this.context, getSceneNum()).setCell(this.messenger.getCell());
        if (TextUtils.isEmpty(str2)) {
            str2 = LoginActionApi.loginReason;
        }
        SignInByPasswordParam signReason = cell.setSignReason(str2);
        if (LoginPreferredConfig.isPasswordEncrypt()) {
            signReason.setPasswordEncrypt(1).setPassword(RsaEncryptUtil.getRSAData(this.context, this.messenger.getPassword()));
        } else {
            signReason.setPassword(this.messenger.getPassword());
        }
        LoginModel.getNet(this.context).signInByPassword(signReason, new LoginServiceCallbackV2<SignInByPasswordResponse>(this.view, false) {
            /* access modifiers changed from: protected */
            public void handleError(RpcRequest rpcRequest) {
                LoginOmegaUtil.trackLoginErrorEvent(0, (String) null, -1, "", "signInByPassword", (String) null);
            }

            /* access modifiers changed from: protected */
            public boolean handleResponse(SignInByPasswordResponse signInByPasswordResponse, int i, String str) {
                int i2 = signInByPasswordResponse.errno;
                if (i2 == 0) {
                    LoginPasswordPresenter.this.messenger.setLoginMethod(CashierAction.ACTION_PASSWORD);
                    LoginPasswordPresenter.this.handToken(signInByPasswordResponse);
                    return true;
                } else if (i2 == 41002) {
                    ((ILoginPwdView) LoginPasswordPresenter.this.view).hideLoading();
                    LoginPasswordPresenter.this.messenger.setNextState((LoginState) null);
                    LoginPasswordPresenter.this.messenger.setCaptchaCell(LoginPasswordPresenter.this.messenger.getCell());
                    LoginPasswordPresenter.this.updateOmegaScene(FragmentMessenger.getNowScene());
                    LoginPasswordPresenter.this.transform(LoginState.STATE_CAPTCHA);
                    boolean unused = LoginPasswordPresenter.this.f44837d = true;
                    return true;
                } else if (i2 != 41020) {
                    ((ILoginPwdView) LoginPasswordPresenter.this.view).hideLoading();
                    ((ILoginPwdView) LoginPasswordPresenter.this.view).setPassword("");
                    String str2 = signInByPasswordResponse.error;
                    if (signInByPasswordResponse.errno != -1) {
                        i = signInByPasswordResponse.errno;
                    }
                    LoginOmegaUtil.trackLoginErrorEvent(2, str2, i, str, "signInByPassword", (String) null);
                    new LoginOmegaUtil(LoginOmegaUtil.LOGIN_FAIL_SW).add("errno", Integer.valueOf(signInByPasswordResponse.errno)).send();
                    return false;
                } else {
                    ((ILoginPwdView) LoginPasswordPresenter.this.view).hideLoading();
                    ((ILoginPwdView) LoginPasswordPresenter.this.view).setPassword("");
                    ((ILoginPwdView) LoginPasswordPresenter.this.view).showInfoDialog((FragmentActivity) ((ILoginPwdView) LoginPasswordPresenter.this.view).getBaseActivity(), (String) null, signInByPasswordResponse.error, new BaseViewUtil.DialogItem(LoginPasswordPresenter.this.context.getString(R.string.login_unify_switch_code_login), new AlertDialogFragment.OnClickListener() {
                        public void onClick(AlertDialogFragment alertDialogFragment, View view) {
                            alertDialogFragment.dismiss();
                            LoginPasswordPresenter.this.setScene(LoginScene.SCENE_CODE_LOGIN);
                            LoginPasswordPresenter.this.updateOmegaScene(LoginScene.SCENE_CODE_LOGIN);
                            LoginPasswordPresenter.this.transform(LoginState.STATE_CODE);
                        }
                    }), new BaseViewUtil.DialogItem(LoginPasswordPresenter.this.context.getString(R.string.login_unify_switch_forget_pwd), new AlertDialogFragment.OnClickListener() {
                        public void onClick(AlertDialogFragment alertDialogFragment, View view) {
                            alertDialogFragment.dismiss();
                            LoginPasswordPresenter.this.forgetPwd();
                        }
                    }), new BaseViewUtil.DialogItem(LoginPasswordPresenter.this.context.getString(R.string.login_unify_switch_cancel), new AlertDialogFragment.OnClickListener() {
                        public void onClick(AlertDialogFragment alertDialogFragment, View view) {
                            alertDialogFragment.dismiss();
                        }
                    }));
                    return true;
                }
            }
        });
    }

    public void changeLoginWay() {
        int i = this.f44838e;
        if (i == 1) {
            new LoginOmegaUtil(LoginOmegaUtil.TONE_P_X_LOGIN_PW_SMS_CK).send();
            setScene(LoginScene.SCENE_CODE_LOGIN);
            updateOmegaScene(LoginScene.SCENE_CODE_LOGIN);
            transform(LoginState.STATE_CODE);
        } else if (i == 2) {
            LoginOmegaUtil.trackEvent(LoginOmegaUtil.TONE_P_X_LOGIN_FACE_CK);
            setScene(LoginScene.SCENE_FACE_LOGIN);
            updateOmegaScene(LoginScene.SCENE_FACE_LOGIN);
            transform(LoginState.STATE_PRE_FACE);
        }
    }

    /* renamed from: a */
    private boolean m32006a() {
        return LoginState.STATE_SET_PWD == LoginFillerFragmentManager.getNextState((LoginState) null);
    }
}
