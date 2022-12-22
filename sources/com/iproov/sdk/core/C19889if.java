package com.iproov.sdk.core;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.DisplayMetrics;
import androidx.core.content.ContextCompat;
import com.iproov.sdk.C19916do;
import com.iproov.sdk.IProov;
import com.iproov.sdk.bridge.OptionsBridge;
import com.iproov.sdk.cameray.C19768break;
import com.iproov.sdk.cameray.C19774class;
import com.iproov.sdk.cameray.C19792try;
import com.iproov.sdk.cameray.Orientation;
import com.iproov.sdk.core.C19880const;
import com.iproov.sdk.core.C19889if;
import com.iproov.sdk.core.exception.CameraException;
import com.iproov.sdk.core.exception.CameraPermissionException;
import com.iproov.sdk.core.exception.FaceDetectorException;
import com.iproov.sdk.core.exception.IProovException;
import com.iproov.sdk.core.exception.InvalidOptionsException;
import com.iproov.sdk.core.exception.NetworkException;
import com.iproov.sdk.core.exception.UnexpectedErrorException;
import com.iproov.sdk.crypto.C19913do;
import com.iproov.sdk.crypto.C19914for;
import com.iproov.sdk.crypto.C19915if;
import com.iproov.sdk.face.C19917do;
import com.iproov.sdk.face.FaceDetector;
import com.iproov.sdk.face.model.FaceFeature;
import com.iproov.sdk.graphics.iproov.OpenGLRenderer;
import com.iproov.sdk.logging.IPLog;
import com.iproov.sdk.p223ui.activity.C19923do;
import com.iproov.sdk.p223ui.activity.IProovLandscapeActivity;
import com.iproov.sdk.p223ui.activity.IProovPortraitActivity;
import com.iproov.sdk.p223ui.activity.IProovReverseLandscapeActivity;
import com.iproov.sdk.p223ui.activity.IProovReversePortraitActivity;
import com.iproov.sdk.p223ui.views.LivenessDebugOverlay;
import com.yanzhenjie.permission.runtime.Permission;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p055case.C1269do;
import p055case.C1273goto;
import p055case.C1274if;
import p055case.C1275new;
import p055case.C1277try;
import p066native.C2381if;
import p089public.C3010if;
import p089public.C3011new;
import p090return.C3014do;
import p092super.C3098for;
import p092super.C3102new;
import p092super.C3103this;
import p093switch.C3108catch;
import p093switch.C3116else;
import p093switch.C3121for;
import p093switch.C3127throw;
import p093switch.C3128try;
import p095throw.C3134do;
import p095throw.C3135if;
import p096try.C3137for;
import p096try.C3138if;
import p227const.C20726if;
import p232do.C20817break;
import p232do.C20821for;
import p232do.C20824new;
import p232do.C20825this;
import p233else.C20828for;
import p234final.C20830do;
import p234final.C20833if;
import p235for.C20836do;
import p235for.C20837for;
import p239if.C20994do;
import p239if.C21001if;
import p239if.C21002new;
import p240import.C21006if;

/* renamed from: com.iproov.sdk.core.if */
/* compiled from: CaptureManager */
public final class C19889if {

    /* renamed from: a */
    private static final C19768break[] f54261a = {C19768break.f54005do};

    /* renamed from: b */
    private static final C19768break[] f54262b = {C19768break.EXTERNAL, C19768break.f54006if};
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static final String f54263c = C19889if.class.getSimpleName();
    /* access modifiers changed from: private */

    /* renamed from: A */
    public C1269do f54264A;
    /* access modifiers changed from: private */

    /* renamed from: B */
    public C3098for f54265B;
    /* access modifiers changed from: private */

    /* renamed from: C */
    public C3014do f54266C;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public C20837for f54267D;
    /* access modifiers changed from: private */

    /* renamed from: E */
    public FaceFeature f54268E;
    /* access modifiers changed from: private */

    /* renamed from: F */
    public C19880const f54269F;
    /* access modifiers changed from: private */

    /* renamed from: G */
    public C19908try f54270G;

    /* renamed from: H */
    private Bitmap f54271H;
    /* access modifiers changed from: private */

    /* renamed from: I */
    public C3011new f54272I;
    /* access modifiers changed from: private */

    /* renamed from: J */
    public RectF f54273J;
    /* access modifiers changed from: private */

    /* renamed from: K */
    public C1275new f54274K;
    /* access modifiers changed from: private */

    /* renamed from: L */
    public C19915if f54275L;
    /* access modifiers changed from: private */

    /* renamed from: M */
    public OpenGLRenderer f54276M;

    /* renamed from: N */
    private Activity f54277N;
    /* access modifiers changed from: private */

    /* renamed from: O */
    public C20824new f54278O;
    /* access modifiers changed from: private */

    /* renamed from: P */
    public C21001if f54279P;
    /* access modifiers changed from: private */

    /* renamed from: Q */
    public Orientation f54280Q;

    /* renamed from: R */
    private int f54281R;

    /* renamed from: S */
    private long f54282S;
    /* access modifiers changed from: private */

    /* renamed from: T */
    public long f54283T;
    /* access modifiers changed from: private */

    /* renamed from: U */
    public boolean f54284U;

    /* renamed from: V */
    private final C3138if.C3147this f54285V;

    /* renamed from: W */
    private final C19894goto f54286W;

    /* renamed from: X */
    private final C21006if.C21008if f54287X;

    /* renamed from: Y */
    private final C19792try.C19793do f54288Y;
    /* access modifiers changed from: private */

    /* renamed from: Z */
    public final C20837for.C20838do f54289Z;
    /* access modifiers changed from: private */

    /* renamed from: aa */
    public final C3098for.C3099do f54290aa;

    /* renamed from: ab */
    private final C19880const.C19881do f54291ab;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final Context f54292d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final String f54293e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final C19902return f54294f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final IProov.Listener f54295g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final C3137for f54296h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final C20828for f54297i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public final C21006if f54298j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public final C19792try f54299k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public final C2381if f54300l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public final C20833if f54301m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public final ExecutorService f54302n = C3108catch.m4015do("FrameProcessor", C3108catch.C3110for.MEDIUM, C3108catch.C3112new.RUN_TASK_ONLY_IF_IDLE);

    /* renamed from: o */
    private final ExecutorService f54303o = C3108catch.m4015do("FrameEncoder", C3108catch.C3110for.LOW, C3108catch.C3112new.QUEUE_TASKS_FIFO);
    /* access modifiers changed from: private */

    /* renamed from: p */
    public final C20726if f54304p = new C20726if();
    /* access modifiers changed from: private */

    /* renamed from: q */
    public final C20726if f54305q = new C20726if();
    /* access modifiers changed from: private */

    /* renamed from: r */
    public final C19888goto f54306r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public final Object f54307s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public final C19913do f54308t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public final C19800c f54309u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public final Queue<C1277try> f54310v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public final Queue<Long> f54311w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public final AtomicInteger f54312x;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public FaceDetector f54313y;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public C3134do f54314z;

