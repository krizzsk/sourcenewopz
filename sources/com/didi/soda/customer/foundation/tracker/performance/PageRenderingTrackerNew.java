package com.didi.soda.customer.foundation.tracker.performance;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.tracker.OmegaTracker;
import com.didi.soda.customer.foundation.tracker.event.EventConst;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\f\u001a\u00020\rH\u0002J\u0006\u0010\u000e\u001a\u00020\rJ\u0010\u0010\n\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0006\u0010\u000f\u001a\u00020\u0000J\u0006\u0010\u0010\u001a\u00020\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/tracker/performance/PageRenderingTrackerNew;", "", "pageName", "", "(Ljava/lang/String;)V", "endTime", "", "getPageName", "()Ljava/lang/String;", "startTime", "switch", "", "checkParams", "", "report", "trackEnd", "trackStart", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PageRenderingTrackerNew.kt */
public final class PageRenderingTrackerNew {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final long DEFAULT_TIMESTAMP = -1;
    public static final String TAG = "PageRenderingTrackerNew";

    /* renamed from: a */
    private final String f41122a;

    /* renamed from: b */
    private long f41123b = -1;

    /* renamed from: c */
    private long f41124c = -1;

    /* renamed from: d */
    private boolean f41125d = true;

    public PageRenderingTrackerNew(String str) {
        Intrinsics.checkNotNullParameter(str, "pageName");
        this.f41122a = str;
    }

    public final String getPageName() {
        return this.f41122a;
    }

    public final PageRenderingTrackerNew trackStart() {
        this.f41123b = System.currentTimeMillis();
        m29186a(true);
        return this;
    }

    public final PageRenderingTrackerNew trackEnd() {
        this.f41124c = System.currentTimeMillis();
        return this;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m29186a(boolean z) {
        this.f41125d = z;
    }

    public final void report() {
        try {
            if (this.f41125d) {
                m29185a();
                if (this.f41124c < this.f41123b) {
                    LogUtil.m29102e("PageRenderingTrackerNew", Intrinsics.stringPlus(this.f41122a, " endTime < startTime error."));
                    return;
                }
                long j = this.f41124c - this.f41123b;
                LogUtil.m29104i("PageRenderingTrackerNew", this.f41122a + " renderTime " + j);
                OmegaTracker.Builder.create(EventConst.Performance.TECH_PAGE_PERFORMANCE).addEventParam("pn", this.f41122a).addEventParam("duration", Long.valueOf(j)).build().track();
                m29186a(false);
            }
        } catch (Exception e) {
            LogUtil.m29104i("PageRenderingTrackerNew", this.f41122a + ' ' + e);
        }
    }

    /* renamed from: a */
    private final void m29185a() {
        if (this.f41122a.length() == 0) {
            throw new IllegalArgumentException("PageName is empty!");
        } else if (this.f41123b == -1) {
            throw new IllegalArgumentException("Do you forget to invoke trackStart() method ?");
        } else if (this.f41124c == -1) {
            throw new IllegalArgumentException("Do you forget to invoke trackEnd() method ?");
        }
    }

    @Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u0010\u0010\u000b\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u0010\u0010\f\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\r"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/tracker/performance/PageRenderingTrackerNew$Companion;", "", "()V", "DEFAULT_TIMESTAMP", "", "TAG", "", "trackEndAndReportUtil", "", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "trackExceptionUtil", "trackStartUtil", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PageRenderingTrackerNew.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void trackStartUtil(ScopeContext scopeContext) {
            if (scopeContext != null && scopeContext.getObject("PageRenderingTrackerNew") != null) {
                Object object = scopeContext.getObject("PageRenderingTrackerNew");
                if (object != null) {
                    ((PageRenderingTrackerNew) object).trackStart();
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.didi.soda.customer.foundation.tracker.performance.PageRenderingTrackerNew");
            }
        }

        public final void trackEndAndReportUtil(ScopeContext scopeContext) {
            if (scopeContext != null && scopeContext.getObject("PageRenderingTrackerNew") != null) {
                Object object = scopeContext.getObject("PageRenderingTrackerNew");
                if (object != null) {
                    ((PageRenderingTrackerNew) object).trackEnd().report();
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.didi.soda.customer.foundation.tracker.performance.PageRenderingTrackerNew");
            }
        }

        public final void trackExceptionUtil(ScopeContext scopeContext) {
            if (scopeContext != null && scopeContext.getObject("PageRenderingTrackerNew") != null) {
                Object object = scopeContext.getObject("PageRenderingTrackerNew");
                if (object != null) {
                    ((PageRenderingTrackerNew) object).m29186a(false);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.didi.soda.customer.foundation.tracker.performance.PageRenderingTrackerNew");
            }
        }
    }
}
