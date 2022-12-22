package org.jacoco.agent.p086rt.internal_8ff85ea.asm;

import org.bouncycastle.pqc.math.linearalgebra.Matrix;
import org.osgi.framework.VersionRange;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.asm.MethodWriter */
class MethodWriter extends MethodVisitor {
    static final int ACC_CONSTRUCTOR = 524288;
    static final int APPEND_FRAME = 252;
    static final int CHOP_FRAME = 248;
    static final int FRAMES = 0;
    static final int FULL_FRAME = 255;
    static final int INSERTED_FRAMES = 1;
    static final int MAXS = 2;
    static final int NOTHING = 3;
    static final int RESERVED = 128;
    static final int SAME_FRAME = 0;
    static final int SAME_FRAME_EXTENDED = 251;
    static final int SAME_LOCALS_1_STACK_ITEM_FRAME = 64;
    static final int SAME_LOCALS_1_STACK_ITEM_FRAME_EXTENDED = 247;
    private int access;
    private ByteVector annd;
    private AnnotationWriter anns;
    private Attribute attrs;
    private Attribute cattrs;
    int classReaderLength;
    int classReaderOffset;
    private ByteVector code = new ByteVector();
    private final int compute;
    private AnnotationWriter ctanns;
    private Label currentBlock;
    private int currentLocals;

    /* renamed from: cw */
    final ClassWriter f6586cw;
    private final int desc;
    private final String descriptor;
    int exceptionCount;
    int[] exceptions;
    private Handler firstHandler;
    private int[] frame;
    private int frameCount;
    private int handlerCount;
    private AnnotationWriter ianns;
    private AnnotationWriter ictanns;
    private AnnotationWriter[] ipanns;
    private AnnotationWriter itanns;
    private Label labels;
    private int lastCodeOffset;
    private Handler lastHandler;
    private ByteVector lineNumber;
    private int lineNumberCount;
    private ByteVector localVar;
    private int localVarCount;
    private ByteVector localVarType;
    private int localVarTypeCount;
    private int maxLocals;
    private int maxStack;
    private int maxStackSize;
    private ByteVector methodParameters;
    private int methodParametersCount;
    private final int name;
    private AnnotationWriter[] panns;
    private Label previousBlock;
    private int[] previousFrame;
    private int previousFrameOffset;
    String signature;
    private ByteVector stackMap;
    private int stackSize;
    private int subroutines;
    private int synthetics;
    private AnnotationWriter tanns;

    public void visitCode() {
    }

    public void visitEnd() {
    }

    MethodWriter(ClassWriter classWriter, int i, String str, String str2, String str3, String[] strArr, int i2) {
        super(327680);
        if (classWriter.firstMethod == null) {
            classWriter.firstMethod = this;
        } else {
            classWriter.lastMethod.f6585mv = this;
        }
        classWriter.lastMethod = this;
        this.f6586cw = classWriter;
        this.access = i;
        if ("<init>".equals(str)) {
            this.access |= 524288;
        }
        this.name = classWriter.newUTF8(str);
        this.desc = classWriter.newUTF8(str2);
        this.descriptor = str2;
        this.signature = str3;
        if (strArr != null && strArr.length > 0) {
            int length = strArr.length;
            this.exceptionCount = length;
            this.exceptions = new int[length];
            for (int i3 = 0; i3 < this.exceptionCount; i3++) {
                this.exceptions[i3] = classWriter.newClass(strArr[i3]);
            }
        }
        this.compute = i2;
        if (i2 != 3) {
            int argumentsAndReturnSizes = Type.getArgumentsAndReturnSizes(this.descriptor) >> 2;
            argumentsAndReturnSizes = (i & 8) != 0 ? argumentsAndReturnSizes - 1 : argumentsAndReturnSizes;
            this.maxLocals = argumentsAndReturnSizes;
            this.currentLocals = argumentsAndReturnSizes;
            Label label = new Label();
            this.labels = label;
            label.status |= 8;
            visitLabel(this.labels);
        }
    }

    public void visitParameter(String str, int i) {
        if (this.methodParameters == null) {
            this.methodParameters = new ByteVector();
        }
        this.methodParametersCount++;
        this.methodParameters.putShort(str == null ? 0 : this.f6586cw.newUTF8(str)).putShort(i);
    }

    public AnnotationVisitor visitAnnotationDefault() {
        ByteVector byteVector = new ByteVector();
        this.annd = byteVector;
        return new AnnotationWriter(this.f6586cw, false, byteVector, (ByteVector) null, 0);
    }

    public AnnotationVisitor visitAnnotation(String str, boolean z) {
        ByteVector byteVector = new ByteVector();
        byteVector.putShort(this.f6586cw.newUTF8(str)).putShort(0);
        AnnotationWriter annotationWriter = new AnnotationWriter(this.f6586cw, true, byteVector, byteVector, 2);
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
        byteVector.putShort(this.f6586cw.newUTF8(str)).putShort(0);
        AnnotationWriter annotationWriter = new AnnotationWriter(this.f6586cw, true, byteVector, byteVector, byteVector.length - 2);
        if (z) {
            annotationWriter.next = this.tanns;
            this.tanns = annotationWriter;
        } else {
            annotationWriter.next = this.itanns;
            this.itanns = annotationWriter;
        }
        return annotationWriter;
    }

    public AnnotationVisitor visitParameterAnnotation(int i, String str, boolean z) {
        ByteVector byteVector = new ByteVector();
        if ("Ljava/lang/Synthetic;".equals(str)) {
            this.synthetics = Math.max(this.synthetics, i + 1);
            return new AnnotationWriter(this.f6586cw, false, byteVector, (ByteVector) null, 0);
        }
        byteVector.putShort(this.f6586cw.newUTF8(str)).putShort(0);
        AnnotationWriter annotationWriter = new AnnotationWriter(this.f6586cw, true, byteVector, byteVector, 2);
        if (z) {
            if (this.panns == null) {
                this.panns = new AnnotationWriter[Type.getArgumentTypes(this.descriptor).length];
            }
            annotationWriter.next = this.panns[i];
            this.panns[i] = annotationWriter;
        } else {
            if (this.ipanns == null) {
                this.ipanns = new AnnotationWriter[Type.getArgumentTypes(this.descriptor).length];
            }
            annotationWriter.next = this.ipanns[i];
            this.ipanns[i] = annotationWriter;
        }
        return annotationWriter;
    }

    public void visitAttribute(Attribute attribute) {
        if (attribute.isCodeAttribute()) {
            attribute.next = this.cattrs;
            this.cattrs = attribute;
            return;
        }
        attribute.next = this.attrs;
        this.attrs = attribute;
    }

    public void visitFrame(int i, int i2, Object[] objArr, int i3, Object[] objArr2) {
        int i4;
        int i5;
        int i6;
        int i7 = this.compute;
        if (i7 != 0) {
            if (i7 != 1) {
                int i8 = 0;
                if (i == -1) {
                    if (this.previousFrame == null) {
                        visitImplicitFirstFrame();
                    }
                    this.currentLocals = i2;
                    int startFrame = startFrame(this.code.length, i2, i3);
                    for (int i9 = 0; i9 < i2; i9++) {
                        if (objArr[i9] instanceof String) {
                            i6 = startFrame + 1;
                            this.frame[startFrame] = 24117248 | this.f6586cw.addType(objArr[i9]);
                        } else if (objArr[i9] instanceof Integer) {
                            i6 = startFrame + 1;
                            this.frame[startFrame] = objArr[i9].intValue();
                        } else {
                            this.frame[startFrame] = this.f6586cw.addUninitializedType("", objArr[i9].position) | 25165824;
                            startFrame++;
                        }
                        startFrame = i6;
                    }
                    while (i8 < i3) {
                        if (objArr2[i8] instanceof String) {
                            i5 = startFrame + 1;
                            this.frame[startFrame] = this.f6586cw.addType(objArr2[i8]) | 24117248;
                        } else if (objArr2[i8] instanceof Integer) {
                            i5 = startFrame + 1;
                            this.frame[startFrame] = objArr2[i8].intValue();
                        } else {
                            i5 = startFrame + 1;
                            this.frame[startFrame] = this.f6586cw.addUninitializedType("", objArr2[i8].position) | 25165824;
                        }
                        startFrame = i5;
                        i8++;
                    }
                    endFrame();
                } else {
                    if (this.stackMap == null) {
                        this.stackMap = new ByteVector();
                        i4 = this.code.length;
                    } else {
                        i4 = (this.code.length - this.previousFrameOffset) - 1;
                        if (i4 < 0) {
                            if (i != 3) {
                                throw new IllegalStateException();
                            }
                            return;
                        }
                    }
                    if (i == 0) {
                        this.currentLocals = i2;
                        this.stackMap.putByte(255).putShort(i4).putShort(i2);
                        for (int i10 = 0; i10 < i2; i10++) {
                            writeFrameType(objArr[i10]);
                        }
                        this.stackMap.putShort(i3);
                        while (i8 < i3) {
                            writeFrameType(objArr2[i8]);
                            i8++;
                        }
                    } else if (i == 1) {
                        this.currentLocals += i2;
                        this.stackMap.putByte(i2 + 251).putShort(i4);
                        while (i8 < i2) {
                            writeFrameType(objArr[i8]);
                            i8++;
                        }
                    } else if (i == 2) {
                        this.currentLocals -= i2;
                        this.stackMap.putByte(251 - i2).putShort(i4);
                    } else if (i != 3) {
                        if (i == 4) {
                            if (i4 < 64) {
                                this.stackMap.putByte(i4 + 64);
                            } else {
                                this.stackMap.putByte(247).putShort(i4);
                            }
                            writeFrameType(objArr2[0]);
                        }
                    } else if (i4 < 64) {
                        this.stackMap.putByte(i4);
                    } else {
                        this.stackMap.putByte(251).putShort(i4);
                    }
                    this.previousFrameOffset = this.code.length;
                    this.frameCount++;
                }
            } else if (this.currentBlock.frame == null) {
                this.currentBlock.frame = new CurrentFrame();
                this.currentBlock.frame.owner = this.currentBlock;
                this.currentBlock.frame.initInputFrame(this.f6586cw, this.access, Type.getArgumentTypes(this.descriptor), i2);
                visitImplicitFirstFrame();
            } else {
                if (i == -1) {
                    this.currentBlock.frame.set(this.f6586cw, i2, objArr, i3, objArr2);
                }
                visitFrame(this.currentBlock.frame);
            }
            this.maxStack = Math.max(this.maxStack, i3);
            this.maxLocals = Math.max(this.maxLocals, this.currentLocals);
        }
    }

    public void visitInsn(int i) {
        this.lastCodeOffset = this.code.length;
        this.code.putByte(i);
        if (this.currentBlock != null) {
            int i2 = this.compute;
            if (i2 == 0 || i2 == 1) {
                this.currentBlock.frame.execute(i, 0, (ClassWriter) null, (Item) null);
            } else {
                int i3 = this.stackSize + Frame.SIZE[i];
                if (i3 > this.maxStackSize) {
                    this.maxStackSize = i3;
                }
                this.stackSize = i3;
            }
            if ((i >= 172 && i <= 177) || i == 191) {
                noSuccessor();
            }
        }
    }

