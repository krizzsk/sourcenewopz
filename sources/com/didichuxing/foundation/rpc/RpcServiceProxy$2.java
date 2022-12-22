package com.didichuxing.foundation.rpc;

import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.foundation.rpc.Rpc;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.annotation.ThreadType;
import java.io.IOException;

class RpcServiceProxy$2 implements Rpc.Callback<RpcRequest, RpcResponse> {
    final /* synthetic */ C15585c this$0;
    final /* synthetic */ RpcService.CallbackV2 val$callback;
    final /* synthetic */ ThreadType val$threadType;

    RpcServiceProxy$2(C15585c cVar, ThreadType threadType, RpcService.CallbackV2 callbackV2) {
        this.this$0 = cVar;
        this.val$threadType = threadType;
        this.val$callback = callbackV2;
    }

    public void onSuccess(final RpcResponse rpcResponse) {
        try {
            final RpcResponseProxy rpcResponseProxy = new RpcResponseProxy(rpcResponse);
            if (RpcServiceProxy$5.$SwitchMap$com$didichuxing$foundation$rpc$annotation$ThreadType[this.val$threadType.ordinal()] != 1) {
                try {
                    this.val$callback.onSuccess(rpcResponseProxy);
                } catch (Throwable th) {
                    onFailure(rpcResponse.getRequest(), new IOException(th));
                }
            } else {
                this.this$0.f47639g.post(new Runnable() {
                    public void run() {
                        try {
                            RpcServiceProxy$2.this.val$callback.onSuccess(rpcResponseProxy);
                        } catch (Throwable th) {
                            RpcServiceProxy$2.this.onFailure(rpcResponse.getRequest(), new IOException(th));
                        }
                    }
                });
            }
        } catch (IOException e) {
            onFailure(rpcResponse.getRequest(), e);
        } catch (Throwable th2) {
            onFailure(rpcResponse.getRequest(), new IOException(th2));
        }
    }

    public void onFailure(final RpcRequest rpcRequest, final IOException iOException) {
        if (C15583a.f47621a) {
            SystemUtils.log(6, "RpcServiceProxy", rpcRequest.getUrl(), iOException, "com.didichuxing.foundation.rpc.RpcServiceProxy$2", 288);
        }
        if (RpcServiceProxy$5.$SwitchMap$com$didichuxing$foundation$rpc$annotation$ThreadType[this.val$threadType.ordinal()] != 1) {
            this.val$callback.onFailure(rpcRequest, iOException);
        } else {
            this.this$0.f47639g.post(new Runnable() {
                public void run() {
                    RpcServiceProxy$2.this.val$callback.onFailure(rpcRequest, iOException);
                }
            });
        }
    }
}
