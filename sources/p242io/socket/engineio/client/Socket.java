package p242io.socket.engineio.client;

import com.datadog.trace.api.Config;
import com.didi.raven.config.RavenKey;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.WebSocket;
import org.json.JSONException;
import p242io.socket.emitter.Emitter;
import p242io.socket.engineio.client.Transport;
import p242io.socket.engineio.client.transports.Polling;
import p242io.socket.engineio.client.transports.PollingXHR;
import p242io.socket.engineio.parser.Packet;
import p242io.socket.parseqs.ParseQS;
import p242io.socket.thread.EventThread;

/* renamed from: io.socket.engineio.client.Socket */
public class Socket extends Emitter {
    public static final String EVENT_CLOSE = "close";
    public static final String EVENT_DATA = "data";
    public static final String EVENT_DRAIN = "drain";
    public static final String EVENT_ERROR = "error";
    public static final String EVENT_FLUSH = "flush";
    public static final String EVENT_HANDSHAKE = "handshake";
    public static final String EVENT_HEARTBEAT = "heartbeat";
    public static final String EVENT_MESSAGE = "message";
    public static final String EVENT_OPEN = "open";
    public static final String EVENT_PACKET = "packet";
    public static final String EVENT_PACKET_CREATE = "packetCreate";
    public static final String EVENT_PING = "ping";
    public static final String EVENT_PONG = "pong";
    public static final String EVENT_TRANSPORT = "transport";
    public static final String EVENT_UPGRADE = "upgrade";
    public static final String EVENT_UPGRADE_ERROR = "upgradeError";
    public static final String EVENT_UPGRADING = "upgrading";
    private static final String PROBE_ERROR = "probe error";
    public static final int PROTOCOL = 3;
    private static Call.Factory defaultCallFactory;
    private static OkHttpClient defaultOkHttpClient;
    private static WebSocket.Factory defaultWebSocketFactory;
    /* access modifiers changed from: private */
    public static final Logger logger = Logger.getLogger(Socket.class.getName());
    /* access modifiers changed from: private */
    public static boolean priorWebsocketSuccess = false;
    private Call.Factory callFactory;
    private ScheduledExecutorService heartbeatScheduler;
    String hostname;

    /* renamed from: id */
    private String f59537id;
    private final Emitter.Listener onHeartbeatAsListener;
    private String path;
    private long pingInterval;
    private Future pingIntervalTimer;
    /* access modifiers changed from: private */
    public long pingTimeout;
    private Future pingTimeoutTimer;
    private int policyPort;
    int port;
    private int prevBufferLen;
    private Map<String, String> query;
    /* access modifiers changed from: private */
    public ReadyState readyState;
    /* access modifiers changed from: private */
    public boolean rememberUpgrade;
    private boolean secure;
    private String timestampParam;
    private boolean timestampRequests;
    Transport transport;
    private Map<String, Transport.Options> transportOptions;
    /* access modifiers changed from: private */
    public List<String> transports;
    private boolean upgrade;
    private List<String> upgrades;
    /* access modifiers changed from: private */
    public boolean upgrading;
    private WebSocket.Factory webSocketFactory;
    LinkedList<Packet> writeBuffer;

    /* renamed from: io.socket.engineio.client.Socket$ReadyState */
    private enum ReadyState {
        OPENING,
        OPEN,
        CLOSING,
        CLOSED;

        public String toString() {
            return super.toString().toLowerCase();
        }
    }

    public Socket() {
        this(new Options());
    }

    public Socket(String str) throws URISyntaxException {
        this(str, (Options) null);
    }

