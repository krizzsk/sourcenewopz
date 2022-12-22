package com.didichuxing.foundation.rpc;

import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.foundation.rpc.Rpc;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.annotation.ThreadType;
import java.io.IOException;

class RpcServiceProxy$1 implements Rpc.Callback<RpcRequest, RpcResponse> {
    final /* synthetic */ C15585c this$0;
    final /* synthetic */ RpcService.Callback val$callback;
    final /* synthetic */ ThreadType val$threadType;

    RpcServiceProxy$1(C15585c cVar, ThreadType threadType, RpcService.Callback callback) {
        this.this$0 = cVar;
        this.val$threadType = threadType;
        this.val$callback = callback;
    }

    public void onSuccess(final RpcResponse rpcResponse) {
        try {
            final Object content = rpcResponse.getContent();
            if (RpcServiceProxy$5.$SwitchMap$com$didichuxing$foundation$rpc$annotation$ThreadType[this.val$threadType.ordinal()] != 1) {
                try {
                    this.val$callback.onSuccess(content);
                } catch (Throwable th) {
                    this.this$0.m34096a(rpcResponse.getRequest(), (RpcService.Callback<Object>) this.val$callback, new IOException(th));
                }
            } else {
                this.this$0.f47639g.post(new Runnable() {
                    public void run() {
                        try {
                            RpcServiceProxy$1.this.val$callback.onSuccess(content);
                        } catch (Throwable th) {
                            RpcServiceProxy$1.this.this$0.m34096a(rpcResponse.getRequest(), (RpcService.Callback<Object>) RpcServiceProxy$1.this.val$callback, new IOException(th));
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

    public void onFailure(RpcRequest rpcRequest, final IOException iOException) {
        if (C15583a.f47621a) {
            SystemUtils.log(6, "RpcServiceProxy", rpcRequest.getUrl(), iOException, "com.didichuxing.foundation.rpc.RpcServiceProxy$1", 231);
        }
        if (RpcServiceProxy$5.$SwitchMap$com$didichuxing$foundation$rpc$annotation$ThreadType[this.val$threadType.ordinal()] != 1) {
            this.val$callback.onFailure(iOException);
        } else {
            this.this$0.f47639g.post(new Runnable() {
                public void run() {
                    RpcServiceProxy$1.this.val$callback.onFailure(iOException);
                }
            });
        }
    }
}
