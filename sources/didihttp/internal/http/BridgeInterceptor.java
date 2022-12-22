package didihttp.internal.http;

import android.text.TextUtils;
import com.google.common.net.HttpHeaders;
import didihttp.Cookie;
import didihttp.CookieJar;
import didihttp.Headers;
import didihttp.Interceptor;
import didihttp.MediaType;
import didihttp.Request;
import didihttp.RequestBody;
import didihttp.Response;
import didihttp.internal.C20747Util;
import java.io.IOException;
import java.util.List;
import okio.GzipSource;
import okio.Okio;
import okio.Source;

public final class BridgeInterceptor implements Interceptor {

    /* renamed from: a */
    private final CookieJar f56694a;

    public BridgeInterceptor(CookieJar cookieJar) {
        this.f56694a = cookieJar;
    }

    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        Request.Builder newBuilder = request.newBuilder();
        RequestBody body = request.body();
        if (body != null) {
            MediaType contentType = body.contentType();
            if (contentType != null) {
                newBuilder.header("Content-Type", contentType.toString());
            }
            long contentLength = body.contentLength();
            if (contentLength != -1) {
                newBuilder.header(HttpHeaders.CONTENT_LENGTH, Long.toString(contentLength));
                newBuilder.removeHeader(HttpHeaders.TRANSFER_ENCODING);
            } else {
                newBuilder.header(HttpHeaders.TRANSFER_ENCODING, "chunked");
                newBuilder.removeHeader(HttpHeaders.CONTENT_LENGTH);
            }
        }
        boolean z = false;
        if (request.header(HttpHeaders.HOST) == null) {
            newBuilder.header(HttpHeaders.HOST, C20747Util.hostHeader(request.url(), false));
        }
        if (request.header(HttpHeaders.CONNECTION) == null) {
            newBuilder.header(HttpHeaders.CONNECTION, "Keep-Alive");
        }
        if (request.header(HttpHeaders.ACCEPT_ENCODING) == null && request.header(HttpHeaders.RANGE) == null) {
            z = true;
            newBuilder.header(HttpHeaders.ACCEPT_ENCODING, "gzip");
        }
        List<Cookie> loadForRequest = this.f56694a.loadForRequest(request.url());
        if (!loadForRequest.isEmpty()) {
            newBuilder.header(HttpHeaders.COOKIE, m40704a(loadForRequest));
        }
        if (request.header("User-Agent") == null) {
            newBuilder.header("User-Agent", "didihttp");
        }
        Response proceed = chain.proceed(newBuilder.build());
        HttpHeaders.receiveHeaders(this.f56694a, request.url(), proceed.headers());
        Response.Builder request2 = proceed.newBuilder().request(request);
        String header = proceed.request().header("didi-header-rid");
        if (!TextUtils.isEmpty(header)) {
            request2.headers(proceed.headers().newBuilder().add("didi-header-rid", header).build());
        }
        if (z && "gzip".equalsIgnoreCase(proceed.header(HttpHeaders.CONTENT_ENCODING)) && HttpHeaders.hasBody(proceed)) {
            GzipSource gzipSource = new GzipSource(proceed.body().source());
            Headers.Builder removeAll = proceed.headers().newBuilder().removeAll(HttpHeaders.CONTENT_ENCODING).removeAll(HttpHeaders.CONTENT_LENGTH);
            if (!TextUtils.isEmpty(header)) {
                removeAll.add("didi-header-rid", header);
            }
            Headers build = removeAll.build();
            request2.headers(build);
            request2.body(new RealResponseBody(build, Okio.buffer((Source) gzipSource)));
        }
        return request2.build();
    }

    /* renamed from: a */
    private String m40704a(List<Cookie> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append("; ");
            }
            Cookie cookie = list.get(i);
            sb.append(cookie.name());
            sb.append('=');
            sb.append(cookie.value());
        }
        return sb.toString();
    }
}
