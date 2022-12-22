package com.koushikdutta.async.http;

import android.os.Build;
import android.text.TextUtils;
import com.koushikdutta.async.AsyncServer;
import com.koushikdutta.async.AsyncSocket;
import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.ConnectCallback;
import com.koushikdutta.async.callback.DataCallback;
import com.koushikdutta.async.future.Cancellable;
import com.koushikdutta.async.future.Future;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.async.future.SimpleFuture;
import com.koushikdutta.async.http.AsyncHttpClient;
import com.koushikdutta.async.http.AsyncHttpClientMiddleware;
import com.koushikdutta.async.http.callback.HttpConnectCallback;
import com.koushikdutta.async.http.callback.RequestCallback;
import com.koushikdutta.async.parser.AsyncParser;
import com.koushikdutta.async.parser.ByteBufferListParser;
import com.koushikdutta.async.parser.JSONArrayParser;
import com.koushikdutta.async.parser.JSONObjectParser;
import com.koushikdutta.async.parser.StringParser;
import com.koushikdutta.async.stream.OutputStreamDataCallback;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.URI;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;
import org.json.JSONObject;

public class AsyncHttpClient {

    /* renamed from: f */
    static final /* synthetic */ boolean f55262f = (!AsyncHttpClient.class.desiredAssertionStatus());

    /* renamed from: g */
    private static AsyncHttpClient f55263g = null;

    /* renamed from: h */
    private static final String f55264h = "AsyncHttp";

    /* renamed from: a */
    final List<AsyncHttpClientMiddleware> f55265a = new CopyOnWriteArrayList();

    /* renamed from: b */
    AsyncSSLSocketMiddleware f55266b;

    /* renamed from: c */
    AsyncSocketMiddleware f55267c;

    /* renamed from: d */
    HttpTransportMiddleware f55268d;

    /* renamed from: e */
    AsyncServer f55269e;

    public static abstract class DownloadCallback extends RequestCallbackBase<ByteBufferList> {
    }

    public static abstract class FileCallback extends RequestCallbackBase<File> {
    }

    public static abstract class JSONArrayCallback extends RequestCallbackBase<JSONArray> {
    }

    public static abstract class JSONObjectCallback extends RequestCallbackBase<JSONObject> {
    }

    public static abstract class RequestCallbackBase<T> implements RequestCallback<T> {
        public void onConnect(AsyncHttpResponse asyncHttpResponse) {
        }

        public void onProgress(AsyncHttpResponse asyncHttpResponse, long j, long j2) {
        }
    }

    public static abstract class StringCallback extends RequestCallbackBase<String> {
    }

    public interface WebSocketConnectCallback {
        void onCompleted(Exception exc, WebSocket webSocket);
    }

    public static AsyncHttpClient getDefaultInstance() {
        if (f55263g == null) {
            f55263g = new AsyncHttpClient(AsyncServer.getDefault());
        }
        return f55263g;
    }

    public Collection<AsyncHttpClientMiddleware> getMiddleware() {
        return this.f55265a;
    }

    public void insertMiddleware(AsyncHttpClientMiddleware asyncHttpClientMiddleware) {
        this.f55265a.add(0, asyncHttpClientMiddleware);
    }

