package com.adyen.threeds2.internal;

import android.os.Handler;
import android.os.Looper;
import androidx.core.util.Consumer;
import atd.p009a.C0939c;
import atd.p010a0.C0956a;
import atd.p011b.C0959b;
import atd.p013c.C0962b;
import atd.p013c.C0963c;
import atd.p015d.C0976a;
import atd.p015d.C0979b;
import atd.p015d.C0980c;
import atd.p015d.C0982e;
import atd.p015d.C0988i;
import atd.p015d.C0989j;
import atd.p017e.C1014c;
import atd.p017e.C1015d;
import atd.p017e.C1016e;
import atd.p020f0.C1023a;
import atd.p046s0.C1172a;
import atd.p052y.C1224b;
import atd.p053z.C1226a;
import atd.p053z.C1227b;
import atd.p053z.C1228c;
import com.adyen.threeds2.CompletionEvent;
import com.adyen.threeds2.ProtocolErrorEvent;
import com.adyen.threeds2.RuntimeErrorEvent;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.adyen.threeds2.internal.f */
public final class C1399f implements C0939c<C0989j> {

    /* renamed from: i */
    private static C1399f f998i;

    /* renamed from: a */
    private C0959b f999a;

    /* renamed from: b */
    private AtomicInteger f1000b;

    /* renamed from: c */
    private Timer f1001c;

    /* renamed from: d */
    private C0988i f1002d;

    /* renamed from: e */
    private C0989j f1003e;

    /* renamed from: f */
    private C1394a f1004f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public C0979b f1005g;

    /* renamed from: h */
    private boolean f1006h;

    /* renamed from: com.adyen.threeds2.internal.f$a */
    class C1400a implements Consumer<C0988i> {

        /* renamed from: a */
        final /* synthetic */ C0982e f1007a;

        C1400a(C0982e eVar) {
            this.f1007a = eVar;
        }

        /* renamed from: a */
        public void accept(C0988i iVar) {
            C1399f.this.mo14858a((ProtocolErrorEvent) new C1228c(iVar.mo13667f(), new C1227b(iVar.mo13667f(), this.f1007a.mo13642g(), this.f1007a.mo13643h(), this.f1007a.mo13644i())));
        }
    }

