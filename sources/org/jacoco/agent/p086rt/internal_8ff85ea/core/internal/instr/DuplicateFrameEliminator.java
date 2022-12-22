package org.jacoco.agent.p086rt.internal_8ff85ea.core.internal.instr;

import org.jacoco.agent.p086rt.internal_8ff85ea.asm.Handle;
import org.jacoco.agent.p086rt.internal_8ff85ea.asm.Label;
import org.jacoco.agent.p086rt.internal_8ff85ea.asm.MethodVisitor;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.core.internal.instr.DuplicateFrameEliminator */
class DuplicateFrameEliminator extends MethodVisitor {
    private boolean instruction = true;

    public DuplicateFrameEliminator(MethodVisitor methodVisitor) {
        super(327680, methodVisitor);
    }

    public void visitFrame(int i, int i2, Object[] objArr, int i3, Object[] objArr2) {
        if (this.instruction) {
            this.instruction = false;
            this.f6585mv.visitFrame(i, i2, objArr, i3, objArr2);
        }
    }

    public void visitInsn(int i) {
        this.instruction = true;
        this.f6585mv.visitInsn(i);
    }

    public void visitIntInsn(int i, int i2) {
        this.instruction = true;
        this.f6585mv.visitIntInsn(i, i2);
    }

    public void visitVarInsn(int i, int i2) {
        this.instruction = true;
        this.f6585mv.visitVarInsn(i, i2);
    }

    public void visitTypeInsn(int i, String str) {
        this.instruction = true;
        this.f6585mv.visitTypeInsn(i, str);
    }

    public void visitFieldInsn(int i, String str, String str2, String str3) {
        this.instruction = true;
        this.f6585mv.visitFieldInsn(i, str, str2, str3);
    }

    public void visitMethodInsn(int i, String str, String str2, String str3, boolean z) {
        this.instruction = true;
        this.f6585mv.visitMethodInsn(i, str, str2, str3, z);
    }

    public void visitInvokeDynamicInsn(String str, String str2, Handle handle, Object... objArr) {
        this.instruction = true;
        this.f6585mv.visitInvokeDynamicInsn(str, str2, handle, objArr);
    }

    public void visitJumpInsn(int i, Label label) {
        this.instruction = true;
        this.f6585mv.visitJumpInsn(i, label);
    }

    public void visitLdcInsn(Object obj) {
        this.instruction = true;
        this.f6585mv.visitLdcInsn(obj);
    }

    public void visitIincInsn(int i, int i2) {
        this.instruction = true;
        this.f6585mv.visitIincInsn(i, i2);
    }

    public void visitTableSwitchInsn(int i, int i2, Label label, Label... labelArr) {
        this.instruction = true;
        this.f6585mv.visitTableSwitchInsn(i, i2, label, labelArr);
    }

    public void visitLookupSwitchInsn(Label label, int[] iArr, Label[] labelArr) {
        this.instruction = true;
        this.f6585mv.visitLookupSwitchInsn(label, iArr, labelArr);
    }

    public void visitMultiANewArrayInsn(String str, int i) {
        this.instruction = true;
        this.f6585mv.visitMultiANewArrayInsn(str, i);
    }
}
