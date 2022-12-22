package com.google.auto.common;

import com.google.common.base.Preconditions;
import javax.lang.model.element.AnnotationValue;
import javax.lang.model.element.AnnotationValueVisitor;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;

public final class SimpleTypeAnnotationValue implements AnnotationValue {
    private final TypeMirror value;

    private SimpleTypeAnnotationValue(TypeMirror typeMirror) {
        Preconditions.checkArgument(typeMirror.getKind().isPrimitive() || typeMirror.getKind().equals(TypeKind.DECLARED) || typeMirror.getKind().equals(TypeKind.ARRAY), "value must be a primitive, array, or declared type, but was %s (%s)", (Object) typeMirror.getKind(), (Object) typeMirror);
        if (typeMirror.getKind().equals(TypeKind.DECLARED)) {
            Preconditions.checkArgument(MoreTypes.asDeclared(typeMirror).getTypeArguments().isEmpty(), "value must not be a parameterized type: %s", (Object) typeMirror);
        }
        this.value = typeMirror;
    }

    /* renamed from: of */
    public static AnnotationValue m38331of(TypeMirror typeMirror) {
        return new SimpleTypeAnnotationValue(typeMirror);
    }

    public TypeMirror getValue() {
        return this.value;
    }

    public String toString() {
        return this.value + ".class";
    }

    public <R, P> R accept(AnnotationValueVisitor<R, P> annotationValueVisitor, P p) {
        return annotationValueVisitor.visitType(getValue(), p);
    }
}
