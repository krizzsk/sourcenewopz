package org.jacoco.agent.p086rt.internal_8ff85ea.core.internal.instr;

import org.jacoco.agent.p086rt.internal_8ff85ea.asm.Label;
import org.jacoco.agent.p086rt.internal_8ff85ea.asm.MethodVisitor;
import org.jacoco.agent.p086rt.internal_8ff85ea.asm.Opcodes;
import org.jacoco.agent.p086rt.internal_8ff85ea.asm.Type;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.core.internal.instr.ProbeInserter */
class ProbeInserter extends MethodVisitor implements IProbeInserter {
    private int accessorStackSize;
    private final IProbeArrayStrategy arrayStrategy;
    private final boolean clinit;
    private final int variable;

    ProbeInserter(int i, String str, String str2, MethodVisitor methodVisitor, IProbeArrayStrategy iProbeArrayStrategy) {
        super(327680, methodVisitor);
        this.clinit = "<clinit>".equals(str);
        this.arrayStrategy = iProbeArrayStrategy;
        int i2 = (i & 8) == 0 ? 1 : 0;
        for (Type size : Type.getArgumentTypes(str2)) {
            i2 += size.getSize();
        }
        this.variable = i2;
    }

    public void insertProbe(int i) {
        this.f6585mv.visitVarInsn(25, this.variable);
        InstrSupport.push(this.f6585mv, i);
        this.f6585mv.visitInsn(4);
        this.f6585mv.visitInsn(84);
    }

    public void visitCode() {
        this.accessorStackSize = this.arrayStrategy.storeInstance(this.f6585mv, this.clinit, this.variable);
        this.f6585mv.visitCode();
    }

    public final void visitVarInsn(int i, int i2) {
        this.f6585mv.visitVarInsn(i, map(i2));
    }

    public final void visitIincInsn(int i, int i2) {
        this.f6585mv.visitIincInsn(map(i), i2);
    }

    public final void visitLocalVariable(String str, String str2, String str3, Label label, Label label2, int i) {
        this.f6585mv.visitLocalVariable(str, str2, str3, label, label2, map(i));
    }

    public void visitMaxs(int i, int i2) {
        this.f6585mv.visitMaxs(Math.max(i + 3, this.accessorStackSize), i2 + 1);
    }

    private int map(int i) {
        return i < this.variable ? i : i + 1;
    }

    public final void visitFrame(int i, int i2, Object[] objArr, int i3, Object[] objArr2) {
        int i4;
        if (i == -1) {
            Object[] objArr3 = new Object[(Math.max(i2, this.variable) + 1)];
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            while (true) {
                if (i5 < i2 || i6 <= this.variable) {
                    if (i6 == this.variable) {
                        i4 = i7 + 1;
                        objArr3[i7] = InstrSupport.DATAFIELD_DESC;
                    } else if (i5 < i2) {
                        int i8 = i5 + 1;
                        Integer num = objArr[i5];
                        int i9 = i7 + 1;
                        objArr3[i7] = num;
                        i6++;
                        if (num == Opcodes.LONG || num == Opcodes.DOUBLE) {
                            i6++;
                        }
                        i5 = i8;
                        i7 = i9;
                    } else {
                        i4 = i7 + 1;
                        objArr3[i7] = Opcodes.TOP;
                    }
                    i6++;
                    i7 = i4;
                } else {
                    this.f6585mv.visitFrame(i, i7, objArr3, i3, objArr2);
                    return;
                }
            }
        } else {
            throw new IllegalArgumentException("ClassReader.accept() should be called with EXPAND_FRAMES flag");
        }
    }
}
