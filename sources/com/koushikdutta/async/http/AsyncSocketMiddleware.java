package com.koushikdutta.async.http;

import android.net.Uri;
import com.koushikdutta.async.AsyncServer;
import com.koushikdutta.async.AsyncSocket;
import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.ConnectCallback;
import com.koushikdutta.async.callback.DataCallback;
import com.koushikdutta.async.callback.WritableCallback;
import com.koushikdutta.async.future.Future;
import com.koushikdutta.async.future.Futures;
import com.koushikdutta.async.future.SimpleCancellable;
import com.koushikdutta.async.future.SimpleFuture;
import com.koushikdutta.async.future.ThenFutureCallback;
import com.koushikdutta.async.http.AsyncHttpClientMiddleware;
import com.koushikdutta.async.util.ArrayDeque;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.Hashtable;
import java.util.Locale;

public class AsyncSocketMiddleware extends SimpleMiddleware {

    /* renamed from: a */
    String f55283a;

    /* renamed from: b */
    int f55284b;

    /* renamed from: c */
    int f55285c;

    /* renamed from: d */
    boolean f55286d;

    /* renamed from: e */
    String f55287e;

    /* renamed from: f */
    int f55288f;

    /* renamed from: g */
    InetSocketAddress f55289g;

    /* renamed from: h */
    Hashtable<String, ConnectionInfo> f55290h;

    /* renamed from: i */
    int f55291i;
    protected AsyncHttpClient mClient;

    /* access modifiers changed from: protected */
    public ConnectCallback wrapCallback(AsyncHttpClientMiddleware.GetSocketData getSocketData, Uri uri, int i, boolean z, ConnectCallback connectCallback) {
        return connectCallback;
    }

    public AsyncSocketMiddleware(AsyncHttpClient asyncHttpClient, String str, int i) {
        this.f55285c = 300000;
        this.f55290h = new Hashtable<>();
        this.f55291i = Integer.MAX_VALUE;
        this.mClient = asyncHttpClient;
        this.f55283a = str;
        this.f55284b = i;
    }

    public void setIdleTimeoutMs(int i) {
        this.f55285c = i;
    }

    public int getSchemePort(Uri uri) {
        if (uri.getScheme() == null || !uri.getScheme().equals(this.f55283a)) {
            return -1;
        }
        if (uri.getPort() == -1) {
            return this.f55284b;
        }
        return uri.getPort();
    }

    public AsyncSocketMiddleware(AsyncHttpClient asyncHttpClient) {
        this(asyncHttpClient, "http", 80);
    }

    public boolean getConnectAllAddresses() {
        return this.f55286d;
    }

    public void setConnectAllAddresses(boolean z) {
        this.f55286d = z;
    }

    public void disableProxy() {
        this.f55288f = -1;
        this.f55287e = null;
        this.f55289g = null;
    }

