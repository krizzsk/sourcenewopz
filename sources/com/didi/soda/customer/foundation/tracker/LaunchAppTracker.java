package com.didi.soda.customer.foundation.tracker;

import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.tracker.OmegaTracker;
import com.didi.soda.customer.foundation.tracker.event.EventConst;
import com.didi.soda.customer.foundation.tracker.performance.PerformanceOmegaHelper;
import com.didi.soda.customer.foundation.util.GsonUtil;
import com.didi.soda.customer.foundation.util.UiHandlerUtil;
import com.didi.soda.customer.foundation.util.startup.FallbackController;
import com.didi.soda.customer.foundation.util.startup.StartLocHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u00020\u000bH\u0002J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u001a\u0010\u0011\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0013\u001a\u00020\u0004H\u0002J\b\u0010\u0014\u001a\u00020\u000bH\u0002J\b\u0010\u0015\u001a\u00020\u000bH\u0002J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u0017\u001a\u00020\u000bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/tracker/LaunchAppTracker;", "", "()V", "appBeginTime", "", "stage", "", "trackInfos", "", "Lcom/didi/soda/customer/foundation/tracker/TraceInfo;", "beginTrace", "", "tag", "", "doTrack", "endTrace", "endTraceInThread", "getPointInfo", "info", "beginTime", "nextStage", "print", "reverseFind", "track", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: LaunchAppTracker.kt */
public final class LaunchAppTracker {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String LOG_TAG = "LaunchApp";
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static boolean f41082d = (!GlobalContext.isEmbed());
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static LaunchAppTracker f41083e = new LaunchAppTracker();
    /* access modifiers changed from: private */

    /* renamed from: f */
    public static String f41084f = "";
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final List<C13758a> f41085a = new ArrayList();

    /* renamed from: b */
    private int f41086b;

    /* renamed from: c */
    private final long f41087c = System.currentTimeMillis();

