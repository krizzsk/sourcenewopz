package org.jacoco.agent.p086rt.internal_8ff85ea.core.internal.instr;

import org.jacoco.agent.p086rt.internal_8ff85ea.asm.MethodVisitor;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.core.internal.instr.InstrSupport */
public final class InstrSupport {
    public static final int ASM_API_VERSION = 327680;
    static final int CLINIT_ACC = 4104;
    static final String CLINIT_DESC = "()V";
    static final String CLINIT_NAME = "<clinit>";
    public static final int DATAFIELD_ACC = 4234;
    public static final String DATAFIELD_DESC = "[Z";
    public static final int DATAFIELD_INTF_ACC = 4121;
    public static final String DATAFIELD_NAME = "$jacocoData";
    public static final int INITMETHOD_ACC = 4106;
    public static final String INITMETHOD_DESC = "()[Z";
    public static final String INITMETHOD_NAME = "$jacocoInit";

    private InstrSupport() {
    }

    public static void assertNotInstrumented(String str, String str2) throws IllegalStateException {
        if (str.equals(DATAFIELD_NAME) || str.equals(INITMETHOD_NAME)) {
            throw new IllegalStateException(String.format("Class %s is already instrumented.", new Object[]{str2}));
        }
    }

    public static void push(MethodVisitor methodVisitor, int i) {
        if (i >= -1 && i <= 5) {
            methodVisitor.visitInsn(i + 3);
        } else if (i >= -128 && i <= 127) {
            methodVisitor.visitIntInsn(16, i);
        } else if (i < -32768 || i > 32767) {
            methodVisitor.visitLdcInsn(Integer.valueOf(i));
        } else {
            methodVisitor.visitIntInsn(17, i);
        }
    }
}
