package org.jacoco.agent.p086rt.internal_8ff85ea.asm.tree;

import java.util.ArrayList;
import java.util.List;
import org.jacoco.agent.p086rt.internal_8ff85ea.asm.AnnotationVisitor;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.asm.tree.AnnotationNode */
public class AnnotationNode extends AnnotationVisitor {
    public String desc;
    public List<Object> values;

    public void check(int i) {
    }

    public void visitEnd() {
    }

    public AnnotationNode(String str) {
        this(327680, str);
        if (getClass() != AnnotationNode.class) {
            throw new IllegalStateException();
        }
    }

    public AnnotationNode(int i, String str) {
        super(i);
        this.desc = str;
    }

    AnnotationNode(List<Object> list) {
        super(327680);
        this.values = list;
    }

    public void visit(String str, Object obj) {
        if (this.values == null) {
            this.values = new ArrayList(this.desc != null ? 2 : 1);
        }
        if (this.desc != null) {
            this.values.add(str);
        }
        int i = 0;
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            ArrayList arrayList = new ArrayList(bArr.length);
            int length = bArr.length;
            while (i < length) {
                arrayList.add(Byte.valueOf(bArr[i]));
                i++;
            }
            this.values.add(arrayList);
        } else if (obj instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj;
            ArrayList arrayList2 = new ArrayList(zArr.length);
            int length2 = zArr.length;
            while (i < length2) {
                arrayList2.add(Boolean.valueOf(zArr[i]));
                i++;
            }
            this.values.add(arrayList2);
        } else if (obj instanceof short[]) {
            short[] sArr = (short[]) obj;
            ArrayList arrayList3 = new ArrayList(sArr.length);
            int length3 = sArr.length;
            while (i < length3) {
                arrayList3.add(Short.valueOf(sArr[i]));
                i++;
            }
            this.values.add(arrayList3);
        } else if (obj instanceof char[]) {
            char[] cArr = (char[]) obj;
            ArrayList arrayList4 = new ArrayList(cArr.length);
            int length4 = cArr.length;
            while (i < length4) {
                arrayList4.add(Character.valueOf(cArr[i]));
                i++;
            }
            this.values.add(arrayList4);
        } else if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            ArrayList arrayList5 = new ArrayList(iArr.length);
            int length5 = iArr.length;
            while (i < length5) {
                arrayList5.add(Integer.valueOf(iArr[i]));
                i++;
            }
            this.values.add(arrayList5);
        } else if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            ArrayList arrayList6 = new ArrayList(jArr.length);
            int length6 = jArr.length;
            while (i < length6) {
                arrayList6.add(Long.valueOf(jArr[i]));
                i++;
            }
            this.values.add(arrayList6);
        } else if (obj instanceof float[]) {
            float[] fArr = (float[]) obj;
            ArrayList arrayList7 = new ArrayList(fArr.length);
            int length7 = fArr.length;
            while (i < length7) {
                arrayList7.add(Float.valueOf(fArr[i]));
                i++;
            }
            this.values.add(arrayList7);
        } else if (obj instanceof double[]) {
            double[] dArr = (double[]) obj;
            ArrayList arrayList8 = new ArrayList(dArr.length);
            int length8 = dArr.length;
            while (i < length8) {
                arrayList8.add(Double.valueOf(dArr[i]));
                i++;
            }
            this.values.add(arrayList8);
        } else {
            this.values.add(obj);
        }
    }

    public void visitEnum(String str, String str2, String str3) {
        if (this.values == null) {
            this.values = new ArrayList(this.desc != null ? 2 : 1);
        }
        if (this.desc != null) {
            this.values.add(str);
        }
        this.values.add(new String[]{str2, str3});
    }

    public AnnotationVisitor visitAnnotation(String str, String str2) {
        if (this.values == null) {
            this.values = new ArrayList(this.desc != null ? 2 : 1);
        }
        if (this.desc != null) {
            this.values.add(str);
        }
        AnnotationNode annotationNode = new AnnotationNode(str2);
        this.values.add(annotationNode);
        return annotationNode;
    }

    public AnnotationVisitor visitArray(String str) {
        if (this.values == null) {
            this.values = new ArrayList(this.desc != null ? 2 : 1);
        }
        if (this.desc != null) {
            this.values.add(str);
        }
        ArrayList arrayList = new ArrayList();
        this.values.add(arrayList);
        return new AnnotationNode((List<Object>) arrayList);
    }

    public void accept(AnnotationVisitor annotationVisitor) {
        if (annotationVisitor != null) {
            if (this.values != null) {
                for (int i = 0; i < this.values.size(); i += 2) {
                    accept(annotationVisitor, (String) this.values.get(i), this.values.get(i + 1));
                }
            }
            annotationVisitor.visitEnd();
        }
    }

    static void accept(AnnotationVisitor annotationVisitor, String str, Object obj) {
        if (annotationVisitor != null) {
            if (obj instanceof String[]) {
                String[] strArr = (String[]) obj;
                annotationVisitor.visitEnum(str, strArr[0], strArr[1]);
            } else if (obj instanceof AnnotationNode) {
                AnnotationNode annotationNode = (AnnotationNode) obj;
                annotationNode.accept(annotationVisitor.visitAnnotation(str, annotationNode.desc));
            } else if (obj instanceof List) {
                AnnotationVisitor visitArray = annotationVisitor.visitArray(str);
                if (visitArray != null) {
                    List list = (List) obj;
                    for (int i = 0; i < list.size(); i++) {
                        accept(visitArray, (String) null, list.get(i));
                    }
                    visitArray.visitEnd();
                }
            } else {
                annotationVisitor.visit(str, obj);
            }
        }
    }
}
