package com.didichuxing.mas.sdk.quality.collect.ditest.agent.android;

import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.util.Encoder;
import com.didichuxing.mas.sdk.quality.collect.ditest.assistant.EnvSwitchManager;

public class Agent {
    public static final String VERSION = "1.1.0";

    /* renamed from: a */
    private static final AgentImpl f47794a = new NullAgentImpl();

    /* renamed from: b */
    private static Object f47795b = new Object();

    /* renamed from: c */
    private static AgentImpl f47796c = f47794a;

    /* renamed from: d */
    private static boolean f47797d = false;

    public static String getVersion() {
        return "1.1.0";
    }

    public static void setImpl(AgentImpl agentImpl) {
        synchronized (f47795b) {
            if (f47796c == null) {
                f47796c = f47794a;
            } else {
                f47796c = agentImpl;
            }
        }
    }

    public static AgentImpl getImpl() {
        AgentImpl agentImpl;
        synchronized (f47795b) {
            agentImpl = f47796c;
        }
        return agentImpl;
    }

    public static int getResponseBodyLimit() {
        return getImpl().getResponseBodyLimit();
    }

    public static String getActiveNetworkCarrier() {
        return getImpl().getNetworkCarrier();
    }

    public static String getActiveNetworkWanType() {
        return getImpl().getNetworkWanType();
    }

    public static void disable() {
        getImpl().disable();
    }

    public static boolean isDisabled() {
        return getImpl().isDisabled();
    }

    public static void start() {
        getImpl().start();
    }

    public static void stop() {
        getImpl().stop();
    }

    public static void setLocation(String str, String str2) {
        getImpl().setLocation(str, str2);
    }

    public static Encoder getEncoder() {
        return getImpl().getEncoder();
    }

    public static boolean isEnvSwitchEnable() {
        return f47797d && EnvSwitchManager.getInstance().isEffect();
    }

    public static void setEnvSwitchEnable(Boolean bool) {
        f47797d = bool.booleanValue();
    }

    public static boolean isApmNetEnable() {
        return getImpl().isApmNetEnable();
    }

    public static boolean isApmUiEnable() {
        return getImpl().isApmUiEnable();
    }

    public static boolean isUploadNetPerf() {
        return getImpl().isUploadNetPerf();
    }

    public static boolean isUploadErrorDiag() {
        return getImpl().isUploadErrorDiag();
    }

    public static boolean canUploadNetErrEvent() {
        return getImpl().canUploadNetErrEvent();
    }

    public static boolean isNetEventLogEnabled() {
        return getImpl().getAgentConfig().isNetEventLogEnabled();
    }

    public static boolean isUploadAllNetEnabled() {
        return getImpl().getAgentConfig().isAllNetUploadEnable();
    }

    public static long getMaxTrafficFiveMinutes() {
        return getImpl().getAgentConfig().getMaxTrafficFiveMinutes();
    }

    public static long getMaxTrafficPerDay() {
        return getImpl().getAgentConfig().getMaxTrafficPerDay();
    }
}
