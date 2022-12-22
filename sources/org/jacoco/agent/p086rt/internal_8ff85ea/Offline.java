package org.jacoco.agent.p086rt.internal_8ff85ea;

import org.jacoco.agent.p086rt.internal_8ff85ea.core.runtime.AgentOptions;
import org.jacoco.agent.p086rt.internal_8ff85ea.core.runtime.RuntimeData;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.Offline */
public final class Offline {
    private static final String CONFIG_RESOURCE = "/jacoco-agent.properties";
    private static final RuntimeData DATA = Agent.getInstance(new AgentOptions(ConfigLoader.load(CONFIG_RESOURCE, System.getProperties()))).getData();

    private Offline() {
    }

    public static boolean[] getProbes(long j, String str, int i) {
        return DATA.getExecutionData(Long.valueOf(j), str, i).getProbes();
    }
}
