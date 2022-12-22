package com.didi.map.global.sctx;

import android.content.Context;
import android.text.TextUtils;
import com.didi.common.map.Map;
import com.didi.common.map.util.DLog;
import com.didi.map.global.sctx.SctxService;
import com.didi.map.global.sctx.case_parser.SctxCaseParser;
import com.didi.map.global.sctx.model.ErrorCodeCollect;
import com.didi.map.global.sctx.model.EtaEdaInfo;
import com.didi.map.global.sctx.model.PushInfo;
import com.didi.map.global.sctx.model.RuntimeErrorCollect;
import com.didi.map.global.sctx.model.SctxTripParam;
import com.didi.map.global.sctx.server.IDataCallback;
import com.didi.map.global.sctx.server.ISctxDataProvider;
import com.didi.map.global.sctx.server.SctxDataProviderFactory;
import com.didi.map.google.model.PageCachedApolloValue;
import com.didi.map.sdk.proto.driver_gl.MapPassengeOrderRouteRes;
import com.didi.map.sdk.proto.driver_gl.PassengerOrderRouteReq;

public abstract class AbstractSctxServiceTwo implements SctxService {

    /* renamed from: a */
    Map f27388a;

    /* renamed from: b */
    Context f27389b;

    /* renamed from: c */
    String f27390c;

    /* renamed from: d */
    SctxService.SctxCallback f27391d;

    /* renamed from: e */
    SctxTripParam f27392e;

    /* renamed from: f */
    SctxService.SctxSearchGetter f27393f;

    /* renamed from: g */
    SctxService.SctxOraNetAgent f27394g;

    /* renamed from: h */
    PageCachedApolloValue f27395h;

    /* renamed from: i */
    ErrorCodeCollect f27396i;

    /* renamed from: j */
    SctxCaseParser f27397j;

    /* renamed from: k */
    RuntimeErrorCollect f27398k;

    /* renamed from: l */
    boolean f27399l = false;

    /* renamed from: m */
    boolean f27400m = true;

    /* renamed from: n */
    long f27401n;

    /* renamed from: o */
    int f27402o = 0;

    /* renamed from: p */
    long f27403p;

    /* renamed from: q */
    IDataCallback f27404q;

    /* renamed from: r */
    private ISctxDataProvider f27405r;

    /* renamed from: s */
    private String f27406s;

    /* access modifiers changed from: protected */
    public long checkInterval(long j) {
        if (j == 0) {
            return 3000;
        }
        if (j < 1000) {
            return 1000;
        }
        if (j > 15000) {
            return 15000;
        }
        return j;
    }

    /* access modifiers changed from: protected */
    public abstract PassengerOrderRouteReq getOraRequestBytes();

    /* access modifiers changed from: protected */
    public long getOraRequestInterval() {
        return 3000;
    }

    /* access modifiers changed from: protected */
    public void onDataSyncFail(String str) {
    }

    /* access modifiers changed from: protected */
    public void onDataSyncStart() {
    }

    /* access modifiers changed from: protected */
    public void onDataSyncSuccess(MapPassengeOrderRouteRes mapPassengeOrderRouteRes) {
    }

    /* access modifiers changed from: protected */
    public abstract void onPreStart();

    public AbstractSctxServiceTwo(SctxTripParam sctxTripParam) {
        initBaseParam(sctxTripParam);
        m19339a();
    }

    /* access modifiers changed from: protected */
    public void initBaseParam(SctxTripParam sctxTripParam) {
        this.f27392e = sctxTripParam;
        this.f27396i = new ErrorCodeCollect();
        this.f27398k = new RuntimeErrorCollect();
        this.f27397j = new SctxCaseParser();
        this.f27388a = this.f27392e.getMap();
        this.f27389b = this.f27392e.getContext();
        this.f27390c = this.f27392e.getPassengerPhone();
        this.f27393f = this.f27392e.getSctxSearchGetter();
        this.f27395h = new PageCachedApolloValue();
    }

    /* renamed from: a */
    private void m19339a() {
        ISctxDataProvider createSctxDataProvider = SctxDataProviderFactory.createSctxDataProvider(m19340b(), this.f27396i, this.f27398k, this.f27397j);
        this.f27405r = createSctxDataProvider;
        createSctxDataProvider.setCallback(m19341c());
        this.f27405r.setInterval(this.f27392e.getOraRequestInterval());
    }

    /* renamed from: b */
    private ISctxDataProvider.DataSearchOptions m19340b() {
        return new ISctxDataProvider.DataSearchOptions() {
            public PushInfo getPushInfo() {
                return null;
            }

            public PassengerOrderRouteReq getRequestBody() {
                return AbstractSctxServiceTwo.this.getOraRequestBytes();
            }

            public String getUrl() {
                return AbstractSctxServiceTwo.this.f27395h.getOraRequestUrl(AbstractSctxServiceTwo.this.f27389b);
            }

            public Context getContext() {
                if (AbstractSctxServiceTwo.this.f27389b != null) {
                    return AbstractSctxServiceTwo.this.f27389b.getApplicationContext();
                }
                return null;
            }
        };
    }

