package org.jacoco.agent.p086rt.internal_8ff85ea.asm;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.asm.Frame */
class Frame {
    static final int ARRAY_OF = 268435456;
    static final int BASE = 16777216;
    static final int BASE_KIND = 267386880;
    static final int BASE_VALUE = 1048575;
    static final int BOOLEAN = 16777225;
    static final int BYTE = 16777226;
    static final int CHAR = 16777227;
    static final int DIM = -268435456;
    static final int DOUBLE = 16777219;
    static final int ELEMENT_OF = -268435456;
    static final int FLOAT = 16777218;
    static final int INTEGER = 16777217;
    static final int KIND = 251658240;
    private static final int LOCAL = 33554432;
    static final int LONG = 16777220;
    static final int NULL = 16777221;
    static final int OBJECT = 24117248;
    static final int SHORT = 16777228;
    static final int[] SIZE;
    private static final int STACK = 50331648;
    static final int TOP = 16777216;
    static final int TOP_IF_LONG_OR_DOUBLE = 8388608;
    static final int UNINITIALIZED = 25165824;
    static final int UNINITIALIZED_THIS = 16777222;
    static final int VALUE = 8388607;
    private int initializationCount;
    private int[] initializations;
    int[] inputLocals;
    int[] inputStack;
    private int[] outputLocals;
    private int[] outputStack;
    int outputStackTop;
    Label owner;

    Frame() {
    }

    static {
        int[] iArr = new int[202];
        for (int i = 0; i < 202; i++) {
            iArr[i] = "EFFFFFFFFGGFFFGGFFFEEFGFGFEEEEEEEEEEEEEEEEEEEEDEDEDDDDDCDCDEEEEEEEEEEEEEEEEEEEEBABABBBBDCFFFGGGEDCDCDCDCDCDCDCDCDCDCEEEEDDDDDDDCDCDCEFEFDDEEFFDEDEEEBDDBBDDDDDDCCCCCCCCEFEDDDCDCDEEEEEEEEEEFEEEEEEDDEEDDEE".charAt(i) - 'E';
        }
        SIZE = iArr;
    }

    /* access modifiers changed from: package-private */
    public final void set(ClassWriter classWriter, int i, Object[] objArr, int i2, Object[] objArr2) {
        for (int convert = convert(classWriter, i, objArr, this.inputLocals); convert < objArr.length; convert++) {
            this.inputLocals[convert] = 16777216;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            if (objArr2[i4] == Opcodes.LONG || objArr2[i4] == Opcodes.DOUBLE) {
                i3++;
            }
        }
        int[] iArr = new int[(i3 + i2)];
        this.inputStack = iArr;
        convert(classWriter, i2, objArr2, iArr);
        this.outputStackTop = 0;
        this.initializationCount = 0;
    }

