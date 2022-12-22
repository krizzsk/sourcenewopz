package com.didi.safety.god.p144ui;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.SparseArray;
import com.didi.safety.god.http.SafetyHttp;
import com.didi.safety.god.http.SafetyTraceEventHandler;
import com.didi.safety.god.manager.GodManager;
import com.didi.safety.god.util.LabelUtils;
import com.didi.safety.god.util.LogUtils;
import com.didi.sec.algo.RawDetectInfo;
import com.didichuxing.dfbasesdk.AppContextHolder;
import java.util.HashMap;
import java.util.Locale;

/* renamed from: com.didi.safety.god.ui.DetectCoreThread */
class DetectCoreThread {

    /* renamed from: e */
    static final /* synthetic */ boolean f34697e = (!DetectCoreThread.class.desiredAssertionStatus());

    /* renamed from: f */
    private static DetectCoreThread f34698f = null;

    /* renamed from: t */
    private static final float f34699t = 0.9f;

    /* renamed from: u */
    private static final float f34700u = 0.99f;

    /* renamed from: v */
    private static final float f34701v = 0.9f;

    /* renamed from: A */
    private boolean f34702A;

    /* renamed from: B */
    private long f34703B;

    /* renamed from: C */
    private int f34704C;

    /* renamed from: D */
    private int f34705D;

    /* renamed from: E */
    private int f34706E;

    /* renamed from: F */
    private int f34707F;

    /* renamed from: G */
    private int f34708G;

    /* renamed from: a */
    boolean f34709a;

    /* renamed from: b */
    boolean f34710b;

    /* renamed from: c */
    boolean f34711c;

    /* renamed from: d */
    PosSizeInfo f34712d;

    /* renamed from: g */
    private boolean f34713g;

    /* renamed from: h */
    private Handler f34714h;

    /* renamed from: i */
    private HandlerThread f34715i;

    /* renamed from: j */
    private int f34716j;

    /* renamed from: k */
    private long f34717k;

    /* renamed from: l */
    private final Object f34718l = new Object();

    /* renamed from: m */
    private boolean f34719m = GodManager.getInstance().getConfig().failCaseSwitch;

    /* renamed from: n */
    private boolean f34720n = GodManager.getInstance().getConfig().successCaseSwitch;

    /* renamed from: o */
    private SparseArray<CollectInfo> f34721o = new SparseArray<>();

    /* renamed from: p */
    private SparseArray<CollectInfo> f34722p = new SparseArray<>();

    /* renamed from: q */
    private int f34723q;

    /* renamed from: r */
    private int f34724r;

    /* renamed from: s */
    private final float f34725s = GodManager.getInstance().getConfig().clearPicProportion;

    /* renamed from: w */
    private RawDetectInfo f34726w;

    /* renamed from: x */
    private RawDetectInfo f34727x;

    /* renamed from: y */
    private RawDetectInfo[] f34728y;

    /* renamed from: z */
    private float f34729z = -1.0f;

