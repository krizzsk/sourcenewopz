package com.didi.unifylogin.flutter.request;

import android.text.TextUtils;
import com.didi.unifylogin.base.model.FragmentMessenger;
import com.didi.unifylogin.base.net.LoginRpcCallbackV2;
import com.didi.unifylogin.base.net.pojo.response.BaseLoginSuccessResponse;
import com.didi.unifylogin.flutter.Result;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.didichuxing.foundation.rpc.RpcRequest;
import com.didichuxing.foundation.rpc.RpcResponseProxy;
import com.taxis99.R;
import java.io.IOException;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u001a\u0010\t\u001a\u00020\u00042\u0010\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u000bH\u0016¨\u0006\f"}, mo175978d2 = {"com/didi/unifylogin/flutter/request/FForgetPassword$request$1", "Lcom/didi/unifylogin/base/net/LoginRpcCallbackV2;", "Lcom/didi/unifylogin/base/net/pojo/response/BaseLoginSuccessResponse;", "onFailure", "", "request", "Lcom/didichuxing/foundation/rpc/RpcRequest;", "exception", "Ljava/io/IOException;", "onSuccess", "proxy", "Lcom/didichuxing/foundation/rpc/RpcResponseProxy;", "OneLogin_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: FForgetPassword.kt */
public final class FForgetPassword$request$1 extends LoginRpcCallbackV2<BaseLoginSuccessResponse> {
    final /* synthetic */ FForgetPassword this$0;

    FForgetPassword$request$1(FForgetPassword fForgetPassword) {
        this.this$0 = fForgetPassword;
    }

    public void onSuccess(RpcResponseProxy<BaseLoginSuccessResponse> rpcResponseProxy) {
        super.onSuccess(rpcResponseProxy);
        BaseLoginSuccessResponse content = rpcResponseProxy != null ? rpcResponseProxy.getContent() : null;
        if (content == null) {
            FForgetPassword fForgetPassword = this.this$0;
            fForgetPassword.resultSuccess(Result.error(fForgetPassword.getContext().getString(R.string.login_unify_net_error)));
            return;
        }
        int i = content.errno;
        if (i == 0) {
            FForgetPassword fForgetPassword2 = this.this$0;
            fForgetPassword2.handToken(content, fForgetPassword2.getResult());
        } else if (i == 41004) {
            this.this$0.updateOmegaScene(FragmentMessenger.getNowScene());
            this.this$0.resultSuccess(Result.from(content));
        } else if (i == 41006) {
            System.out.println("ERRNO_FORBID");
            this.this$0.resultSuccess(Result.from(content));
        } else if (i == 41012) {
            System.out.println("ERRNO_NEED_VERIFY_EMAIL");
            this.this$0.updateOmegaScene(FragmentMessenger.getNowScene());
            this.this$0.resultSuccess(Result.from(content));
        } else if (i != 41015) {
            if (TextUtils.isEmpty(content.error)) {
                content.error = this.this$0.getContext().getString(R.string.login_unify_net_error);
            }
            this.this$0.resultSuccess(Result.from(content));
        } else {
            this.this$0.resultSuccess(Result.from(content));
        }
        new LoginOmegaUtil(LoginOmegaUtil.LOGIN_FAIL_SW).add("errno", Integer.valueOf(content.errno)).send();
    }

    public void onFailure(RpcRequest rpcRequest, IOException iOException) {
        super.onFailure(rpcRequest, iOException);
        FForgetPassword fForgetPassword = this.this$0;
        fForgetPassword.resultSuccess(Result.error(fForgetPassword.getContext().getString(R.string.login_unify_net_error)));
    }
}
