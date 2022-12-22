package didihttp.internal.cache;

import didihttp.Headers;
import didihttp.Interceptor;
import didihttp.Protocol;
import didihttp.Request;
import didihttp.Response;
import didihttp.ResponseBody;
import didihttp.internal.C20747Util;
import didihttp.internal.Internal;
import didihttp.internal.cache.CacheStrategy;
import didihttp.internal.http.HttpHeaders;
import didihttp.internal.http.HttpMethod;
import didihttp.internal.http.RealResponseBody;
import java.io.Closeable;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;

public final class CacheInterceptor implements Interceptor {

    /* renamed from: a */
    final InternalCache f56594a;

    public CacheInterceptor(InternalCache internalCache) {
        this.f56594a = internalCache;
    }

    public Response intercept(Interceptor.Chain chain) throws IOException {
        InternalCache internalCache = this.f56594a;
        Response response = internalCache != null ? internalCache.get(chain.request()) : null;
        CacheStrategy cacheStrategy = new CacheStrategy.Factory(System.currentTimeMillis(), chain.request(), response).get();
        Request request = cacheStrategy.networkRequest;
        Response response2 = cacheStrategy.cacheResponse;
        InternalCache internalCache2 = this.f56594a;
        if (internalCache2 != null) {
            internalCache2.trackResponse(cacheStrategy);
        }
        if (response != null && response2 == null) {
            C20747Util.closeQuietly((Closeable) response.body());
        }
        if (request == null && response2 == null) {
            return new Response.Builder().request(chain.request()).protocol(Protocol.HTTP_1_1).code(504).message("Unsatisfiable Request (only-if-cached)").body(C20747Util.EMPTY_RESPONSE).sentRequestAtMillis(-1).receivedResponseAtMillis(System.currentTimeMillis()).build();
        }
        if (request == null) {
            return response2.newBuilder().cacheResponse(m40653a(response2)).build();
        }
        try {
            Response proceed = chain.proceed(request);
            if (proceed == null && response != null) {
            }
            if (response2 != null) {
                if (proceed.code() == 304) {
                    Response build = response2.newBuilder().headers(m40652a(response2.headers(), proceed.headers())).sentRequestAtMillis(proceed.sentRequestAtMillis()).receivedResponseAtMillis(proceed.receivedResponseAtMillis()).cacheResponse(m40653a(response2)).networkResponse(m40653a(proceed)).build();
                    proceed.body().close();
                    this.f56594a.trackConditionalCacheHit();
                    this.f56594a.update(response2, build);
                    return build;
                }
                C20747Util.closeQuietly((Closeable) response2.body());
            }
            Response build2 = proceed.newBuilder().cacheResponse(m40653a(response2)).networkResponse(m40653a(proceed)).build();
            if (HttpHeaders.hasBody(build2)) {
                return m40654a(m40655a(build2, proceed.request(), this.f56594a), build2);
            }
            return build2;
        } finally {
            if (response != null) {
                C20747Util.closeQuietly((Closeable) response.body());
            }
        }
    }

    /* renamed from: a */
    private static Response m40653a(Response response) {
        return (response == null || response.body() == null) ? response : response.newBuilder().body((ResponseBody) null).build();
    }

    /* renamed from: a */
    private CacheRequest m40655a(Response response, Request request, InternalCache internalCache) throws IOException {
        if (internalCache == null) {
            return null;
        }
        if (CacheStrategy.isCacheable(response, request)) {
            return internalCache.put(response);
        }
        if (HttpMethod.invalidatesCache(request.method())) {
            try {
                internalCache.remove(request);
            } catch (IOException unused) {
            }
        }
        return null;
    }

    /* renamed from: a */
    private Response m40654a(final CacheRequest cacheRequest, Response response) throws IOException {
        Sink body;
        if (cacheRequest == null || (body = cacheRequest.body()) == null) {
            return response;
        }
        final BufferedSource source = response.body().source();
        final BufferedSink buffer = Okio.buffer(body);
        return response.newBuilder().body(new RealResponseBody(response.headers(), Okio.buffer((Source) new Source() {
            boolean cacheRequestClosed;

            public long read(Buffer buffer, long j) throws IOException {
                try {
                    long read = source.read(buffer, j);
                    if (read == -1) {
                        if (!this.cacheRequestClosed) {
                            this.cacheRequestClosed = true;
                            buffer.close();
                        }
                        return -1;
                    }
                    buffer.copyTo(buffer.buffer(), buffer.size() - read, read);
                    buffer.emitCompleteSegments();
                    return read;
                } catch (IOException e) {
                    if (!this.cacheRequestClosed) {
                        this.cacheRequestClosed = true;
                        cacheRequest.abort();
                    }
                    throw e;
                }
            }

            public Timeout timeout() {
                return source.timeout();
            }

            public void close() throws IOException {
                if (!this.cacheRequestClosed && !C20747Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                    this.cacheRequestClosed = true;
                    cacheRequest.abort();
                }
                source.close();
            }
        }))).build();
    }

    /* renamed from: a */
    private static Headers m40652a(Headers headers, Headers headers2) {
        Headers.Builder builder = new Headers.Builder();
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            String name = headers.name(i);
            String value = headers.value(i);
            if ((!com.google.common.net.HttpHeaders.WARNING.equalsIgnoreCase(name) || !value.startsWith("1")) && (!m40656a(name) || headers2.get(name) == null)) {
                Internal.instance.addLenient(builder, name, value);
            }
        }
        int size2 = headers2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            String name2 = headers2.name(i2);
            if (!com.google.common.net.HttpHeaders.CONTENT_LENGTH.equalsIgnoreCase(name2) && m40656a(name2)) {
                Internal.instance.addLenient(builder, name2, headers2.value(i2));
            }
        }
        return builder.build();
    }

    /* renamed from: a */
    static boolean m40656a(String str) {
        return !com.google.common.net.HttpHeaders.CONNECTION.equalsIgnoreCase(str) && !"Keep-Alive".equalsIgnoreCase(str) && !com.google.common.net.HttpHeaders.PROXY_AUTHENTICATE.equalsIgnoreCase(str) && !com.google.common.net.HttpHeaders.PROXY_AUTHORIZATION.equalsIgnoreCase(str) && !com.google.common.net.HttpHeaders.f53667TE.equalsIgnoreCase(str) && !"Trailers".equalsIgnoreCase(str) && !com.google.common.net.HttpHeaders.TRANSFER_ENCODING.equalsIgnoreCase(str) && !com.google.common.net.HttpHeaders.UPGRADE.equalsIgnoreCase(str);
    }
}
