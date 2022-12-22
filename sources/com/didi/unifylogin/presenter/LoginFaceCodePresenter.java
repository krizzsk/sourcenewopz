package com.didi.unifylogin.presenter;

import android.content.Context;
import com.didi.unifylogin.base.model.LoginModel;
import com.didi.unifylogin.base.net.pojo.request.SignInByFaceParam;
import com.didi.unifylogin.base.net.pojo.response.SignInByFaceResponse;
import com.didi.unifylogin.utils.simplifycode.LoginServiceCallbackV2;
import com.didi.unifylogin.view.ability.IVerifyCodeView;
import com.didichuxing.foundation.rpc.RpcRequest;

public class LoginFaceCodePresenter extends BaseCodePresenter {
    public LoginFaceCodePresenter(IVerifyCodeView iVerifyCodeView, Context context) {
        super(iVerifyCodeView, context);
    }

    public void nextOperate() {
        ((IVerifyCodeView) this.view).showLoading((String) null);
        this.messenger.setCode(((IVerifyCodeView) this.view).getCode());
        SignInByFaceParam code = new SignInByFaceParam(this.context, getSceneNum()).setSessionId(this.messenger.getSessionId()).setCell(this.messenger.getCell()).setCodeType(this.messenger.getCodeType()).setCode(this.messenger.getCode());
        ((IVerifyCodeView) this.view).showLoading((String) null);
        LoginModel.getNet(this.context).signInByFace(code, new LoginServiceCallbackV2<SignInByFaceResponse>(this.view) {
            /* access modifiers changed from: protected */
            public void handleError(RpcRequest rpcRequest) {
            }

            /* access modifiers changed from: protected */
            public boolean handleResponse(SignInByFaceResponse signInByFaceResponse, int i, String str) {
                if (signInByFaceResponse.errno != 0) {
                    ((IVerifyCodeView) LoginFaceCodePresenter.this.view).cleanCode();
                    return false;
                }
                LoginFaceCodePresenter.this.handToken(signInByFaceResponse);
                return true;
            }
        });
    }
}
