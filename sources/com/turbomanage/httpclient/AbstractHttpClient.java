package com.turbomanage.httpclient;

import java.io.IOException;
import java.io.OutputStream;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.TreeMap;

public abstract class AbstractHttpClient {
    public static final String JSON = "application/json;charset=UTF-8";
    public static final String MULTIPART = "multipart/form-data";
    public static final String URLENCODED = "application/x-www-form-urlencoded;charset=UTF-8";
    protected String baseUrl;
    protected int connectionTimeout;
    private boolean isConnected;
    protected int readTimeout;
    protected final RequestHandler requestHandler;
    protected Map<String, String> requestHeaders;
    protected RequestLogger requestLogger;

    private AbstractHttpClient() {
        this("");
    }

    private AbstractHttpClient(String str) {
        this(str, new BasicRequestHandler() {
        });
    }

    public AbstractHttpClient(String str, RequestHandler requestHandler2) {
        this.baseUrl = "";
        this.requestLogger = new ConsoleRequestLogger();
        this.requestHeaders = new TreeMap();
        this.connectionTimeout = 2000;
        this.readTimeout = 8000;
        this.baseUrl = str;
        this.requestHandler = requestHandler2;
    }

    public HttpResponse head(String str, ParameterMap parameterMap) {
        return execute(new HttpHead(str, parameterMap));
    }

    public HttpResponse get(String str, ParameterMap parameterMap) {
        return execute(new HttpGet(str, parameterMap));
    }

    public HttpResponse post(String str, ParameterMap parameterMap) {
        return execute(new HttpPost(str, parameterMap));
    }

    public HttpResponse post(String str, String str2, byte[] bArr) {
        return execute(new HttpPost(str, (ParameterMap) null, str2, bArr));
    }

    public HttpResponse put(String str, String str2, byte[] bArr) {
        return execute(new HttpPut(str, (ParameterMap) null, str2, bArr));
    }

    public HttpResponse delete(String str, ParameterMap parameterMap) {
        return execute(new HttpDelete(str, parameterMap));
    }

