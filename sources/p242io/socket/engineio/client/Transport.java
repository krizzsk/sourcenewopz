package p242io.socket.engineio.client;

import java.util.Map;
import okhttp3.Call;
import okhttp3.WebSocket;
import p242io.socket.emitter.Emitter;
import p242io.socket.engineio.parser.Packet;
import p242io.socket.engineio.parser.Parser;
import p242io.socket.thread.EventThread;
import p242io.socket.utf8.UTF8Exception;

/* renamed from: io.socket.engineio.client.Transport */
public abstract class Transport extends Emitter {
    public static final String EVENT_CLOSE = "close";
    public static final String EVENT_DRAIN = "drain";
    public static final String EVENT_ERROR = "error";
    public static final String EVENT_OPEN = "open";
    public static final String EVENT_PACKET = "packet";
    public static final String EVENT_REQUEST_HEADERS = "requestHeaders";
    public static final String EVENT_RESPONSE_HEADERS = "responseHeaders";
    protected Call.Factory callFactory;
    protected String hostname;
    public String name;
    protected String path;
    protected int port;
    public Map<String, String> query;
    /* access modifiers changed from: protected */
    public ReadyState readyState;
    protected boolean secure;
    protected Socket socket;
    protected String timestampParam;
    protected boolean timestampRequests;
    protected WebSocket.Factory webSocketFactory;
    public boolean writable;

    /* renamed from: io.socket.engineio.client.Transport$Options */
    public static class Options {
        public Call.Factory callFactory;
        public String hostname;
        public String path;
        public int policyPort = -1;
        public int port = -1;
        public Map<String, String> query;
        public boolean secure;
        protected Socket socket;
        public String timestampParam;
        public boolean timestampRequests;
        public WebSocket.Factory webSocketFactory;
    }

    /* access modifiers changed from: protected */
    public abstract void doClose();

    /* access modifiers changed from: protected */
    public abstract void doOpen();

    /* access modifiers changed from: protected */
    public abstract void write(Packet[] packetArr) throws UTF8Exception;

    /* renamed from: io.socket.engineio.client.Transport$ReadyState */
    protected enum ReadyState {
        OPENING,
        OPEN,
        CLOSED,
        PAUSED;

        public String toString() {
            return super.toString().toLowerCase();
        }
    }

    public Transport(Options options) {
        this.path = options.path;
        this.hostname = options.hostname;
        this.port = options.port;
        this.secure = options.secure;
        this.query = options.query;
        this.timestampParam = options.timestampParam;
        this.timestampRequests = options.timestampRequests;
        this.socket = options.socket;
        this.webSocketFactory = options.webSocketFactory;
        this.callFactory = options.callFactory;
    }

    /* access modifiers changed from: protected */
    public Transport onError(String str, Exception exc) {
        emit("error", new EngineIOException(str, exc));
        return this;
    }

    public Transport open() {
        EventThread.exec(new Runnable() {
            public void run() {
                if (Transport.this.readyState == ReadyState.CLOSED || Transport.this.readyState == null) {
                    Transport.this.readyState = ReadyState.OPENING;
                    Transport.this.doOpen();
                }
            }
        });
        return this;
    }

    public Transport close() {
        EventThread.exec(new Runnable() {
            public void run() {
                if (Transport.this.readyState == ReadyState.OPENING || Transport.this.readyState == ReadyState.OPEN) {
                    Transport.this.doClose();
                    Transport.this.onClose();
                }
            }
        });
        return this;
    }

    public void send(final Packet[] packetArr) {
        EventThread.exec(new Runnable() {
            public void run() {
                if (Transport.this.readyState == ReadyState.OPEN) {
                    try {
                        Transport.this.write(packetArr);
                    } catch (UTF8Exception e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    throw new RuntimeException("Transport not open");
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onOpen() {
        this.readyState = ReadyState.OPEN;
        this.writable = true;
        emit("open", new Object[0]);
    }

    /* access modifiers changed from: protected */
    public void onData(String str) {
        onPacket(Parser.decodePacket(str));
    }

    /* access modifiers changed from: protected */
    public void onData(byte[] bArr) {
        onPacket(Parser.decodePacket(bArr));
    }

    /* access modifiers changed from: protected */
    public void onPacket(Packet packet) {
        emit("packet", packet);
    }

    /* access modifiers changed from: protected */
    public void onClose() {
        this.readyState = ReadyState.CLOSED;
        emit("close", new Object[0]);
    }
}
