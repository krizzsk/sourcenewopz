package com.didi.unifylogin.presenter;

import android.content.Context;
import com.didi.sdk.util.TextUtil;
import com.didi.unifylogin.base.model.LoginModel;
import com.didi.unifylogin.base.net.LoginRpcCallbackV2;
import com.didi.unifylogin.base.net.pojo.request.DeleteAccountParam;
import com.didi.unifylogin.base.net.pojo.response.DeleteAccountResponse;
import com.didi.unifylogin.store.LoginStore;
import com.didi.unifylogin.view.ability.IVerifyCodeView;
import com.didichuxing.foundation.rpc.RpcRequest;
import com.didichuxing.foundation.rpc.RpcResponseProxy;
import com.taxis99.R;
import java.io.IOException;

public class CancelCodePresenter extends BaseCodePresenter {
    public CancelCodePresenter(IVerifyCodeView iVerifyCodeView, Context context) {
        super(iVerifyCodeView, context);
    }

    public void nextOperate() {
        ((IVerifyCodeView) this.view).showLoading((String) null);
        LoginModel.getNet(this.context).deleteAccount(new DeleteAccountParam(this.context, getSceneNum()).setCell(this.messenger.getCell()).setCode(((IVerifyCodeView) this.view).getCode()).setCodeType(this.messenger.getCodeType()).setTicket(LoginStore.getInstance().getToken()), new LoginRpcCallbackV2<DeleteAccountResponse>() {
            public void onSuccess(RpcResponseProxy<DeleteAccountResponse> rpcResponseProxy) {
                super.onSuccess(rpcResponseProxy);
                DeleteAccountResponse content = rpcResponseProxy.getContent();
                ((IVerifyCodeView) CancelCodePresenter.this.view).hideLoading();
                if (content == null) {
                    ((IVerifyCodeView) CancelCodePresenter.this.view).showError((int) R.string.login_unify_net_error);
                } else if (content.errno != 0) {
                    ((IVerifyCodeView) CancelCodePresenter.this.view).showError(TextUtil.isEmpty(content.error) ? CancelCodePresenter.this.context.getString(R.string.login_unify_net_error) : content.error);
                    ((IVerifyCodeView) CancelCodePresenter.this.view).cleanCode();
                } else {
                    ((IVerifyCodeView) CancelCodePresenter.this.view).onFlowFinish(-1);
                }
            }

            public void onFailure(RpcRequest rpcRequest, IOException iOException) {
                super.onFailure(rpcRequest, iOException);
                ((IVerifyCodeView) CancelCodePresenter.this.view).hideLoading();
                ((IVerifyCodeView) CancelCodePresenter.this.view).showError((int) R.string.login_unify_net_error);
                iOException.printStackTrace();
            }
        });
    }
}
