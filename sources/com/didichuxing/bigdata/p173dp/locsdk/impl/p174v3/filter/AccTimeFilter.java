package com.didichuxing.bigdata.p173dp.locsdk.impl.p174v3.filter;

import android.content.Context;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p173dp.locsdk.DLog;
import com.didichuxing.bigdata.p173dp.locsdk.OSLocationWrapper;
import com.didichuxing.bigdata.p173dp.locsdk.trace.data.ETraceSource;
import com.didichuxing.bigdata.p173dp.locsdk.utils.Utils;
import java.util.ArrayList;
import java.util.Collections;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.impl.v3.filter.AccTimeFilter */
public class AccTimeFilter {

    /* renamed from: a */
    private static final String f45934a = "AccTimeFilter| ";

    /* renamed from: A */
    private float f45935A = 1.0f;

    /* renamed from: b */
    private IAccTimeTracker f45936b;

    /* renamed from: c */
    private String f45937c = "";

    /* renamed from: d */
    private DIDILocation f45938d;

    /* renamed from: e */
    private DIDILocation f45939e;

    /* renamed from: f */
    private DIDILocation f45940f;

    /* renamed from: g */
    private OSLocationWrapper f45941g;

    /* renamed from: h */
    private DIDILocation f45942h;

    /* renamed from: i */
    private float f45943i = 0.0f;

    /* renamed from: j */
    private float f45944j = 0.0f;

    /* renamed from: k */
    private float f45945k = 0.0f;

    /* renamed from: l */
    private float f45946l = 0.0f;

    /* renamed from: m */
    private float f45947m = 0.0f;

    /* renamed from: n */
    private float f45948n = 0.0f;

    /* renamed from: o */
    private float f45949o = 0.0f;

    /* renamed from: p */
    private float f45950p = 0.0f;

    /* renamed from: q */
    private float f45951q = 0.0f;

    /* renamed from: r */
    private float f45952r = 0.0f;

    /* renamed from: s */
    private float f45953s = 0.0f;

    /* renamed from: t */
    private float f45954t = 0.0f;

    /* renamed from: u */
    private float f45955u = 0.0f;

    /* renamed from: v */
    private float f45956v = 0.0f;

    /* renamed from: w */
    private long f45957w = 1;

    /* renamed from: x */
    private boolean f45958x = false;

    /* renamed from: y */
    private float f45959y = 0.0f;

    /* renamed from: z */
    private float f45960z = 1.0f;

    /* renamed from: a */
    private long m32987a(long j, long j2) {
        int i;
        if (j == 0 || j2 == 0 || j < j2) {
            return -1;
        }
        if (i == 0) {
            return 1;
        }
        return j - j2;
    }

    /* renamed from: a */
    private String m32989a(int i) {
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? "unknown" : "lastgps" : "nlp" : "gps" : "flp";
    }

    public AccTimeFilter(Context context) {
        this.f45936b = new AccTimeTracker(context);
    }

    public DIDILocation getTargetLocation(DIDILocation dIDILocation, OSLocationWrapper oSLocationWrapper, DIDILocation dIDILocation2, DIDILocation dIDILocation3) {
        try {
            this.f45939e = dIDILocation;
            this.f45941g = oSLocationWrapper;
            this.f45940f = dIDILocation2;
            this.f45942h = dIDILocation3;
            this.f45937c = "unknown";
            this.f45938d = m32988a();
            if (this.f45936b != null) {
                this.f45936b.startTracking();
                this.f45936b.updateNotifiedLocation(this.f45938d, this.f45937c);
            }
            return this.f45938d;
        } catch (Exception e) {
            DLog.m32737d("AccTimeFilter| exp: " + e.getLocalizedMessage());
            return null;
        }
    }

    /* renamed from: a */
    private DIDILocation m32988a() {
        m32990b();
        m32991c();
        m32992d();
        m32993e();
        m32994f();
        return m32995g();
    }

    /* renamed from: b */
    private void m32990b() {
        this.f45945k = AccTimeFilterHelper.getInstance().f45962a;
        this.f45946l = AccTimeFilterHelper.getInstance().f45963b;
        this.f45947m = AccTimeFilterHelper.getInstance().f45964c;
        this.f45948n = AccTimeFilterHelper.getInstance().f45965d;
        this.f45959y = AccTimeFilterHelper.getInstance().f45968g;
        this.f45960z = AccTimeFilterHelper.getInstance().f45966e;
        this.f45935A = AccTimeFilterHelper.getInstance().f45967f;
        this.f45943i = 0.0f;
        this.f45944j = 0.0f;
        this.f45949o = 0.0f;
        this.f45950p = 0.0f;
        this.f45951q = 0.0f;
        this.f45952r = 0.0f;
        this.f45953s = 0.0f;
        this.f45954t = 0.0f;
        this.f45955u = 0.0f;
        this.f45956v = 0.0f;
        this.f45958x = false;
    }