    public void visitIntInsn(int i, int i2) {
        this.lastCodeOffset = this.code.length;
        if (this.currentBlock != null) {
            int i3 = this.compute;
            if (i3 == 0 || i3 == 1) {
                this.currentBlock.frame.execute(i, i2, (ClassWriter) null, (Item) null);
            } else if (i != 188) {
                int i4 = this.stackSize + 1;
                if (i4 > this.maxStackSize) {
                    this.maxStackSize = i4;
                }
                this.stackSize = i4;
            }
        }
        if (i == 17) {
            this.code.put12(i, i2);
        } else {
            this.code.put11(i, i2);
        }
    }

    public void visitVarInsn(int i, int i2) {
        this.lastCodeOffset = this.code.length;
        Label label = this.currentBlock;
        if (label != null) {
            int i3 = this.compute;
            if (i3 == 0 || i3 == 1) {
                this.currentBlock.frame.execute(i, i2, (ClassWriter) null, (Item) null);
            } else if (i == 169) {
                label.status |= 256;
                this.currentBlock.inputStackTop = this.stackSize;
                noSuccessor();
            } else {
                int i4 = this.stackSize + Frame.SIZE[i];
                if (i4 > this.maxStackSize) {
                    this.maxStackSize = i4;
                }
                this.stackSize = i4;
            }
        }
        if (this.compute != 3) {
            int i5 = (i == 22 || i == 24 || i == 55 || i == 57) ? i2 + 2 : i2 + 1;
            if (i5 > this.maxLocals) {
                this.maxLocals = i5;
            }
        }
        if (i2 < 4 && i != 169) {
            this.code.putByte((i < 54 ? ((i - 21) << 2) + 26 : ((i - 54) << 2) + 59) + i2);
        } else if (i2 >= 256) {
            this.code.putByte(196).put12(i, i2);
        } else {
            this.code.put11(i, i2);
        }
        if (i >= 54 && this.compute == 0 && this.handlerCount > 0) {
            visitLabel(new Label());
        }
    }

