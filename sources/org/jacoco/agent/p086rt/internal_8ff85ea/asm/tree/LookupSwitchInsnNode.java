package org.jacoco.agent.p086rt.internal_8ff85ea.asm.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.jacoco.agent.p086rt.internal_8ff85ea.asm.Label;
import org.jacoco.agent.p086rt.internal_8ff85ea.asm.MethodVisitor;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.asm.tree.LookupSwitchInsnNode */
public class LookupSwitchInsnNode extends AbstractInsnNode {
    public LabelNode dflt;
    public List<Integer> keys;
    public List<LabelNode> labels;

    public int getType() {
        return 12;
    }

    public LookupSwitchInsnNode(LabelNode labelNode, int[] iArr, LabelNode[] labelNodeArr) {
        super(171);
        this.dflt = labelNode;
        this.keys = new ArrayList(iArr == null ? 0 : iArr.length);
        this.labels = new ArrayList(labelNodeArr == null ? 0 : labelNodeArr.length);
        if (iArr != null) {
            for (int valueOf : iArr) {
                this.keys.add(Integer.valueOf(valueOf));
            }
        }
        if (labelNodeArr != null) {
            this.labels.addAll(Arrays.asList(labelNodeArr));
        }
    }

    public void accept(MethodVisitor methodVisitor) {
        int size = this.keys.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = this.keys.get(i).intValue();
        }
        int size2 = this.labels.size();
        Label[] labelArr = new Label[size2];
        for (int i2 = 0; i2 < size2; i2++) {
            labelArr[i2] = this.labels.get(i2).getLabel();
        }
        methodVisitor.visitLookupSwitchInsn(this.dflt.getLabel(), iArr, labelArr);
        acceptAnnotations(methodVisitor);
    }

    public AbstractInsnNode clone(Map<LabelNode, LabelNode> map) {
        LookupSwitchInsnNode lookupSwitchInsnNode = new LookupSwitchInsnNode(clone(this.dflt, map), (int[]) null, clone(this.labels, map));
        lookupSwitchInsnNode.keys.addAll(this.keys);
        return lookupSwitchInsnNode.cloneAnnotations(this);
    }
}
