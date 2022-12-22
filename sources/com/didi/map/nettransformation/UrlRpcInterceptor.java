package com.didi.map.nettransformation;

import android.text.TextUtils;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.foundation.net.rpc.http.HttpRpcRequest;
import com.didichuxing.foundation.net.rpc.http.HttpRpcResponse;
import com.didichuxing.foundation.rpc.RpcInterceptor;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Deprecated
public class UrlRpcInterceptor implements RpcInterceptor<HttpRpcRequest, HttpRpcResponse> {

    /* renamed from: a */
    private static final String f27840a = "https";

    /* renamed from: b */
    private static final String f27841b = "http";

    /* renamed from: c */
    private static final String f27842c = "net_transform_https2http";

    /* renamed from: d */
    private static final Set<String> f27843d = new HashSet();

    public HttpRpcResponse intercept(RpcInterceptor.RpcChain<HttpRpcRequest, HttpRpcResponse> rpcChain) throws IOException {
        HttpRpcRequest request = rpcChain.getRequest();
        return rpcChain.proceed(request.newBuilder().setUrl(transformUrl2Http(request.getUrl())).build());
    }

    public static String transformUrl2Http(String str) {
        return (TextUtils.isEmpty(str) || str.length() < 8 || !Apollo.getToggle("net_transform_https2http").allow()) ? str : str.replaceFirst("https", "http");
    }

    /* renamed from: a */
    private static synchronized String m19921a(String str) {
        String str2;
        synchronized (UrlRpcInterceptor.class) {
            str2 = null;
            if (!TextUtils.isEmpty(str)) {
                int indexOf = str.indexOf("?");
                if (indexOf > 0 && indexOf <= str.length()) {
                    str = str.substring(0, indexOf);
                }
                if (!f27843d.contains(str)) {
                    f27843d.add(str);
                    str2 = str;
                }
            }
        }
        return str2;
    }
}
