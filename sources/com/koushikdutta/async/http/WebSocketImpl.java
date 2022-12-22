package com.koushikdutta.async.http;

import android.text.TextUtils;
import android.util.Base64;
import com.didichuxing.diface.logger.DiFaceLogger;
import com.google.common.net.HttpHeaders;
import com.koushikdutta.async.AsyncServer;
import com.koushikdutta.async.AsyncSocket;
import com.koushikdutta.async.BufferedDataSink;
import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.C20137Util;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.DataCallback;
import com.koushikdutta.async.callback.WritableCallback;
import com.koushikdutta.async.http.WebSocket;
import com.koushikdutta.async.http.server.AsyncHttpServerRequest;
import com.koushikdutta.async.http.server.AsyncHttpServerResponse;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.LinkedList;
import java.util.UUID;

public class WebSocketImpl implements WebSocket {

    /* renamed from: a */
    static final String f55297a = "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";

    /* renamed from: b */
    BufferedDataSink f55298b;

    /* renamed from: c */
    String f55299c;

    /* renamed from: d */
    HybiParser f55300d;

    /* renamed from: e */
    CompletedCallback f55301e;

    /* renamed from: f */
    private LinkedList<ByteBufferList> f55302f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public AsyncSocket f55303g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public WebSocket.StringCallback f55304h;

    /* renamed from: i */
    private DataCallback f55305i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public WebSocket.PingCallback f55306j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public WebSocket.PongCallback f55307k;

    public String charset() {
        return null;
    }

    public boolean isChunked() {
        return false;
    }

    public void end() {
        this.f55303g.end();
    }

    /* renamed from: a */
    private static byte[] m39867a(UUID uuid) {
        byte[] bArr = new byte[16];
        ByteBuffer.wrap(bArr).asLongBuffer().put(new long[]{uuid.getMostSignificantBits(), uuid.getLeastSignificantBits()});
        return bArr;
    }

    /* renamed from: a */
    private static String m39861a(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            instance.update(str.getBytes("iso-8859-1"), 0, str.length());
            return Base64.encodeToString(instance.digest(), 2);
        } catch (Exception unused) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m39862a(ByteBufferList byteBufferList) {
        if (this.f55302f == null) {
            C20137Util.emitAllData(this, byteBufferList);
            if (byteBufferList.remaining() > 0) {
                LinkedList<ByteBufferList> linkedList = new LinkedList<>();
                this.f55302f = linkedList;
                linkedList.add(byteBufferList);
                return;
            }
            return;
        }
        while (!isPaused()) {
            ByteBufferList remove = this.f55302f.remove();
            C20137Util.emitAllData(this, remove);
            if (remove.remaining() > 0) {
                this.f55302f.add(0, remove);
            }
        }
        if (this.f55302f.size() == 0) {
            this.f55302f = null;
        }
    }

    /* renamed from: a */
    private void m39864a(boolean z, boolean z2) {
        C201971 r0 = new HybiParser(this.f55303g) {
            /* access modifiers changed from: protected */
            public void report(Exception exc) {
                if (WebSocketImpl.this.f55301e != null) {
                    WebSocketImpl.this.f55301e.onCompleted(exc);
                }
            }

            /* access modifiers changed from: protected */
            public void onMessage(byte[] bArr) {
                WebSocketImpl.this.m39862a(new ByteBufferList(bArr));
            }

            /* access modifiers changed from: protected */
            public void onMessage(String str) {
                if (WebSocketImpl.this.f55304h != null) {
                    WebSocketImpl.this.f55304h.onStringAvailable(str);
                }
            }

            /* access modifiers changed from: protected */
            public void onDisconnect(int i, String str) {
                WebSocketImpl.this.f55303g.close();
            }

            /* access modifiers changed from: protected */
            public void sendFrame(byte[] bArr) {
                WebSocketImpl.this.f55298b.write(new ByteBufferList(bArr));
            }

            /* access modifiers changed from: protected */
            public void onPing(String str) {
                if (WebSocketImpl.this.f55306j != null) {
                    WebSocketImpl.this.f55306j.onPingReceived(str);
                }
            }

            /* access modifiers changed from: protected */
            public void onPong(String str) {
                if (WebSocketImpl.this.f55307k != null) {
                    WebSocketImpl.this.f55307k.onPongReceived(str);
                }
            }
        };
        this.f55300d = r0;
        r0.setMasking(z);
        this.f55300d.setDeflate(z2);
        if (this.f55303g.isPaused()) {
            this.f55303g.resume();
        }
    }

