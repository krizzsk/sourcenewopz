package com.didi.raven.net.interceptor;

import android.text.TextUtils;
import com.didi.raven.model.RavenRequestTrack;
import com.didi.raven.net.protocol.RavenHttpRpcProtocol;
import com.didi.raven.utils.RavenUtils;
import com.didi.raven.utils.StringUtils;
import com.didichuxing.foundation.net.MimeType;
import com.didichuxing.foundation.net.http.HttpBody;
import com.didichuxing.foundation.net.http.HttpEntity;
import com.didichuxing.foundation.net.http.HttpHeader;
import com.didichuxing.foundation.net.http.SimpleHttpHeader;
import com.didichuxing.foundation.net.rpc.http.HttpRpcRequest;
import com.didichuxing.foundation.net.rpc.http.HttpRpcResponse;
import com.didichuxing.foundation.rpc.RpcInterceptor;
import com.didichuxing.foundation.rpc.RpcProtocol;
import com.google.common.net.HttpHeaders;
import didihttp.Headers;
import didihttp.MediaType;
import didihttp.Protocol;
import didihttp.Request;
import didihttp.RequestBody;
import didihttp.Response;
import didihttp.ResponseBody;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;

public abstract class RavenRequestInterception implements RpcInterceptor<HttpRpcRequest, HttpRpcResponse> {

    /* renamed from: a */
    private static final String f33114a = "RavenInterception";

    public abstract String getRavenAppId();

    public HttpRpcResponse intercept(RpcInterceptor.RpcChain<HttpRpcRequest, HttpRpcResponse> rpcChain) throws IOException {
        HttpRpcRequest request = rpcChain.getRequest();
        RavenRequestTrack ravenRequestTrack = new RavenRequestTrack(request.getUrl(), m23323a(StringUtils.inputStreamToString(request.getEntity().getContent())));
        HttpRpcResponse proceed = rpcChain.proceed(request);
        String a = m23320a(proceed.getHeaders());
        if (proceed.getEntity() == null || proceed.getEntity().getContentLength() <= 0) {
            ravenRequestTrack.track(getRavenAppId(), a, (Object) null, 0);
            return proceed;
        }
        BufferedSource buffer = Okio.buffer(Okio.source(proceed.getEntity().getContent()));
        HttpRpcResponse a2 = m23316a(request, m23318a(proceed, buffer));
        ravenRequestTrack.track(getRavenAppId(), a, m23323a((String) m23319a(buffer, proceed)), 0);
        return a2;
    }

