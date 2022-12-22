package com.didi.unifylogin.presenter;

import android.content.Context;
import com.didi.sdk.util.TextUtil;
import com.didi.unifylogin.api.LoginPreferredConfig;
import com.didi.unifylogin.base.model.FragmentMessenger;
import com.didi.unifylogin.base.model.LoginModel;
import com.didi.unifylogin.base.net.LoginRpcCallbackV2;
import com.didi.unifylogin.base.net.pojo.request.DeleteAccountParam;
import com.didi.unifylogin.base.net.pojo.response.DeleteAccountResponse;
import com.didi.unifylogin.base.presenter.LoginBasePresenter;
import com.didi.unifylogin.presenter.ability.ICancelPresenter;
import com.didi.unifylogin.store.LoginStore;
import com.didi.unifylogin.utils.HighlightUtil;
import com.didi.unifylogin.utils.LoginState;
import com.didi.unifylogin.utils.phone.PhoneUtils;
import com.didi.unifylogin.view.ability.ICancelView;
import com.didichuxing.foundation.rpc.RpcRequest;
import com.didichuxing.foundation.rpc.RpcResponseProxy;
import com.taxis99.R;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CancelPresenter extends LoginBasePresenter<ICancelView> implements ICancelPresenter {

    /* renamed from: a */
    List<DeleteAccountResponse.DeleteContent> f44827a;

    /* renamed from: b */
    boolean f44828b = false;

    public CancelPresenter(ICancelView iCancelView, Context context) {
        super(iCancelView, context);
    }

    public void updateView() {
        super.updateView();
        m31842a();
    }

    /* renamed from: a */
    private void m31842a() {
        ((ICancelView) this.view).showLoading((String) null);
        LoginModel.getNet(this.context).deleteAccount(new DeleteAccountParam(this.context, getSceneNum()).setTicket(LoginStore.getInstance().getToken()).setCell(this.messenger.getCell()), new LoginRpcCallbackV2<DeleteAccountResponse>() {
            public void onSuccess(RpcResponseProxy<DeleteAccountResponse> rpcResponseProxy) {
                super.onSuccess(rpcResponseProxy);
                DeleteAccountResponse content = rpcResponseProxy.getContent();
                ((ICancelView) CancelPresenter.this.view).hideLoading();
                if (content == null) {
                    ((ICancelView) CancelPresenter.this.view).showError((int) R.string.login_unify_net_error);
                    return;
                }
                if (!TextUtil.isEmpty(content.getSubTitle())) {
                    ((ICancelView) CancelPresenter.this.view).setSubTitle(content.getSubTitle());
                } else if (!TextUtil.isEmpty(CancelPresenter.this.messenger.getCell())) {
                    ((ICancelView) CancelPresenter.this.view).setSubTitle(CancelPresenter.this.context.getString(R.string.login_unify_str_cancel_account_sub_title, new Object[]{PhoneUtils.hideMiddleDigital(CancelPresenter.this.messenger.getCell())}));
                }
                int i = content.errno;
                if (i == 41000) {
                    CancelPresenter.this.f44828b = false;
                    if (!TextUtil.isEmpty(content.getSubPromptTitle())) {
                        ((ICancelView) CancelPresenter.this.view).setWarnTxt(HighlightUtil.highlight(content.getSubPromptTitle()));
                    } else {
                        ((ICancelView) CancelPresenter.this.view).setWarnTxt(CancelPresenter.this.context.getString(R.string.login_unify_str_cancel_account_warning));
                    }
                    CancelPresenter.this.f44827a = content.getDeleteAccountPromptTexts();
                    if (CancelPresenter.this.f44827a == null) {
                        CancelPresenter cancelPresenter = CancelPresenter.this;
                        cancelPresenter.f44827a = cancelPresenter.m31847c();
                    }
                    if (CancelPresenter.this.f44827a == null) {
                        CancelPresenter cancelPresenter2 = CancelPresenter.this;
                        cancelPresenter2.f44827a = cancelPresenter2.m31845b();
                    }
                    ((ICancelView) CancelPresenter.this.view).updateContents(CancelPresenter.this.f44827a);
                } else if (i != 41006) {
                    ((ICancelView) CancelPresenter.this.view).showError(TextUtil.isEmpty(content.error) ? CancelPresenter.this.context.getString(R.string.login_unify_net_error) : content.error);
                    ((ICancelView) CancelPresenter.this.view).onFlowFinish(0);
                } else if (content.getDeleteAccountFailTexts() != null) {
                    CancelPresenter.this.f44827a = content.getDeleteAccountFailTexts();
                    ((ICancelView) CancelPresenter.this.view).updateContents(CancelPresenter.this.f44827a);
                    if (!TextUtil.isEmpty(content.getSubPromptTitle())) {
                        ((ICancelView) CancelPresenter.this.view).setWarnTxt(content.getSubPromptTitle());
                    } else {
                        ((ICancelView) CancelPresenter.this.view).setWarnTxt(CancelPresenter.this.context.getString(R.string.login_unify_str_cancel_account_error_warning));
                    }
                    ((ICancelView) CancelPresenter.this.view).setNextBtn(CancelPresenter.this.context.getString(R.string.login_unify_str_know_btn));
                    CancelPresenter.this.f44828b = true;
                } else {
                    ((ICancelView) CancelPresenter.this.view).onFlowFinish(0);
                    ((ICancelView) CancelPresenter.this.view).showError((int) R.string.login_unify_net_error);
                }
            }

            public void onFailure(RpcRequest rpcRequest, IOException iOException) {
                super.onFailure(rpcRequest, iOException);
                ((ICancelView) CancelPresenter.this.view).hideLoading();
                ((ICancelView) CancelPresenter.this.view).showError((int) R.string.login_unify_net_error);
                ((ICancelView) CancelPresenter.this.view).onFlowFinish(0);
                iOException.printStackTrace();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public List<DeleteAccountResponse.DeleteContent> m31845b() {
        ArrayList arrayList = new ArrayList();
        m31843a(arrayList, this.context.getString(R.string.login_unify_str_cancel_account_warning_des1));
        m31843a(arrayList, this.context.getString(R.string.login_unify_str_cancel_account_warning_des2));
        m31843a(arrayList, this.context.getString(R.string.login_unify_str_cancel_account_warning_des3));
        m31843a(arrayList, this.context.getString(R.string.login_unify_str_cancel_account_warning_des4));
        m31843a(arrayList, this.context.getString(R.string.login_unify_str_cancel_account_warning_des5));
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public List<DeleteAccountResponse.DeleteContent> m31847c() {
        List<String> cancelDescribes = LoginPreferredConfig.getCancelDescribes();
        if (cancelDescribes == null || cancelDescribes.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String a : cancelDescribes) {
            m31843a(arrayList, a);
        }
        return arrayList;
    }

    /* renamed from: a */
    private void m31843a(List<DeleteAccountResponse.DeleteContent> list, String str) {
        if (!TextUtil.isEmpty(str)) {
            list.add(new DeleteAccountResponse.DeleteContent().setTag(str));
        }
    }

    public void goVerifyCode() {
        updateOmegaScene(FragmentMessenger.getNowScene());
        transform(LoginState.STATE_CODE);
    }

    public void deleteAcc() {
        if (this.f44828b) {
            ((ICancelView) this.view).onFlowFinish(0);
        } else {
            ((ICancelView) this.view).showWarnDialog();
        }
    }
}
