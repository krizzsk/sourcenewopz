package com.didi.unifylogin.presenter;

import android.content.Context;
import android.text.TextUtils;
import com.didi.unifylogin.base.model.LoginModel;
import com.didi.unifylogin.base.net.LoginRpcCallbackV2;
import com.didi.unifylogin.base.net.pojo.request.CodeMtParam;
import com.didi.unifylogin.base.net.pojo.request.VerifyCodeParam;
import com.didi.unifylogin.base.net.pojo.response.CodeMtResponse;
import com.didi.unifylogin.base.net.pojo.response.VerifyCodeResponse;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.didi.unifylogin.utils.LoginState;
import com.didi.unifylogin.view.ability.IVerifyCodeView;
import com.didichuxing.foundation.rpc.RpcRequest;
import com.didichuxing.foundation.rpc.RpcResponseProxy;
import com.taxis99.R;
import java.io.IOException;

public class VerifyEmailRegisterCodePresenter extends BaseCodePresenter {
    public VerifyEmailRegisterCodePresenter(IVerifyCodeView iVerifyCodeView, Context context) {
        super(iVerifyCodeView, context);
    }

    public void nextOperate() {
        ((IVerifyCodeView) this.view).showLoading((String) null);
        LoginModel.getNet(this.context).verifyCode(new VerifyCodeParam(this.context, this.messenger.getSceneNum()).setCode(((IVerifyCodeView) this.view).getCode()).setCodeType(this.messenger.getCodeType()).setEmail(this.messenger.getEmail()), new LoginRpcCallbackV2<VerifyCodeResponse>() {
            public void onSuccess(RpcResponseProxy<VerifyCodeResponse> rpcResponseProxy) {
                super.onSuccess(rpcResponseProxy);
                VerifyCodeResponse content = rpcResponseProxy.getContent();
                ((IVerifyCodeView) VerifyEmailRegisterCodePresenter.this.view).hideLoading();
                if (content == null) {
                    ((IVerifyCodeView) VerifyEmailRegisterCodePresenter.this.view).showError((int) R.string.login_unify_net_error);
                } else if (content.errno != 0) {
                    ((IVerifyCodeView) VerifyEmailRegisterCodePresenter.this.view).showError(TextUtils.isEmpty(content.error) ? VerifyEmailRegisterCodePresenter.this.context.getString(R.string.login_unify_net_error) : content.error);
                    ((IVerifyCodeView) VerifyEmailRegisterCodePresenter.this.view).cleanCode();
                } else {
                    VerifyEmailRegisterCodePresenter.this.messenger.setCode(((IVerifyCodeView) VerifyEmailRegisterCodePresenter.this.view).getCode());
                    VerifyEmailRegisterCodePresenter.this.transform(LoginState.STATE_SET_PWD_BY_EMAIL);
                }
            }

            public void onFailure(RpcRequest rpcRequest, IOException iOException) {
                super.onFailure(rpcRequest, iOException);
                ((IVerifyCodeView) VerifyEmailRegisterCodePresenter.this.view).hideLoading();
                ((IVerifyCodeView) VerifyEmailRegisterCodePresenter.this.view).showError((int) R.string.login_unify_net_error);
                iOException.printStackTrace();
            }
        });
    }

    public void requestSms(int i) {
        ((IVerifyCodeView) this.view).showLoading((String) null);
        LoginModel.getNet(((IVerifyCodeView) this.view).getBaseActivity()).codeMt(new CodeMtParam(this.context, this.messenger.getSceneNum()).setEmail(this.messenger.getEmail()).setCodeType(i), new LoginRpcCallbackV2<CodeMtResponse>() {
            public void onSuccess(RpcResponseProxy<CodeMtResponse> rpcResponseProxy) {
                super.onSuccess(rpcResponseProxy);
                CodeMtResponse content = rpcResponseProxy.getContent();
                ((IVerifyCodeView) VerifyEmailRegisterCodePresenter.this.view).hideLoading();
                if (content == null) {
                    ((IVerifyCodeView) VerifyEmailRegisterCodePresenter.this.view).showError((int) R.string.login_unify_net_error);
                } else if (content.errno != 0) {
                    ((IVerifyCodeView) VerifyEmailRegisterCodePresenter.this.view).showError(TextUtils.isEmpty(content.error) ? VerifyEmailRegisterCodePresenter.this.context.getString(R.string.login_unify_net_error) : content.error);
                } else {
                    VerifyEmailRegisterCodePresenter.this.setCodeType(content.code_type);
                    VerifyEmailRegisterCodePresenter.this.messenger.setPrompt(content.prompt);
                    VerifyEmailRegisterCodePresenter.this.messenger.setVoiceSupport(content.voiceSupport);
                    ((IVerifyCodeView) VerifyEmailRegisterCodePresenter.this.view).resetCodeStatus();
                    if (content.code_type != 2) {
                        ((IVerifyCodeView) VerifyEmailRegisterCodePresenter.this.view).showShortCompleted((int) R.string.login_unify_send_sms_code_success);
                        return;
                    }
                    ((IVerifyCodeView) VerifyEmailRegisterCodePresenter.this.view).showShortCompleted((int) R.string.login_unify_send_email_code_success);
                    LoginOmegaUtil.trackEvent(LoginOmegaUtil.GP_RECEIVE_SUCCESS_VIEW_SW);
                }
            }

            public void onFailure(RpcRequest rpcRequest, IOException iOException) {
                super.onFailure(rpcRequest, iOException);
                ((IVerifyCodeView) VerifyEmailRegisterCodePresenter.this.view).hideLoading();
                ((IVerifyCodeView) VerifyEmailRegisterCodePresenter.this.view).showError((int) R.string.login_unify_net_error);
                iOException.printStackTrace();
            }
        });
    }
}
