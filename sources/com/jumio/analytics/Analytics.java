package com.jumio.analytics;

import com.jumio.commons.log.Log;
import com.jumio.commons.log.LogUtils;
import com.jumio.core.api.BackendManager;
import com.jumio.core.api.calls.AnalyticsCall;
import com.jumio.core.models.ApiCallDataModel;
import com.jumio.core.network.ApiBinding;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 !2\u00020\u0001:\u0001!B\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\n\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\bJ\u0010\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\fJ\u001e\u0010\u0013\u001a\u00020\b2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u001e\u0010\u0016\u001a\u00020\b2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016R(\u0010\u001c\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00190\u00180\u00178V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006\""}, mo175978d2 = {"Lcom/jumio/analytics/Analytics;", "Lcom/jumio/core/network/ApiBinding;", "Ljava/util/Date;", "serverTime", "", "time", "", "quota", "", "start", "stop", "shutdown", "", "canceled", "reporting", "Lcom/jumio/core/models/ApiCallDataModel;", "apiCallDataModel", "", "result", "onResult", "", "error", "onError", "", "Ljava/lang/Class;", "Lcom/jumio/core/network/ApiCall;", "getBindingClasses", "()[Ljava/lang/Class;", "bindingClasses", "Lcom/jumio/core/api/BackendManager;", "backendManager", "<init>", "(Lcom/jumio/core/api/BackendManager;)V", "Companion", "jumio-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* compiled from: Analytics.kt */
public final class Analytics implements ApiBinding {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String LOGTAG = "Analytics";

    /* renamed from: e */
    public static Analytics f54512e;

    /* renamed from: f */
    public static final Object f54513f = new Object();

    /* renamed from: g */
    public static final ArrayList<AnalyticsEvent> f54514g = new ArrayList<>();

    /* renamed from: h */
    public static final ArrayList<AnalyticsEvent> f54515h = new ArrayList<>();

    /* renamed from: i */
    public static UUID f54516i = UUID.randomUUID();

    /* renamed from: j */
    public static int f54517j = 10;

    /* renamed from: k */
    public static boolean f54518k;

    /* renamed from: l */
    public static boolean f54519l = true;

    /* renamed from: a */
    public BackendManager f54520a;

    /* renamed from: b */
    public final ScheduledExecutorService f54521b = Executors.newScheduledThreadPool(1);

    /* renamed from: c */
    public ScheduledFuture<?> f54522c;

    /* renamed from: d */
    public long f54523d;

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b$\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\u0006\u0010\t\u001a\u00020\u0002R\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0019\u001a\u00020\u00018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001c\u001a\u00020\u001b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00060\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u0015R\u001e\u0010!\u001a\n  *\u0004\u0018\u00010\u001f0\u001f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010#\u001a\u00020\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b#\u0010\f¨\u0006%"}, mo175978d2 = {"Lcom/jumio/analytics/Analytics$Companion;", "", "", "configure$jumio_core_release", "()V", "configure", "Lcom/jumio/analytics/AnalyticsEvent;", "event", "add", "flush", "", "isEnabled", "Z", "()Z", "setEnabled", "(Z)V", "", "LOGTAG", "Ljava/lang/String;", "Ljava/util/ArrayList;", "events", "Ljava/util/ArrayList;", "Lcom/jumio/analytics/Analytics;", "instance", "Lcom/jumio/analytics/Analytics;", "lock", "Ljava/lang/Object;", "", "quota", "I", "reporting", "Ljava/util/UUID;", "kotlin.jvm.PlatformType", "sessionId", "Ljava/util/UUID;", "started", "<init>", "jumio-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
    /* compiled from: Analytics.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void add(AnalyticsEvent analyticsEvent) {
            Analytics access$getInstance$cp;
            Intrinsics.checkNotNullParameter(analyticsEvent, "event");
            analyticsEvent.setSessionId(Analytics.f54516i);
            int eventType = analyticsEvent.getEventType();
            if (eventType == 306 || eventType == 307 || eventType == 311 || eventType == 313 || eventType == 316) {
                Analytics.f54515h.add(analyticsEvent);
            } else if (isEnabled()) {
                LogUtils.logAnalytics(analyticsEvent);
                synchronized (Analytics.f54513f) {
                    Analytics.f54514g.add(analyticsEvent);
                }
                if (!(Analytics.f54517j == 0 || Analytics.f54514g.size() < Analytics.f54517j || (access$getInstance$cp = Analytics.f54512e) == null)) {
                    Analytics.m39421a(access$getInstance$cp, false, 1, (Object) null);
                }
                if (analyticsEvent.getEventType() == 302 && !Intrinsics.areEqual((Object) analyticsEvent.getPayload().mo162353b(), (Object) C19937a.CREATED.toString())) {
                    Log.m39471v(Analytics.LOGTAG, "-- event was SDKLIFECYCLE -> flush() events");
                    Analytics access$getInstance$cp2 = Analytics.f54512e;
                    if (access$getInstance$cp2 != null) {
                        Analytics.m39421a(access$getInstance$cp2, false, 1, (Object) null);
                    }
                }
            }
        }

        public final void configure$jumio_core_release() {
            Analytics.f54518k = false;
            setEnabled(true);
            Analytics.f54516i = UUID.randomUUID();
            Analytics.f54514g.clear();
            Analytics.f54515h.clear();
        }

        public final void flush() {
            Analytics access$getInstance$cp = Analytics.f54512e;
            if (access$getInstance$cp != null) {
                Analytics.m39421a(access$getInstance$cp, false, 1, (Object) null);
            }
        }

        public final boolean isEnabled() {
            return Analytics.f54519l;
        }

        public final void setEnabled(boolean z) {
            Analytics.f54519l = z;
        }
    }

    public Analytics(BackendManager backendManager) {
        Intrinsics.checkNotNullParameter(backendManager, "backendManager");
        this.f54520a = backendManager;
        backendManager.addBinding(this);
    }

    /* renamed from: a */
    public static final void m39420a(Analytics analytics) {
        Intrinsics.checkNotNullParameter(analytics, "this$0");
        m39421a(analytics, false, 1, (Object) null);
    }

    @JvmStatic
    public static final void add(AnalyticsEvent analyticsEvent) {
        Companion.add(analyticsEvent);
    }

    public static /* synthetic */ void reporting$default(Analytics analytics, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        analytics.reporting(z);
    }

    public static /* synthetic */ void start$default(Analytics analytics, Date date, long j, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j = 0;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        analytics.start(date, j, i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: java.lang.Class<? extends com.jumio.core.network.ApiCall<?>>[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Class<? extends com.jumio.core.network.ApiCall<?>>[] getBindingClasses() {
        /*
            r3 = this;
            r0 = 1
            java.lang.Class[] r0 = new java.lang.Class[r0]
            r1 = 0
            java.lang.Class<com.jumio.core.api.calls.AnalyticsCall> r2 = com.jumio.core.api.calls.AnalyticsCall.class
            r0[r1] = r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.analytics.Analytics.getBindingClasses():java.lang.Class[]");
    }

    public void onError(ApiCallDataModel<?> apiCallDataModel, Throwable th) {
        Intrinsics.checkNotNullParameter(apiCallDataModel, "apiCallDataModel");
        if (Intrinsics.areEqual((Object) apiCallDataModel.getCall(), (Object) AnalyticsCall.class)) {
            synchronized (f54513f) {
                ArrayList arrayList = (ArrayList) apiCallDataModel.getData().get("DATA_EVENTS");
                if (arrayList != null) {
                    f54514g.addAll(0, arrayList);
                }
            }
        }
    }

    public void onResult(ApiCallDataModel<?> apiCallDataModel, Object obj) {
        Intrinsics.checkNotNullParameter(apiCallDataModel, "apiCallDataModel");
        Intrinsics.areEqual((Object) apiCallDataModel.getCall(), (Object) AnalyticsCall.class);
    }

    public final void reporting(boolean z) {
        this.f54520a.reporting(f54515h, this.f54523d, z);
    }

    public final void shutdown() {
        stop();
        mo162313a(true);
        this.f54520a.removeBinding(this);
    }

    public final void start(Date date, long j, int i) {
        Intrinsics.checkNotNullParameter(date, "serverTime");
        if (!f54518k && f54519l) {
            this.f54523d = new Date().getTime() - date.getTime();
            f54517j = i;
            f54518k = true;
            Log.m39456d(LOGTAG, Intrinsics.stringPlus("create new session Id: ", f54516i));
            Log.m39471v(LOGTAG, "start with fixed rate at P=" + j + " ms");
            ScheduledFuture<?> scheduledFuture = this.f54522c;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(true);
            }
            if (j != 0) {
                this.f54522c = this.f54521b.scheduleWithFixedDelay(new Runnable() {
                    public final void run() {
                        Analytics.m39420a(Analytics.this);
                    }
                }, j, j, TimeUnit.MILLISECONDS);
            }
            f54512e = this;
        }
    }

    public final void stop() {
        ScheduledFuture<?> scheduledFuture;
        ScheduledFuture<?> scheduledFuture2 = this.f54522c;
        if ((scheduledFuture2 != null && !scheduledFuture2.isCancelled()) && (scheduledFuture = this.f54522c) != null) {
            scheduledFuture.cancel(true);
        }
        f54518k = false;
        f54512e = null;
    }

    /* renamed from: a */
    public static /* synthetic */ void m39421a(Analytics analytics, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        analytics.mo162313a(z);
    }

    /* renamed from: a */
    public final void mo162313a(boolean z) {
        ArrayList arrayList = new ArrayList();
        synchronized (f54513f) {
            ArrayList<AnalyticsEvent> arrayList2 = f54514g;
            arrayList.addAll(arrayList2);
            arrayList2.clear();
            Unit unit = Unit.INSTANCE;
        }
        if (!arrayList.isEmpty()) {
            try {
                Log.m39471v(LOGTAG, "EventDispatcher.dispatchEvents()");
                this.f54520a.analytics(arrayList, this.f54523d, z);
            } catch (Exception e) {
                Log.m39477w(LOGTAG, "Exception while event dispatch", (Throwable) e);
                synchronized (f54513f) {
                    f54514g.addAll(0, arrayList);
                }
            }
        }
    }
}
