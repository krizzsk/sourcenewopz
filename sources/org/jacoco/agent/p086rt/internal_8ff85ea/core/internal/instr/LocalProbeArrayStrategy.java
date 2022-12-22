package org.jacoco.agent.p086rt.internal_8ff85ea.core.internal.instr;

import org.jacoco.agent.p086rt.internal_8ff85ea.asm.ClassVisitor;
import org.jacoco.agent.p086rt.internal_8ff85ea.asm.MethodVisitor;
import org.jacoco.agent.p086rt.internal_8ff85ea.core.runtime.IExecutionDataAccessorGenerator;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.core.internal.instr.LocalProbeArrayStrategy */
class LocalProbeArrayStrategy implements IProbeArrayStrategy {
    private final IExecutionDataAccessorGenerator accessorGenerator;
    private final long classId;
    private final String className;
    private final int probeCount;

    public void addMembers(ClassVisitor classVisitor, int i) {
    }

    LocalProbeArrayStrategy(String str, long j, int i, IExecutionDataAccessorGenerator iExecutionDataAccessorGenerator) {
        this.className = str;
        this.classId = j;
        this.probeCount = i;
        this.accessorGenerator = iExecutionDataAccessorGenerator;
    }

    public int storeInstance(MethodVisitor methodVisitor, boolean z, int i) {
        int generateDataAccessor = this.accessorGenerator.generateDataAccessor(this.classId, this.className, this.probeCount, methodVisitor);
        methodVisitor.visitVarInsn(58, i);
        return generateDataAccessor;
    }
}
