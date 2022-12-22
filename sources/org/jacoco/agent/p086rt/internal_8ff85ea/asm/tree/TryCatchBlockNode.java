package org.jacoco.agent.p086rt.internal_8ff85ea.asm.tree;

import java.util.List;
import org.jacoco.agent.p086rt.internal_8ff85ea.asm.Label;
import org.jacoco.agent.p086rt.internal_8ff85ea.asm.MethodVisitor;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.asm.tree.TryCatchBlockNode */
public class TryCatchBlockNode {
    public LabelNode end;
    public LabelNode handler;
    public List<TypeAnnotationNode> invisibleTypeAnnotations;
    public LabelNode start;
    public String type;
    public List<TypeAnnotationNode> visibleTypeAnnotations;

    public TryCatchBlockNode(LabelNode labelNode, LabelNode labelNode2, LabelNode labelNode3, String str) {
        this.start = labelNode;
        this.end = labelNode2;
        this.handler = labelNode3;
        this.type = str;
    }

    public void updateIndex(int i) {
        int i2 = (i << 8) | 1107296256;
        List<TypeAnnotationNode> list = this.visibleTypeAnnotations;
        if (list != null) {
            for (TypeAnnotationNode typeAnnotationNode : list) {
                typeAnnotationNode.typeRef = i2;
            }
        }
        List<TypeAnnotationNode> list2 = this.invisibleTypeAnnotations;
        if (list2 != null) {
            for (TypeAnnotationNode typeAnnotationNode2 : list2) {
                typeAnnotationNode2.typeRef = i2;
            }
        }
    }

    public void accept(MethodVisitor methodVisitor) {
        Label label;
        int i;
        int i2;
        Label label2 = this.start.getLabel();
        Label label3 = this.end.getLabel();
        LabelNode labelNode = this.handler;
        if (labelNode == null) {
            label = null;
        } else {
            label = labelNode.getLabel();
        }
        methodVisitor.visitTryCatchBlock(label2, label3, label, this.type);
        List<TypeAnnotationNode> list = this.visibleTypeAnnotations;
        if (list == null) {
            i = 0;
        } else {
            i = list.size();
        }
        for (int i3 = 0; i3 < i; i3++) {
            TypeAnnotationNode typeAnnotationNode = this.visibleTypeAnnotations.get(i3);
            typeAnnotationNode.accept(methodVisitor.visitTryCatchAnnotation(typeAnnotationNode.typeRef, typeAnnotationNode.typePath, typeAnnotationNode.desc, true));
        }
        List<TypeAnnotationNode> list2 = this.invisibleTypeAnnotations;
        if (list2 == null) {
            i2 = 0;
        } else {
            i2 = list2.size();
        }
        for (int i4 = 0; i4 < i2; i4++) {
            TypeAnnotationNode typeAnnotationNode2 = this.invisibleTypeAnnotations.get(i4);
            typeAnnotationNode2.accept(methodVisitor.visitTryCatchAnnotation(typeAnnotationNode2.typeRef, typeAnnotationNode2.typePath, typeAnnotationNode2.desc, false));
        }
    }
}