    public Socket(URI uri) {
        this(uri, (Options) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public Socket(String str, Options options) throws URISyntaxException {
        this(str == null ? null : new URI(str), options);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public Socket(URI uri, Options options) {
        this(uri != null ? Options.fromURI(uri, options) : options);
    }

    public Socket(Options options) {
        this.writeBuffer = new LinkedList<>();
        this.onHeartbeatAsListener = new Emitter.Listener() {
            public void call(Object... objArr) {
                Socket.this.onHeartbeat(objArr.length > 0 ? objArr[0].longValue() : 0);
            }
        };
        if (options.host != null) {
            String str = options.host;
            if (str.split(":").length > 2) {
                int indexOf = str.indexOf(91);
                str = indexOf != -1 ? str.substring(indexOf + 1) : str;
                int lastIndexOf = str.lastIndexOf(93);
                if (lastIndexOf != -1) {
                    str = str.substring(0, lastIndexOf);
                }
            }
            options.hostname = str;
        }
        this.secure = options.secure;
        if (options.port == -1) {
            options.port = this.secure ? 443 : 80;
        }
        this.hostname = options.hostname != null ? options.hostname : Config.DEFAULT_AGENT_HOST;
        this.port = options.port;
        this.query = options.query != null ? ParseQS.decode(options.query) : new HashMap<>();
        this.upgrade = options.upgrade;
        StringBuilder sb = new StringBuilder();
        sb.append((options.path != null ? options.path : "/engine.io").replaceAll("/$", ""));
        sb.append("/");
        this.path = sb.toString();
        this.timestampParam = options.timestampParam != null ? options.timestampParam : RavenKey.TYPE;
        this.timestampRequests = options.timestampRequests;
        this.transports = new ArrayList(Arrays.asList(options.transports != null ? options.transports : new String[]{Polling.NAME, p242io.socket.engineio.client.transports.WebSocket.NAME}));
        this.transportOptions = options.transportOptions != null ? options.transportOptions : new HashMap<>();
        this.policyPort = options.policyPort != 0 ? options.policyPort : 843;
        this.rememberUpgrade = options.rememberUpgrade;
        this.callFactory = options.callFactory != null ? options.callFactory : defaultCallFactory;
        this.webSocketFactory = options.webSocketFactory != null ? options.webSocketFactory : defaultWebSocketFactory;
        if (this.callFactory == null) {
            if (defaultOkHttpClient == null) {
                defaultOkHttpClient = new OkHttpClient();
            }
            this.callFactory = defaultOkHttpClient;
        }
        if (this.webSocketFactory == null) {
            if (defaultOkHttpClient == null) {
                defaultOkHttpClient = new OkHttpClient();
            }
            this.webSocketFactory = defaultOkHttpClient;
        }
    }

    public static void setDefaultOkHttpWebSocketFactory(WebSocket.Factory factory) {
        defaultWebSocketFactory = factory;
    }

    public static void setDefaultOkHttpCallFactory(Call.Factory factory) {
        defaultCallFactory = factory;
    }

    public Socket open() {
        EventThread.exec(new Runnable() {
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: java.lang.Object} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: java.lang.String} */
            /* JADX WARNING: Multi-variable type inference failed */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r3 = this;
                    io.socket.engineio.client.Socket r0 = p242io.socket.engineio.client.Socket.this
                    boolean r0 = r0.rememberUpgrade
                    java.lang.String r1 = "websocket"
                    if (r0 == 0) goto L_0x001d
                    boolean r0 = p242io.socket.engineio.client.Socket.priorWebsocketSuccess
                    if (r0 == 0) goto L_0x001d
                    io.socket.engineio.client.Socket r0 = p242io.socket.engineio.client.Socket.this
                    java.util.List r0 = r0.transports
                    boolean r0 = r0.contains(r1)
                    if (r0 == 0) goto L_0x001d
                    goto L_0x0042
                L_0x001d:
                    io.socket.engineio.client.Socket r0 = p242io.socket.engineio.client.Socket.this
                    java.util.List r0 = r0.transports
                    int r0 = r0.size()
                    if (r0 != 0) goto L_0x0034
                    io.socket.engineio.client.Socket r0 = p242io.socket.engineio.client.Socket.this
                    io.socket.engineio.client.Socket$2$1 r1 = new io.socket.engineio.client.Socket$2$1
                    r1.<init>(r0)
                    p242io.socket.thread.EventThread.nextTick(r1)
                    return
                L_0x0034:
                    io.socket.engineio.client.Socket r0 = p242io.socket.engineio.client.Socket.this
                    java.util.List r0 = r0.transports
                    r1 = 0
                    java.lang.Object r0 = r0.get(r1)
                    r1 = r0
                    java.lang.String r1 = (java.lang.String) r1
                L_0x0042:
                    io.socket.engineio.client.Socket r0 = p242io.socket.engineio.client.Socket.this
                    io.socket.engineio.client.Socket$ReadyState r2 = p242io.socket.engineio.client.Socket.ReadyState.OPENING
                    p242io.socket.engineio.client.Socket.ReadyState unused = r0.readyState = r2
                    io.socket.engineio.client.Socket r0 = p242io.socket.engineio.client.Socket.this
                    io.socket.engineio.client.Transport r0 = r0.createTransport(r1)
                    io.socket.engineio.client.Socket r1 = p242io.socket.engineio.client.Socket.this
                    r1.setTransport(r0)
                    r0.open()
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: p242io.socket.engineio.client.Socket.C212802.run():void");
            }
        });
        return this;
    }

