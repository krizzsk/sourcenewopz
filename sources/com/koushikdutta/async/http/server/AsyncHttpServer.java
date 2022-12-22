package com.koushikdutta.async.http.server;

import com.appsflyer.internal.referrer.Payload;
import com.didi.sdk.apm.SystemUtils;
import com.google.common.net.HttpHeaders;
import com.koushikdutta.async.AsyncSSLSocket;
import com.koushikdutta.async.AsyncSSLSocketWrapper;
import com.koushikdutta.async.AsyncServer;
import com.koushikdutta.async.AsyncServerSocket;
import com.koushikdutta.async.AsyncSocket;
import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.C20137Util;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.DataSink;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.DataCallback;
import com.koushikdutta.async.callback.ListenCallback;
import com.koushikdutta.async.callback.ValueCallback;
import com.koushikdutta.async.http.Headers;
import com.koushikdutta.async.http.HttpUtil;
import com.koushikdutta.async.http.Multimap;
import com.koushikdutta.async.http.WebSocket;
import com.koushikdutta.async.http.body.AsyncHttpRequestBody;
import com.koushikdutta.async.http.server.AsyncHttpServerRouter;
import java.net.InetAddress;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

public class AsyncHttpServer extends AsyncHttpServerRouter {

    /* renamed from: h */
    private static Hashtable<Integer, String> f55421h;

    /* renamed from: a */
    ArrayList<AsyncServerSocket> f55422a = new ArrayList<>();

