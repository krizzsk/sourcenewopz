package com.google.auto.common;

import com.google.common.base.Equivalence;
import java.util.List;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.AnnotationValue;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.SimpleAnnotationValueVisitor6;

public final class AnnotationValues {
    private static final Equivalence<AnnotationValue> ANNOTATION_VALUE_EQUIVALENCE = new Equivalence<AnnotationValue>() {
        /* access modifiers changed from: protected */
        public boolean doEquivalent(AnnotationValue annotationValue, AnnotationValue annotationValue2) {
            return ((Boolean) annotationValue.accept(new SimpleAnnotationValueVisitor6<Boolean, AnnotationValue>() {
                /* access modifiers changed from: protected */
                public Boolean defaultAction(Object obj, AnnotationValue annotationValue) {
                    return Boolean.valueOf(obj.equals(annotationValue.accept(new SimpleAnnotationValueVisitor6<Object, Void>() {
                        /* access modifiers changed from: protected */
                        public Object defaultAction(Object obj, Void voidR) {
                            return obj;
                        }
                    }, (Object) null)));
                }

                public Boolean visitAnnotation(AnnotationMirror annotationMirror, AnnotationValue annotationValue) {
                    return (Boolean) annotationValue.accept(new SimpleAnnotationValueVisitor6<Boolean, AnnotationMirror>() {
                        /* access modifiers changed from: protected */
                        public Boolean defaultAction(Object obj, AnnotationMirror annotationMirror) {
                            return false;
                        }

                        public Boolean visitAnnotation(AnnotationMirror annotationMirror, AnnotationMirror annotationMirror2) {
                            return Boolean.valueOf(AnnotationMirrors.equivalence().equivalent(annotationMirror2, annotationMirror));
                        }
                    }, annotationMirror);
                }

                public Boolean visitArray(List<? extends AnnotationValue> list, AnnotationValue annotationValue) {
                    return (Boolean) annotationValue.accept(new SimpleAnnotationValueVisitor6<Boolean, List<? extends AnnotationValue>>() {
                        /* access modifiers changed from: protected */
                        public Boolean defaultAction(Object obj, List<? extends AnnotationValue> list) {
                            return false;
                        }

                        public Boolean visitArray(List<? extends AnnotationValue> list, List<? extends AnnotationValue> list2) {
                            return Boolean.valueOf(AnnotationValues.equivalence().pairwise().equivalent(list2, list));
                        }
                    }, list);
                }

                public Boolean visitType(TypeMirror typeMirror, AnnotationValue annotationValue) {
                    return (Boolean) annotationValue.accept(new SimpleAnnotationValueVisitor6<Boolean, TypeMirror>() {
                        /* access modifiers changed from: protected */
                        public Boolean defaultAction(Object obj, TypeMirror typeMirror) {
                            return false;
                        }

                        public Boolean visitType(TypeMirror typeMirror, TypeMirror typeMirror2) {
                            return Boolean.valueOf(MoreTypes.equivalence().equivalent(typeMirror2, typeMirror));
                        }
                    }, typeMirror);
                }
            }, annotationValue2)).booleanValue();
        }

        /* access modifiers changed from: protected */
        public int doHash(AnnotationValue annotationValue) {
            return ((Integer) annotationValue.accept(new SimpleAnnotationValueVisitor6<Integer, Void>() {
                public Integer visitAnnotation(AnnotationMirror annotationMirror, Void voidR) {
                    return Integer.valueOf(AnnotationMirrors.equivalence().hash(annotationMirror));
                }

                public Integer visitArray(List<? extends AnnotationValue> list, Void voidR) {
                    return Integer.valueOf(AnnotationValues.equivalence().pairwise().hash(list));
                }

                public Integer visitType(TypeMirror typeMirror, Void voidR) {
                    return Integer.valueOf(MoreTypes.equivalence().hash(typeMirror));
                }

                /* access modifiers changed from: protected */
                public Integer defaultAction(Object obj, Void voidR) {
                    return Integer.valueOf(obj.hashCode());
                }
            }, (Object) null)).intValue();
        }
    };

    public static Equivalence<AnnotationValue> equivalence() {
        return ANNOTATION_VALUE_EQUIVALENCE;
    }

    private AnnotationValues() {
    }
}
