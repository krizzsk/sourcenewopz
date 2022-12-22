package com.didi.unifylogin.presenter;

import android.content.Context;
import android.text.TextUtils;
import com.didi.unifylogin.api.LoginPreferredConfig;
import com.didi.unifylogin.base.model.LoginModel;
import com.didi.unifylogin.base.net.LoginRpcCallbackV2;
import com.didi.unifylogin.base.net.pojo.request.VerifyCodeParam;
import com.didi.unifylogin.base.net.pojo.response.VerifyCodeResponse;
import com.didi.unifylogin.utils.LoginChoicePopUtil;
import com.didi.unifylogin.view.ability.IVerifyCodeView;
import com.didichuxing.foundation.rpc.RpcRequest;
import com.didichuxing.foundation.rpc.RpcResponseProxy;
import com.taxis99.R;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VerifyCodeInputCodePresenter extends BaseCodePresenter {
    public VerifyCodeInputCodePresenter(IVerifyCodeView iVerifyCodeView, Context context) {
        super(iVerifyCodeView, context);
    }

    public void updateView() {
        super.updateView();
        String inputCodeTitle = LoginPreferredConfig.getTextAdapter(this.messenger).getInputCodeTitle(this.context);
        if (!TextUtils.isEmpty(inputCodeTitle)) {
            ((IVerifyCodeView) this.view).setTitle(inputCodeTitle);
        }
    }

    public void nextOperate() {
        m32127a();
    }

    /* renamed from: a */
    private void m32127a() {
        this.messenger.setNewCode(((IVerifyCodeView) this.view).getCode());
        String newCell = this.messenger.getNewCell();
        String newCode = this.messenger.getNewCode();
        ((IVerifyCodeView) this.view).showLoading((String) null);
        LoginModel.getNet(this.context).verifyCode(new VerifyCodeParam(this.context, this.messenger.getSceneNum()).setCell(newCell).setCode(newCode), new LoginRpcCallbackV2<VerifyCodeResponse>() {
            public void onSuccess(RpcResponseProxy<VerifyCodeResponse> rpcResponseProxy) {
                super.onSuccess(rpcResponseProxy);
                VerifyCodeResponse content = rpcResponseProxy.getContent();
                ((IVerifyCodeView) VerifyCodeInputCodePresenter.this.view).hideLoading();
                if (content == null) {
                    ((IVerifyCodeView) VerifyCodeInputCodePresenter.this.view).showError((int) R.string.login_unify_net_error);
                } else if (content.errno != 0) {
                    ((IVerifyCodeView) VerifyCodeInputCodePresenter.this.view).showError(TextUtils.isEmpty(content.error) ? VerifyCodeInputCodePresenter.this.context.getString(R.string.login_unify_net_error) : content.error);
                    ((IVerifyCodeView) VerifyCodeInputCodePresenter.this.view).cleanCode();
                } else {
                    VerifyCodeInputCodePresenter.this.messenger.setVerifyCOdeKey(content.access_token);
                    ((IVerifyCodeView) VerifyCodeInputCodePresenter.this.view).onFlowFinish(-1);
                }
            }

            public void onFailure(RpcRequest rpcRequest, IOException iOException) {
                super.onFailure(rpcRequest, iOException);
                ((IVerifyCodeView) VerifyCodeInputCodePresenter.this.view).hideLoading();
                ((IVerifyCodeView) VerifyCodeInputCodePresenter.this.view).showError((int) R.string.login_unify_net_error);
                iOException.printStackTrace();
            }
        });
    }

    public List<LoginChoicePopUtil.ChoiceItem> getChoices() {
        if (this.choiceItems == null) {
            this.choiceItems = new ArrayList();
            if (this.messenger.isVoiceSupport()) {
                this.choiceItems.add(new LoginChoicePopUtil.ChoiceItem(1, this.context.getString(R.string.login_unify_choice_voice)));
            }
        }
        return this.choiceItems;
    }

    public String getPhone() {
        return this.messenger.getNewCell();
    }

    public int getCodeType() {
        return this.messenger.getNewCodeType();
    }

    public void setCodeType(int i) {
        this.messenger.setNewCodeType(i);
    }
}
