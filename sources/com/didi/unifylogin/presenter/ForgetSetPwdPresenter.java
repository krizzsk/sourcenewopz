package com.didi.unifylogin.presenter;

import android.content.Context;
import com.didi.unifylogin.api.LoginPreferredConfig;
import com.didi.unifylogin.api.OneLoginFacade;
import com.didi.unifylogin.base.model.LoginModel;
import com.didi.unifylogin.base.net.pojo.request.ForgetPasswordParam;
import com.didi.unifylogin.base.net.pojo.response.BaseLoginSuccessResponse;
import com.didi.unifylogin.base.presenter.LoginBaseFillerPresenter;
import com.didi.unifylogin.presenter.ability.ISetPwdPresenter;
import com.didi.unifylogin.store.LoginStore;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.didi.unifylogin.utils.RsaEncryptUtil;
import com.didi.unifylogin.utils.simplifycode.LoginServiceCallbackV2;
import com.didi.unifylogin.view.ability.ISetPwdView;
import com.didichuxing.foundation.rpc.RpcRequest;

public class ForgetSetPwdPresenter extends LoginBaseFillerPresenter<ISetPwdView> implements ISetPwdPresenter {
    public ForgetSetPwdPresenter(ISetPwdView iSetPwdView, Context context) {
        super(iSetPwdView, context);
    }

    public void setPassword(String str) {
        ((ISetPwdView) this.view).showLoading((String) null);
        ForgetPasswordParam ticket = new ForgetPasswordParam(this.context, getSceneNum()).setCell(this.messenger.getCell()).setCode(this.messenger.getCode()).setCodeType(this.messenger.getCodeType()).setEmail(this.messenger.getEmail()).setIdNum(this.messenger.getIdNum()).setName(this.messenger.getName()).setLastName(this.messenger.getLastName()).setTicket(LoginStore.getInstance().getToken());
        if (LoginPreferredConfig.isPasswordEncrypt()) {
            ticket.setPasswordEncrypt(1).setNewPassword(RsaEncryptUtil.getRSAData(this.context, str));
        } else {
            ticket.setNewPassword(str);
        }
        LoginModel.getNet(this.context).forgetPassword(ticket, new LoginServiceCallbackV2<BaseLoginSuccessResponse>(this.view, false) {
            /* access modifiers changed from: protected */
            public void handleError(RpcRequest rpcRequest) {
            }

            /* access modifiers changed from: protected */
            public boolean handleResponse(BaseLoginSuccessResponse baseLoginSuccessResponse, int i, String str) {
                if (baseLoginSuccessResponse.errno != 0) {
                    if (!OneLoginFacade.getStore().isLoginNow()) {
                        new LoginOmegaUtil(LoginOmegaUtil.LOGIN_FAIL_SW).add("errno", Integer.valueOf(baseLoginSuccessResponse.errno)).send();
                    }
                    ((ISetPwdView) ForgetSetPwdPresenter.this.view).hideLoading();
                    return false;
                }
                ForgetSetPwdPresenter.this.handToken(baseLoginSuccessResponse);
                return true;
            }
        });
    }
}
