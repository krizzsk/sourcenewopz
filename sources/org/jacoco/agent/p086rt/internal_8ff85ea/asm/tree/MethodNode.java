package org.jacoco.agent.p086rt.internal_8ff85ea.asm.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.jacoco.agent.p086rt.internal_8ff85ea.asm.AnnotationVisitor;
import org.jacoco.agent.p086rt.internal_8ff85ea.asm.Attribute;
import org.jacoco.agent.p086rt.internal_8ff85ea.asm.ClassVisitor;
import org.jacoco.agent.p086rt.internal_8ff85ea.asm.Handle;
import org.jacoco.agent.p086rt.internal_8ff85ea.asm.Label;
import org.jacoco.agent.p086rt.internal_8ff85ea.asm.MethodVisitor;
import org.jacoco.agent.p086rt.internal_8ff85ea.asm.Type;
import org.jacoco.agent.p086rt.internal_8ff85ea.asm.TypePath;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.asm.tree.MethodNode */
public class MethodNode extends MethodVisitor {
    public int access;
    public Object annotationDefault;
    public List<Attribute> attrs;
    public String desc;
    public List<String> exceptions;
    public InsnList instructions;
    public List<AnnotationNode> invisibleAnnotations;
    public List<LocalVariableAnnotationNode> invisibleLocalVariableAnnotations;
    public List<AnnotationNode>[] invisibleParameterAnnotations;
    public List<TypeAnnotationNode> invisibleTypeAnnotations;
    public List<LocalVariableNode> localVariables;
    public int maxLocals;
    public int maxStack;
    public String name;
    public List<ParameterNode> parameters;
    public String signature;
    public List<TryCatchBlockNode> tryCatchBlocks;
    public List<AnnotationNode> visibleAnnotations;
    public List<LocalVariableAnnotationNode> visibleLocalVariableAnnotations;
    public List<AnnotationNode>[] visibleParameterAnnotations;
    public List<TypeAnnotationNode> visibleTypeAnnotations;
    private boolean visited;

    public void visitCode() {
    }

    public void visitEnd() {
    }

    public MethodNode() {
        this(327680);
        if (getClass() != MethodNode.class) {
            throw new IllegalStateException();
        }
    }

    public MethodNode(int i) {
        super(i);
        this.instructions = new InsnList();
    }

    public MethodNode(int i, String str, String str2, String str3, String[] strArr) {
        this(327680, i, str, str2, str3, strArr);
        if (getClass() != MethodNode.class) {
            throw new IllegalStateException();
        }
    }

    public MethodNode(int i, int i2, String str, String str2, String str3, String[] strArr) {
        super(i);
        this.access = i2;
        this.name = str;
        this.desc = str2;
        this.signature = str3;
        boolean z = false;
        this.exceptions = new ArrayList(strArr == null ? 0 : strArr.length);
        if (!((i2 & 1024) != 0 ? true : z)) {
            this.localVariables = new ArrayList(5);
        }
        this.tryCatchBlocks = new ArrayList();
        if (strArr != null) {
            this.exceptions.addAll(Arrays.asList(strArr));
        }
        this.instructions = new InsnList();
    }

    public void visitParameter(String str, int i) {
        if (this.parameters == null) {
            this.parameters = new ArrayList(5);
        }
        this.parameters.add(new ParameterNode(str, i));
    }

    public AnnotationVisitor visitAnnotationDefault() {
        return new AnnotationNode((List<Object>) new ArrayList<Object>(0) {
            public boolean add(Object obj) {
                MethodNode.this.annotationDefault = obj;
                return super.add(obj);
            }
        });
    }

    public AnnotationVisitor visitAnnotation(String str, boolean z) {
        AnnotationNode annotationNode = new AnnotationNode(str);
        if (z) {
            if (this.visibleAnnotations == null) {
                this.visibleAnnotations = new ArrayList(1);
            }
            this.visibleAnnotations.add(annotationNode);
        } else {
            if (this.invisibleAnnotations == null) {
                this.invisibleAnnotations = new ArrayList(1);
            }
            this.invisibleAnnotations.add(annotationNode);
        }
        return annotationNode;
    }