    /* access modifiers changed from: private */
    public Transport createTransport(String str) {
        Transport transport2;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(String.format("creating transport '%s'", new Object[]{str}));
        }
        HashMap hashMap = new HashMap(this.query);
        hashMap.put("EIO", String.valueOf(3));
        hashMap.put("transport", str);
        String str2 = this.f59537id;
        if (str2 != null) {
            hashMap.put("sid", str2);
        }
        Transport.Options options = this.transportOptions.get(str);
        Transport.Options options2 = new Transport.Options();
        options2.query = hashMap;
        options2.socket = this;
        options2.hostname = options != null ? options.hostname : this.hostname;
        options2.port = options != null ? options.port : this.port;
        options2.secure = options != null ? options.secure : this.secure;
        options2.path = options != null ? options.path : this.path;
        options2.timestampRequests = options != null ? options.timestampRequests : this.timestampRequests;
        options2.timestampParam = options != null ? options.timestampParam : this.timestampParam;
        options2.policyPort = options != null ? options.policyPort : this.policyPort;
        options2.callFactory = options != null ? options.callFactory : this.callFactory;
        options2.webSocketFactory = options != null ? options.webSocketFactory : this.webSocketFactory;
        if (p242io.socket.engineio.client.transports.WebSocket.NAME.equals(str)) {
            transport2 = new p242io.socket.engineio.client.transports.WebSocket(options2);
        } else if (Polling.NAME.equals(str)) {
            transport2 = new PollingXHR(options2);
        } else {
            throw new RuntimeException();
        }
        emit("transport", transport2);
        return transport2;
    }

    /* access modifiers changed from: private */
    public void setTransport(Transport transport2) {
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(String.format("setting transport %s", new Object[]{transport2.name}));
        }
        if (this.transport != null) {
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(String.format("clearing existing transport %s", new Object[]{this.transport.name}));
            }
            this.transport.off();
        }
        this.transport = transport2;
        transport2.mo175675on("drain", new Emitter.Listener() {
            public void call(Object... objArr) {
                this.onDrain();
            }
        }).mo175675on("packet", new Emitter.Listener() {
            public void call(Object... objArr) {
                this.onPacket(objArr.length > 0 ? objArr[0] : null);
            }
        }).mo175675on("error", new Emitter.Listener() {
            public void call(Object... objArr) {
                this.onError(objArr.length > 0 ? objArr[0] : null);
            }
        }).mo175675on("close", new Emitter.Listener() {
            public void call(Object... objArr) {
                this.onClose("transport close");
            }
        });
    }

    private void probe(String str) {
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(String.format("probing transport '%s'", new Object[]{str}));
        }
        final Transport[] transportArr = {createTransport(str)};
        final boolean[] zArr = {false};
        priorWebsocketSuccess = false;
        final Runnable[] runnableArr = new Runnable[1];
        final boolean[] zArr2 = zArr;
        final String str2 = str;
        final Transport[] transportArr2 = transportArr;
        final Runnable[] runnableArr2 = runnableArr;
        C212917 r0 = new Emitter.Listener() {
            public void call(Object... objArr) {
                if (!zArr2[0]) {
                    if (Socket.logger.isLoggable(Level.FINE)) {
                        Socket.logger.fine(String.format("probe transport '%s' opened", new Object[]{str2}));
                    }
                    Packet packet = new Packet("ping", "probe");
                    transportArr2[0].send(new Packet[]{packet});
                    transportArr2[0].once("packet", new Emitter.Listener() {
                        public void call(Object... objArr) {
                            if (!zArr2[0]) {
                                Packet packet = objArr[0];
                                if (!"pong".equals(packet.type) || !"probe".equals(packet.data)) {
                                    if (Socket.logger.isLoggable(Level.FINE)) {
                                        Socket.logger.fine(String.format("probe transport '%s' failed", new Object[]{str2}));
                                    }
                                    EngineIOException engineIOException = new EngineIOException(Socket.PROBE_ERROR);
                                    engineIOException.transport = transportArr2[0].name;
                                    this.emit(Socket.EVENT_UPGRADE_ERROR, engineIOException);
                                    return;
                                }
                                if (Socket.logger.isLoggable(Level.FINE)) {
                                    Socket.logger.fine(String.format("probe transport '%s' pong", new Object[]{str2}));
                                }
                                boolean unused = this.upgrading = true;
                                this.emit(Socket.EVENT_UPGRADING, transportArr2[0]);
                                if (transportArr2[0] != null) {
                                    boolean unused2 = Socket.priorWebsocketSuccess = p242io.socket.engineio.client.transports.WebSocket.NAME.equals(transportArr2[0].name);
                                    if (Socket.logger.isLoggable(Level.FINE)) {
                                        Socket.logger.fine(String.format("pausing current transport '%s'", new Object[]{this.transport.name}));
                                    }
                                    ((Polling) this.transport).pause(new Runnable() {
                                        public void run() {
                                            if (!zArr2[0] && ReadyState.CLOSED != this.readyState) {
                                                Socket.logger.fine("changing transport and sending upgrade packet");
                                                runnableArr2[0].run();
                                                this.setTransport(transportArr2[0]);
                                                Packet packet = new Packet("upgrade");
                                                transportArr2[0].send(new Packet[]{packet});
                                                this.emit("upgrade", transportArr2[0]);
                                                transportArr2[0] = null;
                                                boolean unused = this.upgrading = false;
                                                this.flush();
                                            }
                                        }
                                    });
                                }
                            }
                        }
                    });
                }
            }
        };
        final C212948 r6 = new Emitter.Listener() {
            public void call(Object... objArr) {
                boolean[] zArr = zArr;
                if (!zArr[0]) {
                    zArr[0] = true;
                    runnableArr[0].run();
                    transportArr[0].close();
                    transportArr[0] = null;
                }
            }
        };
        final Transport[] transportArr3 = transportArr;
        final C212948 r3 = r6;
        final String str3 = str;
        final C212959 r02 = new Emitter.Listener() {
            public void call(Object... objArr) {
                EngineIOException engineIOException;
                Exception exc = objArr[0];
                if (exc instanceof Exception) {
                    engineIOException = new EngineIOException(Socket.PROBE_ERROR, exc);
                } else if (exc instanceof String) {
                    engineIOException = new EngineIOException("probe error: " + exc);
                } else {
                    engineIOException = new EngineIOException(Socket.PROBE_ERROR);
                }
                engineIOException.transport = transportArr3[0].name;
                r3.call(new Object[0]);
                if (Socket.logger.isLoggable(Level.FINE)) {
                    Socket.logger.fine(String.format("probe transport \"%s\" failed because of error: %s", new Object[]{str3, exc}));
                }
                this.emit(Socket.EVENT_UPGRADE_ERROR, engineIOException);
            }
        };
        C2126710 r15 = new Emitter.Listener() {
            public void call(Object... objArr) {
                r02.call("transport closed");
            }
        };
        C2126811 r8 = new Emitter.Listener() {
            public void call(Object... objArr) {
                r02.call("socket closed");
            }
        };
        C2126912 r7 = new Emitter.Listener() {
            public void call(Object... objArr) {
                Transport transport = objArr[0];
                if (transportArr[0] != null && !transport.name.equals(transportArr[0].name)) {
                    if (Socket.logger.isLoggable(Level.FINE)) {
                        Socket.logger.fine(String.format("'%s' works - aborting '%s'", new Object[]{transport.name, transportArr[0].name}));
                    }
                    r6.call(new Object[0]);
                }
            }
        };
        final C212917 r32 = r0;
        final C212959 r4 = r02;
        final C2126710 r5 = r15;
        C2126912 r19 = r7;
        final C2126811 r72 = r8;
        C2126811 r17 = r8;
        final C2126912 r82 = r19;
        runnableArr[0] = new Runnable() {
            public void run() {
                transportArr3[0].off("open", r32);
                transportArr3[0].off("error", r4);
                transportArr3[0].off("close", r5);
                this.off("close", r72);
                this.off(Socket.EVENT_UPGRADING, r82);
            }
        };
        transportArr[0].once("open", r0);
        transportArr[0].once("error", r02);
        transportArr[0].once("close", r15);
        once("close", r17);
        once(EVENT_UPGRADING, r19);
        transportArr[0].open();
    }

    private void onOpen() {
        logger.fine("socket open");
        this.readyState = ReadyState.OPEN;
        priorWebsocketSuccess = p242io.socket.engineio.client.transports.WebSocket.NAME.equals(this.transport.name);
        emit("open", new Object[0]);
        flush();
        if (this.readyState == ReadyState.OPEN && this.upgrade && (this.transport instanceof Polling)) {
            logger.fine("starting upgrade probes");
            for (String probe : this.upgrades) {
                probe(probe);
            }
        }
    }

    /* access modifiers changed from: private */
    public void onPacket(Packet packet) {
        if (this.readyState == ReadyState.OPENING || this.readyState == ReadyState.OPEN || this.readyState == ReadyState.CLOSING) {
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(String.format("socket received: type '%s', data '%s'", new Object[]{packet.type, packet.data}));
            }
            emit("packet", packet);
            emit(EVENT_HEARTBEAT, new Object[0]);
            if ("open".equals(packet.type)) {
                try {
                    onHandshake(new HandshakeData((String) packet.data));
                } catch (JSONException e) {
                    emit("error", new EngineIOException((Throwable) e));
                }
            } else if ("pong".equals(packet.type)) {
                setPing();
                emit("pong", new Object[0]);
            } else if ("error".equals(packet.type)) {
                EngineIOException engineIOException = new EngineIOException("server error");
                engineIOException.code = packet.data;
                onError(engineIOException);
            } else if ("message".equals(packet.type)) {
                emit("data", packet.data);
                emit("message", packet.data);
            }
        } else if (logger.isLoggable(Level.FINE)) {
            logger.fine(String.format("packet received with socket readyState '%s'", new Object[]{this.readyState}));
        }
    }

    private void onHandshake(HandshakeData handshakeData) {
        emit(EVENT_HANDSHAKE, handshakeData);
        this.f59537id = handshakeData.sid;
        this.transport.query.put("sid", handshakeData.sid);
        this.upgrades = filterUpgrades(Arrays.asList(handshakeData.upgrades));
        this.pingInterval = handshakeData.pingInterval;
        this.pingTimeout = handshakeData.pingTimeout;
        onOpen();
        if (ReadyState.CLOSED != this.readyState) {
            setPing();
            off(EVENT_HEARTBEAT, this.onHeartbeatAsListener);
            mo175675on(EVENT_HEARTBEAT, this.onHeartbeatAsListener);
        }
    }

    /* access modifiers changed from: private */
    public void onHeartbeat(long j) {
        Future future = this.pingTimeoutTimer;
        if (future != null) {
            future.cancel(false);
        }
        if (j <= 0) {
            j = this.pingInterval + this.pingTimeout;
        }
        this.pingTimeoutTimer = getHeartbeatScheduler().schedule(new Runnable() {
            public void run() {
                EventThread.exec(new Runnable() {
                    public void run() {
                        if (this.readyState != ReadyState.CLOSED) {
                            this.onClose("ping timeout");
                        }
                    }
                });
            }
        }, j, TimeUnit.MILLISECONDS);
    }

    private void setPing() {
        Future future = this.pingIntervalTimer;
        if (future != null) {
            future.cancel(false);
        }
        this.pingIntervalTimer = getHeartbeatScheduler().schedule(new Runnable() {
            public void run() {
                EventThread.exec(new Runnable() {
                    public void run() {
                        if (Socket.logger.isLoggable(Level.FINE)) {
                            Socket.logger.fine(String.format("writing ping packet - expecting pong within %sms", new Object[]{Long.valueOf(this.pingTimeout)}));
                        }
                        this.ping();
                        this.onHeartbeat(this.pingTimeout);
                    }
                });
            }
        }, this.pingInterval, TimeUnit.MILLISECONDS);
    }

    /* access modifiers changed from: private */
    public void ping() {
        EventThread.exec(new Runnable() {
            public void run() {
                Socket.this.sendPacket("ping", (Runnable) new Runnable() {
                    public void run() {
                        Socket.this.emit("ping", new Object[0]);
                    }
                });
            }
        });
    }

    /* access modifiers changed from: private */
    public void onDrain() {
        for (int i = 0; i < this.prevBufferLen; i++) {
            this.writeBuffer.poll();
        }
        this.prevBufferLen = 0;
        if (this.writeBuffer.size() == 0) {
            emit("drain", new Object[0]);
        } else {
            flush();
        }
    }

    /* access modifiers changed from: private */
    public void flush() {
        if (this.readyState != ReadyState.CLOSED && this.transport.writable && !this.upgrading && this.writeBuffer.size() != 0) {
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(String.format("flushing %d packets in socket", new Object[]{Integer.valueOf(this.writeBuffer.size())}));
            }
            this.prevBufferLen = this.writeBuffer.size();
            Transport transport2 = this.transport;
            LinkedList<Packet> linkedList = this.writeBuffer;
            transport2.send((Packet[]) linkedList.toArray(new Packet[linkedList.size()]));
            emit(EVENT_FLUSH, new Object[0]);
        }
    }

    public void write(String str) {
        write(str, (Runnable) null);
    }

    public void write(String str, Runnable runnable) {
        send(str, runnable);
    }

    public void write(byte[] bArr) {
        write(bArr, (Runnable) null);
    }

    public void write(byte[] bArr, Runnable runnable) {
        send(bArr, runnable);
    }

    public void send(String str) {
        send(str, (Runnable) null);
    }

    public void send(byte[] bArr) {
        send(bArr, (Runnable) null);
    }

    public void send(final String str, final Runnable runnable) {
        EventThread.exec(new Runnable() {
            public void run() {
                Socket.this.sendPacket("message", str, runnable);
            }
        });
    }

    public void send(final byte[] bArr, final Runnable runnable) {
        EventThread.exec(new Runnable() {
            public void run() {
                Socket.this.sendPacket("message", bArr, runnable);
            }
        });
    }

    /* access modifiers changed from: private */
    public void sendPacket(String str, Runnable runnable) {
        sendPacket(new Packet(str), runnable);
    }

    /* access modifiers changed from: private */
    public void sendPacket(String str, String str2, Runnable runnable) {
        sendPacket(new Packet(str, str2), runnable);
    }

    /* access modifiers changed from: private */
    public void sendPacket(String str, byte[] bArr, Runnable runnable) {
        sendPacket(new Packet(str, bArr), runnable);
    }

    private void sendPacket(Packet packet, final Runnable runnable) {
        if (ReadyState.CLOSING != this.readyState && ReadyState.CLOSED != this.readyState) {
            emit(EVENT_PACKET_CREATE, packet);
            this.writeBuffer.offer(packet);
            if (runnable != null) {
                once(EVENT_FLUSH, new Emitter.Listener() {
                    public void call(Object... objArr) {
                        runnable.run();
                    }
                });
            }
            flush();
        }
    }

    public Socket close() {
        EventThread.exec(new Runnable() {
            public void run() {
                if (Socket.this.readyState == ReadyState.OPENING || Socket.this.readyState == ReadyState.OPEN) {
                    ReadyState unused = Socket.this.readyState = ReadyState.CLOSING;
                    final Socket socket = Socket.this;
                    final C212831 r1 = new Runnable() {
                        public void run() {
                            socket.onClose("forced close");
                            Socket.logger.fine("socket closing - telling transport to close");
                            socket.transport.close();
                        }
                    };
                    final Emitter.Listener[] listenerArr = {new Emitter.Listener() {
                        public void call(Object... objArr) {
                            socket.off("upgrade", listenerArr[0]);
                            socket.off(Socket.EVENT_UPGRADE_ERROR, listenerArr[0]);
                            r1.run();
                        }
                    }};
                    final C212853 r3 = new Runnable() {
                        public void run() {
                            socket.once("upgrade", listenerArr[0]);
                            socket.once(Socket.EVENT_UPGRADE_ERROR, listenerArr[0]);
                        }
                    };
                    if (Socket.this.writeBuffer.size() > 0) {
                        Socket.this.once("drain", new Emitter.Listener() {
                            public void call(Object... objArr) {
                                if (Socket.this.upgrading) {
                                    r3.run();
                                } else {
                                    r1.run();
                                }
                            }
                        });
                    } else if (Socket.this.upgrading) {
                        r3.run();
                    } else {
                        r1.run();
                    }
                }
            }
        });
        return this;
    }

    /* access modifiers changed from: private */
    public void onError(Exception exc) {
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(String.format("socket error %s", new Object[]{exc}));
        }
        priorWebsocketSuccess = false;
        emit("error", exc);
        onClose("transport error", exc);
    }

    /* access modifiers changed from: private */
    public void onClose(String str) {
        onClose(str, (Exception) null);
    }

    private void onClose(String str, Exception exc) {
        if (ReadyState.OPENING == this.readyState || ReadyState.OPEN == this.readyState || ReadyState.CLOSING == this.readyState) {
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(String.format("socket close with reason: %s", new Object[]{str}));
            }
            Future future = this.pingIntervalTimer;
            if (future != null) {
                future.cancel(false);
            }
            Future future2 = this.pingTimeoutTimer;
            if (future2 != null) {
                future2.cancel(false);
            }
            ScheduledExecutorService scheduledExecutorService = this.heartbeatScheduler;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdown();
            }
            this.transport.off("close");
            this.transport.close();
            this.transport.off();
            this.readyState = ReadyState.CLOSED;
            this.f59537id = null;
            emit("close", str, exc);
            this.writeBuffer.clear();
            this.prevBufferLen = 0;
        }
    }

    /* access modifiers changed from: package-private */
    public List<String> filterUpgrades(List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (String next : list) {
            if (this.transports.contains(next)) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    /* renamed from: id */
    public String mo175679id() {
        return this.f59537id;
    }

    private ScheduledExecutorService getHeartbeatScheduler() {
        ScheduledExecutorService scheduledExecutorService = this.heartbeatScheduler;
        if (scheduledExecutorService == null || scheduledExecutorService.isShutdown()) {
            this.heartbeatScheduler = Executors.newSingleThreadScheduledExecutor();
        }
        return this.heartbeatScheduler;
    }

    /* renamed from: io.socket.engineio.client.Socket$Options */
    public static class Options extends Transport.Options {
        public String host;
        public String query;
        public boolean rememberUpgrade;
        public Map<String, Transport.Options> transportOptions;
        public String[] transports;
        public boolean upgrade = true;

        /* access modifiers changed from: private */
        public static Options fromURI(URI uri, Options options) {
            if (options == null) {
                options = new Options();
            }
            options.host = uri.getHost();
            options.secure = "https".equals(uri.getScheme()) || "wss".equals(uri.getScheme());
            options.port = uri.getPort();
            String rawQuery = uri.getRawQuery();
            if (rawQuery != null) {
                options.query = rawQuery;
            }
            return options;
        }
    }
}
