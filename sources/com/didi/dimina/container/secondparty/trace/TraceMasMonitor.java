package com.didi.dimina.container.secondparty.trace;

import com.didi.crossplatform.track.PTracker;
import com.didi.crossplatform.track.model.EngineItem;
import com.didi.crossplatform.track.model.PerformanceItem;
import com.didi.crossplatform.track.model.TrackConfig;
import com.didi.dimina.container.DMConfig;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.Dimina;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didichuxing.mas.sdk.quality.report.utils.Constants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0016\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0005J\u000e\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0016\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012J\u0016\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u001b\u001a\u00020\u00102\b\u0010\u001c\u001a\u0004\u0018\u00010\u0005J\u000e\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u0005J\u0016\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, mo175978d2 = {"Lcom/didi/dimina/container/secondparty/trace/TraceMasMonitor;", "", "mina", "Lcom/didi/dimina/container/DMMina;", "appVersion", "", "(Lcom/didi/dimina/container/DMMina;Ljava/lang/String;)V", "config", "Lcom/didi/crossplatform/track/model/TrackConfig;", "getConfig", "()Lcom/didi/crossplatform/track/model/TrackConfig;", "getMina", "()Lcom/didi/dimina/container/DMMina;", "tracer", "Lcom/didi/crossplatform/track/PTracker;", "traceDownloadMainBundle", "", "duration", "", "traceEngineInit", "traceError", "errorCode", "errorMessage", "traceFirstRenderTime", "traceFirstRenderTimeWithPath", "path", "traceInteractionTime", "tracePageSuccess", "pageUrl", "tracePageView", "tracejsFirstExecTime", "2party-impl_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: TraceMasMonitor.kt */
public final class TraceMasMonitor {

    /* renamed from: a */
    private PTracker f17453a = new PTracker(this.f17454b);

    /* renamed from: b */
    private final TrackConfig f17454b;

    /* renamed from: c */
    private final DMMina f17455c;

    public TraceMasMonitor(DMMina dMMina, String str) {
        Intrinsics.checkParameterIsNotNull(dMMina, "mina");
        Intrinsics.checkParameterIsNotNull(str, "appVersion");
        this.f17455c = dMMina;
        TrackConfig trackConfig = new TrackConfig();
        this.f17454b = trackConfig;
        DMConfig config = this.f17455c.getConfig();
        Intrinsics.checkExpressionValueIsNotNull(config, "mina.config");
        DMConfig.LaunchConfig launchConfig = config.getLaunchConfig();
        Intrinsics.checkExpressionValueIsNotNull(launchConfig, "mina.config.launchConfig");
        trackConfig.appId = launchConfig.getAppId();
        this.f17454b.sdkType = TrackConfig.TYPE_XINGHE;
        this.f17454b.sdkVersion = Dimina.getVersion();
        this.f17454b.appVersion = str;
    }

    public final DMMina getMina() {
        return this.f17455c;
    }

    public final TrackConfig getConfig() {
        return this.f17454b;
    }

    public final void tracePageSuccess(String str) {
        this.f17454b.pageUrl = str;
        this.f17453a.trackPageSuccess();
    }

    public final void traceFirstRenderTime(long j) {
        if (j <= ((long) 10000)) {
            this.f17453a.trackCommonPerformance(PerformanceItem.CommonIndicator.FS_RENDER_TIME, Long.valueOf(j));
        }
    }

    public final void traceFirstRenderTimeWithPath(String str, long j) {
        Intrinsics.checkParameterIsNotNull(str, "path");
        this.f17454b.pageUrl = str;
        traceFirstRenderTime(j);
    }

    public final void tracejsFirstExecTime(String str, long j) {
        Intrinsics.checkParameterIsNotNull(str, "path");
        this.f17454b.pageUrl = str;
        if (j <= ((long) 10000)) {
            this.f17453a.trackCommonPerformance(PerformanceItem.CommonIndicator.JS_FIRST_EXEC_TIME, Long.valueOf(j));
        }
    }

    public final void traceInteractionTime(String str, long j) {
        Intrinsics.checkParameterIsNotNull(str, "path");
        this.f17454b.pageUrl = str;
        if (j <= ((long) 600000)) {
            this.f17453a.trackCommonPerformance(PerformanceItem.CommonIndicator.INTERACTION_TIME, Long.valueOf(j));
        }
    }

    public final void tracePageView(String str) {
        Intrinsics.checkParameterIsNotNull(str, "pageUrl");
        this.f17454b.pageUrl = str;
        this.f17453a.trackPageView();
    }

    public final void traceError(String str, String str2) {
        Intrinsics.checkParameterIsNotNull(str, Constants.ERROR_CODE);
        Intrinsics.checkParameterIsNotNull(str2, ParamConst.PARAM_ERROR_MESSAGE);
        this.f17453a.trackError("dmError", str, str2, (Map<String, Object>) null);
    }

    public final void traceEngineInit(long j) {
        this.f17453a.trackCommonEngine(EngineItem.CommonIndicator.ENGINE_INIT, true, "", j);
    }

    public final void traceDownloadMainBundle(long j) {
        this.f17453a.trackCommonEngine(EngineItem.CommonIndicator.DOWNLOAD_BUNDLE, true, "", j);
    }
}
