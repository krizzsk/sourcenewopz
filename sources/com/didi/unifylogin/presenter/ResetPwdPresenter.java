package com.didi.unifylogin.presenter;

import android.content.Context;
import android.text.TextUtils;
import com.didi.unifylogin.api.LoginPreferredConfig;
import com.didi.unifylogin.base.model.LoginModel;
import com.didi.unifylogin.base.net.LoginRpcCallbackV2;
import com.didi.unifylogin.base.net.pojo.request.ResetPasswordParam;
import com.didi.unifylogin.base.net.pojo.response.BaseResponse;
import com.didi.unifylogin.base.presenter.LoginBasePresenter;
import com.didi.unifylogin.presenter.ability.IResetPasswordPresenter;
import com.didi.unifylogin.store.LoginStore;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.didi.unifylogin.utils.RsaEncryptUtil;
import com.didi.unifylogin.view.ability.IRestPwdView;
import com.didichuxing.foundation.rpc.RpcRequest;
import com.didichuxing.foundation.rpc.RpcResponseProxy;
import com.taxis99.R;
import java.io.IOException;

public class ResetPwdPresenter extends LoginBasePresenter<IRestPwdView> implements IResetPasswordPresenter {
    public ResetPwdPresenter(IRestPwdView iRestPwdView, Context context) {
        super(iRestPwdView, context);
    }

    public void resetPassword() {
        ((IRestPwdView) this.view).showLoading((String) null);
        ResetPasswordParam ticket = new ResetPasswordParam(this.context, this.messenger.getSceneNum()).setCell(this.messenger.getCell()).setTicket(LoginStore.getInstance().getToken());
        if (LoginPreferredConfig.isPasswordEncrypt()) {
            ticket.setPassword(RsaEncryptUtil.getRSAData(this.context, ((IRestPwdView) this.view).getOldPwd())).setNewPassword(RsaEncryptUtil.getRSAData(this.context, ((IRestPwdView) this.view).getNewPwd())).setPasswordEncrypt(1);
        } else {
            ticket.setPassword(((IRestPwdView) this.view).getOldPwd()).setNewPassword(((IRestPwdView) this.view).getNewPwd());
        }
        LoginModel.getNet(this.context).resetPassword(ticket, new LoginRpcCallbackV2<BaseResponse>() {
            public void onSuccess(RpcResponseProxy<BaseResponse> rpcResponseProxy) {
                String str;
                super.onSuccess(rpcResponseProxy);
                BaseResponse content = rpcResponseProxy.getContent();
                ((IRestPwdView) ResetPwdPresenter.this.view).hideLoading();
                if (content == null) {
                    ((IRestPwdView) ResetPwdPresenter.this.view).showError(ResetPwdPresenter.this.context.getResources().getString(R.string.login_unify_net_error));
                } else if (content.errno != 0) {
                    IRestPwdView iRestPwdView = (IRestPwdView) ResetPwdPresenter.this.view;
                    if (!TextUtils.isEmpty(content.error)) {
                        str = content.error;
                    } else {
                        str = ResetPwdPresenter.this.context.getResources().getString(R.string.login_unify_net_error);
                    }
                    iRestPwdView.showError(str);
                    new LoginOmegaUtil(LoginOmegaUtil.PSWDCHGE_OLD_ERROR_SW).add("errno", Integer.valueOf(content.errno)).send();
                } else {
                    new LoginOmegaUtil(LoginOmegaUtil.PSWDCHGE_SUCCESS_SW).send();
                    ((IRestPwdView) ResetPwdPresenter.this.view).onFlowFinish(-1);
                }
            }

            public void onFailure(RpcRequest rpcRequest, IOException iOException) {
                super.onFailure(rpcRequest, iOException);
                ((IRestPwdView) ResetPwdPresenter.this.view).hideLoading();
                ((IRestPwdView) ResetPwdPresenter.this.view).showError(ResetPwdPresenter.this.context.getResources().getString(R.string.login_unify_net_error));
            }
        });
    }
}