    /* renamed from: b */
    ListenCallback f55423b = new ListenCallback() {
        public void onAccepted(final AsyncSocket asyncSocket) {
            new AsyncHttpServerRouter.AsyncHttpServerRequestImpl() {
                String fullPath;
                boolean handled;
                boolean hasContinued;
                final ValueCallback<Exception> onException = new ValueCallback<Exception>() {
                    public void onResult(Exception exc) {
                        SystemUtils.log(6, "HTTP", "exception", exc, "com.koushikdutta.async.http.server.AsyncHttpServer$1$1$2", 98);
                    }
                };
                final Runnable onFinally = new Runnable() {
                    public void run() {
                        SystemUtils.log(4, "HTTP", "Done", (Throwable) null, "com.koushikdutta.async.http.server.AsyncHttpServer$1$1$1", 91);
                    }
                };
                String path;
                HttpServerRequestCallback requestCallback;
                boolean requestComplete;
                AsyncHttpServerResponseImpl res;
                boolean responseComplete;
                AsyncHttpServerRouter.AsyncHttpServerRequestImpl self = this;

                /* access modifiers changed from: package-private */
                public void onRequest() {
                    AsyncHttpServer.this.onRequest(this.requestCallback, this, this.res);
                }

                /* access modifiers changed from: protected */
                public AsyncHttpRequestBody onBody(Headers headers) {
                    String[] split = getStatusLine().split(" ");
                    String str = split[1];
                    this.fullPath = str;
                    this.path = URLDecoder.decode(str.split("\\?")[0]);
                    this.method = split[0];
                    AsyncHttpServerRouter.RouteMatch route = AsyncHttpServer.this.route(this.method, this.path);
                    if (route == null) {
                        return null;
                    }
                    this.matcher = route.matcher;
                    this.requestCallback = route.callback;
                    if (route.bodyCallback == null) {
                        return null;
                    }
                    return route.bodyCallback.getBody(headers);
                }

                /* access modifiers changed from: protected */
                public AsyncHttpRequestBody onUnknownBody(Headers headers) {
                    return AsyncHttpServer.this.onUnknownBody(headers);
                }

                /* access modifiers changed from: protected */
                public void onHeadersReceived() {
                    Headers headers = getHeaders();
                    if (this.hasContinued || !"100-continue".equals(headers.get(HttpHeaders.EXPECT))) {
                        this.res = new AsyncHttpServerResponseImpl(asyncSocket, this) {
                            /* access modifiers changed from: protected */
                            public void report(Exception exc) {
                                super.report(exc);
                                if (exc != null) {
                                    asyncSocket.setDataCallback(new DataCallback.NullDataCallback());
                                    asyncSocket.setEndCallback(new CompletedCallback.NullCompletedCallback());
                                    asyncSocket.close();
                                }
                            }

                            /* access modifiers changed from: protected */
                            public void onEnd() {
                                C202361.this.responseComplete = true;
                                super.onEnd();
                                this.mSocket.setEndCallback((CompletedCallback) null);
                                AsyncHttpServer.this.onResponseCompleted(getRequest(), C202361.this.res);
                                C202361.this.handleOnCompleted();
                            }
                        };
                        boolean onRequest = AsyncHttpServer.this.onRequest(this, this.res);
                        this.handled = onRequest;
                        if (!onRequest) {
                            if (this.requestCallback == null) {
                                this.res.code(404);
                                this.res.end();
                            } else if (!getBody().readFullyOnRequest() || this.requestComplete) {
                                onRequest();
                            }
                        }
                    } else {
                        pause();
                        C20137Util.writeAll((DataSink) this.mSocket, "HTTP/1.1 100 Continue\r\n\r\n".getBytes(), (CompletedCallback) new CompletedCallback() {
                            public void onCompleted(Exception exc) {
                                C202361.this.resume();
                                if (exc != null) {
                                    C202361.this.report(exc);
                                    return;
                                }
                                C202361.this.hasContinued = true;
                                C202361.this.onHeadersReceived();
                            }
                        });
                    }
                }

                public void onCompleted(Exception exc) {
                    if (!AsyncHttpServer.this.isSwitchingProtocols(this.res)) {
                        this.requestComplete = true;
                        super.onCompleted(exc);
                        this.mSocket.setDataCallback(new DataCallback.NullDataCallback() {
                            public void onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
                                super.onDataAvailable(dataEmitter, byteBufferList);
                                C202361.this.mSocket.close();
                            }
                        });
                        if (exc != null) {
                            this.mSocket.close();
                            return;
                        }
                        handleOnCompleted();
                        if (getBody().readFullyOnRequest() && !this.handled) {
                            onRequest();
                        }
                    }
                }

                /* access modifiers changed from: private */
                public void handleOnCompleted() {
                    if (this.requestComplete && this.responseComplete && !AsyncHttpServer.this.isSwitchingProtocols(this.res)) {
                        if (AsyncHttpServer.this.isKeepAlive(this.self, this.res)) {
                            C202351.this.onAccepted(asyncSocket);
                        } else {
                            asyncSocket.close();
                        }
                    }
                }

                public String getPath() {
                    return this.path;
                }

                public Multimap getQuery() {
                    String[] split = this.fullPath.split("\\?", 2);
                    if (split.length < 2) {
                        return new Multimap();
                    }
                    return Multimap.parseQuery(split[1]);
                }

                public String getUrl() {
                    return this.fullPath;
                }
            }.setSocket(asyncSocket);
            asyncSocket.resume();
        }

        public void onCompleted(Exception exc) {
            AsyncHttpServer.this.m39993a(exc);
        }

