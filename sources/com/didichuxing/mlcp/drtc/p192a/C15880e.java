package com.didichuxing.mlcp.drtc.p192a;

import android.content.Context;
import android.os.AsyncTask;
import com.didi.entrega.customer.app.constant.Const;
import com.didichuxing.mlcp.drtc.consts.SDKConsts;
import com.didichuxing.mlcp.drtc.enums.DrtcMessageType;
import com.didichuxing.mlcp.drtc.enums.DrtcPluginRoleType;
import com.didichuxing.mlcp.drtc.enums.DrtcSupportedPlugins;
import com.didichuxing.mlcp.drtc.enums.DrtcTransactionType;
import com.didichuxing.mlcp.drtc.enums.MessengerType;
import com.didichuxing.mlcp.drtc.interfaces.C15887a;
import com.didichuxing.mlcp.drtc.interfaces.C15888b;
import com.didichuxing.mlcp.drtc.interfaces.p193f.C15892a;
import com.didichuxing.mlcp.drtc.interfaces.p193f.C15894c;
import com.didichuxing.mlcp.drtc.interfaces.p193f.C15895d;
import com.didichuxing.mlcp.drtc.interfaces.p193f.C15896e;
import com.didichuxing.mlcp.drtc.interfaces.p193f.C15897f;
import com.didichuxing.mlcp.drtc.interfaces.p193f.C15898g;
import com.didichuxing.mlcp.drtc.interfaces.p193f.C15900i;
import com.didichuxing.mlcp.drtc.sdk.DrtcPluginHandle;
import com.didichuxing.mlcp.drtc.utils.C15918c;
import com.didichuxing.mlcp.drtc.utils.C15924f;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;
import org.webrtc.Loggable;
import org.webrtc.Logging;
import org.webrtc.PeerConnection;
import org.webrtc.PeerConnectionFactory;

/* renamed from: com.didichuxing.mlcp.drtc.a.e */
/* compiled from: DrtcSessionServer */
public class C15880e implements C15887a, C15892a, C15894c, C15896e, Runnable {

    /* renamed from: b */
    private static Boolean f48303b = false;

    /* renamed from: a */
    public final PeerConnection.IceTransportsType f48304a;

    /* renamed from: c */
    private final ConcurrentHashMap<BigInteger, DrtcPluginHandle> f48305c = new ConcurrentHashMap<>();

    /* renamed from: d */
    private final ConcurrentHashMap<String, C15900i> f48306d = new ConcurrentHashMap<>();

    /* renamed from: e */
    private final ConcurrentHashMap<BigInteger, C15895d> f48307e = new ConcurrentHashMap<>();

    /* renamed from: f */
    private final Object f48308f = new Object();

    /* renamed from: g */
    private final Object f48309g = new Object();

    /* renamed from: h */
    private final C15924f f48310h = new C15924f();
    /* access modifiers changed from: private */

    /* renamed from: i */
    public volatile C15888b f48311i;

    /* renamed from: j */
    private final C15897f f48312j;

    /* renamed from: k */
    private DrtcPluginHandle f48313k = null;

    /* renamed from: l */
    private Boolean f48314l;

    /* renamed from: m */
    private Context f48315m;

    /* renamed from: n */
    private volatile Thread f48316n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public BigInteger f48317o;

    /* renamed from: p */
    private final List<PeerConnection.IceServer> f48318p;

