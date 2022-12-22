package com.didi.unifylogin.presenter;

import android.content.Context;
import com.didi.unifylogin.base.model.LoginModel;
import com.didi.unifylogin.base.net.pojo.request.SetPasswordParamByEmail;
import com.didi.unifylogin.base.net.pojo.response.BaseResponse;
import com.didi.unifylogin.utils.simplifycode.LoginServiceCallbackV2;
import com.didi.unifylogin.view.ability.ISetPwdView;
import com.didichuxing.foundation.rpc.RpcRequest;

public class SetPwdByEmailLoginPresenter extends SetPwdPresenter {
    public SetPwdByEmailLoginPresenter(ISetPwdView iSetPwdView, Context context) {
        super(iSetPwdView, context);
    }

    public void setPassword(String str) {
        ((ISetPwdView) this.view).showLoading((String) null);
        SetPasswordParamByEmail setPasswordParamByEmail = new SetPasswordParamByEmail(this.context, getSceneNum());
        setPasswordParamByEmail.setPassword(str);
        setPasswordParamByEmail.setCode(this.messenger.getCode());
        setPasswordParamByEmail.setEmail(this.messenger.getEmail());
        LoginModel.getNet(this.context).setPasswordByEmail(setPasswordParamByEmail, new LoginServiceCallbackV2<BaseResponse>(this.view) {
            /* access modifiers changed from: protected */
            public void handleError(RpcRequest rpcRequest) {
            }

            /* access modifiers changed from: protected */
            public boolean handleResponse(BaseResponse baseResponse, int i, String str) {
                if (baseResponse.errno != 0) {
                    return false;
                }
                ((ISetPwdView) SetPwdByEmailLoginPresenter.this.view).onFlowFinish(-1);
                return true;
            }
        });
    }
}
