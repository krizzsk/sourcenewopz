package com.didi.entrega.customer.foundation.rpc.interceptor;

import android.text.TextUtils;
import com.didi.entrega.customer.foundation.log.RecordTracker;
import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didi.entrega.customer.foundation.rpc.ApiUrlFactory;
import com.didi.entrega.customer.foundation.rpc.ParamsHelper;
import com.didi.entrega.customer.foundation.tracker.error.ErrorConst;
import com.didi.entrega.customer.foundation.tracker.error.ErrorTracker;
import com.didi.entrega.customer.foundation.util.GsonUtil;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didichuxing.foundation.net.http.HttpBody;
import com.didichuxing.foundation.net.http.HttpEntity;
import com.didichuxing.foundation.net.http.HttpMethod;
import com.didichuxing.foundation.net.rpc.http.HttpRpcRequest;
import com.didichuxing.foundation.net.rpc.http.HttpRpcResponse;
import com.didichuxing.foundation.rpc.RpcInterceptor;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Map;

public class CustomerParamsInterceptor implements RpcInterceptor<HttpRpcRequest, HttpRpcResponse> {

    /* renamed from: a */
    private static final String f20018a = "CustomerParamsInterceptor";

    /* renamed from: b */
    private static final String f20019b = "x-www-form-urlencoded";

    /* renamed from: c */
    private static final String f20020c = "didi-header-rid";

