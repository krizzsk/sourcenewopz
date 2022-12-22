package p242io.socket.engineio.client.transports;

import com.didi.hawaii.mapsdkv2.HWMapConstant;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import p242io.socket.emitter.Emitter;
import p242io.socket.engineio.client.Transport;
import p242io.socket.engineio.parser.Packet;
import p242io.socket.engineio.parser.Parser;
import p242io.socket.parseqs.ParseQS;
import p242io.socket.thread.EventThread;
import p242io.socket.utf8.UTF8Exception;
import p242io.socket.yeast.Yeast;

/* renamed from: io.socket.engineio.client.transports.Polling */
public abstract class Polling extends Transport {
    public static final String EVENT_POLL = "poll";
    public static final String EVENT_POLL_COMPLETE = "pollComplete";
    public static final String NAME = "polling";
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final Logger f59538a = Logger.getLogger(Polling.class.getName());
    /* access modifiers changed from: private */

    /* renamed from: b */
    public boolean f59539b;

    /* access modifiers changed from: protected */
    public abstract void doPoll();

    /* access modifiers changed from: protected */
    public abstract void doWrite(String str, Runnable runnable);

    /* access modifiers changed from: protected */
    public abstract void doWrite(byte[] bArr, Runnable runnable);

    public Polling(Transport.Options options) {
        super(options);
        this.name = NAME;
    }

    /* access modifiers changed from: protected */
    public void doOpen() {
        m42038b();
    }

    public void pause(final Runnable runnable) {
        EventThread.exec(new Runnable() {
            public void run() {
                final Polling polling = Polling.this;
                Transport.ReadyState unused = polling.readyState = Transport.ReadyState.PAUSED;
                final C213001 r1 = new Runnable() {
                    public void run() {
                        Polling.f59538a.fine("paused");
                        Transport.ReadyState unused = polling.readyState = Transport.ReadyState.PAUSED;
                        runnable.run();
                    }
                };
                if (Polling.this.f59539b || !Polling.this.writable) {
                    final int[] iArr = {0};
                    if (Polling.this.f59539b) {
                        Polling.f59538a.fine("we are currently polling - waiting to pause");
                        iArr[0] = iArr[0] + 1;
                        Polling.this.once(Polling.EVENT_POLL_COMPLETE, new Emitter.Listener() {
                            public void call(Object... objArr) {
                                Polling.f59538a.fine("pre-pause polling complete");
                                int[] iArr = iArr;
                                int i = iArr[0] - 1;
                                iArr[0] = i;
                                if (i == 0) {
                                    r1.run();
                                }
                            }
                        });
                    }
                    if (!Polling.this.writable) {
                        Polling.f59538a.fine("we are currently writing - waiting to pause");
                        iArr[0] = iArr[0] + 1;
                        Polling.this.once("drain", new Emitter.Listener() {
                            public void call(Object... objArr) {
                                Polling.f59538a.fine("pre-pause writing complete");
                                int[] iArr = iArr;
                                int i = iArr[0] - 1;
                                iArr[0] = i;
                                if (i == 0) {
                                    r1.run();
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
                r1.run();
            }
        });
    }

    /* renamed from: b */
    private void m42038b() {
        f59538a.fine(NAME);
        this.f59539b = true;
        doPoll();
        emit(EVENT_POLL, new Object[0]);
    }

    /* access modifiers changed from: protected */
    public void onData(String str) {
        m42034a((Object) str);
    }

    /* access modifiers changed from: protected */
    public void onData(byte[] bArr) {
        m42034a((Object) bArr);
    }

    /* renamed from: a */
    private void m42034a(Object obj) {
        if (f59538a.isLoggable(Level.FINE)) {
            f59538a.fine(String.format("polling got data %s", new Object[]{obj}));
        }
        C213032 r0 = new Parser.DecodePayloadCallback() {
            public boolean call(Packet packet, int i, int i2) {
                if (this.readyState == Transport.ReadyState.OPENING) {
                    this.onOpen();
                }
                if ("close".equals(packet.type)) {
                    this.onClose();
                    return false;
                }
                this.onPacket(packet);
                return true;
            }
        };
        if (obj instanceof String) {
            Parser.decodePayload((String) obj, (Parser.DecodePayloadCallback<String>) r0);
        } else if (obj instanceof byte[]) {
            Parser.decodePayload((byte[]) obj, (Parser.DecodePayloadCallback) r0);
        }
        if (this.readyState != Transport.ReadyState.CLOSED) {
            this.f59539b = false;
            emit(EVENT_POLL_COMPLETE, new Object[0]);
            if (this.readyState == Transport.ReadyState.OPEN) {
                m42038b();
            } else if (f59538a.isLoggable(Level.FINE)) {
                f59538a.fine(String.format("ignoring poll - transport state '%s'", new Object[]{this.readyState}));
            }
        }
    }

    /* access modifiers changed from: protected */
    public void doClose() {
        C213043 r0 = new Emitter.Listener() {
            public void call(Object... objArr) {
                Polling.f59538a.fine("writing close packet");
                try {
                    this.write(new Packet[]{new Packet("close")});
                } catch (UTF8Exception e) {
                    throw new RuntimeException(e);
                }
            }
        };
        if (this.readyState == Transport.ReadyState.OPEN) {
            f59538a.fine("transport open - closing");
            r0.call(new Object[0]);
            return;
        }
        f59538a.fine("transport not open - deferring close");
        once("open", r0);
    }

    /* access modifiers changed from: protected */
    public void write(Packet[] packetArr) throws UTF8Exception {
        this.writable = false;
        final C213054 r0 = new Runnable() {
            public void run() {
                this.writable = true;
                this.emit("drain", new Object[0]);
            }
        };
        Parser.encodePayload(packetArr, new Parser.EncodeCallback() {
            public void call(Object obj) {
                if (obj instanceof byte[]) {
                    this.doWrite((byte[]) obj, r0);
                } else if (obj instanceof String) {
                    this.doWrite((String) obj, r0);
                } else {
                    Logger a = Polling.f59538a;
                    a.warning("Unexpected data: " + obj);
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public String uri() {
        String str;
        String str2;
        Map map = this.query;
        if (map == null) {
            map = new HashMap();
        }
        String str3 = this.secure ? "https" : "http";
        if (this.timestampRequests) {
            map.put(this.timestampParam, Yeast.yeast());
        }
        String encode = ParseQS.encode(map);
        if (this.port <= 0 || ((!"https".equals(str3) || this.port == 443) && (!"http".equals(str3) || this.port == 80))) {
            str = "";
        } else {
            str = ":" + this.port;
        }
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
