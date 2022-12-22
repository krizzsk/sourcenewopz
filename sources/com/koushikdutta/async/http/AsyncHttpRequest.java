package com.koushikdutta.async.http;

import android.net.Uri;
import com.datadog.android.core.internal.net.DataOkHttpUploader;
import com.didi.sdk.apm.SystemUtils;
import com.google.common.net.HttpHeaders;
import com.koushikdutta.async.AsyncSSLException;
import com.koushikdutta.async.http.body.AsyncHttpRequestBody;
import java.util.Locale;

public class AsyncHttpRequest {
    public static final int DEFAULT_TIMEOUT = 30000;
    public static final String HEADER_ACCEPT_ALL = "*/*";

    /* renamed from: h */
    static final /* synthetic */ boolean f55270h = (!AsyncHttpRequest.class.desiredAssertionStatus());

    /* renamed from: a */
    Uri f55271a;

    /* renamed from: b */
    int f55272b;

    /* renamed from: c */
    String f55273c;

    /* renamed from: d */
    int f55274d;

    /* renamed from: e */
    String f55275e;

    /* renamed from: f */
    int f55276f;

    /* renamed from: g */
    long f55277g;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public String f55278i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public String f55279j;

    /* renamed from: k */
    private Headers f55280k;

    /* renamed from: l */
    private boolean f55281l;

    /* renamed from: m */
    private AsyncHttpRequestBody f55282m;

    public boolean hasBody() {
        return true;
    }

    public void onHandshakeException(AsyncSSLException asyncSSLException) {
    }

    public RequestLine getRequestLine() {
        return new RequestLine() {
            public String getUri() {
                return AsyncHttpRequest.this.getUri().toString();
            }

            public ProtocolVersion getProtocolVersion() {
                return new ProtocolVersion("HTTP", 1, 1);
            }

            public String getMethod() {
                return AsyncHttpRequest.this.f55279j;
            }

            public String toString() {
                if (AsyncHttpRequest.this.f55273c != null) {
                    return String.format(Locale.ENGLISH, "%s %s %s", new Object[]{AsyncHttpRequest.this.f55279j, AsyncHttpRequest.this.getUri(), AsyncHttpRequest.this.f55278i});
                }
                String path = AsyncHttpRequest.this.getPath();
                if (path == null || path.length() == 0) {
                    path = "/";
                }
                String encodedQuery = AsyncHttpRequest.this.getUri().getEncodedQuery();
                if (!(encodedQuery == null || encodedQuery.length() == 0)) {
                    path = path + "?" + encodedQuery;
                }
                return String.format(Locale.ENGLISH, "%s %s %s", new Object[]{AsyncHttpRequest.this.f55279j, path, AsyncHttpRequest.this.f55278i});
            }
        };
    }

    public String getPath() {
        return getUri().getEncodedPath();
    }

    protected static String getDefaultUserAgent() {
        String property = System.getProperty(DataOkHttpUploader.SYSTEM_UA);
        if (property != null) {
            return property;
        }
        return "Java" + System.getProperty("java.version");
    }

    public String getMethod() {
        return this.f55279j;
    }

    public void setRequestLineProtocol(String str) {
        this.f55278i = str;
    }

    public String getRequestLineProtocol() {
        return this.f55278i;
    }

    public AsyncHttpRequest setMethod(String str) {
        if (getClass() == AsyncHttpRequest.class) {
            this.f55279j = str;
            return this;
        }
        throw new UnsupportedOperationException("can't change method on a subclass of AsyncHttpRequest");
    }

    public AsyncHttpRequest(Uri uri, String str) {
        this(uri, str, (Headers) null);
    }

    public static void setDefaultHeaders(Headers headers, Uri uri) {
        if (uri != null) {
            String host = uri.getHost();
            if (uri.getPort() != -1) {
                host = host + ":" + uri.getPort();
            }
            if (host != null) {
                headers.set(HttpHeaders.HOST, host);
            }
        }
        headers.set("User-Agent", getDefaultUserAgent());
        headers.set(HttpHeaders.ACCEPT_ENCODING, "gzip, deflate");
        headers.set(HttpHeaders.CONNECTION, "keep-alive");
        headers.set(HttpHeaders.ACCEPT, HEADER_ACCEPT_ALL);
    }

    public AsyncHttpRequest(Uri uri, String str, Headers headers) {
        this.f55278i = "HTTP/1.1";
        this.f55280k = new Headers();
        this.f55281l = true;
        this.f55272b = 30000;
        this.f55274d = -1;
        if (f55270h || uri != null) {
            this.f55279j = str;
            this.f55271a = uri;
            if (headers == null) {
                this.f55280k = new Headers();
            } else {
                this.f55280k = headers;
            }
            if (headers == null) {
                setDefaultHeaders(this.f55280k, uri);
                return;
            }
            return;
        }
        throw new AssertionError();
    }

