package org.jacoco.agent.p086rt.internal_8ff85ea.asm;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.asm.AnnotationVisitor */
public abstract class AnnotationVisitor {
    protected final int api;

    /* renamed from: av */
    protected AnnotationVisitor f6577av;

    public AnnotationVisitor(int i) {
        this(i, (AnnotationVisitor) null);
    }

    public AnnotationVisitor(int i, AnnotationVisitor annotationVisitor) {
        if (i == 262144 || i == 327680) {
            this.api = i;
            this.f6577av = annotationVisitor;
            return;
        }
        throw new IllegalArgumentException();
    }

    public void visit(String str, Object obj) {
        AnnotationVisitor annotationVisitor = this.f6577av;
        if (annotationVisitor != null) {
            annotationVisitor.visit(str, obj);
        }
    }

    public void visitEnum(String str, String str2, String str3) {
        AnnotationVisitor annotationVisitor = this.f6577av;
        if (annotationVisitor != null) {
            annotationVisitor.visitEnum(str, str2, str3);
        }
    }

    public AnnotationVisitor visitAnnotation(String str, String str2) {
        AnnotationVisitor annotationVisitor = this.f6577av;
        if (annotationVisitor != null) {
            return annotationVisitor.visitAnnotation(str, str2);
        }
        return null;
    }

    public AnnotationVisitor visitArray(String str) {
        AnnotationVisitor annotationVisitor = this.f6577av;
        if (annotationVisitor != null) {
            return annotationVisitor.visitArray(str);
        }
        return null;
    }

    public void visitEnd() {
        AnnotationVisitor annotationVisitor = this.f6577av;
        if (annotationVisitor != null) {
            annotationVisitor.visitEnd();
        }
    }
}
