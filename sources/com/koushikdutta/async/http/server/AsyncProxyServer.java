package com.koushikdutta.async.http.server;

import com.koushikdutta.async.AsyncServer;
import com.koushikdutta.async.http.AsyncHttpClient;

public class AsyncProxyServer extends AsyncHttpServer {

    /* renamed from: h */
    AsyncHttpClient f55430h;

    /* access modifiers changed from: protected */
    public boolean onRequest(AsyncHttpServerRequest asyncHttpServerRequest, AsyncHttpServerResponse asyncHttpServerResponse) {
        return true;
    }

    public AsyncProxyServer(AsyncServer asyncServer) {
        this.f55430h = new AsyncHttpClient(asyncServer);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        r6 = r7.getHeaders().get(com.google.common.net.HttpHeaders.HOST);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0027, code lost:
        r0 = 80;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002b, code lost:
        if (r6 != null) goto L_0x002d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        r3 = r6.split(":", 2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0033, code lost:
        if (r3.length == 2) goto L_0x0035;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0035, code lost:
        r6 = r3[0];
        r0 = java.lang.Integer.parseInt(r3[1]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003f, code lost:
        r6 = android.net.Uri.parse("http://" + r6 + ":" + r0 + r7.getPath());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0079, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x007a, code lost:
        r8.code(500);
        r8.send(r6.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x001d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onRequest(com.koushikdutta.async.http.server.HttpServerRequestCallback r6, com.koushikdutta.async.http.server.AsyncHttpServerRequest r7, final com.koushikdutta.async.http.server.AsyncHttpServerResponse r8) {
        /*
            r5 = this;
            super.onRequest(r6, r7, r8)
            if (r6 == 0) goto L_0x0006
            return
        L_0x0006:
            java.lang.String r6 = r7.getPath()     // Catch:{ Exception -> 0x001d }
            android.net.Uri r6 = android.net.Uri.parse(r6)     // Catch:{ Exception -> 0x001d }
            java.lang.String r0 = r6.getScheme()     // Catch:{ Exception -> 0x001d }
            if (r0 == 0) goto L_0x0015
            goto L_0x0061
        L_0x0015:
            java.lang.Exception r6 = new java.lang.Exception     // Catch:{ Exception -> 0x001d }
            java.lang.String r0 = "no host or full uri provided"
            r6.<init>(r0)     // Catch:{ Exception -> 0x001d }
            throw r6     // Catch:{ Exception -> 0x001d }
        L_0x001d:
            com.koushikdutta.async.http.Headers r6 = r7.getHeaders()     // Catch:{ Exception -> 0x0079 }
            java.lang.String r0 = "Host"
            java.lang.String r6 = r6.get(r0)     // Catch:{ Exception -> 0x0079 }
            r0 = 80
            java.lang.String r1 = ":"
            if (r6 == 0) goto L_0x003f
            r2 = 2
            java.lang.String[] r3 = r6.split(r1, r2)     // Catch:{ Exception -> 0x0079 }
            int r4 = r3.length     // Catch:{ Exception -> 0x0079 }
            if (r4 != r2) goto L_0x003f
            r6 = 0
            r6 = r3[r6]     // Catch:{ Exception -> 0x0079 }
            r0 = 1
            r0 = r3[r0]     // Catch:{ Exception -> 0x0079 }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ Exception -> 0x0079 }
        L_0x003f:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0079 }
            r2.<init>()     // Catch:{ Exception -> 0x0079 }
            java.lang.String r3 = "http://"
            r2.append(r3)     // Catch:{ Exception -> 0x0079 }
            r2.append(r6)     // Catch:{ Exception -> 0x0079 }
            r2.append(r1)     // Catch:{ Exception -> 0x0079 }
            r2.append(r0)     // Catch:{ Exception -> 0x0079 }
            java.lang.String r6 = r7.getPath()     // Catch:{ Exception -> 0x0079 }
            r2.append(r6)     // Catch:{ Exception -> 0x0079 }
            java.lang.String r6 = r2.toString()     // Catch:{ Exception -> 0x0079 }
            android.net.Uri r6 = android.net.Uri.parse(r6)     // Catch:{ Exception -> 0x0079 }
        L_0x0061:
            com.koushikdutta.async.http.AsyncHttpClient r0 = r5.f55430h     // Catch:{ Exception -> 0x0079 }
            com.koushikdutta.async.http.AsyncHttpRequest r1 = new com.koushikdutta.async.http.AsyncHttpRequest     // Catch:{ Exception -> 0x0079 }
            java.lang.String r2 = r7.getMethod()     // Catch:{ Exception -> 0x0079 }
            com.koushikdutta.async.http.Headers r7 = r7.getHeaders()     // Catch:{ Exception -> 0x0079 }
            r1.<init>(r6, r2, r7)     // Catch:{ Exception -> 0x0079 }
            com.koushikdutta.async.http.server.AsyncProxyServer$1 r6 = new com.koushikdutta.async.http.server.AsyncProxyServer$1     // Catch:{ Exception -> 0x0079 }
            r6.<init>(r8)     // Catch:{ Exception -> 0x0079 }
            r0.execute((com.koushikdutta.async.http.AsyncHttpRequest) r1, (com.koushikdutta.async.http.callback.HttpConnectCallback) r6)     // Catch:{ Exception -> 0x0079 }
            goto L_0x0086
        L_0x0079:
            r6 = move-exception
            r7 = 500(0x1f4, float:7.0E-43)
            r8.code(r7)
            java.lang.String r6 = r6.getMessage()
            r8.send((java.lang.String) r6)
        L_0x0086:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.koushikdutta.async.http.server.AsyncProxyServer.onRequest(com.koushikdutta.async.http.server.HttpServerRequestCallback, com.koushikdutta.async.http.server.AsyncHttpServerRequest, com.koushikdutta.async.http.server.AsyncHttpServerResponse):void");
    }
}
