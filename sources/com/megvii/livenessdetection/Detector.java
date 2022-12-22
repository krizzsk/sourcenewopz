package com.megvii.livenessdetection;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.util.Base64;
import com.didi.payment.utilities.scan.collect.CollectionConstant;
import com.iproov.sdk.bridge.OptionsBridge;
import com.megvii.livenessdetection.DetectionConfig;
import com.megvii.livenessdetection.bean.FaceIDDataStruct;
import com.megvii.livenessdetection.bean.FaceInfo;
import com.megvii.livenessdetection.impl.C20339a;
import com.megvii.livenessdetection.impl.C20340b;
import com.megvii.livenessdetection.obf.C20341a;
import com.megvii.livenessdetection.obf.C20343b;
import com.megvii.livenessdetection.obf.C20346d;
import com.megvii.livenessdetection.obf.C20347e;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Detector {
    public static final int DETECTOR_INIT_FAILED_BADCIPHER = 4;
    public static final int DETECTOR_INIT_FAILED_EXPIRE = 5;
    public static final int DETECTOR_INIT_FAILED_INVALIDMODEL = 1;
    public static final int DETECTOR_INIT_FAILED_NATIVEINITFAILED = 3;
    public static final int DETECTOR_INIT_FAILED_SHAREDLIBLOADFAILED = 2;
    public static final int DETECTOR_INIT_OK = 0;

    /* renamed from: d */
    private static boolean f55738d = false;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public DetectionConfig f55739a = null;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public long f55740b = 0;

    /* renamed from: c */
    private long f55741c = 10;

    /* renamed from: e */
    private Context f55742e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public C20347e f55743f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public BlockingQueue<C20340b> f55744g;

    /* renamed from: h */
    private C20331a f55745h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public DetectionListener f55746i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public boolean f55747j = false;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public Handler f55748k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public boolean f55749l = true;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public C20341a f55750m;

    /* renamed from: n */
    private Map<String, DetectionFrame> f55751n;

    /* renamed from: o */
    private boolean f55752o = true;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public C20340b f55753p = null;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public C20340b f55754q = null;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public long f55755r = -1;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public DetectionType f55756s = DetectionType.NONE;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public ArrayList<DetectionFrame> f55757t;

    public enum DetectionFailedType {
        ACTIONBLEND,
        NOTVIDEO,
        TIMEOUT,
        MASK,
        FACENOTCONTINUOUS,
        TOOMANYFACELOST,
        FACELOSTNOTCONTINUOUS
    }

    public interface DetectionListener {
        void onDetectionFailed(DetectionFailedType detectionFailedType);

        DetectionType onDetectionSuccess(DetectionFrame detectionFrame);

        void onFrameDetected(long j, DetectionFrame detectionFrame);
    }

    /* access modifiers changed from: private */
    public native String nativeDetection(long j, int i, byte[] bArr, int i2, int i3, int i4);

    private native String nativeEncode(long j, byte[] bArr);

    private native String nativeFaceQuality(long j, byte[] bArr, int i, int i2);

    private native long nativeRawInit(Context context, byte[] bArr, String str, String str2, String str3);

    private native void nativeRelease(long j);

    /* access modifiers changed from: private */
    public native void nativeReset(long j);

    /* access modifiers changed from: private */
    public native void waitNormal(long j);

    public Detector(Context context, DetectionConfig detectionConfig) {
        if (detectionConfig == null) {
            this.f55739a = new DetectionConfig.Builder().build();
        }
        this.f55742e = context.getApplicationContext();
        this.f55739a = detectionConfig;
        this.f55740b = 0;
        this.f55747j = false;
        this.f55749l = true;
        this.f55750m = new C20341a();
        this.f55743f = new C20347e(this.f55742e);
        this.f55751n = new HashMap();
    }

    public synchronized boolean init(Context context, String str) {
        return m40157a(context, str, (byte[]) null, (String) null, (String) null) == 0;
    }

    public synchronized boolean init(Context context, byte[] bArr, String str) {
        boolean z;
        if (str != null) {
            try {
                if (str.equals("W6VLf6PitAIkKiFuVXBeTe54CSc8jB")) {
                    z = false;
                    this.f55752o = z;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        z = true;
        this.f55752o = z;
        return m40157a(context, (String) null, bArr, (String) null, (String) null) == 0;
    }

    public synchronized int init(Context context, byte[] bArr, String str, String str2) {
        boolean z;
        if (str2 != null) {
            try {
                if (str2.equals("W6VLf6PitAIkKiFuVXBeTe54CSc8jB")) {
                    z = false;
                    this.f55752o = z;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        z = true;
        this.f55752o = z;
        return m40157a(context, (String) null, bArr, str, (String) null);
    }

    public synchronized int init(Context context, byte[] bArr, String str, String str2, String str3) {
        return m40157a(context, (String) null, bArr, str, str2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00d8, code lost:
        return 1;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized int m40157a(android.content.Context r9, java.lang.String r10, byte[] r11, java.lang.String r12, java.lang.String r13) {
        /*
            r8 = this;
            monitor-enter(r8)
            r8.f55742e = r9     // Catch:{ all -> 0x00d9 }
            r0 = 1
            if (r10 != 0) goto L_0x000a
            if (r11 != 0) goto L_0x000a
            monitor-exit(r8)
            return r0
        L_0x000a:
            if (r11 != 0) goto L_0x0010
            byte[] r11 = com.megvii.livenessdetection.obf.C20343b.m40207a((java.lang.String) r10)     // Catch:{ all -> 0x00d9 }
        L_0x0010:
            r2 = r11
            if (r2 == 0) goto L_0x00d7
            java.lang.String r10 = "b3c61531d3a785d8af140218304940e5b24834d3"
            java.lang.String r11 = com.megvii.livenessdetection.obf.C20343b.m40204a((byte[]) r2)     // Catch:{ all -> 0x00d9 }
            boolean r10 = r10.equalsIgnoreCase(r11)     // Catch:{ all -> 0x00d9 }
            if (r10 != 0) goto L_0x0021
            goto L_0x00d7
        L_0x0021:
            boolean r10 = f55738d     // Catch:{ all -> 0x00d9 }
            if (r10 != 0) goto L_0x0042
            android.content.Context r10 = r9.getApplicationContext()     // Catch:{ all -> 0x00d9 }
            com.megvii.livenessdetection.obf.c r10 = com.megvii.livenessdetection.obf.C20344c.m40211a((android.content.Context) r10)     // Catch:{ all -> 0x00d9 }
            java.lang.String r11 = "livenessdetection"
            java.lang.String r0 = "v2.4.5"
            boolean r10 = r10.mo165090a((java.lang.String) r11, (java.lang.String) r0)     // Catch:{ all -> 0x00d9 }
            if (r10 != 0) goto L_0x0042
            if (r13 == 0) goto L_0x003f
            boolean r10 = com.megvii.livenessdetection.obf.C20343b.m40208b(r13)     // Catch:{ all -> 0x00d9 }
            if (r10 != 0) goto L_0x0042
        L_0x003f:
            r9 = 2
            monitor-exit(r8)
            return r9
        L_0x0042:
            com.megvii.livenessdetection.LivenessLicenseManager r10 = new com.megvii.livenessdetection.LivenessLicenseManager     // Catch:{ all -> 0x00d9 }
            android.content.Context r11 = r8.f55742e     // Catch:{ all -> 0x00d9 }
            android.content.Context r11 = r11.getApplicationContext()     // Catch:{ all -> 0x00d9 }
            r10.<init>(r11)     // Catch:{ all -> 0x00d9 }
            long r10 = r10.checkCachedLicense()     // Catch:{ all -> 0x00d9 }
            r6 = 0
            int r13 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r13 != 0) goto L_0x005a
            r9 = 4
            monitor-exit(r8)
            return r9
        L_0x005a:
            com.megvii.livenessdetection.obf.e r10 = r8.f55743f     // Catch:{ Exception -> 0x006c }
            java.lang.String r11 = "889109d126886bd98bc8f6a70d138545"
            java.lang.String r10 = r10.mo165092a(r11)     // Catch:{ Exception -> 0x006c }
            if (r10 == 0) goto L_0x0070
            int r10 = java.lang.Integer.parseInt(r10)     // Catch:{ Exception -> 0x006c }
            long r10 = (long) r10     // Catch:{ Exception -> 0x006c }
            r8.f55741c = r10     // Catch:{ Exception -> 0x006c }
            goto L_0x0070
        L_0x006c:
            r10 = 10
            r8.f55741c = r10     // Catch:{ all -> 0x00d9 }
        L_0x0070:
            r8.release()     // Catch:{ all -> 0x00d9 }
            java.util.concurrent.LinkedBlockingDeque r10 = new java.util.concurrent.LinkedBlockingDeque     // Catch:{ all -> 0x00d9 }
            r11 = 3
            r10.<init>(r11)     // Catch:{ all -> 0x00d9 }
            r8.f55744g = r10     // Catch:{ all -> 0x00d9 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d9 }
            r10.<init>()     // Catch:{ all -> 0x00d9 }
            com.megvii.livenessdetection.obf.e r13 = r8.f55743f     // Catch:{ all -> 0x00d9 }
            java.lang.String r0 = "cb072839e1e240a23baae123ca6cf165"
            java.lang.String r13 = r13.mo165092a(r0)     // Catch:{ all -> 0x00d9 }
            r10.append(r13)     // Catch:{ all -> 0x00d9 }
            java.lang.String r13 = ":"
            r10.append(r13)     // Catch:{ all -> 0x00d9 }
            com.megvii.livenessdetection.obf.e r13 = r8.f55743f     // Catch:{ all -> 0x00d9 }
            java.lang.String r0 = "e2380b201325a8f252636350338aeae8"
            java.lang.String r13 = r13.mo165092a(r0)     // Catch:{ all -> 0x00d9 }
            r10.append(r13)     // Catch:{ all -> 0x00d9 }
            java.lang.String r4 = r10.toString()     // Catch:{ all -> 0x00d9 }
            com.megvii.livenessdetection.DetectionConfig r10 = r8.f55739a     // Catch:{ all -> 0x00d9 }
            java.lang.String r5 = r10.toJsonString()     // Catch:{ all -> 0x00d9 }
            r0 = r8
            r1 = r9
            r3 = r12
            long r9 = r0.nativeRawInit(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x00d9 }
            r8.f55740b = r9     // Catch:{ all -> 0x00d9 }
            int r12 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r12 != 0) goto L_0x00b4
            monitor-exit(r8)
            return r11
        L_0x00b4:
            com.megvii.livenessdetection.Detector$a r9 = new com.megvii.livenessdetection.Detector$a     // Catch:{ all -> 0x00d9 }
            r9.<init>()     // Catch:{ all -> 0x00d9 }
            r8.f55745h = r9     // Catch:{ all -> 0x00d9 }
            r9.start()     // Catch:{ all -> 0x00d9 }
            com.megvii.livenessdetection.Detector$DetectionType r9 = com.megvii.livenessdetection.Detector.DetectionType.NONE     // Catch:{ all -> 0x00d9 }
            r8.f55756s = r9     // Catch:{ all -> 0x00d9 }
            android.os.Handler r9 = new android.os.Handler     // Catch:{ all -> 0x00d9 }
            android.os.Looper r10 = android.os.Looper.getMainLooper()     // Catch:{ all -> 0x00d9 }
            r9.<init>(r10)     // Catch:{ all -> 0x00d9 }
            r8.f55748k = r9     // Catch:{ all -> 0x00d9 }
            java.util.ArrayList r9 = new java.util.ArrayList     // Catch:{ all -> 0x00d9 }
            r9.<init>()     // Catch:{ all -> 0x00d9 }
            r8.f55757t = r9     // Catch:{ all -> 0x00d9 }
            r9 = 0
            monitor-exit(r8)
            return r9
        L_0x00d7:
            monitor-exit(r8)
            return r0
        L_0x00d9:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.megvii.livenessdetection.Detector.m40157a(android.content.Context, java.lang.String, byte[], java.lang.String, java.lang.String):int");
    }

    public synchronized void release() {
        if (this.f55745h != null) {
            this.f55745h.interrupt();
            try {
                this.f55745h.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.f55745h = null;
        }
        if (this.f55748k != null) {
            this.f55748k.removeCallbacksAndMessages((Object) null);
            this.f55748k = null;
        }
        if (this.f55744g != null) {
            this.f55744g.clear();
            this.f55744g = null;
        }
        if (this.f55757t != null) {
            this.f55757t.clear();
            this.f55757t = null;
        }
        if (this.f55740b != 0) {
            nativeRelease(this.f55740b);
        }
        this.f55740b = 0;
    }

    public void enableDebug(boolean z) {
        if (z) {
            C20346d.m40218a();
        } else {
            C20346d.m40221b();
        }
    }

    public String getLog() {
        C20341a aVar = this.f55750m;
        if (aVar == null) {
            return null;
        }
        return aVar.toString();
    }

    public DetectionType getCurDetectType() {
        return this.f55756s;
    }

    public boolean doDetection(byte[] bArr, int i, int i2, int i3) {
        DetectionType detectionType;
        if (this.f55740b == 0 || this.f55746i == null || this.f55756s == DetectionType.DONE || (detectionType = this.f55756s) == null || this.f55747j) {
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(this.f55740b != 0);
            objArr[1] = Boolean.valueOf(this.f55746i == null);
            C20346d.m40222b(String.format("detector inited:%b, detectionlistener is null:%b", objArr));
            return false;
        }
        try {
            return this.f55744g.offer(new C20340b(bArr, i, i2, i3, detectionType));
        } catch (Exception unused) {
            return false;
        }
    }

    public synchronized void setDetectionListener(DetectionListener detectionListener) {
        this.f55746i = detectionListener;
    }

    static {
        try {
            System.loadLibrary("livenessdetection_v2.4.5");
            f55738d = true;
        } catch (UnsatisfiedLinkError unused) {
            C20346d.m40222b("static load library error ");
            f55738d = false;
        }
    }

    public enum DetectionType {
        NONE(0),
        BLINK(1),
        MOUTH(2),
        POS_YAW(3),
        POS_PITCH(4),
        POS_YAW_LEFT(7),
        POS_YAW_RIGHT(8),
        DONE(6),
        POS_PITCH_UP(9),
        POS_PITCH_DOWN(10),
        AIMLESS(-1);
        
        /* access modifiers changed from: private */
        public int mInterVal;

        private DetectionType(int i) {
            this.mInterVal = -1;
            this.mInterVal = i;
        }
    }

    public synchronized void changeDetectionType(DetectionType detectionType) {
        if (this.f55740b != 0) {
            if (detectionType != null) {
                this.f55747j = false;
                this.f55756s = detectionType;
                nativeReset(this.f55740b);
                this.f55755r = System.currentTimeMillis();
                this.f55749l = true;
                this.f55750m.mo165086a(detectionType);
                return;
            }
            throw new RuntimeException("DetectionType could not be null");
        }
    }

    public synchronized void reset() {
        if (this.f55740b != 0) {
            this.f55753p = null;
            this.f55754q = null;
            this.f55757t = new ArrayList<>();
            this.f55747j = false;
            changeDetectionType(DetectionType.NONE);
            this.f55749l = true;
            this.f55750m.mo165084a();
            this.f55751n.clear();
        }
    }

    public synchronized void resetAction() {
        if (this.f55740b != 0) {
            this.f55747j = false;
            this.f55749l = true;
            changeDetectionType(this.f55756s);
        }
    }

    public synchronized ArrayList<DetectionFrame> getValidFrame() {
        if (this.f55757t == null) {
            return null;
        }
        ArrayList<DetectionFrame> arrayList = new ArrayList<>(this.f55757t);
        arrayList.add(0, this.f55753p);
        return arrayList;
    }

    /* renamed from: com.megvii.livenessdetection.Detector$a */
    class C20331a extends Thread {

        /* renamed from: b */
        private C20343b f55759b;

        public C20331a() {
            C20343b bVar = new C20343b();
            this.f55759b = bVar;
            bVar.mo165089a(true);
        }

        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
                r12 = this;
            L_0x0000:
                com.megvii.livenessdetection.Detector r0 = com.megvii.livenessdetection.Detector.this     // Catch:{ InterruptedException -> 0x01f7 }
                java.util.concurrent.BlockingQueue r0 = r0.f55744g     // Catch:{ InterruptedException -> 0x01f7 }
                java.lang.Object r0 = r0.take()     // Catch:{ InterruptedException -> 0x01f7 }
                com.megvii.livenessdetection.impl.b r0 = (com.megvii.livenessdetection.impl.C20340b) r0     // Catch:{ InterruptedException -> 0x01f7 }
                if (r0 != 0) goto L_0x000f
                goto L_0x0000
            L_0x000f:
                com.megvii.livenessdetection.Detector r1 = com.megvii.livenessdetection.Detector.this     // Catch:{ InterruptedException -> 0x01f7 }
                long r1 = r1.f55740b     // Catch:{ InterruptedException -> 0x01f7 }
                r3 = 0
                int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
                if (r5 == 0) goto L_0x0000
                com.megvii.livenessdetection.Detector r1 = com.megvii.livenessdetection.Detector.this     // Catch:{ InterruptedException -> 0x01f7 }
                com.megvii.livenessdetection.Detector$DetectionType r1 = r1.f55756s     // Catch:{ InterruptedException -> 0x01f7 }
                com.megvii.livenessdetection.Detector$DetectionType r2 = com.megvii.livenessdetection.Detector.DetectionType.DONE     // Catch:{ InterruptedException -> 0x01f7 }
                if (r1 != r2) goto L_0x0026
                goto L_0x0000
            L_0x0026:
                long r1 = java.lang.System.currentTimeMillis()     // Catch:{ InterruptedException -> 0x01f7 }
                com.megvii.livenessdetection.Detector r5 = com.megvii.livenessdetection.Detector.this     // Catch:{ InterruptedException -> 0x01f7 }
                long r5 = r5.f55755r     // Catch:{ InterruptedException -> 0x01f7 }
                com.megvii.livenessdetection.Detector r7 = com.megvii.livenessdetection.Detector.this     // Catch:{ InterruptedException -> 0x01f7 }
                com.megvii.livenessdetection.DetectionConfig r7 = r7.f55739a     // Catch:{ InterruptedException -> 0x01f7 }
                long r7 = r7.timeout     // Catch:{ InterruptedException -> 0x01f7 }
                long r5 = r5 + r7
                int r7 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
                if (r7 <= 0) goto L_0x0065
                com.megvii.livenessdetection.Detector r1 = com.megvii.livenessdetection.Detector.this     // Catch:{ InterruptedException -> 0x01f7 }
                com.megvii.livenessdetection.Detector$DetectionType r1 = r1.f55756s     // Catch:{ InterruptedException -> 0x01f7 }
                com.megvii.livenessdetection.Detector$DetectionType r2 = com.megvii.livenessdetection.Detector.DetectionType.NONE     // Catch:{ InterruptedException -> 0x01f7 }
                if (r1 == r2) goto L_0x0065
                com.megvii.livenessdetection.Detector r1 = com.megvii.livenessdetection.Detector.this     // Catch:{ InterruptedException -> 0x01f7 }
                com.megvii.livenessdetection.Detector$DetectionType r1 = r1.f55756s     // Catch:{ InterruptedException -> 0x01f7 }
                com.megvii.livenessdetection.Detector$DetectionType r2 = com.megvii.livenessdetection.Detector.DetectionType.AIMLESS     // Catch:{ InterruptedException -> 0x01f7 }
                if (r1 == r2) goto L_0x0065
                com.megvii.livenessdetection.Detector r1 = com.megvii.livenessdetection.Detector.this     // Catch:{ InterruptedException -> 0x01f7 }
                boolean r1 = r1.f55747j     // Catch:{ InterruptedException -> 0x01f7 }
                if (r1 != 0) goto L_0x0000
                com.megvii.livenessdetection.Detector r1 = com.megvii.livenessdetection.Detector.this     // Catch:{ InterruptedException -> 0x01f7 }
                com.megvii.livenessdetection.Detector$DetectionListener r1 = r1.f55746i     // Catch:{ InterruptedException -> 0x01f7 }
                com.megvii.livenessdetection.Detector$DetectionFailedType r2 = com.megvii.livenessdetection.Detector.DetectionFailedType.TIMEOUT     // Catch:{ InterruptedException -> 0x01f7 }
                r12.m40184a(r2, r1, r0)     // Catch:{ InterruptedException -> 0x01f7 }
                goto L_0x0000
            L_0x0065:
                byte[] r7 = r0.getYUVData()     // Catch:{ InterruptedException -> 0x01f7 }
                int r8 = r0.getImageWidth()     // Catch:{ InterruptedException -> 0x01f7 }
                int r9 = r0.getImageHeight()     // Catch:{ InterruptedException -> 0x01f7 }
                int r10 = r0.getRotation()     // Catch:{ InterruptedException -> 0x01f7 }
                com.megvii.livenessdetection.Detector r1 = com.megvii.livenessdetection.Detector.this     // Catch:{ InterruptedException -> 0x01f7 }
                com.megvii.livenessdetection.Detector$DetectionType r1 = r1.f55756s     // Catch:{ InterruptedException -> 0x01f7 }
                com.megvii.livenessdetection.Detector r2 = com.megvii.livenessdetection.Detector.this     // Catch:{ InterruptedException -> 0x01f7 }
                com.megvii.livenessdetection.Detector$DetectionListener r2 = r2.f55746i     // Catch:{ InterruptedException -> 0x01f7 }
                if (r1 == 0) goto L_0x0000
                com.megvii.livenessdetection.Detector r5 = com.megvii.livenessdetection.Detector.this     // Catch:{ InterruptedException -> 0x01f7 }
                long r5 = r5.f55740b     // Catch:{ InterruptedException -> 0x01f7 }
                int r11 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
                if (r11 == 0) goto L_0x0000
                if (r2 == 0) goto L_0x0000
                com.megvii.livenessdetection.Detector r3 = com.megvii.livenessdetection.Detector.this     // Catch:{ InterruptedException -> 0x01f7 }
                boolean r3 = r3.f55747j     // Catch:{ InterruptedException -> 0x01f7 }
                if (r3 == 0) goto L_0x0099
                goto L_0x0000
            L_0x0099:
                com.megvii.livenessdetection.Detector r3 = com.megvii.livenessdetection.Detector.this     // Catch:{ InterruptedException -> 0x01f7 }
                boolean r3 = r3.f55749l     // Catch:{ InterruptedException -> 0x01f7 }
                if (r3 == 0) goto L_0x00b2
                com.megvii.livenessdetection.Detector r3 = com.megvii.livenessdetection.Detector.this     // Catch:{ InterruptedException -> 0x01f7 }
                r4 = 0
                boolean unused = r3.f55749l = false     // Catch:{ InterruptedException -> 0x01f7 }
                com.megvii.livenessdetection.Detector r3 = com.megvii.livenessdetection.Detector.this     // Catch:{ InterruptedException -> 0x01f7 }
                com.megvii.livenessdetection.Detector r4 = com.megvii.livenessdetection.Detector.this     // Catch:{ InterruptedException -> 0x01f7 }
                long r4 = r4.f55740b     // Catch:{ InterruptedException -> 0x01f7 }
                r3.waitNormal(r4)     // Catch:{ InterruptedException -> 0x01f7 }
            L_0x00b2:
                com.megvii.livenessdetection.Detector r3 = com.megvii.livenessdetection.Detector.this     // Catch:{ InterruptedException -> 0x01f7 }
                com.megvii.livenessdetection.Detector r4 = com.megvii.livenessdetection.Detector.this     // Catch:{ InterruptedException -> 0x01f7 }
                long r4 = r4.f55740b     // Catch:{ InterruptedException -> 0x01f7 }
                int r6 = r1.mInterVal     // Catch:{ InterruptedException -> 0x01f7 }
                java.lang.String r3 = r3.nativeDetection(r4, r6, r7, r8, r9, r10)     // Catch:{ InterruptedException -> 0x01f7 }
                org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ Exception -> 0x01f1 }
                r4.<init>(r3)     // Catch:{ Exception -> 0x01f1 }
                com.megvii.livenessdetection.Detector r5 = com.megvii.livenessdetection.Detector.this     // Catch:{ Exception -> 0x01f1 }
                boolean r5 = r5.f55747j     // Catch:{ Exception -> 0x01f1 }
                if (r5 != 0) goto L_0x0000
                com.megvii.livenessdetection.Detector$DetectionType r5 = r0.mo165081a()     // Catch:{ Exception -> 0x01f1 }
                if (r1 == r5) goto L_0x00d7
                goto L_0x0000
            L_0x00d7:
                com.megvii.livenessdetection.Detector r5 = com.megvii.livenessdetection.Detector.this     // Catch:{ Exception -> 0x01f1 }
                com.megvii.livenessdetection.DetectionConfig r5 = r5.f55739a     // Catch:{ Exception -> 0x01f1 }
                com.megvii.livenessdetection.obf.b r6 = r12.f55759b     // Catch:{ Exception -> 0x01f1 }
                r0.mo165082a((java.lang.String) r3, (com.megvii.livenessdetection.DetectionConfig) r5, (com.megvii.livenessdetection.obf.C20343b) r6)     // Catch:{ Exception -> 0x01f1 }
                com.megvii.livenessdetection.Detector$DetectionType r3 = com.megvii.livenessdetection.Detector.DetectionType.NONE     // Catch:{ Exception -> 0x01f1 }
                if (r1 == r3) goto L_0x01dc
                com.megvii.livenessdetection.Detector$DetectionType r3 = com.megvii.livenessdetection.Detector.DetectionType.AIMLESS     // Catch:{ Exception -> 0x01f1 }
                if (r1 != r3) goto L_0x00ec
                goto L_0x01dc
            L_0x00ec:
                boolean r1 = r0.hasFace()     // Catch:{ Exception -> 0x01f1 }
                if (r1 == 0) goto L_0x00fc
                com.megvii.livenessdetection.Detector r1 = com.megvii.livenessdetection.Detector.this     // Catch:{ Exception -> 0x01f1 }
                com.megvii.livenessdetection.impl.C20340b unused = r1.f55754q = r0     // Catch:{ Exception -> 0x01f1 }
                com.megvii.livenessdetection.Detector r1 = com.megvii.livenessdetection.Detector.this     // Catch:{ Exception -> 0x01f1 }
                r1.mo165051a((com.megvii.livenessdetection.DetectionFrame) r0)     // Catch:{ Exception -> 0x01f1 }
            L_0x00fc:
                java.lang.String r1 = "result"
                int r1 = r4.getInt(r1)     // Catch:{ Exception -> 0x01f1 }
                java.lang.String r3 = "LivenessDetection"
                switch(r1) {
                    case 1: goto L_0x0195;
                    case 2: goto L_0x017d;
                    case 3: goto L_0x016d;
                    case 4: goto L_0x0166;
                    case 5: goto L_0x015f;
                    case 6: goto L_0x0142;
                    case 7: goto L_0x0125;
                    case 8: goto L_0x011e;
                    case 9: goto L_0x0117;
                    case 10: goto L_0x0110;
                    case 11: goto L_0x0109;
                    default: goto L_0x0107;
                }
            L_0x0107:
                goto L_0x0000
            L_0x0109:
                com.megvii.livenessdetection.Detector$DetectionFailedType r1 = com.megvii.livenessdetection.Detector.DetectionFailedType.FACELOSTNOTCONTINUOUS     // Catch:{ Exception -> 0x01f1 }
                r12.m40184a(r1, r2, r0)     // Catch:{ Exception -> 0x01f1 }
                goto L_0x0000
            L_0x0110:
                com.megvii.livenessdetection.Detector$DetectionFailedType r1 = com.megvii.livenessdetection.Detector.DetectionFailedType.TOOMANYFACELOST     // Catch:{ Exception -> 0x01f1 }
                r12.m40184a(r1, r2, r0)     // Catch:{ Exception -> 0x01f1 }
                goto L_0x0000
            L_0x0117:
                com.megvii.livenessdetection.Detector$DetectionFailedType r1 = com.megvii.livenessdetection.Detector.DetectionFailedType.FACENOTCONTINUOUS     // Catch:{ Exception -> 0x01f1 }
                r12.m40184a(r1, r2, r0)     // Catch:{ Exception -> 0x01f1 }
                goto L_0x0000
            L_0x011e:
                com.megvii.livenessdetection.Detector$DetectionFailedType r1 = com.megvii.livenessdetection.Detector.DetectionFailedType.MASK     // Catch:{ Exception -> 0x01f1 }
                r12.m40184a(r1, r2, r0)     // Catch:{ Exception -> 0x01f1 }
                goto L_0x0000
            L_0x0125:
                java.lang.String r1 = "is waiting for normal"
                com.megvii.livenessdetection.obf.C20346d.m40220a(r3, r1)     // Catch:{ Exception -> 0x01f1 }
                com.megvii.livenessdetection.DetectionFrame$FrameType r1 = com.megvii.livenessdetection.DetectionFrame.FrameType.WAITINGNORMAL     // Catch:{ Exception -> 0x01f1 }
                r0.setFrameType(r1)     // Catch:{ Exception -> 0x01f1 }
                r12.m40185a(r0)     // Catch:{ Exception -> 0x01f1 }
                com.megvii.livenessdetection.Detector r1 = com.megvii.livenessdetection.Detector.this     // Catch:{ Exception -> 0x01f1 }
                android.os.Handler r1 = r1.f55748k     // Catch:{ Exception -> 0x01f1 }
                com.megvii.livenessdetection.Detector$a$7 r3 = new com.megvii.livenessdetection.Detector$a$7     // Catch:{ Exception -> 0x01f1 }
                r3.<init>(r2, r0)     // Catch:{ Exception -> 0x01f1 }
                r1.post(r3)     // Catch:{ Exception -> 0x01f1 }
                goto L_0x0000
            L_0x0142:
                java.lang.String r1 = "wait for normal success"
                com.megvii.livenessdetection.obf.C20346d.m40220a(r3, r1)     // Catch:{ Exception -> 0x01f1 }
                com.megvii.livenessdetection.DetectionFrame$FrameType r1 = com.megvii.livenessdetection.DetectionFrame.FrameType.WAITINGNORMAL     // Catch:{ Exception -> 0x01f1 }
                r0.setFrameType(r1)     // Catch:{ Exception -> 0x01f1 }
                r12.m40185a(r0)     // Catch:{ Exception -> 0x01f1 }
                com.megvii.livenessdetection.Detector r1 = com.megvii.livenessdetection.Detector.this     // Catch:{ Exception -> 0x01f1 }
                android.os.Handler r1 = r1.f55748k     // Catch:{ Exception -> 0x01f1 }
                com.megvii.livenessdetection.Detector$a$6 r3 = new com.megvii.livenessdetection.Detector$a$6     // Catch:{ Exception -> 0x01f1 }
                r3.<init>(r2, r0)     // Catch:{ Exception -> 0x01f1 }
                r1.post(r3)     // Catch:{ Exception -> 0x01f1 }
                goto L_0x0000
            L_0x015f:
                com.megvii.livenessdetection.Detector$DetectionFailedType r1 = com.megvii.livenessdetection.Detector.DetectionFailedType.ACTIONBLEND     // Catch:{ Exception -> 0x01f1 }
                r12.m40184a(r1, r2, r0)     // Catch:{ Exception -> 0x01f1 }
                goto L_0x0000
            L_0x0166:
                com.megvii.livenessdetection.Detector$DetectionFailedType r1 = com.megvii.livenessdetection.Detector.DetectionFailedType.NOTVIDEO     // Catch:{ Exception -> 0x01f1 }
                r12.m40184a(r1, r2, r0)     // Catch:{ Exception -> 0x01f1 }
                goto L_0x0000
            L_0x016d:
                com.megvii.livenessdetection.Detector r1 = com.megvii.livenessdetection.Detector.this     // Catch:{ Exception -> 0x01f1 }
                android.os.Handler r1 = r1.f55748k     // Catch:{ Exception -> 0x01f1 }
                com.megvii.livenessdetection.Detector$a$5 r3 = new com.megvii.livenessdetection.Detector$a$5     // Catch:{ Exception -> 0x01f1 }
                r3.<init>(r2, r0)     // Catch:{ Exception -> 0x01f1 }
                r1.post(r3)     // Catch:{ Exception -> 0x01f1 }
                goto L_0x0000
            L_0x017d:
                com.megvii.livenessdetection.DetectionFrame$FrameType r1 = com.megvii.livenessdetection.DetectionFrame.FrameType.NONE     // Catch:{ Exception -> 0x01f1 }
                r0.setFrameType(r1)     // Catch:{ Exception -> 0x01f1 }
                r12.m40185a(r0)     // Catch:{ Exception -> 0x01f1 }
                com.megvii.livenessdetection.Detector r1 = com.megvii.livenessdetection.Detector.this     // Catch:{ Exception -> 0x01f1 }
                android.os.Handler r1 = r1.f55748k     // Catch:{ Exception -> 0x01f1 }
                com.megvii.livenessdetection.Detector$a$4 r3 = new com.megvii.livenessdetection.Detector$a$4     // Catch:{ Exception -> 0x01f1 }
                r3.<init>(r2, r0)     // Catch:{ Exception -> 0x01f1 }
                r1.post(r3)     // Catch:{ Exception -> 0x01f1 }
                goto L_0x0000
            L_0x0195:
                if (r0 == 0) goto L_0x01b2
                boolean r1 = r0.hasFace()     // Catch:{ Exception -> 0x01f1 }
                if (r1 == 0) goto L_0x01b2
                com.megvii.livenessdetection.bean.FaceInfo r1 = r0.getFaceInfo()     // Catch:{ Exception -> 0x01f1 }
                boolean r1 = r1.faceTooLarge     // Catch:{ Exception -> 0x01f1 }
                if (r1 == 0) goto L_0x01b2
                com.megvii.livenessdetection.Detector r0 = com.megvii.livenessdetection.Detector.this     // Catch:{ Exception -> 0x01f1 }
                com.megvii.livenessdetection.Detector r1 = com.megvii.livenessdetection.Detector.this     // Catch:{ Exception -> 0x01f1 }
                long r1 = r1.f55740b     // Catch:{ Exception -> 0x01f1 }
                r0.nativeReset(r1)     // Catch:{ Exception -> 0x01f1 }
                goto L_0x0000
            L_0x01b2:
                com.megvii.livenessdetection.Detector r1 = com.megvii.livenessdetection.Detector.this     // Catch:{ Exception -> 0x01f1 }
                java.util.ArrayList r1 = r1.f55757t     // Catch:{ Exception -> 0x01f1 }
                com.megvii.livenessdetection.Detector r3 = com.megvii.livenessdetection.Detector.this     // Catch:{ Exception -> 0x01f1 }
                com.megvii.livenessdetection.impl.b r3 = r3.f55754q     // Catch:{ Exception -> 0x01f1 }
                r1.add(r3)     // Catch:{ Exception -> 0x01f1 }
                com.megvii.livenessdetection.Detector r1 = com.megvii.livenessdetection.Detector.this     // Catch:{ Exception -> 0x01f1 }
                r3 = 1
                boolean unused = r1.f55747j = true     // Catch:{ Exception -> 0x01f1 }
                com.megvii.livenessdetection.DetectionFrame$FrameType r1 = com.megvii.livenessdetection.DetectionFrame.FrameType.NONE     // Catch:{ Exception -> 0x01f1 }
                r0.setFrameType(r1)     // Catch:{ Exception -> 0x01f1 }
                com.megvii.livenessdetection.Detector r1 = com.megvii.livenessdetection.Detector.this     // Catch:{ Exception -> 0x01f1 }
                android.os.Handler r1 = r1.f55748k     // Catch:{ Exception -> 0x01f1 }
                com.megvii.livenessdetection.Detector$a$3 r3 = new com.megvii.livenessdetection.Detector$a$3     // Catch:{ Exception -> 0x01f1 }
                r3.<init>(r2, r0)     // Catch:{ Exception -> 0x01f1 }
                r1.post(r3)     // Catch:{ Exception -> 0x01f1 }
                goto L_0x0000
            L_0x01dc:
                com.megvii.livenessdetection.DetectionFrame$FrameType r1 = com.megvii.livenessdetection.DetectionFrame.FrameType.NONE     // Catch:{ Exception -> 0x01f1 }
                r0.setFrameType(r1)     // Catch:{ Exception -> 0x01f1 }
                com.megvii.livenessdetection.Detector r1 = com.megvii.livenessdetection.Detector.this     // Catch:{ Exception -> 0x01f1 }
                android.os.Handler r1 = r1.f55748k     // Catch:{ Exception -> 0x01f1 }
                com.megvii.livenessdetection.Detector$a$2 r3 = new com.megvii.livenessdetection.Detector$a$2     // Catch:{ Exception -> 0x01f1 }
                r3.<init>(r2, r0)     // Catch:{ Exception -> 0x01f1 }
                r1.post(r3)     // Catch:{ Exception -> 0x01f1 }
                goto L_0x0000
            L_0x01f1:
                r0 = move-exception
                r0.printStackTrace()     // Catch:{ InterruptedException -> 0x01f7 }
                goto L_0x0000
            L_0x01f7:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.megvii.livenessdetection.Detector.C20331a.run():void");
        }

        /* renamed from: a */
        private void m40184a(final DetectionFailedType detectionFailedType, final DetectionListener detectionListener, final DetectionFrame detectionFrame) {
            Detector.this.f55750m.mo165085a(detectionFailedType);
            if (!(Detector.this.f55750m == null || Detector.this.f55743f == null)) {
                Detector.m40177j(Detector.this);
            }
            boolean unused = Detector.this.f55747j = true;
            Detector.this.f55748k.post(new Runnable() {
                public final void run() {
                    detectionListener.onFrameDetected((Detector.this.f55755r + Detector.this.f55739a.timeout) - System.currentTimeMillis(), detectionFrame);
                    detectionListener.onDetectionFailed(detectionFailedType);
                }
            });
        }

        /* renamed from: a */
        private void m40185a(C20340b bVar) {
            if (Detector.this.f55753p == null) {
                C20340b unused = Detector.this.f55753p = bVar;
            }
            if (bVar.mo165083a(Detector.this.f55753p)) {
                C20340b unused2 = Detector.this.f55753p = bVar;
            }
        }
    }

    public synchronized DetectionFrame faceQualityDetection(Bitmap bitmap) {
        C20339a aVar = new C20339a(bitmap);
        byte[] a = aVar.mo165080a();
        int imageWidth = aVar.getImageWidth();
        int imageHeight = aVar.getImageHeight();
        if (!(a == null || imageWidth == -1)) {
            if (imageHeight != -1) {
                aVar.mo165079a(nativeFaceQuality(this.f55740b, a, imageWidth, imageHeight), this.f55739a, new C20343b());
                return aVar;
            }
        }
        return null;
    }

    public static String getVersion() {
        return new String("MegLive 2.4.5-3A");
    }

    public FaceIDDataStruct getFaceIDDataStruct(int i) {
        JSONObject jSONObject = new JSONObject();
        FaceIDDataStruct faceIDDataStruct = new FaceIDDataStruct();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        C20340b bVar = this.f55753p;
        try {
            jSONObject2.put("image_best", m40162a((DetectionFrame) bVar, i, "image_best", faceIDDataStruct, true));
            if (this.f55757t != null) {
                int i2 = 0;
                while (i2 < this.f55757t.size()) {
                    StringBuilder sb = new StringBuilder("image_action");
                    int i3 = i2 + 1;
                    sb.append(i3);
                    String sb2 = sb.toString();
                    jSONObject2.put(sb2, m40162a(this.f55757t.get(i2), i, "image_action" + i3, faceIDDataStruct, true));
                    i2 = i3;
                }
            }
            if (this.f55751n != null) {
                for (Map.Entry next : this.f55751n.entrySet()) {
                    JSONObject b = m40167b((DetectionFrame) next.getValue());
                    if (b != null) {
                        jSONObject3.put((String) next.getKey(), b);
                    }
                }
            }
            jSONObject2.put("image_env", m40162a((DetectionFrame) bVar, i, "image_env", faceIDDataStruct, false));
            jSONObject.put("images", jSONObject2);
            jSONObject.put("snapshot", jSONObject3);
            jSONObject.put("datetime", new SimpleDateFormat("yyyyMMddHHmmss", Locale.getDefault()).format(new Date()));
            jSONObject.put("sdk_version", getVersion());
            jSONObject.put("user_info", C20343b.m40205a());
            jSONObject.put("log", getLog());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        faceIDDataStruct.delta = nativeEncode(this.f55740b, jSONObject.toString().getBytes());
        return faceIDDataStruct;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo165051a(DetectionFrame detectionFrame) {
        DetectionFrame detectionFrame2;
        DetectionFrame detectionFrame3;
        DetectionFrame detectionFrame4;
        DetectionFrame detectionFrame5;
        if (detectionFrame != null && detectionFrame.hasFace()) {
            if (((double) Math.abs(detectionFrame.getFaceInfo().yaw)) >= 0.167d && ((detectionFrame5 = this.f55751n.get("yaw")) == null || detectionFrame5.getFaceInfo() == null || detectionFrame5.getFaceInfo().smoothQuality < detectionFrame.getFaceInfo().smoothQuality)) {
                this.f55751n.put("yaw", detectionFrame);
            }
            if (((double) Math.abs(detectionFrame.getFaceInfo().pitch)) >= 0.111d && ((detectionFrame4 = this.f55751n.get("pitch")) == null || detectionFrame4.getFaceInfo() == null || detectionFrame4.getFaceInfo().smoothQuality < detectionFrame.getFaceInfo().smoothQuality)) {
                this.f55751n.put("pitch", detectionFrame);
            }
            if (Math.abs(detectionFrame.getFaceInfo().mouthHWRatio) >= 0.2f && ((detectionFrame3 = this.f55751n.get("mouth")) == null || detectionFrame3.getFaceInfo() == null || detectionFrame3.getFaceInfo().smoothQuality < detectionFrame.getFaceInfo().smoothQuality)) {
                this.f55751n.put("mouth", detectionFrame);
            }
            if (Math.abs(detectionFrame.getFaceInfo().leftEyeHWRatio) <= 0.3f && Math.abs(detectionFrame.getFaceInfo().rightEyeHWRatio) <= 0.3f && ((detectionFrame2 = this.f55751n.get("eye")) == null || detectionFrame2.getFaceInfo() == null || detectionFrame2.getFaceInfo().smoothQuality < detectionFrame.getFaceInfo().smoothQuality)) {
                this.f55751n.put("eye", detectionFrame);
            }
            if (this.f55752o) {
                DetectionFrame detectionFrame6 = this.f55751n.get(OptionsBridge.MAX_PITCH_KEY);
                if (detectionFrame6 == null || detectionFrame6.getFaceInfo() == null || Math.abs(detectionFrame6.getFaceInfo().pitch) < Math.abs(detectionFrame.getFaceInfo().pitch)) {
                    if (((double) Math.abs(detectionFrame.getFaceInfo().pitch)) > 0.2d) {
                        RectF rectF = detectionFrame.getFaceInfo().position;
                        float width = rectF.width();
                        float height = rectF.height();
                        float f = width / 10.0f;
                        rectF.left -= f;
                        rectF.right += f;
                        float f2 = height / 10.0f;
                        rectF.top -= f2;
                        rectF.bottom += f2;
                    }
                    this.f55751n.put(OptionsBridge.MAX_PITCH_KEY, detectionFrame);
                }
                DetectionFrame detectionFrame7 = this.f55751n.get(OptionsBridge.MAX_YAW_KEY);
                if (detectionFrame7 == null || detectionFrame7.getFaceInfo() == null || Math.abs(detectionFrame7.getFaceInfo().yaw) < Math.abs(detectionFrame.getFaceInfo().yaw)) {
                    if (((double) Math.abs(detectionFrame.getFaceInfo().yaw)) > 0.2d) {
                        RectF rectF2 = detectionFrame.getFaceInfo().position;
                        float width2 = rectF2.width();
                        float height2 = rectF2.height();
                        float f3 = width2 / 10.0f;
                        rectF2.left -= f3;
                        rectF2.right += f3;
                        float f4 = height2 / 10.0f;
                        rectF2.top -= f4;
                        rectF2.bottom += f4;
                    }
                    this.f55751n.put(OptionsBridge.MAX_YAW_KEY, detectionFrame);
                }
            }
        }
    }

    public FaceIDDataStruct getFaceIDDataStruct() {
        return getFaceIDDataStruct(-1);
    }

    /* renamed from: b */
    private static JSONObject m40167b(DetectionFrame detectionFrame) {
        if (detectionFrame != null && detectionFrame.hasFace()) {
            Rect rect = new Rect();
            byte[] imageData = detectionFrame.getImageData(rect, true, 90, 150, false, false, 0);
            if (imageData == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("image", Base64.encodeToString(imageData, 2));
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(rect.left);
                jSONArray.put(rect.top);
                jSONArray.put(rect.right);
                jSONArray.put(rect.bottom);
                jSONObject.put("rect", jSONArray);
                jSONObject.put("smooth_quality", (double) detectionFrame.getFaceInfo().smoothQuality);
                jSONObject.put(CollectionConstant.APOLLO_PARAM_QUALITY, (double) detectionFrame.getFaceInfo().faceQuality);
                return jSONObject;
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    /* renamed from: a */
    private static JSONObject m40162a(DetectionFrame detectionFrame, int i, String str, FaceIDDataStruct faceIDDataStruct, boolean z) {
        byte[] bArr;
        if (detectionFrame == null || !detectionFrame.hasFace()) {
            return null;
        }
        Rect rect = new Rect();
        if (!z) {
            FaceInfo faceInfo = detectionFrame.getFaceInfo();
            bArr = detectionFrame.getImageData(rect, false, 70, (int) (150.0f / Math.min(faceInfo.position.width(), faceInfo.position.height())), false, false, 0);
        } else {
            bArr = detectionFrame.getImageData(rect, true, 70, i, false, false, 0);
        }
        if (bArr == null) {
            return null;
        }
        faceIDDataStruct.images.put(str, bArr);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(CollectionConstant.APOLLO_PARAM_QUALITY, (double) detectionFrame.getFaceInfo().faceQuality);
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(rect.left);
            jSONArray.put(rect.top);
            jSONArray.put(rect.right);
            jSONArray.put(rect.bottom);
            jSONObject.put("rect", jSONArray);
            jSONObject.put("checksum", C20343b.m40204a(bArr));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* renamed from: j */
    static /* synthetic */ void m40177j(Detector detector) {
        JSONArray jSONArray;
        if (detector.f55750m != null) {
            try {
                jSONArray = new JSONArray(detector.f55743f.mo165094b("8cd0604ba33e2ba7f38a56f0aec08a54"));
            } catch (Exception unused) {
                jSONArray = new JSONArray();
            }
            jSONArray.put(detector.f55750m.toString());
            if (((long) jSONArray.length()) > detector.f55741c) {
                JSONArray jSONArray2 = new JSONArray();
                for (int i = 1; i < jSONArray.length(); i++) {
                    try {
                        jSONArray2.put(jSONArray.get(i));
                    } catch (JSONException unused2) {
                    }
                }
                jSONArray = jSONArray2;
            }
            detector.f55743f.mo165093a("8cd0604ba33e2ba7f38a56f0aec08a54", jSONArray.toString());
        }
    }
}
