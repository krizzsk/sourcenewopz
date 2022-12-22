package org.jacoco.agent.p086rt.internal_8ff85ea.core.internal.instr;

import org.jacoco.agent.p086rt.internal_8ff85ea.core.internal.flow.ClassProbesVisitor;
import org.jacoco.agent.p086rt.internal_8ff85ea.core.internal.flow.MethodProbesVisitor;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.core.internal.instr.ProbeCounter */
class ProbeCounter extends ClassProbesVisitor {
    private int count = 0;
    private boolean methods = false;

    ProbeCounter() {
    }

    public MethodProbesVisitor visitMethod(int i, String str, String str2, String str3, String[] strArr) {
        if ("<clinit>".equals(str) || (i & 1024) != 0) {
            return null;
        }
        this.methods = true;
        return null;
    }

    public void visitTotalProbeCount(int i) {
        this.count = i;
    }

    /* access modifiers changed from: package-private */
    public int getCount() {
        return this.count;
    }

    /* access modifiers changed from: package-private */
    public boolean hasMethods() {
        return this.methods;
    }
}
