package org.jacoco.agent.p086rt.internal_8ff85ea.core.internal.flow;

import org.jacoco.agent.p086rt.internal_8ff85ea.asm.ClassVisitor;
import org.jacoco.agent.p086rt.internal_8ff85ea.asm.MethodVisitor;
import org.jacoco.agent.p086rt.internal_8ff85ea.asm.commons.AnalyzerAdapter;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.core.internal.flow.ClassProbesAdapter */
public class ClassProbesAdapter extends ClassVisitor implements IProbeIdGenerator {
    private static final MethodProbesVisitor EMPTY_METHOD_PROBES_VISITOR = new MethodProbesVisitor() {
    };
    private int counter = 0;

    /* renamed from: cv */
    private final ClassProbesVisitor f6592cv;
    /* access modifiers changed from: private */
    public String name;
    /* access modifiers changed from: private */
    public final boolean trackFrames;

    public ClassProbesAdapter(ClassProbesVisitor classProbesVisitor, boolean z) {
        super(327680, classProbesVisitor);
        this.f6592cv = classProbesVisitor;
        this.trackFrames = z;
    }

    public void visit(int i, int i2, String str, String str2, String str3, String[] strArr) {
        this.name = str;
        super.visit(i, i2, str, str2, str3, strArr);
    }

    public final MethodVisitor visitMethod(int i, String str, String str2, String str3, String[] strArr) {
        MethodProbesVisitor visitMethod = this.f6592cv.visitMethod(i, str, str2, str3, strArr);
        if (visitMethod == null) {
            visitMethod = EMPTY_METHOD_PROBES_VISITOR;
        }
        final MethodProbesVisitor methodProbesVisitor = visitMethod;
        return new MethodSanitizer((MethodVisitor) null, i, str, str2, str3, strArr) {
            public void visitEnd() {
                super.visitEnd();
                LabelFlowAnalyzer.markLabels(this);
                MethodProbesAdapter methodProbesAdapter = new MethodProbesAdapter(methodProbesVisitor, ClassProbesAdapter.this);
                if (ClassProbesAdapter.this.trackFrames) {
                    AnalyzerAdapter analyzerAdapter = new AnalyzerAdapter(ClassProbesAdapter.this.name, this.access, this.name, this.desc, methodProbesAdapter);
                    methodProbesAdapter.setAnalyzer(analyzerAdapter);
                    accept((MethodVisitor) analyzerAdapter);
                    return;
                }
                accept((MethodVisitor) methodProbesAdapter);
            }
        };
    }

    public void visitEnd() {
        this.f6592cv.visitTotalProbeCount(this.counter);
        super.visitEnd();
    }

    public int nextId() {
        int i = this.counter;
        this.counter = i + 1;
        return i;
    }
}
