package com.didi.dimina.container.util;

import com.didi.dimina.container.DMConfig;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.Dimina;
import com.didi.dimina.container.bridge.blankscreen.BlankType;
import com.didi.dimina.container.bundle.bean.BundleConfig;
import com.didi.dimina.container.service.TraceActionService;
import java.util.Map;
import org.json.JSONObject;

public class TraceUtil {
    public static final int MINA_INDEX_UN_KNOW = -999;

    /* renamed from: a */
    static TraceActionService f17971a = Dimina.getConfig().getAdapterConfig().getTraceActionService();

    public static void traceEventDeviceStat(int i, Map<String, Object> map) {
        TraceActionService traceActionService = f17971a;
        if (traceActionService != null) {
            traceActionService.traceEventDeviceStat(i, map);
        }
    }

    public static void traceLoadError(int i, String str, String str2, String str3) {
        TraceActionService traceActionService = f17971a;
        if (traceActionService != null) {
            traceActionService.traceLoadError(i, str, str2, str3);
        }
    }

    public static void trackEventError(int i, String str, int i2, String str2) {
        TraceActionService traceActionService = f17971a;
        if (traceActionService != null) {
            traceActionService.trackEventError(i, str, i2, str2);
        }
    }

    public static void trackRelaunch(int i, int i2, String str) {
        TraceActionService traceActionService = f17971a;
        if (traceActionService != null) {
            traceActionService.trackRelaunch(i, i2, str);
        }
    }

    public static void trackAppOpenRateStart(int i) {
        TraceActionService traceActionService = f17971a;
        if (traceActionService != null) {
            traceActionService.trackAppOpenRateStart(i);
        }
    }

    public static void trackAppOpenRateEnd(int i, int i2, long j, long j2, long j3, long j4, String str, String str2, String str3) {
        TraceActionService traceActionService = f17971a;
        if (traceActionService != null) {
            traceActionService.trackAppOpenRateEnd(i, i2, j, j2, j3, j4, str, str2, str3);
        }
    }

    public static void trackWebViewRelease(int i, long j, long j2) {
        TraceActionService traceActionService = f17971a;
        if (traceActionService != null) {
            traceActionService.trackWebViewRelease(i, j, j2);
        }
    }

    public static void trackTechSagaSubPkgExecStart(int i, String str, String str2, boolean z) {
        TraceActionService traceActionService = f17971a;
        if (traceActionService != null) {
            traceActionService.trackTechSagaSubPkgExecStart(i, str, str2, z);
        }
    }

    public static void trackTechSagaSubPkgExecSuccess(int i, String str, String str2, long j, boolean z) {
        TraceActionService traceActionService = f17971a;
        if (traceActionService != null) {
            traceActionService.trackTechSagaSubPkgExecSuccess(i, str, str2, j, z);
        }
    }

    public static void traceInteractionTime(int i, long j, String str) {
        TraceActionService traceActionService = f17971a;
        if (traceActionService != null) {
            traceActionService.traceInteractionTime(i, j, str);
        }
    }

    public static void trackEventLaunchPerformance2(int i, long j, long j2, long j3, long j4, int i2) {
        TraceActionService traceActionService = f17971a;
        if (traceActionService != null) {
            traceActionService.trackEventLaunchPerformance2(i, j, j2, j3, j4, i2);
        }
    }

    public static void trackEventCoreDotting(int i, String str, String str2) {
        TraceActionService traceActionService = f17971a;
        if (traceActionService != null) {
            traceActionService.trackEventCoreDotting(i, str, str2);
        }
    }

    public static void trackPreloadWebview(int i, int i2, long j) {
        TraceActionService traceActionService = f17971a;
        if (traceActionService != null) {
            traceActionService.trackPreloadWebview(i, i2, j);
        }
    }

    public static void trackWvInterceptorRequestError(int i, String str, Exception exc) {
        TraceActionService traceActionService = f17971a;
        if (traceActionService != null) {
            traceActionService.trackWvInterceptorRequestError(i, str, exc);
        }
    }

    public static void trackPageOnDestroyRendering(int i, String str, long j, long j2, String str2) {
        TraceActionService traceActionService = f17971a;
        if (traceActionService != null) {
            traceActionService.trackPageOnDestroyRendering(i, str, j, j2, str2);
        }
    }

    public static void traceEngineType(int i, String str) {
        TraceActionService traceActionService = f17971a;
        if (traceActionService != null) {
            traceActionService.traceEngineType(i, str);
        }
    }

    public static void traceUnrealizedBridge(int i, String str, String str2) {
        TraceActionService traceActionService = f17971a;
        if (traceActionService != null) {
            traceActionService.traceUnrealizedBridge(i, str, str2);
        }
    }

