package p242io.socket.client;

import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.Call;
import okhttp3.WebSocket;
import p242io.socket.backo.Backoff;
import p242io.socket.client.C21252On;
import p242io.socket.emitter.Emitter;
import p242io.socket.engineio.client.Socket;
import p242io.socket.parser.IOParser;
import p242io.socket.parser.Packet;
import p242io.socket.parser.Parser;
import p242io.socket.thread.EventThread;
import rui.config.RConfigConstants;

/* renamed from: io.socket.client.Manager */
public class Manager extends Emitter {
    public static final String EVENT_CLOSE = "close";
    public static final String EVENT_CONNECT_ERROR = "connect_error";
    public static final String EVENT_CONNECT_TIMEOUT = "connect_timeout";
    public static final String EVENT_ERROR = "error";
    public static final String EVENT_OPEN = "open";
    public static final String EVENT_PACKET = "packet";
    public static final String EVENT_PING = "ping";
    public static final String EVENT_PONG = "pong";
    public static final String EVENT_RECONNECT = "reconnect";
    public static final String EVENT_RECONNECTING = "reconnecting";
    public static final String EVENT_RECONNECT_ATTEMPT = "reconnect_attempt";
    public static final String EVENT_RECONNECT_ERROR = "reconnect_error";
    public static final String EVENT_RECONNECT_FAILED = "reconnect_failed";
    public static final String EVENT_TRANSPORT = "transport";

    /* renamed from: a */
    static WebSocket.Factory f59498a;

    /* renamed from: b */
    static Call.Factory f59499b;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public static final Logger f59500f = Logger.getLogger(Manager.class.getName());

    /* renamed from: c */
    ReadyState f59501c;

    /* renamed from: d */
    Socket f59502d;

    /* renamed from: e */
    ConcurrentHashMap<String, Socket> f59503e;

    /* renamed from: g */
    private boolean f59504g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f59505h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public boolean f59506i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public boolean f59507j;

    /* renamed from: k */
    private int f59508k;

    /* renamed from: l */
    private long f59509l;

    /* renamed from: m */
    private long f59510m;

    /* renamed from: n */
    private double f59511n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public Backoff f59512o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public long f59513p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public Set<Socket> f59514q;

    /* renamed from: r */
    private Date f59515r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public URI f59516s;

    /* renamed from: t */
    private List<Packet> f59517t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public Queue<C21252On.Handle> f59518u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public Options f59519v;

    /* renamed from: w */
    private Parser.Encoder f59520w;

    /* renamed from: x */
    private Parser.Decoder f59521x;

    /* renamed from: io.socket.client.Manager$OpenCallback */
    public interface OpenCallback {
        void call(Exception exc);
    }

    /* renamed from: io.socket.client.Manager$Options */
    public static class Options extends Socket.Options {
        public Parser.Decoder decoder;
        public Parser.Encoder encoder;
        public double randomizationFactor;
        public boolean reconnection = true;
        public int reconnectionAttempts;
        public long reconnectionDelay;
        public long reconnectionDelayMax;
        public long timeout = 20000;
    }

    /* renamed from: io.socket.client.Manager$ReadyState */
    enum ReadyState {
        CLOSED,
        OPENING,
        OPEN
    }

    public Manager() {
        this((URI) null, (Options) null);
    }

    public Manager(URI uri) {
        this(uri, (Options) null);
    }

    public Manager(Options options) {
        this((URI) null, options);
    }