    public WebSocketImpl(AsyncHttpServerRequest asyncHttpServerRequest, AsyncHttpServerResponse asyncHttpServerResponse) {
        this(asyncHttpServerRequest.getSocket());
        String str = asyncHttpServerRequest.getHeaders().get(HttpHeaders.SEC_WEBSOCKET_KEY);
        String a = m39861a(str + f55297a);
        asyncHttpServerRequest.getHeaders().get(HttpHeaders.ORIGIN);
        asyncHttpServerResponse.code(101);
        asyncHttpServerResponse.getHeaders().set(HttpHeaders.UPGRADE, "WebSocket");
        asyncHttpServerResponse.getHeaders().set(HttpHeaders.CONNECTION, HttpHeaders.UPGRADE);
        asyncHttpServerResponse.getHeaders().set(HttpHeaders.SEC_WEBSOCKET_ACCEPT, a);
        String str2 = asyncHttpServerRequest.getHeaders().get(HttpHeaders.SEC_WEBSOCKET_PROTOCOL);
        if (!TextUtils.isEmpty(str2)) {
            asyncHttpServerResponse.getHeaders().set(HttpHeaders.SEC_WEBSOCKET_PROTOCOL, str2);
        }
        asyncHttpServerResponse.writeHead();
        m39864a(false, false);
    }

    public String getProtocol() {
        return this.f55299c;
    }

    public static void addWebSocketUpgradeHeaders(AsyncHttpRequest asyncHttpRequest, String... strArr) {
        Headers headers = asyncHttpRequest.getHeaders();
        String encodeToString = Base64.encodeToString(m39867a(UUID.randomUUID()), 2);
        headers.set(HttpHeaders.SEC_WEBSOCKET_VERSION, DiFaceLogger.EVENT_ID_BIOASSAY_ACTION_SUCCESS);
        headers.set(HttpHeaders.SEC_WEBSOCKET_KEY, encodeToString);
        headers.set(HttpHeaders.SEC_WEBSOCKET_EXTENSIONS, "x-webkit-deflate-frame");
        headers.set(HttpHeaders.CONNECTION, HttpHeaders.UPGRADE);
        headers.set(HttpHeaders.UPGRADE, p242io.socket.engineio.client.transports.WebSocket.NAME);
        if (strArr != null) {
            for (String add : strArr) {
                headers.add(HttpHeaders.SEC_WEBSOCKET_PROTOCOL, add);
            }
        }
        headers.set(HttpHeaders.PRAGMA, "no-cache");
        headers.set(HttpHeaders.CACHE_CONTROL, "no-cache");
        if (TextUtils.isEmpty(asyncHttpRequest.getHeaders().get("User-Agent"))) {
            asyncHttpRequest.getHeaders().set("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_8_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/27.0.1453.15 Safari/537.36");
        }
    }

    public WebSocketImpl(AsyncSocket asyncSocket) {
        this.f55303g = asyncSocket;
        this.f55298b = new BufferedDataSink(this.f55303g);
    }

    public static WebSocket finishHandshake(Headers headers, AsyncHttpResponse asyncHttpResponse) {
        String str;
        String str2;
        if (asyncHttpResponse == null || asyncHttpResponse.code() != 101 || !p242io.socket.engineio.client.transports.WebSocket.NAME.equalsIgnoreCase(asyncHttpResponse.headers().get(HttpHeaders.UPGRADE)) || (str = asyncHttpResponse.headers().get(HttpHeaders.SEC_WEBSOCKET_ACCEPT)) == null || (str2 = headers.get(HttpHeaders.SEC_WEBSOCKET_KEY)) == null) {
            return null;
        }
        if (!str.equalsIgnoreCase(m39861a(str2 + f55297a).trim())) {
            return null;
        }
        String str3 = headers.get(HttpHeaders.SEC_WEBSOCKET_EXTENSIONS);
        boolean z = false;
        if (str3 != null && str3.equals("x-webkit-deflate-frame")) {
            z = true;
        }
        WebSocketImpl webSocketImpl = new WebSocketImpl(asyncHttpResponse.detachSocket());
        webSocketImpl.f55299c = asyncHttpResponse.headers().get(HttpHeaders.SEC_WEBSOCKET_PROTOCOL);
        webSocketImpl.m39864a(true, z);
        return webSocketImpl;
    }