    /* renamed from: a */
    static DetectCoreThread m24495a() {
        if (f34698f == null) {
            f34698f = new DetectCoreThread();
        }
        return f34698f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo89905b() {
        mo89906c();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo89906c() {
        Handler handler = this.f34714h;
        if (handler != null) {
            handler.removeMessages(0);
        }
    }

    /* renamed from: com.didi.safety.god.ui.DetectCoreThread$CollectInfo */
    static class CollectInfo {
        float bscore;
        byte[] imgBytes;
        int label;
        int labelD;
        float qscore;
        float rscore;
        float score;
        int type;

        CollectInfo(int i) {
            this.type = 2;
            this.label = i;
        }

        CollectInfo(int i, RawDetectInfo rawDetectInfo) {
            this(i, 1, rawDetectInfo);
        }

        CollectInfo(int i, int i2, RawDetectInfo rawDetectInfo) {
            this.label = i;
            this.type = i2;
            this.labelD = rawDetectInfo.label;
            this.score = rawDetectInfo.score;
            this.qscore = rawDetectInfo.qScore;
            this.bscore = rawDetectInfo.bScore;
            this.rscore = rawDetectInfo.rScore;
            this.imgBytes = rawDetectInfo.data;
        }

        /* access modifiers changed from: package-private */
        public void update(RawDetectInfo rawDetectInfo) {
            this.type = 2;
            this.labelD = rawDetectInfo.label;
            this.score = rawDetectInfo.score;
            this.qscore = rawDetectInfo.qScore;
            this.bscore = rawDetectInfo.bScore;
            this.rscore = rawDetectInfo.rScore;
            this.imgBytes = rawDetectInfo.data;
        }

        /* access modifiers changed from: package-private */
        public void updateByDetectNothing(byte[] bArr) {
            if (this.imgBytes == null) {
                LogUtils.m24578d("collect detect nothing case...");
                this.imgBytes = bArr;
                this.labelD = 0;
                this.score = 0.0f;
                this.qscore = 0.0f;
                this.bscore = 0.0f;
                this.rscore = 0.0f;
            }
        }

        /* access modifiers changed from: package-private */
        public boolean needUpload() {
            return this.imgBytes != null;
        }
    }

    private DetectCoreThread() {
        LogUtils.m24578d("DetectCoreThread.ctor, collFailCases===" + this.f34719m + ", collOkCases=" + this.f34720n);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo89903a(long j) {
        LogUtils.m24578d("markBeginCostTime===");
        this.f34717k = j;
        m24501k();
    }

    /* renamed from: k */
    private void m24501k() {
        this.f34726w = null;
        this.f34727x = null;
        this.f34728y = new RawDetectInfo[2];
        this.f34712d = new PosSizeInfo();
        this.f34709a = false;
        this.f34710b = false;
        this.f34711c = false;
        this.f34729z = -1.0f;
        this.f34704C = 0;
        this.f34705D = 0;
        this.f34706E = 0;
        this.f34707F = 0;
        this.f34708G = 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo89902a(int i, byte[] bArr, int i2, int i3) {
        LogUtils.m24578d("sendToDetect, label===" + i);
        if (!this.f34713g) {
            m24502l();
        }
        this.f34713g = true;
        this.f34716j = i;
        if (this.f34719m && this.f34721o.get(i) == null) {
            LogUtils.m24578d("sendToDetect, put fail coll info, label===" + i);
            this.f34721o.put(i, new CollectInfo(i));
        }
        this.f34723q = i2;
        this.f34724r = i3;
        Message obtainMessage = this.f34714h.obtainMessage();
        Bundle bundle = new Bundle();
        bundle.putByteArray("data", bArr);
        bundle.putInt("width", i2);
        bundle.putInt("height", i3);
        obtainMessage.setData(bundle);
        this.f34714h.sendMessage(obtainMessage);
    }

    /* renamed from: l */
    private void m24502l() {
        HandlerThread handlerThread = new HandlerThread("god_detect");
        this.f34715i = handlerThread;
        handlerThread.start();
        this.f34714h = new Handler(this.f34715i.getLooper()) {
            public void handleMessage(Message message) {
                DetectCoreThread.this.m24496a(message);
            }
        };
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x0214, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00c1, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m24496a(android.os.Message r9) {
        /*
            r8 = this;
            android.os.Bundle r9 = r9.getData()
            java.lang.String r0 = "data"
            byte[] r0 = r9.getByteArray(r0)
            java.lang.String r1 = "height"
            int r1 = r9.getInt(r1)
            java.lang.String r2 = "width"
            int r9 = r9.getInt(r2)
            com.didi.safety.god.manager.GodManager r2 = com.didi.safety.god.manager.GodManager.getInstance()
            com.didi.sec.algo.RawDetectInfo r9 = r2.yuvdetect(r0, r9, r1)
            java.lang.Object r1 = r8.f34718l
            monitor-enter(r1)
            r2 = 1
            r8.f34709a = r2     // Catch:{ all -> 0x0215 }
            com.didi.sec.algo.RawDetectInfo r3 = r8.f34726w     // Catch:{ all -> 0x0215 }
            if (r3 == 0) goto L_0x0076
            int r3 = r8.f34704C     // Catch:{ all -> 0x0215 }
            int r3 = r3 + r2
            r8.f34704C = r3     // Catch:{ all -> 0x0215 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0215 }
            r3.<init>()     // Catch:{ all -> 0x0215 }
            java.lang.String r4 = "during video, allCount==="
            r3.append(r4)     // Catch:{ all -> 0x0215 }
            int r4 = r8.f34704C     // Catch:{ all -> 0x0215 }
            r3.append(r4)     // Catch:{ all -> 0x0215 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0215 }
            com.didi.safety.god.util.LogUtils.m24578d(r3)     // Catch:{ all -> 0x0215 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0215 }
            r3.<init>()     // Catch:{ all -> 0x0215 }
            java.lang.String r4 = "handle is "
            r3.append(r4)     // Catch:{ all -> 0x0215 }
            r3.append(r9)     // Catch:{ all -> 0x0215 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0215 }
            com.didi.safety.god.util.LogUtils.m24578d(r3)     // Catch:{ all -> 0x0215 }
            if (r9 == 0) goto L_0x0071
            int r3 = r9.disState     // Catch:{ all -> 0x0215 }
            if (r3 != 0) goto L_0x0071
            boolean r3 = r9.notCentered     // Catch:{ all -> 0x0215 }
            if (r3 != 0) goto L_0x0071
            float r3 = r9.score     // Catch:{ all -> 0x0215 }
            com.didi.safety.god.manager.GodManager r4 = com.didi.safety.god.manager.GodManager.getInstance()     // Catch:{ all -> 0x0215 }
            com.didi.safety.god.manager.GodManager$Config r4 = r4.getConfig()     // Catch:{ all -> 0x0215 }
            float r4 = r4.dectConf     // Catch:{ all -> 0x0215 }
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 >= 0) goto L_0x0076
        L_0x0071:
            int r3 = r8.f34708G     // Catch:{ all -> 0x0215 }
            int r3 = r3 + r2
            r8.f34708G = r3     // Catch:{ all -> 0x0215 }
        L_0x0076:
            if (r9 == 0) goto L_0x020a
            float r3 = r9.score     // Catch:{ all -> 0x0215 }
            com.didi.safety.god.manager.GodManager r4 = com.didi.safety.god.manager.GodManager.getInstance()     // Catch:{ all -> 0x0215 }
            com.didi.safety.god.manager.GodManager$Config r4 = r4.getConfig()     // Catch:{ all -> 0x0215 }
            float r4 = r4.dectConf     // Catch:{ all -> 0x0215 }
            r5 = 0
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 >= 0) goto L_0x008b
            r3 = 1
            goto L_0x008c
        L_0x008b:
            r3 = 0
        L_0x008c:
            r8.f34710b = r3     // Catch:{ all -> 0x0215 }
            r4 = 1065185444(0x3f7d70a4, float:0.99)
            if (r3 == 0) goto L_0x00b1
            int r3 = r9.label     // Catch:{ all -> 0x0215 }
            boolean r3 = com.didi.safety.god.util.LabelUtils.isQualitySupportedLabel(r3)     // Catch:{ all -> 0x0215 }
            if (r3 == 0) goto L_0x00b1
            float r3 = r9.score     // Catch:{ all -> 0x0215 }
            r6 = 1045220557(0x3e4ccccd, float:0.2)
            int r3 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r3 <= 0) goto L_0x00b1
            float r3 = r9.qScore     // Catch:{ all -> 0x0215 }
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 <= 0) goto L_0x00b1
            java.lang.String r3 = "label 1/3/6 with very higher qScore, so let it continue..."
            com.didi.safety.god.util.LogUtils.m24578d(r3)     // Catch:{ all -> 0x0215 }
            r8.f34710b = r5     // Catch:{ all -> 0x0215 }
        L_0x00b1:
            boolean r3 = r8.f34710b     // Catch:{ all -> 0x0215 }
            if (r3 == 0) goto L_0x00c2
            r8.m24500a((byte[]) r0)     // Catch:{ all -> 0x0215 }
            int r0 = r8.f34704C     // Catch:{ all -> 0x0215 }
            if (r0 <= 0) goto L_0x00c0
            com.didi.sec.algo.RawDetectInfo[] r0 = r8.f34728y     // Catch:{ all -> 0x0215 }
            r0[r5] = r9     // Catch:{ all -> 0x0215 }
        L_0x00c0:
            monitor-exit(r1)     // Catch:{ all -> 0x0215 }
            return
        L_0x00c2:
            com.didi.sec.algo.RawDetectInfo r0 = r8.f34726w     // Catch:{ all -> 0x0215 }
            if (r0 != 0) goto L_0x0106
            int r0 = r8.f34716j     // Catch:{ all -> 0x0215 }
            int r3 = r9.label     // Catch:{ all -> 0x0215 }
            if (r0 == r3) goto L_0x00cd
            goto L_0x00ce
        L_0x00cd:
            r2 = 0
        L_0x00ce:
            r8.f34711c = r2     // Catch:{ all -> 0x0215 }
            if (r2 == 0) goto L_0x00d7
            r8.m24499a((com.didi.sec.algo.RawDetectInfo) r9)     // Catch:{ all -> 0x0215 }
            monitor-exit(r1)     // Catch:{ all -> 0x0215 }
            return
        L_0x00d7:
            com.didi.safety.god.ui.PosSizeInfo r0 = r8.f34712d     // Catch:{ all -> 0x0215 }
            int r2 = r9.disState     // Catch:{ all -> 0x0215 }
            r0.disState = r2     // Catch:{ all -> 0x0215 }
            com.didi.safety.god.ui.PosSizeInfo r0 = r8.f34712d     // Catch:{ all -> 0x0215 }
            int r0 = r0.disState     // Catch:{ all -> 0x0215 }
            if (r0 <= 0) goto L_0x00ea
            java.lang.String r9 = "first detect size not ok!!!"
            com.didi.safety.god.util.LogUtils.m24578d(r9)     // Catch:{ all -> 0x0215 }
            monitor-exit(r1)     // Catch:{ all -> 0x0215 }
            return
        L_0x00ea:
            com.didi.safety.god.ui.PosSizeInfo r0 = r8.f34712d     // Catch:{ all -> 0x0215 }
            boolean r2 = r9.notCentered     // Catch:{ all -> 0x0215 }
            r0.notCentered = r2     // Catch:{ all -> 0x0215 }
            com.didi.safety.god.ui.PosSizeInfo r0 = r8.f34712d     // Catch:{ all -> 0x0215 }
            boolean r0 = r0.notCentered     // Catch:{ all -> 0x0215 }
            if (r0 == 0) goto L_0x00fd
            java.lang.String r9 = "first detect pos not ok!!!"
            com.didi.safety.god.util.LogUtils.m24578d(r9)     // Catch:{ all -> 0x0215 }
            monitor-exit(r1)     // Catch:{ all -> 0x0215 }
            return
        L_0x00fd:
            java.lang.String r0 = "step1, set firstDetectInfo..."
            com.didi.safety.god.util.LogUtils.m24578d(r0)     // Catch:{ all -> 0x0215 }
            r8.f34726w = r9     // Catch:{ all -> 0x0215 }
            goto L_0x0213
        L_0x0106:
            java.lang.String r0 = "step2, select best pic info during video..."
            com.didi.safety.god.util.LogUtils.m24578d(r0)     // Catch:{ all -> 0x0215 }
            int r0 = r9.label     // Catch:{ all -> 0x0215 }
            int r3 = r8.f34716j     // Catch:{ all -> 0x0215 }
            if (r3 == r0) goto L_0x0118
            java.lang.String r9 = "ignore wrong label during video select..."
            com.didi.safety.god.util.LogUtils.m24578d(r9)     // Catch:{ all -> 0x0215 }
            monitor-exit(r1)     // Catch:{ all -> 0x0215 }
            return
        L_0x0118:
            boolean r3 = com.didi.safety.god.util.LabelUtils.isQualitySupportedLabel(r0)     // Catch:{ all -> 0x0215 }
            if (r3 == 0) goto L_0x01fb
            r3 = 8
            if (r0 != r3) goto L_0x0124
            r0 = 1
            goto L_0x0125
        L_0x0124:
            r0 = 0
        L_0x0125:
            r3 = 1063675494(0x3f666666, float:0.9)
            if (r0 == 0) goto L_0x012b
            goto L_0x012e
        L_0x012b:
            r4 = 1063675494(0x3f666666, float:0.9)
        L_0x012e:
            float r6 = r9.qScore     // Catch:{ all -> 0x0215 }
            if (r0 == 0) goto L_0x0169
            float r0 = r9.bScore     // Catch:{ all -> 0x0215 }
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 > 0) goto L_0x014f
            float r0 = r9.rScore     // Catch:{ all -> 0x0215 }
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 > 0) goto L_0x014f
            int r0 = r8.f34705D     // Catch:{ all -> 0x0215 }
            int r0 = r0 + r2
            r8.f34705D = r0     // Catch:{ all -> 0x0215 }
            float r0 = r8.f34729z     // Catch:{ all -> 0x0215 }
            int r0 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x01c6
            r8.f34727x = r9     // Catch:{ all -> 0x0215 }
            r8.f34729z = r6     // Catch:{ all -> 0x0215 }
            goto L_0x01c6
        L_0x014f:
            float r0 = r9.bScore     // Catch:{ all -> 0x0215 }
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x015f
            int r0 = r8.f34706E     // Catch:{ all -> 0x0215 }
            int r0 = r0 + r2
            r8.f34706E = r0     // Catch:{ all -> 0x0215 }
            com.didi.sec.algo.RawDetectInfo[] r0 = r8.f34728y     // Catch:{ all -> 0x0215 }
            r0[r5] = r9     // Catch:{ all -> 0x0215 }
            goto L_0x01c6
        L_0x015f:
            int r0 = r8.f34707F     // Catch:{ all -> 0x0215 }
            int r0 = r0 + r2
            r8.f34707F = r0     // Catch:{ all -> 0x0215 }
            com.didi.sec.algo.RawDetectInfo[] r0 = r8.f34728y     // Catch:{ all -> 0x0215 }
            r0[r2] = r9     // Catch:{ all -> 0x0215 }
            goto L_0x01c6
        L_0x0169:
            r0 = 1028443341(0x3d4ccccd, float:0.05)
            float r7 = r9.bScore     // Catch:{ all -> 0x0215 }
            int r7 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r7 > 0) goto L_0x0190
            float r7 = r9.rScore     // Catch:{ all -> 0x0215 }
            int r7 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r7 > 0) goto L_0x0190
            int r7 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r7 < 0) goto L_0x0190
            int r0 = r8.f34705D     // Catch:{ all -> 0x0215 }
            int r0 = r0 + r2
            r8.f34705D = r0     // Catch:{ all -> 0x0215 }
            float r0 = r9.score     // Catch:{ all -> 0x0215 }
            float r2 = r8.f34729z     // Catch:{ all -> 0x0215 }
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 <= 0) goto L_0x01c6
            r8.f34727x = r9     // Catch:{ all -> 0x0215 }
            float r9 = r9.score     // Catch:{ all -> 0x0215 }
            r8.f34729z = r9     // Catch:{ all -> 0x0215 }
            goto L_0x01c6
        L_0x0190:
            float r7 = r9.bScore     // Catch:{ all -> 0x0215 }
            int r4 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r4 > 0) goto L_0x01bd
            int r0 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r0 >= 0) goto L_0x01a3
            float r4 = r9.bScore     // Catch:{ all -> 0x0215 }
            float r6 = r9.rScore     // Catch:{ all -> 0x0215 }
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 <= 0) goto L_0x01a3
            goto L_0x01bd
        L_0x01a3:
            float r4 = r9.rScore     // Catch:{ all -> 0x0215 }
            int r3 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r3 > 0) goto L_0x01b3
            if (r0 >= 0) goto L_0x01c6
            float r0 = r9.rScore     // Catch:{ all -> 0x0215 }
            float r3 = r9.bScore     // Catch:{ all -> 0x0215 }
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 <= 0) goto L_0x01c6
        L_0x01b3:
            int r0 = r8.f34707F     // Catch:{ all -> 0x0215 }
            int r0 = r0 + r2
            r8.f34707F = r0     // Catch:{ all -> 0x0215 }
            com.didi.sec.algo.RawDetectInfo[] r0 = r8.f34728y     // Catch:{ all -> 0x0215 }
            r0[r2] = r9     // Catch:{ all -> 0x0215 }
            goto L_0x01c6
        L_0x01bd:
            int r0 = r8.f34706E     // Catch:{ all -> 0x0215 }
            int r0 = r0 + r2
            r8.f34706E = r0     // Catch:{ all -> 0x0215 }
            com.didi.sec.algo.RawDetectInfo[] r0 = r8.f34728y     // Catch:{ all -> 0x0215 }
            r0[r5] = r9     // Catch:{ all -> 0x0215 }
        L_0x01c6:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0215 }
            r9.<init>()     // Catch:{ all -> 0x0215 }
            java.lang.String r0 = "allCount==="
            r9.append(r0)     // Catch:{ all -> 0x0215 }
            int r0 = r8.f34704C     // Catch:{ all -> 0x0215 }
            r9.append(r0)     // Catch:{ all -> 0x0215 }
            java.lang.String r0 = ", okCount="
            r9.append(r0)     // Catch:{ all -> 0x0215 }
            int r0 = r8.f34705D     // Catch:{ all -> 0x0215 }
            r9.append(r0)     // Catch:{ all -> 0x0215 }
            java.lang.String r0 = ", bCount="
            r9.append(r0)     // Catch:{ all -> 0x0215 }
            int r0 = r8.f34706E     // Catch:{ all -> 0x0215 }
            r9.append(r0)     // Catch:{ all -> 0x0215 }
            java.lang.String r0 = ", rCount="
            r9.append(r0)     // Catch:{ all -> 0x0215 }
            int r0 = r8.f34707F     // Catch:{ all -> 0x0215 }
            r9.append(r0)     // Catch:{ all -> 0x0215 }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x0215 }
            com.didi.safety.god.util.LogUtils.m24578d(r9)     // Catch:{ all -> 0x0215 }
            goto L_0x0213
        L_0x01fb:
            float r0 = r9.score     // Catch:{ all -> 0x0215 }
            float r2 = r8.f34729z     // Catch:{ all -> 0x0215 }
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 <= 0) goto L_0x0213
            r8.f34727x = r9     // Catch:{ all -> 0x0215 }
            float r9 = r9.score     // Catch:{ all -> 0x0215 }
            r8.f34729z = r9     // Catch:{ all -> 0x0215 }
            goto L_0x0213
        L_0x020a:
            com.didi.sec.algo.RawDetectInfo r9 = r8.f34726w     // Catch:{ all -> 0x0215 }
            if (r9 != 0) goto L_0x0213
            r8.f34710b = r2     // Catch:{ all -> 0x0215 }
            r8.m24500a((byte[]) r0)     // Catch:{ all -> 0x0215 }
        L_0x0213:
            monitor-exit(r1)     // Catch:{ all -> 0x0215 }
            return
        L_0x0215:
            r9 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0215 }
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.safety.god.p144ui.DetectCoreThread.m24496a(android.os.Message):void");
    }

    /* renamed from: a */
    public void mo89904a(boolean z) {
        if (z) {
            this.f34703B = System.currentTimeMillis();
        }
        this.f34702A = z;
    }

    /* renamed from: a */
    private void m24500a(byte[] bArr) {
        CollectInfo collectInfo;
        if (this.f34719m && (collectInfo = this.f34721o.get(this.f34716j)) != null) {
            collectInfo.updateByDetectNothing(bArr);
        }
    }

    /* renamed from: a */
    private void m24499a(RawDetectInfo rawDetectInfo) {
        CollectInfo collectInfo;
        if (this.f34719m && (collectInfo = this.f34721o.get(this.f34716j)) != null && rawDetectInfo.score > collectInfo.score) {
            LogUtils.m24578d("collect wrong label, find a better score===" + rawDetectInfo.score);
            collectInfo.update(rawDetectInfo);
        }
    }

    /* renamed from: d */
    public boolean mo89907d() {
        return this.f34710b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public Object mo89908e() {
        return this.f34718l;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public RawDetectInfo mo89909f() {
        return this.f34726w;
    }

    /* renamed from: g */
    public int mo89910g() {
        return this.f34704C;
    }

    /* renamed from: h */
    public int mo89911h() {
        return this.f34708G;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public RawDetectInfo mo89912i() {
        LogUtils.m24578d("allCount===" + this.f34704C + ", okCount=" + this.f34705D + ", bCount=" + this.f34706E + ", rCount=" + this.f34707F);
        boolean isQualitySupportedLabel = LabelUtils.isQualitySupportedLabel(this.f34716j);
        RawDetectInfo rawDetectInfo = this.f34727x;
        if (rawDetectInfo == null) {
            rawDetectInfo = this.f34726w;
        }
        if (f34697e || rawDetectInfo != null) {
            boolean z = false;
            if (this.f34727x == null) {
                LogUtils.m24578d("detectInfoDuringVideo is null!!!");
                if (!isQualitySupportedLabel) {
                    rawDetectInfo.qState = 0;
                } else if (this.f34706E >= this.f34707F) {
                    RawDetectInfo rawDetectInfo2 = this.f34728y[0];
                    if (rawDetectInfo2 != null) {
                        rawDetectInfo = rawDetectInfo2;
                    } else {
                        z = true;
                    }
                    rawDetectInfo.qState = 1;
                } else {
                    RawDetectInfo rawDetectInfo3 = this.f34728y[1];
                    if (rawDetectInfo3 != null) {
                        rawDetectInfo = rawDetectInfo3;
                    } else {
                        z = true;
                    }
                    rawDetectInfo.qState = 2;
                }
            } else if (isQualitySupportedLabel) {
                int i = this.f34704C;
                if (i <= 0) {
                    rawDetectInfo.qState = 0;
                } else if ((((float) this.f34705D) * 1.0f) / ((float) i) > this.f34725s) {
                    rawDetectInfo.qState = 0;
                } else if (this.f34706E >= this.f34707F) {
                    RawDetectInfo rawDetectInfo4 = this.f34728y[0];
                    if (rawDetectInfo4 != null) {
                        rawDetectInfo = rawDetectInfo4;
                    } else {
                        z = true;
                    }
                    rawDetectInfo.qState = 1;
                } else {
                    RawDetectInfo rawDetectInfo5 = this.f34728y[1];
                    if (rawDetectInfo5 != null) {
                        rawDetectInfo = rawDetectInfo5;
                    } else {
                        z = true;
                    }
                    rawDetectInfo.qState = 2;
                }
            } else {
                rawDetectInfo.qState = 0;
            }
            if (rawDetectInfo.isGoodQuality()) {
                if (this.f34720n) {
                    LogUtils.m24578d("collect success case...");
                    SparseArray<CollectInfo> sparseArray = this.f34722p;
                    int i2 = this.f34716j;
                    sparseArray.put(i2, new CollectInfo(i2, rawDetectInfo));
                }
            } else if (this.f34719m && !z) {
                CollectInfo collectInfo = this.f34721o.get(this.f34716j);
                if (rawDetectInfo.score > collectInfo.score) {
                    LogUtils.m24578d("collect no good quality, find a better score===" + rawDetectInfo.score);
                    collectInfo.update(rawDetectInfo);
                }
            }
            return rawDetectInfo;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public void mo89913j() {
        LogUtils.m24578d("DetectCoreThread.destroy, started===" + this.f34713g);
        if (this.f34713g) {
            this.f34714h.removeMessages(0);
            this.f34715i.quit();
            m24503m();
        }
        this.f34713g = false;
        f34698f = null;
    }

    /* renamed from: m */
    private void m24503m() {
        if (this.f34719m) {
            int size = this.f34721o.size();
            for (int i = 0; i < size; i++) {
                CollectInfo valueAt = this.f34721o.valueAt(i);
                if (valueAt.needUpload()) {
                    m24497a(valueAt);
                }
            }
        }
        this.f34721o.clear();
        if (this.f34720n) {
            int size2 = this.f34722p.size();
            for (int i2 = 0; i2 < size2; i2++) {
                CollectInfo valueAt2 = this.f34722p.valueAt(i2);
                if (valueAt2.needUpload()) {
                    m24497a(valueAt2);
                }
            }
        }
        this.f34722p.clear();
    }

    /* renamed from: a */
    private void m24497a(CollectInfo collectInfo) {
        if (AppContextHolder.getAppContext() != null) {
            HashMap hashMap = new HashMap(SafetyHttp.getCommonBodyParams());
            hashMap.put("cmd", "ALGRESULT");
            hashMap.put("type", Integer.valueOf(collectInfo.type));
            hashMap.put("label", String.valueOf(collectInfo.label));
            hashMap.put("labelD", String.valueOf(collectInfo.labelD));
            hashMap.put("score", String.format(Locale.CHINA, "%.6f", new Object[]{Float.valueOf(collectInfo.score)}));
            hashMap.put("qscore", String.format(Locale.CHINA, "%.6f", new Object[]{Float.valueOf(collectInfo.qscore)}));
            hashMap.put("bscore", String.format(Locale.CHINA, "%.6f", new Object[]{Float.valueOf(collectInfo.bscore)}));
            hashMap.put("rscore", String.format(Locale.CHINA, "%.6f", new Object[]{Float.valueOf(collectInfo.rscore)}));
            SafetyTraceEventHandler.trace(hashMap);
        }
    }
}
