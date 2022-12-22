package didihttp;

import com.google.common.net.HttpHeaders;
import didihttp.Headers;
import java.io.Closeable;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import okio.Buffer;
import okio.BufferedSource;

public final class Response implements Closeable {

    /* renamed from: a */
    final Request f56492a;

    /* renamed from: b */
    final Protocol f56493b;

    /* renamed from: c */
    final int f56494c;

    /* renamed from: d */
    final String f56495d;

    /* renamed from: e */
    final Handshake f56496e;

    /* renamed from: f */
    final Headers f56497f;

    /* renamed from: g */
    final ResponseBody f56498g;

    /* renamed from: h */
    final Response f56499h;

    /* renamed from: i */
    final Response f56500i;

    /* renamed from: j */
    final Response f56501j;

    /* renamed from: k */
    final long f56502k;

    /* renamed from: l */
    final long f56503l;

    /* renamed from: m */
    private volatile CacheControl f56504m;

    Response(Builder builder) {
        this.f56492a = builder.request;
        this.f56493b = builder.protocol;
        this.f56494c = builder.code;
        this.f56495d = builder.message;
        this.f56496e = builder.handshake;
        this.f56497f = builder.headers.build();
        this.f56498g = builder.body;
        this.f56499h = builder.networkResponse;
        this.f56500i = builder.cacheResponse;
        this.f56501j = builder.priorResponse;
        this.f56502k = builder.sentRequestAtMillis;
        this.f56503l = builder.receivedResponseAtMillis;
    }

    public Request request() {
        return this.f56492a;
    }

    public Protocol protocol() {
        return this.f56493b;
    }

    public int code() {
        return this.f56494c;
    }

    public boolean isSuccessful() {
        int i = this.f56494c;
        return i >= 200 && i < 300;
    }

    public String message() {
        return this.f56495d;
    }

    public Handshake handshake() {
        return this.f56496e;
    }

    public List<String> headers(String str) {
        return this.f56497f.values(str);
    }

    public String header(String str) {
        return header(str, (String) null);
    }

    public String header(String str, String str2) {
        String str3 = this.f56497f.get(str);
        return str3 != null ? str3 : str2;
    }

    public Headers headers() {
        return this.f56497f;
    }

    public ResponseBody peekBody(long j) throws IOException {
        BufferedSource source = this.f56498g.source();
        source.request(j);
        Buffer clone = source.buffer().clone();
        if (clone.size() > j) {
            Buffer buffer = new Buffer();
            buffer.write(clone, j);
            clone.clear();
            clone = buffer;
        }
        return ResponseBody.create(this.f56498g.contentType(), clone.size(), clone);
    }

    public ResponseBody body() {
        return this.f56498g;
    }

    public Builder newBuilder() {
        return new Builder(this);
    }

    public boolean isRedirect() {
        int i = this.f56494c;
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

    public Response networkResponse() {
        return this.f56499h;
    }

    public Response cacheResponse() {
        return this.f56500i;
    }

    public Response priorResponse() {
        return this.f56501j;
    }

    public List<Challenge> challenges() {
        String str;
        int i = this.f56494c;
        if (i == 401) {
            str = HttpHeaders.WWW_AUTHENTICATE;
        } else if (i != 407) {
            return Collections.emptyList();
        } else {
            str = HttpHeaders.PROXY_AUTHENTICATE;
        }
        return didihttp.internal.http.HttpHeaders.parseChallenges(headers(), str);
    }

    public CacheControl cacheControl() {
        CacheControl cacheControl = this.f56504m;
        if (cacheControl != null) {
            return cacheControl;
        }
        CacheControl parse = CacheControl.parse(this.f56497f);
        this.f56504m = parse;
        return parse;
    }

    public long sentRequestAtMillis() {
        return this.f56502k;
    }

    public long receivedResponseAtMillis() {
        return this.f56503l;
    }

    public void close() {
        this.f56498g.close();
    }

    public String toString() {
        return "Response{protocol=" + this.f56493b + ", code=" + this.f56494c + ", message=" + this.f56495d + ", url=" + this.f56492a.url() + '}';
    }

    public static class Builder {
        ResponseBody body;
        Response cacheResponse;
        int code;
        Handshake handshake;
        Headers.Builder headers;
        String message;
        Response networkResponse;
        Response priorResponse;
        Protocol protocol;
        long receivedResponseAtMillis;
        Request request;
        long sentRequestAtMillis;

        public Builder() {
            this.code = -1;
            this.headers = new Headers.Builder();
        }

        Builder(Response response) {
            this.code = -1;
            this.request = response.f56492a;
            this.protocol = response.f56493b;
            this.code = response.f56494c;
            this.message = response.f56495d;
            this.handshake = response.f56496e;
            this.headers = response.f56497f.newBuilder();
            this.body = response.f56498g;
            this.networkResponse = response.f56499h;
            this.cacheResponse = response.f56500i;
            this.priorResponse = response.f56501j;
            this.sentRequestAtMillis = response.f56502k;
            this.receivedResponseAtMillis = response.f56503l;
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

        public Builder handshake(Handshake handshake2) {
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

        public Builder body(ResponseBody responseBody) {
            this.body = responseBody;
            return this;
        }

        public Builder networkResponse(Response response) {
            if (response != null) {
                checkSupportResponse("networkResponse", response);
            }
            this.networkResponse = response;
            return this;
        }

        public Builder cacheResponse(Response response) {
            if (response != null) {
                checkSupportResponse("cacheResponse", response);
            }
            this.cacheResponse = response;
            return this;
        }

        private void checkSupportResponse(String str, Response response) {
            if (response.f56498g != null) {
                throw new IllegalArgumentException(str + ".body != null");
            } else if (response.f56499h != null) {
                throw new IllegalArgumentException(str + ".networkResponse != null");
            } else if (response.f56500i != null) {
                throw new IllegalArgumentException(str + ".cacheResponse != null");
            } else if (response.f56501j != null) {
                throw new IllegalArgumentException(str + ".priorResponse != null");
            }
        }

        public Builder priorResponse(Response response) {
            if (response != null) {
                checkPriorResponse(response);
            }
            this.priorResponse = response;
            return this;
        }

        private void checkPriorResponse(Response response) {
            if (response.f56498g != null) {
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
            } else if (this.code >= 0) {
                return new Response(this);
            } else {
                throw new IllegalStateException("code < 0: " + this.code);
            }
        }
    }
}
