package com.didi.dimina.container.monitor;

import com.didi.dimina.container.Dimina;
import com.didi.dimina.container.jsengine.JSArray;
import com.didi.dimina.container.util.LogUtil;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J1\u0010\n\u001a\u0002H\u000b\"\u0004\b\u0000\u0010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0011H\u0007¢\u0006\u0002\u0010\u0012R$\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0013"}, mo175978d2 = {"Lcom/didi/dimina/container/monitor/TimeTrackMonitor;", "", "()V", "deFaultTimeOut", "", "deFaultTimeOut$annotations", "getDeFaultTimeOut", "()J", "setDeFaultTimeOut", "(J)V", "timeTrackAction", "T", "traceTag", "Lcom/didi/dimina/container/monitor/MonitorConfig;", "data", "Lcom/didi/dimina/container/jsengine/JSArray;", "trackMethod", "Lkotlin/Function0;", "(Lcom/didi/dimina/container/monitor/MonitorConfig;Lcom/didi/dimina/container/jsengine/JSArray;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "container_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: TimeTrackMonitor.kt */
public final class TimeTrackMonitor {
    public static final TimeTrackMonitor INSTANCE = new TimeTrackMonitor();

    /* renamed from: a */
    private static long f16961a = 10;

    @JvmStatic
    public static /* synthetic */ void deFaultTimeOut$annotations() {
    }

    private TimeTrackMonitor() {
    }

    public static final long getDeFaultTimeOut() {
        return f16961a;
    }

    public static final void setDeFaultTimeOut(long j) {
        f16961a = j;
    }

    @JvmStatic
    public static final <T> T timeTrackAction(MonitorConfig monitorConfig, JSArray jSArray, Function0<? extends T> function0) {
        Intrinsics.checkParameterIsNotNull(monitorConfig, "traceTag");
        Intrinsics.checkParameterIsNotNull(jSArray, "data");
        Intrinsics.checkParameterIsNotNull(function0, "trackMethod");
        Dimina.Config config = Dimina.getConfig();
        Intrinsics.checkExpressionValueIsNotNull(config, "Dimina.getConfig()");
        if (!config.isDebug() || !monitorConfig.isPrintLog()) {
            return function0.invoke();
        }
        long currentTimeMillis = System.currentTimeMillis();
        T invoke = function0.invoke();
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (currentTimeMillis2 < f16961a) {
            return invoke;
        }
        LogUtil.m13407d("耗时过长:" + currentTimeMillis2 + "ms 命令长度:" + jSArray.toJSONString().length() + ' ' + monitorConfig.getTagName() + ' ' + jSArray.toJSONString() + ' ');
        return invoke;
    }
}
