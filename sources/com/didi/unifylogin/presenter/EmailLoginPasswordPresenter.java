package com.didi.unifylogin.presenter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.didi.sdk.view.dialog.AlertDialogFragment;
import com.didi.unifylogin.api.LoginActionApi;
import com.didi.unifylogin.base.model.FragmentMessenger;
import com.didi.unifylogin.base.model.LoginModel;
import com.didi.unifylogin.base.net.LoginScene;
import com.didi.unifylogin.base.net.pojo.request.SignInByPasswordParam;
import com.didi.unifylogin.base.net.pojo.response.BaseLoginSuccessResponse;
import com.didi.unifylogin.base.net.pojo.response.SignInByPasswordResponse;
import com.didi.unifylogin.base.view.BaseViewUtil;
import com.didi.unifylogin.listener.ListenerManager;
import com.didi.unifylogin.store.LoginStore;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.didi.unifylogin.utils.LoginState;
import com.didi.unifylogin.utils.simplifycode.LoginServiceCallbackV2;
import com.didi.unifylogin.view.ability.ILoginPwdView;
import com.didichuxing.foundation.rpc.RpcRequest;
import com.taxis99.R;

public class EmailLoginPasswordPresenter extends LoginPasswordPresenter {
    public EmailLoginPasswordPresenter(ILoginPwdView iLoginPwdView, Context context) {
        super(iLoginPwdView, context);
    }

    public void passwordLogin(String str) {
        String str2 = null;
        ((ILoginPwdView) this.view).showLoading((String) null);
        setScene(LoginScene.SCENE_PWD_LOGIN);
        this.messenger.setPassword(str);
        if (ListenerManager.getFirstInstallListener() != null) {
            str2 = ListenerManager.getFirstInstallListener().reasonOfFirstInstall();
        }
        SignInByPasswordParam loginType = new SignInByPasswordParam(this.context, getSceneNum()).setEmail(this.messenger.getEmail()).setPassword(this.messenger.getPassword()).setLoginType(1);
        if (TextUtils.isEmpty(str2)) {
            str2 = LoginActionApi.loginReason;
        }
        LoginModel.getNet(this.context).signInByPassword(loginType.setSignReason(str2), new LoginServiceCallbackV2<SignInByPasswordResponse>(this.view, false) {
            /* access modifiers changed from: protected */
            public boolean handleResponse(SignInByPasswordResponse signInByPasswordResponse, int i, String str) {
                int i2 = signInByPasswordResponse.errno;
                if (i2 == 0) {
                    EmailLoginPasswordPresenter.this.handToken(signInByPasswordResponse);
                    return true;
                } else if (i2 == 41002) {
                    ((ILoginPwdView) EmailLoginPasswordPresenter.this.view).hideLoading();
                    EmailLoginPasswordPresenter.this.messenger.setNextState((LoginState) null);
                    EmailLoginPasswordPresenter.this.messenger.setCaptchaCell(EmailLoginPasswordPresenter.this.messenger.getCell());
                    EmailLoginPasswordPresenter.this.updateOmegaScene(FragmentMessenger.getNowScene());
                    EmailLoginPasswordPresenter.this.transform(LoginState.STATE_CAPTCHA);
                    return true;
                } else if (i2 != 41020) {
                    ((ILoginPwdView) EmailLoginPasswordPresenter.this.view).hideLoading();
                    ((ILoginPwdView) EmailLoginPasswordPresenter.this.view).setPassword("");
                    String str2 = signInByPasswordResponse.error;
                    if (signInByPasswordResponse.errno != -1) {
                        i = signInByPasswordResponse.errno;
                    }
                    LoginOmegaUtil.trackLoginErrorEvent(2, str2, i, str, "signInByPassword", (String) null);
                    new LoginOmegaUtil(LoginOmegaUtil.LOGIN_FAIL_SW).add("errno", Integer.valueOf(signInByPasswordResponse.errno)).send();
                    return false;
                } else {
                    ((ILoginPwdView) EmailLoginPasswordPresenter.this.view).hideLoading();
                    ((ILoginPwdView) EmailLoginPasswordPresenter.this.view).setPassword("");
                    ((ILoginPwdView) EmailLoginPasswordPresenter.this.view).showInfoDialog((FragmentActivity) ((ILoginPwdView) EmailLoginPasswordPresenter.this.view).getBaseActivity(), (String) null, signInByPasswordResponse.error, new BaseViewUtil.DialogItem(EmailLoginPasswordPresenter.this.context.getString(R.string.login_unify_switch_code_login), new AlertDialogFragment.OnClickListener() {
                        public void onClick(AlertDialogFragment alertDialogFragment, View view) {
                            alertDialogFragment.dismiss();
                            EmailLoginPasswordPresenter.this.setScene(LoginScene.SCENE_CODE_LOGIN);
                            EmailLoginPasswordPresenter.this.updateOmegaScene(LoginScene.SCENE_CODE_LOGIN);
                            EmailLoginPasswordPresenter.this.transform(LoginState.STATE_CODE);
                        }
                    }), new BaseViewUtil.DialogItem(EmailLoginPasswordPresenter.this.context.getString(R.string.login_unify_switch_forget_pwd), new AlertDialogFragment.OnClickListener() {
                        public void onClick(AlertDialogFragment alertDialogFragment, View view) {
                            alertDialogFragment.dismiss();
                            EmailLoginPasswordPresenter.this.forgetPwd();
                        }
                    }), new BaseViewUtil.DialogItem(EmailLoginPasswordPresenter.this.context.getString(R.string.login_unify_switch_cancel), new AlertDialogFragment.OnClickListener() {
                        public void onClick(AlertDialogFragment alertDialogFragment, View view) {
                            alertDialogFragment.dismiss();
                        }
                    }));
                    return true;
                }
            }

            /* access modifiers changed from: protected */
            public void handleError(RpcRequest rpcRequest) {
                LoginOmegaUtil.trackLoginErrorEvent(0, (String) null, -1, "", "signInByPassword", (String) null);
            }
        });
    }

    public void forgetPwd() {
        setScene(LoginScene.SCENE_FORGETPWD);
        updateOmegaScene(LoginScene.SCENE_FORGETPWD);
        transform(LoginState.STATE_EMAIL_REGISTER_CODE);
    }

    /* access modifiers changed from: protected */
    public void updateLoginInfo(BaseLoginSuccessResponse baseLoginSuccessResponse) {
        super.updateLoginInfo(baseLoginSuccessResponse);
        LoginStore.getInstance().updateLoginInfo(baseLoginSuccessResponse);
    }
}
