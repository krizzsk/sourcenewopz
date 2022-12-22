package com.didi.unifylogin.presenter;

import android.content.Context;
import android.text.TextUtils;
import com.didi.unifylogin.api.LoginActionApi;
import com.didi.unifylogin.base.model.FragmentMessenger;
import com.didi.unifylogin.base.model.LoginModel;
import com.didi.unifylogin.base.net.pojo.request.SignInByCodeParam;
import com.didi.unifylogin.base.net.pojo.response.SignInByCodeResponse;
import com.didi.unifylogin.listener.ListenerManager;
import com.didi.unifylogin.utils.LoginChoicePopUtil;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.didi.unifylogin.utils.LoginState;
import com.didi.unifylogin.utils.simplifycode.LoginServiceCallbackV2;
import com.didi.unifylogin.view.ability.IVerifyCodeView;
import com.didichuxing.foundation.rpc.RpcRequest;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class LoginCodePresenter extends BaseCodePresenter {
    public LoginCodePresenter(IVerifyCodeView iVerifyCodeView, Context context) {
        super(iVerifyCodeView, context);
    }

    public void nextOperate() {
        String str = null;
        ((IVerifyCodeView) this.view).showLoading((String) null);
        this.messenger.setCode(((IVerifyCodeView) this.view).getCode());
        if (ListenerManager.getFirstInstallListener() != null) {
            str = ListenerManager.getFirstInstallListener().reasonOfFirstInstall();
        }
        SignInByCodeParam code = new SignInByCodeParam(this.context, getSceneNum()).setCell(this.messenger.getCell()).setCodeType(this.messenger.getCodeType()).setCode(this.messenger.getCode());
        if (TextUtils.isEmpty(str)) {
            str = LoginActionApi.loginReason;
        }
        LoginModel.getNet(this.context).signInByCode(code.setSignReason(str), new LoginServiceCallbackV2<SignInByCodeResponse>(this.view, false) {
            /* access modifiers changed from: protected */
            public boolean handleResponse(SignInByCodeResponse signInByCodeResponse, int i, String str) {
                LoginOmegaUtil add = new LoginOmegaUtil(LoginOmegaUtil.TONE_P_X_LOGIN_CODE_CHECK).add("errno", Integer.valueOf(signInByCodeResponse.errno));
                if (signInByCodeResponse.uid > 0) {
                    add.add("uid", Long.valueOf(signInByCodeResponse.uid));
                }
                add.send();
                int i2 = signInByCodeResponse.errno;
                if (i2 == 0) {
                    LoginCodePresenter.this.messenger.setLoginMethod("sms");
                    LoginCodePresenter.this.handToken(signInByCodeResponse);
                    return true;
                } else if (i2 == 41012) {
                    ((IVerifyCodeView) LoginCodePresenter.this.view).hideLoading();
                    LoginCodePresenter.this.messenger.setTempData(signInByCodeResponse.verifyEmailTexts == null ? null : signInByCodeResponse.verifyEmailTexts.toString());
                    LoginCodePresenter.this.updateOmegaScene(FragmentMessenger.getNowScene());
                    LoginCodePresenter.this.transform(LoginState.STATE_VERIFY_EMAIL);
                    return true;
                } else if (i2 != 41015) {
                    ((IVerifyCodeView) LoginCodePresenter.this.view).hideLoading();
                    ((IVerifyCodeView) LoginCodePresenter.this.view).cleanCode();
                    String str2 = signInByCodeResponse.error;
                    if (signInByCodeResponse.errno != -1) {
                        i = signInByCodeResponse.errno;
                    }
                    LoginOmegaUtil.trackLoginErrorEvent(2, str2, i, str, "signInByCode", (String) null);
                    new LoginOmegaUtil(LoginOmegaUtil.LOGIN_FAIL_SW).add("errno", Integer.valueOf(signInByCodeResponse.errno)).send();
                    return false;
                } else {
                    ((IVerifyCodeView) LoginCodePresenter.this.view).hideLoading();
                    ((IVerifyCodeView) LoginCodePresenter.this.view).showIdentityAuthPromptInfo();
                    return true;
                }
            }

            /* access modifiers changed from: protected */
            public void handleError(RpcRequest rpcRequest) {
                LoginOmegaUtil.trackLoginErrorEvent(0, (String) null, -1, "", "signInByCode", (String) null);
            }
        });
    }

    public List<LoginChoicePopUtil.ChoiceItem> getChoices() {
        if (this.choiceItems == null) {
            this.choiceItems = new ArrayList();
            if (ListenerManager.getWhatsAppListener() != null && ListenerManager.getWhatsAppListener().supportWhatsAppVerificationCode() && ListenerManager.getWhatsAppListener().whatsAppInstalled()) {
                this.choiceItems.add(0, new LoginChoicePopUtil.ChoiceItem(4, this.context.getString(R.string.login_unify_choice_whatsapp)));
            }
            if (this.messenger.isVoiceSupport()) {
                this.choiceItems.add(new LoginChoicePopUtil.ChoiceItem(1, this.context.getString(R.string.login_unify_choice_voice)));
            }
            if (!TextUtils.isEmpty(this.messenger.getHideEmail())) {
                this.choiceItems.add(new LoginChoicePopUtil.ChoiceItem(3, this.context.getString(R.string.login_unify_choice_email_code)));
            }
        }
        return this.choiceItems;
    }
}
