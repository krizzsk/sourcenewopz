package com.didi.hawaii.utils;

import android.text.TextUtils;
import com.didi.hawaii.basic.ApolloHawaii;
import com.didi.hawaii.basic.NetConfig;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.foundation.net.rpc.http.HttpRpcRequest;
import com.didichuxing.foundation.net.rpc.http.HttpRpcResponse;
import com.didichuxing.foundation.rpc.RpcInterceptor;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONObject;

public class HawaiiUrlRpcInterceptor implements RpcInterceptor<HttpRpcRequest, HttpRpcResponse> {
    private static final String APOLLO_SWITCH_NET_TRANSFORM_HTTPS2HTTP = "hawaii_sdk_https_to_http";
    private static final String SCHEME_HTTP = "http";
    private static final String SCHEME_HTTPS = "https";

    public HttpRpcResponse intercept(RpcInterceptor.RpcChain<HttpRpcRequest, HttpRpcResponse> rpcChain) throws IOException {
        HttpRpcRequest request = rpcChain.getRequest();
        return rpcChain.proceed(request.newBuilder().setUrl(transformUrl2Http(request.getUrl())).build());
    }

    public static String transformUrl2Http(String str) {
        if (TextUtils.isEmpty(str) || str.length() < 8) {
            return str;
        }
        if (ApolloHawaii.isUseTestUrl()) {
            try {
                String netConfig = NetConfig.getNetConfig();
                if (!TextUtils.isEmpty(netConfig)) {
                    JSONArray jSONArray = new JSONArray(netConfig);
                    if (jSONArray.length() > 0) {
                        for (int i = 0; i < jSONArray.length(); i++) {
                            JSONObject jSONObject = jSONArray.getJSONObject(i);
                            if (jSONObject != null) {
                                String optString = jSONObject.optString("key");
                                String optString2 = jSONObject.optString("release");
                                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                                    str.replace(optString, optString2);
                                }
                            }
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
        return Apollo.getToggle(APOLLO_SWITCH_NET_TRANSFORM_HTTPS2HTTP).allow() ? str.replaceFirst("https", "http") : str;
    }
}
