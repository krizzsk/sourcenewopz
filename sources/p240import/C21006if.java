package p240import;

import android.content.Context;
import android.graphics.RectF;
import com.facebook.internal.NativeProtocol;
import com.iproov.sdk.IProov;
import com.iproov.sdk.bridge.OptionsBridge;
import com.iproov.sdk.cameray.C19768break;
import com.iproov.sdk.core.C19801case;
import com.iproov.sdk.core.C19887for;
import com.iproov.sdk.core.C19898import;
import com.iproov.sdk.core.C19903static;
import com.iproov.sdk.core.C19909while;
import com.iproov.sdk.core.exception.IProovException;
import com.iproov.sdk.core.exception.NetworkException;
import com.iproov.sdk.core.exception.ServerException;
import com.iproov.sdk.core.exception.UnexpectedErrorException;
import com.iproov.sdk.logging.IPLog;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import org.json.JSONException;
import org.json.JSONObject;
import p055case.C1272else;
import p089public.C3009for;
import p089public.C3011new;
import p093switch.C3108catch;
import p093switch.C3115do;
import p093switch.C3124new;
import p093switch.C3128try;
import p239if.C21001if;
import p240import.C21006if;
import p242io.socket.client.Ack;
import p242io.socket.client.C21231IO;
import p242io.socket.client.Socket;
import p242io.socket.emitter.Emitter;
import p242io.socket.engineio.client.transports.WebSocket;

/* renamed from: import.if */
/* compiled from: Streamer */
public class C21006if {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f57281a = ("🔌 " + C21006if.class.getSimpleName());
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final C21008if f57282b;

    /* renamed from: c */
    private final IProov.Options.Network f57283c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final Context f57284d;

    /* renamed from: e */
    private String f57285e;

    /* renamed from: f */
    private Socket f57286f;

    /* renamed from: g */
    private Timer f57287g;

    /* renamed from: h */
    private final Object f57288h = new Object();

    /* renamed from: i */
    private int f57289i = 0;

    /* renamed from: j */
    private int f57290j = 0;

    /* renamed from: k */
    private int f57291k = 0;

    /* renamed from: l */
    private double f57292l;

    /* renamed from: m */
    private C19768break f57293m;

    /* renamed from: n */
    private int f57294n = 0;

    /* renamed from: o */
    private long f57295o = 0;

    /* renamed from: p */
    private final Set<Ack> f57296p = new HashSet();

    /* renamed from: q */
    private final List<byte[]> f57297q = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: r */
    public final ExecutorService f57298r = C3108catch.m4015do("TimeoutProcessor", C3108catch.C3110for.MEDIUM, C3108catch.C3112new.RUN_TASK_ONLY_IF_IDLE);

    /* renamed from: import.if$do */
    /* compiled from: Streamer */
    class C21007do extends TimerTask {
        C21007do() {
        }

        /* access modifiers changed from: private */
        /* renamed from: do */
        public /* synthetic */ void m41108do() {
            C21006if.this.m47678for();
            IPLog.m39301e(C21006if.f57281a, "Socket.IO timeout");
            C21006if.this.f57282b.onError(new NetworkException(C21006if.this.f57284d, "Socket.IO timeout"));
        }

        public void run() {
            C21006if.this.f57298r.execute(new Runnable() {
                public final void run() {
                    C21006if.C21007do.this.m41108do();
                }
            });
        }
    }

    /* renamed from: import.if$if */
    /* compiled from: Streamer */
    public interface C21008if {
        /* renamed from: do */
        void mo162104do();

        /* renamed from: do */
        void mo162105do(double d);

        /* renamed from: do */
        void mo162106do(C19887for forR);

        /* renamed from: do */
        void mo162107do(C21001if ifVar);

        /* renamed from: if */
        void mo162108if();

        void onConnected();

        void onConnecting();

        void onError(IProovException iProovException);
    }

