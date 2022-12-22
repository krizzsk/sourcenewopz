package com.datadog.android.rum;

import com.datadog.android.core.internal.utils.RuntimeUtilsKt;
import com.datadog.android.error.internal.CrashReportsFeature;
import com.datadog.android.log.Logger;
import com.datadog.android.log.internal.LogsFeature;
import com.datadog.android.plugin.DatadogContext;
import com.datadog.android.plugin.DatadogPlugin;
import com.datadog.android.plugin.DatadogRumContext;
import com.datadog.android.rum.internal.RumFeature;
import com.datadog.android.rum.internal.domain.RumContext;
import com.datadog.android.rum.internal.monitor.AdvancedRumMonitor;
import com.datadog.android.tracing.internal.TracesFeature;
import com.didi.safetoolkit.business.toolkit.model.SfViewMenuModel;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u0007J\b\u0010\u001d\u001a\u00020\u0010H\u0007J\r\u0010\u001e\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\u001fJ\b\u0010\u000b\u001a\u00020 H\u0007J\u0010\u0010!\u001a\u00020 2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u0016\u0010!\u001a\u00020 2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00100#H\u0007J\u0010\u0010$\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\bH\u0007J\b\u0010%\u001a\u00020\u001aH\u0003J\u001e\u0010&\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020(2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*H\u0002J\u0015\u0010,\u001a\u00020\u001a2\u0006\u0010-\u001a\u00020\u0005H\u0000¢\u0006\u0002\b.R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006/"}, mo175978d2 = {"Lcom/datadog/android/rum/GlobalRum;", "", "()V", "activeContext", "Ljava/util/concurrent/atomic/AtomicReference;", "Lcom/datadog/android/rum/internal/domain/RumContext;", "globalAttributes", "", "", "getGlobalAttributes$dd_sdk_android_release", "()Ljava/util/Map;", "isRegistered", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isRegistered$dd_sdk_android_release", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "monitor", "Lcom/datadog/android/rum/RumMonitor;", "getMonitor$dd_sdk_android_release", "()Lcom/datadog/android/rum/RumMonitor;", "setMonitor$dd_sdk_android_release", "(Lcom/datadog/android/rum/RumMonitor;)V", "sessionStartNs", "Ljava/util/concurrent/atomic/AtomicLong;", "getSessionStartNs$dd_sdk_android_release", "()Ljava/util/concurrent/atomic/AtomicLong;", "addAttribute", "", "key", "value", "get", "getRumContext", "getRumContext$dd_sdk_android_release", "", "registerIfAbsent", "provider", "Ljava/util/concurrent/Callable;", "removeAttribute", "resetSession", "updateContextInPlugins", "pluginContext", "Lcom/datadog/android/plugin/DatadogContext;", "plugins", "", "Lcom/datadog/android/plugin/DatadogPlugin;", "updateRumContext", "newContext", "updateRumContext$dd_sdk_android_release", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalRum.kt */
public final class GlobalRum {
    public static final GlobalRum INSTANCE = new GlobalRum();

    /* renamed from: a */
    private static final Map<String, Object> f3663a = new ConcurrentHashMap();

    /* renamed from: b */
    private static final AtomicLong f3664b = new AtomicLong(0);

    /* renamed from: c */
    private static final AtomicBoolean f3665c = new AtomicBoolean(false);

    /* renamed from: d */
    private static RumMonitor f3666d = new NoOpRumMonitor();

    /* renamed from: e */
    private static AtomicReference<RumContext> f3667e = new AtomicReference<>(new RumContext((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 63, (DefaultConstructorMarker) null));

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final RumMonitor m2402a(RumMonitor rumMonitor) {
        Intrinsics.checkNotNullParameter(rumMonitor, "$monitor");
        return rumMonitor;
    }

    private GlobalRum() {
    }

    public final Map<String, Object> getGlobalAttributes$dd_sdk_android_release() {
        return f3663a;
    }

    public final AtomicLong getSessionStartNs$dd_sdk_android_release() {
        return f3664b;
    }

    public final AtomicBoolean isRegistered$dd_sdk_android_release() {
        return f3665c;
    }

    public final RumMonitor getMonitor$dd_sdk_android_release() {
        return f3666d;
    }

    public final void setMonitor$dd_sdk_android_release(RumMonitor rumMonitor) {
        Intrinsics.checkNotNullParameter(rumMonitor, "<set-?>");
        f3666d = rumMonitor;
    }

    @JvmStatic
    public static final boolean isRegistered() {
        return f3665c.get();
    }

    @JvmStatic
    public static final boolean registerIfAbsent(RumMonitor rumMonitor) {
        Intrinsics.checkNotNullParameter(rumMonitor, SfViewMenuModel.TYPE_REALTIME_MONITOR);
        return registerIfAbsent((Callable<RumMonitor>) new Callable() {
            public final Object call() {
                return GlobalRum.m2402a(RumMonitor.this);
            }
        });
    }

    @JvmStatic
    public static final boolean registerIfAbsent(Callable<RumMonitor> callable) {
        Intrinsics.checkNotNullParameter(callable, "provider");
        if (f3665c.get()) {
            Logger.w$default(RuntimeUtilsKt.getDevLogger(), "RumMonitor has already been registered", (Throwable) null, (Map) null, 6, (Object) null);
            return false;
        } else if (!f3665c.compareAndSet(false, true)) {
            return false;
        } else {
            RumMonitor call = callable.call();
            Intrinsics.checkNotNullExpressionValue(call, "provider.call()");
            f3666d = call;
            return true;
        }
    }

    @JvmStatic
    public static final RumMonitor get() {
        return f3666d;
    }

    @JvmStatic
    public static final void addAttribute(String str, Object obj) {
        Intrinsics.checkNotNullParameter(str, "key");
        if (obj == null) {
            f3663a.remove(str);
        } else {
            f3663a.put(str, obj);
        }
    }

    @JvmStatic
    public static final void removeAttribute(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        f3663a.remove(str);
    }

    public final RumContext getRumContext$dd_sdk_android_release() {
        RumContext rumContext = f3667e.get();
        Intrinsics.checkNotNullExpressionValue(rumContext, "activeContext.get()");
        return rumContext;
    }

    public final void updateRumContext$dd_sdk_android_release(RumContext rumContext) {
        Intrinsics.checkNotNullParameter(rumContext, "newContext");
        f3667e.set(rumContext);
        DatadogContext datadogContext = new DatadogContext(new DatadogRumContext(rumContext.getApplicationId(), rumContext.getSessionId(), rumContext.getViewId()));
        m2404a(datadogContext, RumFeature.INSTANCE.getPlugins());
        m2404a(datadogContext, CrashReportsFeature.INSTANCE.getPlugins());
        m2404a(datadogContext, LogsFeature.INSTANCE.getPlugins());
        m2404a(datadogContext, TracesFeature.INSTANCE.getPlugins());
    }

    /* renamed from: a */
    private final void m2404a(DatadogContext datadogContext, List<? extends DatadogPlugin> list) {
        for (DatadogPlugin onContextChanged : list) {
            onContextChanged.onContextChanged(datadogContext);
        }
    }

    @JvmStatic
    /* renamed from: a */
    private static final void m2403a() {
        RumMonitor rumMonitor = f3666d;
        AdvancedRumMonitor advancedRumMonitor = rumMonitor instanceof AdvancedRumMonitor ? (AdvancedRumMonitor) rumMonitor : null;
        if (advancedRumMonitor != null) {
            advancedRumMonitor.resetSession();
        }
    }
}
