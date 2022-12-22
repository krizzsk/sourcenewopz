package com.didi.unifylogin.presenter;

import android.content.Context;
import com.didi.unifylogin.base.model.LoginModel;
import com.didi.unifylogin.base.net.pojo.request.SimpleParam;
import com.didi.unifylogin.base.net.pojo.response.BaseResponse;
import com.didi.unifylogin.base.net.pojo.response.GetEmailInfoResponse;
import com.didi.unifylogin.base.presenter.LoginBasePresenter;
import com.didi.unifylogin.presenter.ability.IPreSetEmailPresenter;
import com.didi.unifylogin.store.LoginStore;
import com.didi.unifylogin.utils.simplifycode.LoginServiceCallbackV2;
import com.didi.unifylogin.view.ability.IPreSetEmailView;
import com.didichuxing.foundation.rpc.RpcRequest;

public class PreSetEmailPresenter extends LoginBasePresenter<IPreSetEmailView> implements IPreSetEmailPresenter {
    public PreSetEmailPresenter(IPreSetEmailView iPreSetEmailView, Context context) {
        super(iPreSetEmailView, context);
    }

    public void getEmailState() {
        ((IPreSetEmailView) this.view).showLoading((String) null);
        LoginModel.getNet(this.context).getEmailInfo(new SimpleParam(this.context, getSceneNum()).setTicket(LoginStore.getInstance().getToken()), new LoginServiceCallbackV2<GetEmailInfoResponse>(this.view) {
            /* access modifiers changed from: protected */
            public boolean handleResponse(GetEmailInfoResponse getEmailInfoResponse, int i, String str) {
                if (getEmailInfoResponse.errno != 0) {
                    ((IPreSetEmailView) PreSetEmailPresenter.this.view).showErrorView();
                    return false;
                }
                PreSetEmailPresenter.this.messenger.setHideEmail(getEmailInfoResponse.email);
                ((IPreSetEmailView) PreSetEmailPresenter.this.view).upDateByState(getEmailInfoResponse.emailStatus, getEmailInfoResponse.activationTime);
                return true;
            }

            /* access modifiers changed from: protected */
            public void handleError(RpcRequest rpcRequest) {
                ((IPreSetEmailView) PreSetEmailPresenter.this.view).hideLoading();
                ((IPreSetEmailView) PreSetEmailPresenter.this.view).showErrorView();
            }
        });
    }

    public void toActivate() {
        ((IPreSetEmailView) this.view).showLoading((String) null);
        LoginModel.getNet(this.context).activateEmail(new SimpleParam(this.context, getSceneNum()).setTicket(LoginStore.getInstance().getToken()), new LoginServiceCallbackV2<BaseResponse>(this.view) {
            /* access modifiers changed from: protected */
            public void handleError(RpcRequest rpcRequest) {
            }

            /* access modifiers changed from: protected */
            public boolean handleResponse(BaseResponse baseResponse, int i, String str) {
                if (baseResponse.errno != 0) {
                    return false;
                }
                ((IPreSetEmailView) PreSetEmailPresenter.this.view).showActivateDialog();
                return true;
            }
        });
    }
}