    private static int convert(ClassWriter classWriter, int i, Object[] objArr, int[] iArr) {
        int i2;
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            if (objArr[i4] instanceof Integer) {
                i2 = i3 + 1;
                iArr[i3] = objArr[i4].intValue() | 16777216;
                if (objArr[i4] == Opcodes.LONG || objArr[i4] == Opcodes.DOUBLE) {
                    i3 = i2 + 1;
                    iArr[i2] = 16777216;
                }
            } else if (objArr[i4] instanceof String) {
                i2 = i3 + 1;
                iArr[i3] = type(classWriter, Type.getObjectType(objArr[i4]).getDescriptor());
            } else {
                i2 = i3 + 1;
                iArr[i3] = UNINITIALIZED | classWriter.addUninitializedType("", objArr[i4].position);
            }
            i3 = i2;
        }
        return i3;
    }

    /* access modifiers changed from: package-private */
    public final void set(Frame frame) {
        this.inputLocals = frame.inputLocals;
        this.inputStack = frame.inputStack;
        this.outputLocals = frame.outputLocals;
        this.outputStack = frame.outputStack;
        this.outputStackTop = frame.outputStackTop;
        this.initializationCount = frame.initializationCount;
        this.initializations = frame.initializations;
    }

    private int get(int i) {
        int[] iArr = this.outputLocals;
        if (iArr == null || i >= iArr.length) {
            return i | 33554432;
        }
        int i2 = iArr[i];
        if (i2 != 0) {
            return i2;
        }
        int i3 = i | 33554432;
        iArr[i] = i3;
        return i3;
    }

    private void set(int i, int i2) {
        if (this.outputLocals == null) {
            this.outputLocals = new int[10];
        }
        int length = this.outputLocals.length;
        if (i >= length) {
            int[] iArr = new int[Math.max(i + 1, length * 2)];
            System.arraycopy(this.outputLocals, 0, iArr, 0, length);
            this.outputLocals = iArr;
        }
        this.outputLocals[i] = i2;
    }

    private void push(int i) {
        if (this.outputStack == null) {
            this.outputStack = new int[10];
        }
        int length = this.outputStack.length;
        int i2 = this.outputStackTop;
        if (i2 >= length) {
            int[] iArr = new int[Math.max(i2 + 1, length * 2)];
            System.arraycopy(this.outputStack, 0, iArr, 0, length);
            this.outputStack = iArr;
        }
        int[] iArr2 = this.outputStack;
        int i3 = this.outputStackTop;
        this.outputStackTop = i3 + 1;
        iArr2[i3] = i;
        int i4 = this.owner.inputStackTop + this.outputStackTop;
        if (i4 > this.owner.outputStackMax) {
            this.owner.outputStackMax = i4;
        }
    }

    private void push(ClassWriter classWriter, String str) {
        int type = type(classWriter, str);
        if (type != 0) {
            push(type);
            if (type == LONG || type == DOUBLE) {
                push(16777216);
            }
        }
    }

    private static int type(ClassWriter classWriter, String str) {
        int indexOf = str.charAt(0) == '(' ? str.indexOf(41) + 1 : 0;
        char charAt = str.charAt(indexOf);
        int i = FLOAT;
        if (charAt == 'F') {
            return FLOAT;
        }
        if (charAt == 'L') {
            return classWriter.addType(str.substring(indexOf + 1, str.length() - 1)) | OBJECT;
        }
        if (charAt != 'S') {
            if (charAt == 'V') {
                return 0;
            }
            if (!(charAt == 'Z' || charAt == 'I')) {
                if (charAt == 'J') {
                    return LONG;
                }
                switch (charAt) {
                    case 'B':
                    case 'C':
                        break;
                    case 'D':
                        return DOUBLE;
                    default:
                        int i2 = indexOf + 1;
                        while (str.charAt(i2) == '[') {
                            i2++;
                        }
                        char charAt2 = str.charAt(i2);
                        if (charAt2 != 'F') {
                            if (charAt2 == 'S') {
                                i = SHORT;
                            } else if (charAt2 == 'Z') {
                                i = BOOLEAN;
                            } else if (charAt2 == 'I') {
                                i = INTEGER;
                            } else if (charAt2 != 'J') {
                                switch (charAt2) {
                                    case 'B':
                                        i = BYTE;
                                        break;
                                    case 'C':
                                        i = CHAR;
                                        break;
                                    case 'D':
                                        i = DOUBLE;
                                        break;
                                    default:
                                        i = classWriter.addType(str.substring(i2 + 1, str.length() - 1)) | OBJECT;
                                        break;
                                }
                            } else {
                                i = LONG;
                            }
                        }
                        return ((i2 - indexOf) << 28) | i;
                }
            }
        }
        return INTEGER;
    }

    private int pop() {
        int i = this.outputStackTop;
        if (i > 0) {
            int[] iArr = this.outputStack;
            int i2 = i - 1;
            this.outputStackTop = i2;
            return iArr[i2];
        }
        Label label = this.owner;
        int i3 = label.inputStackTop - 1;
        label.inputStackTop = i3;
        return 50331648 | (-i3);
    }

    private void pop(int i) {
        int i2 = this.outputStackTop;
        if (i2 >= i) {
            this.outputStackTop = i2 - i;
            return;
        }
        this.owner.inputStackTop -= i - this.outputStackTop;
        this.outputStackTop = 0;
    }

    private void pop(String str) {
        char charAt = str.charAt(0);
        if (charAt == '(') {
            pop((Type.getArgumentsAndReturnSizes(str) >> 2) - 1);
        } else if (charAt == 'J' || charAt == 'D') {
            pop(2);
        } else {
            pop(1);
        }
    }

    private void init(int i) {
        if (this.initializations == null) {
            this.initializations = new int[2];
        }
        int length = this.initializations.length;
        int i2 = this.initializationCount;
        if (i2 >= length) {
            int[] iArr = new int[Math.max(i2 + 1, length * 2)];
            System.arraycopy(this.initializations, 0, iArr, 0, length);
            this.initializations = iArr;
        }
        int[] iArr2 = this.initializations;
        int i3 = this.initializationCount;
        this.initializationCount = i3 + 1;
        iArr2[i3] = i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0051 A[LOOP:0: B:8:0x0026->B:19:0x0051, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0050 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int init(org.jacoco.agent.p086rt.internal_8ff85ea.asm.ClassWriter r7, int r8) {
        /*
            r6 = this;
            r0 = 24117248(0x1700000, float:4.4081038E-38)
            r1 = 16777222(0x1000006, float:2.3509904E-38)
            if (r8 != r1) goto L_0x000f
            java.lang.String r1 = r7.thisName
            int r7 = r7.addType((java.lang.String) r1)
        L_0x000d:
            r7 = r7 | r0
            goto L_0x0025
        L_0x000f:
            r1 = -1048576(0xfffffffffff00000, float:NaN)
            r1 = r1 & r8
            r2 = 25165824(0x1800000, float:4.7019774E-38)
            if (r1 != r2) goto L_0x0054
            org.jacoco.agent.rt.internal_8ff85ea.asm.Item[] r1 = r7.typeTable
            r2 = 1048575(0xfffff, float:1.469367E-39)
            r2 = r2 & r8
            r1 = r1[r2]
            java.lang.String r1 = r1.strVal1
            int r7 = r7.addType((java.lang.String) r1)
            goto L_0x000d
        L_0x0025:
            r0 = 0
        L_0x0026:
            int r1 = r6.initializationCount
            if (r0 >= r1) goto L_0x0054
            int[] r1 = r6.initializations
            r1 = r1[r0]
            r2 = -268435456(0xfffffffff0000000, float:-1.58456325E29)
            r2 = r2 & r1
            r3 = 251658240(0xf000000, float:6.3108872E-30)
            r3 = r3 & r1
            r4 = 33554432(0x2000000, float:9.403955E-38)
            r5 = 8388607(0x7fffff, float:1.1754942E-38)
            if (r3 != r4) goto L_0x0042
            int[] r3 = r6.inputLocals
            r1 = r1 & r5
            r1 = r3[r1]
        L_0x0040:
            int r1 = r1 + r2
            goto L_0x004e
        L_0x0042:
            r4 = 50331648(0x3000000, float:3.761582E-37)
            if (r3 != r4) goto L_0x004e
            int[] r3 = r6.inputStack
            int r4 = r3.length
            r1 = r1 & r5
            int r4 = r4 - r1
            r1 = r3[r4]
            goto L_0x0040
        L_0x004e:
            if (r8 != r1) goto L_0x0051
            return r7
        L_0x0051:
            int r0 = r0 + 1
            goto L_0x0026
        L_0x0054:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jacoco.agent.p086rt.internal_8ff85ea.asm.Frame.init(org.jacoco.agent.rt.internal_8ff85ea.asm.ClassWriter, int):int");
    }

    /* access modifiers changed from: package-private */
    public final void initInputFrame(ClassWriter classWriter, int i, Type[] typeArr, int i2) {
        int i3;
        int[] iArr = new int[i2];
        this.inputLocals = iArr;
        this.inputStack = new int[0];
        int i4 = 1;
        if ((i & 8) != 0) {
            i4 = 0;
        } else if ((i & 524288) == 0) {
            iArr[0] = OBJECT | classWriter.addType(classWriter.thisName);
        } else {
            iArr[0] = UNINITIALIZED_THIS;
        }
        for (Type descriptor : typeArr) {
            int type = type(classWriter, descriptor.getDescriptor());
            int i5 = i3 + 1;
            this.inputLocals[i3] = type;
            if (type == LONG || type == DOUBLE) {
                this.inputLocals[i5] = 16777216;
                i3 = i5 + 1;
            } else {
                i3 = i5;
            }
        }
        while (i3 < i2) {
            this.inputLocals[i3] = 16777216;
            i3++;
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x032b, code lost:
        push(DOUBLE);
        push(16777216);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x0332, code lost:
        push(FLOAT);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x0336, code lost:
        push(LONG);
        push(16777216);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x033d, code lost:
        push(INTEGER);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x02af, code lost:
        pop(2);
        push(DOUBLE);
        push(16777216);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x02c3, code lost:
        pop(2);
        push(LONG);
        push(16777216);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void execute(int r17, int r18, org.jacoco.agent.p086rt.internal_8ff85ea.asm.ClassWriter r19, org.jacoco.agent.p086rt.internal_8ff85ea.asm.Item r20) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = r18
            r3 = r19
            r4 = r20
            r5 = 198(0xc6, float:2.77E-43)
            r6 = 1
            if (r1 == r5) goto L_0x0348
            r5 = 199(0xc7, float:2.79E-43)
            if (r1 == r5) goto L_0x0348
            r5 = 24117248(0x1700000, float:4.4081038E-38)
            r7 = 16777218(0x1000002, float:2.3509893E-38)
            r8 = 16777219(0x1000003, float:2.3509895E-38)
            r9 = 16777217(0x1000001, float:2.350989E-38)
            r10 = 16777220(0x1000004, float:2.3509898E-38)
            r11 = 16777216(0x1000000, float:2.3509887E-38)
            switch(r1) {
                case 0: goto L_0x034b;
                case 1: goto L_0x0341;
                case 2: goto L_0x033d;
                case 3: goto L_0x033d;
                case 4: goto L_0x033d;
                case 5: goto L_0x033d;
                case 6: goto L_0x033d;
                case 7: goto L_0x033d;
                case 8: goto L_0x033d;
                case 9: goto L_0x0336;
                case 10: goto L_0x0336;
                case 11: goto L_0x0332;
                case 12: goto L_0x0332;
                case 13: goto L_0x0332;
                case 14: goto L_0x032b;
                case 15: goto L_0x032b;
                case 16: goto L_0x033d;
                case 17: goto L_0x033d;
                case 18: goto L_0x02e0;
                default: goto L_0x0026;
            }
        L_0x0026:
            switch(r1) {
                case 21: goto L_0x033d;
                case 22: goto L_0x0336;
                case 23: goto L_0x0332;
                case 24: goto L_0x032b;
                case 25: goto L_0x02d7;
                default: goto L_0x0029;
            }
        L_0x0029:
            r12 = 8388608(0x800000, float:1.17549435E-38)
            r13 = 251658240(0xf000000, float:6.3108872E-30)
            switch(r1) {
                case 46: goto L_0x02ce;
                case 47: goto L_0x013e;
                case 48: goto L_0x02ba;
                case 49: goto L_0x0149;
                case 50: goto L_0x02a0;
                case 51: goto L_0x02ce;
                case 52: goto L_0x02ce;
                case 53: goto L_0x02ce;
                case 54: goto L_0x027d;
                case 55: goto L_0x0252;
                case 56: goto L_0x027d;
                case 57: goto L_0x0252;
                case 58: goto L_0x027d;
                default: goto L_0x0030;
            }
        L_0x0030:
            r12 = 3
            r13 = 91
            r15 = 0
            r14 = 4
            switch(r1) {
                case 79: goto L_0x024d;
                case 80: goto L_0x0248;
                case 81: goto L_0x024d;
                case 82: goto L_0x0248;
                case 83: goto L_0x024d;
                case 84: goto L_0x024d;
                case 85: goto L_0x024d;
                case 86: goto L_0x024d;
                case 87: goto L_0x0348;
                case 88: goto L_0x0242;
                case 89: goto L_0x0236;
                case 90: goto L_0x0223;
                case 91: goto L_0x0209;
                case 92: goto L_0x01f3;
                case 93: goto L_0x01d6;
                case 94: goto L_0x01b2;
                case 95: goto L_0x01a2;
                case 96: goto L_0x0199;
                case 97: goto L_0x018e;
                case 98: goto L_0x0185;
                case 99: goto L_0x017a;
                case 100: goto L_0x0199;
                case 101: goto L_0x018e;
                case 102: goto L_0x0185;
                case 103: goto L_0x017a;
                case 104: goto L_0x0199;
                case 105: goto L_0x018e;
                case 106: goto L_0x0185;
                case 107: goto L_0x017a;
                case 108: goto L_0x0199;
                case 109: goto L_0x018e;
                case 110: goto L_0x0185;
                case 111: goto L_0x017a;
                case 112: goto L_0x0199;
                case 113: goto L_0x018e;
                case 114: goto L_0x0185;
                case 115: goto L_0x017a;
                case 116: goto L_0x034b;
                case 117: goto L_0x034b;
                case 118: goto L_0x034b;
                case 119: goto L_0x034b;
                case 120: goto L_0x0199;
                case 121: goto L_0x016f;
                case 122: goto L_0x0199;
                case 123: goto L_0x016f;
                case 124: goto L_0x0199;
                case 125: goto L_0x016f;
                case 126: goto L_0x0199;
                case 127: goto L_0x018e;
                case 128: goto L_0x0199;
                case 129: goto L_0x018e;
                case 130: goto L_0x0199;
                case 131: goto L_0x018e;
                case 132: goto L_0x016a;
                case 133: goto L_0x015f;
                case 134: goto L_0x0157;
                case 135: goto L_0x014c;
                case 136: goto L_0x0199;
                case 137: goto L_0x0185;
                case 138: goto L_0x0149;
                case 139: goto L_0x0141;
                case 140: goto L_0x015f;
                case 141: goto L_0x014c;
                case 142: goto L_0x0199;
                case 143: goto L_0x013e;
                case 144: goto L_0x0185;
                case 145: goto L_0x034b;
                case 146: goto L_0x034b;
                case 147: goto L_0x034b;
                case 148: goto L_0x0136;
                case 149: goto L_0x0199;
                case 150: goto L_0x0199;
                case 151: goto L_0x0136;
                case 152: goto L_0x0136;
                case 153: goto L_0x0348;
                case 154: goto L_0x0348;
                case 155: goto L_0x0348;
                case 156: goto L_0x0348;
                case 157: goto L_0x0348;
                case 158: goto L_0x0348;
                case 159: goto L_0x0242;
                case 160: goto L_0x0242;
                case 161: goto L_0x0242;
                case 162: goto L_0x0242;
                case 163: goto L_0x0242;
                case 164: goto L_0x0242;
                case 165: goto L_0x0242;
                case 166: goto L_0x0242;
                case 167: goto L_0x034b;
                case 168: goto L_0x012e;
                case 169: goto L_0x012e;
                case 170: goto L_0x0348;
                case 171: goto L_0x0348;
                case 172: goto L_0x0348;
                case 173: goto L_0x0242;
                case 174: goto L_0x0348;
                case 175: goto L_0x0242;
                case 176: goto L_0x0348;
                case 177: goto L_0x034b;
                case 178: goto L_0x0127;
                case 179: goto L_0x0120;
                case 180: goto L_0x0116;
                case 181: goto L_0x010c;
                case 182: goto L_0x00e7;
                case 183: goto L_0x00e7;
                case 184: goto L_0x00e7;
                case 185: goto L_0x00e7;
                case 186: goto L_0x00db;
                case 187: goto L_0x00cd;
                case 188: goto L_0x0087;
                case 189: goto L_0x005c;
                case 190: goto L_0x0141;
                case 191: goto L_0x0348;
                case 192: goto L_0x0042;
                case 193: goto L_0x0141;
                case 194: goto L_0x0348;
                case 195: goto L_0x0348;
                default: goto L_0x0038;
            }
        L_0x0038:
            r0.pop((int) r2)
            java.lang.String r1 = r4.strVal1
            r0.push(r3, r1)
            goto L_0x034b
        L_0x0042:
            java.lang.String r1 = r4.strVal1
            r16.pop()
            char r2 = r1.charAt(r15)
            if (r2 != r13) goto L_0x0052
            r0.push(r3, r1)
            goto L_0x034b
        L_0x0052:
            int r1 = r3.addType((java.lang.String) r1)
            r1 = r1 | r5
            r0.push(r1)
            goto L_0x034b
        L_0x005c:
            java.lang.String r1 = r4.strVal1
            r16.pop()
            char r2 = r1.charAt(r15)
            if (r2 != r13) goto L_0x007b
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r13)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r0.push(r3, r1)
            goto L_0x034b
        L_0x007b:
            r2 = 292552704(0x11700000, float:1.8932662E-28)
            int r1 = r3.addType((java.lang.String) r1)
            r1 = r1 | r2
            r0.push(r1)
            goto L_0x034b
        L_0x0087:
            r16.pop()
            switch(r2) {
                case 4: goto L_0x00c5;
                case 5: goto L_0x00bd;
                case 6: goto L_0x00b5;
                case 7: goto L_0x00ad;
                case 8: goto L_0x00a5;
                case 9: goto L_0x009d;
                case 10: goto L_0x0095;
                default: goto L_0x008d;
            }
        L_0x008d:
            r1 = 285212676(0x11000004, float:1.0097424E-28)
            r0.push(r1)
            goto L_0x034b
        L_0x0095:
            r1 = 285212673(0x11000001, float:1.0097421E-28)
            r0.push(r1)
            goto L_0x034b
        L_0x009d:
            r1 = 285212684(0x1100000c, float:1.0097434E-28)
            r0.push(r1)
            goto L_0x034b
        L_0x00a5:
            r1 = 285212682(0x1100000a, float:1.0097432E-28)
            r0.push(r1)
            goto L_0x034b
        L_0x00ad:
            r1 = 285212675(0x11000003, float:1.0097423E-28)
            r0.push(r1)
            goto L_0x034b
        L_0x00b5:
            r1 = 285212674(0x11000002, float:1.0097422E-28)
            r0.push(r1)
            goto L_0x034b
        L_0x00bd:
            r1 = 285212683(0x1100000b, float:1.0097433E-28)
            r0.push(r1)
            goto L_0x034b
        L_0x00c5:
            r1 = 285212681(0x11000009, float:1.009743E-28)
            r0.push(r1)
            goto L_0x034b
        L_0x00cd:
            r1 = 25165824(0x1800000, float:4.7019774E-38)
            java.lang.String r4 = r4.strVal1
            int r2 = r3.addUninitializedType(r4, r2)
            r1 = r1 | r2
            r0.push(r1)
            goto L_0x034b
        L_0x00db:
            java.lang.String r1 = r4.strVal2
            r0.pop((java.lang.String) r1)
            java.lang.String r1 = r4.strVal2
            r0.push(r3, r1)
            goto L_0x034b
        L_0x00e7:
            java.lang.String r2 = r4.strVal3
            r0.pop((java.lang.String) r2)
            r2 = 184(0xb8, float:2.58E-43)
            if (r1 == r2) goto L_0x0105
            int r2 = r16.pop()
            r5 = 183(0xb7, float:2.56E-43)
            if (r1 != r5) goto L_0x0105
            java.lang.String r1 = r4.strVal2
            char r1 = r1.charAt(r15)
            r5 = 60
            if (r1 != r5) goto L_0x0105
            r0.init(r2)
        L_0x0105:
            java.lang.String r1 = r4.strVal3
            r0.push(r3, r1)
            goto L_0x034b
        L_0x010c:
            java.lang.String r1 = r4.strVal3
            r0.pop((java.lang.String) r1)
            r16.pop()
            goto L_0x034b
        L_0x0116:
            r0.pop((int) r6)
            java.lang.String r1 = r4.strVal3
            r0.push(r3, r1)
            goto L_0x034b
        L_0x0120:
            java.lang.String r1 = r4.strVal3
            r0.pop((java.lang.String) r1)
            goto L_0x034b
        L_0x0127:
            java.lang.String r1 = r4.strVal3
            r0.push(r3, r1)
            goto L_0x034b
        L_0x012e:
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r2 = "JSR/RET are not supported with computeFrames option"
            r1.<init>(r2)
            throw r1
        L_0x0136:
            r0.pop((int) r14)
            r0.push(r9)
            goto L_0x034b
        L_0x013e:
            r1 = 2
            goto L_0x02c3
        L_0x0141:
            r0.pop((int) r6)
            r0.push(r9)
            goto L_0x034b
        L_0x0149:
            r1 = 2
            goto L_0x02af
        L_0x014c:
            r0.pop((int) r6)
            r0.push(r8)
            r0.push(r11)
            goto L_0x034b
        L_0x0157:
            r0.pop((int) r6)
            r0.push(r7)
            goto L_0x034b
        L_0x015f:
            r0.pop((int) r6)
            r0.push(r10)
            r0.push(r11)
            goto L_0x034b
        L_0x016a:
            r0.set(r2, r9)
            goto L_0x034b
        L_0x016f:
            r0.pop((int) r12)
            r0.push(r10)
            r0.push(r11)
            goto L_0x034b
        L_0x017a:
            r0.pop((int) r14)
            r0.push(r8)
            r0.push(r11)
            goto L_0x034b
        L_0x0185:
            r1 = 2
            r0.pop((int) r1)
            r0.push(r7)
            goto L_0x034b
        L_0x018e:
            r0.pop((int) r14)
            r0.push(r10)
            r0.push(r11)
            goto L_0x034b
        L_0x0199:
            r1 = 2
            r0.pop((int) r1)
            r0.push(r9)
            goto L_0x034b
        L_0x01a2:
            int r1 = r16.pop()
            int r2 = r16.pop()
            r0.push(r1)
            r0.push(r2)
            goto L_0x034b
        L_0x01b2:
            int r1 = r16.pop()
            int r2 = r16.pop()
            int r3 = r16.pop()
            int r4 = r16.pop()
            r0.push(r2)
            r0.push(r1)
            r0.push(r4)
            r0.push(r3)
            r0.push(r2)
            r0.push(r1)
            goto L_0x034b
        L_0x01d6:
            int r1 = r16.pop()
            int r2 = r16.pop()
            int r3 = r16.pop()
            r0.push(r2)
            r0.push(r1)
            r0.push(r3)
            r0.push(r2)
            r0.push(r1)
            goto L_0x034b
        L_0x01f3:
            int r1 = r16.pop()
            int r2 = r16.pop()
            r0.push(r2)
            r0.push(r1)
            r0.push(r2)
            r0.push(r1)
            goto L_0x034b
        L_0x0209:
            int r1 = r16.pop()
            int r2 = r16.pop()
            int r3 = r16.pop()
            r0.push(r1)
            r0.push(r3)
            r0.push(r2)
            r0.push(r1)
            goto L_0x034b
        L_0x0223:
            int r1 = r16.pop()
            int r2 = r16.pop()
            r0.push(r1)
            r0.push(r2)
            r0.push(r1)
            goto L_0x034b
        L_0x0236:
            int r1 = r16.pop()
            r0.push(r1)
            r0.push(r1)
            goto L_0x034b
        L_0x0242:
            r1 = 2
            r0.pop((int) r1)
            goto L_0x034b
        L_0x0248:
            r0.pop((int) r14)
            goto L_0x034b
        L_0x024d:
            r0.pop((int) r12)
            goto L_0x034b
        L_0x0252:
            r0.pop((int) r6)
            int r1 = r16.pop()
            r0.set(r2, r1)
            int r1 = r2 + 1
            r0.set(r1, r11)
            if (r2 <= 0) goto L_0x034b
            int r1 = r2 + -1
            int r2 = r0.get(r1)
            if (r2 == r10) goto L_0x0278
            if (r2 != r8) goto L_0x026e
            goto L_0x0278
        L_0x026e:
            r3 = r2 & r13
            if (r3 == r11) goto L_0x034b
            r2 = r2 | r12
            r0.set(r1, r2)
            goto L_0x034b
        L_0x0278:
            r0.set(r1, r11)
            goto L_0x034b
        L_0x027d:
            int r1 = r16.pop()
            r0.set(r2, r1)
            if (r2 <= 0) goto L_0x034b
            int r1 = r2 + -1
            int r2 = r0.get(r1)
            if (r2 == r10) goto L_0x029b
            if (r2 != r8) goto L_0x0291
            goto L_0x029b
        L_0x0291:
            r3 = r2 & r13
            if (r3 == r11) goto L_0x034b
            r2 = r2 | r12
            r0.set(r1, r2)
            goto L_0x034b
        L_0x029b:
            r0.set(r1, r11)
            goto L_0x034b
        L_0x02a0:
            r0.pop((int) r6)
            int r1 = r16.pop()
            r2 = -268435456(0xfffffffff0000000, float:-1.58456325E29)
            int r1 = r1 + r2
            r0.push(r1)
            goto L_0x034b
        L_0x02af:
            r0.pop((int) r1)
            r0.push(r8)
            r0.push(r11)
            goto L_0x034b
        L_0x02ba:
            r1 = 2
            r0.pop((int) r1)
            r0.push(r7)
            goto L_0x034b
        L_0x02c3:
            r0.pop((int) r1)
            r0.push(r10)
            r0.push(r11)
            goto L_0x034b
        L_0x02ce:
            r1 = 2
            r0.pop((int) r1)
            r0.push(r9)
            goto L_0x034b
        L_0x02d7:
            int r1 = r0.get(r2)
            r0.push(r1)
            goto L_0x034b
        L_0x02e0:
            int r1 = r4.type
            r2 = 16
            if (r1 == r2) goto L_0x0320
            switch(r1) {
                case 3: goto L_0x031c;
                case 4: goto L_0x0318;
                case 5: goto L_0x0311;
                case 6: goto L_0x030a;
                case 7: goto L_0x02ff;
                case 8: goto L_0x02f4;
                default: goto L_0x02e9;
            }
        L_0x02e9:
            java.lang.String r1 = "java/lang/invoke/MethodHandle"
            int r1 = r3.addType((java.lang.String) r1)
            r1 = r1 | r5
            r0.push(r1)
            goto L_0x034b
        L_0x02f4:
            java.lang.String r1 = "java/lang/String"
            int r1 = r3.addType((java.lang.String) r1)
            r1 = r1 | r5
            r0.push(r1)
            goto L_0x034b
        L_0x02ff:
            java.lang.String r1 = "java/lang/Class"
            int r1 = r3.addType((java.lang.String) r1)
            r1 = r1 | r5
            r0.push(r1)
            goto L_0x034b
        L_0x030a:
            r0.push(r8)
            r0.push(r11)
            goto L_0x034b
        L_0x0311:
            r0.push(r10)
            r0.push(r11)
            goto L_0x034b
        L_0x0318:
            r0.push(r7)
            goto L_0x034b
        L_0x031c:
            r0.push(r9)
            goto L_0x034b
        L_0x0320:
            java.lang.String r1 = "java/lang/invoke/MethodType"
            int r1 = r3.addType((java.lang.String) r1)
            r1 = r1 | r5
            r0.push(r1)
            goto L_0x034b
        L_0x032b:
            r0.push(r8)
            r0.push(r11)
            goto L_0x034b
        L_0x0332:
            r0.push(r7)
            goto L_0x034b
        L_0x0336:
            r0.push(r10)
            r0.push(r11)
            goto L_0x034b
        L_0x033d:
            r0.push(r9)
            goto L_0x034b
        L_0x0341:
            r1 = 16777221(0x1000005, float:2.35099E-38)
            r0.push(r1)
            goto L_0x034b
        L_0x0348:
            r0.pop((int) r6)
        L_0x034b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jacoco.agent.p086rt.internal_8ff85ea.asm.Frame.execute(int, int, org.jacoco.agent.rt.internal_8ff85ea.asm.ClassWriter, org.jacoco.agent.rt.internal_8ff85ea.asm.Item):void");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0106  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x010a A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean merge(org.jacoco.agent.p086rt.internal_8ff85ea.asm.ClassWriter r19, org.jacoco.agent.p086rt.internal_8ff85ea.asm.Frame r20, int r21) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            r3 = r21
            int[] r4 = r0.inputLocals
            int r4 = r4.length
            int[] r5 = r0.inputStack
            int r5 = r5.length
            int[] r6 = r2.inputLocals
            if (r6 != 0) goto L_0x0018
            int[] r6 = new int[r4]
            r2.inputLocals = r6
            r6 = 1
            goto L_0x0019
        L_0x0018:
            r6 = 0
        L_0x0019:
            r9 = 0
        L_0x001a:
            r11 = 16777220(0x1000004, float:2.3509898E-38)
            r12 = 8388608(0x800000, float:1.17549435E-38)
            r13 = 33554432(0x2000000, float:9.403955E-38)
            r14 = 251658240(0xf000000, float:6.3108872E-30)
            r15 = -268435456(0xfffffffff0000000, float:-1.58456325E29)
            r16 = 8388607(0x7fffff, float:1.1754942E-38)
            r7 = 16777216(0x1000000, float:2.3509887E-38)
            if (r9 >= r4) goto L_0x0078
            int[] r8 = r0.outputLocals
            if (r8 == 0) goto L_0x0062
            int r10 = r8.length
            if (r9 >= r10) goto L_0x0062
            r8 = r8[r9]
            if (r8 != 0) goto L_0x003c
            int[] r7 = r0.inputLocals
            r7 = r7[r9]
            goto L_0x0066
        L_0x003c:
            r10 = r8 & r15
            r14 = r14 & r8
            if (r14 != r7) goto L_0x0043
            r7 = r8
            goto L_0x0066
        L_0x0043:
            if (r14 != r13) goto L_0x004c
            int[] r13 = r0.inputLocals
            r14 = r8 & r16
            r13 = r13[r14]
            goto L_0x0054
        L_0x004c:
            int[] r13 = r0.inputStack
            r14 = r8 & r16
            int r14 = r5 - r14
            r13 = r13[r14]
        L_0x0054:
            int r10 = r10 + r13
            r8 = r8 & r12
            if (r8 == 0) goto L_0x0060
            if (r10 == r11) goto L_0x0066
            r8 = 16777219(0x1000003, float:2.3509895E-38)
            if (r10 != r8) goto L_0x0060
            goto L_0x0066
        L_0x0060:
            r7 = r10
            goto L_0x0066
        L_0x0062:
            int[] r7 = r0.inputLocals
            r7 = r7[r9]
        L_0x0066:
            int[] r8 = r0.initializations
            if (r8 == 0) goto L_0x006e
            int r7 = r0.init(r1, r7)
        L_0x006e:
            int[] r8 = r2.inputLocals
            boolean r7 = merge(r1, r7, r8, r9)
            r6 = r6 | r7
            int r9 = r9 + 1
            goto L_0x001a
        L_0x0078:
            if (r3 <= 0) goto L_0x00a0
            r5 = 0
        L_0x007b:
            if (r5 >= r4) goto L_0x008b
            int[] r7 = r0.inputLocals
            r7 = r7[r5]
            int[] r8 = r2.inputLocals
            boolean r7 = merge(r1, r7, r8, r5)
            r6 = r6 | r7
            int r5 = r5 + 1
            goto L_0x007b
        L_0x008b:
            int[] r4 = r2.inputStack
            if (r4 != 0) goto L_0x0096
            r4 = 1
            int[] r5 = new int[r4]
            r2.inputStack = r5
            r8 = 1
            goto L_0x0097
        L_0x0096:
            r8 = r6
        L_0x0097:
            int[] r2 = r2.inputStack
            r9 = 0
            boolean r1 = merge(r1, r3, r2, r9)
            r1 = r1 | r8
            return r1
        L_0x00a0:
            r4 = 1
            r9 = 0
            int[] r3 = r0.inputStack
            int r3 = r3.length
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label r8 = r0.owner
            int r8 = r8.inputStackTop
            int r3 = r3 + r8
            int[] r8 = r2.inputStack
            if (r8 != 0) goto L_0x00b7
            int r6 = r0.outputStackTop
            int r6 = r6 + r3
            int[] r6 = new int[r6]
            r2.inputStack = r6
            r8 = 1
            goto L_0x00b8
        L_0x00b7:
            r8 = r6
        L_0x00b8:
            r4 = 0
        L_0x00b9:
            if (r4 >= r3) goto L_0x00d1
            int[] r6 = r0.inputStack
            r6 = r6[r4]
            int[] r10 = r0.initializations
            if (r10 == 0) goto L_0x00c7
            int r6 = r0.init(r1, r6)
        L_0x00c7:
            int[] r10 = r2.inputStack
            boolean r6 = merge(r1, r6, r10, r4)
            r8 = r8 | r6
            int r4 = r4 + 1
            goto L_0x00b9
        L_0x00d1:
            int r4 = r0.outputStackTop
            if (r9 >= r4) goto L_0x0116
            int[] r4 = r0.outputStack
            r4 = r4[r9]
            r6 = r4 & r15
            r10 = r4 & r14
            if (r10 != r7) goto L_0x00e4
            r6 = r4
        L_0x00e0:
            r4 = 16777219(0x1000003, float:2.3509895E-38)
            goto L_0x0102
        L_0x00e4:
            if (r10 != r13) goto L_0x00ed
            int[] r10 = r0.inputLocals
            r17 = r4 & r16
            r10 = r10[r17]
            goto L_0x00f5
        L_0x00ed:
            int[] r10 = r0.inputStack
            r17 = r4 & r16
            int r17 = r5 - r17
            r10 = r10[r17]
        L_0x00f5:
            int r6 = r6 + r10
            r4 = r4 & r12
            if (r4 == 0) goto L_0x00e0
            r4 = 16777219(0x1000003, float:2.3509895E-38)
            if (r6 == r11) goto L_0x0100
            if (r6 != r4) goto L_0x0102
        L_0x0100:
            r6 = 16777216(0x1000000, float:2.3509887E-38)
        L_0x0102:
            int[] r10 = r0.initializations
            if (r10 == 0) goto L_0x010a
            int r6 = r0.init(r1, r6)
        L_0x010a:
            int[] r10 = r2.inputStack
            int r4 = r3 + r9
            boolean r4 = merge(r1, r6, r10, r4)
            r8 = r8 | r4
            int r9 = r9 + 1
            goto L_0x00d1
        L_0x0116:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jacoco.agent.p086rt.internal_8ff85ea.asm.Frame.merge(org.jacoco.agent.rt.internal_8ff85ea.asm.ClassWriter, org.jacoco.agent.rt.internal_8ff85ea.asm.Frame, int):boolean");
    }

    private static boolean merge(ClassWriter classWriter, int i, int[] iArr, int i2) {
        int min;
        int addType;
        int i3 = iArr[i2];
        if (i3 == i) {
            return false;
        }
        if ((268435455 & i) == NULL) {
            if (i3 == NULL) {
                return false;
            }
            i = NULL;
        }
        if (i3 == 0) {
            iArr[i2] = i;
            return true;
        }
        int i4 = i3 & BASE_KIND;
        int i5 = 16777216;
        int i6 = -268435456;
        if (i4 == OBJECT || (i3 & -268435456) != 0) {
            if (i == NULL) {
                return false;
            }
            if ((i & -1048576) != (-1048576 & i3)) {
                int i7 = i & BASE_KIND;
                if (i7 == OBJECT || (i & -268435456) != 0) {
                    int i8 = i & -268435456;
                    int i9 = ((i8 == 0 || i7 == OBJECT) ? 0 : -268435456) + i8;
                    int i10 = i3 & -268435456;
                    if (i10 == 0 || i4 == OBJECT) {
                        i6 = 0;
                    }
                    min = Math.min(i9, i6 + i10) | OBJECT;
                    addType = classWriter.addType("java/lang/Object");
                }
            } else if (i4 == OBJECT) {
                i5 = (i & -268435456) | OBJECT | classWriter.getMergedType(i & BASE_VALUE, BASE_VALUE & i3);
            } else {
                min = ((i3 & -268435456) - 268435456) | OBJECT;
                addType = classWriter.addType("java/lang/Object");
            }
            i5 = min | addType;
        } else if (i3 == NULL) {
            if ((i & BASE_KIND) != OBJECT && (i & -268435456) == 0) {
                i = 16777216;
            }
            i5 = i;
        }
        if (i3 == i5) {
            return false;
        }
        iArr[i2] = i5;
        return true;
    }
}
