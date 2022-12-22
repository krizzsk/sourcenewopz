package com.didi.dimina.container.secondparty.http;

import android.text.TextUtils;
import com.didi.dimina.container.service.NetworkService;
import com.didi.dimina.container.util.JSONUtil;
import com.didi.dimina.container.util.LogUtil;
import com.didichuxing.foundation.p188io.JSON;
import didihttp.Call;
import didihttp.DidiHttpClient;
import didihttp.FormBody;
import didihttp.Headers;
import didihttp.MediaType;
import didihttp.RequestBody;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.didi.dimina.container.secondparty.http.c */
/* compiled from: RequestTask */
class C7533c {

    /* renamed from: a */
    private static final String f17121a = "content-type";

    /* renamed from: b */
    private static final String f17122b = "Content-Type";

    /* renamed from: c */
    private static final String f17123c = "application/json";

    /* renamed from: d */
    private static final String f17124d = "application/x-www-form-urlencoded";
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final Map<String, String> f17125e = new ConcurrentHashMap();

    C7533c() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Call mo55584a(String str, NetworkService.NetworkTaskModel.Request request, DidiHttpClient didiHttpClient) {
        Call newCall = didiHttpClient.newCall(m12691a(request));
        if (!TextUtils.isEmpty(str)) {
            this.f17125e.put(str, newCall.request().tag().toString());
        }
        return newCall;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Call mo55583a(NetworkService.NetworkTaskModel.Request request, DidiHttpClient didiHttpClient) {
        return mo55584a("", request, didiHttpClient);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo55586a(String str, Call call, NetworkService.NetworkTaskModel.Request request, NetworkService.ITaskCallback iTaskCallback) {
        call.enqueue(new RequestTask$1(this, str, iTaskCallback, request));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo55585a(Call call, NetworkService.NetworkTaskModel.Request request, NetworkService.ITaskCallback iTaskCallback) {
        mo55586a("", call, request, iTaskCallback);
    }

    /* renamed from: a */
    public boolean mo55587a(String str, DidiHttpClient didiHttpClient) {
        boolean z = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            String str2 = this.f17125e.get(str);
            if (TextUtils.isEmpty(str2)) {
                return false;
            }
            for (Call next : didiHttpClient.dispatcher().queuedCalls()) {
                if (str2.equals(next.request().tag().toString())) {
                    if (!next.isCanceled()) {
                        next.cancel();
                    }
                    z = true;
                }
            }
            for (Call next2 : didiHttpClient.dispatcher().runningCalls()) {
                if (str2.equals(next2.request().tag().toString())) {
                    if (!next2.isCanceled()) {
                        next2.cancel();
                    }
                    z = true;
                }
            }
            return z;
        } catch (Exception e) {
            LogUtil.iRelease("RequestTask", "request abort failed");
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public JSONObject m12694a(String str, String str2, Headers headers, int i) throws IOException, JSONException {
        Map<String, List<String>> multimap = headers.toMultimap();
        if (!multimap.containsKey(f17121a)) {
            multimap.put(f17121a, Collections.singletonList("application/json"));
        }
        JSONObject jSONObject = JSONUtil.toJSONObject(JSONUtil.toJson(multimap));
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("header", jSONObject);
        Object obj = str2;
        if (str.equals("json")) {
            obj = JSON.parse(str2);
        }
        jSONObject2.put("data", obj);
        jSONObject2.put("cookies", multimap.get("cookies"));
        jSONObject2.put("statusCode", i);
        return jSONObject2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0068  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private didihttp.Request m12691a(com.didi.dimina.container.service.NetworkService.NetworkTaskModel.Request r8) {
        /*
            r7 = this;
            didihttp.Request$Builder r0 = new didihttp.Request$Builder
            r0.<init>()
            java.lang.String r1 = r8.url
            java.lang.String r2 = r8.method
            java.lang.String r2 = r2.toUpperCase()
            int r3 = r2.hashCode()
            r4 = 70454(0x11336, float:9.8727E-41)
            r5 = 2
            r6 = 1
            if (r3 == r4) goto L_0x0037
            r4 = 79599(0x136ef, float:1.11542E-40)
            if (r3 == r4) goto L_0x002d
            r4 = 2461856(0x2590a0, float:3.449795E-39)
            if (r3 == r4) goto L_0x0023
            goto L_0x0041
        L_0x0023:
            java.lang.String r3 = "POST"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0041
            r2 = 0
            goto L_0x0042
        L_0x002d:
            java.lang.String r3 = "PUT"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0041
            r2 = 2
            goto L_0x0042
        L_0x0037:
            java.lang.String r3 = "GET"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0041
            r2 = 1
            goto L_0x0042
        L_0x0041:
            r2 = -1
        L_0x0042:
            if (r2 == 0) goto L_0x005d
            if (r2 == r6) goto L_0x0051
            if (r2 == r5) goto L_0x0049
            goto L_0x0064
        L_0x0049:
            didihttp.RequestBody r2 = r7.m12695b(r8)
            r0.put(r2)
            goto L_0x0064
        L_0x0051:
            java.lang.String r1 = r8.url
            java.util.Map<java.lang.String, java.lang.Object> r2 = r8.data
            java.lang.String r1 = com.didi.dimina.container.secondparty.http.C7535e.m12710a(r1, r2)
            r0.get()
            goto L_0x0064
        L_0x005d:
            didihttp.RequestBody r2 = r7.m12695b(r8)
            r0.post(r2)
        L_0x0064:
            java.util.Map r2 = r8.headers
            if (r2 == 0) goto L_0x0071
            java.util.Map r8 = r8.headers
            didihttp.Headers r8 = didihttp.Headers.m40612of((java.util.Map<java.lang.String, java.lang.String>) r8)
            r0.headers(r8)
        L_0x0071:
            didihttp.Request$Builder r8 = r0.url((java.lang.String) r1)
            long r0 = java.lang.System.currentTimeMillis()
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            didihttp.Request$Builder r8 = r8.tag(r0)
            didihttp.Request r8 = r8.build()
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.secondparty.http.C7533c.m12691a(com.didi.dimina.container.service.NetworkService$NetworkTaskModel$Request):didihttp.Request");
    }

    /* renamed from: b */
    private RequestBody m12695b(NetworkService.NetworkTaskModel.Request request) {
        String str;
        Map map;
        if (request.headers == null) {
            str = null;
        } else {
            Map map2 = request.headers;
            String str2 = f17121a;
            if (map2.get(str2) == null) {
                map = request.headers;
                str2 = "Content-Type";
            } else {
                map = request.headers;
            }
            str = (String) map.get(str2);
        }
        if (TextUtils.isEmpty(str)) {
            str = "application/json";
        }
        MediaType parse = MediaType.parse(str);
        String str3 = parse.type() + "/" + parse.subtype();
        if (TextUtils.equals("application/json", str3)) {
            if (request.data != null && request.data.size() > 0) {
                JSONObject jSONObject = new JSONObject();
                for (Map.Entry next : request.data.entrySet()) {
                    JSONUtil.put(jSONObject, (String) next.getKey(), next.getValue());
                }
                return RequestBody.create(parse, jSONObject.toString());
            } else if (request.data2 != null) {
                return RequestBody.create(parse, request.data2.toString());
            } else {
                return RequestBody.create(parse, "{}");
            }
        } else if (TextUtils.equals("application/x-www-form-urlencoded", str3)) {
            return m12696c(request);
        } else {
            return RequestBody.create(MediaType.parse(str3), request.data2 == null ? "" : request.data2.toString());
        }
    }

    /* renamed from: c */
    private RequestBody m12696c(NetworkService.NetworkTaskModel.Request request) {
        FormBody.Builder builder = new FormBody.Builder();
        if (request.data.entrySet().size() > 0) {
            for (Map.Entry next : request.data.entrySet()) {
                try {
                    builder.addEncoded(URLEncoder.encode((String) next.getKey(), "UTF-8"), URLEncoder.encode(next.getValue().toString(), "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
            return builder.build();
        }
        return RequestBody.create(MediaType.parse("application/x-www-form-urlencoded"), request.data2 == null ? "" : request.data2.toString());
    }
}
