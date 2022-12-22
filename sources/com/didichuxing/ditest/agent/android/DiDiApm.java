package com.didichuxing.ditest.agent.android;

import android.content.Context;
import com.didichuxing.ditest.agent.android.logging.AgentLog;
import com.didichuxing.ditest.agent.android.logging.AgentLogManager;
import com.didichuxing.ditest.agent.android.logging.AndroidAgentLog;
import com.didichuxing.ditest.agent.android.logging.NullAgentLog;
import java.util.Map;

public class DiDiApm {
    public static final boolean DEBUG = true;
    private static final AgentConfiguration agentConfiguration = new AgentConfiguration();
    private static DiDiApm instance;
    private static final AgentLog log = AgentLogManager.getAgentLog();
    private static boolean started = false;
    private int logLevel = 3;
    private boolean loggingEnabled = true;

    private boolean isInstrumented() {
        return false;
    }

    private DiDiApm() {
    }

    public static synchronized DiDiApm getInstance() {
        DiDiApm diDiApm;
        synchronized (DiDiApm.class) {
            if (instance == null) {
                instance = new DiDiApm();
            }
            diDiApm = instance;
        }
        return diDiApm;
    }

    public static void launch(Context context) {
        getInstance().withLogLevel(3).withLoggingEnabled(true).withDisabled(false).start(context);
    }

    public static void debugLaunch(Context context) {
        log.debug("DiDi Apm Debug Mode!");
        getInstance().withLogLevel(5).withLoggingEnabled(true).withDisabled(false).start(context);
    }

    public DiDiApm withLoggingEnabled(boolean z) {
        this.loggingEnabled = z;
        return this;
    }

    public DiDiApm withLogLevel(int i) {
        this.logLevel = i;
        return this;
    }

    public DiDiApm withDisabled(boolean z) {
        agentConfiguration.setDisabled(z);
        return this;
    }

    public void setDisabled(boolean z) {
        agentConfiguration.setDisabled(z);
    }

    public static void setApmNetEnable(boolean z) {
        agentConfiguration.setApmNetEnable(z);
    }

    public static void setApmUiEnable(boolean z) {
        agentConfiguration.setApmUiEnable(z);
    }

    public static void setUploadNetPerfEnable(boolean z) {
        agentConfiguration.setUploadNetPerf(z);
    }

    public static void setUploadErrorDiagEnable(boolean z) {
        agentConfiguration.setUploadErrorDiag(z);
    }

    public static void setNetEventLogUploadInterval(long j) {
        agentConfiguration.setNetEventLogUploadInterval(j);
    }

    public void start(Context context) {
        if (started) {
            log.debug("DiDiApm is already running.");
            return;
        }
        try {
            log.info("didi apm start!");
            AgentLogManager.setAgentLog(this.loggingEnabled ? new AndroidAgentLog() : new NullAgentLog());
            log.setLevel(this.logLevel);
            AndroidAgentImpl.init(context, agentConfiguration);
            started = true;
        } catch (Throwable th) {
            log.error("Error occurred while starting the DiDi Apm agent!", th);
        }
    }

    public static boolean isStarted() {
        return started;
    }

    public static void shutdown() {
        if (started) {
            try {
                Agent.getImpl().stop();
            } finally {
                started = false;
            }
        }
    }

    public static void setMaxTrafficPerDay(long j) {
        agentConfiguration.setMaxTrafficPerDay(j);
    }

    public static void setMaxTrafficFiveMins(long j) {
        agentConfiguration.setMaxTrafficFiveMinutes(j);
    }

    public static void setOverRequestTime(long j) {
        agentConfiguration.setOverRequestTime(j);
    }

    public static void setMaxDiagPerDay(int i) {
        agentConfiguration.setMaxUploadNetErrEventPerDay(i);
    }

    public static void setNetEventLogEnabled(boolean z) {
        agentConfiguration.setNetEventLogEnabled(z);
    }

    public static void setMaxNetEventUploadNum(long j) {
        agentConfiguration.setMaxNetEventUploadNum(j);
    }

    public static void setAllNetUploadEnable(boolean z) {
        agentConfiguration.setAllNetUploadEnable(z);
    }

    public static void setAllNetUploadLimit(long j) {
        agentConfiguration.setAllNetUploadLimit(j);
    }

    public static void initUploadUrls(String str) {
        if (!"".equals(str)) {
            if ("all".equals(str)) {
                agentConfiguration.setUploadAllUrlEnable(true);
            } else {
                agentConfiguration.setUploadAllUrlEnable(false);
            }
            agentConfiguration.initWhiteListAllNetCollectMap(str);
        }
    }

    public static void addUploadUrlWhiteList(String str) {
        agentConfiguration.addUploadUrlWhiteList(str);
    }

    public static void addUploadUrlWhiteListAll(Map<String, Boolean> map) {
        agentConfiguration.addUploadUrlWhiteListAll(map);
    }

    public static void clearUploadUrlWhiteList() {
        agentConfiguration.clearUploadUrlPath();
    }

    public static void setExceptionCollectRate(double d) {
        agentConfiguration.setExceptionCollectRate(d);
    }
}
