package com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.logging;

public class AgentLogManager {

    /* renamed from: a */
    private static DefaultAgentLog f47999a = new DefaultAgentLog();

    public static AgentLog getAgentLog() {
        return f47999a;
    }

    public static void setAgentLog(AgentLog agentLog) {
        f47999a.setImpl(agentLog);
    }
}
