package org.jacoco.agent.p086rt.internal_8ff85ea.core.internal.flow;

import org.jacoco.agent.p086rt.internal_8ff85ea.asm.Handle;
import org.jacoco.agent.p086rt.internal_8ff85ea.asm.Label;
import org.jacoco.agent.p086rt.internal_8ff85ea.asm.MethodVisitor;
import org.jacoco.agent.p086rt.internal_8ff85ea.asm.tree.MethodNode;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.core.internal.flow.LabelFlowAnalyzer */
public final class LabelFlowAnalyzer extends MethodVisitor {
    boolean first = true;
    Label lineStart = null;
    boolean successor = false;

    public static void markLabels(MethodNode methodNode) {
        LabelFlowAnalyzer labelFlowAnalyzer = new LabelFlowAnalyzer();
        int size = methodNode.tryCatchBlocks.size();
        while (true) {
            size--;
            if (size >= 0) {
                methodNode.tryCatchBlocks.get(size).accept(labelFlowAnalyzer);
            } else {
                methodNode.instructions.accept(labelFlowAnalyzer);
                return;
            }
        }
    }

    public LabelFlowAnalyzer() {
        super(327680);
    }

    public void visitTryCatchBlock(Label label, Label label2, Label label3, String str) {
        LabelInfo.setTarget(label);
        LabelInfo.setTarget(label3);
    }

    public void visitJumpInsn(int i, Label label) {
        LabelInfo.setTarget(label);
        if (i != 168) {
            this.successor = i != 167;
            this.first = false;
            return;
        }
        throw new AssertionError("Subroutines not supported.");
    }

    public void visitLabel(Label label) {
        if (this.first) {
            LabelInfo.setTarget(label);
        }
        if (this.successor) {
            LabelInfo.setSuccessor(label);
        }
    }

    public void visitLineNumber(int i, Label label) {
        this.lineStart = label;
    }

    public void visitTableSwitchInsn(int i, int i2, Label label, Label... labelArr) {
        visitSwitchInsn(label, labelArr);
    }

    public void visitLookupSwitchInsn(Label label, int[] iArr, Label[] labelArr) {
        visitSwitchInsn(label, labelArr);
    }

    private void visitSwitchInsn(Label label, Label[] labelArr) {
        LabelInfo.resetDone(label);
        LabelInfo.resetDone(labelArr);
        setTargetIfNotDone(label);
        for (Label targetIfNotDone : labelArr) {
            setTargetIfNotDone(targetIfNotDone);
        }
        this.successor = false;
        this.first = false;
    }

    private static void setTargetIfNotDone(Label label) {
        if (!LabelInfo.isDone(label)) {
            LabelInfo.setTarget(label);
            LabelInfo.setDone(label);
        }
    }

    public void visitInsn(int i) {
        if (i != 169) {
            if (i != 191) {
                switch (i) {
                    case 172:
                    case 173:
                    case 174:
                    case 175:
                    case 176:
                    case 177:
                        break;
                    default:
                        this.successor = true;
                        break;
                }
            }
            this.successor = false;
            this.first = false;
            return;
        }
        throw new AssertionError("Subroutines not supported.");
    }

    public void visitIntInsn(int i, int i2) {
        this.successor = true;
        this.first = false;
    }

    public void visitVarInsn(int i, int i2) {
        this.successor = true;
        this.first = false;
    }

    public void visitTypeInsn(int i, String str) {
        this.successor = true;
        this.first = false;
    }

    public void visitFieldInsn(int i, String str, String str2, String str3) {
        this.successor = true;
        this.first = false;
    }

    public void visitMethodInsn(int i, String str, String str2, String str3, boolean z) {
        this.successor = true;
        this.first = false;
        markMethodInvocationLine();
    }

    public void visitInvokeDynamicInsn(String str, String str2, Handle handle, Object... objArr) {
        this.successor = true;
        this.first = false;
        markMethodInvocationLine();
    }

    private void markMethodInvocationLine() {
        Label label = this.lineStart;
        if (label != null) {
            LabelInfo.setMethodInvocationLine(label);
        }
    }

    public void visitLdcInsn(Object obj) {
        this.successor = true;
        this.first = false;
    }

    public void visitIincInsn(int i, int i2) {
        this.successor = true;
        this.first = false;
    }

    public void visitMultiANewArrayInsn(String str, int i) {
        this.successor = true;
        this.first = false;
    }
}
