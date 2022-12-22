package org.jacoco.agent.p086rt.internal_8ff85ea.asm;

import org.apache.commons.p071io.IOUtils;
import org.jacoco.agent.p086rt.internal_8ff85ea.core.internal.ContentTypeDetector;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.asm.ClassWriter */
public class ClassWriter extends ClassVisitor {
    static final int ACC_SYNTHETIC_ATTRIBUTE = 262144;
    static final int ASM_LABEL_INSN = 18;
    static final int BSM = 33;
    static final int CLASS = 7;
    public static final int COMPUTE_FRAMES = 2;
    public static final int COMPUTE_MAXS = 1;
    static final int DOUBLE = 6;
    static final int FIELD = 9;
    static final int FIELDORMETH_INSN = 6;
    static final int FLOAT = 4;
    static final int F_INSERT = 256;
    static final int HANDLE = 15;
    static final int HANDLE_BASE = 20;
    static final int IINC_INSN = 13;
    static final int IMETH = 11;
    static final int IMPLVAR_INSN = 4;
    static final int INDY = 18;
    static final int INDYMETH_INSN = 8;
    static final int INT = 3;
    static final int ITFMETH_INSN = 7;
    static final int LABELW_INSN = 10;
    static final int LABEL_INSN = 9;
    static final int LDCW_INSN = 12;
    static final int LDC_INSN = 11;
    static final int LONG = 5;
    static final int LOOK_INSN = 15;
    static final int MANA_INSN = 16;
    static final int METH = 10;
    static final int MTYPE = 16;
    static final int NAME_TYPE = 12;
    static final int NOARG_INSN = 0;
    static final int SBYTE_INSN = 1;
    static final int SHORT_INSN = 2;
    static final int STR = 8;
    static final int TABL_INSN = 14;
    static final int TO_ACC_SYNTHETIC = 64;
    static final byte[] TYPE;
    static final int TYPE_INSN = 5;
    static final int TYPE_MERGED = 32;
    static final int TYPE_NORMAL = 30;
    static final int TYPE_UNINIT = 31;
    static final int UTF8 = 1;
    static final int VAR_INSN = 3;
    static final int WIDE_INSN = 17;
    private int access;
    private AnnotationWriter anns;
    private Attribute attrs;
    ByteVector bootstrapMethods;
    int bootstrapMethodsCount;
    private int compute;

    /* renamed from: cr */
    ClassReader f6582cr;
    private int enclosingMethod;
    private int enclosingMethodOwner;
    FieldWriter firstField;
    MethodWriter firstMethod;
    boolean hasAsmInsns;
    private AnnotationWriter ianns;
    int index;
    private ByteVector innerClasses;
    private int innerClassesCount;
    private int interfaceCount;
    private int[] interfaces;
    private AnnotationWriter itanns;
    Item[] items;
    final Item key;
    final Item key2;
    final Item key3;
    final Item key4;
    FieldWriter lastField;
    MethodWriter lastMethod;
    private int name;
    final ByteVector pool;
    private int signature;
    private ByteVector sourceDebug;
    private int sourceFile;
    private int superName;
    private AnnotationWriter tanns;
    String thisName;
    int threshold;
    private short typeCount;
    Item[] typeTable;
    int version;

    public final void visitEnd() {
    }

    static {
        byte[] bArr = new byte[220];
        for (int i = 0; i < 220; i++) {
            bArr[i] = (byte) ("AAAAAAAAAAAAAAAABCLMMDDDDDEEEEEEEEEEEEEEEEEEEEAAAAAAAADDDDDEEEEEEEEEEEEEEEEEEEEAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAANAAAAAAAAAAAAAAAAAAAAJJJJJJJJJJJJJJJJDOPAAAAAAGGGGGGGHIFBFAAFFAARQJJKKSSSSSSSSSSSSSSSSSS".charAt(i) - 'A');
        }
        TYPE = bArr;
    }

    public ClassWriter(int i) {
        super(327680);
        this.index = 1;
        this.pool = new ByteVector();
        Item[] itemArr = new Item[256];
        this.items = itemArr;
        this.threshold = (int) (((double) itemArr.length) * 0.75d);
        this.key = new Item();
        this.key2 = new Item();
        this.key3 = new Item();
        this.key4 = new Item();
        this.compute = (i & 2) != 0 ? 0 : (i & 1) != 0 ? 2 : 3;
    }