    public AnnotationVisitor visitTypeAnnotation(int i, TypePath typePath, String str, boolean z) {
        TypeAnnotationNode typeAnnotationNode = new TypeAnnotationNode(i, typePath, str);
        if (z) {
            if (this.visibleTypeAnnotations == null) {
                this.visibleTypeAnnotations = new ArrayList(1);
            }
            this.visibleTypeAnnotations.add(typeAnnotationNode);
        } else {
            if (this.invisibleTypeAnnotations == null) {
                this.invisibleTypeAnnotations = new ArrayList(1);
            }
            this.invisibleTypeAnnotations.add(typeAnnotationNode);
        }
        return typeAnnotationNode;
    }

    public AnnotationVisitor visitParameterAnnotation(int i, String str, boolean z) {
        AnnotationNode annotationNode = new AnnotationNode(str);
        if (z) {
            if (this.visibleParameterAnnotations == null) {
                this.visibleParameterAnnotations = (List[]) new List[Type.getArgumentTypes(this.desc).length];
            }
            List<AnnotationNode>[] listArr = this.visibleParameterAnnotations;
            if (listArr[i] == null) {
                listArr[i] = new ArrayList(1);
            }
            this.visibleParameterAnnotations[i].add(annotationNode);
        } else {
            if (this.invisibleParameterAnnotations == null) {
                this.invisibleParameterAnnotations = (List[]) new List[Type.getArgumentTypes(this.desc).length];
            }
            List<AnnotationNode>[] listArr2 = this.invisibleParameterAnnotations;
            if (listArr2[i] == null) {
                listArr2[i] = new ArrayList(1);
            }
            this.invisibleParameterAnnotations[i].add(annotationNode);
        }
        return annotationNode;
    }

    public void visitAttribute(Attribute attribute) {
        if (this.attrs == null) {
            this.attrs = new ArrayList(1);
        }
        this.attrs.add(attribute);
    }

    public void visitFrame(int i, int i2, Object[] objArr, int i3, Object[] objArr2) {
        Object[] objArr3;
        Object[] objArr4;
        InsnList insnList = this.instructions;
        if (objArr == null) {
            objArr3 = null;
        } else {
            objArr3 = getLabelNodes(objArr);
        }
        if (objArr2 == null) {
            objArr4 = null;
        } else {
            objArr4 = getLabelNodes(objArr2);
        }
        insnList.add((AbstractInsnNode) new FrameNode(i, i2, objArr3, i3, objArr4));
    }

    public void visitInsn(int i) {
        this.instructions.add((AbstractInsnNode) new InsnNode(i));
    }

    public void visitIntInsn(int i, int i2) {
        this.instructions.add((AbstractInsnNode) new IntInsnNode(i, i2));
    }

    public void visitVarInsn(int i, int i2) {
        this.instructions.add((AbstractInsnNode) new VarInsnNode(i, i2));
    }

    public void visitTypeInsn(int i, String str) {
        this.instructions.add((AbstractInsnNode) new TypeInsnNode(i, str));
    }

    public void visitFieldInsn(int i, String str, String str2, String str3) {
        this.instructions.add((AbstractInsnNode) new FieldInsnNode(i, str, str2, str3));
    }

    @Deprecated
    public void visitMethodInsn(int i, String str, String str2, String str3) {
        if (this.api >= 327680) {
            super.visitMethodInsn(i, str, str2, str3);
        } else {
            this.instructions.add((AbstractInsnNode) new MethodInsnNode(i, str, str2, str3));
        }
    }

    public void visitMethodInsn(int i, String str, String str2, String str3, boolean z) {
        if (this.api < 327680) {
            super.visitMethodInsn(i, str, str2, str3, z);
        } else {
            this.instructions.add((AbstractInsnNode) new MethodInsnNode(i, str, str2, str3, z));
        }
    }

    public void visitInvokeDynamicInsn(String str, String str2, Handle handle, Object... objArr) {
        this.instructions.add((AbstractInsnNode) new InvokeDynamicInsnNode(str, str2, handle, objArr));
    }

    public void visitJumpInsn(int i, Label label) {
        this.instructions.add((AbstractInsnNode) new JumpInsnNode(i, getLabelNode(label)));
    }

    public void visitLabel(Label label) {
        this.instructions.add((AbstractInsnNode) getLabelNode(label));
    }

    public void visitLdcInsn(Object obj) {
        this.instructions.add((AbstractInsnNode) new LdcInsnNode(obj));
    }

    public void visitIincInsn(int i, int i2) {
        this.instructions.add((AbstractInsnNode) new IincInsnNode(i, i2));
    }

