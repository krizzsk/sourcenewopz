package com.didi.unifylogin.flutter.request;

import android.text.TextUtils;
import com.didi.unifylogin.api.OneLoginFacade;
import com.didi.unifylogin.base.net.LoginNetErrNo;
import com.didi.unifylogin.base.net.LoginRpcCallbackV2;
import com.didi.unifylogin.base.net.pojo.response.SetEmailResponse;
import com.didi.unifylogin.flutter.Result;
import com.didi.unifylogin.store.LoginStore;
import com.didi.unifylogin.utils.LoginLog;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.didichuxing.foundation.rpc.RpcRequest;
import com.didichuxing.foundation.rpc.RpcResponseProxy;
import com.taxis99.R;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0018\u0010\t\u001a\u00020\u00042\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000bH\u0016¨\u0006\f"}, mo175978d2 = {"com/didi/unifylogin/flutter/request/FSetEmail$request$1", "Lcom/didi/unifylogin/base/net/LoginRpcCallbackV2;", "Lcom/didi/unifylogin/base/net/pojo/response/SetEmailResponse;", "onFailure", "", "request", "Lcom/didichuxing/foundation/rpc/RpcRequest;", "exception", "Ljava/io/IOException;", "onSuccess", "proxy", "Lcom/didichuxing/foundation/rpc/RpcResponseProxy;", "OneLogin_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: FSetEmail.kt */
public final class FSetEmail$request$1 extends LoginRpcCallbackV2<SetEmailResponse> {
    final /* synthetic */ FSetEmail this$0;

    FSetEmail$request$1(FSetEmail fSetEmail) {
        this.this$0 = fSetEmail;
    }

    public void onSuccess(RpcResponseProxy<SetEmailResponse> rpcResponseProxy) {
        super.onSuccess(rpcResponseProxy);
        SetEmailResponse content = rpcResponseProxy != null ? rpcResponseProxy.getContent() : null;
        if (content == null) {
            FSetEmail fSetEmail = this.this$0;
            fSetEmail.resultSuccess(Result.error(fSetEmail.getContext().getString(R.string.login_unify_net_error)));
            return;
        }
        int i = content.errno;
        if (i != 0) {
            switch (i) {
                case LoginNetErrNo.ERRNO_INVALID_PROMO_CODE:
                    LoginStore.getInstance().setAndSaveHideEmail(content.email);
                    this.this$0.resultSuccess(Result.from(content));
                    return;
                case 41030:
                    break;
                default:
                    switch (i) {
                        case 41060:
                        case LoginNetErrNo.ERRNO_NEED_CURP_VERIFY:
                            break;
                        case LoginNetErrNo.ERRNO_DANGEROUS_USER:
                            OneLoginFacade.getAction().passiveLogout(this.this$0.getContext(), "setEmailErrNoDangerousUser", "/passport/login/v5/setEmail", "");
                            this.this$0.resultSuccess(Result.from(content));
                            return;
                        default:
                            if (content.errno == 51002) {
                                new LoginOmegaUtil(LoginOmegaUtil.TONE_P_X_EMAIL_REG).send();
                            }
                            this.this$0.resultSuccess(Result.error(!TextUtils.isEmpty(content.error) ? content.error : this.this$0.getContext().getResources().getString(R.string.login_unify_net_error)));
                            return;
                    }
            }
            this.this$0.resultSuccess(Result.from(content));
            return;
        }
        LoginStore.getInstance().setAndSaveHideEmail(content.email);
        LoginStore instance = LoginStore.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance, "LoginStore.getInstance()");
        instance.setFinishInputInfo(true);
        LoginLog.write("InputInfoPresenter: finish");
        this.this$0.resultSuccess(Result.from(content));
    }

    public void onFailure(RpcRequest rpcRequest, IOException iOException) {
        super.onFailure(rpcRequest, iOException);
        FSetEmail fSetEmail = this.this$0;
        fSetEmail.resultSuccess(Result.error(fSetEmail.getContext().getResources().getString(R.string.login_unify_net_error)));
    }
}
