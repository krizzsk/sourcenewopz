package com.didi.wallet.dimina.rpc;

import android.net.Uri;
import com.didi.raven.config.RavenKey;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didi.wallet.dimina.util.WalletDiminaUtilKt;
import com.didichuxing.foundation.net.rpc.http.HttpRpcRequest;
import com.didichuxing.foundation.net.rpc.http.HttpRpcResponse;
import com.didichuxing.foundation.rpc.RpcInterceptor;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import didihttp.HttpUrl;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@ServiceProvider(priority = 1000, value = {RpcInterceptor.class})
@Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \b2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\bB\u0005¢\u0006\u0002\u0010\u0004J\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0007H\u0016¨\u0006\t"}, mo175978d2 = {"Lcom/didi/wallet/dimina/rpc/DiminaInterceptor;", "Lcom/didichuxing/foundation/rpc/RpcInterceptor;", "Lcom/didichuxing/foundation/net/rpc/http/HttpRpcRequest;", "Lcom/didichuxing/foundation/net/rpc/http/HttpRpcResponse;", "()V", "intercept", "chain", "Lcom/didichuxing/foundation/rpc/RpcInterceptor$RpcChain;", "Companion", "wallet-service-dimina_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: DiminaInterceptor.kt */
public final class DiminaInterceptor implements RpcInterceptor<HttpRpcRequest, HttpRpcResponse> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private static final String f45175a = "s3-us01.didiglobal.com";

    /* renamed from: b */
    private static final String f45176b = "X-Amz-";

    public HttpRpcResponse intercept(RpcInterceptor.RpcChain<HttpRpcRequest, HttpRpcResponse> rpcChain) {
        RpcInterceptor.RpcChain<HttpRpcRequest, HttpRpcResponse> rpcChain2 = rpcChain;
        Intrinsics.checkNotNullParameter(rpcChain2, "chain");
        HttpRpcRequest request = rpcChain.getRequest();
        String url = request.getUrl();
        try {
            Intrinsics.checkNotNullExpressionValue(url, "tempUrl");
            if (StringsKt.contains$default((CharSequence) url, (CharSequence) f45175a, false, 2, (Object) null) && StringsKt.contains$default((CharSequence) url, (CharSequence) f45176b, false, 2, (Object) null)) {
                String substring = url.substring(0, StringsKt.indexOf$default((CharSequence) url, '?', 0, false, 6, (Object) null));
                Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                Uri parse = Uri.parse(url);
                String str = "";
                Set<String> queryParameterNames = parse.getQueryParameterNames();
                Intrinsics.checkNotNullExpressionValue(queryParameterNames, "uri.queryParameterNames");
                int i = 0;
                for (Object next : queryParameterNames) {
                    int i2 = i + 1;
                    if (i < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    String str2 = (String) next;
                    Intrinsics.checkNotNullExpressionValue(str2, RavenKey.STACK);
                    if (StringsKt.contains$default((CharSequence) str2, (CharSequence) f45176b, false, 2, (Object) null)) {
                        String queryParameter = parse.getQueryParameter(str2);
                        StringBuilder sb = new StringBuilder();
                        sb.append(str);
                        sb.append(i == 0 ? "?" : ParamKeys.SIGN_AND);
                        sb.append(str2);
                        sb.append('=');
                        sb.append(queryParameter);
                        str = sb.toString();
                    }
                    i = i2;
                }
                HttpRpcRequest.Builder newBuilder = request.newBuilder();
                newBuilder.setUrl(HttpUrl.parse(Intrinsics.stringPlus(substring, str)).newBuilder().build().toString());
                request = newBuilder.build();
            }
        } catch (Exception unused) {
            WalletDiminaUtilKt.logWD(Intrinsics.stringPlus("s3域名拦截 --- 域名重新拼接失败 url： ", url));
        }
        return rpcChain2.proceed(request);
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo175978d2 = {"Lcom/didi/wallet/dimina/rpc/DiminaInterceptor$Companion;", "", "()V", "uu", "", "uuKey", "wallet-service-dimina_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: DiminaInterceptor.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
