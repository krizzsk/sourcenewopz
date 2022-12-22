package com.didi.unifylogin.presenter;

import android.content.Context;
import com.didi.sdk.util.TextUtil;
import com.didi.unifylogin.api.LoginPreferredConfig;
import com.didi.unifylogin.base.model.FragmentMessenger;
import com.didi.unifylogin.base.model.LoginModel;
import com.didi.unifylogin.base.net.LoginRpcCallbackV2;
import com.didi.unifylogin.base.net.pojo.request.DeleteUserParam;
import com.didi.unifylogin.base.net.pojo.response.DeleteUserResponse;
import com.didi.unifylogin.flutter.LoginLogicManager;
import com.didi.unifylogin.store.LoginStore;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.didi.unifylogin.utils.LoginState;
import com.didi.unifylogin.view.ability.IVerifyCodeView;
import com.didichuxing.foundation.rpc.RpcRequest;
import com.didichuxing.foundation.rpc.RpcResponseProxy;
import com.taxis99.R;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DeleteAccountCodePresenter extends BaseCodePresenter {
    public DeleteAccountCodePresenter(IVerifyCodeView iVerifyCodeView, Context context) {
        super(iVerifyCodeView, context);
    }

    public void nextOperate() {
        ((IVerifyCodeView) this.view).showLoading((String) null);
        List deleteAccountReasons = this.messenger.getDeleteAccountReasons();
        if (deleteAccountReasons == null) {
            deleteAccountReasons = new ArrayList();
        }
        LoginModel.getNet(this.context).deleteUser(new DeleteUserParam(this.context, getSceneNum()).setCell(this.messenger.getCell()).setCode(((IVerifyCodeView) this.view).getCode()).setCodeType(this.messenger.getCodeType()).setTicket(LoginStore.getInstance().getToken()).setDeleteAccountReasons(deleteAccountReasons), new LoginRpcCallbackV2<DeleteUserResponse>() {
            public void onSuccess(RpcResponseProxy<DeleteUserResponse> rpcResponseProxy) {
                super.onSuccess(rpcResponseProxy);
                DeleteUserResponse content = rpcResponseProxy.getContent();
                ((IVerifyCodeView) DeleteAccountCodePresenter.this.view).hideLoading();
                if (content == null) {
                    ((IVerifyCodeView) DeleteAccountCodePresenter.this.view).showError((int) R.string.login_unify_net_error);
                    return;
                }
                int i = content.errno;
                if (i == 0) {
                    ((IVerifyCodeView) DeleteAccountCodePresenter.this.view).onFlowFinish(-1);
                    LoginLogicManager.getMessenger().setCell("");
                    LoginOmegaUtil.trackEvent("ibt_delete_account_success_sw");
                } else if (i != 41006) {
                    ((IVerifyCodeView) DeleteAccountCodePresenter.this.view).showError(TextUtil.isEmpty(content.error) ? DeleteAccountCodePresenter.this.context.getString(R.string.login_unify_net_error) : content.error);
                    ((IVerifyCodeView) DeleteAccountCodePresenter.this.view).cleanCode();
                } else {
                    DeleteAccountCodePresenter.this.m31886a(content.getSubTitle(), content.getSubPromptTitle(), content.getDeleteAccountFailTexts());
                }
            }

            public void onFailure(RpcRequest rpcRequest, IOException iOException) {
                super.onFailure(rpcRequest, iOException);
                ((IVerifyCodeView) DeleteAccountCodePresenter.this.view).hideLoading();
                ((IVerifyCodeView) DeleteAccountCodePresenter.this.view).showError((int) R.string.login_unify_net_error);
                iOException.printStackTrace();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m31886a(String str, String str2, List<DeleteUserResponse.DeleteContent> list) {
        this.messenger.setDeleteAccountFailedSubTitle(str);
        this.messenger.setDeleteAccountFailedSubPromptTitle(str2);
        this.messenger.setDeleteAccountFailTexts(list);
        updateOmegaScene(FragmentMessenger.getNowScene());
        if (LoginPreferredConfig.isDeleteAccountPageUseTextStyle()) {
            transform(LoginState.STATE_DELETE_ACCOUNT_FAILED_TEXT_STYLE);
        } else {
            transform(LoginState.STATE_DELETE_ACCOUNT_FAILED);
        }
    }
}
