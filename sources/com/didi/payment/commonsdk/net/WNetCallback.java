package com.didi.payment.commonsdk.net;

import com.didichuxing.foundation.rpc.RpcService;
import java.io.IOException;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016J\u0015\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\f¨\u0006\r"}, mo175978d2 = {"Lcom/didi/payment/commonsdk/net/WNetCallback;", "T", "Lcom/didichuxing/foundation/rpc/RpcService$Callback;", "()V", "onComplete", "", "onFailure", "exception", "Ljava/io/IOException;", "onStart", "onSuccess", "response", "(Ljava/lang/Object;)V", "wallet-service-commonsdk_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: WNetCallback.kt */
public abstract class WNetCallback<T> implements RpcService.Callback<T> {
    public void onComplete() {
    }

    public void onStart() {
    }

    public WNetCallback() {
        onStart();
    }

    public void onSuccess(T t) {
        onComplete();
    }

    public void onFailure(IOException iOException) {
        onComplete();
    }
}
