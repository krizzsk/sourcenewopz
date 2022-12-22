package com.didi.unifylogin.presenter;

import android.content.Context;
import com.didi.unifylogin.api.OneLoginFacade;
import com.didi.unifylogin.base.model.LoginModel;
import com.didi.unifylogin.base.net.LoginScene;
import com.didi.unifylogin.base.net.pojo.request.ForgetPasswordParam;
import com.didi.unifylogin.base.net.pojo.response.BaseLoginSuccessResponse;
import com.didi.unifylogin.store.LoginStore;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.didi.unifylogin.utils.LoginState;
import com.didi.unifylogin.utils.simplifycode.LoginServiceCallbackV2;
import com.didi.unifylogin.view.ability.ISetPwdView;
import com.didichuxing.foundation.rpc.RpcRequest;

public class ForgetEmailSetPwdPresenter extends ForgetSetPwdPresenter {
    public ForgetEmailSetPwdPresenter(ISetPwdView iSetPwdView, Context context) {
        super(iSetPwdView, context);
    }

    public void setPassword(String str) {
        ((ISetPwdView) this.view).showLoading((String) null);
        LoginModel.getNet(this.context).forgetPassword(new ForgetPasswordParam(this.context, getSceneNum()).setCode(this.messenger.getCode()).setCodeType(this.messenger.getCodeType()).setEmail(this.messenger.getEmail()).setIdNum(this.messenger.getIdNum()).setName(this.messenger.getName()).setLastName(this.messenger.getLastName()).setNewPassword(str).setTicket(LoginStore.getInstance().getToken()), new LoginServiceCallbackV2<BaseLoginSuccessResponse>(this.view, false) {
            /* access modifiers changed from: protected */
            public void handleError(RpcRequest rpcRequest) {
            }

            /* access modifiers changed from: protected */
            public boolean handleResponse(BaseLoginSuccessResponse baseLoginSuccessResponse, int i, String str) {
                int i2 = baseLoginSuccessResponse.errno;
                if (i2 != 0) {
                    if (i2 == 41011) {
                        ((ISetPwdView) ForgetEmailSetPwdPresenter.this.view).hideLoading();
                        ForgetEmailSetPwdPresenter.this.updateOmegaScene(LoginScene.SCENE_LOGIN);
                        ForgetEmailSetPwdPresenter.this.transform(LoginState.STATE_EMAIL_REGISTER_OR_LOGIN);
                    }
                    if (!OneLoginFacade.getStore().isLoginNow()) {
                        new LoginOmegaUtil(LoginOmegaUtil.LOGIN_FAIL_SW).add("errno", Integer.valueOf(baseLoginSuccessResponse.errno)).send();
                    }
                    ((ISetPwdView) ForgetEmailSetPwdPresenter.this.view).hideLoading();
                    return false;
                }
                ForgetEmailSetPwdPresenter.this.handToken(baseLoginSuccessResponse);
                return true;
            }
        });
    }
}