    public void visitTableSwitchInsn(int i, int i2, Label label, Label... labelArr) {
        this.instructions.add((AbstractInsnNode) new TableSwitchInsnNode(i, i2, getLabelNode(label), getLabelNodes(labelArr)));
    }

    public void visitLookupSwitchInsn(Label label, int[] iArr, Label[] labelArr) {
        this.instructions.add((AbstractInsnNode) new LookupSwitchInsnNode(getLabelNode(label), iArr, getLabelNodes(labelArr)));
    }

    public void visitMultiANewArrayInsn(String str, int i) {
        this.instructions.add((AbstractInsnNode) new MultiANewArrayInsnNode(str, i));
    }

    public AnnotationVisitor visitInsnAnnotation(int i, TypePath typePath, String str, boolean z) {
        AbstractInsnNode last = this.instructions.getLast();
        while (last.getOpcode() == -1) {
            last = last.getPrevious();
        }
        TypeAnnotationNode typeAnnotationNode = new TypeAnnotationNode(i, typePath, str);
        if (z) {
            if (last.visibleTypeAnnotations == null) {
                last.visibleTypeAnnotations = new ArrayList(1);
            }
            last.visibleTypeAnnotations.add(typeAnnotationNode);
        } else {
            if (last.invisibleTypeAnnotations == null) {
                last.invisibleTypeAnnotations = new ArrayList(1);
            }
            last.invisibleTypeAnnotations.add(typeAnnotationNode);
        }
        return typeAnnotationNode;
    }

    public void visitTryCatchBlock(Label label, Label label2, Label label3, String str) {
        this.tryCatchBlocks.add(new TryCatchBlockNode(getLabelNode(label), getLabelNode(label2), getLabelNode(label3), str));
    }

    public AnnotationVisitor visitTryCatchAnnotation(int i, TypePath typePath, String str, boolean z) {
        TryCatchBlockNode tryCatchBlockNode = this.tryCatchBlocks.get((16776960 & i) >> 8);
        TypeAnnotationNode typeAnnotationNode = new TypeAnnotationNode(i, typePath, str);
        if (z) {
            if (tryCatchBlockNode.visibleTypeAnnotations == null) {
                tryCatchBlockNode.visibleTypeAnnotations = new ArrayList(1);
            }
            tryCatchBlockNode.visibleTypeAnnotations.add(typeAnnotationNode);
        } else {
            if (tryCatchBlockNode.invisibleTypeAnnotations == null) {
                tryCatchBlockNode.invisibleTypeAnnotations = new ArrayList(1);
            }
            tryCatchBlockNode.invisibleTypeAnnotations.add(typeAnnotationNode);
        }
        return typeAnnotationNode;
    }

    public void visitLocalVariable(String str, String str2, String str3, Label label, Label label2, int i) {
        this.localVariables.add(new LocalVariableNode(str, str2, str3, getLabelNode(label), getLabelNode(label2), i));
    }

    public AnnotationVisitor visitLocalVariableAnnotation(int i, TypePath typePath, Label[] labelArr, Label[] labelArr2, int[] iArr, String str, boolean z) {
        LocalVariableAnnotationNode localVariableAnnotationNode = new LocalVariableAnnotationNode(i, typePath, getLabelNodes(labelArr), getLabelNodes(labelArr2), iArr, str);
        if (z) {
            if (this.visibleLocalVariableAnnotations == null) {
                this.visibleLocalVariableAnnotations = new ArrayList(1);
            }
            this.visibleLocalVariableAnnotations.add(localVariableAnnotationNode);
        } else {
            if (this.invisibleLocalVariableAnnotations == null) {
                this.invisibleLocalVariableAnnotations = new ArrayList(1);
            }
            this.invisibleLocalVariableAnnotations.add(localVariableAnnotationNode);
        }
        return localVariableAnnotationNode;
    }

    public void visitLineNumber(int i, Label label) {
        this.instructions.add((AbstractInsnNode) new LineNumberNode(i, getLabelNode(label)));
    }

    public void visitMaxs(int i, int i2) {
        this.maxStack = i;
        this.maxLocals = i2;
    }

    /* access modifiers changed from: protected */
    public LabelNode getLabelNode(Label label) {
        if (!(label.info instanceof LabelNode)) {
            label.info = new LabelNode();
        }
        return (LabelNode) label.info;
    }

