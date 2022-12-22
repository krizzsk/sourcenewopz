package com.didi.map.global.sctx;

import android.content.Context;
import android.text.TextUtils;
import com.didi.common.map.Map;
import com.didi.common.map.util.DLog;
import com.didi.map.global.sctx.SctxService;
import com.didi.map.global.sctx.case_parser.SctxCaseParser;
import com.didi.map.global.sctx.model.ErrorCodeCollect;
import com.didi.map.global.sctx.model.PushInfo;
import com.didi.map.global.sctx.model.RuntimeErrorCollect;
import com.didi.map.global.sctx.model.SctxTripParam;
import com.didi.map.global.sctx.server.IDataCallback;
import com.didi.map.global.sctx.server.ISctxDataProvider;
import com.didi.map.global.sctx.server.SctxDataProviderFactory;
import com.didi.map.google.model.PageCachedApolloValue;
import com.didi.map.sdk.proto.driver_gl.MapPassengeOrderRouteRes;
import com.didi.map.sdk.proto.driver_gl.PassengerOrderRouteReq;

public abstract class AbstractSctxService implements SctxService {

    /* renamed from: a */
    Map f27369a;

    /* renamed from: b */
    Context f27370b;

    /* renamed from: c */
    String f27371c;

    /* renamed from: d */
    SctxService.SctxCallback f27372d;

    /* renamed from: e */
    SctxTripParam f27373e;

    /* renamed from: f */
    SctxService.SctxSearchGetter f27374f;

    /* renamed from: g */
    SctxService.SctxOraNetAgent f27375g;

    /* renamed from: h */
    PageCachedApolloValue f27376h;

    /* renamed from: i */
    ErrorCodeCollect f27377i;

    /* renamed from: j */
    SctxCaseParser f27378j;

    /* renamed from: k */
    RuntimeErrorCollect f27379k;

    /* renamed from: l */
    boolean f27380l = false;

    /* renamed from: m */
    boolean f27381m = true;

    /* renamed from: n */
    long f27382n;

    /* renamed from: o */
    int f27383o = 0;

    /* renamed from: p */
    long f27384p;

    /* renamed from: q */
    IDataCallback f27385q;

    /* renamed from: r */
    private ISctxDataProvider f27386r;

    /* renamed from: s */
    private String f27387s;

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

    public AbstractSctxService(SctxTripParam sctxTripParam) {
        initBaseParam(sctxTripParam);
        m19334a();
    }

    /* access modifiers changed from: protected */
    public void initBaseParam(SctxTripParam sctxTripParam) {
        this.f27373e = sctxTripParam;
        this.f27377i = new ErrorCodeCollect();
        this.f27379k = new RuntimeErrorCollect();
        this.f27378j = new SctxCaseParser();
        this.f27369a = this.f27373e.getMap();
        this.f27370b = this.f27373e.getContext();
        this.f27371c = this.f27373e.getPassengerPhone();
        this.f27374f = this.f27373e.getSctxSearchGetter();
        this.f27376h = new PageCachedApolloValue();
    }

    /* renamed from: a */
    private void m19334a() {
        ISctxDataProvider createSctxDataProvider = SctxDataProviderFactory.createSctxDataProvider(m19335b(), this.f27377i, this.f27379k, this.f27378j);
        this.f27386r = createSctxDataProvider;
        createSctxDataProvider.setCallback(m19336c());
        this.f27386r.setInterval(this.f27373e.getOraRequestInterval());
    }

    /* renamed from: b */
    private ISctxDataProvider.DataSearchOptions m19335b() {
        return new ISctxDataProvider.DataSearchOptions() {
            public PushInfo getPushInfo() {
                return null;
            }

            public PassengerOrderRouteReq getRequestBody() {
                return AbstractSctxService.this.getOraRequestBytes();
            }

            public String getUrl() {
                return AbstractSctxService.this.f27376h.getOraRequestUrl(AbstractSctxService.this.f27370b);
            }

            public Context getContext() {
                if (AbstractSctxService.this.f27370b != null) {
                    return AbstractSctxService.this.f27370b.getApplicationContext();
                }
                return null;
            }
        };
    }

    /* renamed from: c */
    private IDataCallback m19336c() {
        C97882 r0 = new IDataCallback() {
            public void onStart() {
                if (!AbstractSctxService.this.f27381m) {
                    AbstractSctxService.this.onDataSyncStart();
                }
            }

            public void onSuccess(MapPassengeOrderRouteRes mapPassengeOrderRouteRes) {
                if (!AbstractSctxService.this.f27381m) {
                    AbstractSctxService.this.onDataSyncSuccess(mapPassengeOrderRouteRes);
                }
            }

            public void onError(String str) {
                if (!AbstractSctxService.this.f27381m) {
                    AbstractSctxService.this.onDataSyncFail(str);
                }
            }
        };
        this.f27385q = r0;
        return r0;
    }

    /* access modifiers changed from: protected */
    public long getRouteExtensionAnimationDuration() {
        long routeExtensionAnimationDuration = this.f27373e.getRouteExtensionAnimationDuration();
        if (routeExtensionAnimationDuration <= 0) {
            return 3000;
        }
        return routeExtensionAnimationDuration;
    }

    /* access modifiers changed from: protected */
    public void refreshSyncInterval() {
        this.f27386r.setInterval(getOraRequestInterval());
    }

    public void setSctxOraNetAgent(SctxService.SctxOraNetAgent sctxOraNetAgent) {
        this.f27375g = sctxOraNetAgent;
    }

    public void registerSctxCallback(SctxService.SctxCallback sctxCallback) {
        this.f27372d = sctxCallback;
    }

    /* renamed from: d */
    private String m19337d() {
        if (TextUtils.isEmpty(this.f27387s)) {
            this.f27387s = getClass().getSimpleName();
        }
        return this.f27387s;
    }

    public void enter() {
        start();
    }

    /* access modifiers changed from: protected */
    public void start() {
        DLog.m7384d(m19337d(), "start...", new Object[0]);
        if (this.f27381m) {
            this.f27381m = false;
            onPreStart();
            this.f27386r.startSync();
        }
        m19338e();
    }

    /* access modifiers changed from: protected */
    public void stop() {
        this.f27381m = true;
        DLog.m7384d(m19337d(), "stop...", new Object[0]);
        this.f27386r.stopSync();
        m19338e();
    }

    public void resume() {
        DLog.m7384d(m19337d(), "resume...", new Object[0]);
        this.f27380l = false;
        if (!this.f27381m) {
            this.f27386r.resumeSync();
        }
        m19338e();
    }

    public void pause() {
        DLog.m7384d(m19337d(), "pause...", new Object[0]);
        this.f27380l = true;
        m19338e();
        this.f27386r.pauseSync();
    }

    public void leave() {
        DLog.m7384d(m19337d(), "leave...", new Object[0]);
        stop();
    }

    public long getRouteId() {
        return this.f27382n;
    }

    /* access modifiers changed from: protected */
    public boolean isRunning() {
        return this.f27386r.isRunning();
    }

    public void runImmediately() {
        try {
            this.f27386r.runImmediately(getOraRequestBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: e */
    private void m19338e() {
        if (this.f27381m || this.f27380l) {
            this.f27384p = 0;
        } else {
            this.f27384p = System.currentTimeMillis();
        }
        DLog.m7384d("ccc", "updateSctxUseableTime mPaused:" + this.f27380l + ", mIsStop:" + this.f27381m + ",mSctxAvailableTime=" + this.f27384p, new Object[0]);
    }
}
