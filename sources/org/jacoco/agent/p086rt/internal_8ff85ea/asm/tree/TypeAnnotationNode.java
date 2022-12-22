package org.jacoco.agent.p086rt.internal_8ff85ea.asm.tree;

import org.jacoco.agent.p086rt.internal_8ff85ea.asm.TypePath;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.asm.tree.TypeAnnotationNode */
public class TypeAnnotationNode extends AnnotationNode {
    public TypePath typePath;
    public int typeRef;

    public TypeAnnotationNode(int i, TypePath typePath2, String str) {
        this(327680, i, typePath2, str);
        if (getClass() != TypeAnnotationNode.class) {
            throw new IllegalStateException();
        }
    }

    public TypeAnnotationNode(int i, int i2, TypePath typePath2, String str) {
        super(i, str);
        this.typeRef = i2;
        this.typePath = typePath2;
    }
}
