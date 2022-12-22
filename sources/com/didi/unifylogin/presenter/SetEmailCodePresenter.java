package com.didi.unifylogin.presenter;

import android.content.Context;
import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.unifylogin.base.model.LoginModel;
import com.didi.unifylogin.base.net.pojo.request.ResetEmailParam;
import com.didi.unifylogin.base.net.pojo.response.SetEmailResponse;
import com.didi.unifylogin.store.LoginStore;
import com.didi.unifylogin.utils.simplifycode.LoginServiceCallbackV2;
import com.didi.unifylogin.view.ability.IVerifyCodeView;
import com.didichuxing.foundation.rpc.RpcRequest;
import com.taxis99.R;

public class SetEmailCodePresenter extends BaseCodePresenter {
    public SetEmailCodePresenter(IVerifyCodeView iVerifyCodeView, Context context) {
        super(iVerifyCodeView, context);
    }

    public void nextOperate() {
        ((IVerifyCodeView) this.view).showLoading((String) null);
        this.messenger.setCode(((IVerifyCodeView) this.view).getCode());
        LoginModel.getNet(this.context).resetEmail(new ResetEmailParam(this.context, getSceneNum()).setCell(this.messenger.getCell()).setCode(this.messenger.getCode()).setNewEmail(this.messenger.getNewEmail()).setTicket(LoginStore.getInstance().getToken()).setCodeType(getCodeType()), new LoginServiceCallbackV2<SetEmailResponse>(this.view) {
            /* access modifiers changed from: protected */
            public void handleError(RpcRequest rpcRequest) {
            }

            /* access modifiers changed from: protected */
            public boolean handleResponse(SetEmailResponse setEmailResponse, int i, String str) {
                if (setEmailResponse.errno != 0) {
                    ((IVerifyCodeView) SetEmailCodePresenter.this.view).cleanCode();
                    return false;
                }
                LoginStore.getInstance().setAndSaveHideEmail(setEmailResponse.email);
                ((IVerifyCodeView) SetEmailCodePresenter.this.view).showInfoDialog(SetEmailCodePresenter.this.context.getString(R.string.login_unify_activated_dialog_title), SetEmailCodePresenter.this.context.getString(R.string.login_unify_activated_dialog_msg), SetEmailCodePresenter.this.context.getString(R.string.login_unify_str_know_btn), new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        ((IVerifyCodeView) SetEmailCodePresenter.this.view).onFlowFinish(-1);
                    }
                });
                return true;
            }
        });
    }
}
