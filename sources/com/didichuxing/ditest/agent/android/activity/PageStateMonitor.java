package com.didichuxing.ditest.agent.android.activity;

import com.didichuxing.ditest.agent.android.Agent;
import com.didichuxing.ditest.agent.android.logging.AgentLog;
import com.didichuxing.ditest.agent.android.logging.AgentLogManager;
import com.didichuxing.omega.sdk.analysis.Tracker;
import java.util.HashMap;

public class PageStateMonitor {
    private static PageStateMonitor instance = new PageStateMonitor();
    private static final AgentLog log = AgentLogManager.getAgentLog();

    public static PageStateMonitor getInstance() {
        return instance;
    }

    public void pageStarted(String str) {
        if (Agent.isApmUiEnable()) {
            AgentLog agentLog = log;
            agentLog.debug("--page started:" + str);
            pageEventTrace("apm_page_start", str);
        }
    }

    public void pageCreated(String str) {
        if (Agent.isApmUiEnable()) {
            AgentLog agentLog = log;
            agentLog.debug("--page created:" + str);
            pageEventTrace("apm_page_create", str);
        }
    }

    public void pageResumed(String str) {
        if (Agent.isApmUiEnable()) {
            AgentLog agentLog = log;
            agentLog.debug("--page resumed:" + str);
            pageEventTrace("apm_page_resume", str);
        }
    }

    private void pageEventTrace(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("ts", Long.valueOf(System.currentTimeMillis()));
        hashMap.put("page", str2);
        Tracker.trackEvent(str, (String) null, hashMap);
    }
}