    public Uri getUri() {
        return this.f55271a;
    }

    public Headers getHeaders() {
        return this.f55280k;
    }

    public boolean getFollowRedirect() {
        return this.f55281l;
    }

    public AsyncHttpRequest setFollowRedirect(boolean z) {
        this.f55281l = z;
        return this;
    }

    public void setBody(AsyncHttpRequestBody asyncHttpRequestBody) {
        this.f55282m = asyncHttpRequestBody;
    }

    public AsyncHttpRequestBody getBody() {
        return this.f55282m;
    }

    public int getTimeout() {
        return this.f55272b;
    }

    public AsyncHttpRequest setTimeout(int i) {
        this.f55272b = i;
        return this;
    }

    public AsyncHttpRequest setHeader(String str, String str2) {
        getHeaders().set(str, str2);
        return this;
    }

    public AsyncHttpRequest addHeader(String str, String str2) {
        getHeaders().add(str, str2);
        return this;
    }

    public void enableProxy(String str, int i) {
        this.f55273c = str;
        this.f55274d = i;
    }

    public void disableProxy() {
        this.f55273c = null;
        this.f55274d = -1;
    }

    public String getProxyHost() {
        return this.f55273c;
    }

    public int getProxyPort() {
        return this.f55274d;
    }

    public String toString() {
        Headers headers = this.f55280k;
        if (headers == null) {
            return super.toString();
        }
        return headers.toPrefixString(this.f55271a.toString());
    }

    public void setLogging(String str, int i) {
        this.f55275e = str;
        this.f55276f = i;
    }

    public int getLogLevel() {
        return this.f55276f;
    }

    public String getLogTag() {
        return this.f55275e;
    }

    /* renamed from: a */
    private String m39846a(String str) {
        long j = 0;
        if (this.f55277g != 0) {
            j = System.currentTimeMillis() - this.f55277g;
        }
        return String.format(Locale.ENGLISH, "(%d ms) %s: %s", new Object[]{Long.valueOf(j), getUri(), str});
    }

    public void logi(String str) {
        String str2 = this.f55275e;
        if (str2 != null && this.f55276f <= 4) {
            SystemUtils.log(4, str2, m39846a(str), (Throwable) null, "com.koushikdutta.async.http.AsyncHttpRequest", 218);
        }
    }

    public void logv(String str) {
        String str2 = this.f55275e;
        if (str2 != null && this.f55276f <= 2) {
            SystemUtils.log(2, str2, m39846a(str), (Throwable) null, "com.koushikdutta.async.http.AsyncHttpRequest", 225);
        }
    }

    public void logw(String str) {
        String str2 = this.f55275e;
        if (str2 != null && this.f55276f <= 5) {
            SystemUtils.log(5, str2, m39846a(str), (Throwable) null, "com.koushikdutta.async.http.AsyncHttpRequest", 232);
        }
    }

    public void logd(String str) {
        String str2 = this.f55275e;
        if (str2 != null && this.f55276f <= 3) {
            SystemUtils.log(3, str2, m39846a(str), (Throwable) null, "com.koushikdutta.async.http.AsyncHttpRequest", 239);
        }
    }

    public void logd(String str, Exception exc) {
        String str2 = this.f55275e;
        if (str2 != null && this.f55276f <= 3) {
            SystemUtils.log(3, str2, m39846a(str), (Throwable) null, "com.koushikdutta.async.http.AsyncHttpRequest", 246);
            SystemUtils.log(3, this.f55275e, exc.getMessage(), exc, "com.koushikdutta.async.http.AsyncHttpRequest", 247);
        }
    }

    public void loge(String str) {
        String str2 = this.f55275e;
        if (str2 != null && this.f55276f <= 6) {
            SystemUtils.log(6, str2, m39846a(str), (Throwable) null, "com.koushikdutta.async.http.AsyncHttpRequest", 254);
        }
    }

    public void loge(String str, Exception exc) {
        String str2 = this.f55275e;
        if (str2 != null && this.f55276f <= 6) {
            SystemUtils.log(6, str2, m39846a(str), (Throwable) null, "com.koushikdutta.async.http.AsyncHttpRequest", 261);
            SystemUtils.log(6, this.f55275e, exc.getMessage(), exc, "com.koushikdutta.async.http.AsyncHttpRequest", 262);
        }
    }
}
