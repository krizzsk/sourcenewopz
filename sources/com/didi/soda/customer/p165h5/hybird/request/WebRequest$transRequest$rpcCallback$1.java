package com.didi.soda.customer.p165h5.hybird.request;

import com.didi.onehybrid.jsbridge.CallbackFunction;
import com.didichuxing.foundation.rpc.Rpc;
import com.didichuxing.foundation.rpc.RpcRequest;
import com.didichuxing.foundation.rpc.RpcResponse;
import java.io.IOException;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u001c\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u0003H\u0016¨\u0006\u000b"}, mo175978d2 = {"com/didi/soda/customer/h5/hybird/request/WebRequest$transRequest$rpcCallback$1", "Lcom/didichuxing/foundation/rpc/Rpc$Callback;", "Lcom/didichuxing/foundation/rpc/RpcRequest;", "Lcom/didichuxing/foundation/rpc/RpcResponse;", "onFailure", "", "request", "e", "Ljava/io/IOException;", "onSuccess", "response", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.soda.customer.h5.hybird.request.WebRequest$transRequest$rpcCallback$1 */
/* compiled from: WebRequest.kt */
public final class WebRequest$transRequest$rpcCallback$1 implements Rpc.Callback<RpcRequest, RpcResponse> {
    final /* synthetic */ CallbackFunction $callback;
    final /* synthetic */ WebRequest this$0;

    WebRequest$transRequest$rpcCallback$1(WebRequest webRequest, CallbackFunction callbackFunction) {
        this.this$0 = webRequest;
        this.$callback = callbackFunction;
    }

    public void onSuccess(RpcResponse rpcResponse) {
        this.this$0.m29272a(rpcResponse, this.$callback);
    }

    public void onFailure(RpcRequest rpcRequest, IOException iOException) {
        CallbackFunction callbackFunction = this.$callback;
        if (callbackFunction != null) {
            WebRequest webRequest = this.this$0;
            String message = iOException == null ? null : iOException.getMessage();
            if (message == null) {
                message = "";
            }
            webRequest.m29271a(callbackFunction, message);
        }
    }
}