    /* renamed from: c */
    private void m32991c() {
        this.f45957w = System.currentTimeMillis();
        DIDILocation dIDILocation = this.f45939e;
        if (dIDILocation != null) {
            if (dIDILocation.getAccuracy() > 0.0f) {
                this.f45943i += 1.0f / this.f45939e.getAccuracy();
            }
            long a = m32987a(this.f45957w, this.f45939e.getLocalTime());
            if (a > 0) {
                this.f45944j += 1.0f / ((float) a);
            }
        }
        DIDILocation dIDILocation2 = this.f45940f;
        if (dIDILocation2 != null) {
            if (dIDILocation2.getAccuracy() > 0.0f) {
                this.f45943i += 1.0f / this.f45940f.getAccuracy();
            }
            long a2 = m32987a(this.f45957w, this.f45940f.getLocalTime());
            if (a2 > 0) {
                this.f45944j += 1.0f / ((float) a2);
            }
        }
        OSLocationWrapper oSLocationWrapper = this.f45941g;
        if (!(oSLocationWrapper == null || oSLocationWrapper.getLocation() == null)) {
            if (this.f45941g.getLocation().getAccuracy() > 0.0f) {
                this.f45943i += 1.0f / this.f45941g.getLocation().getAccuracy();
            }
            long a3 = m32987a(this.f45957w, this.f45941g.getLocalTime());
            if (a3 > 0) {
                this.f45944j += 1.0f / ((float) a3);
            }
        }
        DIDILocation dIDILocation3 = this.f45942h;
        if (dIDILocation3 != null) {
            if (dIDILocation3.getAccuracy() > 0.0f) {
                this.f45943i += 1.0f / this.f45942h.getAccuracy();
            }
            long a4 = m32987a(this.f45957w, this.f45942h.getLocalTime());
            if (a4 > 0) {
                this.f45944j += 1.0f / ((float) a4);
            }
        }
    }

    /* renamed from: d */
    private void m32992d() {
        if (this.f45944j != 0.0f) {
            DIDILocation dIDILocation = this.f45939e;
            if (dIDILocation != null && dIDILocation.getAccuracy() > 0.0f) {
                this.f45949o = (1.0f / this.f45939e.getAccuracy()) / this.f45943i;
            }
            DIDILocation dIDILocation2 = this.f45940f;
            if (dIDILocation2 != null && dIDILocation2.getAccuracy() > 0.0f) {
                this.f45950p = (1.0f / this.f45940f.getAccuracy()) / this.f45943i;
            }
            OSLocationWrapper oSLocationWrapper = this.f45941g;
            if (!(oSLocationWrapper == null || oSLocationWrapper.getLocation() == null || this.f45941g.getLocation().getAccuracy() <= 0.0f)) {
                this.f45951q = (1.0f / this.f45941g.getLocation().getAccuracy()) / this.f45943i;
            }
            DIDILocation dIDILocation3 = this.f45942h;
            if (dIDILocation3 != null && dIDILocation3.getAccuracy() > 0.0f) {
                this.f45952r = (1.0f / this.f45942h.getAccuracy()) / this.f45943i;
            }
        }
    }

    /* renamed from: e */
    private void m32993e() {
        if (this.f45944j != 0.0f) {
            DIDILocation dIDILocation = this.f45939e;
            if (dIDILocation != null) {
                long a = m32987a(this.f45957w, dIDILocation.getLocalTime());
                if (a > 0) {
                    this.f45953s = (1.0f / ((float) a)) / this.f45944j;
                }
            }
            DIDILocation dIDILocation2 = this.f45940f;
            if (dIDILocation2 != null) {
                long a2 = m32987a(this.f45957w, dIDILocation2.getLocalTime());
                if (a2 > 0) {
                    this.f45954t = (1.0f / ((float) a2)) / this.f45944j;
                }
            }
            OSLocationWrapper oSLocationWrapper = this.f45941g;
            if (oSLocationWrapper != null) {
                long a3 = m32987a(this.f45957w, oSLocationWrapper.getLocalTime());
                if (a3 > 0) {
                    this.f45955u = (1.0f / ((float) a3)) / this.f45944j;
                }
            }
            DIDILocation dIDILocation3 = this.f45942h;
            if (dIDILocation3 != null) {
                long a4 = m32987a(this.f45957w, dIDILocation3.getLocalTime());
                if (a4 > 0) {
                    this.f45956v = (1.0f / ((float) a4)) / this.f45944j;
                }
            }
        }
    }

    /* renamed from: f */
    private void m32994f() {
        this.f45958x = AccTimeFilterHelper.getInstance().isFewSatellite();
    }

