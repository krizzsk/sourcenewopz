package org.jacoco.agent.p086rt.internal_8ff85ea.asm.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.jacoco.agent.p086rt.internal_8ff85ea.asm.MethodVisitor;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.asm.tree.AbstractInsnNode */
public abstract class AbstractInsnNode {
    public static final int FIELD_INSN = 4;
    public static final int FRAME = 14;
    public static final int IINC_INSN = 10;
    public static final int INSN = 0;
    public static final int INT_INSN = 1;
    public static final int INVOKE_DYNAMIC_INSN = 6;
    public static final int JUMP_INSN = 7;
    public static final int LABEL = 8;
    public static final int LDC_INSN = 9;
    public static final int LINE = 15;
    public static final int LOOKUPSWITCH_INSN = 12;
    public static final int METHOD_INSN = 5;
    public static final int MULTIANEWARRAY_INSN = 13;
    public static final int TABLESWITCH_INSN = 11;
    public static final int TYPE_INSN = 3;
    public static final int VAR_INSN = 2;
    int index = -1;
    public List<TypeAnnotationNode> invisibleTypeAnnotations;
    AbstractInsnNode next;
    protected int opcode;
    AbstractInsnNode prev;
    public List<TypeAnnotationNode> visibleTypeAnnotations;

    public abstract void accept(MethodVisitor methodVisitor);

    public abstract AbstractInsnNode clone(Map<LabelNode, LabelNode> map);

    public abstract int getType();

    protected AbstractInsnNode(int i) {
        this.opcode = i;
    }

    public int getOpcode() {
        return this.opcode;
    }

    public AbstractInsnNode getPrevious() {
        return this.prev;
    }

    public AbstractInsnNode getNext() {
        return this.next;
    }

    /* access modifiers changed from: protected */
    public final void acceptAnnotations(MethodVisitor methodVisitor) {
        int i;
        int i2;
        List<TypeAnnotationNode> list = this.visibleTypeAnnotations;
        if (list == null) {
            i = 0;
        } else {
            i = list.size();
        }
        for (int i3 = 0; i3 < i; i3++) {
            TypeAnnotationNode typeAnnotationNode = this.visibleTypeAnnotations.get(i3);
            typeAnnotationNode.accept(methodVisitor.visitInsnAnnotation(typeAnnotationNode.typeRef, typeAnnotationNode.typePath, typeAnnotationNode.desc, true));
        }
        List<TypeAnnotationNode> list2 = this.invisibleTypeAnnotations;
        if (list2 == null) {
            i2 = 0;
        } else {
            i2 = list2.size();
        }
        for (int i4 = 0; i4 < i2; i4++) {
            TypeAnnotationNode typeAnnotationNode2 = this.invisibleTypeAnnotations.get(i4);
            typeAnnotationNode2.accept(methodVisitor.visitInsnAnnotation(typeAnnotationNode2.typeRef, typeAnnotationNode2.typePath, typeAnnotationNode2.desc, false));
        }
    }

    static LabelNode clone(LabelNode labelNode, Map<LabelNode, LabelNode> map) {
        return map.get(labelNode);
    }

    static LabelNode[] clone(List<LabelNode> list, Map<LabelNode, LabelNode> map) {
        int size = list.size();
        LabelNode[] labelNodeArr = new LabelNode[size];
        for (int i = 0; i < size; i++) {
            labelNodeArr[i] = map.get(list.get(i));
        }
        return labelNodeArr;
    }

    /* access modifiers changed from: protected */
    public final AbstractInsnNode cloneAnnotations(AbstractInsnNode abstractInsnNode) {
        if (abstractInsnNode.visibleTypeAnnotations != null) {
            this.visibleTypeAnnotations = new ArrayList();
            for (int i = 0; i < abstractInsnNode.visibleTypeAnnotations.size(); i++) {
                TypeAnnotationNode typeAnnotationNode = abstractInsnNode.visibleTypeAnnotations.get(i);
                TypeAnnotationNode typeAnnotationNode2 = new TypeAnnotationNode(typeAnnotationNode.typeRef, typeAnnotationNode.typePath, typeAnnotationNode.desc);
                typeAnnotationNode.accept(typeAnnotationNode2);
                this.visibleTypeAnnotations.add(typeAnnotationNode2);
            }
        }
        if (abstractInsnNode.invisibleTypeAnnotations != null) {
            this.invisibleTypeAnnotations = new ArrayList();
            for (int i2 = 0; i2 < abstractInsnNode.invisibleTypeAnnotations.size(); i2++) {
                TypeAnnotationNode typeAnnotationNode3 = abstractInsnNode.invisibleTypeAnnotations.get(i2);
                TypeAnnotationNode typeAnnotationNode4 = new TypeAnnotationNode(typeAnnotationNode3.typeRef, typeAnnotationNode3.typePath, typeAnnotationNode3.desc);
                typeAnnotationNode3.accept(typeAnnotationNode4);
                this.invisibleTypeAnnotations.add(typeAnnotationNode4);
            }
        }
        return this;
    }
}
