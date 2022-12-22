package com.koushikdutta.async.http;

import android.net.Uri;
import android.text.TextUtils;
import com.koushikdutta.async.AsyncSSLSocket;
import com.koushikdutta.async.AsyncSSLSocketWrapper;
import com.koushikdutta.async.AsyncSocket;
import com.koushikdutta.async.C20137Util;
import com.koushikdutta.async.DataSink;
import com.koushikdutta.async.LineEmitter;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.ConnectCallback;
import com.koushikdutta.async.callback.DataCallback;
import com.koushikdutta.async.http.AsyncHttpClientMiddleware;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

public class AsyncSSLSocketMiddleware extends AsyncSocketMiddleware {
    protected List<AsyncSSLEngineConfigurator> engineConfigurators = new ArrayList();
    protected HostnameVerifier hostnameVerifier;
    protected SSLContext sslContext;
    protected TrustManager[] trustManagers;

    public AsyncSSLSocketMiddleware(AsyncHttpClient asyncHttpClient) {
        super(asyncHttpClient, "https", 443);
    }

    public void setSSLContext(SSLContext sSLContext) {
        this.sslContext = sSLContext;
    }

    public SSLContext getSSLContext() {
        SSLContext sSLContext = this.sslContext;
        return sSLContext != null ? sSLContext : AsyncSSLSocketWrapper.getDefaultSSLContext();
    }

    public void setTrustManagers(TrustManager[] trustManagerArr) {
        this.trustManagers = trustManagerArr;
    }

    public void setHostnameVerifier(HostnameVerifier hostnameVerifier2) {
        this.hostnameVerifier = hostnameVerifier2;
    }

    public void addEngineConfigurator(AsyncSSLEngineConfigurator asyncSSLEngineConfigurator) {
        this.engineConfigurators.add(asyncSSLEngineConfigurator);
    }