    public ClassWriter(ClassReader classReader, int i) {
        this(i);
        classReader.copyPool(this);
        this.f6582cr = classReader;
    }

    public final void visit(int i, int i2, String str, String str2, String str3, String[] strArr) {
        int i3;
        this.version = i;
        this.access = i2;
        this.name = newClass(str);
        this.thisName = str;
        if (str2 != null) {
            this.signature = newUTF8(str2);
        }
        if (str3 == null) {
            i3 = 0;
        } else {
            i3 = newClass(str3);
        }
        this.superName = i3;
        if (strArr != null && strArr.length > 0) {
            int length = strArr.length;
            this.interfaceCount = length;
            this.interfaces = new int[length];
            for (int i4 = 0; i4 < this.interfaceCount; i4++) {
                this.interfaces[i4] = newClass(strArr[i4]);
            }
        }
    }

    public final void visitSource(String str, String str2) {
        if (str != null) {
            this.sourceFile = newUTF8(str);
        }
        if (str2 != null) {
            this.sourceDebug = new ByteVector().encodeUTF8(str2, 0, Integer.MAX_VALUE);
        }
    }

    public final void visitOuterClass(String str, String str2, String str3) {
        this.enclosingMethodOwner = newClass(str);
        if (str2 != null && str3 != null) {
            this.enclosingMethod = newNameType(str2, str3);
        }
    }

    public final AnnotationVisitor visitAnnotation(String str, boolean z) {
        ByteVector byteVector = new ByteVector();
        byteVector.putShort(newUTF8(str)).putShort(0);
        AnnotationWriter annotationWriter = new AnnotationWriter(this, true, byteVector, byteVector, 2);
        if (z) {
            annotationWriter.next = this.anns;
            this.anns = annotationWriter;
        } else {
            annotationWriter.next = this.ianns;
            this.ianns = annotationWriter;
        }
        return annotationWriter;
    }

    public final AnnotationVisitor visitTypeAnnotation(int i, TypePath typePath, String str, boolean z) {
        ByteVector byteVector = new ByteVector();
        AnnotationWriter.putTarget(i, typePath, byteVector);
        byteVector.putShort(newUTF8(str)).putShort(0);
        AnnotationWriter annotationWriter = new AnnotationWriter(this, true, byteVector, byteVector, byteVector.length - 2);
        if (z) {
            annotationWriter.next = this.tanns;
            this.tanns = annotationWriter;
        } else {
            annotationWriter.next = this.itanns;
            this.itanns = annotationWriter;
        }
        return annotationWriter;
    }

    public final void visitAttribute(Attribute attribute) {
        attribute.next = this.attrs;
        this.attrs = attribute;
    }

    public final void visitInnerClass(String str, String str2, String str3, int i) {
        if (this.innerClasses == null) {
            this.innerClasses = new ByteVector();
        }
        Item newClassItem = newClassItem(str);
        if (newClassItem.intVal == 0) {
            this.innerClassesCount++;
            this.innerClasses.putShort(newClassItem.index);
            int i2 = 0;
            this.innerClasses.putShort(str2 == null ? 0 : newClass(str2));
            ByteVector byteVector = this.innerClasses;
            if (str3 != null) {
                i2 = newUTF8(str3);
            }
            byteVector.putShort(i2);
            this.innerClasses.putShort(i);
            newClassItem.intVal = this.innerClassesCount;
        }
    }

    public final FieldVisitor visitField(int i, String str, String str2, String str3, Object obj) {
        return new FieldWriter(this, i, str, str2, str3, obj);
    }

    public final MethodVisitor visitMethod(int i, String str, String str2, String str3, String[] strArr) {
        return new MethodWriter(this, i, str, str2, str3, strArr, this.compute);
    }

