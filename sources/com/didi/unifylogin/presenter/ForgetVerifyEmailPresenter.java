package com.didi.unifylogin.presenter;

import android.content.Context;
import com.didi.sdk.util.TextUtil;
import com.didi.unifylogin.base.model.FragmentMessenger;
import com.didi.unifylogin.base.model.LoginModel;
import com.didi.unifylogin.base.net.pojo.request.ForgetPasswordParam;
import com.didi.unifylogin.base.net.pojo.response.BaseLoginSuccessResponse;
import com.didi.unifylogin.base.presenter.LoginBasePresenter;
import com.didi.unifylogin.presenter.ability.IVerifyEmailPresenter;
import com.didi.unifylogin.utils.LoginState;
import com.didi.unifylogin.utils.simplifycode.LoginServiceCallbackV2;
import com.didi.unifylogin.view.ability.IVerifyEmailView;
import com.didichuxing.foundation.rpc.RpcRequest;
import com.taxis99.R;

public class ForgetVerifyEmailPresenter extends LoginBasePresenter<IVerifyEmailView> implements IVerifyEmailPresenter {
    public ForgetVerifyEmailPresenter(IVerifyEmailView iVerifyEmailView, Context context) {
        super(iVerifyEmailView, context);
    }

    public void verifyEmail() {
        if (TextUtil.isEmpty(((IVerifyEmailView) this.view).getEmail()) || !((IVerifyEmailView) this.view).getEmail().contains("@")) {
            ((IVerifyEmailView) this.view).showError(this.context.getString(R.string.login_unify_input_right_email));
            return;
        }
        ((IVerifyEmailView) this.view).showLoading((String) null);
        this.messenger.setEmail(((IVerifyEmailView) this.view).getEmail());
        LoginModel.getNet(this.context).forgetPassword(new ForgetPasswordParam(this.context, getSceneNum()).setCell(this.messenger.getCell()).setCode(this.messenger.getCode()).setCodeType(this.messenger.getCodeType()).setEmail(this.messenger.getEmail()), new LoginServiceCallbackV2<BaseLoginSuccessResponse>(this.view) {
            /* access modifiers changed from: protected */
            public void handleError(RpcRequest rpcRequest) {
            }

            /* access modifiers changed from: protected */
            public boolean handleResponse(BaseLoginSuccessResponse baseLoginSuccessResponse, int i, String str) {
                if (baseLoginSuccessResponse.errno != 41004) {
                    return false;
                }
                ForgetVerifyEmailPresenter.this.updateOmegaScene(FragmentMessenger.getNowScene());
                ForgetVerifyEmailPresenter.this.transform(LoginState.STATE_SET_PWD);
                return true;
            }
        });
    }
}
