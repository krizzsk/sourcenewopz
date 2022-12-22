package org.jacoco.agent.p086rt.internal_8ff85ea.asm.tree;

import org.jacoco.agent.p086rt.internal_8ff85ea.asm.MethodVisitor;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.asm.tree.ParameterNode */
public class ParameterNode {
    public int access;
    public String name;

    public ParameterNode(String str, int i) {
        this.name = str;
        this.access = i;
    }

    public void accept(MethodVisitor methodVisitor) {
        methodVisitor.visitParameter(this.name, this.access);
    }
}
