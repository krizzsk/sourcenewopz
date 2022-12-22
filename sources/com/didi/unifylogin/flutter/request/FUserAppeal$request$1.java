package com.didi.unifylogin.flutter.request;

import com.didi.unifylogin.base.net.LoginRpcCallbackV2;
import com.didi.unifylogin.base.net.pojo.response.NewUserAppealResponse;
import com.didi.unifylogin.flutter.Result;
import com.didichuxing.foundation.rpc.RpcRequest;
import com.didichuxing.foundation.rpc.RpcResponseProxy;
import com.taxis99.R;
import java.io.IOException;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u001a\u0010\t\u001a\u00020\u00042\u0010\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u000bH\u0016¨\u0006\f"}, mo175978d2 = {"com/didi/unifylogin/flutter/request/FUserAppeal$request$1", "Lcom/didi/unifylogin/base/net/LoginRpcCallbackV2;", "Lcom/didi/unifylogin/base/net/pojo/response/NewUserAppealResponse;", "onFailure", "", "request", "Lcom/didichuxing/foundation/rpc/RpcRequest;", "exception", "Ljava/io/IOException;", "onSuccess", "response", "Lcom/didichuxing/foundation/rpc/RpcResponseProxy;", "OneLogin_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: FUserAppeal.kt */
public final class FUserAppeal$request$1 extends LoginRpcCallbackV2<NewUserAppealResponse> {
    final /* synthetic */ FUserAppeal this$0;

    FUserAppeal$request$1(FUserAppeal fUserAppeal) {
        this.this$0 = fUserAppeal;
    }

    public void onSuccess(RpcResponseProxy<NewUserAppealResponse> rpcResponseProxy) {
        super.onSuccess(rpcResponseProxy);
        this.this$0.resultSuccess(Result.from(rpcResponseProxy != null ? rpcResponseProxy.getContent() : null));
    }

    public void onFailure(RpcRequest rpcRequest, IOException iOException) {
        super.onFailure(rpcRequest, iOException);
        FUserAppeal fUserAppeal = this.this$0;
        fUserAppeal.resultSuccess(Result.error(fUserAppeal.getContext().getResources().getString(R.string.login_unify_net_error)));
    }
}
