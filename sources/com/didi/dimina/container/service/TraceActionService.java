package com.didi.dimina.container.service;

import com.didi.dimina.container.DMConfig;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.bridge.blankscreen.BlankType;
import com.didi.dimina.container.bundle.bean.BundleConfig;
import java.util.Map;
import org.json.JSONObject;

public interface TraceActionService {
    void firstLaunch(int i, String str);

    void newTraceForceUpdateEnd(DMMina dMMina, BundleConfig bundleConfig, BundleConfig bundleConfig2, BundleConfig bundleConfig3, BundleConfig bundleConfig4, int i, String str);

    void techSagaScreenBlankMonitor(int i, String str, int i2, @BlankType int i3, String str2, float f, String str3, String str4, String str5);

    void techSagaScreenBlankMonitorException();

    void traceD6WebkitSameLayerRenderEvent(String str, Map<String, Object> map);

    void traceEngineType(int i, String str);

    void traceEventDeviceStat(int i, Map<String, Object> map);

    void traceForceUpdateEnd(int i, DMConfig.ForceUpdateConfig forceUpdateConfig, int i2, long j);

    void traceForceUpdateStart(int i, DMConfig.ForceUpdateConfig forceUpdateConfig);

    void traceInteractionTime(int i, long j, String str);

    void traceInvokeWebViewReady(int i, String str, Long l);

    void traceLoadError(int i, String str, String str2, String str3);

    void tracePmException(Throwable th, int i, String str);

    void traceReadFileError(int i, String str, String str2, String str3);

    void traceSagaWaitingTiming(int i, long j);

    void traceUnrealizedBridge(int i, String str, String str2);

    void traceV8Fatal(String str);

    void traceWebViewCrash(int i);

    void trackAppOpenRateEnd(int i, int i2, long j, long j2, long j3, long j4, String str, String str2, String str3);

    void trackAppOpenRateStart(int i);

    void trackBackgroundFetchDataApply(int i, int i2, String str);

    void trackEventCoreDotting(int i, String str, String str2);

    void trackEventError(int i, String str, int i2, String str2);

    void trackEventLaunchPerformance2(int i, long j, long j2, long j3, long j4, int i2);

    void trackJscoreExecute(int i, Long l, Long l2, Long l3);

    void trackOpenPageEnd(int i, String str, boolean z, Long l);

    void trackOpenPageStart(int i, String str);

    void trackPageOnDestroyRendering(int i, String str, long j, long j2, String str2);

    void trackPreloadWebview(int i, int i2, long j);

    void trackRelaunch(int i, int i2, String str);

    void trackReportMiniProgramEvent(int i, JSONObject jSONObject);

    void trackTechSagaSubPkgExecStart(int i, String str, String str2, boolean z);

    void trackTechSagaSubPkgExecSuccess(int i, String str, String str2, long j, boolean z);

    void trackWebViewRelease(int i, long j, long j2);

    void trackWvInterceptorRequestError(int i, String str, Exception exc);
}
