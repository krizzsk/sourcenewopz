package com.didi.unifylogin.third;

import android.content.Context;
import com.didi.unifylogin.base.net.LoginRpcCallbackV2;
import com.didi.unifylogin.base.net.pojo.response.LoginTypeResponse;
import com.didichuxing.foundation.rpc.RpcRequest;
import com.didichuxing.foundation.rpc.RpcResponseProxy;
import java.io.IOException;
import java.util.List;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0018\u0010\t\u001a\u00020\u00042\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000bH\u0016¨\u0006\f"}, mo175978d2 = {"com/didi/unifylogin/third/LoginTypeManager$requestLoginType$1", "Lcom/didi/unifylogin/base/net/LoginRpcCallbackV2;", "Lcom/didi/unifylogin/base/net/pojo/response/LoginTypeResponse;", "onFailure", "", "request", "Lcom/didichuxing/foundation/rpc/RpcRequest;", "exception", "Ljava/io/IOException;", "onSuccess", "response", "Lcom/didichuxing/foundation/rpc/RpcResponseProxy;", "OneLogin_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: LoginTypeManager.kt */
public final class LoginTypeManager$requestLoginType$1 extends LoginRpcCallbackV2<LoginTypeResponse> {
    final /* synthetic */ Context $context;
    final /* synthetic */ LoginTypeListListener $listener;

    LoginTypeManager$requestLoginType$1(Context context, LoginTypeListListener loginTypeListListener) {
        this.$context = context;
        this.$listener = loginTypeListListener;
    }

    public void onSuccess(RpcResponseProxy<LoginTypeResponse> rpcResponseProxy) {
        List<String> loginTypeList;
        LoginTypeListListener loginTypeListListener;
        super.onSuccess(rpcResponseProxy);
        LoginTypeResponse content = rpcResponseProxy != null ? rpcResponseProxy.getContent() : null;
        LoginTypeManager.INSTANCE.m32197a(this.$context, content);
        if (content != null && (loginTypeList = content.getLoginTypeList()) != null && (loginTypeListListener = this.$listener) != null) {
            loginTypeListListener.onResult(loginTypeList);
        }
    }

    public void onFailure(RpcRequest rpcRequest, IOException iOException) {
        super.onFailure(rpcRequest, iOException);
    }
}
