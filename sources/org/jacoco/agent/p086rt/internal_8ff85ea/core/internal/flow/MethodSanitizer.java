package org.jacoco.agent.p086rt.internal_8ff85ea.core.internal.flow;

import org.jacoco.agent.p086rt.internal_8ff85ea.asm.Label;
import org.jacoco.agent.p086rt.internal_8ff85ea.asm.MethodVisitor;
import org.jacoco.agent.p086rt.internal_8ff85ea.asm.commons.JSRInlinerAdapter;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.core.internal.flow.MethodSanitizer */
class MethodSanitizer extends JSRInlinerAdapter {
    MethodSanitizer(MethodVisitor methodVisitor, int i, String str, String str2, String str3, String[] strArr) {
        super(327680, methodVisitor, i, str, str2, str3, strArr);
    }

    public void visitLocalVariable(String str, String str2, String str3, Label label, Label label2, int i) {
        if (label.info != null && label2.info != null) {
            super.visitLocalVariable(str, str2, str3, label, label2, i);
        }
    }

    public void visitLineNumber(int i, Label label) {
        if (label.info != null) {
            super.visitLineNumber(i, label);
        }
    }
}
