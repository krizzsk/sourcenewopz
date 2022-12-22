package org.jacoco.agent.p086rt.internal_8ff85ea.asm.commons;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jacoco.agent.p086rt.internal_8ff85ea.asm.Handle;
import org.jacoco.agent.p086rt.internal_8ff85ea.asm.Label;
import org.jacoco.agent.p086rt.internal_8ff85ea.asm.MethodVisitor;
import org.jacoco.agent.p086rt.internal_8ff85ea.asm.Opcodes;
import org.jacoco.agent.p086rt.internal_8ff85ea.asm.Type;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.asm.commons.AnalyzerAdapter */
public class AnalyzerAdapter extends MethodVisitor {
    private List<Label> labels;
    public List<Object> locals;
    private int maxLocals;
    private int maxStack;
    private String owner;
    public List<Object> stack;
    public Map<Object, Object> uninitializedTypes;

    public AnalyzerAdapter(String str, int i, String str2, String str3, MethodVisitor methodVisitor) {
        this(327680, str, i, str2, str3, methodVisitor);
        if (getClass() != AnalyzerAdapter.class) {
            throw new IllegalStateException();
        }
    }

    protected AnalyzerAdapter(int i, String str, int i2, String str2, String str3, MethodVisitor methodVisitor) {
        super(i, methodVisitor);
        this.owner = str;
        this.locals = new ArrayList();
        this.stack = new ArrayList();
        this.uninitializedTypes = new HashMap();
        if ((i2 & 8) == 0) {
            if ("<init>".equals(str2)) {
                this.locals.add(Opcodes.UNINITIALIZED_THIS);
            } else {
                this.locals.add(str);
            }
        }
        Type[] argumentTypes = Type.getArgumentTypes(str3);
        for (int i3 = 0; i3 < argumentTypes.length; i3++) {
            switch (argumentTypes[i3].getSort()) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                    this.locals.add(Opcodes.INTEGER);
                    break;
                case 6:
                    this.locals.add(Opcodes.FLOAT);
                    break;
                case 7:
                    this.locals.add(Opcodes.LONG);
                    this.locals.add(Opcodes.TOP);
                    break;
                case 8:
                    this.locals.add(Opcodes.DOUBLE);
                    this.locals.add(Opcodes.TOP);
                    break;
                case 9:
                    this.locals.add(argumentTypes[i3].getDescriptor());
                    break;
                default:
                    this.locals.add(argumentTypes[i3].getInternalName());
                    break;
            }
        }
        this.maxLocals = this.locals.size();
    }

    public void visitFrame(int i, int i2, Object[] objArr, int i3, Object[] objArr2) {
        if (i == -1) {
            if (this.f6585mv != null) {
                this.f6585mv.visitFrame(i, i2, objArr, i3, objArr2);
            }
            List<Object> list = this.locals;
            if (list != null) {
                list.clear();
                this.stack.clear();
            } else {
                this.locals = new ArrayList();
                this.stack = new ArrayList();
            }
            visitFrameTypes(i2, objArr, this.locals);
            visitFrameTypes(i3, objArr2, this.stack);
            this.maxStack = Math.max(this.maxStack, this.stack.size());
            return;
        }
        throw new IllegalStateException("ClassReader.accept() should be called with EXPAND_FRAMES flag");
    }

    private static void visitFrameTypes(int i, Object[] objArr, List<Object> list) {
        for (int i2 = 0; i2 < i; i2++) {
            Integer num = objArr[i2];
            list.add(num);
            if (num == Opcodes.LONG || num == Opcodes.DOUBLE) {
                list.add(Opcodes.TOP);
            }
        }
    }

    public void visitInsn(int i) {
        if (this.f6585mv != null) {
            this.f6585mv.visitInsn(i);
        }
        execute(i, 0, (String) null);
        if ((i >= 172 && i <= 177) || i == 191) {
            this.locals = null;
            this.stack = null;
        }
    }

    public void visitIntInsn(int i, int i2) {
        if (this.f6585mv != null) {
            this.f6585mv.visitIntInsn(i, i2);
        }
        execute(i, i2, (String) null);
    }

    public void visitVarInsn(int i, int i2) {
        if (this.f6585mv != null) {
            this.f6585mv.visitVarInsn(i, i2);
        }
        execute(i, i2, (String) null);
    }

    public void visitTypeInsn(int i, String str) {
        if (i == 187) {
            if (this.labels == null) {
                Label label = new Label();
                ArrayList arrayList = new ArrayList(3);
                this.labels = arrayList;
                arrayList.add(label);
                if (this.f6585mv != null) {
                    this.f6585mv.visitLabel(label);
                }
            }
            for (int i2 = 0; i2 < this.labels.size(); i2++) {
                this.uninitializedTypes.put(this.labels.get(i2), str);
            }
        }
        if (this.f6585mv != null) {
            this.f6585mv.visitTypeInsn(i, str);
        }
        execute(i, 0, str);
    }

    public void visitFieldInsn(int i, String str, String str2, String str3) {
        if (this.f6585mv != null) {
            this.f6585mv.visitFieldInsn(i, str, str2, str3);
        }
        execute(i, 0, str3);
    }

    @Deprecated
    public void visitMethodInsn(int i, String str, String str2, String str3) {
        if (this.api >= 327680) {
            super.visitMethodInsn(i, str, str2, str3);
        } else {
            doVisitMethodInsn(i, str, str2, str3, i == 185);
        }
    }

    public void visitMethodInsn(int i, String str, String str2, String str3, boolean z) {
        if (this.api < 327680) {
            super.visitMethodInsn(i, str, str2, str3, z);
        } else {
            doVisitMethodInsn(i, str, str2, str3, z);
        }
    }

    private void doVisitMethodInsn(int i, String str, String str2, String str3, boolean z) {
        Object obj;
        if (this.f6585mv != null) {
            this.f6585mv.visitMethodInsn(i, str, str2, str3, z);
        }
        if (this.locals == null) {
            this.labels = null;
            return;
        }
        pop(str3);
        if (i != 184) {
            Object pop = pop();
            if (i == 183) {
                if (str2.charAt(0) == '<') {
                    if (pop == Opcodes.UNINITIALIZED_THIS) {
                        obj = this.owner;
                    } else {
                        obj = this.uninitializedTypes.get(pop);
                    }
                    for (int i2 = 0; i2 < this.locals.size(); i2++) {
                        if (this.locals.get(i2) == pop) {
                            this.locals.set(i2, obj);
                        }
                    }
                    for (int i3 = 0; i3 < this.stack.size(); i3++) {
                        if (this.stack.get(i3) == pop) {
                            this.stack.set(i3, obj);
                        }
                    }
                }
            }
        }
        pushDesc(str3);
        this.labels = null;
    }

    public void visitInvokeDynamicInsn(String str, String str2, Handle handle, Object... objArr) {
        if (this.f6585mv != null) {
            this.f6585mv.visitInvokeDynamicInsn(str, str2, handle, objArr);
        }
        if (this.locals == null) {
            this.labels = null;
            return;
        }
        pop(str2);
        pushDesc(str2);
        this.labels = null;
    }

    public void visitJumpInsn(int i, Label label) {
        if (this.f6585mv != null) {
            this.f6585mv.visitJumpInsn(i, label);
        }
        execute(i, 0, (String) null);
        if (i == 167) {
            this.locals = null;
            this.stack = null;
        }
    }

    public void visitLabel(Label label) {
        if (this.f6585mv != null) {
            this.f6585mv.visitLabel(label);
        }
        if (this.labels == null) {
            this.labels = new ArrayList(3);
        }
        this.labels.add(label);
    }

    public void visitLdcInsn(Object obj) {
        if (this.f6585mv != null) {
            this.f6585mv.visitLdcInsn(obj);
        }
        if (this.locals == null) {
            this.labels = null;
            return;
        }
        if (obj instanceof Integer) {
            push(Opcodes.INTEGER);
        } else if (obj instanceof Long) {
            push(Opcodes.LONG);
            push(Opcodes.TOP);
        } else if (obj instanceof Float) {
            push(Opcodes.FLOAT);
        } else if (obj instanceof Double) {
            push(Opcodes.DOUBLE);
            push(Opcodes.TOP);
        } else if (obj instanceof String) {
            push("java/lang/String");
        } else if (obj instanceof Type) {
            int sort = ((Type) obj).getSort();
            if (sort == 10 || sort == 9) {
                push("java/lang/Class");
            } else if (sort == 11) {
                push("java/lang/invoke/MethodType");
            } else {
                throw new IllegalArgumentException();
            }
        } else if (obj instanceof Handle) {
            push("java/lang/invoke/MethodHandle");
        } else {
            throw new IllegalArgumentException();
        }
        this.labels = null;
    }

    public void visitIincInsn(int i, int i2) {
        if (this.f6585mv != null) {
            this.f6585mv.visitIincInsn(i, i2);
        }
        execute(132, i, (String) null);
    }

    public void visitTableSwitchInsn(int i, int i2, Label label, Label... labelArr) {
        if (this.f6585mv != null) {
            this.f6585mv.visitTableSwitchInsn(i, i2, label, labelArr);
        }
        execute(170, 0, (String) null);
        this.locals = null;
        this.stack = null;
    }

    public void visitLookupSwitchInsn(Label label, int[] iArr, Label[] labelArr) {
        if (this.f6585mv != null) {
            this.f6585mv.visitLookupSwitchInsn(label, iArr, labelArr);
        }
        execute(171, 0, (String) null);
        this.locals = null;
        this.stack = null;
    }

    public void visitMultiANewArrayInsn(String str, int i) {
        if (this.f6585mv != null) {
            this.f6585mv.visitMultiANewArrayInsn(str, i);
        }
        execute(197, i, str);
    }

    public void visitMaxs(int i, int i2) {
        if (this.f6585mv != null) {
            this.maxStack = Math.max(this.maxStack, i);
            this.maxLocals = Math.max(this.maxLocals, i2);
            this.f6585mv.visitMaxs(this.maxStack, this.maxLocals);
        }
    }

    private Object get(int i) {
        this.maxLocals = Math.max(this.maxLocals, i + 1);
        return i < this.locals.size() ? this.locals.get(i) : Opcodes.TOP;
    }

    private void set(int i, Object obj) {
        this.maxLocals = Math.max(this.maxLocals, i + 1);
        while (i >= this.locals.size()) {
            this.locals.add(Opcodes.TOP);
        }
        this.locals.set(i, obj);
    }

    private void push(Object obj) {
        this.stack.add(obj);
        this.maxStack = Math.max(this.maxStack, this.stack.size());
    }

    private void pushDesc(String str) {
        int i = 0;
        if (str.charAt(0) == '(') {
            i = str.indexOf(41) + 1;
        }
        char charAt = str.charAt(i);
        if (charAt != 'F') {
            if (charAt != 'S') {
                if (charAt == 'V') {
                    return;
                }
                if (charAt != 'I') {
                    if (charAt == 'J') {
                        push(Opcodes.LONG);
                        push(Opcodes.TOP);
                        return;
                    } else if (charAt != 'Z') {
                        if (charAt != '[') {
                            switch (charAt) {
                                case 'B':
                                case 'C':
                                    break;
                                case 'D':
                                    push(Opcodes.DOUBLE);
                                    push(Opcodes.TOP);
                                    return;
                                default:
                                    if (i == 0) {
                                        push(str.substring(1, str.length() - 1));
                                        return;
                                    } else {
                                        push(str.substring(i + 1, str.length() - 1));
                                        return;
                                    }
                            }
                        } else if (i == 0) {
                            push(str);
                            return;
                        } else {
                            push(str.substring(i, str.length()));
                            return;
                        }
                    }
                }
            }
            push(Opcodes.INTEGER);
            return;
        }
        push(Opcodes.FLOAT);
    }

    private Object pop() {
        List<Object> list = this.stack;
        return list.remove(list.size() - 1);
    }

    private void pop(int i) {
        int size = this.stack.size();
        int i2 = size - i;
        for (int i3 = size - 1; i3 >= i2; i3--) {
            this.stack.remove(i3);
        }
    }

    private void pop(String str) {
        char charAt = str.charAt(0);
        if (charAt == '(') {
            Type[] argumentTypes = Type.getArgumentTypes(str);
            int i = 0;
            for (Type size : argumentTypes) {
                i += size.getSize();
            }
            pop(i);
        } else if (charAt == 'J' || charAt == 'D') {
            pop(2);
        } else {
            pop(1);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00ce, code lost:
        pop(1);
        push(org.jacoco.agent.p086rt.internal_8ff85ea.asm.Opcodes.INTEGER);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x020a, code lost:
        r7 = r7 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0227, code lost:
        r7 = r7 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0258, code lost:
        pop(2);
        push(org.jacoco.agent.p086rt.internal_8ff85ea.asm.Opcodes.DOUBLE);
        push(org.jacoco.agent.p086rt.internal_8ff85ea.asm.Opcodes.TOP);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x026f, code lost:
        pop(2);
        push(org.jacoco.agent.p086rt.internal_8ff85ea.asm.Opcodes.LONG);
        push(org.jacoco.agent.p086rt.internal_8ff85ea.asm.Opcodes.TOP);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void execute(int r6, int r7, java.lang.String r8) {
        /*
            r5 = this;
            java.util.List<java.lang.Object> r0 = r5.locals
            r1 = 0
            if (r0 != 0) goto L_0x0008
            r5.labels = r1
            return
        L_0x0008:
            r0 = 198(0xc6, float:2.77E-43)
            r2 = 1
            if (r6 == r0) goto L_0x02c3
            r0 = 199(0xc7, float:2.79E-43)
            if (r6 == r0) goto L_0x02c3
            switch(r6) {
                case 0: goto L_0x02c6;
                case 1: goto L_0x02bd;
                case 2: goto L_0x02b7;
                case 3: goto L_0x02b7;
                case 4: goto L_0x02b7;
                case 5: goto L_0x02b7;
                case 6: goto L_0x02b7;
                case 7: goto L_0x02b7;
                case 8: goto L_0x02b7;
                case 9: goto L_0x02ac;
                case 10: goto L_0x02ac;
                case 11: goto L_0x02a6;
                case 12: goto L_0x02a6;
                case 13: goto L_0x02a6;
                case 14: goto L_0x029b;
                case 15: goto L_0x029b;
                case 16: goto L_0x02b7;
                case 17: goto L_0x02b7;
                default: goto L_0x0014;
            }
        L_0x0014:
            switch(r6) {
                case 21: goto L_0x0293;
                case 22: goto L_0x0286;
                case 23: goto L_0x0293;
                case 24: goto L_0x0286;
                case 25: goto L_0x0293;
                default: goto L_0x0017;
            }
        L_0x0017:
            r0 = 2
            switch(r6) {
                case 46: goto L_0x027d;
                case 47: goto L_0x026f;
                case 48: goto L_0x0266;
                case 49: goto L_0x0258;
                case 50: goto L_0x023b;
                case 51: goto L_0x027d;
                case 52: goto L_0x027d;
                case 53: goto L_0x027d;
                case 54: goto L_0x021e;
                case 55: goto L_0x01f7;
                case 56: goto L_0x021e;
                case 57: goto L_0x01f7;
                case 58: goto L_0x021e;
                default: goto L_0x001b;
            }
        L_0x001b:
            r3 = 3
            r4 = 4
            switch(r6) {
                case 79: goto L_0x01f2;
                case 80: goto L_0x01ed;
                case 81: goto L_0x01f2;
                case 82: goto L_0x01ed;
                case 83: goto L_0x01f2;
                case 84: goto L_0x01f2;
                case 85: goto L_0x01f2;
                case 86: goto L_0x01f2;
                case 87: goto L_0x02c3;
                case 88: goto L_0x01e8;
                case 89: goto L_0x01dc;
                case 90: goto L_0x01c9;
                case 91: goto L_0x01af;
                case 92: goto L_0x0199;
                case 93: goto L_0x017c;
                case 94: goto L_0x0158;
                case 95: goto L_0x0148;
                case 96: goto L_0x013e;
                case 97: goto L_0x012f;
                case 98: goto L_0x0125;
                case 99: goto L_0x0116;
                case 100: goto L_0x013e;
                case 101: goto L_0x012f;
                case 102: goto L_0x0125;
                case 103: goto L_0x0116;
                case 104: goto L_0x013e;
                case 105: goto L_0x012f;
                case 106: goto L_0x0125;
                case 107: goto L_0x0116;
                case 108: goto L_0x013e;
                case 109: goto L_0x012f;
                case 110: goto L_0x0125;
                case 111: goto L_0x0116;
                case 112: goto L_0x013e;
                case 113: goto L_0x012f;
                case 114: goto L_0x0125;
                case 115: goto L_0x0116;
                case 116: goto L_0x02c6;
                case 117: goto L_0x02c6;
                case 118: goto L_0x02c6;
                case 119: goto L_0x02c6;
                case 120: goto L_0x013e;
                case 121: goto L_0x0107;
                case 122: goto L_0x013e;
                case 123: goto L_0x0107;
                case 124: goto L_0x013e;
                case 125: goto L_0x0107;
                case 126: goto L_0x013e;
                case 127: goto L_0x012f;
                case 128: goto L_0x013e;
                case 129: goto L_0x012f;
                case 130: goto L_0x013e;
                case 131: goto L_0x012f;
                case 132: goto L_0x0100;
                case 133: goto L_0x00f1;
                case 134: goto L_0x00e7;
                case 135: goto L_0x00d8;
                case 136: goto L_0x013e;
                case 137: goto L_0x0125;
                case 138: goto L_0x0258;
                case 139: goto L_0x00ce;
                case 140: goto L_0x00f1;
                case 141: goto L_0x00d8;
                case 142: goto L_0x013e;
                case 143: goto L_0x026f;
                case 144: goto L_0x0125;
                case 145: goto L_0x02c6;
                case 146: goto L_0x02c6;
                case 147: goto L_0x02c6;
                case 148: goto L_0x00c4;
                case 149: goto L_0x013e;
                case 150: goto L_0x013e;
                case 151: goto L_0x00c4;
                case 152: goto L_0x00c4;
                case 153: goto L_0x02c3;
                case 154: goto L_0x02c3;
                case 155: goto L_0x02c3;
                case 156: goto L_0x02c3;
                case 157: goto L_0x02c3;
                case 158: goto L_0x02c3;
                case 159: goto L_0x01e8;
                case 160: goto L_0x01e8;
                case 161: goto L_0x01e8;
                case 162: goto L_0x01e8;
                case 163: goto L_0x01e8;
                case 164: goto L_0x01e8;
                case 165: goto L_0x01e8;
                case 166: goto L_0x01e8;
                case 167: goto L_0x02c6;
                case 168: goto L_0x00bc;
                case 169: goto L_0x00bc;
                case 170: goto L_0x02c3;
                case 171: goto L_0x02c3;
                case 172: goto L_0x02c3;
                case 173: goto L_0x01e8;
                case 174: goto L_0x02c3;
                case 175: goto L_0x01e8;
                case 176: goto L_0x02c3;
                case 177: goto L_0x02c6;
                case 178: goto L_0x00b7;
                case 179: goto L_0x00b2;
                case 180: goto L_0x00aa;
                case 181: goto L_0x00a2;
                default: goto L_0x0020;
            }
        L_0x0020:
            switch(r6) {
                case 187: goto L_0x0096;
                case 188: goto L_0x0058;
                case 189: goto L_0x003b;
                case 190: goto L_0x00ce;
                case 191: goto L_0x02c3;
                case 192: goto L_0x002b;
                case 193: goto L_0x00ce;
                case 194: goto L_0x02c3;
                case 195: goto L_0x02c3;
                default: goto L_0x0023;
            }
        L_0x0023:
            r5.pop((int) r7)
            r5.pushDesc(r8)
            goto L_0x02c6
        L_0x002b:
            r5.pop()
            org.jacoco.agent.rt.internal_8ff85ea.asm.Type r6 = org.jacoco.agent.p086rt.internal_8ff85ea.asm.Type.getObjectType(r8)
            java.lang.String r6 = r6.getDescriptor()
            r5.pushDesc(r6)
            goto L_0x02c6
        L_0x003b:
            r5.pop()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "["
            r6.append(r7)
            org.jacoco.agent.rt.internal_8ff85ea.asm.Type r7 = org.jacoco.agent.p086rt.internal_8ff85ea.asm.Type.getObjectType(r8)
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            r5.pushDesc(r6)
            goto L_0x02c6
        L_0x0058:
            r5.pop()
            switch(r7) {
                case 4: goto L_0x008f;
                case 5: goto L_0x0088;
                case 6: goto L_0x0081;
                case 7: goto L_0x007a;
                case 8: goto L_0x0073;
                case 9: goto L_0x006c;
                case 10: goto L_0x0065;
                default: goto L_0x005e;
            }
        L_0x005e:
            java.lang.String r6 = "[J"
            r5.pushDesc(r6)
            goto L_0x02c6
        L_0x0065:
            java.lang.String r6 = "[I"
            r5.pushDesc(r6)
            goto L_0x02c6
        L_0x006c:
            java.lang.String r6 = "[S"
            r5.pushDesc(r6)
            goto L_0x02c6
        L_0x0073:
            java.lang.String r6 = "[B"
            r5.pushDesc(r6)
            goto L_0x02c6
        L_0x007a:
            java.lang.String r6 = "[D"
            r5.pushDesc(r6)
            goto L_0x02c6
        L_0x0081:
            java.lang.String r6 = "[F"
            r5.pushDesc(r6)
            goto L_0x02c6
        L_0x0088:
            java.lang.String r6 = "[C"
            r5.pushDesc(r6)
            goto L_0x02c6
        L_0x008f:
            java.lang.String r6 = "[Z"
            r5.pushDesc(r6)
            goto L_0x02c6
        L_0x0096:
            java.util.List<org.jacoco.agent.rt.internal_8ff85ea.asm.Label> r6 = r5.labels
            r7 = 0
            java.lang.Object r6 = r6.get(r7)
            r5.push(r6)
            goto L_0x02c6
        L_0x00a2:
            r5.pop((java.lang.String) r8)
            r5.pop()
            goto L_0x02c6
        L_0x00aa:
            r5.pop((int) r2)
            r5.pushDesc(r8)
            goto L_0x02c6
        L_0x00b2:
            r5.pop((java.lang.String) r8)
            goto L_0x02c6
        L_0x00b7:
            r5.pushDesc(r8)
            goto L_0x02c6
        L_0x00bc:
            java.lang.RuntimeException r6 = new java.lang.RuntimeException
            java.lang.String r7 = "JSR/RET are not supported"
            r6.<init>(r7)
            throw r6
        L_0x00c4:
            r5.pop((int) r4)
            java.lang.Integer r6 = org.jacoco.agent.p086rt.internal_8ff85ea.asm.Opcodes.INTEGER
            r5.push(r6)
            goto L_0x02c6
        L_0x00ce:
            r5.pop((int) r2)
            java.lang.Integer r6 = org.jacoco.agent.p086rt.internal_8ff85ea.asm.Opcodes.INTEGER
            r5.push(r6)
            goto L_0x02c6
        L_0x00d8:
            r5.pop((int) r2)
            java.lang.Integer r6 = org.jacoco.agent.p086rt.internal_8ff85ea.asm.Opcodes.DOUBLE
            r5.push(r6)
            java.lang.Integer r6 = org.jacoco.agent.p086rt.internal_8ff85ea.asm.Opcodes.TOP
            r5.push(r6)
            goto L_0x02c6
        L_0x00e7:
            r5.pop((int) r2)
            java.lang.Integer r6 = org.jacoco.agent.p086rt.internal_8ff85ea.asm.Opcodes.FLOAT
            r5.push(r6)
            goto L_0x02c6
        L_0x00f1:
            r5.pop((int) r2)
            java.lang.Integer r6 = org.jacoco.agent.p086rt.internal_8ff85ea.asm.Opcodes.LONG
            r5.push(r6)
            java.lang.Integer r6 = org.jacoco.agent.p086rt.internal_8ff85ea.asm.Opcodes.TOP
            r5.push(r6)
            goto L_0x02c6
        L_0x0100:
            java.lang.Integer r6 = org.jacoco.agent.p086rt.internal_8ff85ea.asm.Opcodes.INTEGER
            r5.set(r7, r6)
            goto L_0x02c6
        L_0x0107:
            r5.pop((int) r3)
            java.lang.Integer r6 = org.jacoco.agent.p086rt.internal_8ff85ea.asm.Opcodes.LONG
            r5.push(r6)
            java.lang.Integer r6 = org.jacoco.agent.p086rt.internal_8ff85ea.asm.Opcodes.TOP
            r5.push(r6)
            goto L_0x02c6
        L_0x0116:
            r5.pop((int) r4)
            java.lang.Integer r6 = org.jacoco.agent.p086rt.internal_8ff85ea.asm.Opcodes.DOUBLE
            r5.push(r6)
            java.lang.Integer r6 = org.jacoco.agent.p086rt.internal_8ff85ea.asm.Opcodes.TOP
            r5.push(r6)
            goto L_0x02c6
        L_0x0125:
            r5.pop((int) r0)
            java.lang.Integer r6 = org.jacoco.agent.p086rt.internal_8ff85ea.asm.Opcodes.FLOAT
            r5.push(r6)
            goto L_0x02c6
        L_0x012f:
            r5.pop((int) r4)
            java.lang.Integer r6 = org.jacoco.agent.p086rt.internal_8ff85ea.asm.Opcodes.LONG
            r5.push(r6)
            java.lang.Integer r6 = org.jacoco.agent.p086rt.internal_8ff85ea.asm.Opcodes.TOP
            r5.push(r6)
            goto L_0x02c6
        L_0x013e:
            r5.pop((int) r0)
            java.lang.Integer r6 = org.jacoco.agent.p086rt.internal_8ff85ea.asm.Opcodes.INTEGER
            r5.push(r6)
            goto L_0x02c6
        L_0x0148:
            java.lang.Object r6 = r5.pop()
            java.lang.Object r7 = r5.pop()
            r5.push(r6)
            r5.push(r7)
            goto L_0x02c6
        L_0x0158:
            java.lang.Object r6 = r5.pop()
            java.lang.Object r7 = r5.pop()
            java.lang.Object r8 = r5.pop()
            java.lang.Object r0 = r5.pop()
            r5.push(r7)
            r5.push(r6)
            r5.push(r0)
            r5.push(r8)
            r5.push(r7)
            r5.push(r6)
            goto L_0x02c6
        L_0x017c:
            java.lang.Object r6 = r5.pop()
            java.lang.Object r7 = r5.pop()
            java.lang.Object r8 = r5.pop()
            r5.push(r7)
            r5.push(r6)
            r5.push(r8)
            r5.push(r7)
            r5.push(r6)
            goto L_0x02c6
        L_0x0199:
            java.lang.Object r6 = r5.pop()
            java.lang.Object r7 = r5.pop()
            r5.push(r7)
            r5.push(r6)
            r5.push(r7)
            r5.push(r6)
            goto L_0x02c6
        L_0x01af:
            java.lang.Object r6 = r5.pop()
            java.lang.Object r7 = r5.pop()
            java.lang.Object r8 = r5.pop()
            r5.push(r6)
            r5.push(r8)
            r5.push(r7)
            r5.push(r6)
            goto L_0x02c6
        L_0x01c9:
            java.lang.Object r6 = r5.pop()
            java.lang.Object r7 = r5.pop()
            r5.push(r6)
            r5.push(r7)
            r5.push(r6)
            goto L_0x02c6
        L_0x01dc:
            java.lang.Object r6 = r5.pop()
            r5.push(r6)
            r5.push(r6)
            goto L_0x02c6
        L_0x01e8:
            r5.pop((int) r0)
            goto L_0x02c6
        L_0x01ed:
            r5.pop((int) r4)
            goto L_0x02c6
        L_0x01f2:
            r5.pop((int) r3)
            goto L_0x02c6
        L_0x01f7:
            r5.pop((int) r2)
            java.lang.Object r6 = r5.pop()
            r5.set(r7, r6)
            int r6 = r7 + 1
            java.lang.Integer r8 = org.jacoco.agent.p086rt.internal_8ff85ea.asm.Opcodes.TOP
            r5.set(r6, r8)
            if (r7 <= 0) goto L_0x02c6
            int r7 = r7 - r2
            java.lang.Object r6 = r5.get(r7)
            java.lang.Integer r8 = org.jacoco.agent.p086rt.internal_8ff85ea.asm.Opcodes.LONG
            if (r6 == r8) goto L_0x0217
            java.lang.Integer r8 = org.jacoco.agent.p086rt.internal_8ff85ea.asm.Opcodes.DOUBLE
            if (r6 != r8) goto L_0x02c6
        L_0x0217:
            java.lang.Integer r6 = org.jacoco.agent.p086rt.internal_8ff85ea.asm.Opcodes.TOP
            r5.set(r7, r6)
            goto L_0x02c6
        L_0x021e:
            java.lang.Object r6 = r5.pop()
            r5.set(r7, r6)
            if (r7 <= 0) goto L_0x02c6
            int r7 = r7 - r2
            java.lang.Object r6 = r5.get(r7)
            java.lang.Integer r8 = org.jacoco.agent.p086rt.internal_8ff85ea.asm.Opcodes.LONG
            if (r6 == r8) goto L_0x0234
            java.lang.Integer r8 = org.jacoco.agent.p086rt.internal_8ff85ea.asm.Opcodes.DOUBLE
            if (r6 != r8) goto L_0x02c6
        L_0x0234:
            java.lang.Integer r6 = org.jacoco.agent.p086rt.internal_8ff85ea.asm.Opcodes.TOP
            r5.set(r7, r6)
            goto L_0x02c6
        L_0x023b:
            r5.pop((int) r2)
            java.lang.Object r6 = r5.pop()
            boolean r7 = r6 instanceof java.lang.String
            if (r7 == 0) goto L_0x0251
            java.lang.String r6 = (java.lang.String) r6
            java.lang.String r6 = r6.substring(r2)
            r5.pushDesc(r6)
            goto L_0x02c6
        L_0x0251:
            java.lang.String r6 = "java/lang/Object"
            r5.push(r6)
            goto L_0x02c6
        L_0x0258:
            r5.pop((int) r0)
            java.lang.Integer r6 = org.jacoco.agent.p086rt.internal_8ff85ea.asm.Opcodes.DOUBLE
            r5.push(r6)
            java.lang.Integer r6 = org.jacoco.agent.p086rt.internal_8ff85ea.asm.Opcodes.TOP
            r5.push(r6)
            goto L_0x02c6
        L_0x0266:
            r5.pop((int) r0)
            java.lang.Integer r6 = org.jacoco.agent.p086rt.internal_8ff85ea.asm.Opcodes.FLOAT
            r5.push(r6)
            goto L_0x02c6
        L_0x026f:
            r5.pop((int) r0)
            java.lang.Integer r6 = org.jacoco.agent.p086rt.internal_8ff85ea.asm.Opcodes.LONG
            r5.push(r6)
            java.lang.Integer r6 = org.jacoco.agent.p086rt.internal_8ff85ea.asm.Opcodes.TOP
            r5.push(r6)
            goto L_0x02c6
        L_0x027d:
            r5.pop((int) r0)
            java.lang.Integer r6 = org.jacoco.agent.p086rt.internal_8ff85ea.asm.Opcodes.INTEGER
            r5.push(r6)
            goto L_0x02c6
        L_0x0286:
            java.lang.Object r6 = r5.get(r7)
            r5.push(r6)
            java.lang.Integer r6 = org.jacoco.agent.p086rt.internal_8ff85ea.asm.Opcodes.TOP
            r5.push(r6)
            goto L_0x02c6
        L_0x0293:
            java.lang.Object r6 = r5.get(r7)
            r5.push(r6)
            goto L_0x02c6
        L_0x029b:
            java.lang.Integer r6 = org.jacoco.agent.p086rt.internal_8ff85ea.asm.Opcodes.DOUBLE
            r5.push(r6)
            java.lang.Integer r6 = org.jacoco.agent.p086rt.internal_8ff85ea.asm.Opcodes.TOP
            r5.push(r6)
            goto L_0x02c6
        L_0x02a6:
            java.lang.Integer r6 = org.jacoco.agent.p086rt.internal_8ff85ea.asm.Opcodes.FLOAT
            r5.push(r6)
            goto L_0x02c6
        L_0x02ac:
            java.lang.Integer r6 = org.jacoco.agent.p086rt.internal_8ff85ea.asm.Opcodes.LONG
            r5.push(r6)
            java.lang.Integer r6 = org.jacoco.agent.p086rt.internal_8ff85ea.asm.Opcodes.TOP
            r5.push(r6)
            goto L_0x02c6
        L_0x02b7:
            java.lang.Integer r6 = org.jacoco.agent.p086rt.internal_8ff85ea.asm.Opcodes.INTEGER
            r5.push(r6)
            goto L_0x02c6
        L_0x02bd:
            java.lang.Integer r6 = org.jacoco.agent.p086rt.internal_8ff85ea.asm.Opcodes.NULL
            r5.push(r6)
            goto L_0x02c6
        L_0x02c3:
            r5.pop((int) r2)
        L_0x02c6:
            r5.labels = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jacoco.agent.p086rt.internal_8ff85ea.asm.commons.AnalyzerAdapter.execute(int, int, java.lang.String):void");
    }
}
