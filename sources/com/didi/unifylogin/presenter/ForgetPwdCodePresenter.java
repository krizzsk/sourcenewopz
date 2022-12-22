package com.didi.unifylogin.presenter;

import android.content.Context;
import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.util.TextUtil;
import com.didi.unifylogin.api.LoginPreferredConfig;
import com.didi.unifylogin.api.OneLoginFacade;
import com.didi.unifylogin.base.model.FragmentMessenger;
import com.didi.unifylogin.base.model.LoginModel;
import com.didi.unifylogin.base.net.LoginRpcCallbackV2;
import com.didi.unifylogin.base.net.pojo.request.ForgetPasswordParam;
import com.didi.unifylogin.base.net.pojo.response.BaseLoginSuccessResponse;
import com.didi.unifylogin.utils.LoginChoicePopUtil;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.didi.unifylogin.utils.LoginState;
import com.didi.unifylogin.view.ability.IVerifyCodeView;
import com.didichuxing.foundation.rpc.RpcRequest;
import com.didichuxing.foundation.rpc.RpcResponseProxy;
import com.taxis99.R;
import java.io.IOException;
import java.util.List;

public class ForgetPwdCodePresenter extends BaseCodePresenter {
    public ForgetPwdCodePresenter(IVerifyCodeView iVerifyCodeView, Context context) {
        super(iVerifyCodeView, context);
    }

    public void nextOperate() {
        ((IVerifyCodeView) this.view).showLoading((String) null);
        this.messenger.setCode(((IVerifyCodeView) this.view).getCode());
        LoginModel.getNet(this.context).forgetPassword(new ForgetPasswordParam(this.context, getSceneNum()).setCell(this.messenger.getCell()).setCode(this.messenger.getCode()).setCodeType(this.messenger.getCodeType()), new LoginRpcCallbackV2<BaseLoginSuccessResponse>() {
            public void onSuccess(RpcResponseProxy<BaseLoginSuccessResponse> rpcResponseProxy) {
                super.onSuccess(rpcResponseProxy);
                BaseLoginSuccessResponse content = rpcResponseProxy.getContent();
                ((IVerifyCodeView) ForgetPwdCodePresenter.this.view).hideLoading();
                if (content == null) {
                    ((IVerifyCodeView) ForgetPwdCodePresenter.this.view).showError((int) R.string.login_unify_net_error);
                    return;
                }
                int i = content.errno;
                if (i == 0) {
                    ForgetPwdCodePresenter.this.handToken(content);
                } else if (i == 41004) {
                    ForgetPwdCodePresenter.this.updateOmegaScene(FragmentMessenger.getNowScene());
                    ForgetPwdCodePresenter.this.transform(LoginState.STATE_SET_PWD);
                } else if (i == 41006) {
                    ForgetPwdCodePresenter.this.m31948a();
                } else if (i == 41012) {
                    ForgetPwdCodePresenter.this.updateOmegaScene(FragmentMessenger.getNowScene());
                    ForgetPwdCodePresenter.this.transform(LoginState.STATE_VERIFY_EMAIL);
                } else if (i != 41015) {
                    ((IVerifyCodeView) ForgetPwdCodePresenter.this.view).showError(TextUtil.isEmpty(content.error) ? ForgetPwdCodePresenter.this.context.getString(R.string.login_unify_net_error) : content.error);
                    ((IVerifyCodeView) ForgetPwdCodePresenter.this.view).cleanCode();
                } else {
                    ((IVerifyCodeView) ForgetPwdCodePresenter.this.view).showIdentityAuthPromptInfo();
                }
                new LoginOmegaUtil(LoginOmegaUtil.LOGIN_FAIL_SW).add("errno", Integer.valueOf(content.errno)).send();
            }

            public void onFailure(RpcRequest rpcRequest, IOException iOException) {
                super.onFailure(rpcRequest, iOException);
                ((IVerifyCodeView) ForgetPwdCodePresenter.this.view).hideLoading();
                ((IVerifyCodeView) ForgetPwdCodePresenter.this.view).showError((int) R.string.login_unify_net_error);
            }
        });
    }

    public List<LoginChoicePopUtil.ChoiceItem> getChoices() {
        if (this.choiceItems == null) {
            this.choiceItems = super.getChoices();
            if (!OneLoginFacade.getStore().isLoginNow() && !LoginPreferredConfig.isCloseRetrieve()) {
                this.choiceItems.add(new LoginChoicePopUtil.ChoiceItem(2, this.context.getString(R.string.login_unify_choice_retrieve)));
            }
        }
        return this.choiceItems;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m31948a() {
        ((IVerifyCodeView) this.view).showInfoDialog(this.context.getString(R.string.login_unify_verify_dialog_status_exception_title), this.context.getString(R.string.login_unify_verify_dialog_status_exception_message), this.context.getString(R.string.login_unify_verify_dialog_know_button), new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                ((IVerifyCodeView) ForgetPwdCodePresenter.this.view).onFlowFinish(0);
            }
        });
    }
}