    public LaunchAppTracker() {
        m29150a("init-Launch");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m29148a() {
        this.f41086b++;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m29150a(String str) {
        this.f41085a.add(new C13758a(str, this.f41086b, System.currentTimeMillis(), 0));
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final C13758a m29151b(String str) {
        Iterator it = RangesKt.downTo(this.f41085a.size() - 1, 0).iterator();
        while (it.hasNext()) {
            C13758a aVar = this.f41085a.get(((IntIterator) it).nextInt());
            if (Intrinsics.areEqual((Object) aVar.mo104911a(), (Object) str)) {
                return aVar;
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public final void m29154c(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        C13758a b = m29151b(str);
        if (b != null) {
            b.mo104912a((int) (currentTimeMillis - b.mo104914c()));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public final void m29156d(String str) {
        UiHandlerUtil.post(new Runnable(str, System.currentTimeMillis()) {
            public final /* synthetic */ String f$1;
            public final /* synthetic */ long f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                LaunchAppTracker.m29149a(LaunchAppTracker.this, this.f$1, this.f$2);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m29149a(LaunchAppTracker launchAppTracker, String str, long j) {
        Intrinsics.checkNotNullParameter(launchAppTracker, "this$0");
        Intrinsics.checkNotNullParameter(str, "$tag");
        if (f41082d) {
            try {
                C13758a b = launchAppTracker.m29151b(str);
                if (b != null) {
                    b.mo104912a((int) (j - b.mo104914c()));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: b */
    private final void m29152b() {
        if (LaunchAppTrackerKt.f41088a) {
            for (C13758a aVar : this.f41085a) {
                Companion.log(aVar.toString());
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public final void m29153c() {
        m29154c("init-Launch");
        if (LaunchAppTrackerKt.f41088a) {
            m29152b();
        }
        try {
            m29155d();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: d */
    private final void m29155d() {
        String str;
        C13758a aVar = null;
        C13758a aVar2 = null;
        C13758a aVar3 = null;
        C13758a aVar4 = null;
        C13758a aVar5 = null;
        C13758a aVar6 = null;
        C13758a aVar7 = null;
        for (C13758a aVar8 : this.f41085a) {
            String a = aVar8.mo104911a();
            switch (a.hashCode()) {
                case -1430209267:
                    if (a.equals("init-addQueue")) {
                        aVar7 = aVar8;
                        break;
                    } else {
                        break;
                    }
                case -991266505:
                    if (a.equals("init-FeedIndex")) {
                        aVar6 = aVar8;
                        break;
                    } else {
                        break;
                    }
                case -873641500:
                    if (a.equals("init-Splash")) {
                        aVar2 = aVar8;
                        break;
                    } else {
                        break;
                    }
                case -593869359:
                    if (a.equals("init-WaitLocToRefreshHome")) {
                        aVar5 = aVar8;
                        break;
                    } else {
                        break;
                    }
                case -510513126:
                    if (a.equals("init-StartLocation")) {
                        aVar3 = aVar8;
                        break;
                    } else {
                        break;
                    }
                case -222688269:
                    if (a.equals("init-Application")) {
                        aVar = aVar8;
                        break;
                    } else {
                        break;
                    }
                case -125400027:
                    if (a.equals("init-MainPage")) {
                        aVar4 = aVar8;
                        break;
                    } else {
                        break;
                    }
            }
        }
        long c = aVar == null ? this.f41087c : aVar.mo104914c();
        String a2 = m29147a(aVar, c);
        String a3 = m29147a(aVar2, c);
        String a4 = m29147a(aVar3, c);
        String a5 = m29147a(aVar4, c);
        String a6 = m29147a(aVar5, c);
        String a7 = m29147a(aVar6, c);
        String a8 = m29147a(aVar7, c);
        Iterable iterable = this.f41085a;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (Iterator it = iterable.iterator(); it.hasNext(); it = it) {
            C13758a aVar9 = (C13758a) it.next();
            arrayList.add(MapsKt.mapOf(TuplesKt.m42317to("sg", Integer.valueOf(aVar9.mo104913b())), TuplesKt.m42317to("tag", aVar9.mo104911a()), TuplesKt.m42317to("beg", Long.valueOf(aVar9.mo104914c() - c)), TuplesKt.m42317to("dur", Integer.valueOf(aVar9.mo104915d()))));
        }
        try {
            str = GsonUtil.toJson((List) arrayList);
        } catch (Exception e) {
            e.printStackTrace();
            str = "";
        }
        FallbackController.FallbackModel fallbackInfo = FallbackController.getFallbackInfo();
        Intrinsics.checkNotNullExpressionValue(fallbackInfo, "getFallbackInfo()");
        OmegaTracker.Builder.create(EventConst.Performance.LAUNCH_DETAIL).addEventParam("init_app", a2).addEventParam("init_splash", a3).addEventParam("start_loc", a4).addEventParam("init_main", a5).addEventParam("wait_loc", a6).addEventParam("refresh_home", a7).addEventParam("add_queue", a8).addEventParam("detail", str).addEventParam("fallback_open", Boolean.valueOf(fallbackInfo.isOpen)).addEventParam("lazy_component", Boolean.valueOf(fallbackInfo.isOpenLazyComponent)).addEventParam("delay_flutter", Boolean.valueOf(fallbackInfo.isOpenDelayFlutter)).addEventParam("pre_loc", Boolean.valueOf(StartLocHelper.isPreLoc())).addEventParam("close_splash_post", Boolean.valueOf(fallbackInfo.isCloseSplashPost)).addEventParam("open_async_layout", Boolean.valueOf(fallbackInfo.isOpenAsyncLayout)).addEventParam("open_pre_feed", Boolean.valueOf(StartLocHelper.isPreLoad())).addEventParam("remove_set_view", Boolean.valueOf(fallbackInfo.isRemoveSetView)).build().track();
    }

    /* renamed from: a */
    private final String m29147a(C13758a aVar, long j) {
        long j2;
        Pair[] pairArr = new Pair[3];
        int i = 0;
        pairArr[0] = TuplesKt.m42317to("tag", aVar == null ? "" : aVar.mo104911a());
        if (aVar == null) {
            j2 = 0;
        } else {
            j2 = aVar.mo104914c() - j;
        }
        pairArr[1] = TuplesKt.m42317to("bgi", Long.valueOf(j2));
        if (aVar != null) {
            i = aVar.mo104915d();
        }
        pairArr[2] = TuplesKt.m42317to("dur", Integer.valueOf(i));
        try {
            String json = GsonUtil.toJson(MapsKt.mapOf(pairArr));
            Intrinsics.checkNotNullExpressionValue(json, "{\n            GsonUtil.toJson(infoMap)\n        }");
            return json;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @Metadata(mo175977d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004J\u0006\u0010\r\u001a\u00020\u000bJ\u000e\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004J\u000e\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004J\u0006\u0010\u0010\u001a\u00020\u000bJ\u000e\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0004J\u000e\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0004J\u0006\u0010\u0014\u001a\u00020\u000bJ\u0006\u0010\u0015\u001a\u00020\u000bJ\u0016\u0010\u0016\u001a\u00020\u000b2\u000e\u0010\u0017\u001a\n\u0018\u00010\u0018j\u0004\u0018\u0001`\u0019R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/tracker/LaunchAppTracker$Companion;", "", "()V", "LOG_TAG", "", "enable", "", "instance", "Lcom/didi/soda/customer/foundation/tracker/LaunchAppTracker;", "launchFlowInfo", "beginTrace", "", "tag", "clear", "endTrace", "endTraceInThread", "fixFakeColdStart", "log", "msg", "logLaunchFlow", "nextStage", "track", "trackExtraError", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: LaunchAppTracker.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void log(String str) {
            Intrinsics.checkNotNullParameter(str, "msg");
        }

        private Companion() {
        }

        public final void beginTrace(String str) {
            LaunchAppTracker access$getInstance$cp;
            Intrinsics.checkNotNullParameter(str, "tag");
            if (LaunchAppTracker.f41082d && (access$getInstance$cp = LaunchAppTracker.f41083e) != null) {
                access$getInstance$cp.m29150a(str);
            }
        }

        public final void endTrace(String str) {
            LaunchAppTracker access$getInstance$cp;
            Intrinsics.checkNotNullParameter(str, "tag");
            if (LaunchAppTracker.f41082d && (access$getInstance$cp = LaunchAppTracker.f41083e) != null) {
                access$getInstance$cp.m29154c(str);
            }
        }

        public final void endTraceInThread(String str) {
            LaunchAppTracker access$getInstance$cp;
            Intrinsics.checkNotNullParameter(str, "tag");
            if (LaunchAppTracker.f41082d && (access$getInstance$cp = LaunchAppTracker.f41083e) != null) {
                access$getInstance$cp.m29156d(str);
            }
        }

        public final void fixFakeColdStart() {
            if (LaunchAppTracker.f41082d) {
                LaunchAppTracker access$getInstance$cp = LaunchAppTracker.f41083e;
                C13758a access$reverseFind = access$getInstance$cp == null ? null : access$getInstance$cp.m29151b("init-LaunchSplash");
                if (access$reverseFind != null && access$reverseFind.mo104915d() > 500) {
                    clear();
                    PerformanceOmegaHelper.getInstance().reset();
                    LogUtil.m29100d("TraceHelper", "fixFakeColdStart");
                }
            }
        }

        public final void nextStage() {
            LaunchAppTracker access$getInstance$cp;
            if (LaunchAppTracker.f41082d && (access$getInstance$cp = LaunchAppTracker.f41083e) != null) {
                access$getInstance$cp.m29148a();
            }
        }

        public final void track() {
            if (LaunchAppTracker.f41082d) {
                LaunchAppTracker access$getInstance$cp = LaunchAppTracker.f41083e;
                if (access$getInstance$cp != null) {
                    access$getInstance$cp.m29153c();
                }
                clear();
            }
        }

        public final void clear() {
            LaunchAppTracker.f41082d = false;
            if (LaunchAppTracker.f41083e != null) {
                LaunchAppTracker access$getInstance$cp = LaunchAppTracker.f41083e;
                if (access$getInstance$cp != null) {
                    access$getInstance$cp.f41085a.clear();
                }
                LaunchAppTracker.f41083e = null;
            }
            LaunchAppTracker.f41084f = "";
        }

        public final void logLaunchFlow(String str) {
            Intrinsics.checkNotNullParameter(str, "msg");
            LaunchAppTracker.f41084f = LaunchAppTracker.f41084f + ",[" + str + VersionRange.RIGHT_CLOSED;
        }

        public final void trackExtraError(Exception exc) {
            String str;
            if (exc == null) {
                str = null;
            } else {
                try {
                    str = ExceptionsKt.stackTraceToString(exc);
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            OmegaTracker.Builder create = OmegaTracker.Builder.create(EventConst.Technology.TECH_SAILING_C_GET_EXTRA_DATA_ERROR);
            if (str == null) {
                str = "";
            }
            create.addEventParam("stack_info", str).build().track();
        }
    }
}