    /* renamed from: com.didichuxing.mlcp.drtc.a.e$a */
    /* compiled from: DrtcSessionServer */
    static /* synthetic */ class C15881a {

        /* renamed from: a */
        static final /* synthetic */ int[] f48319a;

        /* JADX WARNING: Can't wrap try/catch for region: R(20:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|(3:19|20|22)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(22:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|22) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.didichuxing.mlcp.drtc.enums.DrtcMessageType[] r0 = com.didichuxing.mlcp.drtc.enums.DrtcMessageType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f48319a = r0
                com.didichuxing.mlcp.drtc.enums.DrtcMessageType r1 = com.didichuxing.mlcp.drtc.enums.DrtcMessageType.ack     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f48319a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didichuxing.mlcp.drtc.enums.DrtcMessageType r1 = com.didichuxing.mlcp.drtc.enums.DrtcMessageType.success     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f48319a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didichuxing.mlcp.drtc.enums.DrtcMessageType r1 = com.didichuxing.mlcp.drtc.enums.DrtcMessageType.error     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f48319a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.didichuxing.mlcp.drtc.enums.DrtcMessageType r1 = com.didichuxing.mlcp.drtc.enums.DrtcMessageType.event     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f48319a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.didichuxing.mlcp.drtc.enums.DrtcMessageType r1 = com.didichuxing.mlcp.drtc.enums.DrtcMessageType.hangup     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f48319a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.didichuxing.mlcp.drtc.enums.DrtcMessageType r1 = com.didichuxing.mlcp.drtc.enums.DrtcMessageType.detached     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f48319a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.didichuxing.mlcp.drtc.enums.DrtcMessageType r1 = com.didichuxing.mlcp.drtc.enums.DrtcMessageType.slowlink     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f48319a     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.didichuxing.mlcp.drtc.enums.DrtcMessageType r1 = com.didichuxing.mlcp.drtc.enums.DrtcMessageType.webrtcup     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f48319a     // Catch:{ NoSuchFieldError -> 0x006c }
                com.didichuxing.mlcp.drtc.enums.DrtcMessageType r1 = com.didichuxing.mlcp.drtc.enums.DrtcMessageType.media     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = f48319a     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.didichuxing.mlcp.drtc.enums.DrtcMessageType r1 = com.didichuxing.mlcp.drtc.enums.DrtcMessageType.keepalive     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.mlcp.drtc.p192a.C15880e.C15881a.<clinit>():void");
        }
    }

    /* renamed from: com.didichuxing.mlcp.drtc.a.e$b */
    /* compiled from: DrtcSessionServer */
    private class C15882b extends AsyncTask<C15895d, Void, Void> {
        private C15882b() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Void doInBackground(C15895d... dVarArr) {
            C15895d dVar = dVarArr[0];
            try {
                C15900i a = C15883f.m34468a(C15880e.this, DrtcTransactionType.attach, dVar.mo118958g(), dVar);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(SDKConsts.getSysConfig().f48336c, DrtcMessageType.attach);
                jSONObject.put(SDKConsts.MSG_TAG_PLUGIN, dVar.mo118958g());
                jSONObject.put(SDKConsts.MSG_TAG_TRAN, C15880e.this.m34438a(a));
                jSONObject.put(SDKConsts.MSG_TAG_OPAQUE, dVar.mo118960p());
                if (C15880e.this.f48311i.mo118935a() == MessengerType.websocket) {
                    jSONObject.put("session_id", C15880e.this.f48317o);
                }
                C15880e.this.f48311i.mo118937a(jSONObject.toString(), C15880e.this.f48317o);
                return null;
            } catch (JSONException e) {
                C15880e.this.mo118890c(e.getMessage());
                return null;
            }
        }

        /* synthetic */ C15882b(C15880e eVar, C15881a aVar) {
            this();
        }
    }

    public C15880e(C15897f fVar) {
        System.setProperty("java.net.preferIPv6Addresses", SDKConsts.BOOLEAN_FALSE);
        System.setProperty("java.net.preferIPv4Stack", "true");
        this.f48314l = false;
        this.f48312j = fVar;
        this.f48318p = fVar.mo118968q();
        this.f48304a = this.f48312j.mo118966i();
        this.f48317o = new BigInteger("-1");
        this.f48311i = C15918c.m34721a(this.f48312j.mo118967n(), this);
    }

    /* renamed from: a */
    private void m34439a() {
        try {
            C15900i a = C15883f.m34468a(this, DrtcTransactionType.create, (DrtcSupportedPlugins) null, (C15895d) null);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(SDKConsts.getSysConfig().f48336c, DrtcMessageType.create);
            jSONObject.put(SDKConsts.MSG_TAG_TRAN, m34438a(a));
            this.f48311i.mo118936a(jSONObject.toString());
        } catch (JSONException e) {
            mo118890c(e.getMessage());
        }
    }

    /* renamed from: b */
    private void m34442b() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(SDKConsts.getSysConfig().f48336c, DrtcMessageType.destroy);
            jSONObject.put(SDKConsts.MSG_TAG_TRAN, this.f48310h.mo119065a(12));
            this.f48311i.mo118936a(jSONObject.toString());
        } catch (JSONException e) {
            mo118890c(e.getMessage());
        }
    }

    /* renamed from: a */
    public void mo118884a(JSONObject jSONObject, DrtcSupportedPlugins drtcSupportedPlugins, C15895d dVar) {
    }

    /* renamed from: b */
    public void mo118889b(JSONObject jSONObject, DrtcSupportedPlugins drtcSupportedPlugins, C15895d dVar) {
    }

    /* renamed from: c */
    public void mo118891c(JSONObject jSONObject) {
        if (jSONObject.has("reason")) {
            try {
                this.f48312j.mo118964f(jSONObject.getString("reason"));
            } catch (JSONException unused) {
                this.f48312j.mo118964f("Json parse exception");
            }
        } else {
            this.f48312j.mo118964f("unknown");
        }
    }

    /* renamed from: d */
    public void mo118893d(JSONObject jSONObject, DrtcSupportedPlugins drtcSupportedPlugins, C15895d dVar) {
        try {
            BigInteger bigInteger = new BigInteger(jSONObject.getJSONObject("data").getString("id"));
            DrtcPluginHandle drtcPluginHandle = new DrtcPluginHandle(this, this.f48315m, drtcSupportedPlugins, bigInteger, dVar, dVar.mo118955c(), dVar.mo118954a());
            if (dVar.mo118955c() == DrtcPluginRoleType.PublisherRole) {
                this.f48313k = drtcPluginHandle;
            }
            synchronized (this.f48308f) {
                this.f48305c.put(bigInteger, drtcPluginHandle);
            }
            dVar.mo118949a(drtcPluginHandle);
        } catch (JSONException e) {
            mo118890c("[E] Janus handler create failed:" + e.getMessage());
        }
    }

    /* renamed from: e */
    public void mo118895e(JSONObject jSONObject) {
        DrtcPluginHandle drtcPluginHandle;
        JSONObject jSONObject2;
        try {
            DrtcMessageType fromString = DrtcMessageType.fromString(jSONObject.getString(SDKConsts.getSysConfig().f48336c));
            JSONObject jSONObject3 = null;
            String string = jSONObject.has(SDKConsts.MSG_TAG_TRAN) ? jSONObject.getString(SDKConsts.MSG_TAG_TRAN) : null;
            BigInteger bigInteger = jSONObject.has(Const.BillClickType.SENDER) ? new BigInteger(jSONObject.getString(Const.BillClickType.SENDER)) : null;
            if (bigInteger != null) {
                synchronized (this.f48308f) {
                    drtcPluginHandle = this.f48305c.get(bigInteger);
                }
            } else {
                drtcPluginHandle = null;
            }
            switch (C15881a.f48319a[fromString.ordinal()]) {
                case 1:
                case 2:
                case 3:
                    if (string != null) {
                        synchronized (this.f48309g) {
                            C15900i iVar = this.f48306d.get(string);
                            if (iVar != null) {
                                iVar.mo118877a(jSONObject);
                            }
                            this.f48306d.remove(string);
                        }
                        return;
                    }
                    return;
                case 4:
                    if (drtcPluginHandle != null && jSONObject.has(SDKConsts.MSG_TAG_PLUGIND) && (jSONObject2 = jSONObject.getJSONObject(SDKConsts.MSG_TAG_PLUGIND)) != null) {
                        JSONObject jSONObject4 = jSONObject2.has("data") ? jSONObject2.getJSONObject("data") : null;
                        if (jSONObject.has("jsep")) {
                            jSONObject3 = jSONObject.getJSONObject("jsep");
                        }
                        drtcPluginHandle.onMessage(jSONObject4, jSONObject3);
                        return;
                    }
                    return;
                case 5:
                    if (jSONObject.has("reason")) {
                        mo118890c("[W] Peer connection has been shutdown by janus-core,since:" + jSONObject.getString("reason"));
                    }
                    if (drtcPluginHandle != null) {
                        drtcPluginHandle.onDetached();
                        m34440a(bigInteger);
                        return;
                    }
                    return;
                case 6:
                    if (drtcPluginHandle != null) {
                        drtcPluginHandle.onDetached();
                        m34440a(bigInteger);
                        return;
                    }
                    return;
                case 7:
                    String string2 = jSONObject.getString("media");
                    boolean z = jSONObject.getBoolean("uplink");
                    int i = jSONObject.getInt("lost");
                    if (z) {
                        if (i > 30) {
                            this.f48313k.updateNtQua(1);
                        } else {
                            this.f48313k.updateNtQua(2);
                        }
                    }
                    mo118890c("[W] Slow link : type[" + string2 + "],lost[" + i + com.didichuxing.bigdata.p173dp.locsdk.Const.jaRight);
                    return;
                case 8:
                    mo118890c(String.format("[I] Webrtc is up, sender id : %s", new Object[]{bigInteger.toString()}));
                    return;
                case 9:
                    if (jSONObject.has("type") && jSONObject.has("receiving")) {
                        drtcPluginHandle.onMediaStreamArrived(jSONObject.getString("type"), jSONObject.getString("receiving"));
                        return;
                    }
                    return;
                default:
                    return;
            }
        } catch (JSONException e) {
            mo118890c(e.getMessage());
        }
        mo118890c(e.getMessage());
    }

    /* renamed from: f */
    public void mo118896f() {
        this.f48314l = false;
        mo118890c("[I] " + this.f48311i.mo118935a().toString() + " Connect to core server is closed");
    }

    public void run() {
        Thread currentThread = Thread.currentThread();
        while (this.f48316n == currentThread) {
            try {
                Thread.sleep(15000);
                if (this.f48314l.booleanValue() && this.f48311i.mo118935a() == MessengerType.websocket) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put(SDKConsts.getSysConfig().f48336c, DrtcMessageType.keepalive.toString());
                        jSONObject.put(SDKConsts.MSG_TAG_TRAN, this.f48310h.mo119065a(12));
                        if (this.f48311i.mo118935a() == MessengerType.websocket) {
                            jSONObject.put("session_id", this.f48317o);
                        }
                        this.f48311i.mo118937a(jSONObject.toString(), this.f48317o);
                    } catch (JSONException e) {
                        C15897f fVar = this.f48312j;
                        fVar.mo118890c("Keep alive failed is sdk online?" + e.getMessage());
                        this.f48314l = false;
                        return;
                    }
                } else {
                    return;
                }
            } catch (InterruptedException unused) {
                return;
            }
        }
    }

    /* renamed from: t */
    public BigInteger mo118898t() {
        return this.f48317o;
    }

    /* renamed from: u */
    public List<PeerConnection.IceServer> mo118899u() {
        return this.f48318p;
    }

    /* renamed from: v */
    public void mo118900v() {
        f48303b = false;
        for (Map.Entry<BigInteger, C15895d> key : this.f48307e.entrySet()) {
            mo118886b((BigInteger) key.getKey());
        }
        DrtcPluginHandle drtcPluginHandle = this.f48313k;
        if (drtcPluginHandle != null) {
            drtcPluginHandle.hangUp();
        }
    }

    /* renamed from: w */
    public boolean mo118901w() {
        if (this.f48311i != null) {
            mo118890c("[I] Session server initializing...");
            this.f48311i.mo118940c();
            return true;
        }
        mo118890c("[E] Messenger is null,server initialization failed");
        return false;
    }

    /* renamed from: x */
    public void mo118902x() {
        f48303b = false;
        m34442b();
        synchronized (this.f48309g) {
            this.f48306d.clear();
        }
        if (this.f48311i != null) {
            this.f48311i.mo118939b();
        }
        this.f48316n = null;
        this.f48314l = false;
        this.f48312j.mo118965h();
    }

    /* renamed from: b */
    public void mo118885b(Exception exc) {
        mo118890c("[Ex]" + this.f48311i.mo118935a().toString() + " Connect to core server failed. Exception: " + exc.getMessage());
    }

    /* renamed from: a */
    public C15880e mo118878a(Context context, boolean z) {
        if (!f48303b.booleanValue()) {
            mo118890c("[I] Session server initializing peer connection factory");
            this.f48315m = context;
            PeerConnectionFactory.initialize(PeerConnectionFactory.InitializationOptions.builder(context).setInjectableLogger((Loggable) null, (Logging.Severity) null).setEnableInternalTracer(false).createInitializationOptions());
            Logging.enableLogToDebugOutput(Logging.Severity.LS_NONE);
            f48303b = true;
        } else {
            mo118890c("[W] Session server peer connection factory init twice");
        }
        return this;
    }

    /* renamed from: b */
    public void mo118888b(JSONObject jSONObject) {
        this.f48314l = true;
        try {
            this.f48317o = new BigInteger(jSONObject.getJSONObject("data").getString("id"));
            this.f48316n = new Thread(this, "KeepAliveThread");
            this.f48316n.start();
            this.f48312j.mo118961a(this.f48317o);
        } catch (JSONException e) {
            mo118890c("[E] Core session create failed:" + e.getMessage());
        }
    }

    /* renamed from: c */
    public void mo118892c(JSONObject jSONObject, DrtcSupportedPlugins drtcSupportedPlugins, C15895d dVar) {
        try {
            dVar.mo118950a(jSONObject.getJSONObject("error").getString("reason"));
        } catch (JSONException unused) {
            dVar.mo118950a("unknown");
        }
    }

    /* renamed from: c */
    public void mo118890c(String str) {
        C15897f fVar = this.f48312j;
        if (fVar != null) {
            fVar.mo118890c(str);
        }
    }

    /* renamed from: a */
    private void m34440a(BigInteger bigInteger) {
        synchronized (this.f48308f) {
            this.f48305c.remove(bigInteger);
        }
    }

    /* renamed from: b */
    public void mo118886b(BigInteger bigInteger) {
        C15895d dVar = this.f48307e.get(bigInteger);
        if (dVar != null) {
            dVar.mo118959o();
        }
    }

    /* renamed from: b */
    public void mo118887b(BigInteger bigInteger, C15895d dVar) {
        this.f48307e.remove(bigInteger, dVar);
    }

    /* renamed from: a */
    public void mo118880a(C15895d dVar) {
        if (!f48303b.booleanValue()) {
            dVar.mo118890c("[E] Peer connection factory hasn't been initialized, please initialize via initializeMediaContext");
            return;
        }
        new C15882b(this, (C15881a) null).execute(new C15895d[]{dVar});
    }

    /* renamed from: a */
    public void mo118883a(JSONObject jSONObject, DrtcMessageType drtcMessageType, BigInteger bigInteger) {
        try {
            jSONObject.put(SDKConsts.getSysConfig().f48336c, drtcMessageType.toString());
            jSONObject.put(SDKConsts.MSG_TAG_TRAN, this.f48310h.mo119065a(12));
            if (this.f48311i.mo118935a() == MessengerType.websocket) {
                jSONObject.put("session_id", this.f48317o);
                jSONObject.put(SDKConsts.MSG_TAG_HANDLE_ID, bigInteger);
            }
            if (this.f48314l.booleanValue()) {
                this.f48311i.mo118938a(jSONObject.toString(), this.f48317o, bigInteger);
            }
        } catch (JSONException e) {
            mo118890c(e.getMessage());
        }
    }

    /* renamed from: a */
    public void mo118879a(DrtcTransactionType drtcTransactionType, BigInteger bigInteger, C15898g gVar, DrtcSupportedPlugins drtcSupportedPlugins) {
        JSONObject k = gVar.mo118906k();
        if (k != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(SDKConsts.getSysConfig().f48336c, DrtcMessageType.message.toString());
                if (this.f48311i.mo118935a() == MessengerType.websocket) {
                    jSONObject.put("session_id", this.f48317o);
                    jSONObject.put(SDKConsts.MSG_TAG_HANDLE_ID, bigInteger);
                }
                jSONObject.put(SDKConsts.MSG_TAG_TRAN, m34438a(C15883f.m34469a(gVar)));
                if (k.has("message")) {
                    jSONObject.put("body", k.getJSONObject("message"));
                }
                if (k.has("jsep")) {
                    jSONObject.put("jsep", k.getJSONObject("jsep"));
                }
                this.f48311i.mo118938a(jSONObject.toString(), this.f48317o, bigInteger);
                gVar.mo118905d((JSONObject) null);
            } catch (JSONException e) {
                gVar.mo118890c(e.getMessage());
            }
        }
    }

    /* renamed from: a */
    public void mo118881a(Exception exc) {
        this.f48312j.mo118962b(exc.getMessage());
    }

    /* renamed from: a */
    public void mo118882a(BigInteger bigInteger, C15895d dVar) {
        this.f48307e.put(bigInteger, dVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public String m34438a(C15900i iVar) {
        String a = this.f48310h.mo119065a(12);
        synchronized (this.f48309g) {
            while (this.f48306d.containsKey(a)) {
                a = this.f48310h.mo119065a(12);
            }
            this.f48306d.put(a, iVar);
        }
        return a;
    }

    /* renamed from: e */
    public void mo118894e() {
        m34439a();
        C15897f fVar = this.f48312j;
        fVar.mo118963e("[I] " + this.f48311i.mo118935a().toString() + " Connection is already");
    }
}
