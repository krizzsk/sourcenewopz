package global.didi.pay.threeds.network;

import com.didi.dcrypto.util.DCryptoUtils;
import com.didichuxing.foundation.net.rpc.http.HttpRpcInterceptor;
import com.didichuxing.foundation.net.rpc.http.HttpRpcRequest;
import com.didichuxing.foundation.net.rpc.http.HttpRpcResponse;
import com.didichuxing.foundation.rpc.RpcInterceptor;
import global.didi.pay.threeds.method.cybs.Cybs3DS;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006H\u0016¨\u0006\b"}, mo175978d2 = {"Lglobal/didi/pay/threeds/network/ThreedsInterceptor;", "Lcom/didichuxing/foundation/net/rpc/http/HttpRpcInterceptor;", "()V", "intercept", "Lcom/didichuxing/foundation/net/rpc/http/HttpRpcResponse;", "chain", "Lcom/didichuxing/foundation/rpc/RpcInterceptor$RpcChain;", "Lcom/didichuxing/foundation/net/rpc/http/HttpRpcRequest;", "payThreeds_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ThreedsInterceptor.kt */
public final class ThreedsInterceptor implements HttpRpcInterceptor {
    public HttpRpcResponse intercept(RpcInterceptor.RpcChain<HttpRpcRequest, HttpRpcResponse> rpcChain) {
        Intrinsics.checkNotNull(rpcChain);
        HttpRpcResponse proceed = rpcChain.proceed(rpcChain.getRequest().newBuilder().addHeader("appVersion", Cybs3DS.Companion.getAppVersion()).addHeader(DCryptoUtils.PARAMS_KEY_TERMINAL_ID, Cybs3DS.Companion.getTerminalId()).addHeader("sdkVersion", Cybs3DS.Companion.getSdkVersion()).build());
        Intrinsics.checkNotNullExpressionValue(proceed, "chain.proceed(\n            request.newBuilder()\n                .addHeader(\n                    \"appVersion\", Cybs3DS.appVersion\n                ).addHeader(\n                    \"terminalId\", Cybs3DS.terminalId\n                ).addHeader(\n                    \"sdkVersion\", Cybs3DS.sdkVersion\n                )\n                .build()\n        )");
        return proceed;
    }
}