    private LabelNode[] getLabelNodes(Label[] labelArr) {
        LabelNode[] labelNodeArr = new LabelNode[labelArr.length];
        for (int i = 0; i < labelArr.length; i++) {
            labelNodeArr[i] = getLabelNode(labelArr[i]);
        }
        return labelNodeArr;
    }

    private Object[] getLabelNodes(Object[] objArr) {
        Object[] objArr2 = new Object[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            LabelNode labelNode = objArr[i];
            if (labelNode instanceof Label) {
                labelNode = getLabelNode((Label) labelNode);
            }
            objArr2[i] = labelNode;
        }
        return objArr2;
    }

    public void check(int i) {
        if (i == 262144) {
            List<TypeAnnotationNode> list = this.visibleTypeAnnotations;
            if (list == null || list.size() <= 0) {
                List<TypeAnnotationNode> list2 = this.invisibleTypeAnnotations;
                if (list2 == null || list2.size() <= 0) {
                    List<TryCatchBlockNode> list3 = this.tryCatchBlocks;
                    int size = list3 == null ? 0 : list3.size();
                    int i2 = 0;
                    while (i2 < size) {
                        TryCatchBlockNode tryCatchBlockNode = this.tryCatchBlocks.get(i2);
                        if (tryCatchBlockNode.visibleTypeAnnotations != null && tryCatchBlockNode.visibleTypeAnnotations.size() > 0) {
                            throw new RuntimeException();
                        } else if (tryCatchBlockNode.invisibleTypeAnnotations == null || tryCatchBlockNode.invisibleTypeAnnotations.size() <= 0) {
                            i2++;
                        } else {
                            throw new RuntimeException();
                        }
                    }
                    int i3 = 0;
                    while (i3 < this.instructions.size()) {
                        AbstractInsnNode abstractInsnNode = this.instructions.get(i3);
                        if (abstractInsnNode.visibleTypeAnnotations != null && abstractInsnNode.visibleTypeAnnotations.size() > 0) {
                            throw new RuntimeException();
                        } else if (abstractInsnNode.invisibleTypeAnnotations == null || abstractInsnNode.invisibleTypeAnnotations.size() <= 0) {
                            if (abstractInsnNode instanceof MethodInsnNode) {
                                if (((MethodInsnNode) abstractInsnNode).itf != (abstractInsnNode.opcode == 185)) {
                                    throw new RuntimeException();
                                }
                            }
                            i3++;
                        } else {
                            throw new RuntimeException();
                        }
                    }
                    List<LocalVariableAnnotationNode> list4 = this.visibleLocalVariableAnnotations;
                    if (list4 == null || list4.size() <= 0) {
                        List<LocalVariableAnnotationNode> list5 = this.invisibleLocalVariableAnnotations;
                        if (list5 != null && list5.size() > 0) {
                            throw new RuntimeException();
                        }
                        return;
                    }
                    throw new RuntimeException();
                }
                throw new RuntimeException();
            }
            throw new RuntimeException();
        }
    }

    public void accept(ClassVisitor classVisitor) {
        String[] strArr = new String[this.exceptions.size()];
        this.exceptions.toArray(strArr);
        MethodVisitor visitMethod = classVisitor.visitMethod(this.access, this.name, this.desc, this.signature, strArr);
        if (visitMethod != null) {
            accept(visitMethod);
        }
    }

