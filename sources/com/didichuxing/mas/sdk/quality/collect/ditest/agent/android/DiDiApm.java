package com.didichuxing.mas.sdk.quality.collect.ditest.agent.android;

import android.content.Context;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.logging.AgentLog;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.logging.AgentLogManager;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.logging.AndroidAgentLog;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.logging.NullAgentLog;
import java.util.Map;

public class DiDiApm {
    public static final boolean DEBUG = true;

    /* renamed from: a */
    private static final AgentLog f47825a = AgentLogManager.getAgentLog();

    /* renamed from: b */
    private static final AgentConfiguration f47826b = new AgentConfiguration();

    /* renamed from: c */
    private static boolean f47827c = false;

    /* renamed from: f */
    private static DiDiApm f47828f;

    /* renamed from: d */
    private boolean f47829d = true;

    /* renamed from: e */
    private int f47830e = 3;

    /* renamed from: a */
    private boolean m34211a() {
        return false;
    }

    private DiDiApm() {
    }

    public static synchronized DiDiApm getInstance() {
        DiDiApm diDiApm;
        synchronized (DiDiApm.class) {
            if (f47828f == null) {
                f47828f = new DiDiApm();
            }
            diDiApm = f47828f;
        }
        return diDiApm;
    }

    public static void launch(Context context) {
        getInstance().withLogLevel(3).withLoggingEnabled(true).withDisabled(false).start(context);
    }

    public static void debugLaunch(Context context) {
        f47825a.debug("DiDi Apm Debug Mode!");
        getInstance().withLogLevel(5).withLoggingEnabled(true).withDisabled(false).start(context);
    }

    public DiDiApm withLoggingEnabled(boolean z) {
        this.f47829d = z;
        return this;
    }

    public DiDiApm withLogLevel(int i) {
        this.f47830e = i;
        return this;
    }

    public DiDiApm withDisabled(boolean z) {
        f47826b.setDisabled(z);
        return this;
    }

    public void setDisabled(boolean z) {
        f47826b.setDisabled(z);
    }

    public static void setApmNetEnable(boolean z) {
        f47826b.setApmNetEnable(z);
    }

    public static void setApmUiEnable(boolean z) {
        f47826b.setApmUiEnable(z);
    }

    public static void setUploadNetPerfEnable(boolean z) {
        f47826b.setUploadNetPerf(z);
    }

    public static void setUploadErrorDiagEnable(boolean z) {
        f47826b.setUploadErrorDiag(z);
    }

    public static void setNetEventLogUploadInterval(long j) {
        f47826b.setNetEventLogUploadInterval(j);
    }

    public void start(Context context) {
        if (f47827c) {
            f47825a.debug("DiDiApm is already running.");
            return;
        }
        try {
            f47825a.info("didi apm start!");
            AgentLogManager.setAgentLog(this.f47829d ? new AndroidAgentLog() : new NullAgentLog());
            f47825a.setLevel(this.f47830e);
            AndroidAgentImpl.init(context, f47826b);
            f47827c = true;
        } catch (Throwable th) {
            f47825a.error("Error occurred while starting the DiDi Apm agent!", th);
        }
    }

    public static boolean isStarted() {
        return f47827c;
    }

    public static void shutdown() {
        if (f47827c) {
            try {
                Agent.getImpl().stop();
            } finally {
                f47827c = false;
            }
        }
    }

    public static void setMaxTrafficPerDay(long j) {
        f47826b.setMaxTrafficPerDay(j);
    }

    public static void setMaxTrafficFiveMins(long j) {
        f47826b.setMaxTrafficFiveMinutes(j);
    }

    public static void setOverRequestTime(long j) {
        f47826b.setOverRequestTime(j);
    }

    public static void setMaxDiagPerDay(int i) {
        f47826b.setMaxUploadNetErrEventPerDay(i);
    }

    public static void setNetEventLogEnabled(boolean z) {
        f47826b.setNetEventLogEnabled(z);
    }

    public static void setMaxNetEventUploadNum(long j) {
        f47826b.setMaxNetEventUploadNum(j);
    }

    public static void setAllNetUploadEnable(boolean z) {
        f47826b.setAllNetUploadEnable(z);
    }

    public static void setAllNetUploadLimit(long j) {
        f47826b.setAllNetUploadLimit(j);
    }

    public static void initUploadUrls(String str) {
        if (!"".equals(str)) {
            if ("all".equals(str)) {
                f47826b.setUploadAllUrlEnable(true);
            } else {
                f47826b.setUploadAllUrlEnable(false);
            }
            f47826b.initWhiteListAllNetCollectMap(str);
        }
    }

    public static void addUploadUrlWhiteList(String str) {
        f47826b.addUploadUrlWhiteList(str);
    }

    public static void addUploadUrlWhiteListAll(Map<String, Boolean> map) {
        f47826b.addUploadUrlWhiteListAll(map);
    }

    public static void clearUploadUrlWhiteList() {
        f47826b.clearUploadUrlPath();
    }

    public static void setExceptionCollectRate(double d) {
        f47826b.setExceptionCollectRate(d);
    }
}
