package com.didi.unifylogin.presenter;

import android.content.Context;
import android.text.TextUtils;
import com.didi.unifylogin.base.model.LoginModel;
import com.didi.unifylogin.base.net.LoginRpcCallbackV2;
import com.didi.unifylogin.base.net.pojo.request.SetCellParam;
import com.didi.unifylogin.base.net.pojo.response.SetCellResponse;
import com.didi.unifylogin.store.LoginStore;
import com.didi.unifylogin.view.ability.IVerifyCodeView;
import com.didichuxing.foundation.rpc.RpcRequest;
import com.didichuxing.foundation.rpc.RpcResponseProxy;
import com.taxis99.R;
import java.io.IOException;

public class SetPhoneCodePresenter extends BaseCodePresenter {
    public SetPhoneCodePresenter(IVerifyCodeView iVerifyCodeView, Context context) {
        super(iVerifyCodeView, context);
    }

    public void updateView() {
        super.updateView();
        ((IVerifyCodeView) this.view).setTitle(this.context.getString(R.string.login_unify_input_old_cell_code));
    }

    public void nextOperate() {
        ((IVerifyCodeView) this.view).showLoading((String) null);
        this.messenger.setCode(((IVerifyCodeView) this.view).getCode());
        SetCellParam ticket = new SetCellParam(this.context, getSceneNum()).setCell(this.messenger.getCell()).setCode(this.messenger.getCode()).setCodeType(this.messenger.getCodeType()).setNewCell(this.messenger.getNewCell()).setNewCode(this.messenger.getNewCode()).setNewCodeType(this.messenger.getNewCodeType()).setTicket(LoginStore.getInstance().getToken());
        if (this.messenger.getNewCellCountry() != null) {
            ticket.setNewCellCountryCallingCode(this.messenger.getNewCellCountry().calling_code);
        }
        LoginModel.getNet(this.context).setCell(ticket, new LoginRpcCallbackV2<SetCellResponse>() {
            public void onSuccess(RpcResponseProxy<SetCellResponse> rpcResponseProxy) {
                String str;
                super.onSuccess(rpcResponseProxy);
                SetCellResponse content = rpcResponseProxy.getContent();
                ((IVerifyCodeView) SetPhoneCodePresenter.this.view).hideLoading();
                if (content == null) {
                    ((IVerifyCodeView) SetPhoneCodePresenter.this.view).showError(SetPhoneCodePresenter.this.context.getResources().getString(R.string.login_unify_net_error));
                } else if (content.errno != 0) {
                    IVerifyCodeView iVerifyCodeView = (IVerifyCodeView) SetPhoneCodePresenter.this.view;
                    if (!TextUtils.isEmpty(content.error)) {
                        str = content.error;
                    } else {
                        str = SetPhoneCodePresenter.this.context.getResources().getString(R.string.login_unify_net_error);
                    }
                    iVerifyCodeView.showError(str);
                    ((IVerifyCodeView) SetPhoneCodePresenter.this.view).cleanCode();
                } else {
                    ((IVerifyCodeView) SetPhoneCodePresenter.this.view).onFlowFinish(-1);
                }
            }

            public void onFailure(RpcRequest rpcRequest, IOException iOException) {
                super.onFailure(rpcRequest, iOException);
                ((IVerifyCodeView) SetPhoneCodePresenter.this.view).hideLoading();
                ((IVerifyCodeView) SetPhoneCodePresenter.this.view).showError(SetPhoneCodePresenter.this.context.getResources().getString(R.string.login_unify_net_error));
            }
        });
    }
}
