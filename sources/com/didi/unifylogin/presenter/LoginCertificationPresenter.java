package com.didi.unifylogin.presenter;

import android.content.Context;
import android.text.TextUtils;
import com.didi.unifylogin.base.model.LoginModel;
import com.didi.unifylogin.base.net.pojo.request.SignInByCodeParam;
import com.didi.unifylogin.base.net.pojo.response.SignInByCodeResponse;
import com.didi.unifylogin.base.presenter.LoginBasePresenter;
import com.didi.unifylogin.presenter.ability.ICertificationPresenter;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.didi.unifylogin.utils.simplifycode.LoginServiceCallbackV2;
import com.didi.unifylogin.view.ability.ICertificationView;
import com.didichuxing.foundation.rpc.RpcRequest;
import com.taxis99.R;

public class LoginCertificationPresenter extends LoginBasePresenter<ICertificationView> implements ICertificationPresenter {
    public LoginCertificationPresenter(ICertificationView iCertificationView, Context context) {
        super(iCertificationView, context);
    }

    public void certification() {
        ((ICertificationView) this.view).showLoading((String) null);
        this.messenger.setName(((ICertificationView) this.view).getName()).setLastName(((ICertificationView) this.view).getLastName()).setIdNum(((ICertificationView) this.view).getIdNum());
        LoginModel.getNet(this.context).signInByCode(new SignInByCodeParam(this.context, getSceneNum()).setCell(this.messenger.getCell()).setCode(this.messenger.getCode()).setCodeType(this.messenger.getCodeType()).setName(this.messenger.getName()).setLastName(this.messenger.getLastName()).setIdNum(this.messenger.getIdNum()), new LoginServiceCallbackV2<SignInByCodeResponse>(this.view, false) {
            /* access modifiers changed from: protected */
            public boolean handleResponse(SignInByCodeResponse signInByCodeResponse, int i, String str) {
                String str2;
                int i2 = signInByCodeResponse.errno;
                if (i2 == 0) {
                    new LoginOmegaUtil(LoginOmegaUtil.IDCHECK_SUCCESS_SW).send();
                    LoginCertificationPresenter.this.handToken(signInByCodeResponse);
                    return true;
                } else if (i2 != 41010) {
                    ((ICertificationView) LoginCertificationPresenter.this.view).hideLoading();
                    String str3 = signInByCodeResponse.error;
                    if (signInByCodeResponse.errno != -1) {
                        i = signInByCodeResponse.errno;
                    }
                    LoginOmegaUtil.trackLoginErrorEvent(2, str3, i, str, "signInByCode", (String) null);
                    return false;
                } else {
                    new LoginOmegaUtil(LoginOmegaUtil.IDCHECK_FAIL_SW).send();
                    ((ICertificationView) LoginCertificationPresenter.this.view).hideLoading();
                    ICertificationView iCertificationView = (ICertificationView) LoginCertificationPresenter.this.view;
                    if (!TextUtils.isEmpty(signInByCodeResponse.error)) {
                        str2 = signInByCodeResponse.error;
                    } else {
                        str2 = LoginCertificationPresenter.this.context.getResources().getString(R.string.login_unify_net_error);
                    }
                    iCertificationView.showError(str2);
                    return true;
                }
            }

            /* access modifiers changed from: protected */
            public void handleError(RpcRequest rpcRequest) {
                LoginOmegaUtil.trackLoginErrorEvent(0, (String) null, -1, "", "signInByCode", (String) null);
            }
        });
    }
}
