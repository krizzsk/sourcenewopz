package okhttp3;

import com.google.common.net.HttpHeaders;
import java.io.Closeable;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import okhttp3.Headers;
import okio.Buffer;
import okio.BufferedSource;

public final class Response implements Closeable {

    /* renamed from: a */
    final Request f5239a;

    /* renamed from: b */
    final Protocol f5240b;

    /* renamed from: c */
    final int f5241c;

    /* renamed from: d */
    final String f5242d;
    @Nullable

    /* renamed from: e */
    final Handshake f5243e;

    /* renamed from: f */
    final Headers f5244f;
    @Nullable

    /* renamed from: g */
    final ResponseBody f5245g;
    @Nullable

    /* renamed from: h */
    final Response f5246h;
    @Nullable

    /* renamed from: i */
    final Response f5247i;
    @Nullable

    /* renamed from: j */
    final Response f5248j;

    /* renamed from: k */
    final long f5249k;

    /* renamed from: l */
    final long f5250l;
    @Nullable

    /* renamed from: m */
    private volatile CacheControl f5251m;

    Response(Builder builder) {
        this.f5239a = builder.request;
        this.f5240b = builder.protocol;
        this.f5241c = builder.code;
        this.f5242d = builder.message;
        this.f5243e = builder.handshake;
        this.f5244f = builder.headers.build();
        this.f5245g = builder.body;
        this.f5246h = builder.networkResponse;
        this.f5247i = builder.cacheResponse;
        this.f5248j = builder.priorResponse;
        this.f5249k = builder.sentRequestAtMillis;
        this.f5250l = builder.receivedResponseAtMillis;
    }

    public Request request() {
        return this.f5239a;
    }

    public Protocol protocol() {
        return this.f5240b;
    }

    public int code() {
        return this.f5241c;
    }

    public boolean isSuccessful() {
        int i = this.f5241c;
        return i >= 200 && i < 300;
    }

    public String message() {
        return this.f5242d;
    }

    @Nullable
    public Handshake handshake() {
        return this.f5243e;
    }

    public List<String> headers(String str) {
        return this.f5244f.values(str);
    }

    @Nullable
    public String header(String str) {
        return header(str, (String) null);
    }

    @Nullable
    public String header(String str, @Nullable String str2) {
        String str3 = this.f5244f.get(str);
        return str3 != null ? str3 : str2;
    }

    public Headers headers() {
        return this.f5244f;
    }

    public ResponseBody peekBody(long j) throws IOException {
        BufferedSource source = this.f5245g.source();
        source.request(j);
        Buffer clone = source.buffer().clone();
        if (clone.size() > j) {
            Buffer buffer = new Buffer();
            buffer.write(clone, j);
            clone.clear();
            clone = buffer;
        }
        return ResponseBody.create(this.f5245g.contentType(), clone.size(), clone);
    }

    @Nullable
    public ResponseBody body() {
        return this.f5245g;
    }

    public Builder newBuilder() {
        return new Builder(this);
    }

    public boolean isRedirect() {
        int i = this.f5241c;
        if (i == 307 || i == 308) {
            return true;
        }
        switch (i) {
            case 300:
            case 301:
            case 302:
            case 303:
                return true;
            default:
                return false;
        }
    }

    @Nullable
    public Response networkResponse() {
        return this.f5246h;
    }

    @Nullable
    public Response cacheResponse() {
        return this.f5247i;
    }

    @Nullable
    public Response priorResponse() {
        return this.f5248j;
    }

    public List<Challenge> challenges() {
        String str;
        int i = this.f5241c;
        if (i == 401) {
            str = HttpHeaders.WWW_AUTHENTICATE;
        } else if (i != 407) {
            return Collections.emptyList();
        } else {
            str = HttpHeaders.PROXY_AUTHENTICATE;
        }
        return okhttp3.internal.http.HttpHeaders.parseChallenges(headers(), str);
    }

    public CacheControl cacheControl() {
        CacheControl cacheControl = this.f5251m;
        if (cacheControl != null) {
            return cacheControl;
        }
        CacheControl parse = CacheControl.parse(this.f5244f);
        this.f5251m = parse;
        return parse;
    }

    public long sentRequestAtMillis() {
        return this.f5249k;
    }

