package org.jacoco.agent.p086rt.internal_8ff85ea.core.internal.instr;

import org.jacoco.agent.p086rt.internal_8ff85ea.asm.ClassVisitor;
import org.jacoco.agent.p086rt.internal_8ff85ea.asm.Label;
import org.jacoco.agent.p086rt.internal_8ff85ea.asm.MethodVisitor;
import org.jacoco.agent.p086rt.internal_8ff85ea.core.runtime.IExecutionDataAccessorGenerator;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.core.internal.instr.ClassFieldProbeArrayStrategy */
class ClassFieldProbeArrayStrategy implements IProbeArrayStrategy {
    private static final Object[] FRAME_LOCALS_EMPTY = new Object[0];
    private static final Object[] FRAME_STACK_ARRZ = {InstrSupport.DATAFIELD_DESC};
    private final IExecutionDataAccessorGenerator accessorGenerator;
    private final long classId;
    private final String className;
    private final boolean withFrames;

    ClassFieldProbeArrayStrategy(String str, long j, boolean z, IExecutionDataAccessorGenerator iExecutionDataAccessorGenerator) {
        this.className = str;
        this.classId = j;
        this.withFrames = z;
        this.accessorGenerator = iExecutionDataAccessorGenerator;
    }

    public int storeInstance(MethodVisitor methodVisitor, boolean z, int i) {
        methodVisitor.visitMethodInsn(184, this.className, InstrSupport.INITMETHOD_NAME, InstrSupport.INITMETHOD_DESC, false);
        methodVisitor.visitVarInsn(58, i);
        return 1;
    }

    public void addMembers(ClassVisitor classVisitor, int i) {
        createDataField(classVisitor);
        createInitMethod(classVisitor, i);
    }

    private void createDataField(ClassVisitor classVisitor) {
        classVisitor.visitField(4234, InstrSupport.DATAFIELD_NAME, InstrSupport.DATAFIELD_DESC, (String) null, (Object) null);
    }

    private void createInitMethod(ClassVisitor classVisitor, int i) {
        MethodVisitor visitMethod = classVisitor.visitMethod(4106, InstrSupport.INITMETHOD_NAME, InstrSupport.INITMETHOD_DESC, (String) null, (String[]) null);
        visitMethod.visitCode();
        visitMethod.visitFieldInsn(178, this.className, InstrSupport.DATAFIELD_NAME, InstrSupport.DATAFIELD_DESC);
        visitMethod.visitInsn(89);
        Label label = new Label();
        visitMethod.visitJumpInsn(199, label);
        visitMethod.visitInsn(87);
        int genInitializeDataField = genInitializeDataField(visitMethod, i);
        if (this.withFrames) {
            visitMethod.visitFrame(-1, 0, FRAME_LOCALS_EMPTY, 1, FRAME_STACK_ARRZ);
        }
        visitMethod.visitLabel(label);
        visitMethod.visitInsn(176);
        visitMethod.visitMaxs(Math.max(genInitializeDataField, 2), 0);
        visitMethod.visitEnd();
    }

    private int genInitializeDataField(MethodVisitor methodVisitor, int i) {
        int generateDataAccessor = this.accessorGenerator.generateDataAccessor(this.classId, this.className, i, methodVisitor);
        methodVisitor.visitInsn(89);
        methodVisitor.visitFieldInsn(179, this.className, InstrSupport.DATAFIELD_NAME, InstrSupport.DATAFIELD_DESC);
        return Math.max(generateDataAccessor, 2);
    }
}
