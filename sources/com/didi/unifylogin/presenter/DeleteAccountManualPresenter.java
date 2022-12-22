package com.didi.unifylogin.presenter;

import android.content.Context;
import com.didi.sdk.util.TextUtil;
import com.didi.unifylogin.base.model.FragmentMessenger;
import com.didi.unifylogin.base.model.LoginModel;
import com.didi.unifylogin.base.net.LoginRpcCallbackV2;
import com.didi.unifylogin.base.net.pojo.request.GetDeleteAccountManualParam;
import com.didi.unifylogin.base.net.pojo.response.GetDeleteAccountManualResponse;
import com.didi.unifylogin.base.presenter.LoginBasePresenter;
import com.didi.unifylogin.presenter.ability.IDeleteAccountManualPresenter;
import com.didi.unifylogin.store.LoginStore;
import com.didi.unifylogin.utils.LoginState;
import com.didi.unifylogin.utils.phone.PhoneUtils;
import com.didi.unifylogin.view.ability.IDeleteAccountManualView;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.foundation.rpc.RpcRequest;
import com.didichuxing.foundation.rpc.RpcResponseProxy;
import com.taxis99.R;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DeleteAccountManualPresenter extends LoginBasePresenter<IDeleteAccountManualView> implements IDeleteAccountManualPresenter {

    /* renamed from: a */
    List<GetDeleteAccountManualResponse.DeleteContent> f44829a;

    /* renamed from: b */
    boolean f44830b = false;

    public DeleteAccountManualPresenter(IDeleteAccountManualView iDeleteAccountManualView, Context context) {
        super(iDeleteAccountManualView, context);
    }

    public void updateView() {
        super.updateView();
        m31895a();
    }

    /* renamed from: a */
    private void m31895a() {
        ((IDeleteAccountManualView) this.view).showLoading((String) null);
        LoginModel.getNet(this.context).getDeleteAccountManual(new GetDeleteAccountManualParam(this.context, getSceneNum()).setTicket(LoginStore.getInstance().getToken()), new LoginRpcCallbackV2<GetDeleteAccountManualResponse>() {
            public void onSuccess(RpcResponseProxy<GetDeleteAccountManualResponse> rpcResponseProxy) {
                super.onSuccess(rpcResponseProxy);
                GetDeleteAccountManualResponse content = rpcResponseProxy.getContent();
                ((IDeleteAccountManualView) DeleteAccountManualPresenter.this.view).hideLoading();
                if (content == null) {
                    ((IDeleteAccountManualView) DeleteAccountManualPresenter.this.view).showError((int) R.string.login_unify_net_error);
                    return;
                }
                if (!TextUtil.isEmpty(content.getSubTitle())) {
                    ((IDeleteAccountManualView) DeleteAccountManualPresenter.this.view).setTitle(content.getSubTitle());
                } else if (!TextUtil.isEmpty(DeleteAccountManualPresenter.this.messenger.getCell())) {
                    ((IDeleteAccountManualView) DeleteAccountManualPresenter.this.view).setTitle(DeleteAccountManualPresenter.this.context.getString(R.string.login_unify_str_cancel_account_sub_title, new Object[]{PhoneUtils.hideMiddleDigital(DeleteAccountManualPresenter.this.messenger.getCell())}));
                }
                if (content.errno != 0) {
                    ((IDeleteAccountManualView) DeleteAccountManualPresenter.this.view).showError(TextUtil.isEmpty(content.error) ? DeleteAccountManualPresenter.this.context.getString(R.string.login_unify_net_error) : content.error);
                    ((IDeleteAccountManualView) DeleteAccountManualPresenter.this.view).onFlowFinish(0);
                    return;
                }
                DeleteAccountManualPresenter.this.f44830b = false;
                if (!TextUtil.isEmpty(content.getSubPromptTitle())) {
                    ((IDeleteAccountManualView) DeleteAccountManualPresenter.this.view).setSubTitle(content.getSubPromptTitle());
                } else {
                    ((IDeleteAccountManualView) DeleteAccountManualPresenter.this.view).setSubTitle(DeleteAccountManualPresenter.this.context.getString(R.string.login_unify_str_cancel_account_warning));
                }
                ((IDeleteAccountManualView) DeleteAccountManualPresenter.this.view).setWarnTxt(content.getDeleteAccountWarning());
                DeleteAccountManualPresenter.this.f44829a = content.getDeleteAccountPromptTexts();
                ((IDeleteAccountManualView) DeleteAccountManualPresenter.this.view).updateContents(DeleteAccountManualPresenter.this.f44829a);
            }

            public void onFailure(RpcRequest rpcRequest, IOException iOException) {
                super.onFailure(rpcRequest, iOException);
                ((IDeleteAccountManualView) DeleteAccountManualPresenter.this.view).hideLoading();
                ((IDeleteAccountManualView) DeleteAccountManualPresenter.this.view).showError((int) R.string.login_unify_net_error);
                ((IDeleteAccountManualView) DeleteAccountManualPresenter.this.view).onFlowFinish(0);
                iOException.printStackTrace();
            }
        });
    }

    /* renamed from: a */
    private void m31896a(List<GetDeleteAccountManualResponse.DeleteContent> list, String str) {
        if (!TextUtil.isEmpty(str)) {
            list.add(new GetDeleteAccountManualResponse.DeleteContent().setTag(str));
        }
    }

    /* renamed from: b */
    private boolean m31898b() {
        return Apollo.getToggle("delete_reason", false).allow();
    }

    public void goVerifyCode() {
        this.messenger.setDeleteAccountReasons(new ArrayList());
        updateOmegaScene(FragmentMessenger.getNowScene());
        transform(LoginState.STATE_CODE);
    }

    public void deleteAcc() {
        if (m31898b()) {
            goDeleteAccountReasons();
        } else {
            ((IDeleteAccountManualView) this.view).showWarnDialog();
        }
    }

    public void goDeleteAccountReasons() {
        updateOmegaScene(FragmentMessenger.getNowScene());
        transform(LoginState.STATE_DELETE_ACCOUNT_REASON);
    }
}
