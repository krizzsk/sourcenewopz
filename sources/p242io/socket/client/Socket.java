package p242io.socket.client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p242io.socket.client.C21252On;
import p242io.socket.client.Manager;
import p242io.socket.emitter.Emitter;
import p242io.socket.parser.Packet;
import p242io.socket.thread.EventThread;

/* renamed from: io.socket.client.Socket */
public class Socket extends Emitter {
    public static final String EVENT_CONNECT = "connect";
    public static final String EVENT_CONNECTING = "connecting";
    public static final String EVENT_CONNECT_ERROR = "connect_error";
    public static final String EVENT_CONNECT_TIMEOUT = "connect_timeout";
    public static final String EVENT_DISCONNECT = "disconnect";
    public static final String EVENT_ERROR = "error";
    public static final String EVENT_MESSAGE = "message";
    public static final String EVENT_PING = "ping";
    public static final String EVENT_PONG = "pong";
    public static final String EVENT_RECONNECT = "reconnect";
    public static final String EVENT_RECONNECTING = "reconnecting";
    public static final String EVENT_RECONNECT_ATTEMPT = "reconnect_attempt";
    public static final String EVENT_RECONNECT_ERROR = "reconnect_error";
    public static final String EVENT_RECONNECT_FAILED = "reconnect_failed";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final Logger f59522b = Logger.getLogger(Socket.class.getName());
    protected static Map<String, Integer> events = new HashMap<String, Integer>() {
        {
            put("connect", 1);
            put("connect_error", 1);
            put("connect_timeout", 1);
            put(Socket.EVENT_CONNECTING, 1);
            put(Socket.EVENT_DISCONNECT, 1);
            put("error", 1);
            put("reconnect", 1);
            put("reconnect_attempt", 1);
            put("reconnect_failed", 1);
            put("reconnect_error", 1);
            put("reconnecting", 1);
            put("ping", 1);
            put("pong", 1);
        }
    };

    /* renamed from: a */
    String f59523a;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public volatile boolean f59524c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public int f59525d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public String f59526e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Manager f59527f;

    /* renamed from: g */
    private String f59528g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public Map<Integer, Ack> f59529h = new HashMap();

    /* renamed from: i */
    private Queue<C21252On.Handle> f59530i;

    /* renamed from: j */
    private final Queue<List<Object>> f59531j = new LinkedList();
    /* access modifiers changed from: private */

    /* renamed from: k */
    public final Queue<Packet<JSONArray>> f59532k = new LinkedList();

    /* renamed from: g */
    static /* synthetic */ int m42021g(Socket socket) {
        int i = socket.f59525d;
        socket.f59525d = i + 1;
        return i;
    }

