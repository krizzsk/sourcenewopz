package com.didiglobal.ibg_rpc_service.internal;

import com.didichuxing.foundation.net.rpc.http.HttpRpcClient;
import com.didichuxing.foundation.net.rpc.http.HttpRpcClientFactory;
import com.didiglobal.ibg_rpc_service.HttpRpcClientConfig;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n"}, mo175978d2 = {"<anonymous>", "Lcom/didichuxing/foundation/net/rpc/http/HttpRpcClient;", "kotlin.jvm.PlatformType"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: HttpClient.kt */
final class HttpClient$client$2 extends Lambda implements Function0<HttpRpcClient> {
    public static final HttpClient$client$2 INSTANCE = new HttpClient$client$2();

    HttpClient$client$2() {
        super(0);
    }

    public final HttpRpcClient invoke() {
        HttpClient httpClient = HttpClient.INSTANCE;
        HttpClient.f50248d = true;
        HttpRpcClient.Builder newBuilder = new HttpRpcClientFactory().newRpcClient(HttpClient.INSTANCE.m36204a()).newBuilder();
        HttpRpcClientConfig access$getConfig = HttpClient.INSTANCE.m36206b();
        if (access$getConfig != null) {
            Intrinsics.checkNotNullExpressionValue(newBuilder, "this");
            access$getConfig.config(newBuilder);
        }
        return newBuilder.build();
    }
}
