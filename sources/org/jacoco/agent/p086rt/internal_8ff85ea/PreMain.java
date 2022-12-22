package org.jacoco.agent.p086rt.internal_8ff85ea;

import java.lang.instrument.Instrumentation;
import org.jacoco.agent.p086rt.internal_8ff85ea.core.runtime.AgentOptions;
import org.jacoco.agent.p086rt.internal_8ff85ea.core.runtime.IRuntime;
import org.jacoco.agent.p086rt.internal_8ff85ea.core.runtime.ModifiedSystemClassRuntime;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.PreMain */
public final class PreMain {
    private PreMain() {
    }

    public static void premain(String str, Instrumentation instrumentation) throws Exception {
        AgentOptions agentOptions = new AgentOptions(str);
        Agent instance = Agent.getInstance(agentOptions);
        IRuntime createRuntime = createRuntime(instrumentation);
        createRuntime.startup(instance.getData());
        instrumentation.addTransformer(new CoverageTransformer(createRuntime, agentOptions, IExceptionLogger.SYSTEM_ERR));
    }

    private static IRuntime createRuntime(Instrumentation instrumentation) throws Exception {
        return ModifiedSystemClassRuntime.createFor(instrumentation, "java/util/UUID");
    }
}
