package com.didi.unifylogin.presenter;

import android.content.Context;
import android.text.TextUtils;
import com.didi.unifylogin.base.model.FragmentMessenger;
import com.didi.unifylogin.base.model.LoginModel;
import com.didi.unifylogin.base.net.pojo.request.ForgetPasswordParam;
import com.didi.unifylogin.base.net.pojo.response.BaseLoginSuccessResponse;
import com.didi.unifylogin.base.presenter.LoginBasePresenter;
import com.didi.unifylogin.presenter.ability.ICertificationPresenter;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.didi.unifylogin.utils.LoginState;
import com.didi.unifylogin.utils.simplifycode.LoginServiceCallbackV2;
import com.didi.unifylogin.view.ability.ICertificationView;
import com.didichuxing.foundation.rpc.RpcRequest;
import com.taxis99.R;

public class ForgetCertificationPresenter extends LoginBasePresenter<ICertificationView> implements ICertificationPresenter {
    public ForgetCertificationPresenter(ICertificationView iCertificationView, Context context) {
        super(iCertificationView, context);
    }

    public void certification() {
        ((ICertificationView) this.view).showLoading((String) null);
        this.messenger.setName(((ICertificationView) this.view).getName()).setLastName(((ICertificationView) this.view).getLastName()).setIdNum(((ICertificationView) this.view).getIdNum());
        LoginModel.getNet(this.context).forgetPassword(new ForgetPasswordParam(this.context, getSceneNum()).setCell(this.messenger.getCell()).setCode(this.messenger.getCode()).setCodeType(this.messenger.getCodeType()).setName(this.messenger.getName()).setLastName(this.messenger.getLastName()).setIdNum(this.messenger.getIdNum()), new LoginServiceCallbackV2<BaseLoginSuccessResponse>(this.view) {
            /* access modifiers changed from: protected */
            public void handleError(RpcRequest rpcRequest) {
            }

            /* access modifiers changed from: protected */
            public boolean handleResponse(BaseLoginSuccessResponse baseLoginSuccessResponse, int i, String str) {
                String str2;
                int i2 = baseLoginSuccessResponse.errno;
                if (i2 == 41004) {
                    new LoginOmegaUtil(LoginOmegaUtil.IDCHECK_SUCCESS_SW).send();
                    ForgetCertificationPresenter.this.updateOmegaScene(FragmentMessenger.getNowScene());
                    ForgetCertificationPresenter.this.transform(LoginState.STATE_SET_PWD);
                    return true;
                } else if (i2 != 41010) {
                    return false;
                } else {
                    ICertificationView iCertificationView = (ICertificationView) ForgetCertificationPresenter.this.view;
                    if (!TextUtils.isEmpty(baseLoginSuccessResponse.error)) {
                        str2 = baseLoginSuccessResponse.error;
                    } else {
                        str2 = ForgetCertificationPresenter.this.context.getResources().getString(R.string.login_unify_net_error);
                    }
                    iCertificationView.showError(str2);
                    new LoginOmegaUtil(LoginOmegaUtil.IDCHECK_FAIL_SW).send();
                    return true;
                }
            }
        });
    }
}
