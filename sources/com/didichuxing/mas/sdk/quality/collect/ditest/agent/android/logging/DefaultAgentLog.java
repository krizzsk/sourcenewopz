package com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.logging;

public class DefaultAgentLog implements AgentLog {

    /* renamed from: a */
    private AgentLog f48003a = new AndroidAgentLog();

    public void setImpl(AgentLog agentLog) {
        synchronized (this) {
            this.f48003a = agentLog;
        }
    }

    public void debug(String str) {
        synchronized (this) {
            this.f48003a.debug(str);
        }
    }

    public void info(String str) {
        synchronized (this) {
            this.f48003a.info(str);
        }
    }

    public void verbose(String str) {
        synchronized (this) {
            this.f48003a.verbose(str);
        }
    }

    public void warning(String str) {
        synchronized (this) {
            this.f48003a.warning(str);
        }
    }

    public void error(String str) {
        synchronized (this) {
            this.f48003a.error(str);
        }
    }

    public void error(String str, Throwable th) {
        synchronized (this) {
            this.f48003a.error(str, th);
        }
    }

    public int getLevel() {
        int level;
        synchronized (this) {
            level = this.f48003a.getLevel();
        }
        return level;
    }

    public void setLevel(int i) {
        synchronized (this) {
            this.f48003a.setLevel(i);
        }
    }
}
