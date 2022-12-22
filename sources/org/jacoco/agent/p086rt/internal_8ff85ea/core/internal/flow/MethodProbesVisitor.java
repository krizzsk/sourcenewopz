package org.jacoco.agent.p086rt.internal_8ff85ea.core.internal.flow;

import org.jacoco.agent.p086rt.internal_8ff85ea.asm.Label;
import org.jacoco.agent.p086rt.internal_8ff85ea.asm.MethodVisitor;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.core.internal.flow.MethodProbesVisitor */
public abstract class MethodProbesVisitor extends MethodVisitor {
    public void visitInsnWithProbe(int i, int i2) {
    }

    public void visitJumpInsnWithProbe(int i, Label label, int i2, IFrame iFrame) {
    }

    public void visitLookupSwitchInsnWithProbes(Label label, int[] iArr, Label[] labelArr, IFrame iFrame) {
    }

    public void visitProbe(int i) {
    }

    public void visitTableSwitchInsnWithProbes(int i, int i2, Label label, Label[] labelArr, IFrame iFrame) {
    }

    public MethodProbesVisitor() {
        this((MethodVisitor) null);
    }

    public MethodProbesVisitor(MethodVisitor methodVisitor) {
        super(327680, methodVisitor);
    }
}