    public byte[] toByteArray() {
        int i;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        int i2;
        ByteVector byteVector;
        if (this.index <= 65535) {
            int i3 = (this.interfaceCount * 2) + 24;
            int i4 = 0;
            for (FieldWriter fieldWriter = this.firstField; fieldWriter != null; fieldWriter = (FieldWriter) fieldWriter.f6583fv) {
                i4++;
                i3 += fieldWriter.getSize();
            }
            int i5 = 0;
            for (MethodWriter methodWriter = this.firstMethod; methodWriter != null; methodWriter = (MethodWriter) methodWriter.f6585mv) {
                i5++;
                i3 += methodWriter.getSize();
            }
            ByteVector byteVector2 = this.bootstrapMethods;
            if (byteVector2 != null) {
                i3 += byteVector2.length + 8;
                newUTF8("BootstrapMethods");
                i = 1;
            } else {
                i = 0;
            }
            if (this.signature != 0) {
                i++;
                i3 += 8;
                newUTF8("Signature");
            }
            if (this.sourceFile != 0) {
                i++;
                i3 += 8;
                newUTF8("SourceFile");
            }
            ByteVector byteVector3 = this.sourceDebug;
            if (byteVector3 != null) {
                i++;
                i3 += byteVector3.length + 6;
                newUTF8("SourceDebugExtension");
            }
            if (this.enclosingMethodOwner != 0) {
                i++;
                i3 += 10;
                newUTF8("EnclosingMethod");
            }
            if ((this.access & 131072) != 0) {
                i++;
                i3 += 6;
                newUTF8("Deprecated");
            }
            int i6 = this.access;
            if ((i6 & 4096) != 0 && ((this.version & 65535) < 49 || (i6 & 262144) != 0)) {
                i++;
                i3 += 6;
                newUTF8("Synthetic");
            }
            ByteVector byteVector4 = this.innerClasses;
            if (byteVector4 != null) {
                i++;
                i3 += byteVector4.length + 8;
                newUTF8("InnerClasses");
            }
            AnnotationWriter annotationWriter = this.anns;
            if (annotationWriter != null) {
                i++;
                i3 += annotationWriter.getSize() + 8;
                newUTF8("RuntimeVisibleAnnotations");
            }
            AnnotationWriter annotationWriter2 = this.ianns;
            if (annotationWriter2 != null) {
                i++;
                i3 += annotationWriter2.getSize() + 8;
                newUTF8("RuntimeInvisibleAnnotations");
            }
            AnnotationWriter annotationWriter3 = this.tanns;
            String str6 = "SourceDebugExtension";
            if (annotationWriter3 != null) {
                i++;
                i3 += annotationWriter3.getSize() + 8;
                newUTF8("RuntimeVisibleTypeAnnotations");
            }
            AnnotationWriter annotationWriter4 = this.itanns;
            if (annotationWriter4 != null) {
                i++;
                i3 += annotationWriter4.getSize() + 8;
                newUTF8("RuntimeInvisibleTypeAnnotations");
            }
            int i7 = i3;
            Attribute attribute = this.attrs;
            if (attribute != null) {
                int count = i + attribute.getCount();
                str3 = "Deprecated";
                str2 = "EnclosingMethod";
                str = "RuntimeVisibleTypeAnnotations";
                String str7 = str6;
                str4 = "RuntimeInvisibleAnnotations";
                str5 = str7;
                i7 += this.attrs.getSize(this, (byte[]) null, 0, -1, -1);
                i = count;
            } else {
                str3 = "Deprecated";
                str2 = "EnclosingMethod";
                str = "RuntimeVisibleTypeAnnotations";
                String str8 = str6;
                str4 = "RuntimeInvisibleAnnotations";
                str5 = str8;
            }
            ByteVector byteVector5 = new ByteVector(i7 + this.pool.length);
            byteVector5.putInt(ContentTypeDetector.CLASSFILE).putInt(this.version);
            byteVector5.putShort(this.index).putByteArray(this.pool.data, 0, this.pool.length);
            int i8 = this.access;
            byteVector5.putShort((~(393216 | ((i8 & 262144) / 64))) & i8).putShort(this.name).putShort(this.superName);
            byteVector5.putShort(this.interfaceCount);
            for (int i9 = 0; i9 < this.interfaceCount; i9++) {
                byteVector5.putShort(this.interfaces[i9]);
            }
            byteVector5.putShort(i4);
            for (FieldWriter fieldWriter2 = this.firstField; fieldWriter2 != null; fieldWriter2 = (FieldWriter) fieldWriter2.f6583fv) {
                fieldWriter2.put(byteVector5);
            }
            byteVector5.putShort(i5);
            for (MethodWriter methodWriter2 = this.firstMethod; methodWriter2 != null; methodWriter2 = (MethodWriter) methodWriter2.f6585mv) {
                methodWriter2.put(byteVector5);
            }
            byteVector5.putShort(i);
            if (this.bootstrapMethods != null) {
                byteVector5.putShort(newUTF8("BootstrapMethods"));
                byteVector5.putInt(this.bootstrapMethods.length + 2).putShort(this.bootstrapMethodsCount);
                byteVector5.putByteArray(this.bootstrapMethods.data, 0, this.bootstrapMethods.length);
            }
            if (this.signature != 0) {
                i2 = 2;
                byteVector5.putShort(newUTF8("Signature")).putInt(2).putShort(this.signature);
            } else {
                i2 = 2;
            }
            if (this.sourceFile != 0) {
                byteVector5.putShort(newUTF8("SourceFile")).putInt(i2).putShort(this.sourceFile);
            }
            ByteVector byteVector6 = this.sourceDebug;
            if (byteVector6 != null) {
                int i10 = byteVector6.length;
                byteVector5.putShort(newUTF8(str5)).putInt(i10);
                byteVector5.putByteArray(this.sourceDebug.data, 0, i10);
            }
            if (this.enclosingMethodOwner != 0) {
                byteVector5.putShort(newUTF8(str2)).putInt(4);
                byteVector5.putShort(this.enclosingMethodOwner).putShort(this.enclosingMethod);
            }
            if ((this.access & 131072) != 0) {
                byteVector5.putShort(newUTF8(str3)).putInt(0);
            }
            int i11 = this.access;
            if ((i11 & 4096) != 0 && ((this.version & 65535) < 49 || (i11 & 262144) != 0)) {
                byteVector5.putShort(newUTF8("Synthetic")).putInt(0);
            }
            if (this.innerClasses != null) {
                byteVector5.putShort(newUTF8("InnerClasses"));
                byteVector5.putInt(this.innerClasses.length + 2).putShort(this.innerClassesCount);
                byteVector5.putByteArray(this.innerClasses.data, 0, this.innerClasses.length);
            }
            if (this.anns != null) {
                byteVector5.putShort(newUTF8("RuntimeVisibleAnnotations"));
                this.anns.put(byteVector5);
            }
            if (this.ianns != null) {
                byteVector5.putShort(newUTF8(str4));
                this.ianns.put(byteVector5);
            }
            if (this.tanns != null) {
                byteVector5.putShort(newUTF8(str));
                this.tanns.put(byteVector5);
            }
            if (this.itanns != null) {
                byteVector5.putShort(newUTF8("RuntimeInvisibleTypeAnnotations"));
                this.itanns.put(byteVector5);
            }
            Attribute attribute2 = this.attrs;
            if (attribute2 != null) {
                byteVector = byteVector5;
                attribute2.put(this, (byte[]) null, 0, -1, -1, byteVector);
            } else {
                byteVector = byteVector5;
            }
            if (!this.hasAsmInsns) {
                return byteVector.data;
            }
            this.anns = null;
            this.ianns = null;
            this.attrs = null;
            this.innerClassesCount = 0;
            this.innerClasses = null;
            this.firstField = null;
            this.lastField = null;
            this.firstMethod = null;
            this.lastMethod = null;
            this.compute = 1;
            this.hasAsmInsns = false;
            new ClassReader(byteVector.data).accept(this, 264);
            return toByteArray();
        }
        throw new RuntimeException("Class file too large!");
    }