    public static void traceForceUpdateStart(int i, DMConfig.ForceUpdateConfig forceUpdateConfig) {
        TraceActionService traceActionService = f17971a;
        if (traceActionService != null) {
            traceActionService.traceForceUpdateStart(i, forceUpdateConfig);
        }
    }

    public static void traceForceUpdateEnd(int i, DMConfig.ForceUpdateConfig forceUpdateConfig, int i2, long j) {
        TraceActionService traceActionService = f17971a;
        if (traceActionService != null) {
            traceActionService.traceForceUpdateEnd(i, forceUpdateConfig, i2, j);
        }
    }

    public static void newTraceForceUpdateEnd(DMMina dMMina, BundleConfig bundleConfig, BundleConfig bundleConfig2, BundleConfig bundleConfig3, BundleConfig bundleConfig4, int i, String str) {
        TraceActionService traceActionService = f17971a;
        if (traceActionService != null) {
            traceActionService.newTraceForceUpdateEnd(dMMina, bundleConfig, bundleConfig2, bundleConfig3, bundleConfig4, i, str);
        }
    }

    public static void tracePmException(Throwable th, int i, String str) {
        TraceActionService traceActionService = f17971a;
        if (traceActionService != null) {
            traceActionService.tracePmException(th, i, str);
        }
    }

    public static void trackBackgroundFetchDataApply(int i, int i2, String str) {
        TraceActionService traceActionService = f17971a;
        if (traceActionService != null) {
            traceActionService.trackBackgroundFetchDataApply(i, i2, str);
        }
    }

    public static void firstLaunch(int i, String str) {
        TraceActionService traceActionService = f17971a;
        if (traceActionService != null) {
            traceActionService.firstLaunch(i, str);
        }
    }

    public static void techSagaScreenBlankMonitor(int i, String str, int i2, @BlankType int i3, String str2, float f, String str3, String str4, String str5) {
        TraceActionService traceActionService = f17971a;
        if (traceActionService != null) {
            traceActionService.techSagaScreenBlankMonitor(i, str, i2, i3, str2, f, str3, str4, str5);
        }
    }

    public static void traceReadFileError(int i, String str, String str2, String str3) {
        TraceActionService traceActionService = f17971a;
        if (traceActionService != null) {
            traceActionService.traceReadFileError(i, str, str2, str3);
        }
    }

    public static void traceV8Fatal(String str) {
        TraceActionService traceActionService = f17971a;
        if (traceActionService != null) {
            traceActionService.traceV8Fatal(str);
        }
    }

    public static void traceWebViewCrash(int i) {
        TraceActionService traceActionService = f17971a;
        if (traceActionService != null) {
            traceActionService.traceWebViewCrash(i);
        }
    }

    public static void techSagaScreenBlankMonitorException() {
        TraceActionService traceActionService = f17971a;
        if (traceActionService != null) {
            traceActionService.techSagaScreenBlankMonitorException();
        }
    }

    public static void traceSagaWaitingTiming(int i, long j) {
        TraceActionService traceActionService = f17971a;
        if (traceActionService != null) {
            traceActionService.traceSagaWaitingTiming(i, j);
        }
    }

    public static void trackReportMiniProgramEvent(int i, JSONObject jSONObject) {
        TraceActionService traceActionService = f17971a;
        if (traceActionService != null) {
            traceActionService.trackReportMiniProgramEvent(i, jSONObject);
        }
    }

    public static void traceD6WebkitSameLayerRenderEvent(String str, Map<String, Object> map) {
        TraceActionService traceActionService = f17971a;
        if (traceActionService != null) {
            traceActionService.traceD6WebkitSameLayerRenderEvent(str, map);
        }
    }

    public static void traceInvokeWebViewReady(int i, String str, long j) {
        TraceActionService traceActionService = f17971a;
        if (traceActionService != null) {
            traceActionService.traceInvokeWebViewReady(i, str, Long.valueOf(j));
        }
    }

    public static void trackOpenPageStart(int i, String str) {
        TraceActionService traceActionService = f17971a;
        if (traceActionService != null) {
            traceActionService.trackOpenPageStart(i, str);
        }
    }

    public static void trackOpenPageEnd(int i, String str, boolean z, Long l) {
        TraceActionService traceActionService = f17971a;
        if (traceActionService != null) {
            traceActionService.trackOpenPageEnd(i, str, z, l);
        }
    }

    public static void trackJscoreExecute(int i, long j, long j2, long j3) {
        TraceActionService traceActionService = f17971a;
        if (traceActionService != null) {
            traceActionService.trackJscoreExecute(i, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3));
        }
    }
}
