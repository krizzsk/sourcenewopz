package org.jacoco.agent.p086rt.internal_8ff85ea.asm;

import com.google.common.base.Ascii;
import java.io.IOException;
import java.io.InputStream;
import net.lingala.zip4j.util.InternalZipConstants;
import okio.Utf8;
import org.apache.commons.p071io.IOUtils;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.asm.ClassReader */
public class ClassReader {
    static final boolean ANNOTATIONS = true;
    static final int EXPAND_ASM_INSNS = 256;
    public static final int EXPAND_FRAMES = 8;
    static final boolean FRAMES = true;
    static final boolean RESIZE = true;
    static final boolean SIGNATURES = true;
    public static final int SKIP_CODE = 1;
    public static final int SKIP_DEBUG = 2;
    public static final int SKIP_FRAMES = 4;
    static final boolean WRITER = true;

    /* renamed from: b */
    public final byte[] f6580b;
    public final int header;
    private final int[] items;
    private final int maxStringLength;
    private final String[] strings;

    public ClassReader(byte[] bArr) {
        this(bArr, 0, bArr.length);
    }

    public ClassReader(byte[] bArr, int i, int i2) {
        this.f6580b = bArr;
        if (readShort(i + 6) <= 52) {
            int[] iArr = new int[readUnsignedShort(i + 8)];
            this.items = iArr;
            int length = iArr.length;
            this.strings = new String[length];
            int i3 = 0;
            int i4 = i + 10;
            int i5 = 1;
            while (i5 < length) {
                int i6 = i4 + 1;
                this.items[i5] = i6;
                byte b = bArr[i4];
                int i7 = 5;
                if (b == 1) {
                    i7 = readUnsignedShort(i6) + 3;
                    if (i7 > i3) {
                        i3 = i7;
                    }
                } else if (b != 15) {
                    if (!(b == 18 || b == 3 || b == 4)) {
                        if (b != 5 && b != 6) {
                            switch (b) {
                                case 9:
                                case 10:
                                case 11:
                                case 12:
                                    break;
                                default:
                                    i7 = 3;
                                    break;
                            }
                        } else {
                            i7 = 9;
                            i5++;
                        }
                    }
                } else {
                    i7 = 4;
                }
                i4 += i7;
                i5++;
            }
            this.maxStringLength = i3;
            this.header = i4;
            return;
        }
        throw new IllegalArgumentException();
    }

    public int getAccess() {
        return readUnsignedShort(this.header);
    }

    public String getClassName() {
        return readClass(this.header + 2, new char[this.maxStringLength]);
    }

    public String getSuperName() {
        return readClass(this.header + 4, new char[this.maxStringLength]);
    }

    public String[] getInterfaces() {
        int i = this.header + 6;
        int readUnsignedShort = readUnsignedShort(i);
        String[] strArr = new String[readUnsignedShort];
        if (readUnsignedShort > 0) {
            char[] cArr = new char[this.maxStringLength];
            for (int i2 = 0; i2 < readUnsignedShort; i2++) {
                i += 2;
                strArr[i2] = readClass(i, cArr);
            }
        }
        return strArr;
    }

    /* access modifiers changed from: package-private */
    public void copyPool(ClassWriter classWriter) {
        char[] cArr = new char[this.maxStringLength];
        int length = this.items.length;
        Item[] itemArr = new Item[length];
        int i = 1;
        while (i < length) {
            int i2 = this.items[i];
            byte b = this.f6580b[i2 - 1];
            Item item = new Item(i);
            if (b == 1) {
                String[] strArr = this.strings;
                String str = strArr[i];
                if (str == null) {
                    int i3 = this.items[i];
                    str = readUTF(i3 + 2, readUnsignedShort(i3), cArr);
                    strArr[i] = str;
                }
                item.set(b, str, (String) null, (String) null);
            } else if (b == 15) {
                int i4 = this.items[readUnsignedShort(i2 + 1)];
                int i5 = this.items[readUnsignedShort(i4 + 2)];
                item.set(readByte(i2) + 20, readClass(i4, cArr), readUTF8(i5, cArr), readUTF8(i5 + 2, cArr));
            } else if (b == 18) {
                if (classWriter.bootstrapMethods == null) {
                    copyBootstrapMethods(classWriter, itemArr, cArr);
                }
                int i6 = this.items[readUnsignedShort(i2 + 2)];
                item.set(readUTF8(i6, cArr), readUTF8(i6 + 2, cArr), readUnsignedShort(i2));
            } else if (b == 3) {
                item.set(readInt(i2));
            } else if (b != 4) {
                if (b == 5) {
                    item.set(readLong(i2));
                } else if (b != 6) {
                    switch (b) {
                        case 9:
                        case 10:
                        case 11:
                            int i7 = this.items[readUnsignedShort(i2 + 2)];
                            item.set(b, readClass(i2, cArr), readUTF8(i7, cArr), readUTF8(i7 + 2, cArr));
                            break;
                        case 12:
                            item.set(b, readUTF8(i2, cArr), readUTF8(i2 + 2, cArr), (String) null);
                            break;
                        default:
                            item.set(b, readUTF8(i2, cArr), (String) null, (String) null);
                            break;
                    }
                } else {
                    item.set(Double.longBitsToDouble(readLong(i2)));
                }
                i++;
            } else {
                item.set(Float.intBitsToFloat(readInt(i2)));
            }
            int i8 = item.hashCode % length;
            item.next = itemArr[i8];
            itemArr[i8] = item;
            i++;
        }
        int i9 = this.items[1] - 1;
        classWriter.pool.putByteArray(this.f6580b, i9, this.header - i9);
        classWriter.items = itemArr;
        classWriter.threshold = (int) (((double) length) * 0.75d);
        classWriter.index = length;
    }

    private void copyBootstrapMethods(ClassWriter classWriter, Item[] itemArr, char[] cArr) {
        int i;
        boolean z;
        int attributes = getAttributes();
        int readUnsignedShort = readUnsignedShort(attributes);
        while (true) {
            if (readUnsignedShort <= 0) {
                z = false;
                break;
            } else if ("BootstrapMethods".equals(readUTF8(attributes + 2, cArr))) {
                z = true;
                break;
            } else {
                attributes += readInt(attributes + 4) + 6;
                readUnsignedShort--;
            }
        }
        if (z) {
            int readUnsignedShort2 = readUnsignedShort(attributes + 8);
            int i2 = attributes + 10;
            int i3 = i2;
            for (i = 0; i < readUnsignedShort2; i++) {
                int i4 = (i3 - attributes) - 10;
                int hashCode = readConst(readUnsignedShort(i3), cArr).hashCode();
                for (int readUnsignedShort3 = readUnsignedShort(i3 + 2); readUnsignedShort3 > 0; readUnsignedShort3--) {
                    hashCode ^= readConst(readUnsignedShort(i3 + 4), cArr).hashCode();
                    i3 += 2;
                }
                i3 += 4;
                Item item = new Item(i);
                item.set(i4, hashCode & Integer.MAX_VALUE);
                int length = item.hashCode % itemArr.length;
                item.next = itemArr[length];
                itemArr[length] = item;
            }
            int readInt = readInt(attributes + 4);
            ByteVector byteVector = new ByteVector(readInt + 62);
            byteVector.putByteArray(this.f6580b, i2, readInt - 2);
            classWriter.bootstrapMethodsCount = readUnsignedShort2;
            classWriter.bootstrapMethods = byteVector;
        }
    }

    public ClassReader(InputStream inputStream) throws IOException {
        this(readClass(inputStream, false));
    }

    public ClassReader(String str) throws IOException {
        this(readClass(ClassLoader.getSystemResourceAsStream(str.replace('.', IOUtils.DIR_SEPARATOR_UNIX) + ".class"), true));
    }

    private static byte[] readClass(InputStream inputStream, boolean z) throws IOException {
        if (inputStream != null) {
            try {
                byte[] bArr = new byte[inputStream.available()];
                int i = 0;
                while (true) {
                    int read = inputStream.read(bArr, i, bArr.length - i);
                    if (read == -1) {
                        if (i < bArr.length) {
                            byte[] bArr2 = new byte[i];
                            System.arraycopy(bArr, 0, bArr2, 0, i);
                            bArr = bArr2;
                        }
                        if (z) {
                            inputStream.close();
                        }
                        return bArr;
                    }
                    i += read;
                    if (i == bArr.length) {
                        int read2 = inputStream.read();
                        if (read2 < 0) {
                            return bArr;
                        }
                        byte[] bArr3 = new byte[(bArr.length + 1000)];
                        System.arraycopy(bArr, 0, bArr3, 0, i);
                        int i2 = i + 1;
                        bArr3[i] = (byte) read2;
                        i = i2;
                        bArr = bArr3;
                    }
                }
            } finally {
                if (z) {
                    inputStream.close();
                }
            }
        } else {
            throw new IOException("Class not found");
        }
    }

    public void accept(ClassVisitor classVisitor, int i) {
        accept(classVisitor, new Attribute[0], i);
    }

    public void accept(ClassVisitor classVisitor, Attribute[] attributeArr, int i) {
        String[] strArr;
        String str;
        String str2;
        int i2;
        String str3;
        Attribute attribute;
        int i3;
        ClassVisitor classVisitor2 = classVisitor;
        int i4 = i;
        int i5 = this.header;
        char[] cArr = new char[this.maxStringLength];
        Context context = new Context();
        context.attrs = attributeArr;
        context.flags = i4;
        context.buffer = cArr;
        int readUnsignedShort = readUnsignedShort(i5);
        String readClass = readClass(i5 + 2, cArr);
        String readClass2 = readClass(i5 + 4, cArr);
        int readUnsignedShort2 = readUnsignedShort(i5 + 6);
        String[] strArr2 = new String[readUnsignedShort2];
        int i6 = i5 + 8;
        for (int i7 = 0; i7 < readUnsignedShort2; i7++) {
            strArr2[i7] = readClass(i6, cArr);
            i6 += 2;
        }
        int attributes = getAttributes();
        int i8 = attributes;
        int i9 = readUnsignedShort;
        int readUnsignedShort3 = readUnsignedShort(attributes);
        int i10 = readUnsignedShort2;
        int i11 = 0;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        String str9 = null;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        Attribute attribute2 = null;
        while (readUnsignedShort3 > 0) {
            String readUTF8 = readUTF8(i8 + 2, cArr);
            if ("SourceFile".equals(readUTF8)) {
                str6 = readUTF8(i8 + 8, cArr);
            } else if ("InnerClasses".equals(readUTF8)) {
                i15 = i8 + 8;
            } else if ("EnclosingMethod".equals(readUTF8)) {
                String readClass3 = readClass(i8 + 8, cArr);
                int readUnsignedShort4 = readUnsignedShort(i8 + 10);
                if (readUnsignedShort4 != 0) {
                    str9 = readUTF8(this.items[readUnsignedShort4], cArr);
                    str4 = readUTF8(this.items[readUnsignedShort4] + 2, cArr);
                }
                str8 = readClass3;
            } else if ("Signature".equals(readUTF8)) {
                str7 = readUTF8(i8 + 8, cArr);
            } else if ("RuntimeVisibleAnnotations".equals(readUTF8)) {
                i11 = i8 + 8;
            } else if ("RuntimeVisibleTypeAnnotations".equals(readUTF8)) {
                i13 = i8 + 8;
            } else {
                if ("Deprecated".equals(readUTF8)) {
                    i3 = 131072;
                } else if ("Synthetic".equals(readUTF8)) {
                    i3 = 266240;
                } else if ("SourceDebugExtension".equals(readUTF8)) {
                    int readInt = readInt(i8 + 4);
                    str5 = readUTF(i8 + 8, readInt, new char[readInt]);
                } else if ("RuntimeInvisibleAnnotations".equals(readUTF8)) {
                    i12 = i8 + 8;
                } else if ("RuntimeInvisibleTypeAnnotations".equals(readUTF8)) {
                    i14 = i8 + 8;
                } else {
                    if ("BootstrapMethods".equals(readUTF8)) {
                        int readUnsignedShort5 = readUnsignedShort(i8 + 8);
                        int[] iArr = new int[readUnsignedShort5];
                        int i16 = i8 + 10;
                        int i17 = 0;
                        while (i17 < readUnsignedShort5) {
                            iArr[i17] = i16;
                            i16 += (readUnsignedShort(i16 + 2) + 2) << 1;
                            i17++;
                            i11 = i11;
                        }
                        context.bootstrapMethods = iArr;
                        str2 = str4;
                        str = str5;
                        str3 = str6;
                        strArr = strArr2;
                        attribute = attribute2;
                        i2 = i11;
                    } else {
                        i2 = i11;
                        str2 = str4;
                        str = str5;
                        String str10 = readUTF8;
                        String str11 = str6;
                        strArr = strArr2;
                        str3 = str11;
                        Attribute readAttribute = readAttribute(attributeArr, str10, i8 + 8, readInt(i8 + 4), cArr, -1, (Label[]) null);
                        attribute = attribute2;
                        if (readAttribute != null) {
                            readAttribute.next = attribute;
                            attribute2 = readAttribute;
                            str6 = str3;
                            i11 = i2;
                            str4 = str2;
                            str5 = str;
                            i8 += readInt(i8 + 4) + 6;
                            readUnsignedShort3--;
                            Attribute[] attributeArr2 = attributeArr;
                            strArr2 = strArr;
                        }
                    }
                    attribute2 = attribute;
                    str6 = str3;
                    i11 = i2;
                    str4 = str2;
                    str5 = str;
                    i8 += readInt(i8 + 4) + 6;
                    readUnsignedShort3--;
                    Attribute[] attributeArr22 = attributeArr;
                    strArr2 = strArr;
                }
                i9 |= i3;
            }
            strArr = strArr2;
            i8 += readInt(i8 + 4) + 6;
            readUnsignedShort3--;
            Attribute[] attributeArr222 = attributeArr;
            strArr2 = strArr;
        }
        int i18 = i11;
        String str12 = str4;
        String str13 = str5;
        String str14 = str6;
        String[] strArr3 = strArr2;
        Attribute attribute3 = attribute2;
        classVisitor.visit(readInt(this.items[1] - 7), i9, readClass, str7, readClass2, strArr2);
        if ((i4 & 2) == 0) {
            String str15 = str13;
            if (!(str14 == null && str15 == null)) {
                classVisitor2.visitSource(str14, str15);
            }
        }
        String str16 = str8;
        if (str16 != null) {
            classVisitor2.visitOuterClass(str16, str9, str12);
        }
        int i19 = i18;
        if (i19 != 0) {
            int i20 = i19 + 2;
            for (int readUnsignedShort6 = readUnsignedShort(i19); readUnsignedShort6 > 0; readUnsignedShort6--) {
                i20 = readAnnotationValues(i20 + 2, cArr, true, classVisitor2.visitAnnotation(readUTF8(i20, cArr), true));
            }
        }
        int i21 = i12;
        if (i21 != 0) {
            int i22 = i21 + 2;
            for (int readUnsignedShort7 = readUnsignedShort(i21); readUnsignedShort7 > 0; readUnsignedShort7--) {
                i22 = readAnnotationValues(i22 + 2, cArr, true, classVisitor2.visitAnnotation(readUTF8(i22, cArr), false));
            }
        }
        int i23 = i13;
        if (i23 != 0) {
            int i24 = i23 + 2;
            for (int readUnsignedShort8 = readUnsignedShort(i23); readUnsignedShort8 > 0; readUnsignedShort8--) {
                int readAnnotationTarget = readAnnotationTarget(context, i24);
                i24 = readAnnotationValues(readAnnotationTarget + 2, cArr, true, classVisitor2.visitTypeAnnotation(context.typeRef, context.typePath, readUTF8(readAnnotationTarget, cArr), true));
            }
        }
        int i25 = i14;
        if (i25 != 0) {
            int i26 = i25 + 2;
            for (int readUnsignedShort9 = readUnsignedShort(i25); readUnsignedShort9 > 0; readUnsignedShort9--) {
                int readAnnotationTarget2 = readAnnotationTarget(context, i26);
                i26 = readAnnotationValues(readAnnotationTarget2 + 2, cArr, true, classVisitor2.visitTypeAnnotation(context.typeRef, context.typePath, readUTF8(readAnnotationTarget2, cArr), false));
            }
        }
        while (attribute3 != null) {
            Attribute attribute4 = attribute3.next;
            attribute3.next = null;
            classVisitor2.visitAttribute(attribute3);
            attribute3 = attribute4;
        }
        int i27 = i15;
        if (i27 != 0) {
            int i28 = i27 + 2;
            for (int readUnsignedShort10 = readUnsignedShort(i27); readUnsignedShort10 > 0; readUnsignedShort10--) {
                classVisitor2.visitInnerClass(readClass(i28, cArr), readClass(i28 + 2, cArr), readUTF8(i28 + 4, cArr), readUnsignedShort(i28 + 6));
                i28 += 8;
            }
        }
        int i29 = this.header + 10 + (i10 * 2);
        for (int readUnsignedShort11 = readUnsignedShort(i29 - 2); readUnsignedShort11 > 0; readUnsignedShort11--) {
            i29 = readField(classVisitor2, context, i29);
        }
        int i30 = i29 + 2;
        for (int readUnsignedShort12 = readUnsignedShort(i30 - 2); readUnsignedShort12 > 0; readUnsignedShort12--) {
            i30 = readMethod(classVisitor2, context, i30);
        }
        classVisitor.visitEnd();
    }

