package com.wallet.flutter.wallet_flutter.http;

import com.didi.payment.base.exts.ApplicationContextProvider;
import com.didi.payment.base.flutter.HttpRpcClientConfig;
import com.didichuxing.foundation.net.rpc.http.HttpRpcClient;
import com.didichuxing.foundation.net.rpc.http.HttpRpcClientFactory;
import com.didichuxing.foundation.spi.ServiceLoader;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n"}, mo175978d2 = {"<anonymous>", "Lcom/didichuxing/foundation/net/rpc/http/HttpRpcClient;", "kotlin.jvm.PlatformType"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: WalletFlutterHttpChannel.kt */
final class WalletFlutterHttpChannel$rpcClient$2 extends Lambda implements Function0<HttpRpcClient> {
    public static final WalletFlutterHttpChannel$rpcClient$2 INSTANCE = new WalletFlutterHttpChannel$rpcClient$2();

    WalletFlutterHttpChannel$rpcClient$2() {
        super(0);
    }

    public final HttpRpcClient invoke() {
        HttpRpcClientConfig httpRpcClientConfig;
        HttpRpcClient.Builder newBuilder = new HttpRpcClientFactory().newRpcClient(ApplicationContextProvider.Companion.getContext()).newBuilder();
        ServiceLoader<S> load = ServiceLoader.load(HttpRpcClientConfig.class);
        if (!(load == null || (httpRpcClientConfig = (HttpRpcClientConfig) load.get()) == null)) {
            Intrinsics.checkNotNullExpressionValue(newBuilder, "builder");
            httpRpcClientConfig.config(newBuilder);
        }
        return newBuilder.build();
    }
}
