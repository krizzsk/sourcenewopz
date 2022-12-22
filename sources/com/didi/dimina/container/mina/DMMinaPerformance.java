package com.didi.dimina.container.mina;

import android.app.ActivityManager;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.Dimina;
import com.didi.dimina.container.bean.Constant;
import com.didi.dimina.container.page.DMPage;
import com.didi.dimina.container.util.HttpUtil;
import com.didi.dimina.container.util.JSONUtil;
import com.didi.dimina.container.util.TraceUtil;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public class DMMinaPerformance {

    /* renamed from: a */
    private static final long f16897a = -1;

    /* renamed from: b */
    private static final long f16898b = 0;

    /* renamed from: A */
    private long f16899A = -1;

    /* renamed from: B */
    private long f16900B = -1;

    /* renamed from: C */
    private long f16901C = -1;

    /* renamed from: D */
    private long f16902D = -1;

    /* renamed from: E */
    private long f16903E;

    /* renamed from: F */
    private long f16904F;

    /* renamed from: G */
    private boolean f16905G = false;

    /* renamed from: H */
    private long f16906H = -1;

    /* renamed from: I */
    private long f16907I = -1;

    /* renamed from: J */
    private volatile DMMinaPerfStorage f16908J;

    /* renamed from: K */
    private DMMinaPerfRender f16909K;

    /* renamed from: c */
    private final DMMina f16910c;

    /* renamed from: d */
    private long f16911d = -1;

    /* renamed from: e */
    private long f16912e = -1;

    /* renamed from: f */
    private long f16913f = -1;

    /* renamed from: g */
    private long f16914g = -1;

    /* renamed from: h */
    private long f16915h = -1;

    /* renamed from: i */
    private long f16916i = -1;

    /* renamed from: j */
    private long f16917j = -1;

    /* renamed from: k */
    private long f16918k = -1;

    /* renamed from: l */
    private long f16919l = -1;

    /* renamed from: m */
    private long f16920m = -1;

    /* renamed from: n */
    private long f16921n = -1;

    /* renamed from: o */
    private long f16922o = -1;

    /* renamed from: p */
    private long f16923p = -1;

    /* renamed from: q */
    private long f16924q = -1;

    /* renamed from: r */
    private long f16925r = -1;

    /* renamed from: s */
    private long f16926s = -1;

    /* renamed from: t */
    private long f16927t = -1;

    /* renamed from: u */
    private long f16928u = 0;

    /* renamed from: v */
    private int f16929v = 0;

    /* renamed from: w */
    private long f16930w = 0;

    /* renamed from: x */
    private long f16931x = 0;

    /* renamed from: y */
    private long f16932y = 0;

    /* renamed from: z */
    private long f16933z = -1;

    public DMMinaPerformance(DMMina dMMina) {
        this.f16910c = dMMina;
    }

    /* renamed from: a */
    private long m12508a() {
        return TimeUnit.NANOSECONDS.toMillis(System.nanoTime());
    }

    public void markJSEnginePreload() {
        this.f16911d = m12508a();
    }

    public void appendStartSubPackageLoadTime(long j) {
        if (!this.f16905G) {
            this.f16931x += j;
        }
    }

    public void appendStartSubPackageLoadExec(long j) {
        if (!this.f16905G) {
            this.f16932y += j;
        }
    }

    public long getSubStartPackageLoadTime() {
        return this.f16931x;
    }

    public long getSubStartPackageLoadExec() {
        return this.f16932y;
    }

    public void markJSEngineReady() {
        this.f16912e = m12508a();
    }

    public void markWebViewOpenFirst() {
        this.f16913f = m12508a();
    }

    public void markWebViewOpen() {
        this.f16914g = m12508a();
        this.f16928u++;
    }

    public void markJSDefinedAppStart() {
        this.f16917j = m12508a();
    }

    public void markJSDefinedAppEnd() {
        this.f16918k = m12508a();
    }

    public void markJSDefinedDmStart() {
        this.f16919l = m12508a();
    }

    public void markJSDefinedDmEnd() {
        this.f16920m = m12508a();
    }

    public void markJSRequireStart() {
        this.f16921n = m12508a();
    }

    public void markLaunchEntryBackground() {
        this.f16929v = 1;
    }

    public void markForceUpdate() {
        this.f16933z = 1;
    }

    public void markNotForceUpdate() {
        this.f16933z = -1;
    }

    public void markJSRequireEnd() {
        this.f16922o = m12508a();
    }

    public void markJSPackageStart() {
        this.f16923p = m12508a();
    }

    public long getMarkJSPackageStart() {
        return this.f16923p;
    }

    public void markJSPackageEnd() {
        this.f16924q = m12508a();
    }

    public void markWinDone() {
        if (!this.f16905G) {
            TraceUtil.trackEventCoreDotting(this.f16910c.getMinaIndex(), Constant.CORE_DOTTING.PAGE_FIRST_INVOKE_PARAMS_TO_WIN_DONE, "");
        }
        this.f16926s = m12508a();
    }

    public void markAppLaunch() {
        this.f16915h = m12508a();
        this.f16905G = false;
        this.f16925r = m12510b();
        TraceUtil.trackAppOpenRateStart(this.f16910c.getMinaIndex());
    }

    public void markNativeJsReady() {
        this.f16916i = m12508a();
        this.f16930w = System.currentTimeMillis();
    }

    public void markDmServiceExecuteStart() {
        this.f16899A = m12508a();
    }

    public void markDmServiceExecuteEnd() {
        this.f16900B = m12508a();
    }

    public void markAppServiceExecuteStart() {
        this.f16901C = m12508a();
        m12512c();
    }

    public void markAppServiceExecuteEnd() {
        this.f16902D = m12508a();
        m12512c();
    }

    public void setRemoteInstallStartTime() {
        this.f16906H = m12508a();
    }

    public void setRemoteInstallEndTime() {
        this.f16907I = m12508a();
    }

    public void markNativeJSBusinessReady() {
        this.f16927t = m12508a();
    }

    public void markDOMReady(DMPage dMPage) {
        if (!this.f16905G) {
            this.f16905G = true;
            m12511b(dMPage);
            TraceUtil.trackEventCoreDotting(this.f16910c.getMinaIndex(), Constant.CORE_DOTTING.DIMINA_PAGE_FIRST_DOM_READY, "onlaunch");
            m12513c(dMPage);
            return;
        }
        m12509a(dMPage);
        DMLaunchLifecycleManager.getInstance().hookPageDomReady(this.f16910c, dMPage);
    }

    public boolean isFirstDomReady() {
        return this.f16905G;
    }

    /* renamed from: a */
    private void m12509a(DMPage dMPage) {
        if (this.f16914g != -1) {
            try {
                this.f16903E = m12511b(dMPage);
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.f16914g = -1;
        }
    }

    public void traceInteractionTime(String str) {
        TraceUtil.traceInteractionTime(this.f16910c.getMinaIndex(), m12508a() - this.f16914g, str);
    }

    /* renamed from: b */
    private long m12511b(DMPage dMPage) {
        long a = m12508a();
        long j = a - this.f16914g;
        if (this.f16915h != -1) {
            TimeUnit.MILLISECONDS.toSeconds(a - this.f16915h);
        }
        if (dMPage != null) {
            String url = dMPage.getUrl();
            HttpUtil.splitPath(url);
            JSONUtil.combineJson(JSONUtil.toJSONObject(dMPage.getNavigateConfig().query), HttpUtil.parseUrlQueryJSONObject(this.f16910c.getConfig().getLaunchConfig().getAppId(), url));
        }
        return j;
    }

    /* renamed from: c */
    private void m12513c(DMPage dMPage) {
        long j;
        long j2;
        DMPage dMPage2 = dMPage;
        long a = m12508a();
        String str = "";
        if (dMPage2 != null) {
            try {
                str = HttpUtil.splitPath(dMPage.getUrl());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        JSONObject combineJson = JSONUtil.combineJson(HttpUtil.parseUrlQueryJSONObject(this.f16910c.getConfig().getLaunchConfig().getAppId(), str), this.f16910c.getConfig().getLaunchConfig().getExtraOptions());
        JSONObject jSONObject = new JSONObject();
        JSONUtil.put(jSONObject, "openType", (Object) "appLaunch");
        JSONUtil.put(jSONObject, "url", (Object) str);
        JSONUtil.put(jSONObject, "query", (Object) combineJson.toString());
        long j3 = this.f16915h != -1 ? a - this.f16915h : 0;
        if (this.f16912e != -1) {
            int i = (this.f16911d > -1 ? 1 : (this.f16911d == -1 ? 0 : -1));
        }
        long j4 = this.f16913f != -1 ? a - this.f16913f : 0;
        long j5 = (this.f16918k == -1 || this.f16917j == -1) ? 0 : this.f16918k - this.f16917j;
        long j6 = (this.f16920m == -1 || this.f16919l == -1) ? 0 : this.f16920m - this.f16919l;
        if (this.f16922o == -1 || this.f16921n == -1) {
            j2 = j6;
            j = 0;
        } else {
            j2 = j6;
            j = this.f16922o - this.f16921n;
        }
        long j7 = (this.f16924q == -1 || this.f16923p == -1) ? 0 : this.f16924q - this.f16923p;
        long j8 = this.f16926s != -1 ? a - this.f16926s : 0;
        this.f16903E = j4;
        this.f16904F = j3;
        TraceUtil.trackEventLaunchPerformance2(this.f16910c.getMinaIndex(), j2 + j5, j, j7, j8, this.f16929v);
        m12510b();
        TraceUtil.trackAppOpenRateEnd(this.f16910c.getMinaIndex(), 1, this.f16907I - this.f16906H, m12514d(), j4, m12508a() - this.f16915h, DMMinaHelper.getCurPath(this.f16910c), "0", "");
        DMLaunchLifecycleManager.getInstance().hookFirstPageDomReady(this.f16910c, dMPage2);
        this.f16911d = -1;
        this.f16912e = -1;
        this.f16913f = -1;
        this.f16916i = -1;
        this.f16927t = -1;
        this.f16929v = 0;
        this.f16899A = -1;
        this.f16900B = -1;
        this.f16901C = -1;
        this.f16902D = -1;
        this.f16906H = -1;
        this.f16907I = -1;
    }

    public void markLaunchFail(int i, String str) {
        int minaIndex = this.f16910c.getMinaIndex();
        String curPath = DMMinaHelper.getCurPath(this.f16910c);
        TraceUtil.trackAppOpenRateEnd(minaIndex, -1, 0, 0, 0, 0, curPath, "" + i, str);
    }

    /* renamed from: b */
    private long m12510b() {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) Dimina.getConfig().getApp().getSystemService("activity")).getMemoryInfo(memoryInfo);
        return memoryInfo.availMem / 1048576;
    }

    public long getLaunchTime() {
        return this.f16930w;
    }

    public long getForceUpdate() {
        return this.f16933z;
    }

    public long getDidOpenCount() {
        return this.f16928u;
    }

    public long getLaunchDuration() {
        return this.f16904F;
    }

    public long getCurPageChangeTime() {
        return this.f16903E;
    }

    public long getMarkAppLaunchTime() {
        return this.f16915h;
    }

    public long getMarkJSEnginePreloadTime() {
        return this.f16911d;
    }

    public long getMarkJSEngineReadyTime() {
        return this.f16912e;
    }

    public long getMarkJSDefinedDmStart() {
        return this.f16919l;
    }

    public long getMarkJSDefinedDmEnd() {
        return this.f16920m;
    }

    public DMMinaPerfStorage getMinaPerfStorage() {
        if (!Dimina.getConfig().isDebug()) {
            return null;
        }
        if (this.f16908J == null) {
            synchronized (this) {
                if (this.f16908J == null) {
                    this.f16908J = new DMMinaPerfStorage(this.f16910c.getActivity().getApplication(), this.f16910c.getConfig().getLaunchConfig().getAppId());
                }
            }
        }
        return this.f16908J;
    }

    public DMMinaPerfRender getPerfRender() {
        if (!Dimina.getConfig().isDebug()) {
            return null;
        }
        if (this.f16909K == null) {
            synchronized (this) {
                if (this.f16909K == null) {
                    this.f16909K = new DMMinaPerfRender();
                }
            }
        }
        return this.f16909K;
    }

    /* renamed from: c */
    private void m12512c() {
        if (this.f16900B != -1 && this.f16902D != -1) {
            TraceUtil.trackJscoreExecute(this.f16910c.getMinaIndex(), this.f16900B - this.f16899A, this.f16902D - this.f16901C, m12514d());
        }
    }

    /* renamed from: d */
    private long m12514d() {
        long j = this.f16900B;
        if (j != -1) {
            long j2 = this.f16902D;
            if (j2 != -1) {
                if (j <= j2) {
                    j = j2;
                }
                long j3 = this.f16899A;
                long j4 = this.f16901C;
                if (j3 > j4) {
                    j3 = j4;
                }
                return j - j3;
            }
        }
        return -1;
    }
}
