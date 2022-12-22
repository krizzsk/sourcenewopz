package didihttp;

import com.google.common.net.HttpHeaders;
import com.koushikdutta.async.http.AsyncHttpDelete;
import com.koushikdutta.async.http.AsyncHttpHead;
import didihttp.Headers;
import didihttp.internal.C20747Util;
import didihttp.internal.http.HttpMethod;
import java.net.URL;
import java.util.List;

public final class Request {

    /* renamed from: a */
    final HttpUrl f56486a;

    /* renamed from: b */
    final String f56487b;

    /* renamed from: c */
    final Headers f56488c;

    /* renamed from: d */
    final RequestBody f56489d;

    /* renamed from: e */
    final Object f56490e;

    /* renamed from: f */
    private volatile CacheControl f56491f;

    Request(Builder builder) {
        this.f56486a = builder.url;
        this.f56487b = builder.method;
        this.f56488c = builder.headers.build();
        this.f56489d = builder.body;
        this.f56490e = builder.tag != null ? builder.tag : this;
    }

    public HttpUrl url() {
        return this.f56486a;
    }

    public String method() {
        return this.f56487b;
    }

    public Headers headers() {
        return this.f56488c;
    }

    public String header(String str) {
        return this.f56488c.get(str);
    }

    public List<String> headers(String str) {
        return this.f56488c.values(str);
    }

    public RequestBody body() {
        return this.f56489d;
    }

    public Object tag() {
        return this.f56490e;
    }

    public Builder newBuilder() {
        return new Builder(this);
    }

    public CacheControl cacheControl() {
        CacheControl cacheControl = this.f56491f;
        if (cacheControl != null) {
            return cacheControl;
        }
        CacheControl parse = CacheControl.parse(this.f56488c);
        this.f56491f = parse;
        return parse;
    }

    public boolean isHttps() {
        return this.f56486a.isHttps();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request{method=");
        sb.append(this.f56487b);
        sb.append(", url=");
        sb.append(this.f56486a);
        sb.append(", tag=");
        Object obj = this.f56490e;
        if (obj == this) {
            obj = null;
        }
        sb.append(obj);
        sb.append('}');
        return sb.toString();
    }

    public static class Builder {
        RequestBody body;
        Headers.Builder headers;
        String method;
        Object tag;
        HttpUrl url;

        public Builder() {
            this.method = "GET";
            this.headers = new Headers.Builder();
        }

        Builder(Request request) {
            this.url = request.f56486a;
            this.method = request.f56487b;
            this.body = request.f56489d;
            this.tag = request.f56490e;
            this.headers = request.f56488c.newBuilder();
        }

        public Builder url(HttpUrl httpUrl) {
            if (httpUrl != null) {
                this.url = httpUrl;
                return this;
            }
            throw new NullPointerException("url == null");
        }

        public Builder url(String str) {
            if (str != null) {
                if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                    str = "http:" + str.substring(3);
                } else if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                    str = "https:" + str.substring(4);
                }
                HttpUrl parse = HttpUrl.parse(str);
                if (parse != null) {
                    return url(parse);
                }
                throw new IllegalArgumentException("unexpected url: " + str);
            }
            throw new NullPointerException("url == null");
        }

        public Builder url(URL url2) {
            if (url2 != null) {
                HttpUrl httpUrl = HttpUrl.get(url2);
                if (httpUrl != null) {
                    return url(httpUrl);
                }
                throw new IllegalArgumentException("unexpected url: " + url2);
            }
            throw new NullPointerException("url == null");
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

        public Builder cacheControl(CacheControl cacheControl) {
            String cacheControl2 = cacheControl.toString();
            if (cacheControl2.isEmpty()) {
                return removeHeader(HttpHeaders.CACHE_CONTROL);
            }
            return header(HttpHeaders.CACHE_CONTROL, cacheControl2);
        }

        public Builder get() {
            return method("GET", (RequestBody) null);
        }

        public Builder head() {
            return method(AsyncHttpHead.METHOD, (RequestBody) null);
        }

        public Builder post(RequestBody requestBody) {
            return method("POST", requestBody);
        }

        public Builder delete(RequestBody requestBody) {
            return method(AsyncHttpDelete.METHOD, requestBody);
        }

        public Builder delete() {
            return delete(C20747Util.EMPTY_REQUEST);
        }

        public Builder put(RequestBody requestBody) {
            return method("PUT", requestBody);
        }

        public Builder patch(RequestBody requestBody) {
            return method("PATCH", requestBody);
        }

        public Builder method(String str, RequestBody requestBody) {
            if (str == null) {
                throw new NullPointerException("method == null");
            } else if (str.length() == 0) {
                throw new IllegalArgumentException("method.length() == 0");
            } else if (requestBody != null && !HttpMethod.permitsRequestBody(str)) {
                throw new IllegalArgumentException("method " + str + " must not have a request body.");
            } else if (requestBody != null || !HttpMethod.requiresRequestBody(str)) {
                this.method = str;
                this.body = requestBody;
                return this;
            } else {
                throw new IllegalArgumentException("method " + str + " must have a request body.");
            }
        }

        public Builder tag(Object obj) {
            this.tag = obj;
            return this;
        }

        public Request build() {
            if (this.url != null) {
                return new Request(this);
            }
            throw new IllegalStateException("url == null");
        }
    }
}