        public void onListening(AsyncServerSocket asyncServerSocket) {
            AsyncHttpServer.this.f55422a.add(asyncServerSocket);
        }
    };

    /* renamed from: c */
    CompletedCallback f55424c;

    public interface WebSocketRequestCallback {
        void onConnected(WebSocket webSocket, AsyncHttpServerRequest asyncHttpServerRequest);
    }

    /* access modifiers changed from: protected */
    public boolean onRequest(AsyncHttpServerRequest asyncHttpServerRequest, AsyncHttpServerResponse asyncHttpServerResponse) {
        return false;
    }

    /* access modifiers changed from: protected */
    public void onResponseCompleted(AsyncHttpServerRequest asyncHttpServerRequest, AsyncHttpServerResponse asyncHttpServerResponse) {
    }

    public void stop() {
        ArrayList<AsyncServerSocket> arrayList = this.f55422a;
        if (arrayList != null) {
            Iterator<AsyncServerSocket> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().stop();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onRequest(HttpServerRequestCallback httpServerRequestCallback, AsyncHttpServerRequest asyncHttpServerRequest, AsyncHttpServerResponse asyncHttpServerResponse) {
        if (httpServerRequestCallback != null) {
            try {
                httpServerRequestCallback.onRequest(asyncHttpServerRequest, asyncHttpServerResponse);
            } catch (Exception e) {
                SystemUtils.log(6, "AsyncHttpServer", "request callback raised uncaught exception. Catching versus crashing process", e, "com.koushikdutta.async.http.server.AsyncHttpServer", 55);
                asyncHttpServerResponse.code(500);
                asyncHttpServerResponse.end();
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean isKeepAlive(AsyncHttpServerRequest asyncHttpServerRequest, AsyncHttpServerResponse asyncHttpServerResponse) {
        return HttpUtil.isKeepAlive(asyncHttpServerResponse.getHttpVersion(), asyncHttpServerRequest.getHeaders());
    }

    /* access modifiers changed from: protected */
    public AsyncHttpRequestBody onUnknownBody(Headers headers) {
        return new UnknownRequestBody(headers.get("Content-Type"));
    }

    /* access modifiers changed from: protected */
    public boolean isSwitchingProtocols(AsyncHttpServerResponse asyncHttpServerResponse) {
        return asyncHttpServerResponse.code() == 101;
    }

    public AsyncServerSocket listen(AsyncServer asyncServer, int i) {
        return asyncServer.listen((InetAddress) null, i, this.f55423b);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m39993a(Exception exc) {
        CompletedCallback completedCallback = this.f55424c;
        if (completedCallback != null) {
            completedCallback.onCompleted(exc);
        }
    }

    public AsyncServerSocket listen(int i) {
        return listen(AsyncServer.getDefault(), i);
    }

    public void listenSecure(final int i, final SSLContext sSLContext) {
        AsyncServer.getDefault().listen((InetAddress) null, i, new ListenCallback() {
            public void onAccepted(AsyncSocket asyncSocket) {
                AsyncSSLSocketWrapper.handshake(asyncSocket, (String) null, i, sSLContext.createSSLEngine(), (TrustManager[]) null, (HostnameVerifier) null, false, new AsyncSSLSocketWrapper.HandshakeCallback() {
                    public void onHandshakeCompleted(Exception exc, AsyncSSLSocket asyncSSLSocket) {
                        if (asyncSSLSocket != null) {
                            AsyncHttpServer.this.f55423b.onAccepted(asyncSSLSocket);
                        }
                    }
                });
            }

            public void onListening(AsyncServerSocket asyncServerSocket) {
                AsyncHttpServer.this.f55423b.onListening(asyncServerSocket);
            }

            public void onCompleted(Exception exc) {
                AsyncHttpServer.this.f55423b.onCompleted(exc);
            }
        });
    }

    public ListenCallback getListenCallback() {
        return this.f55423b;
    }

    public void setErrorCallback(CompletedCallback completedCallback) {
        this.f55424c = completedCallback;
    }

    public CompletedCallback getErrorCallback() {
        return this.f55424c;
    }

    static {
        Hashtable<Integer, String> hashtable = new Hashtable<>();
        f55421h = hashtable;
        hashtable.put(200, Payload.RESPONSE_OK);
        f55421h.put(202, "Accepted");
        f55421h.put(206, "Partial Content");
        f55421h.put(101, "Switching Protocols");
        f55421h.put(301, "Moved Permanently");
        f55421h.put(302, "Found");
        f55421h.put(304, "Not Modified");
        f55421h.put(400, "Bad Request");
        f55421h.put(404, "Not Found");
        f55421h.put(500, "Internal Server Error");
    }

    public static String getResponseCodeDescription(int i) {
        String str = f55421h.get(Integer.valueOf(i));
        return str == null ? "Unknown" : str;
    }
}
