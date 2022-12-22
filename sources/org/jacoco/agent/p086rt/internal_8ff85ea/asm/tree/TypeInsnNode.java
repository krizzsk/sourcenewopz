package org.jacoco.agent.p086rt.internal_8ff85ea.asm.tree;

import java.util.Map;
import org.jacoco.agent.p086rt.internal_8ff85ea.asm.MethodVisitor;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.asm.tree.TypeInsnNode */
public class TypeInsnNode extends AbstractInsnNode {
    public String desc;

    public int getType() {
        return 3;
    }

    public TypeInsnNode(int i, String str) {
        super(i);
        this.desc = str;
    }

    public void setOpcode(int i) {
        this.opcode = i;
    }

    public void accept(MethodVisitor methodVisitor) {
        methodVisitor.visitTypeInsn(this.opcode, this.desc);
        acceptAnnotations(methodVisitor);
    }

    public AbstractInsnNode clone(Map<LabelNode, LabelNode> map) {
        return new TypeInsnNode(this.opcode, this.desc).cloneAnnotations(this);
    }
}
