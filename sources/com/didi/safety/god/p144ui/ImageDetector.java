package com.didi.safety.god.p144ui;

import com.didi.safety.god.http.SafetyTraceEventHandler;
import com.didi.safety.god.manager.GodManager;
import com.didi.safety.god.util.LabelUtils;
import com.didi.sec.algo.RawDetectInfo;
import java.util.HashMap;

/* renamed from: com.didi.safety.god.ui.ImageDetector */
public class ImageDetector {

    /* renamed from: a */
    private int f34770a;

    /* renamed from: b */
    private int f34771b = GodManager.getInstance().getConfig().timeOutEngine;

    /* renamed from: c */
    private long f34772c;

    /* renamed from: d */
    private long f34773d;

    /* renamed from: e */
    private final DetectionListener f34774e;

    /* renamed from: f */
    private volatile boolean f34775f;

    /* renamed from: g */
    private volatile boolean f34776g;

    /* renamed from: h */
    private long f34777h;

    /* renamed from: i */
    private boolean f34778i = GodManager.getInstance().getConfig().standardLabelTimeoutSwitch;

    /* renamed from: j */
    private boolean f34779j;

    /* renamed from: k */
    private boolean f34780k;

    /* renamed from: l */
    private int f34781l;

    /* renamed from: m */
    private int f34782m;

    /* renamed from: com.didi.safety.god.ui.ImageDetector$DetectionListener */
    public interface DetectionListener {
        void onDetectLabelDone(boolean z, PosSizeInfo posSizeInfo);

        void onDetectNothing();

        void onDetectTimeout();

        void onFinish(DetectionResult detectionResult, RawDetectInfo rawDetectInfo, boolean z);

        void onTimeoutRecord();
    }

    /* renamed from: com.didi.safety.god.ui.ImageDetector$DetectionResult */
    public enum DetectionResult {
        SUCCESS,
        TIMEOUT,
        DETECTION_ERROR,
        DETECTION_NO_GOOD_QUALITY,
        ENGINE_ERROR
    }