    public void clearEngineConfigurators() {
        this.engineConfigurators.clear();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:1:0x000b A[LOOP:0: B:1:0x000b->B:4:0x001b, LOOP_START, PHI: r2 
      PHI: (r2v1 javax.net.ssl.SSLEngine) = (r2v0 javax.net.ssl.SSLEngine), (r2v5 javax.net.ssl.SSLEngine) binds: [B:0:0x0000, B:4:0x001b] A[DONT_GENERATE, DONT_INLINE]] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public javax.net.ssl.SSLEngine createConfiguredSSLEngine(com.koushikdutta.async.http.AsyncHttpClientMiddleware.GetSocketData r5, java.lang.String r6, int r7) {
        /*
            r4 = this;
            javax.net.ssl.SSLContext r0 = r4.getSSLContext()
            java.util.List<com.koushikdutta.async.http.AsyncSSLEngineConfigurator> r1 = r4.engineConfigurators
            java.util.Iterator r1 = r1.iterator()
            r2 = 0
        L_0x000b:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x001d
            java.lang.Object r2 = r1.next()
            com.koushikdutta.async.http.AsyncSSLEngineConfigurator r2 = (com.koushikdutta.async.http.AsyncSSLEngineConfigurator) r2
            javax.net.ssl.SSLEngine r2 = r2.createEngine(r0, r6, r7)
            if (r2 == 0) goto L_0x000b
        L_0x001d:
            java.util.List<com.koushikdutta.async.http.AsyncSSLEngineConfigurator> r0 = r4.engineConfigurators
            java.util.Iterator r0 = r0.iterator()
        L_0x0023:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0033
            java.lang.Object r1 = r0.next()
            com.koushikdutta.async.http.AsyncSSLEngineConfigurator r1 = (com.koushikdutta.async.http.AsyncSSLEngineConfigurator) r1
            r1.configureEngine(r2, r5, r6, r7)
            goto L_0x0023
        L_0x0033:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.koushikdutta.async.http.AsyncSSLSocketMiddleware.createConfiguredSSLEngine(com.koushikdutta.async.http.AsyncHttpClientMiddleware$GetSocketData, java.lang.String, int):javax.net.ssl.SSLEngine");
    }

    /* access modifiers changed from: protected */
    public AsyncSSLSocketWrapper.HandshakeCallback createHandshakeCallback(AsyncHttpClientMiddleware.GetSocketData getSocketData, final ConnectCallback connectCallback) {
        return new AsyncSSLSocketWrapper.HandshakeCallback() {
            public void onHandshakeCompleted(Exception exc, AsyncSSLSocket asyncSSLSocket) {
                connectCallback.onConnectCompleted(exc, asyncSSLSocket);
            }
        };
    }

    /* access modifiers changed from: protected */
    public void tryHandshake(AsyncSocket asyncSocket, AsyncHttpClientMiddleware.GetSocketData getSocketData, Uri uri, int i, ConnectCallback connectCallback) {
        AsyncSSLSocketWrapper.handshake(asyncSocket, uri.getHost(), i, createConfiguredSSLEngine(getSocketData, uri.getHost(), i), this.trustManagers, this.hostnameVerifier, true, createHandshakeCallback(getSocketData, connectCallback));
    }

    /* access modifiers changed from: protected */
    public ConnectCallback wrapCallback(AsyncHttpClientMiddleware.GetSocketData getSocketData, Uri uri, int i, boolean z, ConnectCallback connectCallback) {
        final ConnectCallback connectCallback2 = connectCallback;
        final boolean z2 = z;
        final AsyncHttpClientMiddleware.GetSocketData getSocketData2 = getSocketData;
        final Uri uri2 = uri;
        final int i2 = i;
        return new ConnectCallback() {
            public void onConnectCompleted(Exception exc, final AsyncSocket asyncSocket) {
                if (exc != null) {
                    connectCallback2.onConnectCompleted(exc, asyncSocket);
                } else if (!z2) {
                    AsyncSSLSocketMiddleware.this.tryHandshake(asyncSocket, getSocketData2, uri2, i2, connectCallback2);
                } else {
                    String format = String.format(Locale.ENGLISH, "CONNECT %s:%s HTTP/1.1\r\nHost: %s\r\n\r\n", new Object[]{uri2.getHost(), Integer.valueOf(i2), uri2.getHost()});
                    AsyncHttpRequest asyncHttpRequest = getSocketData2.request;
                    asyncHttpRequest.logv("Proxying: " + format);
                    C20137Util.writeAll((DataSink) asyncSocket, format.getBytes(), (CompletedCallback) new CompletedCallback() {
                        public void onCompleted(Exception exc) {
                            if (exc != null) {
                                connectCallback2.onConnectCompleted(exc, asyncSocket);
                                return;
                            }
                            LineEmitter lineEmitter = new LineEmitter();
                            lineEmitter.setLineCallback(new LineEmitter.StringCallback() {
                                String statusLine;

                                public void onStringAvailable(String str) {
                                    getSocketData2.request.logv(str);
                                    if (this.statusLine == null) {
                                        String trim = str.trim();
                                        this.statusLine = trim;
                                        if (!trim.matches("HTTP/1.\\d 2\\d\\d .*")) {
                                            asyncSocket.setDataCallback((DataCallback) null);
                                            asyncSocket.setEndCallback((CompletedCallback) null);
                                            ConnectCallback connectCallback = connectCallback2;
                                            connectCallback.onConnectCompleted(new IOException("non 2xx status line: " + this.statusLine), asyncSocket);
                                        }
                                    } else if (TextUtils.isEmpty(str.trim())) {
                                        asyncSocket.setDataCallback((DataCallback) null);
                                        asyncSocket.setEndCallback((CompletedCallback) null);
                                        AsyncSSLSocketMiddleware.this.tryHandshake(asyncSocket, getSocketData2, uri2, i2, connectCallback2);
                                    }
                                }
                            });
                            asyncSocket.setDataCallback(lineEmitter);
                            asyncSocket.setEndCallback(new CompletedCallback() {
                                public void onCompleted(Exception exc) {
                                    if (!asyncSocket.isOpen() && exc == null) {
                                        exc = new IOException("socket closed before proxy connect response");
                                    }
                                    connectCallback2.onConnectCompleted(exc, asyncSocket);
                                }
                            });
                        }
                    });
                }
            }
        };
    }
}
