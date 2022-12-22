package org.jacoco.agent.p086rt.internal_8ff85ea.asm.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.jacoco.agent.p086rt.internal_8ff85ea.asm.Label;
import org.jacoco.agent.p086rt.internal_8ff85ea.asm.MethodVisitor;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.asm.tree.TableSwitchInsnNode */
public class TableSwitchInsnNode extends AbstractInsnNode {
    public LabelNode dflt;
    public List<LabelNode> labels;
    public int max;
    public int min;

    public int getType() {
        return 11;
    }

    public TableSwitchInsnNode(int i, int i2, LabelNode labelNode, LabelNode... labelNodeArr) {
        super(170);
        this.min = i;
        this.max = i2;
        this.dflt = labelNode;
        ArrayList arrayList = new ArrayList();
        this.labels = arrayList;
        if (labelNodeArr != null) {
            arrayList.addAll(Arrays.asList(labelNodeArr));
        }
    }

    public void accept(MethodVisitor methodVisitor) {
        int size = this.labels.size();
        Label[] labelArr = new Label[size];
        for (int i = 0; i < size; i++) {
            labelArr[i] = this.labels.get(i).getLabel();
        }
        methodVisitor.visitTableSwitchInsn(this.min, this.max, this.dflt.getLabel(), labelArr);
        acceptAnnotations(methodVisitor);
    }

    public AbstractInsnNode clone(Map<LabelNode, LabelNode> map) {
        return new TableSwitchInsnNode(this.min, this.max, clone(this.dflt, map), clone(this.labels, map)).cloneAnnotations(this);
    }
}
