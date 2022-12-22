package com.didichuxing.dfbasesdk.http;

import android.text.TextUtils;
import com.didi.security.wireless.adapter.SecurityWrapper;
import com.didichuxing.foundation.net.rpc.http.HttpRpcRequest;
import com.didichuxing.foundation.net.rpc.http.HttpRpcResponse;
import com.didichuxing.foundation.rpc.RpcInterceptor;
import java.io.IOException;
import java.net.URLEncoder;
import kotlin.text.Typography;

public class SecurityAccessWsgInterceptor implements RpcInterceptor<HttpRpcRequest, HttpRpcResponse> {
    public static final String WSG_TYPE_ACCESS_SECURITY = "https://access/security";
    public static long difaceGuideWsgDuration;

    public HttpRpcResponse intercept(RpcInterceptor.RpcChain<HttpRpcRequest, HttpRpcResponse> rpcChain) throws IOException {
        return rpcChain.proceed(m33433a(rpcChain.getRequest()));
    }

    /* renamed from: a */
    private HttpRpcRequest m33433a(HttpRpcRequest httpRpcRequest) {
        try {
            String url = httpRpcRequest.getUrl();
            long currentTimeMillis = System.currentTimeMillis();
            String doCollect = SecurityWrapper.doCollect(WSG_TYPE_ACCESS_SECURITY);
            if (url != null && url.contains("dd_face_guide2")) {
                difaceGuideWsgDuration = System.currentTimeMillis() - currentTimeMillis;
            }
            if (TextUtils.isEmpty(doCollect)) {
                return httpRpcRequest;
            }
            HttpRpcRequest.Builder newBuilder = httpRpcRequest.newBuilder();
            StringBuilder sb = new StringBuilder(url);
            int indexOf = url.indexOf("?");
            if (indexOf < 0) {
                sb.append('?');
            } else if (indexOf < url.length() - 1) {
                sb.append(Typography.amp);
            }
            sb.append("wsgenv");
            sb.append('=');
            sb.append(URLEncoder.encode(doCollect, "utf-8"));
            newBuilder.setUrl(sb.toString());
            newBuilder.removeHeaders(BizAccessInterceptor.WSG_NOT_COLLECT_WSGENV);
            newBuilder.addHeader(BizAccessInterceptor.WSG_NOT_COLLECT_WSGENV, "1");
            return newBuilder.build();
        } catch (Throwable unused) {
            return httpRpcRequest;
        }
    }
}