    public HttpResponse execute(HttpRequest httpRequest) {
        try {
            return doHttpMethod(httpRequest.getPath(), httpRequest.getHttpMethod(), httpRequest.getContentType(), httpRequest.getContent());
        } catch (HttpRequestException e) {
            this.requestHandler.onError(e);
            return null;
        } catch (Exception e2) {
            this.requestHandler.onError(new HttpRequestException(e2, (HttpResponse) null));
            return null;
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:42|43|44|45|46) */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004f, code lost:
        r4 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
        r4.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0085, code lost:
        throw new com.turbomanage.httpclient.HttpRequestException(r4, (com.turbomanage.httpclient.HttpResponse) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x008b, code lost:
        throw new com.turbomanage.httpclient.HttpRequestException(r4, (com.turbomanage.httpclient.HttpResponse) null);
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:30:0x005e, B:42:0x007d] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:42:0x007d */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x005e A[SYNTHETIC, Splitter:B:30:0x005e] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x009b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.turbomanage.httpclient.HttpResponse doHttpMethod(java.lang.String r3, com.turbomanage.httpclient.HttpMethod r4, java.lang.String r5, byte[] r6) throws com.turbomanage.httpclient.HttpRequestException {
        /*
            r2 = this;
            r0 = 0
            r1 = 0
            r2.isConnected = r0     // Catch:{ Exception -> 0x0056, all -> 0x0053 }
            java.net.HttpURLConnection r3 = r2.openConnection(r3)     // Catch:{ Exception -> 0x0056, all -> 0x0053 }
            r2.prepareConnection(r3, r4, r5)     // Catch:{ Exception -> 0x0051 }
            r2.appendRequestHeaders(r3)     // Catch:{ Exception -> 0x0051 }
            com.turbomanage.httpclient.RequestLogger r4 = r2.requestLogger     // Catch:{ Exception -> 0x0051 }
            boolean r4 = r4.isLoggingEnabled()     // Catch:{ Exception -> 0x0051 }
            if (r4 == 0) goto L_0x001b
            com.turbomanage.httpclient.RequestLogger r4 = r2.requestLogger     // Catch:{ Exception -> 0x0051 }
            r4.logRequest(r3, r6)     // Catch:{ Exception -> 0x0051 }
        L_0x001b:
            r3.connect()     // Catch:{ Exception -> 0x0051 }
            r4 = 1
            r2.isConnected = r4     // Catch:{ Exception -> 0x0051 }
            boolean r4 = r3.getDoOutput()     // Catch:{ Exception -> 0x0051 }
            if (r4 == 0) goto L_0x002c
            if (r6 == 0) goto L_0x002c
            r2.writeOutputStream(r3, r6)     // Catch:{ Exception -> 0x0051 }
        L_0x002c:
            boolean r4 = r3.getDoInput()     // Catch:{ Exception -> 0x0051 }
            if (r4 == 0) goto L_0x0037
            com.turbomanage.httpclient.HttpResponse r4 = r2.readInputStream(r3)     // Catch:{ Exception -> 0x0051 }
            goto L_0x003c
        L_0x0037:
            com.turbomanage.httpclient.HttpResponse r4 = new com.turbomanage.httpclient.HttpResponse     // Catch:{ Exception -> 0x0051 }
            r4.<init>(r3, r1)     // Catch:{ Exception -> 0x0051 }
        L_0x003c:
            com.turbomanage.httpclient.RequestLogger r5 = r2.requestLogger
            boolean r5 = r5.isLoggingEnabled()
            if (r5 == 0) goto L_0x0049
            com.turbomanage.httpclient.RequestLogger r5 = r2.requestLogger
            r5.logResponse(r4)
        L_0x0049:
            if (r3 == 0) goto L_0x004e
            r3.disconnect()
        L_0x004e:
            return r4
        L_0x004f:
            r4 = move-exception
            goto L_0x008c
        L_0x0051:
            r4 = move-exception
            goto L_0x0058
        L_0x0053:
            r4 = move-exception
            r3 = r1
            goto L_0x008c
        L_0x0056:
            r4 = move-exception
            r3 = r1
        L_0x0058:
            com.turbomanage.httpclient.HttpResponse r1 = r2.readErrorStream(r3)     // Catch:{ Exception -> 0x007d }
            if (r1 == 0) goto L_0x0077
            int r5 = r1.getStatus()     // Catch:{ all -> 0x004f }
            if (r5 <= 0) goto L_0x0077
            com.turbomanage.httpclient.RequestLogger r4 = r2.requestLogger
            boolean r4 = r4.isLoggingEnabled()
            if (r4 == 0) goto L_0x0071
            com.turbomanage.httpclient.RequestLogger r4 = r2.requestLogger
            r4.logResponse(r1)
        L_0x0071:
            if (r3 == 0) goto L_0x0076
            r3.disconnect()
        L_0x0076:
            return r1
        L_0x0077:
            com.turbomanage.httpclient.HttpRequestException r5 = new com.turbomanage.httpclient.HttpRequestException     // Catch:{ all -> 0x004f }
            r5.<init>(r4, r1)     // Catch:{ all -> 0x004f }
            throw r5     // Catch:{ all -> 0x004f }
        L_0x007d:
            r4.printStackTrace()     // Catch:{ all -> 0x0086 }
            com.turbomanage.httpclient.HttpRequestException r5 = new com.turbomanage.httpclient.HttpRequestException     // Catch:{ all -> 0x004f }
            r5.<init>(r4, r1)     // Catch:{ all -> 0x004f }
            throw r5     // Catch:{ all -> 0x004f }
        L_0x0086:
            com.turbomanage.httpclient.HttpRequestException r5 = new com.turbomanage.httpclient.HttpRequestException     // Catch:{ all -> 0x004f }
            r5.<init>(r4, r1)     // Catch:{ all -> 0x004f }
            throw r5     // Catch:{ all -> 0x004f }
        L_0x008c:
            com.turbomanage.httpclient.RequestLogger r5 = r2.requestLogger
            boolean r5 = r5.isLoggingEnabled()
            if (r5 == 0) goto L_0x0099
            com.turbomanage.httpclient.RequestLogger r5 = r2.requestLogger
            r5.logResponse(r1)
        L_0x0099:
            if (r3 == 0) goto L_0x009e
            r3.disconnect()
        L_0x009e:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.turbomanage.httpclient.AbstractHttpClient.doHttpMethod(java.lang.String, com.turbomanage.httpclient.HttpMethod, java.lang.String, byte[]):com.turbomanage.httpclient.HttpResponse");
    }

    /* access modifiers changed from: protected */
    public HttpURLConnection openConnection(String str) throws IOException {
        String str2 = this.baseUrl + str;
        try {
            new URL(str2);
            return this.requestHandler.openConnection(str2);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException(str2 + " is not a valid URL", e);
        }
    }

    /* access modifiers changed from: protected */
    public void prepareConnection(HttpURLConnection httpURLConnection, HttpMethod httpMethod, String str) throws IOException {
        httpURLConnection.setConnectTimeout(this.connectionTimeout);
        httpURLConnection.setReadTimeout(this.readTimeout);
        this.requestHandler.prepareConnection(httpURLConnection, httpMethod, str);
    }

    private void appendRequestHeaders(HttpURLConnection httpURLConnection) {
        for (String next : this.requestHeaders.keySet()) {
            httpURLConnection.setRequestProperty(next, this.requestHeaders.get(next));
        }
    }

    /* access modifiers changed from: protected */
    public int writeOutputStream(HttpURLConnection httpURLConnection, byte[] bArr) throws Exception {
        OutputStream outputStream = null;
        try {
            outputStream = this.requestHandler.openOutput(httpURLConnection);
            if (outputStream != null) {
                this.requestHandler.writeStream(outputStream, bArr);
            }
            return httpURLConnection.getResponseCode();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Exception unused) {
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: byte[]} */
    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v1, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0020 A[SYNTHETIC, Splitter:B:16:0x0020] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.turbomanage.httpclient.HttpResponse readInputStream(java.net.HttpURLConnection r4) throws java.lang.Exception {
        /*
            r3 = this;
            r0 = 0
            com.turbomanage.httpclient.RequestHandler r1 = r3.requestHandler     // Catch:{ all -> 0x001d }
            java.io.InputStream r1 = r1.openInput(r4)     // Catch:{ all -> 0x001d }
            if (r1 == 0) goto L_0x000f
            com.turbomanage.httpclient.RequestHandler r0 = r3.requestHandler     // Catch:{ all -> 0x001a }
            byte[] r0 = r0.readStream(r1)     // Catch:{ all -> 0x001a }
        L_0x000f:
            com.turbomanage.httpclient.HttpResponse r2 = new com.turbomanage.httpclient.HttpResponse     // Catch:{ all -> 0x001a }
            r2.<init>(r4, r0)     // Catch:{ all -> 0x001a }
            if (r1 == 0) goto L_0x0019
            r1.close()     // Catch:{ Exception -> 0x0019 }
        L_0x0019:
            return r2
        L_0x001a:
            r4 = move-exception
            r0 = r1
            goto L_0x001e
        L_0x001d:
            r4 = move-exception
        L_0x001e:
            if (r0 == 0) goto L_0x0023
            r0.close()     // Catch:{ Exception -> 0x0023 }
        L_0x0023:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.turbomanage.httpclient.AbstractHttpClient.readInputStream(java.net.HttpURLConnection):com.turbomanage.httpclient.HttpResponse");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: byte[]} */
    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v1, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x001e A[SYNTHETIC, Splitter:B:16:0x001e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.turbomanage.httpclient.HttpResponse readErrorStream(java.net.HttpURLConnection r4) throws java.lang.Exception {
        /*
            r3 = this;
            r0 = 0
            java.io.InputStream r1 = r4.getErrorStream()     // Catch:{ all -> 0x001b }
            if (r1 == 0) goto L_0x000d
            com.turbomanage.httpclient.RequestHandler r0 = r3.requestHandler     // Catch:{ all -> 0x0018 }
            byte[] r0 = r0.readStream(r1)     // Catch:{ all -> 0x0018 }
        L_0x000d:
            com.turbomanage.httpclient.HttpResponse r2 = new com.turbomanage.httpclient.HttpResponse     // Catch:{ all -> 0x0018 }
            r2.<init>(r4, r0)     // Catch:{ all -> 0x0018 }
            if (r1 == 0) goto L_0x0017
            r1.close()     // Catch:{ Exception -> 0x0017 }
        L_0x0017:
            return r2
        L_0x0018:
            r4 = move-exception
            r0 = r1
            goto L_0x001c
        L_0x001b:
            r4 = move-exception
        L_0x001c:
            if (r0 == 0) goto L_0x0021
            r0.close()     // Catch:{ Exception -> 0x0021 }
        L_0x0021:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.turbomanage.httpclient.AbstractHttpClient.readErrorStream(java.net.HttpURLConnection):com.turbomanage.httpclient.HttpResponse");
    }

    public ParameterMap newParams() {
        return new ParameterMap();
    }

    public AbstractHttpClient addHeader(String str, String str2) {
        this.requestHeaders.put(str, str2);
        return this;
    }

    public void clearHeaders() {
        this.requestHeaders.clear();
    }

    public static CookieManager getCookieManager() {
        return (CookieManager) CookieHandler.getDefault();
    }

    public void setRequestLogger(RequestLogger requestLogger2) {
        this.requestLogger = requestLogger2;
    }

    public static void ensureCookieManager() {
        if (CookieHandler.getDefault() == null) {
            CookieHandler.setDefault(new CookieManager());
        }
    }

    /* access modifiers changed from: protected */
    public boolean isTimeoutException(Throwable th, long j) {
        long currentTimeMillis = (System.currentTimeMillis() - j) + 10;
        if (this.requestLogger.isLoggingEnabled()) {
            RequestLogger requestLogger2 = this.requestLogger;
            requestLogger2.log("ELAPSED TIME = " + currentTimeMillis + ", CT = " + this.connectionTimeout + ", RT = " + this.readTimeout);
        }
        if (this.isConnected) {
            if (currentTimeMillis >= ((long) this.readTimeout)) {
                return true;
            }
            return false;
        } else if (currentTimeMillis >= ((long) this.connectionTimeout)) {
            return true;
        } else {
            return false;
        }
    }

    public void setConnectionTimeout(int i) {
        this.connectionTimeout = i;
    }

    public void setReadTimeout(int i) {
        this.readTimeout = i;
    }
}