    public Socket(Manager manager, String str, Manager.Options options) {
        this.f59527f = manager;
        this.f59526e = str;
        if (options != null) {
            this.f59528g = options.query;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m42007b() {
        if (this.f59530i == null) {
            final Manager manager = this.f59527f;
            this.f59530i = new LinkedList<C21252On.Handle>() {
                {
                    add(C21252On.m41997on(manager, "open", new Emitter.Listener() {
                        public void call(Object... objArr) {
                            Socket.this.m42012c();
                        }
                    }));
                    add(C21252On.m41997on(manager, "packet", new Emitter.Listener() {
                        public void call(Object... objArr) {
                            Socket.this.m42009b((Packet<?>) objArr[0]);
                        }
                    }));
                    add(C21252On.m41997on(manager, "close", new Emitter.Listener() {
                        public void call(Object... objArr) {
                            Socket.this.m42005a(objArr.length > 0 ? objArr[0] : null);
                        }
                    }));
                }
            };
        }
    }

    public Socket open() {
        EventThread.exec(new Runnable() {
            public void run() {
                if (!Socket.this.f59524c && !Socket.this.f59527f.isReconnecting()) {
                    Socket.this.m42007b();
                    Socket.this.f59527f.open();
                    if (Manager.ReadyState.OPEN == Socket.this.f59527f.f59501c) {
                        Socket.this.m42012c();
                    }
                    Socket.this.emit(Socket.EVENT_CONNECTING, new Object[0]);
                }
            }
        });
        return this;
    }

    public Socket connect() {
        return open();
    }

    public Socket send(final Object... objArr) {
        EventThread.exec(new Runnable() {
            public void run() {
                Socket.this.emit("message", objArr);
            }
        });
        return this;
    }

    public Emitter emit(final String str, final Object... objArr) {
        EventThread.exec(new Runnable() {
            public void run() {
                Ack ack;
                Object[] objArr;
                if (Socket.events.containsKey(str)) {
                    Emitter unused = Socket.super.emit(str, objArr);
                    return;
                }
                Object[] objArr2 = objArr;
                int length = objArr2.length - 1;
                if (objArr2.length <= 0 || !(objArr2[length] instanceof Ack)) {
                    objArr = objArr;
                    ack = null;
                } else {
                    objArr = new Object[length];
                    for (int i = 0; i < length; i++) {
                        objArr[i] = objArr[i];
                    }
                    ack = (Ack) objArr[length];
                }
                Socket.this.emit(str, objArr, ack);
            }
        });
        return this;
    }

    public Emitter emit(final String str, final Object[] objArr, final Ack ack) {
        EventThread.exec(new Runnable() {
            public void run() {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(str);
                Object[] objArr = objArr;
                if (objArr != null) {
                    for (Object put : objArr) {
                        jSONArray.put(put);
                    }
                }
                Packet packet = new Packet(2, jSONArray);
                if (ack != null) {
                    Socket.f59522b.fine(String.format("emitting packet with ack id %d", new Object[]{Integer.valueOf(Socket.this.f59525d)}));
                    Socket.this.f59529h.put(Integer.valueOf(Socket.this.f59525d), ack);
                    packet.f59554id = Socket.m42021g(Socket.this);
                }
                if (Socket.this.f59524c) {
                    Socket.this.m42004a(packet);
                } else {
                    Socket.this.f59532k.add(packet);
                }
            }
        });
        return this;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m42004a(Packet packet) {
        packet.nsp = this.f59526e;
        this.f59527f.mo175627a(packet);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m42012c() {
        f59522b.fine("transport is open - connecting");
        if (!"/".equals(this.f59526e)) {
            String str = this.f59528g;
            if (str == null || str.isEmpty()) {
                m42004a(new Packet(0));
                return;
            }
            Packet packet = new Packet(0);
            packet.query = this.f59528g;
            m42004a(packet);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m42005a(String str) {
        if (f59522b.isLoggable(Level.FINE)) {
            f59522b.fine(String.format("close (%s)", new Object[]{str}));
        }
        this.f59524c = false;
        this.f59523a = null;
        emit(EVENT_DISCONNECT, str);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m42009b(Packet<?> packet) {
        if (this.f59526e.equals(packet.nsp)) {
            switch (packet.type) {
                case 0:
                    m42014d();
                    return;
                case 1:
                    m42020f();
                    return;
                case 2:
                    m42013c((Packet<JSONArray>) packet);
                    return;
                case 3:
                    m42016d((Packet<JSONArray>) packet);
                    return;
                case 4:
                    emit("error", packet.data);
                    return;
                case 5:
                    m42013c((Packet<JSONArray>) packet);
                    return;
                case 6:
                    m42016d((Packet<JSONArray>) packet);
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: c */
    private void m42013c(Packet<JSONArray> packet) {
        ArrayList arrayList = new ArrayList(Arrays.asList(m42006a((JSONArray) packet.data)));
        if (f59522b.isLoggable(Level.FINE)) {
            f59522b.fine(String.format("emitting event %s", new Object[]{arrayList}));
        }
        if (packet.f59554id >= 0) {
            f59522b.fine("attaching ack callback to event");
            arrayList.add(m41998a(packet.f59554id));
        }
        if (!this.f59524c) {
            this.f59531j.add(arrayList);
        } else if (!arrayList.isEmpty()) {
            super.emit(arrayList.remove(0).toString(), arrayList.toArray());
        }
    }

    /* renamed from: a */
    private Ack m41998a(final int i) {
        final boolean[] zArr = {false};
        return new Ack() {
            public void call(final Object... objArr) {
                EventThread.exec(new Runnable() {
                    public void run() {
                        if (!zArr[0]) {
                            zArr[0] = true;
                            if (Socket.f59522b.isLoggable(Level.FINE)) {
                                Logger a = Socket.f59522b;
                                Object[] objArr = objArr;
                                if (objArr.length == 0) {
                                    objArr = null;
                                }
                                a.fine(String.format("sending ack %s", objArr));
                            }
                            JSONArray jSONArray = new JSONArray();
                            for (Object put : objArr) {
                                jSONArray.put(put);
                            }
                            Packet packet = new Packet(3, jSONArray);
                            packet.f59554id = i;
                            this.m42004a(packet);
                        }
                    }
                });
            }
        };
    }

    /* renamed from: d */
    private void m42016d(Packet<JSONArray> packet) {
        Ack remove = this.f59529h.remove(Integer.valueOf(packet.f59554id));
        if (remove != null) {
            if (f59522b.isLoggable(Level.FINE)) {
                f59522b.fine(String.format("calling ack %s with %s", new Object[]{Integer.valueOf(packet.f59554id), packet.data}));
            }
            remove.call(m42006a((JSONArray) packet.data));
        } else if (f59522b.isLoggable(Level.FINE)) {
            f59522b.fine(String.format("bad ack %s", new Object[]{Integer.valueOf(packet.f59554id)}));
        }
    }

    /* renamed from: d */
    private void m42014d() {
        this.f59524c = true;
        emit("connect", new Object[0]);
        m42018e();
    }

    /* renamed from: e */
    private void m42018e() {
        while (true) {
            List poll = this.f59531j.poll();
            if (poll == null) {
                break;
            }
            super.emit((String) poll.get(0), poll.toArray());
        }
        this.f59531j.clear();
        while (true) {
            Packet poll2 = this.f59532k.poll();
            if (poll2 != null) {
                m42004a(poll2);
            } else {
                this.f59532k.clear();
                return;
            }
        }
    }

    /* renamed from: f */
    private void m42020f() {
        if (f59522b.isLoggable(Level.FINE)) {
            f59522b.fine(String.format("server disconnect (%s)", new Object[]{this.f59526e}));
        }
        m42022g();
        m42005a("io server disconnect");
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m42022g() {
        Queue<C21252On.Handle> queue = this.f59530i;
        if (queue != null) {
            for (C21252On.Handle destroy : queue) {
                destroy.destroy();
            }
            this.f59530i = null;
        }
        this.f59527f.mo175626a(this);
    }

    public Socket close() {
        EventThread.exec(new Runnable() {
            public void run() {
                if (Socket.this.f59524c) {
                    if (Socket.f59522b.isLoggable(Level.FINE)) {
                        Socket.f59522b.fine(String.format("performing disconnect (%s)", new Object[]{Socket.this.f59526e}));
                    }
                    Socket.this.m42004a(new Packet(1));
                }
                Socket.this.m42022g();
                if (Socket.this.f59524c) {
                    Socket.this.m42005a("io client disconnect");
                }
            }
        });
        return this;
    }

    public Socket disconnect() {
        return close();
    }

    /* renamed from: io */
    public Manager mo175661io() {
        return this.f59527f;
    }

    public boolean connected() {
        return this.f59524c;
    }

    /* renamed from: id */
    public String mo175660id() {
        return this.f59523a;
    }

    /* renamed from: a */
    private static Object[] m42006a(JSONArray jSONArray) {
        Object obj;
        int length = jSONArray.length();
        Object[] objArr = new Object[length];
        for (int i = 0; i < length; i++) {
            Object obj2 = null;
            try {
                obj = jSONArray.get(i);
            } catch (JSONException e) {
                f59522b.log(Level.WARNING, "An error occured while retrieving data from JSONArray", e);
                obj = null;
            }
            if (!JSONObject.NULL.equals(obj)) {
                obj2 = obj;
            }
            objArr[i] = obj2;
        }
        return objArr;
    }
}
