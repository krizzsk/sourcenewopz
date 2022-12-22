package org.jacoco.agent.p086rt.internal_8ff85ea.asm;

import com.google.p217ar.core.ImageMetadata;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.asm.FieldWriter */
final class FieldWriter extends FieldVisitor {
    private final int access;
    private AnnotationWriter anns;
    private Attribute attrs;

    /* renamed from: cw */
    private final ClassWriter f6584cw;
    private final int desc;
    private AnnotationWriter ianns;
    private AnnotationWriter itanns;
    private final int name;
    private int signature;
    private AnnotationWriter tanns;
    private int value;

    public void visitEnd() {
    }

    FieldWriter(ClassWriter classWriter, int i, String str, String str2, String str3, Object obj) {
        super(327680);
        if (classWriter.firstField == null) {
            classWriter.firstField = this;
        } else {
            classWriter.lastField.f6583fv = this;
        }
        classWriter.lastField = this;
        this.f6584cw = classWriter;
        this.access = i;
        this.name = classWriter.newUTF8(str);
        this.desc = classWriter.newUTF8(str2);
        if (str3 != null) {
            this.signature = classWriter.newUTF8(str3);
        }
        if (obj != null) {
            this.value = classWriter.newConstItem(obj).index;
        }
    }

    public AnnotationVisitor visitAnnotation(String str, boolean z) {
        ByteVector byteVector = new ByteVector();
        byteVector.putShort(this.f6584cw.newUTF8(str)).putShort(0);
        AnnotationWriter annotationWriter = new AnnotationWriter(this.f6584cw, true, byteVector, byteVector, 2);
        if (z) {
            annotationWriter.next = this.anns;
            this.anns = annotationWriter;
        } else {
            annotationWriter.next = this.ianns;
            this.ianns = annotationWriter;
        }
        return annotationWriter;
    }

    public AnnotationVisitor visitTypeAnnotation(int i, TypePath typePath, String str, boolean z) {
        ByteVector byteVector = new ByteVector();
        AnnotationWriter.putTarget(i, typePath, byteVector);
        byteVector.putShort(this.f6584cw.newUTF8(str)).putShort(0);
        AnnotationWriter annotationWriter = new AnnotationWriter(this.f6584cw, true, byteVector, byteVector, byteVector.length - 2);
        if (z) {
            annotationWriter.next = this.tanns;
            this.tanns = annotationWriter;
        } else {
            annotationWriter.next = this.itanns;
            this.itanns = annotationWriter;
        }
        return annotationWriter;
    }

    public void visitAttribute(Attribute attribute) {
        attribute.next = this.attrs;
        this.attrs = attribute;
    }

    /* access modifiers changed from: package-private */
    public int getSize() {
        int i;
        if (this.value != 0) {
            this.f6584cw.newUTF8("ConstantValue");
            i = 16;
        } else {
            i = 8;
        }
        if ((this.access & 4096) != 0 && ((this.f6584cw.version & 65535) < 49 || (this.access & 262144) != 0)) {
            this.f6584cw.newUTF8("Synthetic");
            i += 6;
        }
        if ((this.access & 131072) != 0) {
            this.f6584cw.newUTF8("Deprecated");
            i += 6;
        }
        if (this.signature != 0) {
            this.f6584cw.newUTF8("Signature");
            i += 8;
        }
        if (this.anns != null) {
            this.f6584cw.newUTF8("RuntimeVisibleAnnotations");
            i += this.anns.getSize() + 8;
        }
        if (this.ianns != null) {
            this.f6584cw.newUTF8("RuntimeInvisibleAnnotations");
            i += this.ianns.getSize() + 8;
        }
        if (this.tanns != null) {
            this.f6584cw.newUTF8("RuntimeVisibleTypeAnnotations");
            i += this.tanns.getSize() + 8;
        }
        if (this.itanns != null) {
            this.f6584cw.newUTF8("RuntimeInvisibleTypeAnnotations");
            i += this.itanns.getSize() + 8;
        }
        Attribute attribute = this.attrs;
        return attribute != null ? i + attribute.getSize(this.f6584cw, (byte[]) null, 0, -1, -1) : i;
    }

    /* access modifiers changed from: package-private */
    public void put(ByteVector byteVector) {
        int i = this.access;
        byteVector.putShort(i & (~(((i & 262144) / 64) | ImageMetadata.HOT_PIXEL_MODE))).putShort(this.name).putShort(this.desc);
        int i2 = this.value != 0 ? 1 : 0;
        if ((this.access & 4096) != 0 && ((this.f6584cw.version & 65535) < 49 || (this.access & 262144) != 0)) {
            i2++;
        }
        if ((this.access & 131072) != 0) {
            i2++;
        }
        if (this.signature != 0) {
            i2++;
        }
        if (this.anns != null) {
            i2++;
        }
        if (this.ianns != null) {
            i2++;
        }
        if (this.tanns != null) {
            i2++;
        }
        if (this.itanns != null) {
            i2++;
        }
        Attribute attribute = this.attrs;
        if (attribute != null) {
            i2 += attribute.getCount();
        }
        byteVector.putShort(i2);
        if (this.value != 0) {
            byteVector.putShort(this.f6584cw.newUTF8("ConstantValue"));
            byteVector.putInt(2).putShort(this.value);
        }
        if ((this.access & 4096) != 0 && ((this.f6584cw.version & 65535) < 49 || (this.access & 262144) != 0)) {
            byteVector.putShort(this.f6584cw.newUTF8("Synthetic")).putInt(0);
        }
        if ((this.access & 131072) != 0) {
            byteVector.putShort(this.f6584cw.newUTF8("Deprecated")).putInt(0);
        }
        if (this.signature != 0) {
            byteVector.putShort(this.f6584cw.newUTF8("Signature"));
            byteVector.putInt(2).putShort(this.signature);
        }
        if (this.anns != null) {
            byteVector.putShort(this.f6584cw.newUTF8("RuntimeVisibleAnnotations"));
            this.anns.put(byteVector);
        }
        if (this.ianns != null) {
            byteVector.putShort(this.f6584cw.newUTF8("RuntimeInvisibleAnnotations"));
            this.ianns.put(byteVector);
        }
        if (this.tanns != null) {
            byteVector.putShort(this.f6584cw.newUTF8("RuntimeVisibleTypeAnnotations"));
            this.tanns.put(byteVector);
        }
        if (this.itanns != null) {
            byteVector.putShort(this.f6584cw.newUTF8("RuntimeInvisibleTypeAnnotations"));
            this.itanns.put(byteVector);
        }
        Attribute attribute2 = this.attrs;
        if (attribute2 != null) {
            attribute2.put(this.f6584cw, (byte[]) null, 0, -1, -1, byteVector);
        }
    }
}