    private int readField(ClassVisitor classVisitor, Context context, int i) {
        int i2;
        Context context2 = context;
        int i3 = i;
        char[] cArr = context2.buffer;
        int readUnsignedShort = readUnsignedShort(i3);
        String readUTF8 = readUTF8(i3 + 2, cArr);
        String readUTF82 = readUTF8(i3 + 4, cArr);
        int i4 = i3 + 6;
        int i5 = i4;
        int i6 = readUnsignedShort;
        int readUnsignedShort2 = readUnsignedShort(i4);
        Attribute attribute = null;
        String str = null;
        Object obj = null;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        while (readUnsignedShort2 > 0) {
            String readUTF83 = readUTF8(i5 + 2, cArr);
            if ("ConstantValue".equals(readUTF83)) {
                int readUnsignedShort3 = readUnsignedShort(i5 + 8);
                if (readUnsignedShort3 == 0) {
                    obj = null;
                } else {
                    obj = readConst(readUnsignedShort3, cArr);
                }
            } else if ("Signature".equals(readUTF83)) {
                str = readUTF8(i5 + 8, cArr);
            } else {
                if ("Deprecated".equals(readUTF83)) {
                    i2 = 131072;
                } else if ("Synthetic".equals(readUTF83)) {
                    i2 = 266240;
                } else if ("RuntimeVisibleAnnotations".equals(readUTF83)) {
                    i10 = i5 + 8;
                } else if ("RuntimeVisibleTypeAnnotations".equals(readUTF83)) {
                    i8 = i5 + 8;
                } else if ("RuntimeInvisibleAnnotations".equals(readUTF83)) {
                    i9 = i5 + 8;
                } else if ("RuntimeInvisibleTypeAnnotations".equals(readUTF83)) {
                    i7 = i5 + 8;
                } else {
                    Attribute attribute2 = attribute;
                    int i11 = i7;
                    int i12 = i8;
                    int i13 = i9;
                    int i14 = i10;
                    attribute = readAttribute(context2.attrs, readUTF83, i5 + 8, readInt(i5 + 4), cArr, -1, (Label[]) null);
                    Attribute attribute3 = attribute2;
                    if (attribute != null) {
                        attribute.next = attribute3;
                        i9 = i13;
                    } else {
                        i9 = i13;
                        attribute = attribute3;
                    }
                    i10 = i14;
                    i7 = i11;
                    i8 = i12;
                }
                i6 |= i2;
            }
            i5 += readInt(i5 + 4) + 6;
            readUnsignedShort2--;
            context2 = context;
        }
        Attribute attribute4 = attribute;
        int i15 = i7;
        int i16 = i8;
        int i17 = i9;
        int i18 = i10;
        int i19 = i5 + 2;
        FieldVisitor visitField = classVisitor.visitField(i6, readUTF8, readUTF82, str, obj);
        if (visitField == null) {
            return i19;
        }
        if (i18 != 0) {
            int i20 = i18 + 2;
            for (int readUnsignedShort4 = readUnsignedShort(i18); readUnsignedShort4 > 0; readUnsignedShort4--) {
                i20 = readAnnotationValues(i20 + 2, cArr, true, visitField.visitAnnotation(readUTF8(i20, cArr), true));
            }
        }
        if (i17 != 0) {
            int i21 = i17;
            int i22 = i21 + 2;
            for (int readUnsignedShort5 = readUnsignedShort(i21); readUnsignedShort5 > 0; readUnsignedShort5--) {
                i22 = readAnnotationValues(i22 + 2, cArr, true, visitField.visitAnnotation(readUTF8(i22, cArr), false));
            }
        }
        int i23 = i16;
        if (i23 != 0) {
            int i24 = i23 + 2;
            for (int readUnsignedShort6 = readUnsignedShort(i23); readUnsignedShort6 > 0; readUnsignedShort6--) {
                Context context3 = context;
                int readAnnotationTarget = readAnnotationTarget(context3, i24);
                i24 = readAnnotationValues(readAnnotationTarget + 2, cArr, true, visitField.visitTypeAnnotation(context3.typeRef, context3.typePath, readUTF8(readAnnotationTarget, cArr), true));
            }
        }
        Context context4 = context;
        int i25 = i15;
        if (i25 != 0) {
            int i26 = i25 + 2;
            for (int readUnsignedShort7 = readUnsignedShort(i25); readUnsignedShort7 > 0; readUnsignedShort7--) {
                int readAnnotationTarget2 = readAnnotationTarget(context4, i26);
                i26 = readAnnotationValues(readAnnotationTarget2 + 2, cArr, true, visitField.visitTypeAnnotation(context4.typeRef, context4.typePath, readUTF8(readAnnotationTarget2, cArr), false));
            }
        }
        while (attribute4 != null) {
            Attribute attribute5 = attribute4.next;
            attribute4.next = null;
            visitField.visitAttribute(attribute4);
            attribute4 = attribute5;
        }
        visitField.visitEnd();
        return i19;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:68:0x01b4, code lost:
        if (r1.exceptionCount == 0) goto L_0x01d3;
     */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x01d8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int readMethod(org.jacoco.agent.p086rt.internal_8ff85ea.asm.ClassVisitor r32, org.jacoco.agent.p086rt.internal_8ff85ea.asm.Context r33, int r34) {
        /*
            r31 = this;
            r8 = r31
            r9 = r33
            r0 = r34
            char[] r10 = r9.buffer
            int r1 = r8.readUnsignedShort(r0)
            r9.access = r1
            int r1 = r0 + 2
            java.lang.String r1 = r8.readUTF8(r1, r10)
            r9.name = r1
            int r1 = r0 + 4
            java.lang.String r1 = r8.readUTF8(r1, r10)
            r9.desc = r1
            int r11 = r0 + 6
            int r0 = r8.readUnsignedShort(r11)
            r14 = r0
            r15 = r11
            r0 = 0
            r1 = 0
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r13 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
        L_0x0037:
            if (r14 <= 0) goto L_0x0177
            int r12 = r15 + 2
            java.lang.String r12 = r8.readUTF8(r12, r10)
            r21 = r0
            java.lang.String r0 = "Code"
            boolean r0 = r0.equals(r12)
            if (r0 == 0) goto L_0x0068
            int r0 = r9.flags
            r12 = 1
            r0 = r0 & r12
            if (r0 != 0) goto L_0x0057
            int r0 = r15 + 8
            r19 = r0
        L_0x0053:
            r0 = r21
            goto L_0x016a
        L_0x0057:
            r27 = r1
            r28 = r2
            r12 = r3
            r29 = r4
            r30 = r5
            r22 = r7
        L_0x0062:
            r26 = r21
            r21 = r6
            goto L_0x015b
        L_0x0068:
            java.lang.String r0 = "Exceptions"
            boolean r0 = r0.equals(r12)
            if (r0 == 0) goto L_0x008e
            int r0 = r15 + 8
            int r0 = r8.readUnsignedShort(r0)
            java.lang.String[] r6 = new java.lang.String[r0]
            int r12 = r15 + 10
            r20 = r1
            r1 = r12
            r12 = 0
        L_0x007e:
            if (r12 >= r0) goto L_0x008b
            java.lang.String r17 = r8.readClass((int) r1, (char[]) r10)
            r6[r12] = r17
            int r1 = r1 + 2
            int r12 = r12 + 1
            goto L_0x007e
        L_0x008b:
            r17 = r1
            goto L_0x009e
        L_0x008e:
            r20 = r1
            java.lang.String r0 = "Signature"
            boolean r0 = r0.equals(r12)
            if (r0 == 0) goto L_0x00a1
            int r0 = r15 + 8
            java.lang.String r7 = r8.readUTF8(r0, r10)
        L_0x009e:
            r1 = r20
            goto L_0x0053
        L_0x00a1:
            java.lang.String r0 = "Deprecated"
            boolean r0 = r0.equals(r12)
            if (r0 == 0) goto L_0x00bc
            int r0 = r9.access
            r1 = 131072(0x20000, float:1.83671E-40)
            r0 = r0 | r1
            r9.access = r0
        L_0x00b0:
            r28 = r2
            r12 = r3
            r29 = r4
            r30 = r5
            r22 = r7
            r27 = r20
            goto L_0x0062
        L_0x00bc:
            java.lang.String r0 = "RuntimeVisibleAnnotations"
            boolean r0 = r0.equals(r12)
            if (r0 == 0) goto L_0x00c7
            int r5 = r15 + 8
            goto L_0x009e
        L_0x00c7:
            java.lang.String r0 = "RuntimeVisibleTypeAnnotations"
            boolean r0 = r0.equals(r12)
            if (r0 == 0) goto L_0x00d2
            int r2 = r15 + 8
            goto L_0x009e
        L_0x00d2:
            java.lang.String r0 = "AnnotationDefault"
            boolean r0 = r0.equals(r12)
            if (r0 == 0) goto L_0x00dd
            int r3 = r15 + 8
            goto L_0x009e
        L_0x00dd:
            java.lang.String r0 = "Synthetic"
            boolean r0 = r0.equals(r12)
            if (r0 == 0) goto L_0x00ee
            int r0 = r9.access
            r1 = 266240(0x41000, float:3.73082E-40)
            r0 = r0 | r1
            r9.access = r0
            goto L_0x00b0
        L_0x00ee:
            java.lang.String r0 = "RuntimeInvisibleAnnotations"
            boolean r0 = r0.equals(r12)
            if (r0 == 0) goto L_0x00f9
            int r4 = r15 + 8
            goto L_0x009e
        L_0x00f9:
            java.lang.String r0 = "RuntimeInvisibleTypeAnnotations"
            boolean r0 = r0.equals(r12)
            if (r0 == 0) goto L_0x0105
            int r1 = r15 + 8
            goto L_0x0053
        L_0x0105:
            java.lang.String r0 = "RuntimeVisibleParameterAnnotations"
            boolean r0 = r0.equals(r12)
            if (r0 == 0) goto L_0x0110
            int r18 = r15 + 8
            goto L_0x009e
        L_0x0110:
            java.lang.String r0 = "RuntimeInvisibleParameterAnnotations"
            boolean r0 = r0.equals(r12)
            if (r0 == 0) goto L_0x011d
            int r0 = r15 + 8
            r1 = r20
            goto L_0x016a
        L_0x011d:
            java.lang.String r0 = "MethodParameters"
            boolean r0 = r0.equals(r12)
            if (r0 == 0) goto L_0x0129
            int r16 = r15 + 8
            goto L_0x009e
        L_0x0129:
            org.jacoco.agent.rt.internal_8ff85ea.asm.Attribute[] r1 = r9.attrs
            int r22 = r15 + 8
            int r0 = r15 + 4
            int r23 = r8.readInt(r0)
            r24 = -1
            r25 = 0
            r26 = r21
            r0 = r31
            r27 = r20
            r28 = r2
            r2 = r12
            r12 = r3
            r3 = r22
            r29 = r4
            r4 = r23
            r30 = r5
            r5 = r10
            r21 = r6
            r6 = r24
            r22 = r7
            r7 = r25
            org.jacoco.agent.rt.internal_8ff85ea.asm.Attribute r0 = r0.readAttribute(r1, r2, r3, r4, r5, r6, r7)
            if (r0 == 0) goto L_0x015b
            r0.next = r13
            r13 = r0
        L_0x015b:
            r3 = r12
            r6 = r21
            r7 = r22
            r0 = r26
            r1 = r27
            r2 = r28
            r4 = r29
            r5 = r30
        L_0x016a:
            int r12 = r15 + 4
            int r12 = r8.readInt(r12)
            int r12 = r12 + 6
            int r15 = r15 + r12
            int r14 = r14 + -1
            goto L_0x0037
        L_0x0177:
            r26 = r0
            r27 = r1
            r28 = r2
            r12 = r3
            r29 = r4
            r30 = r5
            r21 = r6
            r22 = r7
            int r15 = r15 + 2
            int r1 = r9.access
            java.lang.String r2 = r9.name
            java.lang.String r3 = r9.desc
            r0 = r32
            r4 = r22
            r5 = r21
            org.jacoco.agent.rt.internal_8ff85ea.asm.MethodVisitor r0 = r0.visitMethod(r1, r2, r3, r4, r5)
            if (r0 != 0) goto L_0x019b
            return r15
        L_0x019b:
            boolean r1 = r0 instanceof org.jacoco.agent.p086rt.internal_8ff85ea.asm.MethodWriter
            if (r1 == 0) goto L_0x01df
            r1 = r0
            org.jacoco.agent.rt.internal_8ff85ea.asm.MethodWriter r1 = (org.jacoco.agent.p086rt.internal_8ff85ea.asm.MethodWriter) r1
            org.jacoco.agent.rt.internal_8ff85ea.asm.ClassWriter r2 = r1.f6586cw
            org.jacoco.agent.rt.internal_8ff85ea.asm.ClassReader r2 = r2.f6582cr
            if (r2 != r8) goto L_0x01df
            java.lang.String r2 = r1.signature
            r7 = r22
            if (r7 != r2) goto L_0x01df
            r6 = r21
            if (r6 != 0) goto L_0x01b7
            int r2 = r1.exceptionCount
            if (r2 != 0) goto L_0x01d5
            goto L_0x01d3
        L_0x01b7:
            int r2 = r6.length
            int r3 = r1.exceptionCount
            if (r2 != r3) goto L_0x01d5
            int r2 = r6.length
            r3 = 1
            int r2 = r2 - r3
        L_0x01bf:
            if (r2 < 0) goto L_0x01d3
            int r3 = r17 + -2
            int[] r4 = r1.exceptions
            r4 = r4[r2]
            int r5 = r8.readUnsignedShort(r3)
            if (r4 == r5) goto L_0x01ce
            goto L_0x01d5
        L_0x01ce:
            int r2 = r2 + -1
            r17 = r3
            goto L_0x01bf
        L_0x01d3:
            r2 = 1
            goto L_0x01d6
        L_0x01d5:
            r2 = 0
        L_0x01d6:
            if (r2 == 0) goto L_0x01df
            r1.classReaderOffset = r11
            int r0 = r15 - r11
            r1.classReaderLength = r0
            return r15
        L_0x01df:
            if (r16 == 0) goto L_0x0200
            byte[] r1 = r8.f6580b
            byte r1 = r1[r16]
            r1 = r1 & 255(0xff, float:3.57E-43)
            r2 = 1
            int r16 = r16 + 1
            r2 = r16
        L_0x01ec:
            if (r1 <= 0) goto L_0x0200
            java.lang.String r3 = r8.readUTF8(r2, r10)
            int r4 = r2 + 2
            int r4 = r8.readUnsignedShort(r4)
            r0.visitParameter(r3, r4)
            int r1 = r1 + -1
            int r2 = r2 + 4
            goto L_0x01ec
        L_0x0200:
            if (r12 == 0) goto L_0x020f
            org.jacoco.agent.rt.internal_8ff85ea.asm.AnnotationVisitor r1 = r0.visitAnnotationDefault()
            r2 = 0
            r8.readAnnotationValue(r12, r10, r2, r1)
            if (r1 == 0) goto L_0x020f
            r1.visitEnd()
        L_0x020f:
            r5 = r30
            if (r5 == 0) goto L_0x022d
            int r1 = r8.readUnsignedShort(r5)
            int r5 = r5 + 2
        L_0x0219:
            if (r1 <= 0) goto L_0x022d
            int r2 = r5 + 2
            java.lang.String r3 = r8.readUTF8(r5, r10)
            r4 = 1
            org.jacoco.agent.rt.internal_8ff85ea.asm.AnnotationVisitor r3 = r0.visitAnnotation(r3, r4)
            int r5 = r8.readAnnotationValues(r2, r10, r4, r3)
            int r1 = r1 + -1
            goto L_0x0219
        L_0x022d:
            r4 = r29
            if (r4 == 0) goto L_0x024d
            int r1 = r8.readUnsignedShort(r4)
            int r4 = r4 + 2
        L_0x0237:
            if (r1 <= 0) goto L_0x024d
            int r2 = r4 + 2
            java.lang.String r3 = r8.readUTF8(r4, r10)
            r4 = 0
            org.jacoco.agent.rt.internal_8ff85ea.asm.AnnotationVisitor r3 = r0.visitAnnotation(r3, r4)
            r4 = 1
            int r2 = r8.readAnnotationValues(r2, r10, r4, r3)
            int r1 = r1 + -1
            r4 = r2
            goto L_0x0237
        L_0x024d:
            r2 = r28
            if (r2 == 0) goto L_0x0273
            int r1 = r8.readUnsignedShort(r2)
            int r2 = r2 + 2
        L_0x0257:
            if (r1 <= 0) goto L_0x0273
            int r2 = r8.readAnnotationTarget(r9, r2)
            int r3 = r2 + 2
            int r4 = r9.typeRef
            org.jacoco.agent.rt.internal_8ff85ea.asm.TypePath r5 = r9.typePath
            java.lang.String r2 = r8.readUTF8(r2, r10)
            r6 = 1
            org.jacoco.agent.rt.internal_8ff85ea.asm.AnnotationVisitor r2 = r0.visitTypeAnnotation(r4, r5, r2, r6)
            int r2 = r8.readAnnotationValues(r3, r10, r6, r2)
            int r1 = r1 + -1
            goto L_0x0257
        L_0x0273:
            r1 = r27
            if (r1 == 0) goto L_0x029a
            int r2 = r8.readUnsignedShort(r1)
            int r1 = r1 + 2
        L_0x027d:
            if (r2 <= 0) goto L_0x029a
            int r1 = r8.readAnnotationTarget(r9, r1)
            int r3 = r1 + 2
            int r4 = r9.typeRef
            org.jacoco.agent.rt.internal_8ff85ea.asm.TypePath r5 = r9.typePath
            java.lang.String r1 = r8.readUTF8(r1, r10)
            r6 = 0
            org.jacoco.agent.rt.internal_8ff85ea.asm.AnnotationVisitor r1 = r0.visitTypeAnnotation(r4, r5, r1, r6)
            r4 = 1
            int r1 = r8.readAnnotationValues(r3, r10, r4, r1)
            int r2 = r2 + -1
            goto L_0x027d
        L_0x029a:
            r4 = 1
            r1 = r18
            if (r1 == 0) goto L_0x02a2
            r8.readParameterAnnotations(r0, r9, r1, r4)
        L_0x02a2:
            r1 = r26
            if (r1 == 0) goto L_0x02aa
            r2 = 0
            r8.readParameterAnnotations(r0, r9, r1, r2)
        L_0x02aa:
            if (r13 == 0) goto L_0x02b6
            org.jacoco.agent.rt.internal_8ff85ea.asm.Attribute r1 = r13.next
            r2 = 0
            r13.next = r2
            r0.visitAttribute(r13)
            r13 = r1
            goto L_0x02aa
        L_0x02b6:
            r13 = r19
            if (r13 == 0) goto L_0x02c0
            r0.visitCode()
            r8.readCode(r0, r9, r13)
        L_0x02c0:
            r0.visitEnd()
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jacoco.agent.p086rt.internal_8ff85ea.asm.ClassReader.readMethod(org.jacoco.agent.rt.internal_8ff85ea.asm.ClassVisitor, org.jacoco.agent.rt.internal_8ff85ea.asm.Context, int):int");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: IfRegionVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Don't wrap MOVE or CONST insns: 0x089c: MOVE  (r0v29 int) = (r24v1 int)
        	at jadx.core.dex.instructions.args.InsnArg.wrapArg(InsnArg.java:164)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.assignInline(CodeShrinkVisitor.java:133)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.checkInline(CodeShrinkVisitor.java:118)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkBlock(CodeShrinkVisitor.java:65)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkMethod(CodeShrinkVisitor.java:43)
        	at jadx.core.dex.visitors.regions.TernaryMod.makeTernaryInsn(TernaryMod.java:122)
        	at jadx.core.dex.visitors.regions.TernaryMod.visitRegion(TernaryMod.java:34)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:73)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:27)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.visit(IfRegionVisitor.java:31)
        */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x04be  */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x04dc  */
    /* JADX WARNING: Removed duplicated region for block: B:197:0x0538  */
    /* JADX WARNING: Removed duplicated region for block: B:202:0x056e  */
    /* JADX WARNING: Removed duplicated region for block: B:206:0x05b1  */
    /* JADX WARNING: Removed duplicated region for block: B:210:0x05ee  */
    /* JADX WARNING: Removed duplicated region for block: B:211:0x0600  */
    /* JADX WARNING: Removed duplicated region for block: B:212:0x0612  */
    /* JADX WARNING: Removed duplicated region for block: B:213:0x0626  */
    /* JADX WARNING: Removed duplicated region for block: B:214:0x063c  */
    /* JADX WARNING: Removed duplicated region for block: B:218:0x065e  */
    /* JADX WARNING: Removed duplicated region for block: B:222:0x06c6  */
    /* JADX WARNING: Removed duplicated region for block: B:233:0x071f  */
    /* JADX WARNING: Removed duplicated region for block: B:234:0x0735  */
    /* JADX WARNING: Removed duplicated region for block: B:238:0x075d  */
    /* JADX WARNING: Removed duplicated region for block: B:239:0x0773  */
    /* JADX WARNING: Removed duplicated region for block: B:241:0x078b  */
    /* JADX WARNING: Removed duplicated region for block: B:243:0x07a1  */
    private void readCode(org.jacoco.agent.p086rt.internal_8ff85ea.asm.MethodVisitor r44, org.jacoco.agent.p086rt.internal_8ff85ea.asm.Context r45, int r46) {
        /*
            r43 = this;
            r7 = r43
            r15 = r44
            r14 = r45
            r0 = r46
            byte[] r8 = r7.f6580b
            char[] r13 = r14.buffer
            int r12 = r7.readUnsignedShort(r0)
            int r1 = r0 + 2
            int r11 = r7.readUnsignedShort(r1)
            int r1 = r0 + 4
            int r9 = r7.readInt(r1)
            r10 = 8
            int r16 = r0 + 8
            int r6 = r16 + r9
            int r0 = r9 + 2
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label[] r5 = new org.jacoco.agent.p086rt.internal_8ff85ea.asm.Label[r0]
            r14.labels = r5
            int r0 = r9 + 1
            r7.readLabel(r0, r5)
            r0 = r16
        L_0x002f:
            r4 = 132(0x84, float:1.85E-43)
            r3 = 1
            if (r0 >= r6) goto L_0x00d8
            int r1 = r0 - r16
            byte r2 = r8[r0]
            r2 = r2 & 255(0xff, float:3.57E-43)
            byte[] r17 = org.jacoco.agent.p086rt.internal_8ff85ea.asm.ClassWriter.TYPE
            byte r2 = r17[r2]
            switch(r2) {
                case 0: goto L_0x00d4;
                case 1: goto L_0x00d0;
                case 2: goto L_0x00cc;
                case 3: goto L_0x00d0;
                case 4: goto L_0x00d4;
                case 5: goto L_0x00cc;
                case 6: goto L_0x00cc;
                case 7: goto L_0x00c8;
                case 8: goto L_0x00c8;
                case 9: goto L_0x00bd;
                case 10: goto L_0x00b2;
                case 11: goto L_0x00d0;
                case 12: goto L_0x00cc;
                case 13: goto L_0x00cc;
                case 14: goto L_0x0082;
                case 15: goto L_0x005b;
                case 16: goto L_0x0041;
                case 17: goto L_0x0050;
                case 18: goto L_0x0044;
                default: goto L_0x0041;
            }
        L_0x0041:
            int r0 = r0 + 4
            goto L_0x002f
        L_0x0044:
            int r2 = r0 + 1
            int r2 = r7.readUnsignedShort(r2)
            int r1 = r1 + r2
            r7.readLabel(r1, r5)
            goto L_0x00cc
        L_0x0050:
            int r1 = r0 + 1
            byte r1 = r8[r1]
            r1 = r1 & 255(0xff, float:3.57E-43)
            if (r1 != r4) goto L_0x0041
            int r0 = r0 + 6
            goto L_0x002f
        L_0x005b:
            int r0 = r0 + 4
            r2 = r1 & 3
            int r0 = r0 - r2
            int r2 = r7.readInt(r0)
            int r2 = r2 + r1
            r7.readLabel(r2, r5)
            int r2 = r0 + 4
            int r2 = r7.readInt(r2)
        L_0x006e:
            if (r2 <= 0) goto L_0x007f
            int r3 = r0 + 12
            int r3 = r7.readInt(r3)
            int r3 = r3 + r1
            r7.readLabel(r3, r5)
            int r0 = r0 + 8
            int r2 = r2 + -1
            goto L_0x006e
        L_0x007f:
            int r0 = r0 + 8
            goto L_0x002f
        L_0x0082:
            int r0 = r0 + 4
            r2 = r1 & 3
            int r0 = r0 - r2
            int r2 = r7.readInt(r0)
            int r2 = r2 + r1
            r7.readLabel(r2, r5)
            int r2 = r0 + 8
            int r2 = r7.readInt(r2)
            int r4 = r0 + 4
            int r4 = r7.readInt(r4)
            int r2 = r2 - r4
            int r2 = r2 + r3
        L_0x009d:
            if (r2 <= 0) goto L_0x00ae
            int r3 = r0 + 12
            int r3 = r7.readInt(r3)
            int r3 = r3 + r1
            r7.readLabel(r3, r5)
            int r0 = r0 + 4
            int r2 = r2 + -1
            goto L_0x009d
        L_0x00ae:
            int r0 = r0 + 12
            goto L_0x002f
        L_0x00b2:
            int r2 = r0 + 1
            int r2 = r7.readInt(r2)
            int r1 = r1 + r2
            r7.readLabel(r1, r5)
            goto L_0x00c8
        L_0x00bd:
            int r2 = r0 + 1
            short r2 = r7.readShort(r2)
            int r1 = r1 + r2
            r7.readLabel(r1, r5)
            goto L_0x00cc
        L_0x00c8:
            int r0 = r0 + 5
            goto L_0x002f
        L_0x00cc:
            int r0 = r0 + 3
            goto L_0x002f
        L_0x00d0:
            int r0 = r0 + 2
            goto L_0x002f
        L_0x00d4:
            int r0 = r0 + 1
            goto L_0x002f
        L_0x00d8:
            int r1 = r7.readUnsignedShort(r0)
        L_0x00dc:
            if (r1 <= 0) goto L_0x0115
            int r2 = r0 + 2
            int r2 = r7.readUnsignedShort(r2)
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label r2 = r7.readLabel(r2, r5)
            int r4 = r0 + 4
            int r4 = r7.readUnsignedShort(r4)
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label r4 = r7.readLabel(r4, r5)
            int r3 = r0 + 6
            int r3 = r7.readUnsignedShort(r3)
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label r3 = r7.readLabel(r3, r5)
            int[] r10 = r7.items
            int r0 = r0 + 8
            int r19 = r7.readUnsignedShort(r0)
            r10 = r10[r19]
            java.lang.String r10 = r7.readUTF8(r10, r13)
            r15.visitTryCatchBlock(r2, r4, r3, r10)
            int r1 = r1 + -1
            r3 = 1
            r4 = 132(0x84, float:1.85E-43)
            r10 = 8
            goto L_0x00dc
        L_0x0115:
            int r0 = r0 + 2
            int r1 = r14.flags
            r2 = 8
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0120
            r4 = 1
            goto L_0x0121
        L_0x0120:
            r4 = 0
        L_0x0121:
            int r1 = r7.readUnsignedShort(r0)
            r19 = r0
            r20 = r1
            r30 = r4
            r0 = 0
            r1 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 1
            r27 = 0
            r28 = -1
            r29 = -1
        L_0x013f:
            r4 = 67
            if (r20 <= 0) goto L_0x0359
            int r2 = r19 + 2
            java.lang.String r2 = r7.readUTF8(r2, r13)
            java.lang.String r3 = "LocalVariableTable"
            boolean r3 = r3.equals(r2)
            if (r3 == 0) goto L_0x01b4
            int r2 = r14.flags
            r2 = r2 & 2
            if (r2 != 0) goto L_0x01ad
            int r2 = r19 + 8
            int r3 = r7.readUnsignedShort(r2)
            r4 = r19
        L_0x015f:
            if (r3 <= 0) goto L_0x019f
            int r10 = r4 + 10
            r33 = r0
            int r0 = r7.readUnsignedShort(r10)
            r24 = r5[r0]
            r34 = r1
            if (r24 != 0) goto L_0x017e
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label r1 = r7.readLabel(r0, r5)
            r24 = r2
            int r2 = r1.status
            r17 = 1
            r2 = r2 | 1
            r1.status = r2
            goto L_0x0180
        L_0x017e:
            r24 = r2
        L_0x0180:
            int r4 = r4 + 12
            int r1 = r7.readUnsignedShort(r4)
            int r0 = r0 + r1
            r1 = r5[r0]
            if (r1 != 0) goto L_0x0195
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label r0 = r7.readLabel(r0, r5)
            int r1 = r0.status
            r2 = 1
            r1 = r1 | r2
            r0.status = r1
        L_0x0195:
            int r3 = r3 + -1
            r4 = r10
            r2 = r24
            r0 = r33
            r1 = r34
            goto L_0x015f
        L_0x019f:
            r33 = r0
            r34 = r1
            r24 = r2
            r46 = r5
            r40 = r6
            r39 = r30
            goto L_0x02c6
        L_0x01ad:
            r33 = r0
            r34 = r1
        L_0x01b1:
            r3 = 1
            goto L_0x02bc
        L_0x01b4:
            r33 = r0
            r34 = r1
            java.lang.String r0 = "LocalVariableTypeTable"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x01c4
            int r25 = r19 + 8
            goto L_0x02bc
        L_0x01c4:
            java.lang.String r0 = "LineNumberTable"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0211
            int r0 = r14.flags
            r0 = r0 & 2
            if (r0 != 0) goto L_0x01b1
            int r0 = r19 + 8
            int r0 = r7.readUnsignedShort(r0)
            r1 = r19
        L_0x01da:
            if (r0 <= 0) goto L_0x01b1
            int r2 = r1 + 10
            int r2 = r7.readUnsignedShort(r2)
            r3 = r5[r2]
            if (r3 != 0) goto L_0x01f0
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label r3 = r7.readLabel(r2, r5)
            int r4 = r3.status
            r10 = 1
            r4 = r4 | r10
            r3.status = r4
        L_0x01f0:
            r2 = r5[r2]
        L_0x01f2:
            int r3 = r2.line
            if (r3 <= 0) goto L_0x0204
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label r3 = r2.next
            if (r3 != 0) goto L_0x0201
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label r3 = new org.jacoco.agent.rt.internal_8ff85ea.asm.Label
            r3.<init>()
            r2.next = r3
        L_0x0201:
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label r2 = r2.next
            goto L_0x01f2
        L_0x0204:
            int r3 = r1 + 12
            int r3 = r7.readUnsignedShort(r3)
            r2.line = r3
            int r1 = r1 + 4
            int r0 = r0 + -1
            goto L_0x01da
        L_0x0211:
            java.lang.String r0 = "RuntimeVisibleTypeAnnotations"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0244
            int r0 = r19 + 8
            r1 = 1
            int[] r0 = r7.readTypeAnnotations(r15, r14, r0, r1)
            int r2 = r0.length
            if (r2 == 0) goto L_0x0235
            r2 = 0
            r3 = r0[r2]
            int r3 = r7.readByte(r3)
            if (r3 >= r4) goto L_0x022d
            goto L_0x0235
        L_0x022d:
            r3 = r0[r2]
            int r3 = r3 + r1
            int r1 = r7.readUnsignedShort(r3)
            goto L_0x0236
        L_0x0235:
            r1 = -1
        L_0x0236:
            r28 = r1
            r46 = r5
            r40 = r6
            r39 = r30
            r15 = -1
            r1 = r0
            r0 = r33
            goto L_0x0343
        L_0x0244:
            java.lang.String r0 = "RuntimeInvisibleTypeAnnotations"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0273
            int r0 = r19 + 8
            r1 = 0
            int[] r0 = r7.readTypeAnnotations(r15, r14, r0, r1)
            int r2 = r0.length
            if (r2 == 0) goto L_0x0268
            r2 = r0[r1]
            int r2 = r7.readByte(r2)
            if (r2 >= r4) goto L_0x025f
            goto L_0x0268
        L_0x025f:
            r2 = r0[r1]
            r3 = 1
            int r2 = r2 + r3
            int r1 = r7.readUnsignedShort(r2)
            goto L_0x026a
        L_0x0268:
            r3 = 1
            r1 = -1
        L_0x026a:
            r29 = r1
            r46 = r5
            r40 = r6
            r39 = r30
            goto L_0x02c4
        L_0x0273:
            r3 = 1
            java.lang.String r0 = "StackMapTable"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0291
            int r0 = r14.flags
            r0 = r0 & 4
            if (r0 != 0) goto L_0x02bc
            int r21 = r19 + 10
            int r0 = r19 + 4
            int r22 = r7.readInt(r0)
            int r0 = r19 + 8
            int r27 = r7.readUnsignedShort(r0)
            goto L_0x02bc
        L_0x0291:
            java.lang.String r0 = "StackMap"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x02c9
            int r0 = r14.flags
            r0 = r0 & 4
            if (r0 != 0) goto L_0x02bc
            int r21 = r19 + 10
            int r0 = r19 + 4
            int r22 = r7.readInt(r0)
            int r0 = r19 + 8
            int r27 = r7.readUnsignedShort(r0)
            r46 = r5
            r40 = r6
            r39 = r30
            r0 = r33
            r1 = r34
            r15 = -1
            r26 = 0
            goto L_0x0343
        L_0x02bc:
            r46 = r5
            r40 = r6
            r39 = r30
            r0 = r33
        L_0x02c4:
            r1 = r34
        L_0x02c6:
            r15 = -1
            goto L_0x0343
        L_0x02c9:
            r10 = r23
            r4 = 0
        L_0x02cc:
            org.jacoco.agent.rt.internal_8ff85ea.asm.Attribute[] r0 = r14.attrs
            int r0 = r0.length
            if (r4 >= r0) goto L_0x0332
            org.jacoco.agent.rt.internal_8ff85ea.asm.Attribute[] r0 = r14.attrs
            r0 = r0[r4]
            java.lang.String r0 = r0.type
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0311
            org.jacoco.agent.rt.internal_8ff85ea.asm.Attribute[] r0 = r14.attrs
            r0 = r0[r4]
            int r17 = r19 + 8
            int r1 = r19 + 4
            int r23 = r7.readInt(r1)
            int r35 = r16 + -8
            r1 = r33
            r37 = r1
            r36 = r34
            r1 = r43
            r31 = r2
            r15 = -1
            r2 = r17
            r3 = r23
            r17 = r4
            r39 = r30
            r4 = r13
            r46 = r5
            r5 = r35
            r40 = r6
            r6 = r46
            org.jacoco.agent.rt.internal_8ff85ea.asm.Attribute r0 = r0.read(r1, r2, r3, r4, r5, r6)
            if (r0 == 0) goto L_0x0320
            r0.next = r10
            r10 = r0
            goto L_0x0320
        L_0x0311:
            r31 = r2
            r17 = r4
            r46 = r5
            r40 = r6
            r39 = r30
            r37 = r33
            r36 = r34
            r15 = -1
        L_0x0320:
            int r4 = r17 + 1
            r15 = r44
            r5 = r46
            r2 = r31
            r34 = r36
            r33 = r37
            r30 = r39
            r6 = r40
            r3 = 1
            goto L_0x02cc
        L_0x0332:
            r46 = r5
            r40 = r6
            r39 = r30
            r37 = r33
            r36 = r34
            r15 = -1
            r23 = r10
            r1 = r36
            r0 = r37
        L_0x0343:
            int r2 = r19 + 4
            int r2 = r7.readInt(r2)
            int r2 = r2 + 6
            int r19 = r19 + r2
            int r20 = r20 + -1
            r15 = r44
            r5 = r46
            r30 = r39
            r6 = r40
            goto L_0x013f
        L_0x0359:
            r37 = r0
            r36 = r1
            r46 = r5
            r40 = r6
            r39 = r30
            r15 = -1
            if (r21 == 0) goto L_0x03b4
            r14.offset = r15
            r0 = 0
            r14.mode = r0
            r14.localCount = r0
            r14.localDiff = r0
            r14.stackCount = r0
            java.lang.Object[] r0 = new java.lang.Object[r11]
            r14.local = r0
            java.lang.Object[] r0 = new java.lang.Object[r12]
            r14.stack = r0
            r10 = r39
            if (r10 == 0) goto L_0x0380
            r7.getImplicitFrame(r14)
        L_0x0380:
            r0 = r21
        L_0x0382:
            int r1 = r21 + r22
            int r1 = r1 + -2
            if (r0 >= r1) goto L_0x03af
            byte r1 = r8[r0]
            r2 = 8
            if (r1 != r2) goto L_0x03a8
            int r1 = r0 + 1
            int r1 = r7.readUnsignedShort(r1)
            if (r1 < 0) goto L_0x03a8
            if (r1 >= r9) goto L_0x03a8
            int r2 = r16 + r1
            byte r2 = r8[r2]
            r2 = r2 & 255(0xff, float:3.57E-43)
            r3 = 187(0xbb, float:2.62E-43)
            if (r2 != r3) goto L_0x03a8
            r6 = r46
            r7.readLabel(r1, r6)
            goto L_0x03aa
        L_0x03a8:
            r6 = r46
        L_0x03aa:
            int r0 = r0 + 1
            r46 = r6
            goto L_0x0382
        L_0x03af:
            r6 = r46
            r17 = r14
            goto L_0x03ba
        L_0x03b4:
            r6 = r46
            r10 = r39
            r17 = 0
        L_0x03ba:
            int r0 = r14.flags
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x03d1
            r1 = -1
            r3 = 0
            r5 = 0
            r19 = 0
            r0 = r44
            r2 = r11
            r15 = 67
            r4 = r5
            r5 = r19
            r0.visitFrame(r1, r2, r3, r4, r5)
            goto L_0x03d3
        L_0x03d1:
            r15 = 67
        L_0x03d3:
            int r0 = r14.flags
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 != 0) goto L_0x03de
            r2 = -33
            r19 = -33
            goto L_0x03e0
        L_0x03de:
            r19 = 0
        L_0x03e0:
            r5 = r16
            r3 = r17
            r17 = 0
            r20 = 0
        L_0x03e8:
            r4 = r40
            if (r5 >= r4) goto L_0x0880
            int r2 = r5 - r16
            r0 = r6[r2]
            if (r0 == 0) goto L_0x0418
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label r1 = r0.next
            r15 = 0
            r0.next = r15
            r15 = r44
            r30 = r11
            r11 = -1
            r15.visitLabel(r0)
            int r11 = r14.flags
            r11 = r11 & 2
            if (r11 != 0) goto L_0x041c
            int r11 = r0.line
            if (r11 <= 0) goto L_0x041c
            int r11 = r0.line
            r15.visitLineNumber(r11, r0)
        L_0x040e:
            if (r1 == 0) goto L_0x041c
            int r11 = r1.line
            r15.visitLineNumber(r11, r0)
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label r1 = r1.next
            goto L_0x040e
        L_0x0418:
            r15 = r44
            r30 = r11
        L_0x041c:
            r11 = r3
            r3 = r21
        L_0x041f:
            if (r11 == 0) goto L_0x04a7
            int r0 = r11.offset
            if (r0 == r2) goto L_0x042b
            int r0 = r11.offset
            r1 = -1
            if (r0 != r1) goto L_0x04a7
            goto L_0x042c
        L_0x042b:
            r1 = -1
        L_0x042c:
            int r0 = r11.offset
            if (r0 == r1) goto L_0x0478
            r1 = r26
            if (r1 == 0) goto L_0x045e
            if (r10 == 0) goto L_0x0437
            goto L_0x045e
        L_0x0437:
            int r0 = r11.mode
            r46 = r2
            int r2 = r11.localDiff
            r21 = r3
            java.lang.Object[] r3 = r11.local
            r40 = r4
            int r4 = r11.stackCount
            r26 = r5
            java.lang.Object[] r5 = r11.stack
            r32 = r0
            r0 = r44
            r33 = r12
            r12 = r1
            r1 = r32
            r32 = r9
            r9 = r46
            r14 = r21
            r21 = r40
            r0.visitFrame(r1, r2, r3, r4, r5)
            goto L_0x0484
        L_0x045e:
            r14 = r3
            r21 = r4
            r26 = r5
            r32 = r9
            r33 = r12
            r12 = r1
            r9 = r2
            r1 = -1
            int r2 = r11.localCount
            java.lang.Object[] r3 = r11.local
            int r4 = r11.stackCount
            java.lang.Object[] r5 = r11.stack
            r0 = r44
            r0.visitFrame(r1, r2, r3, r4, r5)
            goto L_0x0484
        L_0x0478:
            r14 = r3
            r21 = r4
            r32 = r9
            r33 = r12
            r12 = r26
            r9 = r2
            r26 = r5
        L_0x0484:
            if (r27 <= 0) goto L_0x0496
            int r3 = r7.readFrame(r14, r12, r10, r11)
            int r27 = r27 + -1
            r14 = r45
            r2 = r9
            r4 = r21
            r5 = r26
            r9 = r32
            goto L_0x04a1
        L_0x0496:
            r2 = r9
            r3 = r14
            r4 = r21
            r5 = r26
            r9 = r32
            r11 = 0
            r14 = r45
        L_0x04a1:
            r26 = r12
            r12 = r33
            goto L_0x041f
        L_0x04a7:
            r14 = r3
            r21 = r4
            r32 = r9
            r33 = r12
            r12 = r26
            r9 = r2
            r26 = r5
            byte r0 = r8[r26]
            r5 = r0 & 255(0xff, float:3.57E-43)
            byte[] r0 = org.jacoco.agent.p086rt.internal_8ff85ea.asm.ClassWriter.TYPE
            byte r0 = r0[r5]
            switch(r0) {
                case 0: goto L_0x07a1;
                case 1: goto L_0x078b;
                case 2: goto L_0x0773;
                case 3: goto L_0x075d;
                case 4: goto L_0x0735;
                case 5: goto L_0x071f;
                case 6: goto L_0x06c6;
                case 7: goto L_0x06c6;
                case 8: goto L_0x065e;
                case 9: goto L_0x063c;
                case 10: goto L_0x0626;
                case 11: goto L_0x0612;
                case 12: goto L_0x0600;
                case 13: goto L_0x05ee;
                case 14: goto L_0x05b1;
                case 15: goto L_0x056e;
                case 16: goto L_0x04be;
                case 17: goto L_0x0538;
                case 18: goto L_0x04dc;
                default: goto L_0x04be;
            }
        L_0x04be:
            r39 = r10
            r38 = r12
            r10 = r14
            r18 = 8
            r35 = 132(0x84, float:1.85E-43)
            r14 = r45
            int r5 = r26 + 1
            java.lang.String r0 = r7.readClass((int) r5, (char[]) r13)
            int r5 = r26 + 3
            byte r1 = r8[r5]
            r1 = r1 & 255(0xff, float:3.57E-43)
            r15.visitMultiANewArrayInsn(r0, r1)
            int r5 = r26 + 4
            goto L_0x07b2
        L_0x04dc:
            r0 = 218(0xda, float:3.05E-43)
            if (r5 >= r0) goto L_0x04e3
            int r5 = r5 + -49
            goto L_0x04e5
        L_0x04e3:
            int r5 = r5 + -20
        L_0x04e5:
            int r0 = r26 + 1
            int r0 = r7.readUnsignedShort(r0)
            int r2 = r9 + r0
            r0 = r6[r2]
            r1 = 167(0xa7, float:2.34E-43)
            if (r5 == r1) goto L_0x0530
            r1 = 168(0xa8, float:2.35E-43)
            if (r5 != r1) goto L_0x04f8
            goto L_0x0530
        L_0x04f8:
            r1 = 166(0xa6, float:2.33E-43)
            if (r5 > r1) goto L_0x0503
            int r5 = r5 + 1
            r4 = 1
            r1 = r5 ^ 1
            int r1 = r1 - r4
            goto L_0x0506
        L_0x0503:
            r4 = 1
            r1 = r5 ^ 1
        L_0x0506:
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label r2 = new org.jacoco.agent.rt.internal_8ff85ea.asm.Label
            r2.<init>()
            r15.visitJumpInsn(r1, r2)
            r1 = 200(0xc8, float:2.8E-43)
            r15.visitJumpInsn(r1, r0)
            r15.visitLabel(r2)
            if (r14 == 0) goto L_0x0535
            if (r11 == 0) goto L_0x0520
            int r0 = r11.offset
            int r2 = r9 + 3
            if (r0 == r2) goto L_0x0535
        L_0x0520:
            r1 = 256(0x100, float:3.59E-43)
            r2 = 0
            r3 = 0
            r5 = 0
            r34 = 0
            r0 = r44
            r4 = r5
            r5 = r34
            r0.visitFrame(r1, r2, r3, r4, r5)
            goto L_0x0535
        L_0x0530:
            int r5 = r5 + 33
            r15.visitJumpInsn(r5, r0)
        L_0x0535:
            int r5 = r26 + 3
            goto L_0x055f
        L_0x0538:
            int r5 = r26 + 1
            byte r0 = r8[r5]
            r0 = r0 & 255(0xff, float:3.57E-43)
            r4 = 132(0x84, float:1.85E-43)
            if (r0 != r4) goto L_0x0554
            int r5 = r26 + 2
            int r0 = r7.readUnsignedShort(r5)
            int r5 = r26 + 4
            short r1 = r7.readShort(r5)
            r15.visitIincInsn(r0, r1)
            int r5 = r26 + 6
            goto L_0x055f
        L_0x0554:
            int r5 = r26 + 2
            int r1 = r7.readUnsignedShort(r5)
            r15.visitVarInsn(r0, r1)
            int r5 = r26 + 4
        L_0x055f:
            r39 = r10
            r38 = r12
            r10 = r14
            r0 = r17
            r1 = r28
            r12 = r36
            r18 = 8
            goto L_0x0658
        L_0x056e:
            r4 = 132(0x84, float:1.85E-43)
            int r5 = r26 + 4
            r0 = r9 & 3
            int r5 = r5 - r0
            int r0 = r7.readInt(r5)
            int r2 = r9 + r0
            int r0 = r5 + 4
            int r0 = r7.readInt(r0)
            int[] r1 = new int[r0]
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label[] r3 = new org.jacoco.agent.p086rt.internal_8ff85ea.asm.Label[r0]
            r18 = 8
            int r5 = r5 + 8
            r4 = r5
            r5 = 0
        L_0x058b:
            if (r5 >= r0) goto L_0x05a7
            int r26 = r7.readInt(r4)
            r1[r5] = r26
            r46 = r0
            int r0 = r4 + 4
            int r0 = r7.readInt(r0)
            int r0 = r0 + r9
            r0 = r6[r0]
            r3[r5] = r0
            int r4 = r4 + 8
            int r5 = r5 + 1
            r0 = r46
            goto L_0x058b
        L_0x05a7:
            r0 = r6[r2]
            r15.visitLookupSwitchInsn(r0, r1, r3)
            r5 = r4
            r39 = r10
            goto L_0x064f
        L_0x05b1:
            r18 = 8
            int r5 = r26 + 4
            r0 = r9 & 3
            int r5 = r5 - r0
            int r0 = r7.readInt(r5)
            int r2 = r9 + r0
            int r0 = r5 + 4
            int r0 = r7.readInt(r0)
            int r1 = r5 + 8
            int r1 = r7.readInt(r1)
            int r3 = r1 - r0
            r4 = 1
            int r3 = r3 + r4
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label[] r4 = new org.jacoco.agent.p086rt.internal_8ff85ea.asm.Label[r3]
            int r5 = r5 + 12
            r39 = r10
            r10 = r5
            r5 = 0
        L_0x05d6:
            if (r5 >= r3) goto L_0x05e7
            int r26 = r7.readInt(r10)
            int r26 = r9 + r26
            r26 = r6[r26]
            r4[r5] = r26
            int r10 = r10 + 4
            int r5 = r5 + 1
            goto L_0x05d6
        L_0x05e7:
            r2 = r6[r2]
            r15.visitTableSwitchInsn(r0, r1, r2, r4)
            r5 = r10
            goto L_0x064f
        L_0x05ee:
            r39 = r10
            r18 = 8
            int r5 = r26 + 1
            byte r0 = r8[r5]
            r0 = r0 & 255(0xff, float:3.57E-43)
            int r5 = r26 + 2
            byte r1 = r8[r5]
            r15.visitIincInsn(r0, r1)
            goto L_0x064d
        L_0x0600:
            r39 = r10
            r18 = 8
            int r5 = r26 + 1
            int r0 = r7.readUnsignedShort(r5)
            java.lang.Object r0 = r7.readConst(r0, r13)
            r15.visitLdcInsn(r0)
            goto L_0x064d
        L_0x0612:
            r39 = r10
            r18 = 8
            int r5 = r26 + 1
            byte r0 = r8[r5]
            r0 = r0 & 255(0xff, float:3.57E-43)
            java.lang.Object r0 = r7.readConst(r0, r13)
            r15.visitLdcInsn(r0)
            int r5 = r26 + 2
            goto L_0x064f
        L_0x0626:
            r39 = r10
            r18 = 8
            int r5 = r5 + r19
            int r0 = r26 + 1
            int r0 = r7.readInt(r0)
            int r2 = r9 + r0
            r0 = r6[r2]
            r15.visitJumpInsn(r5, r0)
            int r5 = r26 + 5
            goto L_0x064f
        L_0x063c:
            r39 = r10
            r18 = 8
            int r0 = r26 + 1
            short r0 = r7.readShort(r0)
            int r2 = r9 + r0
            r0 = r6[r2]
            r15.visitJumpInsn(r5, r0)
        L_0x064d:
            int r5 = r26 + 3
        L_0x064f:
            r38 = r12
            r10 = r14
            r0 = r17
            r1 = r28
            r12 = r36
        L_0x0658:
            r35 = 132(0x84, float:1.85E-43)
            r14 = r45
            goto L_0x07b8
        L_0x065e:
            r39 = r10
            r18 = 8
            int[] r0 = r7.items
            int r5 = r26 + 1
            int r1 = r7.readUnsignedShort(r5)
            r0 = r0[r1]
            r10 = r14
            r14 = r45
            int[] r1 = r14.bootstrapMethods
            int r2 = r7.readUnsignedShort(r0)
            r1 = r1[r2]
            int r2 = r7.readUnsignedShort(r1)
            java.lang.Object r2 = r7.readConst(r2, r13)
            org.jacoco.agent.rt.internal_8ff85ea.asm.Handle r2 = (org.jacoco.agent.p086rt.internal_8ff85ea.asm.Handle) r2
            int r3 = r1 + 2
            int r3 = r7.readUnsignedShort(r3)
            java.lang.Object[] r4 = new java.lang.Object[r3]
            int r1 = r1 + 4
            r5 = 0
        L_0x068c:
            if (r5 >= r3) goto L_0x06a1
            r46 = r3
            int r3 = r7.readUnsignedShort(r1)
            java.lang.Object r3 = r7.readConst(r3, r13)
            r4[r5] = r3
            int r1 = r1 + 2
            int r5 = r5 + 1
            r3 = r46
            goto L_0x068c
        L_0x06a1:
            int[] r1 = r7.items
            int r0 = r0 + 2
            int r0 = r7.readUnsignedShort(r0)
            r0 = r1[r0]
            java.lang.String r1 = r7.readUTF8(r0, r13)
            int r0 = r0 + 2
            java.lang.String r0 = r7.readUTF8(r0, r13)
            r15.visitInvokeDynamicInsn(r1, r0, r2, r4)
            int r5 = r26 + 5
            r38 = r12
            r0 = r17
            r1 = r28
            r12 = r36
            r35 = 132(0x84, float:1.85E-43)
            goto L_0x07b8
        L_0x06c6:
            r39 = r10
            r10 = r14
            r18 = 8
            r14 = r45
            int[] r0 = r7.items
            int r1 = r26 + 1
            int r1 = r7.readUnsignedShort(r1)
            r0 = r0[r1]
            int r1 = r0 + -1
            byte r1 = r8[r1]
            r2 = 11
            if (r1 != r2) goto L_0x06e2
            r34 = 1
            goto L_0x06e4
        L_0x06e2:
            r34 = 0
        L_0x06e4:
            java.lang.String r2 = r7.readClass((int) r0, (char[]) r13)
            int[] r1 = r7.items
            int r0 = r0 + 2
            int r0 = r7.readUnsignedShort(r0)
            r0 = r1[r0]
            java.lang.String r3 = r7.readUTF8(r0, r13)
            int r0 = r0 + 2
            java.lang.String r4 = r7.readUTF8(r0, r13)
            r0 = 182(0xb6, float:2.55E-43)
            if (r5 >= r0) goto L_0x0709
            r15.visitFieldInsn(r5, r2, r3, r4)
            r38 = r12
            r35 = 132(0x84, float:1.85E-43)
            r12 = r5
            goto L_0x0717
        L_0x0709:
            r0 = r44
            r1 = r5
            r38 = r12
            r12 = 1
            r35 = 132(0x84, float:1.85E-43)
            r12 = r5
            r5 = r34
            r0.visitMethodInsn(r1, r2, r3, r4, r5)
        L_0x0717:
            r0 = 185(0xb9, float:2.59E-43)
            if (r12 != r0) goto L_0x0788
            int r5 = r26 + 5
            goto L_0x07b2
        L_0x071f:
            r39 = r10
            r38 = r12
            r10 = r14
            r18 = 8
            r35 = 132(0x84, float:1.85E-43)
            r14 = r45
            r12 = r5
            int r5 = r26 + 1
            java.lang.String r0 = r7.readClass((int) r5, (char[]) r13)
            r15.visitTypeInsn(r12, r0)
            goto L_0x0788
        L_0x0735:
            r39 = r10
            r38 = r12
            r10 = r14
            r18 = 8
            r35 = 132(0x84, float:1.85E-43)
            r14 = r45
            r12 = r5
            r0 = 54
            if (r12 <= r0) goto L_0x0751
            int r5 = r12 + -59
            int r1 = r5 >> 2
            int r1 = r1 + r0
            r0 = r5 & 3
            r15.visitVarInsn(r1, r0)
            goto L_0x07b0
        L_0x0751:
            int r5 = r12 + -26
            int r0 = r5 >> 2
            int r0 = r0 + 21
            r1 = r5 & 3
            r15.visitVarInsn(r0, r1)
            goto L_0x07b0
        L_0x075d:
            r39 = r10
            r38 = r12
            r10 = r14
            r18 = 8
            r35 = 132(0x84, float:1.85E-43)
            r14 = r45
            r12 = r5
            int r5 = r26 + 1
            byte r0 = r8[r5]
            r0 = r0 & 255(0xff, float:3.57E-43)
            r15.visitVarInsn(r12, r0)
            goto L_0x079e
        L_0x0773:
            r39 = r10
            r38 = r12
            r10 = r14
            r18 = 8
            r35 = 132(0x84, float:1.85E-43)
            r14 = r45
            r12 = r5
            int r5 = r26 + 1
            short r0 = r7.readShort(r5)
            r15.visitIntInsn(r12, r0)
        L_0x0788:
            int r5 = r26 + 3
            goto L_0x07b2
        L_0x078b:
            r39 = r10
            r38 = r12
            r10 = r14
            r18 = 8
            r35 = 132(0x84, float:1.85E-43)
            r14 = r45
            r12 = r5
            int r5 = r26 + 1
            byte r0 = r8[r5]
            r15.visitIntInsn(r12, r0)
        L_0x079e:
            int r5 = r26 + 2
            goto L_0x07b2
        L_0x07a1:
            r39 = r10
            r38 = r12
            r10 = r14
            r18 = 8
            r35 = 132(0x84, float:1.85E-43)
            r14 = r45
            r12 = r5
            r15.visitInsn(r12)
        L_0x07b0:
            int r5 = r26 + 1
        L_0x07b2:
            r0 = r17
            r1 = r28
            r12 = r36
        L_0x07b8:
            if (r12 == 0) goto L_0x07fc
            int r2 = r12.length
            if (r0 >= r2) goto L_0x07fc
            if (r1 > r9) goto L_0x07fc
            if (r1 != r9) goto L_0x07dc
            r1 = r12[r0]
            int r1 = r7.readAnnotationTarget(r14, r1)
            int r2 = r1 + 2
            int r3 = r14.typeRef
            org.jacoco.agent.rt.internal_8ff85ea.asm.TypePath r4 = r14.typePath
            java.lang.String r1 = r7.readUTF8(r1, r13)
            r46 = r5
            r5 = 1
            org.jacoco.agent.rt.internal_8ff85ea.asm.AnnotationVisitor r1 = r15.visitInsnAnnotation(r3, r4, r1, r5)
            r7.readAnnotationValues(r2, r13, r5, r1)
            goto L_0x07de
        L_0x07dc:
            r46 = r5
        L_0x07de:
            int r0 = r0 + 1
            int r1 = r12.length
            if (r0 >= r1) goto L_0x07f8
            r1 = r12[r0]
            int r1 = r7.readByte(r1)
            r2 = 67
            if (r1 >= r2) goto L_0x07ee
            goto L_0x07f8
        L_0x07ee:
            r1 = r12[r0]
            r2 = 1
            int r1 = r1 + r2
            int r2 = r7.readUnsignedShort(r1)
            r1 = r2
            goto L_0x07f9
        L_0x07f8:
            r1 = -1
        L_0x07f9:
            r5 = r46
            goto L_0x07b8
        L_0x07fc:
            r46 = r5
            r2 = r20
            r3 = r29
            r5 = r37
        L_0x0804:
            if (r5 == 0) goto L_0x0858
            int r4 = r5.length
            if (r2 >= r4) goto L_0x0858
            if (r3 > r9) goto L_0x0858
            if (r3 != r9) goto L_0x082d
            r3 = r5[r2]
            int r3 = r7.readAnnotationTarget(r14, r3)
            int r4 = r3 + 2
            r17 = r0
            int r0 = r14.typeRef
            r20 = r1
            org.jacoco.agent.rt.internal_8ff85ea.asm.TypePath r1 = r14.typePath
            java.lang.String r3 = r7.readUTF8(r3, r13)
            r26 = r10
            r10 = 0
            org.jacoco.agent.rt.internal_8ff85ea.asm.AnnotationVisitor r0 = r15.visitInsnAnnotation(r0, r1, r3, r10)
            r1 = 1
            r7.readAnnotationValues(r4, r13, r1, r0)
            goto L_0x0834
        L_0x082d:
            r17 = r0
            r20 = r1
            r26 = r10
            r10 = 0
        L_0x0834:
            int r2 = r2 + 1
            int r0 = r5.length
            if (r2 >= r0) goto L_0x084e
            r0 = r5[r2]
            int r0 = r7.readByte(r0)
            r1 = 67
            if (r0 >= r1) goto L_0x0844
            goto L_0x0850
        L_0x0844:
            r0 = r5[r2]
            r3 = 1
            int r0 = r0 + r3
            int r0 = r7.readUnsignedShort(r0)
            r3 = r0
            goto L_0x0851
        L_0x084e:
            r1 = 67
        L_0x0850:
            r3 = -1
        L_0x0851:
            r0 = r17
            r1 = r20
            r10 = r26
            goto L_0x0804
        L_0x0858:
            r17 = r0
            r20 = r1
            r26 = r10
            r1 = 67
            r10 = 0
            r29 = r3
            r37 = r5
            r3 = r11
            r36 = r12
            r28 = r20
            r40 = r21
            r21 = r26
            r11 = r30
            r9 = r32
            r12 = r33
            r26 = r38
            r10 = r39
            r15 = 67
            r5 = r46
            r20 = r2
            goto L_0x03e8
        L_0x0880:
            r15 = r44
            r32 = r9
            r30 = r11
            r33 = r12
            r12 = r36
            r5 = r37
            r10 = 0
            r0 = r6[r32]
            if (r0 == 0) goto L_0x0896
            r0 = r6[r32]
            r15.visitLabel(r0)
        L_0x0896:
            int r0 = r14.flags
            r0 = r0 & 2
            if (r0 != 0) goto L_0x0934
            r0 = r24
            if (r0 == 0) goto L_0x0934
            r1 = r25
            if (r1 == 0) goto L_0x08ce
            int r25 = r1 + 2
            int r1 = r7.readUnsignedShort(r1)
            int r1 = r1 * 3
            int[] r3 = new int[r1]
            r2 = r25
        L_0x08b0:
            if (r1 <= 0) goto L_0x08cc
            int r1 = r1 + -1
            int r4 = r2 + 6
            r3[r1] = r4
            r4 = -1
            int r1 = r1 + r4
            int r8 = r2 + 8
            int r8 = r7.readUnsignedShort(r8)
            r3[r1] = r8
            int r1 = r1 + r4
            int r8 = r7.readUnsignedShort(r2)
            r3[r1] = r8
            int r2 = r2 + 10
            goto L_0x08b0
        L_0x08cc:
            r8 = r3
            goto L_0x08cf
        L_0x08ce:
            r8 = 0
        L_0x08cf:
            int r24 = r0 + 2
            int r0 = r7.readUnsignedShort(r0)
            r9 = r0
            r11 = r24
        L_0x08d8:
            if (r9 <= 0) goto L_0x0934
            int r0 = r7.readUnsignedShort(r11)
            int r1 = r11 + 2
            int r1 = r7.readUnsignedShort(r1)
            int r2 = r11 + 8
            int r4 = r7.readUnsignedShort(r2)
            if (r8 == 0) goto L_0x0907
            r2 = 0
        L_0x08ed:
            int r3 = r8.length
            if (r2 >= r3) goto L_0x0907
            r3 = r8[r2]
            if (r3 != r0) goto L_0x0904
            int r3 = r2 + 1
            r3 = r8[r3]
            if (r3 != r4) goto L_0x0904
            int r2 = r2 + 2
            r2 = r8[r2]
            java.lang.String r2 = r7.readUTF8(r2, r13)
            r3 = r2
            goto L_0x0908
        L_0x0904:
            int r2 = r2 + 3
            goto L_0x08ed
        L_0x0907:
            r3 = 0
        L_0x0908:
            int r2 = r11 + 4
            java.lang.String r2 = r7.readUTF8(r2, r13)
            int r10 = r11 + 6
            java.lang.String r10 = r7.readUTF8(r10, r13)
            r16 = r6[r0]
            int r0 = r0 + r1
            r17 = r6[r0]
            r0 = r44
            r1 = r2
            r2 = r10
            r10 = r4
            r4 = r16
            r41 = r5
            r5 = r17
            r16 = r6
            r6 = r10
            r0.visitLocalVariable(r1, r2, r3, r4, r5, r6)
            int r11 = r11 + 10
            int r9 = r9 + -1
            r6 = r16
            r5 = r41
            r10 = 0
            goto L_0x08d8
        L_0x0934:
            r41 = r5
            r0 = 32
            if (r12 == 0) goto L_0x0995
            r2 = 0
        L_0x093b:
            int r1 = r12.length
            if (r2 >= r1) goto L_0x0995
            r1 = r12[r2]
            int r1 = r7.readByte(r1)
            r3 = 1
            int r1 = r1 >> r3
            if (r1 != r0) goto L_0x097b
            r1 = r12[r2]
            int r1 = r7.readAnnotationTarget(r14, r1)
            int r4 = r1 + 2
            int r9 = r14.typeRef
            org.jacoco.agent.rt.internal_8ff85ea.asm.TypePath r10 = r14.typePath
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label[] r11 = r14.start
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label[] r5 = r14.end
            int[] r6 = r14.index
            java.lang.String r1 = r7.readUTF8(r1, r13)
            r16 = 1
            r8 = r44
            r17 = 0
            r3 = r30
            r18 = r12
            r42 = r33
            r0 = 1
            r12 = r5
            r5 = r13
            r13 = r6
            r6 = r14
            r14 = r1
            r1 = r15
            r15 = r16
            org.jacoco.agent.rt.internal_8ff85ea.asm.AnnotationVisitor r8 = r8.visitLocalVariableAnnotation(r9, r10, r11, r12, r13, r14, r15)
            r7.readAnnotationValues(r4, r5, r0, r8)
            goto L_0x0987
        L_0x097b:
            r18 = r12
            r5 = r13
            r6 = r14
            r1 = r15
            r3 = r30
            r42 = r33
            r0 = 1
            r17 = 0
        L_0x0987:
            int r2 = r2 + 1
            r15 = r1
            r30 = r3
            r13 = r5
            r14 = r6
            r12 = r18
            r33 = r42
            r0 = 32
            goto L_0x093b
        L_0x0995:
            r5 = r13
            r6 = r14
            r1 = r15
            r3 = r30
            r42 = r33
            r0 = 1
            r17 = 0
            r2 = r41
            if (r2 == 0) goto L_0x09e3
            r4 = 0
        L_0x09a4:
            int r8 = r2.length
            if (r4 >= r8) goto L_0x09e3
            r8 = r2[r4]
            int r8 = r7.readByte(r8)
            int r8 = r8 >> r0
            r15 = 32
            if (r8 != r15) goto L_0x09dc
            r8 = r2[r4]
            int r8 = r7.readAnnotationTarget(r6, r8)
            int r14 = r8 + 2
            int r9 = r6.typeRef
            org.jacoco.agent.rt.internal_8ff85ea.asm.TypePath r10 = r6.typePath
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label[] r11 = r6.start
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label[] r12 = r6.end
            int[] r13 = r6.index
            java.lang.String r16 = r7.readUTF8(r8, r5)
            r17 = 0
            r8 = r44
            r0 = r14
            r14 = r16
            r16 = 32
            r15 = r17
            org.jacoco.agent.rt.internal_8ff85ea.asm.AnnotationVisitor r8 = r8.visitLocalVariableAnnotation(r9, r10, r11, r12, r13, r14, r15)
            r9 = 1
            r7.readAnnotationValues(r0, r5, r9, r8)
            goto L_0x09df
        L_0x09dc:
            r9 = 1
            r16 = 32
        L_0x09df:
            int r4 = r4 + 1
            r0 = 1
            goto L_0x09a4
        L_0x09e3:
            r0 = r23
        L_0x09e5:
            if (r0 == 0) goto L_0x09f1
            org.jacoco.agent.rt.internal_8ff85ea.asm.Attribute r2 = r0.next
            r4 = 0
            r0.next = r4
            r1.visitAttribute(r0)
            r0 = r2
            goto L_0x09e5
        L_0x09f1:
            r0 = r42
            r1.visitMaxs(r0, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jacoco.agent.p086rt.internal_8ff85ea.asm.ClassReader.readCode(org.jacoco.agent.rt.internal_8ff85ea.asm.MethodVisitor, org.jacoco.agent.rt.internal_8ff85ea.asm.Context, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x007d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int[] readTypeAnnotations(org.jacoco.agent.p086rt.internal_8ff85ea.asm.MethodVisitor r12, org.jacoco.agent.p086rt.internal_8ff85ea.asm.Context r13, int r14, boolean r15) {
        /*
            r11 = this;
            char[] r0 = r13.buffer
            int r1 = r11.readUnsignedShort(r14)
            int[] r2 = new int[r1]
            int r14 = r14 + 2
            r3 = 0
        L_0x000b:
            if (r3 >= r1) goto L_0x0089
            r2[r3] = r14
            int r4 = r11.readInt(r14)
            int r5 = r4 >>> 24
            r6 = 1
            if (r5 == 0) goto L_0x0055
            if (r5 == r6) goto L_0x0055
            r7 = 64
            if (r5 == r7) goto L_0x0031
            r7 = 65
            if (r5 == r7) goto L_0x0031
            switch(r5) {
                case 19: goto L_0x002e;
                case 20: goto L_0x002e;
                case 21: goto L_0x002e;
                case 22: goto L_0x0055;
                default: goto L_0x0025;
            }
        L_0x0025:
            switch(r5) {
                case 71: goto L_0x002b;
                case 72: goto L_0x002b;
                case 73: goto L_0x002b;
                case 74: goto L_0x002b;
                case 75: goto L_0x002b;
                default: goto L_0x0028;
            }
        L_0x0028:
            int r14 = r14 + 3
            goto L_0x0057
        L_0x002b:
            int r14 = r14 + 4
            goto L_0x0057
        L_0x002e:
            int r14 = r14 + 1
            goto L_0x0057
        L_0x0031:
            int r7 = r14 + 1
            int r7 = r11.readUnsignedShort(r7)
        L_0x0037:
            if (r7 <= 0) goto L_0x0028
            int r8 = r14 + 3
            int r8 = r11.readUnsignedShort(r8)
            int r9 = r14 + 5
            int r9 = r11.readUnsignedShort(r9)
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label[] r10 = r13.labels
            r11.readLabel(r8, r10)
            int r8 = r8 + r9
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label[] r9 = r13.labels
            r11.readLabel(r8, r9)
            int r14 = r14 + 6
            int r7 = r7 + -1
            goto L_0x0037
        L_0x0055:
            int r14 = r14 + 2
        L_0x0057:
            int r7 = r11.readByte(r14)
            r8 = 66
            r9 = 0
            if (r5 != r8) goto L_0x007d
            if (r7 != 0) goto L_0x0063
            goto L_0x006a
        L_0x0063:
            org.jacoco.agent.rt.internal_8ff85ea.asm.TypePath r9 = new org.jacoco.agent.rt.internal_8ff85ea.asm.TypePath
            byte[] r5 = r11.f6580b
            r9.<init>(r5, r14)
        L_0x006a:
            int r7 = r7 * 2
            int r7 = r7 + r6
            int r14 = r14 + r7
            int r5 = r14 + 2
            java.lang.String r14 = r11.readUTF8(r14, r0)
            org.jacoco.agent.rt.internal_8ff85ea.asm.AnnotationVisitor r14 = r12.visitTryCatchAnnotation(r4, r9, r14, r15)
            int r14 = r11.readAnnotationValues(r5, r0, r6, r14)
            goto L_0x0086
        L_0x007d:
            int r14 = r14 + 3
            int r7 = r7 * 2
            int r14 = r14 + r7
            int r14 = r11.readAnnotationValues(r14, r0, r6, r9)
        L_0x0086:
            int r3 = r3 + 1
            goto L_0x000b
        L_0x0089:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jacoco.agent.p086rt.internal_8ff85ea.asm.ClassReader.readTypeAnnotations(org.jacoco.agent.rt.internal_8ff85ea.asm.MethodVisitor, org.jacoco.agent.rt.internal_8ff85ea.asm.Context, int, boolean):int[]");
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0084  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int readAnnotationTarget(org.jacoco.agent.p086rt.internal_8ff85ea.asm.Context r9, int r10) {
        /*
            r8 = this;
            int r0 = r8.readInt(r10)
            int r1 = r0 >>> 24
            r2 = 1
            if (r1 == 0) goto L_0x0075
            if (r1 == r2) goto L_0x0075
            r3 = 64
            r4 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            if (r1 == r3) goto L_0x002f
            r3 = 65
            if (r1 == r3) goto L_0x002f
            switch(r1) {
                case 19: goto L_0x002c;
                case 20: goto L_0x002c;
                case 21: goto L_0x002c;
                case 22: goto L_0x0075;
                default: goto L_0x0018;
            }
        L_0x0018:
            switch(r1) {
                case 71: goto L_0x0025;
                case 72: goto L_0x0025;
                case 73: goto L_0x0025;
                case 74: goto L_0x0025;
                case 75: goto L_0x0025;
                default: goto L_0x001b;
            }
        L_0x001b:
            r3 = 67
            if (r1 >= r3) goto L_0x0021
            r4 = -256(0xffffffffffffff00, float:NaN)
        L_0x0021:
            r0 = r0 & r4
            int r10 = r10 + 3
            goto L_0x007a
        L_0x0025:
            r1 = -16776961(0xffffffffff0000ff, float:-1.7014636E38)
            r0 = r0 & r1
            int r10 = r10 + 4
            goto L_0x007a
        L_0x002c:
            r0 = r0 & r4
            int r10 = r10 + r2
            goto L_0x007a
        L_0x002f:
            r0 = r0 & r4
            int r1 = r10 + 1
            int r1 = r8.readUnsignedShort(r1)
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label[] r3 = new org.jacoco.agent.p086rt.internal_8ff85ea.asm.Label[r1]
            r9.start = r3
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label[] r3 = new org.jacoco.agent.p086rt.internal_8ff85ea.asm.Label[r1]
            r9.end = r3
            int[] r3 = new int[r1]
            r9.index = r3
            int r10 = r10 + 3
            r3 = 0
        L_0x0045:
            if (r3 >= r1) goto L_0x007a
            int r4 = r8.readUnsignedShort(r10)
            int r5 = r10 + 2
            int r5 = r8.readUnsignedShort(r5)
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label[] r6 = r9.start
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label[] r7 = r9.labels
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label r7 = r8.readLabel(r4, r7)
            r6[r3] = r7
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label[] r6 = r9.end
            int r4 = r4 + r5
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label[] r5 = r9.labels
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label r4 = r8.readLabel(r4, r5)
            r6[r3] = r4
            int[] r4 = r9.index
            int r5 = r10 + 4
            int r5 = r8.readUnsignedShort(r5)
            r4[r3] = r5
            int r10 = r10 + 6
            int r3 = r3 + 1
            goto L_0x0045
        L_0x0075:
            r1 = -65536(0xffffffffffff0000, float:NaN)
            r0 = r0 & r1
            int r10 = r10 + 2
        L_0x007a:
            int r1 = r8.readByte(r10)
            r9.typeRef = r0
            if (r1 != 0) goto L_0x0084
            r0 = 0
            goto L_0x008b
        L_0x0084:
            org.jacoco.agent.rt.internal_8ff85ea.asm.TypePath r0 = new org.jacoco.agent.rt.internal_8ff85ea.asm.TypePath
            byte[] r3 = r8.f6580b
            r0.<init>(r3, r10)
        L_0x008b:
            r9.typePath = r0
            int r10 = r10 + r2
            int r1 = r1 * 2
            int r10 = r10 + r1
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jacoco.agent.p086rt.internal_8ff85ea.asm.ClassReader.readAnnotationTarget(org.jacoco.agent.rt.internal_8ff85ea.asm.Context, int):int");
    }

    private void readParameterAnnotations(MethodVisitor methodVisitor, Context context, int i, boolean z) {
        int i2 = i + 1;
        byte b = this.f6580b[i] & 255;
        int length = Type.getArgumentTypes(context.desc).length - b;
        int i3 = 0;
        while (i3 < length) {
            AnnotationVisitor visitParameterAnnotation = methodVisitor.visitParameterAnnotation(i3, "Ljava/lang/Synthetic;", false);
            if (visitParameterAnnotation != null) {
                visitParameterAnnotation.visitEnd();
            }
            i3++;
        }
        char[] cArr = context.buffer;
        while (i3 < b + length) {
            i2 += 2;
            for (int readUnsignedShort = readUnsignedShort(i2); readUnsignedShort > 0; readUnsignedShort--) {
                i2 = readAnnotationValues(i2 + 2, cArr, true, methodVisitor.visitParameterAnnotation(i3, readUTF8(i2, cArr), z));
            }
            i3++;
        }
    }

    private int readAnnotationValues(int i, char[] cArr, boolean z, AnnotationVisitor annotationVisitor) {
        int readUnsignedShort = readUnsignedShort(i);
        int i2 = i + 2;
        if (z) {
            while (readUnsignedShort > 0) {
                i2 = readAnnotationValue(i2 + 2, cArr, readUTF8(i2, cArr), annotationVisitor);
                readUnsignedShort--;
            }
        } else {
            while (readUnsignedShort > 0) {
                i2 = readAnnotationValue(i2, cArr, (String) null, annotationVisitor);
                readUnsignedShort--;
            }
        }
        if (annotationVisitor != null) {
            annotationVisitor.visitEnd();
        }
        return i2;
    }

    private int readAnnotationValue(int i, char[] cArr, String str, AnnotationVisitor annotationVisitor) {
        int i2 = 0;
        if (annotationVisitor == null) {
            byte b = this.f6580b[i] & 255;
            if (b == 64) {
                return readAnnotationValues(i + 3, cArr, true, (AnnotationVisitor) null);
            }
            if (b != 91) {
                return b != 101 ? i + 3 : i + 5;
            }
            return readAnnotationValues(i + 1, cArr, false, (AnnotationVisitor) null);
        }
        int i3 = i + 1;
        byte b2 = this.f6580b[i] & 255;
        if (b2 == 64) {
            return readAnnotationValues(i3 + 2, cArr, true, annotationVisitor.visitAnnotation(str, readUTF8(i3, cArr)));
        }
        if (b2 != 70) {
            if (b2 == 83) {
                annotationVisitor.visit(str, Short.valueOf((short) readInt(this.items[readUnsignedShort(i3)])));
            } else if (b2 == 99) {
                annotationVisitor.visit(str, Type.getType(readUTF8(i3, cArr)));
            } else if (b2 == 101) {
                annotationVisitor.visitEnum(str, readUTF8(i3, cArr), readUTF8(i3 + 2, cArr));
                return i3 + 4;
            } else if (b2 == 115) {
                annotationVisitor.visit(str, readUTF8(i3, cArr));
            } else if (!(b2 == 73 || b2 == 74)) {
                if (b2 == 90) {
                    annotationVisitor.visit(str, readInt(this.items[readUnsignedShort(i3)]) == 0 ? Boolean.FALSE : Boolean.TRUE);
                } else if (b2 != 91) {
                    switch (b2) {
                        case 66:
                            annotationVisitor.visit(str, Byte.valueOf((byte) readInt(this.items[readUnsignedShort(i3)])));
                            break;
                        case 67:
                            annotationVisitor.visit(str, Character.valueOf((char) readInt(this.items[readUnsignedShort(i3)])));
                            break;
                        case 68:
                            break;
                        default:
                            return i3;
                    }
                } else {
                    int readUnsignedShort = readUnsignedShort(i3);
                    int i4 = i3 + 2;
                    if (readUnsignedShort == 0) {
                        return readAnnotationValues(i4 - 2, cArr, false, annotationVisitor.visitArray(str));
                    }
                    int i5 = i4 + 1;
                    byte b3 = this.f6580b[i4] & 255;
                    if (b3 == 70) {
                        float[] fArr = new float[readUnsignedShort];
                        while (i2 < readUnsignedShort) {
                            fArr[i2] = Float.intBitsToFloat(readInt(this.items[readUnsignedShort(i5)]));
                            i5 += 3;
                            i2++;
                        }
                        annotationVisitor.visit(str, fArr);
                    } else if (b3 == 83) {
                        short[] sArr = new short[readUnsignedShort];
                        while (i2 < readUnsignedShort) {
                            sArr[i2] = (short) readInt(this.items[readUnsignedShort(i5)]);
                            i5 += 3;
                            i2++;
                        }
                        annotationVisitor.visit(str, sArr);
                    } else if (b3 == 90) {
                        boolean[] zArr = new boolean[readUnsignedShort];
                        for (int i6 = 0; i6 < readUnsignedShort; i6++) {
                            zArr[i6] = readInt(this.items[readUnsignedShort(i5)]) != 0;
                            i5 += 3;
                        }
                        annotationVisitor.visit(str, zArr);
                    } else if (b3 == 73) {
                        int[] iArr = new int[readUnsignedShort];
                        while (i2 < readUnsignedShort) {
                            iArr[i2] = readInt(this.items[readUnsignedShort(i5)]);
                            i5 += 3;
                            i2++;
                        }
                        annotationVisitor.visit(str, iArr);
                    } else if (b3 != 74) {
                        switch (b3) {
                            case 66:
                                byte[] bArr = new byte[readUnsignedShort];
                                while (i2 < readUnsignedShort) {
                                    bArr[i2] = (byte) readInt(this.items[readUnsignedShort(i5)]);
                                    i5 += 3;
                                    i2++;
                                }
                                annotationVisitor.visit(str, bArr);
                                break;
                            case 67:
                                char[] cArr2 = new char[readUnsignedShort];
                                while (i2 < readUnsignedShort) {
                                    cArr2[i2] = (char) readInt(this.items[readUnsignedShort(i5)]);
                                    i5 += 3;
                                    i2++;
                                }
                                annotationVisitor.visit(str, cArr2);
                                break;
                            case 68:
                                double[] dArr = new double[readUnsignedShort];
                                while (i2 < readUnsignedShort) {
                                    dArr[i2] = Double.longBitsToDouble(readLong(this.items[readUnsignedShort(i5)]));
                                    i5 += 3;
                                    i2++;
                                }
                                annotationVisitor.visit(str, dArr);
                                break;
                            default:
                                return readAnnotationValues(i5 - 3, cArr, false, annotationVisitor.visitArray(str));
                        }
                    } else {
                        long[] jArr = new long[readUnsignedShort];
                        while (i2 < readUnsignedShort) {
                            jArr[i2] = readLong(this.items[readUnsignedShort(i5)]);
                            i5 += 3;
                            i2++;
                        }
                        annotationVisitor.visit(str, jArr);
                    }
                    return i5 - 1;
                }
            }
            return i3 + 2;
        }
        annotationVisitor.visit(str, readConst(readUnsignedShort(i3), cArr));
        return i3 + 2;
    }

    private void getImplicitFrame(Context context) {
        int i;
        int i2;
        String str = context.desc;
        Object[] objArr = context.local;
        int i3 = 0;
        if ((context.access & 8) == 0) {
            if ("<init>".equals(context.name)) {
                objArr[0] = Opcodes.UNINITIALIZED_THIS;
            } else {
                objArr[0] = readClass(this.header + 2, context.buffer);
            }
            i3 = 1;
        }
        int i4 = 1;
        while (true) {
            int i5 = i4 + 1;
            char charAt = str.charAt(i4);
            if (charAt == 'F') {
                i2 = i + 1;
                objArr[i] = Opcodes.FLOAT;
            } else if (charAt != 'L') {
                if (!(charAt == 'S' || charAt == 'I')) {
                    if (charAt == 'J') {
                        i2 = i + 1;
                        objArr[i] = Opcodes.LONG;
                    } else if (charAt != 'Z') {
                        if (charAt != '[') {
                            switch (charAt) {
                                case 'B':
                                case 'C':
                                    break;
                                case 'D':
                                    i2 = i + 1;
                                    objArr[i] = Opcodes.DOUBLE;
                                    break;
                                default:
                                    context.localCount = i;
                                    return;
                            }
                        } else {
                            while (str.charAt(i5) == '[') {
                                i5++;
                            }
                            if (str.charAt(i5) == 'L') {
                                do {
                                    i5++;
                                } while (str.charAt(i5) != ';');
                            }
                            int i6 = i5 + 1;
                            objArr[i] = str.substring(i4, i6);
                            i4 = i6;
                            i++;
                        }
                    }
                }
                i2 = i + 1;
                objArr[i] = Opcodes.INTEGER;
            } else {
                int i7 = i5;
                while (str.charAt(i7) != ';') {
                    i7++;
                }
                objArr[i] = str.substring(i5, i7);
                i++;
                i4 = i7 + 1;
            }
            i = i2;
            i4 = i5;
        }
    }

    private int readFrame(int i, boolean z, boolean z2, Context context) {
        int i2;
        int i3;
        char[] cArr = context.buffer;
        Label[] labelArr = context.labels;
        if (z) {
            int i4 = i + 1;
            i2 = this.f6580b[i] & 255;
            i3 = i4;
        } else {
            context.offset = -1;
            i3 = i;
            i2 = 255;
        }
        context.localDiff = 0;
        if (i2 < 64) {
            context.mode = 3;
            context.stackCount = 0;
        } else if (i2 < 128) {
            i2 -= 64;
            i3 = readFrameType(context.stack, 0, i3, cArr, labelArr);
            context.mode = 4;
            context.stackCount = 1;
        } else {
            int readUnsignedShort = readUnsignedShort(i3);
            int i5 = i3 + 2;
            if (i2 == 247) {
                i5 = readFrameType(context.stack, 0, i5, cArr, labelArr);
                context.mode = 4;
                context.stackCount = 1;
            } else if (i2 >= 248 && i2 < 251) {
                context.mode = 2;
                context.localDiff = 251 - i2;
                context.localCount -= context.localDiff;
                context.stackCount = 0;
            } else if (i2 == 251) {
                context.mode = 3;
                context.stackCount = 0;
            } else if (i2 < 255) {
                int i6 = i2 - 251;
                int i7 = z2 ? context.localCount : 0;
                int i8 = i6;
                while (i8 > 0) {
                    i5 = readFrameType(context.local, i7, i5, cArr, labelArr);
                    i8--;
                    i7++;
                }
                context.mode = 1;
                context.localDiff = i6;
                context.localCount += context.localDiff;
                context.stackCount = 0;
            } else {
                context.mode = 0;
                int readUnsignedShort2 = readUnsignedShort(i5);
                int i9 = i5 + 2;
                context.localDiff = readUnsignedShort2;
                context.localCount = readUnsignedShort2;
                int i10 = 0;
                while (readUnsignedShort2 > 0) {
                    i9 = readFrameType(context.local, i10, i9, cArr, labelArr);
                    readUnsignedShort2--;
                    i10++;
                }
                int readUnsignedShort3 = readUnsignedShort(i9);
                i5 = i9 + 2;
                context.stackCount = readUnsignedShort3;
                int i11 = 0;
                while (readUnsignedShort3 > 0) {
                    i5 = readFrameType(context.stack, i11, i5, cArr, labelArr);
                    readUnsignedShort3--;
                    i11++;
                }
            }
            i2 = readUnsignedShort;
        }
        context.offset += i2 + 1;
        readLabel(context.offset, labelArr);
        return i3;
    }

    private int readFrameType(Object[] objArr, int i, int i2, char[] cArr, Label[] labelArr) {
        int i3 = i2 + 1;
        switch (this.f6580b[i2] & 255) {
            case 0:
                objArr[i] = Opcodes.TOP;
                return i3;
            case 1:
                objArr[i] = Opcodes.INTEGER;
                return i3;
            case 2:
                objArr[i] = Opcodes.FLOAT;
                return i3;
            case 3:
                objArr[i] = Opcodes.DOUBLE;
                return i3;
            case 4:
                objArr[i] = Opcodes.LONG;
                return i3;
            case 5:
                objArr[i] = Opcodes.NULL;
                return i3;
            case 6:
                objArr[i] = Opcodes.UNINITIALIZED_THIS;
                return i3;
            case 7:
                objArr[i] = readClass(i3, cArr);
                break;
            default:
                objArr[i] = readLabel(readUnsignedShort(i3), labelArr);
                break;
        }
        return i3 + 2;
    }

    /* access modifiers changed from: protected */
    public Label readLabel(int i, Label[] labelArr) {
        if (labelArr[i] == null) {
            labelArr[i] = new Label();
        }
        return labelArr[i];
    }

    private int getAttributes() {
        int i = this.header;
        int readUnsignedShort = i + 8 + (readUnsignedShort(i + 6) * 2);
        for (int readUnsignedShort2 = readUnsignedShort(readUnsignedShort); readUnsignedShort2 > 0; readUnsignedShort2--) {
            for (int readUnsignedShort3 = readUnsignedShort(readUnsignedShort + 8); readUnsignedShort3 > 0; readUnsignedShort3--) {
                readUnsignedShort += readInt(readUnsignedShort + 12) + 6;
            }
            readUnsignedShort += 8;
        }
        int i2 = readUnsignedShort + 2;
        for (int readUnsignedShort4 = readUnsignedShort(i2); readUnsignedShort4 > 0; readUnsignedShort4--) {
            for (int readUnsignedShort5 = readUnsignedShort(i2 + 8); readUnsignedShort5 > 0; readUnsignedShort5--) {
                i2 += readInt(i2 + 12) + 6;
            }
            i2 += 8;
        }
        return i2 + 2;
    }

    private Attribute readAttribute(Attribute[] attributeArr, String str, int i, int i2, char[] cArr, int i3, Label[] labelArr) {
        Attribute[] attributeArr2 = attributeArr;
        String str2 = str;
        for (int i4 = 0; i4 < attributeArr2.length; i4++) {
            if (attributeArr2[i4].type.equals(str)) {
                return attributeArr2[i4].read(this, i, i2, cArr, i3, labelArr);
            }
        }
        return new Attribute(str).read(this, i, i2, (char[]) null, -1, (Label[]) null);
    }

    public int getItemCount() {
        return this.items.length;
    }

    public int getItem(int i) {
        return this.items[i];
    }

    public int getMaxStringLength() {
        return this.maxStringLength;
    }

    public int readByte(int i) {
        return this.f6580b[i] & 255;
    }

    public int readUnsignedShort(int i) {
        byte[] bArr = this.f6580b;
        return (bArr[i + 1] & 255) | ((bArr[i] & 255) << 8);
    }

    public short readShort(int i) {
        byte[] bArr = this.f6580b;
        return (short) ((bArr[i + 1] & 255) | ((bArr[i] & 255) << 8));
    }

    public int readInt(int i) {
        byte[] bArr = this.f6580b;
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << Ascii.CAN) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }

    public long readLong(int i) {
        return (((long) readInt(i)) << 32) | (((long) readInt(i + 4)) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
    }

    public String readUTF8(int i, char[] cArr) {
        int readUnsignedShort = readUnsignedShort(i);
        if (i == 0 || readUnsignedShort == 0) {
            return null;
        }
        String[] strArr = this.strings;
        String str = strArr[readUnsignedShort];
        if (str != null) {
            return str;
        }
        int i2 = this.items[readUnsignedShort];
        String readUTF = readUTF(i2 + 2, readUnsignedShort(i2), cArr);
        strArr[readUnsignedShort] = readUTF;
        return readUTF;
    }

    private String readUTF(int i, int i2, char[] cArr) {
        byte b;
        int i3 = i2 + i;
        byte[] bArr = this.f6580b;
        int i4 = 0;
        char c = 0;
        char c2 = 0;
        while (i < i3) {
            int i5 = i + 1;
            byte b2 = bArr[i];
            if (c != 0) {
                if (c == 1) {
                    cArr[i4] = (char) ((b2 & Utf8.REPLACEMENT_BYTE) | (c2 << 6));
                    i4++;
                    c = 0;
                } else if (c == 2) {
                    b = (b2 & Utf8.REPLACEMENT_BYTE) | (c2 << 6);
                }
                i = i5;
            } else {
                byte b3 = b2 & 255;
                if (b3 < 128) {
                    cArr[i4] = (char) b3;
                    i4++;
                } else if (b3 >= 224 || b3 <= 191) {
                    c2 = (char) (b3 & Ascii.f53593SI);
                    c = 2;
                } else {
                    b = b3 & Ascii.f53596US;
                }
                i = i5;
            }
            c2 = (char) b;
            c = 1;
            i = i5;
        }
        return new String(cArr, 0, i4);
    }

    public String readClass(int i, char[] cArr) {
        return readUTF8(this.items[readUnsignedShort(i)], cArr);
    }

    public Object readConst(int i, char[] cArr) {
        int i2 = this.items[i];
        byte b = this.f6580b[i2 - 1];
        if (b == 16) {
            return Type.getMethodType(readUTF8(i2, cArr));
        }
        switch (b) {
            case 3:
                return Integer.valueOf(readInt(i2));
            case 4:
                return Float.valueOf(Float.intBitsToFloat(readInt(i2)));
            case 5:
                return Long.valueOf(readLong(i2));
            case 6:
                return Double.valueOf(Double.longBitsToDouble(readLong(i2)));
            case 7:
                return Type.getObjectType(readUTF8(i2, cArr));
            case 8:
                return readUTF8(i2, cArr);
            default:
                int readByte = readByte(i2);
                int[] iArr = this.items;
                int i3 = iArr[readUnsignedShort(i2 + 1)];
                boolean z = this.f6580b[i3 + -1] == 11;
                String readClass = readClass(i3, cArr);
                int i4 = iArr[readUnsignedShort(i3 + 2)];
                return new Handle(readByte, readClass, readUTF8(i4, cArr), readUTF8(i4 + 2, cArr), z);
        }
    }
}
