package org.jacoco.agent.p086rt.internal_8ff85ea.asm.tree;

import java.util.Map;
import org.jacoco.agent.p086rt.internal_8ff85ea.asm.MethodVisitor;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.asm.tree.FieldInsnNode */
public class FieldInsnNode extends AbstractInsnNode {
    public String desc;
    public String name;
    public String owner;

    public int getType() {
        return 4;
    }

    public FieldInsnNode(int i, String str, String str2, String str3) {
        super(i);
        this.owner = str;
        this.name = str2;
        this.desc = str3;
    }

    public void setOpcode(int i) {
        this.opcode = i;
    }

    public void accept(MethodVisitor methodVisitor) {
        methodVisitor.visitFieldInsn(this.opcode, this.owner, this.name, this.desc);
        acceptAnnotations(methodVisitor);
    }

    public AbstractInsnNode clone(Map<LabelNode, LabelNode> map) {
        return new FieldInsnNode(this.opcode, this.owner, this.name, this.desc).cloneAnnotations(this);
    }
}