    public void enableProxy(String str, int i) {
        this.f55287e = str;
        this.f55288f = i;
        this.f55289g = null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo164122a(Uri uri, int i, String str, int i2) {
        String str2;
        if (str != null) {
            str2 = str + ":" + i2;
        } else {
            str2 = "";
        }
        if (str != null) {
            str2 = str + ":" + i2;
        }
        return uri.getScheme() + "//" + uri.getHost() + ":" + i + "?proxy=" + str2;
    }

    class IdleSocketHolder {
        long idleTime = System.currentTimeMillis();
        AsyncSocket socket;

        public IdleSocketHolder(AsyncSocket asyncSocket) {
            this.socket = asyncSocket;
        }
    }

    static class ConnectionInfo {
        int openCount;
        ArrayDeque<AsyncHttpClientMiddleware.GetSocketData> queue = new ArrayDeque<>();
        ArrayDeque<IdleSocketHolder> sockets = new ArrayDeque<>();

        ConnectionInfo() {
        }
    }

    public int getMaxConnectionCount() {
        return this.f55291i;
    }

    public void setMaxConnectionCount(int i) {
        this.f55291i = i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0090, code lost:
        if (r11.f55286d == false) goto L_0x00d8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0094, code lost:
        if (r11.f55287e != null) goto L_0x00d8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x009c, code lost:
        if (r12.request.getProxyHost() == null) goto L_0x009f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x009f, code lost:
        r12.request.logv("Resolving domain and connecting to all available addresses");
        r0 = new com.koushikdutta.async.future.SimpleFuture();
        r0.setComplete(r11.mClient.getServer().getAllByName(r3.getHost()).then(new com.koushikdutta.async.http.$$Lambda$AsyncSocketMiddleware$e2Cx3NXDSl7U9BmK06nRm3AFryc(r11, r4, r12)).fail(new com.koushikdutta.async.http.$$Lambda$AsyncSocketMiddleware$LTVWTaY6UddLJvoKjqepmTkUEz4(r11, r12, r3, r4))).setCallback(new com.koushikdutta.async.http.$$Lambda$AsyncSocketMiddleware$VJqDaFcbHMA4IrL0_f2gFZsSA(r11, r12, r3, r4));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00d7, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00d8, code lost:
        r12.request.logd("Connecting socket");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00e6, code lost:
        if (r12.request.getProxyHost() != null) goto L_0x00f5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00ea, code lost:
        if (r11.f55287e == null) goto L_0x00f5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00ec, code lost:
        r12.request.enableProxy(r11.f55287e, r11.f55288f);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00fb, code lost:
        if (r12.request.getProxyHost() == null) goto L_0x010b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00fd, code lost:
        r0 = r12.request.getProxyHost();
        r7 = r12.request.getProxyPort();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x010b, code lost:
        r0 = r3.getHost();
        r7 = r4;
        r5 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0112, code lost:
        if (r5 == false) goto L_0x0132;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0114, code lost:
        r12.request.logv("Using proxy: " + r0 + ":" + r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0144, code lost:
        return r11.mClient.getServer().connectSocket(r0, r7, wrapCallback(r12, r3, r4, r5, r12.connectCallback));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.koushikdutta.async.future.Cancellable getSocket(com.koushikdutta.async.http.AsyncHttpClientMiddleware.GetSocketData r12) {
        /*
            r11 = this;
            com.koushikdutta.async.http.AsyncHttpRequest r0 = r12.request
            android.net.Uri r3 = r0.getUri()
            com.koushikdutta.async.http.AsyncHttpRequest r0 = r12.request
            android.net.Uri r0 = r0.getUri()
            int r4 = r11.getSchemePort(r0)
            r0 = 0
            r1 = -1
            if (r4 != r1) goto L_0x0015
            return r0
        L_0x0015:
            com.koushikdutta.async.util.UntypedHashtable r1 = r12.state
            java.lang.String r2 = "socket-owner"
            r1.put(r2, r11)
            com.koushikdutta.async.http.AsyncHttpRequest r1 = r12.request
            java.lang.String r1 = r1.getProxyHost()
            com.koushikdutta.async.http.AsyncHttpRequest r2 = r12.request
            int r2 = r2.getProxyPort()
            java.lang.String r1 = r11.mo164122a((android.net.Uri) r3, (int) r4, (java.lang.String) r1, (int) r2)
            com.koushikdutta.async.http.AsyncSocketMiddleware$ConnectionInfo r1 = r11.m39850a((java.lang.String) r1)
            monitor-enter(r11)
            int r2 = r1.openCount     // Catch:{ all -> 0x0145 }
            int r5 = r11.f55291i     // Catch:{ all -> 0x0145 }
            if (r2 < r5) goto L_0x0043
            com.koushikdutta.async.future.SimpleCancellable r0 = new com.koushikdutta.async.future.SimpleCancellable     // Catch:{ all -> 0x0145 }
            r0.<init>()     // Catch:{ all -> 0x0145 }
            com.koushikdutta.async.util.ArrayDeque<com.koushikdutta.async.http.AsyncHttpClientMiddleware$GetSocketData> r1 = r1.queue     // Catch:{ all -> 0x0145 }
            r1.add(r12)     // Catch:{ all -> 0x0145 }
            monitor-exit(r11)     // Catch:{ all -> 0x0145 }
            return r0
        L_0x0043:
            int r2 = r1.openCount     // Catch:{ all -> 0x0145 }
            r5 = 1
            int r2 = r2 + r5
            r1.openCount = r2     // Catch:{ all -> 0x0145 }
        L_0x0049:
            com.koushikdutta.async.util.ArrayDeque<com.koushikdutta.async.http.AsyncSocketMiddleware$IdleSocketHolder> r2 = r1.sockets     // Catch:{ all -> 0x0145 }
            boolean r2 = r2.isEmpty()     // Catch:{ all -> 0x0145 }
            if (r2 != 0) goto L_0x008d
            com.koushikdutta.async.util.ArrayDeque<com.koushikdutta.async.http.AsyncSocketMiddleware$IdleSocketHolder> r2 = r1.sockets     // Catch:{ all -> 0x0145 }
            java.lang.Object r2 = r2.pop()     // Catch:{ all -> 0x0145 }
            com.koushikdutta.async.http.AsyncSocketMiddleware$IdleSocketHolder r2 = (com.koushikdutta.async.http.AsyncSocketMiddleware.IdleSocketHolder) r2     // Catch:{ all -> 0x0145 }
            com.koushikdutta.async.AsyncSocket r6 = r2.socket     // Catch:{ all -> 0x0145 }
            long r7 = r2.idleTime     // Catch:{ all -> 0x0145 }
            int r2 = r11.f55285c     // Catch:{ all -> 0x0145 }
            long r9 = (long) r2     // Catch:{ all -> 0x0145 }
            long r7 = r7 + r9
            long r9 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0145 }
            int r2 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r2 >= 0) goto L_0x0070
            r6.setClosedCallback(r0)     // Catch:{ all -> 0x0145 }
            r6.close()     // Catch:{ all -> 0x0145 }
            goto L_0x0049
        L_0x0070:
            boolean r2 = r6.isOpen()     // Catch:{ all -> 0x0145 }
            if (r2 != 0) goto L_0x0077
            goto L_0x0049
        L_0x0077:
            com.koushikdutta.async.http.AsyncHttpRequest r1 = r12.request     // Catch:{ all -> 0x0145 }
            java.lang.String r2 = "Reusing keep-alive socket"
            r1.logd(r2)     // Catch:{ all -> 0x0145 }
            com.koushikdutta.async.callback.ConnectCallback r12 = r12.connectCallback     // Catch:{ all -> 0x0145 }
            r12.onConnectCompleted(r0, r6)     // Catch:{ all -> 0x0145 }
            com.koushikdutta.async.future.SimpleCancellable r12 = new com.koushikdutta.async.future.SimpleCancellable     // Catch:{ all -> 0x0145 }
            r12.<init>()     // Catch:{ all -> 0x0145 }
            r12.setComplete()     // Catch:{ all -> 0x0145 }
            monitor-exit(r11)     // Catch:{ all -> 0x0145 }
            return r12
        L_0x008d:
            monitor-exit(r11)     // Catch:{ all -> 0x0145 }
            boolean r0 = r11.f55286d
            if (r0 == 0) goto L_0x00d8
            java.lang.String r0 = r11.f55287e
            if (r0 != 0) goto L_0x00d8
            com.koushikdutta.async.http.AsyncHttpRequest r0 = r12.request
            java.lang.String r0 = r0.getProxyHost()
            if (r0 == 0) goto L_0x009f
            goto L_0x00d8
        L_0x009f:
            com.koushikdutta.async.http.AsyncHttpRequest r0 = r12.request
            java.lang.String r1 = "Resolving domain and connecting to all available addresses"
            r0.logv(r1)
            com.koushikdutta.async.future.SimpleFuture r0 = new com.koushikdutta.async.future.SimpleFuture
            r0.<init>()
            com.koushikdutta.async.http.AsyncHttpClient r1 = r11.mClient
            com.koushikdutta.async.AsyncServer r1 = r1.getServer()
            java.lang.String r2 = r3.getHost()
            com.koushikdutta.async.future.Future r1 = r1.getAllByName(r2)
            com.koushikdutta.async.http.-$$Lambda$AsyncSocketMiddleware$e2Cx3NXDSl7U9BmK06nRm3AFryc r2 = new com.koushikdutta.async.http.-$$Lambda$AsyncSocketMiddleware$e2Cx3NXDSl7U9BmK06nRm3AFryc
            r2.<init>(r4, r12)
            com.koushikdutta.async.future.Future r1 = r1.then(r2)
            com.koushikdutta.async.http.-$$Lambda$AsyncSocketMiddleware$LTVWTaY6UddLJvoKjqepmTkUEz4 r2 = new com.koushikdutta.async.http.-$$Lambda$AsyncSocketMiddleware$LTVWTaY6UddLJvoKjqepmTkUEz4
            r2.<init>(r12, r3, r4)
            com.koushikdutta.async.future.Future r1 = r1.fail(r2)
            com.koushikdutta.async.future.Future r1 = r0.setComplete(r1)
            com.koushikdutta.async.http.-$$Lambda$AsyncSocketMiddleware$VJqDaFcbHMA4IrL0-_f-2gFZsSA r2 = new com.koushikdutta.async.http.-$$Lambda$AsyncSocketMiddleware$VJqDaFcbHMA4IrL0-_f-2gFZsSA
            r2.<init>(r12, r3, r4)
            r1.setCallback(r2)
            return r0
        L_0x00d8:
            com.koushikdutta.async.http.AsyncHttpRequest r0 = r12.request
            java.lang.String r1 = "Connecting socket"
            r0.logd(r1)
            r0 = 0
            com.koushikdutta.async.http.AsyncHttpRequest r1 = r12.request
            java.lang.String r1 = r1.getProxyHost()
            if (r1 != 0) goto L_0x00f5
            java.lang.String r1 = r11.f55287e
            if (r1 == 0) goto L_0x00f5
            com.koushikdutta.async.http.AsyncHttpRequest r1 = r12.request
            java.lang.String r2 = r11.f55287e
            int r6 = r11.f55288f
            r1.enableProxy(r2, r6)
        L_0x00f5:
            com.koushikdutta.async.http.AsyncHttpRequest r1 = r12.request
            java.lang.String r1 = r1.getProxyHost()
            if (r1 == 0) goto L_0x010b
            com.koushikdutta.async.http.AsyncHttpRequest r0 = r12.request
            java.lang.String r0 = r0.getProxyHost()
            com.koushikdutta.async.http.AsyncHttpRequest r1 = r12.request
            int r1 = r1.getProxyPort()
            r7 = r1
            goto L_0x0112
        L_0x010b:
            java.lang.String r1 = r3.getHost()
            r0 = r1
            r7 = r4
            r5 = 0
        L_0x0112:
            if (r5 == 0) goto L_0x0132
            com.koushikdutta.async.http.AsyncHttpRequest r1 = r12.request
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r6 = "Using proxy: "
            r2.append(r6)
            r2.append(r0)
            java.lang.String r6 = ":"
            r2.append(r6)
            r2.append(r7)
            java.lang.String r2 = r2.toString()
            r1.logv(r2)
        L_0x0132:
            com.koushikdutta.async.http.AsyncHttpClient r1 = r11.mClient
            com.koushikdutta.async.AsyncServer r8 = r1.getServer()
            com.koushikdutta.async.callback.ConnectCallback r6 = r12.connectCallback
            r1 = r11
            r2 = r12
            com.koushikdutta.async.callback.ConnectCallback r12 = r1.wrapCallback(r2, r3, r4, r5, r6)
            com.koushikdutta.async.future.Cancellable r12 = r8.connectSocket(r0, r7, r12)
            return r12
        L_0x0145:
            r12 = move-exception
            monitor-exit(r11)     // Catch:{ all -> 0x0145 }
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.koushikdutta.async.http.AsyncSocketMiddleware.getSocket(com.koushikdutta.async.http.AsyncHttpClientMiddleware$GetSocketData):com.koushikdutta.async.future.Cancellable");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ Future m39849a(int i, AsyncHttpClientMiddleware.GetSocketData getSocketData, InetAddress[] inetAddressArr) throws Exception {
        return Futures.loopUntil((F[]) inetAddressArr, new ThenFutureCallback(i, getSocketData) {
            public final /* synthetic */ int f$1;
            public final /* synthetic */ AsyncHttpClientMiddleware.GetSocketData f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final Future then(Object obj) {
                return AsyncSocketMiddleware.this.m39848a(this.f$1, this.f$2, (InetAddress) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ Future m39848a(int i, AsyncHttpClientMiddleware.GetSocketData getSocketData, InetAddress inetAddress) throws Exception {
        SimpleFuture simpleFuture = new SimpleFuture();
        String format = String.format(Locale.ENGLISH, "%s:%s", new Object[]{inetAddress, Integer.valueOf(i)});
        AsyncHttpRequest asyncHttpRequest = getSocketData.request;
        asyncHttpRequest.logv("attempting connection to " + format);
        AsyncServer server = this.mClient.getServer();
        InetSocketAddress inetSocketAddress = new InetSocketAddress(inetAddress, i);
        simpleFuture.getClass();
        server.connectSocket(inetSocketAddress, new ConnectCallback() {
            public final void onConnectCompleted(Exception exc, AsyncSocket asyncSocket) {
                SimpleFuture.this.setComplete(exc, asyncSocket);
            }
        });
        return simpleFuture;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m39853a(AsyncHttpClientMiddleware.GetSocketData getSocketData, Uri uri, int i, Exception exc) throws Exception {
        wrapCallback(getSocketData, uri, i, false, getSocketData.connectCallback).onConnectCompleted(exc, (AsyncSocket) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m39854a(AsyncHttpClientMiddleware.GetSocketData getSocketData, Uri uri, int i, Exception exc, AsyncSocket asyncSocket) {
        if (asyncSocket != null) {
            if (exc == null) {
                wrapCallback(getSocketData, uri, i, false, getSocketData.connectCallback).onConnectCompleted((Exception) null, asyncSocket);
                return;
            }
            getSocketData.request.logd("Recycling extra socket leftover from cancelled operation");
            m39851a(asyncSocket);
            m39852a(asyncSocket, getSocketData.request);
        }
    }

    /* renamed from: a */
    private ConnectionInfo m39850a(String str) {
        ConnectionInfo connectionInfo = this.f55290h.get(str);
        if (connectionInfo != null) {
            return connectionInfo;
        }
        ConnectionInfo connectionInfo2 = new ConnectionInfo();
        this.f55290h.put(str, connectionInfo2);
        return connectionInfo2;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m39857b(String str) {
        ConnectionInfo connectionInfo = this.f55290h.get(str);
        if (connectionInfo != null) {
            while (!connectionInfo.sockets.isEmpty()) {
                IdleSocketHolder peekLast = connectionInfo.sockets.peekLast();
                AsyncSocket asyncSocket = peekLast.socket;
                if (peekLast.idleTime + ((long) this.f55285c) > System.currentTimeMillis()) {
                    break;
                }
                connectionInfo.sockets.pop();
                asyncSocket.setClosedCallback((CompletedCallback) null);
                asyncSocket.close();
            }
            if (connectionInfo.openCount == 0 && connectionInfo.queue.isEmpty() && connectionInfo.sockets.isEmpty()) {
                this.f55290h.remove(str);
            }
        }
    }

    /* renamed from: a */
    private void m39852a(AsyncSocket asyncSocket, AsyncHttpRequest asyncHttpRequest) {
        final ArrayDeque<IdleSocketHolder> arrayDeque;
        if (asyncSocket != null) {
            Uri uri = asyncHttpRequest.getUri();
            final String a = mo164122a(uri, getSchemePort(uri), asyncHttpRequest.getProxyHost(), asyncHttpRequest.getProxyPort());
            final IdleSocketHolder idleSocketHolder = new IdleSocketHolder(asyncSocket);
            synchronized (this) {
                arrayDeque = m39850a(a).sockets;
                arrayDeque.push(idleSocketHolder);
            }
            asyncSocket.setClosedCallback(new CompletedCallback() {
                public void onCompleted(Exception exc) {
                    synchronized (AsyncSocketMiddleware.this) {
                        arrayDeque.remove(idleSocketHolder);
                        AsyncSocketMiddleware.this.m39857b(a);
                    }
                }
            });
        }
    }

    /* renamed from: a */
    private void m39851a(final AsyncSocket asyncSocket) {
        asyncSocket.setEndCallback(new CompletedCallback() {
            public void onCompleted(Exception exc) {
                asyncSocket.setClosedCallback((CompletedCallback) null);
                asyncSocket.close();
            }
        });
        asyncSocket.setWriteableCallback((WritableCallback) null);
        asyncSocket.setDataCallback(new DataCallback.NullDataCallback() {
            public void onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
                super.onDataAvailable(dataEmitter, byteBufferList);
                byteBufferList.recycle();
                asyncSocket.setClosedCallback((CompletedCallback) null);
                asyncSocket.close();
            }
        });
    }

    /* renamed from: a */
    private void m39855a(AsyncHttpRequest asyncHttpRequest) {
        Uri uri = asyncHttpRequest.getUri();
        String a = mo164122a(uri, getSchemePort(uri), asyncHttpRequest.getProxyHost(), asyncHttpRequest.getProxyPort());
        synchronized (this) {
            ConnectionInfo connectionInfo = this.f55290h.get(a);
            if (connectionInfo != null) {
                connectionInfo.openCount--;
                while (connectionInfo.openCount < this.f55291i && connectionInfo.queue.size() > 0) {
                    AsyncHttpClientMiddleware.GetSocketData remove = connectionInfo.queue.remove();
                    SimpleCancellable simpleCancellable = (SimpleCancellable) remove.socketCancellable;
                    if (!simpleCancellable.isCancelled()) {
                        simpleCancellable.setParent(getSocket(remove));
                    }
                }
                m39857b(a);
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean isKeepAlive(AsyncHttpClientMiddleware.OnResponseCompleteData onResponseCompleteData) {
        return HttpUtil.isKeepAlive(onResponseCompleteData.response.protocol(), onResponseCompleteData.response.headers()) && HttpUtil.isKeepAlive(Protocol.HTTP_1_1, onResponseCompleteData.request.getHeaders());
    }

    public void onResponseComplete(AsyncHttpClientMiddleware.OnResponseCompleteData onResponseCompleteData) {
        if (onResponseCompleteData.state.get("socket-owner") == this) {
            try {
                m39851a(onResponseCompleteData.socket);
                if (onResponseCompleteData.exception == null) {
                    if (onResponseCompleteData.socket.isOpen()) {
                        if (!isKeepAlive(onResponseCompleteData)) {
                            onResponseCompleteData.request.logv("closing out socket (not keep alive)");
                            onResponseCompleteData.socket.setClosedCallback((CompletedCallback) null);
                            onResponseCompleteData.socket.close();
                        }
                        onResponseCompleteData.request.logd("Recycling keep-alive socket");
                        m39852a(onResponseCompleteData.socket, onResponseCompleteData.request);
                        m39855a(onResponseCompleteData.request);
                        return;
                    }
                }
                onResponseCompleteData.request.logv("closing out socket (exception)");
                onResponseCompleteData.socket.setClosedCallback((CompletedCallback) null);
                onResponseCompleteData.socket.close();
            } finally {
                m39855a(onResponseCompleteData.request);
            }
        }
    }
}