    public long receivedResponseAtMillis() {
        return this.f5250l;
    }

    public void close() {
        ResponseBody responseBody = this.f5245g;
        if (responseBody != null) {
            responseBody.close();
            return;
        }
        throw new IllegalStateException("response is not eligible for a body and must not be closed");
    }

    public String toString() {
        return "Response{protocol=" + this.f5240b + ", code=" + this.f5241c + ", message=" + this.f5242d + ", url=" + this.f5239a.url() + '}';
    }

    public static class Builder {
        @Nullable
        ResponseBody body;
        @Nullable
        Response cacheResponse;
        int code;
        @Nullable
        Handshake handshake;
        Headers.Builder headers;
        String message;
        @Nullable
        Response networkResponse;
        @Nullable
        Response priorResponse;
        @Nullable
        Protocol protocol;
        long receivedResponseAtMillis;
        @Nullable
        Request request;
        long sentRequestAtMillis;

        public Builder() {
            this.code = -1;
            this.headers = new Headers.Builder();
        }

        Builder(Response response) {
            this.code = -1;
            this.request = response.f5239a;
            this.protocol = response.f5240b;
            this.code = response.f5241c;
            this.message = response.f5242d;
            this.handshake = response.f5243e;
            this.headers = response.f5244f.newBuilder();
            this.body = response.f5245g;
            this.networkResponse = response.f5246h;
            this.cacheResponse = response.f5247i;
            this.priorResponse = response.f5248j;
            this.sentRequestAtMillis = response.f5249k;
            this.receivedResponseAtMillis = response.f5250l;
        }

        public Builder request(Request request2) {
            this.request = request2;
            return this;
        }

        public Builder protocol(Protocol protocol2) {
            this.protocol = protocol2;
            return this;
        }

        public Builder code(int i) {
            this.code = i;
            return this;
        }

        public Builder message(String str) {
            this.message = str;
            return this;
        }

        public Builder handshake(@Nullable Handshake handshake2) {
            this.handshake = handshake2;
            return this;
        }

        public Builder header(String str, String str2) {
            this.headers.set(str, str2);
            return this;
        }

        public Builder addHeader(String str, String str2) {
            this.headers.add(str, str2);
            return this;
        }

        public Builder removeHeader(String str) {
            this.headers.removeAll(str);
            return this;
        }

        public Builder headers(Headers headers2) {
            this.headers = headers2.newBuilder();
            return this;
        }

        public Builder body(@Nullable ResponseBody responseBody) {
            this.body = responseBody;
            return this;
        }

        public Builder networkResponse(@Nullable Response response) {
            if (response != null) {
                checkSupportResponse("networkResponse", response);
            }
            this.networkResponse = response;
            return this;
        }

        public Builder cacheResponse(@Nullable Response response) {
            if (response != null) {
                checkSupportResponse("cacheResponse", response);
            }
            this.cacheResponse = response;
            return this;
        }

        private void checkSupportResponse(String str, Response response) {
            if (response.f5245g != null) {
                throw new IllegalArgumentException(str + ".body != null");
            } else if (response.f5246h != null) {
                throw new IllegalArgumentException(str + ".networkResponse != null");
            } else if (response.f5247i != null) {
                throw new IllegalArgumentException(str + ".cacheResponse != null");
            } else if (response.f5248j != null) {
                throw new IllegalArgumentException(str + ".priorResponse != null");
            }
        }

        public Builder priorResponse(@Nullable Response response) {
            if (response != null) {
                checkPriorResponse(response);
            }
            this.priorResponse = response;
            return this;
        }

        private void checkPriorResponse(Response response) {
            if (response.f5245g != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        public Builder sentRequestAtMillis(long j) {
            this.sentRequestAtMillis = j;
            return this;
        }

        public Builder receivedResponseAtMillis(long j) {
            this.receivedResponseAtMillis = j;
            return this;
        }

        public Response build() {
            if (this.request == null) {
                throw new IllegalStateException("request == null");
            } else if (this.protocol == null) {
                throw new IllegalStateException("protocol == null");
            } else if (this.code < 0) {
                throw new IllegalStateException("code < 0: " + this.code);
            } else if (this.message != null) {
                return new Response(this);
            } else {
                throw new IllegalStateException("message == null");
            }
        }
    }
}