    /* renamed from: g */
    private DIDILocation m32995g() {
        float f = this.f45945k;
        float f2 = this.f45949o;
        float f3 = this.f45960z;
        float f4 = f + (f2 * f3);
        float f5 = this.f45953s;
        float f6 = this.f45935A;
        this.f45945k = f4 + (f5 * f6);
        this.f45946l = this.f45946l + (this.f45950p * f3) + (this.f45954t * f6);
        this.f45947m = this.f45947m + (this.f45951q * f3) + (this.f45955u * f6);
        this.f45948n = this.f45948n + (this.f45952r * f3) + (this.f45956v * f6);
        float f7 = 0.0f;
        if (this.f45939e == null) {
            this.f45945k = 0.0f;
        }
        if (this.f45940f == null) {
            this.f45946l = 0.0f;
        }
        if (this.f45941g == null) {
            this.f45947m = 0.0f;
        }
        if (this.f45942h == null) {
            this.f45948n = 0.0f;
        }
        float f8 = this.f45945k;
        float f9 = this.f45946l;
        if (f8 == f9) {
            float f10 = this.f45947m;
            if (f9 == f10 && f10 == this.f45948n) {
                DIDILocation dIDILocation = this.f45939e;
                if (dIDILocation != null) {
                    this.f45937c = "flp";
                    return dIDILocation;
                }
                DIDILocation dIDILocation2 = this.f45940f;
                if (dIDILocation2 != null) {
                    this.f45937c = "gps";
                    return dIDILocation2;
                }
                OSLocationWrapper oSLocationWrapper = this.f45941g;
                if (oSLocationWrapper != null) {
                    this.f45937c = "nlp";
                    return DIDILocation.loadFromSystemLoc(oSLocationWrapper, ETraceSource.nlp, Utils.getCoordinateType());
                }
                DIDILocation dIDILocation3 = this.f45942h;
                if (dIDILocation3 != null) {
                    this.f45937c = "lastgps";
                    return dIDILocation3;
                }
                DLog.m32737d("AccTimeFilter| all null");
                return null;
            }
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new LocType(1, this.f45945k));
        float f11 = this.f45946l - this.f45959y;
        if (f11 < 0.0f) {
            f11 = 0.0f;
        }
        if (!this.f45958x) {
            f11 = this.f45946l;
        }
        arrayList.add(new LocType(2, f11));
        arrayList.add(new LocType(3, this.f45947m));
        float f12 = this.f45948n - this.f45959y;
        if (f12 >= 0.0f) {
            f7 = f12;
        }
        if (!this.f45958x) {
            f7 = this.f45948n;
        }
        arrayList.add(new LocType(4, f7));
        Collections.sort(arrayList, $$Lambda$AccTimeFilter$VETMnhGHp2BiRW50ZvNHzCehoAQ.INSTANCE);
        int i = ((LocType) arrayList.get(0)).type;
        this.f45937c = m32989a(i);
        if (i == 1) {
            return this.f45939e;
        }
        if (i == 2) {
            return this.f45940f;
        }
        if (i == 3) {
            return DIDILocation.loadFromSystemLoc(this.f45941g, ETraceSource.nlp, Utils.getCoordinateType());
        }
        if (i != 4) {
            return null;
        }
        return this.f45942h;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ int m32986a(LocType locType, LocType locType2) {
        return (int) ((locType2.score * 100000.0f) - (locType.score * 100000.0f));
    }

    /* renamed from: com.didichuxing.bigdata.dp.locsdk.impl.v3.filter.AccTimeFilter$LocType */
    private static class LocType {
        static final int flp = 1;
        static final int gps = 2;
        static final int last_gps = 4;
        static final int os_nlp = 3;
        float score;
        int type;

        LocType(int i, float f) {
            this.type = i;
            this.score = f;
        }
    }

    /* renamed from: h */
    private void m32996h() {
        DLog.m32737d("AccTimeFilter| 以下为此次参与对比的位置信息");
        if (this.f45939e != null) {
            DLog.m32737d("AccTimeFilter| info flp: " + this.f45939e.toString());
        }
        if (this.f45940f != null) {
            DLog.m32737d("AccTimeFilter| info gps: " + this.f45940f.toString());
        }
        if (this.f45941g != null) {
            DLog.m32737d("AccTimeFilter| info nlp: " + this.f45941g.info());
        }
        if (this.f45942h != null) {
            DLog.m32737d("AccTimeFilter| info last gps: " + this.f45942h.toString());
        }
    }

    public void destroy() {
        this.f45937c = "unknown";
        this.f45938d = null;
        IAccTimeTracker iAccTimeTracker = this.f45936b;
        if (iAccTimeTracker != null) {
            iAccTimeTracker.stopTracking();
        }
    }
}
