package com.didi.payment.base.interceptor;

import android.net.Uri;
import android.text.TextUtils;
import com.didi.payment.base.anti.AccessBlockManager;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.base.utils.WalletApolloUtil;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;
import com.didichuxing.foundation.net.MimeType;
import com.didichuxing.foundation.net.http.HttpEntity;
import com.didichuxing.foundation.net.rpc.http.HttpRpcRequest;
import com.didichuxing.foundation.net.rpc.http.HttpRpcResponse;
import com.didichuxing.foundation.p188io.Streams;
import com.didichuxing.foundation.rpc.RpcInterceptor;
import didihttp.internal.trace.IdGenrator;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.InetAddress;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.HashSet;
import org.json.JSONException;
import org.json.JSONObject;

public class RequestMonitorInterceptor implements RpcInterceptor<HttpRpcRequest, HttpRpcResponse> {

    /* renamed from: a */
    private static final String f29904a = "tech_wallet_monitor_req";

    /* renamed from: b */
    private static final String f29905b = "error_no";

    /* renamed from: c */
    private static final String f29906c = "error_msg";

    /* renamed from: d */
    private static final String f29907d = "trace_id";

    /* renamed from: e */
    private static final HashSet<String> f29908e = new HashSet<>();

    /* renamed from: f */
    private static IToggle f29909f;

    public HttpRpcResponse intercept(RpcInterceptor.RpcChain<HttpRpcRequest, HttpRpcResponse> rpcChain) throws IOException {
        HttpRpcRequest request = rpcChain.getRequest();
        Uri parse = Uri.parse(request.getUrl());
        String host = parse.getHost();
        boolean contains = f29908e.contains(host);
        if (!contains && !WalletApolloUtil.isTrackRequestMonitorEnable(host)) {
            return rpcChain.proceed(request);
        }
        if (!contains) {
            f29908e.add(host);
        }
        String path = parse.getPath();
        if (TextUtils.isEmpty(request.getHeader("didi-header-rid"))) {
            HttpRpcRequest.Builder newBuilder = request.newBuilder();
            newBuilder.addHeader("didi-header-rid", IdGenrator.generate((InetAddress) null));
            request = newBuilder.build();
        }
        try {
            HttpRpcResponse proceed = rpcChain.proceed(request);
            HttpEntity entity = proceed.getEntity();
            if (entity == null || !proceed.isSuccessful() || entity.getContentLength() == 0) {
                m20980a(path, request, proceed, new String[]{String.valueOf(proceed.getStatus()), "request failed"});
                return proceed;
            }
            MimeType contentType = entity.getContentType();
            if (!"text".equalsIgnoreCase(contentType.getType()) && !"json".equalsIgnoreCase(contentType.getSubtype())) {
                return proceed;
            }
            String readFully = Streams.readFully((Reader) new InputStreamReader(entity.getContent()));
            m20980a(path, request, proceed, m20981a(readFully));
            HttpRpcResponse a = m20979a(proceed, readFully);
            AccessBlockManager.getInstance().checkResponse(readFully);
            return a;
        } catch (Exception e) {
            m20980a(path, request, (HttpRpcResponse) null, new String[]{"", e.getMessage()});
            throw new IOException(e);
        }
    }

    /* renamed from: a */
    private void m20980a(String str, HttpRpcRequest httpRpcRequest, HttpRpcResponse httpRpcResponse, String[] strArr) {
        if (!TextUtils.isEmpty(str)) {
            HttpRpcRequest request = httpRpcResponse != null ? httpRpcResponse.getRequest() : httpRpcRequest;
            if (request != null && !TextUtils.isEmpty(request.getUrl())) {
                String str2 = strArr[0];
                String str3 = strArr[1];
                if (httpRpcResponse == null) {
                    str2 = "-11";
                }
                fin_tech_wallet_http_req_lite_en(str2, str3, str, httpRpcRequest);
                if (!"0".equalsIgnoreCase(str2)) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(f29905b, str2);
                    hashMap.put("error_msg", str3);
                    String header = request.getHeader("didi-header-rid");
                    if (header != null) {
                        hashMap.put("trace_id", header);
                    }
                    FinOmegaSDK.trackEvent(f29904a + str.replace("/", "_"), hashMap);
                }
            }
        }
    }

    /* renamed from: a */
    private String[] m20981a(String str) {
        String[] strArr = new String[2];
        try {
            JSONObject jSONObject = new JSONObject(str);
            String str2 = "";
            strArr[0] = jSONObject.has("errno") ? jSONObject.optString("errno") : str2;
            if (jSONObject.has("errmsg")) {
                str2 = jSONObject.optString("errmsg");
            }
            strArr[1] = str2;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return strArr;
    }

    /* renamed from: a */
    private HttpRpcResponse m20979a(HttpRpcResponse httpRpcResponse, final String str) {
        final HttpEntity entity = httpRpcResponse.getEntity();
        return httpRpcResponse.newBuilder().setEntity((HttpEntity) new HttpEntity() {
            public void close() {
            }

            public void writeTo(OutputStream outputStream) {
            }

            public MimeType getContentType() {
                return entity.getContentType();
            }

            public String getTransferEncoding() {
                return entity.getTransferEncoding();
            }

            public Charset getCharset() {
                return entity.getCharset();
            }

            public InputStream getContent() throws IOException {
                if (entity.getCharset() != null) {
                    return new ByteArrayInputStream(str.getBytes(entity.getCharset()));
                }
                return new ByteArrayInputStream(str.getBytes("utf-8"));
            }

            public long getContentLength() throws IOException {
                return entity.getContentLength();
            }
        }).build();
    }

    public void fin_tech_wallet_http_req_lite_en(String str, String str2, String str3, HttpRpcRequest httpRpcRequest) {
        String str4 = str;
        String str5 = str2;
        String str6 = str3;
        if (str6 != null) {
            if (f29909f == null) {
                f29909f = Apollo.getToggle("ibg_fin_wallet_http_record");
            }
            IToggle iToggle = f29909f;
            if (iToggle != null && iToggle.allow()) {
                String str7 = "";
                for (String str8 : ((String) f29909f.getExperiment().getParam("url", str7)).split(",")) {
                    if (str8.equals(str6)) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("errorno", str4);
                        hashMap.put("errormsg", str5);
                        hashMap.put("url", str6);
                        FinOmegaSDK.trackEvent("fin_tech_wallet_http_req_lite_en", hashMap);
                    } else if (str8.contains(":")) {
                        String[] split = str8.split(":");
                        if (split[0].equals(str6)) {
                            if (split.length >= 2) {
                                str7 = Uri.parse(httpRpcRequest.getUrl()).getQueryParameter(split[1]);
                            }
                            HashMap hashMap2 = new HashMap();
                            hashMap2.put("errorno", str4);
                            hashMap2.put("errormsg", str5);
                            hashMap2.put("url", str6);
                            hashMap2.put("pub_type", str7);
                            FinOmegaSDK.trackEvent("fin_tech_wallet_http_req_lite_en", hashMap2);
                        }
                    }
                }
            }
        }
    }
}
