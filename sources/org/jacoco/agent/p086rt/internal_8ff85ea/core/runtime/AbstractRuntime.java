package org.jacoco.agent.p086rt.internal_8ff85ea.core.runtime;

import java.util.Random;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.core.runtime.AbstractRuntime */
public abstract class AbstractRuntime implements IRuntime {
    private static final Random RANDOM = new Random();
    protected RuntimeData data;

    public void startup(RuntimeData runtimeData) throws Exception {
        this.data = runtimeData;
    }

    public static String createRandomId() {
        return Integer.toHexString(RANDOM.nextInt());
    }
}