    /* renamed from: c */
    private IDataCallback m19341c() {
        C97902 r0 = new IDataCallback() {
            public void onStart() {
                if (!AbstractSctxServiceTwo.this.f27400m && !AbstractSctxServiceTwo.this.f27399l) {
                    AbstractSctxServiceTwo.this.onDataSyncStart();
                }
            }

            public void onSuccess(MapPassengeOrderRouteRes mapPassengeOrderRouteRes) {
                if (!AbstractSctxServiceTwo.this.f27400m && !AbstractSctxServiceTwo.this.f27399l) {
                    AbstractSctxServiceTwo.this.onDataSyncSuccess(mapPassengeOrderRouteRes);
                }
                if (!AbstractSctxServiceTwo.this.f27400m && AbstractSctxServiceTwo.this.f27399l && mapPassengeOrderRouteRes != null) {
                    int i = 0;
                    int intValue = (mapPassengeOrderRouteRes.eta == null || mapPassengeOrderRouteRes.eta.intValue() < 0) ? 0 : mapPassengeOrderRouteRes.eta.intValue();
                    if (mapPassengeOrderRouteRes.distance != null && mapPassengeOrderRouteRes.distance.intValue() >= 0) {
                        i = mapPassengeOrderRouteRes.distance.intValue();
                    }
                    AbstractSctxServiceTwo.this.f27391d.onEtaEdaUpdate(new EtaEdaInfo(intValue, i, -1));
                }
            }

            public void onError(String str) {
                if (!AbstractSctxServiceTwo.this.f27400m && !AbstractSctxServiceTwo.this.f27399l) {
                    AbstractSctxServiceTwo.this.onDataSyncFail(str);
                }
            }
        };
        this.f27404q = r0;
        return r0;
    }

    /* access modifiers changed from: protected */
    public long getRouteExtensionAnimationDuration() {
        long routeExtensionAnimationDuration = this.f27392e.getRouteExtensionAnimationDuration();
        if (routeExtensionAnimationDuration <= 0) {
            return 3000;
        }
        return routeExtensionAnimationDuration;
    }

    /* access modifiers changed from: protected */
    public void refreshSyncInterval() {
        this.f27405r.setInterval(getOraRequestInterval());
    }

    public void setSctxOraNetAgent(SctxService.SctxOraNetAgent sctxOraNetAgent) {
        this.f27394g = sctxOraNetAgent;
    }

    public void registerSctxCallback(SctxService.SctxCallback sctxCallback) {
        this.f27391d = sctxCallback;
    }

    /* renamed from: d */
    private String m19342d() {
        if (TextUtils.isEmpty(this.f27406s)) {
            this.f27406s = getClass().getSimpleName();
        }
        return this.f27406s;
    }

    public void enter() {
        start();
    }

    /* access modifiers changed from: protected */
    public void start() {
        DLog.m7384d(m19342d(), "start...", new Object[0]);
        if (this.f27400m) {
            this.f27400m = false;
            onPreStart();
            this.f27405r.startSync();
        }
        m19343e();
    }

    /* access modifiers changed from: protected */
    public void stop() {
        this.f27400m = true;
        DLog.m7384d(m19342d(), "stop...", new Object[0]);
        this.f27405r.stopSync();
        m19343e();
    }

    public void resume() {
        DLog.m7384d(m19342d(), "resume...", new Object[0]);
        this.f27399l = false;
        if (!this.f27400m) {
            this.f27405r.resumeSync();
        }
        m19343e();
    }

    public void pause() {
        DLog.m7384d(m19342d(), "pause...", new Object[0]);
        this.f27399l = true;
        m19343e();
    }

    public void leave() {
        DLog.m7384d(m19342d(), "leave...", new Object[0]);
        stop();
    }

    public long getRouteId() {
        return this.f27401n;
    }

    /* access modifiers changed from: protected */
    public boolean isRunning() {
        return this.f27405r.isRunning();
    }

    public void runImmediately() {
        try {
            this.f27405r.runImmediately(getOraRequestBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: e */
    private void m19343e() {
        if (this.f27400m || this.f27399l) {
            this.f27403p = 0;
        } else {
            this.f27403p = System.currentTimeMillis();
        }
        DLog.m7384d("ccc", "updateSctxUseableTime mPaused:" + this.f27399l + ", mIsStop:" + this.f27400m + ",mSctxAvailableTime=" + this.f27403p, new Object[0]);
    }
}
