package com.didi.unifylogin.presenter;

import android.content.Context;
import com.didi.unifylogin.api.LoginPreferredConfig;
import com.didi.unifylogin.base.model.LoginModel;
import com.didi.unifylogin.base.net.pojo.request.SetPasswordParam;
import com.didi.unifylogin.base.net.pojo.response.BaseResponse;
import com.didi.unifylogin.base.presenter.LoginBaseFillerPresenter;
import com.didi.unifylogin.presenter.ability.ISetPwdPresenter;
import com.didi.unifylogin.store.LoginStore;
import com.didi.unifylogin.utils.RsaEncryptUtil;
import com.didi.unifylogin.utils.simplifycode.LoginServiceCallbackV2;
import com.didi.unifylogin.view.ability.ISetPwdView;
import com.didichuxing.foundation.rpc.RpcRequest;

public class SetPwdPresenter extends LoginBaseFillerPresenter<ISetPwdView> implements ISetPwdPresenter {
    public SetPwdPresenter(ISetPwdView iSetPwdView, Context context) {
        super(iSetPwdView, context);
    }

    public void setPassword(String str) {
        ((ISetPwdView) this.view).showLoading((String) null);
        SetPasswordParam cell = new SetPasswordParam(this.context, getSceneNum()).setTicket(LoginStore.getInstance().getToken()).setCell(getMessenger().getCell());
        if (LoginPreferredConfig.isPasswordEncrypt()) {
            cell.setNewPassword(RsaEncryptUtil.getRSAData(this.context, str)).setPasswordEncrypt(1);
        } else {
            cell.setNewPassword(str);
        }
        LoginModel.getNet(this.context).setPassword(cell, new LoginServiceCallbackV2<BaseResponse>(this.view) {
            /* access modifiers changed from: protected */
            public void handleError(RpcRequest rpcRequest) {
            }

            /* access modifiers changed from: protected */
            public boolean handleResponse(BaseResponse baseResponse, int i, String str) {
                if (baseResponse.errno != 0) {
                    return false;
                }
                ((ISetPwdView) SetPwdPresenter.this.view).onFlowFinish(-1);
                return true;
            }
        });
    }
}
