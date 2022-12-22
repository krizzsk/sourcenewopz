package com.didi.dimina.container.secondparty.trace.inner;

import com.didi.dimina.container.DMConfig;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.Dimina;
import com.didi.dimina.container.secondparty.DMConfig4Di;
import com.didi.dimina.container.service.RegionConfigService;
import com.didi.dimina.container.util.LogUtil;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J4\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u00042\u0018\b\u0002\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0010H\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0013"}, mo175978d2 = {"Lcom/didi/dimina/container/secondparty/trace/inner/LogTracker;", "", "()V", "TAG", "", "isLogManagerInit", "", "()Z", "setLogManagerInit", "(Z)V", "trackEvent", "", "mina", "Lcom/didi/dimina/container/DMMina;", "eventId", "params", "", "logBase", "Lcom/didi/dimina/container/secondparty/trace/inner/LogBase;", "2party-impl_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: LogTracker.kt */
public final class LogTracker {
    public static final LogTracker INSTANCE = new LogTracker();
    public static final String TAG = "LogTracker";

    /* renamed from: a */
    private static volatile boolean f17472a;

    @JvmStatic
    public static final void trackEvent(DMMina dMMina, String str) {
        trackEvent$default(dMMina, str, (Map) null, 4, (Object) null);
    }

    private LogTracker() {
    }

    public final boolean isLogManagerInit() {
        return f17472a;
    }

    public final void setLogManagerInit(boolean z) {
        f17472a = z;
    }

    @JvmStatic
    public static final void trackEvent(LogBase logBase) {
        RegionConfigService regionConfigService;
        Intrinsics.checkParameterIsNotNull(logBase, "logBase");
        DMMina mina = logBase.getMina();
        Boolean bool = null;
        DMConfig config = mina != null ? mina.getConfig() : null;
        if (config instanceof DMConfig4Di) {
            DMConfig4Di.LaunchConfig launchConfig = ((DMConfig4Di) config).getLaunchConfig();
            Intrinsics.checkExpressionValueIsNotNull(launchConfig, "minaConfig.launchConfig");
            if (!launchConfig.isLogServerOn()) {
                LogUtil.iRelease(TAG, "数据平台 日志服务未开启");
                return;
            }
            Dimina.Config config2 = Dimina.getConfig();
            Intrinsics.checkExpressionValueIsNotNull(config2, "Dimina.getConfig()");
            Dimina.AdapterConfig adapterConfig = config2.getAdapterConfig();
            if (!(adapterConfig == null || (regionConfigService = adapterConfig.getRegionConfigService()) == null)) {
                bool = regionConfigService.isInternational();
            }
            if (bool == null) {
                LogUtil.iRelease(TAG, "得不到 国内/国际业务 标识, 直接返回");
                return;
            }
            if (!f17472a) {
                f17472a = true;
                LogManager.init();
            }
            LogCollectThread.INSTANCE.add(logBase);
        }
    }

    public static /* synthetic */ void trackEvent$default(DMMina dMMina, String str, Map map, int i, Object obj) {
        if ((i & 4) != 0) {
            map = null;
        }
        trackEvent(dMMina, str, map);
    }

    @JvmStatic
    public static final void trackEvent(DMMina dMMina, String str, Map<String, ? extends Object> map) {
        Intrinsics.checkParameterIsNotNull(str, "eventId");
        LogBase logBase = new LogBase(dMMina, str);
        if (map != null) {
            logBase.append(map);
        }
        trackEvent(logBase);
    }
}
