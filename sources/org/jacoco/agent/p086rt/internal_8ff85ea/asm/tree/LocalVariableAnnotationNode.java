package org.jacoco.agent.p086rt.internal_8ff85ea.asm.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.jacoco.agent.p086rt.internal_8ff85ea.asm.Label;
import org.jacoco.agent.p086rt.internal_8ff85ea.asm.MethodVisitor;
import org.jacoco.agent.p086rt.internal_8ff85ea.asm.TypePath;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.asm.tree.LocalVariableAnnotationNode */
public class LocalVariableAnnotationNode extends TypeAnnotationNode {
    public List<LabelNode> end;
    public List<Integer> index;
    public List<LabelNode> start;

    public LocalVariableAnnotationNode(int i, TypePath typePath, LabelNode[] labelNodeArr, LabelNode[] labelNodeArr2, int[] iArr, String str) {
        this(327680, i, typePath, labelNodeArr, labelNodeArr2, iArr, str);
    }

    public LocalVariableAnnotationNode(int i, int i2, TypePath typePath, LabelNode[] labelNodeArr, LabelNode[] labelNodeArr2, int[] iArr, String str) {
        super(i, i2, typePath, str);
        ArrayList arrayList = new ArrayList(labelNodeArr.length);
        this.start = arrayList;
        arrayList.addAll(Arrays.asList(labelNodeArr));
        ArrayList arrayList2 = new ArrayList(labelNodeArr2.length);
        this.end = arrayList2;
        arrayList2.addAll(Arrays.asList(labelNodeArr2));
        this.index = new ArrayList(iArr.length);
        for (int valueOf : iArr) {
            this.index.add(Integer.valueOf(valueOf));
        }
    }

    public void accept(MethodVisitor methodVisitor, boolean z) {
        int size = this.start.size();
        Label[] labelArr = new Label[size];
        Label[] labelArr2 = new Label[this.end.size()];
        int[] iArr = new int[this.index.size()];
        for (int i = 0; i < size; i++) {
            labelArr[i] = this.start.get(i).getLabel();
            labelArr2[i] = this.end.get(i).getLabel();
            iArr[i] = this.index.get(i).intValue();
        }
        accept(methodVisitor.visitLocalVariableAnnotation(this.typeRef, this.typePath, labelArr, labelArr2, iArr, this.desc, true));
    }
}