    public void accept(MethodVisitor methodVisitor) {
        int i;
        int i2;
        int i3;
        List<ParameterNode> list = this.parameters;
        int size = list == null ? 0 : list.size();
        for (int i4 = 0; i4 < size; i4++) {
            ParameterNode parameterNode = this.parameters.get(i4);
            methodVisitor.visitParameter(parameterNode.name, parameterNode.access);
        }
        if (this.annotationDefault != null) {
            AnnotationVisitor visitAnnotationDefault = methodVisitor.visitAnnotationDefault();
            AnnotationNode.accept(visitAnnotationDefault, (String) null, this.annotationDefault);
            if (visitAnnotationDefault != null) {
                visitAnnotationDefault.visitEnd();
            }
        }
        List<AnnotationNode> list2 = this.visibleAnnotations;
        int size2 = list2 == null ? 0 : list2.size();
        for (int i5 = 0; i5 < size2; i5++) {
            AnnotationNode annotationNode = this.visibleAnnotations.get(i5);
            annotationNode.accept(methodVisitor.visitAnnotation(annotationNode.desc, true));
        }
        List<AnnotationNode> list3 = this.invisibleAnnotations;
        int size3 = list3 == null ? 0 : list3.size();
        for (int i6 = 0; i6 < size3; i6++) {
            AnnotationNode annotationNode2 = this.invisibleAnnotations.get(i6);
            annotationNode2.accept(methodVisitor.visitAnnotation(annotationNode2.desc, false));
        }
        List<TypeAnnotationNode> list4 = this.visibleTypeAnnotations;
        int size4 = list4 == null ? 0 : list4.size();
        for (int i7 = 0; i7 < size4; i7++) {
            TypeAnnotationNode typeAnnotationNode = this.visibleTypeAnnotations.get(i7);
            typeAnnotationNode.accept(methodVisitor.visitTypeAnnotation(typeAnnotationNode.typeRef, typeAnnotationNode.typePath, typeAnnotationNode.desc, true));
        }
        List<TypeAnnotationNode> list5 = this.invisibleTypeAnnotations;
        if (list5 == null) {
            i = 0;
        } else {
            i = list5.size();
        }
        for (int i8 = 0; i8 < i; i8++) {
            TypeAnnotationNode typeAnnotationNode2 = this.invisibleTypeAnnotations.get(i8);
            typeAnnotationNode2.accept(methodVisitor.visitTypeAnnotation(typeAnnotationNode2.typeRef, typeAnnotationNode2.typePath, typeAnnotationNode2.desc, false));
        }
        List<AnnotationNode>[] listArr = this.visibleParameterAnnotations;
        int length = listArr == null ? 0 : listArr.length;
        for (int i9 = 0; i9 < length; i9++) {
            List<AnnotationNode> list6 = this.visibleParameterAnnotations[i9];
            if (list6 != null) {
                for (int i10 = 0; i10 < list6.size(); i10++) {
                    AnnotationNode annotationNode3 = list6.get(i10);
                    annotationNode3.accept(methodVisitor.visitParameterAnnotation(i9, annotationNode3.desc, true));
                }
            }
        }
        List<AnnotationNode>[] listArr2 = this.invisibleParameterAnnotations;
        int length2 = listArr2 == null ? 0 : listArr2.length;
        for (int i11 = 0; i11 < length2; i11++) {
            List<AnnotationNode> list7 = this.invisibleParameterAnnotations[i11];
            if (list7 != null) {
                for (int i12 = 0; i12 < list7.size(); i12++) {
                    AnnotationNode annotationNode4 = list7.get(i12);
                    annotationNode4.accept(methodVisitor.visitParameterAnnotation(i11, annotationNode4.desc, false));
                }
            }
        }
        if (this.visited) {
            this.instructions.resetLabels();
        }
        List<Attribute> list8 = this.attrs;
        int size5 = list8 == null ? 0 : list8.size();
        for (int i13 = 0; i13 < size5; i13++) {
            methodVisitor.visitAttribute(this.attrs.get(i13));
        }
        if (this.instructions.size() > 0) {
            methodVisitor.visitCode();
            List<TryCatchBlockNode> list9 = this.tryCatchBlocks;
            int size6 = list9 == null ? 0 : list9.size();
            for (int i14 = 0; i14 < size6; i14++) {
                this.tryCatchBlocks.get(i14).updateIndex(i14);
                this.tryCatchBlocks.get(i14).accept(methodVisitor);
            }
            this.instructions.accept(methodVisitor);
            List<LocalVariableNode> list10 = this.localVariables;
            int size7 = list10 == null ? 0 : list10.size();
            for (int i15 = 0; i15 < size7; i15++) {
                this.localVariables.get(i15).accept(methodVisitor);
            }
            List<LocalVariableAnnotationNode> list11 = this.visibleLocalVariableAnnotations;
            if (list11 == null) {
                i2 = 0;
            } else {
                i2 = list11.size();
            }
            for (int i16 = 0; i16 < i2; i16++) {
                this.visibleLocalVariableAnnotations.get(i16).accept(methodVisitor, true);
            }
            List<LocalVariableAnnotationNode> list12 = this.invisibleLocalVariableAnnotations;
            if (list12 == null) {
                i3 = 0;
            } else {
                i3 = list12.size();
            }
            for (int i17 = 0; i17 < i3; i17++) {
                this.invisibleLocalVariableAnnotations.get(i17).accept(methodVisitor, false);
            }
            methodVisitor.visitMaxs(this.maxStack, this.maxLocals);
            this.visited = true;
        }
        methodVisitor.visitEnd();
    }
}