    public AsyncHttpClient(AsyncServer asyncServer) {
        this.f55269e = asyncServer;
        AsyncSocketMiddleware asyncSocketMiddleware = new AsyncSocketMiddleware(this);
        this.f55267c = asyncSocketMiddleware;
        insertMiddleware(asyncSocketMiddleware);
        AsyncSSLSocketMiddleware asyncSSLSocketMiddleware = new AsyncSSLSocketMiddleware(this);
        this.f55266b = asyncSSLSocketMiddleware;
        insertMiddleware(asyncSSLSocketMiddleware);
        HttpTransportMiddleware httpTransportMiddleware = new HttpTransportMiddleware();
        this.f55268d = httpTransportMiddleware;
        insertMiddleware(httpTransportMiddleware);
        this.f55266b.addEngineConfigurator(new SSLEngineSNIConfigurator());
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static void m39842c(AsyncHttpRequest asyncHttpRequest) {
        String str;
        if (asyncHttpRequest.f55273c == null) {
            try {
                List<Proxy> select = ProxySelector.getDefault().select(URI.create(asyncHttpRequest.getUri().toString()));
                if (!select.isEmpty()) {
                    Proxy proxy = select.get(0);
                    if (proxy.type() == Proxy.Type.HTTP && (proxy.address() instanceof InetSocketAddress)) {
                        InetSocketAddress inetSocketAddress = (InetSocketAddress) proxy.address();
                        if (Build.VERSION.SDK_INT >= 14) {
                            str = inetSocketAddress.getHostString();
                        } else {
                            InetAddress address = inetSocketAddress.getAddress();
                            if (address != null) {
                                str = address.getHostAddress();
                            } else {
                                str = inetSocketAddress.getHostName();
                            }
                        }
                        asyncHttpRequest.enableProxy(str, inetSocketAddress.getPort());
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public AsyncSocketMiddleware getSocketMiddleware() {
        return this.f55267c;
    }

    public AsyncSSLSocketMiddleware getSSLSocketMiddleware() {
        return this.f55266b;
    }

    public Future<AsyncHttpResponse> execute(AsyncHttpRequest asyncHttpRequest, HttpConnectCallback httpConnectCallback) {
        FutureAsyncHttpResponse futureAsyncHttpResponse = new FutureAsyncHttpResponse();
        m39829a(asyncHttpRequest, 0, futureAsyncHttpResponse, httpConnectCallback);
        return futureAsyncHttpResponse;
    }

    public Future<AsyncHttpResponse> execute(String str, HttpConnectCallback httpConnectCallback) {
        return execute((AsyncHttpRequest) new AsyncHttpGet(str), httpConnectCallback);
    }

    private class FutureAsyncHttpResponse extends SimpleFuture<AsyncHttpResponse> {
        public Cancellable scheduled;
        public AsyncSocket socket;
        public Runnable timeoutRunnable;

        private FutureAsyncHttpResponse() {
        }

        public boolean cancel() {
            if (!super.cancel()) {
                return false;
            }
            AsyncSocket asyncSocket = this.socket;
            if (asyncSocket != null) {
                asyncSocket.setDataCallback(new DataCallback.NullDataCallback());
                this.socket.close();
            }
            Cancellable cancellable = this.scheduled;
            if (cancellable == null) {
                return true;
            }
            cancellable.cancel();
            return true;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m39822a(FutureAsyncHttpResponse futureAsyncHttpResponse, Exception exc, C20198a aVar, AsyncHttpRequest asyncHttpRequest, HttpConnectCallback httpConnectCallback) {
        boolean z;
        if (f55262f || httpConnectCallback != null) {
            futureAsyncHttpResponse.scheduled.cancel();
            if (exc != null) {
                asyncHttpRequest.loge("Connection error", exc);
                z = futureAsyncHttpResponse.setComplete(exc);
            } else {
                asyncHttpRequest.logd("Connection successful");
                z = futureAsyncHttpResponse.setComplete(aVar);
            }
            if (z) {
                httpConnectCallback.onConnectCompleted(exc, aVar);
                if (!f55262f && exc == null && aVar.socket() != null && aVar.getDataCallback() == null && !aVar.isPaused()) {
                    throw new AssertionError();
                }
            } else if (aVar != null) {
                aVar.setDataCallback(new DataCallback.NullDataCallback());
                aVar.close();
            }
        } else {
            throw new AssertionError();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m39829a(AsyncHttpRequest asyncHttpRequest, int i, FutureAsyncHttpResponse futureAsyncHttpResponse, HttpConnectCallback httpConnectCallback) {
        if (this.f55269e.isAffinityThread()) {
            m39839b(asyncHttpRequest, i, futureAsyncHttpResponse, httpConnectCallback);
            return;
        }
        final AsyncHttpRequest asyncHttpRequest2 = asyncHttpRequest;
        final int i2 = i;
        final FutureAsyncHttpResponse futureAsyncHttpResponse2 = futureAsyncHttpResponse;
        final HttpConnectCallback httpConnectCallback2 = httpConnectCallback;
        this.f55269e.post(new Runnable() {
            public void run() {
                AsyncHttpClient.this.m39839b(asyncHttpRequest2, i2, futureAsyncHttpResponse2, httpConnectCallback2);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static long m39844d(AsyncHttpRequest asyncHttpRequest) {
        return (long) asyncHttpRequest.getTimeout();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m39840b(AsyncHttpRequest asyncHttpRequest, AsyncHttpRequest asyncHttpRequest2, String str) {
        String str2 = asyncHttpRequest.getHeaders().get(str);
        if (!TextUtils.isEmpty(str2)) {
            asyncHttpRequest2.getHeaders().set(str, str2);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m39839b(AsyncHttpRequest asyncHttpRequest, int i, FutureAsyncHttpResponse futureAsyncHttpResponse, HttpConnectCallback httpConnectCallback) {
        AsyncHttpRequest asyncHttpRequest2 = asyncHttpRequest;
        FutureAsyncHttpResponse futureAsyncHttpResponse2 = futureAsyncHttpResponse;
        if (!f55262f && !this.f55269e.isAffinityThread()) {
            throw new AssertionError();
        } else if (i > 15) {
            m39822a(futureAsyncHttpResponse, (Exception) new RedirectLimitExceededException("too many redirects"), (C20198a) null, asyncHttpRequest, httpConnectCallback);
        } else {
            asyncHttpRequest.getUri();
            AsyncHttpClientMiddleware.OnResponseCompleteData onResponseCompleteData = new AsyncHttpClientMiddleware.OnResponseCompleteData();
            asyncHttpRequest2.f55277g = System.currentTimeMillis();
            onResponseCompleteData.request = asyncHttpRequest2;
            asyncHttpRequest.logd("Executing request.");
            for (AsyncHttpClientMiddleware onRequest : this.f55265a) {
                onRequest.onRequest(onResponseCompleteData);
            }
            if (asyncHttpRequest.getTimeout() > 0) {
                final AsyncHttpClientMiddleware.OnResponseCompleteData onResponseCompleteData2 = onResponseCompleteData;
                final FutureAsyncHttpResponse futureAsyncHttpResponse3 = futureAsyncHttpResponse;
                final AsyncHttpRequest asyncHttpRequest3 = asyncHttpRequest;
                final HttpConnectCallback httpConnectCallback2 = httpConnectCallback;
                futureAsyncHttpResponse2.timeoutRunnable = new Runnable() {
                    public void run() {
                        if (onResponseCompleteData2.socketCancellable != null) {
                            onResponseCompleteData2.socketCancellable.cancel();
                            if (onResponseCompleteData2.socket != null) {
                                onResponseCompleteData2.socket.close();
                            }
                        }
                        AsyncHttpClient.this.m39822a(futureAsyncHttpResponse3, (Exception) new TimeoutException(), (C20198a) null, asyncHttpRequest3, httpConnectCallback2);
                    }
                };
                futureAsyncHttpResponse2.scheduled = this.f55269e.postDelayed(futureAsyncHttpResponse2.timeoutRunnable, m39844d(asyncHttpRequest));
            }
            final AsyncHttpRequest asyncHttpRequest4 = asyncHttpRequest;
            final FutureAsyncHttpResponse futureAsyncHttpResponse4 = futureAsyncHttpResponse;
            final HttpConnectCallback httpConnectCallback3 = httpConnectCallback;
            final AsyncHttpClientMiddleware.OnResponseCompleteData onResponseCompleteData3 = onResponseCompleteData;
            final int i2 = i;
            onResponseCompleteData.connectCallback = new ConnectCallback() {
                boolean reported;

                public void onConnectCompleted(Exception exc, AsyncSocket asyncSocket) {
                    if (!this.reported || asyncSocket == null) {
                        this.reported = true;
                        asyncHttpRequest4.logv("socket connected");
                        if (!futureAsyncHttpResponse4.isCancelled()) {
                            if (futureAsyncHttpResponse4.timeoutRunnable != null) {
                                futureAsyncHttpResponse4.scheduled.cancel();
                            }
                            if (exc != null) {
                                AsyncHttpClient.this.m39822a(futureAsyncHttpResponse4, exc, (C20198a) null, asyncHttpRequest4, httpConnectCallback3);
                                return;
                            }
                            onResponseCompleteData3.socket = asyncSocket;
                            futureAsyncHttpResponse4.socket = asyncSocket;
                            AsyncHttpClient.this.m39830a(asyncHttpRequest4, i2, futureAsyncHttpResponse4, httpConnectCallback3, onResponseCompleteData3);
                        } else if (asyncSocket != null) {
                            asyncSocket.close();
                        }
                    } else {
                        asyncSocket.setDataCallback(new DataCallback.NullDataCallback());
                        asyncSocket.setEndCallback(new CompletedCallback.NullCompletedCallback());
                        asyncSocket.close();
                        throw new AssertionError("double connect callback");
                    }
                }
            };
            m39842c(asyncHttpRequest);
            if (asyncHttpRequest.getBody() != null && asyncHttpRequest.getHeaders().get("Content-Type") == null) {
                asyncHttpRequest.getHeaders().set("Content-Type", asyncHttpRequest.getBody().getContentType());
            }
            for (AsyncHttpClientMiddleware socket : this.f55265a) {
                Cancellable socket2 = socket.getSocket(onResponseCompleteData);
                if (socket2 != null) {
                    onResponseCompleteData.socketCancellable = socket2;
                    futureAsyncHttpResponse.setParent(socket2);
                    return;
                }
            }
            m39822a(futureAsyncHttpResponse, (Exception) new IllegalArgumentException("invalid uri=" + asyncHttpRequest.getUri() + " middlewares=" + this.f55265a), (C20198a) null, asyncHttpRequest, httpConnectCallback);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:1:0x0028 A[LOOP:0: B:1:0x0028->B:4:0x0038, LOOP_START] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m39830a(com.koushikdutta.async.http.AsyncHttpRequest r10, int r11, com.koushikdutta.async.http.AsyncHttpClient.FutureAsyncHttpResponse r12, com.koushikdutta.async.http.callback.HttpConnectCallback r13, com.koushikdutta.async.http.AsyncHttpClientMiddleware.OnResponseCompleteData r14) {
        /*
            r9 = this;
            com.koushikdutta.async.http.AsyncHttpClient$4 r8 = new com.koushikdutta.async.http.AsyncHttpClient$4
            r0 = r8
            r1 = r9
            r2 = r10
            r3 = r12
            r4 = r10
            r5 = r13
            r6 = r14
            r7 = r11
            r0.<init>(r2, r3, r4, r5, r6, r7)
            com.koushikdutta.async.http.AsyncHttpClient$5 r10 = new com.koushikdutta.async.http.AsyncHttpClient$5
            r10.<init>(r8)
            r14.sendHeadersCallback = r10
            com.koushikdutta.async.http.AsyncHttpClient$6 r10 = new com.koushikdutta.async.http.AsyncHttpClient$6
            r10.<init>(r8)
            r14.receiveHeadersCallback = r10
            r14.response = r8
            com.koushikdutta.async.AsyncSocket r10 = r14.socket
            r8.setSocket(r10)
            java.util.List<com.koushikdutta.async.http.AsyncHttpClientMiddleware> r10 = r9.f55265a
            java.util.Iterator r10 = r10.iterator()
        L_0x0028:
            boolean r11 = r10.hasNext()
            if (r11 == 0) goto L_0x003a
            java.lang.Object r11 = r10.next()
            com.koushikdutta.async.http.AsyncHttpClientMiddleware r11 = (com.koushikdutta.async.http.AsyncHttpClientMiddleware) r11
            boolean r11 = r11.exchangeHeaders(r14)
            if (r11 == 0) goto L_0x0028
        L_0x003a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.koushikdutta.async.http.AsyncHttpClient.m39830a(com.koushikdutta.async.http.AsyncHttpRequest, int, com.koushikdutta.async.http.AsyncHttpClient$FutureAsyncHttpResponse, com.koushikdutta.async.http.callback.HttpConnectCallback, com.koushikdutta.async.http.AsyncHttpClientMiddleware$OnResponseCompleteData):void");
    }

    public Future<ByteBufferList> executeByteBufferList(AsyncHttpRequest asyncHttpRequest, DownloadCallback downloadCallback) {
        return execute(asyncHttpRequest, new ByteBufferListParser(), downloadCallback);
    }

    public Future<String> executeString(AsyncHttpRequest asyncHttpRequest, StringCallback stringCallback) {
        return execute(asyncHttpRequest, new StringParser(), stringCallback);
    }

    public Future<JSONObject> executeJSONObject(AsyncHttpRequest asyncHttpRequest, JSONObjectCallback jSONObjectCallback) {
        return execute(asyncHttpRequest, new JSONObjectParser(), jSONObjectCallback);
    }

    public Future<JSONArray> executeJSONArray(AsyncHttpRequest asyncHttpRequest, JSONArrayCallback jSONArrayCallback) {
        return execute(asyncHttpRequest, new JSONArrayParser(), jSONArrayCallback);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public <T> void m39832a(RequestCallback<T> requestCallback, SimpleFuture<T> simpleFuture, AsyncHttpResponse asyncHttpResponse, Exception exc, T t) {
        boolean z;
        if (exc != null) {
            z = simpleFuture.setComplete(exc);
        } else {
            z = simpleFuture.setComplete(t);
        }
        if (z && requestCallback != null) {
            requestCallback.onCompleted(exc, asyncHttpResponse, t);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public <T> void m39843c(RequestCallback<T> requestCallback, SimpleFuture<T> simpleFuture, AsyncHttpResponse asyncHttpResponse, Exception exc, T t) {
        final RequestCallback<T> requestCallback2 = requestCallback;
        final SimpleFuture<T> simpleFuture2 = simpleFuture;
        final AsyncHttpResponse asyncHttpResponse2 = asyncHttpResponse;
        final Exception exc2 = exc;
        final T t2 = t;
        this.f55269e.post(new Runnable() {
            public void run() {
                AsyncHttpClient.this.m39832a(requestCallback2, simpleFuture2, asyncHttpResponse2, exc2, t2);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m39835a(RequestCallback requestCallback, AsyncHttpResponse asyncHttpResponse, long j, long j2) {
        if (requestCallback != null) {
            requestCallback.onProgress(asyncHttpResponse, j, j2);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m39834a(RequestCallback requestCallback, AsyncHttpResponse asyncHttpResponse) {
        if (requestCallback != null) {
            requestCallback.onConnect(asyncHttpResponse);
        }
    }

    public Future<File> executeFile(AsyncHttpRequest asyncHttpRequest, String str, FileCallback fileCallback) {
        final File file = new File(str);
        file.getParentFile().mkdirs();
        try {
            final BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file), 8192);
            final FutureAsyncHttpResponse futureAsyncHttpResponse = new FutureAsyncHttpResponse();
            C201708 r6 = new SimpleFuture<File>() {
                /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
                /* JADX WARNING: Failed to process nested try/catch */
                /* JADX WARNING: Missing exception handler attribute for start block: B:2:0x001b */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void cancelCleanup() {
                    /*
                        r2 = this;
                        com.koushikdutta.async.http.AsyncHttpClient$FutureAsyncHttpResponse r0 = r11     // Catch:{ Exception -> 0x001b }
                        java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x001b }
                        com.koushikdutta.async.http.AsyncHttpResponse r0 = (com.koushikdutta.async.http.AsyncHttpResponse) r0     // Catch:{ Exception -> 0x001b }
                        com.koushikdutta.async.callback.DataCallback$NullDataCallback r1 = new com.koushikdutta.async.callback.DataCallback$NullDataCallback     // Catch:{ Exception -> 0x001b }
                        r1.<init>()     // Catch:{ Exception -> 0x001b }
                        r0.setDataCallback(r1)     // Catch:{ Exception -> 0x001b }
                        com.koushikdutta.async.http.AsyncHttpClient$FutureAsyncHttpResponse r0 = r11     // Catch:{ Exception -> 0x001b }
                        java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x001b }
                        com.koushikdutta.async.http.AsyncHttpResponse r0 = (com.koushikdutta.async.http.AsyncHttpResponse) r0     // Catch:{ Exception -> 0x001b }
                        r0.close()     // Catch:{ Exception -> 0x001b }
                    L_0x001b:
                        java.io.OutputStream r0 = r2     // Catch:{ Exception -> 0x0020 }
                        r0.close()     // Catch:{ Exception -> 0x0020 }
                    L_0x0020:
                        java.io.File r0 = r3
                        r0.delete()
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.koushikdutta.async.http.AsyncHttpClient.C201708.cancelCleanup():void");
                }
            };
            r6.setParent(futureAsyncHttpResponse);
            final FileCallback fileCallback2 = fileCallback;
            final C201708 r5 = r6;
            m39829a(asyncHttpRequest, 0, futureAsyncHttpResponse, (HttpConnectCallback) new HttpConnectCallback() {
                long mDownloaded = 0;

                public void onConnectCompleted(Exception exc, final AsyncHttpResponse asyncHttpResponse) {
                    if (exc != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException unused) {
                        }
                        file.delete();
                        AsyncHttpClient.this.m39843c(fileCallback2, r5, asyncHttpResponse, exc, null);
                        return;
                    }
                    AsyncHttpClient.this.m39834a(fileCallback2, asyncHttpResponse);
                    final long contentLength = HttpUtil.contentLength(asyncHttpResponse.headers());
                    final AsyncHttpResponse asyncHttpResponse2 = asyncHttpResponse;
                    asyncHttpResponse.setDataCallback(new OutputStreamDataCallback(bufferedOutputStream) {
                        public void onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
                            C201719.this.mDownloaded += (long) byteBufferList.remaining();
                            super.onDataAvailable(dataEmitter, byteBufferList);
                            AsyncHttpClient.this.m39835a((RequestCallback) fileCallback2, asyncHttpResponse2, C201719.this.mDownloaded, contentLength);
                        }
                    });
                    asyncHttpResponse.setEndCallback(new CompletedCallback() {
                        public void onCompleted(Exception e) {
                            try {
                                bufferedOutputStream.close();
                            } catch (IOException e2) {
                                e = e2;
                            }
                            Exception exc = e;
                            if (exc != null) {
                                file.delete();
                                AsyncHttpClient.this.m39843c(fileCallback2, r5, asyncHttpResponse, exc, null);
                                return;
                            }
                            AsyncHttpClient.this.m39843c(fileCallback2, r5, asyncHttpResponse, (Exception) null, file);
                        }
                    });
                }
            });
            return r6;
        } catch (FileNotFoundException e) {
            SimpleFuture simpleFuture = new SimpleFuture();
            simpleFuture.setComplete((Exception) e);
            return simpleFuture;
        }
    }

    public <T> SimpleFuture<T> execute(AsyncHttpRequest asyncHttpRequest, AsyncParser<T> asyncParser, RequestCallback<T> requestCallback) {
        FutureAsyncHttpResponse futureAsyncHttpResponse = new FutureAsyncHttpResponse();
        SimpleFuture<T> simpleFuture = new SimpleFuture<>();
        m39829a(asyncHttpRequest, 0, futureAsyncHttpResponse, (HttpConnectCallback) new HttpConnectCallback(requestCallback, simpleFuture, asyncParser) {
            public final /* synthetic */ RequestCallback f$1;
            public final /* synthetic */ SimpleFuture f$2;
            public final /* synthetic */ AsyncParser f$3;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final void onConnectCompleted(Exception exc, AsyncHttpResponse asyncHttpResponse) {
                AsyncHttpClient.this.m39833a(this.f$1, this.f$2, this.f$3, exc, asyncHttpResponse);
            }
        });
        simpleFuture.setParent(futureAsyncHttpResponse);
        return simpleFuture;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m39833a(RequestCallback requestCallback, SimpleFuture simpleFuture, AsyncParser asyncParser, Exception exc, AsyncHttpResponse asyncHttpResponse) {
        if (exc != null) {
            m39843c(requestCallback, simpleFuture, asyncHttpResponse, exc, (Object) null);
            return;
        }
        m39834a(requestCallback, asyncHttpResponse);
        Future parse = asyncParser.parse(asyncHttpResponse);
        parse.setCallback(new FutureCallback(requestCallback, simpleFuture, asyncHttpResponse) {
            public final /* synthetic */ RequestCallback f$1;
            public final /* synthetic */ SimpleFuture f$2;
            public final /* synthetic */ AsyncHttpResponse f$3;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final void onCompleted(Exception exc, Object obj) {
                AsyncHttpClient.this.m39843c(this.f$1, this.f$2, this.f$3, exc, obj);
            }
        });
        simpleFuture.setParent(parse);
    }

    public Future<WebSocket> websocket(AsyncHttpRequest asyncHttpRequest, String str, WebSocketConnectCallback webSocketConnectCallback) {
        return websocket(asyncHttpRequest, str != null ? new String[]{str} : null, webSocketConnectCallback);
    }

    public Future<WebSocket> websocket(AsyncHttpRequest asyncHttpRequest, String[] strArr, WebSocketConnectCallback webSocketConnectCallback) {
        WebSocketImpl.addWebSocketUpgradeHeaders(asyncHttpRequest, strArr);
        SimpleFuture simpleFuture = new SimpleFuture();
        simpleFuture.setParent(execute(asyncHttpRequest, (HttpConnectCallback) new HttpConnectCallback(webSocketConnectCallback, asyncHttpRequest) {
            public final /* synthetic */ AsyncHttpClient.WebSocketConnectCallback f$1;
            public final /* synthetic */ AsyncHttpRequest f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onConnectCompleted(Exception exc, AsyncHttpResponse asyncHttpResponse) {
                AsyncHttpClient.m39821a(SimpleFuture.this, this.f$1, this.f$2, exc, asyncHttpResponse);
            }
        }));
        return simpleFuture;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m39821a(SimpleFuture simpleFuture, WebSocketConnectCallback webSocketConnectCallback, AsyncHttpRequest asyncHttpRequest, Exception exc, AsyncHttpResponse asyncHttpResponse) {
        if (exc == null) {
            WebSocket finishHandshake = WebSocketImpl.finishHandshake(asyncHttpRequest.getHeaders(), asyncHttpResponse);
            if (finishHandshake == null) {
                exc = new WebSocketHandshakeException("Unable to complete websocket handshake");
                asyncHttpResponse.close();
                if (!simpleFuture.setComplete(exc)) {
                    return;
                }
            } else if (!simpleFuture.setComplete(finishHandshake)) {
                return;
            }
            if (webSocketConnectCallback != null) {
                webSocketConnectCallback.onCompleted(exc, finishHandshake);
            }
        } else if (simpleFuture.setComplete(exc) && webSocketConnectCallback != null) {
            webSocketConnectCallback.onCompleted(exc, (WebSocket) null);
        }
    }

    public Future<WebSocket> websocket(String str, String str2, WebSocketConnectCallback webSocketConnectCallback) {
        return websocket((AsyncHttpRequest) new AsyncHttpGet(str.replace("ws://", "http://").replace("wss://", "https://")), str2, webSocketConnectCallback);
    }

    public Future<WebSocket> websocket(String str, String[] strArr, WebSocketConnectCallback webSocketConnectCallback) {
        return websocket((AsyncHttpRequest) new AsyncHttpGet(str.replace("ws://", "http://").replace("wss://", "https://")), strArr, webSocketConnectCallback);
    }

    public AsyncServer getServer() {
        return this.f55269e;
    }
}
