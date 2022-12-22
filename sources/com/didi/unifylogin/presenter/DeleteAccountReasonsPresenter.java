package com.didi.unifylogin.presenter;

import android.content.Context;
import com.didi.sdk.util.TextUtil;
import com.didi.unifylogin.base.model.FragmentMessenger;
import com.didi.unifylogin.base.model.LoginModel;
import com.didi.unifylogin.base.net.LoginRpcCallbackV2;
import com.didi.unifylogin.base.net.pojo.request.ListDeleteAccountReasonsParam;
import com.didi.unifylogin.base.net.pojo.response.ListDeleteAccountReasonsResponse;
import com.didi.unifylogin.base.presenter.LoginBasePresenter;
import com.didi.unifylogin.presenter.ability.IDeleteAccountReasonsPresenter;
import com.didi.unifylogin.store.LoginStore;
import com.didi.unifylogin.utils.LoginState;
import com.didi.unifylogin.view.ability.IDeleteAccountReasonsView;
import com.didi.unifylogin.view.adpter.DeleteAccountReasonsAdapter;
import com.didichuxing.foundation.rpc.RpcRequest;
import com.didichuxing.foundation.rpc.RpcResponseProxy;
import com.taxis99.R;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DeleteAccountReasonsPresenter extends LoginBasePresenter<IDeleteAccountReasonsView> implements IDeleteAccountReasonsPresenter {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public List<String> f44831a = new ArrayList();

    public DeleteAccountReasonsPresenter(IDeleteAccountReasonsView iDeleteAccountReasonsView, Context context) {
        super(iDeleteAccountReasonsView, context);
    }

    public void updateView() {
        super.updateView();
        m31917a();
    }

    /* renamed from: a */
    private void m31917a() {
        ((IDeleteAccountReasonsView) this.view).showLoading((String) null);
        LoginModel.getNet(this.context).listDeleteAccountReasons(new ListDeleteAccountReasonsParam(this.context, getSceneNum()).setTicket(LoginStore.getInstance().getToken()), new LoginRpcCallbackV2<ListDeleteAccountReasonsResponse>() {
            public void onSuccess(RpcResponseProxy<ListDeleteAccountReasonsResponse> rpcResponseProxy) {
                super.onSuccess(rpcResponseProxy);
                ListDeleteAccountReasonsResponse content = rpcResponseProxy.getContent();
                ((IDeleteAccountReasonsView) DeleteAccountReasonsPresenter.this.view).hideLoading();
                if (content == null) {
                    ((IDeleteAccountReasonsView) DeleteAccountReasonsPresenter.this.view).showError((int) R.string.login_unify_net_error);
                } else if (content.errno != 0) {
                    ((IDeleteAccountReasonsView) DeleteAccountReasonsPresenter.this.view).showError(TextUtil.isEmpty(content.error) ? DeleteAccountReasonsPresenter.this.context.getString(R.string.login_unify_net_error) : content.error);
                    ((IDeleteAccountReasonsView) DeleteAccountReasonsPresenter.this.view).onFlowFinish(0);
                } else {
                    ((IDeleteAccountReasonsView) DeleteAccountReasonsPresenter.this.view).setTitle(content.getSubTitle());
                    List unused = DeleteAccountReasonsPresenter.this.f44831a = content.getDeleteAccountReasons();
                    if (DeleteAccountReasonsPresenter.this.f44831a == null) {
                        List unused2 = DeleteAccountReasonsPresenter.this.f44831a = new ArrayList();
                    }
                    ArrayList arrayList = new ArrayList();
                    for (String deleteAccountReason : DeleteAccountReasonsPresenter.this.f44831a) {
                        arrayList.add(new DeleteAccountReasonsAdapter.DeleteAccountReason(deleteAccountReason, false));
                    }
                    arrayList.add(new DeleteAccountReasonsAdapter.DeleteAccountReason(DeleteAccountReasonsPresenter.this.context.getString(R.string.Global_Driver_drv_delete_account_Other_cudA), true));
                    ((IDeleteAccountReasonsView) DeleteAccountReasonsPresenter.this.view).updateReasons(arrayList);
                    if (!TextUtil.isEmpty(content.getSubPromptTitle())) {
                        ((IDeleteAccountReasonsView) DeleteAccountReasonsPresenter.this.view).setWarnTxt(content.getSubPromptTitle());
                    }
                }
            }

            public void onFailure(RpcRequest rpcRequest, IOException iOException) {
                super.onFailure(rpcRequest, iOException);
                ((IDeleteAccountReasonsView) DeleteAccountReasonsPresenter.this.view).hideLoading();
                ((IDeleteAccountReasonsView) DeleteAccountReasonsPresenter.this.view).showError((int) R.string.login_unify_net_error);
                ((IDeleteAccountReasonsView) DeleteAccountReasonsPresenter.this.view).onFlowFinish(0);
                iOException.printStackTrace();
            }
        });
    }

    public void goVerifyCode() {
        this.messenger.setDeleteAccountReasons(((IDeleteAccountReasonsView) this.view).getSelectedReasons());
        updateOmegaScene(FragmentMessenger.getNowScene());
        transform(LoginState.STATE_CODE);
    }

    public void deleteAcc() {
        ((IDeleteAccountReasonsView) this.view).showWarnDialog();
    }

    public void goDeleteAccountFailed() {
        updateOmegaScene(FragmentMessenger.getNowScene());
        transform(LoginState.STATE_DELETE_ACCOUNT_FAILED);
    }
}
