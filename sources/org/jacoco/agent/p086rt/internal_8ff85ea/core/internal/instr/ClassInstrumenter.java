package org.jacoco.agent.p086rt.internal_8ff85ea.core.internal.instr;

import org.jacoco.agent.p086rt.internal_8ff85ea.asm.ClassVisitor;
import org.jacoco.agent.p086rt.internal_8ff85ea.asm.FieldVisitor;
import org.jacoco.agent.p086rt.internal_8ff85ea.asm.MethodVisitor;
import org.jacoco.agent.p086rt.internal_8ff85ea.core.internal.flow.ClassProbesVisitor;
import org.jacoco.agent.p086rt.internal_8ff85ea.core.internal.flow.MethodProbesVisitor;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.core.internal.instr.ClassInstrumenter */
public class ClassInstrumenter extends ClassProbesVisitor {
    private String className;
    private final IProbeArrayStrategy probeArrayStrategy;

    public ClassInstrumenter(IProbeArrayStrategy iProbeArrayStrategy, ClassVisitor classVisitor) {
        super(classVisitor);
        this.probeArrayStrategy = iProbeArrayStrategy;
    }

    public void visit(int i, int i2, String str, String str2, String str3, String[] strArr) {
        this.className = str;
        super.visit(i, i2, str, str2, str3, strArr);
    }

    public FieldVisitor visitField(int i, String str, String str2, String str3, Object obj) {
        InstrSupport.assertNotInstrumented(str, this.className);
        return super.visitField(i, str, str2, str3, obj);
    }

    public MethodProbesVisitor visitMethod(int i, String str, String str2, String str3, String[] strArr) {
        InstrSupport.assertNotInstrumented(str, this.className);
        MethodVisitor visitMethod = this.f6581cv.visitMethod(i, str, str2, str3, strArr);
        if (visitMethod == null) {
            return null;
        }
        ProbeInserter probeInserter = new ProbeInserter(i, str, str2, new DuplicateFrameEliminator(visitMethod), this.probeArrayStrategy);
        return new MethodInstrumenter(probeInserter, probeInserter);
    }

    public void visitTotalProbeCount(int i) {
        this.probeArrayStrategy.addMembers(this.f6581cv, i);
    }
}
