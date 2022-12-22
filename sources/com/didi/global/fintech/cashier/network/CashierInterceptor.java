package com.didi.global.fintech.cashier.network;

import com.didi.global.fintech.cashier.user.facade.CashierFacade;
import com.didi.global.fintech.cashier.user.facade.CashierInitConfig;
import com.didichuxing.foundation.net.rpc.http.HttpRpcInterceptor;
import com.didichuxing.foundation.net.rpc.http.HttpRpcRequest;
import com.didichuxing.foundation.net.rpc.http.HttpRpcResponse;
import com.didichuxing.foundation.rpc.RpcInterceptor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006H\u0016¨\u0006\b"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/network/CashierInterceptor;", "Lcom/didichuxing/foundation/net/rpc/http/HttpRpcInterceptor;", "()V", "intercept", "Lcom/didichuxing/foundation/net/rpc/http/HttpRpcResponse;", "chain", "Lcom/didichuxing/foundation/rpc/RpcInterceptor$RpcChain;", "Lcom/didichuxing/foundation/net/rpc/http/HttpRpcRequest;", "cashier_network_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CashierInterceptor.kt */
public final class CashierInterceptor implements HttpRpcInterceptor {
    public HttpRpcResponse intercept(RpcInterceptor.RpcChain<HttpRpcRequest, HttpRpcResponse> rpcChain) {
        Intrinsics.checkNotNull(rpcChain);
        CashierInitConfig initConfig = CashierFacade.Companion.getInstance().getInitConfig();
        HttpRpcRequest.Builder newBuilder = rpcChain.getRequest().newBuilder();
        HttpRpcResponse proceed = rpcChain.proceed(newBuilder.addHeader("hintContent", "{ \"lang\": \"" + initConfig.getLanguage() + "\", \"locale\": \"" + initConfig.getLocale() + "\", \"location_cityid\": \"" + initConfig.getCityId() + "\"}").build());
        Intrinsics.checkNotNullExpressionValue(proceed, "chain.proceed(\n         …       .build()\n        )");
        return proceed;
    }
}