    /* renamed from: com.adyen.threeds2.internal.f$b */
    static /* synthetic */ class C1401b {

        /* renamed from: a */
        static final /* synthetic */ int[] f1009a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                atd.e.d[] r0 = atd.p017e.C1015d.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f1009a = r0
                atd.e.d r1 = atd.p017e.C1015d.CHALLENGE_RESPONSE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f1009a     // Catch:{ NoSuchFieldError -> 0x001d }
                atd.e.d r1 = atd.p017e.C1015d.ERROR     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.adyen.threeds2.internal.C1399f.C1401b.<clinit>():void");
        }
    }

    /* renamed from: com.adyen.threeds2.internal.f$c */
    class C1402c implements Consumer<C0988i> {

        /* renamed from: a */
        final /* synthetic */ C1014c f1010a;

        /* renamed from: b */
        final /* synthetic */ String f1011b;

        C1402c(C1014c cVar, String str) {
            this.f1010a = cVar;
            this.f1011b = str;
        }

        /* renamed from: a */
        public void accept(C0988i iVar) {
            C1399f.this.mo14856a((C0988i) this.f1010a.mo13737a(iVar, this.f1011b));
        }
    }

    /* renamed from: com.adyen.threeds2.internal.f$d */
    class C1403d implements Consumer<C0988i> {

        /* renamed from: a */
        final /* synthetic */ C1014c f1013a;

        /* renamed from: b */
        final /* synthetic */ String f1014b;

        C1403d(C1014c cVar, String str) {
            this.f1013a = cVar;
            this.f1014b = str;
        }

        /* renamed from: a */
        public void accept(C0988i iVar) {
            C1399f.this.mo14858a(this.f1013a.mo13738a(iVar.mo13667f(), this.f1014b));
        }
    }

    /* renamed from: com.adyen.threeds2.internal.f$e */
    class C1404e implements Consumer<C0989j> {

        /* renamed from: a */
        final /* synthetic */ C0963c f1016a;

        /* renamed from: b */
        final /* synthetic */ String f1017b;

        C1404e(C0963c cVar, String str) {
            this.f1016a = cVar;
            this.f1017b = str;
        }

        /* renamed from: a */
        public void accept(C0989j jVar) {
            C1399f.this.mo14856a((C0988i) new C0979b(C1399f.this.f1005g.mo13665d(), C1399f.this.f1005g.mo13669h(), C1399f.this.f1005g.mo13663b(), C1399f.this.f1005g.mo13667f(), C1399f.this.f1005g.mo13668g(), this.f1016a, this.f1017b));
        }
    }

    /* renamed from: com.adyen.threeds2.internal.f$f */
    class C1405f implements Consumer<C0988i> {
        C1405f() {
        }

        /* renamed from: a */
        public void accept(C0988i iVar) {
            C1399f.this.mo14856a((C0988i) C1014c.TRANSACTION_TIMED_OUT.mo13737a(iVar, C1172a.m764a(-1319008291502L)));
        }
    }

    /* renamed from: com.adyen.threeds2.internal.f$g */
    class C1406g implements Consumer<AtomicInteger> {

        /* renamed from: a */
        final /* synthetic */ C0988i f1020a;

        C1406g(C1399f fVar, C0988i iVar) {
            this.f1020a = iVar;
        }

        /* renamed from: a */
        public void accept(AtomicInteger atomicInteger) {
            this.f1020a.mo13662a(atomicInteger.getAndIncrement());
        }
    }

    /* renamed from: com.adyen.threeds2.internal.f$h */
    class C1407h implements Consumer<C0959b> {

        /* renamed from: a */
        final /* synthetic */ C0988i f1021a;

        C1407h(C1399f fVar, C0988i iVar) {
            this.f1021a = iVar;
        }

        /* renamed from: a */
        public void accept(C0959b bVar) {
            bVar.mo13602a(this.f1021a);
        }
    }

    /* renamed from: com.adyen.threeds2.internal.f$i */
    class C1408i implements Consumer<C0988i> {
        C1408i() {
        }

        /* renamed from: a */
        public void accept(C0988i iVar) {
            C1399f.this.mo14858a(C1014c.MESSAGE_RECEIVED_INVALID.mo13738a(iVar.mo13667f(), C1172a.m764a(-1576706329262L)));
        }
    }

    /* renamed from: com.adyen.threeds2.internal.f$j */
    class C1409j implements Consumer<C0988i> {
        C1409j() {
        }

        /* renamed from: a */
        public void accept(C0988i iVar) {
            if (C1015d.ERROR.equals(iVar.mo13664c())) {
                C1399f.this.mo14857a((CompletionEvent) new C1226a(iVar.mo13667f(), C1016e.f272Y.mo13745a()));
            } else {
                C1399f.this.mo14858a(C1014c.MESSAGE_RECEIVED_INVALID.mo13738a(iVar.mo13667f(), C1172a.m764a(-1800044628654L)));
            }
        }
    }

    /* renamed from: com.adyen.threeds2.internal.f$k */
    class C1410k implements Consumer<C0988i> {

        /* renamed from: a */
        final /* synthetic */ C0980c f1024a;

        C1410k(C0980c cVar) {
            this.f1024a = cVar;
        }

        /* renamed from: a */
        public void accept(C0988i iVar) {
            if (!iVar.mo13665d().equals(this.f1024a.mo13672c())) {
                C1399f.this.mo14859a(C1224b.MESSAGE_VERSIONS_MISMATCH.mo13980a());
            } else if (iVar.mo13666e() != this.f1024a.mo13637g()) {
                C1399f.this.mo14859a(C1224b.MESSAGE_INDICES_MISMATCH.mo13980a());
            } else if (!this.f1024a.mo13641j()) {
                C1399f.this.mo14855a(this.f1024a.mo13639h());
            } else if (C1399f.this.mo14863g()) {
                C1399f.this.mo14853a();
            } else {
                C1399f.this.mo14857a((CompletionEvent) new C1226a(this.f1024a.mo13673d(), this.f1024a.mo13640i()));
            }
        }
    }

    /* renamed from: com.adyen.threeds2.internal.f$l */
    private static final class C1411l extends TimerTask {

        /* renamed from: com.adyen.threeds2.internal.f$l$a */
        class C1412a implements Runnable {
            C1412a(C1411l lVar) {
            }

            public void run() {
                C1399f.m1120d().mo14864h();
            }
        }

        C1411l() {
        }

        public void run() {
            new Handler(Looper.getMainLooper()).post(new C1412a(this));
        }
    }

    private C1399f() {
    }

    /* renamed from: c */
    private C1394a m1119c() {
        if (this.f1006h) {
            return this.f1004f;
        }
        return null;
    }

    /* renamed from: d */
    public static synchronized C1399f m1120d() {
        C1399f fVar;
        synchronized (C1399f.class) {
            if (f998i == null) {
                f998i = new C1399f();
            }
            fVar = f998i;
        }
        return fVar;
    }

    /* renamed from: e */
    private void m1121e() {
        C1394a c = m1119c();
        if (c != null) {
            c.mo14845a();
        }
    }

    /* renamed from: f */
    private void m1122f() {
        C1394a c = m1119c();
        if (c != null) {
            c.timedout();
        }
    }

    /* renamed from: i */
    private boolean m1123i() {
        if (this.f1006h) {
            return false;
        }
        C1172a.m764a(-2109282273966L);
        return true;
    }

    /* renamed from: b */
    public void mo13555a(C0989j jVar) {
        m1115a(jVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public boolean mo14863g() {
        C0988i iVar = this.f1002d;
        if (!(iVar instanceof C0979b)) {
            return false;
        }
        return ((C0979b) iVar).mo13635j() instanceof C0962b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public void mo14864h() {
        if (!m1123i()) {
            m1116a(this.f1002d, new C1405f());
            m1122f();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public synchronized void mo14861b() {
        if (!m1123i()) {
            this.f999a = null;
            this.f1000b = null;
            Timer timer = this.f1001c;
            if (timer != null) {
                timer.cancel();
                this.f1001c = null;
            }
            this.f1002d = null;
            this.f1003e = null;
            if (this.f1004f != null) {
                this.f1004f = null;
            }
            this.f1005g = null;
            this.f1006h = false;
        }
    }

    /* renamed from: a */
    public void mo13556a(Throwable th, String str) {
        if (th instanceof C0956a) {
            C0956a aVar = (C0956a) th;
            C1014c b = aVar.mo13598b();
            String a = aVar.mo13597a();
            if (!C1014c.SYSTEM_CONNECTION_FAILURE.equals(b) && !m1118a(aVar)) {
                m1116a(this.f1002d, new C1402c(b, a));
            }
            if (C1014c.TRANSACTION_TIMED_OUT.equals(b) || C1014c.SYSTEM_CONNECTION_FAILURE.equals(b)) {
                mo14859a(b.mo13739a(a));
            } else {
                m1116a(this.f1002d, new C1403d(b, a));
            }
        } else {
            mo14859a(C1224b.UNKNOWN.mo13981a(str + C1172a.m764a(-1980433255086L) + th.getLocalizedMessage()));
        }
    }

    /* renamed from: a */
    private boolean m1118a(C0956a aVar) {
        return aVar.mo13598b().equals(C1014c.DATA_ELEMENT_INVALID_FORMAT) && aVar.mo13597a().contains(C1172a.m764a(-1989023189678L));
    }

    /* renamed from: a */
    public void mo14854a(C0963c cVar, String str) {
        if (!m1123i()) {
            m1116a(this.f1003e, new C1404e(cVar, str));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo14860a(String str, C1023a aVar, C0979b bVar, int i, C1394a aVar2) {
        m1117a(str, aVar, i, aVar2);
        this.f1005g = bVar;
        mo14856a((C0988i) bVar);
    }

    /* renamed from: a */
    private <T> void m1116a(T t, Consumer<T> consumer) {
        if (t != null) {
            consumer.accept(t);
        }
    }

    /* renamed from: a */
    private synchronized void m1117a(String str, C1023a aVar, int i, C1394a aVar2) {
        this.f999a = new C0959b(str, aVar, this);
        this.f1004f = aVar2;
        this.f1000b = new AtomicInteger();
        Timer timer = new Timer();
        this.f1001c = timer;
        timer.schedule(new C1411l(), TimeUnit.MINUTES.toMillis((long) i));
        this.f1006h = true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo14853a() {
        C1394a c;
        if (!m1123i() && (c = m1119c()) != null) {
            c.cancelled();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo14856a(C0988i iVar) {
        if (!m1123i()) {
            if (iVar instanceof C0979b) {
                m1121e();
            }
            m1116a(this.f1000b, new C1406g(this, iVar));
            this.f1002d = iVar;
            m1116a(this.f999a, new C1407h(this, iVar));
        }
    }

    /* renamed from: a */
    private void m1115a(C0989j jVar) {
        if (!m1123i()) {
            if (jVar != null) {
                this.f1003e = jVar;
                int i = C1401b.f1009a[jVar.mo13671b().ordinal()];
                if (i == 1) {
                    m1113a((C0980c) jVar);
                } else if (i != 2) {
                    m1116a(this.f1002d, new C1408i());
                } else {
                    m1114a((C0982e) jVar);
                }
            } else {
                m1116a(this.f1002d, new C1409j());
            }
        }
    }

    /* renamed from: a */
    private void m1113a(C0980c cVar) {
        m1116a(this.f1002d, new C1410k(cVar));
    }

    /* renamed from: a */
    private void m1114a(C0982e eVar) {
        m1116a(this.f1002d, new C1400a(eVar));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo14855a(C0976a aVar) {
        C1394a c = m1119c();
        if (c != null) {
            c.mo14846a(aVar);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo14857a(CompletionEvent completionEvent) {
        C1394a c = m1119c();
        if (c != null) {
            c.completed(completionEvent);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo14858a(ProtocolErrorEvent protocolErrorEvent) {
        C1394a c = m1119c();
        if (c != null) {
            c.protocolError(protocolErrorEvent);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo14859a(RuntimeErrorEvent runtimeErrorEvent) {
        C1394a c = m1119c();
        if (c != null) {
            c.runtimeError(runtimeErrorEvent);
        }
    }
}
