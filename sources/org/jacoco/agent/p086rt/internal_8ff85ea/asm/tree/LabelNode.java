package org.jacoco.agent.p086rt.internal_8ff85ea.asm.tree;

import java.util.Map;
import org.jacoco.agent.p086rt.internal_8ff85ea.asm.Label;
import org.jacoco.agent.p086rt.internal_8ff85ea.asm.MethodVisitor;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.asm.tree.LabelNode */
public class LabelNode extends AbstractInsnNode {
    private Label label;

    public int getType() {
        return 8;
    }

    public LabelNode() {
        super(-1);
    }

    public LabelNode(Label label2) {
        super(-1);
        this.label = label2;
    }

    public Label getLabel() {
        if (this.label == null) {
            this.label = new Label();
        }
        return this.label;
    }

    public void accept(MethodVisitor methodVisitor) {
        methodVisitor.visitLabel(getLabel());
    }

    public AbstractInsnNode clone(Map<LabelNode, LabelNode> map) {
        return map.get(this);
    }

    public void resetLabel() {
        this.label = null;
    }
}
