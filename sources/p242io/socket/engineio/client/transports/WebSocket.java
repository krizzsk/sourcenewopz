package p242io.socket.engineio.client.transports;

import com.didi.hawaii.mapsdkv2.HWMapConstant;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Logger;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;
import p242io.socket.engineio.client.Transport;
import p242io.socket.engineio.parser.Packet;
import p242io.socket.engineio.parser.Parser;
import p242io.socket.parseqs.ParseQS;
import p242io.socket.thread.EventThread;
import p242io.socket.utf8.UTF8Exception;
import p242io.socket.yeast.Yeast;

/* renamed from: io.socket.engineio.client.transports.WebSocket */
public class WebSocket extends Transport {
    public static final String NAME = "websocket";
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final Logger f59542a = Logger.getLogger(PollingXHR.class.getName());
    /* access modifiers changed from: private */

    /* renamed from: b */
    public okhttp3.WebSocket f59543b;

    public WebSocket(Transport.Options options) {
        super(options);
        this.name = NAME;
    }

    /* access modifiers changed from: protected */
    public void doOpen() {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        emit("requestHeaders", treeMap);
        WebSocket.Factory okHttpClient = this.webSocketFactory != null ? this.webSocketFactory : new OkHttpClient();
        Request.Builder url = new Request.Builder().url(uri());
        for (Map.Entry entry : treeMap.entrySet()) {
            for (String addHeader : (List) entry.getValue()) {
                url.addHeader((String) entry.getKey(), addHeader);
            }
        }
        this.f59543b = okHttpClient.newWebSocket(url.build(), new WebSocketListener() {
            public void onOpen(okhttp3.WebSocket webSocket, Response response) {
                final Map<String, List<String>> multimap = response.headers().toMultimap();
                EventThread.exec(new Runnable() {
                    public void run() {
                        this.emit("responseHeaders", multimap);
                        this.onOpen();
                    }
                });
            }

            public void onMessage(okhttp3.WebSocket webSocket, final String str) {
                if (str != null) {
                    EventThread.exec(new Runnable() {
                        public void run() {
                            this.onData(str);
                        }
                    });
                }
            }

            public void onMessage(okhttp3.WebSocket webSocket, final ByteString byteString) {
                if (byteString != null) {
                    EventThread.exec(new Runnable() {
                        public void run() {
                            this.onData(byteString.toByteArray());
                        }
                    });
                }
            }

            public void onClosed(okhttp3.WebSocket webSocket, int i, String str) {
                EventThread.exec(new Runnable() {
                    public void run() {
                        this.onClose();
                    }
                });
            }

            public void onFailure(okhttp3.WebSocket webSocket, final Throwable th, Response response) {
                if (th instanceof Exception) {
                    EventThread.exec(new Runnable() {
                        public void run() {
                            Transport unused = this.onError("websocket error", (Exception) th);
                        }
                    });
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void write(Packet[] packetArr) throws UTF8Exception {
        int i = 0;
        this.writable = false;
        final C213252 r1 = new Runnable() {
            public void run() {
                EventThread.nextTick(new Runnable() {
                    public void run() {
                        this.writable = true;
                        this.emit("drain", new Object[0]);
                    }
                });
            }
        };
        final int[] iArr = {packetArr.length};
        int length = packetArr.length;
        while (i < length) {
            Packet packet = packetArr[i];
            if (this.readyState == Transport.ReadyState.OPENING || this.readyState == Transport.ReadyState.OPEN) {
                Parser.encodePacket(packet, new Parser.EncodeCallback() {
                    public void call(Object obj) {
                        try {
                            if (obj instanceof String) {
                                this.f59543b.send((String) obj);
                            } else if (obj instanceof byte[]) {
                                this.f59543b.send(ByteString.m3607of((byte[]) obj));
                            }
                        } catch (IllegalStateException unused) {
                            WebSocket.f59542a.fine("websocket closed before we could write");
                        }
                        int[] iArr = iArr;
                        int i = iArr[0] - 1;
                        iArr[0] = i;
                        if (i == 0) {
                            r1.run();
                        }
                    }
                });
                i++;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void doClose() {
        okhttp3.WebSocket webSocket = this.f59543b;
        if (webSocket != null) {
            webSocket.close(1000, "");
            this.f59543b = null;
        }
    }

    /* access modifiers changed from: protected */
    public String uri() {
        String str;
        String str2;
        Map map = this.query;
        if (map == null) {
            map = new HashMap();
        }
        String str3 = this.secure ? "wss" : "ws";
        if (this.port <= 0 || ((!"wss".equals(str3) || this.port == 443) && (!"ws".equals(str3) || this.port == 80))) {
            str = "";
        } else {
            str = ":" + this.port;
        }
        if (this.timestampRequests) {
            map.put(this.timestampParam, Yeast.yeast());
        }
        String encode = ParseQS.encode(map);
        if (encode.length() > 0) {
            encode = "?" + encode;
        }
        boolean contains = this.hostname.contains(":");
        StringBuilder sb = new StringBuilder();
        sb.append(str3);
        sb.append(HWMapConstant.HTTP.SEPARATOR);
        if (contains) {
            str2 = Const.jaLeft + this.hostname + Const.jaRight;
        } else {
            str2 = this.hostname;
        }
        sb.append(str2);
        sb.append(str);
        sb.append(this.path);
        sb.append(encode);
        return sb.toString();
    }
}
