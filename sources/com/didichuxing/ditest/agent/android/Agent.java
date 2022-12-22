package com.didichuxing.ditest.agent.android;

import com.didichuxing.ditest.agent.android.util.Encoder;
import com.didichuxing.ditest.assistant.EnvSwitchManager;

public class Agent {
    private static final AgentImpl NULL_AGENT_IMPL = new NullAgentImpl();
    public static final String VERSION = "1.1.0";
    private static boolean envSwitchEnable = false;
    private static AgentImpl impl = NULL_AGENT_IMPL;
    private static Object implLock = new Object();

    public static String getVersion() {
        return "1.1.0";
    }

    public static void setImpl(AgentImpl agentImpl) {
        synchronized (implLock) {
            if (impl == null) {
                impl = NULL_AGENT_IMPL;
            } else {
                impl = agentImpl;
            }
        }
    }

    public static AgentImpl getImpl() {
        AgentImpl agentImpl;
        synchronized (implLock) {
            agentImpl = impl;
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
        return envSwitchEnable && EnvSwitchManager.getInstance().isEffect();
    }

    public static void setEnvSwitchEnable(Boolean bool) {
        envSwitchEnable = bool.booleanValue();
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
