package com.didi.sdk.audiorecorder.net;

import com.didi.sdk.audiorecorder.utils.LogUtil;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didichuxing.foundation.net.rpc.http.HttpRpcInterceptor;
import com.didichuxing.foundation.net.rpc.http.HttpRpcRequest;
import com.didichuxing.foundation.net.rpc.http.HttpRpcResponse;
import com.didichuxing.foundation.p188io.StringDeserializer;
import com.didichuxing.foundation.rpc.RpcInterceptor;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import okio.Buffer;
import org.json.JSONObject;

public class ReqParamsInterceptor implements HttpRpcInterceptor {

    /* renamed from: a */
    private static final String f35444a = "ReqParamsInterceptor";

    public HttpRpcResponse intercept(RpcInterceptor.RpcChain<HttpRpcRequest, HttpRpcResponse> rpcChain) throws IOException {
        long currentTimeMillis = System.currentTimeMillis();
        HttpRpcRequest request = rpcChain.getRequest();
        HttpRpcResponse proceed = rpcChain.proceed(request);
        try {
            m25090a(request, System.currentTimeMillis() - currentTimeMillis);
        } catch (Exception e) {
            LogUtil.log("Failed to intercept request", e);
        }
        return proceed;
    }

    /* renamed from: a */
    private void m25090a(HttpRpcRequest httpRpcRequest, long j) throws IOException {
        if (httpRpcRequest != null && httpRpcRequest.getEntity() != null) {
            Buffer buffer = new Buffer();
            buffer.readFrom(httpRpcRequest.getEntity().getContent());
            buffer.request(Long.MAX_VALUE);
            Map<String, Object> a = m25089a(new StringDeserializer().deserialize(buffer.clone().inputStream()));
            if (a != null) {
                new JSONObject(a).toString();
            }
        }
    }

    /* renamed from: a */
    private Map<String, Object> m25089a(String str) {
        String str2;
        if (str == null || str.equals("")) {
            return null;
        }
        String substring = str.substring(1);
        HashMap hashMap = new HashMap();
        for (String split : substring.split(ParamKeys.SIGN_AND)) {
            String[] split2 = split.split("=");
            if (split2.length >= 1) {
                String str3 = split2[0];
                if (split2.length == 2) {
                    str2 = split2[1];
                } else {
                    str2 = "";
                }
                hashMap.put(str3, str2);
            }
        }
        return hashMap;
    }
}
