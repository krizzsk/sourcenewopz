package com.didichuxing.dfbasesdk.interceptor;

import android.net.Uri;
import android.text.TextUtils;
import com.didichuxing.foundation.net.http.HttpMethod;
import com.didichuxing.foundation.net.rpc.http.HttpRpcInterceptor;
import com.didichuxing.foundation.net.rpc.http.HttpRpcRequest;
import com.didichuxing.foundation.net.rpc.http.HttpRpcResponse;
import com.didichuxing.foundation.rpc.RpcInterceptor;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SignerRpcInterceptor implements HttpRpcInterceptor {
    public static final Map<String, AbsContentTypeParse> PARSE_MAP;
    public static final Set<String> SKIP_SIGN_API = new HashSet();

    static {
        HashMap hashMap = new HashMap();
        PARSE_MAP = hashMap;
        hashMap.put("application", new JsonParse());
        PARSE_MAP.put("multipart", new FormDataParse());
    }

    public HttpRpcResponse intercept(RpcInterceptor.RpcChain<HttpRpcRequest, HttpRpcResponse> rpcChain) throws IOException {
        AbsContentTypeParse absContentTypeParse;
        HttpRpcRequest request = rpcChain.getRequest();
        try {
            String url = request.getUrl();
            if (!TextUtils.isEmpty(url) && request.getMethod() == HttpMethod.POST) {
                if (!(SKIP_SIGN_API.contains(Uri.parse(url).getLastPathSegment()) || request.getEntity() == null || (absContentTypeParse = PARSE_MAP.get(request.getEntity().getContentType().getType())) == null)) {
                    request = absContentTypeParse.sign(request);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rpcChain.proceed(request);
    }

    public static void addSkipSignApi(String str) {
        SKIP_SIGN_API.add(str);
    }
}
