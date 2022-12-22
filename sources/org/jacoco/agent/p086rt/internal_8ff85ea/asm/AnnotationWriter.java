package org.jacoco.agent.p086rt.internal_8ff85ea.asm;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.asm.AnnotationWriter */
final class AnnotationWriter extends AnnotationVisitor {

    /* renamed from: bv */
    private final ByteVector f6578bv;

    /* renamed from: cw */
    private final ClassWriter f6579cw;
    private final boolean named;
    AnnotationWriter next;
    private final int offset;
    private final ByteVector parent;
    AnnotationWriter prev;
    private int size;

    AnnotationWriter(ClassWriter classWriter, boolean z, ByteVector byteVector, ByteVector byteVector2, int i) {
        super(327680);
        this.f6579cw = classWriter;
        this.named = z;
        this.f6578bv = byteVector;
        this.parent = byteVector2;
        this.offset = i;
    }

    public void visit(String str, Object obj) {
        this.size++;
        if (this.named) {
            this.f6578bv.putShort(this.f6579cw.newUTF8(str));
        }
        if (obj instanceof String) {
            this.f6578bv.put12(115, this.f6579cw.newUTF8((String) obj));
        } else if (obj instanceof Byte) {
            this.f6578bv.put12(66, this.f6579cw.newInteger(((Byte) obj).byteValue()).index);
        } else if (obj instanceof Boolean) {
            this.f6578bv.put12(90, this.f6579cw.newInteger(((Boolean) obj).booleanValue() ? 1 : 0).index);
        } else if (obj instanceof Character) {
            this.f6578bv.put12(67, this.f6579cw.newInteger(((Character) obj).charValue()).index);
        } else if (obj instanceof Short) {
            this.f6578bv.put12(83, this.f6579cw.newInteger(((Short) obj).shortValue()).index);
        } else if (obj instanceof Type) {
            this.f6578bv.put12(99, this.f6579cw.newUTF8(((Type) obj).getDescriptor()));
        } else {
            int i = 0;
            if (obj instanceof byte[]) {
                byte[] bArr = (byte[]) obj;
                this.f6578bv.put12(91, bArr.length);
                while (i < bArr.length) {
                    this.f6578bv.put12(66, this.f6579cw.newInteger(bArr[i]).index);
                    i++;
                }
            } else if (obj instanceof boolean[]) {
                boolean[] zArr = (boolean[]) obj;
                this.f6578bv.put12(91, zArr.length);
                while (i < zArr.length) {
                    this.f6578bv.put12(90, this.f6579cw.newInteger(zArr[i] ? 1 : 0).index);
                    i++;
                }
            } else if (obj instanceof short[]) {
                short[] sArr = (short[]) obj;
                this.f6578bv.put12(91, sArr.length);
                while (i < sArr.length) {
                    this.f6578bv.put12(83, this.f6579cw.newInteger(sArr[i]).index);
                    i++;
                }
            } else if (obj instanceof char[]) {
                char[] cArr = (char[]) obj;
                this.f6578bv.put12(91, cArr.length);
                while (i < cArr.length) {
                    this.f6578bv.put12(67, this.f6579cw.newInteger(cArr[i]).index);
                    i++;
                }
            } else if (obj instanceof int[]) {
                int[] iArr = (int[]) obj;
                this.f6578bv.put12(91, iArr.length);
                while (i < iArr.length) {
                    this.f6578bv.put12(73, this.f6579cw.newInteger(iArr[i]).index);
                    i++;
                }
            } else if (obj instanceof long[]) {
                long[] jArr = (long[]) obj;
                this.f6578bv.put12(91, jArr.length);
                while (i < jArr.length) {
                    this.f6578bv.put12(74, this.f6579cw.newLong(jArr[i]).index);
                    i++;
                }
            } else if (obj instanceof float[]) {
                float[] fArr = (float[]) obj;
                this.f6578bv.put12(91, fArr.length);
                while (i < fArr.length) {
                    this.f6578bv.put12(70, this.f6579cw.newFloat(fArr[i]).index);
                    i++;
                }
            } else if (obj instanceof double[]) {
                double[] dArr = (double[]) obj;
                this.f6578bv.put12(91, dArr.length);
                while (i < dArr.length) {
                    this.f6578bv.put12(68, this.f6579cw.newDouble(dArr[i]).index);
                    i++;
                }
            } else {
                Item newConstItem = this.f6579cw.newConstItem(obj);
                this.f6578bv.put12(".s.IFJDCS".charAt(newConstItem.type), newConstItem.index);
            }
        }
    }

