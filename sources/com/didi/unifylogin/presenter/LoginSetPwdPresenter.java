package com.didi.unifylogin.presenter;

import android.content.Context;
import android.text.TextUtils;
import com.didi.unifylogin.api.LoginPreferredConfig;
import com.didi.unifylogin.api.OneLoginFacade;
import com.didi.unifylogin.base.model.LoginModel;
import com.didi.unifylogin.base.net.LoginRpcCallbackV2;
import com.didi.unifylogin.base.net.pojo.request.SetPasswordParam;
import com.didi.unifylogin.base.net.pojo.response.BaseResponse;
import com.didi.unifylogin.base.presenter.LoginBaseFillerPresenter;
import com.didi.unifylogin.presenter.ability.ISetPwdPresenter;
import com.didi.unifylogin.store.LoginStore;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.didi.unifylogin.utils.RsaEncryptUtil;
import com.didi.unifylogin.view.ability.ISetPwdView;
import com.didichuxing.foundation.rpc.RpcRequest;
import com.didichuxing.foundation.rpc.RpcResponseProxy;
import com.taxis99.R;
import java.io.IOException;

public class LoginSetPwdPresenter extends LoginBaseFillerPresenter<ISetPwdView> implements ISetPwdPresenter {
    public LoginSetPwdPresenter(ISetPwdView iSetPwdView, Context context) {
        super(iSetPwdView, context);
    }

    public void setPassword(String str) {
        ((ISetPwdView) this.view).showLoading((String) null);
        SetPasswordParam cell = new SetPasswordParam(this.context, getSceneNum()).setTicket(LoginStore.getInstance().getTemporaryToken()).setCell(getMessenger().getCell());
        if (LoginPreferredConfig.isPasswordEncrypt()) {
            cell.setNewPassword(RsaEncryptUtil.getRSAData(this.context, str)).setPasswordEncrypt(1);
        } else {
            cell.setNewPassword(str);
        }
        LoginModel.getNet(this.context).setPassword(cell, new LoginRpcCallbackV2<BaseResponse>() {
            public void onSuccess(RpcResponseProxy<BaseResponse> rpcResponseProxy) {
                String str;
                super.onSuccess(rpcResponseProxy);
                BaseResponse content = rpcResponseProxy.getContent();
                if (content == null) {
                    ((ISetPwdView) LoginSetPwdPresenter.this.view).hideLoading();
                    ((ISetPwdView) LoginSetPwdPresenter.this.view).showError(LoginSetPwdPresenter.this.context.getResources().getString(R.string.login_unify_net_error));
                } else if (content.errno != 0) {
                    ((ISetPwdView) LoginSetPwdPresenter.this.view).hideLoading();
                    ISetPwdView iSetPwdView = (ISetPwdView) LoginSetPwdPresenter.this.view;
                    if (!TextUtils.isEmpty(content.error)) {
                        str = content.error;
                    } else {
                        str = LoginSetPwdPresenter.this.context.getResources().getString(R.string.login_unify_net_error);
                    }
                    iSetPwdView.showError(str);
                    if (!OneLoginFacade.getStore().isLoginNow()) {
                        new LoginOmegaUtil(LoginOmegaUtil.LOGIN_FAIL_SW).add("errno", Integer.valueOf(content.errno)).send();
                    }
                } else {
                    LoginSetPwdPresenter.this.goFillNextInfo();
                }
            }

            public void onFailure(RpcRequest rpcRequest, IOException iOException) {
                super.onFailure(rpcRequest, iOException);
                ((ISetPwdView) LoginSetPwdPresenter.this.view).hideLoading();
                ((ISetPwdView) LoginSetPwdPresenter.this.view).showError(LoginSetPwdPresenter.this.context.getResources().getString(R.string.login_unify_net_error));
            }
        });
    }
}
