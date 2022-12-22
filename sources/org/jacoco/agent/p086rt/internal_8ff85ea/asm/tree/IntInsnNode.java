package org.jacoco.agent.p086rt.internal_8ff85ea.asm.tree;

import java.util.Map;
import org.jacoco.agent.p086rt.internal_8ff85ea.asm.MethodVisitor;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.asm.tree.IntInsnNode */
public class IntInsnNode extends AbstractInsnNode {
    public int operand;

    public int getType() {
        return 1;
    }

    public IntInsnNode(int i, int i2) {
        super(i);
        this.operand = i2;
    }

    public void setOpcode(int i) {
        this.opcode = i;
    }

    public void accept(MethodVisitor methodVisitor) {
        methodVisitor.visitIntInsn(this.opcode, this.operand);
        acceptAnnotations(methodVisitor);
    }

    public AbstractInsnNode clone(Map<LabelNode, LabelNode> map) {
        return new IntInsnNode(this.opcode, this.operand).cloneAnnotations(this);
    }
}