    public void close() {
        this.f55303g.close();
    }

    public void setClosedCallback(CompletedCallback completedCallback) {
        this.f55303g.setClosedCallback(completedCallback);
    }

    public CompletedCallback getClosedCallback() {
        return this.f55303g.getClosedCallback();
    }

    public void setEndCallback(CompletedCallback completedCallback) {
        this.f55301e = completedCallback;
    }

    public CompletedCallback getEndCallback() {
        return this.f55301e;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m39865a(byte[] bArr) {
        this.f55298b.write(new ByteBufferList(this.f55300d.frame(bArr)));
    }

    public void send(byte[] bArr) {
        getServer().post(new Runnable(bArr) {
            public final /* synthetic */ byte[] f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                WebSocketImpl.this.m39865a(this.f$1);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m39866a(byte[] bArr, int i, int i2) {
        this.f55298b.write(new ByteBufferList(this.f55300d.frame(bArr, i, i2)));
    }

    public void send(byte[] bArr, int i, int i2) {
        getServer().post(new Runnable(bArr, i, i2) {
            public final /* synthetic */ byte[] f$1;
            public final /* synthetic */ int f$2;
            public final /* synthetic */ int f$3;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final void run() {
                WebSocketImpl.this.m39866a(this.f$1, this.f$2, this.f$3);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public /* synthetic */ void m39873d(String str) {
        this.f55298b.write(new ByteBufferList(this.f55300d.frame(str)));
    }

    public void send(String str) {
        getServer().post(new Runnable(str) {
            public final /* synthetic */ String f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                WebSocketImpl.this.m39873d(this.f$1);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void m39871c(String str) {
        this.f55298b.write(new ByteBufferList(ByteBuffer.wrap(this.f55300d.pingFrame(str))));
    }

    public void ping(String str) {
        getServer().post(new Runnable(str) {
            public final /* synthetic */ String f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                WebSocketImpl.this.m39871c(this.f$1);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m39869b(String str) {
        this.f55298b.write(new ByteBufferList(ByteBuffer.wrap(this.f55300d.pongFrame(str))));
    }

    public void pong(String str) {
        getServer().post(new Runnable(str) {
            public final /* synthetic */ String f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                WebSocketImpl.this.m39869b(this.f$1);
            }
        });
    }

    public void setStringCallback(WebSocket.StringCallback stringCallback) {
        this.f55304h = stringCallback;
    }

    public void setDataCallback(DataCallback dataCallback) {
        this.f55305i = dataCallback;
    }

    public WebSocket.StringCallback getStringCallback() {
        return this.f55304h;
    }

    public void setPingCallback(WebSocket.PingCallback pingCallback) {
        this.f55306j = pingCallback;
    }

    public void setPongCallback(WebSocket.PongCallback pongCallback) {
        this.f55307k = pongCallback;
    }

    public WebSocket.PongCallback getPongCallback() {
        return this.f55307k;
    }

    public DataCallback getDataCallback() {
        return this.f55305i;
    }

    public boolean isOpen() {
        return this.f55303g.isOpen();
    }

    public boolean isBuffering() {
        return this.f55298b.remaining() > 0;
    }

    public void write(ByteBufferList byteBufferList) {
        send(byteBufferList.getAllByteArray());
    }

    public void setWriteableCallback(WritableCallback writableCallback) {
        this.f55298b.setWriteableCallback(writableCallback);
    }

    public WritableCallback getWriteableCallback() {
        return this.f55298b.getWriteableCallback();
    }

    public AsyncSocket getSocket() {
        return this.f55303g;
    }

    public AsyncServer getServer() {
        return this.f55303g.getServer();
    }

    public void pause() {
        this.f55303g.pause();
    }

    public void resume() {
        this.f55303g.resume();
    }

    public boolean isPaused() {
        return this.f55303g.isPaused();
    }
}