    /* access modifiers changed from: package-private */
    public Item newConstItem(Object obj) {
        if (obj instanceof Integer) {
            return newInteger(((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return newInteger(((Byte) obj).intValue());
        }
        if (obj instanceof Character) {
            return newInteger(((Character) obj).charValue());
        }
        if (obj instanceof Short) {
            return newInteger(((Short) obj).intValue());
        }
        if (obj instanceof Boolean) {
            return newInteger(((Boolean) obj).booleanValue() ? 1 : 0);
        }
        if (obj instanceof Float) {
            return newFloat(((Float) obj).floatValue());
        }
        if (obj instanceof Long) {
            return newLong(((Long) obj).longValue());
        }
        if (obj instanceof Double) {
            return newDouble(((Double) obj).doubleValue());
        }
        if (obj instanceof String) {
            return newString((String) obj);
        }
        if (obj instanceof Type) {
            Type type = (Type) obj;
            int sort = type.getSort();
            if (sort == 10) {
                return newClassItem(type.getInternalName());
            }
            if (sort == 11) {
                return newMethodTypeItem(type.getDescriptor());
            }
            return newClassItem(type.getDescriptor());
        } else if (obj instanceof Handle) {
            Handle handle = (Handle) obj;
            return newHandleItem(handle.tag, handle.owner, handle.name, handle.desc, handle.itf);
        } else {
            throw new IllegalArgumentException("value " + obj);
        }
    }

    public int newConst(Object obj) {
        return newConstItem(obj).index;
    }

    public int newUTF8(String str) {
        this.key.set(1, str, (String) null, (String) null);
        Item item = get(this.key);
        if (item == null) {
            this.pool.putByte(1).putUTF8(str);
            int i = this.index;
            this.index = i + 1;
            item = new Item(i, this.key);
            put(item);
        }
        return item.index;
    }

    /* access modifiers changed from: package-private */
    public Item newClassItem(String str) {
        this.key2.set(7, str, (String) null, (String) null);
        Item item = get(this.key2);
        if (item != null) {
            return item;
        }
        this.pool.put12(7, newUTF8(str));
        int i = this.index;
        this.index = i + 1;
        Item item2 = new Item(i, this.key2);
        put(item2);
        return item2;
    }

    public int newClass(String str) {
        return newClassItem(str).index;
    }

    /* access modifiers changed from: package-private */
    public Item newMethodTypeItem(String str) {
        this.key2.set(16, str, (String) null, (String) null);
        Item item = get(this.key2);
        if (item != null) {
            return item;
        }
        this.pool.put12(16, newUTF8(str));
        int i = this.index;
        this.index = i + 1;
        Item item2 = new Item(i, this.key2);
        put(item2);
        return item2;
    }

    public int newMethodType(String str) {
        return newMethodTypeItem(str).index;
    }

    /* access modifiers changed from: package-private */
    public Item newHandleItem(int i, String str, String str2, String str3, boolean z) {
        this.key4.set(i + 20, str, str2, str3);
        Item item = get(this.key4);
        if (item != null) {
            return item;
        }
        if (i <= 4) {
            put112(15, i, newField(str, str2, str3));
        } else {
            put112(15, i, newMethod(str, str2, str3, z));
        }
        int i2 = this.index;
        this.index = i2 + 1;
        Item item2 = new Item(i2, this.key4);
        put(item2);
        return item2;
    }

    @Deprecated
    public int newHandle(int i, String str, String str2, String str3) {
        return newHandle(i, str, str2, str3, i == 9);
    }

    public int newHandle(int i, String str, String str2, String str3, boolean z) {
        return newHandleItem(i, str, str2, str3, z).index;
    }

    /* access modifiers changed from: package-private */
    public Item newInvokeDynamicItem(String str, String str2, Handle handle, Object... objArr) {
        int i;
        ByteVector byteVector = this.bootstrapMethods;
        if (byteVector == null) {
            byteVector = new ByteVector();
            this.bootstrapMethods = byteVector;
        }
        int i2 = byteVector.length;
        int hashCode = handle.hashCode();
        byteVector.putShort(newHandle(handle.tag, handle.owner, handle.name, handle.desc, handle.isInterface()));
        byteVector.putShort(r12);
        for (Object obj : objArr) {
            hashCode ^= obj.hashCode();
            byteVector.putShort(newConst(obj));
        }
        byte[] bArr = byteVector.data;
        int i3 = (r12 + 2) << 1;
        int i4 = hashCode & Integer.MAX_VALUE;
        Item[] itemArr = this.items;
        Item item = itemArr[i4 % itemArr.length];
        loop1:
        while (item != null) {
            if (item.type == 33 && item.hashCode == i4) {
                int i5 = item.intVal;
                int i6 = 0;
                while (i6 < i3) {
                    if (bArr[i2 + i6] != bArr[i5 + i6]) {
                        item = item.next;
                    } else {
                        i6++;
                    }
                }
                break loop1;
            }
            item = item.next;
        }
        if (item != null) {
            i = item.index;
            byteVector.length = i2;
        } else {
            i = this.bootstrapMethodsCount;
            this.bootstrapMethodsCount = i + 1;
            Item item2 = new Item(i);
            item2.set(i2, i4);
            put(item2);
        }
        this.key3.set(str, str2, i);
        Item item3 = get(this.key3);
        if (item3 != null) {
            return item3;
        }
        put122(18, i, newNameType(str, str2));
        int i7 = this.index;
        this.index = i7 + 1;
        Item item4 = new Item(i7, this.key3);
        put(item4);
        return item4;
    }

    public int newInvokeDynamic(String str, String str2, Handle handle, Object... objArr) {
        return newInvokeDynamicItem(str, str2, handle, objArr).index;
    }

    /* access modifiers changed from: package-private */
    public Item newFieldItem(String str, String str2, String str3) {
        this.key3.set(9, str, str2, str3);
        Item item = get(this.key3);
        if (item != null) {
            return item;
        }
        put122(9, newClass(str), newNameType(str2, str3));
        int i = this.index;
        this.index = i + 1;
        Item item2 = new Item(i, this.key3);
        put(item2);
        return item2;
    }

    public int newField(String str, String str2, String str3) {
        return newFieldItem(str, str2, str3).index;
    }

    /* access modifiers changed from: package-private */
    public Item newMethodItem(String str, String str2, String str3, boolean z) {
        int i = z ? 11 : 10;
        this.key3.set(i, str, str2, str3);
        Item item = get(this.key3);
        if (item != null) {
            return item;
        }
        put122(i, newClass(str), newNameType(str2, str3));
        int i2 = this.index;
        this.index = i2 + 1;
        Item item2 = new Item(i2, this.key3);
        put(item2);
        return item2;
    }

    public int newMethod(String str, String str2, String str3, boolean z) {
        return newMethodItem(str, str2, str3, z).index;
    }

    /* access modifiers changed from: package-private */
    public Item newInteger(int i) {
        this.key.set(i);
        Item item = get(this.key);
        if (item != null) {
            return item;
        }
        this.pool.putByte(3).putInt(i);
        int i2 = this.index;
        this.index = i2 + 1;
        Item item2 = new Item(i2, this.key);
        put(item2);
        return item2;
    }

    /* access modifiers changed from: package-private */
    public Item newFloat(float f) {
        this.key.set(f);
        Item item = get(this.key);
        if (item != null) {
            return item;
        }
        this.pool.putByte(4).putInt(this.key.intVal);
        int i = this.index;
        this.index = i + 1;
        Item item2 = new Item(i, this.key);
        put(item2);
        return item2;
    }

    /* access modifiers changed from: package-private */
    public Item newLong(long j) {
        this.key.set(j);
        Item item = get(this.key);
        if (item != null) {
            return item;
        }
        this.pool.putByte(5).putLong(j);
        Item item2 = new Item(this.index, this.key);
        this.index += 2;
        put(item2);
        return item2;
    }

    /* access modifiers changed from: package-private */
    public Item newDouble(double d) {
        this.key.set(d);
        Item item = get(this.key);
        if (item != null) {
            return item;
        }
        this.pool.putByte(6).putLong(this.key.longVal);
        Item item2 = new Item(this.index, this.key);
        this.index += 2;
        put(item2);
        return item2;
    }

    private Item newString(String str) {
        this.key2.set(8, str, (String) null, (String) null);
        Item item = get(this.key2);
        if (item != null) {
            return item;
        }
        this.pool.put12(8, newUTF8(str));
        int i = this.index;
        this.index = i + 1;
        Item item2 = new Item(i, this.key2);
        put(item2);
        return item2;
    }

    public int newNameType(String str, String str2) {
        return newNameTypeItem(str, str2).index;
    }

    /* access modifiers changed from: package-private */
    public Item newNameTypeItem(String str, String str2) {
        this.key2.set(12, str, str2, (String) null);
        Item item = get(this.key2);
        if (item != null) {
            return item;
        }
        put122(12, newUTF8(str), newUTF8(str2));
        int i = this.index;
        this.index = i + 1;
        Item item2 = new Item(i, this.key2);
        put(item2);
        return item2;
    }

    /* access modifiers changed from: package-private */
    public int addType(String str) {
        this.key.set(30, str, (String) null, (String) null);
        Item item = get(this.key);
        if (item == null) {
            item = addType(this.key);
        }
        return item.index;
    }

    /* access modifiers changed from: package-private */
    public int addUninitializedType(String str, int i) {
        this.key.type = 31;
        this.key.intVal = i;
        this.key.strVal1 = str;
        this.key.hashCode = (str.hashCode() + 31 + i) & Integer.MAX_VALUE;
        Item item = get(this.key);
        if (item == null) {
            item = addType(this.key);
        }
        return item.index;
    }

    private Item addType(Item item) {
        short s = (short) (this.typeCount + 1);
        this.typeCount = s;
        Item item2 = new Item(s, this.key);
        put(item2);
        if (this.typeTable == null) {
            this.typeTable = new Item[16];
        }
        short s2 = this.typeCount;
        Item[] itemArr = this.typeTable;
        if (s2 == itemArr.length) {
            Item[] itemArr2 = new Item[(itemArr.length * 2)];
            System.arraycopy(itemArr, 0, itemArr2, 0, itemArr.length);
            this.typeTable = itemArr2;
        }
        this.typeTable[this.typeCount] = item2;
        return item2;
    }

    /* access modifiers changed from: package-private */
    public int getMergedType(int i, int i2) {
        this.key2.type = 32;
        this.key2.longVal = ((long) i) | (((long) i2) << 32);
        this.key2.hashCode = (i + 32 + i2) & Integer.MAX_VALUE;
        Item item = get(this.key2);
        if (item == null) {
            String str = this.typeTable[i].strVal1;
            String str2 = this.typeTable[i2].strVal1;
            this.key2.intVal = addType(getCommonSuperClass(str, str2));
            item = new Item(0, this.key2);
            put(item);
        }
        return item.intVal;
    }

    /* access modifiers changed from: protected */
    public String getCommonSuperClass(String str, String str2) {
        ClassLoader classLoader = getClass().getClassLoader();
        try {
            Class cls = Class.forName(str.replace(IOUtils.DIR_SEPARATOR_UNIX, '.'), false, classLoader);
            Class<?> cls2 = Class.forName(str2.replace(IOUtils.DIR_SEPARATOR_UNIX, '.'), false, classLoader);
            if (cls.isAssignableFrom(cls2)) {
                return str;
            }
            if (cls2.isAssignableFrom(cls)) {
                return str2;
            }
            if (cls.isInterface() || cls2.isInterface()) {
                return "java/lang/Object";
            }
            do {
                cls = cls.getSuperclass();
            } while (!cls.isAssignableFrom(cls2));
            return cls.getName().replace('.', IOUtils.DIR_SEPARATOR_UNIX);
        } catch (Exception e) {
            throw new RuntimeException(e.toString());
        }
    }

    private Item get(Item item) {
        Item item2 = this.items[item.hashCode % this.items.length];
        while (item2 != null && (item2.type != item.type || !item.isEqualTo(item2))) {
            item2 = item2.next;
        }
        return item2;
    }

    private void put(Item item) {
        if (this.index + this.typeCount > this.threshold) {
            int length = this.items.length;
            int i = (length * 2) + 1;
            Item[] itemArr = new Item[i];
            for (int i2 = length - 1; i2 >= 0; i2--) {
                Item item2 = this.items[i2];
                while (item2 != null) {
                    int i3 = item2.hashCode % i;
                    Item item3 = item2.next;
                    item2.next = itemArr[i3];
                    itemArr[i3] = item2;
                    item2 = item3;
                }
            }
            this.items = itemArr;
            this.threshold = (int) (((double) i) * 0.75d);
        }
        int i4 = item.hashCode;
        Item[] itemArr2 = this.items;
        int length2 = i4 % itemArr2.length;
        item.next = itemArr2[length2];
        this.items[length2] = item;
    }

    private void put122(int i, int i2, int i3) {
        this.pool.put12(i, i2).putShort(i3);
    }

    private void put112(int i, int i2, int i3) {
        this.pool.put11(i, i2).putShort(i3);
    }
}
