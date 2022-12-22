package com.didi.jacoco.runtime;

import java.io.File;
import java.io.FileOutputStream;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jacoco.agent.p086rt.internal_8ff85ea.Offline;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0004\u001a\u00020\u0005*\u00020\u0006\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, mo175978d2 = {"AGENT_METHOD_NAME", "", "EXECUTION_DATA_METHOD_NAME", "RT_CLASS", "createEcFile", "", "Ljava/io/File;", "jacoco-runtime_release"}, mo175979k = 2, mo175980mv = {1, 1, 16})
/* compiled from: Entity.kt */
public final class EntityKt {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final String AGENT_METHOD_NAME = "getAgent";
    private static final String EXECUTION_DATA_METHOD_NAME = "getExecutionData";
    private static final String RT_CLASS = "org.jacoco.agent.rt.RT";

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-1261928119707794396L, "com/didi/jacoco/runtime/EntityKt", 7);
        $jacocoData = probes;
        return probes;
    }

    public static final void createEcFile(File file) {
        boolean[] $jacocoInit = $jacocoInit();
        Intrinsics.checkParameterIsNotNull(file, "$this$createEcFile");
        $jacocoInit[0] = true;
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        $jacocoInit[1] = true;
        Object invoke = Class.forName(RT_CLASS).getMethod(AGENT_METHOD_NAME, new Class[0]).invoke((Object) null, new Object[0]);
        $jacocoInit[2] = true;
        Object invoke2 = invoke.getClass().getMethod(EXECUTION_DATA_METHOD_NAME, new Class[]{Boolean.TYPE}).invoke(invoke, new Object[]{false});
        if (invoke2 != null) {
            $jacocoInit[4] = true;
            fileOutputStream.write((byte[]) invoke2);
            $jacocoInit[5] = true;
            fileOutputStream.close();
            $jacocoInit[6] = true;
            return;
        }
        TypeCastException typeCastException = new TypeCastException("null cannot be cast to non-null type kotlin.ByteArray");
        $jacocoInit[3] = true;
        throw typeCastException;
    }
}