    public Manager(URI uri, Options options) {
        this.f59514q = new HashSet();
        options = options == null ? new Options() : options;
        if (options.path == null) {
            options.path = "/socket.io";
        }
        if (options.webSocketFactory == null) {
            options.webSocketFactory = f59498a;
        }
        if (options.callFactory == null) {
            options.callFactory = f59499b;
        }
        this.f59519v = options;
        this.f59503e = new ConcurrentHashMap<>();
        this.f59518u = new LinkedList();
        reconnection(options.reconnection);
        reconnectionAttempts(options.reconnectionAttempts != 0 ? options.reconnectionAttempts : Integer.MAX_VALUE);
        reconnectionDelay(options.reconnectionDelay != 0 ? options.reconnectionDelay : 1000);
        reconnectionDelayMax(options.reconnectionDelayMax != 0 ? options.reconnectionDelayMax : 5000);
        randomizationFactor(options.randomizationFactor != 0.0d ? options.randomizationFactor : 0.5d);
        this.f59512o = new Backoff().setMin(reconnectionDelay()).setMax(reconnectionDelayMax()).setJitter(randomizationFactor());
        timeout(options.timeout);
        this.f59501c = ReadyState.CLOSED;
        this.f59516s = uri;
        this.f59507j = false;
        this.f59517t = new ArrayList();
        this.f59520w = options.encoder != null ? options.encoder : new IOParser.Encoder();
        this.f59521x = options.decoder != null ? options.decoder : new IOParser.Decoder();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m41960a(String str, Object... objArr) {
        emit(str, objArr);
        for (Socket emit : this.f59503e.values()) {
            emit.emit(str, objArr);
        }
    }

    /* renamed from: c */
    private void m41970c() {
        for (Map.Entry next : this.f59503e.entrySet()) {
            ((Socket) next.getValue()).f59523a = m41952a((String) next.getKey());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public String m41952a(String str) {
        String str2;
        StringBuilder sb = new StringBuilder();
        if ("/".equals(str)) {
            str2 = "";
        } else {
            str2 = str + RConfigConstants.KEYWORD_COLOR_SIGN;
        }
        sb.append(str2);
        sb.append(this.f59502d.mo175679id());
        return sb.toString();
    }

    public boolean reconnection() {
        return this.f59504g;
    }

    public Manager reconnection(boolean z) {
        this.f59504g = z;
        return this;
    }

    public boolean isReconnecting() {
        return this.f59506i;
    }

    public int reconnectionAttempts() {
        return this.f59508k;
    }

    public Manager reconnectionAttempts(int i) {
        this.f59508k = i;
        return this;
    }

    public final long reconnectionDelay() {
        return this.f59509l;
    }

    public Manager reconnectionDelay(long j) {
        this.f59509l = j;
        Backoff backoff = this.f59512o;
        if (backoff != null) {
            backoff.setMin(j);
        }
        return this;
    }

    public final double randomizationFactor() {
        return this.f59511n;
    }

    public Manager randomizationFactor(double d) {
        this.f59511n = d;
        Backoff backoff = this.f59512o;
        if (backoff != null) {
            backoff.setJitter(d);
        }
        return this;
    }

    public final long reconnectionDelayMax() {
        return this.f59510m;
    }

    public Manager reconnectionDelayMax(long j) {
        this.f59510m = j;
        Backoff backoff = this.f59512o;
        if (backoff != null) {
            backoff.setMax(j);
        }
        return this;
    }

    public long timeout() {
        return this.f59513p;
    }

    public Manager timeout(long j) {
        this.f59513p = j;
        return this;
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m41974d() {
        if (!this.f59506i && this.f59504g && this.f59512o.getAttempts() == 0) {
            m41987j();
        }
    }

    public Manager open() {
        return open((OpenCallback) null);
    }

    public Manager open(final OpenCallback openCallback) {
        EventThread.exec(new Runnable() {
            public void run() {
                if (Manager.f59500f.isLoggable(Level.FINE)) {
                    Manager.f59500f.fine(String.format("readyState %s", new Object[]{Manager.this.f59501c}));
                }
                if (Manager.this.f59501c != ReadyState.OPEN && Manager.this.f59501c != ReadyState.OPENING) {
                    if (Manager.f59500f.isLoggable(Level.FINE)) {
                        Manager.f59500f.fine(String.format("opening %s", new Object[]{Manager.this.f59516s}));
                    }
                    Manager manager = Manager.this;
                    manager.f59502d = new Engine(manager.f59516s, Manager.this.f59519v);
                    final Socket socket = Manager.this.f59502d;
                    final Manager manager2 = Manager.this;
                    manager2.f59501c = ReadyState.OPENING;
                    boolean unused = Manager.this.f59505h = false;
                    socket.mo175675on("transport", new Emitter.Listener() {
                        public void call(Object... objArr) {
                            manager2.emit("transport", objArr);
                        }
                    });
                    C21252On.Handle on = C21252On.m41997on(socket, "open", new Emitter.Listener() {
                        public void call(Object... objArr) {
                            manager2.m41976e();
                            if (openCallback != null) {
                                openCallback.call((Exception) null);
                            }
                        }
                    });
                    C21252On.Handle on2 = C21252On.m41997on(socket, "error", new Emitter.Listener() {
                        public void call(Object... objArr) {
                            Exception exc = null;
                            Exception exc2 = objArr.length > 0 ? objArr[0] : null;
                            Manager.f59500f.fine("connect_error");
                            manager2.m41984i();
                            manager2.f59501c = ReadyState.CLOSED;
                            manager2.m41960a("connect_error", exc2);
                            if (openCallback != null) {
                                if (exc2 instanceof Exception) {
                                    exc = exc2;
                                }
                                openCallback.call(new SocketIOException("Connection error", exc));
                                return;
                            }
                            manager2.m41974d();
                        }
                    });
                    if (Manager.this.f59513p >= 0) {
                        long f = Manager.this.f59513p;
                        Manager.f59500f.fine(String.format("connection attempt will timeout after %d", new Object[]{Long.valueOf(f)}));
                        final Timer timer = new Timer();
                        final long j = f;
                        final C21252On.Handle handle = on;
                        timer.schedule(new TimerTask() {
                            public void run() {
                                EventThread.exec(new Runnable() {
                                    public void run() {
                                        Manager.f59500f.fine(String.format("connect attempt timed out after %d", new Object[]{Long.valueOf(j)}));
                                        handle.destroy();
                                        socket.close();
                                        socket.emit("error", new SocketIOException("timeout"));
                                        manager2.m41960a("connect_timeout", Long.valueOf(j));
                                    }
                                });
                            }
                        }, f);
                        Manager.this.f59518u.add(new C21252On.Handle() {
                            public void destroy() {
                                timer.cancel();
                            }
                        });
                    }
                    Manager.this.f59518u.add(on);
                    Manager.this.f59518u.add(on2);
                    Manager.this.f59502d.open();
                }
            }
        });
        return this;
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m41976e() {
        f59500f.fine("open");
        m41984i();
        this.f59501c = ReadyState.OPEN;
        emit("open", new Object[0]);
        Socket socket = this.f59502d;
        this.f59518u.add(C21252On.m41997on(socket, "data", new Emitter.Listener() {
            public void call(Object... objArr) {
                String str = objArr[0];
                if (str instanceof String) {
                    Manager.this.m41967b(str);
                } else if (str instanceof byte[]) {
                    Manager.this.m41961a((byte[]) str);
                }
            }
        }));
        this.f59518u.add(C21252On.m41997on(socket, "ping", new Emitter.Listener() {
            public void call(Object... objArr) {
                Manager.this.m41979f();
            }
        }));
        this.f59518u.add(C21252On.m41997on(socket, "pong", new Emitter.Listener() {
            public void call(Object... objArr) {
                Manager.this.m41981g();
            }
        }));
        this.f59518u.add(C21252On.m41997on(socket, "error", new Emitter.Listener() {
            public void call(Object... objArr) {
                Manager.this.m41959a(objArr[0]);
            }
        }));
        this.f59518u.add(C21252On.m41997on(socket, "close", new Emitter.Listener() {
            public void call(Object... objArr) {
                Manager.this.m41972c(objArr[0]);
            }
        }));
        this.f59521x.onDecoded(new Parser.Decoder.Callback() {
            public void call(Packet packet) {
                Manager.this.m41966b(packet);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m41979f() {
        this.f59515r = new Date();
        m41960a("ping", new Object[0]);
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m41981g() {
        Object[] objArr = new Object[1];
        objArr[0] = Long.valueOf(this.f59515r != null ? new Date().getTime() - this.f59515r.getTime() : 0);
        m41960a("pong", objArr);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m41967b(String str) {
        this.f59521x.add(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m41961a(byte[] bArr) {
        this.f59521x.add(bArr);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m41966b(Packet packet) {
        emit("packet", packet);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m41959a(Exception exc) {
        f59500f.log(Level.FINE, "error", exc);
        m41960a("error", exc);
    }

    public Socket socket(final String str, Options options) {
        Socket socket = this.f59503e.get(str);
        if (socket != null) {
            return socket;
        }
        final Socket socket2 = new Socket(this, str, options);
        Socket putIfAbsent = this.f59503e.putIfAbsent(str, socket2);
        if (putIfAbsent != null) {
            return putIfAbsent;
        }
        socket2.mo175675on(Socket.EVENT_CONNECTING, new Emitter.Listener() {
            public void call(Object... objArr) {
                this.f59514q.add(socket2);
            }
        });
        socket2.mo175675on("connect", new Emitter.Listener() {
            public void call(Object... objArr) {
                socket2.f59523a = this.m41952a(str);
            }
        });
        return socket2;
    }

    public Socket socket(String str) {
        return socket(str, (Options) null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo175626a(Socket socket) {
        this.f59514q.remove(socket);
        if (this.f59514q.isEmpty()) {
            mo175625a();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo175627a(Packet packet) {
        if (f59500f.isLoggable(Level.FINE)) {
            f59500f.fine(String.format("writing packet %s", new Object[]{packet}));
        }
        if (packet.query != null && !packet.query.isEmpty() && packet.type == 0) {
            packet.nsp += "?" + packet.query;
        }
        if (!this.f59507j) {
            this.f59507j = true;
            this.f59520w.encode(packet, new Parser.Encoder.Callback() {
                public void call(Object[] objArr) {
                    for (String str : objArr) {
                        if (str instanceof String) {
                            this.f59502d.write(str);
                        } else if (str instanceof byte[]) {
                            this.f59502d.write((byte[]) str);
                        }
                    }
                    boolean unused = this.f59507j = false;
                    this.m41982h();
                }
            });
            return;
        }
        this.f59517t.add(packet);
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m41982h() {
        if (!this.f59517t.isEmpty() && !this.f59507j) {
            mo175627a(this.f59517t.remove(0));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m41984i() {
        f59500f.fine("cleanup");
        while (true) {
            C21252On.Handle poll = this.f59518u.poll();
            if (poll != null) {
                poll.destroy();
            } else {
                this.f59521x.onDecoded((Parser.Decoder.Callback) null);
                this.f59517t.clear();
                this.f59507j = false;
                this.f59515r = null;
                this.f59521x.destroy();
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo175625a() {
        f59500f.fine(Socket.EVENT_DISCONNECT);
        this.f59505h = true;
        this.f59506i = false;
        if (this.f59501c != ReadyState.OPEN) {
            m41984i();
        }
        this.f59512o.reset();
        this.f59501c = ReadyState.CLOSED;
        Socket socket = this.f59502d;
        if (socket != null) {
            socket.close();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m41972c(String str) {
        f59500f.fine("onclose");
        m41984i();
        this.f59512o.reset();
        this.f59501c = ReadyState.CLOSED;
        emit("close", str);
        if (this.f59504g && !this.f59505h) {
            m41987j();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public void m41987j() {
        if (!this.f59506i && !this.f59505h) {
            if (this.f59512o.getAttempts() >= this.f59508k) {
                f59500f.fine("reconnect failed");
                this.f59512o.reset();
                m41960a("reconnect_failed", new Object[0]);
                this.f59506i = false;
                return;
            }
            long duration = this.f59512o.duration();
            f59500f.fine(String.format("will wait %dms before reconnect attempt", new Object[]{Long.valueOf(duration)}));
            this.f59506i = true;
            final Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                public void run() {
                    EventThread.exec(new Runnable() {
                        public void run() {
                            if (!this.f59505h) {
                                Manager.f59500f.fine("attempting reconnect");
                                int attempts = this.f59512o.getAttempts();
                                this.m41960a("reconnect_attempt", Integer.valueOf(attempts));
                                this.m41960a("reconnecting", Integer.valueOf(attempts));
                                if (!this.f59505h) {
                                    this.open(new OpenCallback() {
                                        public void call(Exception exc) {
                                            if (exc != null) {
                                                Manager.f59500f.fine("reconnect attempt error");
                                                boolean unused = this.f59506i = false;
                                                this.m41987j();
                                                this.m41960a("reconnect_error", exc);
                                                return;
                                            }
                                            Manager.f59500f.fine("reconnect success");
                                            this.m41988k();
                                        }
                                    });
                                }
                            }
                        }
                    });
                }
            }, duration);
            this.f59518u.add(new C21252On.Handle() {
                public void destroy() {
                    timer.cancel();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public void m41988k() {
        int attempts = this.f59512o.getAttempts();
        this.f59506i = false;
        this.f59512o.reset();
        m41970c();
        m41960a("reconnect", Integer.valueOf(attempts));
    }

    /* renamed from: io.socket.client.Manager$Engine */
    private static class Engine extends Socket {
        Engine(URI uri, Socket.Options options) {
            super(uri, options);
        }
    }
}
