package com.didi.unifylogin.utils.simplifycode;

import android.content.Context;
import android.text.TextUtils;
import com.didi.unifylogin.base.net.LoginRpcCallbackV2;
import com.didi.unifylogin.base.net.pojo.response.BaseResponse;
import com.didi.unifylogin.base.view.AbsLoginBaseActivity;
import com.didi.unifylogin.base.view.ability.ILoginBaseFragment;
import com.didi.unifylogin.store.LoginStore;
import com.didi.unifylogin.utils.NetworkUtil;
import com.didichuxing.foundation.rpc.RpcRequest;
import com.didichuxing.foundation.rpc.RpcResponseProxy;
import com.taxis99.R;
import java.io.IOException;

public abstract class LoginServiceCallbackV2<T extends BaseResponse> extends LoginRpcCallbackV2<T> {
    private ILoginBaseFragment callbackView;
    private Context context;
    private boolean isAuto = true;

    /* access modifiers changed from: protected */
    public abstract void handleError(RpcRequest rpcRequest);

    /* access modifiers changed from: protected */
    public abstract boolean handleResponse(T t, int i, String str);

    public LoginServiceCallbackV2(ILoginBaseFragment iLoginBaseFragment) {
        init(iLoginBaseFragment, true);
    }

    public LoginServiceCallbackV2(ILoginBaseFragment iLoginBaseFragment, boolean z) {
        init(iLoginBaseFragment, z);
    }

    public void init(ILoginBaseFragment iLoginBaseFragment, boolean z) {
        this.callbackView = iLoginBaseFragment;
        this.isAuto = z;
        AbsLoginBaseActivity baseActivity = iLoginBaseFragment.getBaseActivity();
        if (baseActivity != null) {
            this.context = baseActivity.getApplicationContext();
        } else {
            this.context = LoginStore.getContext();
        }
    }

    public void onSuccess(RpcResponseProxy<T> rpcResponseProxy) {
        String str;
        super.onSuccess(rpcResponseProxy);
        if (this.isAuto) {
            this.callbackView.hideLoading();
        }
        if (rpcResponseProxy == null || rpcResponseProxy.getContent() == null) {
            this.callbackView.showError((int) R.string.login_unify_net_error);
            return;
        }
        BaseResponse baseResponse = (BaseResponse) rpcResponseProxy.getContent();
        if (!handleResponse(baseResponse, rpcResponseProxy.getStatus(), NetworkUtil.getHeader(rpcResponseProxy.getHeaders(), "didi-header-rid"))) {
            ILoginBaseFragment iLoginBaseFragment = this.callbackView;
            if (!TextUtils.isEmpty(baseResponse.error)) {
                str = baseResponse.error;
            } else {
                str = this.context.getResources().getString(R.string.login_unify_net_error);
            }
            iLoginBaseFragment.showError(str);
        }
    }

    public void onFailure(RpcRequest rpcRequest, IOException iOException) {
        super.onFailure(rpcRequest, iOException);
        this.callbackView.hideLoading();
        this.callbackView.showError((int) R.string.login_unify_net_error);
        handleError(rpcRequest);
    }
}