    public void visitTypeInsn(int i, String str) {
        this.lastCodeOffset = this.code.length;
        Item newClassItem = this.f6586cw.newClassItem(str);
        if (this.currentBlock != null) {
            int i2 = this.compute;
            if (i2 == 0 || i2 == 1) {
                this.currentBlock.frame.execute(i, this.code.length, this.f6586cw, newClassItem);
            } else if (i == 187) {
                int i3 = this.stackSize + 1;
                if (i3 > this.maxStackSize) {
                    this.maxStackSize = i3;
                }
                this.stackSize = i3;
            }
        }
        this.code.put12(i, newClassItem.index);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003d, code lost:
        r8 = r8 + r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x004c, code lost:
        if (r8 <= r4.maxStackSize) goto L_0x0050;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x004e, code lost:
        r4.maxStackSize = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0050, code lost:
        r4.stackSize = r8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void visitFieldInsn(int r5, java.lang.String r6, java.lang.String r7, java.lang.String r8) {
        /*
            r4 = this;
            org.jacoco.agent.rt.internal_8ff85ea.asm.ByteVector r0 = r4.code
            int r0 = r0.length
            r4.lastCodeOffset = r0
            org.jacoco.agent.rt.internal_8ff85ea.asm.ClassWriter r0 = r4.f6586cw
            org.jacoco.agent.rt.internal_8ff85ea.asm.Item r6 = r0.newFieldItem(r6, r7, r8)
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label r7 = r4.currentBlock
            if (r7 == 0) goto L_0x005c
            int r7 = r4.compute
            r0 = 0
            if (r7 == 0) goto L_0x0053
            r1 = 1
            if (r7 != r1) goto L_0x0019
            goto L_0x0053
        L_0x0019:
            char r7 = r8.charAt(r0)
            r8 = -2
            r2 = 74
            r3 = 68
            switch(r5) {
                case 178: goto L_0x003f;
                case 179: goto L_0x0035;
                case 180: goto L_0x002c;
                default: goto L_0x0025;
            }
        L_0x0025:
            int r0 = r4.stackSize
            if (r7 == r3) goto L_0x0048
            if (r7 != r2) goto L_0x003d
            goto L_0x0048
        L_0x002c:
            int r8 = r4.stackSize
            if (r7 == r3) goto L_0x0032
            if (r7 != r2) goto L_0x0033
        L_0x0032:
            r0 = 1
        L_0x0033:
            int r8 = r8 + r0
            goto L_0x004a
        L_0x0035:
            int r0 = r4.stackSize
            if (r7 == r3) goto L_0x003d
            if (r7 != r2) goto L_0x003c
            goto L_0x003d
        L_0x003c:
            r8 = -1
        L_0x003d:
            int r8 = r8 + r0
            goto L_0x004a
        L_0x003f:
            int r8 = r4.stackSize
            if (r7 == r3) goto L_0x0045
            if (r7 != r2) goto L_0x0046
        L_0x0045:
            r1 = 2
        L_0x0046:
            int r8 = r8 + r1
            goto L_0x004a
        L_0x0048:
            r8 = -3
            goto L_0x003d
        L_0x004a:
            int r7 = r4.maxStackSize
            if (r8 <= r7) goto L_0x0050
            r4.maxStackSize = r8
        L_0x0050:
            r4.stackSize = r8
            goto L_0x005c
        L_0x0053:
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label r7 = r4.currentBlock
            org.jacoco.agent.rt.internal_8ff85ea.asm.Frame r7 = r7.frame
            org.jacoco.agent.rt.internal_8ff85ea.asm.ClassWriter r8 = r4.f6586cw
            r7.execute(r5, r0, r8, r6)
        L_0x005c:
            org.jacoco.agent.rt.internal_8ff85ea.asm.ByteVector r7 = r4.code
            int r6 = r6.index
            r7.put12(r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jacoco.agent.p086rt.internal_8ff85ea.asm.MethodWriter.visitFieldInsn(int, java.lang.String, java.lang.String, java.lang.String):void");
    }

    public void visitMethodInsn(int i, String str, String str2, String str3, boolean z) {
        int i2;
        this.lastCodeOffset = this.code.length;
        Item newMethodItem = this.f6586cw.newMethodItem(str, str2, str3, z);
        int i3 = newMethodItem.intVal;
        if (this.currentBlock != null) {
            int i4 = this.compute;
            if (i4 == 0 || i4 == 1) {
                this.currentBlock.frame.execute(i, 0, this.f6586cw, newMethodItem);
            } else {
                if (i3 == 0) {
                    i3 = Type.getArgumentsAndReturnSizes(str3);
                    newMethodItem.intVal = i3;
                }
                if (i == 184) {
                    i2 = (this.stackSize - (i3 >> 2)) + (i3 & 3) + 1;
                } else {
                    i2 = (this.stackSize - (i3 >> 2)) + (i3 & 3);
                }
                if (i2 > this.maxStackSize) {
                    this.maxStackSize = i2;
                }
                this.stackSize = i2;
            }
        }
        if (i == 185) {
            if (i3 == 0) {
                i3 = Type.getArgumentsAndReturnSizes(str3);
                newMethodItem.intVal = i3;
            }
            this.code.put12(185, newMethodItem.index).put11(i3 >> 2, 0);
            return;
        }
        this.code.put12(i, newMethodItem.index);
    }

    public void visitInvokeDynamicInsn(String str, String str2, Handle handle, Object... objArr) {
        this.lastCodeOffset = this.code.length;
        Item newInvokeDynamicItem = this.f6586cw.newInvokeDynamicItem(str, str2, handle, objArr);
        int i = newInvokeDynamicItem.intVal;
        if (this.currentBlock != null) {
            int i2 = this.compute;
            if (i2 == 0 || i2 == 1) {
                this.currentBlock.frame.execute(186, 0, this.f6586cw, newInvokeDynamicItem);
            } else {
                if (i == 0) {
                    i = Type.getArgumentsAndReturnSizes(str2);
                    newInvokeDynamicItem.intVal = i;
                }
                int i3 = (this.stackSize - (i >> 2)) + (i & 3) + 1;
                if (i3 > this.maxStackSize) {
                    this.maxStackSize = i3;
                }
                this.stackSize = i3;
            }
        }
        this.code.put12(186, newInvokeDynamicItem.index);
        this.code.putShort(0);
    }

    public void visitJumpInsn(int i, Label label) {
        boolean z = i >= 200;
        if (z) {
            i -= 33;
        }
        this.lastCodeOffset = this.code.length;
        Label label2 = this.currentBlock;
        Label label3 = null;
        if (label2 != null) {
            int i2 = this.compute;
            if (i2 == 0) {
                label2.frame.execute(i, 0, (ClassWriter) null, (Item) null);
                label.getFirst().status |= 16;
                addSuccessor(0, label);
                if (i != 167) {
                    label3 = new Label();
                }
            } else if (i2 == 1) {
                label2.frame.execute(i, 0, (ClassWriter) null, (Item) null);
            } else if (i == 168) {
                if ((label.status & 512) == 0) {
                    label.status |= 512;
                    this.subroutines++;
                }
                this.currentBlock.status |= 128;
                addSuccessor(this.stackSize + 1, label);
                label3 = new Label();
            } else {
                int i3 = this.stackSize + Frame.SIZE[i];
                this.stackSize = i3;
                addSuccessor(i3, label);
            }
        }
        if ((label.status & 2) != 0 && label.position - this.code.length < -32768) {
            if (i == 167) {
                this.code.putByte(200);
            } else if (i == 168) {
                this.code.putByte(201);
            } else {
                if (label3 != null) {
                    label3.status |= 16;
                }
                this.code.putByte(i <= 166 ? ((i + 1) ^ 1) - 1 : i ^ 1);
                this.code.putShort(8);
                this.code.putByte(200);
            }
            ByteVector byteVector = this.code;
            label.put(this, byteVector, byteVector.length - 1, true);
        } else if (z) {
            this.code.putByte(i + 33);
            ByteVector byteVector2 = this.code;
            label.put(this, byteVector2, byteVector2.length - 1, true);
        } else {
            this.code.putByte(i);
            ByteVector byteVector3 = this.code;
            label.put(this, byteVector3, byteVector3.length - 1, false);
        }
        if (this.currentBlock != null) {
            if (label3 != null) {
                visitLabel(label3);
            }
            if (i == 167) {
                noSuccessor();
            }
        }
    }

    public void visitLabel(Label label) {
        this.f6586cw.hasAsmInsns |= label.resolve(this, this.code.length, this.code.data);
        if ((label.status & 1) == 0) {
            int i = this.compute;
            if (i == 0) {
                if (this.currentBlock != null) {
                    if (label.position == this.currentBlock.position) {
                        this.currentBlock.status |= label.status & 16;
                        label.frame = this.currentBlock.frame;
                        return;
                    }
                    addSuccessor(0, label);
                }
                this.currentBlock = label;
                if (label.frame == null) {
                    label.frame = new Frame();
                    label.frame.owner = label;
                }
                if (this.previousBlock != null) {
                    if (label.position == this.previousBlock.position) {
                        this.previousBlock.status |= label.status & 16;
                        label.frame = this.previousBlock.frame;
                        this.currentBlock = this.previousBlock;
                        return;
                    }
                    this.previousBlock.successor = label;
                }
                this.previousBlock = label;
            } else if (i == 1) {
                Label label2 = this.currentBlock;
                if (label2 == null) {
                    this.currentBlock = label;
                } else {
                    label2.frame.owner = label;
                }
            } else if (i == 2) {
                Label label3 = this.currentBlock;
                if (label3 != null) {
                    label3.outputStackMax = this.maxStackSize;
                    addSuccessor(this.stackSize, label);
                }
                this.currentBlock = label;
                this.stackSize = 0;
                this.maxStackSize = 0;
                Label label4 = this.previousBlock;
                if (label4 != null) {
                    label4.successor = label;
                }
                this.previousBlock = label;
            }
        }
    }

    public void visitLdcInsn(Object obj) {
        int i;
        this.lastCodeOffset = this.code.length;
        Item newConstItem = this.f6586cw.newConstItem(obj);
        if (this.currentBlock != null) {
            int i2 = this.compute;
            if (i2 == 0 || i2 == 1) {
                this.currentBlock.frame.execute(18, 0, this.f6586cw, newConstItem);
            } else {
                if (newConstItem.type == 5 || newConstItem.type == 6) {
                    i = this.stackSize + 2;
                } else {
                    i = this.stackSize + 1;
                }
                if (i > this.maxStackSize) {
                    this.maxStackSize = i;
                }
                this.stackSize = i;
            }
        }
        int i3 = newConstItem.index;
        if (newConstItem.type == 5 || newConstItem.type == 6) {
            this.code.put12(20, i3);
        } else if (i3 >= 256) {
            this.code.put12(19, i3);
        } else {
            this.code.put11(18, i3);
        }
    }

    public void visitIincInsn(int i, int i2) {
        int i3;
        int i4;
        this.lastCodeOffset = this.code.length;
        if (this.currentBlock != null && ((i4 = this.compute) == 0 || i4 == 1)) {
            this.currentBlock.frame.execute(132, i, (ClassWriter) null, (Item) null);
        }
        if (this.compute != 3 && (i3 = i + 1) > this.maxLocals) {
            this.maxLocals = i3;
        }
        if (i > 255 || i2 > 127 || i2 < -128) {
            this.code.putByte(196).put12(132, i).putShort(i2);
        } else {
            this.code.putByte(132).put11(i, i2);
        }
    }

    public void visitTableSwitchInsn(int i, int i2, Label label, Label... labelArr) {
        this.lastCodeOffset = this.code.length;
        int i3 = this.code.length;
        this.code.putByte(170);
        ByteVector byteVector = this.code;
        byteVector.putByteArray((byte[]) null, 0, (4 - (byteVector.length % 4)) % 4);
        label.put(this, this.code, i3, true);
        this.code.putInt(i).putInt(i2);
        for (Label put : labelArr) {
            put.put(this, this.code, i3, true);
        }
        visitSwitchInsn(label, labelArr);
    }

    public void visitLookupSwitchInsn(Label label, int[] iArr, Label[] labelArr) {
        this.lastCodeOffset = this.code.length;
        int i = this.code.length;
        this.code.putByte(171);
        ByteVector byteVector = this.code;
        byteVector.putByteArray((byte[]) null, 0, (4 - (byteVector.length % 4)) % 4);
        label.put(this, this.code, i, true);
        this.code.putInt(labelArr.length);
        for (int i2 = 0; i2 < labelArr.length; i2++) {
            this.code.putInt(iArr[i2]);
            labelArr[i2].put(this, this.code, i, true);
        }
        visitSwitchInsn(label, labelArr);
    }

    private void visitSwitchInsn(Label label, Label[] labelArr) {
        Label label2 = this.currentBlock;
        if (label2 != null) {
            if (this.compute == 0) {
                label2.frame.execute(171, 0, (ClassWriter) null, (Item) null);
                addSuccessor(0, label);
                label.getFirst().status |= 16;
                for (int i = 0; i < labelArr.length; i++) {
                    addSuccessor(0, labelArr[i]);
                    labelArr[i].getFirst().status |= 16;
                }
            } else {
                int i2 = this.stackSize - 1;
                this.stackSize = i2;
                addSuccessor(i2, label);
                for (Label addSuccessor : labelArr) {
                    addSuccessor(this.stackSize, addSuccessor);
                }
            }
            noSuccessor();
        }
    }

    public void visitMultiANewArrayInsn(String str, int i) {
        this.lastCodeOffset = this.code.length;
        Item newClassItem = this.f6586cw.newClassItem(str);
        if (this.currentBlock != null) {
            int i2 = this.compute;
            if (i2 == 0 || i2 == 1) {
                this.currentBlock.frame.execute(197, i, this.f6586cw, newClassItem);
            } else {
                this.stackSize += 1 - i;
            }
        }
        this.code.put12(197, newClassItem.index).putByte(i);
    }

    public AnnotationVisitor visitInsnAnnotation(int i, TypePath typePath, String str, boolean z) {
        ByteVector byteVector = new ByteVector();
        AnnotationWriter.putTarget((i & -16776961) | (this.lastCodeOffset << 8), typePath, byteVector);
        byteVector.putShort(this.f6586cw.newUTF8(str)).putShort(0);
        AnnotationWriter annotationWriter = new AnnotationWriter(this.f6586cw, true, byteVector, byteVector, byteVector.length - 2);
        if (z) {
            annotationWriter.next = this.ctanns;
            this.ctanns = annotationWriter;
        } else {
            annotationWriter.next = this.ictanns;
            this.ictanns = annotationWriter;
        }
        return annotationWriter;
    }

    public void visitTryCatchBlock(Label label, Label label2, Label label3, String str) {
        this.handlerCount++;
        Handler handler = new Handler();
        handler.start = label;
        handler.end = label2;
        handler.handler = label3;
        handler.desc = str;
        handler.type = str != null ? this.f6586cw.newClass(str) : 0;
        Handler handler2 = this.lastHandler;
        if (handler2 == null) {
            this.firstHandler = handler;
        } else {
            handler2.next = handler;
        }
        this.lastHandler = handler;
    }

    public AnnotationVisitor visitTryCatchAnnotation(int i, TypePath typePath, String str, boolean z) {
        ByteVector byteVector = new ByteVector();
        AnnotationWriter.putTarget(i, typePath, byteVector);
        byteVector.putShort(this.f6586cw.newUTF8(str)).putShort(0);
        AnnotationWriter annotationWriter = new AnnotationWriter(this.f6586cw, true, byteVector, byteVector, byteVector.length - 2);
        if (z) {
            annotationWriter.next = this.ctanns;
            this.ctanns = annotationWriter;
        } else {
            annotationWriter.next = this.ictanns;
            this.ictanns = annotationWriter;
        }
        return annotationWriter;
    }

    public void visitLocalVariable(String str, String str2, String str3, Label label, Label label2, int i) {
        int i2 = 1;
        if (str3 != null) {
            if (this.localVarType == null) {
                this.localVarType = new ByteVector();
            }
            this.localVarTypeCount++;
            this.localVarType.putShort(label.position).putShort(label2.position - label.position).putShort(this.f6586cw.newUTF8(str)).putShort(this.f6586cw.newUTF8(str3)).putShort(i);
        }
        if (this.localVar == null) {
            this.localVar = new ByteVector();
        }
        this.localVarCount++;
        this.localVar.putShort(label.position).putShort(label2.position - label.position).putShort(this.f6586cw.newUTF8(str)).putShort(this.f6586cw.newUTF8(str2)).putShort(i);
        if (this.compute != 3) {
            char charAt = str2.charAt(0);
            if (charAt == 'J' || charAt == 'D') {
                i2 = 2;
            }
            int i3 = i + i2;
            if (i3 > this.maxLocals) {
                this.maxLocals = i3;
            }
        }
    }

    public AnnotationVisitor visitLocalVariableAnnotation(int i, TypePath typePath, Label[] labelArr, Label[] labelArr2, int[] iArr, String str, boolean z) {
        ByteVector byteVector = new ByteVector();
        byteVector.putByte(i >>> 24).putShort(labelArr.length);
        for (int i2 = 0; i2 < labelArr.length; i2++) {
            byteVector.putShort(labelArr[i2].position).putShort(labelArr2[i2].position - labelArr[i2].position).putShort(iArr[i2]);
        }
        if (typePath == null) {
            byteVector.putByte(0);
        } else {
            byteVector.putByteArray(typePath.f6587b, typePath.offset, (typePath.f6587b[typePath.offset] * 2) + 1);
        }
        byteVector.putShort(this.f6586cw.newUTF8(str)).putShort(0);
        AnnotationWriter annotationWriter = new AnnotationWriter(this.f6586cw, true, byteVector, byteVector, byteVector.length - 2);
        if (z) {
            annotationWriter.next = this.ctanns;
            this.ctanns = annotationWriter;
        } else {
            annotationWriter.next = this.ictanns;
            this.ictanns = annotationWriter;
        }
        return annotationWriter;
    }

    public void visitLineNumber(int i, Label label) {
        if (this.lineNumber == null) {
            this.lineNumber = new ByteVector();
        }
        this.lineNumberCount++;
        this.lineNumber.putShort(label.position);
        this.lineNumber.putShort(i);
    }

    /*  JADX ERROR: JadxOverflowException in pass: LoopRegionVisitor
        jadx.core.utils.exceptions.JadxOverflowException: LoopRegionVisitor.assignOnlyInLoop endless recursion
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public void visitMaxs(int r14, int r15) {
        /*
            r13 = this;
            int r0 = r13.compute
            r1 = 0
            r2 = 32
            r3 = 0
            r4 = 1
            if (r0 != 0) goto L_0x0116
            org.jacoco.agent.rt.internal_8ff85ea.asm.Handler r14 = r13.firstHandler
        L_0x000b:
            r15 = 24117248(0x1700000, float:4.4081038E-38)
            java.lang.String r0 = "java/lang/Throwable"
            if (r14 == 0) goto L_0x004e
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label r5 = r14.start
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label r5 = r5.getFirst()
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label r6 = r14.handler
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label r6 = r6.getFirst()
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label r7 = r14.end
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label r7 = r7.getFirst()
            java.lang.String r8 = r14.desc
            if (r8 != 0) goto L_0x0028
            goto L_0x002a
        L_0x0028:
            java.lang.String r0 = r14.desc
        L_0x002a:
            org.jacoco.agent.rt.internal_8ff85ea.asm.ClassWriter r8 = r13.f6586cw
            int r0 = r8.addType((java.lang.String) r0)
            r15 = r15 | r0
            int r0 = r6.status
            r0 = r0 | 16
            r6.status = r0
        L_0x0037:
            if (r5 == r7) goto L_0x004b
            org.jacoco.agent.rt.internal_8ff85ea.asm.Edge r0 = new org.jacoco.agent.rt.internal_8ff85ea.asm.Edge
            r0.<init>()
            r0.info = r15
            r0.successor = r6
            org.jacoco.agent.rt.internal_8ff85ea.asm.Edge r8 = r5.successors
            r0.next = r8
            r5.successors = r0
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label r5 = r5.successor
            goto L_0x0037
        L_0x004b:
            org.jacoco.agent.rt.internal_8ff85ea.asm.Handler r14 = r14.next
            goto L_0x000b
        L_0x004e:
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label r14 = r13.labels
            org.jacoco.agent.rt.internal_8ff85ea.asm.Frame r14 = r14.frame
            org.jacoco.agent.rt.internal_8ff85ea.asm.ClassWriter r5 = r13.f6586cw
            int r6 = r13.access
            java.lang.String r7 = r13.descriptor
            org.jacoco.agent.rt.internal_8ff85ea.asm.Type[] r7 = org.jacoco.agent.p086rt.internal_8ff85ea.asm.Type.getArgumentTypes((java.lang.String) r7)
            int r8 = r13.maxLocals
            r14.initInputFrame(r5, r6, r7, r8)
            r13.visitFrame(r14)
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label r14 = r13.labels
            r5 = 0
        L_0x0067:
            if (r14 == 0) goto L_0x00ab
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label r6 = r14.next
            r14.next = r1
            org.jacoco.agent.rt.internal_8ff85ea.asm.Frame r7 = r14.frame
            int r8 = r14.status
            r8 = r8 & 16
            if (r8 == 0) goto L_0x007a
            int r8 = r14.status
            r8 = r8 | r2
            r14.status = r8
        L_0x007a:
            int r8 = r14.status
            r8 = r8 | 64
            r14.status = r8
            int[] r8 = r7.inputStack
            int r8 = r8.length
            int r9 = r14.outputStackMax
            int r8 = r8 + r9
            if (r8 <= r5) goto L_0x0089
            r5 = r8
        L_0x0089:
            org.jacoco.agent.rt.internal_8ff85ea.asm.Edge r14 = r14.successors
        L_0x008b:
            if (r14 == 0) goto L_0x00a9
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label r8 = r14.successor
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label r8 = r8.getFirst()
            org.jacoco.agent.rt.internal_8ff85ea.asm.ClassWriter r9 = r13.f6586cw
            org.jacoco.agent.rt.internal_8ff85ea.asm.Frame r10 = r8.frame
            int r11 = r14.info
            boolean r9 = r7.merge(r9, r10, r11)
            if (r9 == 0) goto L_0x00a6
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label r9 = r8.next
            if (r9 != 0) goto L_0x00a6
            r8.next = r6
            r6 = r8
        L_0x00a6:
            org.jacoco.agent.rt.internal_8ff85ea.asm.Edge r14 = r14.next
            goto L_0x008b
        L_0x00a9:
            r14 = r6
            goto L_0x0067
        L_0x00ab:
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label r14 = r13.labels
        L_0x00ad:
            if (r14 == 0) goto L_0x0104
            org.jacoco.agent.rt.internal_8ff85ea.asm.Frame r1 = r14.frame
            int r6 = r14.status
            r6 = r6 & r2
            if (r6 == 0) goto L_0x00b9
            r13.visitFrame(r1)
        L_0x00b9:
            int r1 = r14.status
            r1 = r1 & 64
            if (r1 != 0) goto L_0x0101
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label r1 = r14.successor
            int r6 = r14.position
            if (r1 != 0) goto L_0x00ca
            org.jacoco.agent.rt.internal_8ff85ea.asm.ByteVector r7 = r13.code
            int r7 = r7.length
            goto L_0x00cc
        L_0x00ca:
            int r7 = r1.position
        L_0x00cc:
            int r7 = r7 - r4
            if (r7 < r6) goto L_0x0101
            int r5 = java.lang.Math.max(r5, r4)
            r8 = r6
        L_0x00d4:
            if (r8 >= r7) goto L_0x00df
            org.jacoco.agent.rt.internal_8ff85ea.asm.ByteVector r9 = r13.code
            byte[] r9 = r9.data
            r9[r8] = r3
            int r8 = r8 + 1
            goto L_0x00d4
        L_0x00df:
            org.jacoco.agent.rt.internal_8ff85ea.asm.ByteVector r8 = r13.code
            byte[] r8 = r8.data
            r9 = -65
            r8[r7] = r9
            int r6 = r13.startFrame(r6, r3, r4)
            int[] r7 = r13.frame
            org.jacoco.agent.rt.internal_8ff85ea.asm.ClassWriter r8 = r13.f6586cw
            int r8 = r8.addType((java.lang.String) r0)
            r8 = r8 | r15
            r7[r6] = r8
            r13.endFrame()
            org.jacoco.agent.rt.internal_8ff85ea.asm.Handler r6 = r13.firstHandler
            org.jacoco.agent.rt.internal_8ff85ea.asm.Handler r1 = org.jacoco.agent.p086rt.internal_8ff85ea.asm.Handler.remove(r6, r14, r1)
            r13.firstHandler = r1
        L_0x0101:
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label r14 = r14.successor
            goto L_0x00ad
        L_0x0104:
            org.jacoco.agent.rt.internal_8ff85ea.asm.Handler r14 = r13.firstHandler
            r13.handlerCount = r3
        L_0x0108:
            if (r14 == 0) goto L_0x0112
            int r15 = r13.handlerCount
            int r15 = r15 + r4
            r13.handlerCount = r15
            org.jacoco.agent.rt.internal_8ff85ea.asm.Handler r14 = r14.next
            goto L_0x0108
        L_0x0112:
            r13.maxStack = r5
            goto L_0x01f4
        L_0x0116:
            r5 = 2
            if (r0 != r5) goto L_0x01f0
            org.jacoco.agent.rt.internal_8ff85ea.asm.Handler r15 = r13.firstHandler
        L_0x011b:
            r0 = 2147483647(0x7fffffff, float:NaN)
            if (r15 == 0) goto L_0x0152
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label r5 = r15.start
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label r6 = r15.handler
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label r7 = r15.end
        L_0x0126:
            if (r5 == r7) goto L_0x014f
            org.jacoco.agent.rt.internal_8ff85ea.asm.Edge r8 = new org.jacoco.agent.rt.internal_8ff85ea.asm.Edge
            r8.<init>()
            r8.info = r0
            r8.successor = r6
            int r9 = r5.status
            r9 = r9 & 128(0x80, float:1.794E-43)
            if (r9 != 0) goto L_0x013e
            org.jacoco.agent.rt.internal_8ff85ea.asm.Edge r9 = r5.successors
            r8.next = r9
            r5.successors = r8
            goto L_0x014c
        L_0x013e:
            org.jacoco.agent.rt.internal_8ff85ea.asm.Edge r9 = r5.successors
            org.jacoco.agent.rt.internal_8ff85ea.asm.Edge r9 = r9.next
            org.jacoco.agent.rt.internal_8ff85ea.asm.Edge r9 = r9.next
            r8.next = r9
            org.jacoco.agent.rt.internal_8ff85ea.asm.Edge r9 = r5.successors
            org.jacoco.agent.rt.internal_8ff85ea.asm.Edge r9 = r9.next
            r9.next = r8
        L_0x014c:
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label r5 = r5.successor
            goto L_0x0126
        L_0x014f:
            org.jacoco.agent.rt.internal_8ff85ea.asm.Handler r15 = r15.next
            goto L_0x011b
        L_0x0152:
            int r15 = r13.subroutines
            if (r15 <= 0) goto L_0x01af
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label r5 = r13.labels
            r6 = 1
            r5.visitSubroutine(r1, r6, r15)
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label r15 = r13.labels
            r5 = 0
        L_0x0160:
            if (r15 == 0) goto L_0x0188
            int r8 = r15.status
            r8 = r8 & 128(0x80, float:1.794E-43)
            if (r8 == 0) goto L_0x0185
            org.jacoco.agent.rt.internal_8ff85ea.asm.Edge r8 = r15.successors
            org.jacoco.agent.rt.internal_8ff85ea.asm.Edge r8 = r8.next
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label r8 = r8.successor
            int r9 = r8.status
            r9 = r9 & 1024(0x400, float:1.435E-42)
            if (r9 != 0) goto L_0x0185
            int r5 = r5 + 1
            long r9 = (long) r5
            r11 = 32
            long r9 = r9 / r11
            long r9 = r9 << r2
            int r11 = r5 % 32
            long r11 = r6 << r11
            long r9 = r9 | r11
            int r11 = r13.subroutines
            r8.visitSubroutine(r1, r9, r11)
        L_0x0185:
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label r15 = r15.successor
            goto L_0x0160
        L_0x0188:
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label r15 = r13.labels
        L_0x018a:
            if (r15 == 0) goto L_0x01af
            int r1 = r15.status
            r1 = r1 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x01ac
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label r1 = r13.labels
        L_0x0194:
            if (r1 == 0) goto L_0x019f
            int r2 = r1.status
            r2 = r2 & -2049(0xfffffffffffff7ff, float:NaN)
            r1.status = r2
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label r1 = r1.successor
            goto L_0x0194
        L_0x019f:
            org.jacoco.agent.rt.internal_8ff85ea.asm.Edge r1 = r15.successors
            org.jacoco.agent.rt.internal_8ff85ea.asm.Edge r1 = r1.next
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label r1 = r1.successor
            r5 = 0
            int r2 = r13.subroutines
            r1.visitSubroutine(r15, r5, r2)
        L_0x01ac:
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label r15 = r15.successor
            goto L_0x018a
        L_0x01af:
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label r15 = r13.labels
        L_0x01b1:
            if (r15 == 0) goto L_0x01e9
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label r1 = r15.next
            int r2 = r15.inputStackTop
            int r5 = r15.outputStackMax
            int r5 = r5 + r2
            if (r5 <= r3) goto L_0x01bd
            r3 = r5
        L_0x01bd:
            org.jacoco.agent.rt.internal_8ff85ea.asm.Edge r5 = r15.successors
            int r15 = r15.status
            r15 = r15 & 128(0x80, float:1.794E-43)
            if (r15 == 0) goto L_0x01c7
            org.jacoco.agent.rt.internal_8ff85ea.asm.Edge r5 = r5.next
        L_0x01c7:
            r15 = r1
        L_0x01c8:
            if (r5 == 0) goto L_0x01b1
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label r1 = r5.successor
            int r6 = r1.status
            r6 = r6 & 8
            if (r6 != 0) goto L_0x01e6
            int r6 = r5.info
            if (r6 != r0) goto L_0x01d8
            r6 = 1
            goto L_0x01db
        L_0x01d8:
            int r6 = r5.info
            int r6 = r6 + r2
        L_0x01db:
            r1.inputStackTop = r6
            int r6 = r1.status
            r6 = r6 | 8
            r1.status = r6
            r1.next = r15
            r15 = r1
        L_0x01e6:
            org.jacoco.agent.rt.internal_8ff85ea.asm.Edge r5 = r5.next
            goto L_0x01c8
        L_0x01e9:
            int r14 = java.lang.Math.max(r14, r3)
            r13.maxStack = r14
            goto L_0x01f4
        L_0x01f0:
            r13.maxStack = r14
            r13.maxLocals = r15
        L_0x01f4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jacoco.agent.p086rt.internal_8ff85ea.asm.MethodWriter.visitMaxs(int, int):void");
    }

    private void addSuccessor(int i, Label label) {
        Edge edge = new Edge();
        edge.info = i;
        edge.successor = label;
        edge.next = this.currentBlock.successors;
        this.currentBlock.successors = edge;
    }

    private void noSuccessor() {
        if (this.compute == 0) {
            Label label = new Label();
            label.frame = new Frame();
            label.frame.owner = label;
            label.resolve(this, this.code.length, this.code.data);
            this.previousBlock.successor = label;
            this.previousBlock = label;
        } else {
            this.currentBlock.outputStackMax = this.maxStackSize;
        }
        if (this.compute != 1) {
            this.currentBlock = null;
        }
    }

    private void visitFrame(Frame frame2) {
        int[] iArr = frame2.inputLocals;
        int[] iArr2 = frame2.inputStack;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < iArr.length) {
            int i5 = iArr[i2];
            if (i5 == 16777216) {
                i4++;
            } else {
                i3 += i4 + 1;
                i4 = 0;
            }
            if (i5 == 16777220 || i5 == 16777219) {
                i2++;
            }
            i2++;
        }
        int i6 = 0;
        int i7 = 0;
        while (i6 < iArr2.length) {
            int i8 = iArr2[i6];
            i7++;
            if (i8 == 16777220 || i8 == 16777219) {
                i6++;
            }
            i6++;
        }
        int startFrame = startFrame(frame2.owner.position, i3, i7);
        int i9 = 0;
        while (i3 > 0) {
            int i10 = iArr[i9];
            int i11 = startFrame + 1;
            this.frame[startFrame] = i10;
            if (i10 == 16777220 || i10 == 16777219) {
                i9++;
            }
            i9++;
            i3--;
            startFrame = i11;
        }
        while (i < iArr2.length) {
            int i12 = iArr2[i];
            int i13 = startFrame + 1;
            this.frame[startFrame] = i12;
            if (i12 == 16777220 || i12 == 16777219) {
                i++;
            }
            i++;
            startFrame = i13;
        }
        endFrame();
    }

    private void visitImplicitFirstFrame() {
        int i;
        int i2;
        int i3;
        int i4;
        int startFrame = startFrame(0, this.descriptor.length() + 1, 0);
        int i5 = this.access;
        if ((i5 & 8) == 0) {
            if ((i5 & 524288) == 0) {
                int[] iArr = this.frame;
                i4 = startFrame + 1;
                ClassWriter classWriter = this.f6586cw;
                iArr[startFrame] = classWriter.addType(classWriter.thisName) | 24117248;
            } else {
                i4 = startFrame + 1;
                this.frame[startFrame] = 6;
            }
            startFrame = i4;
        }
        int i6 = 1;
        while (true) {
            int i7 = i6 + 1;
            char charAt = this.descriptor.charAt(i6);
            if (charAt == 'F') {
                i2 = i + 1;
                this.frame[i] = 2;
            } else if (charAt != 'L') {
                if (!(charAt == 'S' || charAt == 'I')) {
                    if (charAt == 'J') {
                        i2 = i + 1;
                        this.frame[i] = 4;
                    } else if (charAt != 'Z') {
                        if (charAt != '[') {
                            switch (charAt) {
                                case 'B':
                                case 'C':
                                    break;
                                case 'D':
                                    i3 = i + 1;
                                    this.frame[i] = 3;
                                    break;
                                default:
                                    this.frame[1] = i - 3;
                                    endFrame();
                                    return;
                            }
                        } else {
                            while (this.descriptor.charAt(i7) == '[') {
                                i7++;
                            }
                            if (this.descriptor.charAt(i7) == 'L') {
                                do {
                                    i7++;
                                } while (this.descriptor.charAt(i7) != ';');
                            }
                            i3 = i + 1;
                            i7++;
                            this.frame[i] = this.f6586cw.addType(this.descriptor.substring(i6, i7)) | 24117248;
                        }
                        i6 = i7;
                        i = i3;
                    }
                }
                i2 = i + 1;
                this.frame[i] = 1;
            } else {
                int i8 = i7;
                while (this.descriptor.charAt(i8) != ';') {
                    i8++;
                }
                this.frame[i] = this.f6586cw.addType(this.descriptor.substring(i7, i8)) | 24117248;
                i++;
                i6 = i8 + 1;
            }
            i = i2;
            i6 = i7;
        }
    }

    private int startFrame(int i, int i2, int i3) {
        int i4 = i2 + 3 + i3;
        int[] iArr = this.frame;
        if (iArr == null || iArr.length < i4) {
            this.frame = new int[i4];
        }
        int[] iArr2 = this.frame;
        iArr2[0] = i;
        iArr2[1] = i2;
        iArr2[2] = i3;
        return 3;
    }

    private void endFrame() {
        if (this.previousFrame != null) {
            if (this.stackMap == null) {
                this.stackMap = new ByteVector();
            }
            writeFrame();
            this.frameCount++;
        }
        this.previousFrame = this.frame;
        this.frame = null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0106  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void writeFrame() {
        /*
            r16 = this;
            r0 = r16
            int[] r1 = r0.frame
            r2 = 1
            r3 = r1[r2]
            r4 = 2
            r1 = r1[r4]
            org.jacoco.agent.rt.internal_8ff85ea.asm.ClassWriter r4 = r0.f6586cw
            int r4 = r4.version
            r5 = 65535(0xffff, float:9.1834E-41)
            r4 = r4 & r5
            r5 = 0
            r6 = 3
            r7 = 50
            if (r4 >= r7) goto L_0x0033
            org.jacoco.agent.rt.internal_8ff85ea.asm.ByteVector r2 = r0.stackMap
            int[] r4 = r0.frame
            r4 = r4[r5]
            org.jacoco.agent.rt.internal_8ff85ea.asm.ByteVector r2 = r2.putShort(r4)
            r2.putShort(r3)
            int r3 = r3 + r6
            r0.writeFrameTypes(r6, r3)
            org.jacoco.agent.rt.internal_8ff85ea.asm.ByteVector r2 = r0.stackMap
            r2.putShort(r1)
            int r1 = r1 + r3
            r0.writeFrameTypes(r3, r1)
            return
        L_0x0033:
            int[] r4 = r0.previousFrame
            r7 = r4[r2]
            int r8 = r0.frameCount
            if (r8 != 0) goto L_0x0040
            int[] r4 = r0.frame
            r4 = r4[r5]
            goto L_0x0049
        L_0x0040:
            int[] r8 = r0.frame
            r8 = r8[r5]
            r4 = r4[r5]
            int r8 = r8 - r4
            int r4 = r8 + -1
        L_0x0049:
            r8 = 252(0xfc, float:3.53E-43)
            r9 = 248(0xf8, float:3.48E-43)
            r10 = 247(0xf7, float:3.46E-43)
            r11 = 64
            r12 = 255(0xff, float:3.57E-43)
            r13 = 251(0xfb, float:3.52E-43)
            if (r1 != 0) goto L_0x006b
            int r2 = r3 - r7
            switch(r2) {
                case -3: goto L_0x0067;
                case -2: goto L_0x0067;
                case -1: goto L_0x0067;
                case 0: goto L_0x0060;
                case 1: goto L_0x005d;
                case 2: goto L_0x005d;
                case 3: goto L_0x005d;
                default: goto L_0x005c;
            }
        L_0x005c:
            goto L_0x007b
        L_0x005d:
            r14 = 252(0xfc, float:3.53E-43)
            goto L_0x007d
        L_0x0060:
            if (r4 >= r11) goto L_0x0064
            r14 = 0
            goto L_0x007d
        L_0x0064:
            r14 = 251(0xfb, float:3.52E-43)
            goto L_0x007d
        L_0x0067:
            r7 = r3
            r14 = 248(0xf8, float:3.48E-43)
            goto L_0x007d
        L_0x006b:
            if (r3 != r7) goto L_0x007a
            if (r1 != r2) goto L_0x007a
            r2 = 63
            if (r4 >= r2) goto L_0x0076
            r14 = 64
            goto L_0x0078
        L_0x0076:
            r14 = 247(0xf7, float:3.46E-43)
        L_0x0078:
            r2 = 0
            goto L_0x007d
        L_0x007a:
            r2 = 0
        L_0x007b:
            r14 = 255(0xff, float:3.57E-43)
        L_0x007d:
            if (r14 == r12) goto L_0x0097
            r15 = 3
        L_0x0080:
            if (r5 >= r7) goto L_0x0097
            int[] r6 = r0.frame
            r6 = r6[r15]
            int[] r12 = r0.previousFrame
            r12 = r12[r15]
            if (r6 == r12) goto L_0x008f
            r14 = 255(0xff, float:3.57E-43)
            goto L_0x0097
        L_0x008f:
            int r15 = r15 + 1
            int r5 = r5 + 1
            r6 = 3
            r12 = 255(0xff, float:3.57E-43)
            goto L_0x0080
        L_0x0097:
            if (r14 == 0) goto L_0x0106
            if (r14 == r11) goto L_0x00f8
            if (r14 == r10) goto L_0x00e7
            if (r14 == r9) goto L_0x00dc
            if (r14 == r13) goto L_0x00d2
            if (r14 == r8) goto L_0x00c1
            org.jacoco.agent.rt.internal_8ff85ea.asm.ByteVector r2 = r0.stackMap
            r5 = 255(0xff, float:3.57E-43)
            org.jacoco.agent.rt.internal_8ff85ea.asm.ByteVector r2 = r2.putByte(r5)
            org.jacoco.agent.rt.internal_8ff85ea.asm.ByteVector r2 = r2.putShort(r4)
            r2.putShort(r3)
            r5 = 3
            int r3 = r3 + r5
            r0.writeFrameTypes(r5, r3)
            org.jacoco.agent.rt.internal_8ff85ea.asm.ByteVector r2 = r0.stackMap
            r2.putShort(r1)
            int r1 = r1 + r3
            r0.writeFrameTypes(r3, r1)
            goto L_0x010b
        L_0x00c1:
            r5 = 3
            org.jacoco.agent.rt.internal_8ff85ea.asm.ByteVector r1 = r0.stackMap
            int r2 = r2 + r13
            org.jacoco.agent.rt.internal_8ff85ea.asm.ByteVector r1 = r1.putByte(r2)
            r1.putShort(r4)
            int r7 = r7 + r5
            int r3 = r3 + r5
            r0.writeFrameTypes(r7, r3)
            goto L_0x010b
        L_0x00d2:
            org.jacoco.agent.rt.internal_8ff85ea.asm.ByteVector r1 = r0.stackMap
            org.jacoco.agent.rt.internal_8ff85ea.asm.ByteVector r1 = r1.putByte(r13)
            r1.putShort(r4)
            goto L_0x010b
        L_0x00dc:
            org.jacoco.agent.rt.internal_8ff85ea.asm.ByteVector r1 = r0.stackMap
            int r2 = r2 + r13
            org.jacoco.agent.rt.internal_8ff85ea.asm.ByteVector r1 = r1.putByte(r2)
            r1.putShort(r4)
            goto L_0x010b
        L_0x00e7:
            org.jacoco.agent.rt.internal_8ff85ea.asm.ByteVector r1 = r0.stackMap
            org.jacoco.agent.rt.internal_8ff85ea.asm.ByteVector r1 = r1.putByte(r10)
            r1.putShort(r4)
            int r1 = r3 + 3
            int r3 = r3 + 4
            r0.writeFrameTypes(r1, r3)
            goto L_0x010b
        L_0x00f8:
            org.jacoco.agent.rt.internal_8ff85ea.asm.ByteVector r1 = r0.stackMap
            int r4 = r4 + r11
            r1.putByte(r4)
            int r1 = r3 + 3
            int r3 = r3 + 4
            r0.writeFrameTypes(r1, r3)
            goto L_0x010b
        L_0x0106:
            org.jacoco.agent.rt.internal_8ff85ea.asm.ByteVector r1 = r0.stackMap
            r1.putByte(r4)
        L_0x010b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jacoco.agent.p086rt.internal_8ff85ea.asm.MethodWriter.writeFrame():void");
    }

    private void writeFrameTypes(int i, int i2) {
        while (i < i2) {
            int i3 = this.frame[i];
            int i4 = -268435456 & i3;
            if (i4 == 0) {
                int i5 = i3 & 1048575;
                int i6 = i3 & 267386880;
                if (i6 == 24117248) {
                    ByteVector putByte = this.stackMap.putByte(7);
                    ClassWriter classWriter = this.f6586cw;
                    putByte.putShort(classWriter.newClass(classWriter.typeTable[i5].strVal1));
                } else if (i6 != 25165824) {
                    this.stackMap.putByte(i5);
                } else {
                    this.stackMap.putByte(8).putShort(this.f6586cw.typeTable[i5].intVal);
                }
            } else {
                StringBuilder sb = new StringBuilder();
                int i7 = i4 >> 28;
                while (true) {
                    int i8 = i7 - 1;
                    if (i7 <= 0) {
                        break;
                    }
                    sb.append(VersionRange.LEFT_CLOSED);
                    i7 = i8;
                }
                if ((i3 & 267386880) == 24117248) {
                    sb.append(Matrix.MATRIX_TYPE_RANDOM_LT);
                    sb.append(this.f6586cw.typeTable[i3 & 1048575].strVal1);
                    sb.append(';');
                } else {
                    int i9 = i3 & 15;
                    if (i9 == 1) {
                        sb.append('I');
                    } else if (i9 == 2) {
                        sb.append('F');
                    } else if (i9 != 3) {
                        switch (i9) {
                            case 9:
                                sb.append(Matrix.MATRIX_TYPE_ZERO);
                                break;
                            case 10:
                                sb.append('B');
                                break;
                            case 11:
                                sb.append('C');
                                break;
                            case 12:
                                sb.append('S');
                                break;
                            default:
                                sb.append('J');
                                break;
                        }
                    } else {
                        sb.append('D');
                    }
                }
                this.stackMap.putByte(7).putShort(this.f6586cw.newClass(sb.toString()));
            }
            i++;
        }
    }

    private void writeFrameType(Object obj) {
        if (obj instanceof String) {
            this.stackMap.putByte(7).putShort(this.f6586cw.newClass((String) obj));
        } else if (obj instanceof Integer) {
            this.stackMap.putByte(((Integer) obj).intValue());
        } else {
            this.stackMap.putByte(8).putShort(((Label) obj).position);
        }
    }

    /* access modifiers changed from: package-private */
    public final int getSize() {
        int i;
        if (this.classReaderOffset != 0) {
            return this.classReaderLength + 6;
        }
        if (this.code.length <= 0) {
            i = 8;
        } else if (this.code.length <= 65535) {
            this.f6586cw.newUTF8("Code");
            i = this.code.length + 18 + (this.handlerCount * 8) + 8;
            if (this.localVar != null) {
                this.f6586cw.newUTF8("LocalVariableTable");
                i += this.localVar.length + 8;
            }
            if (this.localVarType != null) {
                this.f6586cw.newUTF8("LocalVariableTypeTable");
                i += this.localVarType.length + 8;
            }
            if (this.lineNumber != null) {
                this.f6586cw.newUTF8("LineNumberTable");
                i += this.lineNumber.length + 8;
            }
            if (this.stackMap != null) {
                this.f6586cw.newUTF8((this.f6586cw.version & 65535) >= 50 ? "StackMapTable" : "StackMap");
                i += this.stackMap.length + 8;
            }
            if (this.ctanns != null) {
                this.f6586cw.newUTF8("RuntimeVisibleTypeAnnotations");
                i += this.ctanns.getSize() + 8;
            }
            if (this.ictanns != null) {
                this.f6586cw.newUTF8("RuntimeInvisibleTypeAnnotations");
                i += this.ictanns.getSize() + 8;
            }
            Attribute attribute = this.cattrs;
            if (attribute != null) {
                i += attribute.getSize(this.f6586cw, this.code.data, this.code.length, this.maxStack, this.maxLocals);
            }
        } else {
            throw new RuntimeException("Method code too large!");
        }
        if (this.exceptionCount > 0) {
            this.f6586cw.newUTF8("Exceptions");
            i += (this.exceptionCount * 2) + 8;
        }
        if ((this.access & 4096) != 0 && ((65535 & this.f6586cw.version) < 49 || (this.access & 262144) != 0)) {
            this.f6586cw.newUTF8("Synthetic");
            i += 6;
        }
        if ((this.access & 131072) != 0) {
            this.f6586cw.newUTF8("Deprecated");
            i += 6;
        }
        if (this.signature != null) {
            this.f6586cw.newUTF8("Signature");
            this.f6586cw.newUTF8(this.signature);
            i += 8;
        }
        if (this.methodParameters != null) {
            this.f6586cw.newUTF8("MethodParameters");
            i += this.methodParameters.length + 7;
        }
        if (this.annd != null) {
            this.f6586cw.newUTF8("AnnotationDefault");
            i += this.annd.length + 6;
        }
        if (this.anns != null) {
            this.f6586cw.newUTF8("RuntimeVisibleAnnotations");
            i += this.anns.getSize() + 8;
        }
        if (this.ianns != null) {
            this.f6586cw.newUTF8("RuntimeInvisibleAnnotations");
            i += this.ianns.getSize() + 8;
        }
        if (this.tanns != null) {
            this.f6586cw.newUTF8("RuntimeVisibleTypeAnnotations");
            i += this.tanns.getSize() + 8;
        }
        if (this.itanns != null) {
            this.f6586cw.newUTF8("RuntimeInvisibleTypeAnnotations");
            i += this.itanns.getSize() + 8;
        }
        if (this.panns != null) {
            this.f6586cw.newUTF8("RuntimeVisibleParameterAnnotations");
            AnnotationWriter[] annotationWriterArr = this.panns;
            int length = i + ((annotationWriterArr.length - this.synthetics) * 2) + 7;
            for (int length2 = annotationWriterArr.length - 1; length2 >= this.synthetics; length2--) {
                AnnotationWriter[] annotationWriterArr2 = this.panns;
                length = i + (annotationWriterArr2[length2] == null ? 0 : annotationWriterArr2[length2].getSize());
            }
        }
        if (this.ipanns != null) {
            this.f6586cw.newUTF8("RuntimeInvisibleParameterAnnotations");
            AnnotationWriter[] annotationWriterArr3 = this.ipanns;
            int length3 = i + ((annotationWriterArr3.length - this.synthetics) * 2) + 7;
            for (int length4 = annotationWriterArr3.length - 1; length4 >= this.synthetics; length4--) {
                AnnotationWriter[] annotationWriterArr4 = this.ipanns;
                length3 = i + (annotationWriterArr4[length4] == null ? 0 : annotationWriterArr4[length4].getSize());
            }
        }
        Attribute attribute2 = this.attrs;
        return attribute2 != null ? i + attribute2.getSize(this.f6586cw, (byte[]) null, 0, -1, -1) : i;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x029a  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x02ea  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x02fd  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x031c  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x0345  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x0366  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x037a  */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x038e  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x03a0  */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x03b2  */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x03c8  */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x03de  */
    /* JADX WARNING: Removed duplicated region for block: B:180:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void put(org.jacoco.agent.p086rt.internal_8ff85ea.asm.ByteVector r23) {
        /*
            r22 = this;
            r0 = r22
            r8 = r23
            int r1 = r0.access
            r9 = 262144(0x40000, float:3.67342E-40)
            r2 = r1 & r9
            int r2 = r2 / 64
            r3 = 917504(0xe0000, float:1.285697E-39)
            r2 = r2 | r3
            int r2 = ~r2
            r1 = r1 & r2
            org.jacoco.agent.rt.internal_8ff85ea.asm.ByteVector r1 = r8.putShort(r1)
            int r2 = r0.name
            org.jacoco.agent.rt.internal_8ff85ea.asm.ByteVector r1 = r1.putShort(r2)
            int r2 = r0.desc
            r1.putShort(r2)
            int r1 = r0.classReaderOffset
            if (r1 == 0) goto L_0x0032
            org.jacoco.agent.rt.internal_8ff85ea.asm.ClassWriter r1 = r0.f6586cw
            org.jacoco.agent.rt.internal_8ff85ea.asm.ClassReader r1 = r1.f6582cr
            byte[] r1 = r1.f6580b
            int r2 = r0.classReaderOffset
            int r3 = r0.classReaderLength
            r8.putByteArray(r1, r2, r3)
            return
        L_0x0032:
            org.jacoco.agent.rt.internal_8ff85ea.asm.ByteVector r1 = r0.code
            int r1 = r1.length
            r10 = 0
            if (r1 <= 0) goto L_0x003b
            r1 = 1
            goto L_0x003c
        L_0x003b:
            r1 = 0
        L_0x003c:
            int r2 = r0.exceptionCount
            if (r2 <= 0) goto L_0x0042
            int r1 = r1 + 1
        L_0x0042:
            int r2 = r0.access
            r2 = r2 & 4096(0x1000, float:5.74E-42)
            r12 = 49
            r13 = 65535(0xffff, float:9.1834E-41)
            if (r2 == 0) goto L_0x005b
            org.jacoco.agent.rt.internal_8ff85ea.asm.ClassWriter r2 = r0.f6586cw
            int r2 = r2.version
            r2 = r2 & r13
            if (r2 < r12) goto L_0x0059
            int r2 = r0.access
            r2 = r2 & r9
            if (r2 == 0) goto L_0x005b
        L_0x0059:
            int r1 = r1 + 1
        L_0x005b:
            int r2 = r0.access
            r14 = 131072(0x20000, float:1.83671E-40)
            r2 = r2 & r14
            if (r2 == 0) goto L_0x0064
            int r1 = r1 + 1
        L_0x0064:
            java.lang.String r2 = r0.signature
            if (r2 == 0) goto L_0x006a
            int r1 = r1 + 1
        L_0x006a:
            org.jacoco.agent.rt.internal_8ff85ea.asm.ByteVector r2 = r0.methodParameters
            if (r2 == 0) goto L_0x0070
            int r1 = r1 + 1
        L_0x0070:
            org.jacoco.agent.rt.internal_8ff85ea.asm.ByteVector r2 = r0.annd
            if (r2 == 0) goto L_0x0076
            int r1 = r1 + 1
        L_0x0076:
            org.jacoco.agent.rt.internal_8ff85ea.asm.AnnotationWriter r2 = r0.anns
            if (r2 == 0) goto L_0x007c
            int r1 = r1 + 1
        L_0x007c:
            org.jacoco.agent.rt.internal_8ff85ea.asm.AnnotationWriter r2 = r0.ianns
            if (r2 == 0) goto L_0x0082
            int r1 = r1 + 1
        L_0x0082:
            org.jacoco.agent.rt.internal_8ff85ea.asm.AnnotationWriter r2 = r0.tanns
            if (r2 == 0) goto L_0x0088
            int r1 = r1 + 1
        L_0x0088:
            org.jacoco.agent.rt.internal_8ff85ea.asm.AnnotationWriter r2 = r0.itanns
            if (r2 == 0) goto L_0x008e
            int r1 = r1 + 1
        L_0x008e:
            org.jacoco.agent.rt.internal_8ff85ea.asm.AnnotationWriter[] r2 = r0.panns
            if (r2 == 0) goto L_0x0094
            int r1 = r1 + 1
        L_0x0094:
            org.jacoco.agent.rt.internal_8ff85ea.asm.AnnotationWriter[] r2 = r0.ipanns
            if (r2 == 0) goto L_0x009a
            int r1 = r1 + 1
        L_0x009a:
            org.jacoco.agent.rt.internal_8ff85ea.asm.Attribute r2 = r0.attrs
            if (r2 == 0) goto L_0x00a3
            int r2 = r2.getCount()
            int r1 = r1 + r2
        L_0x00a3:
            r8.putShort(r1)
            org.jacoco.agent.rt.internal_8ff85ea.asm.ByteVector r1 = r0.code
            int r1 = r1.length
            java.lang.String r15 = "RuntimeInvisibleTypeAnnotations"
            java.lang.String r7 = "RuntimeVisibleTypeAnnotations"
            r6 = 2
            if (r1 <= 0) goto L_0x0294
            org.jacoco.agent.rt.internal_8ff85ea.asm.ByteVector r1 = r0.code
            int r1 = r1.length
            int r1 = r1 + 12
            int r2 = r0.handlerCount
            int r2 = r2 * 8
            int r1 = r1 + r2
            org.jacoco.agent.rt.internal_8ff85ea.asm.ByteVector r2 = r0.localVar
            if (r2 == 0) goto L_0x00c5
            int r2 = r2.length
            int r2 = r2 + 8
            int r1 = r1 + r2
        L_0x00c5:
            org.jacoco.agent.rt.internal_8ff85ea.asm.ByteVector r2 = r0.localVarType
            if (r2 == 0) goto L_0x00ce
            int r2 = r2.length
            int r2 = r2 + 8
            int r1 = r1 + r2
        L_0x00ce:
            org.jacoco.agent.rt.internal_8ff85ea.asm.ByteVector r2 = r0.lineNumber
            if (r2 == 0) goto L_0x00d7
            int r2 = r2.length
            int r2 = r2 + 8
            int r1 = r1 + r2
        L_0x00d7:
            org.jacoco.agent.rt.internal_8ff85ea.asm.ByteVector r2 = r0.stackMap
            if (r2 == 0) goto L_0x00e0
            int r2 = r2.length
            int r2 = r2 + 8
            int r1 = r1 + r2
        L_0x00e0:
            org.jacoco.agent.rt.internal_8ff85ea.asm.AnnotationWriter r2 = r0.ctanns
            if (r2 == 0) goto L_0x00eb
            int r2 = r2.getSize()
            int r2 = r2 + 8
            int r1 = r1 + r2
        L_0x00eb:
            org.jacoco.agent.rt.internal_8ff85ea.asm.AnnotationWriter r2 = r0.ictanns
            if (r2 == 0) goto L_0x00f6
            int r2 = r2.getSize()
            int r2 = r2 + 8
            int r1 = r1 + r2
        L_0x00f6:
            org.jacoco.agent.rt.internal_8ff85ea.asm.Attribute r2 = r0.cattrs
            if (r2 == 0) goto L_0x0119
            org.jacoco.agent.rt.internal_8ff85ea.asm.ClassWriter r3 = r0.f6586cw
            org.jacoco.agent.rt.internal_8ff85ea.asm.ByteVector r4 = r0.code
            byte[] r4 = r4.data
            org.jacoco.agent.rt.internal_8ff85ea.asm.ByteVector r5 = r0.code
            int r5 = r5.length
            int r11 = r0.maxStack
            int r14 = r0.maxLocals
            r16 = r2
            r17 = r3
            r18 = r4
            r19 = r5
            r20 = r11
            r21 = r14
            int r2 = r16.getSize(r17, r18, r19, r20, r21)
            int r1 = r1 + r2
        L_0x0119:
            org.jacoco.agent.rt.internal_8ff85ea.asm.ClassWriter r2 = r0.f6586cw
            java.lang.String r3 = "Code"
            int r2 = r2.newUTF8(r3)
            org.jacoco.agent.rt.internal_8ff85ea.asm.ByteVector r2 = r8.putShort(r2)
            r2.putInt(r1)
            int r1 = r0.maxStack
            org.jacoco.agent.rt.internal_8ff85ea.asm.ByteVector r1 = r8.putShort(r1)
            int r2 = r0.maxLocals
            r1.putShort(r2)
            org.jacoco.agent.rt.internal_8ff85ea.asm.ByteVector r1 = r0.code
            int r1 = r1.length
            org.jacoco.agent.rt.internal_8ff85ea.asm.ByteVector r1 = r8.putInt(r1)
            org.jacoco.agent.rt.internal_8ff85ea.asm.ByteVector r2 = r0.code
            byte[] r2 = r2.data
            org.jacoco.agent.rt.internal_8ff85ea.asm.ByteVector r3 = r0.code
            int r3 = r3.length
            r1.putByteArray(r2, r10, r3)
            int r1 = r0.handlerCount
            r8.putShort(r1)
            int r1 = r0.handlerCount
            if (r1 <= 0) goto L_0x0173
            org.jacoco.agent.rt.internal_8ff85ea.asm.Handler r1 = r0.firstHandler
        L_0x0151:
            if (r1 == 0) goto L_0x0173
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label r2 = r1.start
            int r2 = r2.position
            org.jacoco.agent.rt.internal_8ff85ea.asm.ByteVector r2 = r8.putShort(r2)
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label r3 = r1.end
            int r3 = r3.position
            org.jacoco.agent.rt.internal_8ff85ea.asm.ByteVector r2 = r2.putShort(r3)
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label r3 = r1.handler
            int r3 = r3.position
            org.jacoco.agent.rt.internal_8ff85ea.asm.ByteVector r2 = r2.putShort(r3)
            int r3 = r1.type
            r2.putShort(r3)
            org.jacoco.agent.rt.internal_8ff85ea.asm.Handler r1 = r1.next
            goto L_0x0151
        L_0x0173:
            org.jacoco.agent.rt.internal_8ff85ea.asm.ByteVector r1 = r0.localVar
            if (r1 == 0) goto L_0x0179
            r1 = 1
            goto L_0x017a
        L_0x0179:
            r1 = 0
        L_0x017a:
            org.jacoco.agent.rt.internal_8ff85ea.asm.ByteVector r2 = r0.localVarType
            if (r2 == 0) goto L_0x0180
            int r1 = r1 + 1
        L_0x0180:
            org.jacoco.agent.rt.internal_8ff85ea.asm.ByteVector r2 = r0.lineNumber
            if (r2 == 0) goto L_0x0186
            int r1 = r1 + 1
        L_0x0186:
            org.jacoco.agent.rt.internal_8ff85ea.asm.ByteVector r2 = r0.stackMap
            if (r2 == 0) goto L_0x018c
            int r1 = r1 + 1
        L_0x018c:
            org.jacoco.agent.rt.internal_8ff85ea.asm.AnnotationWriter r2 = r0.ctanns
            if (r2 == 0) goto L_0x0192
            int r1 = r1 + 1
        L_0x0192:
            org.jacoco.agent.rt.internal_8ff85ea.asm.AnnotationWriter r2 = r0.ictanns
            if (r2 == 0) goto L_0x0198
            int r1 = r1 + 1
        L_0x0198:
            org.jacoco.agent.rt.internal_8ff85ea.asm.Attribute r2 = r0.cattrs
            if (r2 == 0) goto L_0x01a1
            int r2 = r2.getCount()
            int r1 = r1 + r2
        L_0x01a1:
            r8.putShort(r1)
            org.jacoco.agent.rt.internal_8ff85ea.asm.ByteVector r1 = r0.localVar
            if (r1 == 0) goto L_0x01cc
            org.jacoco.agent.rt.internal_8ff85ea.asm.ClassWriter r1 = r0.f6586cw
            java.lang.String r2 = "LocalVariableTable"
            int r1 = r1.newUTF8(r2)
            r8.putShort(r1)
            org.jacoco.agent.rt.internal_8ff85ea.asm.ByteVector r1 = r0.localVar
            int r1 = r1.length
            int r1 = r1 + r6
            org.jacoco.agent.rt.internal_8ff85ea.asm.ByteVector r1 = r8.putInt(r1)
            int r2 = r0.localVarCount
            r1.putShort(r2)
            org.jacoco.agent.rt.internal_8ff85ea.asm.ByteVector r1 = r0.localVar
            byte[] r1 = r1.data
            org.jacoco.agent.rt.internal_8ff85ea.asm.ByteVector r2 = r0.localVar
            int r2 = r2.length
            r8.putByteArray(r1, r10, r2)
        L_0x01cc:
            org.jacoco.agent.rt.internal_8ff85ea.asm.ByteVector r1 = r0.localVarType
            if (r1 == 0) goto L_0x01f4
            org.jacoco.agent.rt.internal_8ff85ea.asm.ClassWriter r1 = r0.f6586cw
            java.lang.String r2 = "LocalVariableTypeTable"
            int r1 = r1.newUTF8(r2)
            r8.putShort(r1)
            org.jacoco.agent.rt.internal_8ff85ea.asm.ByteVector r1 = r0.localVarType
            int r1 = r1.length
            int r1 = r1 + r6
            org.jacoco.agent.rt.internal_8ff85ea.asm.ByteVector r1 = r8.putInt(r1)
            int r2 = r0.localVarTypeCount
            r1.putShort(r2)
            org.jacoco.agent.rt.internal_8ff85ea.asm.ByteVector r1 = r0.localVarType
            byte[] r1 = r1.data
            org.jacoco.agent.rt.internal_8ff85ea.asm.ByteVector r2 = r0.localVarType
            int r2 = r2.length
            r8.putByteArray(r1, r10, r2)
        L_0x01f4:
            org.jacoco.agent.rt.internal_8ff85ea.asm.ByteVector r1 = r0.lineNumber
            if (r1 == 0) goto L_0x021c
            org.jacoco.agent.rt.internal_8ff85ea.asm.ClassWriter r1 = r0.f6586cw
            java.lang.String r2 = "LineNumberTable"
            int r1 = r1.newUTF8(r2)
            r8.putShort(r1)
            org.jacoco.agent.rt.internal_8ff85ea.asm.ByteVector r1 = r0.lineNumber
            int r1 = r1.length
            int r1 = r1 + r6
            org.jacoco.agent.rt.internal_8ff85ea.asm.ByteVector r1 = r8.putInt(r1)
            int r2 = r0.lineNumberCount
            r1.putShort(r2)
            org.jacoco.agent.rt.internal_8ff85ea.asm.ByteVector r1 = r0.lineNumber
            byte[] r1 = r1.data
            org.jacoco.agent.rt.internal_8ff85ea.asm.ByteVector r2 = r0.lineNumber
            int r2 = r2.length
            r8.putByteArray(r1, r10, r2)
        L_0x021c:
            org.jacoco.agent.rt.internal_8ff85ea.asm.ByteVector r1 = r0.stackMap
            if (r1 == 0) goto L_0x0255
            org.jacoco.agent.rt.internal_8ff85ea.asm.ClassWriter r1 = r0.f6586cw
            int r1 = r1.version
            r1 = r1 & r13
            r2 = 50
            if (r1 < r2) goto L_0x022b
            r1 = 1
            goto L_0x022c
        L_0x022b:
            r1 = 0
        L_0x022c:
            org.jacoco.agent.rt.internal_8ff85ea.asm.ClassWriter r2 = r0.f6586cw
            if (r1 == 0) goto L_0x0233
            java.lang.String r1 = "StackMapTable"
            goto L_0x0235
        L_0x0233:
            java.lang.String r1 = "StackMap"
        L_0x0235:
            int r1 = r2.newUTF8(r1)
            r8.putShort(r1)
            org.jacoco.agent.rt.internal_8ff85ea.asm.ByteVector r1 = r0.stackMap
            int r1 = r1.length
            int r1 = r1 + r6
            org.jacoco.agent.rt.internal_8ff85ea.asm.ByteVector r1 = r8.putInt(r1)
            int r2 = r0.frameCount
            r1.putShort(r2)
            org.jacoco.agent.rt.internal_8ff85ea.asm.ByteVector r1 = r0.stackMap
            byte[] r1 = r1.data
            org.jacoco.agent.rt.internal_8ff85ea.asm.ByteVector r2 = r0.stackMap
            int r2 = r2.length
            r8.putByteArray(r1, r10, r2)
        L_0x0255:
            org.jacoco.agent.rt.internal_8ff85ea.asm.AnnotationWriter r1 = r0.ctanns
            if (r1 == 0) goto L_0x0267
            org.jacoco.agent.rt.internal_8ff85ea.asm.ClassWriter r1 = r0.f6586cw
            int r1 = r1.newUTF8(r7)
            r8.putShort(r1)
            org.jacoco.agent.rt.internal_8ff85ea.asm.AnnotationWriter r1 = r0.ctanns
            r1.put(r8)
        L_0x0267:
            org.jacoco.agent.rt.internal_8ff85ea.asm.AnnotationWriter r1 = r0.ictanns
            if (r1 == 0) goto L_0x0279
            org.jacoco.agent.rt.internal_8ff85ea.asm.ClassWriter r1 = r0.f6586cw
            int r1 = r1.newUTF8(r15)
            r8.putShort(r1)
            org.jacoco.agent.rt.internal_8ff85ea.asm.AnnotationWriter r1 = r0.ictanns
            r1.put(r8)
        L_0x0279:
            org.jacoco.agent.rt.internal_8ff85ea.asm.Attribute r1 = r0.cattrs
            if (r1 == 0) goto L_0x0294
            org.jacoco.agent.rt.internal_8ff85ea.asm.ClassWriter r2 = r0.f6586cw
            org.jacoco.agent.rt.internal_8ff85ea.asm.ByteVector r3 = r0.code
            byte[] r3 = r3.data
            org.jacoco.agent.rt.internal_8ff85ea.asm.ByteVector r4 = r0.code
            int r4 = r4.length
            int r5 = r0.maxLocals
            int r11 = r0.maxStack
            r14 = 2
            r6 = r11
            r11 = r7
            r7 = r23
            r1.put(r2, r3, r4, r5, r6, r7)
            goto L_0x0296
        L_0x0294:
            r11 = r7
            r14 = 2
        L_0x0296:
            int r1 = r0.exceptionCount
            if (r1 <= 0) goto L_0x02c2
            org.jacoco.agent.rt.internal_8ff85ea.asm.ClassWriter r1 = r0.f6586cw
            java.lang.String r2 = "Exceptions"
            int r1 = r1.newUTF8(r2)
            org.jacoco.agent.rt.internal_8ff85ea.asm.ByteVector r1 = r8.putShort(r1)
            int r2 = r0.exceptionCount
            int r2 = r2 * 2
            int r2 = r2 + r14
            r1.putInt(r2)
            int r1 = r0.exceptionCount
            r8.putShort(r1)
            r1 = 0
        L_0x02b4:
            int r2 = r0.exceptionCount
            if (r1 >= r2) goto L_0x02c2
            int[] r2 = r0.exceptions
            r2 = r2[r1]
            r8.putShort(r2)
            int r1 = r1 + 1
            goto L_0x02b4
        L_0x02c2:
            int r1 = r0.access
            r1 = r1 & 4096(0x1000, float:5.74E-42)
            if (r1 == 0) goto L_0x02e3
            org.jacoco.agent.rt.internal_8ff85ea.asm.ClassWriter r1 = r0.f6586cw
            int r1 = r1.version
            r1 = r1 & r13
            if (r1 < r12) goto L_0x02d4
            int r1 = r0.access
            r1 = r1 & r9
            if (r1 == 0) goto L_0x02e3
        L_0x02d4:
            org.jacoco.agent.rt.internal_8ff85ea.asm.ClassWriter r1 = r0.f6586cw
            java.lang.String r2 = "Synthetic"
            int r1 = r1.newUTF8(r2)
            org.jacoco.agent.rt.internal_8ff85ea.asm.ByteVector r1 = r8.putShort(r1)
            r1.putInt(r10)
        L_0x02e3:
            int r1 = r0.access
            r2 = 131072(0x20000, float:1.83671E-40)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x02f9
            org.jacoco.agent.rt.internal_8ff85ea.asm.ClassWriter r1 = r0.f6586cw
            java.lang.String r2 = "Deprecated"
            int r1 = r1.newUTF8(r2)
            org.jacoco.agent.rt.internal_8ff85ea.asm.ByteVector r1 = r8.putShort(r1)
            r1.putInt(r10)
        L_0x02f9:
            java.lang.String r1 = r0.signature
            if (r1 == 0) goto L_0x0318
            org.jacoco.agent.rt.internal_8ff85ea.asm.ClassWriter r1 = r0.f6586cw
            java.lang.String r2 = "Signature"
            int r1 = r1.newUTF8(r2)
            org.jacoco.agent.rt.internal_8ff85ea.asm.ByteVector r1 = r8.putShort(r1)
            org.jacoco.agent.rt.internal_8ff85ea.asm.ByteVector r1 = r1.putInt(r14)
            org.jacoco.agent.rt.internal_8ff85ea.asm.ClassWriter r2 = r0.f6586cw
            java.lang.String r3 = r0.signature
            int r2 = r2.newUTF8(r3)
            r1.putShort(r2)
        L_0x0318:
            org.jacoco.agent.rt.internal_8ff85ea.asm.ByteVector r1 = r0.methodParameters
            if (r1 == 0) goto L_0x0341
            org.jacoco.agent.rt.internal_8ff85ea.asm.ClassWriter r1 = r0.f6586cw
            java.lang.String r2 = "MethodParameters"
            int r1 = r1.newUTF8(r2)
            r8.putShort(r1)
            org.jacoco.agent.rt.internal_8ff85ea.asm.ByteVector r1 = r0.methodParameters
            int r1 = r1.length
            r2 = 1
            int r1 = r1 + r2
            org.jacoco.agent.rt.internal_8ff85ea.asm.ByteVector r1 = r8.putInt(r1)
            int r2 = r0.methodParametersCount
            r1.putByte(r2)
            org.jacoco.agent.rt.internal_8ff85ea.asm.ByteVector r1 = r0.methodParameters
            byte[] r1 = r1.data
            org.jacoco.agent.rt.internal_8ff85ea.asm.ByteVector r2 = r0.methodParameters
            int r2 = r2.length
            r8.putByteArray(r1, r10, r2)
        L_0x0341:
            org.jacoco.agent.rt.internal_8ff85ea.asm.ByteVector r1 = r0.annd
            if (r1 == 0) goto L_0x0362
            org.jacoco.agent.rt.internal_8ff85ea.asm.ClassWriter r1 = r0.f6586cw
            java.lang.String r2 = "AnnotationDefault"
            int r1 = r1.newUTF8(r2)
            r8.putShort(r1)
            org.jacoco.agent.rt.internal_8ff85ea.asm.ByteVector r1 = r0.annd
            int r1 = r1.length
            r8.putInt(r1)
            org.jacoco.agent.rt.internal_8ff85ea.asm.ByteVector r1 = r0.annd
            byte[] r1 = r1.data
            org.jacoco.agent.rt.internal_8ff85ea.asm.ByteVector r2 = r0.annd
            int r2 = r2.length
            r8.putByteArray(r1, r10, r2)
        L_0x0362:
            org.jacoco.agent.rt.internal_8ff85ea.asm.AnnotationWriter r1 = r0.anns
            if (r1 == 0) goto L_0x0376
            org.jacoco.agent.rt.internal_8ff85ea.asm.ClassWriter r1 = r0.f6586cw
            java.lang.String r2 = "RuntimeVisibleAnnotations"
            int r1 = r1.newUTF8(r2)
            r8.putShort(r1)
            org.jacoco.agent.rt.internal_8ff85ea.asm.AnnotationWriter r1 = r0.anns
            r1.put(r8)
        L_0x0376:
            org.jacoco.agent.rt.internal_8ff85ea.asm.AnnotationWriter r1 = r0.ianns
            if (r1 == 0) goto L_0x038a
            org.jacoco.agent.rt.internal_8ff85ea.asm.ClassWriter r1 = r0.f6586cw
            java.lang.String r2 = "RuntimeInvisibleAnnotations"
            int r1 = r1.newUTF8(r2)
            r8.putShort(r1)
            org.jacoco.agent.rt.internal_8ff85ea.asm.AnnotationWriter r1 = r0.ianns
            r1.put(r8)
        L_0x038a:
            org.jacoco.agent.rt.internal_8ff85ea.asm.AnnotationWriter r1 = r0.tanns
            if (r1 == 0) goto L_0x039c
            org.jacoco.agent.rt.internal_8ff85ea.asm.ClassWriter r1 = r0.f6586cw
            int r1 = r1.newUTF8(r11)
            r8.putShort(r1)
            org.jacoco.agent.rt.internal_8ff85ea.asm.AnnotationWriter r1 = r0.tanns
            r1.put(r8)
        L_0x039c:
            org.jacoco.agent.rt.internal_8ff85ea.asm.AnnotationWriter r1 = r0.itanns
            if (r1 == 0) goto L_0x03ae
            org.jacoco.agent.rt.internal_8ff85ea.asm.ClassWriter r1 = r0.f6586cw
            int r1 = r1.newUTF8(r15)
            r8.putShort(r1)
            org.jacoco.agent.rt.internal_8ff85ea.asm.AnnotationWriter r1 = r0.itanns
            r1.put(r8)
        L_0x03ae:
            org.jacoco.agent.rt.internal_8ff85ea.asm.AnnotationWriter[] r1 = r0.panns
            if (r1 == 0) goto L_0x03c4
            org.jacoco.agent.rt.internal_8ff85ea.asm.ClassWriter r1 = r0.f6586cw
            java.lang.String r2 = "RuntimeVisibleParameterAnnotations"
            int r1 = r1.newUTF8(r2)
            r8.putShort(r1)
            org.jacoco.agent.rt.internal_8ff85ea.asm.AnnotationWriter[] r1 = r0.panns
            int r2 = r0.synthetics
            org.jacoco.agent.p086rt.internal_8ff85ea.asm.AnnotationWriter.put(r1, r2, r8)
        L_0x03c4:
            org.jacoco.agent.rt.internal_8ff85ea.asm.AnnotationWriter[] r1 = r0.ipanns
            if (r1 == 0) goto L_0x03da
            org.jacoco.agent.rt.internal_8ff85ea.asm.ClassWriter r1 = r0.f6586cw
            java.lang.String r2 = "RuntimeInvisibleParameterAnnotations"
            int r1 = r1.newUTF8(r2)
            r8.putShort(r1)
            org.jacoco.agent.rt.internal_8ff85ea.asm.AnnotationWriter[] r1 = r0.ipanns
            int r2 = r0.synthetics
            org.jacoco.agent.p086rt.internal_8ff85ea.asm.AnnotationWriter.put(r1, r2, r8)
        L_0x03da:
            org.jacoco.agent.rt.internal_8ff85ea.asm.Attribute r1 = r0.attrs
            if (r1 == 0) goto L_0x03e9
            org.jacoco.agent.rt.internal_8ff85ea.asm.ClassWriter r2 = r0.f6586cw
            r3 = 0
            r4 = 0
            r5 = -1
            r6 = -1
            r7 = r23
            r1.put(r2, r3, r4, r5, r6, r7)
        L_0x03e9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jacoco.agent.p086rt.internal_8ff85ea.asm.MethodWriter.put(org.jacoco.agent.rt.internal_8ff85ea.asm.ByteVector):void");
    }
}