    /* renamed from: a */
    private Map<String, Object> m23323a(String str) {
        return RavenUtils.jsonToMap(str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0054  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.Object m23319a(okio.BufferedSource r3, com.didichuxing.foundation.net.rpc.http.HttpRpcResponse r4) throws java.io.IOException {
        /*
            r2 = this;
            r0 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r3.request(r0)
            okio.Buffer r3 = r3.buffer()
            java.util.List r0 = r4.getHeaders()
            java.lang.String r0 = r2.m23325b((java.util.List<com.didichuxing.foundation.net.http.HttpHeader>) r0)
            java.lang.String r1 = "gzip"
            boolean r0 = android.text.TextUtils.equals(r1, r0)
            if (r0 != 0) goto L_0x002a
            java.util.List r4 = r4.getHeaders()
            java.lang.String r4 = r2.m23326c(r4)
            boolean r4 = android.text.TextUtils.equals(r1, r4)
            if (r4 == 0) goto L_0x003f
        L_0x002a:
            r4 = 0
            okio.GzipSource r0 = new okio.GzipSource     // Catch:{ all -> 0x0051 }
            okio.Buffer r3 = r3.clone()     // Catch:{ all -> 0x0051 }
            r0.<init>(r3)     // Catch:{ all -> 0x0051 }
            okio.Buffer r3 = new okio.Buffer     // Catch:{ all -> 0x004e }
            r3.<init>()     // Catch:{ all -> 0x004e }
            r3.writeAll(r0)     // Catch:{ all -> 0x004e }
            r0.close()
        L_0x003f:
            okio.Buffer r3 = r3.clone()
            java.lang.String r4 = "UTF-8"
            java.nio.charset.Charset r4 = java.nio.charset.Charset.forName(r4)
            java.lang.String r3 = r3.readString(r4)
            return r3
        L_0x004e:
            r3 = move-exception
            r4 = r0
            goto L_0x0052
        L_0x0051:
            r3 = move-exception
        L_0x0052:
            if (r4 == 0) goto L_0x0057
            r4.close()
        L_0x0057:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.raven.net.interceptor.RavenRequestInterception.m23319a(okio.BufferedSource, com.didichuxing.foundation.net.rpc.http.HttpRpcResponse):java.lang.Object");
    }

    /* renamed from: a */
    private String m23321a(List<HttpHeader> list, String str) {
        for (HttpHeader next : list) {
            if (TextUtils.equals(next.getName(), str)) {
                return next.getValue();
            }
        }
        return "";
    }

    /* renamed from: a */
    private String m23320a(List<HttpHeader> list) {
        return m23321a(list, "didi-header-rid");
    }

    /* renamed from: b */
    private String m23325b(List<HttpHeader> list) {
        return m23321a(list, HttpHeaders.CONTENT_ENCODING);
    }

    /* renamed from: c */
    private String m23326c(List<HttpHeader> list) {
        return m23321a(list, HttpHeaders.ACCEPT_ENCODING);
    }

    /* renamed from: a */
    private RequestBody m23317a(HttpRpcRequest httpRpcRequest) {
        final HttpEntity entity = httpRpcRequest.getEntity();
        if (entity == null) {
            return null;
        }
        return new RequestBody() {
            public void writeTo(BufferedSink bufferedSink) throws IOException {
                entity.writeTo(bufferedSink.outputStream());
            }

            public MediaType contentType() {
                MimeType contentType = entity.getContentType();
                if (contentType != null) {
                    return MediaType.parse(contentType.toString());
                }
                return null;
            }

            public long contentLength() throws IOException {
                return entity.getContentLength();
            }
        };
    }

    /* renamed from: d */
    private Headers m23327d(List<HttpHeader> list) {
        Headers.Builder builder = new Headers.Builder();
        for (HttpHeader next : list) {
            builder.add(next.getName(), next.getValue());
        }
        return builder.build();
    }

    /* renamed from: b */
    private Request m23324b(HttpRpcRequest httpRpcRequest) {
        return new Request.Builder().url(httpRpcRequest.getUrl()).headers(m23327d(httpRpcRequest.getHeaders())).method(httpRpcRequest.getMethod().name(), m23317a(httpRpcRequest)).tag(httpRpcRequest.getTag()).build();
    }

    /* renamed from: a */
    private Response m23318a(HttpRpcResponse httpRpcResponse, final BufferedSource bufferedSource) throws IOException {
        final HttpEntity entity = httpRpcResponse.getEntity();
        return new Response.Builder().request(m23324b(httpRpcResponse.getRequest())).protocol(Protocol.get(httpRpcResponse.getProtocol().toString().toLowerCase())).code(httpRpcResponse.getStatus()).message(httpRpcResponse.getReason()).headers(m23327d(httpRpcResponse.getHeaders())).body(entity == null ? null : new ResponseBody() {
            final long mContentLength = entity.getContentLength();
            final MediaType mContentType = MediaType.parse(String.valueOf(entity.getContentType()));

            public BufferedSource source() {
                return bufferedSource;
            }

            public MediaType contentType() {
                return this.mContentType;
            }

            public long contentLength() {
                return this.mContentLength;
            }
        }).build();
    }

    /* renamed from: a */
    private HttpRpcResponse m23316a(HttpRpcRequest httpRpcRequest, Response response) throws IOException {
        return new HttpRpcResponse.Builder().setProtocol((RpcProtocol) RavenHttpRpcProtocol.parse(response.protocol().toString())).setStatus(response.code()).setReason(response.message()).addHeaders((Iterable) m23322a(response.headers())).setEntity(m23315a(response)).setRequest(httpRpcRequest).build();
    }

    /* renamed from: a */
    private List<HttpHeader> m23322a(Headers headers) {
        ArrayList arrayList = new ArrayList();
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(new SimpleHttpHeader(headers.name(i), headers.value(i)));
        }
        return arrayList;
    }

    /* renamed from: a */
    private HttpEntity m23315a(Response response) throws IOException {
        final ResponseBody body = response.body();
        if (body == null) {
            return null;
        }
        final MimeType parse = MimeType.parse(String.valueOf(body.contentType()));
        return new HttpBody() {
            public MimeType getContentType() {
                return parse;
            }

            public InputStream getContent() throws IOException {
                return body.byteStream();
            }

            public long getContentLength() throws IOException {
                return body.contentLength();
            }

            public void close() throws IOException {
                body.close();
            }
        };
    }
}