    public ImageDetector(DetectionListener detectionListener, int i, int i2, int i3) {
        this.f34774e = detectionListener;
        this.f34770a = i3;
        this.f34781l = i;
        this.f34782m = i2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo89977a() {
        return this.f34782m == 0 || !LabelUtils.isStandardLabel(this.f34781l);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public RawDetectInfo mo89978b() {
        return DetectCoreThread.m24495a().mo89909f();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0158, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void pushData(byte[] r10, int r11, int r12) {
        /*
            r9 = this;
            com.didi.safety.god.ui.DetectCoreThread r0 = com.didi.safety.god.p144ui.DetectCoreThread.m24495a()
            java.lang.Object r0 = r0.mo89908e()
            monitor-enter(r0)
            boolean r1 = r9.f34775f     // Catch:{ all -> 0x0159 }
            if (r1 == 0) goto L_0x000f
            monitor-exit(r0)     // Catch:{ all -> 0x0159 }
            return
        L_0x000f:
            boolean r1 = r9.isQuit()     // Catch:{ all -> 0x0159 }
            if (r1 == 0) goto L_0x0017
            monitor-exit(r0)     // Catch:{ all -> 0x0159 }
            return
        L_0x0017:
            com.didi.safety.god.ui.DetectCoreThread r1 = com.didi.safety.god.p144ui.DetectCoreThread.m24495a()     // Catch:{ all -> 0x0159 }
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0159 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0159 }
            r4.<init>()     // Catch:{ all -> 0x0159 }
            java.lang.String r5 = "pushData, label==="
            r4.append(r5)     // Catch:{ all -> 0x0159 }
            int r5 = r9.f34781l     // Catch:{ all -> 0x0159 }
            r4.append(r5)     // Catch:{ all -> 0x0159 }
            java.lang.String r5 = ", currentTime="
            r4.append(r5)     // Catch:{ all -> 0x0159 }
            r4.append(r2)     // Catch:{ all -> 0x0159 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0159 }
            com.didi.safety.god.util.LogUtils.m24578d(r4)     // Catch:{ all -> 0x0159 }
            long r4 = r9.f34777h     // Catch:{ all -> 0x0159 }
            r6 = 0
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 != 0) goto L_0x004a
            r9.f34777h = r2     // Catch:{ all -> 0x0159 }
            r1.mo89903a((long) r2)     // Catch:{ all -> 0x0159 }
        L_0x004a:
            boolean r4 = r1.mo89907d()     // Catch:{ all -> 0x0159 }
            if (r4 == 0) goto L_0x0055
            com.didi.safety.god.ui.ImageDetector$DetectionListener r4 = r9.f34774e     // Catch:{ all -> 0x0159 }
            r4.onDetectNothing()     // Catch:{ all -> 0x0159 }
        L_0x0055:
            long r4 = r9.f34773d     // Catch:{ all -> 0x0159 }
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 != 0) goto L_0x006b
            r9.f34773d = r2     // Catch:{ all -> 0x0159 }
            int r4 = r9.f34781l     // Catch:{ all -> 0x0159 }
            r1.mo89902a(r4, r10, r11, r12)     // Catch:{ all -> 0x0159 }
            r9.f34772c = r2     // Catch:{ all -> 0x0159 }
            java.lang.String r10 = "first frame, just send to detect..."
            com.didi.safety.god.util.LogUtils.m24578d(r10)     // Catch:{ all -> 0x0159 }
            goto L_0x0157
        L_0x006b:
            boolean r4 = r9.mo89977a()     // Catch:{ all -> 0x0159 }
            if (r4 == 0) goto L_0x008c
            java.lang.String r10 = "non-standard label or picAutoDect=0 label, wait to timeout..."
            com.didi.safety.god.util.LogUtils.m24578d(r10)     // Catch:{ all -> 0x0159 }
            long r10 = r9.f34773d     // Catch:{ all -> 0x0159 }
            long r2 = r2 - r10
            int r10 = r9.f34770a     // Catch:{ all -> 0x0159 }
            long r10 = (long) r10     // Catch:{ all -> 0x0159 }
            int r12 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1))
            if (r12 <= 0) goto L_0x0157
            java.lang.String r10 = "non-standard label or picAutoDect=0 label timeout..."
            com.didi.safety.god.util.LogUtils.m24578d(r10)     // Catch:{ all -> 0x0159 }
            com.didi.safety.god.ui.ImageDetector$DetectionListener r10 = r9.f34774e     // Catch:{ all -> 0x0159 }
            r10.onTimeoutRecord()     // Catch:{ all -> 0x0159 }
            goto L_0x0157
        L_0x008c:
            boolean r4 = r9.f34779j     // Catch:{ all -> 0x0159 }
            if (r4 != 0) goto L_0x00f9
            boolean r4 = r1.f34709a     // Catch:{ all -> 0x0159 }
            if (r4 != 0) goto L_0x009b
            java.lang.String r10 = "no first detect result ready, wait and next==="
            com.didi.safety.god.util.LogUtils.m24578d(r10)     // Catch:{ all -> 0x0159 }
            goto L_0x0157
        L_0x009b:
            boolean r4 = r1.f34710b     // Catch:{ all -> 0x0159 }
            if (r4 == 0) goto L_0x00c5
            java.lang.String r4 = "inside standard label, detect nothing..."
            com.didi.safety.god.util.LogUtils.m24578d(r4)     // Catch:{ all -> 0x0159 }
            long r4 = r9.f34773d     // Catch:{ all -> 0x0159 }
            long r2 = r2 - r4
            int r4 = r9.f34770a     // Catch:{ all -> 0x0159 }
            long r4 = (long) r4     // Catch:{ all -> 0x0159 }
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 <= 0) goto L_0x00be
            boolean r2 = r9.f34778i     // Catch:{ all -> 0x0159 }
            if (r2 == 0) goto L_0x00be
            java.lang.String r10 = "standard label timeout..."
            com.didi.safety.god.util.LogUtils.m24578d(r10)     // Catch:{ all -> 0x0159 }
            com.didi.safety.god.ui.ImageDetector$DetectionListener r10 = r9.f34774e     // Catch:{ all -> 0x0159 }
            r10.onDetectTimeout()     // Catch:{ all -> 0x0159 }
            goto L_0x0157
        L_0x00be:
            int r2 = r9.f34781l     // Catch:{ all -> 0x0159 }
            r1.mo89902a(r2, r10, r11, r12)     // Catch:{ all -> 0x0159 }
            goto L_0x0157
        L_0x00c5:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0159 }
            r2.<init>()     // Catch:{ all -> 0x0159 }
            java.lang.String r3 = "detect something, wrong==="
            r2.append(r3)     // Catch:{ all -> 0x0159 }
            boolean r3 = r1.f34711c     // Catch:{ all -> 0x0159 }
            r2.append(r3)     // Catch:{ all -> 0x0159 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0159 }
            com.didi.safety.god.util.LogUtils.m24578d(r2)     // Catch:{ all -> 0x0159 }
            com.didi.safety.god.ui.PosSizeInfo r2 = r1.f34712d     // Catch:{ all -> 0x0159 }
            boolean r3 = r1.f34711c     // Catch:{ all -> 0x0159 }
            if (r3 != 0) goto L_0x00f1
            boolean r3 = r2.notOk()     // Catch:{ all -> 0x0159 }
            if (r3 == 0) goto L_0x00f1
            java.lang.String r3 = "first detect pos/size not ok, send to detect..."
            com.didi.safety.god.util.LogUtils.m24578d(r3)     // Catch:{ all -> 0x0159 }
            int r3 = r9.f34781l     // Catch:{ all -> 0x0159 }
            r1.mo89902a(r3, r10, r11, r12)     // Catch:{ all -> 0x0159 }
        L_0x00f1:
            com.didi.safety.god.ui.ImageDetector$DetectionListener r10 = r9.f34774e     // Catch:{ all -> 0x0159 }
            boolean r11 = r1.f34711c     // Catch:{ all -> 0x0159 }
            r10.onDetectLabelDone(r11, r2)     // Catch:{ all -> 0x0159 }
            goto L_0x0157
        L_0x00f9:
            boolean r2 = r9.f34780k     // Catch:{ all -> 0x0159 }
            r3 = 1
            if (r2 != 0) goto L_0x010c
            r1.mo89904a((boolean) r3)     // Catch:{ all -> 0x0159 }
            java.lang.String r2 = "video started, continue send to detect..."
            com.didi.safety.god.util.LogUtils.m24578d(r2)     // Catch:{ all -> 0x0159 }
            int r2 = r9.f34781l     // Catch:{ all -> 0x0159 }
            r1.mo89902a(r2, r10, r11, r12)     // Catch:{ all -> 0x0159 }
            goto L_0x0157
        L_0x010c:
            java.lang.String r10 = "video stopped, callback with picInfo..."
            com.didi.safety.god.util.LogUtils.m24578d(r10)     // Catch:{ all -> 0x0159 }
            com.didi.sec.algo.RawDetectInfo r10 = r1.mo89912i()     // Catch:{ all -> 0x0159 }
            int r11 = r1.mo89910g()     // Catch:{ all -> 0x0159 }
            int r12 = r1.mo89911h()     // Catch:{ all -> 0x0159 }
            com.didi.safety.god.manager.GodManager r1 = com.didi.safety.god.manager.GodManager.getInstance()     // Catch:{ all -> 0x0159 }
            com.didi.safety.god.manager.GodManager$Config r1 = r1.getConfig()     // Catch:{ all -> 0x0159 }
            double r1 = r1.mScreenCheckRate     // Catch:{ all -> 0x0159 }
            r9.m24551a(r11, r12, r1)     // Catch:{ all -> 0x0159 }
            r1 = 0
            if (r11 <= 0) goto L_0x0150
            if (r12 <= 0) goto L_0x0150
            double r4 = (double) r12     // Catch:{ all -> 0x0159 }
            double r11 = (double) r11     // Catch:{ all -> 0x0159 }
            double r4 = r4 / r11
            com.didi.safety.god.manager.GodManager r11 = com.didi.safety.god.manager.GodManager.getInstance()     // Catch:{ all -> 0x0159 }
            com.didi.safety.god.manager.GodManager$Config r11 = r11.getConfig()     // Catch:{ all -> 0x0159 }
            double r11 = r11.mScreenCheckRate     // Catch:{ all -> 0x0159 }
            int r2 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
            if (r2 <= 0) goto L_0x0148
            com.didi.safety.god.ui.ImageDetector$DetectionListener r11 = r9.f34774e     // Catch:{ all -> 0x0159 }
            com.didi.safety.god.ui.ImageDetector$DetectionResult r12 = com.didi.safety.god.p144ui.ImageDetector.DetectionResult.SUCCESS     // Catch:{ all -> 0x0159 }
            r11.onFinish(r12, r10, r3)     // Catch:{ all -> 0x0159 }
            goto L_0x0157
        L_0x0148:
            com.didi.safety.god.ui.ImageDetector$DetectionListener r11 = r9.f34774e     // Catch:{ all -> 0x0159 }
            com.didi.safety.god.ui.ImageDetector$DetectionResult r12 = com.didi.safety.god.p144ui.ImageDetector.DetectionResult.SUCCESS     // Catch:{ all -> 0x0159 }
            r11.onFinish(r12, r10, r1)     // Catch:{ all -> 0x0159 }
            goto L_0x0157
        L_0x0150:
            com.didi.safety.god.ui.ImageDetector$DetectionListener r11 = r9.f34774e     // Catch:{ all -> 0x0159 }
            com.didi.safety.god.ui.ImageDetector$DetectionResult r12 = com.didi.safety.god.p144ui.ImageDetector.DetectionResult.SUCCESS     // Catch:{ all -> 0x0159 }
            r11.onFinish(r12, r10, r1)     // Catch:{ all -> 0x0159 }
        L_0x0157:
            monitor-exit(r0)     // Catch:{ all -> 0x0159 }
            return
        L_0x0159:
            r10 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0159 }
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.safety.god.p144ui.ImageDetector.pushData(byte[], int, int):void");
    }

    public void quit() {
        this.f34776g = true;
    }

    public boolean isQuit() {
        return this.f34776g;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo89979c() {
        this.f34775f = true;
        DetectCoreThread.m24495a().mo89906c();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo89980d() {
        this.f34775f = false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo89981e() {
        this.f34779j = true;
        this.f34780k = false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo89982f() {
        this.f34780k = true;
        DetectCoreThread.m24495a().mo89905b();
    }

    /* renamed from: a */
    private void m24551a(int i, int i2, double d) {
        HashMap hashMap = new HashMap();
        hashMap.put("cmd", "BADFRAME");
        hashMap.put("allCount", Integer.valueOf(i));
        hashMap.put("failCount", Integer.valueOf(i2));
        hashMap.put("screenCheckRate", Double.valueOf(d));
        SafetyTraceEventHandler.trace(hashMap);
    }
}