    public C21006if(Context context, String str, String str2, IProov.Options.Network network, C21008if ifVar) throws IProovException {
        this.f57284d = context;
        this.f57283c = network;
        this.f57285e = str2;
        this.f57282b = ifVar;
        C21231IO.Options options = new C21231IO.Options();
        options.query = "token=" + str2;
        if (!network.certificates.isEmpty()) {
            C21004a.m41072a(context, network, options);
        }
        String str3 = str.replace("https://", "").split("/")[0];
        options.path = network.path;
        options.timeout = (long) (network.timeoutSecs * 1000);
        options.forceNew = true;
        options.reconnection = false;
        options.transports = new String[]{WebSocket.NAME};
        try {
            Socket socket = C21231IO.socket("https://" + str3 + "/" + str2, options);
            this.f57286f = socket;
            socket.mo175675on("connect", m41082b()).mo175675on("error", m41085c()).mo175675on("connect_error", m41085c()).mo175675on("connect_timeout", m41085c()).mo175675on(Socket.EVENT_DISCONNECT, m41087d()).mo175675on("edge_status", m41089e()).mo175675on("edge_result_callback", m41091f()).mo175675on("edge_result_ack", m41093g()).mo175675on("edge_abort", m41095h());
        } catch (URISyntaxException e) {
            throw new NetworkException(context, (Exception) e);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m41079a(Object[] objArr) {
    }

    /* renamed from: b */
    private Emitter.Listener m41082b() {
        return new Emitter.Listener() {
            public final void call(Object[] objArr) {
                C21006if.this.m41100j(objArr);
            }
        };
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static /* synthetic */ void m41083b(Object[] objArr) {
    }

    /* renamed from: c */
    private Emitter.Listener m41085c() {
        return new Emitter.Listener() {
            public final void call(Object[] objArr) {
                C21006if.this.m41098i(objArr);
            }
        };
    }

    /* renamed from: e */
    private Emitter.Listener m41089e() {
        return new Emitter.Listener() {
            public final void call(Object[] objArr) {
                C21006if.this.m41094g(objArr);
            }
        };
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public /* synthetic */ void m41090e(Object[] objArr) {
        m47678for();
    }

    /* renamed from: f */
    private Emitter.Listener m41091f() {
        return new Emitter.Listener() {
            public final void call(Object[] objArr) {
                C21006if.this.m41092f(objArr);
            }
        };
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public /* synthetic */ void m41092f(Object[] objArr) {
        m41099j();
        JSONObject jSONObject = objArr[0];
        C19887for forR = new C19887for(jSONObject);
        JSONObject jSONObject2 = C3128try.m4079do(jSONObject);
        try {
            jSONObject2.put("received", Calendar.getInstance(TimeZone.getTimeZone("UTC")).getTimeInMillis());
        } catch (JSONException unused) {
        }
        objArr[objArr.length - 1].call(jSONObject2);
        this.f57282b.mo162106do(forR);
    }

    /* renamed from: g */
    private Emitter.Listener m41093g() {
        return new Emitter.Listener() {
            public final void call(Object[] objArr) {
                C21006if.this.m41090e(objArr);
            }
        };
    }

    /* renamed from: h */
    private Emitter.Listener m41095h() {
        return new Emitter.Listener() {
            public final void call(Object[] objArr) {
                C21006if.this.m41088d(objArr);
            }
        };
    }

    /* renamed from: i */
    private void m41097i() {
        synchronized (this.f57288h) {
            m41099j();
            Timer timer = new Timer();
            this.f57287g = timer;
            timer.schedule(new C21007do(), (long) (this.f57283c.timeoutSecs * 1000));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public /* synthetic */ void m41098i(Object[] objArr) {
        String str;
        m41099j();
        if (objArr[0] instanceof Exception) {
            str = objArr[0].getLocalizedMessage();
        } else {
            str = "" + objArr[0];
        }
        IPLog.m39301e(f57281a, "Error: " + str);
        this.f57282b.onError(new NetworkException(this.f57284d, str));
    }

    /* renamed from: j */
    private void m41099j() {
        synchronized (this.f57288h) {
            Timer timer = this.f57287g;
            if (timer != null) {
                timer.cancel();
                this.f57287g = null;
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void m41086c(Object[] objArr) {
        if (objArr.length <= 0 || !(objArr[0] instanceof JSONObject)) {
            this.f57282b.onError(new NetworkException(this.f57284d, "No data/ack received"));
            return;
        }
        JSONObject jSONObject = objArr[0];
        if (jSONObject.optString("error").isEmpty()) {
            try {
                C21001if ifVar = new C21001if(this.f57284d, jSONObject);
                this.f57285e = ifVar.m47666break();
                this.f57282b.mo162107do(ifVar);
            } catch (JSONException e) {
                this.f57282b.onError(new UnexpectedErrorException(this.f57284d, (Exception) e));
            }
        } else {
            this.f57282b.onError(IProovException.getExceptionForACode(this.f57284d, jSONObject.optString("error", "no error given"), jSONObject.optString(NativeProtocol.BRIDGE_ARG_ERROR_DESCRIPTION, "no description given")));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public /* synthetic */ void m41088d(Object[] objArr) {
        m41099j();
        this.f57282b.onError(new ServerException(this.f57284d, objArr[0].optString("reason")));
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public /* synthetic */ void m41094g(Object[] objArr) {
        m41097i();
        this.f57292l = objArr[0].optDouble("progress") / 100.0d;
        this.f57282b.mo162105do(m47679new());
    }

    /* renamed from: if */
    public synchronized void mo171530if() {
        this.f57286f.connect();
        this.f57282b.onConnecting();
    }

    /* renamed from: new  reason: not valid java name */
    public double m47679new() {
        double d = (((double) this.f57289i) / ((double) this.f57291k)) * 0.5d;
        return d + ((1.0d - d) * this.f57292l);
    }

    /* renamed from: a */
    private byte[] m41080a(byte[] bArr) throws C21005do {
        try {
            return C3124new.m4036do(bArr);
        } catch (Exception e) {
            throw new C21005do(e);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public /* synthetic */ void m41096h(Object[] objArr) {
        m41099j();
        this.f57282b.mo162104do();
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public /* synthetic */ void m41100j(Object[] objArr) {
        this.f57282b.onConnected();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:6|7|8|9|10|11|12) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0014 */
    /* renamed from: do */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void mo171527do(org.json.JSONObject r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.m47680try()     // Catch:{ all -> 0x0032 }
            if (r0 != 0) goto L_0x0009
            monitor-exit(r2)
            return
        L_0x0009:
            java.lang.String r0 = "id"
            io.socket.client.Socket r1 = r2.f57286f     // Catch:{ JSONException -> 0x0014 }
            java.lang.String r1 = r1.mo175660id()     // Catch:{ JSONException -> 0x0014 }
            r3.put(r0, r1)     // Catch:{ JSONException -> 0x0014 }
        L_0x0014:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0032 }
            r0.<init>()     // Catch:{ all -> 0x0032 }
            java.lang.String r1 = "Sending client_start: "
            r0.append(r1)     // Catch:{ all -> 0x0032 }
            r0.append(r3)     // Catch:{ all -> 0x0032 }
            com.iproov.sdk.core.import r0 = com.iproov.sdk.core.C19898import.AND7     // Catch:{ all -> 0x0032 }
            com.iproov.sdk.core.C19909while.m39264do(r0)     // Catch:{ all -> 0x0032 }
            import.-$$Lambda$if$rwrjT2hfnei2sNx4VNF_Wk0nQpg r0 = new import.-$$Lambda$if$rwrjT2hfnei2sNx4VNF_Wk0nQpg     // Catch:{ all -> 0x0032 }
            r0.<init>()     // Catch:{ all -> 0x0032 }
            java.lang.String r1 = "client_start"
            r2.m41077a(r1, r3, r0)     // Catch:{ all -> 0x0032 }
            monitor-exit(r2)
            return
        L_0x0032:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: p240import.C21006if.mo171527do(org.json.JSONObject):void");
    }

    /* renamed from: for  reason: not valid java name */
    public synchronized void m47678for() {
        m41099j();
        if (this.f57286f != null) {
            this.f57282b.mo162108if();
            this.f57286f.disconnect();
            this.f57286f = null;
        }
    }

    /* renamed from: if */
    public synchronized void mo171531if(JSONObject jSONObject) {
        if (m47680try()) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append("sendClientLuxData: ");
                sb.append(jSONObject.toString(2));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            m41077a("client_lux", jSONObject, $$Lambda$if$lvmRuMDl8OceQ0WhtLamni8mbWQ.INSTANCE);
        }
    }

    /* renamed from: d */
    private Emitter.Listener m41087d() {
        return new Emitter.Listener() {
            public final void call(Object[] objArr) {
                C21006if.this.m41096h(objArr);
            }
        };
    }

    /* renamed from: do */
    public synchronized void mo171528do(byte[] bArr, Long l, List<C3009for> list, RectF rectF, String str, C1272else elseR, C19801case caseR, boolean z) throws IProovException {
        byte[] bArr2 = bArr;
        Long l2 = l;
        String str2 = str;
        C19801case caseR2 = caseR;
        boolean z2 = z;
        synchronized (this) {
            try {
                this.f57297q.add(m41080a(bArr));
                byte[] bArr3 = z2 ? C19903static.m39260do(bArr2, m41080a(C3115do.m4024do(this.f57285e.getBytes(StandardCharsets.UTF_8), this.f57297q)), this.f57285e) : bArr2;
                if (m47680try()) {
                    JSONObject jSONObject = new JSONObject();
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("token", this.f57285e);
                    jSONObject2.put("version", 5);
                    jSONObject2.put("camera", this.f57293m.mo161895do());
                    jSONObject2.put(OptionsBridge.ORIENTATION_KEY, String.format("%03d", new Object[]{Integer.valueOf(this.f57294n)}));
                    jSONObject2.put("type", "video/" + elseR.f466do);
                    jSONObject2.put("dataURL", bArr3);
                    jSONObject2.put("part", this.f57290j + 1);
                    jSONObject2.put("final", z2);
                    jSONObject2.put("loco", C3011new.m3824do(list));
                    jSONObject2.put("frt", caseR2.f54099do);
                    if (rectF != null) {
                        jSONObject2.put("cr", C21004a.m41071a(rectF));
                    }
                    if (l2 != null) {
                        jSONObject2.put("timestamp", l2);
                    }
                    if (str2 != null) {
                        jSONObject2.put("vsg", str2);
                    }
                    jSONObject.put("video", jSONObject2);
                    StringBuilder sb = new StringBuilder();
                    sb.append("Sending part 📡 ");
                    sb.append(this.f57290j + 1);
                    sb.append("...");
                    sb.append(caseR2);
                    sb.append(" size=");
                    sb.append(bArr2.length);
                    this.f57295o += (long) bArr2.length;
                    if (z2) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Stream size ");
                        sb2.append(this.f57295o / 1024);
                        sb2.append(" kB");
                    }
                    C19909while.m39264do(C19898import.AND6);
                    m41077a("client_video", jSONObject, new Ack(z2) {
                        public final /* synthetic */ boolean f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void call(Object[] objArr) {
                            C21006if.this.m41078a(this.f$1, objArr);
                        }
                    });
                    this.f57290j++;
                } else {
                    throw new NetworkException(this.f57284d, "Cannot send video (socket not connected)");
                }
            } catch (C21005do e) {
                e.printStackTrace();
                throw new UnexpectedErrorException(this.f57284d, (Exception) e);
            } catch (JSONException e2) {
                throw new UnexpectedErrorException(this.f57284d, (Exception) e2);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: try  reason: not valid java name */
    public synchronized boolean m47680try() {
        Socket socket;
        socket = this.f57286f;
        return socket != null && socket.connected();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m41078a(boolean z, Object[] objArr) {
        if (objArr.length > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("Ack received: ");
            sb.append(objArr[0]);
        }
        this.f57289i++;
        this.f57282b.mo162105do(m47679new());
        if (z) {
            m41097i();
        }
    }

    /* renamed from: do */
    public synchronized void mo171526do(String str) {
        if (m47680try()) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("reason", str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            m41077a("client_abort", jSONObject, $$Lambda$if$FCWuLGmlLaYMsefRpB8UEkBji6E.INSTANCE);
        }
    }

    /* renamed from: do */
    public void mo171524do(int i) {
        this.f57291k = i + 1;
    }

    /* renamed from: do */
    public void mo171525do(C19768break breakR, int i) {
        this.f57293m = breakR;
        this.f57294n = i;
    }

    /* renamed from: a */
    private void m41077a(String str, JSONObject jSONObject, Ack ack) {
        if (ack != null) {
            this.f57296p.add(ack);
            m41097i();
        }
        C19909while.m39264do(C19898import.AND8);
        this.f57286f.emit(str, jSONObject, new Ack(ack) {
            public final /* synthetic */ Ack f$1;

            {
                this.f$1 = r2;
            }

            public final void call(Object[] objArr) {
                C21006if.this.m41076a(this.f$1, objArr);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m41076a(Ack ack, Object[] objArr) {
        this.f57296p.remove(ack);
        if (this.f57296p.isEmpty()) {
            m41099j();
        } else {
            m41097i();
        }
        if (ack != null) {
            ack.call(objArr);
        }
    }
}
