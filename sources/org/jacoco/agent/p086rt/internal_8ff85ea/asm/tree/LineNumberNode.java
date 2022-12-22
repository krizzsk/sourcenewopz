package org.jacoco.agent.p086rt.internal_8ff85ea.asm.tree;

import java.util.Map;
import org.jacoco.agent.p086rt.internal_8ff85ea.asm.MethodVisitor;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.asm.tree.LineNumberNode */
public class LineNumberNode extends AbstractInsnNode {
    public int line;
    public LabelNode start;

    public int getType() {
        return 15;
    }

    public LineNumberNode(int i, LabelNode labelNode) {
        super(-1);
        this.line = i;
        this.start = labelNode;
    }

    public void accept(MethodVisitor methodVisitor) {
        methodVisitor.visitLineNumber(this.line, this.start.getLabel());
    }

    public AbstractInsnNode clone(Map<LabelNode, LabelNode> map) {
        return new LineNumberNode(this.line, clone(this.start, map));
    }
}
