package com.didi.dimina.container.secondparty.imghook;

import didihttp.Headers;
import didihttp.Interceptor;
import didihttp.Protocol;
import didihttp.Request;
import didihttp.Response;
import didihttp.ResponseBody;
import didihttp.internal.C20747Util;
import didihttp.internal.Internal;
import didihttp.internal.cache.CacheRequest;
import didihttp.internal.cache.CacheStrategy;
import didihttp.internal.cache.InternalCache;
import didihttp.internal.http.HttpHeaders;
import didihttp.internal.http.HttpMethod;
import didihttp.internal.http.RealResponseBody;
import java.io.Closeable;
import java.io.IOException;
import okhttp3.internal.C2434Util;
import okio.Okio;
import okio.Sink;
import okio.Source;

/* renamed from: com.didi.dimina.container.secondparty.imghook.a */
/* compiled from: CacheInterceptor */
final class C7553a implements Interceptor {

    /* renamed from: a */
    final InternalCache f17192a;

    public C7553a(InternalCache internalCache) {
        this.f17192a = internalCache;
    }

    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        String header = request.header("mainUrlFlag");
        if (header == null) {
            header = "unknown";
        }
        Request build = request.newBuilder().removeHeader("mainUrlFlag").build();
        InternalCache internalCache = this.f17192a;
        Response response = null;
        Response response2 = internalCache != null ? internalCache.get(build) : null;
        CacheStrategy cacheStrategy = new CacheStrategy.Factory(System.currentTimeMillis(), build, response2).get();
        Request request2 = cacheStrategy.networkRequest;
        Response response3 = cacheStrategy.cacheResponse;
        InternalCache internalCache2 = this.f17192a;
        if (internalCache2 != null) {
            internalCache2.trackResponse(cacheStrategy);
        }
        if (response2 != null && response3 == null) {
            C2434Util.closeQuietly((Closeable) response2.body());
        }
        if (request2 == null && response3 == null) {
            return new Response.Builder().request(build).protocol(Protocol.HTTP_1_1).code(504).message("Unsatisfiable Request (only-if-cached)").body(C20747Util.EMPTY_RESPONSE).sentRequestAtMillis(System.currentTimeMillis()).receivedResponseAtMillis(System.currentTimeMillis()).build();
        }
        if (request2 == null) {
            return response3.newBuilder().cacheResponse(m12756a(response3)).sentRequestAtMillis(System.currentTimeMillis()).receivedResponseAtMillis(System.currentTimeMillis()).build();
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            Response proceed = chain.proceed(request2);
            try {
                Response build2 = proceed.newBuilder().networkResponse((Response) null).cacheResponse((Response) null).priorResponse((Response) null).sentRequestAtMillis(currentTimeMillis).receivedResponseAtMillis(System.currentTimeMillis()).header("mainUrlFlag", header).build();
                if (build2 == null && response2 != null) {
                    C2434Util.closeQuietly((Closeable) response2.body());
                }
                if (response3 != null) {
                    if (build2.code() == 304) {
                        Response build3 = response3.newBuilder().headers(m12755a(response3.headers(), build2.headers())).sentRequestAtMillis(build2.sentRequestAtMillis()).receivedResponseAtMillis(build2.receivedResponseAtMillis()).cacheResponse(m12756a(response3)).networkResponse(m12756a(build2)).build();
                        build2.body().close();
                        this.f17192a.trackConditionalCacheHit();
                        this.f17192a.update(response3, build3);
                        return build3;
                    }
                    C2434Util.closeQuietly((Closeable) response3.body());
                }
                if (build2 == null) {
                    return null;
                }
                Response build4 = build2.newBuilder().cacheResponse(m12756a(response3)).networkResponse(m12756a(build2)).build();
                if (this.f17192a != null) {
                    if (HttpHeaders.hasBody(build4) && CacheStrategy.isCacheable(build4, request2)) {
                        return m12757a(this.f17192a.put(build4), build4);
                    }
                    if (HttpMethod.invalidatesCache(request2.method())) {
                        try {
                            this.f17192a.remove(request2);
                        } catch (IOException unused) {
                        }
                    }
                }
                return build4;
            } catch (Throwable th) {
                th = th;
                response = proceed;
                C2434Util.closeQuietly((Closeable) response2.body());
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            if (response == null && response2 != null) {
                C2434Util.closeQuietly((Closeable) response2.body());
            }
            throw th;
        }
    }

    /* renamed from: a */
    private static Response m12756a(Response response) {
        return (response == null || response.body() == null) ? response : response.newBuilder().body((ResponseBody) null).build();
    }

    /* renamed from: a */
    private Response m12757a(CacheRequest cacheRequest, Response response) throws IOException {
        Sink body;
        if (cacheRequest == null || (body = cacheRequest.body()) == null) {
            return response;
        }
        return response.newBuilder().body(new RealResponseBody(response.headers(), Okio.buffer((Source) new CacheInterceptor$1(this, response.body().source(), cacheRequest, Okio.buffer(body))))).build();
    }

    /* renamed from: a */
    private static Headers m12755a(Headers headers, Headers headers2) {
        Headers.Builder builder = new Headers.Builder();
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            String name = headers.name(i);
            String value = headers.value(i);
            if ((!com.google.common.net.HttpHeaders.WARNING.equalsIgnoreCase(name) || !value.startsWith("1")) && (m12759b(name) || !m12758a(name) || headers2.get(name) == null)) {
                Internal.instance.addLenient(builder, name, value);
            }
        }
        int size2 = headers2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            String name2 = headers2.name(i2);
            if (!m12759b(name2) && m12758a(name2)) {
                Internal.instance.addLenient(builder, name2, headers2.value(i2));
            }
        }
        return builder.build();
    }

    /* renamed from: a */
    static boolean m12758a(String str) {
        return !com.google.common.net.HttpHeaders.CONNECTION.equalsIgnoreCase(str) && !"Keep-Alive".equalsIgnoreCase(str) && !com.google.common.net.HttpHeaders.PROXY_AUTHENTICATE.equalsIgnoreCase(str) && !com.google.common.net.HttpHeaders.PROXY_AUTHORIZATION.equalsIgnoreCase(str) && !com.google.common.net.HttpHeaders.f53667TE.equalsIgnoreCase(str) && !"Trailers".equalsIgnoreCase(str) && !com.google.common.net.HttpHeaders.TRANSFER_ENCODING.equalsIgnoreCase(str) && !com.google.common.net.HttpHeaders.UPGRADE.equalsIgnoreCase(str);
    }

    /* renamed from: b */
    static boolean m12759b(String str) {
        return com.google.common.net.HttpHeaders.CONTENT_LENGTH.equalsIgnoreCase(str) || com.google.common.net.HttpHeaders.CONTENT_ENCODING.equalsIgnoreCase(str) || "Content-Type".equalsIgnoreCase(str);
    }
}
