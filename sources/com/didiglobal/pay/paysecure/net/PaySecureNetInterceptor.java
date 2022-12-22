package com.didiglobal.pay.paysecure.net;

import com.didichuxing.foundation.net.rpc.http.HttpRpcInterceptor;
import com.didichuxing.foundation.net.rpc.http.HttpRpcRequest;
import com.didichuxing.foundation.net.rpc.http.HttpRpcResponse;
import com.didichuxing.foundation.rpc.RpcInterceptor;
import com.didiglobal.pay.paysecure.PaySecure;
import com.didiglobal.pay.paysecure.PaySecureNetParamListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006H\u0016¨\u0006\b"}, mo175978d2 = {"Lcom/didiglobal/pay/paysecure/net/PaySecureNetInterceptor;", "Lcom/didichuxing/foundation/net/rpc/http/HttpRpcInterceptor;", "()V", "intercept", "Lcom/didichuxing/foundation/net/rpc/http/HttpRpcResponse;", "chain", "Lcom/didichuxing/foundation/rpc/RpcInterceptor$RpcChain;", "Lcom/didichuxing/foundation/net/rpc/http/HttpRpcRequest;", "paysecure_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: PaySecureNetInterceptor.kt */
public final class PaySecureNetInterceptor implements HttpRpcInterceptor {
    public HttpRpcResponse intercept(RpcInterceptor.RpcChain<HttpRpcRequest, HttpRpcResponse> rpcChain) {
        if (rpcChain == null) {
            Intrinsics.throwNpe();
        }
        PaySecureNetParamListener netParamListener = PaySecure.INSTANCE.getConfig().getNetParamListener();
        HttpRpcRequest.Builder addHeader = rpcChain.getRequest().newBuilder().addHeader("hintCode", "0");
        HttpRpcResponse proceed = rpcChain.proceed(addHeader.addHeader("hintContent", "{ \"app_timeout_ms\": 20000," + " \"lang\": \"" + netParamListener.getLanguage() + "\"," + " \"lat\": " + netParamListener.getLat() + ',' + " \"lng\": " + netParamListener.getLng() + ',' + " \"locale\": \"" + netParamListener.getLocale() + "\"," + " \"location_cityid\": \"" + netParamListener.getCityId() + "\"," + " \"location_country\": \"" + netParamListener.getCountry() + "\"," + " \"product_id\": \"" + netParamListener.getProductId() + "\", " + " \"trip_cityid\": \"" + netParamListener.getCityId() + "\"," + " \"trip_country\": \"" + netParamListener.getCountry() + "\"," + " \"utc_offset\": " + netParamListener.getUtcOffset(PaySecure.INSTANCE.getAppContext()) + ',' + " \"sample\": {" + " \"code\": 128" + " }" + "}").addHeader("caller", "wallet").build());
        Intrinsics.checkExpressionValueIsNotNull(proceed, "chain.proceed(\n         …       .build()\n        )");
        return proceed;
    }
}