    public HttpRpcResponse intercept(RpcInterceptor.RpcChain<HttpRpcRequest, HttpRpcResponse> rpcChain) throws IOException {
        HttpRpcResponse httpRpcResponse;
        try {
            HttpRpcRequest request = rpcChain.getRequest();
            HttpMethod method = request.getMethod();
            HttpEntity entity = request.getEntity();
            if (HttpMethod.POST.equals(method)) {
                httpRpcResponse = m14783a(rpcChain, entity);
            } else if (HttpMethod.GET.equals(method)) {
                httpRpcResponse = m14782a(rpcChain);
            } else {
                httpRpcResponse = rpcChain.proceed(rpcChain.getRequest().newBuilder().build());
            }
            if (!request.getUrl().contains(ApiUrlFactory.CUSTOMER_API_HTTPS_ONLINE)) {
                return httpRpcResponse;
            }
            String a = m14784a(httpRpcResponse);
            RecordTracker.Builder.create().setTag("net").setLogModule("m-net-success|").setMessage(a).setOtherParam("data", request.getUrl()).setOtherParam("traceId", request.getHeader(f20020c)).setLogCategory("c-data|").build().info();
            return m14781a(httpRpcResponse, rpcChain.getRequest(), a);
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    /* renamed from: a */
    private String m14784a(HttpRpcResponse httpRpcResponse) throws IOException {
        return httpRpcResponse != null ? m14785a(httpRpcResponse.getEntity().getContent()) : "";
    }

    /* renamed from: a */
    private HttpRpcResponse m14781a(HttpRpcResponse httpRpcResponse, HttpRpcRequest httpRpcRequest, final String str) throws IOException {
        if (httpRpcResponse == null || httpRpcResponse.getEntity() == null || httpRpcRequest == null) {
            return httpRpcResponse;
        }
        final String url = httpRpcRequest.getUrl();
        LogUtil.m14765i(f20018a, "before content: " + str);
        JsonElement dataNonNull = GsonUtil.dataNonNull(str, new GsonUtil.DataNullHandler() {
            public boolean filter(JsonObject jsonObject) {
                JsonElement jsonElement = jsonObject.get("errno");
                return (jsonElement == null || jsonElement.getAsInt() == 0) ? false : true;
            }

            public void handle(GsonUtil.DataNullHandler.DataErrorType dataErrorType, JsonObject jsonObject) {
                jsonObject.remove("data");
                jsonObject.add("data", (JsonElement) null);
                if (dataErrorType == GsonUtil.DataNullHandler.DataErrorType.LACKDATA) {
                    ErrorTracker.create(ErrorConst.ErrorName.PARSE_EXCEPTIONS).addModuleName("api").addParam("content_json", str).addErrorType(url).build().trackError();
                }
            }
        });
        if (dataNonNull != null) {
            str = dataNonNull.toString();
        }
        LogUtil.m14761d(f20018a, "after content: " + str);
        return httpRpcResponse.newBuilder().setEntity((HttpEntity) HttpBody.newInstance(httpRpcResponse.getEntity().getContentType(), str)).build();
    }

    /* renamed from: a */
    private HttpRpcResponse m14783a(RpcInterceptor.RpcChain<HttpRpcRequest, HttpRpcResponse> rpcChain, HttpEntity httpEntity) throws IOException {
        if (httpEntity == null || httpEntity.getContentType() == null || !f20019b.equalsIgnoreCase(httpEntity.getContentType().getSubtype())) {
            return rpcChain.proceed(rpcChain.getRequest().newBuilder().build());
        }
        String a = m14785a(httpEntity.getContent());
        LogUtil.m14761d(f20018a, "raw content: " + a);
        Map<String, Object> commonParams = ParamsHelper.getCommonParams();
        StringBuilder sb = new StringBuilder(a);
        int i = 0;
        for (Map.Entry next : commonParams.entrySet()) {
            if (!TextUtils.isEmpty(a) || i > 0) {
                sb.append(ParamKeys.SIGN_AND);
            }
            sb.append((String) next.getKey());
            sb.append("=");
            sb.append(URLEncoder.encode(String.valueOf(next.getValue()), "UTF-8"));
            i++;
        }
        String sb2 = sb.toString();
        HttpBody newInstance = HttpBody.newInstance(httpEntity.getContentType(), sb2);
        LogUtil.m14761d(f20018a, "Add params: " + sb2);
        return rpcChain.proceed(rpcChain.getRequest().newBuilder().post(newInstance).build());
    }

    /* renamed from: a */
    private HttpRpcResponse m14782a(RpcInterceptor.RpcChain<HttpRpcRequest, HttpRpcResponse> rpcChain) throws IOException {
        String url = rpcChain.getRequest().getUrl();
        StringBuilder sb = new StringBuilder(url);
        Map<String, Object> commonParams = ParamsHelper.getCommonParams();
        boolean z = !url.contains("?");
        int i = 0;
        for (Map.Entry next : commonParams.entrySet()) {
            if (i != 0 || !z) {
                sb.append(ParamKeys.SIGN_AND);
            } else {
                sb.append("?");
                z = false;
            }
            sb.append((String) next.getKey());
            sb.append("=");
            sb.append(URLEncoder.encode(String.valueOf(next.getValue()), "UTF-8"));
            i++;
        }
        return rpcChain.proceed(rpcChain.getRequest().newBuilder().setUrl(sb.toString()).build());
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x002c A[SYNTHETIC, Splitter:B:18:0x002c] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x003b A[SYNTHETIC, Splitter:B:25:0x003b] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String m14785a(java.io.InputStream r5) {
        /*
            r4 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 0
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0026 }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0026 }
            r3.<init>(r5)     // Catch:{ IOException -> 0x0026 }
            r2.<init>(r3)     // Catch:{ IOException -> 0x0026 }
        L_0x0010:
            java.lang.String r5 = r2.readLine()     // Catch:{ IOException -> 0x0021, all -> 0x001e }
            if (r5 == 0) goto L_0x001a
            r0.append(r5)     // Catch:{ IOException -> 0x0021, all -> 0x001e }
            goto L_0x0010
        L_0x001a:
            r2.close()     // Catch:{ IOException -> 0x0030 }
            goto L_0x0034
        L_0x001e:
            r5 = move-exception
            r1 = r2
            goto L_0x0039
        L_0x0021:
            r5 = move-exception
            r1 = r2
            goto L_0x0027
        L_0x0024:
            r5 = move-exception
            goto L_0x0039
        L_0x0026:
            r5 = move-exception
        L_0x0027:
            r5.printStackTrace()     // Catch:{ all -> 0x0024 }
            if (r1 == 0) goto L_0x0034
            r1.close()     // Catch:{ IOException -> 0x0030 }
            goto L_0x0034
        L_0x0030:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0034:
            java.lang.String r5 = r0.toString()
            return r5
        L_0x0039:
            if (r1 == 0) goto L_0x0043
            r1.close()     // Catch:{ IOException -> 0x003f }
            goto L_0x0043
        L_0x003f:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0043:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.entrega.customer.foundation.rpc.interceptor.CustomerParamsInterceptor.m14785a(java.io.InputStream):java.lang.String");
    }
}
