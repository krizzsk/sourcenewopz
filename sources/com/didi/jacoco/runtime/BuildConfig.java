package com.didi.jacoco.runtime;

import org.jacoco.agent.p086rt.internal_8ff85ea.Offline;

public final class BuildConfig {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    public static final String APPLICATION_ID = "com.didi.jacoco.runtime";
    public static final String BUILD_TYPE = "release";
    public static final boolean DEBUG = Boolean.parseBoolean("true");
    public static final String FLAVOR = "";
    public static final int VERSION_CODE = 1;
    public static final String VERSION_NAME = "1.0";

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(1430968850922618855L, "com/didi/jacoco/runtime/BuildConfig", 2);
        $jacocoData = probes;
        return probes;
    }

    public BuildConfig() {
        $jacocoInit()[0] = true;
    }

    static {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[1] = true;
    }
}
