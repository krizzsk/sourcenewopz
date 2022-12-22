package com.didi.unifylogin.flutter.request;

import com.didi.global.fintech.cashier.model.net.request.CashierAction;
import com.didi.unifylogin.base.net.LoginRpcCallbackV2;
import com.didi.unifylogin.base.net.pojo.response.VerifyPersonInfoResponse;
import com.didi.unifylogin.flutter.Result;
import com.didichuxing.foundation.rpc.RpcRequest;
import com.didichuxing.foundation.rpc.RpcResponseProxy;
import com.taxis99.R;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\u00042\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000bH\u0016¨\u0006\f"}, mo175978d2 = {"com/didi/unifylogin/flutter/request/FVerifyPersonalInfo$request$1", "Lcom/didi/unifylogin/base/net/LoginRpcCallbackV2;", "Lcom/didi/unifylogin/base/net/pojo/response/VerifyPersonInfoResponse;", "onFailure", "", "request", "Lcom/didichuxing/foundation/rpc/RpcRequest;", "exception", "Ljava/io/IOException;", "onSuccess", "response", "Lcom/didichuxing/foundation/rpc/RpcResponseProxy;", "OneLogin_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: FVerifyPersonalInfo.kt */
public final class FVerifyPersonalInfo$request$1 extends LoginRpcCallbackV2<VerifyPersonInfoResponse> {
    final /* synthetic */ FVerifyPersonalInfo this$0;

    FVerifyPersonalInfo$request$1(FVerifyPersonalInfo fVerifyPersonalInfo) {
        this.this$0 = fVerifyPersonalInfo;
    }

    public void onSuccess(RpcResponseProxy<VerifyPersonInfoResponse> rpcResponseProxy) {
        Intrinsics.checkParameterIsNotNull(rpcResponseProxy, "response");
        super.onSuccess(rpcResponseProxy);
        if (rpcResponseProxy.getContent() == null) {
            this.this$0.resultSuccess(Result.error());
            return;
        }
        VerifyPersonInfoResponse content = rpcResponseProxy.getContent();
        if (content == null) {
            Intrinsics.throwNpe();
        }
        if (content.errno != 0) {
            this.this$0.resultSuccess(Result.from(content));
            return;
        }
        this.this$0.getMessenger().setLoginMethod(CashierAction.ACTION_PASSWORD);
        FVerifyPersonalInfo fVerifyPersonalInfo = this.this$0;
        fVerifyPersonalInfo.handToken(content, fVerifyPersonalInfo.getResult());
    }

    public void onFailure(RpcRequest rpcRequest, IOException iOException) {
        Intrinsics.checkParameterIsNotNull(rpcRequest, "request");
        Intrinsics.checkParameterIsNotNull(iOException, "exception");
        super.onFailure(rpcRequest, iOException);
        FVerifyPersonalInfo fVerifyPersonalInfo = this.this$0;
        fVerifyPersonalInfo.resultSuccess(Result.error(fVerifyPersonalInfo.getContext().getResources().getString(R.string.login_unify_net_error)));
    }
}