    public void visitEnum(String str, String str2, String str3) {
        this.size++;
        if (this.named) {
            this.f6578bv.putShort(this.f6579cw.newUTF8(str));
        }
        this.f6578bv.put12(101, this.f6579cw.newUTF8(str2)).putShort(this.f6579cw.newUTF8(str3));
    }

    public AnnotationVisitor visitAnnotation(String str, String str2) {
        this.size++;
        if (this.named) {
            this.f6578bv.putShort(this.f6579cw.newUTF8(str));
        }
        this.f6578bv.put12(64, this.f6579cw.newUTF8(str2)).putShort(0);
        ClassWriter classWriter = this.f6579cw;
        ByteVector byteVector = this.f6578bv;
        return new AnnotationWriter(classWriter, true, byteVector, byteVector, byteVector.length - 2);
    }

    public AnnotationVisitor visitArray(String str) {
        this.size++;
        if (this.named) {
            this.f6578bv.putShort(this.f6579cw.newUTF8(str));
        }
        this.f6578bv.put12(91, 0);
        ClassWriter classWriter = this.f6579cw;
        ByteVector byteVector = this.f6578bv;
        return new AnnotationWriter(classWriter, false, byteVector, byteVector, byteVector.length - 2);
    }

    public void visitEnd() {
        ByteVector byteVector = this.parent;
        if (byteVector != null) {
            byte[] bArr = byteVector.data;
            int i = this.offset;
            int i2 = this.size;
            bArr[i] = (byte) (i2 >>> 8);
            bArr[i + 1] = (byte) i2;
        }
    }

    /* access modifiers changed from: package-private */
    public int getSize() {
        int i = 0;
        for (AnnotationWriter annotationWriter = this; annotationWriter != null; annotationWriter = annotationWriter.next) {
            i += annotationWriter.f6578bv.length;
        }
        return i;
    }

    /* access modifiers changed from: package-private */
    public void put(ByteVector byteVector) {
        int i = 2;
        int i2 = 0;
        AnnotationWriter annotationWriter = null;
        for (AnnotationWriter annotationWriter2 = this; annotationWriter2 != null; annotationWriter2 = annotationWriter2.next) {
            i2++;
            i += annotationWriter2.f6578bv.length;
            annotationWriter2.visitEnd();
            annotationWriter2.prev = annotationWriter;
            annotationWriter = annotationWriter2;
        }
        byteVector.putInt(i);
        byteVector.putShort(i2);
        while (annotationWriter != null) {
            byteVector.putByteArray(annotationWriter.f6578bv.data, 0, annotationWriter.f6578bv.length);
            annotationWriter = annotationWriter.prev;
        }
    }

    static void put(AnnotationWriter[] annotationWriterArr, int i, ByteVector byteVector) {
        int length = ((annotationWriterArr.length - i) * 2) + 1;
        int i2 = i;
        while (true) {
            int i3 = 0;
            if (i2 >= annotationWriterArr.length) {
                break;
            }
            if (annotationWriterArr[i2] != null) {
                i3 = annotationWriterArr[i2].getSize();
            }
            length += i3;
            i2++;
        }
        byteVector.putInt(length).putByte(annotationWriterArr.length - i);
        while (i < annotationWriterArr.length) {
            AnnotationWriter annotationWriter = null;
            int i4 = 0;
            for (AnnotationWriter annotationWriter2 = annotationWriterArr[i]; annotationWriter2 != null; annotationWriter2 = annotationWriter2.next) {
                i4++;
                annotationWriter2.visitEnd();
                annotationWriter2.prev = annotationWriter;
                annotationWriter = annotationWriter2;
            }
            byteVector.putShort(i4);
            while (annotationWriter != null) {
                byteVector.putByteArray(annotationWriter.f6578bv.data, 0, annotationWriter.f6578bv.length);
                annotationWriter = annotationWriter.prev;
            }
            i++;
        }
    }

    static void putTarget(int i, TypePath typePath, ByteVector byteVector) {
        int i2 = i >>> 24;
        if (!(i2 == 0 || i2 == 1)) {
            switch (i2) {
                case 19:
                case 20:
                case 21:
                    byteVector.putByte(i2);
                    break;
                case 22:
                    break;
                default:
                    switch (i2) {
                        case 71:
                        case 72:
                        case 73:
                        case 74:
                        case 75:
                            byteVector.putInt(i);
                            break;
                        default:
                            byteVector.put12(i2, (i & 16776960) >> 8);
                            break;
                    }
            }
        }
        byteVector.putShort(i >>> 16);
        if (typePath == null) {
            byteVector.putByte(0);
            return;
        }
        byteVector.putByteArray(typePath.f6587b, typePath.offset, (typePath.f6587b[typePath.offset] * 2) + 1);
    }
}
