package com.didi.unifylogin.presenter;

import android.content.Context;
import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.util.TextUtil;
import com.didi.unifylogin.base.model.FragmentMessenger;
import com.didi.unifylogin.base.model.LoginModel;
import com.didi.unifylogin.base.net.LoginRpcCallbackV2;
import com.didi.unifylogin.base.net.pojo.request.GetIdentityParam;
import com.didi.unifylogin.base.net.pojo.response.BaseResponse;
import com.didi.unifylogin.base.presenter.LoginBasePresenter;
import com.didi.unifylogin.presenter.ability.IConfirmPhonePresenter;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.didi.unifylogin.utils.LoginState;
import com.didi.unifylogin.view.ability.IConfirmPhoneView;
import com.didichuxing.foundation.rpc.RpcRequest;
import com.didichuxing.foundation.rpc.RpcResponseProxy;
import com.taxis99.R;
import java.io.IOException;

public class ConfirmPhonePresenter extends LoginBasePresenter<IConfirmPhoneView> implements IConfirmPhonePresenter {
    public ConfirmPhonePresenter(IConfirmPhoneView iConfirmPhoneView, Context context) {
        super(iConfirmPhoneView, context);
    }

    public void getIdentity() {
        ((IConfirmPhoneView) this.view).showLoading((String) null);
        this.messenger.setCell(((IConfirmPhoneView) this.view).getPhone());
        LoginModel.getNet(this.context).getIdentity(new GetIdentityParam(this.context, this.messenger.getSceneNum()).setCell(this.messenger.getCell()), new LoginRpcCallbackV2<BaseResponse>() {
            public void onSuccess(RpcResponseProxy<BaseResponse> rpcResponseProxy) {
                super.onSuccess(rpcResponseProxy);
                BaseResponse content = rpcResponseProxy.getContent();
                ((IConfirmPhoneView) ConfirmPhonePresenter.this.view).hideLoading();
                if (content == null) {
                    ((IConfirmPhoneView) ConfirmPhonePresenter.this.view).showError(ConfirmPhonePresenter.this.context.getString(R.string.login_unify_net_error));
                    return;
                }
                int i = content.errno;
                if (i == 0) {
                    ConfirmPhonePresenter.this.updateOmegaScene(FragmentMessenger.getNowScene());
                    ConfirmPhonePresenter.this.transform(LoginState.STATE_NEW_PHONE);
                } else if (i != 41009) {
                    ((IConfirmPhoneView) ConfirmPhonePresenter.this.view).showError(TextUtil.isEmpty(content.error) ? ConfirmPhonePresenter.this.context.getString(R.string.login_unify_net_error) : content.error);
                } else {
                    ((IConfirmPhoneView) ConfirmPhonePresenter.this.view).showInfoDialog(ConfirmPhonePresenter.this.context.getString(R.string.login_unify_verify_dialog_not_find_account_title), ConfirmPhonePresenter.this.context.getString(R.string.login_unify_verify_dialog_not_find_account_message), ConfirmPhonePresenter.this.context.getString(R.string.login_unify_verify_dialog_know_button), new View.OnClickListener() {
                        public void onClick(View view) {
                            AutoTrackHelper.trackViewOnClick(view);
                            ((IConfirmPhoneView) ConfirmPhonePresenter.this.view).onFlowFinish(0);
                        }
                    });
                    new LoginOmegaUtil(LoginOmegaUtil.PHOECHECK_NOID_SW).send();
                }
            }

            public void onFailure(RpcRequest rpcRequest, IOException iOException) {
                super.onFailure(rpcRequest, iOException);
                ((IConfirmPhoneView) ConfirmPhonePresenter.this.view).hideLoading();
                ((IConfirmPhoneView) ConfirmPhonePresenter.this.view).showError(ConfirmPhonePresenter.this.context.getString(R.string.login_unify_net_error));
            }
        });
    }
}
