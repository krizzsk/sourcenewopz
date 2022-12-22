package com.didichuxing.security.challenge;

import com.didichuxing.foundation.net.rpc.http.HttpRpcRequest;
import com.didichuxing.foundation.net.rpc.http.HttpRpcResponse;
import com.didichuxing.foundation.rpc.RpcInterceptor;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.didichuxing.security.challenge.DiChallenge;
import java.io.InputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

@ServiceProvider(priority = 990, value = {RpcInterceptor.class})
public class DiChallengeInterceptor implements RpcInterceptor<HttpRpcRequest, HttpRpcResponse> {

    /* renamed from: a */
    private static final String f48956a = DiChallengeInterceptor.class.getSimpleName();

    /* renamed from: b */
    private static final String f48957b = "sec_close_challenge_toggle";

    /* JADX WARNING: type inference failed for: r3v0, types: [com.didichuxing.foundation.rpc.RpcInterceptor$RpcChain, com.didichuxing.foundation.rpc.RpcInterceptor$RpcChain<com.didichuxing.foundation.net.rpc.http.HttpRpcRequest, com.didichuxing.foundation.net.rpc.http.HttpRpcResponse>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.didichuxing.foundation.net.rpc.http.HttpRpcResponse intercept(com.didichuxing.foundation.rpc.RpcInterceptor.RpcChain<com.didichuxing.foundation.net.rpc.http.HttpRpcRequest, com.didichuxing.foundation.net.rpc.http.HttpRpcResponse> r3) throws java.io.IOException {
        /*
            r2 = this;
            r0 = 0
            java.lang.String r1 = "sec_close_challenge_toggle"
            com.didichuxing.apollo.sdk.IToggle r1 = com.didichuxing.apollo.sdk.Apollo.getToggle(r1, r0)     // Catch:{ all -> 0x000c }
            boolean r0 = r1.allow()     // Catch:{ all -> 0x000c }
            goto L_0x000d
        L_0x000c:
        L_0x000d:
            if (r0 == 0) goto L_0x001a
            java.lang.Object r0 = r3.getRequest()
            java.lang.Object r3 = r3.proceed(r0)
            com.didichuxing.foundation.net.rpc.http.HttpRpcResponse r3 = (com.didichuxing.foundation.net.rpc.http.HttpRpcResponse) r3
            return r3
        L_0x001a:
            com.didichuxing.security.challenge.DiChallenge$RequestBuilder r3 = r2.m35183a((com.didichuxing.foundation.rpc.RpcInterceptor.RpcChain<com.didichuxing.foundation.net.rpc.http.HttpRpcRequest, com.didichuxing.foundation.net.rpc.http.HttpRpcResponse>) r3)     // Catch:{ Exception -> 0x0025 }
            java.lang.Object r3 = com.didichuxing.security.challenge.DiChallenge.execute(r3)     // Catch:{ Exception -> 0x0025 }
            com.didichuxing.foundation.net.rpc.http.HttpRpcResponse r3 = (com.didichuxing.foundation.net.rpc.http.HttpRpcResponse) r3     // Catch:{ Exception -> 0x0025 }
            return r3
        L_0x0025:
            r3 = move-exception
            boolean r0 = r3 instanceof java.io.IOException
            if (r0 == 0) goto L_0x002d
            java.io.IOException r3 = (java.io.IOException) r3
            goto L_0x0033
        L_0x002d:
            java.io.IOException r0 = new java.io.IOException
            r0.<init>(r3)
            r3 = r0
        L_0x0033:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.security.challenge.DiChallengeInterceptor.intercept(com.didichuxing.foundation.rpc.RpcInterceptor$RpcChain):com.didichuxing.foundation.net.rpc.http.HttpRpcResponse");
    }

    /* renamed from: a */
    private DiChallenge.RequestBuilder<HttpRpcResponse> m35183a(final RpcInterceptor.RpcChain<HttpRpcRequest, HttpRpcResponse> rpcChain) {
        final HttpRpcRequest request = rpcChain.getRequest();
        return new DiChallenge.RequestBuilder<HttpRpcResponse>() {
            boolean newRpc = false;

            public IHttpRequest<HttpRpcResponse> build() throws Exception {
                final HttpRpcRequest.Builder newBuilder = request.newBuilder();
                final HashMap hashMap = new HashMap();
                final HashSet hashSet = new HashSet();
                return new IHttpRequest<HttpRpcResponse>() {
                    public String getUrl() throws Exception {
                        return request.getUrl();
                    }

                    public String getHeader(String str) throws Exception {
                        List<String> headers;
                        if (hashMap.containsKey(str)) {
                            return (String) hashMap.get(str);
                        }
                        if (!hashSet.contains(str) && (headers = request.getHeaders(str)) != null && !headers.isEmpty()) {
                            return headers.get(0);
                        }
                        return null;
                    }

                    public void setHeader(String str, String str2) throws Exception {
                        hashSet.remove(str);
                        hashMap.put(str, str2);
                    }

                    public void removeHeader(String str) throws Exception {
                        hashMap.remove(str);
                        hashSet.add(str);
                    }

                    public IHttpResponse<HttpRpcResponse> execute() throws Exception {
                        for (String removeHeaders : hashSet) {
                            newBuilder.removeHeaders(removeHeaders);
                        }
                        for (Map.Entry entry : hashMap.entrySet()) {
                            newBuilder.removeHeaders((String) entry.getKey());
                            newBuilder.addHeader((String) entry.getKey(), (String) entry.getValue());
                        }
                        return DiChallengeInterceptor.this.m35184a((HttpRpcResponse) rpcChain.proceed(newBuilder.build()));
                    }
                };
            }
        };
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public IHttpResponse<HttpRpcResponse> m35184a(final HttpRpcResponse httpRpcResponse) throws Exception {
        return new IHttpResponse<HttpRpcResponse>() {
            public int getResponseCode() {
                return httpRpcResponse.getStatus();
            }

            public String getHeader(String str) {
                List<String> headers = httpRpcResponse.getHeaders(str);
                if (headers == null || headers.isEmpty()) {
                    return null;
                }
                return headers.get(0);
            }

            public InputStream getRawBody() throws Exception {
                return httpRpcResponse.getEntity().getContent();
            }

            public HttpRpcResponse getResponse() {
                return httpRpcResponse;
            }
        };
    }
}
