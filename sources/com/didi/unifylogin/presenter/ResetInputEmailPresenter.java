package com.didi.unifylogin.presenter;

import android.content.Context;
import com.didi.unifylogin.base.model.FragmentMessenger;
import com.didi.unifylogin.base.model.LoginModel;
import com.didi.unifylogin.base.net.pojo.request.ResetEmailParam;
import com.didi.unifylogin.base.net.pojo.response.SetEmailResponse;
import com.didi.unifylogin.base.presenter.LoginBasePresenter;
import com.didi.unifylogin.presenter.ability.IInputEmailPresenter;
import com.didi.unifylogin.store.LoginStore;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.didi.unifylogin.utils.LoginState;
import com.didi.unifylogin.utils.simplifycode.LoginServiceCallbackV2;
import com.didi.unifylogin.view.ability.IInputEmailView;
import com.didichuxing.foundation.rpc.RpcRequest;

public class ResetInputEmailPresenter extends LoginBasePresenter<IInputEmailView> implements IInputEmailPresenter {
    public ResetInputEmailPresenter(IInputEmailView iInputEmailView, Context context) {
        super(iInputEmailView, context);
    }

    public void resetEmail() {
        ((IInputEmailView) this.view).showLoading((String) null);
        this.messenger.setNewEmail(((IInputEmailView) this.view).getNewEmail());
        LoginModel.getNet(this.context).resetEmail(new ResetEmailParam(this.context, getSceneNum()).setNewEmail(this.messenger.getNewEmail()).setCell(this.messenger.getCell()).setTicket(LoginStore.getInstance().getToken()), new LoginServiceCallbackV2<SetEmailResponse>(this.view) {
            /* access modifiers changed from: protected */
            public void handleError(RpcRequest rpcRequest) {
            }

            /* access modifiers changed from: protected */
            public boolean handleResponse(SetEmailResponse setEmailResponse, int i, String str) {
                if (setEmailResponse.errno == 51002) {
                    new LoginOmegaUtil(LoginOmegaUtil.TONE_P_X_EMAIL_REG).send();
                }
                int i2 = setEmailResponse.errno;
                if (i2 == 0) {
                    LoginStore.getInstance().setAndSaveHideEmail(setEmailResponse.email);
                    ((IInputEmailView) ResetInputEmailPresenter.this.view).onFlowFinish(-1);
                    return false;
                } else if (i2 != 41000) {
                    return false;
                } else {
                    ResetInputEmailPresenter.this.updateOmegaScene(FragmentMessenger.getNowScene());
                    ResetInputEmailPresenter.this.transform(LoginState.STATE_CODE);
                    return true;
                }
            }
        });
    }
}
