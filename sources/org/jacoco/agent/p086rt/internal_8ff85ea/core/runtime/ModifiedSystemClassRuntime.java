package org.jacoco.agent.p086rt.internal_8ff85ea.core.runtime;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;
import org.apache.commons.p071io.IOUtils;
import org.jacoco.agent.p086rt.internal_8ff85ea.asm.ClassReader;
import org.jacoco.agent.p086rt.internal_8ff85ea.asm.ClassVisitor;
import org.jacoco.agent.p086rt.internal_8ff85ea.asm.ClassWriter;
import org.jacoco.agent.p086rt.internal_8ff85ea.asm.MethodVisitor;
import org.jacoco.agent.p086rt.internal_8ff85ea.core.internal.Java9Support;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.core.runtime.ModifiedSystemClassRuntime */
public class ModifiedSystemClassRuntime extends AbstractRuntime {
    private static final String ACCESS_FIELD_TYPE = "Ljava/lang/Object;";
    private final String accessFieldName;
    private final Class<?> systemClass;
    private final String systemClassName;

    public void shutdown() {
    }

    public ModifiedSystemClassRuntime(Class<?> cls, String str) {
        this.systemClass = cls;
        this.systemClassName = cls.getName().replace('.', IOUtils.DIR_SEPARATOR_UNIX);
        this.accessFieldName = str;
    }

    public void startup(RuntimeData runtimeData) throws Exception {
        super.startup(runtimeData);
        this.systemClass.getField(this.accessFieldName).set((Object) null, runtimeData);
    }

    public int generateDataAccessor(long j, String str, int i, MethodVisitor methodVisitor) {
        methodVisitor.visitFieldInsn(178, this.systemClassName, this.accessFieldName, ACCESS_FIELD_TYPE);
        RuntimeData.generateAccessCall(j, str, i, methodVisitor);
        return 6;
    }

    public static IRuntime createFor(Instrumentation instrumentation, String str) throws ClassNotFoundException {
        return createFor(instrumentation, str, "$jacocoAccess");
    }

    public static IRuntime createFor(Instrumentation instrumentation, final String str, final String str2) throws ClassNotFoundException {
        C28651 r0 = new ClassFileTransformer() {
            public byte[] transform(ClassLoader classLoader, String str, Class<?> cls, ProtectionDomain protectionDomain, byte[] bArr) throws IllegalClassFormatException {
                if (str.equals(str)) {
                    return ModifiedSystemClassRuntime.instrument(bArr, str2);
                }
                return null;
            }
        };
        instrumentation.addTransformer(r0);
        Class<?> cls = Class.forName(str.replace(IOUtils.DIR_SEPARATOR_UNIX, '.'));
        instrumentation.removeTransformer(r0);
        try {
            cls.getField(str2);
            return new ModifiedSystemClassRuntime(cls, str2);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(String.format("Class %s could not be instrumented.", new Object[]{str}), e);
        }
    }

    public static byte[] instrument(byte[] bArr, final String str) {
        ClassReader classReader = new ClassReader(Java9Support.downgradeIfRequired(bArr));
        ClassWriter classWriter = new ClassWriter(classReader, 0);
        classReader.accept(new ClassVisitor(327680, classWriter) {
            public void visitEnd() {
                ModifiedSystemClassRuntime.createDataField(this.f6581cv, str);
                super.visitEnd();
            }
        }, 8);
        return classWriter.toByteArray();
    }

    /* access modifiers changed from: private */
    public static void createDataField(ClassVisitor classVisitor, String str) {
        classVisitor.visitField(4233, str, ACCESS_FIELD_TYPE, (String) null, (Object) null);
    }
}
