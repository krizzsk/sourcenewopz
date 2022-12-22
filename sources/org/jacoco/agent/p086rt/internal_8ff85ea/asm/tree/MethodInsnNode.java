package org.jacoco.agent.p086rt.internal_8ff85ea.asm.tree;

import java.util.Map;
import org.jacoco.agent.p086rt.internal_8ff85ea.asm.MethodVisitor;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.asm.tree.MethodInsnNode */
public class MethodInsnNode extends AbstractInsnNode {
    public String desc;
    public boolean itf;
    public String name;
    public String owner;

    public int getType() {
        return 5;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @Deprecated
    public MethodInsnNode(int i, String str, String str2, String str3) {
        this(i, str, str2, str3, i == 185);
    }

    public MethodInsnNode(int i, String str, String str2, String str3, boolean z) {
        super(i);
        this.owner = str;
        this.name = str2;
        this.desc = str3;
        this.itf = z;
    }

    public void setOpcode(int i) {
        this.opcode = i;
    }

    public void accept(MethodVisitor methodVisitor) {
        methodVisitor.visitMethodInsn(this.opcode, this.owner, this.name, this.desc, this.itf);
        acceptAnnotations(methodVisitor);
    }

    public AbstractInsnNode clone(Map<LabelNode, LabelNode> map) {
        return new MethodInsnNode(this.opcode, this.owner, this.name, this.desc, this.itf);
    }
}