    /* renamed from: com.iproov.sdk.core.if$else */
    /* compiled from: CaptureManager */
    static /* synthetic */ class C19892else {

        /* renamed from: do */
        static final /* synthetic */ int[] f54317do;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.iproov.sdk.cameray.Orientation[] r0 = com.iproov.sdk.cameray.Orientation.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f54317do = r0
                com.iproov.sdk.cameray.Orientation r1 = com.iproov.sdk.cameray.Orientation.PORTRAIT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f54317do     // Catch:{ NoSuchFieldError -> 0x001d }
                com.iproov.sdk.cameray.Orientation r1 = com.iproov.sdk.cameray.Orientation.LANDSCAPE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f54317do     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.iproov.sdk.cameray.Orientation r1 = com.iproov.sdk.cameray.Orientation.REVERSE_PORTRAIT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f54317do     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.iproov.sdk.cameray.Orientation r1 = com.iproov.sdk.cameray.Orientation.REVERSE_LANDSCAPE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iproov.sdk.core.C19889if.C19892else.<clinit>():void");
        }
    }

    /* renamed from: com.iproov.sdk.core.if$if */
    /* compiled from: CaptureManager */
    class C19895if implements C21006if.C21008if {
        C19895if() {
        }

        /* renamed from: do */
        private int m39219do(int i) {
            return C19889if.this.f54272I.mo38425do().get(Integer.valueOf(i)) == Boolean.TRUE ? 1 : 0;
        }

        /* access modifiers changed from: private */
        /* renamed from: for  reason: not valid java name */
        public /* synthetic */ void m47535for() {
            C19889if.this.m47524import();
        }

        /* renamed from: do */
        public void mo162104do() {
        }

        /* renamed from: if */
        public void mo162108if() {
        }

        public void onConnected() {
            JSONObject jSONObject = new JSONObject(C21002new.m41070do(C19889if.this.f54292d, C19889if.this.f54293e, C19889if.this.f54294f.f54334if));
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(C20994do.GENUINE_PRESENCE_ASSURANCE);
            C19889if.this.f54272I.m46180for();
            if (C19889if.this.f54272I.mo38428if()) {
                jSONArray.put(C20994do.LIVENESS);
            } else {
                IPLog.m39305w(C19889if.f54263c, "Liveness not available in supported_assurance_types due to sensors lacking");
            }
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put(m39219do(1));
            jSONArray2.put(m39219do(10));
            jSONArray2.put(m39219do(4));
            jSONArray2.put(m39219do(9));
            jSONArray2.put(m39219do(11));
            C3128try.m4080do(jSONObject, "avs", (Object) jSONArray2);
            C3128try.m4080do(jSONObject, "supported_assurance_types", (Object) jSONArray);
            C3128try.m4080do(jSONObject, "supported_codecs", (Object) C3128try.m4078do(C1273goto.m990do(C19889if.this.f54301m)));
            C3128try.m4080do(jSONObject, "dal", (Object) Integer.valueOf(C19889if.this.f54308t.f54352do));
            C3128try.m4080do(jSONObject, "opt", (Object) OptionsBridge.toJsonForAnalytics(C19889if.this.m47528try()));
            if (C19889if.this.f54308t != C19913do.UNSUPPORTED) {
                try {
                    String str = C3127throw.m4050do(C19889if.this.f54275L.m47538else().getDer());
                    String str2 = C3127throw.m4050do(C19889if.this.f54275L.mo162128do(C19889if.this.f54293e.getBytes()));
                    C3128try.m4080do(jSONObject, "pky", (Object) str);
                    C3128try.m4080do(jSONObject, "tsg", (Object) str2);
                } catch (C19914for e) {
                    e.printStackTrace();
                    String a = C19889if.f54263c;
                    IPLog.m39305w(a, "Failed to add device assurance info:" + e.getMessage());
                }
            }
            C19889if.this.f54298j.mo171527do(jSONObject);
        }

        public void onConnecting() {
            C19889if.this.f54296h.m46217new();
        }

        public void onError(IProovException iProovException) {
            C19889if.this.f54296h.mo38665do(iProovException);
        }

        /* renamed from: do */
        public void mo162107do(C21001if ifVar) {
            C21001if unused = C19889if.this.f54279P = ifVar;
            C19916do.m39280do(ifVar);
            C19889if.this.m39166j();
            C19889if.this.f54309u.mo161967a(ifVar.m47671final());
            if (ifVar.mo171518if() != null) {
                IPLog.m39305w("iProov", ifVar.mo171518if());
            }
            if (ifVar.mo171513do() == C20994do.GENUINE_PRESENCE_ASSURANCE) {
                C20837for unused2 = C19889if.this.f54267D = new C20837for(ifVar.m47674new(), ifVar.m47675try(), C19889if.this.f54289Z);
                C19889if ifVar2 = C19889if.this;
                C19908try unused3 = ifVar2.f54270G = ifVar2.f54267D;
                C19889if.this.f54298j.mo171524do(C19889if.this.f54270G.mo162065do());
                C19889if ifVar3 = C19889if.this;
                C3098for unused4 = ifVar3.f54265B = new C3102new(ifVar3.f54292d, C19889if.this.f54299k, ifVar.m47667case(), C19889if.this.f54290aa, C19889if.this.f54306r);
                if (C19889if.this.f54278O != null) {
                    String unused5 = C19889if.f54263c;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Focal Length (init2) = ");
                    sb.append(C19889if.this.f54278O.m47617for());
                    C19889if.this.f54265B.mo38586do(C19889if.this.f54278O.m47617for().floatValue());
                }
            }
            if (ifVar.m47673goto() != 0.0d) {
                C19889if.this.f54313y.setOmega(ifVar.m47673goto());
            }
            C19889if.this.f54314z.m46214for();
            if (C19889if.this.f54300l.m46156throw()) {
                C3127throw.m4051do(3000, (Runnable) new Runnable() {
                    public final void run() {
                        C19889if.C19895if.this.m47535for();
                    }
                });
            }
            if (ifVar.mo171513do() == C20994do.LIVENESS) {
                C19889if.this.m39164i();
            }
            C1275new unused6 = C19889if.this.f54274K = new C1275new(ifVar.m47672for());
            C19889if.this.m39168k();
            C19889if.this.f54296h.mo38663do((String) C3127throw.m4049do(C19889if.this.f54294f.f54333do.f53992ui.title, C21002new.m41069do(C19889if.this.f54292d, ifVar)));
        }

        /* renamed from: do */
        public void mo162105do(double d) {
            if (C19889if.this.f54296h.mo38668if() instanceof C3138if.C3139break) {
                C19889if.this.m39140a(d);
            }
        }

        /* renamed from: do */
        public void mo162106do(C19887for forR) {
            C19889if.this.f54296h.mo38661do(forR);
        }
    }

    /* renamed from: com.iproov.sdk.core.if$try */
    /* compiled from: CaptureManager */
    class C19897try implements C3098for.C3099do {
        C19897try() {
        }

        /* renamed from: do */
        public void mo38592do(boolean z) {
            C19889if.this.f54299k.mo161903do(z);
        }

        /* renamed from: do */
        public void mo38591do() {
            C19889if.this.f54299k.mo161898do();
        }
    }

    public C19889if(Context context, String str, String str2, C19902return returnR, IProov.Listener listener) throws IProovException {
        C20833if ifVar = C20830do.m41031do().mo170663if();
        this.f54301m = ifVar;
        this.f54306r = new C19888goto(ifVar);
        this.f54307s = new Object();
        this.f54310v = new LinkedBlockingQueue();
        this.f54311w = new ConcurrentLinkedQueue();
        this.f54312x = new AtomicInteger(0);
        this.f54280Q = Orientation.findByDegrees(270);
        this.f54281R = 0;
        this.f54282S = -1;
        C19891do doVar = new C19891do();
        this.f54285V = doVar;
        this.f54286W = new C19894goto();
        C19895if ifVar2 = new C19895if();
        this.f54287X = ifVar2;
        this.f54288Y = new C19893for();
        this.f54289Z = new C19896new();
        this.f54290aa = new C19897try();
        this.f54291ab = new C19890case();
        this.f54292d = context.getApplicationContext();
        C19915if ifVar3 = null;
        this.f54277N = context instanceof Activity ? (Activity) context : null;
        this.f54294f = returnR;
        this.f54295g = listener;
        this.f54293e = str2;
        this.f54296h = new C3137for(doVar);
        try {
            this.f54313y = C19917do.m39284do(context, returnR.f54333do.capture).getFaceDetector(context, returnR.f54333do.capture);
            new C19798break(context);
            new C19907throw(context);
            IProov.Options.Capture.GenuinePresenceAssurance genuinePresenceAssurance = returnR.f54333do.capture.genuinePresenceAssurance;
            this.f54297i = new C20828for(genuinePresenceAssurance.maxRoll, genuinePresenceAssurance.maxYaw, genuinePresenceAssurance.maxPitch);
            this.f54309u = new C19800c();
            this.f54298j = new C21006if(context, str, str2, returnR.f54333do.network, ifVar2);
            try {
                this.f54314z = new C3134do(context);
            } catch (C3135if unused) {
            }
            this.f54299k = new C19774class(this.f54301m, this.f54288Y, this.f54306r, returnR.f54333do.capture.camera == IProov.Camera.FRONT ? f54261a : f54262b).mo161897do(context);
            C2381if ifVar4 = new C2381if(context);
            this.f54300l = ifVar4;
            this.f54284U = ifVar4.m46148const();
            try {
                this.f54272I = new C3011new(context);
            } catch (C3010if unused2) {
                IPLog.m39305w(f54263c, "Sensor Manager unavailable");
            }
            try {
                C19915if ifVar5 = C19915if.m39274do(context);
                this.f54275L = ifVar5;
                ifVar3 = ifVar5;
            } catch (C19914for e) {
                e.printStackTrace();
                String str3 = f54263c;
                IPLog.m39305w(str3, "Key Store Manager unavailable: " + e.getLocalizedMessage());
                this.f54275L = null;
            } catch (Throwable th) {
                this.f54308t = C19915if.m39273do(this.f54275L);
                throw th;
            }
            this.f54308t = C19915if.m39273do(ifVar3);
        } catch (FaceDetectorException e2) {
            throw new FaceDetectorException(context, e2.getMessage());
        }
    }

    /* renamed from: catch  reason: not valid java name */
    public void m47522catch() {
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m39149b() {
        if (ContextCompat.checkSelfPermission(this.f54292d, Permission.CAMERA) == 0) {
            this.f54276M.mo162154do(this.f54299k, this.f54294f.f54333do.f53992ui, this.f54280Q);
            return;
        }
        C3014do doVar = this.f54266C;
        if (doVar != null) {
            doVar.mo38434do();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m39150b(C20821for forR, boolean z) {
        int i;
        byte[] bArr = forR.mo161941if(this.f54274K.f61670new);
        this.f54311w.add(Long.valueOf(forR.mo161938do()));
        try {
            if (this.f54264A.m46122new()) {
                this.f54264A.mo14140do(bArr);
                if (!z) {
                    this.f54281R++;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("💽 encodeFrame() sent encodedFramesCount=");
                sb.append(this.f54281R);
                sb.append(" ");
                sb.append(z ? C19801case.SUPPLEMENTARY : C19801case.AUTHENTICATION);
                if (this.f54279P.mo171513do() == C20994do.GENUINE_PRESENCE_ASSURANCE) {
                    i = 4;
                } else {
                    i = this.f54270G.mo162065do();
                }
                if (this.f54279P.m47669const() && this.f54281R == i) {
                    this.f54271H = forR.m47614for(1);
                }
            }
        } catch (C1274if e) {
            this.f54296h.mo38665do((IProovException) new UnexpectedErrorException(this.f54292d, (Exception) e));
        }
        if (this.f54281R == this.f54270G.mo162065do()) {
            this.f54264A.mo14139do();
            m39140a(this.f54298j.m47679new());
        }
    }

    /* renamed from: c */
    private void m39151c() {
        this.f54280Q = C3116else.m4026do(this.f54299k.m47474new().m47618new(), this.f54266C.m46183new());
        this.f54296h.mo38668if().m46219for(this.f54266C);
        this.f54277N = null;
        m39166j();
    }

    /* renamed from: d */
    private void m39153d() {
        C3134do doVar = this.f54314z;
        if (doVar != null) {
            doVar.mo38651do();
        }
        C3011new newR = this.f54272I;
        if (newR != null) {
            newR.m46179case();
        }
        OpenGLRenderer openGLRenderer = this.f54276M;
        if (openGLRenderer != null) {
            openGLRenderer.m47544catch();
        }
        synchronized (this.f54307s) {
            FaceDetector faceDetector = this.f54313y;
            if (faceDetector != null) {
                faceDetector.release();
                this.f54313y = null;
            }
        }
        this.f54277N = null;
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m39156e() {
        this.f54303o.execute(new Runnable() {
            public final void run() {
                C19889if.this.m39174n();
            }
        });
        this.f54298j.m47678for();
        C20837for forR = this.f54267D;
        if (forR != null) {
            forR.m47646for();
        }
        C19880const constR = this.f54269F;
        if (constR != null) {
            constR.mo162064c();
        }
        this.f54277N = null;
    }

    /* renamed from: f */
    private void m39158f() {
        C3138if.C3142else elseR;
        StringBuilder sb = new StringBuilder();
        sb.append("*** START FLASHING *** ");
        sb.append(this.f54304p.mo169173do());
        if (this.f54267D != null && this.f54276M != null && (elseR = this.f54296h.m46218try()) != null) {
            this.f54299k.m47473for();
            this.f54309u.mo161966a();
            this.f54267D.mo170686if(this.f54304p.mo169173do(), this.f54276M.getFrameRate());
            m39147a("flashing_start", elseR.m46227try());
            this.f54299k.mo161903do(true);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public boolean m39160g() {
        Activity activity = this.f54277N;
        if (activity != null && (activity.isDestroyed() || this.f54277N.isFinishing())) {
            return false;
        }
        Intent intent = new Intent(this.f54292d, m39136a(this.f54294f.f54333do.f53992ui.orientation));
        Activity activity2 = this.f54277N;
        if (activity2 != null && this.f54294f.f54333do.f53992ui.activityCompatibilityRequestCode != null) {
            this.f54277N.startActivityForResult(intent, this.f54294f.f54333do.f53992ui.activityCompatibilityRequestCode.intValue());
        } else if (activity2 != null) {
            this.f54277N.startActivity(intent);
        } else {
            intent.addFlags(268435456);
            this.f54292d.startActivity(intent);
        }
        this.f54277N = null;
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m39162h() {
        this.f54312x.incrementAndGet();
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m39164i() {
        if (this.f54294f.f54333do.f53992ui.orientation != Orientation.PORTRAIT) {
            this.f54296h.mo38665do((IProovException) new InvalidOptionsException(this.f54292d, "Liveness Assurance is currently only supported in portrait orientation"));
        } else if (this.f54269F == null && this.f54278O != null) {
            DisplayMetrics displayMetrics = this.f54292d.getResources().getDisplayMetrics();
            C19880const constR = new C19880const(this.f54292d, this.f54278O, new C20817break(displayMetrics.widthPixels, displayMetrics.heightPixels), this.f54279P.m47670else(), this.f54291ab);
            this.f54269F = constR;
            this.f54270G = constR;
            this.f54298j.mo171524do(constR.mo162065do());
            this.f54299k.mo161899do(new RectF(0.0f, 0.0f, 1.0f, 1.0f));
            C3011new newR = this.f54272I;
            if (newR != null) {
                newR.mo38426do((C3011new.C3012do) this.f54269F.mo162063b());
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public void m39166j() {
        C3127throw.m4052do((Runnable) new Runnable() {
            public final void run() {
                C19889if.this.m39172m();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public void m39168k() {
        C20824new newR;
        if (this.f54274K != null && (newR = this.f54278O) != null) {
            C1269do doVar = new C1269do(newR.mo161911if(), this.f54286W, this.f54274K);
            this.f54264A = doVar;
            doVar.m46121case();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public /* synthetic */ void m39172m() {
        C21001if ifVar;
        C3014do doVar = this.f54266C;
        if (doVar != null && (ifVar = this.f54279P) != null) {
            doVar.mo38437do(ifVar.mo171513do(), this.f54279P.m47671final());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: n */
    public /* synthetic */ void m39174n() {
        C1269do doVar = this.f54264A;
        if (doVar != null) {
            doVar.mo14139do();
        }
    }

    /* renamed from: break  reason: not valid java name */
    public void m47521break() {
        this.f54296h.mo38665do((IProovException) new CameraPermissionException(this.f54292d));
    }

    /* renamed from: class  reason: not valid java name */
    public void m47523class() {
        this.f54296h.m46216for();
    }

    /* renamed from: import  reason: not valid java name */
    public void m47524import() {
        C3138if ifVar = this.f54296h.mo38668if();
        boolean z = this.f54300l.mo23987do() || this.f54300l.m46156throw();
        if ((this.f54279P != null && this.f54267D != null && z && (ifVar instanceof C3138if.C3145if)) || ifVar.m46220for()) {
            m39158f();
        }
    }

    /* renamed from: new  reason: not valid java name */
    public C20994do m47525new() {
        return this.f54279P.mo171513do();
    }

    /* renamed from: static  reason: not valid java name */
    public void m47526static() {
        this.f54284U = this.f54300l.m46148const();
    }

    /* renamed from: super  reason: not valid java name */
    public synchronized void m47527super() {
        this.f54298j.mo171530if();
    }

    /* renamed from: try  reason: not valid java name */
    public IProov.Options m47528try() {
        return this.f54294f.f54333do;
    }

    /* renamed from: com.iproov.sdk.core.if$do */
    /* compiled from: CaptureManager */
    class C19891do implements C3138if.C3147this {
        C19891do() {
        }

        /* renamed from: do */
        public void mo38690do(C3138if.C3142else elseR) {
        }

        /* renamed from: do */
        public void mo38695do(C3138if ifVar) {
            String unused = C19889if.f54263c;
            StringBuilder sb = new StringBuilder();
            sb.append("🔵 ");
            sb.append(ifVar);
            if (C19889if.this.f54266C != null) {
                ifVar.mo38674if(C19889if.this.f54266C);
            }
        }

        /* renamed from: do */
        public void mo38693do(C3138if.C3146new newR) {
            C19889if.this.f54295g.onConnecting();
        }

        /* renamed from: do */
        public void mo38691do(C3138if.C3143for forR) {
            if (!C19889if.this.m39160g()) {
                C19889if.this.m47523class();
            }
            C19889if.this.f54295g.onConnected();
        }

        /* renamed from: do */
        public void mo38692do(C3138if.C3145if ifVar) {
            C19889if.this.m39147a(ifVar.m46230new().mo38657do(), ifVar.m46231try());
        }

        /* renamed from: do */
        public void mo38687do(C3138if.C3139break breakR) {
            C19889if.this.f54295g.onProcessing(breakR.m46222try(), breakR.m46221new());
        }

        /* renamed from: do */
        public void mo38688do(C3138if.C3140case caseR) {
            C19887for forR = caseR.m46223new();
            C19889if.this.m39156e();
            if (forR.m47520new()) {
                C19889if.this.f54295g.onSuccess(new IProov.SuccessResult(forR.mo162089if(), C19889if.this.m39169l()));
            } else if (forR.m47519for()) {
                C19889if.this.f54295g.onError(new NetworkException(C19889if.this.f54292d, forR.mo162087do(C19889if.this.f54292d)));
            } else {
                C19889if.this.f54295g.onFailure(new IProov.FailureResult(forR.mo162089if(), forR.mo162087do(C19889if.this.f54292d), forR.mo162086do(), C19889if.this.m39169l()));
            }
        }

        /* renamed from: do */
        public void mo38694do(C3138if.C3148try tryR) {
            IProovException iProovException = tryR.m46232new();
            C19889if.this.m39146a(iProovException.getReason());
            C19889if.this.m39156e();
            C19889if.this.f54295g.onError(iProovException);
        }

        /* renamed from: do */
        public void mo38689do(C3138if.C3141do doVar) {
            C19889if.this.m39146a("user_cancelled");
            C19889if.this.m39156e();
            C19889if.this.f54295g.onCancelled();
        }
    }

    /* renamed from: com.iproov.sdk.core.if$for */
    /* compiled from: CaptureManager */
    class C19893for implements C19792try.C19793do {
        C19893for() {
        }

        /* access modifiers changed from: private */
        /* renamed from: for  reason: not valid java name */
        public /* synthetic */ void m47530for() {
            if (C19889if.this.f54265B != null && C19889if.this.f54266C != null) {
                C19889if.this.f54266C.mo38435do(C19889if.this.f54265B.m46197for());
                if (C19889if.this.f54300l.m46148const()) {
                    C19889if.this.f54266C.mo38436do(C19889if.this.f54265B.mo38590if());
                }
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: if */
        public /* synthetic */ void m39207if(C20821for forR) {
            try {
                C3138if.C3145if ifVar = m47529for(forR);
                if (ifVar != null) {
                    C19889if.this.f54296h.mo38664do(ifVar);
                }
                if (C19889if.this.f54305q.mo169175if()) {
                    C19889if.this.f54305q.m47608try();
                } else {
                    C19889if.this.f54305q.m47606for();
                }
                C3127throw.m4052do((Runnable) new Runnable() {
                    public final void run() {
                        C19889if.C19893for.this.m47530for();
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                C19889if.this.f54296h.mo38665do((IProovException) new UnexpectedErrorException(C19889if.this.f54292d, e));
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: new  reason: not valid java name */
        public /* synthetic */ void m47534new() {
            if (C19889if.this.f54266C != null) {
                C19889if.this.f54266C.m46184try();
            }
        }

        /* renamed from: do */
        public void mo161945do(C20824new newR) {
            String unused = C19889if.f54263c;
            if (C19889if.this.f54265B != null) {
                C19889if.this.f54265B.mo38586do(newR.m47617for().floatValue());
            }
            C20824new unused2 = C19889if.this.f54278O = newR;
            C19889if.this.f54276M.m47543break();
            C19889if.this.f54298j.mo171525do(newR.mo161909do(), C19889if.this.f54280Q.angleDegrees);
            C19889if.this.m39168k();
            if (C19889if.this.f54279P != null && C19889if.this.f54279P.mo171513do() == C20994do.LIVENESS) {
                C19889if.this.m39164i();
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x003a, code lost:
            if (com.iproov.sdk.core.C19889if.m39165j(r9.f54318do) == null) goto L_0x0061;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0067, code lost:
            if (com.iproov.sdk.core.C19889if.m39110C(r9.f54318do) == null) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0069, code lost:
            r3 = com.iproov.sdk.core.C19889if.m39110C(r9.f54318do).mo38585do(r0, com.iproov.sdk.core.C19889if.m39122O(r9.f54318do));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x007f, code lost:
            if (com.iproov.sdk.core.C19889if.m39122O(r9.f54318do) == null) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0081, code lost:
            if (r3 == null) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0087, code lost:
            if (r3.m46229for() == false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0089, code lost:
            r10 = com.iproov.sdk.core.C19889if.m39122O(r9.f54318do).getPose();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0093, code lost:
            if (r10 == null) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0095, code lost:
            r10 = com.iproov.sdk.core.C19889if.m39125R(r9.f54318do).mo170661do(r10);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x009f, code lost:
            if (r10 == null) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
            return new p096try.C3138if.C3145if(r10, r3.m46231try());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
            return new p096try.C3138if.C3145if(com.iproov.sdk.core.C19889if.m39165j(r9.f54318do).mo162062a(r10, r0, com.iproov.sdk.core.C19889if.m39122O(r9.f54318do), new android.graphics.Rect(0, 0, r0.getWidth(), r0.getHeight())), (p092super.C3103this) null);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
            return null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
            return r3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
            return r3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
            return r3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
            return r3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
            return r3;
         */
        /* renamed from: for  reason: not valid java name */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private p096try.C3138if.C3145if m47529for(p232do.C20821for r10) throws p092super.C3095case {
            /*
                r9 = this;
                int r0 = r9.m39206if()
                android.graphics.Bitmap r0 = r10.mo161939do(r0)
                com.iproov.sdk.core.if r1 = com.iproov.sdk.core.C19889if.this
                com.iproov.sdk.cameray.Orientation r1 = r1.f54280Q
                android.graphics.Bitmap r0 = p093switch.C3121for.m4030do(r0, r1)
                if (r0 == 0) goto L_0x00af
                com.iproov.sdk.core.if r1 = com.iproov.sdk.core.C19889if.this
                java.lang.Object r1 = r1.f54307s
                monitor-enter(r1)
                com.iproov.sdk.core.if r2 = com.iproov.sdk.core.C19889if.this     // Catch:{ all -> 0x00ac }
                com.iproov.sdk.face.FaceDetector r2 = r2.f54313y     // Catch:{ all -> 0x00ac }
                r3 = 0
                if (r2 != 0) goto L_0x0026
                monitor-exit(r1)     // Catch:{ all -> 0x00ac }
                return r3
            L_0x0026:
                com.iproov.sdk.core.if r2 = com.iproov.sdk.core.C19889if.this     // Catch:{ all -> 0x00ac }
                com.iproov.sdk.face.FaceDetector r4 = r2.f54313y     // Catch:{ all -> 0x00ac }
                com.iproov.sdk.face.model.FaceFeature r4 = r4.detectFace(r0)     // Catch:{ all -> 0x00ac }
                com.iproov.sdk.face.model.FaceFeature unused = r2.f54268E = r4     // Catch:{ all -> 0x00ac }
                monitor-exit(r1)     // Catch:{ all -> 0x00ac }
                com.iproov.sdk.core.if r1 = com.iproov.sdk.core.C19889if.this
                com.iproov.sdk.core.const r1 = r1.f54269F
                if (r1 == 0) goto L_0x0061
                try.if$if r1 = new try.if$if
                com.iproov.sdk.core.if r2 = com.iproov.sdk.core.C19889if.this
                com.iproov.sdk.core.const r2 = r2.f54269F
                com.iproov.sdk.core.if r4 = com.iproov.sdk.core.C19889if.this
                com.iproov.sdk.face.model.FaceFeature r4 = r4.f54268E
                android.graphics.Rect r5 = new android.graphics.Rect
                int r6 = r0.getWidth()
                int r7 = r0.getHeight()
                r8 = 0
                r5.<init>(r8, r8, r6, r7)
                try.do r10 = r2.mo162062a((p232do.C20821for) r10, (android.graphics.Bitmap) r0, (com.iproov.sdk.face.model.FaceFeature) r4, (android.graphics.Rect) r5)
                r1.<init>(r10, r3)
                r3 = r1
                goto L_0x00ab
            L_0x0061:
                com.iproov.sdk.core.if r10 = com.iproov.sdk.core.C19889if.this
                super.for r10 = r10.f54265B
                if (r10 == 0) goto L_0x00ab
                com.iproov.sdk.core.if r10 = com.iproov.sdk.core.C19889if.this
                super.for r10 = r10.f54265B
                com.iproov.sdk.core.if r1 = com.iproov.sdk.core.C19889if.this
                com.iproov.sdk.face.model.FaceFeature r1 = r1.f54268E
                try.if$if r3 = r10.mo38585do(r0, r1)
                com.iproov.sdk.core.if r10 = com.iproov.sdk.core.C19889if.this
                com.iproov.sdk.face.model.FaceFeature r10 = r10.f54268E
                if (r10 == 0) goto L_0x00ab
                if (r3 == 0) goto L_0x00ab
                boolean r10 = r3.m46229for()
                if (r10 == 0) goto L_0x00ab
                com.iproov.sdk.core.if r10 = com.iproov.sdk.core.C19889if.this
                com.iproov.sdk.face.model.FaceFeature r10 = r10.f54268E
                com.iproov.sdk.face.model.Pose r10 = r10.getPose()
                if (r10 == 0) goto L_0x00ab
                com.iproov.sdk.core.if r0 = com.iproov.sdk.core.C19889if.this
                else.for r0 = r0.f54297i
                try.do r10 = r0.mo170661do(r10)
                if (r10 == 0) goto L_0x00ab
                try.if$if r0 = new try.if$if
                super.this r1 = r3.m46231try()
                r0.<init>(r10, r1)
                r3 = r0
            L_0x00ab:
                return r3
            L_0x00ac:
                r10 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x00ac }
                throw r10
            L_0x00af:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r0 = "Bitmap can not be null"
                r10.<init>(r0)
                throw r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iproov.sdk.core.C19889if.C19893for.m47529for(do.for):try.if$if");
        }

        /* renamed from: do */
        public void mo161947do(Exception exc) {
            if (exc instanceof IProovException) {
                C19889if.this.f54296h.mo38665do((IProovException) exc);
            } else {
                C19889if.this.f54296h.mo38665do((IProovException) new CameraException(C19889if.this.f54292d, exc));
            }
        }

        /* renamed from: do */
        public void mo161943do(C19792try.C19794if ifVar, Exception exc) {
            IPLog.m39305w(C19889if.f54263c, ifVar.toString());
            if (exc != null) {
                exc.printStackTrace();
            }
        }

        /* renamed from: if */
        private int m39206if() {
            return (C19889if.this.f54279P == null || C19889if.this.f54279P.mo171513do() != C20994do.LIVENESS) ? 4 : 3;
        }

        /* renamed from: do */
        public void mo161948do(boolean z) {
            if (C19889if.this.f54265B != null) {
                C19889if.this.f54265B.mo38588do(z);
            }
        }

        /* renamed from: do */
        public void mo161946do(C20825this thisR) {
            if (C19889if.this.f54265B != null) {
                C19889if.this.f54265B.mo38587do(thisR);
            }
        }

        /* renamed from: do */
        public void mo161944do(C20821for forR) {
            if (forR == null) {
                C19889if.this.f54296h.mo38665do((IProovException) new CameraException(C19889if.this.f54292d, "Frame not available, perhaps corrupt"));
            } else if (C19889if.this.f54266C != null) {
                if (C19889if.this.f54304p.mo169175if()) {
                    C19889if.this.f54304p.m47608try();
                } else {
                    C19889if.this.f54304p.m47606for();
                }
                long unused = C19889if.this.f54283T = System.nanoTime();
                if (C19889if.this.f54296h.mo38666do() && C19889if.this.f54279P != null) {
                    C19889if.this.f54302n.execute(new Runnable(forR) {
                        public final /* synthetic */ C20821for f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void run() {
                            C19889if.C19893for.this.m39207if(this.f$1);
                        }
                    });
                }
                if (C19889if.this.f54312x.get() > 0) {
                    C19889if.this.f54312x.decrementAndGet();
                    String unused2 = C19889if.f54263c;
                    C19889if.this.m39145a(forR, false);
                } else {
                    synchronized (C19889if.this.f54309u) {
                        if (C19889if.this.f54309u.mo161968b()) {
                            C3127throw.m4052do((Runnable) new Runnable() {
                                public final void run() {
                                    C19889if.C19893for.this.m47534new();
                                }
                            });
                            String unused3 = C19889if.f54263c;
                            C19889if.this.m39145a(forR, true);
                        }
                    }
                }
                if (C19889if.this.f54300l.m46148const()) {
                    synchronized (C19889if.this.f54307s) {
                        C3127throw.m4052do((Runnable) new Runnable(C19900new.m39241a(C19889if.this.f54265B, C19889if.this.f54279P, C19889if.this.f54268E, C19889if.this.f54276M, C19889if.this.f54299k, C19889if.this.f54278O, C19889if.this.f54313y, C19889if.this.f54264A, C19889if.this.f54276M.getFrameRate(), C19889if.this.f54304p, C19889if.this.f54305q)) {
                            public final /* synthetic */ String f$1;

                            {
                                this.f$1 = r2;
                            }

                            public final void run() {
                                C19889if.C19893for.this.m39205do(this.f$1);
                            }
                        });
                    }
                }
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: do */
        public /* synthetic */ void m39205do(String str) {
            if (C19889if.this.f54266C != null) {
                C19889if.this.f54266C.mo38438do(str);
            }
        }

        /* renamed from: do */
        public void mo161942do() {
            C19889if.this.f54304p.m47607new();
            C19889if.this.f54305q.m47607new();
        }
    }

    /* renamed from: com.iproov.sdk.core.if$case */
    /* compiled from: CaptureManager */
    class C19890case implements C19880const.C19881do {
        C19890case() {
        }

        /* access modifiers changed from: private */
        /* renamed from: if */
        public /* synthetic */ void m39191if(Rect rect, Rect rect2, Rect rect3, Rect rect4) {
            if (C19889if.this.f54266C != null) {
                LivenessDebugOverlay livenessDebugOverlay = C19889if.this.f54266C.mo38441if();
                if (C19889if.this.f54284U) {
                    livenessDebugOverlay.setVisibility(0);
                    livenessDebugOverlay.mo162195if(rect);
                    livenessDebugOverlay.m47551for(rect2);
                    livenessDebugOverlay.mo162192do(rect3);
                    livenessDebugOverlay.m47552new(rect4);
                    livenessDebugOverlay.mo162194if();
                    return;
                }
                livenessDebugOverlay.setVisibility(8);
            }
        }

        /* renamed from: do */
        public void mo162068do(C20821for forR, boolean z, RectF rectF) {
            String unused = C19889if.f54263c;
            synchronized (C19889if.this.f54309u) {
                C19889if.this.f54309u.mo161966a();
                String unused2 = C19889if.f54263c;
                C19889if.this.m39145a(forR, false);
            }
            C19889if.this.f54299k.mo161899do(rectF);
            C3127throw.m4052do((Runnable) new Runnable(z) {
                public final /* synthetic */ boolean f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    C19889if.C19890case.this.m39190do(this.f$1);
                }
            });
        }

        /* access modifiers changed from: private */
        /* renamed from: do */
        public /* synthetic */ void m39190do(boolean z) {
            if (!(C19889if.this.f54266C == null || C19889if.this.f54269F == null)) {
                C19889if.this.f54266C.mo38439do(z);
            }
            if (z) {
                C19889if.this.f54272I.m46179case();
            }
        }

        /* renamed from: do */
        public void mo162067do(Rect rect, RectF rectF) {
            RectF unused = C19889if.this.f54273J = rectF;
            String unused2 = C19889if.f54263c;
            StringBuilder sb = new StringBuilder();
            sb.append("CROPRECTpost=");
            sb.append(rect);
            C3127throw.m4052do((Runnable) new Runnable(rect) {
                public final /* synthetic */ Rect f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    C19889if.C19890case.this.m39189do(this.f$1);
                }
            });
        }

        /* access modifiers changed from: private */
        /* renamed from: do */
        public /* synthetic */ void m39189do(Rect rect) {
            C19889if.this.f54276M.mo162153do(rect);
            if (C19889if.this.f54266C != null) {
                if (C19889if.this.f54269F != null) {
                    C19889if.this.f54266C.mo38439do(false);
                }
                if (C19889if.this.f54300l.m46148const()) {
                    C19889if.this.f54266C.m46182for();
                }
            }
            C19889if.this.f54272I.m46181try();
        }

        /* renamed from: do */
        public void mo162066do(Rect rect, Rect rect2, Rect rect3, Rect rect4) {
            C3127throw.m4052do((Runnable) new Runnable(rect, rect2, rect3, rect4) {
                public final /* synthetic */ Rect f$1;
                public final /* synthetic */ Rect f$2;
                public final /* synthetic */ Rect f$3;
                public final /* synthetic */ Rect f$4;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                    this.f$4 = r5;
                }

                public final void run() {
                    C19889if.C19890case.this.m39191if(this.f$1, this.f$2, this.f$3, this.f$4);
                }
            });
        }

        /* renamed from: do */
        public void mo162069do(Exception exc) {
            C19889if.this.f54296h.mo38665do((IProovException) new UnexpectedErrorException(C19889if.this.f54292d, exc));
        }
    }

    /* renamed from: com.iproov.sdk.core.if$new */
    /* compiled from: CaptureManager */
    class C19896new implements C20837for.C20838do {
        C19896new() {
        }

        /* renamed from: do */
        public void mo162113do(int i, C20836do doVar, int i2) {
            String unused = C19889if.f54263c;
            StringBuilder sb = new StringBuilder();
            sb.append("Flashing ");
            sb.append(doVar);
            sb.append(" (#");
            int i3 = i + 1;
            sb.append(i3);
            sb.append(")");
            int color = C19889if.this.f54292d.getResources().getColor(doVar.mo170682do());
            float f = ((float) i) / ((float) C19889if.this.f54267D.m47647new());
            float f2 = ((float) i3) / ((float) C19889if.this.f54267D.m47647new());
            C19889if.this.f54276M.mo162152do(color, f2, (long) i2);
            C19889if.this.f54267D.mo170684do(C19889if.this.f54304p.mo169173do(), C19889if.this.f54276M.getFrameRate());
            if (((double) i) >= ((double) C19889if.this.f54267D.m47647new()) * 0.8d) {
                C19889if.this.f54276M.m47545this();
            }
            C19889if.this.f54296h.mo38662do(doVar, i2, f, f2);
        }

        /* renamed from: if */
        public void mo162114if() {
            String unused = C19889if.f54263c;
            C19889if.this.m39162h();
        }

        /* renamed from: do */
        public void mo162112do() {
            String unused = C19889if.f54263c;
        }
    }

    /* renamed from: do */
    public void mo162098do(C3014do doVar) {
        if (this.f54266C != doVar) {
            this.f54266C = doVar;
            if (doVar != null) {
                m39151c();
            } else {
                m39153d();
            }
        }
    }

    /* renamed from: do */
    public void mo162097do(OpenGLRenderer openGLRenderer) {
        this.f54276M = openGLRenderer;
        openGLRenderer.setPermissionsDelegate(new OpenGLRenderer.C19919do() {
            /* renamed from: do */
            public final void mo161963do() {
                C19889if.this.m39149b();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m39146a(String str) {
        this.f54298j.mo171526do(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m39147a(String str, C3103this thisR) {
        if (this.f54265B != null && thisR != null) {
            Map<String, Object> map = thisR.mo38597do();
            map.put("time", Long.valueOf(System.currentTimeMillis()));
            map.put("state", str);
            map.put("autoStartEnabled", Double.valueOf(this.f54294f.f54333do.f53992ui.genuinePresenceAssurance.autoStartDisabled ? 0.0d : 1.0d));
            C3134do doVar = this.f54314z;
            if (doVar != null) {
                map.put("sLux", Float.valueOf(doVar.mo38653if()));
            }
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry next : map.entrySet()) {
                try {
                    jSONObject.put((String) next.getKey(), next.getValue());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            this.f54298j.mo171531if(jSONObject);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public Bitmap m39169l() {
        Bitmap bitmap = this.f54271H;
        if (bitmap == null) {
            return null;
        }
        return C3121for.m4030do(bitmap, this.f54280Q);
    }

    /* renamed from: com.iproov.sdk.core.if$goto */
    /* compiled from: CaptureManager */
    public class C19894goto implements C1269do.C1271if {
        public C19894goto() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:11:0x005c A[Catch:{ IProovException -> 0x0096 }] */
        /* JADX WARNING: Removed duplicated region for block: B:12:0x0068 A[Catch:{ IProovException -> 0x0096 }] */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x0089 A[Catch:{ IProovException -> 0x0096 }] */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x008d A[Catch:{ IProovException -> 0x0096 }] */
        /* renamed from: do */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void m39215do(byte[] r11, boolean r12) {
            /*
                r10 = this;
                java.lang.String unused = com.iproov.sdk.core.C19889if.f54263c
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "onFrameEncoded -> streamer 🛒 frame size="
                r0.append(r1)
                int r1 = r11.length
                r0.append(r1)
                com.iproov.sdk.core.if r0 = com.iproov.sdk.core.C19889if.this
                java.util.Queue r0 = r0.f54311w
                java.lang.Object r0 = r0.poll()
                r3 = r0
                java.lang.Long r3 = (java.lang.Long) r3
                com.iproov.sdk.core.if r0 = com.iproov.sdk.core.C19889if.this
                com.iproov.sdk.crypto.do r0 = r0.f54308t
                com.iproov.sdk.crypto.do r1 = com.iproov.sdk.crypto.C19913do.UNSUPPORTED
                r2 = 0
                if (r0 == r1) goto L_0x0048
                com.iproov.sdk.core.if r0 = com.iproov.sdk.core.C19889if.this     // Catch:{ for -> 0x0039 }
                com.iproov.sdk.crypto.if r0 = r0.f54275L     // Catch:{ for -> 0x0039 }
                byte[] r0 = r0.mo162128do((byte[]) r11)     // Catch:{ for -> 0x0039 }
                java.lang.String r0 = p093switch.C3127throw.m4050do((byte[]) r0)     // Catch:{ for -> 0x0039 }
                r6 = r0
                goto L_0x0049
            L_0x0039:
                r0 = move-exception
                r0.printStackTrace()
                java.lang.String r1 = com.iproov.sdk.core.C19889if.f54263c
                java.lang.String r0 = r0.getLocalizedMessage()
                com.iproov.sdk.logging.IPLog.m39305w(r1, r0)
            L_0x0048:
                r6 = r2
            L_0x0049:
                com.iproov.sdk.core.import r0 = com.iproov.sdk.core.C19898import.AND5     // Catch:{ IProovException -> 0x0096 }
                com.iproov.sdk.core.C19909while.m39264do(r0)     // Catch:{ IProovException -> 0x0096 }
                com.iproov.sdk.core.if r0 = com.iproov.sdk.core.C19889if.this     // Catch:{ IProovException -> 0x0096 }
                import.if r1 = r0.f54298j     // Catch:{ IProovException -> 0x0096 }
                com.iproov.sdk.core.if r0 = com.iproov.sdk.core.C19889if.this     // Catch:{ IProovException -> 0x0096 }
                com.iproov.sdk.core.const r0 = r0.f54269F     // Catch:{ IProovException -> 0x0096 }
                if (r0 == 0) goto L_0x0068
                com.iproov.sdk.core.if r0 = com.iproov.sdk.core.C19889if.this     // Catch:{ IProovException -> 0x0096 }
                com.iproov.sdk.core.const r0 = r0.f54269F     // Catch:{ IProovException -> 0x0096 }
                java.util.List r0 = r0.mo162061a()     // Catch:{ IProovException -> 0x0096 }
                r4 = r0
                goto L_0x0069
            L_0x0068:
                r4 = r2
            L_0x0069:
                com.iproov.sdk.core.if r0 = com.iproov.sdk.core.C19889if.this     // Catch:{ IProovException -> 0x0096 }
                android.graphics.RectF r5 = r0.f54273J     // Catch:{ IProovException -> 0x0096 }
                com.iproov.sdk.core.if r0 = com.iproov.sdk.core.C19889if.this     // Catch:{ IProovException -> 0x0096 }
                if.if r0 = r0.f54279P     // Catch:{ IProovException -> 0x0096 }
                case.case r0 = r0.m47672for()     // Catch:{ IProovException -> 0x0096 }
                case.else r7 = r0.mo14136do()     // Catch:{ IProovException -> 0x0096 }
                com.iproov.sdk.core.if r0 = com.iproov.sdk.core.C19889if.this     // Catch:{ IProovException -> 0x0096 }
                com.iproov.sdk.core.c r0 = r0.f54309u     // Catch:{ IProovException -> 0x0096 }
                boolean r0 = r0.mo161969c()     // Catch:{ IProovException -> 0x0096 }
                if (r0 == 0) goto L_0x008d
                com.iproov.sdk.core.case r0 = com.iproov.sdk.core.C19801case.SUPPLEMENTARY     // Catch:{ IProovException -> 0x0096 }
            L_0x008b:
                r8 = r0
                goto L_0x0090
            L_0x008d:
                com.iproov.sdk.core.case r0 = com.iproov.sdk.core.C19801case.AUTHENTICATION     // Catch:{ IProovException -> 0x0096 }
                goto L_0x008b
            L_0x0090:
                r2 = r11
                r9 = r12
                r1.mo171528do(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ IProovException -> 0x0096 }
                goto L_0x00a0
            L_0x0096:
                r11 = move-exception
                com.iproov.sdk.core.if r12 = com.iproov.sdk.core.C19889if.this
                try.for r12 = r12.f54296h
                r12.mo38665do((com.iproov.sdk.core.exception.IProovException) r11)
            L_0x00a0:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iproov.sdk.core.C19889if.C19894goto.m39215do(byte[], boolean):void");
        }

        /* renamed from: do */
        public void mo14144do(C1277try tryR) {
            if (C19889if.this.f54296h.mo38668if().mo38675if()) {
                String unused = C19889if.f54263c;
                return;
            }
            C19889if.this.f54310v.offer(tryR);
            if (tryR.mo14148do()) {
                String unused2 = C19889if.f54263c;
                StringBuilder sb = new StringBuilder();
                sb.append("onFrameEncoded held header size=");
                sb.append(tryR.f473do.length);
            } else if (!C19889if.this.f54296h.mo38668if().mo38672do()) {
                String unused3 = C19889if.f54263c;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("onFrameEncoded 🕰 too early header=");
                sb2.append(tryR.mo14148do());
                sb2.append(" size=");
                sb2.append(tryR.f473do.length);
            } else {
                while (C19889if.this.f54310v.size() > 1) {
                    C1277try tryR2 = (C1277try) C19889if.this.f54310v.poll();
                    byte[] bArr = tryR2.f473do;
                    if (tryR2.mo14148do()) {
                        C1277try tryR3 = (C1277try) C19889if.this.f54310v.poll();
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        try {
                            byteArrayOutputStream.write(bArr);
                            byteArrayOutputStream.write(tryR3.f473do);
                            bArr = byteArrayOutputStream.toByteArray();
                        } catch (IOException e) {
                            IPLog.m39305w(C19889if.f54263c, e.getLocalizedMessage());
                        }
                    }
                    m39215do(bArr, false);
                }
            }
        }

        /* renamed from: do */
        public void mo14143do() {
            String unused = C19889if.f54263c;
            while (!C19889if.this.f54310v.isEmpty()) {
                m39215do(((C1277try) C19889if.this.f54310v.poll()).f473do, C19889if.this.f54310v.isEmpty());
            }
        }

        /* renamed from: do */
        public void mo14145do(Exception exc) {
            C19889if.this.f54296h.mo38665do((IProovException) new UnexpectedErrorException(C19889if.this.f54292d, exc.getLocalizedMessage()));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m39140a(double d) {
        if (this.f54282S == -1) {
            this.f54282S = System.currentTimeMillis();
        }
        this.f54296h.mo38660do(d, C21002new.m41068do(this.f54292d, this.f54279P.m47668catch(), d, System.currentTimeMillis() - this.f54282S > 3000, this.f54279P.mo171513do()));
    }

    /* renamed from: a */
    private static Class<? extends C19923do> m39136a(Orientation orientation) {
        int i = C19892else.f54317do[orientation.ordinal()];
        if (i == 2) {
            return IProovLandscapeActivity.class;
        }
        if (i == 3) {
            return IProovReversePortraitActivity.class;
        }
        if (i != 4) {
            return IProovPortraitActivity.class;
        }
        return IProovReverseLandscapeActivity.class;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m39145a(C20821for forR, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("📀 encodeFrame() ");
        sb.append(z ? C19801case.SUPPLEMENTARY : C19801case.AUTHENTICATION);
        if (this.f54264A != null && this.f54270G != null) {
            this.f54303o.execute(new Runnable(forR, z) {
                public final /* synthetic */ C20821for f$1;
                public final /* synthetic */ boolean f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void run() {
                    C19889if.this.m39150b(this.f$1, this.f$2);
                }
            });
        }
    }
}
